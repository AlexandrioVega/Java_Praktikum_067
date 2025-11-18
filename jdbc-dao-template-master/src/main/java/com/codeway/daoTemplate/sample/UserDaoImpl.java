package com.codeway.daoTemplate.sample;

import com.codeway.daoTemplate.dao.GenericDaoImpl;
//import com.codeway.daoTemplate.utils.TemplateLogger;
//import com.codeway.daoTemplate.utils.PooledDataSource;

public class UserDaoImpl extends GenericDaoImpl<Integer, User> {

	public UserDaoImpl() {
		super(User.class, new MyDataSource());

//		super(User.class, PooledDataSource.getInstance());
//		TemplateLogger.shouldLog =false;
	}
	
	public User getUserByMobileNo(String mobile) throws Exception {
		 return getSingleEntity("mobile=?", mobile);
	}

//	public List<User> searchUsersByName(String name) throws Exception {
//		return getList("name like ?", "%"+name+"%");
//	}
//	private static UserDaoImpl instance;
//	
//	public static UserDaoImpl getInstance() {
//		if(instance ==null){
//			synchronized (UserDaoImpl.class) {
//	            if(instance == null){
//	                instance = new UserDaoImpl();
//	            }
//	        }
//		}
//		return instance;
//	}
	
	public static void main(String[] args) throws Exception{

		UserDaoImpl userDao = new UserDaoImpl();
		
		User user = new User();
		user.setEmail("test@abc1.com");
		user.setName("user 2 ");
		user.setMobile("999999998");
		
		userDao.save(user);
		System.out.println("User Baru Tersimpan. ID: " + user.getId());
    
		// READ
		System.out.println("\n--- 2. FASE READ (GET) ---");
		User existing = userDao.getUserByMobileNo("999999998");
		System.out.println("Data Ditemukan. Nama: " + existing.getName());
		
		// UPDATE
		System.out.println("\n--- 3. FASE UPDATE ---");
		existing.setName("User 2 baru");
		existing.setEmail("updated@codeway.com");
		existing.setMobile("999999999"); // Ubah nomor mobile juga
		
		userDao.update(existing); // Memanggil method update generic
		System.out.println("Data ID " + existing.getId() + " berhasil diupdate.");

		// READ
		System.out.println("\n--- 4. FASE READ (VERIFIKASI UPDATE) ---");
		User updatedUser = userDao.getUserByMobileNo("999999999");
		System.out.println("Data Verifikasi. Nama: " + updatedUser.getName());
		
		// DELETE
		System.out.println("\n--- 5. FASE DELETE (REMOVE) ---");
		userDao.remove(updatedUser.getId()); 
		System.out.println("Data ID " + updatedUser.getId() + " berhasil dihapus.");
		
		// READ
		System.out.println("\n--- 6. FASE READ (VERIFIKASI DELETE) ---");
		User deletedUser = userDao.getUserByMobileNo("999999999");
		if (deletedUser == null) {
			System.out.println("Data tidak ditemukan (null).");
		} else {
			System.out.println("Data masih ditemukan.");
		}	
	}
}
