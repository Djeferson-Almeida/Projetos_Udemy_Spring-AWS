package br.com.udemy.mapper;

import java.util.ArrayList;
import java.util.List;

public class ModelMapper {

	 private static ModelMapper mapper = new ModelMapper();
	 
	 public static <O,D> D parseObject(O origin, Class<D> destination) {
	 	return mapper.parseObject(origin, destination);
}

	public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination){
		List<D> destinationObjects = new ArrayList<D>();
		for(O o : origin) {
			destinationObjects.add(mapper.parseObject(o,destination));
		}
		return destinationObjects;
	}
}