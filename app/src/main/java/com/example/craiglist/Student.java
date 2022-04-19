package com.example.craiglist;

public class Student {
    private final String Name;
    private final String RollNo;
    private final Integer Chemistry;


    public Student(String Name, String RollNo, Integer Chemistry) {
        this.Name = Name;
        this.RollNo = RollNo;
        this.Chemistry = Chemistry;



    }

    public String getName() {
        return Name;
    }

    public String getRollNo() {
        return RollNo;
    }
    public Integer getChemistry() {
        return Chemistry;
    }

}
