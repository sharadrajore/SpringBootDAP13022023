package com.zensar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zensar.entity.Address;
import com.zensar.entity.User;
import com.zensar.repository.AddressRepository;
import com.zensar.repository.UserRepository;

@SpringBootApplication
public class OneToOneApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User user = new User();
		user.setUserId(1);
		user.setUserName("Ram");
		user.setUserAge(24);

		Address address = new Address();
		address.setAddressId(1);
		address.setCity("Pune");
		address.setState("Maha");
		address.setPinCode(411016);
		address.setUser(user);

		addressRepository.save(address);

	}

}
