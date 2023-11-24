package net.runelite.client.plugins.raids3.Akkha.ButterflyTech;

import java.util.List;

public class ButterflyTechRegion {
  private List<ButterflyTechTile> butterflyTechTileList;
  private ButterflyTechTile startingTile;
  public int index = 0;

  public ButterflyTechRegion(List<ButterflyTechTile> butterflyTechTileList, ButterflyTechTile startingTile) {
    this.setButterflyTechTileList(butterflyTechTileList);
    this.setStartingTile(startingTile);
  }

  public ButterflyTechRegion() {
    this.setButterflyTechTileList((List)null);
    this.setStartingTile((ButterflyTechTile)null);
  }

  public List<ButterflyTechTile> getButterflyTechTileList() {
    return this.butterflyTechTileList;
  }

  public void setButterflyTechTileList(List<ButterflyTechTile> butterflyTechTileList) {
    this.butterflyTechTileList = butterflyTechTileList;
  }

  public ButterflyTechTile getStartingTile() {
    return this.startingTile;
  }

  public void setStartingTile(ButterflyTechTile startingTile) {
    this.startingTile = startingTile;
  }

  public int getIndex() {
    return this.index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public void IncIndex() {
    ++this.index;
    if (this.index >= this.butterflyTechTileList.size()) {
      this.index = 0;
    }

  }
}