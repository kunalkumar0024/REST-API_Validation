package com.kunal.FindCollege.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kunal.FindCollege.entity.College;
@Repository
public interface CollegeRepository extends CrudRepository<College,String> {

}
