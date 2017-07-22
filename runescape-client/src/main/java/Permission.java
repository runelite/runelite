import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
@Implements("Permission")
public enum Permission implements RSEnum {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   field3142(0, -1, true, false, true),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   field3140(1, 0, true, true, true),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   field3141(2, 1, true, true, false),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   field3149(3, 2, false, false, true),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   field3143(4, 3, false, false, true),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   field3144(5, 10, false, false, true);

   @ObfuscatedName("k")
   public final boolean field3139;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1129103389
   )
   final int field3145;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1183323705
   )
   public final int field3146;
   @ObfuscatedName("p")
   public final boolean field3147;

   Permission(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.field3145 = var3;
      this.field3146 = var4;
      this.field3147 = var6;
      this.field3139 = var7;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1443879177"
   )
   public int rsOrdinal() {
      return this.field3145;
   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "([Lho;IB)V",
      garbageValue = "0"
   )
   static final void method3990(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.hasScript || !class11.method55(var3))) {
            if(var3.type == 0) {
               if(!var3.hasScript && class11.method55(var3) && var3 != class3.field14) {
                  continue;
               }

               method3990(var0, var3.id);
               if(var3.children != null) {
                  method3990(var3.children, var3.id);
               }

               WidgetNode var7 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var7 != null) {
                  class56.method788(var7.id);
               }
            }

            if(var3.type == 6) {
               int var5;
               if(var3.field2664 != -1 || var3.field2665 != -1) {
                  boolean var4 = AbstractSoundSystem.method1998(var3);
                  if(var4) {
                     var5 = var3.field2665;
                  } else {
                     var5 = var3.field2664;
                  }

                  if(var5 != -1) {
                     Sequence var6 = class31.getAnimation(var5);

                     for(var3.field2676 += Client.field1066; var3.field2676 > var6.frameLenghts[var3.field2739]; class21.method156(var3)) {
                        var3.field2676 -= var6.frameLenghts[var3.field2739];
                        ++var3.field2739;
                        if(var3.field2739 >= var6.frameIDs.length) {
                           var3.field2739 -= var6.frameStep;
                           if(var3.field2739 < 0 || var3.field2739 >= var6.frameIDs.length) {
                              var3.field2739 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2673 != 0 && !var3.hasScript) {
                  int var8 = var3.field2673 >> 16;
                  var5 = var3.field2673 << 16 >> 16;
                  var8 *= Client.field1066;
                  var5 *= Client.field1066;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  class21.method156(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljt;Ljt;Ljt;ZI)V",
      garbageValue = "635381113"
   )
   @Export("drawLoginScreen")
   static void drawLoginScreen(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class92.field1417 = (class45.canvasWidth - 765) / 2;
         class92.loginWindowX = class92.field1417 + 202;
      }

      byte var4;
      int var5;
      int var7;
      int var9;
      int var10;
      int var11;
      int var12;
      int var29;
      int var31;
      int var32;
      int var36;
      if(class92.worldSelectShown) {
         if(class23.field340 == null) {
            class23.field340 = class269.method4759(class271.indexSprites, "sl_back", "");
         }

         if(class175.field2368 == null) {
            class175.field2368 = class269.method4758(class271.indexSprites, "sl_flags", "");
         }

         if(WorldMapType2.field521 == null) {
            WorldMapType2.field521 = class269.method4758(class271.indexSprites, "sl_arrows", "");
         }

         if(class164.field2280 == null) {
            class164.field2280 = class269.method4758(class271.indexSprites, "sl_stars", "");
         }

         Rasterizer2D.method4828(class92.field1417, 23, 765, 480, 0);
         Rasterizer2D.method4833(class92.field1417, 0, 125, 23, 12425273, 9135624);
         Rasterizer2D.method4833(class92.field1417 + 125, 0, 640, 23, 5197647, 2697513);
         var0.method4643("Select a world", class92.field1417 + 62, 15, 0, -1);
         if(class164.field2280 != null) {
            class164.field2280[1].method4941(class92.field1417 + 140, 1);
            var1.method4640("Members only world", class92.field1417 + 152, 10, 16777215, -1);
            class164.field2280[0].method4941(class92.field1417 + 140, 12);
            var1.method4640("Free world", class92.field1417 + 152, 21, 16777215, -1);
         }

         if(WorldMapType2.field521 != null) {
            var29 = class92.field1417 + 280;
            if(World.field1281[0] == 0 && World.field1285[0] == 0) {
               WorldMapType2.field521[2].method4941(var29, 4);
            } else {
               WorldMapType2.field521[0].method4941(var29, 4);
            }

            if(World.field1281[0] == 0 && World.field1285[0] == 1) {
               WorldMapType2.field521[3].method4941(var29 + 15, 4);
            } else {
               WorldMapType2.field521[1].method4941(var29 + 15, 4);
            }

            var0.method4640("World", var29 + 32, 17, 16777215, -1);
            var5 = class92.field1417 + 390;
            if(World.field1281[0] == 1 && World.field1285[0] == 0) {
               WorldMapType2.field521[2].method4941(var5, 4);
            } else {
               WorldMapType2.field521[0].method4941(var5, 4);
            }

            if(World.field1281[0] == 1 && World.field1285[0] == 1) {
               WorldMapType2.field521[3].method4941(var5 + 15, 4);
            } else {
               WorldMapType2.field521[1].method4941(var5 + 15, 4);
            }

            var0.method4640("Players", var5 + 32, 17, 16777215, -1);
            var31 = class92.field1417 + 500;
            if(World.field1281[0] == 2 && World.field1285[0] == 0) {
               WorldMapType2.field521[2].method4941(var31, 4);
            } else {
               WorldMapType2.field521[0].method4941(var31, 4);
            }

            if(World.field1281[0] == 2 && World.field1285[0] == 1) {
               WorldMapType2.field521[3].method4941(var31 + 15, 4);
            } else {
               WorldMapType2.field521[1].method4941(var31 + 15, 4);
            }

            var0.method4640("Location", var31 + 32, 17, 16777215, -1);
            var7 = class92.field1417 + 610;
            if(World.field1281[0] == 3 && World.field1285[0] == 0) {
               WorldMapType2.field521[2].method4941(var7, 4);
            } else {
               WorldMapType2.field521[0].method4941(var7, 4);
            }

            if(World.field1281[0] == 3 && World.field1285[0] == 1) {
               WorldMapType2.field521[3].method4941(var7 + 15, 4);
            } else {
               WorldMapType2.field521[1].method4941(var7 + 15, 4);
            }

            var0.method4640("Type", var7 + 32, 17, 16777215, -1);
         }

         Rasterizer2D.method4828(class92.field1417 + 708, 4, 50, 16, 0);
         var1.method4643("Cancel", class92.field1417 + 708 + 25, 16, 16777215, -1);
         class92.field1426 = -1;
         if(class23.field340 != null) {
            var4 = 88;
            byte var35 = 19;
            var31 = 765 / (var4 + 1);
            var7 = 480 / (var35 + 1);

            do {
               var32 = var7;
               var9 = var31;
               if((var31 - 1) * var7 >= World.worldCount) {
                  --var31;
               }

               if((var7 - 1) * var31 >= World.worldCount) {
                  --var7;
               }

               if((var7 - 1) * var31 >= World.worldCount) {
                  --var7;
               }
            } while(var32 != var7 || var31 != var9);

            var32 = (765 - var31 * var4) / (var31 + 1);
            if(var32 > 5) {
               var32 = 5;
            }

            var9 = (480 - var35 * var7) / (var7 + 1);
            if(var9 > 5) {
               var9 = 5;
            }

            var10 = (765 - var31 * var4 - (var31 - 1) * var32) / 2;
            var11 = (480 - var35 * var7 - (var7 - 1) * var9) / 2;
            var12 = var11 + 23;
            var36 = var10 + class92.field1417;
            int var14 = 0;
            boolean var15 = false;

            int var16;
            for(var16 = 0; var16 < World.worldCount; ++var16) {
               World var17 = class64.worldList[var16];
               boolean var18 = true;
               String var19 = Integer.toString(var17.playerCount);
               if(var17.playerCount == -1) {
                  var19 = "OFF";
                  var18 = false;
               } else if(var17.playerCount > 1980) {
                  var19 = "FULL";
                  var18 = false;
               }

               int var21 = 0;
               byte var20;
               if(var17.method1506()) {
                  if(var17.method1507()) {
                     var20 = 7;
                  } else {
                     var20 = 6;
                  }
               } else if(var17.method1511()) {
                  var21 = 16711680;
                  if(var17.method1507()) {
                     var20 = 5;
                  } else {
                     var20 = 4;
                  }
               } else if(var17.method1512()) {
                  if(var17.method1507()) {
                     var20 = 3;
                  } else {
                     var20 = 2;
                  }
               } else if(var17.method1507()) {
                  var20 = 1;
               } else {
                  var20 = 0;
               }

               if(MouseInput.field730 >= var36 && MouseInput.field731 >= var12 && MouseInput.field730 < var36 + var4 && MouseInput.field731 < var35 + var12 && var18) {
                  class92.field1426 = var16;
                  class23.field340[var20].method4987(var36, var12, 128, 16777215);
                  var15 = true;
               } else {
                  class23.field340[var20].method4956(var36, var12);
               }

               if(class175.field2368 != null) {
                  class175.field2368[(var17.method1507()?8:0) + var17.location].method4941(var36 + 29, var12);
               }

               var0.method4643(Integer.toString(var17.id), var36 + 15, var12 + var35 / 2 + 5, var21, -1);
               var1.method4643(var19, var36 + 60, var12 + var35 / 2 + 5, 268435455, -1);
               var12 += var9 + var35;
               ++var14;
               if(var14 >= var7) {
                  var12 = var11 + 23;
                  var36 += var4 + var32;
                  var14 = 0;
               }
            }

            if(var15) {
               var16 = var1.method4635(class64.worldList[class92.field1426].activity) + 6;
               int var23 = var1.verticalSpace + 8;
               Rasterizer2D.method4828(MouseInput.field730 - var16 / 2, MouseInput.field731 + 20 + 5, var16, var23, 16777120);
               Rasterizer2D.drawRectangle(MouseInput.field730 - var16 / 2, MouseInput.field731 + 20 + 5, var16, var23, 0);
               var1.method4643(class64.worldList[class92.field1426].activity, MouseInput.field730, var1.verticalSpace + MouseInput.field731 + 20 + 5 + 4, 0, -1);
            }
         }

         WorldMapType1.field417.vmethod4917(0, 0);
      } else {
         if(var3) {
            class92.field1394.method4956(class92.field1417, 0);
            class92.field1399.method4956(class92.field1417 + 382, 0);
            class92.logoSprite.method4941(class92.field1417 + 382 - class92.logoSprite.originalWidth / 2, 18);
         }

         if(Client.gameState == 0 || Client.gameState == 5) {
            var4 = 20;
            var0.method4643("RuneScape is loading - please wait...", class92.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.drawRectangle(class92.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.drawRectangle(class92.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.method4828(class92.loginWindowX + 180 - 150, var5 + 2, class92.loadingBarPercentage * 3, 30, 9179409);
            Rasterizer2D.method4828(class92.loadingBarPercentage * 3 + (class92.loginWindowX + 180 - 150), var5 + 2, 300 - class92.loadingBarPercentage * 3, 30, 0);
            var0.method4643(class92.loadingText, class92.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var22;
         short var28;
         short var30;
         if(Client.gameState == 20) {
            class92.field1396.method4941(class92.loginWindowX + 180 - class92.field1396.originalWidth / 2, 271 - class92.field1396.height / 2);
            var28 = 211;
            var0.method4643(class92.loginMessage1, class92.loginWindowX + 180, var28, 16776960, 0);
            var29 = var28 + 15;
            var0.method4643(class92.loginMessage2, class92.loginWindowX + 180, var29, 16776960, 0);
            var29 += 15;
            var0.method4643(class92.loginMessage3, class92.loginWindowX + 180, var29, 16776960, 0);
            var29 += 15;
            var29 += 10;
            if(class92.loginIndex != 4) {
               var0.method4640("Login: ", class92.loginWindowX + 180 - 110, var29, 16777215, 0);
               var30 = 200;

               for(var22 = class92.username; var0.method4635(var22) > var30; var22 = var22.substring(0, var22.length() - 1)) {
                  ;
               }

               var0.method4640(FontTypeFace.appendTags(var22), class92.loginWindowX + 180 - 70, var29, 16777215, 0);
               var29 += 15;
               var0.method4640("Password: " + WorldListFetcher.method1472(class92.password), class92.loginWindowX + 180 - 108, var29, 16777215, 0);
               var29 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class92.field1396.method4941(class92.loginWindowX, 171);
            short var6;
            if(class92.loginIndex == 0) {
               var28 = 251;
               var0.method4643("Welcome to RuneScape", class92.loginWindowX + 180, var28, 16776960, 0);
               var29 = var28 + 30;
               var5 = class92.loginWindowX + 180 - 80;
               var6 = 291;
               class92.field1397.method4941(var5 - 73, var6 - 20);
               var0.method4644("New User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class92.loginWindowX + 180 + 80;
               class92.field1397.method4941(var5 - 73, var6 - 20);
               var0.method4644("Existing User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class92.loginIndex == 1) {
               var0.method4643(class92.field1419, class92.loginWindowX + 180, 211, 16776960, 0);
               var28 = 236;
               var0.method4643(class92.loginMessage1, class92.loginWindowX + 180, var28, 16777215, 0);
               var29 = var28 + 15;
               var0.method4643(class92.loginMessage2, class92.loginWindowX + 180, var29, 16777215, 0);
               var29 += 15;
               var0.method4643(class92.loginMessage3, class92.loginWindowX + 180, var29, 16777215, 0);
               var29 += 15;
               var5 = class92.loginWindowX + 180 - 80;
               var6 = 321;
               class92.field1397.method4941(var5 - 73, var6 - 20);
               var0.method4643("Continue", var5, var6 + 5, 16777215, 0);
               var5 = class92.loginWindowX + 180 + 80;
               class92.field1397.method4941(var5 - 73, var6 - 20);
               var0.method4643("Cancel", var5, var6 + 5, 16777215, 0);
            } else {
               short var8;
               if(class92.loginIndex == 2) {
                  var28 = 211;
                  var0.method4643(class92.loginMessage1, class92.loginWindowX + 180, var28, 16776960, 0);
                  var29 = var28 + 15;
                  var0.method4643(class92.loginMessage2, class92.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var0.method4643(class92.loginMessage3, class92.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var29 += 10;
                  var0.method4640("Login: ", class92.loginWindowX + 180 - 110, var29, 16777215, 0);
                  var30 = 200;

                  for(var22 = class92.username; var0.method4635(var22) > var30; var22 = var22.substring(1)) {
                     ;
                  }

                  var0.method4640(FontTypeFace.appendTags(var22) + (class92.loginIndex2 == 0 & Client.gameCycle % 40 < 20?class8.getColTags(16776960) + "|":""), class92.loginWindowX + 180 - 70, var29, 16777215, 0);
                  var29 += 15;
                  var0.method4640("Password: " + WorldListFetcher.method1472(class92.password) + (class92.loginIndex2 == 1 & Client.gameCycle % 40 < 20?class8.getColTags(16776960) + "|":""), class92.loginWindowX + 180 - 108, var29, 16777215, 0);
                  var29 += 15;
                  var7 = class92.loginWindowX + 180 - 80;
                  var8 = 321;
                  class92.field1397.method4941(var7 - 73, var8 - 20);
                  var0.method4643("Login", var7, var8 + 5, 16777215, 0);
                  var7 = class92.loginWindowX + 180 + 80;
                  class92.field1397.method4941(var7 - 73, var8 - 20);
                  var0.method4643("Cancel", var7, var8 + 5, 16777215, 0);
                  var28 = 357;
                  var1.method4643("Forgotten your password? <col=ffffff>Click here.", class92.loginWindowX + 180, var28, 16776960, 0);
               } else if(class92.loginIndex == 3) {
                  var28 = 201;
                  var0.method4643("Invalid username or password.", class92.loginWindowX + 180, var28, 16776960, 0);
                  var29 = var28 + 20;
                  var1.method4643("For accounts created after 24th November 2010, please use your", class92.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var1.method4643("email address to login. Otherwise please login with your username.", class92.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var5 = class92.loginWindowX + 180;
                  var6 = 276;
                  class92.field1397.method4941(var5 - 73, var6 - 20);
                  var2.method4643("Try again", var5, var6 + 5, 16777215, 0);
                  var5 = class92.loginWindowX + 180;
                  var6 = 326;
                  class92.field1397.method4941(var5 - 73, var6 - 20);
                  var2.method4643("Forgotten password?", var5, var6 + 5, 16777215, 0);
               } else if(class92.loginIndex == 4) {
                  var0.method4643("Authenticator", class92.loginWindowX + 180, 211, 16776960, 0);
                  var28 = 236;
                  var0.method4643(class92.loginMessage1, class92.loginWindowX + 180, var28, 16777215, 0);
                  var29 = var28 + 15;
                  var0.method4643(class92.loginMessage2, class92.loginWindowX + 180, var29, 16777215, 0);
                  var29 += 15;
                  var0.method4643(class92.loginMessage3, class92.loginWindowX + 180, var29, 16777215, 0);
                  var29 += 15;
                  var22 = "PIN: ";
                  String var25 = Occluder.authCode;
                  String var26 = MouseInput.method974('*', var25.length());
                  var0.method4640(var22 + var26 + (Client.gameCycle % 40 < 20?class8.getColTags(16776960) + "|":""), class92.loginWindowX + 180 - 108, var29, 16777215, 0);
                  var29 -= 8;
                  var0.method4640("Trust this computer", class92.loginWindowX + 180 - 9, var29, 16776960, 0);
                  var29 += 15;
                  var0.method4640("for 30 days: ", class92.loginWindowX + 180 - 9, var29, 16776960, 0);
                  var9 = class92.loginWindowX + 180 - 9 + var0.method4635("for 30 days: ") + 15;
                  var10 = var29 - var0.verticalSpace;
                  IndexedSprite var27;
                  if(class92.field1424) {
                     var27 = WorldMapType1.field413;
                  } else {
                     var27 = class177.field2382;
                  }

                  var27.method4941(var9, var10);
                  var29 += 15;
                  var12 = class92.loginWindowX + 180 - 80;
                  short var13 = 321;
                  class92.field1397.method4941(var12 - 73, var13 - 20);
                  var0.method4643("Continue", var12, var13 + 5, 16777215, 0);
                  var12 = class92.loginWindowX + 180 + 80;
                  class92.field1397.method4941(var12 - 73, var13 - 20);
                  var0.method4643("Cancel", var12, var13 + 5, 16777215, 0);
                  var1.method4643("<u=ff>Can\'t Log In?</u>", class92.loginWindowX + 180, var13 + 36, 255, 0);
               } else if(class92.loginIndex == 5) {
                  var0.method4643("Forgotten your password?", class92.loginWindowX + 180, 201, 16776960, 0);
                  var28 = 221;
                  var2.method4643(class92.loginMessage1, class92.loginWindowX + 180, var28, 16776960, 0);
                  var29 = var28 + 15;
                  var2.method4643(class92.loginMessage2, class92.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var2.method4643(class92.loginMessage3, class92.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var29 += 14;
                  var0.method4640("Username/email: ", class92.loginWindowX + 180 - 145, var29, 16777215, 0);
                  var30 = 174;

                  for(var22 = class92.username; var0.method4635(var22) > var30; var22 = var22.substring(1)) {
                     ;
                  }

                  var0.method4640(FontTypeFace.appendTags(var22) + (Client.gameCycle % 40 < 20?class8.getColTags(16776960) + "|":""), class92.loginWindowX + 180 - 34, var29, 16777215, 0);
                  var29 += 15;
                  var7 = class92.loginWindowX + 180 - 80;
                  var8 = 321;
                  class92.field1397.method4941(var7 - 73, var8 - 20);
                  var0.method4643("Recover", var7, var8 + 5, 16777215, 0);
                  var7 = class92.loginWindowX + 180 + 80;
                  class92.field1397.method4941(var7 - 73, var8 - 20);
                  var0.method4643("Back", var7, var8 + 5, 16777215, 0);
               } else if(class92.loginIndex == 6) {
                  var28 = 211;
                  var0.method4643(class92.loginMessage1, class92.loginWindowX + 180, var28, 16776960, 0);
                  var29 = var28 + 15;
                  var0.method4643(class92.loginMessage2, class92.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var0.method4643(class92.loginMessage3, class92.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var5 = class92.loginWindowX + 180;
                  var6 = 321;
                  class92.field1397.method4941(var5 - 73, var6 - 20);
                  var0.method4643("Back", var5, var6 + 5, 16777215, 0);
               }
            }
         }

         if(class92.field1412 > 0) {
            var29 = class92.field1412;
            var30 = 256;
            class92.field1410 += var29 * 128;
            if(class92.field1410 > class92.field1406.length) {
               class92.field1410 -= class92.field1406.length;
               var31 = (int)(Math.random() * 12.0D);
               class20.method151(class36.field493[var31]);
            }

            var31 = 0;
            var7 = var29 * 128;
            var32 = (var30 - var29) * 128;

            for(var9 = 0; var9 < var32; ++var9) {
               var10 = class24.field348[var7 + var31] - var29 * class92.field1406[var31 + class92.field1410 & class92.field1406.length - 1] / 6;
               if(var10 < 0) {
                  var10 = 0;
               }

               class24.field348[var31++] = var10;
            }

            for(var9 = var30 - var29; var9 < var30; ++var9) {
               var10 = var9 * 128;

               for(var11 = 0; var11 < 128; ++var11) {
                  var12 = (int)(Math.random() * 100.0D);
                  if(var12 < 50 && var11 > 10 && var11 < 118) {
                     class24.field348[var11 + var10] = 255;
                  } else {
                     class24.field348[var10 + var11] = 0;
                  }
               }
            }

            if(class92.field1395 > 0) {
               class92.field1395 -= var29 * 4;
            }

            if(class92.field1407 > 0) {
               class92.field1407 -= var29 * 4;
            }

            if(class92.field1395 == 0 && class92.field1407 == 0) {
               var9 = (int)(Math.random() * (double)(2000 / var29));
               if(var9 == 0) {
                  class92.field1395 = 1024;
               }

               if(var9 == 1) {
                  class92.field1407 = 1024;
               }
            }

            for(var9 = 0; var9 < var30 - var29; ++var9) {
               class92.field1423[var9] = class92.field1423[var29 + var9];
            }

            for(var9 = var30 - var29; var9 < var30; ++var9) {
               class92.field1423[var9] = (int)(Math.sin((double)class92.field1413 / 14.0D) * 16.0D + Math.sin((double)class92.field1413 / 15.0D) * 14.0D + Math.sin((double)class92.field1413 / 16.0D) * 12.0D);
               ++class92.field1413;
            }

            class92.field1411 += var29;
            var9 = ((Client.gameCycle & 1) + var29) / 2;
            if(var9 > 0) {
               for(var10 = 0; var10 < class92.field1411 * 100; ++var10) {
                  var11 = (int)(Math.random() * 124.0D) + 2;
                  var12 = (int)(Math.random() * 128.0D) + 128;
                  class24.field348[var11 + (var12 << 7)] = 192;
               }

               class92.field1411 = 0;
               var10 = 0;

               label547:
               while(true) {
                  if(var10 >= var30) {
                     var10 = 0;

                     while(true) {
                        if(var10 >= 128) {
                           break label547;
                        }

                        var11 = 0;

                        for(var12 = -var9; var12 < var30; ++var12) {
                           var36 = var12 * 128;
                           if(var9 + var12 < var30) {
                              var11 += CombatInfo1.field1271[var9 * 128 + var36 + var10];
                           }

                           if(var12 - (var9 + 1) >= 0) {
                              var11 -= CombatInfo1.field1271[var36 + var10 - (var9 + 1) * 128];
                           }

                           if(var12 >= 0) {
                              class24.field348[var10 + var36] = var11 / (var9 * 2 + 1);
                           }
                        }

                        ++var10;
                     }
                  }

                  var11 = 0;
                  var12 = var10 * 128;

                  for(var36 = -var9; var36 < 128; ++var36) {
                     if(var9 + var36 < 128) {
                        var11 += class24.field348[var9 + var12 + var36];
                     }

                     if(var36 - (var9 + 1) >= 0) {
                        var11 -= class24.field348[var12 + var36 - (var9 + 1)];
                     }

                     if(var36 >= 0) {
                        CombatInfo1.field1271[var12 + var36] = var11 / (var9 * 2 + 1);
                     }
                  }

                  ++var10;
               }
            }

            class92.field1412 = 0;
         }

         Signlink.method2882();
         AbstractByteBuffer.titlemuteSprite[class34.preferences.muted?1:0].method4941(class92.field1417 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.languageId == 0) {
            if(WorldMapType2.field522 != null) {
               var29 = class92.field1417 + 5;
               var30 = 463;
               byte var33 = 100;
               byte var34 = 35;
               WorldMapType2.field522.method4941(var29, var30);
               var0.method4643("World" + " " + Client.world, var29 + var33 / 2, var30 + var34 / 2 - 2, 16777215, 0);
               if(class265.listFetcher != null) {
                  var1.method4643("Loading...", var29 + var33 / 2, var30 + var34 / 2 + 12, 16777215, 0);
               } else {
                  var1.method4643("Click to switch", var29 + var33 / 2, var30 + var34 / 2 + 12, 16777215, 0);
               }
            } else {
               WorldMapType2.field522 = Occluder.getSprite(class271.indexSprites, "sl_button", "");
            }
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILip;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "-1767598396"
   )
   public static void method3996(int var0, IndexDataBase var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.getFile(var2);
      int var7 = var1.getChild(var6, var3);
      class134.method2519(var0, var1, var6, var7, var4, var5);
   }
}
