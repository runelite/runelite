import java.text.DecimalFormat;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
public class class89 {
   @ObfuscatedName("s")
   static boolean field1329;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1824112419
   )
   static int field1356;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   static IndexedSprite field1319;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "[Lkh;"
   )
   @Export("runeSprites")
   static IndexedSprite[] runeSprites;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   static IndexedSprite field1321;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1462013979
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 61557269
   )
   static int field1323;
   @ObfuscatedName("y")
   static int[] field1325;
   @ObfuscatedName("e")
   static int[] field1326;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1763972043
   )
   static int field1327;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1769454175
   )
   static int field1355;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1453909673
   )
   static int field1328;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1068147523
   )
   static int field1347;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1253517941
   )
   static int field1331;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 455158567
   )
   static int field1332;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1863592157
   )
   @Export("loadingBarPercentage")
   static int loadingBarPercentage;
   @ObfuscatedName("ai")
   @Export("loadingText")
   static String loadingText;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 854369067
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("am")
   @Export("Login_response0")
   static String Login_response0;
   @ObfuscatedName("ah")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("ag")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("az")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("ae")
   @Export("username")
   static String username;
   @ObfuscatedName("ao")
   @Export("password")
   static String password;
   @ObfuscatedName("av")
   @Export("Login_isUsernameRemembered")
   static boolean Login_isUsernameRemembered;
   @ObfuscatedName("ac")
   static boolean field1344;
   @ObfuscatedName("bj")
   static boolean field1345;
   @ObfuscatedName("bm")
   static boolean field1346;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -675977997
   )
   static int field1317;
   @ObfuscatedName("bq")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "[Lkh;"
   )
   @Export("slFlagSprites")
   static IndexedSprite[] slFlagSprites;
   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "[Lkh;"
   )
   @Export("slArrowSprites")
   static IndexedSprite[] slArrowSprites;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -790337029
   )
   static int field1353;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      longValue = -3589199354240235951L
   )
   static long field1338;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      longValue = 4531988219323204223L
   )
   static long field1354;
   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "[Lkh;"
   )
   @Export("mapscene")
   static IndexedSprite[] mapscene;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = -162657369
   )
   @Export("cameraX")
   static int cameraX;

   static {
      field1356 = 0;
      loginWindowX = field1356 + 202;
      field1325 = new int[256];
      field1327 = 0;
      field1355 = 0;
      field1328 = 0;
      field1347 = 0;
      field1331 = 0;
      field1332 = 0;
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
      field1344 = false;
      field1345 = false;
      field1346 = true;
      field1317 = 0;
      worldSelectShown = false;
      field1353 = -1;
      new DecimalFormat("##0.00");
      new class150();
      field1338 = -1L;
      field1354 = -1L;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)Lkh;",
      garbageValue = "-1"
   )
   static IndexedSprite method1909() {
      IndexedSprite var0 = new IndexedSprite();
      var0.width = class310.field3908;
      var0.originalHeight = class310.field3910;
      var0.offsetX = class219.field2698[0];
      var0.offsetY = class263.offsetsY[0];
      var0.originalWidth = class60.field708[0];
      var0.height = class310.field3911[0];
      var0.palette = class289.field3786;
      var0.pixels = class310.spritePixels[0];
      Name.method5282();
      return var0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-68924624"
   )
   static final void method1941(int var0) {
      short var1 = 256;
      field1328 += var0 * 128;
      int var2;
      if(field1328 > class43.field547.length) {
         field1328 -= class43.field547.length;
         var2 = (int)(Math.random() * 12.0D);
         class18.method143(runeSprites[var2]);
      }

      var2 = 0;
      int var3 = var0 * 128;
      int var4 = (var1 - var0) * 128;

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = OwnWorldComparator.field838[var3 + var2] - var0 * class43.field547[var2 + field1328 & class43.field547.length - 1] / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         OwnWorldComparator.field838[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = var5 * 128;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               OwnWorldComparator.field838[var7 + var6] = 255;
            } else {
               OwnWorldComparator.field838[var7 + var6] = 0;
            }
         }
      }

      if(field1327 > 0) {
         field1327 -= var0 * 4;
      }

      if(field1355 > 0) {
         field1355 -= var0 * 4;
      }

      if(field1327 == 0 && field1355 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            field1327 = 1024;
         }

         if(var5 == 1) {
            field1355 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         field1325[var5] = field1325[var0 + var5];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         field1325[var5] = (int)(Math.sin((double)field1332 / 14.0D) * 16.0D + Math.sin((double)field1332 / 15.0D) * 14.0D + Math.sin((double)field1332 / 16.0D) * 12.0D);
         ++field1332;
      }

      field1347 += var0;
      var5 = (var0 + (Client.gameCycle & 1)) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < field1347 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            OwnWorldComparator.field838[var7 + (var8 << 7)] = 192;
         }

         field1347 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = var6 * 128;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var5 + var9 < 128) {
                  var7 += OwnWorldComparator.field838[var5 + var8 + var9];
               }

               if(var9 - (var5 + 1) >= 0) {
                  var7 -= OwnWorldComparator.field838[var8 + var9 - (var5 + 1)];
               }

               if(var9 >= 0) {
                  class31.field424[var8 + var9] = var7 / (var5 * 2 + 1);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = var8 * 128;
               if(var8 + var5 < var1) {
                  var7 += class31.field424[var9 + var6 + var5 * 128];
               }

               if(var8 - (var5 + 1) >= 0) {
                  var7 -= class31.field424[var9 + var6 - (var5 + 1) * 128];
               }

               if(var8 >= 0) {
                  OwnWorldComparator.field838[var9 + var6] = var7 / (var5 * 2 + 1);
               }
            }
         }
      }

   }

   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-27"
   )
   static final void method1939() {
      for(Projectile var0 = (Projectile)Client.projectiles.getFront(); var0 != null; var0 = (Projectile)Client.projectiles.getNext()) {
         if(var0.floor == class60.plane && Client.gameCycle <= var0.endCycle) {
            if(Client.gameCycle >= var0.startMovementCycle) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.moveProjectile(var1.x, var1.y, MessageNode.getTileHeight(var1.x, var1.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var2 = -var0.interacting - 1;
                  Player var3;
                  if(var2 == Client.localInteractingIndex) {
                     var3 = GroundObject.localPlayer;
                  } else {
                     var3 = Client.cachedPlayers[var2];
                  }

                  if(var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.moveProjectile(var3.x, var3.y, MessageNode.getTileHeight(var3.x, var3.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               var0.update(Client.field1091);
               TotalQuantityComparator.region.method2915(class60.plane, (int)var0.x, (int)var0.y, (int)var0.z, 60, var0, var0.rotationX, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("jc")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2060496660"
   )
   static void method1899(int var0, int var1) {
      class226.method4410(class36.topContextMenuRow, var0, var1);
      class36.topContextMenuRow = null;
   }
}
