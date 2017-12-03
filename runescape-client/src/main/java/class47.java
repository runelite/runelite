import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class47 {
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
   public int field564;
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
   public class47(int var1, Coordinates var2, Coordinates var3) {
      this.field564 = var1;
      this.field565 = var2;
      this.field562 = var3;
   }
}
