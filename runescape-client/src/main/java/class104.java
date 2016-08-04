import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
@Implements("Tile")
public final class class104 extends class211 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 519576417
   )
   @Export("plane")
   int field1808;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -987515097
   )
   @Export("x")
   int field1809;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -304054191
   )
   @Export("y")
   int field1810;
   @ObfuscatedName("bw")
   static class171 field1811;
   @ObfuscatedName("h")
   class92 field1812;
   @ObfuscatedName("u")
   @Export("decorativeObject")
   class97 field1813;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -922709805
   )
   int field1814;
   @ObfuscatedName("q")
   @Export("objects")
   class101[] field1815 = new class101[5];
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1243058331
   )
   int field1816;
   @ObfuscatedName("b")
   @Export("itemLayer")
   class102 field1817;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2051549641
   )
   int field1818;
   @ObfuscatedName("k")
   @Export("wallObject")
   class90 field1819;
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
   class96 field1824;
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
   class104 field1830;
   @ObfuscatedName("z")
   boolean field1831;

   class104(int var1, int var2, int var3) {
      this.field1814 = this.field1808 = var1;
      this.field1809 = var2;
      this.field1810 = var3;
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "405539891"
   )
   static String method2382(int var0) {
      return client.field510[var0].length() > 0?client.field440[var0] + " " + client.field510[var0]:client.field440[var0];
   }
}
