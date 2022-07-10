package com.dsa.DSADump;

import com.dsa.DSADump.array.MinInRotatedSortedArray;
import com.dsa.DSADump.array.SearchInrotatedSortedArray;
import com.dsa.DSADump.tree.ChildrenSumPropertyConversion;
import com.dsa.DSADump.tree.SymmetricTrees;
import com.dsa.DSADump.tree.bst.CheckBST;
import com.dsa.DSADump.tree.bst.InOrderPredecessor;
import com.dsa.DSADump.tree.bst.SortedArrayToBST;
import com.dsa.DSADump.tree.views.BottomView;
import com.dsa.DSADump.tree.views.RightView;
import com.dsa.DSADump.tree.views.TopView;
import com.dsa.DSADump.tree.views.VerticaView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DsaDumpApplication implements CommandLineRunner {
	@Autowired
	MinInRotatedSortedArray primAlgorithm;
	public static void main(String[] args) {
		SpringApplication.run(DsaDumpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
    primAlgorithm.driver();

	}
}
