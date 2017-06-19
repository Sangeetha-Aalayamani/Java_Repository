package com.sample.spring;

import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * 
 * @author user
 *
 */
public class Student {

	private String id;
	private String name;
	private List<String> studentIdList;
	private Set<String> studentNameList;
	private Map<String,String> mapList;
	private Address address;
	
	public Student(){
		System.out.println("Inside Student Class Constructor");
	}
		
	public Student(String id, String name,List<String> studentIdList,Set<String> studentNameList,Map<String,String> mapList,Address addr) {
		super();
		this.id = id;
		this.name = name;
		this.studentIdList= studentIdList;
		this.studentNameList = studentNameList;
		this.mapList = mapList;
		address = addr;
		System.out.println("Student Constructor");
		System.out.println("ID: " +id);
		System.out.println("Name: " +name);
		System.out.println("studentIdList: " +studentIdList);
		System.out.println("studentNameList: " +studentNameList);
		System.out.println("mapList: " +mapList);
		System.out.println("Address:"+addr.toString());
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public List<String> getStudentIdList() {
		return studentIdList;
	}


	public void setStudentIdList(List<String> studentIdList) {
		this.studentIdList = studentIdList;
	}


	public Set<String> getStudentNameList() {
		return studentNameList;
	}


	public void setStudentNameList(Set<String> studentNameList) {
		this.studentNameList = studentNameList;
	}


	public Map<String, String> getMapList() {
		return mapList;
	}


	public void setMapList(Map<String, String> mapList) {
		this.mapList = mapList;
	}


	@Override
	public String toString() {
		System.out.println("id: "+id);
		System.out.println("name: "+name);
		return "Student Details [id=" + id + ", name=" + name + "]";
	}	
}
