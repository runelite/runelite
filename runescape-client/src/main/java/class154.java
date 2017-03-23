import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
public class class154 {
   @ObfuscatedName("h")
   static byte[][] field2116 = new byte[1000][];
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 648662175
   )
   static int field2117 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2027277139
   )
   static int field2118 = 0;
   @ObfuscatedName("r")
   static byte[][] field2119 = new byte[250][];
   @ObfuscatedName("o")
   static byte[][] field2121 = new byte[50][];
   @ObfuscatedName("d")
   static Widget field2123;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1328146445
   )
   static int field2127 = 0;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-890980205"
   )
   static synchronized byte[] method3067(int var0) {
      byte[] var1;
      if(var0 == 100 && field2118 > 0) {
         var1 = field2116[--field2118];
         field2116[field2118] = null;
         return var1;
      } else if(var0 == 5000 && field2117 > 0) {
         var1 = field2119[--field2117];
         field2119[field2117] = null;
         return var1;
      } else if(var0 == 30000 && field2127 > 0) {
         var1 = field2121[--field2127];
         field2121[field2127] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   class154() throws Throwable {
      throw new Error();
   }
}
