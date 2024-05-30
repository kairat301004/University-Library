package kg.megalab.universitylibrary.repository;

import kg.megalab.universitylibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
