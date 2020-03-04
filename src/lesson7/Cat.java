package lesson7;

public class Cat {

    private String name;
    private boolean fullCat = false;// сытость кота
    private int eatCat = (int) (Math.random() * 100) + 1;// аппетит кота

    public Cat(String name) {
        this.name = name;
    }

    public void eat(Plate plate) {

        if (plate.checkFoodPlate(plate.getFood(), eatCat) && !fullCat) {
            plate.setFood(plate.getFood() - eatCat);
            fullCat = true;
            System.out.println("Кот: " + name + " ест. Аппетит кота: " + eatCat );
        } else {
            System.out.println("Кот " + name + " поел или в тарелке для него не хватает еды. Аппетит кота: " + eatCat);
        }
    }

}
