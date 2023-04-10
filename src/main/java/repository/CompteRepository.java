package repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Compte;

public interface CompteRepository extends JpaRepository <Compte,Integer>{


	Optional <Compte> findById(Integer Id);
	//List <Compte> findByType(String type);

	/*@Query("select c from Compagnon c left join fetch c.maitre where c.id=:id")
	Optional<Compagnon> findByIdWithMaitre(@Param("id") Long id);*/


	@Transactional
	@Modifying
	@Query("delete Compte c where c.login=:login")
	void deleteByLogin(@Param("login") String login);
}
