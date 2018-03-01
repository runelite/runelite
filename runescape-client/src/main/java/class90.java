import java.text.DecimalFormat;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
public class class90 {
   @ObfuscatedName("d")
   static boolean field1343;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1899485945
   )
   static int field1336;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   static IndexedSprite field1356;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   @Export("runeSprites")
   static IndexedSprite[] runeSprites;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lly;"
   )
   static SpritePixels field1338;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lly;"
   )
   static SpritePixels field1340;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   @Export("logoSprite")
   static IndexedSprite logoSprite;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   static IndexedSprite field1342;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1368220797
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("j")
   static int[] field1344;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 290470851
   )
   static int field1345;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1051380913
   )
   static int field1346;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 538201555
   )
   static int field1347;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -195717053
   )
   static int field1352;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1989542503
   )
   static int field1359;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1019983803
   )
   static int field1350;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1388666353
   )
   @Export("loadingBarPercentage")
   static int loadingBarPercentage;
   @ObfuscatedName("aq")
   @Export("loadingText")
   static String loadingText;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 697155513
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("ad")
   @Export("Login_response0")
   static String Login_response0;
   @ObfuscatedName("ar")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("ao")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("at")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("ag")
   @Export("username")
   static String username;
   @ObfuscatedName("an")
   @Export("password")
   static String password;
   @ObfuscatedName("ax")
   @Export("Login_isUsernameRemembered")
   static boolean Login_isUsernameRemembered;
   @ObfuscatedName("av")
   static boolean field1335;
   @ObfuscatedName("bc")
   static boolean field1362;
   @ObfuscatedName("bl")
   static boolean field1363;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 2064553993
   )
   static int field1364;
   @ObfuscatedName("bm")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 687527079
   )
   static int field1368;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      longValue = -6118141378853504073L
   )
   static long field1369;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      longValue = 7103010554099090951L
   )
   static long field1370;

   static {
      field1336 = 0;
      loginWindowX = field1336 + 202;
      field1344 = new int[256];
      field1345 = 0;
      field1346 = 0;
      field1347 = 0;
      field1352 = 0;
      field1359 = 0;
      field1350 = 0;
      loadingBarPercentage = 10;
      loadingText = "";
      loginIndex = 0;
      Login_response0 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      password = "";
      Login_isUsernameRemembered = false;
      field1335 = false;
      field1362 = false;
      field1363 = true;
      field1364 = 0;
      worldSelectShown = false;
      field1368 = -1;
      new DecimalFormat("##0.00");
      new class160();
      field1369 = -1L;
      field1370 = -1L;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Ljr;",
      garbageValue = "-784571536"
   )
   public static class270 method1941(int var0) {
      class270 var1 = (class270)class270.field3474.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class270.field3471.getConfigData(19, var0);
         var1 = new class270();
         if(var2 != null) {
            var1.method4912(new Buffer(var2));
         }

         class270.field3474.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IZIZI)V",
      garbageValue = "-64268121"
   )
   static void method1940(int var0, boolean var1, int var2, boolean var3) {
      if(World.worldList != null) {
         Resampler.method2358(0, World.worldList.length - 1, var0, var1, var2, var3);
      }

   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(ZLgb;I)V",
      garbageValue = "-1803424955"
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
         int var2 = var1.method3620();
         var3 = var1.method3620();
         var4 = var1.readUnsignedShort();
         class158.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               class158.xteaKeys[var5][var6] = var1.readInt();
            }
         }

         WorldMapData.mapRegions = new int[var4];
         MapLabel.landMapFileIds = new int[var4];
         TotalQuantityComparator.landRegionFileIds = new int[var4];
         Buffer.field2570 = new byte[var4][];
         UnitPriceComparator.field320 = new byte[var4][];
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
                  WorldMapData.mapRegions[var4] = var8;
                  MapLabel.landMapFileIds[var4] = BuildType.indexMaps.getFile("m" + var6 + "_" + var7);
                  TotalQuantityComparator.landRegionFileIds[var4] = BuildType.indexMaps.getFile("l" + var6 + "_" + var7);
                  ++var4;
               }
            }
         }

         WorldMapType1.method280(var2, var3, true);
      } else {
         boolean var15 = var1.method3583() == 1;
         var3 = var1.method3620();
         var4 = var1.readUnsignedShortOb1();
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
         class158.xteaKeys = new int[var5][4];

         for(var6 = 0; var6 < var5; ++var6) {
            for(var7 = 0; var7 < 4; ++var7) {
               class158.xteaKeys[var6][var7] = var1.readInt();
            }
         }

         WorldMapData.mapRegions = new int[var5];
         MapLabel.landMapFileIds = new int[var5];
         TotalQuantityComparator.landRegionFileIds = new int[var5];
         Buffer.field2570 = new byte[var5][];
         UnitPriceComparator.field320 = new byte[var5][];
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
                        if(WorldMapData.mapRegions[var13] == var12) {
                           var12 = -1;
                           break;
                        }
                     }

                     if(var12 != -1) {
                        WorldMapData.mapRegions[var5] = var12;
                        var13 = var12 >> 8 & 255;
                        int var14 = var12 & 255;
                        MapLabel.landMapFileIds[var5] = BuildType.indexMaps.getFile("m" + var13 + "_" + var14);
                        TotalQuantityComparator.landRegionFileIds[var5] = BuildType.indexMaps.getFile("l" + var13 + "_" + var14);
                        ++var5;
                     }
                  }
               }
            }
         }

         WorldMapType1.method280(var4, var3, !var15);
      }

   }
}
