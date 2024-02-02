package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import utilities.GenderType;

import java.time.LocalDate;

public class LoanTest {
	//VG
	@Test
	public void testDueDate()
	{
		Customer customer = new Customer("Mr", "Michael", "Smith", "1 The High Street","1234","a@b.com",1, GenderType.MALE);
		Book book1 = new Book(1,"An introduction to Java","Matt Greencroft","12345","Anytown Branch", 400);
		Loan loan = new Loan(1,customer,book1);

		assertEquals(LocalDate.now().plusDays(14), loan.getDueDate());
    }
}