public class Player {
  private String color;

  public Player(String str) {
    color = str;
  }

  public String getColor(){
    return color;
  }

  public boolean isBlack() {
    if (color.equals("black")) {
      return true;
    }
    return false;
  }

  public boolean isWhite() {
    if (color.equals("white")) {
      return true;
    }
    return false;
  }
  
}
