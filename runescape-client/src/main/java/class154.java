import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
public class class154 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -834147339
   )
   static int field2100 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1215836129
   )
   static int field2101 = 0;
   @ObfuscatedName("k")
   static byte[][] field2102 = new byte[1000][];
   @ObfuscatedName("g")
   static byte[][] field2103 = new byte[250][];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1537782779
   )
   static int field2104 = 0;
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = -984409145
   )
   static int field2105;
   @ObfuscatedName("w")
   public static byte[][] field2106;
   @ObfuscatedName("n")
   static byte[][] field2107 = new byte[50][];

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IS)[B",
      garbageValue = "20862"
   )
   static synchronized byte[] method2945(int var0) {
      byte[] var1;
      if(var0 == 100 && field2101 > 0) {
         var1 = field2102[--field2101];
         field2102[field2101] = null;
         return var1;
      } else if(var0 == 5000 && field2100 > 0) {
         var1 = field2103[--field2100];
         field2103[field2100] = null;
         return var1;
      } else if(var0 == 30000 && field2104 > 0) {
         var1 = field2107[--field2104];
         field2107[field2104] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }
}
