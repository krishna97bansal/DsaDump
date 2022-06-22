package com.dsa.DSADump;

import com.dsa.DSADump.graph.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DsaDumpApplication implements CommandLineRunner {

	@Autowired
	ShortestPathUnidirectedUnitWeight dfsTraversal;

	public static void main(String[] args) {
		SpringApplication.run(DsaDumpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		dfsTraversal.driver().forEach(i->System.out.println(i));
		System.out.println(dfsTraversal.driver());
	}
}
