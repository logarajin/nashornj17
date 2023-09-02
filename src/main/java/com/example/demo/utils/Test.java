package com.example.demo.utils;

import org.mapstruct.factory.Mappers;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	  MapperEx mapper  = (MapperEx) Mappers.getMapper(MapperEx.class);

	  
	  SimpleSource simpleSource = new SimpleSource();
      simpleSource.setName("Rama");
      simpleSource.setDescription("Here");
      SimpleDestination destination = mapper.copySourceToDestination(simpleSource);
      
      System.out.println(destination);
	}

}
