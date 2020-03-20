package repository.impl;

import org.springframework.stereotype.Component;

import repository.IRepository;
@Component(value = "txtRepository")
public class TxtRepository implements IRepository {
	public void save(String message) {
		System.out.println(message);
	}
}
