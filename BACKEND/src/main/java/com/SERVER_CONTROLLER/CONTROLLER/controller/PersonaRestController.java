package com.SERVER_CONTROLLER.CONTROLLER.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SERVER_CONTROLLER.CONTROLLER.dto.MedicamentoDTO;
import com.SERVER_CONTROLLER.CONTROLLER.model.Medicamento;
import com.SERVER_CONTROLLER.CONTROLLER.service.API.MedicamentoServiceApi;

@RestController
@RequestMapping("api/v1/medicamento")
@CrossOrigin("*")
public class PersonaRestController {

   @Autowired
	private MedicamentoServiceApi medicamentoServiceAPI;

	@GetMapping(value = "/")
	public List<MedicamentoDTO> getAll() throws Exception {
		return medicamentoServiceAPI.getAll();
	}

	@GetMapping(value = "/{id}")
	public MedicamentoDTO find(@PathVariable String id) throws Exception {
		return medicamentoServiceAPI.get(id);
	}

	@PostMapping(value = "/")
	public ResponseEntity<String> save(@RequestBody Medicamento medicamento) throws Exception {
		
		String id = medicamentoServiceAPI.save(medicamento);
		
		return new ResponseEntity<String>(id, HttpStatus.OK);
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<String> save2(@RequestBody Medicamento medicamento, @PathVariable String id) throws Exception {
		if (id == null || id.length() == 0 || id.equals("null")) {
			id = medicamentoServiceAPI.save(medicamento);
		} else {
			medicamentoServiceAPI.save(medicamento, id);
		}
		return new ResponseEntity<String>(id, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<MedicamentoDTO> delete(@PathVariable String id) throws Exception {
		MedicamentoDTO medicamento = medicamentoServiceAPI.get(id);
		if (medicamento != null) {
			medicamentoServiceAPI.delete(id);
		} else {
			return new ResponseEntity<MedicamentoDTO>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<MedicamentoDTO>(medicamento, HttpStatus.OK);
	}
    
}
