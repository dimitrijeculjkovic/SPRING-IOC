package main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import config.MyBeanConfig;
import repository.IRepository;
import service.MessageService;
@Component(value = "main")
public class Main {
	
	public static void main(String[] args) {

		BeanFactory container = new AnnotationConfigApplicationContext(MyBeanConfig.class);
		
		Main main = container.getBean("main", Main.class);
		
		MessageService messageService = 
				container.getBean("messageServiceTxtRepository", MessageService.class);
		
//		main.annotationConfig();
		main.saveMessage(messageService, "Gladan sam!!!");
		
		((AnnotationConfigApplicationContext)container).close();
	}

	private void annotationConfig() {
		BeanFactory container = new AnnotationConfigApplicationContext(MyBeanConfig.class);
		IRepository txtRepository = (IRepository)container.getBean("txtRepository");
		txtRepository.save("My plain message!");
		
		IRepository xmlRepository = container.getBean("xmlRepository", IRepository.class);
		xmlRepository.save("My xml message!");
		
		((AnnotationConfigApplicationContext)container).close();
	}
	
	//u zavisnosti od uslova koristimo cuvamo poruku u txt repository ili xml repository
	private void saveMessage(MessageService ms, String message) {

		ms.save(message);
		
		
	}
}
