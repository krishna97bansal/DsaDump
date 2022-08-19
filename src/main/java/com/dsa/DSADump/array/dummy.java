package com.dsa.DSADump.array;

import java.util.*;

public class dummy {
    public static  void main(String args[]){

        Map<Emp, String> map = new HashMap<>();
        Emp emp1 = new Emp("a");
        map.put(emp1, "a");
        System.out.println(map.get(emp1));

        emp1.name="b";
        System.out.println(map.get(emp1));

        Emp emp2 = new Emp("b");
        System.out.println(map.get(emp2));

        Emp emp3 = new Emp("a");
        System.out.println(map.get(emp3));
    }


}
class Emp {
    String name;
    Integer age;

    Emp(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.name);
    }

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((Emp)obj).name);
    }
}
