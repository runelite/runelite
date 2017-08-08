import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public class class175 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1240785229
   )
   static int field2389;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2135637413
   )
   static int field2392;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1072362693
   )
   static int field2388;
   @ObfuscatedName("y")
   static byte[][] field2387;
   @ObfuscatedName("w")
   static byte[][] field2386;
   @ObfuscatedName("k")
   static byte[][] field2391;

   static {
      field2389 = 0;
      field2392 = 0;
      field2388 = 0;
      field2387 = new byte[1000][];
      field2386 = new byte[250][];
      field2391 = new byte[50][];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)Liv;",
      garbageValue = "1"
   )
   public static CombatInfo2 method3381(int var0) {
      CombatInfo2 var1 = (CombatInfo2)CombatInfo2.field3362.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = CombatInfo2.field3357.getConfigData(33, var0);
         var1 = new CombatInfo2();
         if(var2 != null) {
            var1.method4410(new Buffer(var2));
         }

         CombatInfo2.field3362.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "-106"
   )
   static synchronized byte[] method3379(int var0) {
      byte[] var1;
      if(var0 == 100 && field2389 > 0) {
         var1 = field2387[--field2389];
         field2387[field2389] = null;
         return var1;
      } else if(var0 == 5000 && field2392 > 0) {
         var1 = field2386[--field2392];
         field2386[field2392] = null;
         return var1;
      } else if(var0 == 30000 && field2388 > 0) {
         var1 = field2391[--field2388];
         field2391[field2388] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)I",
      garbageValue = "40"
   )
   public static int method3377(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0 - (var3 - 1):7 - var1 - (var4 - 1)));
   }
}
