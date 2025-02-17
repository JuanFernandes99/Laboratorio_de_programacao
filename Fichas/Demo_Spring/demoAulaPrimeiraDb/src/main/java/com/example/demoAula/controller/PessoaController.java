package com.example.demoAula.controller;

import com.example.demoAula.utils.Wrapper;
import com.example.demoAula.dto.SimpleResponse;
import com.example.demoAula.dto.SimpleResponsePessoas;
import com.example.demoAula.model.Pessoa;
import com.example.demoAula.service.PessoaEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PessoaController {
	
	private final PessoaEmpresaService pessoaEmpresaService;

	@Autowired
	public PessoaController(PessoaEmpresaService aPessoaEmpresa_service) {

		pessoaEmpresaService = aPessoaEmpresa_service;
	}

	@GetMapping("/getPessoas")
	public List<Pessoa> getPessoas() {
		return pessoaEmpresaService.getPessoas();
	}

	@PostMapping("/addPessoaEmpresa")
	public ResponseEntity<SimpleResponse> addPessoa(@RequestBody Wrapper aWrapper) {
		SimpleResponse sr = new SimpleResponse();
		if (pessoaEmpresaService.addPessoaToEmpresa(aWrapper.getPessoa(), aWrapper.getEmpresa())) {
			sr.setAsSuccess("Pessoa adicionada a empresa");
			return ResponseEntity.status(HttpStatus.OK).body(sr);
		}
		return null;
	}
	
	@PostMapping(path = "/addPessoa")
	public ResponseEntity<SimpleResponse> addPessoas(@RequestBody Pessoa aPessoa) {
		SimpleResponsePessoas sr = new SimpleResponsePessoas();

		if (aPessoa.getIdade() <= 0) {
			sr.setMessage("Idade Tem Que Ser Superior a 0");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}

		if (aPessoa.getNome() == null || aPessoa.getNome().isBlank()) {
			sr.setMessage("Nome Invalido");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}

		if (aPessoa.getEmail() == null || aPessoa.getEmail().isBlank()) {
			sr.setMessage("Email Invalido");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}

		if (pessoaEmpresaService.addPessoa(aPessoa)) {
			sr.setAsSuccess("Pessoa Inserida Com Sucesso");
			sr.setPessoas(pessoaEmpresaService.getPessoas());
			return ResponseEntity.status(HttpStatus.OK).body(sr);

		} else {
			sr.setAsError("Erro ao inserir a Pessoa");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}

	}

	@DeleteMapping("/removePessoa/{aId}")
	public SimpleResponse removePessoa2(@PathVariable String aId) {
		SimpleResponse sr = new SimpleResponse();

		if (pessoaEmpresaService.removeEmpresa2(aId)) {
			sr.setAsSuccess("Pessoa Removida Com Sucesso");
		} else {
			sr.setAsError("Erro a Remover a Pessoa");
		}

		return sr;
	}

	@DeleteMapping("/removePessoa")
	public SimpleResponse removePessoa(@RequestBody Pessoa aPessoa) {
		SimpleResponsePessoas sr = new SimpleResponsePessoas();
		sr.setAsSuccess("Sucesso");

		if (pessoaEmpresaService.removePessoa(aPessoa)) {
			sr.setAsSuccess("Pessoa Removida Com Sucesso");
		} else {
			sr.setAsError("Erro a Remover a Pessoa");
		}

		return sr;
	}

	@PutMapping("/updatePessoa")
	public SimpleResponse updatePessoa(@RequestBody Pessoa aPessoa) {
		SimpleResponse sr = new SimpleResponse();

		if (aPessoa.getId() == null) {
			sr.setAsError("Id invalido");
			return sr;
		}

		if (aPessoa.getNome() == null || aPessoa.getNome().isBlank()) {
			sr.setAsError("Nome Invalido");
			return sr;
		}

		boolean suc = pessoaEmpresaService.updatePessoa(aPessoa);

		if (suc) {
			sr.setAsSuccess("Pessoa atualizada com sucesso");
		} else {
			sr.setAsError("Erro na atualização da pessoa " + aPessoa.getId());
		}
		return sr;

	}
}
