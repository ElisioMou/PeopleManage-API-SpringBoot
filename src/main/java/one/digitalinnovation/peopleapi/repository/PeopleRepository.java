package one.digitalinnovation.peopleapi.repository;

import one.digitalinnovation.peopleapi.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Long> {
}
