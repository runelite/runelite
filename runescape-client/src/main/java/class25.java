import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public class class25 {
   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   static Widget field373;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = 43507605
   )
   static int field377;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = 312366923
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1481703975
   )
   int field382;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   Coordinates field384;

   @ObfuscatedSignature(
      signature = "(ILhh;)V"
   )
   class25(int var1, Coordinates var2) {
      this.field382 = var1;
      this.field384 = var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lia;Ljava/lang/String;Ljava/lang/String;I)[Ljr;",
      garbageValue = "-746166272"
   )
   public static IndexedSprite[] method197(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return GroundObject.method2508(var0, var3, var4);
   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-371461505"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.isDynamicRegion = var0;
      int var1;
      int var2;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.isDynamicRegion) {
         var1 = Client.secretPacketBuffer2.method3209();
         var2 = Client.secretPacketBuffer2.method3329();
         int var3 = Client.secretPacketBuffer2.readUnsignedShort();
         Player.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               Player.xteaKeys[var4][var5] = Client.secretPacketBuffer2.readInt();
            }
         }

         class141.mapRegions = new int[var3];
         Ignore.field872 = new int[var3];
         class15.landRegionFielIds = new int[var3];
         class15.field298 = new byte[var3][];
         class29.field431 = new byte[var3][];
         boolean var15 = false;
         if((var2 / 8 == 48 || var2 / 8 == 49) && var1 / 8 == 48) {
            var15 = true;
         }

         if(var2 / 8 == 48 && var1 / 8 == 148) {
            var15 = true;
         }

         var3 = 0;

         for(var5 = (var2 - 6) / 8; var5 <= (var2 + 6) / 8; ++var5) {
            for(var6 = (var1 - 6) / 8; var6 <= (var1 + 6) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var15 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class141.mapRegions[var3] = var7;
                  Ignore.field872[var3] = class14.indexMaps.getFile("m" + var5 + "_" + var6);
                  class15.landRegionFielIds[var3] = class14.indexMaps.getFile("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class19.method150(var2, var1, true);
      } else {
         var1 = Client.secretPacketBuffer2.method3210();
         var2 = Client.secretPacketBuffer2.method3210();
         boolean var14 = Client.secretPacketBuffer2.readUnsignedByte() == 1;
         var4 = Client.secretPacketBuffer2.readUnsignedShort();
         Client.secretPacketBuffer2.bitAccess();

         int var8;
         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var8 = Client.secretPacketBuffer2.getBits(1);
                  if(var8 == 1) {
                     Client.field998[var5][var6][var7] = Client.secretPacketBuffer2.getBits(26);
                  } else {
                     Client.field998[var5][var6][var7] = -1;
                  }
               }
            }
         }

         Client.secretPacketBuffer2.byteAccess();
         Player.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               Player.xteaKeys[var5][var6] = Client.secretPacketBuffer2.readInt();
            }
         }

         class141.mapRegions = new int[var4];
         Ignore.field872 = new int[var4];
         class15.landRegionFielIds = new int[var4];
         class15.field298 = new byte[var4][];
         class29.field431 = new byte[var4][];
         var4 = 0;

         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var8 = Client.field998[var5][var6][var7];
                  if(var8 != -1) {
                     int var9 = var8 >> 14 & 1023;
                     int var10 = var8 >> 3 & 2047;
                     int var11 = (var9 / 8 << 8) + var10 / 8;

                     int var12;
                     for(var12 = 0; var12 < var4; ++var12) {
                        if(class141.mapRegions[var12] == var11) {
                           var11 = -1;
                           break;
                        }
                     }

                     if(var11 != -1) {
                        class141.mapRegions[var4] = var11;
                        var12 = var11 >> 8 & 255;
                        int var13 = var11 & 255;
                        Ignore.field872[var4] = class14.indexMaps.getFile("m" + var12 + "_" + var13);
                        class15.landRegionFielIds[var4] = class14.indexMaps.getFile("l" + var12 + "_" + var13);
                        ++var4;
                     }
                  }
               }
            }
         }

         class19.method150(var2, var1, !var14);
      }

   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-100"
   )
   @Export("getTileHeight")
   static final int getTileHeight(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class61.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = var6 * class61.tileHeights[var5][var3 + 1][var4] + (128 - var6) * class61.tileHeights[var5][var3][var4] >> 7;
         int var9 = class61.tileHeights[var5][var3][var4 + 1] * (128 - var6) + var6 * class61.tileHeights[var5][var3 + 1][var4 + 1] >> 7;
         return var9 * var7 + var8 * (128 - var7) >> 7;
      } else {
         return 0;
      }
   }
}
