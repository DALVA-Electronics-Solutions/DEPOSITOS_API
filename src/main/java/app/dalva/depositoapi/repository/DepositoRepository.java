package app.dalva.depositoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.dalva.depositoapi.model.entity.DepositoEntity;

@Repository
public interface DepositoRepository extends JpaRepository<DepositoEntity, Long> {
}
