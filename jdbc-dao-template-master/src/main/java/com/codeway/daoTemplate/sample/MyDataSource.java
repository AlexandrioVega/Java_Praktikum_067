package com.codeway.daoTemplate.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.codeway.daoTemplate.utils.TemplateDataSource;

/*
*
* @Author Abhishek.Pandey
*/
public class MyDataSource  implements TemplateDataSource{

	
	@Override
	public Connection getConnection() throws Exception {

        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

        String user = "root";
        String pass = ""; // ganti jika ada password

        Class.forName("com.mysql.cj.jdbc.Driver");  // DRIVER BARU

        return DriverManager.getConnection(url, user, pass);
    }

	@Override
	public void closeConnection(Connection con) {
		
		if(con !=null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

}
