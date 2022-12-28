package com.te.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.ecommerce.entity.Authorities;
@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, String> {

}
