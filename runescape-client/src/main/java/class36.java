import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public class class36 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lan;"
   )
   static final class36 field479;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lan;"
   )
   static final class36 field478;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 742719533
   )
   static int field480;
   @ObfuscatedName("fe")
   static byte[][] field482;
   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   @Export("mapedge")
   static SpritePixels mapedge;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 937513939
   )
   final int field481;

   static {
      field479 = new class36(0);
      field478 = new class36(1);
   }

   class36(int var1) {
      this.field481 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I[BLfe;I)V",
      garbageValue = "-1081185820"
   )
   static void method543(int var0, byte[] var1, IndexFile var2) {
      FileSystem var3 = new FileSystem();
      var3.field3267 = 0;
      var3.hash = (long)var0;
      var3.field3265 = var1;
      var3.index = var2;
      Deque var4 = class243.field3297;
      synchronized(class243.field3297) {
         class243.field3297.addFront(var3);
      }

      Object var9 = class243.field3300;
      synchronized(class243.field3300) {
         if(class243.field3296 == 0) {
            class243.field3294 = new Thread(new class243());
            class243.field3294.setDaemon(true);
            class243.field3294.start();
            class243.field3294.setPriority(5);
         }

         class243.field3296 = 600;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILcw;ZB)I",
      garbageValue = "-43"
   )
   static int method544(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = PendingSpawn.method1612(class82.intStack[--class56.intStackSize]);
      } else {
         var3 = var2?class285.field3789:Friend.field768;
      }

      WorldMapData.method394(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class82.intStack[--class56.intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = class48.localPlayer.composition.method4111();
            return 1;
         } else {
            return 2;
         }
      } else {
         class56.intStackSize -= 2;
         int var4 = class82.intStack[class56.intStackSize];
         int var5 = class82.intStack[class56.intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = class250.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2775 = var6.offsetX2d;
         var3.field2768 = var6.offsetY2d;
         var3.modelZoom = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2784 = 0;
         } else if(var0 == 1212 | 1 == var6.isStackable) {
            var3.field2784 = 1;
         } else {
            var3.field2784 = 2;
         }

         if(var3.field2781 > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.field2781;
         } else if(var3.originalWidth > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.originalWidth;
         }

         return 1;
      }
   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-600741203"
   )
   static final void method545(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.lowMemory && var0 != Ignore.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class56.region.method2814(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class56.region.method2808(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class56.region.method2851(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class56.region.method2942(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class56.region.method2912(var0, var2, var3, var7);
            int var13 = var7 >> 14 & 32767;
            int var14 = var11 & 31;
            int var15 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               class56.region.method2924(var0, var2, var3);
               var12 = class24.getObjectDefinition(var13);
               if(var12.interactType != 0) {
                  Client.collisionMaps[var0].removeWall(var2, var3, var14, var15, var12.field3505);
               }
            }

            if(var1 == 1) {
               class56.region.method2799(var0, var2, var3);
            }

            if(var1 == 2) {
               class56.region.method2800(var0, var2, var3);
               var12 = class24.getObjectDefinition(var13);
               if(var2 + var12.sizeX > 103 || var3 + var12.sizeX > 103 || var2 + var12.sizeY > 103 || var3 + var12.sizeY > 103) {
                  return;
               }

               if(var12.interactType != 0) {
                  Client.collisionMaps[var0].removeObject(var2, var3, var12.sizeX, var12.sizeY, var15, var12.field3505);
               }
            }

            if(var1 == 3) {
               class56.region.method2801(var0, var2, var3);
               var12 = class24.getObjectDefinition(var13);
               if(var12.interactType == 1) {
                  Client.collisionMaps[var0].unblock(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class61.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            class296.method5402(var0, var11, var2, var3, var4, var5, var6, class56.region, Client.collisionMaps[var0]);
         }
      }

   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(Lhk;Ljx;IIZB)V",
      garbageValue = "-44"
   )
   static final void method546(Widget var0, ItemComposition var1, int var2, int var3, boolean var4) {
      String[] var5 = var1.inventoryActions;
      byte var6 = -1;
      String var7 = null;
      if(var5 != null && var5[var3] != null) {
         if(var3 == 0) {
            var6 = 33;
         } else if(var3 == 1) {
            var6 = 34;
         } else if(var3 == 2) {
            var6 = 35;
         } else if(var3 == 3) {
            var6 = 36;
         } else {
            var6 = 37;
         }

         var7 = var5[var3];
      } else if(var3 == 4) {
         var6 = 37;
         var7 = "Drop";
      }

      if(var6 != -1 && var7 != null) {
         class188.method3612(var7, WallObject.getColTags(16748608) + var1.name, var6, var1.id, var2, var0.id, var4);
      }

   }
}
