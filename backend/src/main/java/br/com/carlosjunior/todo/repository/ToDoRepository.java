package br.com.carlosjunior.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.carlosjunior.todo.entity.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {

	@Query("SELECT t FROM ToDo t WHERE t.finalizado = false ORDER BY t.dataParaFinalizar")
	List<ToDo> findAllOpen();
	
	@Query("SELECT t FROM ToDo t WHERE t.finalizado = true ORDER BY t.dataParaFinalizar")
	List<ToDo> findAllClose();

}
