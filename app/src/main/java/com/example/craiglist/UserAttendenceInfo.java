package com.example.craiglist;

public class UserAttendenceInfo {

    public Integer ChemistryTotalCounter;
    public Integer PhysicsTotalCounter;
    public Integer PetroleumTotalCounter;
    public Integer MathsTotalCounter;

    public UserAttendenceInfo(Integer chemistryTotalCounter, Integer physicsTotalCounter, Integer petroleumTotalCounter, Integer mathsTotalCounter) {
        ChemistryTotalCounter = chemistryTotalCounter;
        PhysicsTotalCounter = physicsTotalCounter;
        PetroleumTotalCounter = petroleumTotalCounter;
        MathsTotalCounter = mathsTotalCounter;
    }
}
