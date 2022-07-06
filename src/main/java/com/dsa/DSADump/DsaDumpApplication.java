package com.dsa.DSADump;

import com.dsa.DSADump.graph.*;
import com.dsa.DSADump.matrix.FindElementInRowColumnSortedMatrix;
import com.dsa.DSADump.matrix.SpiralTraversal;
import com.dsa.DSADump.tree.traversals.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DsaDumpApplication implements CommandLineRunner {
	@Autowired
	FindElementInRowColumnSortedMatrix primAlgorithm;
	public static void main(String[] args) {
		SpringApplication.run(DsaDumpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
    primAlgorithm.driver();

	}
}
