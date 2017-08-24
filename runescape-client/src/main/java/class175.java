import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public class class175 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1290784719
   )
   static int field2403;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 987447605
   )
   static int field2399;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1838908245
   )
   static int field2405;
   @ObfuscatedName("r")
   static byte[][] field2398;
   @ObfuscatedName("o")
   static byte[][] field2401;
   @ObfuscatedName("n")
   static byte[][] field2402;
   @ObfuscatedName("fg")
   @Export("landRegionFielIds")
   static int[] landRegionFielIds;

   static {
      field2403 = 0;
      field2399 = 0;
      field2405 = 0;
      field2398 = new byte[1000][];
      field2401 = new byte[250][];
      field2402 = new byte[50][];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1421283812"
   )
   static synchronized byte[] method3452(int var0) {
      byte[] var1;
      if(var0 == 100 && field2403 > 0) {
         var1 = field2398[--field2403];
         field2398[field2403] = null;
         return var1;
      } else if(var0 == 5000 && field2399 > 0) {
         var1 = field2401[--field2399];
         field2401[field2399] = null;
         return var1;
      } else if(var0 == 30000 && field2405 > 0) {
         var1 = field2402[--field2405];
         field2402[field2405] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-14"
   )
   public static void method3454() {
      Varbit.varbits.reset();
   }
}
