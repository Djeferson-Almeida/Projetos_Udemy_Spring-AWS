	package br.com.udemy;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.MediaType;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;

	import br.com.udemy.model.Person;
	import br.com.udemy.services.PersonServices;

	@RestController
	@RequestMapping(value = "/person")
	public class PersonController {

		@Autowired
		private PersonServices service = new PersonServices();

		@RequestMapping (method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public Person findById(@PathVariable(value = "id") String id)  {

			return service.findById(id);
		}
		
		@RequestMapping(value = "/{id}",
				method = RequestMethod.GET,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Person> findAll(){

			return service.findAll();
		}

		@RequestMapping(value = "/{id}",
				method = RequestMethod.POST,
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public Person create(@RequestBody Person person){

			return service.create(person);
		}
		

		@RequestMapping(value = "/{id}",
				method = RequestMethod.PUT,
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public Person update(@RequestBody Person person){

			return service.create(person);
		}
		
		@RequestMapping(value = "/{id}",
				method = RequestMethod.DELETE)
		public void delete(@PathVariable(value = "id") String id){

			service.delete(id);
		}
		
		
	}

	
