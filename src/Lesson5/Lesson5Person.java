package Lesson5;

import sun.plugin.javascript.navig.Array;

import java.util.Arrays;

class Person {

    private String name;
    private String position;
    private String email;
    private long phoneNumber;
    private int salary;
    private int age;

    public Person(String name, String position, String email, long phoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public Person(){
    }

    public void print(){
        System.out.println("Name: " + name + "\nPosition: " + position + "\nEmail: " + email + "\nPhone Number: " + phoneNumber + "\nSalary: " + salary + "\nAge: " + age);
    }


    public int getAge() {
        return age;
    }
}

public class Lesson5Person {

    public static void main(String[] args) {
        Person pers = new Person("IvanovIvan","Engineer", "ivivan@mailbox.com", 892312312, 30000, 30);
        pers.print();

        Person [] persArray = new Person[5];

        persArray[0] = new Person("IvanovIvan","Engineer", "iv_ivan@mailbox.com", 892312312, 30000, 30);
        persArray[1] = new Person("PetrovPetr","Analyst", "petr_petr@mailbox.com", 892355612, 50000, 40);
        persArray[2] = new Person("SmirnovSergey","Developer", "sm_sergey@mailbox.com", 892456567, 80000, 45);
        persArray[3] = new Person("PotapovaOlga","Director", "pot_olga@mailbox.com", 892777799, 150000, 37);
        persArray[4] = new Person("TryshinIgor","Sysadmin", "Tr_igor@mailbox.com", 892345512, 60000, 39);

        for (int i = 0; i <persArray.length ; i++) {
            if (persArray[i].getAge()>=40){
                persArray[i].print();
            }
        }

    }


}