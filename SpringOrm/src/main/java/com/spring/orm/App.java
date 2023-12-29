package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.orm.dao.StudentDao;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao sd = context.getBean("studentDao", StudentDao.class);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean go = true;
		while (go) {
			System.out.println("press 1 to add student");
			System.out.println("press 2 to display all student");
			System.out.println("press 3 to get one student");
			System.out.println("press 4 to delete student");
			System.out.println("press 5 to update student");
			System.out.println("press 6 to exit");
			try {
				int input = Integer.parseInt(br.readLine());
				switch (input) {
				case 1:
					System.out.println("Enter name ");
					String name=br.readLine();
					System.out.println("Enter ID");
					int id=Integer.parseInt(br.readLine());
					System.out.println("Enter City");
					String city=br.readLine();
					Student st=new Student();
					st.setId(id);
					st.setAddress(city);
					st.setName(name);
					sd.saveStudent(st);
					break;

				case 2:
					List<Student> list = sd.getAllStudent();
					for (Student sts : list) {
						System.out.println(sts);
					}

					break;
				case 3:
					System.out.println("Enter ID");
					 id=Integer.parseInt(br.readLine());
					Student std=sd.getStudent(id);
					System.out.println(std);
					
					break;
				case 4:
					System.out.println("Enter ID");
					 id=Integer.parseInt(br.readLine());
					sd.deleteStudent(id);
					break;
				case 5:
					System.out.println("Enter name ");
					 name = br.readLine();
					System.out.println("Enter ID");
					 id = Integer.parseInt(br.readLine());
					System.out.println("Enter City");
					 city = br.readLine();
					Student st1 = new Student();
					st1.setId(id);
					st1.setAddress(city);
					st1.setName(name);
					sd.updateStudent(st1);
					System.out.println();
					break;
				case 6:
					go = false;
					break;
				default:
					System.out.println("input valid number");
					break;
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}
}
