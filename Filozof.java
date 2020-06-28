

import java.util.Random;

public class Filozof implements Runnable{

  private String name;
  private final Stick leftStick;
  private final Stick rightStick;
  private int lap = 0;

  
  private final int eatUntil;
  public Filozof(String name, int eatUntil, Stick leftStick, Stick rightStick) {
    this.name = name;
    this.eatUntil = eatUntil;
    this.leftStick = leftStick;
    this.rightStick = rightStick;
  }

  public String returnName() {
    return name;
  }

  public void run() {
	  Random random = new Random();
	  while (lap < eatUntil) {

      System.out.println("Filozof :" + name + " rozmyœla");
      	try {
      			Thread.sleep(random.nextInt(2000));
      		} catch (InterruptedException e) {
      			e.printStackTrace();
      		}
      Stick firstChopstick = leftStick.returnID() < rightStick.returnID()
          ? leftStick : rightStick;
      Stick secondChopstick = leftStick.returnID() < rightStick.returnID()
          ? rightStick : leftStick;
      firstChopstick.pick(this);
      secondChopstick.pick(this);

      System.out.println("Filozof :" + name + " spo¿ywa posi³ek");
      lap++;

      secondChopstick.putDown(this);
      firstChopstick.putDown(this);
    }
    System.out.println("Filozof :" + name + " ### zakoñczy³ jedzenie ###");
  }
}