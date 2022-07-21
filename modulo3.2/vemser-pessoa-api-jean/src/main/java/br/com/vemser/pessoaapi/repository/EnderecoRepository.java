package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

    @Query("select e from ENDERECO_PESSOA e where e.pais = :pais")
    List<EnderecoEntity> enderecoByPais(@Param("pais") String pais);

    @Query("select e from ENDERECO_PESSOA e join e.pessoaEntities p where p.idPessoa = :idPessoa")
    List<EnderecoEntity> enderecoByIdPessoa(@Param("idPessoa") Integer idPessoa);
}
