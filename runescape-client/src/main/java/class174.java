import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class174 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 566988177
   )
   static int field2414;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1051171635
   )
   static int field2412;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1283661919
   )
   static int field2417;
   @ObfuscatedName("p")
   static byte[][] field2415;
   @ObfuscatedName("q")
   static byte[][] field2416;
   @ObfuscatedName("s")
   static byte[][] field2413;
   @ObfuscatedName("g")
   static byte[][][] field2411;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = 829749175
   )
   @Export("cameraYaw")
   static int cameraYaw;

   static {
      field2414 = 0;
      field2412 = 0;
      field2417 = 0;
      field2415 = new byte[1000][];
      field2416 = new byte[250][];
      field2413 = new byte[50][];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "28"
   )
   static synchronized byte[] method3463(int var0) {
      byte[] var1;
      if(var0 == 100 && field2414 > 0) {
         var1 = field2415[--field2414];
         field2415[field2414] = null;
         return var1;
      } else if(var0 == 5000 && field2412 > 0) {
         var1 = field2416[--field2412];
         field2416[field2412] = null;
         return var1;
      } else if(var0 == 30000 && field2417 > 0) {
         var1 = field2413[--field2417];
         field2413[field2417] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }
}
