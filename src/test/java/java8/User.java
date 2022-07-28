package java8;

public class User {

    int age;
    String name;
    int weight;
    boolean isSex;
    String speciality;

    public User(int age, String name, int weight, boolean sex, String speciality) {
        this.age = age;
        this.name = name;
        this.weight = weight;
        this.isSex = sex;
        this.speciality = speciality;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isSex() {
        return isSex;
    }

    public String getSpeciality() {
        return speciality;
    }

    @Override
    public String toString() {
        return "Age : " + age + "; Name : " + name + "; Weight :" + weight + "; Sex : " + isSex + "; Speciality : " + speciality;
    }
}
