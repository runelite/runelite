import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
public class class54 extends CacheableNode {
   @ObfuscatedName("l")
   static class170 field1169;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1511999975
   )
   public int field1170 = 0;
   @ObfuscatedName("g")
   static NodeCache field1171 = new NodeCache(64);
   @ObfuscatedName("rq")
   protected static boolean field1172;
   @ObfuscatedName("qu")
   @Export("bufferProvider")
   public static BufferProvider bufferProvider;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1037792829"
   )
   void method1152(Buffer var1) {
      while(true) {
         int var2 = var1.method2633();
         if(var2 == 0) {
            return;
         }

         this.method1162(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass170;III)[LSpritePixels;",
      garbageValue = "1386923093"
   )
   static SpritePixels[] method1153(class170 var0, int var1, int var2) {
      return !class4.method49(var0, var1, var2)?null:Ignore.method112();
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-2092321833"
   )
   static final void method1154(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class136.region.method1998(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      ModIcon var14;
      if(var5 != 0) {
         var6 = class136.region.method2081(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var12 = class23.field619.image;
         var10 = 24624 + var1 * 4 + 2048 * (103 - var2);
         var11 = var5 >> 14 & 32767;
         ObjectComposition var13 = class160.getObjectDefinition(var11);
         if(var13.field950 != -1) {
            var14 = WallObject.field1611[var13.field950];
            if(null != var14) {
               int var15 = (var13.field960 * 4 - var14.originalWidth) / 2;
               int var16 = (var13.field970 * 4 - var14.height) / 2;
               var14.method1954(48 + var1 * 4 + var15, 48 + 4 * (104 - var2 - var13.field970) + var16);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var12[var10] = var9;
                  var12[512 + var10] = var9;
                  var12[var10 + 1024] = var9;
                  var12[var10 + 1536] = var9;
               } else if(var7 == 1) {
                  var12[var10] = var9;
                  var12[var10 + 1] = var9;
                  var12[var10 + 2] = var9;
                  var12[3 + var10] = var9;
               } else if(var7 == 2) {
                  var12[var10 + 3] = var9;
                  var12[512 + var10 + 3] = var9;
                  var12[1027 + var10] = var9;
                  var12[var10 + 3 + 1536] = var9;
               } else if(var7 == 3) {
                  var12[1536 + var10] = var9;
                  var12[var10 + 1536 + 1] = var9;
                  var12[1536 + var10 + 2] = var9;
                  var12[1536 + var10 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var12[var10] = var9;
               } else if(var7 == 1) {
                  var12[var10 + 3] = var9;
               } else if(var7 == 2) {
                  var12[1536 + var10 + 3] = var9;
               } else if(var7 == 3) {
                  var12[var10 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var12[var10] = var9;
                  var12[var10 + 512] = var9;
                  var12[var10 + 1024] = var9;
                  var12[1536 + var10] = var9;
               } else if(var7 == 0) {
                  var12[var10] = var9;
                  var12[var10 + 1] = var9;
                  var12[var10 + 2] = var9;
                  var12[3 + var10] = var9;
               } else if(var7 == 1) {
                  var12[3 + var10] = var9;
                  var12[512 + var10 + 3] = var9;
                  var12[3 + var10 + 1024] = var9;
                  var12[1536 + var10 + 3] = var9;
               } else if(var7 == 2) {
                  var12[1536 + var10] = var9;
                  var12[1536 + var10 + 1] = var9;
                  var12[1538 + var10] = var9;
                  var12[var10 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = class136.region.method2019(var0, var1, var2);
      ObjectComposition var17;
      if(var5 != 0) {
         var6 = class136.region.method2081(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         var17 = class160.getObjectDefinition(var9);
         int var18;
         if(var17.field950 != -1) {
            var14 = WallObject.field1611[var17.field950];
            if(var14 != null) {
               var11 = (var17.field960 * 4 - var14.originalWidth) / 2;
               var18 = (var17.field970 * 4 - var14.height) / 2;
               var14.method1954(var11 + 48 + var1 * 4, (104 - var2 - var17.field970) * 4 + 48 + var18);
            }
         } else if(var8 == 9) {
            var10 = 15658734;
            if(var5 > 0) {
               var10 = 15597568;
            }

            int[] var20 = class23.field619.image;
            var18 = (103 - var2) * 2048 + 24624 + 4 * var1;
            if(var7 != 0 && var7 != 2) {
               var20[var18] = var10;
               var20[512 + var18 + 1] = var10;
               var20[1024 + var18 + 2] = var10;
               var20[3 + var18 + 1536] = var10;
            } else {
               var20[var18 + 1536] = var10;
               var20[1 + var18 + 1024] = var10;
               var20[512 + var18 + 2] = var10;
               var20[var18 + 3] = var10;
            }
         }
      }

      var5 = class136.region.method2014(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         var17 = class160.getObjectDefinition(var6);
         if(var17.field950 != -1) {
            ModIcon var19 = WallObject.field1611[var17.field950];
            if(null != var19) {
               var9 = (var17.field960 * 4 - var19.originalWidth) / 2;
               int var21 = (var17.field970 * 4 - var19.height) / 2;
               var19.method1954(var9 + 48 + 4 * var1, (104 - var2 - var17.field970) * 4 + 48 + var21);
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-2123186596"
   )
   void method1162(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field1170 = var1.method2635();
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1654941550"
   )
   public static int method1164(int var0) {
      class50 var1 = class24.method602(var0);
      int var2 = var1.field1119;
      int var3 = var1.field1120;
      int var4 = var1.field1124;
      int var5 = class179.field2959[var4 - var3];
      return class179.widgetSettings[var2] >> var3 & var5;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "1948359571"
   )
   public static int method1165(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;I)[LSpritePixels;",
      garbageValue = "737334618"
   )
   public static SpritePixels[] method1167(class170 var0, String var1, String var2) {
      int var3 = var0.method3410(var1);
      int var4 = var0.method3459(var3, var2);
      return method1153(var0, var3, var4);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1170310488"
   )
   public static void method1169() {
      PlayerComposition.field2978.reset();
   }
}
