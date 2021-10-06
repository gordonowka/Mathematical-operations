package pl.cinkciarz.mathematicaloperations.persistance.repository;

import pl.cinkciarz.mathematicaloperations.persistance.entity.MathematicalOperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MathematicalOperationsRepository extends JpaRepository<MathematicalOperationEntity, Long> {
}
