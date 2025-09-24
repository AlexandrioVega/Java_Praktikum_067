package soal5;


public class Food extends Goods {

    private int calories;


    public Food(String description, double price, int calories) {
        super(description, price);
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    
    @Override
    public void display() {
        super.display(); 
        System.out.println("Calories: " + this.calories);
    }
}