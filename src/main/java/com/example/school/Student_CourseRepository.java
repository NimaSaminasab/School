package com.example.school;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Student_CourseRepository extends CrudRepository<Student_Course,Long>{


//    SELECT Orders.OrderID, Customers.CustomerName
//    FROM Orders
//    INNER JOIN Customers ON Orders.CustomerID = Customers.CustomerID;

    //Select *
    // from A a
    // left join
    // B b on a.id=b.id
    @Query("SELECT std_crs " +
            "FROM Course c " +
            "INNER JOIN Student_Course std_crs" +
            " ON c.id = std_crs.course.id"
    )
    List<Student_Course> getCoursesForStudent(long id) ;

}
