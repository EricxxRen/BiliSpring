package com.rxx.coffeejourney.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将application.yml中定义的值映射到这个类中
 * @ConfigurationProperties告诉SpringBoot将本类中的所有属性和配置文件中的相关属性进行绑定
 *      prefix = "person"指定配置文件中的那个属性进行绑定
 * 只有组件在容器中才能提供@ConfigurationProperties的功能
 * 会报Not registered via @ConfigurationProperties or marked as Spring Component
 * 需要添加@Component注解
 */
@Component
/**
 * @Validated加入数据校验功能，属性上加@Email标签说明该属性必须为邮箱格式
 * 只有@ConfigurationProperties支持，@Value()不支持
 */
//@Validated
/**
 * @PropertySource(value = "classpath:person.properties")只能作用于.properties文件
 * 获取不到.yml文件
 */
//@PropertySource(value = "classpath:person.properties")
@ConfigurationProperties(prefix = "person")
public class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private Boolean boss;
    private Date birth;

    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
}
