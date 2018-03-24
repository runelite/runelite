import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public class class23 {
   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   @Export("compass")
   static SpritePixels compass;
   @ObfuscatedName("je")
   @ObfuscatedGetter(
      intValue = -562717215
   )
   static int field331;

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(ZLgz;I)V",
      garbageValue = "-1126633063"
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
         int var2 = var1.method3574();
         var3 = var1.method3576();
         var4 = var1.readUnsignedShort();
         BuildType.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               BuildType.xteaKeys[var5][var6] = var1.readInt();
            }
         }

         IndexDataBase.mapRegions = new int[var4];
         class66.landMapFileIds = new int[var4];
         GraphicsObject.landRegionFileIds = new int[var4];
         class204.field2601 = new byte[var4][];
         class81.field1253 = new byte[var4][];
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
                  IndexDataBase.mapRegions[var4] = var8;
                  class66.landMapFileIds[var4] = VertexNormal.indexMaps.getFile("m" + var6 + "_" + var7);
                  GraphicsObject.landRegionFileIds[var4] = VertexNormal.indexMaps.getFile("l" + var6 + "_" + var7);
                  ++var4;
               }
            }
         }

         class64.method1131(var3, var2, true);
      } else {
         boolean var15 = var1.method3565() == 1;
         var3 = var1.method3576();
         var4 = var1.readUnsignedShort();
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
         BuildType.xteaKeys = new int[var5][4];

         for(var6 = 0; var6 < var5; ++var6) {
            for(var7 = 0; var7 < 4; ++var7) {
               BuildType.xteaKeys[var6][var7] = var1.readInt();
            }
         }

         IndexDataBase.mapRegions = new int[var5];
         class66.landMapFileIds = new int[var5];
         GraphicsObject.landRegionFileIds = new int[var5];
         class204.field2601 = new byte[var5][];
         class81.field1253 = new byte[var5][];
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
                        if(IndexDataBase.mapRegions[var13] == var12) {
                           var12 = -1;
                           break;
                        }
                     }

                     if(var12 != -1) {
                        IndexDataBase.mapRegions[var5] = var12;
                        var13 = var12 >> 8 & 255;
                        int var14 = var12 & 255;
                        class66.landMapFileIds[var5] = VertexNormal.indexMaps.getFile("m" + var13 + "_" + var14);
                        GraphicsObject.landRegionFileIds[var5] = VertexNormal.indexMaps.getFile("l" + var13 + "_" + var14);
                        ++var5;
                     }
                  }
               }
            }
         }

         class64.method1131(var4, var3, !var15);
      }

   }
}
