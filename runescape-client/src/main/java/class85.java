import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
public final class class85 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 114090959
   )
   int field1454;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1223926417
   )
   int field1455;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 401863283
   )
   int field1456;
   @ObfuscatedName("ay")
   static class102 field1457;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 770767375
   )
   int field1458;
   @ObfuscatedName("g")
   boolean field1459 = true;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1458903381
   )
   int field1460;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1189519993
   )
   int field1461;
   @ObfuscatedName("ab")
   static ModIcon[] field1462;
   @ObfuscatedName("d")
   static int[] field1464;

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   class85(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1454 = var1;
      this.field1455 = var2;
      this.field1461 = var3;
      this.field1456 = var4;
      this.field1458 = var5;
      this.field1460 = var6;
      this.field1459 = var7;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LFont;LFont;LFont;ZI)V",
      garbageValue = "1995381431"
   )
   static void method1651(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class41.field814 = (class16.field186 - Client.field355) / 2;
         class41.loginWindowX = class41.field814 + 202;
      }

      if(class41.worldSelectShown) {
         class119.method2223(var0, var1);
      } else {
         if(var3) {
            class41.field815.method3969(class41.field814, 0);
            class39.field798.method3969(382 + class41.field814, 0);
            class41.field816.method3919(382 + class41.field814 - class41.field816.originalWidth / 2, 18);
         }

         int var5;
         if(Client.gameState == 0 || Client.gameState == 5) {
            byte var4 = 20;
            var0.method3739("RuneScape is loading - please wait...", class41.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.method3863(180 + class41.loginWindowX - 152, var5, 304, 34, 9179409);
            Rasterizer2D.method3863(class41.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.method3876(class41.loginWindowX + 180 - 150, var5 + 2, class41.field828 * 3, 30, 9179409);
            Rasterizer2D.method3876(180 + class41.loginWindowX - 150 + class41.field828 * 3, var5 + 2, 300 - class41.field828 * 3, 30, 0);
            var0.method3739(class41.field822, 180 + class41.loginWindowX, 276 - var4, 16777215, -1);
         }

         String var6;
         String var8;
         String var9;
         String var10;
         short var24;
         int var25;
         short var26;
         if(Client.gameState == 20) {
            class41.field819.method3919(class41.loginWindowX + 180 - class41.field819.originalWidth / 2, 271 - class41.field819.height / 2);
            var24 = 211;
            var0.method3739(class41.loginMessage1, 180 + class41.loginWindowX, var24, 16776960, 0);
            var25 = var24 + 15;
            var0.method3739(class41.loginMessage2, class41.loginWindowX + 180, var25, 16776960, 0);
            var25 += 15;
            var0.method3739(class41.loginMessage3, class41.loginWindowX + 180, var25, 16776960, 0);
            var25 += 15;
            var25 += 10;
            if(class41.loginIndex != 4) {
               var0.method3727("Login: ", class41.loginWindowX + 180 - 110, var25, 16777215, 0);
               var26 = 200;

               for(var6 = class41.username; var0.method3722(var6) > var26; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method3727(FontTypeFace.method3726(var6), 180 + class41.loginWindowX - 70, var25, 16777215, 0);
               var25 += 15;
               var8 = "Password: ";
               var10 = class41.field810;
               var9 = class40.method727('*', var10.length());
               var0.method3727(var8 + var9, 180 + class41.loginWindowX - 108, var25, 16777215, 0);
               var25 += 15;
            }
         }

         int var11;
         int var17;
         int var18;
         int var20;
         int var27;
         if(Client.gameState == 10 || Client.gameState == 11) {
            class41.field819.method3919(class41.loginWindowX, 171);
            short var15;
            if(class41.loginIndex == 0) {
               var24 = 251;
               var0.method3739("Welcome to RuneScape", 180 + class41.loginWindowX, var24, 16776960, 0);
               var25 = var24 + 30;
               var5 = class41.loginWindowX + 180 - 80;
               var15 = 291;
               class41.field840.method3919(var5 - 73, var15 - 20);
               var0.method3731("New User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = 80 + class41.loginWindowX + 180;
               class41.field840.method3919(var5 - 73, var15 - 20);
               var0.method3731("Existing User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class41.loginIndex == 1) {
               var0.method3739(class41.field831, class41.loginWindowX + 180, 211, 16776960, 0);
               var24 = 236;
               var0.method3739(class41.loginMessage1, 180 + class41.loginWindowX, var24, 16777215, 0);
               var25 = var24 + 15;
               var0.method3739(class41.loginMessage2, class41.loginWindowX + 180, var25, 16777215, 0);
               var25 += 15;
               var0.method3739(class41.loginMessage3, 180 + class41.loginWindowX, var25, 16777215, 0);
               var25 += 15;
               var5 = 180 + class41.loginWindowX - 80;
               var15 = 321;
               class41.field840.method3919(var5 - 73, var15 - 20);
               var0.method3739("Continue", var5, 5 + var15, 16777215, 0);
               var5 = 80 + 180 + class41.loginWindowX;
               class41.field840.method3919(var5 - 73, var15 - 20);
               var0.method3739("Cancel", var5, 5 + var15, 16777215, 0);
            } else if(class41.loginIndex == 2) {
               var24 = 211;
               var0.method3739(class41.loginMessage1, class41.loginWindowX + 180, var24, 16776960, 0);
               var25 = var24 + 15;
               var0.method3739(class41.loginMessage2, 180 + class41.loginWindowX, var25, 16776960, 0);
               var25 += 15;
               var0.method3739(class41.loginMessage3, 180 + class41.loginWindowX, var25, 16776960, 0);
               var25 += 15;
               var25 += 10;
               var0.method3727("Login: ", 180 + class41.loginWindowX - 110, var25, 16777215, 0);
               var26 = 200;

               for(var6 = class41.username; var0.method3722(var6) > var26; var6 = var6.substring(1)) {
                  ;
               }

               var0.method3727(FontTypeFace.method3726(var6) + (class41.loginIndex2 == 0 & Client.gameCycle % 40 < 20?Actor.method574(16776960) + "|":""), class41.loginWindowX + 180 - 70, var25, 16777215, 0);
               var25 += 15;
               var8 = "Password: ";
               var10 = class41.field810;
               var9 = class40.method727('*', var10.length());
               var0.method3727(var8 + var9 + (class41.loginIndex2 == 1 & Client.gameCycle % 40 < 20?Actor.method574(16776960) + "|":""), 180 + class41.loginWindowX - 108, var25, 16777215, 0);
               var25 += 15;
               var11 = 180 + class41.loginWindowX - 80;
               short var12 = 321;
               class41.field840.method3919(var11 - 73, var12 - 20);
               var0.method3739("Login", var11, 5 + var12, 16777215, 0);
               var11 = 180 + class41.loginWindowX + 80;
               class41.field840.method3919(var11 - 73, var12 - 20);
               var0.method3739("Cancel", var11, var12 + 5, 16777215, 0);
               var24 = 357;
               var1.method3739("Forgotten your password? <col=ffffff>Click here.", class41.loginWindowX + 180, var24, 16776960, 0);
            } else if(class41.loginIndex == 3) {
               var24 = 201;
               var0.method3739("Invalid username or password.", 180 + class41.loginWindowX, var24, 16776960, 0);
               var25 = var24 + 20;
               var1.method3739("For accounts created after 24th November 2010, please use your", class41.loginWindowX + 180, var25, 16776960, 0);
               var25 += 15;
               var1.method3739("email address to login. Otherwise please login with your username.", class41.loginWindowX + 180, var25, 16776960, 0);
               var25 += 15;
               var5 = 180 + class41.loginWindowX;
               var15 = 276;
               class41.field840.method3919(var5 - 73, var15 - 20);
               var2.method3739("Try again", var5, var15 + 5, 16777215, 0);
               var5 = 180 + class41.loginWindowX;
               var15 = 326;
               class41.field840.method3919(var5 - 73, var15 - 20);
               var2.method3739("Forgotten password?", var5, 5 + var15, 16777215, 0);
            } else if(class41.loginIndex == 4) {
               var0.method3739("Authenticator", class41.loginWindowX + 180, 211, 16776960, 0);
               var24 = 236;
               var0.method3739(class41.loginMessage1, 180 + class41.loginWindowX, var24, 16777215, 0);
               var25 = var24 + 15;
               var0.method3739(class41.loginMessage2, class41.loginWindowX + 180, var25, 16777215, 0);
               var25 += 15;
               var0.method3739(class41.loginMessage3, 180 + class41.loginWindowX, var25, 16777215, 0);
               var25 += 15;
               var6 = "PIN: ";
               var8 = class41.authCode;
               String var7 = class40.method727('*', var8.length());
               var0.method3727(var6 + var7 + (Client.gameCycle % 40 < 20?Actor.method574(16776960) + "|":""), class41.loginWindowX + 180 - 108, var25, 16777215, 0);
               var25 -= 8;
               var0.method3727("Trust this computer", 180 + class41.loginWindowX - 9, var25, 16776960, 0);
               var25 += 15;
               var0.method3727("for 30 days: ", class41.loginWindowX + 180 - 9, var25, 16776960, 0);
               var17 = 180 + class41.loginWindowX - 9 + var0.method3722("for 30 days: ") + 15;
               var18 = var25 - var0.field3102;
               ModIcon var19;
               if(class41.field837) {
                  var19 = class41.field818;
               } else {
                  var19 = class41.field817;
               }

               var19.method3919(var17, var18);
               var25 += 15;
               var27 = class41.loginWindowX + 180 - 80;
               short var13 = 321;
               class41.field840.method3919(var27 - 73, var13 - 20);
               var0.method3739("Continue", var27, var13 + 5, 16777215, 0);
               var27 = 80 + 180 + class41.loginWindowX;
               class41.field840.method3919(var27 - 73, var13 - 20);
               var0.method3739("Cancel", var27, var13 + 5, 16777215, 0);
               var1.method3739("<u=ff>Can\'t Log In?</u>", class41.loginWindowX + 180, var13 + 36, 255, 0);
            } else if(class41.loginIndex == 5) {
               var0.method3739("Forgotten your password?", class41.loginWindowX + 180, 201, 16776960, 0);
               var24 = 221;
               var2.method3739(class41.loginMessage1, class41.loginWindowX + 180, var24, 16776960, 0);
               var25 = var24 + 15;
               var2.method3739(class41.loginMessage2, class41.loginWindowX + 180, var25, 16776960, 0);
               var25 += 15;
               var2.method3739(class41.loginMessage3, 180 + class41.loginWindowX, var25, 16776960, 0);
               var25 += 15;
               var25 += 14;
               var0.method3727("Username/email: ", 180 + class41.loginWindowX - 145, var25, 16777215, 0);
               var26 = 174;

               for(var6 = class41.username; var0.method3722(var6) > var26; var6 = var6.substring(1)) {
                  ;
               }

               var0.method3727(FontTypeFace.method3726(var6) + (Client.gameCycle % 40 < 20?Actor.method574(16776960) + "|":""), 180 + class41.loginWindowX - 34, var25, 16777215, 0);
               var25 += 15;
               var20 = 180 + class41.loginWindowX - 80;
               short var21 = 321;
               class41.field840.method3919(var20 - 73, var21 - 20);
               var0.method3739("Recover", var20, 5 + var21, 16777215, 0);
               var20 = 80 + 180 + class41.loginWindowX;
               class41.field840.method3919(var20 - 73, var21 - 20);
               var0.method3739("Back", var20, var21 + 5, 16777215, 0);
            } else if(class41.loginIndex == 6) {
               var24 = 211;
               var0.method3739(class41.loginMessage1, 180 + class41.loginWindowX, var24, 16776960, 0);
               var25 = var24 + 15;
               var0.method3739(class41.loginMessage2, class41.loginWindowX + 180, var25, 16776960, 0);
               var25 += 15;
               var0.method3739(class41.loginMessage3, 180 + class41.loginWindowX, var25, 16776960, 0);
               var25 += 15;
               var5 = 180 + class41.loginWindowX;
               var15 = 321;
               class41.field840.method3919(var5 - 73, var15 - 20);
               var0.method3739("Back", var5, 5 + var15, 16777215, 0);
            }
         }

         if(class41.field826 > 0) {
            class3.method39(class41.field826);
            class41.field826 = 0;
         }

         var24 = 256;
         if(class41.field829 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class41.field829 > 768) {
                  class146.field2031[var5] = class6.method80(class97.field1630[var5], field1464[var5], 1024 - class41.field829);
               } else if(class41.field829 > 256) {
                  class146.field2031[var5] = field1464[var5];
               } else {
                  class146.field2031[var5] = class6.method80(field1464[var5], class97.field1630[var5], 256 - class41.field829);
               }
            }
         } else if(class41.field823 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class41.field823 > 768) {
                  class146.field2031[var5] = class6.method80(class97.field1630[var5], class41.field821[var5], 1024 - class41.field823);
               } else if(class41.field823 > 256) {
                  class146.field2031[var5] = class41.field821[var5];
               } else {
                  class146.field2031[var5] = class6.method80(class41.field821[var5], class97.field1630[var5], 256 - class41.field823);
               }
            }
         } else {
            for(var5 = 0; var5 < 256; ++var5) {
               class146.field2031[var5] = class97.field1630[var5];
            }
         }

         Rasterizer2D.method3844(class41.field814, 9, class41.field814 + 128, 7 + var24);
         class41.field815.method3969(class41.field814, 0);
         Rasterizer2D.method3843();
         var5 = 0;
         int var29 = class41.field814 + class57.bufferProvider.width * 9;

         int var14;
         int var28;
         int var31;
         for(var20 = 1; var20 < var24 - 1; ++var20) {
            var31 = (var24 - var20) * class41.field820[var20] / var24;
            var17 = var31 + 22;
            if(var17 < 0) {
               var17 = 0;
            }

            var5 += var17;

            for(var18 = var17; var18 < 128; ++var18) {
               var11 = class203.field3076[var5++];
               if(var11 != 0) {
                  var27 = var11;
                  var28 = 256 - var11;
                  var11 = class146.field2031[var11];
                  var14 = class57.bufferProvider.pixels[var29];
                  class57.bufferProvider.pixels[var29++] = ((var11 & '\uff00') * var27 + (var14 & '\uff00') * var28 & 16711680) + ((var11 & 16711935) * var27 + var28 * (var14 & 16711935) & -16711936) >> 8;
               } else {
                  ++var29;
               }
            }

            var29 += var17 + class57.bufferProvider.width - 128;
         }

         Rasterizer2D.method3844(765 + class41.field814 - 128, 9, 765 + class41.field814, 7 + var24);
         class39.field798.method3969(382 + class41.field814, 0);
         Rasterizer2D.method3843();
         var5 = 0;
         var29 = 637 + 24 + class57.bufferProvider.width * 9 + class41.field814;

         for(var20 = 1; var20 < var24 - 1; ++var20) {
            var31 = class41.field820[var20] * (var24 - var20) / var24;
            var17 = 103 - var31;
            var29 += var31;

            for(var18 = 0; var18 < var17; ++var18) {
               var11 = class203.field3076[var5++];
               if(var11 != 0) {
                  var27 = var11;
                  var28 = 256 - var11;
                  var11 = class146.field2031[var11];
                  var14 = class57.bufferProvider.pixels[var29];
                  class57.bufferProvider.pixels[var29++] = ((var14 & 16711935) * var28 + (var11 & 16711935) * var27 & -16711936) + (var27 * (var11 & '\uff00') + (var14 & '\uff00') * var28 & 16711680) >> 8;
               } else {
                  ++var29;
               }
            }

            var5 += 128 - var17;
            var29 += class57.bufferProvider.width - var17 - var31;
         }

         class157.field2129[class38.field794.field702?1:0].method3919(765 + class41.field814 - 40, 463);
         if(Client.gameState > 5 && Client.field300 == 0) {
            if(class186.field2771 != null) {
               var25 = 5 + class41.field814;
               var26 = 463;
               byte var30 = 100;
               byte var32 = 35;
               class186.field2771.method3919(var25, var26);
               var0.method3739("World" + " " + Client.world, var25 + var30 / 2, var26 + var32 / 2 - 2, 16777215, 0);
               if(World.worldServersDownload != null) {
                  var1.method3739("Loading...", var25 + var30 / 2, 12 + var26 + var32 / 2, 16777215, 0);
               } else {
                  var1.method3739("Click to switch", var25 + var30 / 2, var26 + var32 / 2 + 12, 16777215, 0);
               }
            } else {
               class186.field2771 = class88.method1821(class40.field807, "sl_button", "");
            }
         }

         try {
            Graphics var22 = class25.canvas.getGraphics();
            class57.bufferProvider.draw(var22, 0, 0);
         } catch (Exception var23) {
            class25.canvas.repaint();
         }

      }
   }

   @ObfuscatedName("ef")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IB)V",
      garbageValue = "34"
   )
   static final void method1652(String var0, int var1) {
      Client.field336.method2963(237);
      class159 var2 = Client.field336;
      int var3 = var0.length() + 1;
      var2.method2708(var3 + 1);
      Client.field336.method2844(var1);
      Client.field336.method2714(var0);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-13"
   )
   public static boolean method1653(int var0) {
      return (var0 >> 20 & 1) != 0;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lclass15;B)V",
      garbageValue = "1"
   )
   static final void method1654(class15 var0) {
      if(Client.flagX == XItemContainer.localPlayer.x >> 7 && XItemContainer.localPlayer.y >> 7 == Client.flagY) {
         Client.flagX = 0;
      }

      int var1 = class45.field894;
      int[] var2 = class45.field896;
      int var3 = var1;
      if(var0 == class15.field173 || var0 == class15.field168) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(var0 == class15.field173) {
            var5 = XItemContainer.localPlayer;
            var6 = XItemContainer.localPlayer.field278 << 14;
         } else if(var0 == class15.field168) {
            var5 = Client.cachedPlayers[Client.field292];
            var6 = Client.field292 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(var0 == class15.field170 && var2[var4] == Client.field292) {
               continue;
            }
         }

         if(null != var5 && var5.vmethod699() && !var5.field257) {
            var5.field274 = false;
            if((Client.field299 && var1 > 50 || var1 > 200) && var0 != class15.field173 && var5.idlePoseAnimation == var5.poseAnimation) {
               var5.field274 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.model != null && Client.gameCycle >= var5.totalLevel && Client.gameCycle < var5.field265) {
                  var5.field274 = false;
                  var5.field270 = XClanMember.method223(var5.x, var5.y, class118.plane);
                  class0.region.method1703(class118.plane, var5.x, var5.y, var5.field270, 60, var5, var5.angle, var6, var5.field275, var5.field263, var5.field269, var5.field273);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field559[var7][var8] == Client.field397) {
                        continue;
                     }

                     Client.field559[var7][var8] = Client.field397;
                  }

                  var5.field270 = XClanMember.method223(var5.x, var5.y, class118.plane);
                  class0.region.method1713(class118.plane, var5.x, var5.y, var5.field270, 60, var5, var5.angle, var6, var5.field607);
               }
            }
         }
      }

   }
}
