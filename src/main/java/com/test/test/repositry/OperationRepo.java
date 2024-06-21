package com.test.test.repositry;

import com.test.test.entities.Operations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepo extends JpaRepository<Operations, Long> {
}
