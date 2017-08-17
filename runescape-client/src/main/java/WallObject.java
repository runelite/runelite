import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("ev")
   @ObfuscatedSignature(
      signature = "Lea;"
   )
   static Task field2130;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1962379383
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1956735527
   )
   @Export("config")
   int config;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1617900715
   )
   @Export("x")
   int x;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Leq;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -389123369
   )
   @Export("y")
   int y;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 123758765
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Leq;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -99362331
   )
   @Export("orientationA")
   int orientationA;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1432137627
   )
   @Export("orientationB")
   int orientationB;

   WallObject() {
      this.hash = 0;
      this.config = 0;
   }
}
