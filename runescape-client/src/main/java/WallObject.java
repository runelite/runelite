import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1062312009
   )
   @Export("x")
   int x;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1031328835
   )
   @Export("y")
   int y;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -558190651
   )
   int field1570;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1601799597
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("g")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("m")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2135688295
   )
   int field1574 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1383415985
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 2057334241
   )
   int field1576;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-348068628"
   )
   public static boolean method2077(char var0) {
      return var0 >= 48 && var0 <= 57;
   }
}
