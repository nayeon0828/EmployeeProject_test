package vo;

import java.util.Objects;

public class EmployeeVO {

     private String id;
     private String name;
     private String postion;
     private int salary;
     private String hireDate;

    public EmployeeVO(String id, String name, String postion, int salary, String hireDate) {
        this.id = id;
        this.name = name;
        this.postion = postion;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }


    @Override
    public String toString() {
        return "EmployeeVO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", postion='" + postion + '\'' +
                ", salary=" + salary +
                ", hireDate='" + hireDate + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeVO that = (EmployeeVO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
