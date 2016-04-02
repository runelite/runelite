import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ci")
public class class84 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -853930469
   )
   int field1429;
   @ObfuscatedName("s")
   static byte[][][] field1431;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1474402593
   )
   int field1432;
   @ObfuscatedName("k")
   public static short[][] field1433;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -602561021
   )
   int field1434;
   @ObfuscatedName("p")
   public static int[] field1437;

   @ObfuscatedName("cq")
   static String method1917(int var0) {
      return client.field426[var0].length() > 0?client.field425[var0] + " " + client.field426[var0]:client.field425[var0];
   }

   @ObfuscatedName("de")
   static String method1918(class173 var0) {
      return class170.method3363(class75.method1642(var0)) == 0?null:(null != var0.field2812 && var0.field2812.trim().length() != 0?var0.field2812:null);
   }
}
