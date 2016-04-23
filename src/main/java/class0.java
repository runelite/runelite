import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class0 extends class208 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -303398201
   )
   int field0;
   @ObfuscatedName("h")
   boolean field1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 566433885
   )
   int field3;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -76654631
   )
   int field4;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -651785421
   )
   int field5;
   @ObfuscatedName("i")
   class173 field6;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2132539195
   )
   int field7;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1809528787
   )
   int field8;
   @ObfuscatedName("l")
   String field10;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = 165183685
   )
   @Export("baseY")
   static int field12;
   @ObfuscatedName("ak")
   static class168 field13;
   @ObfuscatedName("io")
   static class173 field14;
   @ObfuscatedName("j")
   Object[] field16;
   @ObfuscatedName("m")
   class173 field18;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-38"
   )
   public static boolean method0(int var0) {
      return (var0 >> 28 & 1) != 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass144;I)V",
      garbageValue = "-1014262198"
   )
   static void method1(class144 var0) {
      if(class31.field726) {
         class75.method1631(var0);
      } else {
         int var2;
         int var3;
         if((1 == class140.field2134 || !class139.field2116 && 4 == class140.field2134) && class140.field2135 >= 765 + class31.field696 - 50 && class140.field2136 >= 453) {
            class4.field75.field143 = !class4.field75.field143;
            class45.method946();
            if(!class4.field75.field143) {
               class168 var1 = class135.field2069;
               var2 = var1.method3232("scape main");
               var3 = var1.method3233(var2, "");
               class126.method2783(var1, var2, var3, 255, false);
            } else {
               class168.method3332();
            }
         }

         if(client.field283 != 5) {
            ++class31.field708;
            if(client.field283 == 10 || 11 == client.field283) {
               int var9;
               if(0 == client.field292) {
                  if(class140.field2134 == 1 || !class139.field2116 && 4 == class140.field2134) {
                     var9 = 5 + class31.field696;
                     short var10 = 463;
                     byte var11 = 100;
                     byte var4 = 35;
                     if(class140.field2135 >= var9 && class140.field2135 <= var9 + var11 && class140.field2136 >= var10 && class140.field2136 <= var10 + var4) {
                        if(class76.method1671()) {
                           class31.field726 = true;
                        }

                        return;
                     }
                  }

                  if(class17.field245 != null && class76.method1671()) {
                     class31.field726 = true;
                  }
               }

               var9 = class140.field2134;
               var2 = class140.field2135;
               var3 = class140.field2136;
               if(!class139.field2116 && 4 == var9) {
                  var9 = 1;
               }

               short var5;
               int var12;
               if(class31.field712 == 0) {
                  var12 = class31.field702 + 180 - 80;
                  var5 = 291;
                  if(1 == var9 && var2 >= var12 - 75 && var2 <= var12 + 75 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                     class46.method970(class59.method1248("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var12 = 80 + class31.field702 + 180;
                  if(1 == var9 && var2 >= var12 - 75 && var2 <= var12 + 75 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                     if(0 != (client.field492 & 33554432)) {
                        class31.field719 = "";
                        class31.field714 = "This is a <col=00ffff>Tournament<col=ffffff> world.";
                        class31.field729 = "Max stats and high level gear are provided.";
                        class31.field716 = "Your normal account will not be affected.";
                        class31.field712 = 1;
                        class31.field722 = 0;
                     } else if(0 != (client.field492 & 4)) {
                        if((client.field492 & 1024) != 0) {
                           class31.field714 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class31.field729 = "Players can attack each other almost everywhere";
                           class31.field716 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class31.field714 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class31.field729 = "Players can attack each other";
                           class31.field716 = "almost everywhere.";
                        }

                        class31.field719 = "Warning!";
                        class31.field712 = 1;
                        class31.field722 = 0;
                     } else if(0 != (client.field492 & 1024)) {
                        class31.field714 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class31.field729 = "The Protect Item prayer will";
                        class31.field716 = "not work on this world.";
                        class31.field719 = "Warning!";
                        class31.field712 = 1;
                        class31.field722 = 0;
                     } else {
                        class31.field714 = "";
                        class31.field729 = "Enter your username/email & password.";
                        class31.field716 = "";
                        class31.field712 = 2;
                        class31.field722 = 0;
                     }
                  }
               } else if(1 != class31.field712) {
                  short var13;
                  if(2 == class31.field712) {
                     var13 = 231;
                     var12 = var13 + 30;
                     if(1 == var9 && var3 >= var12 - 15 && var3 < var12) {
                        class31.field722 = 0;
                     }

                     var12 += 15;
                     if(var9 == 1 && var3 >= var12 - 15 && var3 < var12) {
                        class31.field722 = 1;
                     }

                     var12 += 15;
                     var13 = 361;
                     if(var9 == 1 && var3 >= var13 - 15 && var3 < var13) {
                        class114.method2436("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class31.field712 = 5;
                        return;
                     }

                     int var14 = 180 + class31.field702 - 80;
                     short var6 = 321;
                     if(1 == var9 && var2 >= var14 - 75 && var2 <= 75 + var14 && var3 >= var6 - 20 && var3 <= 20 + var6) {
                        class31.field698 = class31.field698.trim();
                        if(class31.field698.length() == 0) {
                           class114.method2436("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class31.field710.length() == 0) {
                           class114.method2436("", "Please enter your password.", "");
                           return;
                        }

                        class114.method2436("", "Connecting to server...", "");
                        class31.field727 = class4.field75.field142.containsKey(Integer.valueOf(class89.method2082(class31.field698)))?class159.field2595:class159.field2591;
                        class13.method162(20);
                        return;
                     }

                     var14 = 80 + 180 + class31.field702;
                     if(var9 == 1 && var2 >= var14 - 75 && var2 <= 75 + var14 && var3 >= var6 - 20 && var3 <= var6 + 20) {
                        class31.field712 = 0;
                        class31.field698 = "";
                        class31.field710 = "";
                        class31.field720 = 0;
                        class101.field1739 = "";
                        class31.field721 = true;
                     }

                     while(true) {
                        while(class2.method29()) {
                           boolean var7 = false;

                           for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                              if(class137.field2081 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                 var7 = true;
                                 break;
                              }
                           }

                           if(13 == class188.field3056) {
                              class31.field712 = 0;
                              class31.field698 = "";
                              class31.field710 = "";
                              class31.field720 = 0;
                              class101.field1739 = "";
                              class31.field721 = true;
                           } else if(0 == class31.field722) {
                              if(class188.field3056 == 85 && class31.field698.length() > 0) {
                                 class31.field698 = class31.field698.substring(0, class31.field698.length() - 1);
                              }

                              if(84 == class188.field3056 || class188.field3056 == 80) {
                                 class31.field722 = 1;
                              }

                              if(var7 && class31.field698.length() < 320) {
                                 class31.field698 = class31.field698 + class137.field2081;
                              }
                           } else if(1 == class31.field722) {
                              if(class188.field3056 == 85 && class31.field710.length() > 0) {
                                 class31.field710 = class31.field710.substring(0, class31.field710.length() - 1);
                              }

                              if(84 == class188.field3056 || 80 == class188.field3056) {
                                 class31.field722 = 0;
                              }

                              if(class188.field3056 == 84) {
                                 class31.field698 = class31.field698.trim();
                                 if(class31.field698.length() == 0) {
                                    class114.method2436("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class31.field710.length() == 0) {
                                    class114.method2436("", "Please enter your password.", "");
                                    return;
                                 }

                                 class114.method2436("", "Connecting to server...", "");
                                 class31.field727 = class4.field75.field142.containsKey(Integer.valueOf(class89.method2082(class31.field698)))?class159.field2595:class159.field2591;
                                 class13.method162(20);
                                 return;
                              }

                              if(var7 && class31.field710.length() < 20) {
                                 class31.field710 = class31.field710 + class137.field2081;
                              }
                           }
                        }

                        return;
                     }
                  } else if(class31.field712 == 3) {
                     var12 = 180 + class31.field702;
                     var5 = 276;
                     if(var9 == 1 && var2 >= var12 - 75 && var2 <= 75 + var12 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                        class31.field714 = "";
                        class31.field729 = "Enter your username/email & password.";
                        class31.field716 = "";
                        class31.field712 = 2;
                        class31.field722 = 0;
                     }

                     var12 = class31.field702 + 180;
                     var5 = 326;
                     if(var9 == 1 && var2 >= var12 - 75 && var2 <= var12 + 75 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                        class114.method2436("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class31.field712 = 5;
                        return;
                     }
                  } else {
                     boolean var15;
                     int var16;
                     if(4 == class31.field712) {
                        var12 = 180 + class31.field702 - 80;
                        var5 = 321;
                        if(var9 == 1 && var2 >= var12 - 75 && var2 <= 75 + var12 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                           class101.field1739.trim();
                           if(class101.field1739.length() != 6) {
                              class114.method2436("", "Please enter a 6-digin PIN.", "");
                              return;
                           }

                           class31.field720 = Integer.parseInt(class101.field1739);
                           class101.field1739 = "";
                           class31.field727 = class31.field721?class159.field2590:class159.field2592;
                           class114.method2436("", "Connecting to server...", "");
                           class13.method162(20);
                           return;
                        }

                        if(1 == var9 && var2 >= 180 + class31.field702 - 9 && var2 <= 180 + class31.field702 + 130 && var3 >= 263 && var3 <= 296) {
                           class31.field721 = !class31.field721;
                        }

                        if(1 == var9 && var2 >= class31.field702 + 180 - 34 && var2 <= 34 + class31.field702 + 180 && var3 >= 351 && var3 <= 363) {
                           class46.method970(class59.method1248("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                        }

                        var12 = 80 + 180 + class31.field702;
                        if(var9 == 1 && var2 >= var12 - 75 && var2 <= var12 + 75 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                           class31.field712 = 0;
                           class31.field698 = "";
                           class31.field710 = "";
                           class31.field720 = 0;
                           class101.field1739 = "";
                        }

                        while(class2.method29()) {
                           var15 = false;

                           for(var16 = 0; var16 < "1234567890".length(); ++var16) {
                              if(class137.field2081 == "1234567890".charAt(var16)) {
                                 var15 = true;
                                 break;
                              }
                           }

                           if(class188.field3056 == 13) {
                              class31.field712 = 0;
                              class31.field698 = "";
                              class31.field710 = "";
                              class31.field720 = 0;
                              class101.field1739 = "";
                           } else {
                              if(class188.field3056 == 85 && class101.field1739.length() > 0) {
                                 class101.field1739 = class101.field1739.substring(0, class101.field1739.length() - 1);
                              }

                              if(class188.field3056 == 84) {
                                 class101.field1739.trim();
                                 if(class101.field1739.length() != 6) {
                                    class114.method2436("", "Please enter a 6-digin PIN.", "");
                                    return;
                                 }

                                 class31.field720 = Integer.parseInt(class101.field1739);
                                 class101.field1739 = "";
                                 class31.field727 = class31.field721?class159.field2590:class159.field2592;
                                 class114.method2436("", "Connecting to server...", "");
                                 class13.method162(20);
                                 return;
                              }

                              if(var15 && class101.field1739.length() < 6) {
                                 class101.field1739 = class101.field1739 + class137.field2081;
                              }
                           }
                        }
                     } else if(5 == class31.field712) {
                        var12 = class31.field702 + 180 - 80;
                        var5 = 321;
                        if(var9 == 1 && var2 >= var12 - 75 && var2 <= 75 + var12 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                           class172.method3357();
                           return;
                        }

                        var12 = class31.field702 + 180 + 80;
                        if(var9 == 1 && var2 >= var12 - 75 && var2 <= 75 + var12 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                           class31.field714 = "";
                           class31.field729 = "Enter your username/email & password.";
                           class31.field716 = "";
                           class31.field712 = 2;
                           class31.field722 = 0;
                           class31.field710 = "";
                        }

                        while(class2.method29()) {
                           var15 = false;

                           for(var16 = 0; var16 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var16) {
                              if(class137.field2081 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var16)) {
                                 var15 = true;
                                 break;
                              }
                           }

                           if(13 == class188.field3056) {
                              class31.field714 = "";
                              class31.field729 = "Enter your username/email & password.";
                              class31.field716 = "";
                              class31.field712 = 2;
                              class31.field722 = 0;
                              class31.field710 = "";
                           } else {
                              if(85 == class188.field3056 && class31.field698.length() > 0) {
                                 class31.field698 = class31.field698.substring(0, class31.field698.length() - 1);
                              }

                              if(84 == class188.field3056) {
                                 class172.method3357();
                                 return;
                              }

                              if(var15 && class31.field698.length() < 320) {
                                 class31.field698 = class31.field698 + class137.field2081;
                              }
                           }
                        }
                     } else if(class31.field712 == 6) {
                        while(true) {
                           do {
                              if(!class2.method29()) {
                                 var13 = 321;
                                 if(var9 == 1 && var3 >= var13 - 20 && var3 <= var13 + 20) {
                                    class31.field714 = "";
                                    class31.field729 = "Enter your username/email & password.";
                                    class31.field716 = "";
                                    class31.field712 = 2;
                                    class31.field722 = 0;
                                    class31.field710 = "";
                                 }

                                 return;
                              }
                           } while(84 != class188.field3056 && class188.field3056 != 13);

                           class31.field714 = "";
                           class31.field729 = "Enter your username/email & password.";
                           class31.field716 = "";
                           class31.field712 = 2;
                           class31.field722 = 0;
                           class31.field710 = "";
                        }
                     }
                  }
               } else {
                  while(class2.method29()) {
                     if(84 == class188.field3056) {
                        class31.field714 = "";
                        class31.field729 = "Enter your username/email & password.";
                        class31.field716 = "";
                        class31.field712 = 2;
                        class31.field722 = 0;
                     } else if(13 == class188.field3056) {
                        class31.field712 = 0;
                     }
                  }

                  var12 = class31.field702 + 180 - 80;
                  var5 = 321;
                  if(1 == var9 && var2 >= var12 - 75 && var2 <= 75 + var12 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                     class31.field714 = "";
                     class31.field729 = "Enter your username/email & password.";
                     class31.field716 = "";
                     class31.field712 = 2;
                     class31.field722 = 0;
                  }

                  var12 = 80 + class31.field702 + 180;
                  if(var9 == 1 && var2 >= var12 - 75 && var2 <= 75 + var12 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                     class31.field712 = 0;
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1900775843"
   )
   public static void method2() {
      class51.field1089.method3707();
      class51.field1091.method3707();
      class51.field1092.method3707();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)I",
      garbageValue = "-125"
   )
   public static int method3(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return 0 == var2?var1:(1 == var2?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }
}
