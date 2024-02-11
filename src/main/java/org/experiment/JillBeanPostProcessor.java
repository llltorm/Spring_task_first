package org.experiment;

import org.experiment.data.Student;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.Map;

public class JillBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Student) {
            Student student = (Student) bean;
            if (student.getName().equals("Jil") && student.calculateAverageGrades() < 3) {
                for (Map.Entry<String, Integer> entry : student.getMapGradesOfStudent().entrySet()) {
                    entry.setValue(3);
                }
            }
        }
        return bean;
    }
}
