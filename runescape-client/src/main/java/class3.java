import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
final class class3 implements class0 {
   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "Lfd;"
   )
   @Export("rssocket")
   static class169 rssocket;
   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "[Lll;"
   )
   @Export("modIconSprites")
   static IndexedSprite[] modIconSprites;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgs;I)V",
      garbageValue = "-879679091"
   )
   @Export("initializeGPI")
   static final void initializeGPI(PacketBuffer var0) {
      var0.bitAccess();
      int var1 = Client.localInteractingIndex;
      Player var2 = SoundTaskDataProvider.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.playerId = var1;
      int var3 = var0.getBits(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class138.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.getSize() << 6);
      var2.pathY[0] = var6 - class23.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.getSize() << 6);
      BoundingBox3DDrawMode.plane = var2.field856 = var4;
      if(class93.field1430[var1] != null) {
         var2.decodeApperance(class93.field1430[var1]);
      }

      class93.playerIndexesCount = 0;
      class93.playerIndices[++class93.playerIndexesCount - 1] = var1;
      class93.field1428[var1] = 0;
      class93.field1433 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.getBits(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class93.Players_regions[var7] = (var10 << 14) + var11 + (var9 << 28);
            class93.Players_orientations[var7] = 0;
            class93.Players_targetIndices[var7] = -1;
            class93.field1435[++class93.field1433 - 1] = var7;
            class93.field1428[var7] = 0;
         }
      }

      var0.byteAccess();
   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(ZLgs;I)V",
      garbageValue = "349487721"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0, PacketBuffer var1) {
      Client.isDynamicRegion = var0;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      if(!Client.isDynamicRegion) {
         int var2 = var1.method3555();
         var3 = var1.method3554();
         var4 = var1.readUnsignedShort();
         class152.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               class152.xteaKeys[var5][var6] = var1.readInt();
            }
         }

         class298.mapRegions = new int[var4];
         ItemContainer.landMapFileIds = new int[var4];
         FontName.landRegionFileIds = new int[var4];
         Varbit.field3544 = new byte[var4][];
         Client.field1139 = new byte[var4][];
         boolean var16 = false;
         if((var3 / 8 == 48 || var3 / 8 == 49) && var2 / 8 == 48) {
            var16 = true;
         }

         if(var3 / 8 == 48 && var2 / 8 == 148) {
            var16 = true;
         }

         var4 = 0;

         for(var6 = (var3 - 6) / 8; var6 <= (var3 + 6) / 8; ++var6) {
            for(var7 = (var2 - 6) / 8; var7 <= (var2 + 6) / 8; ++var7) {
               var8 = var7 + (var6 << 8);
               if(!var16 || var7 != 49 && var7 != 149 && var7 != 147 && var6 != 50 && (var6 != 49 || var7 != 47)) {
                  class298.mapRegions[var4] = var8;
                  ItemContainer.landMapFileIds[var4] = MouseRecorder.indexMaps.getFile("m" + var6 + "_" + var7);
                  FontName.landRegionFileIds[var4] = MouseRecorder.indexMaps.getFile("l" + var6 + "_" + var7);
                  ++var4;
               }
            }
         }

         class289.method5207(var3, var2, true);
      } else {
         boolean var15 = var1.method3538() == 1;
         var3 = var1.method3554();
         var4 = var1.method3554();
         var5 = var1.readUnsignedShort();
         var1.bitAccess();

         int var9;
         for(var6 = 0; var6 < 4; ++var6) {
            for(var7 = 0; var7 < 13; ++var7) {
               for(var8 = 0; var8 < 13; ++var8) {
                  var9 = var1.getBits(1);
                  if(var9 == 1) {
                     Client.instanceTemplateChunks[var6][var7][var8] = var1.getBits(26);
                  } else {
                     Client.instanceTemplateChunks[var6][var7][var8] = -1;
                  }
               }
            }
         }

         var1.byteAccess();
         class152.xteaKeys = new int[var5][4];

         for(var6 = 0; var6 < var5; ++var6) {
            for(var7 = 0; var7 < 4; ++var7) {
               class152.xteaKeys[var6][var7] = var1.readInt();
            }
         }

         class298.mapRegions = new int[var5];
         ItemContainer.landMapFileIds = new int[var5];
         FontName.landRegionFileIds = new int[var5];
         Varbit.field3544 = new byte[var5][];
         Client.field1139 = new byte[var5][];
         var5 = 0;

         for(var6 = 0; var6 < 4; ++var6) {
            for(var7 = 0; var7 < 13; ++var7) {
               for(var8 = 0; var8 < 13; ++var8) {
                  var9 = Client.instanceTemplateChunks[var6][var7][var8];
                  if(var9 != -1) {
                     int var10 = var9 >> 14 & 1023;
                     int var11 = var9 >> 3 & 2047;
                     int var12 = (var10 / 8 << 8) + var11 / 8;

                     int var13;
                     for(var13 = 0; var13 < var5; ++var13) {
                        if(class298.mapRegions[var13] == var12) {
                           var12 = -1;
                           break;
                        }
                     }

                     if(var12 != -1) {
                        class298.mapRegions[var5] = var12;
                        var13 = var12 >> 8 & 255;
                        int var14 = var12 & 255;
                        ItemContainer.landMapFileIds[var5] = MouseRecorder.indexMaps.getFile("m" + var13 + "_" + var14);
                        FontName.landRegionFileIds[var5] = MouseRecorder.indexMaps.getFile("l" + var13 + "_" + var14);
                        ++var5;
                     }
                  }
               }
            }
         }

         class289.method5207(var3, var4, !var15);
      }

   }
}
