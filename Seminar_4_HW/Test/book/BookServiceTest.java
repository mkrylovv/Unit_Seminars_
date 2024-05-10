package book;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Test
    public void testFindByBookId() {
        BookRepository mockBookRepository = mock(BookRepository.class);
        when(mockBookRepository.findById("111")).thenReturn(new Book("111", "Harry Potter and the philosopher's stone", "J.K.Rowling"));
        BookService bookService = new BookService(mockBookRepository);
        Book result = bookService.findBookById("111");
        assertEquals("Harry Potter and the philosopher's stone", result.getTitle());
        assertEquals("J.K.Rowling", result.getAuthor());
    }

    @Test
    public void testFindAllBooks() {
        Book book1 = new Book("111", "Harry Potter and the philosopher's stone", "J.K.Rowling");
        Book book2 = new Book("222", "Harry Potter and the chamber of secrets", "Joanne Rowling");
        BookRepository mockBookRepository = mock(BookRepository.class);
        when(mockBookRepository.findAll()).thenReturn(List.of(book1, book2));
        BookService bookService = new BookService(mockBookRepository);
        List<Book> result = bookService.findAllBooks();

        assertEquals(2, result.size());
        assertEquals("Harry Potter and the philosopher's stone", result.get(0).getTitle());
        assertEquals("J.K.Rowling", result.get(0).getAuthor());
        assertEquals("Harry Potter and the chamber of secrets", result.get(1).getTitle());
        assertEquals("Joanne Rowling", result.get(1).getAuthor());
    }
}