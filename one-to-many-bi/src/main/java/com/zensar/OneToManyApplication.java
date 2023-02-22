package com.zensar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zensar.entity.Address;
import com.zensar.entity.User;
import com.zensar.repository.AddressRepository;
import com.zensar.repository.UserRepository;

@SpringBootApplication
public class OneToManyApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user = userRepository.findById(101).get();
		
		System.out.println(user.getUserName());
		
	//	System.out.println(user.getAddresses().get(0).getCity());
		
		

	/*	User user = new User();

		user.setUserId(101);
		user.setUserName("Ravi");
		user.setUserAge(30);

		Address address1 = new Address();
		address1.setAddressId(1);
		address1.setCity("Amravati");
		address1.setState("Maha");
		address1.setPinCode(444606);
		address1.setUser(user);

		Address address2 = new Address();
		address2.setAddressId(2);
		address2.setCity("Pune");
		address2.setState("Maha");
		address2.setPinCode(411016);
		address2.setUser(user);

		user.setAddresses(List.of(address1, address2));

		// addressRepository.save(address1);
		// addressRepository.save(address2);

		userRepository.save(user); */

	}

}
