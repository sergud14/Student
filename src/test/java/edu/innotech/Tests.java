package edu.innotech;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tests {
    @RepeatedTest(value=4,name="корректные оценки добавляются в список оценок")
    public void gradesInRange(RepetitionInfo repetitionInfo){
        Student stud= new Student("vasia");
        int num = repetitionInfo.getCurrentRepetition()+1;
        stud.addGrade(num);
        Assertions.assertEquals(stud.getGrades().get(0),num);
    }

    @ParameterizedTest(name="добавление неверных оценок кидает исключение")
    @MethodSource("edu.innotech.MarksGenerator#ints")
    public void gradesNotInRange(int x){
        Student stud= new Student("vasia");
        Assertions.assertThrows(IllegalArgumentException.class,()->stud.addGrade(x));
    }

    @Test
    public void testAddGrade(){
        Student stud= new Student("vasia");
        List<Integer> test = new ArrayList<>(stud.getGrades());
        stud.getGrades().add(5);
        Assertions.assertEquals(test,stud.getGrades());
    }

    @Test
    public void testToString(){
        String name="vasia";
        int grade=5;
        List<Integer> grades=new ArrayList<>();
        grades.add(grade);
        Student stud= new Student(name);
        stud.addGrade(grade);
        String studToString= "Student{" + "name=" + name + ", marks=" + grades + '}';
        Assertions.assertEquals(studToString,stud.toString());
    }

    @Test
    public void testGetName(){
        String name="vasia";
        Student stud= new Student(name);
        Assertions.assertEquals(name,stud.getName());
    }

    @Test
    public void testSetName(){
        String name="vasia";
        String name2="vanya";
        Student stud= new Student(name);
        stud.setName(name2);
        Assertions.assertEquals(name2,stud.getName());
    }

    @Test
    public void testEquals(){
        Student stud= new Student("vasia");
        stud.addGrade(5);
        Student stud2= null;
        Object stud3= new Object();
        Student stud4= new Student("vasia");
        stud4.addGrade(5);
        Student stud5= new Student("vania");
        stud5.addGrade(5);
        Assertions.assertEquals(stud,stud);
        Assertions.assertNotEquals(stud,stud2);
        Assertions.assertNotEquals(stud.getClass(),stud3.getClass());
        Assertions.assertEquals(stud,stud4);
        Assertions.assertNotEquals(stud,stud5);
    }
    @Test
    public void testHash()
    {
        Student stud= new Student("vasia");
        stud.addGrade(5);
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(stud.getName());
        hash = 13 * hash + Objects.hashCode(stud.getGrades());
        Assertions.assertEquals(hash,stud.hashCode());
    }
}
