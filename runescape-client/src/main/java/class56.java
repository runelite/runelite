import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.applet.Applet;

@ObfuscatedName("bg")
public class class56 {
   @ObfuscatedName("qx")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   @Export("indexStore255")
   static IndexFile indexStore255;
   @ObfuscatedName("qi")
   @ObfuscatedSignature(
      signature = "Ln;"
   )
   @Export("grandExchangeEvents")
   static GrandExchangeEvents grandExchangeEvents;
   @ObfuscatedName("a")
   public static Applet field622;
   @ObfuscatedName("w")
   public static String field621;
   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   @Export("fontPlain11")
   static Font fontPlain11;

   static {
      field622 = null;
      field621 = null;
   }

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(ZLgy;I)V",
      garbageValue = "-1311328675"
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
         int var2 = var1.method3297();
         var3 = var1.readUnsignedShortOb1();
         var4 = var1.readUnsignedShort();
         class21.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               class21.xteaKeys[var5][var6] = var1.readInt();
            }
         }

         class64.mapRegions = new int[var4];
         class91.landMapFileIds = new int[var4];
         GraphicsObject.landRegionFileIds = new int[var4];
         ClanMember.field842 = new byte[var4][];
         WorldMapType3.field365 = new byte[var4][];
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
                  class64.mapRegions[var4] = var8;
                  class91.landMapFileIds[var4] = SceneComposition.indexMaps.getFile("m" + var6 + "_" + var7);
                  GraphicsObject.landRegionFileIds[var4] = SceneComposition.indexMaps.getFile("l" + var6 + "_" + var7);
                  ++var4;
               }
            }
         }

         class60.method983(var3, var2, true);
      } else {
         boolean var15 = var1.method3274() == 1;
         var3 = var1.method3299();
         var4 = var1.method3299();
         var5 = var1.readUnsignedShort();
         var1.bitAccess();

         int var9;
         for(var6 = 0; var6 < 4; ++var6) {
            for(var7 = 0; var7 < 13; ++var7) {
               for(var8 = 0; var8 < 13; ++var8) {
                  var9 = var1.getBits(1);
                  if(var9 == 1) {
                     Client.field902[var6][var7][var8] = var1.getBits(26);
                  } else {
                     Client.field902[var6][var7][var8] = -1;
                  }
               }
            }
         }

         var1.byteAccess();
         class21.xteaKeys = new int[var5][4];

         for(var6 = 0; var6 < var5; ++var6) {
            for(var7 = 0; var7 < 4; ++var7) {
               class21.xteaKeys[var6][var7] = var1.readInt();
            }
         }

         class64.mapRegions = new int[var5];
         class91.landMapFileIds = new int[var5];
         GraphicsObject.landRegionFileIds = new int[var5];
         ClanMember.field842 = new byte[var5][];
         WorldMapType3.field365 = new byte[var5][];
         var5 = 0;

         for(var6 = 0; var6 < 4; ++var6) {
            for(var7 = 0; var7 < 13; ++var7) {
               for(var8 = 0; var8 < 13; ++var8) {
                  var9 = Client.field902[var6][var7][var8];
                  if(var9 != -1) {
                     int var10 = var9 >> 14 & 1023;
                     int var11 = var9 >> 3 & 2047;
                     int var12 = (var10 / 8 << 8) + var11 / 8;

                     int var13;
                     for(var13 = 0; var13 < var5; ++var13) {
                        if(class64.mapRegions[var13] == var12) {
                           var12 = -1;
                           break;
                        }
                     }

                     if(var12 != -1) {
                        class64.mapRegions[var5] = var12;
                        var13 = var12 >> 8 & 255;
                        int var14 = var12 & 255;
                        class91.landMapFileIds[var5] = SceneComposition.indexMaps.getFile("m" + var13 + "_" + var14);
                        GraphicsObject.landRegionFileIds[var5] = SceneComposition.indexMaps.getFile("l" + var13 + "_" + var14);
                        ++var5;
                     }
                  }
               }
            }
         }

         class60.method983(var3, var4, !var15);
      }

   }
}
