package com.mayuran19.datasourceconfig.repository;

import com.mayuran19.datasourceconfig.domain.SomeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SomeRepository extends JpaRepository<SomeTable, Long> {
    @Query(nativeQuery = true, value = "select current_setting('app.current_user_id', true)")
    public String getCurrentUser();
}
