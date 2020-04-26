package command;

public class Main {

	public static void main(String[] args) {
		RemoteController rController = new RemoteController();
		
		BookClass book_1 = new BookClass("Book1");
		BookClass book_2 = new BookClass("Book2");
		
		Command returnBook_1 = new ReturnBookCommand(book_1);
		Command returnBook_2 = new ReturnBookCommand(book_2);
		Command takeBook_1 = new TakeBookCommand(book_1);
		//Command takeBook_2 = new TakeBookCommand(book_2);
		
		rController.SetCommand(takeBook_1);
		rController.Execute();
		
		rController.SetCommand(takeBook_1);
		rController.Execute();
		
		rController.SetCommand(returnBook_1);
		rController.Execute();
			
		//rController.SetCommand(takeBook_2);
		//rController.Execute();
		
		rController.SetCommand(returnBook_2);
		rController.Execute();
	}

}
