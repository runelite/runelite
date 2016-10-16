import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class50 extends CacheableNode {
   @ObfuscatedName("z")
   public static NodeCache field1063 = new NodeCache(64);
   @ObfuscatedName("bo")
   static ModIcon field1064;
   @ObfuscatedName("s")
   public static class170 field1065;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 804851157
   )
   public int field1066;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -636245117
   )
   public int field1067;
   @ObfuscatedName("qu")
   @ObfuscatedGetter(
      intValue = -2030422847
   )
   public static int field1069;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -822175757
   )
   public int field1070;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass227;Lclass227;Lclass227;ZI)V",
      garbageValue = "-595975094"
   )
   static void method992(class227 var0, class227 var1, class227 var2, boolean var3) {
      if(var3) {
         class33.field715 = (field1069 - Client.field483) / 2;
         class33.loginWindowX = class33.field715 + 202;
      }

      if(class33.worldSelectShown) {
         class47.method951(var0, var1);
      } else {
         if(var3) {
            class33.field725.method1710(class33.field715, 0);
            class129.field2078.method1710(382 + class33.field715, 0);
            class33.field704.method1871(class33.field715 + 382 - class33.field704.originalWidth / 2, 18);
         }

         int var5;
         if(Client.gameState == 0 || Client.gameState == 5) {
            byte var4 = 20;
            var0.method4072("RuneScape is loading - please wait...", class33.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            class82.method1815(180 + class33.loginWindowX - 152, var5, 304, 34, 9179409);
            class82.method1815(180 + class33.loginWindowX - 151, var5 + 1, 302, 32, 0);
            class82.method1801(180 + class33.loginWindowX - 150, var5 + 2, class33.field718 * 3, 30, 9179409);
            class82.method1801(class33.field718 * 3 + (180 + class33.loginWindowX - 150), var5 + 2, 300 - class33.field718 * 3, 30, 0);
            var0.method4072(class33.field719, class33.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var6;
         int var12;
         int var14;
         short var24;
         int var25;
         short var26;
         if(Client.gameState == 20) {
            class33.field721.method1871(class33.loginWindowX + 180 - class33.field721.originalWidth / 2, 271 - class33.field721.height / 2);
            var24 = 211;
            var0.method4072(class33.loginMessage1, 180 + class33.loginWindowX, var24, 16776960, 0);
            var25 = var24 + 15;
            var0.method4072(class33.loginMessage2, class33.loginWindowX + 180, var25, 16776960, 0);
            var25 += 15;
            var0.method4072(class33.loginMessage3, class33.loginWindowX + 180, var25, 16776960, 0);
            var25 += 15;
            var25 += 10;
            if(class33.loginIndex != 4) {
               var0.method4032("Login: ", class33.loginWindowX + 180 - 110, var25, 16777215, 0);
               var26 = 200;

               for(var6 = class33.username; var0.method4027(var6) > var26; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method4032(class226.method4053(var6), 180 + class33.loginWindowX - 70, var25, 16777215, 0);
               var25 += 15;
               String var8 = "Password: ";
               String var10 = class33.field726;
               var12 = var10.length();
               char[] var13 = new char[var12];

               for(var14 = 0; var14 < var12; ++var14) {
                  var13[var14] = 42;
               }

               String var11 = new String(var13);
               var0.method4032(var8 + var11, class33.loginWindowX + 180 - 108, var25, 16777215, 0);
               var25 += 15;
            }
         }

         int var16;
         int var27;
         int var28;
         if(Client.gameState == 10 || Client.gameState == 11) {
            class33.field721.method1871(class33.loginWindowX, 171);
            short var15;
            if(class33.loginIndex == 0) {
               var24 = 251;
               var0.method4072("Welcome to RuneScape", class33.loginWindowX + 180, var24, 16776960, 0);
               var25 = var24 + 30;
               var5 = 180 + class33.loginWindowX - 80;
               var15 = 291;
               class116.field1995.method1871(var5 - 73, var15 - 20);
               var0.method4035("New User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = 80 + 180 + class33.loginWindowX;
               class116.field1995.method1871(var5 - 73, var15 - 20);
               var0.method4035("Existing User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class33.loginIndex == 1) {
               var0.method4072(class33.field709, class33.loginWindowX + 180, 211, 16776960, 0);
               var24 = 236;
               var0.method4072(class33.loginMessage1, 180 + class33.loginWindowX, var24, 16777215, 0);
               var25 = var24 + 15;
               var0.method4072(class33.loginMessage2, class33.loginWindowX + 180, var25, 16777215, 0);
               var25 += 15;
               var0.method4072(class33.loginMessage3, class33.loginWindowX + 180, var25, 16777215, 0);
               var25 += 15;
               var5 = 180 + class33.loginWindowX - 80;
               var15 = 321;
               class116.field1995.method1871(var5 - 73, var15 - 20);
               var0.method4072("Continue", var5, 5 + var15, 16777215, 0);
               var5 = 180 + class33.loginWindowX + 80;
               class116.field1995.method1871(var5 - 73, var15 - 20);
               var0.method4072("Cancel", var5, var15 + 5, 16777215, 0);
            } else {
               short var17;
               if(class33.loginIndex == 2) {
                  var24 = 211;
                  var0.method4072(class33.loginMessage1, class33.loginWindowX + 180, var24, 16776960, 0);
                  var25 = var24 + 15;
                  var0.method4072(class33.loginMessage2, class33.loginWindowX + 180, var25, 16776960, 0);
                  var25 += 15;
                  var0.method4072(class33.loginMessage3, class33.loginWindowX + 180, var25, 16776960, 0);
                  var25 += 15;
                  var25 += 10;
                  var0.method4032("Login: ", 180 + class33.loginWindowX - 110, var25, 16777215, 0);
                  var26 = 200;

                  for(var6 = class33.username; var0.method4027(var6) > var26; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4032(class226.method4053(var6) + (class33.loginIndex2 == 0 & Client.gameCycle % 40 < 20?class188.method3706(16776960) + "|":""), class33.loginWindowX + 180 - 70, var25, 16777215, 0);
                  var25 += 15;
                  var0.method4032("Password: " + class152.method3134(class33.field726) + (class33.loginIndex2 == 1 & Client.gameCycle % 40 < 20?class188.method3706(16776960) + "|":""), 180 + class33.loginWindowX - 108, var25, 16777215, 0);
                  var25 += 15;
                  var16 = 180 + class33.loginWindowX - 80;
                  var17 = 321;
                  class116.field1995.method1871(var16 - 73, var17 - 20);
                  var0.method4072("Login", var16, var17 + 5, 16777215, 0);
                  var16 = 80 + 180 + class33.loginWindowX;
                  class116.field1995.method1871(var16 - 73, var17 - 20);
                  var0.method4072("Cancel", var16, 5 + var17, 16777215, 0);
                  var24 = 357;
                  var1.method4072("Forgotten your password? <col=ffffff>Click here.", 180 + class33.loginWindowX, var24, 16776960, 0);
               } else if(class33.loginIndex == 3) {
                  var24 = 201;
                  var0.method4072("Invalid username or password.", 180 + class33.loginWindowX, var24, 16776960, 0);
                  var25 = var24 + 20;
                  var1.method4072("For accounts created after 24th November 2010, please use your", class33.loginWindowX + 180, var25, 16776960, 0);
                  var25 += 15;
                  var1.method4072("email address to login. Otherwise please login with your username.", 180 + class33.loginWindowX, var25, 16776960, 0);
                  var25 += 15;
                  var5 = 180 + class33.loginWindowX;
                  var15 = 276;
                  class116.field1995.method1871(var5 - 73, var15 - 20);
                  var2.method4072("Try again", var5, var15 + 5, 16777215, 0);
                  var5 = 180 + class33.loginWindowX;
                  var15 = 326;
                  class116.field1995.method1871(var5 - 73, var15 - 20);
                  var2.method4072("Forgotten password?", var5, 5 + var15, 16777215, 0);
               } else if(class33.loginIndex == 4) {
                  var0.method4072("Authenticator", class33.loginWindowX + 180, 211, 16776960, 0);
                  var24 = 236;
                  var0.method4072(class33.loginMessage1, class33.loginWindowX + 180, var24, 16777215, 0);
                  var25 = var24 + 15;
                  var0.method4072(class33.loginMessage2, 180 + class33.loginWindowX, var25, 16777215, 0);
                  var25 += 15;
                  var0.method4072(class33.loginMessage3, class33.loginWindowX + 180, var25, 16777215, 0);
                  var25 += 15;
                  var0.method4032("PIN: " + class152.method3134(class51.authCode) + (Client.gameCycle % 40 < 20?class188.method3706(16776960) + "|":""), 180 + class33.loginWindowX - 108, var25, 16777215, 0);
                  var25 -= 8;
                  var0.method4032("Trust this computer", class33.loginWindowX + 180 - 9, var25, 16776960, 0);
                  var25 += 15;
                  var0.method4032("for 30 days: ", 180 + class33.loginWindowX - 9, var25, 16776960, 0);
                  var5 = 180 + class33.loginWindowX - 9 + var0.method4027("for 30 days: ") + 15;
                  var27 = var25 - var0.field3238;
                  ModIcon var7;
                  if(class33.field728) {
                     var7 = class124.field2045;
                  } else {
                     var7 = class47.field1030;
                  }

                  var7.method1871(var5, var27);
                  var25 += 15;
                  var28 = class33.loginWindowX + 180 - 80;
                  short var18 = 321;
                  class116.field1995.method1871(var28 - 73, var18 - 20);
                  var0.method4072("Continue", var28, var18 + 5, 16777215, 0);
                  var28 = 80 + 180 + class33.loginWindowX;
                  class116.field1995.method1871(var28 - 73, var18 - 20);
                  var0.method4072("Cancel", var28, var18 + 5, 16777215, 0);
                  var1.method4072("<u=ff>Can\'t Log In?</u>", class33.loginWindowX + 180, var18 + 36, 255, 0);
               } else if(class33.loginIndex == 5) {
                  var0.method4072("Forgotten your password?", 180 + class33.loginWindowX, 201, 16776960, 0);
                  var24 = 221;
                  var2.method4072(class33.loginMessage1, class33.loginWindowX + 180, var24, 16776960, 0);
                  var25 = var24 + 15;
                  var2.method4072(class33.loginMessage2, class33.loginWindowX + 180, var25, 16776960, 0);
                  var25 += 15;
                  var2.method4072(class33.loginMessage3, class33.loginWindowX + 180, var25, 16776960, 0);
                  var25 += 15;
                  var25 += 14;
                  var0.method4032("Username/email: ", class33.loginWindowX + 180 - 145, var25, 16777215, 0);
                  var26 = 174;

                  for(var6 = class33.username; var0.method4027(var6) > var26; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4032(class226.method4053(var6) + (Client.gameCycle % 40 < 20?class188.method3706(16776960) + "|":""), class33.loginWindowX + 180 - 34, var25, 16777215, 0);
                  var25 += 15;
                  var16 = 180 + class33.loginWindowX - 80;
                  var17 = 321;
                  class116.field1995.method1871(var16 - 73, var17 - 20);
                  var0.method4072("Recover", var16, var17 + 5, 16777215, 0);
                  var16 = 80 + class33.loginWindowX + 180;
                  class116.field1995.method1871(var16 - 73, var17 - 20);
                  var0.method4072("Back", var16, 5 + var17, 16777215, 0);
               } else if(class33.loginIndex == 6) {
                  var24 = 211;
                  var0.method4072(class33.loginMessage1, 180 + class33.loginWindowX, var24, 16776960, 0);
                  var25 = var24 + 15;
                  var0.method4072(class33.loginMessage2, class33.loginWindowX + 180, var25, 16776960, 0);
                  var25 += 15;
                  var0.method4072(class33.loginMessage3, class33.loginWindowX + 180, var25, 16776960, 0);
                  var25 += 15;
                  var5 = class33.loginWindowX + 180;
                  var15 = 321;
                  class116.field1995.method1871(var5 - 73, var15 - 20);
                  var0.method4072("Back", var5, var15 + 5, 16777215, 0);
               }
            }
         }

         int var19;
         int var20;
         int var21;
         int var29;
         if(class33.field716 > 0) {
            var25 = class33.field716;
            var26 = 256;
            class33.field714 += var25 * 128;
            if(class33.field714 > class33.field710.length) {
               class33.field714 -= class33.field710.length;
               var27 = (int)(Math.random() * 12.0D);
               XItemContainer.method182(class33.field702[var27]);
            }

            var27 = 0;
            var16 = 128 * var25;
            var28 = 128 * (var26 - var25);

            for(var29 = 0; var29 < var28; ++var29) {
               var19 = class38.field799[var16 + var27] - var25 * class33.field710[class33.field714 + var27 & class33.field710.length - 1] / 6;
               if(var19 < 0) {
                  var19 = 0;
               }

               class38.field799[var27++] = var19;
            }

            for(var29 = var26 - var25; var29 < var26; ++var29) {
               var19 = var29 * 128;

               for(var20 = 0; var20 < 128; ++var20) {
                  var12 = (int)(Math.random() * 100.0D);
                  if(var12 < 50 && var20 > 10 && var20 < 118) {
                     class38.field799[var20 + var19] = 255;
                  } else {
                     class38.field799[var19 + var20] = 0;
                  }
               }
            }

            if(class33.field720 > 0) {
               class33.field720 -= 4 * var25;
            }

            if(class33.field711 > 0) {
               class33.field711 -= 4 * var25;
            }

            if(class33.field720 == 0 && class33.field711 == 0) {
               var29 = (int)(Math.random() * (double)(2000 / var25));
               if(var29 == 0) {
                  class33.field720 = 1024;
               }

               if(var29 == 1) {
                  class33.field711 = 1024;
               }
            }

            for(var29 = 0; var29 < var26 - var25; ++var29) {
               class33.field708[var29] = class33.field708[var25 + var29];
            }

            for(var29 = var26 - var25; var29 < var26; ++var29) {
               class33.field708[var29] = (int)(Math.sin((double)class33.field733 / 14.0D) * 16.0D + Math.sin((double)class33.field733 / 15.0D) * 14.0D + Math.sin((double)class33.field733 / 16.0D) * 12.0D);
               ++class33.field733;
            }

            class33.field717 += var25;
            var29 = (var25 + (Client.gameCycle & 1)) / 2;
            if(var29 > 0) {
               for(var19 = 0; var19 < class33.field717 * 100; ++var19) {
                  var20 = (int)(Math.random() * 124.0D) + 2;
                  var12 = (int)(Math.random() * 128.0D) + 128;
                  class38.field799[(var12 << 7) + var20] = 192;
               }

               class33.field717 = 0;
               var19 = 0;

               label384:
               while(true) {
                  if(var19 >= var26) {
                     var19 = 0;

                     while(true) {
                        if(var19 >= 128) {
                           break label384;
                        }

                        var20 = 0;

                        for(var12 = -var29; var12 < var26; ++var12) {
                           var21 = 128 * var12;
                           if(var29 + var12 < var26) {
                              var20 += class14.field191[128 * var29 + var21 + var19];
                           }

                           if(var12 - (1 + var29) >= 0) {
                              var20 -= class14.field191[var21 + var19 - (1 + var29) * 128];
                           }

                           if(var12 >= 0) {
                              class38.field799[var21 + var19] = var20 / (2 * var29 + 1);
                           }
                        }

                        ++var19;
                     }
                  }

                  var20 = 0;
                  var12 = var19 * 128;

                  for(var21 = -var29; var21 < 128; ++var21) {
                     if(var21 + var29 < 128) {
                        var20 += class38.field799[var29 + var21 + var12];
                     }

                     if(var21 - (1 + var29) >= 0) {
                        var20 -= class38.field799[var12 + var21 - (var29 + 1)];
                     }

                     if(var21 >= 0) {
                        class14.field191[var12 + var21] = var20 / (1 + var29 * 2);
                     }
                  }

                  ++var19;
               }
            }

            class33.field716 = 0;
         }

         var24 = 256;
         if(class33.field720 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class33.field720 > 768) {
                  ChatLineBuffer.field665[var5] = class43.method865(class52.field1114[var5], class33.field727[var5], 1024 - class33.field720);
               } else if(class33.field720 > 256) {
                  ChatLineBuffer.field665[var5] = class33.field727[var5];
               } else {
                  ChatLineBuffer.field665[var5] = class43.method865(class33.field727[var5], class52.field1114[var5], 256 - class33.field720);
               }
            }
         } else if(class33.field711 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class33.field711 > 768) {
                  ChatLineBuffer.field665[var5] = class43.method865(class52.field1114[var5], MessageNode.field780[var5], 1024 - class33.field711);
               } else if(class33.field711 > 256) {
                  ChatLineBuffer.field665[var5] = MessageNode.field780[var5];
               } else {
                  ChatLineBuffer.field665[var5] = class43.method865(MessageNode.field780[var5], class52.field1114[var5], 256 - class33.field711);
               }
            }
         } else {
            for(var5 = 0; var5 < 256; ++var5) {
               ChatLineBuffer.field665[var5] = class52.field1114[var5];
            }
         }

         class82.method1795(class33.field715, 9, 128 + class33.field715, var24 + 7);
         class33.field725.method1710(class33.field715, 0);
         class82.method1794();
         var5 = 0;
         var27 = Player.bufferProvider.width * 9 + class33.field715;

         for(var16 = 1; var16 < var24 - 1; ++var16) {
            var28 = (var24 - var16) * class33.field708[var16] / var24;
            var29 = 22 + var28;
            if(var29 < 0) {
               var29 = 0;
            }

            var5 += var29;

            for(var19 = var29; var19 < 128; ++var19) {
               var20 = class38.field799[var5++];
               if(var20 != 0) {
                  var12 = var20;
                  var21 = 256 - var20;
                  var20 = ChatLineBuffer.field665[var20];
                  var14 = Player.bufferProvider.pixels[var27];
                  Player.bufferProvider.pixels[var27++] = ((var14 & '\uff00') * var21 + (var20 & '\uff00') * var12 & 16711680) + (var12 * (var20 & 16711935) + var21 * (var14 & 16711935) & -16711936) >> 8;
               } else {
                  ++var27;
               }
            }

            var27 += var29 + Player.bufferProvider.width - 128;
         }

         class82.method1795(class33.field715 + 765 - 128, 9, 765 + class33.field715, var24 + 7);
         class129.field2078.method1710(382 + class33.field715, 0);
         class82.method1794();
         var5 = 0;
         var27 = 637 + 24 + Player.bufferProvider.width * 9 + class33.field715;

         for(var16 = 1; var16 < var24 - 1; ++var16) {
            var28 = (var24 - var16) * class33.field708[var16] / var24;
            var29 = 103 - var28;
            var27 += var28;

            for(var19 = 0; var19 < var29; ++var19) {
               var20 = class38.field799[var5++];
               if(var20 != 0) {
                  var12 = var20;
                  var21 = 256 - var20;
                  var20 = ChatLineBuffer.field665[var20];
                  var14 = Player.bufferProvider.pixels[var27];
                  Player.bufferProvider.pixels[var27++] = (var21 * (var14 & 16711935) + var12 * (var20 & 16711935) & -16711936) + ((var20 & '\uff00') * var12 + var21 * (var14 & '\uff00') & 16711680) >> 8;
               } else {
                  ++var27;
               }
            }

            var5 += 128 - var29;
            var27 += Player.bufferProvider.width - var29 - var28;
         }

         class33.field705[Sequence.field984.field124?1:0].method1871(class33.field715 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.field346 == 0) {
            if(field1064 != null) {
               var25 = 5 + class33.field715;
               var26 = 463;
               byte var31 = 100;
               byte var30 = 35;
               field1064.method1871(var25, var26);
               var0.method4072("World" + " " + Client.world, var31 / 2 + var25, var30 / 2 + var26 - 2, 16777215, 0);
               if(null != ClassInfo.worldServersDownload) {
                  var1.method4072("Loading...", var25 + var31 / 2, var26 + var30 / 2 + 12, 16777215, 0);
               } else {
                  var1.method4072("Click to switch", var31 / 2 + var25, var30 / 2 + var26 + 12, 16777215, 0);
               }
            } else {
               field1064 = class225.method4021(class152.field2281, "sl_button", "");
            }
         }

         try {
            Graphics var22 = Frames.canvas.getGraphics();
            Player.bufferProvider.draw(var22, 0, 0);
         } catch (Exception var23) {
            Frames.canvas.repaint();
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-104"
   )
   void method997(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1070 = var1.method2668();
         this.field1066 = var1.method2481();
         this.field1067 = var1.method2481();
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-108"
   )
   public void method1000(Buffer var1) {
      while(true) {
         int var2 = var1.method2481();
         if(var2 == 0) {
            return;
         }

         this.method997(var1, var2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass170;IIIZI)V",
      garbageValue = "-1041796044"
   )
   public static void method1001(class170 var0, int var1, int var2, int var3, boolean var4) {
      class186.field3002 = 1;
      XItemContainer.field200 = var0;
      class186.field3003 = var1;
      class186.field3004 = var2;
      class186.field3005 = var3;
      class186.field3006 = var4;
      class153.field2283 = 10000;
   }
}
