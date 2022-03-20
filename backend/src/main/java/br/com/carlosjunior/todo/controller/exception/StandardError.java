package br.com.carlosjunior.todo.controller.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StandardError implements Serializable {


	private static final long serialVersionUID = 1L;

	private Long timestamp;
	private Integer status;
	private String message;

}
