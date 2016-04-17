import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
public class class103 extends class204 {
   @ObfuscatedName("bk")
   static class168 field1768;
   @ObfuscatedName("a")
   class88[] field1770;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1380971109
   )
   static int field1773;

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1626202225"
   )
   static final void method2374(String var0) {
      if(var0 != null) {
         String var1 = class23.method672(var0, client.field551);
         if(var1 != null) {
            for(int var2 = 0; var2 < client.field397; ++var2) {
               class7 var3 = client.field395[var2];
               String var4 = var3.field140;
               String var5 = class23.method672(var4, client.field551);
               if(class159.method3267(var0, var1, var4, var5)) {
                  --client.field397;

                  for(int var6 = var2; var6 < client.field397; ++var6) {
                     client.field395[var6] = client.field395[1 + var6];
                  }

                  client.field486 = client.field477;
                  client.field338.method2873(28);
                  client.field338.method2603(class104.method2383(var0));
                  client.field338.method2694(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-2067681819"
   )
   static final void method2376(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(0 != var6) {
         var11 = class91.field1593[var6];
         var12 = class91.field1594[var6];
         var13 = var12 * var9 - var11 * var5 >> 16;
         var10 = var11 * var9 + var5 * var12 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = class91.field1593[var7];
         var12 = class91.field1594[var7];
         var13 = var12 * var8 + var11 * var10 >> 16;
         var10 = var10 * var12 - var8 * var11 >> 16;
         var8 = var13;
      }

      class26.field673 = var0 - var8;
      class46.field1070 = var1 - var9;
      class137.field2129 = var2 - var10;
      class59.field1227 = var3;
      class113.field1958 = var4;
   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "([Lclass173;II)V",
      garbageValue = "-1158385992"
   )
   static final void method2381(class173[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class173 var3 = var0[var2];
         if(null != var3) {
            if(var3.field2824 == 0) {
               if(var3.field2867 != null) {
                  method2381(var3.field2867, var1);
               }

               class3 var4 = (class3)client.field453.method3868((long)var3.field2842);
               if(var4 != null) {
                  class124.method2904(var4.field70, var1);
               }
            }

            class0 var5;
            if(var1 == 0 && null != var3.field2865) {
               var5 = new class0();
               var5.field2 = var3;
               var5.field4 = var3.field2865;
               class168.method3449(var5, 200000);
            }

            if(var1 == 1 && null != var3.field2866) {
               if(var3.field2759 >= 0) {
                  class173 var6 = class20.method641(var3.field2842);
                  if(null == var6 || null == var6.field2867 || var3.field2759 >= var6.field2867.length || var6.field2867[var3.field2759] != var3) {
                     continue;
                  }
               }

               var5 = new class0();
               var5.field2 = var3;
               var5.field4 = var3.field2866;
               class168.method3449(var5, 200000);
            }
         }
      }

   }

   class103(class167 var1, class167 var2, int var3, boolean var4) {
      class199 var5 = new class199();
      int var6 = var1.method3372(var3);
      this.field1770 = new class88[var6];
      int[] var7 = var1.method3368(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.method3403(var3, var7[var8]);
         class102 var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(class102 var12 = (class102)var5.method3926(); var12 != null; var12 = (class102)var5.method3902()) {
            if(var11 == var12.field1763) {
               var10 = var12;
               break;
            }
         }

         if(null == var10) {
            byte[] var13;
            if(var4) {
               var13 = var2.method3432(0, var11);
            } else {
               var13 = var2.method3432(var11, 0);
            }

            var10 = new class102(var11, var13);
            var5.method3900(var10);
         }

         this.field1770[var7[var8]] = new class88(var9, var10);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1615095230"
   )
   public boolean method2382(int var1) {
      return this.field1770[var1].field1550;
   }
}
