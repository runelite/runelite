import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 519576417
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -987515097
   )
   @Export("x")
   int x;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -304054191
   )
   @Export("y")
   int y;
   @ObfuscatedName("bw")
   static class171 field1811;
   @ObfuscatedName("h")
   class92 field1812;
   @ObfuscatedName("u")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -922709805
   )
   int field1814;
   @ObfuscatedName("q")
   @Export("objects")
   GameObject[] objects = new GameObject[5];
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1243058331
   )
   int field1816;
   @ObfuscatedName("b")
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2051549641
   )
   int field1818;
   @ObfuscatedName("k")
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("f")
   boolean field1820;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1979012297
   )
   int field1821 = 0;
   @ObfuscatedName("s")
   class100 field1822;
   @ObfuscatedName("d")
   boolean field1823;
   @ObfuscatedName("n")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("p")
   int[] field1825 = new int[5];
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 762769825
   )
   int field1826;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1389797947
   )
   int field1827;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 791915711
   )
   int field1828;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 393010145
   )
   int field1829;
   @ObfuscatedName("t")
   Tile field1830;
   @ObfuscatedName("z")
   boolean field1831;

   Tile(int var1, int var2, int var3) {
      this.field1814 = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "405539891"
   )
   static String method2382(int var0) {
      return Client.menuTargets[var0].length() > 0?Client.menuOptions[var0] + " " + Client.menuTargets[var0]:Client.menuOptions[var0];
   }
}
