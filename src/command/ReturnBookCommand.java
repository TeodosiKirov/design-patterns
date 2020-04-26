package command;

public class ReturnBookCommand implements Command{
	
	BookClass book;
	
	ReturnBookCommand(BookClass book){
		this.book = book;
	}
	
	@Override
	public void execute() {
		System.out.println("You returned " + this.book.GetBookName());
		this.book.ReturnBook();
		
}
	
}
