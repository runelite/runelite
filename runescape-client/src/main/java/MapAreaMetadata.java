import net.runelite.mapping.*;

@ObfuscatedName("aa")
@Implements("MapAreaMetadata")
public class MapAreaMetadata {
   @ObfuscatedName("ef")
   @ObfuscatedSignature(
      signature = "Lev;"
   )
   static Task field560;
   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "Lks;"
   )
   @Export("mapedge")
   static SpritePixels mapedge;
   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   static Widget field566;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 469268205
   )
   @Export("mapAreaTypeArrayIndex")
   public int mapAreaTypeArrayIndex;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   public Coordinates field565;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   public Coordinates field562;

   @ObfuscatedSignature(
      signature = "(ILhc;Lhc;)V"
   )
   public MapAreaMetadata(int var1, Coordinates var2, Coordinates var3) {
      this.mapAreaTypeArrayIndex = var1;
      this.field565 = var2;
      this.field562 = var3;
   }
}
