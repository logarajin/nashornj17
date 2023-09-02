package com.example.demo.utils;

import org.mapstruct.Mapper;


@Mapper
public interface MapperEx {
	
	public SimpleDestination copySourceToDestination(SimpleSource source);
	
	public SimpleSource copyDestinationToSource(SimpleDestination source);

}
