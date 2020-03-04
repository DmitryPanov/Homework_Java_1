package Lesson6.Animals;

public class Dog extends Animal {
    int lenghtRun;
    static int countDog;

    public Dog(String name,int lenghtRun) {
        super(name);
        this.lenghtRun = lenghtRun;
        countDog +=1;
        System.out.println("Количество созданных собак: " + countDog);
    }
    @Override
    public void run(int run) {
        System.out.println(name + ": " + checkRun(run,lenghtRun));
        if(checkRun(run,lenghtRun) == true){
            System.out.println(name + " пробежал " + run + " m");
        } else {
            System.out.println(name + " не может столько бегать");
        }
    }

    @Override
    public void swim(int lenghtSwim) {
        System.out.println(name + ": " + checkSwim(lenghtSwim));
        if(checkSwim(lenghtSwim) == true){
            System.out.println(name + " проплыл " + lenghtSwim + " m");
        } else {
            System.out.println(name + " не может так плавать");
        }
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
        return !(jump <= 0) && !(jump > 0.5);
    }

    private boolean checkSwim (int lenghtSwim) {
        return lenghtSwim > 0 && lenghtSwim <= 10;
    }

    private boolean checkRun(int run,int lenghtRun) {
        if (lenghtRun <= 0 || run > lenghtRun) {
            return false;
        }
        return true;
    }

}
