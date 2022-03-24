package com.hiber;
 
import com.hibernate.dao.StudentDao;
import com.hibernate.model.Student;

public class App {
public static void main(String[] args) {
	StudentDao s =  new StudentDao();
	Student student  = new Student("Vasanth","kumar","dineshkumar6380704237@gmail.com");
	//s.saveStudent(student);
	//s.updateStudent("selvakumar",4);
 
	//s.DeleteStudent(3);
	s.selectStudent(1);
//	List< Student > students = s.getStudent();
//	for(Student a : students)
//	{
//		System.out.println("Student :" +a);
//	}
//	
 }
}
