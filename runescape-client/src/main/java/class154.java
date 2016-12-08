import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public class class154 {
   @ObfuscatedName("v")
   static byte[][] field2111 = new byte[50][];
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 647830699
   )
   static int field2113 = 0;
   @ObfuscatedName("g")
   static byte[][] field2114 = new byte[1000][];
   @ObfuscatedName("h")
   static byte[][] field2115 = new byte[250][];
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 563494539
   )
   static int field2116 = 0;
   @ObfuscatedName("mk")
   static SpritePixels field2118;
   @ObfuscatedName("ie")
   static class38 field2120;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 641607123
   )
   static int field2121 = 0;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "90"
   )
   static synchronized byte[] method2929(int var0) {
      byte[] var1;
      if(var0 == 100 && field2116 > 0) {
         var1 = field2114[--field2116];
         field2114[field2116] = null;
         return var1;
      } else if(var0 == 5000 && field2121 > 0) {
         var1 = field2115[--field2121];
         field2115[field2121] = null;
         return var1;
      } else if(var0 == 30000 && field2113 > 0) {
         var1 = field2111[--field2113];
         field2111[field2113] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }
}
