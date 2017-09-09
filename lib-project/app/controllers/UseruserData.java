package controllers;

import play.data.validation.Constraints;

public class UseruserData {

    @Constraints.Required
    private String name;

    @Constraints.Required
    private Integer age;

    public UseruserData() {
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

    @Override
    public String toString() {
        return String.format("UseruserData(%s, %s)", name, age);
    }

}
