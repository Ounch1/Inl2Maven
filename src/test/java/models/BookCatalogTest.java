package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class  BookCatalogTest {

	private BookCatalog bc;
	private Book book1;

	public BookCatalogTest() {
		bc = new BookCatalog();
		Book book1 = new Book(1,"Learning Java","","","",0);
		bc.addBook(book1);
	}

	//G
	@Test
	public void testAddABook()
	{
		BookCatalog catalog = new BookCatalog();
		Book testBook = new Book(1, "Test Book", "Test Author", "1234567890", "Test Branch", 200);

		catalog.addBook(testBook);
		Book[] bookArray = catalog.getBookArray();
		assertEquals(testBook, bookArray[0]);
	}

	//G
	@Test
	public void testFindBook() {
		BookCatalog catalog = new BookCatalog();
		catalog.addBook(new Book(1, "Test Book", "Test Author", "1234567890", "Test Branch", 200));
		try {
			Book foundBook = catalog.findBook("Test Book");
			assertNotNull(foundBook);
			assertEquals("Test Book", foundBook.getTitle());
		} catch (BookNotFoundException e) {
			fail("BookNotFoundException should not be thrown");
		}
	}

	//G
	@Test
	public void testFindBookIgnoringCase()
	{
		BookCatalog catalog = new BookCatalog();
		catalog.addBook(new Book(1, "Test Book", "Test Author", "1234567890", "Test Branch", 200));
		try {
			Book foundBook = catalog.findBook("tEsT bOoK");
			assertNotNull(foundBook);
			assertEquals("Test Book", foundBook.getTitle());
		} catch (BookNotFoundException e) {
			fail("BookNotFoundException should not be thrown");
		}
	}

	//G
	@Test
	public void testFindBookWithExtraSpaces()
	{
		BookCatalog catalog = new BookCatalog();
		catalog.addBook(new Book(1, "Test Book", "Test Author", "1234567890", "Test Branch", 200));
		try {
			Book foundBook = catalog.findBook(" Test Book" );
			assertNotNull(foundBook);
			assertEquals("Test Book", foundBook.getTitle());
		} catch (BookNotFoundException e) {
			fail("BookNotFoundException should not be thrown");
		}
	}

	//VG
	// This test should throw BookNotFoundException in order to pass.
	@Test
	public void testFindBookThatDoesntExist()
	{
		BookCatalog catalog = new BookCatalog();

		assertThrows(BookNotFoundException.class, () ->
		{
			catalog.findBook("Nonexistent Book");
		});
	}
}
