import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class174 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1034146259
   )
   static int field2378;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 189173503
   )
   static int field2372;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2112316397
   )
   static int field2376;
   @ObfuscatedName("y")
   static byte[][] field2374;
   @ObfuscatedName("e")
   static byte[][] field2375;
   @ObfuscatedName("f")
   static byte[][] field2371;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1272508717
   )
   @Export("priority")
   public static int priority;
   @ObfuscatedName("z")
   static int[] field2373;

   static {
      field2378 = 0;
      field2372 = 0;
      field2376 = 0;
      field2374 = new byte[1000][];
      field2375 = new byte[250][];
      field2371 = new byte[50][];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "1"
   )
   static synchronized byte[] method3392(int var0) {
      byte[] var1;
      if(var0 == 100 && field2378 > 0) {
         var1 = field2374[--field2378];
         field2374[field2378] = null;
         return var1;
      } else if(var0 == 5000 && field2372 > 0) {
         var1 = field2375[--field2372];
         field2375[field2372] = null;
         return var1;
      } else if(var0 == 30000 && field2376 > 0) {
         var1 = field2371[--field2376];
         field2371[field2376] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "29"
   )
   static final String method3396(int var0) {
      return var0 < 999999999?Integer.toString(var0):"*";
   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1550497578"
   )
   static final void method3393(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class51.region.method2726(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class51.region.method2712(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = KeyFocusListener.field619.image;
         var11 = var1 * 4 + 24624 + (103 - var2) * 2048;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = WidgetNode.getObjectDefinition(var12);
         if(var13.mapSceneId != -1) {
            IndexedSprite var14 = class18.field306[var13.mapSceneId];
            if(var14 != null) {
               int var15 = (var13.sizeX * 4 - var14.originalWidth) / 2;
               int var16 = (var13.sizeY * 4 - var14.height) / 2;
               var14.method5034(var15 + var1 * 4 + 48, (104 - var2 - var13.sizeY) * 4 + 48 + var16);
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
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536 + 3] = var9;
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
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = class51.region.method2760(var0, var1, var2);
      if(var5 != 0) {
         var6 = class51.region.method2712(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = WidgetNode.getObjectDefinition(var9);
         int var18;
         if(var23.mapSceneId != -1) {
            IndexedSprite var17 = class18.field306[var23.mapSceneId];
            if(var17 != null) {
               var12 = (var23.sizeX * 4 - var17.originalWidth) / 2;
               var18 = (var23.sizeY * 4 - var17.height) / 2;
               var17.method5034(var12 + var1 * 4 + 48, (104 - var2 - var23.sizeY) * 4 + var18 + 48);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = KeyFocusListener.field619.image;
            var18 = var1 * 4 + 24624 + (103 - var2) * 2048;
            if(var7 != 0 && var7 != 2) {
               var22[var18] = var11;
               var22[var18 + 512 + 1] = var11;
               var22[var18 + 1024 + 2] = var11;
               var22[var18 + 1536 + 3] = var11;
            } else {
               var22[var18 + 1536] = var11;
               var22[var18 + 1024 + 1] = var11;
               var22[var18 + 512 + 2] = var11;
               var22[var18 + 3] = var11;
            }
         }
      }

      var5 = class51.region.method2699(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var19 = WidgetNode.getObjectDefinition(var6);
         if(var19.mapSceneId != -1) {
            IndexedSprite var20 = class18.field306[var19.mapSceneId];
            if(var20 != null) {
               var9 = (var19.sizeX * 4 - var20.originalWidth) / 2;
               int var21 = (var19.sizeY * 4 - var20.height) / 2;
               var20.method5034(var1 * 4 + var9 + 48, var21 + (104 - var2 - var19.sizeY) * 4 + 48);
            }
         }
      }

   }
}
