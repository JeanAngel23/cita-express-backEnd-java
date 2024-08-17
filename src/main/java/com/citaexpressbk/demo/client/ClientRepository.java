package com.citaexpressbk.demo.client;

import com.citaexpressbk.demo.domain.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository <Client, Long>{

    Page<Client> findByStatusTrue(Pageable pageable);

}
