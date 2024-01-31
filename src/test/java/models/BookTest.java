package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookTest {

	//G
	@Test
	public void test2EqualBooks()
	{
		Book book1 = new Book(1, "Title", "Author", "ISBN123", "Branch", 200);
		Book book2 = new Book(1, "Title", "Author", "ISBN123", "Branch", 200);

		// Assert that the books are equal
		assertEquals(book1, book2);
	}

	//G
	@Test
	public void test2NonEqualBooks()
	{
		Book book1 = new Book(1, "Title", "Author", "ISBN123", "Branch", 200);
		Book book2 = new Book(2, "Title", "Author", "ISBN123", "Branch", 200);

		// Assert that the books are equal
		assertNotEquals(book1, book2);
	}

}
