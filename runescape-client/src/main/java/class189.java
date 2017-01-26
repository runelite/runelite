import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public class class189 extends CacheableNode {
   @ObfuscatedName("g")
   static NodeCache field2781 = new NodeCache(64);
   @ObfuscatedName("a")
   static int[] field2782;
   @ObfuscatedName("x")
   public boolean field2784 = false;
   @ObfuscatedName("p")
   public static class182 field2786;

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1963351339"
   )
   static final void method3440(int var0, int var1, int var2, int var3, int var4) {
      int var5 = Renderable.region.method1778(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = Renderable.region.method1729(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = WidgetNode.field174.image;
         var11 = 2048 * (103 - var2) + var1 * 4 + 24624;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = class217.getObjectDefinition(var12);
         if(var13.mapSceneId != -1) {
            ModIcon var14 = class3.field37[var13.mapSceneId];
            if(var14 != null) {
               int var15 = (var13.sizeX * 4 - var14.originalWidth) / 2;
               int var16 = (var13.sizeY * 4 - var14.height) / 2;
               var14.method4083(var15 + 4 * var1 + 48, 48 + 4 * (104 - var2 - var13.sizeY) + var16);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[1024 + var11] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[2 + var11] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[3 + var11] = var9;
                  var10[512 + var11 + 3] = var9;
                  var10[3 + var11 + 1024] = var9;
                  var10[3 + var11 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[1536 + var11] = var9;
                  var10[1 + 1536 + var11] = var9;
                  var10[2 + 1536 + var11] = var9;
                  var10[3 + var11 + 1536] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[1536 + var11 + 3] = var9;
               } else if(var7 == 3) {
                  var10[1536 + var11] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[1024 + var11] = var9;
                  var10[1536 + var11] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[2 + var11] = var9;
                  var10[3 + var11] = var9;
               } else if(var7 == 1) {
                  var10[3 + var11] = var9;
                  var10[var11 + 3 + 512] = var9;
                  var10[1024 + 3 + var11] = var9;
                  var10[var11 + 3 + 1536] = var9;
               } else if(var7 == 2) {
                  var10[1536 + var11] = var9;
                  var10[1536 + var11 + 1] = var9;
                  var10[2 + var11 + 1536] = var9;
                  var10[3 + var11 + 1536] = var9;
               }
            }
         }
      }

      var5 = Renderable.region.method1727(var0, var1, var2);
      if(var5 != 0) {
         var6 = Renderable.region.method1729(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = class217.getObjectDefinition(var9);
         int var18;
         if(var23.mapSceneId != -1) {
            ModIcon var19 = class3.field37[var23.mapSceneId];
            if(null != var19) {
               var12 = (var23.sizeX * 4 - var19.originalWidth) / 2;
               var18 = (var23.sizeY * 4 - var19.height) / 2;
               var19.method4083(var12 + 48 + var1 * 4, 48 + 4 * (104 - var2 - var23.sizeY) + var18);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var17 = WidgetNode.field174.image;
            var18 = 2048 * (103 - var2) + var1 * 4 + 24624;
            if(var7 != 0 && var7 != 2) {
               var17[var18] = var11;
               var17[1 + var18 + 512] = var11;
               var17[1024 + var18 + 2] = var11;
               var17[1536 + var18 + 3] = var11;
            } else {
               var17[1536 + var18] = var11;
               var17[1024 + var18 + 1] = var11;
               var17[2 + 512 + var18] = var11;
               var17[3 + var18] = var11;
            }
         }
      }

      var5 = Renderable.region.method1741(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var20 = class217.getObjectDefinition(var6);
         if(var20.mapSceneId != -1) {
            ModIcon var21 = class3.field37[var20.mapSceneId];
            if(var21 != null) {
               var9 = (var20.sizeX * 4 - var21.originalWidth) / 2;
               int var22 = (var20.sizeY * 4 - var21.height) / 2;
               var21.method4083(48 + 4 * var1 + var9, var22 + 48 + (104 - var2 - var20.sizeY) * 4);
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1078653186"
   )
   void method3441(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3442(var1, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "88"
   )
   void method3442(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2784 = true;
      }

   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-792395149"
   )
   static void method3451(Widget var0, int var1, int var2) {
      if(var0.field2201 == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.field2201 == 1) {
         var0.relativeX = (var1 - var0.width) / 2 + var0.originalX;
      } else if(var0.field2201 == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.field2201 == 3) {
         var0.relativeX = var0.originalX * var1 >> 14;
      } else if(var0.field2201 == 4) {
         var0.relativeX = (var1 * var0.originalX >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.relativeX = var1 - var0.width - (var1 * var0.originalX >> 14);
      }

      if(var0.field2195 == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.field2195 == 1) {
         var0.relativeY = (var2 - var0.height) / 2 + var0.originalY;
      } else if(var0.field2195 == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.field2195 == 3) {
         var0.relativeY = var0.originalY * var2 >> 14;
      } else if(var0.field2195 == 4) {
         var0.relativeY = (var2 - var0.height) / 2 + (var0.originalY * var2 >> 14);
      } else {
         var0.relativeY = var2 - var0.height - (var0.originalY * var2 >> 14);
      }

      if(Client.field505 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.width + var0.relativeX > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.height + var0.relativeY > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-575438441"
   )
   static void method3453(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method2374((long)var0);
      if(var1 != null) {
         for(int var2 = 0; var2 < var1.itemIds.length; ++var2) {
            var1.itemIds[var2] = -1;
            var1.stackSizes[var2] = 0;
         }

      }
   }
}
