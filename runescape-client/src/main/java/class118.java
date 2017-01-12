import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
public class class118 {
   @ObfuscatedName("a")
   static int[][] field1826 = new int[128][128];
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1149324909
   )
   static int field1827;
   @ObfuscatedName("l")
   static int[] field1828 = new int[4096];
   @ObfuscatedName("g")
   static int[] field1829 = new int[4096];
   @ObfuscatedName("hi")
   @ObfuscatedGetter(
      intValue = 450718923
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("mh")
   static byte field1831;
   @ObfuscatedName("i")
   static int[][] field1834 = new int[128][128];

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-183684210"
   )
   static final boolean method2269(char var0) {
      return var0 == 160 || var0 == 32 || var0 == 95 || var0 == 45;
   }
}
