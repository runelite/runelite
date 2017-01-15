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
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      Graphics var12;
      int var13;
      int var14;
      int var15;
      int var16;
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
            var13 = 280 + class41.field846;
            if(World.field674[0] == 0 && World.field676[0] == 0) {
               XItemContainer.field133[2].method4066(var13, 4);
            } else {
               XItemContainer.field133[0].method4066(var13, 4);
            }

            if(World.field674[0] == 0 && World.field676[0] == 1) {
               XItemContainer.field133[3].method4066(15 + var13, 4);
            } else {
               XItemContainer.field133[1].method4066(var13 + 15, 4);
            }

            var0.method3867("World", 32 + var13, 17, 16777215, -1);
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
            var14 = 500 + class41.field846;
            if(World.field674[0] == 2 && World.field676[0] == 0) {
               XItemContainer.field133[2].method4066(var14, 4);
            } else {
               XItemContainer.field133[0].method4066(var14, 4);
            }

            if(World.field674[0] == 2 && World.field676[0] == 1) {
               XItemContainer.field133[3].method4066(var14 + 15, 4);
            } else {
               XItemContainer.field133[1].method4066(var14 + 15, 4);
            }

            var0.method3867("Location", 32 + var14, 17, 16777215, -1);
            var6 = 610 + class41.field846;
            if(World.field674[0] == 3 && World.field676[0] == 0) {
               XItemContainer.field133[2].method4066(var6, 4);
            } else {
               XItemContainer.field133[0].method4066(var6, 4);
            }

            if(World.field674[0] == 3 && World.field676[0] == 1) {
               XItemContainer.field133[3].method4066(15 + var6, 4);
            } else {
               XItemContainer.field133[1].method4066(15 + var6, 4);
            }

            var0.method3867("Type", var6 + 32, 17, 16777215, -1);
         }

         class219.method3993(class41.field846 + 708, 4, 50, 16, 0);
         var1.method3870("Cancel", 25 + class41.field846 + 708, 16, 16777215, -1);
         class41.field841 = -1;
         if(class7.field67 != null) {
            var4 = 88;
            byte var17 = 19;
            var14 = 765 / (var4 + 1);
            var6 = 480 / (1 + var17);

            while(true) {
               var15 = var6;
               var16 = var14;
               if(var6 * (var14 - 1) >= World.field684) {
                  --var14;
               }

               if((var6 - 1) * var14 >= World.field684) {
                  --var6;
               }

               if((var6 - 1) * var14 >= World.field684) {
                  --var6;
               }

               if(var6 == var15 && var14 == var16) {
                  var15 = (765 - var4 * var14) / (1 + var14);
                  if(var15 > 5) {
                     var15 = 5;
                  }

                  var16 = (480 - var17 * var6) / (var6 + 1);
                  if(var16 > 5) {
                     var16 = 5;
                  }

                  var7 = (765 - var14 * var4 - var15 * (var14 - 1)) / 2;
                  var8 = (480 - var6 * var17 - (var6 - 1) * var16) / 2;
                  var9 = 23 + var8;
                  var10 = class41.field846 + var7;
                  var11 = 0;
                  boolean var18 = false;

                  int var19;
                  for(var19 = 0; var19 < World.field684; ++var19) {
                     World var20 = World.worldList[var19];
                     boolean var21 = true;
                     String var22 = Integer.toString(var20.playerCount);
                     if(var20.playerCount == -1) {
                        var22 = "OFF";
                        var21 = false;
                     } else if(var20.playerCount > 1980) {
                        var22 = "FULL";
                        var21 = false;
                     }

                     int var23 = 0;
                     byte var24;
                     if(var20.method631()) {
                        if(var20.method636()) {
                           var24 = 7;
                        } else {
                           var24 = 6;
                        }
                     } else if(var20.method646()) {
                        var23 = 16711680;
                        if(var20.method636()) {
                           var24 = 5;
                        } else {
                           var24 = 4;
                        }
                     } else if(var20.method625()) {
                        if(var20.method636()) {
                           var24 = 3;
                        } else {
                           var24 = 2;
                        }
                     } else if(var20.method636()) {
                        var24 = 1;
                     } else {
                        var24 = 0;
                     }

                     if(class115.field1788 >= var10 && class115.field1789 >= var9 && class115.field1788 < var10 + var4 && class115.field1789 < var9 + var17 && var21) {
                        class41.field841 = var19;
                        class7.field67[var24].method4109(var10, var9, 128, 16777215);
                        var18 = true;
                     } else {
                        class7.field67[var24].method4123(var10, var9);
                     }

                     if(Ignore.field204 != null) {
                        Ignore.field204[(var20.method636()?8:0) + var20.location].method4066(var10 + 29, var9);
                     }

                     var0.method3870(Integer.toString(var20.id), var10 + 15, 5 + var17 / 2 + var9, var23, -1);
                     var1.method3870(var22, 60 + var10, var9 + var17 / 2 + 5, 268435455, -1);
                     var9 += var16 + var17;
                     ++var11;
                     if(var11 >= var6) {
                        var9 = 23 + var8;
                        var10 += var4 + var15;
                        var11 = 0;
                     }
                  }

                  if(var18) {
                     var19 = var1.method3874(World.worldList[class41.field841].activity) + 6;
                     int var30 = var1.field3087 + 8;
                     class219.method3993(class115.field1788 - var19 / 2, 25 + class115.field1789, var19, var30, 16777120);
                     class219.method3977(class115.field1788 - var19 / 2, 25 + class115.field1789, var19, var30, 0);
                     var1.method3870(World.worldList[class41.field841].activity, class115.field1788, var1.field3087 + 20 + class115.field1789 + 5 + 4, 0, -1);
                  }
                  break;
               }
            }
         }

         try {
            var12 = class165.canvas.getGraphics();
            GameEngine.bufferProvider.draw(var12, 0, 0);
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

         String var27;
         short var28;
         short var29;
         if(Client.gameState == 20) {
            class41.field807.method4066(180 + class41.loginWindowX - class41.field807.originalWidth / 2, 271 - class41.field807.height / 2);
            var28 = 211;
            var0.method3870(class41.loginMessage1, 180 + class41.loginWindowX, var28, 16776960, 0);
            var13 = var28 + 15;
            var0.method3870(class41.loginMessage2, class41.loginWindowX + 180, var13, 16776960, 0);
            var13 += 15;
            var0.method3870(class41.loginMessage3, class41.loginWindowX + 180, var13, 16776960, 0);
            var13 += 15;
            var13 += 10;
            if(class41.loginIndex != 4) {
               var0.method3867("Login: ", 180 + class41.loginWindowX - 110, var13, 16777215, 0);
               var29 = 200;

               for(var27 = class41.username; var0.method3874(var27) > var29; var27 = var27.substring(0, var27.length() - 1)) {
                  ;
               }

               var0.method3867(class209.method3866(var27), 180 + class41.loginWindowX - 70, var13, 16777215, 0);
               var13 += 15;
               var0.method3867("Password: " + class6.method94(class41.field833), class41.loginWindowX + 180 - 108, var13, 16777215, 0);
               var13 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class41.field807.method4066(class41.loginWindowX, 171);
            short var31;
            if(class41.loginIndex == 0) {
               var28 = 251;
               var0.method3870("Welcome to RuneScape", class41.loginWindowX + 180, var28, 16776960, 0);
               var13 = var28 + 30;
               var5 = class41.loginWindowX + 180 - 80;
               var31 = 291;
               class41.field808.method4066(var5 - 73, var31 - 20);
               var0.method3871("New User", var5 - 73, var31 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class41.loginWindowX + 180 + 80;
               class41.field808.method4066(var5 - 73, var31 - 20);
               var0.method3871("Existing User", var5 - 73, var31 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class41.loginIndex == 1) {
               var0.method3870(class41.field828, class41.loginWindowX + 180, 211, 16776960, 0);
               var28 = 236;
               var0.method3870(class41.loginMessage1, class41.loginWindowX + 180, var28, 16777215, 0);
               var13 = var28 + 15;
               var0.method3870(class41.loginMessage2, class41.loginWindowX + 180, var13, 16777215, 0);
               var13 += 15;
               var0.method3870(class41.loginMessage3, 180 + class41.loginWindowX, var13, 16777215, 0);
               var13 += 15;
               var5 = class41.loginWindowX + 180 - 80;
               var31 = 321;
               class41.field808.method4066(var5 - 73, var31 - 20);
               var0.method3870("Continue", var5, var31 + 5, 16777215, 0);
               var5 = 260 + class41.loginWindowX;
               class41.field808.method4066(var5 - 73, var31 - 20);
               var0.method3870("Cancel", var5, var31 + 5, 16777215, 0);
            } else {
               short var32;
               if(class41.loginIndex == 2) {
                  var28 = 211;
                  var0.method3870(class41.loginMessage1, 180 + class41.loginWindowX, var28, 16776960, 0);
                  var13 = var28 + 15;
                  var0.method3870(class41.loginMessage2, 180 + class41.loginWindowX, var13, 16776960, 0);
                  var13 += 15;
                  var0.method3870(class41.loginMessage3, 180 + class41.loginWindowX, var13, 16776960, 0);
                  var13 += 15;
                  var13 += 10;
                  var0.method3867("Login: ", class41.loginWindowX + 180 - 110, var13, 16777215, 0);
                  var29 = 200;

                  for(var27 = class41.username; var0.method3874(var27) > var29; var27 = var27.substring(1)) {
                     ;
                  }

                  var0.method3867(class209.method3866(var27) + (class41.loginIndex2 == 0 & Client.gameCycle % 40 < 20?class32.method691(16776960) + "|":""), 180 + class41.loginWindowX - 70, var13, 16777215, 0);
                  var13 += 15;
                  var0.method3867("Password: " + class6.method94(class41.field833) + (class41.loginIndex2 == 1 & Client.gameCycle % 40 < 20?class32.method691(16776960) + "|":""), class41.loginWindowX + 180 - 108, var13, 16777215, 0);
                  var13 += 15;
                  var6 = 180 + class41.loginWindowX - 80;
                  var32 = 321;
                  class41.field808.method4066(var6 - 73, var32 - 20);
                  var0.method3870("Login", var6, var32 + 5, 16777215, 0);
                  var6 = 260 + class41.loginWindowX;
                  class41.field808.method4066(var6 - 73, var32 - 20);
                  var0.method3870("Cancel", var6, 5 + var32, 16777215, 0);
                  var28 = 357;
                  var1.method3870("Forgotten your password? <col=ffffff>Click here.", 180 + class41.loginWindowX, var28, 16776960, 0);
               } else if(class41.loginIndex == 3) {
                  var28 = 201;
                  var0.method3870("Invalid username or password.", class41.loginWindowX + 180, var28, 16776960, 0);
                  var13 = var28 + 20;
                  var1.method3870("For accounts created after 24th November 2010, please use your", class41.loginWindowX + 180, var13, 16776960, 0);
                  var13 += 15;
                  var1.method3870("email address to login. Otherwise please login with your username.", 180 + class41.loginWindowX, var13, 16776960, 0);
                  var13 += 15;
                  var5 = 180 + class41.loginWindowX;
                  var31 = 276;
                  class41.field808.method4066(var5 - 73, var31 - 20);
                  var2.method3870("Try again", var5, 5 + var31, 16777215, 0);
                  var5 = class41.loginWindowX + 180;
                  var31 = 326;
                  class41.field808.method4066(var5 - 73, var31 - 20);
                  var2.method3870("Forgotten password?", var5, 5 + var31, 16777215, 0);
               } else if(class41.loginIndex == 4) {
                  var0.method3870("Authenticator", 180 + class41.loginWindowX, 211, 16776960, 0);
                  var28 = 236;
                  var0.method3870(class41.loginMessage1, 180 + class41.loginWindowX, var28, 16777215, 0);
                  var13 = var28 + 15;
                  var0.method3870(class41.loginMessage2, class41.loginWindowX + 180, var13, 16777215, 0);
                  var13 += 15;
                  var0.method3870(class41.loginMessage3, class41.loginWindowX + 180, var13, 16777215, 0);
                  var13 += 15;
                  var0.method3867("PIN: " + class6.method94(XClanMember.authCode) + (Client.gameCycle % 40 < 20?class32.method691(16776960) + "|":""), class41.loginWindowX + 180 - 108, var13, 16777215, 0);
                  var13 -= 8;
                  var0.method3867("Trust this computer", 180 + class41.loginWindowX - 9, var13, 16776960, 0);
                  var13 += 15;
                  var0.method3867("for 30 days: ", 180 + class41.loginWindowX - 9, var13, 16776960, 0);
                  var5 = 180 + class41.loginWindowX - 9 + var0.method3874("for 30 days: ") + 15;
                  var14 = var13 - var0.field3087;
                  ModIcon var35;
                  if(class41.field835) {
                     var35 = class8.field80;
                  } else {
                     var35 = class41.field811;
                  }

                  var35.method4066(var5, var14);
                  var13 += 15;
                  var15 = class41.loginWindowX + 180 - 80;
                  short var36 = 321;
                  class41.field808.method4066(var15 - 73, var36 - 20);
                  var0.method3870("Continue", var15, var36 + 5, 16777215, 0);
                  var15 = 180 + class41.loginWindowX + 80;
                  class41.field808.method4066(var15 - 73, var36 - 20);
                  var0.method3870("Cancel", var15, 5 + var36, 16777215, 0);
                  var1.method3870("<u=ff>Can\'t Log In?</u>", class41.loginWindowX + 180, var36 + 36, 255, 0);
               } else if(class41.loginIndex != 5) {
                  if(class41.loginIndex == 6) {
                     var28 = 211;
                     var0.method3870(class41.loginMessage1, 180 + class41.loginWindowX, var28, 16776960, 0);
                     var13 = var28 + 15;
                     var0.method3870(class41.loginMessage2, class41.loginWindowX + 180, var13, 16776960, 0);
                     var13 += 15;
                     var0.method3870(class41.loginMessage3, 180 + class41.loginWindowX, var13, 16776960, 0);
                     var13 += 15;
                     var5 = 180 + class41.loginWindowX;
                     var31 = 321;
                     class41.field808.method4066(var5 - 73, var31 - 20);
                     var0.method3870("Back", var5, 5 + var31, 16777215, 0);
                  }
               } else {
                  var0.method3870("Forgotten your password?", 180 + class41.loginWindowX, 201, 16776960, 0);
                  var28 = 221;
                  var2.method3870(class41.loginMessage1, 180 + class41.loginWindowX, var28, 16776960, 0);
                  var13 = var28 + 15;
                  var2.method3870(class41.loginMessage2, class41.loginWindowX + 180, var13, 16776960, 0);
                  var13 += 15;
                  var2.method3870(class41.loginMessage3, class41.loginWindowX + 180, var13, 16776960, 0);
                  var13 += 15;
                  var13 += 14;
                  var0.method3867("Username/email: ", 180 + class41.loginWindowX - 145, var13, 16777215, 0);
                  var29 = 174;

                  for(var27 = class41.username; var0.method3874(var27) > var29; var27 = var27.substring(1)) {
                     ;
                  }

                  var0.method3867(class209.method3866(var27) + (Client.gameCycle % 40 < 20?class32.method691(16776960) + "|":""), class41.loginWindowX + 180 - 34, var13, 16777215, 0);
                  var13 += 15;
                  var6 = class41.loginWindowX + 180 - 80;
                  var32 = 321;
                  class41.field808.method4066(var6 - 73, var32 - 20);
                  var0.method3870("Recover", var6, 5 + var32, 16777215, 0);
                  var6 = 80 + class41.loginWindowX + 180;
                  class41.field808.method4066(var6 - 73, var32 - 20);
                  var0.method3870("Back", var6, 5 + var32, 16777215, 0);
               }
            }
         }

         if(class41.field823 > 0) {
            var13 = class41.field823;
            var29 = 256;
            class41.field821 += var13 * 128;
            if(class41.field821 > class88.field1531.length) {
               class41.field821 -= class88.field1531.length;
               var14 = (int)(Math.random() * 12.0D);
               class25.method593(NPC.field759[var14]);
            }

            var14 = 0;
            var6 = var13 * 128;
            var15 = (var29 - var13) * 128;

            for(var16 = 0; var16 < var15; ++var16) {
               var7 = class5.field48[var6 + var14] - var13 * class88.field1531[class41.field821 + var14 & class88.field1531.length - 1] / 6;
               if(var7 < 0) {
                  var7 = 0;
               }

               class5.field48[var14++] = var7;
            }

            var16 = var29 - var13;

            while(true) {
               if(var16 >= var29) {
                  if(class41.field806 > 0) {
                     class41.field806 -= 4 * var13;
                  }

                  if(class41.field810 > 0) {
                     class41.field810 -= var13 * 4;
                  }

                  if(class41.field806 == 0 && class41.field810 == 0) {
                     var16 = (int)(Math.random() * (double)(2000 / var13));
                     if(var16 == 0) {
                        class41.field806 = 1024;
                     }

                     if(var16 == 1) {
                        class41.field810 = 1024;
                     }
                  }

                  for(var16 = 0; var16 < var29 - var13; ++var16) {
                     class41.field815[var16] = class41.field815[var13 + var16];
                  }

                  for(var16 = var29 - var13; var16 < var29; ++var16) {
                     class41.field815[var16] = (int)(Math.sin((double)class41.field843 / 14.0D) * 16.0D + Math.sin((double)class41.field843 / 15.0D) * 14.0D + Math.sin((double)class41.field843 / 16.0D) * 12.0D);
                     ++class41.field843;
                  }

                  class41.field822 += var13;
                  var16 = ((Client.gameCycle & 1) + var13) / 2;
                  if(var16 > 0) {
                     for(var7 = 0; var7 < class41.field822 * 100; ++var7) {
                        var8 = (int)(Math.random() * 124.0D) + 2;
                        var9 = (int)(Math.random() * 128.0D) + 128;
                        class5.field48[(var9 << 7) + var8] = 192;
                     }

                     class41.field822 = 0;

                     for(var7 = 0; var7 < var29; ++var7) {
                        var8 = 0;
                        var9 = var7 * 128;

                        for(var10 = -var16; var10 < 128; ++var10) {
                           if(var16 + var10 < 128) {
                              var8 += class5.field48[var16 + var10 + var9];
                           }

                           if(var10 - (1 + var16) >= 0) {
                              var8 -= class5.field48[var9 + var10 - (var16 + 1)];
                           }

                           if(var10 >= 0) {
                              class41.field813[var9 + var10] = var8 / (1 + 2 * var16);
                           }
                        }
                     }

                     for(var7 = 0; var7 < 128; ++var7) {
                        var8 = 0;

                        for(var9 = -var16; var9 < var29; ++var9) {
                           var10 = 128 * var9;
                           if(var16 + var9 < var29) {
                              var8 += class41.field813[var10 + var7 + var16 * 128];
                           }

                           if(var9 - (1 + var16) >= 0) {
                              var8 -= class41.field813[var7 + var10 - 128 * (1 + var16)];
                           }

                           if(var9 >= 0) {
                              class5.field48[var10 + var7] = var8 / (1 + 2 * var16);
                           }
                        }
                     }
                  }

                  class41.field823 = 0;
                  break;
               }

               var7 = var16 * 128;

               for(var8 = 0; var8 < 128; ++var8) {
                  var9 = (int)(Math.random() * 100.0D);
                  if(var9 < 50 && var8 > 10 && var8 < 118) {
                     class5.field48[var8 + var7] = 255;
                  } else {
                     class5.field48[var7 + var8] = 0;
                  }
               }

               ++var16;
            }
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
         var14 = GameEngine.bufferProvider.width * 9 + class41.field846;

         for(var6 = 1; var6 < var28 - 1; ++var6) {
            var15 = class41.field815[var6] * (var28 - var6) / var28;
            var16 = 22 + var15;
            if(var16 < 0) {
               var16 = 0;
            }

            var5 += var16;

            for(var7 = var16; var7 < 128; ++var7) {
               var8 = class5.field48[var5++];
               if(var8 != 0) {
                  var9 = var8;
                  var10 = 256 - var8;
                  var8 = TextureProvider.field1199[var8];
                  var11 = GameEngine.bufferProvider.pixels[var14];
                  GameEngine.bufferProvider.pixels[var14++] = (var10 * (var11 & 16711935) + var9 * (var8 & 16711935) & -16711936) + (var9 * (var8 & '\uff00') + var10 * (var11 & '\uff00') & 16711680) >> 8;
               } else {
                  ++var14;
               }
            }

            var14 += var16 + GameEngine.bufferProvider.width - 128;
         }

         class219.method3965(765 + class41.field846 - 128, 9, 765 + class41.field846, var28 + 7);
         class41.field840.method4123(class41.field846 + 382, 0);
         class219.method3964();
         var5 = 0;
         var14 = class41.field846 + 637 + GameEngine.bufferProvider.width * 9 + 24;

         for(var6 = 1; var6 < var28 - 1; ++var6) {
            var15 = (var28 - var6) * class41.field815[var6] / var28;
            var16 = 103 - var15;
            var14 += var15;

            for(var7 = 0; var7 < var16; ++var7) {
               var8 = class5.field48[var5++];
               if(var8 != 0) {
                  var9 = var8;
                  var10 = 256 - var8;
                  var8 = TextureProvider.field1199[var8];
                  var11 = GameEngine.bufferProvider.pixels[var14];
                  GameEngine.bufferProvider.pixels[var14++] = ((var11 & '\uff00') * var10 + (var8 & '\uff00') * var9 & 16711680) + (var10 * (var11 & 16711935) + (var8 & 16711935) * var9 & -16711936) >> 8;
               } else {
                  ++var14;
               }
            }

            var5 += 128 - var16;
            var14 += GameEngine.bufferProvider.width - var16 - var15;
         }

         class38.field788[class2.field21.field692?1:0].method4066(765 + class41.field846 - 40, 463);
         if(Client.gameState > 5 && Client.field472 == 0) {
            if(class185.field2730 != null) {
               var13 = class41.field846 + 5;
               var29 = 463;
               byte var33 = 100;
               byte var34 = 35;
               class185.field2730.method4066(var13, var29);
               var0.method3870("World " + Client.world, var33 / 2 + var13, var34 / 2 + var29 - 2, 16777215, 0);
               if(null != Friend.worldServersDownload) {
                  var1.method3870("Loading...", var33 / 2 + var13, 12 + var34 / 2 + var29, 16777215, 0);
               } else {
                  var1.method3870("Click to switch", var13 + var33 / 2, 12 + var34 / 2 + var29, 16777215, 0);
               }
            } else {
               class185.field2730 = ItemComposition.method3698(class0.field4, "sl_button", "");
            }
         }

         try {
            var12 = class165.canvas.getGraphics();
            GameEngine.bufferProvider.draw(var12, 0, 0);
         } catch (Exception var25) {
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
