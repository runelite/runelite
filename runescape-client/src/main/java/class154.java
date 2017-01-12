import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public class class154 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1639610231
   )
   static int field2082 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1453803147
   )
   static int field2083 = 0;
   @ObfuscatedName("a")
   static byte[][] field2084 = new byte[1000][];
   @ObfuscatedName("f")
   static byte[][] field2085 = new byte[250][];
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1017875207
   )
   static int field2088 = 0;
   @ObfuscatedName("c")
   static byte[][] field2089 = new byte[50][];

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "-34"
   )
   static synchronized byte[] method2992(int var0) {
      byte[] var1;
      if(var0 == 100 && field2088 > 0) {
         var1 = field2084[--field2088];
         field2084[field2088] = null;
         return var1;
      } else if(var0 == 5000 && field2082 > 0) {
         var1 = field2085[--field2082];
         field2085[field2082] = null;
         return var1;
      } else if(var0 == 30000 && field2083 > 0) {
         var1 = field2089[--field2083];
         field2089[field2083] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }
}
