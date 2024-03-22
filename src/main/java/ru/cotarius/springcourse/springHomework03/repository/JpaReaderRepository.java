package ru.cotarius.springcourse.springHomework03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cotarius.springcourse.springHomework03.model.Reader;

public interface JpaReaderRepository extends JpaRepository<Reader, Long> {
}
