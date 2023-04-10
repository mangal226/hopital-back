package repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Patient;


public interface PatientRepository extends JpaRepository <Patient, Integer> {
	
	
	Optional <Patient> findById(Integer Id);
	List<Patient> findByNom(String nom);

	@Transactional
	@Modifying
	@Query("update Patient p set p.prenom=:prenom2 where p.id=:id")
	void updatePatient(@Param("id") Integer id, @Param("prenom2") String prenom);

	@Transactional
	@Modifying
	@Query("delete Patient p where p.id=:id_patient")
	void deleteById(@Param("id_patient") Integer Id);
}


