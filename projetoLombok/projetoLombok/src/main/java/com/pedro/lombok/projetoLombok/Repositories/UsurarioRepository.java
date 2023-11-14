package com.pedro.lombok.projetoLombok.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedro.lombok.projetoLombok.Entities.*;

public interface UsurarioRepository extends JpaRepository<Usuario, Long>{
	
}