package 案例.HomeWork.hspdeuHomeWork.GenericExercise;

import java.util.*;

/**
 * coding: utf-8
 *
 * @version 1.0
 */
public class Exercise03 {
    public static void main(String[] args) {
        DAO<User> userDAO = new DAO<>();
        System.out.println(userDAO);
        userDAO.save("1", new User(1, 18, "yj"));
        userDAO.save("2", new User(2, 19, "yx"));
        userDAO.save("3", new User(2, 20, "zzc"));
        System.out.println(userDAO);

        List<User> list = userDAO.list();
        System.out.println(list);
        userDAO.delete("1");
        System.out.println(userDAO);
        System.out.println(userDAO.get("2"));
        userDAO.update("3",new User(2, 20, "zzcez"));
        System.out.println(userDAO);
    }
}

class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    public List<T> list() {
        ArrayList<T> ts = new ArrayList<>();
        Set<String> strings = map.keySet();
        for (String key : strings) {
            ts.add(get(key));
        }
        return ts;
    }

    public void delete(String id) {
        map.remove(id);
    }

    @Override
    public String toString() {
        return "DAO{" +
                "map=" + map +
                '}';
    }
}

class User {
    private int id;
    private int age;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}