package mx.com.eglobal.calculator.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.eglobal.calculator.rest.dto.BinnacleEntity;

public interface BinnacleRepository extends JpaRepository<BinnacleEntity, Long>{
	
}
