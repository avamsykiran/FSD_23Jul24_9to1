package com.cts.jsf.ui;

import com.cts.jsf.models.ComplexNumber;

public class App01ClassObjectDemo {

	public static void main(String[] args) {

		ComplexNumber z1 = new ComplexNumber();
		ComplexNumber z2 = new ComplexNumber(10,-2);
		ComplexNumber z3 = new ComplexNumber(z2);
		ComplexNumber z4 = z2;
		
		System.out.println(String.format("%s\t%d\t%d", z1,z1.hashCode(),System.identityHashCode(z1)));
		System.out.println(String.format("%s\t%d\t%d", z2,z2.hashCode(),System.identityHashCode(z2)));
		System.out.println(String.format("%s\t%d\t%d", z3,z3.hashCode(),System.identityHashCode(z3)));
		System.out.println(String.format("%s\t%d\t%d", z4,z4.hashCode(),System.identityHashCode(z4)));
		
		System.out.println(String.format("%b\t%b",z2==z3,z2.equals(z3)));
		System.out.println(String.format("%b\t%b",z2==z4,z2.equals(z4)));
	}

}
