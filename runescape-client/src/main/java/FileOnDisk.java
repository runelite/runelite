import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("i")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -8716984470098998479L
   )
   @Export("position")
   long position;
   @ObfuscatedName("a")
   public static short[] field1195;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -5187204452199084659L
   )
   @Export("length")
   long length;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = -9292891
   )
   @Export("menuX")
   static int menuX;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LGameEngine;B)V",
      garbageValue = "74"
   )
   static void method1387(GameEngine var0) {
      if(class41.worldSelectShown) {
         PlayerComposition.method3086(var0);
      } else {
         if((class115.field1802 == 1 || !class103.field1662 && class115.field1802 == 4) && class115.field1803 >= 765 + class41.field824 - 50 && class115.field1804 >= 453) {
            class149.field2044.field692 = !class149.field2044.field692;
            class41.method759();
            if(!class149.field2044.field692) {
               Ignore.method190(class204.field3079, "scape main", "", 255, false);
            } else {
               class172.method3180();
            }
         }

         if(Client.gameState != 5) {
            ++class41.field845;
            if(Client.gameState == 10 || Client.gameState == 11) {
               int var1;
               if(Client.field290 == 0) {
                  if(class115.field1802 == 1 || !class103.field1662 && class115.field1802 == 4) {
                     var1 = 5 + class41.field824;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(class115.field1803 >= var1 && class115.field1803 <= var3 + var1 && class115.field1804 >= var2 && class115.field1804 <= var2 + var4) {
                        if(TextureProvider.loadWorlds()) {
                           class41.worldSelectShown = true;
                        }

                        return;
                     }
                  }

                  if(class6.worldServersDownload != null && TextureProvider.loadWorlds()) {
                     class41.worldSelectShown = true;
                  }
               }

               var1 = class115.field1802;
               int var13 = class115.field1803;
               int var14 = class115.field1804;
               if(!class103.field1662 && var1 == 4) {
                  var1 = 1;
               }

               short var5;
               String var6;
               int var15;
               if(class41.loginIndex == 0) {
                  var15 = 180 + class41.loginWindowX - 80;
                  var5 = 291;
                  if(var1 == 1 && var13 >= var15 - 75 && var13 <= 75 + var15 && var14 >= var5 - 20 && var14 <= var5 + 20) {
                     label761: {
                        var6 = class6.method85("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws";
                        if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                           try {
                              Desktop.getDesktop().browse(new URI(var6));
                              break label761;
                           } catch (Exception var11) {
                              ;
                           }
                        }

                        if(class114.field1784.startsWith("win")) {
                           GroundObject.method1528(var6, 0);
                        } else if(class114.field1784.startsWith("mac")) {
                           NPC.method689(var6, 1, "openjs");
                        } else {
                           GroundObject.method1528(var6, 2);
                        }
                     }
                  }

                  var15 = 80 + 180 + class41.loginWindowX;
                  if(var1 == 1 && var13 >= var15 - 75 && var13 <= 75 + var15 && var14 >= var5 - 20 && var14 <= var5 + 20) {
                     if((Client.flags & 33554432) != 0) {
                        class41.field841 = "";
                        class41.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class41.loginMessage2 = "Your normal account will not be affected.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else if((Client.flags & 4) != 0) {
                        if((Client.flags & 1024) != 0) {
                           class41.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class41.loginMessage2 = "Players can attack each other almost everywhere";
                           class41.loginMessage3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class41.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class41.loginMessage2 = "Players can attack each other";
                           class41.loginMessage3 = "almost everywhere.";
                        }

                        class41.field841 = "Warning!";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class41.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class41.loginMessage2 = "The Protect Item prayer will";
                        class41.loginMessage3 = "not work on this world.";
                        class41.field841 = "Warning!";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     }
                  }
               } else if(class41.loginIndex != 1) {
                  short var16;
                  if(class41.loginIndex == 2) {
                     var16 = 231;
                     var15 = var16 + 30;
                     if(var1 == 1 && var14 >= var15 - 15 && var14 < var15) {
                        class41.loginIndex2 = 0;
                     }

                     var15 += 15;
                     if(var1 == 1 && var14 >= var15 - 15 && var14 < var15) {
                        class41.loginIndex2 = 1;
                     }

                     var15 += 15;
                     var16 = 361;
                     if(var1 == 1 && var14 >= var16 - 15 && var14 < var16) {
                        class22.method204("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class41.loginIndex = 5;
                        return;
                     }

                     int var17 = 180 + class41.loginWindowX - 80;
                     short var9 = 321;
                     if(var1 == 1 && var13 >= var17 - 75 && var13 <= var17 + 75 && var14 >= var9 - 20 && var14 <= 20 + var9) {
                        class41.username = class41.username.trim();
                        if(class41.username.length() == 0) {
                           class22.method204("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class41.field850.length() == 0) {
                           class22.method204("", "Please enter your password.", "");
                           return;
                        }

                        class22.method204("", "Connecting to server...", "");
                        class41.field851 = class149.field2044.field687.containsKey(Integer.valueOf(RSCanvas.method2052(class41.username)))?class97.field1619:class97.field1617;
                        XGrandExchangeOffer.setGameState(20);
                        return;
                     }

                     var17 = 80 + 180 + class41.loginWindowX;
                     if(var1 == 1 && var13 >= var17 - 75 && var13 <= 75 + var17 && var14 >= var9 - 20 && var14 <= 20 + var9) {
                        class41.loginIndex = 0;
                        class41.username = "";
                        class41.field850 = "";
                        class200.field3048 = 0;
                        VertexNormal.authCode = "";
                        class41.field828 = true;
                     }

                     while(true) {
                        while(class44.method782()) {
                           boolean var10 = false;

                           for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                              if(XClanMember.field275 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                 var10 = true;
                                 break;
                              }
                           }

                           if(Tile.field1352 == 13) {
                              class41.loginIndex = 0;
                              class41.username = "";
                              class41.field850 = "";
                              class200.field3048 = 0;
                              VertexNormal.authCode = "";
                              class41.field828 = true;
                           } else if(class41.loginIndex2 == 0) {
                              if(Tile.field1352 == 85 && class41.username.length() > 0) {
                                 class41.username = class41.username.substring(0, class41.username.length() - 1);
                              }

                              if(Tile.field1352 == 84 || Tile.field1352 == 80) {
                                 class41.loginIndex2 = 1;
                              }

                              if(var10 && class41.username.length() < 320) {
                                 class41.username = class41.username + XClanMember.field275;
                              }
                           } else if(class41.loginIndex2 == 1) {
                              if(Tile.field1352 == 85 && class41.field850.length() > 0) {
                                 class41.field850 = class41.field850.substring(0, class41.field850.length() - 1);
                              }

                              if(Tile.field1352 == 84 || Tile.field1352 == 80) {
                                 class41.loginIndex2 = 0;
                              }

                              if(Tile.field1352 == 84) {
                                 class41.username = class41.username.trim();
                                 if(class41.username.length() == 0) {
                                    class22.method204("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class41.field850.length() == 0) {
                                    class22.method204("", "Please enter your password.", "");
                                    return;
                                 }

                                 class22.method204("", "Connecting to server...", "");
                                 class41.field851 = class149.field2044.field687.containsKey(Integer.valueOf(RSCanvas.method2052(class41.username)))?class97.field1619:class97.field1617;
                                 XGrandExchangeOffer.setGameState(20);
                                 return;
                              }

                              if(var10 && class41.field850.length() < 20) {
                                 class41.field850 = class41.field850 + XClanMember.field275;
                              }
                           }
                        }

                        return;
                     }
                  } else if(class41.loginIndex == 3) {
                     var15 = 180 + class41.loginWindowX;
                     var5 = 276;
                     if(var1 == 1 && var13 >= var15 - 75 && var13 <= var15 + 75 && var14 >= var5 - 20 && var14 <= 20 + var5) {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     }

                     var15 = class41.loginWindowX + 180;
                     var5 = 326;
                     if(var1 == 1 && var13 >= var15 - 75 && var13 <= 75 + var15 && var14 >= var5 - 20 && var14 <= 20 + var5) {
                        class22.method204("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class41.loginIndex = 5;
                        return;
                     }
                  } else {
                     boolean var18;
                     int var19;
                     if(class41.loginIndex == 4) {
                        var15 = class41.loginWindowX + 180 - 80;
                        var5 = 321;
                        if(var1 == 1 && var13 >= var15 - 75 && var13 <= 75 + var15 && var14 >= var5 - 20 && var14 <= var5 + 20) {
                           VertexNormal.authCode.trim();
                           if(VertexNormal.authCode.length() != 6) {
                              class22.method204("", "Please enter a 6-digin PIN.", "");
                              return;
                           }

                           class200.field3048 = Integer.parseInt(VertexNormal.authCode);
                           VertexNormal.authCode = "";
                           class41.field851 = class41.field828?class97.field1618:class97.field1620;
                           class22.method204("", "Connecting to server...", "");
                           XGrandExchangeOffer.setGameState(20);
                           return;
                        }

                        if(var1 == 1 && var13 >= 180 + class41.loginWindowX - 9 && var13 <= 180 + class41.loginWindowX + 130 && var14 >= 263 && var14 <= 296) {
                           class41.field828 = !class41.field828;
                        }

                        if(var1 == 1 && var13 >= class41.loginWindowX + 180 - 34 && var13 <= 180 + class41.loginWindowX + 34 && var14 >= 351 && var14 <= 363) {
                           label776: {
                              var6 = class6.method85("secure", true) + "m=totp-authenticator/disableTOTPRequest";
                              if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                                 try {
                                    Desktop.getDesktop().browse(new URI(var6));
                                    break label776;
                                 } catch (Exception var12) {
                                    ;
                                 }
                              }

                              if(class114.field1784.startsWith("win")) {
                                 GroundObject.method1528(var6, 0);
                              } else if(class114.field1784.startsWith("mac")) {
                                 NPC.method689(var6, 1, "openjs");
                              } else {
                                 GroundObject.method1528(var6, 2);
                              }
                           }
                        }

                        var15 = class41.loginWindowX + 180 + 80;
                        if(var1 == 1 && var13 >= var15 - 75 && var13 <= 75 + var15 && var14 >= var5 - 20 && var14 <= 20 + var5) {
                           class41.loginIndex = 0;
                           class41.username = "";
                           class41.field850 = "";
                           class200.field3048 = 0;
                           VertexNormal.authCode = "";
                        }

                        while(class44.method782()) {
                           var18 = false;

                           for(var19 = 0; var19 < "1234567890".length(); ++var19) {
                              if(XClanMember.field275 == "1234567890".charAt(var19)) {
                                 var18 = true;
                                 break;
                              }
                           }

                           if(Tile.field1352 == 13) {
                              class41.loginIndex = 0;
                              class41.username = "";
                              class41.field850 = "";
                              class200.field3048 = 0;
                              VertexNormal.authCode = "";
                           } else {
                              if(Tile.field1352 == 85 && VertexNormal.authCode.length() > 0) {
                                 VertexNormal.authCode = VertexNormal.authCode.substring(0, VertexNormal.authCode.length() - 1);
                              }

                              if(Tile.field1352 == 84) {
                                 VertexNormal.authCode.trim();
                                 if(VertexNormal.authCode.length() != 6) {
                                    class22.method204("", "Please enter a 6-digin PIN.", "");
                                    return;
                                 }

                                 class200.field3048 = Integer.parseInt(VertexNormal.authCode);
                                 VertexNormal.authCode = "";
                                 class41.field851 = class41.field828?class97.field1618:class97.field1620;
                                 class22.method204("", "Connecting to server...", "");
                                 XGrandExchangeOffer.setGameState(20);
                                 return;
                              }

                              if(var18 && VertexNormal.authCode.length() < 6) {
                                 VertexNormal.authCode = VertexNormal.authCode + XClanMember.field275;
                              }
                           }
                        }
                     } else if(class41.loginIndex == 5) {
                        var15 = class41.loginWindowX + 180 - 80;
                        var5 = 321;
                        if(var1 == 1 && var13 >= var15 - 75 && var13 <= 75 + var15 && var14 >= var5 - 20 && var14 <= var5 + 20) {
                           class49.method866();
                           return;
                        }

                        var15 = 80 + 180 + class41.loginWindowX;
                        if(var1 == 1 && var13 >= var15 - 75 && var13 <= 75 + var15 && var14 >= var5 - 20 && var14 <= var5 + 20) {
                           class41.loginMessage1 = "";
                           class41.loginMessage2 = "Enter your username/email & password.";
                           class41.loginMessage3 = "";
                           class41.loginIndex = 2;
                           class41.loginIndex2 = 0;
                           class41.field850 = "";
                        }

                        while(class44.method782()) {
                           var18 = false;

                           for(var19 = 0; var19 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var19) {
                              if(XClanMember.field275 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var19)) {
                                 var18 = true;
                                 break;
                              }
                           }

                           if(Tile.field1352 == 13) {
                              class41.loginMessage1 = "";
                              class41.loginMessage2 = "Enter your username/email & password.";
                              class41.loginMessage3 = "";
                              class41.loginIndex = 2;
                              class41.loginIndex2 = 0;
                              class41.field850 = "";
                           } else {
                              if(Tile.field1352 == 85 && class41.username.length() > 0) {
                                 class41.username = class41.username.substring(0, class41.username.length() - 1);
                              }

                              if(Tile.field1352 == 84) {
                                 class49.method866();
                                 return;
                              }

                              if(var18 && class41.username.length() < 320) {
                                 class41.username = class41.username + XClanMember.field275;
                              }
                           }
                        }
                     } else if(class41.loginIndex == 6) {
                        while(true) {
                           do {
                              if(!class44.method782()) {
                                 var16 = 321;
                                 if(var1 == 1 && var14 >= var16 - 20 && var14 <= var16 + 20) {
                                    class41.loginMessage1 = "";
                                    class41.loginMessage2 = "Enter your username/email & password.";
                                    class41.loginMessage3 = "";
                                    class41.loginIndex = 2;
                                    class41.loginIndex2 = 0;
                                    class41.field850 = "";
                                 }

                                 return;
                              }
                           } while(Tile.field1352 != 84 && Tile.field1352 != 13);

                           class41.loginMessage1 = "";
                           class41.loginMessage2 = "Enter your username/email & password.";
                           class41.loginMessage3 = "";
                           class41.loginIndex = 2;
                           class41.loginIndex2 = 0;
                           class41.field850 = "";
                        }
                     }
                  }
               } else {
                  while(class44.method782()) {
                     if(Tile.field1352 == 84) {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     } else if(Tile.field1352 == 13) {
                        class41.loginIndex = 0;
                     }
                  }

                  var15 = 180 + class41.loginWindowX - 80;
                  var5 = 321;
                  if(var1 == 1 && var13 >= var15 - 75 && var13 <= 75 + var15 && var14 >= var5 - 20 && var14 <= var5 + 20) {
                     class41.loginMessage1 = "";
                     class41.loginMessage2 = "Enter your username/email & password.";
                     class41.loginMessage3 = "";
                     class41.loginIndex = 2;
                     class41.loginIndex2 = 0;
                  }

                  var15 = 80 + 180 + class41.loginWindowX;
                  if(var1 == 1 && var13 >= var15 - 75 && var13 <= var15 + 75 && var14 >= var5 - 20 && var14 <= 20 + var5) {
                     class41.loginIndex = 0;
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "22"
   )
   public final void method1388(byte[] var1, int var2, int var3) throws IOException {
      if(this.position + (long)var3 > this.length) {
         this.file.seek(this.length + 1L);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-851160590"
   )
   public final void method1389() throws IOException {
      if(this.file != null) {
         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "861372290"
   )
   public final long method1390() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("i")
   final void method1391(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "84"
   )
   public final int method1392(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   public FileOnDisk(File var1, String var2, long var3) throws IOException {
      if(-1L == var3) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.file = new RandomAccessFile(var1, var2);
      this.length = var3;
      this.position = 0L;
      int var5 = this.file.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.file.seek(0L);
         this.file.write(var5);
      }

      this.file.seek(0L);
   }

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.method1389();
      }

   }
}
