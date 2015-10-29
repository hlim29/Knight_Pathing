import java.util.LinkedList;


public class Move {

	
	private Square prev;
	private Square next;
	
	public Move(Square prev, Square next) {
		this.prev = prev;
		this.next = next;
	}
	
	@Override
	public String toString(){
		return prev.toString() + ">" + next.toString();
	}

	public Square getPrev() {
		return prev;
	}

	public Square getNext() {
		return next;
	}
	
	
}
