import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class33 {
   @ObfuscatedName("f")
   static final class33 field744 = new class33();
   @ObfuscatedName("e")
   static final class33 field745 = new class33();
   @ObfuscatedName("s")
   static final class33 field747 = new class33();
   @ObfuscatedName("w")
   static final class33 field749 = new class33();

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILclass86;[Lclass108;I)V",
      garbageValue = "-721238659"
   )
   static final void method710(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, class86 var8, class108[] var9) {
      class119 var10 = new class119(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.method2536();
         if(var12 == 0) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.method2536();
            if(0 == var14) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.method2523();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if(var17 == var4 && var16 >= var5 && var16 < var5 + 8 && var15 >= var6 && var15 < var6 + 8) {
               class40 var21 = class26.method633(var11);
               int var22 = var2 + class8.method113(var16 & 7, var15 & 7, var7, var21.field908, var21.field915, var20);
               int var23 = var3 + class134.method2864(var16 & 7, var15 & 7, var7, var21.field908, var21.field915, var20);
               if(var22 > 0 && var23 > 0 && var22 < 103 && var23 < 103) {
                  int var24 = var1;
                  if((class5.field80[1][var22][var23] & 2) == 2) {
                     var24 = var1 - 1;
                  }

                  class108 var25 = null;
                  if(var24 >= 0) {
                     var25 = var9[var24];
                  }

                  class0.method1(var1, var22, var23, var11, var20 + var7 & 3, var19, var8, var25);
               }
            }
         }
      }
   }

   @ObfuscatedName("w")
   public static class51 method711(int var0) {
      class51 var1 = (class51)class51.field1086.method3754((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class5.field101.method3280(10, var0);
         var1 = new class51();
         var1.field1089 = var0;
         if(null != var2) {
            var1.method1016(new class119(var2));
         }

         var1.method1056();
         if(-1 != var1.field1122) {
            var1.method1018(method711(var1.field1122), method711(var1.field1121));
         }

         if(var1.field1131 != -1) {
            var1.method1025(method711(var1.field1131), method711(var1.field1128));
         }

         if(!class51.field1100 && var1.field1123) {
            var1.field1091 = "Members object";
            var1.field1104 = false;
            var1.field1105 = null;
            var1.field1130 = null;
            var1.field1124 = 0;
         }

         class51.field1086.method3756(var1, (long)var0);
         return var1;
      }
   }
}
