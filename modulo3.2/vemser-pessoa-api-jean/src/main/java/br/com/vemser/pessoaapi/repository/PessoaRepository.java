package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.dto.PessoaRelatorioDTO;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    List<PessoaEntity> findAllByNomeContainsIgnoreCase(String nome);

    PessoaEntity findByCpf(String cpf);

    @Query(value = "select new br.com.vemser.pessoaapi.dto.PessoaRelatorioDTO(" +
            "p.idPessoa, " +
            "p.nome, " +
            "p.email, " +
            "c.numero, " +
            "e.cep, " +
            "e.cidade, " +
            "e.estado, " +
            "e.pais, " +
            "pE.nome" +
            ") " +
            "from PESSOA p " +
            "left join p.contatoEntities c " +
            "left join p.enderecoEntities e " +
            "left join p.petEntity pE ")
    List<PessoaRelatorioDTO> relatorioPessoa();
}
