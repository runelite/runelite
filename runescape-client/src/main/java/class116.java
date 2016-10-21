import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
public class class116 {
   @ObfuscatedName("f")
   int[] field2017;
   @ObfuscatedName("e")
   byte[] field2018;
   @ObfuscatedName("co")
   static class146 field2019;
   @ObfuscatedName("n")
   int[] field2021;
   @ObfuscatedName("qk")
   @ObfuscatedGetter(
      intValue = -1300921409
   )
   protected static int field2022;

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;LWidget;B)Ljava/lang/String;",
      garbageValue = "10"
   )
   static String method2461(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               String var4 = var0.substring(0, var3);
               int var6 = class51.method1069(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(2 + var3);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var7 = "";
            if(class20.field567 != null) {
               var7 = GameObject.method2233(class20.field567.field2258);
               if(null != class20.field567.field2266) {
                  var7 = (String)class20.field567.field2266;
               }
            }

            var0 = var0.substring(0, var2) + var7 + var0.substring(4 + var2);
         }
      }

      return var0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BII[BII)I",
      garbageValue = "-244413310"
   )
   public int method2462(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field2017[var8];
         byte var10 = this.field2018[var8];
         if(var10 == 0) {
            throw new RuntimeException("");
         }

         int var11 = var7 >> 3;
         int var12 = var7 & 7;
         var6 &= -var12 >> 31;
         int var13 = var11 + (var12 + var10 - 1 >> 3);
         var12 += 24;
         var4[var11] = (byte)(var6 |= var9 >>> var12);
         if(var11 < var13) {
            ++var11;
            var12 -= 8;
            var4[var11] = (byte)(var6 = var9 >>> var12);
            if(var11 < var13) {
               ++var11;
               var12 -= 8;
               var4[var11] = (byte)(var6 = var9 >>> var12);
               if(var11 < var13) {
                  ++var11;
                  var12 -= 8;
                  var4[var11] = (byte)(var6 = var9 >>> var12);
                  if(var11 < var13) {
                     ++var11;
                     var12 -= 8;
                     var4[var11] = (byte)(var6 = var9 << -var12);
                  }
               }
            }
         }

         var7 += var10;
      }

      return (var7 + 7 >> 3) - var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BI[BIIB)I",
      garbageValue = "-18"
   )
   public int method2463(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(var5 == 0) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.field2021[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.field2021[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 64) != 0) {
               var6 = this.field2021[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2021[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.field2021[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2021[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 16) != 0) {
               var6 = this.field2021[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2021[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 8) != 0) {
               var6 = this.field2021[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2021[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.field2021[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2021[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 2) != 0) {
               var6 = this.field2021[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2021[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 1) != 0) {
               var6 = this.field2021[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2021[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            ++var7;
         }

         return 1 + var7 - var2;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LGameEngine;S)V",
      garbageValue = "25304"
   )
   static void method2467(GameEngine var0) {
      int var1;
      int var2;
      int var3;
      int var16;
      if(class33.worldSelectShown) {
         if(class143.field2198 == 1 || !ChatMessages.field276 && class143.field2198 == 4) {
            var1 = class33.field720 + 280;
            if(class143.field2197 >= var1 && class143.field2197 <= 14 + var1 && class143.field2207 >= 4 && class143.field2207 <= 18) {
               class1.method7(0, 0);
            } else if(class143.field2197 >= 15 + var1 && class143.field2197 <= var1 + 80 && class143.field2207 >= 4 && class143.field2207 <= 18) {
               class1.method7(0, 1);
            } else {
               var2 = class33.field720 + 390;
               if(class143.field2197 >= var2 && class143.field2197 <= var2 + 14 && class143.field2207 >= 4 && class143.field2207 <= 18) {
                  class1.method7(1, 0);
               } else if(class143.field2197 >= 15 + var2 && class143.field2197 <= 80 + var2 && class143.field2207 >= 4 && class143.field2207 <= 18) {
                  class1.method7(1, 1);
               } else {
                  var3 = 500 + class33.field720;
                  if(class143.field2197 >= var3 && class143.field2197 <= var3 + 14 && class143.field2207 >= 4 && class143.field2207 <= 18) {
                     class1.method7(2, 0);
                  } else if(class143.field2197 >= var3 + 15 && class143.field2197 <= var3 + 80 && class143.field2207 >= 4 && class143.field2207 <= 18) {
                     class1.method7(2, 1);
                  } else {
                     var16 = 610 + class33.field720;
                     if(class143.field2197 >= var16 && class143.field2197 <= var16 + 14 && class143.field2207 >= 4 && class143.field2207 <= 18) {
                        class1.method7(3, 0);
                     } else if(class143.field2197 >= 15 + var16 && class143.field2197 <= 80 + var16 && class143.field2207 >= 4 && class143.field2207 <= 18) {
                        class1.method7(3, 1);
                     } else if(class143.field2197 >= 708 + class33.field720 && class143.field2207 >= 4 && class143.field2197 <= 50 + class33.field720 + 708 && class143.field2207 <= 20) {
                        class33.worldSelectShown = false;
                        class33.field731.method1761(class33.field720, 0);
                        class33.field725.method1761(382 + class33.field720, 0);
                        class33.field749.method1913(382 + class33.field720 - class33.field749.originalWidth / 2, 18);
                     } else if(class33.field752 != -1) {
                        World var5 = World.worldList[class33.field752];
                        ChatMessages.selectWorld(var5);
                        class33.worldSelectShown = false;
                        class33.field731.method1761(class33.field720, 0);
                        class33.field725.method1761(class33.field720 + 382, 0);
                        class33.field749.method1913(class33.field720 + 382 - class33.field749.originalWidth / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((class143.field2198 == 1 || !ChatMessages.field276 && class143.field2198 == 4) && class143.field2197 >= 765 + class33.field720 - 50 && class143.field2207 >= 453) {
            class16.field232.field138 = !class16.field232.field138;
            class18.method193();
            if(!class16.field232.field138) {
               class171 var9 = class47.field1050;
               var2 = var9.method3299("scape main");
               var3 = var9.method3361(var2, "");
               class1.method16(var9, var2, var3, 255, false);
            } else {
               class154.method3172();
            }
         }

         if(Client.gameState != 5) {
            ++class33.field719;
            if(Client.gameState == 10 || Client.gameState == 11) {
               if(Client.field287 == 0) {
                  if(class143.field2198 == 1 || !ChatMessages.field276 && class143.field2198 == 4) {
                     var1 = 5 + class33.field720;
                     short var14 = 463;
                     byte var15 = 100;
                     byte var4 = 35;
                     if(class143.field2197 >= var1 && class143.field2197 <= var1 + var15 && class143.field2207 >= var14 && class143.field2207 <= var4 + var14) {
                        class34.method724();
                        return;
                     }
                  }

                  if(class13.worldServersDownload != null) {
                     class34.method724();
                  }
               }

               var1 = class143.field2198;
               var2 = class143.field2197;
               var3 = class143.field2207;
               if(!ChatMessages.field276 && var1 == 4) {
                  var1 = 1;
               }

               short var10;
               if(class33.loginIndex == 0) {
                  var16 = class33.loginWindowX + 180 - 80;
                  var10 = 291;
                  if(var1 == 1 && var2 >= var16 - 75 && var2 <= var16 + 75 && var3 >= var10 - 20 && var3 <= var10 + 20) {
                     label877: {
                        String var6 = class129.method2826("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws";
                        if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                           try {
                              Desktop.getDesktop().browse(new URI(var6));
                              break label877;
                           } catch (Exception var13) {
                              ;
                           }
                        }

                        if(class141.field2180.startsWith("win")) {
                           class20.method565(var6, 0);
                        } else if(class141.field2180.startsWith("mac")) {
                           SecondaryBufferProvider.method1668(var6, 1, "openjs");
                        } else {
                           class20.method565(var6, 2);
                        }
                     }
                  }

                  var16 = 80 + 180 + class33.loginWindowX;
                  if(var1 == 1 && var2 >= var16 - 75 && var2 <= var16 + 75 && var3 >= var10 - 20 && var3 <= var10 + 20) {
                     if((Client.flags & 33554432) != 0) {
                        class33.field740 = "";
                        class33.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class33.loginMessage2 = "Your normal account will not be affected.";
                        class33.loginMessage3 = "";
                        class33.loginIndex = 1;
                        class33.loginIndex2 = 0;
                     } else if((Client.flags & 4) != 0) {
                        if((Client.flags & 1024) != 0) {
                           class33.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class33.loginMessage2 = "Players can attack each other almost everywhere";
                           class33.loginMessage3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class33.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class33.loginMessage2 = "Players can attack each other";
                           class33.loginMessage3 = "almost everywhere.";
                        }

                        class33.field740 = "Warning!";
                        class33.loginIndex = 1;
                        class33.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class33.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class33.loginMessage2 = "The Protect Item prayer will";
                        class33.loginMessage3 = "not work on this world.";
                        class33.field740 = "Warning!";
                        class33.loginIndex = 1;
                        class33.loginIndex2 = 0;
                     } else {
                        class33.loginMessage1 = "";
                        class33.loginMessage2 = "Enter your username/email & password.";
                        class33.loginMessage3 = "";
                        class33.loginIndex = 2;
                        class33.loginIndex2 = 0;
                     }
                  }
               } else if(class33.loginIndex != 1) {
                  short var17;
                  if(class33.loginIndex == 2) {
                     var17 = 231;
                     var16 = var17 + 30;
                     if(var1 == 1 && var3 >= var16 - 15 && var3 < var16) {
                        class33.loginIndex2 = 0;
                     }

                     var16 += 15;
                     if(var1 == 1 && var3 >= var16 - 15 && var3 < var16) {
                        class33.loginIndex2 = 1;
                     }

                     var16 += 15;
                     var17 = 361;
                     if(var1 == 1 && var3 >= var17 - 15 && var3 < var17) {
                        class59.method1273("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class33.loginIndex = 5;
                        return;
                     }

                     int var18 = 180 + class33.loginWindowX - 80;
                     short var11 = 321;
                     if(var1 == 1 && var2 >= var18 - 75 && var2 <= var18 + 75 && var3 >= var11 - 20 && var3 <= 20 + var11) {
                        class33.username = class33.username.trim();
                        if(class33.username.length() == 0) {
                           class59.method1273("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class33.field724.length() == 0) {
                           class59.method1273("", "Please enter your password.", "");
                           return;
                        }

                        class59.method1273("", "Connecting to server...", "");
                        class33.field726 = class16.field232.field140.containsKey(Integer.valueOf(SecondaryBufferProvider.method1664(class33.username)))?class162.field2638:class162.field2636;
                        KitDefinition.setGameState(20);
                        return;
                     }

                     var18 = 80 + class33.loginWindowX + 180;
                     if(var1 == 1 && var2 >= var18 - 75 && var2 <= var18 + 75 && var3 >= var11 - 20 && var3 <= var11 + 20) {
                        class33.loginIndex = 0;
                        class33.username = "";
                        class33.field724 = "";
                        class47.field1049 = 0;
                        class20.authCode = "";
                        class33.field751 = true;
                     }

                     while(true) {
                        while(class217.method4030()) {
                           boolean var12 = false;

                           for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                              if(class140.field2163 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                 var12 = true;
                                 break;
                              }
                           }

                           if(class140.field2161 == 13) {
                              class33.loginIndex = 0;
                              class33.username = "";
                              class33.field724 = "";
                              class47.field1049 = 0;
                              class20.authCode = "";
                              class33.field751 = true;
                           } else if(class33.loginIndex2 == 0) {
                              if(class140.field2161 == 85 && class33.username.length() > 0) {
                                 class33.username = class33.username.substring(0, class33.username.length() - 1);
                              }

                              if(class140.field2161 == 84 || class140.field2161 == 80) {
                                 class33.loginIndex2 = 1;
                              }

                              if(var12 && class33.username.length() < 320) {
                                 class33.username = class33.username + class140.field2163;
                              }
                           } else if(class33.loginIndex2 == 1) {
                              if(class140.field2161 == 85 && class33.field724.length() > 0) {
                                 class33.field724 = class33.field724.substring(0, class33.field724.length() - 1);
                              }

                              if(class140.field2161 == 84 || class140.field2161 == 80) {
                                 class33.loginIndex2 = 0;
                              }

                              if(class140.field2161 == 84) {
                                 class33.username = class33.username.trim();
                                 if(class33.username.length() == 0) {
                                    class59.method1273("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class33.field724.length() == 0) {
                                    class59.method1273("", "Please enter your password.", "");
                                    return;
                                 }

                                 class59.method1273("", "Connecting to server...", "");
                                 class33.field726 = class16.field232.field140.containsKey(Integer.valueOf(SecondaryBufferProvider.method1664(class33.username)))?class162.field2638:class162.field2636;
                                 KitDefinition.setGameState(20);
                                 return;
                              }

                              if(var12 && class33.field724.length() < 20) {
                                 class33.field724 = class33.field724 + class140.field2163;
                              }
                           }
                        }

                        return;
                     }
                  } else if(class33.loginIndex == 3) {
                     var16 = 180 + class33.loginWindowX;
                     var10 = 276;
                     if(var1 == 1 && var2 >= var16 - 75 && var2 <= var16 + 75 && var3 >= var10 - 20 && var3 <= var10 + 20) {
                        class33.loginMessage1 = "";
                        class33.loginMessage2 = "Enter your username/email & password.";
                        class33.loginMessage3 = "";
                        class33.loginIndex = 2;
                        class33.loginIndex2 = 0;
                     }

                     var16 = 180 + class33.loginWindowX;
                     var10 = 326;
                     if(var1 == 1 && var2 >= var16 - 75 && var2 <= var16 + 75 && var3 >= var10 - 20 && var3 <= var10 + 20) {
                        class59.method1273("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class33.loginIndex = 5;
                        return;
                     }
                  } else {
                     boolean var19;
                     int var20;
                     if(class33.loginIndex == 4) {
                        var16 = 180 + class33.loginWindowX - 80;
                        var10 = 321;
                        if(var1 == 1 && var2 >= var16 - 75 && var2 <= 75 + var16 && var3 >= var10 - 20 && var3 <= 20 + var10) {
                           class20.authCode.trim();
                           if(class20.authCode.length() != 6) {
                              class59.method1273("", "Please enter a 6-digin PIN.", "");
                              return;
                           }

                           class47.field1049 = Integer.parseInt(class20.authCode);
                           class20.authCode = "";
                           class33.field726 = class33.field751?class162.field2635:class162.field2637;
                           class59.method1273("", "Connecting to server...", "");
                           KitDefinition.setGameState(20);
                           return;
                        }

                        if(var1 == 1 && var2 >= 180 + class33.loginWindowX - 9 && var2 <= 130 + 180 + class33.loginWindowX && var3 >= 263 && var3 <= 296) {
                           class33.field751 = !class33.field751;
                        }

                        if(var1 == 1 && var2 >= 180 + class33.loginWindowX - 34 && var2 <= class33.loginWindowX + 180 + 34 && var3 >= 351 && var3 <= 363) {
                           class110.method2404(class129.method2826("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                        }

                        var16 = 80 + class33.loginWindowX + 180;
                        if(var1 == 1 && var2 >= var16 - 75 && var2 <= var16 + 75 && var3 >= var10 - 20 && var3 <= var10 + 20) {
                           class33.loginIndex = 0;
                           class33.username = "";
                           class33.field724 = "";
                           class47.field1049 = 0;
                           class20.authCode = "";
                        }

                        while(class217.method4030()) {
                           var19 = false;

                           for(var20 = 0; var20 < "1234567890".length(); ++var20) {
                              if(class140.field2163 == "1234567890".charAt(var20)) {
                                 var19 = true;
                                 break;
                              }
                           }

                           if(class140.field2161 == 13) {
                              class33.loginIndex = 0;
                              class33.username = "";
                              class33.field724 = "";
                              class47.field1049 = 0;
                              class20.authCode = "";
                           } else {
                              if(class140.field2161 == 85 && class20.authCode.length() > 0) {
                                 class20.authCode = class20.authCode.substring(0, class20.authCode.length() - 1);
                              }

                              if(class140.field2161 == 84) {
                                 class20.authCode.trim();
                                 if(class20.authCode.length() != 6) {
                                    class59.method1273("", "Please enter a 6-digin PIN.", "");
                                    return;
                                 }

                                 class47.field1049 = Integer.parseInt(class20.authCode);
                                 class20.authCode = "";
                                 class33.field726 = class33.field751?class162.field2635:class162.field2637;
                                 class59.method1273("", "Connecting to server...", "");
                                 KitDefinition.setGameState(20);
                                 return;
                              }

                              if(var19 && class20.authCode.length() < 6) {
                                 class20.authCode = class20.authCode + class140.field2163;
                              }
                           }
                        }
                     } else if(class33.loginIndex == 5) {
                        var16 = 180 + class33.loginWindowX - 80;
                        var10 = 321;
                        if(var1 == 1 && var2 >= var16 - 75 && var2 <= var16 + 75 && var3 >= var10 - 20 && var3 <= 20 + var10) {
                           class156.method3183();
                           return;
                        }

                        var16 = class33.loginWindowX + 180 + 80;
                        if(var1 == 1 && var2 >= var16 - 75 && var2 <= var16 + 75 && var3 >= var10 - 20 && var3 <= var10 + 20) {
                           class33.loginMessage1 = "";
                           class33.loginMessage2 = "Enter your username/email & password.";
                           class33.loginMessage3 = "";
                           class33.loginIndex = 2;
                           class33.loginIndex2 = 0;
                           class33.field724 = "";
                        }

                        while(class217.method4030()) {
                           var19 = false;

                           for(var20 = 0; var20 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var20) {
                              if(class140.field2163 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var20)) {
                                 var19 = true;
                                 break;
                              }
                           }

                           if(class140.field2161 == 13) {
                              class33.loginMessage1 = "";
                              class33.loginMessage2 = "Enter your username/email & password.";
                              class33.loginMessage3 = "";
                              class33.loginIndex = 2;
                              class33.loginIndex2 = 0;
                              class33.field724 = "";
                           } else {
                              if(class140.field2161 == 85 && class33.username.length() > 0) {
                                 class33.username = class33.username.substring(0, class33.username.length() - 1);
                              }

                              if(class140.field2161 == 84) {
                                 class156.method3183();
                                 return;
                              }

                              if(var19 && class33.username.length() < 320) {
                                 class33.username = class33.username + class140.field2163;
                              }
                           }
                        }
                     } else if(class33.loginIndex == 6) {
                        while(true) {
                           do {
                              if(!class217.method4030()) {
                                 var17 = 321;
                                 if(var1 == 1 && var3 >= var17 - 20 && var3 <= 20 + var17) {
                                    class33.loginMessage1 = "";
                                    class33.loginMessage2 = "Enter your username/email & password.";
                                    class33.loginMessage3 = "";
                                    class33.loginIndex = 2;
                                    class33.loginIndex2 = 0;
                                    class33.field724 = "";
                                 }

                                 return;
                              }
                           } while(class140.field2161 != 84 && class140.field2161 != 13);

                           class33.loginMessage1 = "";
                           class33.loginMessage2 = "Enter your username/email & password.";
                           class33.loginMessage3 = "";
                           class33.loginIndex = 2;
                           class33.loginIndex2 = 0;
                           class33.field724 = "";
                        }
                     }
                  }
               } else {
                  while(class217.method4030()) {
                     if(class140.field2161 == 84) {
                        class33.loginMessage1 = "";
                        class33.loginMessage2 = "Enter your username/email & password.";
                        class33.loginMessage3 = "";
                        class33.loginIndex = 2;
                        class33.loginIndex2 = 0;
                     } else if(class140.field2161 == 13) {
                        class33.loginIndex = 0;
                     }
                  }

                  var16 = 180 + class33.loginWindowX - 80;
                  var10 = 321;
                  if(var1 == 1 && var2 >= var16 - 75 && var2 <= var16 + 75 && var3 >= var10 - 20 && var3 <= var10 + 20) {
                     class33.loginMessage1 = "";
                     class33.loginMessage2 = "Enter your username/email & password.";
                     class33.loginMessage3 = "";
                     class33.loginIndex = 2;
                     class33.loginIndex2 = 0;
                  }

                  var16 = 80 + class33.loginWindowX + 180;
                  if(var1 == 1 && var2 >= var16 - 75 && var2 <= 75 + var16 && var3 >= var10 - 20 && var3 <= 20 + var10) {
                     class33.loginIndex = 0;
                  }
               }

            }
         }
      }
   }

   public class116(byte[] var1) {
      int var2 = var1.length;
      this.field2017 = new int[var2];
      this.field2018 = var1;
      int[] var3 = new int[33];
      this.field2021 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field2017[var5] = var8;
            int var9;
            int var10;
            int var11;
            int var12;
            if((var8 & var7) != 0) {
               var9 = var3[var6 - 1];
            } else {
               var9 = var8 | var7;

               for(var10 = var6 - 1; var10 >= 1; --var10) {
                  var11 = var3[var10];
                  if(var11 != var8) {
                     break;
                  }

                  var12 = 1 << 32 - var10;
                  if((var11 & var12) != 0) {
                     var3[var10] = var3[var10 - 1];
                     break;
                  }

                  var3[var10] = var11 | var12;
               }
            }

            var3[var6] = var9;

            for(var10 = 1 + var6; var10 <= 32; ++var10) {
               if(var8 == var3[var10]) {
                  var3[var10] = var9;
               }
            }

            var10 = 0;

            for(var11 = 0; var11 < var6; ++var11) {
               var12 = Integer.MIN_VALUE >>> var11;
               if((var8 & var12) != 0) {
                  if(this.field2021[var10] == 0) {
                     this.field2021[var10] = var4;
                  }

                  var10 = this.field2021[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.field2021.length) {
                  int[] var13 = new int[2 * this.field2021.length];

                  for(int var14 = 0; var14 < this.field2021.length; ++var14) {
                     var13[var14] = this.field2021[var14];
                  }

                  this.field2021 = var13;
               }

               var12 >>>= 1;
            }

            this.field2021[var10] = ~var5;
            if(var10 >= var4) {
               var4 = 1 + var10;
            }
         }
      }

   }
}
