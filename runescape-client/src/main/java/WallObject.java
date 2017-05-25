import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eo")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2103463111
   )
   @Export("x")
   int x;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1115958401
   )
   @Export("y")
   int y;
   @ObfuscatedName("t")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("v")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1459753793
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1994299827
   )
   int field2112;
   @ObfuscatedName("n")
   public static String field2113;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -486196087
   )
   int field2114;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -53257687
   )
   int field2115;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -243348171
   )
   @Export("floor")
   int floor;

   WallObject() {
      this.hash = 0;
      this.field2112 = 0;
   }
}
