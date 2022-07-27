package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.UsuarioCreateDTO;
import br.com.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.vemser.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;
    private final PasswordEncoder passwordEncoder;

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public UsuarioEntity saveUsuario(UsuarioCreateDTO usuarioCreateDTO) {
        UsuarioEntity usuarioEntity = creteToEntity(usuarioCreateDTO);
        encodePassword(usuarioEntity);
        return usuarioRepository.save(usuarioEntity);
    }

    public UsuarioEntity creteToEntity(UsuarioCreateDTO usuarioCreateDTO){
        return objectMapper.convertValue(usuarioCreateDTO, UsuarioEntity.class);
    }

    public void encodePassword(UsuarioEntity usuarioEntity){
        usuarioEntity.setSenha(passwordEncoder.encode(usuarioEntity.getPassword()));
    }
}
