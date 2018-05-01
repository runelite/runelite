import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
@Implements("MapLabel")
public class MapLabel {
   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "Lbg;"
   )
   @Export("mouseRecorder")
   static MouseRecorder mouseRecorder;
   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("indexWorldMap")
   static IndexData indexWorldMap;
   @ObfuscatedName("g")
   @Export("text")
   String text;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1904029967
   )
   int field460;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1831486839
   )
   int field462;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lx;"
   )
   @Export("fontSize")
   Size fontSize;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IILx;)V"
   )
   MapLabel(String var1, int var2, int var3, Size var4) {
      this.text = var1;
      this.field460 = var2;
      this.field462 = var3;
      this.fontSize = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "103"
   )
   static boolean method374(String var0) {
      if(var0 == null) {
         return false;
      } else {
         try {
            new URL(var0);
            return true;
         } catch (MalformedURLException var2) {
            return false;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "533169362"
   )
   public static boolean method375(int var0) {
      return (var0 >> 31 & 1) != 0;
   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(ZLgl;I)V",
      garbageValue = "-506284622"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0, PacketBuffer var1) {
      Client.isDynamicRegion = var0;
      int var2;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      if(!Client.isDynamicRegion) {
         var2 = var1.method3627();
         int var3 = var1.method3635();
         var4 = var1.readUnsignedShort();
         MapIcon.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               MapIcon.xteaKeys[var5][var6] = var1.readInt();
            }
         }

         class20.mapRegions = new int[var4];
         class23.landMapFileIds = new int[var4];
         CombatInfo1.landRegionFileIds = new int[var4];
         class88.field1323 = new byte[var4][];
         BoundingBox3DDrawMode.field270 = new byte[var4][];
         boolean var16 = false;
         if((var2 / 8 == 48 || var2 / 8 == 49) && var3 / 8 == 48) {
            var16 = true;
         }

         if(var2 / 8 == 48 && var3 / 8 == 148) {
            var16 = true;
         }

         var4 = 0;

         for(var6 = (var2 - 6) / 8; var6 <= (var2 + 6) / 8; ++var6) {
            for(var7 = (var3 - 6) / 8; var7 <= (var3 + 6) / 8; ++var7) {
               var8 = var7 + (var6 << 8);
               if(!var16 || var7 != 49 && var7 != 149 && var7 != 147 && var6 != 50 && (var6 != 49 || var7 != 47)) {
                  class20.mapRegions[var4] = var8;
                  class23.landMapFileIds[var4] = SoundTaskDataProvider.indexMaps.getFile("m" + var6 + "_" + var7);
                  CombatInfo1.landRegionFileIds[var4] = SoundTaskDataProvider.indexMaps.getFile("l" + var6 + "_" + var7);
                  ++var4;
               }
            }
         }

         class7.method33(var2, var3, true);
      } else {
         var2 = var1.method3635();
         boolean var15 = var1.method3628() == 1;
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
         MapIcon.xteaKeys = new int[var5][4];

         for(var6 = 0; var6 < var5; ++var6) {
            for(var7 = 0; var7 < 4; ++var7) {
               MapIcon.xteaKeys[var6][var7] = var1.readInt();
            }
         }

         class20.mapRegions = new int[var5];
         class23.landMapFileIds = new int[var5];
         CombatInfo1.landRegionFileIds = new int[var5];
         class88.field1323 = new byte[var5][];
         BoundingBox3DDrawMode.field270 = new byte[var5][];
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
                        if(class20.mapRegions[var13] == var12) {
                           var12 = -1;
                           break;
                        }
                     }

                     if(var12 != -1) {
                        class20.mapRegions[var5] = var12;
                        var13 = var12 >> 8 & 255;
                        int var14 = var12 & 255;
                        class23.landMapFileIds[var5] = SoundTaskDataProvider.indexMaps.getFile("m" + var13 + "_" + var14);
                        CombatInfo1.landRegionFileIds[var5] = SoundTaskDataProvider.indexMaps.getFile("l" + var13 + "_" + var14);
                        ++var5;
                     }
                  }
               }
            }
         }

         class7.method33(var2, var4, !var15);
      }

   }
}
