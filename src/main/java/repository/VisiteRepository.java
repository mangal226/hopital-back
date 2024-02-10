package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Medecin;
import model.Visite;
import org.springframework.transaction.annotation.Transactional;

public interface VisiteRepository extends JpaRepository<Visite, Integer>{
	Optional <Visite> findById(Integer Id);
	List<Visite> findByMedecin(Medecin medecin);

	/*@Transactional
	@Modifying
	@Query("update Patient p set p.prenom=:prenom2 where c.id_patient=:id")
	void updateVisite(@Param("id") Integer id, @Param("prenom2") String prenom);*/

	@Transactional
	@Modifying
	@Query("delete Patient p where p.id=:id_patient")
	void deleteById(@Param("id_patient") Integer Id);

}
