import java.awt.Component;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public abstract class class130 {
   @ObfuscatedName("f")
   public abstract void vmethod3114(Component var1);

   @ObfuscatedName("s")
   public abstract int vmethod3111();

   @ObfuscatedName("r")
   public abstract void vmethod3115(Component var1);

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass143;B)V",
      garbageValue = "-100"
   )
   static void method2849() {
      if(class31.field741) {
         class140.method2990();
      } else {
         int var1;
         int var2;
         if((class139.field2145 == 1 || !class214.field3149 && 4 == class139.field2145) && class139.field2146 >= class31.field716 + 765 - 50 && class139.field2147 >= 453) {
            class89.field1548.field132 = !class89.field1548.field132;
            class108.method2430();
            if(!class89.field1548.field132) {
               class167 var0 = class129.field2054;
               var1 = var0.method3278("scape main");
               var2 = var0.method3328(var1, "");
               class86.method2097(var0, var1, var2, 255, false);
            } else {
               class182.field2942.method3628();
               class182.field2947 = 1;
               class182.field2946 = null;
            }
         }

         if(5 != client.field552) {
            ++class31.field748;
            if(10 == client.field552 || 11 == client.field552) {
               int var8;
               if(client.field298 == 0) {
                  if(1 == class139.field2145 || !class214.field3149 && class139.field2145 == 4) {
                     var8 = class31.field716 + 5;
                     short var9 = 463;
                     byte var10 = 100;
                     byte var3 = 35;
                     if(class139.field2146 >= var8 && class139.field2146 <= var10 + var8 && class139.field2147 >= var9 && class139.field2147 <= var3 + var9) {
                        if(class5.method99()) {
                           class31.field741 = true;
                        }

                        return;
                     }
                  }

                  if(null != class107.field1879 && class5.method99()) {
                     class31.field741 = true;
                  }
               }

               var8 = class139.field2145;
               var1 = class139.field2146;
               var2 = class139.field2147;
               if(!class214.field3149 && 4 == var8) {
                  var8 = 1;
               }

               short var4;
               int var11;
               if(0 == class31.field733) {
                  var11 = 180 + class31.field721 - 80;
                  var4 = 291;
                  if(1 == var8 && var1 >= var11 - 75 && var1 <= var11 + 75 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                     class32.method710(class93.method2183("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true);
                  }

                  var11 = class31.field721 + 180 + 80;
                  if(1 == var8 && var1 >= var11 - 75 && var1 <= 75 + var11 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                     if((client.field506 & 33554432) != 0) {
                        class31.field734 = "";
                        class31.field735 = "This is a <col=00ffff>Tournament<col=ffffff> world.";
                        class31.field736 = "Max stats and high level gear are provided.";
                        class31.field737 = "Your normal account will not be affected.";
                        class31.field733 = 1;
                        class31.field738 = 0;
                     } else if(0 != (client.field506 & 4)) {
                        if(0 != (client.field506 & 1024)) {
                           class31.field735 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class31.field736 = "Players can attack each other almost everywhere";
                           class31.field737 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class31.field735 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class31.field736 = "Players can attack each other";
                           class31.field737 = "almost everywhere.";
                        }

                        class31.field734 = "Warning!";
                        class31.field733 = 1;
                        class31.field738 = 0;
                     } else if(0 != (client.field506 & 1024)) {
                        class31.field735 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class31.field736 = "The Protect Item prayer will";
                        class31.field737 = "not work on this world.";
                        class31.field734 = "Warning!";
                        class31.field733 = 1;
                        class31.field738 = 0;
                     } else {
                        class31.field735 = "";
                        class31.field736 = "Enter your username/email & password.";
                        class31.field737 = "";
                        class31.field733 = 2;
                        class31.field738 = 0;
                     }
                  }
               } else if(class31.field733 != 1) {
                  short var12;
                  if(class31.field733 == 2) {
                     var12 = 231;
                     var11 = var12 + 30;
                     if(var8 == 1 && var2 >= var11 - 15 && var2 < var11) {
                        class31.field738 = 0;
                     }

                     var11 += 15;
                     if(var8 == 1 && var2 >= var11 - 15 && var2 < var11) {
                        class31.field738 = 1;
                     }

                     var11 += 15;
                     var12 = 361;
                     if(1 == var8 && var2 >= var12 - 15 && var2 < var12) {
                        class4.method56("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class31.field733 = 5;
                        return;
                     }

                     int var13 = class31.field721 + 180 - 80;
                     short var5 = 321;
                     if(var8 == 1 && var1 >= var13 - 75 && var1 <= var13 + 75 && var2 >= var5 - 20 && var2 <= var5 + 20) {
                        class31.field742 = class31.field742.trim();
                        if(class31.field742.length() == 0) {
                           class4.method56("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class31.field726.length() == 0) {
                           class4.method56("", "Please enter your password.", "");
                           return;
                        }

                        class4.method56("", "Connecting to server...", "");
                        class31.field715 = class89.field1548.field134.containsKey(Integer.valueOf(class128.method2830(class31.field742)))?class158.field2585:class158.field2584;
                        class1.method9(20);
                        return;
                     }

                     var13 = class31.field721 + 180 + 80;
                     if(var8 == 1 && var1 >= var13 - 75 && var1 <= var13 + 75 && var2 >= var5 - 20 && var2 <= 20 + var5) {
                        class31.field733 = 0;
                        class31.field742 = "";
                        class31.field726 = "";
                        class177.field2899 = 0;
                        class27.field669 = "";
                        class31.field731 = true;
                     }

                     while(true) {
                        while(class33.method715()) {
                           boolean var6 = false;

                           for(int var7 = 0; var7 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var7) {
                              if(class110.field1948 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var7)) {
                                 var6 = true;
                                 break;
                              }
                           }

                           if(13 == class13.field201) {
                              class31.field733 = 0;
                              class31.field742 = "";
                              class31.field726 = "";
                              class177.field2899 = 0;
                              class27.field669 = "";
                              class31.field731 = true;
                           } else if(0 == class31.field738) {
                              if(85 == class13.field201 && class31.field742.length() > 0) {
                                 class31.field742 = class31.field742.substring(0, class31.field742.length() - 1);
                              }

                              if(84 == class13.field201 || class13.field201 == 80) {
                                 class31.field738 = 1;
                              }

                              if(var6 && class31.field742.length() < 320) {
                                 class31.field742 = class31.field742 + class110.field1948;
                              }
                           } else if(1 == class31.field738) {
                              if(85 == class13.field201 && class31.field726.length() > 0) {
                                 class31.field726 = class31.field726.substring(0, class31.field726.length() - 1);
                              }

                              if(class13.field201 == 84 || 80 == class13.field201) {
                                 class31.field738 = 0;
                              }

                              if(84 == class13.field201) {
                                 class31.field742 = class31.field742.trim();
                                 if(class31.field742.length() == 0) {
                                    class4.method56("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class31.field726.length() == 0) {
                                    class4.method56("", "Please enter your password.", "");
                                    return;
                                 }

                                 class4.method56("", "Connecting to server...", "");
                                 class31.field715 = class89.field1548.field134.containsKey(Integer.valueOf(class128.method2830(class31.field742)))?class158.field2585:class158.field2584;
                                 class1.method9(20);
                                 return;
                              }

                              if(var6 && class31.field726.length() < 20) {
                                 class31.field726 = class31.field726 + class110.field1948;
                              }
                           }
                        }

                        return;
                     }
                  } else if(3 == class31.field733) {
                     var11 = 180 + class31.field721;
                     var4 = 276;
                     if(1 == var8 && var1 >= var11 - 75 && var1 <= 75 + var11 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                        class31.field735 = "";
                        class31.field736 = "Enter your username/email & password.";
                        class31.field737 = "";
                        class31.field733 = 2;
                        class31.field738 = 0;
                     }

                     var11 = class31.field721 + 180;
                     var4 = 326;
                     if(var8 == 1 && var1 >= var11 - 75 && var1 <= 75 + var11 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                        class4.method56("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class31.field733 = 5;
                        return;
                     }
                  } else {
                     boolean var14;
                     int var15;
                     if(class31.field733 == 4) {
                        var11 = 180 + class31.field721 - 80;
                        var4 = 321;
                        if(var8 == 1 && var1 >= var11 - 75 && var1 <= var11 + 75 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                           class27.field669.trim();
                           if(class27.field669.length() != 6) {
                              class4.method56("", "Please enter a 6-digin PIN.", "");
                              return;
                           }

                           class177.field2899 = Integer.parseInt(class27.field669);
                           class27.field669 = "";
                           class31.field715 = class31.field731?class158.field2583:class158.field2586;
                           class4.method56("", "Connecting to server...", "");
                           class1.method9(20);
                           return;
                        }

                        if(var8 == 1 && var1 >= 180 + class31.field721 - 9 && var1 <= 130 + class31.field721 + 180 && var2 >= 263 && var2 <= 296) {
                           class31.field731 = !class31.field731;
                        }

                        if(var8 == 1 && var1 >= 180 + class31.field721 - 34 && var1 <= 34 + 180 + class31.field721 && var2 >= 351 && var2 <= 363) {
                           class32.method710(class93.method2183("secure", true) + "m=totp-authenticator/disableTOTPRequest", true);
                        }

                        var11 = 180 + class31.field721 + 80;
                        if(var8 == 1 && var1 >= var11 - 75 && var1 <= var11 + 75 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                           class31.field733 = 0;
                           class31.field742 = "";
                           class31.field726 = "";
                           class177.field2899 = 0;
                           class27.field669 = "";
                        }

                        while(class33.method715()) {
                           var14 = false;

                           for(var15 = 0; var15 < "1234567890".length(); ++var15) {
                              if(class110.field1948 == "1234567890".charAt(var15)) {
                                 var14 = true;
                                 break;
                              }
                           }

                           if(class13.field201 == 13) {
                              class31.field733 = 0;
                              class31.field742 = "";
                              class31.field726 = "";
                              class177.field2899 = 0;
                              class27.field669 = "";
                           } else {
                              if(85 == class13.field201 && class27.field669.length() > 0) {
                                 class27.field669 = class27.field669.substring(0, class27.field669.length() - 1);
                              }

                              if(class13.field201 == 84) {
                                 class27.field669.trim();
                                 if(class27.field669.length() != 6) {
                                    class4.method56("", "Please enter a 6-digin PIN.", "");
                                    return;
                                 }

                                 class177.field2899 = Integer.parseInt(class27.field669);
                                 class27.field669 = "";
                                 class31.field715 = class31.field731?class158.field2583:class158.field2586;
                                 class4.method56("", "Connecting to server...", "");
                                 class1.method9(20);
                                 return;
                              }

                              if(var14 && class27.field669.length() < 6) {
                                 class27.field669 = class27.field669 + class110.field1948;
                              }
                           }
                        }
                     } else if(class31.field733 == 5) {
                        var11 = class31.field721 + 180 - 80;
                        var4 = 321;
                        if(var8 == 1 && var1 >= var11 - 75 && var1 <= var11 + 75 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                           class46.method985();
                           return;
                        }

                        var11 = 80 + class31.field721 + 180;
                        if(1 == var8 && var1 >= var11 - 75 && var1 <= 75 + var11 && var2 >= var4 - 20 && var2 <= 20 + var4) {
                           class31.field735 = "";
                           class31.field736 = "Enter your username/email & password.";
                           class31.field737 = "";
                           class31.field733 = 2;
                           class31.field738 = 0;
                           class31.field726 = "";
                        }

                        while(class33.method715()) {
                           var14 = false;

                           for(var15 = 0; var15 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var15) {
                              if(class110.field1948 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var15)) {
                                 var14 = true;
                                 break;
                              }
                           }

                           if(13 == class13.field201) {
                              class31.field735 = "";
                              class31.field736 = "Enter your username/email & password.";
                              class31.field737 = "";
                              class31.field733 = 2;
                              class31.field738 = 0;
                              class31.field726 = "";
                           } else {
                              if(85 == class13.field201 && class31.field742.length() > 0) {
                                 class31.field742 = class31.field742.substring(0, class31.field742.length() - 1);
                              }

                              if(84 == class13.field201) {
                                 class46.method985();
                                 return;
                              }

                              if(var14 && class31.field742.length() < 320) {
                                 class31.field742 = class31.field742 + class110.field1948;
                              }
                           }
                        }
                     } else if(6 == class31.field733) {
                        while(true) {
                           do {
                              if(!class33.method715()) {
                                 var12 = 321;
                                 if(var8 == 1 && var2 >= var12 - 20 && var2 <= var12 + 20) {
                                    class31.field735 = "";
                                    class31.field736 = "Enter your username/email & password.";
                                    class31.field737 = "";
                                    class31.field733 = 2;
                                    class31.field738 = 0;
                                    class31.field726 = "";
                                 }

                                 return;
                              }
                           } while(84 != class13.field201 && class13.field201 != 13);

                           class31.field735 = "";
                           class31.field736 = "Enter your username/email & password.";
                           class31.field737 = "";
                           class31.field733 = 2;
                           class31.field738 = 0;
                           class31.field726 = "";
                        }
                     }
                  }
               } else {
                  while(class33.method715()) {
                     if(class13.field201 == 84) {
                        class31.field735 = "";
                        class31.field736 = "Enter your username/email & password.";
                        class31.field737 = "";
                        class31.field733 = 2;
                        class31.field738 = 0;
                     } else if(class13.field201 == 13) {
                        class31.field733 = 0;
                     }
                  }

                  var11 = class31.field721 + 180 - 80;
                  var4 = 321;
                  if(var8 == 1 && var1 >= var11 - 75 && var1 <= 75 + var11 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                     class31.field735 = "";
                     class31.field736 = "Enter your username/email & password.";
                     class31.field737 = "";
                     class31.field733 = 2;
                     class31.field738 = 0;
                  }

                  var11 = class31.field721 + 180 + 80;
                  if(1 == var8 && var1 >= var11 - 75 && var1 <= var11 + 75 && var2 >= var4 - 20 && var2 <= 20 + var4) {
                     class31.field733 = 0;
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("g")
   static void method2851() {
      class32.field774 = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class32.field757[var0] = null;
         class32.field756[var0] = 1;
      }

   }
}
