package com.fiap.parquimetro.dominio.estacionamento.repository;


import com.fiap.parquimetro.dominio.estacionamento.entitie.Estacionamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstacionamentoRepository extends JpaRepository<Estacionamento,Long> {

}
