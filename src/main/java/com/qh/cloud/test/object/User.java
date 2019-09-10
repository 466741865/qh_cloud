package com.qh.cloud.test.object;

/**
 * @author : QingHang
 * @version 1.0
 * @Description : TODO
 * @date : 2018/5/16 10:34
 */
public class User {

    private int id;

    private String name;

    private String nickname;

    private int age;

    private int sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (age != user.age) return false;
        if (sex != user.sex) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return nickname != null ? nickname.equals(user.nickname) : user.nickname == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + sex;
        return result;
    }
}
