package com.dp3.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dp3.service.UsuarioService;

@Controller
@RequestMapping("/user")
public class UsuarioController {
	
//	private static final Log LOGGER = LogFactory.getLog(UsuarioController.class);
	
	UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService service) {
		usuarioService = service;
	}
	
//	@RequestMapping(value = "/{idUser}", method = RequestMethod.GET)
//	public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable("idUser") Integer id) {
//		LOGGER.debug("Recuperamos el usuario por ID: " + id);
//		Usuario user = (Usuario) usuarioService.loadUserByUsername(String.valueOf(id));
//		return new ResponseEntity<UsuarioDTO>(UsuarioTranslator.getUsuarioDTO(user), HttpStatus.OK);
//	}
	
//	@RequestMapping(path="/modificar", method=RequestMethod.POST, consumes="application/json")
//	@ResponseBody
//	public ResponseEntity<UsuarioDTO> actualizarUsuario(@RequestBody UsuarioDTO dto) throws UsuarioException {
//		Usuario esteUsuario = (Usuario) usuarioService.loadUserByUsername(String.valueOf(dto.getUf()));
//		Usuario usuario = usuarioService.modificarUsuario(esteUsuario, dto);
//		return new ResponseEntity<UsuarioDTO>(UsuarioTranslator.getUsuarioDTO(usuario), HttpStatus.ACCEPTED);
//	}
}