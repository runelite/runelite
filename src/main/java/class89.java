import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
public final class class89 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 109674557
   )
   int field1555;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1096721585
   )
   int field1556;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 513684937
   )
   int field1557;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 731105553
   )
   int field1558;
   @ObfuscatedName("y")
   boolean field1559 = true;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 385800311
   )
   int field1560;
   @ObfuscatedName("ch")
   static class224 field1561;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1591301983
   )
   int field1565;

   class89(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1557 = var1;
      this.field1555 = var2;
      this.field1556 = var3;
      this.field1565 = var4;
      this.field1558 = var5;
      this.field1560 = var6;
      this.field1559 = var7;
   }

   @ObfuscatedName("w")
   public static int method2075(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(0 != var1) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "121"
   )
   static void method2076(int var0, int var1, int var2, int var3) {
      class15 var4 = (class15)class15.field234.method3806((long)var0);
      if(null == var4) {
         var4 = new class15();
         class15.field234.method3807(var4, (long)var0);
      }

      if(var4.field228.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.field228.length; ++var7) {
            var5[var7] = var4.field228[var7];
            var6[var7] = var4.field229[var7];
         }

         for(var7 = var4.field228.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.field228 = var5;
         var4.field229 = var6;
      }

      var4.field228[var1] = var2;
      var4.field229[var1] = var3;
   }

   @ObfuscatedName("n")
   static final byte[] method2077(byte[] var0) {
      class119 var1 = new class119(var0);
      int var2 = var1.method2506();
      int var3 = var1.method2511();
      if(var3 >= 0 && (0 == class167.field2704 || var3 <= class167.field2704)) {
         if(var2 == 0) {
            byte[] var6 = new byte[var3];
            var1.method2531(var6, 0, var3);
            return var6;
         } else {
            int var4 = var1.method2511();
            if(var4 < 0 || class167.field2704 != 0 && var4 > class167.field2704) {
               throw new RuntimeException();
            } else {
               byte[] var5 = new byte[var4];
               if(var2 == 1) {
                  class117.method2464(var5, var4, var0, 9);
               } else {
                  class167.field2702.method2454(var1, var5);
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException();
      }
   }
}
