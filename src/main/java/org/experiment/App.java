package org.experiment;

import org.experiment.context.ApplicationContext;
import org.experiment.data.Teacher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext javaConfigContext =
                new AnnotationConfigApplicationContext(ApplicationContext.class);

        Teacher teacherA = javaConfigContext.getBean("teacher", Teacher.class);
        System.out.println("JAVA Config file:");
        System.out.println(teacherA);
        javaConfigContext.close();

        ClassPathXmlApplicationContext xmlConfigContext =
                new ClassPathXmlApplicationContext("XmlContext.xml");

        Teacher teacherB = xmlConfigContext.getBean("teacher", Teacher.class);
        System.out.println("XML Config file:");
        System.out.println(teacherB);
        xmlConfigContext.close();
    }
}
