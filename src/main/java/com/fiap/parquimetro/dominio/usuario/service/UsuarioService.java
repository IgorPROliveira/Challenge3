package com.fiap.parquimetro.dominio.usuario.service;


import com.fiap.parquimetro.dominio.usuario.dto.request.UsuarioRequestDTO;
import com.fiap.parquimetro.dominio.usuario.dto.response.UsuarioDTO;
import com.fiap.parquimetro.dominio.usuario.dto.response.UsuarioInformacaoDTO;
import com.fiap.parquimetro.dominio.usuario.entitie.Usuario;
import com.fiap.parquimetro.dominio.usuario.repository.IUsuarioRepository;
import com.fiap.parquimetro.exception.service.DatabaseException;
import com.fiap.parquimetro.exception.service.ServiceNotFoundedException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class UsuarioService {

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Transactional
    public UsuarioDTO save(UsuarioRequestDTO dto) {
        var entity = dto.toEntity();
        var enderecoSaved = usuarioRepository.save(entity);
        return enderecoSaved.ToUsuarioDTO();
    }

    @Transactional(readOnly = true)
    public Page<UsuarioInformacaoDTO> findAll(PageRequest pageRequest) {
        var usuarios = usuarioRepository.findAll(pageRequest);
        return  usuarios.map(Usuario::ToUsuarioInformacaoDTO);
    }

    @Transactional
    public UsuarioDTO update(Long id, UsuarioRequestDTO dto) {
        try {
            Usuario entity = usuarioRepository.getReferenceById(id);
            dto.ToMapperEntity(entity);

            var enderecoSaved = usuarioRepository.save(entity);
            return enderecoSaved.ToUsuarioDTO();

        }  catch (EntityNotFoundException e) {
            throw new ServiceNotFoundedException("Usuario não encontrado, id: " + id);
        }
    }

    @Transactional
    public void delete(Long id)  {
        try {
            usuarioRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação de integridade dos dados");
        }
    }

//    @Transactional(readOnly = true)
//    public UsuarioPessoaDTO findById(Long id) {
//        var usuario = usuarioRepository.findById(id).orElseThrow(
//                () -> new ServiceNotFoundedException("Usuario não encontrado")
//        );
//        return usuario.ToUsuarioPessoaDTO();
//    }

    @Transactional(readOnly = true)
    public ResponseEntity<UsuarioInformacaoDTO> findById(Long id) {
        var usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get().ToUsuarioInformacaoDTO());
        }
        return ResponseEntity.notFound().build();
    }

}
