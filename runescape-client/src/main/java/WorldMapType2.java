import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1636152923
   )
   int field491;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -131324117
   )
   int field495;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1052337055
   )
   int field492;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -839148491
   )
   int field496;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -643526111
   )
   int field493;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 659571243
   )
   int field494;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-198305855"
   )
   public boolean vmethod715(int var1, int var2) {
      return var1 >> 6 == this.field495 && var2 >> 6 == this.field496;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIS)Z",
      garbageValue = "4496"
   )
   public boolean vmethod714(int var1, int var2, int var3) {
      return var1 >= this.field491 && var1 < this.field492 + this.field491?var2 >> 6 == this.field493 && var3 >> 6 == this.field494:false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lae;B)V",
      garbageValue = "103"
   )
   public void vmethod713(WorldMapData var1) {
      if(var1.field429 > this.field495) {
         var1.field429 = this.field495;
      }

      if(var1.field430 < this.field495) {
         var1.field430 = this.field495;
      }

      if(var1.field431 > this.field496) {
         var1.field431 = this.field496;
      }

      if(var1.field432 < this.field496) {
         var1.field432 = this.field496;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)Lhy;",
      garbageValue = "-93"
   )
   public Coordinates vmethod717(int var1, int var2) {
      if(!this.vmethod715(var1, var2)) {
         return null;
      } else {
         int var3 = var1 + (this.field493 * 64 - this.field495 * 64);
         int var4 = var2 + (this.field494 * 64 - this.field496 * 64);
         return new Coordinates(this.field491, var3, var4);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIB)[I",
      garbageValue = "32"
   )
   public int[] vmethod716(int var1, int var2, int var3) {
      if(!this.vmethod714(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field495 * 64 - this.field493 * 64 + var2, var3 + (this.field496 * 64 - this.field494 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1677838449"
   )
   void method537() {
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfw;I)V",
      garbageValue = "996105043"
   )
   public void vmethod718(Buffer var1) {
      this.field491 = var1.readUnsignedByte();
      this.field492 = var1.readUnsignedByte();
      this.field493 = var1.readUnsignedShort();
      this.field494 = var1.readUnsignedShort();
      this.field495 = var1.readUnsignedShort();
      this.field496 = var1.readUnsignedShort();
      this.method537();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1516702108"
   )
   static void method544(int var0, int var1, int var2, int var3) {
      for(class82 var4 = (class82)class82.field1286.getFront(); var4 != null; var4 = (class82)class82.field1286.getNext()) {
         if(var4.field1290 != -1 || var4.field1294 != null) {
            int var5 = 0;
            if(var1 > var4.field1287) {
               var5 += var1 - var4.field1287;
            } else if(var1 < var4.field1285) {
               var5 += var4.field1285 - var1;
            }

            if(var2 > var4.field1292) {
               var5 += var2 - var4.field1292;
            } else if(var2 < var4.field1298) {
               var5 += var4.field1298 - var2;
            }

            if(var5 - 64 <= var4.field1289 && Client.field1123 != 0 && var0 == var4.field1284) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = (var4.field1289 - var5) * Client.field1123 / var4.field1289;
               if(var4.field1291 == null) {
                  if(var4.field1290 >= 0) {
                     SoundEffect var7 = SoundEffect.getTrack(class207.field2555, var4.field1290, 0);
                     if(var7 != null) {
                        class109 var8 = var7.method2001().method2049(CacheFile.field1539);
                        class119 var9 = class119.method2195(var8, 100, var6);
                        var9.method2198(-1);
                        class2.field18.method1937(var9);
                        var4.field1291 = var9;
                     }
                  }
               } else {
                  var4.field1291.method2199(var6);
               }

               if(var4.field1296 == null) {
                  if(var4.field1294 != null && (var4.field1283 -= var3) <= 0) {
                     int var11 = (int)(Math.random() * (double)var4.field1294.length);
                     SoundEffect var12 = SoundEffect.getTrack(class207.field2555, var4.field1294[var11], 0);
                     if(var12 != null) {
                        class109 var13 = var12.method2001().method2049(CacheFile.field1539);
                        class119 var10 = class119.method2195(var13, 100, var6);
                        var10.method2198(0);
                        class2.field18.method1937(var10);
                        var4.field1296 = var10;
                        var4.field1283 = var4.field1297 + (int)(Math.random() * (double)(var4.field1293 - var4.field1297));
                     }
                  }
               } else {
                  var4.field1296.method2199(var6);
                  if(!var4.field1296.linked()) {
                     var4.field1296 = null;
                  }
               }
            } else {
               if(var4.field1291 != null) {
                  class2.field18.method1938(var4.field1291);
                  var4.field1291 = null;
               }

               if(var4.field1296 != null) {
                  class2.field18.method1938(var4.field1296);
                  var4.field1296 = null;
               }
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lbh;I)V",
      garbageValue = "-1479860926"
   )
   static void method542(GameEngine var0) {
      int var1;
      int var10;
      int var11;
      int var13;
      if(class92.worldSelectShown) {
         if(MouseInput.field697 == 1 || !class67.field792 && MouseInput.field697 == 4) {
            var1 = class92.field1416 + 280;
            if(MouseInput.field709 >= var1 && MouseInput.field709 <= var1 + 14 && MouseInput.field713 >= 4 && MouseInput.field713 <= 18) {
               class21.method146(0, 0);
            } else if(MouseInput.field709 >= var1 + 15 && MouseInput.field709 <= var1 + 80 && MouseInput.field713 >= 4 && MouseInput.field713 <= 18) {
               class21.method146(0, 1);
            } else {
               var10 = class92.field1416 + 390;
               if(MouseInput.field709 >= var10 && MouseInput.field709 <= var10 + 14 && MouseInput.field713 >= 4 && MouseInput.field713 <= 18) {
                  class21.method146(1, 0);
               } else if(MouseInput.field709 >= var10 + 15 && MouseInput.field709 <= var10 + 80 && MouseInput.field713 >= 4 && MouseInput.field713 <= 18) {
                  class21.method146(1, 1);
               } else {
                  var11 = class92.field1416 + 500;
                  if(MouseInput.field709 >= var11 && MouseInput.field709 <= var11 + 14 && MouseInput.field713 >= 4 && MouseInput.field713 <= 18) {
                     class21.method146(2, 0);
                  } else if(MouseInput.field709 >= var11 + 15 && MouseInput.field709 <= var11 + 80 && MouseInput.field713 >= 4 && MouseInput.field713 <= 18) {
                     class21.method146(2, 1);
                  } else {
                     var13 = class92.field1416 + 610;
                     if(MouseInput.field709 >= var13 && MouseInput.field709 <= var13 + 14 && MouseInput.field713 >= 4 && MouseInput.field713 <= 18) {
                        class21.method146(3, 0);
                     } else if(MouseInput.field709 >= var13 + 15 && MouseInput.field709 <= var13 + 80 && MouseInput.field713 >= 4 && MouseInput.field713 <= 18) {
                        class21.method146(3, 1);
                     } else if(MouseInput.field709 >= class92.field1416 + 708 && MouseInput.field713 >= 4 && MouseInput.field709 <= class92.field1416 + 708 + 50 && MouseInput.field713 <= 20) {
                        class92.worldSelectShown = false;
                        class92.field1411.method5067(class92.field1416, 0);
                        class92.field1399.method5067(class92.field1416 + 382, 0);
                        class11.logoSprite.method5034(class92.field1416 + 382 - class11.logoSprite.originalWidth / 2, 18);
                     } else if(class92.field1404 != -1) {
                        World var5 = World.worldList[class92.field1404];
                        WorldMapType3.method203(var5);
                        class92.worldSelectShown = false;
                        class92.field1411.method5067(class92.field1416, 0);
                        class92.field1399.method5067(class92.field1416 + 382, 0);
                        class11.logoSprite.method5034(class92.field1416 + 382 - class11.logoSprite.originalWidth / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((MouseInput.field697 == 1 || !class67.field792 && MouseInput.field697 == 4) && MouseInput.field709 >= class92.field1416 + 765 - 50 && MouseInput.field713 >= 453) {
            class170.preferences.muted = !class170.preferences.muted;
            Projectile.method1762();
            if(!class170.preferences.muted) {
               WorldMapType3.method204(class2.indexTrack1, "scape main", "", 255, false);
            } else {
               class48.method729();
            }
         }

         if(Client.gameState != 5) {
            ++class92.field1413;
            if(Client.gameState == 10 || Client.gameState == 11) {
               if(Client.languageId == 0) {
                  if(MouseInput.field697 == 1 || !class67.field792 && MouseInput.field697 == 4) {
                     var1 = class92.field1416 + 5;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(MouseInput.field709 >= var1 && MouseInput.field709 <= var3 + var1 && MouseInput.field713 >= var2 && MouseInput.field713 <= var4 + var2) {
                        if(class87.loadWorlds()) {
                           class92.worldSelectShown = true;
                        }

                        return;
                     }
                  }

                  if(World.listFetcher != null && class87.loadWorlds()) {
                     class92.worldSelectShown = true;
                  }
               }

               var1 = MouseInput.field697;
               var10 = MouseInput.field709;
               var11 = MouseInput.field713;
               if(!class67.field792 && var1 == 4) {
                  var1 = 1;
               }

               short var6;
               int var9;
               if(class92.loginIndex == 0) {
                  boolean var12 = false;

                  while(class12.method71()) {
                     if(DState.field2348 == 84) {
                        var12 = true;
                     }
                  }

                  var9 = class92.loginWindowX + 180 - 80;
                  var6 = 291;
                  if(var1 == 1 && var10 >= var9 - 75 && var10 <= var9 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                     DynamicObject.method1871(class71.method1131("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var9 = class92.loginWindowX + 180 + 80;
                  if(var1 == 1 && var10 >= var9 - 75 && var10 <= var9 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20 || var12) {
                     if((Client.flags & 33554432) != 0) {
                        class92.field1412 = "";
                        class92.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class92.loginMessage2 = "Your normal account will not be affected.";
                        class92.loginMessage3 = "";
                        class92.loginIndex = 1;
                        class92.loginIndex2 = 0;
                     } else if((Client.flags & 4) != 0) {
                        if((Client.flags & 1024) != 0) {
                           class92.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class92.loginMessage2 = "Players can attack each other almost everywhere";
                           class92.loginMessage3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class92.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class92.loginMessage2 = "Players can attack each other";
                           class92.loginMessage3 = "almost everywhere.";
                        }

                        class92.field1412 = "Warning!";
                        class92.loginIndex = 1;
                        class92.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class92.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class92.loginMessage2 = "The Protect Item prayer will";
                        class92.loginMessage3 = "not work on this world.";
                        class92.field1412 = "Warning!";
                        class92.loginIndex = 1;
                        class92.loginIndex2 = 0;
                     } else {
                        class92.loginMessage1 = "";
                        class92.loginMessage2 = "Enter your username/email & password.";
                        class92.loginMessage3 = "";
                        class92.loginIndex = 2;
                        class92.loginIndex2 = 0;
                     }
                  }
               } else {
                  short var17;
                  if(class92.loginIndex != 1) {
                     short var14;
                     if(class92.loginIndex == 2) {
                        var14 = 231;
                        var13 = var14 + 30;
                        if(var1 == 1 && var11 >= var13 - 15 && var11 < var13) {
                           class92.loginIndex2 = 0;
                        }

                        var13 += 15;
                        if(var1 == 1 && var11 >= var13 - 15 && var11 < var13) {
                           class92.loginIndex2 = 1;
                        }

                        var13 += 15;
                        var14 = 361;
                        if(var1 == 1 && var11 >= var14 - 15 && var11 < var14) {
                           PendingSpawn.method1526("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class92.loginIndex = 5;
                           return;
                        }

                        var9 = class92.loginWindowX + 180 - 80;
                        var6 = 321;
                        if(var1 == 1 && var10 >= var9 - 75 && var10 <= var9 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                           class92.username = class92.username.trim();
                           if(class92.username.length() == 0) {
                              PendingSpawn.method1526("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class92.password.length() == 0) {
                              PendingSpawn.method1526("", "Please enter your password.", "");
                              return;
                           }

                           PendingSpawn.method1526("", "Connecting to server...", "");
                           class92.field1418 = class170.preferences.preferences.containsKey(Integer.valueOf(ChatLineBuffer.method1878(class92.username)))?class149.field2177:class149.field2174;
                           class2.setGameState(20);
                           return;
                        }

                        var9 = class92.loginWindowX + 180 + 80;
                        if(var1 == 1 && var10 >= var9 - 75 && var10 <= var9 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                           class92.loginIndex = 0;
                           class92.username = "";
                           class92.password = "";
                           class41.authCodeForLogin = 0;
                           class17.authCode = "";
                           class92.field1419 = true;
                        }

                        while(true) {
                           while(class12.method71()) {
                              boolean var7 = false;

                              for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                                 if(class1.field8 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                    var7 = true;
                                    break;
                                 }
                              }

                              if(DState.field2348 == 13) {
                                 class92.loginIndex = 0;
                                 class92.username = "";
                                 class92.password = "";
                                 class41.authCodeForLogin = 0;
                                 class17.authCode = "";
                                 class92.field1419 = true;
                              } else if(class92.loginIndex2 == 0) {
                                 if(DState.field2348 == 85 && class92.username.length() > 0) {
                                    class92.username = class92.username.substring(0, class92.username.length() - 1);
                                 }

                                 if(DState.field2348 == 84 || DState.field2348 == 80) {
                                    class92.loginIndex2 = 1;
                                 }

                                 if(var7 && class92.username.length() < 320) {
                                    class92.username = class92.username + class1.field8;
                                 }
                              } else if(class92.loginIndex2 == 1) {
                                 if(DState.field2348 == 85 && class92.password.length() > 0) {
                                    class92.password = class92.password.substring(0, class92.password.length() - 1);
                                 }

                                 if(DState.field2348 == 84 || DState.field2348 == 80) {
                                    class92.loginIndex2 = 0;
                                 }

                                 if(DState.field2348 == 84) {
                                    class92.username = class92.username.trim();
                                    if(class92.username.length() == 0) {
                                       PendingSpawn.method1526("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class92.password.length() == 0) {
                                       PendingSpawn.method1526("", "Please enter your password.", "");
                                       return;
                                    }

                                    PendingSpawn.method1526("", "Connecting to server...", "");
                                    class92.field1418 = class170.preferences.preferences.containsKey(Integer.valueOf(ChatLineBuffer.method1878(class92.username)))?class149.field2177:class149.field2174;
                                    class2.setGameState(20);
                                    return;
                                 }

                                 if(var7 && class92.password.length() < 20) {
                                    class92.password = class92.password + class1.field8;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class92.loginIndex == 3) {
                        var13 = class92.loginWindowX + 180;
                        var17 = 276;
                        if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                           class92.loginMessage1 = "";
                           class92.loginMessage2 = "Enter your username/email & password.";
                           class92.loginMessage3 = "";
                           class92.loginIndex = 2;
                           class92.loginIndex2 = 0;
                        }

                        var13 = class92.loginWindowX + 180;
                        var17 = 326;
                        if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                           PendingSpawn.method1526("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class92.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var15;
                        int var16;
                        if(class92.loginIndex == 4) {
                           var13 = class92.loginWindowX + 180 - 80;
                           var17 = 321;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                              class17.authCode.trim();
                              if(class17.authCode.length() != 6) {
                                 PendingSpawn.method1526("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              class41.authCodeForLogin = Integer.parseInt(class17.authCode);
                              class17.authCode = "";
                              class92.field1418 = class92.field1419?class149.field2176:class149.field2175;
                              PendingSpawn.method1526("", "Connecting to server...", "");
                              class2.setGameState(20);
                              return;
                           }

                           if(var1 == 1 && var10 >= class92.loginWindowX + 180 - 9 && var10 <= class92.loginWindowX + 180 + 130 && var11 >= 263 && var11 <= 296) {
                              class92.field1419 = !class92.field1419;
                           }

                           if(var1 == 1 && var10 >= class92.loginWindowX + 180 - 34 && var10 <= class92.loginWindowX + 34 + 180 && var11 >= 351 && var11 <= 363) {
                              DynamicObject.method1871(class71.method1131("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                           }

                           var13 = class92.loginWindowX + 180 + 80;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                              class92.loginIndex = 0;
                              class92.username = "";
                              class92.password = "";
                              class41.authCodeForLogin = 0;
                              class17.authCode = "";
                           }

                           while(class12.method71()) {
                              var15 = false;

                              for(var16 = 0; var16 < "1234567890".length(); ++var16) {
                                 if(class1.field8 == "1234567890".charAt(var16)) {
                                    var15 = true;
                                    break;
                                 }
                              }

                              if(DState.field2348 == 13) {
                                 class92.loginIndex = 0;
                                 class92.username = "";
                                 class92.password = "";
                                 class41.authCodeForLogin = 0;
                                 class17.authCode = "";
                              } else {
                                 if(DState.field2348 == 85 && class17.authCode.length() > 0) {
                                    class17.authCode = class17.authCode.substring(0, class17.authCode.length() - 1);
                                 }

                                 if(DState.field2348 == 84) {
                                    class17.authCode.trim();
                                    if(class17.authCode.length() != 6) {
                                       PendingSpawn.method1526("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    class41.authCodeForLogin = Integer.parseInt(class17.authCode);
                                    class17.authCode = "";
                                    class92.field1418 = class92.field1419?class149.field2176:class149.field2175;
                                    PendingSpawn.method1526("", "Connecting to server...", "");
                                    class2.setGameState(20);
                                    return;
                                 }

                                 if(var15 && class17.authCode.length() < 6) {
                                    class17.authCode = class17.authCode + class1.field8;
                                 }
                              }
                           }
                        } else if(class92.loginIndex == 5) {
                           var13 = class92.loginWindowX + 180 - 80;
                           var17 = 321;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                              class10.method50();
                              return;
                           }

                           var13 = class92.loginWindowX + 180 + 80;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                              class92.loginMessage1 = "";
                              class92.loginMessage2 = "Enter your username/email & password.";
                              class92.loginMessage3 = "";
                              class92.loginIndex = 2;
                              class92.loginIndex2 = 0;
                              class92.password = "";
                           }

                           while(class12.method71()) {
                              var15 = false;

                              for(var16 = 0; var16 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var16) {
                                 if(class1.field8 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var16)) {
                                    var15 = true;
                                    break;
                                 }
                              }

                              if(DState.field2348 == 13) {
                                 class92.loginMessage1 = "";
                                 class92.loginMessage2 = "Enter your username/email & password.";
                                 class92.loginMessage3 = "";
                                 class92.loginIndex = 2;
                                 class92.loginIndex2 = 0;
                                 class92.password = "";
                              } else {
                                 if(DState.field2348 == 85 && class92.username.length() > 0) {
                                    class92.username = class92.username.substring(0, class92.username.length() - 1);
                                 }

                                 if(DState.field2348 == 84) {
                                    class10.method50();
                                    return;
                                 }

                                 if(var15 && class92.username.length() < 320) {
                                    class92.username = class92.username + class1.field8;
                                 }
                              }
                           }
                        } else if(class92.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!class12.method71()) {
                                    var14 = 321;
                                    if(var1 == 1 && var11 >= var14 - 20 && var11 <= var14 + 20) {
                                       class92.loginMessage1 = "";
                                       class92.loginMessage2 = "Enter your username/email & password.";
                                       class92.loginMessage3 = "";
                                       class92.loginIndex = 2;
                                       class92.loginIndex2 = 0;
                                       class92.password = "";
                                    }

                                    return;
                                 }
                              } while(DState.field2348 != 84 && DState.field2348 != 13);

                              class92.loginMessage1 = "";
                              class92.loginMessage2 = "Enter your username/email & password.";
                              class92.loginMessage3 = "";
                              class92.loginIndex = 2;
                              class92.loginIndex2 = 0;
                              class92.password = "";
                           }
                        }
                     }
                  } else {
                     while(class12.method71()) {
                        if(DState.field2348 == 84) {
                           class92.loginMessage1 = "";
                           class92.loginMessage2 = "Enter your username/email & password.";
                           class92.loginMessage3 = "";
                           class92.loginIndex = 2;
                           class92.loginIndex2 = 0;
                        } else if(DState.field2348 == 13) {
                           class92.loginIndex = 0;
                        }
                     }

                     var13 = class92.loginWindowX + 180 - 80;
                     var17 = 321;
                     if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                        class92.loginMessage1 = "";
                        class92.loginMessage2 = "Enter your username/email & password.";
                        class92.loginMessage3 = "";
                        class92.loginIndex = 2;
                        class92.loginIndex2 = 0;
                     }

                     var13 = class92.loginWindowX + 180 + 80;
                     if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                        class92.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)Lbj;",
      garbageValue = "857100978"
   )
   static MessageNode method543(int var0, int var1) {
      ChatLineBuffer var2 = (ChatLineBuffer)class98.chatLineMap.get(Integer.valueOf(var0));
      return var2.method1874(var1);
   }
}
