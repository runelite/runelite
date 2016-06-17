import java.awt.Component;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
public abstract class class131 {
   @ObfuscatedName("x")
   public static int[] field2048;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "934171121"
   )
   public abstract void vmethod3115(Component var1);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-12"
   )
   public abstract int vmethod3116();

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-223310101"
   )
   public abstract void vmethod3114(Component var1);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass122;IB)V",
      garbageValue = "8"
   )
   static void method2873(class122 var0, int var1) {
      boolean var2 = var0.method2784(1) == 1;
      if(var2) {
         class32.field746[++class32.field745 - 1] = var1;
      }

      int var3 = var0.method2784(2);
      class2 var4 = client.field410[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field29 = false;
         } else if(var1 == client.field430) {
            throw new RuntimeException();
         } else {
            class32.field741[var1] = (class85.field1434 + var4.field831[0] >> 6) + (var4.field844[0] + class4.field62 >> 6 << 14) + (var4.field47 << 28);
            if(var4.field817 != -1) {
               class32.field743[var1] = var4.field817;
            } else {
               class32.field743[var1] = var4.field840;
            }

            class32.field744[var1] = var4.field815;
            client.field410[var1] = null;
            if(var0.method2784(1) != 0) {
               class101.method2288(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method2784(3);
            var6 = var4.field844[0];
            var7 = var4.field831[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(var1 == client.field430 && (var4.field813 < 1536 || var4.field791 < 1536 || var4.field813 >= 11776 || var4.field791 >= 11776)) {
               var4.method17(var6, var7);
               var4.field29 = false;
            } else if(var2) {
               var4.field29 = true;
               var4.field50 = var6;
               var4.field51 = var7;
            } else {
               var4.field29 = false;
               var4.method16(var6, var7, class32.field736[var1]);
            }

         } else if(var3 == 2) {
            var5 = var0.method2784(4);
            var6 = var4.field844[0];
            var7 = var4.field831[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(client.field430 != var1 || var4.field813 >= 1536 && var4.field791 >= 1536 && var4.field813 < 11776 && var4.field791 < 11776) {
               if(var2) {
                  var4.field29 = true;
                  var4.field50 = var6;
                  var4.field51 = var7;
               } else {
                  var4.field29 = false;
                  var4.method16(var6, var7, class32.field736[var1]);
               }
            } else {
               var4.method17(var6, var7);
               var4.field29 = false;
            }

         } else {
            var5 = var0.method2784(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method2784(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var4.field844[0] + var8;
               var11 = var9 + var4.field831[0];
               if(var1 == client.field430 && (var4.field813 < 1536 || var4.field791 < 1536 || var4.field813 >= 11776 || var4.field791 >= 11776)) {
                  var4.method17(var10, var11);
                  var4.field29 = false;
               } else if(var2) {
                  var4.field29 = true;
                  var4.field50 = var10;
                  var4.field51 = var11;
               } else {
                  var4.field29 = false;
                  var4.method16(var10, var11, class32.field736[var1]);
               }

               var4.field47 = (byte)(var4.field47 + var7 & 3);
               if(client.field430 == var1) {
                  class144.field2193 = var4.field47;
               }

            } else {
               var6 = var0.method2784(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + var4.field844[0] + class4.field62 & 16383) - class4.field62;
               var11 = (var4.field831[0] + class85.field1434 + var9 & 16383) - class85.field1434;
               if(client.field430 == var1 && (var4.field813 < 1536 || var4.field791 < 1536 || var4.field813 >= 11776 || var4.field791 >= 11776)) {
                  var4.method17(var10, var11);
                  var4.field29 = false;
               } else if(var2) {
                  var4.field29 = true;
                  var4.field50 = var10;
                  var4.field51 = var11;
               } else {
                  var4.field29 = false;
                  var4.method16(var10, var11, class32.field736[var1]);
               }

               var4.field47 = (byte)(var7 + var4.field47 & 3);
               if(client.field430 == var1) {
                  class144.field2193 = var4.field47;
               }

            }
         }
      }
   }
}
