import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
public class class183 {
   @ObfuscatedName("u")
   public static class167 field2952;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1609077469
   )
   public static int field2953 = 0;
   @ObfuscatedName("x")
   public static class167 field2954;
   @ObfuscatedName("b")
   public static class184 field2955;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -452225095
   )
   public static int field2956;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 71897045
   )
   public static int field2957;
   @ObfuscatedName("f")
   public static class167 field2958;
   @ObfuscatedName("my")
   static byte field2959;

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "([Lclass173;IIIZI)V",
      garbageValue = "684420715"
   )
   static void method3633(class173[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         class173 var6 = var0[var5];
         if(var6 != null && var1 == var6.field2773) {
            class2.method42(var6, var2, var3, var4);
            class98.method2265(var6, var2, var3);
            if(var6.field2878 > var6.field2777 - var6.field2769) {
               var6.field2878 = var6.field2777 - var6.field2769;
            }

            if(var6.field2878 < 0) {
               var6.field2878 = 0;
            }

            if(var6.field2776 > var6.field2778 - var6.field2888) {
               var6.field2776 = var6.field2778 - var6.field2888;
            }

            if(var6.field2776 < 0) {
               var6.field2776 = 0;
            }

            if(var6.field2798 == 0) {
               class75.method1698(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-38"
   )
   static final void method3634() {
      for(int var0 = 0; var0 < client.field554; ++var0) {
         --client.field533[var0];
         if(client.field533[var0] >= -10) {
            class58 var9 = client.field392[var0];
            if(var9 == null) {
               var9 = class58.method1314(class136.field2101, client.field531[var0], 0);
               if(null == var9) {
                  continue;
               }

               client.field533[var0] += var9.method1309();
               client.field392[var0] = var9;
            }

            if(client.field533[var0] < 0) {
               int var2;
               if(client.field521[var0] != 0) {
                  int var3 = (client.field521[var0] & 255) * 128;
                  int var4 = client.field521[var0] >> 16 & 255;
                  int var5 = 64 + var4 * 128 - class15.field225.field837;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = client.field521[var0] >> 8 & 255;
                  int var7 = 128 * var6 + 64 - class15.field225.field880;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var7 + var5 - 128;
                  if(var8 > var3) {
                     client.field533[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var3 - var8) * client.field349 / var3;
               } else {
                  var2 = client.field492;
               }

               if(var2 > 0) {
                  class62 var11 = var9.method1308().method1340(class12.field194);
                  class64 var10 = class64.method1361(var11, 100, var2);
                  var10.method1383(client.field532[var0] - 1);
                  class121.field2014.method1229(var10);
               }

               client.field533[var0] = -100;
            }
         } else {
            --client.field554;

            for(int var1 = var0; var1 < client.field554; ++var1) {
               client.field531[var1] = client.field531[var1 + 1];
               client.field392[var1] = client.field392[1 + var1];
               client.field532[var1] = client.field532[1 + var1];
               client.field533[var1] = client.field533[var1 + 1];
               client.field521[var1] = client.field521[1 + var1];
            }

            --var0;
         }
      }

      if(client.field526) {
         boolean var12;
         if(field2953 != 0) {
            var12 = true;
         } else {
            var12 = field2955.method3644();
         }

         if(!var12) {
            if(client.field524 != 0 && client.field315 != -1) {
               class96.method2261(class17.field261, client.field315, 0, client.field524, false);
            }

            client.field526 = false;
         }
      }

   }
}
