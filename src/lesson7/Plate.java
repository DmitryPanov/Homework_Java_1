package lesson7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("Остаток еды: " + food);
    }

    public int getFood() {
        return food;
    }


    public void setFood(int food) {
        this.food = food;
    }

    public boolean checkFoodPlate(int food, int eatCat) {
        return (food - eatCat) >= 0;
    }

    public void addFood(int food) {
        this.food += food;
        System.out.println("Добавляем еду: " + food + ". Новый остаток еды: " + this.food);
    }

}
