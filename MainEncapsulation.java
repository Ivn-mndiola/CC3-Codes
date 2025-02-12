class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Student {
    private String idNo;

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getIdNo() {
        return idNo;
    }
}

public class MainEncapsulation {
    public static void main(String[] args) {
        Person p = new Person();
        Student stud = new Student();

        p.setName("MENDIOLA");
        stud.setIdNo("24-1111-222");
        
        System.out.println(p.getName());
        System.out.println("Hello " + p.getName());
        System.out.println("Your ID number is: " + stud.getIdNo());
    }
}
