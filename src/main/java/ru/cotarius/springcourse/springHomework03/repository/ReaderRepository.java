package ru.cotarius.springcourse.springHomework03.repository;

import lombok.Data;
import org.springframework.stereotype.Repository;
import ru.cotarius.springcourse.springHomework03.model.Reader;

import java.util.ArrayList;
import java.util.List;

@Data
@Repository
public class ReaderRepository {
    private final List<Reader> readers = new ArrayList<>();

    {
        readers.add(new Reader("Константин", "Хабенский"));
        readers.add(new Reader("Евгений", "Миронов"));
        readers.add(new Reader("Владимир", "Машков"));
        readers.add(new Reader("Светлана", "Ходченкова"));
        readers.add(new Reader("Александр", "Балуев"));
    }

    public Reader getById(long id){
        return readers.stream().filter(reader -> reader.getId() == id).findFirst().orElse(null);
    }
}
