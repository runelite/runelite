import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class161 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -933018755
   )
   static int field2297 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1247931529
   )
   static int field2298 = 0;
   @ObfuscatedName("h")
   static byte[][] field2299 = new byte[1000][];
   @ObfuscatedName("w")
   static byte[][] field2300 = new byte[250][];
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 20660487
   )
   static int field2301 = 0;
   @ObfuscatedName("r")
   static byte[][] field2304 = new byte[50][];

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "600230293"
   )
   static synchronized byte[] method3187(int var0) {
      byte[] var1;
      if(var0 == 100 && field2297 > 0) {
         var1 = field2299[--field2297];
         field2299[field2297] = null;
         return var1;
      } else if(var0 == 5000 && field2301 > 0) {
         var1 = field2300[--field2301];
         field2300[field2301] = null;
         return var1;
      } else if(var0 == 30000 && field2298 > 0) {
         var1 = field2304[--field2298];
         field2304[field2298] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "6"
   )
   public static boolean method3188() {
      return class138.field1917 != 0?true:class138.field1919.method2557();
   }
}
