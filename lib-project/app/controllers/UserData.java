package controllers;

import play.data.validation.Constraints;

public class UserData {

    @Constraints.Required
    private String name;

    @Constraints.Required
    private Integer age;

    @Constraints.Required
    private String gender;

    @Constraints.Required
    private String email;

    @Constraints.Required
    private String password;

    public UserData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender(){return gender;}

    public void setGender(String gender){this.gender = gender;}

    public String getEmail(){return email;}

    public void setEmail(String email){this.email = email;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("UserData(%s, %s, %s, %s)", name, age, gender, email);
    }

}
