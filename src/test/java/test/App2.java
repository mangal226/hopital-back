package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.*;

import config.AppConfig;
import main.AppSpring;
import model.Patient;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
import repository.PatientRepository;

public class App2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBeanFactory().createBean(AppSpring.class).run(args);
		ctx.close();

	}

}
