import java.util.Comparator;
import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
final class class5 implements Comparator {
   @ObfuscatedName("qu")
   static class109 field51;
   @ObfuscatedName("by")
   @Export("host")
   static String host;

   public int compare(Object var1, Object var2) {
      return this.method59((class2)var1, (class2)var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;B)I",
      garbageValue = "0"
   )
   int method59(class2 var1, class2 var2) {
      return var1.field24.price < var2.field24.price?-1:(var1.field24.price == var2.field24.price?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-1292615743"
   )
   static final void method68(int var0, int var1, int var2, int var3, int var4) {
      int var5 = Client.region.method1717(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = Client.region.method1721(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class159.field2131.image;
         var11 = var1 * 4 + 24624 + (103 - var2) * 2048;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = ItemLayer.getObjectDefinition(var12);
         if(var13.field2939 != -1) {
            ModIcon var14 = class168.field2195[var13.field2939];
            if(null != var14) {
               int var15 = (var13.field2907 * 4 - var14.originalWidth) / 2;
               int var16 = (var13.field2908 * 4 - var14.height) / 2;
               var14.method3979(var1 * 4 + 48 + var15, var16 + (104 - var2 - var13.field2908) * 4 + 48);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[2 + var11] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 3 + 512] = var9;
                  var10[1024 + 3 + var11] = var9;
                  var10[3 + var11 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[1 + var11 + 1536] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[1536 + var11 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[3 + var11] = var9;
               } else if(var7 == 2) {
                  var10[1536 + 3 + var11] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[var11 + 2] = var9;
                  var10[3 + var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[512 + var11 + 3] = var9;
                  var10[var11 + 3 + 1024] = var9;
                  var10[1536 + var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[2 + 1536 + var11] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = Client.region.method1719(var0, var1, var2);
      if(var5 != 0) {
         var6 = Client.region.method1721(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = ItemLayer.getObjectDefinition(var9);
         int var21;
         if(var23.field2939 != -1) {
            ModIcon var22 = class168.field2195[var23.field2939];
            if(var22 != null) {
               var12 = (var23.field2907 * 4 - var22.originalWidth) / 2;
               var21 = (var23.field2908 * 4 - var22.height) / 2;
               var22.method3979(var12 + var1 * 4 + 48, var21 + (104 - var2 - var23.field2908) * 4 + 48);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var20 = class159.field2131.image;
            var21 = 24624 + var1 * 4 + (103 - var2) * 2048;
            if(var7 != 0 && var7 != 2) {
               var20[var21] = var11;
               var20[1 + 512 + var21] = var11;
               var20[var21 + 1024 + 2] = var11;
               var20[var21 + 1536 + 3] = var11;
            } else {
               var20[var21 + 1536] = var11;
               var20[1 + var21 + 1024] = var11;
               var20[2 + 512 + var21] = var11;
               var20[3 + var21] = var11;
            }
         }
      }

      var5 = Client.region.method1720(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var17 = ItemLayer.getObjectDefinition(var6);
         if(var17.field2939 != -1) {
            ModIcon var18 = class168.field2195[var17.field2939];
            if(null != var18) {
               var9 = (var17.field2907 * 4 - var18.originalWidth) / 2;
               int var19 = (var17.field2908 * 4 - var18.height) / 2;
               var18.method3979(var9 + var1 * 4 + 48, 48 + (104 - var2 - var17.field2908) * 4 + var19);
            }
         }
      }

   }

   @ObfuscatedName("i")
   public static String method69(long var0) {
      class162.field2152.setTime(new Date(var0));
      int var2 = class162.field2152.get(7);
      int var3 = class162.field2152.get(5);
      int var4 = class162.field2152.get(2);
      int var5 = class162.field2152.get(1);
      int var6 = class162.field2152.get(11);
      int var7 = class162.field2152.get(12);
      int var8 = class162.field2152.get(13);
      return class162.field2154[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class162.field2156[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1001267419"
   )
   public static int method70(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }
}
