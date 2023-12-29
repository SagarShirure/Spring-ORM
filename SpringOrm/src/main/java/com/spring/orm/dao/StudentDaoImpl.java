package com.spring.orm.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.Student;



public class StudentDaoImpl implements StudentDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public int saveStudent(Student student) {
		try {
			hibernateTemplate.saveOrUpdate(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	public Student getStudent(int id) {
		Student st = hibernateTemplate.get(Student.class, id);
		return st;
	}

	public List<Student> getAllStudent() {
		List<Student> list = hibernateTemplate.loadAll(Student.class);
		return list;
	}

	@Transactional
	public void updateStudent(Student student) {
		try {
			hibernateTemplate.saveOrUpdate(student);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Enter valid ID");
		}
	}

	@Transactional
	public void deleteStudent(int id) {
		try {
		Student st = hibernateTemplate.get(Student.class, id);
		hibernateTemplate.delete(st);
	} catch (Exception e) {
			System.out.println("Enter valid ID");
		}
	}

	

}