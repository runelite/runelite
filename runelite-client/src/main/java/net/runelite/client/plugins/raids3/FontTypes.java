package net.runelite.client.plugins.raids3;

public enum FontTypes {
  REGULAR("RS Regular"),
  ARIAL("Arial"),
  CAMBRIA("Cambria"),
  ROCKWELL("Rockwell"),
  SEGOE_UI("Segoe Ui"),
  TIMES_NEW_ROMAN("Times New Roman"),
  VERDANA("Verdana");

  private final String name;

  public String toString() {
    return this.name;
  }

  private FontTypes(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
}