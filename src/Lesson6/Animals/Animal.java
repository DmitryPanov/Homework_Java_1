package Lesson6.Animals;

public class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }
    public Animal(){

    }

    public void run(int lenghtRun) {
        if (lenghtRun <= 0) {
            System.out.println("Животное не может так бегать");
            return;
        }
        System.out.println("Животное пробежало: " + lenghtRun + " м");
    }

    public void swim(int lenghtSwim) {
        if (lenghtSwim <= 0) {
            System.out.println("Животное не может так плавать ");
            return;
        }
        System.out.println("Животное проплыло: " + lenghtSwim + " м");
    }

    public void jump(double lenghtJump) {
        if (lenghtJump <= 0) {
            System.out.println("Животное не может так прыгать ");
            return;
        }
        System.out.println("Животное прыгнуло на: " + lenghtJump + " м");
    }
}
