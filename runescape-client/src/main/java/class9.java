import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public abstract class class9 extends Node {
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 1467760613
   )
   static int field251;
   @ObfuscatedName("pf")
   @ObfuscatedGetter(
      intValue = 9460989
   )
   static int field250;
   @ObfuscatedName("ak")
   protected static GarbageCollectorMXBean field254;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-56481943"
   )
   public abstract void vmethod58();

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-128"
   )
   static void method54() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3628(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3625()) {
         int var1 = var0.id;
         if(class13.loadWidget(var1)) {
            boolean var2 = true;
            Widget[] var3 = class268.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = GZipDecompressor.method3177(var4);
               if(var5 != null) {
                  class7.method34(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lfp;IIIIIII)V",
      garbageValue = "-1856874615"
   )
   @Export("loadTerrain")
   static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class61.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  int[] var8 = class61.tileHeights[0][var2];
                  int var11 = var2 + var4 + 932731;
                  int var12 = var3 + var5 + 556238;
                  int var13 = class29.getSmoothNoise(var11 + '넵', var12 + 91923, 4) - 128 + (class29.getSmoothNoise(var11 + 10294, var12 + '鎽', 2) - 128 >> 1) + (class29.getSmoothNoise(var11, var12, 1) - 128 >> 2);
                  var13 = (int)(0.3D * (double)var13) + 35;
                  if(var13 < 10) {
                     var13 = 10;
                  } else if(var13 > 60) {
                     var13 = 60;
                  }

                  var8[var3] = -var13 * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var14 = var0.readUnsignedByte();
               if(var14 == 1) {
                  var14 = 0;
               }

               if(var1 == 0) {
                  class61.tileHeights[0][var2][var3] = -var14 * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - var14 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class178.overlayIds[var1][var2][var3] = var0.readByte();
               class61.overlayPaths[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class215.overlayRotations[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class61.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class54.underlayIds[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "103"
   )
   static void method55(int var0, int var1) {
      if(Client.field1167 != 0 && var0 != -1) {
         CacheFile.method2339(class46.indexTrack2, var0, 0, Client.field1167, false);
         Client.field1169 = true;
      }

   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1145027450"
   )
   static final int method48() {
      if(Buffer.preferences.hideRoofs) {
         return class27.plane;
      } else {
         int var0 = class227.getTileHeight(class82.cameraX, class158.cameraY, class27.plane);
         return var0 - Ignore.cameraZ < 800 && (class61.tileSettings[class27.plane][class82.cameraX >> 7][class158.cameraY >> 7] & 4) != 0?class27.plane:3;
      }
   }
}
