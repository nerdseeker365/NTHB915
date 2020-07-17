package com.nt.entity;
//Entity class or Domain class or Model class or Persistance class or Pojo class or HLO(Hibernate Language Object) class
import java.io.Serializable;

import lombok.Data;
@Data
public class Product implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int pid;
private String pname;
private float price;
private float qly;
}
