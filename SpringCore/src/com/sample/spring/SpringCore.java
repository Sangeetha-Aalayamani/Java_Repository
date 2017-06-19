package com.sample.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 
 * @author user
 *
 */
public class SpringCore {

	public static void main(String[] args) {

		// Resource resource = new ClassPathResource("application-context.xml");

		// BeanFactory c = new XmlBeanFactory(resource);

		ApplicationContext c = new ClassPathXmlApplicationContext("application-context.xml");

		Student s = (Student) c.getBean("studentBean");
		System.out.println("Name is " + s.getName());
		System.out.println("ID is " + s.getId());

		System.out.println(s);

	}

}
