import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class23 {
   @ObfuscatedName("qz")
   @ObfuscatedSignature(
      signature = "Lco;"
   )
   @Export("preferences")
   static Preferences preferences;
   @ObfuscatedName("ax")
   protected static GarbageCollectorMXBean field356;

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-741246638"
   )
   static final void method164(boolean var0) {
      while(true) {
         if(Client.secretPacketBuffer2.bitsAvail(Client.packetLength) >= 27) {
            int var1 = Client.secretPacketBuffer2.getBits(15);
            if(var1 != 32767) {
               boolean var2 = false;
               if(Client.cachedNPCs[var1] == null) {
                  Client.cachedNPCs[var1] = new NPC();
                  var2 = true;
               }

               NPC var3 = Client.cachedNPCs[var1];
               Client.npcIndices[++Client.npcIndexesCount - 1] = var1;
               var3.field1256 = Client.gameCycle;
               int var4;
               if(var0) {
                  var4 = Client.secretPacketBuffer2.getBits(8);
                  if(var4 > 127) {
                     var4 -= 256;
                  }
               } else {
                  var4 = Client.secretPacketBuffer2.getBits(5);
                  if(var4 > 15) {
                     var4 -= 32;
                  }
               }

               int var5 = Client.secretPacketBuffer2.getBits(1);
               int var6 = Client.secretPacketBuffer2.getBits(1);
               if(var6 == 1) {
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var1;
               }

               int var7 = Client.field1041[Client.secretPacketBuffer2.getBits(3)];
               if(var2) {
                  var3.orientation = var3.angle = var7;
               }

               var3.composition = class72.getNpcDefinition(Client.secretPacketBuffer2.getBits(14));
               int var8;
               if(var0) {
                  var8 = Client.secretPacketBuffer2.getBits(8);
                  if(var8 > 127) {
                     var8 -= 256;
                  }
               } else {
                  var8 = Client.secretPacketBuffer2.getBits(5);
                  if(var8 > 15) {
                     var8 -= 32;
                  }
               }

               var3.field1211 = var3.composition.field3559;
               var3.field1265 = var3.composition.field3582;
               if(var3.field1265 == 0) {
                  var3.angle = 0;
               }

               var3.field1215 = var3.composition.field3565;
               var3.field1260 = var3.composition.field3581;
               var3.field1217 = var3.composition.field3567;
               var3.field1218 = var3.composition.field3568;
               var3.idlePoseAnimation = var3.composition.field3557;
               var3.field1266 = var3.composition.field3566;
               var3.field1213 = var3.composition.field3564;
               var3.method1754(AbstractByteBuffer.localPlayer.pathX[0] + var4, AbstractByteBuffer.localPlayer.pathY[0] + var8, var5 == 1);
               continue;
            }
         }

         Client.secretPacketBuffer2.byteAccess();
         return;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)Lkr;",
      garbageValue = "1849761097"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = (long)var0 + ((long)var1 << 16) + ((long)var2 << 38) + ((long)var4 << 40) + ((long)var3 << 42);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = class46.getItemDefinition(var0);
      if(var1 > 1 && var9.countObj != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.countCo[var11] && var9.countCo[var11] != 0) {
               var10 = var9.countObj[var11];
            }
         }

         if(var10 != -1) {
            var9 = class46.getItemDefinition(var10);
         }
      }

      Model var21 = var9.getModel(1);
      if(var21 == null) {
         return null;
      } else {
         SpritePixels var22 = null;
         if(var9.notedTemplate != -1) {
            var22 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(var22 == null) {
               return null;
            }
         } else if(var9.notedId != -1) {
            var22 = createSprite(var9.unnotedId, var1, var2, var3, 0, false);
            if(var22 == null) {
               return null;
            }
         } else if(var9.field3542 != -1) {
            var22 = createSprite(var9.field3541, var1, 0, 0, 0, false);
            if(var22 == null) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.graphicsPixels;
         int var13 = Rasterizer2D.graphicsPixelsWidth;
         int var14 = Rasterizer2D.graphicsPixelsHeight;
         int[] var15 = new int[4];
         Rasterizer2D.copyDrawRegion(var15);
         var8 = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         Rasterizer2D.reset();
         Graphics3D.method2680();
         Graphics3D.method2682(16, 16);
         Graphics3D.rasterGouraudLowRes = false;
         if(var9.field3542 != -1) {
            var22.method5172(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)(1.5D * (double)var16);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = var16 * Graphics3D.SINE[var9.xan2d] >> 16;
         int var18 = var16 * Graphics3D.COSINE[var9.xan2d] >> 16;
         var21.method2594();
         var21.method2607(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var21.modelHeight / 2 + var17 + var9.offsetY2d, var18 + var9.offsetY2d);
         if(var9.notedId != -1) {
            var22.method5172(0, 0);
         }

         if(var2 >= 1) {
            var8.method5171(1);
         }

         if(var2 >= 2) {
            var8.method5171(16777215);
         }

         if(var3 != 0) {
            var8.method5193(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         if(var9.notedTemplate != -1) {
            var22.method5172(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            Font var19 = ItemComposition.field3488;
            String var20;
            if(var1 < 100000) {
               var20 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var19.method4840(var20, 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.setDrawRegion(var15);
         Graphics3D.method2680();
         Graphics3D.rasterGouraudLowRes = true;
         return var8;
      }
   }
}
