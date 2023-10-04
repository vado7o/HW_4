import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookRepoTest {

    @Test
    void testBookRepoFindBook() {
        BookRepository bookrepo = mock(BookRepository.class);

        when(bookrepo.findById(anyString())).thenReturn(new Book("a02x6", "Scherlock Holmes", "Conan Doyle"));

        BookService bookService = new BookService(bookrepo);

        assertEquals("a02x6", bookService.findBookById("x006").getId());
        assertEquals("Conan Doyle", bookService.findBookById("x006").getAuthor());
        assertEquals("Scherlock Holmes", bookService.findBookById("x006").getTitle());
    }

    @Test
    void testBookRepoFindAll() {
        BookRepository bookrepo = mock(BookRepository.class);

        when(bookrepo.findAll()).thenReturn(Arrays.asList(new Book("a02x6", "Scherlock Holmes", "Conan Doyle"),
                new Book("x0062t", "Tom Sawyer", "Mark Twain"), new Book("p004m5", "Captain's daughter", "Alexander Pushkin")));

        BookService bookService = new BookService(bookrepo);

        assertEquals("a02x6", bookService.findAllBooks().get(0).getId());
        assertEquals("Tom Sawyer", bookService.findAllBooks().get(1).getTitle());
        assertEquals("Alexander Pushkin", bookService.findAllBooks().get(2).getAuthor());


    }
}
