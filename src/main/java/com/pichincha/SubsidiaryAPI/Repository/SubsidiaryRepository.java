package com.pichincha.SubsidiaryAPI.Repository;
import com.pichincha.SubsidiaryAPI.Model.Subsidiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubsidiaryRepository extends JpaRepository<Subsidiary,Integer> {
}
