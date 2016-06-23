import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
public class class152 implements class112 {
   @ObfuscatedName("l")
   static final class152 field2254 = new class152(4, 3, false, false, true);
   @ObfuscatedName("u")
   static final class152 field2255 = new class152(1, 0, true, true, true);
   @ObfuscatedName("x")
   static final class152 field2256 = new class152(2, 1, true, true, false);
   @ObfuscatedName("bm")
   static class168 field2257;
   @ObfuscatedName("f")
   static final class152 field2258 = new class152(0, -1, true, false, true);
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 111069325
   )
   final int field2259;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 90571401
   )
   public final int field2260;
   @ObfuscatedName("m")
   public final boolean field2261;
   @ObfuscatedName("g")
   public final boolean field2262;
   @ObfuscatedName("b")
   static final class152 field2263 = new class152(3, 2, false, false, true);

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   class152(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2259 = var1;
      this.field2260 = var2;
      this.field2261 = var4;
      this.field2262 = var5;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "69"
   )
   public int vmethod3194() {
      return this.field2259;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass224;Lclass224;I)V",
      garbageValue = "-392180600"
   )
   static void method3174(class224 var0, class224 var1) {
      if(class168.field2689 == null) {
         class168.field2689 = class8.method128(class108.field1909, "sl_back", "");
      }

      if(class0.field14 == null) {
         class0.field14 = client.method595(class108.field1909, "sl_flags", "");
      }

      if(class155.field2284 == null) {
         class155.field2284 = client.method595(class108.field1909, "sl_arrows", "");
      }

      if(class26.field666 == null) {
         class26.field666 = client.method595(class108.field1909, "sl_stars", "");
      }

      class79.method1854(class31.field725, 23, 765, 480, 0);
      class79.method1859(class31.field725, 0, 125, 23, 12425273, 9135624);
      class79.method1859(125 + class31.field725, 0, 640, 23, 5197647, 2697513);
      var0.method4073("Select a world", 62 + class31.field725, 15, 0, -1);
      if(class26.field666 != null) {
         class26.field666[1].method1916(140 + class31.field725, 1);
         var1.method4066("Members only world", 152 + class31.field725, 10, 16777215, -1);
         class26.field666[0].method1916(140 + class31.field725, 12);
         var1.method4066("Free world", class31.field725 + 152, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(null != class155.field2284) {
         int var2 = 280 + class31.field725;
         if(class25.field639[0] == 0 && class25.field649[0] == 0) {
            class155.field2284[2].method1916(var2, 4);
         } else {
            class155.field2284[0].method1916(var2, 4);
         }

         if(class25.field639[0] == 0 && class25.field649[0] == 1) {
            class155.field2284[3].method1916(var2 + 15, 4);
         } else {
            class155.field2284[1].method1916(var2 + 15, 4);
         }

         var0.method4066("World", 32 + var2, 17, 16777215, -1);
         int var3 = class31.field725 + 390;
         if(class25.field639[0] == 1 && class25.field649[0] == 0) {
            class155.field2284[2].method1916(var3, 4);
         } else {
            class155.field2284[0].method1916(var3, 4);
         }

         if(class25.field639[0] == 1 && class25.field649[0] == 1) {
            class155.field2284[3].method1916(15 + var3, 4);
         } else {
            class155.field2284[1].method1916(15 + var3, 4);
         }

         var0.method4066("Players", var3 + 32, 17, 16777215, -1);
         var4 = 500 + class31.field725;
         if(class25.field639[0] == 2 && class25.field649[0] == 0) {
            class155.field2284[2].method1916(var4, 4);
         } else {
            class155.field2284[0].method1916(var4, 4);
         }

         if(class25.field639[0] == 2 && class25.field649[0] == 1) {
            class155.field2284[3].method1916(15 + var4, 4);
         } else {
            class155.field2284[1].method1916(var4 + 15, 4);
         }

         var0.method4066("Location", var4 + 32, 17, 16777215, -1);
         var5 = 610 + class31.field725;
         if(class25.field639[0] == 3 && class25.field649[0] == 0) {
            class155.field2284[2].method1916(var5, 4);
         } else {
            class155.field2284[0].method1916(var5, 4);
         }

         if(class25.field639[0] == 3 && class25.field649[0] == 1) {
            class155.field2284[3].method1916(var5 + 15, 4);
         } else {
            class155.field2284[1].method1916(var5 + 15, 4);
         }

         var0.method4066("Type", 32 + var5, 17, 16777215, -1);
      }

      class79.method1854(class31.field725 + 708, 4, 50, 16, 0);
      var1.method4073("Cancel", 708 + class31.field725 + 25, 16, 16777215, -1);
      class31.field743 = -1;
      if(null != class168.field2689) {
         byte var23 = 88;
         byte var24 = 19;
         var4 = 765 / (1 + var23);
         var5 = 480 / (var24 + 1);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if(var5 * (var4 - 1) >= class25.field636) {
               --var4;
            }

            if(var4 * (var5 - 1) >= class25.field636) {
               --var5;
            }

            if((var5 - 1) * var4 >= class25.field636) {
               --var5;
            }
         } while(var5 != var6 || var4 != var7);

         var6 = (765 - var23 * var4) / (var4 + 1);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var24 * var5) / (var5 + 1);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var4 * var23 - (var4 - 1) * var6) / 2;
         int var9 = (480 - var5 * var24 - var7 * (var5 - 1)) / 2;
         int var10 = 23 + var9;
         int var11 = class31.field725 + var8;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < class25.field636; ++var14) {
            class25 var15 = class25.field635[var14];
            boolean var16 = true;
            String var17 = Integer.toString(var15.field638);
            if(var15.field638 == -1) {
               var17 = "OFF";
               var16 = false;
            } else if(var15.field638 > 1980) {
               var17 = "FULL";
               var16 = false;
            }

            int var19 = 0;
            byte var18;
            if(var15.method670()) {
               if(var15.method646()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method643()) {
               var19 = 16711680;
               if(var15.method646()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method635()) {
               if(var15.method646()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method646()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(class140.field2146 >= var11 && class140.field2151 >= var10 && class140.field2146 < var23 + var11 && class140.field2151 < var10 + var24 && var16) {
               class31.field743 = var14;
               class168.field2689[var18].method1840(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               class168.field2689[var18].method1761(var11, var10);
            }

            if(null != class0.field14) {
               class0.field14[(var15.method646()?8:0) + var15.field650].method1916(var11 + 29, var10);
            }

            var0.method4073(Integer.toString(var15.field640), 15 + var11, var10 + var24 / 2 + 5, var19, -1);
            var1.method4073(var17, var11 + 60, 5 + var10 + var24 / 2, 268435455, -1);
            var10 += var7 + var24;
            ++var12;
            if(var12 >= var5) {
               var10 = 23 + var9;
               var11 += var6 + var23;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method4043(class25.field635[class31.field743].field631) + 6;
            int var20 = var1.field3188 + 8;
            class79.method1854(class140.field2146 - var14 / 2, class140.field2151 + 20 + 5, var14, var20, 16777120);
            class79.method1860(class140.field2146 - var14 / 2, 5 + class140.field2151 + 20, var14, var20, 0);
            var1.method4073(class25.field635[class31.field743].field631, class140.field2146, 4 + 5 + class140.field2151 + 20 + var1.field3188, 0, -1);
         }
      }

      try {
         Graphics var21 = class89.field1567.getGraphics();
         class12.field196.vmethod1939(var21, 0, 0);
      } catch (Exception var22) {
         class89.field1567.repaint();
      }

   }
}
