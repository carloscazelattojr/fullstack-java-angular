package br.com.carlosjunior.todo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.carlosjunior.todo.entity.ToDo;
import br.com.carlosjunior.todo.service.ToDoService;

@RestController
@RequestMapping("/todos")
public class ToDoController {

	@Autowired
	private ToDoService toDoService;

	@GetMapping("/{id}")
	public ResponseEntity<ToDo> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(toDoService.findById(id));
	}

	@GetMapping("/open")
	public ResponseEntity<List<ToDo>> listOpen() {
		List<ToDo> list = toDoService.findAllOpen();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/close")
	public ResponseEntity<List<ToDo>> listClose() {
		List<ToDo> list = toDoService.findAllClose();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping()
	public ResponseEntity<List<ToDo>> listAll() {
		List<ToDo> list = toDoService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<ToDo> create(@RequestBody ToDo obj) {
		obj = toDoService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		toDoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ToDo> update(@PathVariable Long id, @RequestBody ToDo obj){
		ToDo newObj = toDoService.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	

}
