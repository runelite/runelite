import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
public class class89 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 52316313
   )
   int field1420;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -502327993
   )
   int field1421;
   @ObfuscatedName("b")
   String field1422;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1964184821
   )
   int field1423;
   @ObfuscatedName("w")
   static int[] field1424;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 39282405
   )
   int field1428;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1151088181
   )
   static int field1429;

   @ObfuscatedName("jx")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "126784234"
   )
   static boolean method1700(Widget var0) {
      if(Client.field1100) {
         if(class210.method3903(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "24"
   )
   static int method1701(int var0, Script var1, boolean var2) {
      if(var0 == 5306) {
         int[] var3 = class83.intStack;
         int var4 = ++class83.intStackSize - 1;
         int var5 = Client.isResized?2:1;
         var3[var4] = var5;
         return 1;
      } else {
         int var6;
         if(var0 == 5307) {
            var6 = class83.intStack[--class83.intStackSize];
            if(var6 == 1 || var6 == 2) {
               class232.method4103(var6);
            }

            return 1;
         } else if(var0 == 5308) {
            class83.intStack[++class83.intStackSize - 1] = XGrandExchangeOffer.field303.field1336;
            return 1;
         } else if(var0 != 5309) {
            return 2;
         } else {
            var6 = class83.intStack[--class83.intStackSize];
            if(var6 == 1 || var6 == 2) {
               XGrandExchangeOffer.field303.field1336 = var6;
               ScriptState.method1052();
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "123"
   )
   public static void method1702() {
      try {
         File var0 = new File(class76.field1218, "random.dat");
         int var2;
         if(var0.exists()) {
            class155.field2268 = new class123(new FileOnDisk(var0, "rw", 25L), 24, 0);
         } else {
            label38:
            for(int var1 = 0; var1 < Script.field1538.length; ++var1) {
               for(var2 = 0; var2 < class88.field1408.length; ++var2) {
                  File var3 = new File(class88.field1408[var2] + Script.field1538[var1] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class155.field2268 = new class123(new FileOnDisk(var3, "rw", 25L), 24, 0);
                     break label38;
                  }
               }
            }
         }

         if(class155.field2268 == null) {
            RandomAccessFile var4 = new RandomAccessFile(var0, "rw");
            var2 = var4.read();
            var4.seek(0L);
            var4.write(var2);
            var4.seek(0L);
            var4.close();
            class155.field2268 = new class123(new FileOnDisk(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LFont;LFont;LFont;ZI)V",
      garbageValue = "1136262557"
   )
   static void method1703(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class92.field1459 = (VertexNormal.field2020 - 765) / 2;
         class92.loginWindowX = class92.field1459 + 202;
      }

      if(class92.worldSelectShown) {
         class45.method614(var0, var1);
      } else {
         if(var3) {
            class33.field474.method5045(class92.field1459, 0);
            class211.field2609.method5045(class92.field1459 + 382, 0);
            class92.field1457.method5017(class92.field1459 + 382 - class92.field1457.originalWidth / 2, 18);
         }

         int var5;
         if(Client.gameState == 0 || Client.gameState == 5) {
            byte var4 = 20;
            var0.method4736("RuneScape is loading - please wait...", class92.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.method4945(class92.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.method4945(class92.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.method4923(class92.loginWindowX + 180 - 150, var5 + 2, class92.field1448 * 3, 30, 9179409);
            Rasterizer2D.method4923(class92.loginWindowX + 180 - 150 + class92.field1448 * 3, var5 + 2, 300 - class92.field1448 * 3, 30, 0);
            var0.method4736(class92.field1455, class92.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var6;
         short var17;
         int var18;
         short var19;
         if(Client.gameState == 20) {
            class92.field1442.method5017(class92.loginWindowX + 180 - class92.field1442.originalWidth / 2, 271 - class92.field1442.height / 2);
            var17 = 211;
            var0.method4736(class92.loginMessage1, class92.loginWindowX + 180, var17, 16776960, 0);
            var18 = var17 + 15;
            var0.method4736(class92.loginMessage2, class92.loginWindowX + 180, var18, 16776960, 0);
            var18 += 15;
            var0.method4736(class92.loginMessage3, class92.loginWindowX + 180, var18, 16776960, 0);
            var18 += 15;
            var18 += 10;
            if(class92.loginIndex != 4) {
               var0.method4737("Login: ", class92.loginWindowX + 180 - 110, var18, 16777215, 0);
               var19 = 200;

               for(var6 = class92.username; var0.method4728(var6) > var19; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method4737(FontTypeFace.method4776(var6), class92.loginWindowX + 180 - 70, var18, 16777215, 0);
               var18 += 15;
               var0.method4737("Password: " + class10.method49(class92.password), class92.loginWindowX + 180 - 108, var18, 16777215, 0);
               var18 += 15;
            }
         }

         int var7;
         int var20;
         int var23;
         if(Client.gameState == 10 || Client.gameState == 11) {
            class92.field1442.method5017(class92.loginWindowX, 171);
            short var15;
            if(class92.loginIndex == 0) {
               var17 = 251;
               var0.method4736("Welcome to RuneScape", class92.loginWindowX + 180, var17, 16776960, 0);
               var18 = var17 + 30;
               var5 = class92.loginWindowX + 180 - 80;
               var15 = 291;
               FileOnDisk.field1782.method5017(var5 - 73, var15 - 20);
               var0.method4745("New User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class92.loginWindowX + 180 + 80;
               FileOnDisk.field1782.method5017(var5 - 73, var15 - 20);
               var0.method4745("Existing User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class92.loginIndex == 1) {
               var0.method4736(class92.field1460, class92.loginWindowX + 180, 211, 16776960, 0);
               var17 = 236;
               var0.method4736(class92.loginMessage1, class92.loginWindowX + 180, var17, 16777215, 0);
               var18 = var17 + 15;
               var0.method4736(class92.loginMessage2, class92.loginWindowX + 180, var18, 16777215, 0);
               var18 += 15;
               var0.method4736(class92.loginMessage3, class92.loginWindowX + 180, var18, 16777215, 0);
               var18 += 15;
               var5 = class92.loginWindowX + 180 - 80;
               var15 = 321;
               FileOnDisk.field1782.method5017(var5 - 73, var15 - 20);
               var0.method4736("Continue", var5, var15 + 5, 16777215, 0);
               var5 = class92.loginWindowX + 180 + 80;
               FileOnDisk.field1782.method5017(var5 - 73, var15 - 20);
               var0.method4736("Cancel", var5, var15 + 5, 16777215, 0);
            } else {
               short var8;
               if(class92.loginIndex == 2) {
                  var17 = 211;
                  var0.method4736(class92.loginMessage1, class92.loginWindowX + 180, var17, 16776960, 0);
                  var18 = var17 + 15;
                  var0.method4736(class92.loginMessage2, class92.loginWindowX + 180, var18, 16776960, 0);
                  var18 += 15;
                  var0.method4736(class92.loginMessage3, class92.loginWindowX + 180, var18, 16776960, 0);
                  var18 += 15;
                  var18 += 10;
                  var0.method4737("Login: ", class92.loginWindowX + 180 - 110, var18, 16777215, 0);
                  var19 = 200;

                  for(var6 = class92.username; var0.method4728(var6) > var19; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4737(FontTypeFace.method4776(var6) + (class92.loginIndex2 == 0 & Client.gameCycle % 40 < 20?WorldMapData.method337(16776960) + "|":""), class92.loginWindowX + 180 - 70, var18, 16777215, 0);
                  var18 += 15;
                  var0.method4737("Password: " + class10.method49(class92.password) + (class92.loginIndex2 == 1 & Client.gameCycle % 40 < 20?WorldMapData.method337(16776960) + "|":""), class92.loginWindowX + 180 - 108, var18, 16777215, 0);
                  var18 += 15;
                  var7 = class92.loginWindowX + 180 - 80;
                  var8 = 321;
                  FileOnDisk.field1782.method5017(var7 - 73, var8 - 20);
                  var0.method4736("Login", var7, var8 + 5, 16777215, 0);
                  var7 = class92.loginWindowX + 180 + 80;
                  FileOnDisk.field1782.method5017(var7 - 73, var8 - 20);
                  var0.method4736("Cancel", var7, var8 + 5, 16777215, 0);
                  var17 = 357;
                  var1.method4736("Forgotten your password? <col=ffffff>Click here.", class92.loginWindowX + 180, var17, 16776960, 0);
               } else if(class92.loginIndex == 3) {
                  var17 = 201;
                  var0.method4736("Invalid username or password.", class92.loginWindowX + 180, var17, 16776960, 0);
                  var18 = var17 + 20;
                  var1.method4736("For accounts created after 24th November 2010, please use your", class92.loginWindowX + 180, var18, 16776960, 0);
                  var18 += 15;
                  var1.method4736("email address to login. Otherwise please login with your username.", class92.loginWindowX + 180, var18, 16776960, 0);
                  var18 += 15;
                  var5 = class92.loginWindowX + 180;
                  var15 = 276;
                  FileOnDisk.field1782.method5017(var5 - 73, var15 - 20);
                  var2.method4736("Try again", var5, var15 + 5, 16777215, 0);
                  var5 = class92.loginWindowX + 180;
                  var15 = 326;
                  FileOnDisk.field1782.method5017(var5 - 73, var15 - 20);
                  var2.method4736("Forgotten password?", var5, var15 + 5, 16777215, 0);
               } else if(class92.loginIndex == 4) {
                  var0.method4736("Authenticator", class92.loginWindowX + 180, 211, 16776960, 0);
                  var17 = 236;
                  var0.method4736(class92.loginMessage1, class92.loginWindowX + 180, var17, 16777215, 0);
                  var18 = var17 + 15;
                  var0.method4736(class92.loginMessage2, class92.loginWindowX + 180, var18, 16777215, 0);
                  var18 += 15;
                  var0.method4736(class92.loginMessage3, class92.loginWindowX + 180, var18, 16777215, 0);
                  var18 += 15;
                  var0.method4737("PIN: " + class10.method49(class231.authCode) + (Client.gameCycle % 40 < 20?WorldMapData.method337(16776960) + "|":""), class92.loginWindowX + 180 - 108, var18, 16777215, 0);
                  var18 -= 8;
                  var0.method4737("Trust this computer", class92.loginWindowX + 180 - 9, var18, 16776960, 0);
                  var18 += 15;
                  var0.method4737("for 30 days: ", class92.loginWindowX + 180 - 9, var18, 16776960, 0);
                  var5 = class92.loginWindowX + 180 - 9 + var0.method4728("for 30 days: ") + 15;
                  var23 = var18 - var0.field3652;
                  ModIcon var16;
                  if(class92.field1464) {
                     var16 = class77.field1237;
                  } else {
                     var16 = class3.field28;
                  }

                  var16.method5017(var5, var23);
                  var18 += 15;
                  var20 = class92.loginWindowX + 180 - 80;
                  short var9 = 321;
                  FileOnDisk.field1782.method5017(var20 - 73, var9 - 20);
                  var0.method4736("Continue", var20, var9 + 5, 16777215, 0);
                  var20 = class92.loginWindowX + 180 + 80;
                  FileOnDisk.field1782.method5017(var20 - 73, var9 - 20);
                  var0.method4736("Cancel", var20, var9 + 5, 16777215, 0);
                  var1.method4736("<u=ff>Can\'t Log In?</u>", class92.loginWindowX + 180, var9 + 36, 255, 0);
               } else if(class92.loginIndex == 5) {
                  var0.method4736("Forgotten your password?", class92.loginWindowX + 180, 201, 16776960, 0);
                  var17 = 221;
                  var2.method4736(class92.loginMessage1, class92.loginWindowX + 180, var17, 16776960, 0);
                  var18 = var17 + 15;
                  var2.method4736(class92.loginMessage2, class92.loginWindowX + 180, var18, 16776960, 0);
                  var18 += 15;
                  var2.method4736(class92.loginMessage3, class92.loginWindowX + 180, var18, 16776960, 0);
                  var18 += 15;
                  var18 += 14;
                  var0.method4737("Username/email: ", class92.loginWindowX + 180 - 145, var18, 16777215, 0);
                  var19 = 174;

                  for(var6 = class92.username; var0.method4728(var6) > var19; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4737(FontTypeFace.method4776(var6) + (Client.gameCycle % 40 < 20?WorldMapData.method337(16776960) + "|":""), class92.loginWindowX + 180 - 34, var18, 16777215, 0);
                  var18 += 15;
                  var7 = class92.loginWindowX + 180 - 80;
                  var8 = 321;
                  FileOnDisk.field1782.method5017(var7 - 73, var8 - 20);
                  var0.method4736("Recover", var7, var8 + 5, 16777215, 0);
                  var7 = class92.loginWindowX + 180 + 80;
                  FileOnDisk.field1782.method5017(var7 - 73, var8 - 20);
                  var0.method4736("Back", var7, var8 + 5, 16777215, 0);
               } else if(class92.loginIndex == 6) {
                  var17 = 211;
                  var0.method4736(class92.loginMessage1, class92.loginWindowX + 180, var17, 16776960, 0);
                  var18 = var17 + 15;
                  var0.method4736(class92.loginMessage2, class92.loginWindowX + 180, var18, 16776960, 0);
                  var18 += 15;
                  var0.method4736(class92.loginMessage3, class92.loginWindowX + 180, var18, 16776960, 0);
                  var18 += 15;
                  var5 = class92.loginWindowX + 180;
                  var15 = 321;
                  FileOnDisk.field1782.method5017(var5 - 73, var15 - 20);
                  var0.method4736("Back", var5, var15 + 5, 16777215, 0);
               }
            }
         }

         int var10;
         int var11;
         int var12;
         int var13;
         int var21;
         if(class92.field1452 > 0) {
            var18 = class92.field1452;
            var19 = 256;
            class92.field1450 += var18 * 128;
            if(class92.field1450 > class10.field258.length) {
               class92.field1450 -= class10.field258.length;
               var23 = (int)(Math.random() * 12.0D);
               Actor.method1533(class92.field1470[var23]);
            }

            var23 = 0;
            var7 = var18 * 128;
            var20 = (var19 - var18) * 128;

            for(var21 = 0; var21 < var20; ++var21) {
               var10 = class23.field344[var7 + var23] - var18 * class10.field258[var23 + class92.field1450 & class10.field258.length - 1] / 6;
               if(var10 < 0) {
                  var10 = 0;
               }

               class23.field344[var23++] = var10;
            }

            for(var21 = var19 - var18; var21 < var19; ++var21) {
               var10 = var21 * 128;

               for(var11 = 0; var11 < 128; ++var11) {
                  var12 = (int)(Math.random() * 100.0D);
                  if(var12 < 50 && var11 > 10 && var11 < 118) {
                     class23.field344[var11 + var10] = 255;
                  } else {
                     class23.field344[var10 + var11] = 0;
                  }
               }
            }

            if(class92.field1444 > 0) {
               class92.field1444 -= var18 * 4;
            }

            if(class92.field1449 > 0) {
               class92.field1449 -= var18 * 4;
            }

            if(class92.field1444 == 0 && class92.field1449 == 0) {
               var21 = (int)(Math.random() * (double)(2000 / var18));
               if(var21 == 0) {
                  class92.field1444 = 1024;
               }

               if(var21 == 1) {
                  class92.field1449 = 1024;
               }
            }

            for(var21 = 0; var21 < var19 - var18; ++var21) {
               class92.field1447[var21] = class92.field1447[var21 + var18];
            }

            for(var21 = var19 - var18; var21 < var19; ++var21) {
               class92.field1447[var21] = (int)(Math.sin((double)class92.field1453 / 14.0D) * 16.0D + Math.sin((double)class92.field1453 / 15.0D) * 14.0D + Math.sin((double)class92.field1453 / 16.0D) * 12.0D);
               ++class92.field1453;
            }

            class92.field1451 += var18;
            var21 = (var18 + (Client.gameCycle & 1)) / 2;
            if(var21 > 0) {
               for(var10 = 0; var10 < class92.field1451 * 100; ++var10) {
                  var11 = (int)(Math.random() * 124.0D) + 2;
                  var12 = (int)(Math.random() * 128.0D) + 128;
                  class23.field344[(var12 << 7) + var11] = 192;
               }

               class92.field1451 = 0;
               var10 = 0;

               label515:
               while(true) {
                  if(var10 >= var19) {
                     var10 = 0;

                     while(true) {
                        if(var10 >= 128) {
                           break label515;
                        }

                        var11 = 0;

                        for(var12 = -var21; var12 < var19; ++var12) {
                           var13 = var12 * 128;
                           if(var21 + var12 < var19) {
                              var11 += class21.field327[var13 + var10 + var21 * 128];
                           }

                           if(var12 - (var21 + 1) >= 0) {
                              var11 -= class21.field327[var13 + var10 - (var21 + 1) * 128];
                           }

                           if(var12 >= 0) {
                              class23.field344[var10 + var13] = var11 / (var21 * 2 + 1);
                           }
                        }

                        ++var10;
                     }
                  }

                  var11 = 0;
                  var12 = var10 * 128;

                  for(var13 = -var21; var13 < 128; ++var13) {
                     if(var21 + var13 < 128) {
                        var11 += class23.field344[var21 + var13 + var12];
                     }

                     if(var13 - (var21 + 1) >= 0) {
                        var11 -= class23.field344[var12 + var13 - (var21 + 1)];
                     }

                     if(var13 >= 0) {
                        class21.field327[var12 + var13] = var11 / (var21 * 2 + 1);
                     }
                  }

                  ++var10;
               }
            }

            class92.field1452 = 0;
         }

         var17 = 256;
         if(class92.field1444 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class92.field1444 > 768) {
                  class100.field1558[var5] = GameEngine.method849(class270.field3683[var5], FileOnDisk.field1783[var5], 1024 - class92.field1444);
               } else if(class92.field1444 > 256) {
                  class100.field1558[var5] = FileOnDisk.field1783[var5];
               } else {
                  class100.field1558[var5] = GameEngine.method849(FileOnDisk.field1783[var5], class270.field3683[var5], 256 - class92.field1444);
               }
            }
         } else if(class92.field1449 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class92.field1449 > 768) {
                  class100.field1558[var5] = GameEngine.method849(class270.field3683[var5], field1424[var5], 1024 - class92.field1449);
               } else if(class92.field1449 > 256) {
                  class100.field1558[var5] = field1424[var5];
               } else {
                  class100.field1558[var5] = GameEngine.method849(field1424[var5], class270.field3683[var5], 256 - class92.field1449);
               }
            }
         } else {
            for(var5 = 0; var5 < 256; ++var5) {
               class100.field1558[var5] = class270.field3683[var5];
            }
         }

         Rasterizer2D.method4940(class92.field1459, 9, class92.field1459 + 128, var17 + 7);
         class33.field474.method5045(class92.field1459, 0);
         Rasterizer2D.method4914();
         var5 = 0;
         var23 = class92.field1459 + class166.field2343.width * 9;

         int var14;
         for(var7 = 1; var7 < var17 - 1; ++var7) {
            var20 = class92.field1447[var7] * (var17 - var7) / var17;
            var21 = var20 + 22;
            if(var21 < 0) {
               var21 = 0;
            }

            var5 += var21;

            for(var10 = var21; var10 < 128; ++var10) {
               var11 = class23.field344[var5++];
               if(var11 != 0) {
                  var12 = var11;
                  var13 = 256 - var11;
                  var11 = class100.field1558[var11];
                  var14 = class166.field2343.pixels[var23];
                  class166.field2343.pixels[var23++] = (var12 * (var11 & '\uff00') + var13 * (var14 & '\uff00') & 16711680) + (var12 * (var11 & 16711935) + var13 * (var14 & 16711935) & -16711936) >> 8;
               } else {
                  ++var23;
               }
            }

            var23 += class166.field2343.width + var21 - 128;
         }

         Rasterizer2D.method4940(class92.field1459 + 765 - 128, 9, class92.field1459 + 765, var17 + 7);
         class211.field2609.method5045(class92.field1459 + 382, 0);
         Rasterizer2D.method4914();
         var5 = 0;
         var23 = class166.field2343.width * 9 + 24 + 637 + class92.field1459;

         for(var7 = 1; var7 < var17 - 1; ++var7) {
            var20 = (var17 - var7) * class92.field1447[var7] / var17;
            var21 = 103 - var20;
            var23 += var20;

            for(var10 = 0; var10 < var21; ++var10) {
               var11 = class23.field344[var5++];
               if(var11 != 0) {
                  var12 = var11;
                  var13 = 256 - var11;
                  var11 = class100.field1558[var11];
                  var14 = class166.field2343.pixels[var23];
                  class166.field2343.pixels[var23++] = ((var11 & '\uff00') * var12 + var13 * (var14 & '\uff00') & 16711680) + (var13 * (var14 & 16711935) + var12 * (var11 & 16711935) & -16711936) >> 8;
               } else {
                  ++var23;
               }
            }

            var5 += 128 - var21;
            var23 += class166.field2343.width - var21 - var20;
         }

         class56.field692[XGrandExchangeOffer.field303.field1332?1:0].method5017(class92.field1459 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.field1077 == 0) {
            if(class87.field1407 != null) {
               var18 = class92.field1459 + 5;
               var19 = 463;
               byte var24 = 100;
               byte var22 = 35;
               class87.field1407.method5017(var18, var19);
               var0.method4736("World" + " " + Client.world, var24 / 2 + var18, var19 + var22 / 2 - 2, 16777215, 0);
               if(class36.worldServersDownload != null) {
                  var1.method4736("Loading...", var24 / 2 + var18, var19 + var22 / 2 + 12, 16777215, 0);
               } else {
                  var1.method4736("Click to switch", var24 / 2 + var18, var19 + var22 / 2 + 12, 16777215, 0);
               }
            } else {
               class87.field1407 = class84.method1666(class261.indexSprites, "sl_button", "");
            }
         }

      }
   }
}
