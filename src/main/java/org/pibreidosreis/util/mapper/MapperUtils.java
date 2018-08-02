package org.pibreidosreis.util.mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MapperUtils {

	private static ObjectMapper mapperInstance;
	private static DozerBeanMapper dozerMapper;
	
	public static ObjectMapper getMapper() {
		mapperInstance = Optional.ofNullable(mapperInstance).orElse(new ObjectMapper()
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false));
		return mapperInstance;
	}
	
	public static DozerBeanMapper getDozerMapper() {
		dozerMapper = Optional.of(dozerMapper).orElse(new DozerBeanMapper());
		return dozerMapper;
	}
	
	public static <E, D> D map(E object, Class<D> type){
		return getMapper().convertValue(object, type);
	}
	
	public static <E, D> List<D> mapAll(List<E> list, Class<D> type){
		return list.stream().map(item -> getMapper().convertValue(list, type))
				.collect(Collectors.toList());
	}
	
	public static void addMappingToDozer(BeanMappingBuilder mappingBuilder) {
		getDozerMapper().addMapping(mappingBuilder);
	}
	
	public static <E, D> void copyProperties(E oldObject, D newObject) {
		getDozerMapper().map(oldObject, newObject);
	}
}
