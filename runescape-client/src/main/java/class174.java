import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class174 {
   @ObfuscatedName("s")
   static byte[][] field2407;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1330271353
   )
   static int field2408;
   @ObfuscatedName("r")
   static byte[][] field2409;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1941390237
   )
   static int field2410;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1509340203
   )
   static int field2411;
   @ObfuscatedName("t")
   static byte[][] field2412;
   @ObfuscatedName("pd")
   @ObfuscatedGetter(
      intValue = -1107876773
   )
   static int field2414;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "655606343"
   )
   static synchronized byte[] method3342(int var0) {
      byte[] var1;
      if(var0 == 100 && field2410 > 0) {
         var1 = field2412[--field2410];
         field2412[field2410] = null;
         return var1;
      } else if(var0 == 5000 && field2408 > 0) {
         var1 = field2407[--field2408];
         field2407[field2408] = null;
         return var1;
      } else if(var0 == 30000 && field2411 > 0) {
         var1 = field2409[--field2411];
         field2409[field2411] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   static {
      field2410 = 0;
      field2408 = 0;
      field2411 = 0;
      field2412 = new byte[1000][];
      field2407 = new byte[250][];
      field2409 = new byte[50][];
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2135579352"
   )
   public static void method3343(int var0) {
      class203.field2508 = 1;
      class61.field785 = null;
      class203.field2511 = -1;
      class203.field2512 = -1;
      class203.field2513 = 0;
      class203.field2515 = false;
      class203.field2517 = var0;
   }
}
