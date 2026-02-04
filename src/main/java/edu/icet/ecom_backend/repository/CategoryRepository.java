package edu.icet.ecom_backend.repository;

import edu.icet.ecom_backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<edu.icet.ecom_backend.model.Category, Long> {

}
