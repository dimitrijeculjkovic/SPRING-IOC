package repository.impl;

import org.springframework.stereotype.Component;

import repository.IRepository;
@Component(value = "xmlRepository")
public class XMLRepository  implements IRepository{
	public void save(String message) {
		System.out.println("<message>"+message+"</message>");
	}
}
