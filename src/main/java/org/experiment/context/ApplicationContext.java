package org.experiment.context;

import org.experiment.JillBeanPostProcessor;
import org.experiment.data.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan("org.experiment.data")
@PropertySource("classpath:MyApp.properties")
public class ApplicationContext {

    @Bean(initMethod = "init")
    public Student studentA() {
        Map<String, Integer> mapGradesOfStudent = new HashMap<String, Integer>();
        String name = "Bob";
        mapGradesOfStudent.put("history", 5);
        mapGradesOfStudent.put("biology", 4);
        mapGradesOfStudent.put("math", 5);
        return new Student(name, mapGradesOfStudent);
    }

    @Bean(initMethod = "init")
    public Student studentB() {
        Map<String, Integer> mapGradesOfStudent = new HashMap<String, Integer>();
        String name = "Jil";
        mapGradesOfStudent.put("history", 2);
        mapGradesOfStudent.put("biology", 2);
        mapGradesOfStudent.put("math", 3);
        return new Student(name, mapGradesOfStudent);
    }

    @Bean(initMethod = "init")
    public Student studentC() {
        Map<String, Integer> mapGradesOfStudent = new HashMap<String, Integer>();
        String name = "Nik";
        mapGradesOfStudent.put("history", 2);
        mapGradesOfStudent.put("biology", 2);
        mapGradesOfStudent.put("math", 3);
        return new Student(name, mapGradesOfStudent);
    }

    @Bean
    public JillBeanPostProcessor BeanPostProcessor() {
        return new JillBeanPostProcessor();
    }
}
