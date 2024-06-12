package br.com.udemy.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.udemy.exceptions.ResourceNotFoundException;
import br.com.udemy.mapper.ModelMapper;
import br.com.udemy.mapper.custom.PersonMapper;
import br.com.udemy.model.Person;
import br.com.udemy.repositories.PersonRepository;
import br.com.udemy.vo.v1.PersonVO;
import br.com.udemy.vo.v2.PersonVOV2;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonMapper mapper;
	
	public List<PersonVO> findAll() {
		logger.info("Finding all peoples!");
		
		return ModelMapper.parseListObjects(repository.findAll(), PersonVO.class);

	}

	public PersonVO findById(Long id) {

		logger.info("Finding one PersonVO!");
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		return ModelMapper.parseObject(entity, PersonVO.class);
	}

	
	public PersonVO create(PersonVO person) {
		logger.info("Creating one PersonVO!");
		
		var entity = ModelMapper.parseObject(person, Person.class);
		var vo = ModelMapper.parseObject(repository.save(entity), PersonVO.class);
		return vo;	
	}
	
	public PersonVOV2 createV2(PersonVOV2 person) {
		logger.info("Creating one PersonVO!");
		
		var entity = mapper.convertVoToEntity(person);
		var vo = mapper.convertEntityToVo(repository.save(entity));
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		logger.info("updating Person!");
		
		var entity= repository.findById(person.getId())
				.orElseThrow(() -> 
		new ResourceNotFoundException("No records found for this ID!"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo = ModelMapper.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		
		logger.info("Deleting one person!");
		
		var entity= repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
		
		}
	
	

}
