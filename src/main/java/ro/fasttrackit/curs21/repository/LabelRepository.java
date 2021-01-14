package ro.fasttrackit.curs21.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.curs21.model.Label;

public interface LabelRepository extends JpaRepository<Label, Integer> {
}
