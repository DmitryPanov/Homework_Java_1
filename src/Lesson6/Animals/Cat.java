package Lesson6.Animals;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void run(int lenghtRun) {
        System.out.println(name + ": " + checkRun(lenghtRun));
        if(checkRun(lenghtRun) == true){
            System.out.println(name + " пробежал " + lenghtRun + " m");
        } else {
            System.out.println(name + " не может столько бегать");
        }
    }

    @Override
    public void swim(int lenghtSwim) {
        System.out.println(name + ": " + checkSwim(lenghtSwim));
        System.out.println("Котики не плавают!");
    }

    @Override
    public void jump(double lenghtJump) {
        System.out.println(name + ": " + checkJump(lenghtJump));
        if(checkJump(lenghtJump) == true){
            System.out.println(name + " прыгнул на " + lenghtJump + " m");
        } else {
            System.out.println(name + " не может так прыгать");
        }
    }

    private boolean checkJump(double jump) {
        if (jump <= 0 || jump > 2) {
            return false;
        }
        return true;
    }

    private boolean checkSwim(int lenghtSwim) {
        return false;
    }

    private boolean checkRun(int lenghtRun) {
        if (lenghtRun <= 0 || lenghtRun > 200) {
            return false;
        }
        return true;
    }
}
