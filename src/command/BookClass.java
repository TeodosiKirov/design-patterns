package command;

public class BookClass {
	private String bookName;
	private boolean isTaken;
	
	BookClass(String bookName){
		this.bookName = bookName;
		this.isTaken = false;
	}
	
	public String GetBookName() {
		return this.bookName;
	}
	
	public void TakeBook() {
		if(this.isTaken == false) {
			System.out.println("You have taken " + this.bookName + "!\n");
			this.isTaken = true;
		}
		else {
			System.out.println(this.bookName + " is taken!\n");
		}
	}
	
	public void ReturnBook() {
		if(this.isTaken == true) {
			System.out.println("You have returned " + this.bookName + "\n");
			this.isTaken = false;	
		}
		else {
			System.out.println("You dont have " + this.bookName);
		}
		
	}
	

}
