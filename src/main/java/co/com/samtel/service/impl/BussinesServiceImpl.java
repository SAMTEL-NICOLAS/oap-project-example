package co.com.samtel.service.impl;

import org.springframework.stereotype.Service;

import co.com.samtel.service.BussinesService;

@Service
public class BussinesServiceImpl implements BussinesService {

	@Override
	public String getSaludo(String name) {
		return name.concat(" es el mas aspero");
	}

	@Override
	public String testExecution(String nombre) {
		return nombre.concat(" ejecucion del metodo");
	}

}
