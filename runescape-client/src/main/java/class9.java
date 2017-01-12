import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public final class class9 {
   @ObfuscatedName("ie")
   static class38 field89;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -993537949
   )
   static int field90;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass208;Lclass208;Lclass208;ZI)V",
      garbageValue = "72353073"
   )
   static void method116(class208 var0, class208 var1, class208 var2, boolean var3) {
      if(var3) {
         class41.field846 = (class0.field1 - Client.field495) / 2;
         class41.loginWindowX = class41.field846 + 202;
      }

      byte var4;
      int var5;
      int var7;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      Graphics var23;
      int var29;
      int var31;
      int var32;
      int var33;
      if(class41.worldSelectShown) {
         if(class7.field67 == null) {
            class7.field67 = class25.method592(class0.field4, "sl_back", "");
         }

         if(null == Ignore.field204) {
            Ignore.field204 = Buffer.method2988(class0.field4, "sl_flags", "");
         }

         if(null == XItemContainer.field133) {
            XItemContainer.field133 = Buffer.method2988(class0.field4, "sl_arrows", "");
         }

         if(class65.field1102 == null) {
            class65.field1102 = Buffer.method2988(class0.field4, "sl_stars", "");
         }

         class219.method3993(class41.field846, 23, 765, 480, 0);
         class219.method3991(class41.field846, 0, 125, 23, 12425273, 9135624);
         class219.method3991(125 + class41.field846, 0, 640, 23, 5197647, 2697513);
         var0.method3870("Select a world", 62 + class41.field846, 15, 0, -1);
         if(null != class65.field1102) {
            class65.field1102[1].method4066(140 + class41.field846, 1);
            var1.method3867("Members only world", class41.field846 + 152, 10, 16777215, -1);
            class65.field1102[0].method4066(class41.field846 + 140, 12);
            var1.method3867("Free world", 152 + class41.field846, 21, 16777215, -1);
         }

         if(null != XItemContainer.field133) {
            var29 = 280 + class41.field846;
            if(World.field674[0] == 0 && World.field676[0] == 0) {
               XItemContainer.field133[2].method4066(var29, 4);
            } else {
               XItemContainer.field133[0].method4066(var29, 4);
            }

            if(World.field674[0] == 0 && World.field676[0] == 1) {
               XItemContainer.field133[3].method4066(15 + var29, 4);
            } else {
               XItemContainer.field133[1].method4066(var29 + 15, 4);
            }

            var0.method3867("World", 32 + var29, 17, 16777215, -1);
            var5 = class41.field846 + 390;
            if(World.field674[0] == 1 && World.field676[0] == 0) {
               XItemContainer.field133[2].method4066(var5, 4);
            } else {
               XItemContainer.field133[0].method4066(var5, 4);
            }

            if(World.field674[0] == 1 && World.field676[0] == 1) {
               XItemContainer.field133[3].method4066(15 + var5, 4);
            } else {
               XItemContainer.field133[1].method4066(15 + var5, 4);
            }

            var0.method3867("Players", 32 + var5, 17, 16777215, -1);
            var31 = 500 + class41.field846;
            if(World.field674[0] == 2 && World.field676[0] == 0) {
               XItemContainer.field133[2].method4066(var31, 4);
            } else {
               XItemContainer.field133[0].method4066(var31, 4);
            }

            if(World.field674[0] == 2 && World.field676[0] == 1) {
               XItemContainer.field133[3].method4066(var31 + 15, 4);
            } else {
               XItemContainer.field133[1].method4066(var31 + 15, 4);
            }

            var0.method3867("Location", 32 + var31, 17, 16777215, -1);
            var7 = 610 + class41.field846;
            if(World.field674[0] == 3 && World.field676[0] == 0) {
               XItemContainer.field133[2].method4066(var7, 4);
            } else {
               XItemContainer.field133[0].method4066(var7, 4);
            }

            if(World.field674[0] == 3 && World.field676[0] == 1) {
               XItemContainer.field133[3].method4066(15 + var7, 4);
            } else {
               XItemContainer.field133[1].method4066(15 + var7, 4);
            }

            var0.method3867("Type", var7 + 32, 17, 16777215, -1);
         }

         class219.method3993(class41.field846 + 708, 4, 50, 16, 0);
         var1.method3870("Cancel", 25 + class41.field846 + 708, 16, 16777215, -1);
         class41.field841 = -1;
         if(class7.field67 != null) {
            var4 = 88;
            byte var36 = 19;
            var31 = 765 / (var4 + 1);
            var7 = 480 / (1 + var36);

            do {
               var32 = var7;
               var33 = var31;
               if(var7 * (var31 - 1) >= World.field684) {
                  --var31;
               }

               if((var7 - 1) * var31 >= World.field684) {
                  --var7;
               }

               if((var7 - 1) * var31 >= World.field684) {
                  --var7;
               }
            } while(var7 != var32 || var31 != var33);

            var32 = (765 - var4 * var31) / (1 + var31);
            if(var32 > 5) {
               var32 = 5;
            }

            var33 = (480 - var36 * var7) / (var7 + 1);
            if(var33 > 5) {
               var33 = 5;
            }

            var10 = (765 - var31 * var4 - var32 * (var31 - 1)) / 2;
            var11 = (480 - var7 * var36 - (var7 - 1) * var33) / 2;
            var12 = 23 + var11;
            var13 = class41.field846 + var10;
            var14 = 0;
            boolean var15 = false;

            int var16;
            for(var16 = 0; var16 < World.field684; ++var16) {
               World var17 = World.worldList[var16];
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
               if(var17.method631()) {
                  if(var17.method636()) {
                     var20 = 7;
                  } else {
                     var20 = 6;
                  }
               } else if(var17.method646()) {
                  var21 = 16711680;
                  if(var17.method636()) {
                     var20 = 5;
                  } else {
                     var20 = 4;
                  }
               } else if(var17.method625()) {
                  if(var17.method636()) {
                     var20 = 3;
                  } else {
                     var20 = 2;
                  }
               } else if(var17.method636()) {
                  var20 = 1;
               } else {
                  var20 = 0;
               }

               if(class115.field1788 >= var13 && class115.field1789 >= var12 && class115.field1788 < var13 + var4 && class115.field1789 < var12 + var36 && var18) {
                  class41.field841 = var16;
                  class7.field67[var20].method4109(var13, var12, 128, 16777215);
                  var15 = true;
               } else {
                  class7.field67[var20].method4123(var13, var12);
               }

               if(Ignore.field204 != null) {
                  Ignore.field204[(var17.method636()?8:0) + var17.location].method4066(var13 + 29, var12);
               }

               var0.method3870(Integer.toString(var17.id), var13 + 15, 5 + var36 / 2 + var12, var21, -1);
               var1.method3870(var19, 60 + var13, var12 + var36 / 2 + 5, 268435455, -1);
               var12 += var33 + var36;
               ++var14;
               if(var14 >= var7) {
                  var12 = 23 + var11;
                  var13 += var4 + var32;
                  var14 = 0;
               }
            }

            if(var15) {
               var16 = var1.method3874(World.worldList[class41.field841].activity) + 6;
               int var22 = var1.field3087 + 8;
               class219.method3993(class115.field1788 - var16 / 2, 5 + 20 + class115.field1789, var16, var22, 16777120);
               class219.method3977(class115.field1788 - var16 / 2, 5 + 20 + class115.field1789, var16, var22, 0);
               var1.method3870(World.worldList[class41.field841].activity, class115.field1788, var1.field3087 + 20 + class115.field1789 + 5 + 4, 0, -1);
            }
         }

         try {
            var23 = class165.canvas.getGraphics();
            GameEngine.bufferProvider.draw(var23, 0, 0);
         } catch (Exception var26) {
            class165.canvas.repaint();
         }

      } else {
         if(var3) {
            class41.field809.method4123(class41.field846, 0);
            class41.field840.method4123(382 + class41.field846, 0);
            class229.field3246.method4066(class41.field846 + 382 - class229.field3246.originalWidth / 2, 18);
         }

         if(Client.gameState == 0 || Client.gameState == 5) {
            var4 = 20;
            var0.method3870("RuneScape is loading - please wait...", 180 + class41.loginWindowX, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            class219.method3977(class41.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            class219.method3977(class41.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            class219.method3993(180 + class41.loginWindowX - 150, var5 + 2, class41.field825 * 3, 30, 9179409);
            class219.method3993(class41.field825 * 3 + (class41.loginWindowX + 180 - 150), var5 + 2, 300 - class41.field825 * 3, 30, 0);
            var0.method3870(class41.field826, 180 + class41.loginWindowX, 276 - var4, 16777215, -1);
         }

         String var24;
         short var28;
         short var30;
         if(Client.gameState == 20) {
            class41.field807.method4066(180 + class41.loginWindowX - class41.field807.originalWidth / 2, 271 - class41.field807.height / 2);
            var28 = 211;
            var0.method3870(class41.loginMessage1, 180 + class41.loginWindowX, var28, 16776960, 0);
            var29 = var28 + 15;
            var0.method3870(class41.loginMessage2, class41.loginWindowX + 180, var29, 16776960, 0);
            var29 += 15;
            var0.method3870(class41.loginMessage3, class41.loginWindowX + 180, var29, 16776960, 0);
            var29 += 15;
            var29 += 10;
            if(class41.loginIndex != 4) {
               var0.method3867("Login: ", 180 + class41.loginWindowX - 110, var29, 16777215, 0);
               var30 = 200;

               for(var24 = class41.username; var0.method3874(var24) > var30; var24 = var24.substring(0, var24.length() - 1)) {
                  ;
               }

               var0.method3867(class209.method3866(var24), 180 + class41.loginWindowX - 70, var29, 16777215, 0);
               var29 += 15;
               var0.method3867("Password: " + class6.method94(class41.field833), class41.loginWindowX + 180 - 108, var29, 16777215, 0);
               var29 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class41.field807.method4066(class41.loginWindowX, 171);
            short var6;
            if(class41.loginIndex == 0) {
               var28 = 251;
               var0.method3870("Welcome to RuneScape", class41.loginWindowX + 180, var28, 16776960, 0);
               var29 = var28 + 30;
               var5 = class41.loginWindowX + 180 - 80;
               var6 = 291;
               class41.field808.method4066(var5 - 73, var6 - 20);
               var0.method3871("New User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class41.loginWindowX + 180 + 80;
               class41.field808.method4066(var5 - 73, var6 - 20);
               var0.method3871("Existing User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class41.loginIndex == 1) {
               var0.method3870(class41.field828, class41.loginWindowX + 180, 211, 16776960, 0);
               var28 = 236;
               var0.method3870(class41.loginMessage1, class41.loginWindowX + 180, var28, 16777215, 0);
               var29 = var28 + 15;
               var0.method3870(class41.loginMessage2, class41.loginWindowX + 180, var29, 16777215, 0);
               var29 += 15;
               var0.method3870(class41.loginMessage3, 180 + class41.loginWindowX, var29, 16777215, 0);
               var29 += 15;
               var5 = class41.loginWindowX + 180 - 80;
               var6 = 321;
               class41.field808.method4066(var5 - 73, var6 - 20);
               var0.method3870("Continue", var5, var6 + 5, 16777215, 0);
               var5 = 80 + 180 + class41.loginWindowX;
               class41.field808.method4066(var5 - 73, var6 - 20);
               var0.method3870("Cancel", var5, var6 + 5, 16777215, 0);
            } else {
               short var8;
               if(class41.loginIndex == 2) {
                  var28 = 211;
                  var0.method3870(class41.loginMessage1, 180 + class41.loginWindowX, var28, 16776960, 0);
                  var29 = var28 + 15;
                  var0.method3870(class41.loginMessage2, 180 + class41.loginWindowX, var29, 16776960, 0);
                  var29 += 15;
                  var0.method3870(class41.loginMessage3, 180 + class41.loginWindowX, var29, 16776960, 0);
                  var29 += 15;
                  var29 += 10;
                  var0.method3867("Login: ", class41.loginWindowX + 180 - 110, var29, 16777215, 0);
                  var30 = 200;

                  for(var24 = class41.username; var0.method3874(var24) > var30; var24 = var24.substring(1)) {
                     ;
                  }

                  var0.method3867(class209.method3866(var24) + (class41.loginIndex2 == 0 & Client.gameCycle % 40 < 20?class32.method691(16776960) + "|":""), 180 + class41.loginWindowX - 70, var29, 16777215, 0);
                  var29 += 15;
                  var0.method3867("Password: " + class6.method94(class41.field833) + (class41.loginIndex2 == 1 & Client.gameCycle % 40 < 20?class32.method691(16776960) + "|":""), class41.loginWindowX + 180 - 108, var29, 16777215, 0);
                  var29 += 15;
                  var7 = 180 + class41.loginWindowX - 80;
                  var8 = 321;
                  class41.field808.method4066(var7 - 73, var8 - 20);
                  var0.method3870("Login", var7, var8 + 5, 16777215, 0);
                  var7 = 80 + 180 + class41.loginWindowX;
                  class41.field808.method4066(var7 - 73, var8 - 20);
                  var0.method3870("Cancel", var7, 5 + var8, 16777215, 0);
                  var28 = 357;
                  var1.method3870("Forgotten your password? <col=ffffff>Click here.", 180 + class41.loginWindowX, var28, 16776960, 0);
               } else if(class41.loginIndex == 3) {
                  var28 = 201;
                  var0.method3870("Invalid username or password.", class41.loginWindowX + 180, var28, 16776960, 0);
                  var29 = var28 + 20;
                  var1.method3870("For accounts created after 24th November 2010, please use your", class41.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var1.method3870("email address to login. Otherwise please login with your username.", 180 + class41.loginWindowX, var29, 16776960, 0);
                  var29 += 15;
                  var5 = 180 + class41.loginWindowX;
                  var6 = 276;
                  class41.field808.method4066(var5 - 73, var6 - 20);
                  var2.method3870("Try again", var5, 5 + var6, 16777215, 0);
                  var5 = class41.loginWindowX + 180;
                  var6 = 326;
                  class41.field808.method4066(var5 - 73, var6 - 20);
                  var2.method3870("Forgotten password?", var5, 5 + var6, 16777215, 0);
               } else if(class41.loginIndex == 4) {
                  var0.method3870("Authenticator", 180 + class41.loginWindowX, 211, 16776960, 0);
                  var28 = 236;
                  var0.method3870(class41.loginMessage1, 180 + class41.loginWindowX, var28, 16777215, 0);
                  var29 = var28 + 15;
                  var0.method3870(class41.loginMessage2, class41.loginWindowX + 180, var29, 16777215, 0);
                  var29 += 15;
                  var0.method3870(class41.loginMessage3, class41.loginWindowX + 180, var29, 16777215, 0);
                  var29 += 15;
                  var0.method3867("PIN: " + class6.method94(XClanMember.authCode) + (Client.gameCycle % 40 < 20?class32.method691(16776960) + "|":""), class41.loginWindowX + 180 - 108, var29, 16777215, 0);
                  var29 -= 8;
                  var0.method3867("Trust this computer", 180 + class41.loginWindowX - 9, var29, 16776960, 0);
                  var29 += 15;
                  var0.method3867("for 30 days: ", 180 + class41.loginWindowX - 9, var29, 16776960, 0);
                  var5 = 180 + class41.loginWindowX - 9 + var0.method3874("for 30 days: ") + 15;
                  var31 = var29 - var0.field3087;
                  ModIcon var25;
                  if(class41.field835) {
                     var25 = class8.field80;
                  } else {
                     var25 = class41.field811;
                  }

                  var25.method4066(var5, var31);
                  var29 += 15;
                  var32 = class41.loginWindowX + 180 - 80;
                  short var9 = 321;
                  class41.field808.method4066(var32 - 73, var9 - 20);
                  var0.method3870("Continue", var32, var9 + 5, 16777215, 0);
                  var32 = 180 + class41.loginWindowX + 80;
                  class41.field808.method4066(var32 - 73, var9 - 20);
                  var0.method3870("Cancel", var32, 5 + var9, 16777215, 0);
                  var1.method3870("<u=ff>Can\'t Log In?</u>", class41.loginWindowX + 180, var9 + 36, 255, 0);
               } else if(class41.loginIndex == 5) {
                  var0.method3870("Forgotten your password?", 180 + class41.loginWindowX, 201, 16776960, 0);
                  var28 = 221;
                  var2.method3870(class41.loginMessage1, 180 + class41.loginWindowX, var28, 16776960, 0);
                  var29 = var28 + 15;
                  var2.method3870(class41.loginMessage2, class41.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var2.method3870(class41.loginMessage3, class41.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var29 += 14;
                  var0.method3867("Username/email: ", 180 + class41.loginWindowX - 145, var29, 16777215, 0);
                  var30 = 174;

                  for(var24 = class41.username; var0.method3874(var24) > var30; var24 = var24.substring(1)) {
                     ;
                  }

                  var0.method3867(class209.method3866(var24) + (Client.gameCycle % 40 < 20?class32.method691(16776960) + "|":""), class41.loginWindowX + 180 - 34, var29, 16777215, 0);
                  var29 += 15;
                  var7 = class41.loginWindowX + 180 - 80;
                  var8 = 321;
                  class41.field808.method4066(var7 - 73, var8 - 20);
                  var0.method3870("Recover", var7, 5 + var8, 16777215, 0);
                  var7 = 80 + class41.loginWindowX + 180;
                  class41.field808.method4066(var7 - 73, var8 - 20);
                  var0.method3870("Back", var7, 5 + var8, 16777215, 0);
               } else if(class41.loginIndex == 6) {
                  var28 = 211;
                  var0.method3870(class41.loginMessage1, 180 + class41.loginWindowX, var28, 16776960, 0);
                  var29 = var28 + 15;
                  var0.method3870(class41.loginMessage2, class41.loginWindowX + 180, var29, 16776960, 0);
                  var29 += 15;
                  var0.method3870(class41.loginMessage3, 180 + class41.loginWindowX, var29, 16776960, 0);
                  var29 += 15;
                  var5 = 180 + class41.loginWindowX;
                  var6 = 321;
                  class41.field808.method4066(var5 - 73, var6 - 20);
                  var0.method3870("Back", var5, 5 + var6, 16777215, 0);
               }
            }
         }

         if(class41.field823 > 0) {
            var29 = class41.field823;
            var30 = 256;
            class41.field821 += var29 * 128;
            if(class41.field821 > class88.field1531.length) {
               class41.field821 -= class88.field1531.length;
               var31 = (int)(Math.random() * 12.0D);
               class25.method593(NPC.field759[var31]);
            }

            var31 = 0;
            var7 = var29 * 128;
            var32 = (var30 - var29) * 128;

            for(var33 = 0; var33 < var32; ++var33) {
               var10 = class5.field48[var7 + var31] - var29 * class88.field1531[class41.field821 + var31 & class88.field1531.length - 1] / 6;
               if(var10 < 0) {
                  var10 = 0;
               }

               class5.field48[var31++] = var10;
            }

            for(var33 = var30 - var29; var33 < var30; ++var33) {
               var10 = var33 * 128;

               for(var11 = 0; var11 < 128; ++var11) {
                  var12 = (int)(Math.random() * 100.0D);
                  if(var12 < 50 && var11 > 10 && var11 < 118) {
                     class5.field48[var11 + var10] = 255;
                  } else {
                     class5.field48[var10 + var11] = 0;
                  }
               }
            }

            if(class41.field806 > 0) {
               class41.field806 -= 4 * var29;
            }

            if(class41.field810 > 0) {
               class41.field810 -= var29 * 4;
            }

            if(class41.field806 == 0 && class41.field810 == 0) {
               var33 = (int)(Math.random() * (double)(2000 / var29));
               if(var33 == 0) {
                  class41.field806 = 1024;
               }

               if(var33 == 1) {
                  class41.field810 = 1024;
               }
            }

            for(var33 = 0; var33 < var30 - var29; ++var33) {
               class41.field815[var33] = class41.field815[var29 + var33];
            }

            for(var33 = var30 - var29; var33 < var30; ++var33) {
               class41.field815[var33] = (int)(Math.sin((double)class41.field843 / 14.0D) * 16.0D + Math.sin((double)class41.field843 / 15.0D) * 14.0D + Math.sin((double)class41.field843 / 16.0D) * 12.0D);
               ++class41.field843;
            }

            class41.field822 += var29;
            var33 = ((Client.gameCycle & 1) + var29) / 2;
            if(var33 > 0) {
               for(var10 = 0; var10 < class41.field822 * 100; ++var10) {
                  var11 = (int)(Math.random() * 124.0D) + 2;
                  var12 = (int)(Math.random() * 128.0D) + 128;
                  class5.field48[(var12 << 7) + var11] = 192;
               }

               class41.field822 = 0;
               var10 = 0;

               label624:
               while(true) {
                  if(var10 >= var30) {
                     var10 = 0;

                     while(true) {
                        if(var10 >= 128) {
                           break label624;
                        }

                        var11 = 0;

                        for(var12 = -var33; var12 < var30; ++var12) {
                           var13 = 128 * var12;
                           if(var33 + var12 < var30) {
                              var11 += class41.field813[var13 + var10 + var33 * 128];
                           }

                           if(var12 - (1 + var33) >= 0) {
                              var11 -= class41.field813[var10 + var13 - 128 * (1 + var33)];
                           }

                           if(var12 >= 0) {
                              class5.field48[var13 + var10] = var11 / (1 + 2 * var33);
                           }
                        }

                        ++var10;
                     }
                  }

                  var11 = 0;
                  var12 = var10 * 128;

                  for(var13 = -var33; var13 < 128; ++var13) {
                     if(var33 + var13 < 128) {
                        var11 += class5.field48[var33 + var13 + var12];
                     }

                     if(var13 - (1 + var33) >= 0) {
                        var11 -= class5.field48[var12 + var13 - (var33 + 1)];
                     }

                     if(var13 >= 0) {
                        class41.field813[var12 + var13] = var11 / (1 + 2 * var33);
                     }
                  }

                  ++var10;
               }
            }

            class41.field823 = 0;
         }

         var28 = 256;
         if(class41.field806 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class41.field806 > 768) {
                  TextureProvider.field1199[var5] = WidgetNode.method184(class41.field816[var5], class41.field817[var5], 1024 - class41.field806);
               } else if(class41.field806 > 256) {
                  TextureProvider.field1199[var5] = class41.field817[var5];
               } else {
                  TextureProvider.field1199[var5] = WidgetNode.method184(class41.field817[var5], class41.field816[var5], 256 - class41.field806);
               }
            }
         } else if(class41.field810 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class41.field810 > 768) {
                  TextureProvider.field1199[var5] = WidgetNode.method184(class41.field816[var5], GroundObject.field1300[var5], 1024 - class41.field810);
               } else if(class41.field810 > 256) {
                  TextureProvider.field1199[var5] = GroundObject.field1300[var5];
               } else {
                  TextureProvider.field1199[var5] = WidgetNode.method184(GroundObject.field1300[var5], class41.field816[var5], 256 - class41.field810);
               }
            }
         } else {
            for(var5 = 0; var5 < 256; ++var5) {
               TextureProvider.field1199[var5] = class41.field816[var5];
            }
         }

         class219.method3965(class41.field846, 9, 128 + class41.field846, var28 + 7);
         class41.field809.method4123(class41.field846, 0);
         class219.method3964();
         var5 = 0;
         var31 = GameEngine.bufferProvider.width * 9 + class41.field846;

         for(var7 = 1; var7 < var28 - 1; ++var7) {
            var32 = class41.field815[var7] * (var28 - var7) / var28;
            var33 = 22 + var32;
            if(var33 < 0) {
               var33 = 0;
            }

            var5 += var33;

            for(var10 = var33; var10 < 128; ++var10) {
               var11 = class5.field48[var5++];
               if(var11 != 0) {
                  var12 = var11;
                  var13 = 256 - var11;
                  var11 = TextureProvider.field1199[var11];
                  var14 = GameEngine.bufferProvider.pixels[var31];
                  GameEngine.bufferProvider.pixels[var31++] = (var13 * (var14 & 16711935) + var12 * (var11 & 16711935) & -16711936) + (var12 * (var11 & '\uff00') + var13 * (var14 & '\uff00') & 16711680) >> 8;
               } else {
                  ++var31;
               }
            }

            var31 += var33 + GameEngine.bufferProvider.width - 128;
         }

         class219.method3965(765 + class41.field846 - 128, 9, 765 + class41.field846, var28 + 7);
         class41.field840.method4123(class41.field846 + 382, 0);
         class219.method3964();
         var5 = 0;
         var31 = class41.field846 + 637 + GameEngine.bufferProvider.width * 9 + 24;

         for(var7 = 1; var7 < var28 - 1; ++var7) {
            var32 = (var28 - var7) * class41.field815[var7] / var28;
            var33 = 103 - var32;
            var31 += var32;

            for(var10 = 0; var10 < var33; ++var10) {
               var11 = class5.field48[var5++];
               if(var11 != 0) {
                  var12 = var11;
                  var13 = 256 - var11;
                  var11 = TextureProvider.field1199[var11];
                  var14 = GameEngine.bufferProvider.pixels[var31];
                  GameEngine.bufferProvider.pixels[var31++] = ((var14 & '\uff00') * var13 + (var11 & '\uff00') * var12 & 16711680) + (var13 * (var14 & 16711935) + (var11 & 16711935) * var12 & -16711936) >> 8;
               } else {
                  ++var31;
               }
            }

            var5 += 128 - var33;
            var31 += GameEngine.bufferProvider.width - var33 - var32;
         }

         class38.field788[class2.field21.field692?1:0].method4066(765 + class41.field846 - 40, 463);
         if(Client.gameState > 5 && Client.field472 == 0) {
            if(class185.field2730 != null) {
               var29 = class41.field846 + 5;
               var30 = 463;
               byte var35 = 100;
               byte var34 = 35;
               class185.field2730.method4066(var29, var30);
               var0.method3870("World" + " " + Client.world, var35 / 2 + var29, var34 / 2 + var30 - 2, 16777215, 0);
               if(null != Friend.worldServersDownload) {
                  var1.method3870("Loading...", var35 / 2 + var29, 12 + var34 / 2 + var30, 16777215, 0);
               } else {
                  var1.method3870("Click to switch", var29 + var35 / 2, 12 + var34 / 2 + var30, 16777215, 0);
               }
            } else {
               class185.field2730 = ItemComposition.method3698(class0.field4, "sl_button", "");
            }
         }

         try {
            var23 = class165.canvas.getGraphics();
            GameEngine.bufferProvider.draw(var23, 0, 0);
         } catch (Exception var27) {
            class165.canvas.repaint();
         }

      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "572019459"
   )
   public static synchronized long method117() {
      long var0 = System.currentTimeMillis();
      if(var0 < class155.field2095) {
         class155.field2091 += class155.field2095 - var0;
      }

      class155.field2095 = var0;
      return var0 + class155.field2091;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-601246225"
   )
   public static void method118() {
      class138.field1899.method2570();
      class138.field1900 = 1;
      class138.field1903 = null;
   }
}
