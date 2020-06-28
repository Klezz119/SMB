import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Stick {
	private Filozof have;
	private int ID;
	private Lock lock = new ReentrantLock();
	  
	
	public Stick(int id) {
	    this.ID = id;
	}
	
	public int returnID() {
	    return ID;
	}

	public Filozof returnHave() {
	    return have;
	}
	  
	public void pick(Filozof philosopher) {
	    lock.lock();
	    have = philosopher;
	}

	public void putDown(Filozof philosopher) {
	    assert have == philosopher
	        : "Error";
	    have = null;
	    lock.unlock();
	}
}

