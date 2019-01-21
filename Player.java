public class Player {
  private String color;

  public Player(String str) {
    color = str;
  }

  public String getColor(){
    return color;
  }

  //return true for black player
  public boolean isBlack() {
    if (color.equals("black")) {
      return true;
    }
    return false;
  }

  //return true for white player
  public boolean isWhite() {
    if (color.equals("white")) {
      return true;
    }
    return false;
  }
}
