package br.com.carlosjunior.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carlosjunior.todo.entity.ToDo;
import br.com.carlosjunior.todo.repository.ToDoRepository;
import br.com.carlosjunior.todo.service.exception.ObjectNotFoundException;

@Service
public class ToDoService {

	@Autowired
	private ToDoRepository toDoRepository;
	
	public ToDo findById(Long id) {
		Optional<ToDo> obj = toDoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Id não encontrado"));
	}

	public List<ToDo> findAllOpen() {
		List<ToDo> list = toDoRepository.findAllOpen();
		return list;
	}

	public List<ToDo> findAllClose() {
		List<ToDo> list = toDoRepository.findAllClose();
		return list;
	}

	public List<ToDo> findAll() {
		List<ToDo> list = toDoRepository.findAll();
		return list;
	}

	public ToDo create(ToDo obj) {
		obj.setId(null);
		return toDoRepository.save(obj);
	}

	public void deleteById(Long id) {
		toDoRepository.deleteById(id);		
	}

	public ToDo update(Long id, ToDo obj) {
		ToDo newToDo = toDoRepository.findById(id).orElseThrow();
		newToDo.setTitulo(obj.getTitulo());
		newToDo.setDescricao(obj.getDescricao());
		newToDo.setDataParaFinalizar(obj.getDataParaFinalizar());
		newToDo.setFinalizado(obj.getFinalizado());
		return toDoRepository.save(newToDo);;
	}

	
	
}
