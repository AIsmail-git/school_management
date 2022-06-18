package za.ac.cput.school_management.factory;

/*
Author: Ameer Ismail
student nr: 218216033
factory: Student factory
ADP3 June assessment Group 1
 */

import za.ac.cput.school_management.domain.Name;
import za.ac.cput.school_management.domain.Student;
import za.ac.cput.school_management.helper.Helper;

public class StudentFactory
{
    public static Student build(String studentId, String email, Name name)
    {
        Helper.checkStringParam("studentId", studentId);
        Helper.checkIfObjectNull("Name", name);
        Helper.checkStringParam("email", email);
        Helper.checkEmail(email);

        return new Student.Builder()
                .setStudentId(studentId)
                .setEmail(email)
                .setName(name)
                .build();
    }
}
