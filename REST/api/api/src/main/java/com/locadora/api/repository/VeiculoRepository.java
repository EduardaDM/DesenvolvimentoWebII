package com.locadora.api.repository;

import com.locadora.api.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VeiculoRepository  extends JpaRepository<Veiculo, Long> {

    //buscar por modelo - extra
    List<Veiculo> findByModeloContaining(String modelo);

    //select buscar veiculos mais baratos
    List<Veiculo> findByValorDiariaLessThan(Double valor);

}
