package edu.innotech;

public class Starter {
    public static void main(String[] args) {
        Student st= new Student("pete");
        st.addGrade(3);
        st.getGrades().add(999);
        System.out.println(st);
    }
}

