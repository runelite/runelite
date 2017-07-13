import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
final class class5 implements class0 {
   @ObfuscatedName("er")
   @Export("font_p12full")
   static Font font_p12full;

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "100"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.isDynamicRegion = var0;
      int var1;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.isDynamicRegion) {
         var1 = Client.secretPacketBuffer2.readUnsignedShort();
         int var2 = Client.secretPacketBuffer2.readByteOb1();
         var3 = Client.secretPacketBuffer2.readUnsignedShort();
         class73.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class73.xteaKeys[var4][var5] = Client.secretPacketBuffer2.readInt();
            }
         }

         RSCanvas.mapRegions = new int[var3];
         class10.field259 = new int[var3];
         CombatInfoListHolder.landRegionFielIds = new int[var3];
         class39.field525 = new byte[var3][];
         class25.field365 = new byte[var3][];
         boolean var15 = false;
         if((var1 / 8 == 48 || var1 / 8 == 49) && var2 / 8 == 48) {
            var15 = true;
         }

         if(var1 / 8 == 48 && var2 / 8 == 148) {
            var15 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (var1 + 6) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (var2 + 6) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var15 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  RSCanvas.mapRegions[var3] = var7;
                  class10.field259[var3] = class12.indexMaps.getFile("m" + var5 + "_" + var6);
                  CombatInfoListHolder.landRegionFielIds[var3] = class12.indexMaps.getFile("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         Varcs.method1789(var1, var2, true);
      } else {
         var1 = Client.secretPacketBuffer2.readUnsignedShortOb1();
         boolean var14 = Client.secretPacketBuffer2.method3249() == 1;
         var3 = Client.secretPacketBuffer2.readUnsignedShortOb1();
         var4 = Client.secretPacketBuffer2.readUnsignedShort();
         Client.secretPacketBuffer2.bitAccess();

         int var8;
         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var8 = Client.secretPacketBuffer2.getBits(1);
                  if(var8 == 1) {
                     Client.field1119[var5][var6][var7] = Client.secretPacketBuffer2.getBits(26);
                  } else {
                     Client.field1119[var5][var6][var7] = -1;
                  }
               }
            }
         }

         Client.secretPacketBuffer2.byteAccess();
         class73.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               class73.xteaKeys[var5][var6] = Client.secretPacketBuffer2.readInt();
            }
         }

         RSCanvas.mapRegions = new int[var4];
         class10.field259 = new int[var4];
         CombatInfoListHolder.landRegionFielIds = new int[var4];
         class39.field525 = new byte[var4][];
         class25.field365 = new byte[var4][];
         var4 = 0;

         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var8 = Client.field1119[var5][var6][var7];
                  if(var8 != -1) {
                     int var9 = var8 >> 14 & 1023;
                     int var10 = var8 >> 3 & 2047;
                     int var11 = (var9 / 8 << 8) + var10 / 8;

                     int var12;
                     for(var12 = 0; var12 < var4; ++var12) {
                        if(RSCanvas.mapRegions[var12] == var11) {
                           var11 = -1;
                           break;
                        }
                     }

                     if(var11 != -1) {
                        RSCanvas.mapRegions[var4] = var11;
                        var12 = var11 >> 8 & 255;
                        int var13 = var11 & 255;
                        class10.field259[var4] = class12.indexMaps.getFile("m" + var12 + "_" + var13);
                        CombatInfoListHolder.landRegionFielIds[var4] = class12.indexMaps.getFile("l" + var12 + "_" + var13);
                        ++var4;
                     }
                  }
               }
            }
         }

         Varcs.method1789(var1, var3, !var14);
      }

   }
}
