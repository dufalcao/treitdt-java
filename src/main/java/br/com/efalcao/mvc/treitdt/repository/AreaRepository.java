package br.com.efalcao.mvc.treitdt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.efalcao.mvc.treitdt.model.Area;


@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {
	
}



