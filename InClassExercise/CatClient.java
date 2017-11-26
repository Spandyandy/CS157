public class CatClient {
  public static void main (String[] args) {
    Cat c = new Cat(args[0]);
    c.readAndEcho();
  }
}