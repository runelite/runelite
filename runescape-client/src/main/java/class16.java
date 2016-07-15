import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public final class class16 extends class211 {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1295877937
   )
   int field230 = -1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1174004905
   )
   int field231;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1834087893
   )
   int field232;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1818241595
   )
   int field233;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -996578775
   )
   int field234;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -632985711
   )
   int field235;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1741676195
   )
   int field236;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -586811259
   )
   int field237;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 572582507
   )
   int field238;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 559993437
   )
   int field239 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1175410273
   )
   int field240;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -286442967
   )
   int field242;
   @ObfuscatedName("d")
   static int[] field243;
   @ObfuscatedName("qm")
   @ObfuscatedGetter(
      intValue = -1425635515
   )
   protected static int field246;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass147;I)V",
      garbageValue = "500362644"
   )
   static void method164(class147 var0) {
      int var1;
      int var2;
      int var3;
      int var14;
      if(class33.field757) {
         if(class143.field2208 == 1 || !client.field469 && class143.field2208 == 4) {
            var1 = class33.field758 + 280;
            if(class143.field2207 >= var1 && class143.field2207 <= 14 + var1 && class143.field2213 >= 4 && class143.field2213 <= 18) {
               class117.method2532(0, 0);
            } else if(class143.field2207 >= 15 + var1 && class143.field2207 <= 80 + var1 && class143.field2213 >= 4 && class143.field2213 <= 18) {
               class117.method2532(0, 1);
            } else {
               var2 = class33.field758 + 390;
               if(class143.field2207 >= var2 && class143.field2207 <= 14 + var2 && class143.field2213 >= 4 && class143.field2213 <= 18) {
                  class117.method2532(1, 0);
               } else if(class143.field2207 >= var2 + 15 && class143.field2207 <= 80 + var2 && class143.field2213 >= 4 && class143.field2213 <= 18) {
                  class117.method2532(1, 1);
               } else {
                  var3 = class33.field758 + 500;
                  if(class143.field2207 >= var3 && class143.field2207 <= 14 + var3 && class143.field2213 >= 4 && class143.field2213 <= 18) {
                     class117.method2532(2, 0);
                  } else if(class143.field2207 >= var3 + 15 && class143.field2207 <= 80 + var3 && class143.field2213 >= 4 && class143.field2213 <= 18) {
                     class117.method2532(2, 1);
                  } else {
                     var14 = 610 + class33.field758;
                     if(class143.field2207 >= var14 && class143.field2207 <= 14 + var14 && class143.field2213 >= 4 && class143.field2213 <= 18) {
                        class117.method2532(3, 0);
                     } else if(class143.field2207 >= var14 + 15 && class143.field2207 <= 80 + var14 && class143.field2213 >= 4 && class143.field2213 <= 18) {
                        class117.method2532(3, 1);
                     } else if(class143.field2207 >= class33.field758 + 708 && class143.field2213 >= 4 && class143.field2207 <= 708 + class33.field758 + 50 && class143.field2213 <= 20) {
                        class33.field757 = false;
                        class33.field761.method1800(class33.field758, 0);
                        class8.field151.method1800(class33.field758 + 382, 0);
                        class33.field762.method1952(class33.field758 + 382 - class33.field762.field1486 / 2, 18);
                     } else if(class33.field792 != -1) {
                        class27 var9 = class118.field2032[class33.field792];
                        class151.method3219(var9);
                        class33.field757 = false;
                        class33.field761.method1800(class33.field758, 0);
                        class8.field151.method1800(382 + class33.field758, 0);
                        class33.field762.method1952(class33.field758 + 382 - class33.field762.field1486 / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((class143.field2208 == 1 || !client.field469 && class143.field2208 == 4) && class143.field2207 >= 765 + class33.field758 - 50 && class143.field2213 >= 453) {
            client.field571.field144 = !client.field571.field144;
            class49.method1062();
            if(!client.field571.field144) {
               class171 var10 = class109.field1948;
               var2 = var10.method3342("scape main");
               var3 = var10.method3357(var2, "");
               class127.method2904(var10, var2, var3, 255, false);
            } else {
               class90.method2176();
            }
         }

         if(client.field301 != 5) {
            ++class33.field774;
            if(client.field301 == 10 || client.field301 == 11) {
               if(client.field299 == 0) {
                  if(class143.field2208 == 1 || !client.field469 && class143.field2208 == 4) {
                     var1 = class33.field758 + 5;
                     short var12 = 463;
                     byte var13 = 100;
                     byte var4 = 35;
                     if(class143.field2207 >= var1 && class143.field2207 <= var1 + var13 && class143.field2213 >= var12 && class143.field2213 <= var4 + var12) {
                        class20.method539();
                        return;
                     }
                  }

                  if(null != class27.field672) {
                     class20.method539();
                  }
               }

               var1 = class143.field2208;
               var2 = class143.field2207;
               var3 = class143.field2213;
               if(!client.field469 && var1 == 4) {
                  var1 = 1;
               }

               short var5;
               String var11;
               if(class33.field778 == 0) {
                  var14 = 180 + class33.field765 - 80;
                  var5 = 291;
                  if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                     var11 = class49.method1060("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws";
                     class124.method2853(var11, true, "openjs", false);
                  }

                  var14 = class33.field765 + 180 + 80;
                  if(var1 == 1 && var2 >= var14 - 75 && var2 <= 75 + var14 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                     if((client.field292 & 33554432) != 0) {
                        class33.field779 = "";
                        class33.field772 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class33.field781 = "Your normal account will not be affected.";
                        class33.field791 = "";
                        class33.field778 = 1;
                        class33.field788 = 0;
                     } else if((client.field292 & 4) != 0) {
                        if((client.field292 & 1024) != 0) {
                           class33.field772 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class33.field781 = "Players can attack each other almost everywhere";
                           class33.field791 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class33.field772 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class33.field781 = "Players can attack each other";
                           class33.field791 = "almost everywhere.";
                        }

                        class33.field779 = "Warning!";
                        class33.field778 = 1;
                        class33.field788 = 0;
                     } else if((client.field292 & 1024) != 0) {
                        class33.field772 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class33.field781 = "The Protect Item prayer will";
                        class33.field791 = "not work on this world.";
                        class33.field779 = "Warning!";
                        class33.field778 = 1;
                        class33.field788 = 0;
                     } else {
                        class33.field772 = "";
                        class33.field781 = "Enter your username/email & password.";
                        class33.field791 = "";
                        class33.field778 = 2;
                        class33.field788 = 0;
                     }
                  }
               } else if(class33.field778 != 1) {
                  short var15;
                  if(class33.field778 == 2) {
                     var15 = 231;
                     var14 = var15 + 30;
                     if(var1 == 1 && var3 >= var14 - 15 && var3 < var14) {
                        class33.field788 = 0;
                     }

                     var14 += 15;
                     if(var1 == 1 && var3 >= var14 - 15 && var3 < var14) {
                        class33.field788 = 1;
                     }

                     var14 += 15;
                     var15 = 361;
                     if(var1 == 1 && var3 >= var15 - 15 && var3 < var15) {
                        class117.method2529("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class33.field778 = 5;
                        return;
                     }

                     int var16 = class33.field765 + 180 - 80;
                     short var6 = 321;
                     if(var1 == 1 && var2 >= var16 - 75 && var2 <= var16 + 75 && var3 >= var6 - 20 && var3 <= 20 + var6) {
                        class33.field784 = class33.field784.trim();
                        if(class33.field784.length() == 0) {
                           class117.method2529("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class33.field780.length() == 0) {
                           class117.method2529("", "Please enter your password.", "");
                           return;
                        }

                        class117.method2529("", "Connecting to server...", "");
                        class33.field770 = client.field571.field147.containsKey(Integer.valueOf(class22.method569(class33.field784)))?class162.field2646:class162.field2649;
                        class92.method2179(20);
                        return;
                     }

                     var16 = 80 + class33.field765 + 180;
                     if(var1 == 1 && var2 >= var16 - 75 && var2 <= var16 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20) {
                        class33.field778 = 0;
                        class33.field784 = "";
                        class33.field780 = "";
                        class180.field2948 = 0;
                        class33.field786 = "";
                        class33.field787 = true;
                     }

                     while(true) {
                        while(class122.method2812()) {
                           boolean var7 = false;

                           for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                              if(class107.field1868 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                 var7 = true;
                                 break;
                              }
                           }

                           if(class53.field1162 == 13) {
                              class33.field778 = 0;
                              class33.field784 = "";
                              class33.field780 = "";
                              class180.field2948 = 0;
                              class33.field786 = "";
                              class33.field787 = true;
                           } else if(class33.field788 == 0) {
                              if(class53.field1162 == 85 && class33.field784.length() > 0) {
                                 class33.field784 = class33.field784.substring(0, class33.field784.length() - 1);
                              }

                              if(class53.field1162 == 84 || class53.field1162 == 80) {
                                 class33.field788 = 1;
                              }

                              if(var7 && class33.field784.length() < 320) {
                                 class33.field784 = class33.field784 + class107.field1868;
                              }
                           } else if(class33.field788 == 1) {
                              if(class53.field1162 == 85 && class33.field780.length() > 0) {
                                 class33.field780 = class33.field780.substring(0, class33.field780.length() - 1);
                              }

                              if(class53.field1162 == 84 || class53.field1162 == 80) {
                                 class33.field788 = 0;
                              }

                              if(class53.field1162 == 84) {
                                 class33.field784 = class33.field784.trim();
                                 if(class33.field784.length() == 0) {
                                    class117.method2529("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class33.field780.length() == 0) {
                                    class117.method2529("", "Please enter your password.", "");
                                    return;
                                 }

                                 class117.method2529("", "Connecting to server...", "");
                                 class33.field770 = client.field571.field147.containsKey(Integer.valueOf(class22.method569(class33.field784)))?class162.field2646:class162.field2649;
                                 class92.method2179(20);
                                 return;
                              }

                              if(var7 && class33.field780.length() < 20) {
                                 class33.field780 = class33.field780 + class107.field1868;
                              }
                           }
                        }

                        return;
                     }
                  } else if(class33.field778 == 3) {
                     var14 = class33.field765 + 180;
                     var5 = 276;
                     if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                        class33.field772 = "";
                        class33.field781 = "Enter your username/email & password.";
                        class33.field791 = "";
                        class33.field778 = 2;
                        class33.field788 = 0;
                     }

                     var14 = 180 + class33.field765;
                     var5 = 326;
                     if(var1 == 1 && var2 >= var14 - 75 && var2 <= 75 + var14 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                        class117.method2529("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class33.field778 = 5;
                        return;
                     }
                  } else {
                     boolean var17;
                     int var18;
                     if(class33.field778 == 4) {
                        var14 = 180 + class33.field765 - 80;
                        var5 = 321;
                        if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                           class33.field786.trim();
                           if(class33.field786.length() != 6) {
                              class117.method2529("", "Please enter a 6-digin PIN.", "");
                              return;
                           }

                           class180.field2948 = Integer.parseInt(class33.field786);
                           class33.field786 = "";
                           class33.field770 = class33.field787?class162.field2645:class162.field2647;
                           class117.method2529("", "Connecting to server...", "");
                           class92.method2179(20);
                           return;
                        }

                        if(var1 == 1 && var2 >= 180 + class33.field765 - 9 && var2 <= 130 + 180 + class33.field765 && var3 >= 263 && var3 <= 296) {
                           class33.field787 = !class33.field787;
                        }

                        if(var1 == 1 && var2 >= 180 + class33.field765 - 34 && var2 <= 34 + 180 + class33.field765 && var3 >= 351 && var3 <= 363) {
                           var11 = class49.method1060("secure", true) + "m=totp-authenticator/disableTOTPRequest";
                           class124.method2853(var11, true, "openjs", false);
                        }

                        var14 = 80 + class33.field765 + 180;
                        if(var1 == 1 && var2 >= var14 - 75 && var2 <= 75 + var14 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                           class33.field778 = 0;
                           class33.field784 = "";
                           class33.field780 = "";
                           class180.field2948 = 0;
                           class33.field786 = "";
                        }

                        while(class122.method2812()) {
                           var17 = false;

                           for(var18 = 0; var18 < "1234567890".length(); ++var18) {
                              if(class107.field1868 == "1234567890".charAt(var18)) {
                                 var17 = true;
                                 break;
                              }
                           }

                           if(class53.field1162 == 13) {
                              class33.field778 = 0;
                              class33.field784 = "";
                              class33.field780 = "";
                              class180.field2948 = 0;
                              class33.field786 = "";
                           } else {
                              if(class53.field1162 == 85 && class33.field786.length() > 0) {
                                 class33.field786 = class33.field786.substring(0, class33.field786.length() - 1);
                              }

                              if(class53.field1162 == 84) {
                                 class33.field786.trim();
                                 if(class33.field786.length() != 6) {
                                    class117.method2529("", "Please enter a 6-digin PIN.", "");
                                    return;
                                 }

                                 class180.field2948 = Integer.parseInt(class33.field786);
                                 class33.field786 = "";
                                 class33.field770 = class33.field787?class162.field2645:class162.field2647;
                                 class117.method2529("", "Connecting to server...", "");
                                 class92.method2179(20);
                                 return;
                              }

                              if(var17 && class33.field786.length() < 6) {
                                 class33.field786 = class33.field786 + class107.field1868;
                              }
                           }
                        }
                     } else if(class33.field778 == 5) {
                        var14 = class33.field765 + 180 - 80;
                        var5 = 321;
                        if(var1 == 1 && var2 >= var14 - 75 && var2 <= 75 + var14 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                           class122.method2668();
                           return;
                        }

                        var14 = class33.field765 + 180 + 80;
                        if(var1 == 1 && var2 >= var14 - 75 && var2 <= 75 + var14 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                           class33.field772 = "";
                           class33.field781 = "Enter your username/email & password.";
                           class33.field791 = "";
                           class33.field778 = 2;
                           class33.field788 = 0;
                           class33.field780 = "";
                        }

                        while(class122.method2812()) {
                           var17 = false;

                           for(var18 = 0; var18 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var18) {
                              if(class107.field1868 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var18)) {
                                 var17 = true;
                                 break;
                              }
                           }

                           if(class53.field1162 == 13) {
                              class33.field772 = "";
                              class33.field781 = "Enter your username/email & password.";
                              class33.field791 = "";
                              class33.field778 = 2;
                              class33.field788 = 0;
                              class33.field780 = "";
                           } else {
                              if(class53.field1162 == 85 && class33.field784.length() > 0) {
                                 class33.field784 = class33.field784.substring(0, class33.field784.length() - 1);
                              }

                              if(class53.field1162 == 84) {
                                 class122.method2668();
                                 return;
                              }

                              if(var17 && class33.field784.length() < 320) {
                                 class33.field784 = class33.field784 + class107.field1868;
                              }
                           }
                        }
                     } else if(class33.field778 == 6) {
                        while(true) {
                           do {
                              if(!class122.method2812()) {
                                 var15 = 321;
                                 if(var1 == 1 && var3 >= var15 - 20 && var3 <= var15 + 20) {
                                    class33.field772 = "";
                                    class33.field781 = "Enter your username/email & password.";
                                    class33.field791 = "";
                                    class33.field778 = 2;
                                    class33.field788 = 0;
                                    class33.field780 = "";
                                 }

                                 return;
                              }
                           } while(class53.field1162 != 84 && class53.field1162 != 13);

                           class33.field772 = "";
                           class33.field781 = "Enter your username/email & password.";
                           class33.field791 = "";
                           class33.field778 = 2;
                           class33.field788 = 0;
                           class33.field780 = "";
                        }
                     }
                  }
               } else {
                  while(class122.method2812()) {
                     if(class53.field1162 == 84) {
                        class33.field772 = "";
                        class33.field781 = "Enter your username/email & password.";
                        class33.field791 = "";
                        class33.field778 = 2;
                        class33.field788 = 0;
                     } else if(class53.field1162 == 13) {
                        class33.field778 = 0;
                     }
                  }

                  var14 = class33.field765 + 180 - 80;
                  var5 = 321;
                  if(var1 == 1 && var2 >= var14 - 75 && var2 <= 75 + var14 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                     class33.field772 = "";
                     class33.field781 = "Enter your username/email & password.";
                     class33.field791 = "";
                     class33.field778 = 2;
                     class33.field788 = 0;
                  }

                  var14 = 180 + class33.field765 + 80;
                  if(var1 == 1 && var2 >= var14 - 75 && var2 <= 75 + var14 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                     class33.field778 = 0;
                  }
               }

            }
         }
      }
   }
}
