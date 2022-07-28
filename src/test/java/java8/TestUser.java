package java8;

import java8.User;
import java8.UserCheck;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TestUser {
    User firstUser = new User(25, "Nataly", 65, true, "housewife");
    User secondUser = new User(35, "Ros", 78, false, "waiter");
    User thirdUser = new User(65, "Larisa", 84, true, "pensioner");
    User fourthUser = new User(66, "Sergey", 65, false, "hunter");
    User fifthUser = new User(28, "Yasya", 65, true, "administrator");
    User sixthUser = new User(48, "", 102, false, "farmer");
    User seventhUser = new User(19, "Svetlana", 49, true, "nurse");
    User eighthUser = new User(37, "Nikolay", 36, false, "singer");
    User ninthUser = new User(55, "Katerina", 83, true, "housewife");
    User tenthUser = new User(64, "Vladimir", 72, false, "builder");
    User eleventhUser = new User(36, "Kamila", 55, true, "singer");
    User twelfthUser = new User(45, "Petya", 69, false,"postman");
    User thirteenthUser = new User(42, "Katerina", 103, true, "butcher");
    User fourteenthUser = new User(29, "Sasha", 64, false, "astronaut");
    User fifteenthUser = new User(51, "Yulya", 32 , true, "architect");

    List<User> userList = Arrays.asList(firstUser, secondUser, thirdUser,fourthUser, fifthUser, sixthUser, seventhUser,
            eighthUser, ninthUser, tenthUser, eleventhUser, twelfthUser, thirteenthUser, fourteenthUser, fifteenthUser);
    @Test
    public void CheckUserBySpeciality(){
        List<User> userList1 = printInformation(userList, new UserCheck() {
            @Override
            public boolean conditionCheck(User user) {
                return user.speciality.contains("singer");
            }
        });
        for (User user : userList1) {
            Assert.assertEquals("singer", user.speciality);
        }

    }

    @Test
    public void CheckUserBySpecialityAndAge(){
        List<User> userList1 = printInformation(userList, new UserCheck() {
            @Override
            public boolean conditionCheck(User user) {
                return user.speciality.contains("singer") && user.getAge() <37;
            }
        });
        for (User user : userList1) {
            Assert.assertTrue(user.speciality.contains("singer") && (user.getAge() <37));
        }

    }

    @Test
    public void CheckUserByAgeAndWeight(){
        List<User> userList1 = printInformation(userList, new UserCheck() {
            @Override
            public boolean conditionCheck(User user) {
                return user.getAge() >45 && user.getWeight() <84;
            }
        });
        for (User user : userList1) {
            Assert.assertTrue(user.getAge() >45 && user.getWeight() <84);
        }
    }

    @Test
    public void CheckUserByAgeAndSex(){
        List<User> userList1 = printInformation(userList, new UserCheck() {
            @Override
            public boolean conditionCheck(User user) {
                return user.isSex && user.getAge() <=60;
            }
        });
        for (User user : userList1) {
            Assert.assertTrue(user.isSex() &&  user.getAge() <=60);
        }

    }

    @Test
    public void CheckUserByNameAndSex(){
        List<User> userList1 = printInformation(userList, new UserCheck() {
            @Override
            public boolean conditionCheck(User user) {
                return user.isSex && Objects.equals(user.getName(), "Katerina");
            }
        });
        for (User user : userList1) {
            Assert.assertTrue(user.isSex && Objects.equals(user.getName(),"Katerina"));
        }
    }

    @Test
    public void CheckLenghtByName(){
        List<User> userList1 = printInformation(userList, new UserCheck() {
            @Override
            public boolean conditionCheck(User user) {
                return user.getName().length() % 2 ==0;
            }
        });
        for (User user : userList1) {
            Assert.assertEquals(user.getName().length() % 2, 0);
        }

    }

    @Test
    public void CheckNameIsEmpty(){
        List<User> userList1 = printInformation(userList, new UserCheck() {
            @Override
            public boolean conditionCheck(User user) {
                return user.getName().isEmpty();
            }
        });
        for (User user : userList1) {
            Assert.assertTrue(user.name.isEmpty());
        }

    }

    @Test
    public void CheckSpecialityContainsChar(){
        List<User> userList1 = printInformation(userList, new UserCheck() {
            @Override
            public boolean conditionCheck(User user) {
                return user.isSex && user.speciality.contains("er");
            }
        });
        for (User user : userList1) {
            Assert.assertTrue(user.isSex && user.speciality.contains("er"));
        }

    }

    @Test
    public void CheckSpecialityAndName(){
        List<User> userList1 = printInformation(userList, new UserCheck() {
            @Override
            public boolean conditionCheck(User user) {
                return user.getName().contains("Katerina") && user.speciality.equals("housewife");
            }
        });
        for (User user : userList1) {
            Assert.assertTrue(user.getName().contains("Katerina") && user.speciality.equals("housewife"));
        }

    }

    @Test
    public void CheckUserByAgeAndSex1(){
        List<User> userList1 = printInformation(userList, new UserCheck() {
            @Override
            public boolean conditionCheck(User user) {
                return user.getAge() >=40 && !user.isSex;
            }
        });
        for (User user : userList1) {
            Assert.assertTrue(user.getAge() >=40 && !user.isSex);
        }

    }
    public List<User> printInformation(List<User> userList, UserCheck userCheck) {
        List<User> userList1 = new ArrayList<>();
        for (User user : userList) {
            if (userCheck.conditionCheck(user)) {
                System.out.println(user);
                userList1.add(user);
            }
        }
        return userList1;
    }
}