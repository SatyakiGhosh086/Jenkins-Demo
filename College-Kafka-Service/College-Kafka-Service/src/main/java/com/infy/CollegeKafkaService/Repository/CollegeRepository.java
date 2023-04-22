package com.infy.CollegeKafkaService.Repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.CollegeKafkaService.Entity.KafkaCollege;

public interface CollegeRepository extends CrudRepository<KafkaCollege,Integer> 
{

}
