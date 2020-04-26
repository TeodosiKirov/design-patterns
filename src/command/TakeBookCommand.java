package command;

public class TakeBookCommand implements Command {
	
    BookClass book;
	
	TakeBookCommand(BookClass book){
		this.book = book;
	}

	@Override
	public void execute() {
		System.out.println("You tried taking " + this.book.GetBookName() );
		this.book.TakeBook();
		
	}

}
