package com.mtworek.dao;

import com.mtworek.model.Drivers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by mikolaj on 28.11.17.
 */

public interface ApplicationRepository extends CrudRepository<Drivers, Long> {

    List<Drivers> findByFirstName(String firstName);
    List<Drivers> findByAge(int age);


    // custom query example and return a stream
    @Query("select d from Drivers d where d.lastName = :lastName")
    Stream<Drivers> findByLastNameReturnStream(@Param("lastName") String lastName);

}