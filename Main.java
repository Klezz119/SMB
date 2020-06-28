import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static int Iloœæ_Filozofów = 6;
	public static int Laps = 5;

public static void main(String[] args) throws InterruptedException {
	List<Filozof> Filozofowie = new ArrayList<>();

    Stick F_Chopstick = new Stick(0);
    Stick P_Chopstick = F_Chopstick;
    
    for (int i = 1; i < Iloœæ_Filozofów; i++) {
      Stick nextChopstick = new Stick(i);
      Filozof philosopher = new Filozof("" + i, Laps, P_Chopstick, nextChopstick);
      Filozofowie.add(philosopher);
      P_Chopstick = nextChopstick;
    }

    // Last Philosopher
    Filozof ostatniFilozof = new Filozof("" + Iloœæ_Filozofów, Laps, P_Chopstick, F_Chopstick);

    List<Thread> ts = Filozofowie.stream()
        .map(Thread::new)
        .collect(Collectors.toList());

    ts.forEach(Thread::start);

    for (Thread t : ts) {
      t.join();
    }
    System.out.println("Wszyscy zakoñczyli jedzenie");
  
	
}
}
