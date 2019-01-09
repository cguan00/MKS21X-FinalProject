public class Player {
  private String Pcolor;

  public Player(String str) {
    Pcolor = str;
  }

  public String getColor(){
    return Pcolor;
  }

  public boolean isBlack() {
    if (Pcolor.equals("black")) {
      return true;
    }
    return false;
  }

  public boolean isWhite() {
    if (Pcolor.equals("white")) {
      return true;
    }
    return false;
  }

}
