package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cs")
public class class102 extends class203 {
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = 1016140985
   )
   protected static int field1777;
   @ObfuscatedName("j")
   class87[] field1778;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1010370203
   )
   public static int field1780;

   class102(class166 var1, class166 var2, int var3, boolean var4) {
      class198 var5 = new class198();
      int var6 = var1.method3224(var3);
      this.field1778 = new class87[var6];
      int[] var7 = var1.method3223(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.method3214(var3, var7[var8]);
         class101 var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(class101 var12 = (class101)var5.method3773(); null != var12; var12 = (class101)var5.method3772()) {
            if(var12.field1776 == var11) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13;
            if(var4) {
               var13 = var2.method3220(0, var11);
            } else {
               var13 = var2.method3220(var11, 0);
            }

            var10 = new class101(var11, var13);
            var5.method3768(var10);
         }

         this.field1778[var7[var8]] = new class87(var9, var10);
      }

   }

   @ObfuscatedName("f")
   public static boolean method2251(int var0) {
      return 0 != (var0 >> 30 & 1);
   }

   @ObfuscatedName("m")
   public static void method2253() {
      try {
         if(class182.field2957 == 1) {
            int var0 = class182.field2954.method3550();
            if(var0 > 0 && class182.field2954.method3556()) {
               var0 -= class3.field62;
               if(var0 < 0) {
                  var0 = 0;
               }

               class182.field2954.method3549(var0);
               return;
            }

            class182.field2954.method3637();
            class182.field2954.method3553();
            if(class182.field2955 != null) {
               class182.field2957 = 2;
            } else {
               class182.field2957 = 0;
            }

            class169.field2719 = null;
            class171.field2746 = null;
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class182.field2954.method3637();
         class182.field2957 = 0;
         class169.field2719 = null;
         class171.field2746 = null;
         class182.field2955 = null;
      }

   }

   @ObfuscatedName("l")
   public boolean method2254(int var1) {
      return this.field1778[var1].field1546;
   }
}
