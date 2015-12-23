package com.atrinet.domain.repository;

import com.atrinet.domain.model.SecurityUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by AFomin on 7/5/2015.
 */
public interface SecurityUserRepository extends JpaRepository<SecurityUser, Long> {
}
