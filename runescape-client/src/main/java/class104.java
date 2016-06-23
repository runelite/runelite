import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
public final class class104 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1623709163
   )
   int field1776;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 476512613
   )
   int field1777;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1208103233
   )
   int field1778;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1900013337
   )
   int field1780;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -611949471
   )
   int field1781;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -810559831
   )
   int field1782;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1887796123
   )
   int field1783;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2006283059
   )
   int field1784;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 192266117
   )
   int field1785;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1168713763
   )
   int field1786;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -621176057
   )
   int field1787;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1884024225
   )
   int field1788;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -966143819
   )
   int field1789;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -962252437
   )
   int field1790;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 14392957
   )
   int field1791;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -157527733
   )
   int field1792;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 270554131
   )
   int field1793;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -521960099
   )
   int field1794;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 1678750359
   )
   static int field1796;
   @ObfuscatedName("ay")
   @Export("authCode")
   static String field1797;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass144;I)V",
      garbageValue = "-713893447"
   )
   static void method2348(class144 var0) {
      if(class31.field722) {
         class2.method19(var0);
      } else {
         int var2;
         int var3;
         if((class140.field2156 == 1 || !class148.field2224 && class140.field2156 == 4) && class140.field2161 >= class31.field725 + 765 - 50 && class140.field2158 >= 453) {
            class20.field580.field141 = !class20.field580.field141;
            class21.method613();
            if(!class20.field580.field141) {
               class168 var1 = class17.field261;
               var2 = var1.method3300("scape main");
               var3 = var1.method3301(var2, "");
               class96.method2261(var1, var2, var3, 255, false);
            } else {
               class38.method807();
            }
         }

         if(client.field299 != 5) {
            ++class31.field726;
            if(client.field299 == 10 || client.field299 == 11) {
               int var9;
               if(client.field297 == 0) {
                  if(class140.field2156 == 1 || !class148.field2224 && class140.field2156 == 4) {
                     var9 = 5 + class31.field725;
                     short var10 = 463;
                     byte var11 = 100;
                     byte var4 = 35;
                     if(class140.field2161 >= var9 && class140.field2161 <= var11 + var9 && class140.field2158 >= var10 && class140.field2158 <= var4 + var10) {
                        class29.method706();
                        return;
                     }
                  }

                  if(class189.field3050 != null) {
                     class29.method706();
                  }
               }

               var9 = class140.field2156;
               var2 = class140.field2161;
               var3 = class140.field2158;
               if(!class148.field2224 && var9 == 4) {
                  var9 = 1;
               }

               short var5;
               int var12;
               if(class31.field724 == 0) {
                  var12 = class31.field731 + 180 - 80;
                  var5 = 291;
                  if(var9 == 1 && var2 >= var12 - 75 && var2 <= var12 + 75 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                     class29.method707(class84.method1963("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var12 = 80 + class31.field731 + 180;
                  if(var9 == 1 && var2 >= var12 - 75 && var2 <= var12 + 75 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                     if((client.field291 & 33554432) != 0) {
                        class31.field720 = "";
                        class31.field730 = "This is a <col=00ffff>Tournament<col=ffffff> world.";
                        class31.field733 = "Max stats and high level gear are provided.";
                        class31.field734 = "Your normal account will not be affected.";
                        class31.field724 = 1;
                        class31.field739 = 0;
                     } else if((client.field291 & 4) != 0) {
                        if((client.field291 & 1024) != 0) {
                           class31.field730 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class31.field733 = "Players can attack each other almost everywhere";
                           class31.field734 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class31.field730 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class31.field733 = "Players can attack each other";
                           class31.field734 = "almost everywhere.";
                        }

                        class31.field720 = "Warning!";
                        class31.field724 = 1;
                        class31.field739 = 0;
                     } else if((client.field291 & 1024) != 0) {
                        class31.field730 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class31.field733 = "The Protect Item prayer will";
                        class31.field734 = "not work on this world.";
                        class31.field720 = "Warning!";
                        class31.field724 = 1;
                        class31.field739 = 0;
                     } else {
                        class31.field730 = "";
                        class31.field733 = "Enter your username/email & password.";
                        class31.field734 = "";
                        class31.field724 = 2;
                        class31.field739 = 0;
                     }
                  }
               } else if(class31.field724 != 1) {
                  short var13;
                  if(class31.field724 == 2) {
                     var13 = 231;
                     var12 = var13 + 30;
                     if(var9 == 1 && var3 >= var12 - 15 && var3 < var12) {
                        class31.field739 = 0;
                     }

                     var12 += 15;
                     if(var9 == 1 && var3 >= var12 - 15 && var3 < var12) {
                        class31.field739 = 1;
                     }

                     var12 += 15;
                     var13 = 361;
                     if(var9 == 1 && var3 >= var13 - 15 && var3 < var13) {
                        class111.method2477("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class31.field724 = 5;
                        return;
                     }

                     int var14 = 180 + class31.field731 - 80;
                     short var6 = 321;
                     if(var9 == 1 && var2 >= var14 - 75 && var2 <= 75 + var14 && var3 >= var6 - 20 && var3 <= var6 + 20) {
                        class31.field729 = class31.field729.trim();
                        if(class31.field729.length() == 0) {
                           class111.method2477("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class31.field736.length() == 0) {
                           class111.method2477("", "Please enter your password.", "");
                           return;
                        }

                        class111.method2477("", "Connecting to server...", "");
                        class31.field727 = class20.field580.field146.containsKey(Integer.valueOf(class159.method3197(class31.field729)))?class159.field2600:class159.field2593;
                        class11.method156(20);
                        return;
                     }

                     var14 = 180 + class31.field731 + 80;
                     if(var9 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var6 - 20 && var3 <= 20 + var6) {
                        class31.field724 = 0;
                        class31.field729 = "";
                        class31.field736 = "";
                        class107.field1880 = 0;
                        field1797 = "";
                        class31.field738 = true;
                     }

                     while(true) {
                        while(class84.method1962()) {
                           boolean var7 = false;

                           for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                              if(class13.field198 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                 var7 = true;
                                 break;
                              }
                           }

                           if(class101.field1756 == 13) {
                              class31.field724 = 0;
                              class31.field729 = "";
                              class31.field736 = "";
                              class107.field1880 = 0;
                              field1797 = "";
                              class31.field738 = true;
                           } else if(class31.field739 == 0) {
                              if(class101.field1756 == 85 && class31.field729.length() > 0) {
                                 class31.field729 = class31.field729.substring(0, class31.field729.length() - 1);
                              }

                              if(class101.field1756 == 84 || class101.field1756 == 80) {
                                 class31.field739 = 1;
                              }

                              if(var7 && class31.field729.length() < 320) {
                                 class31.field729 = class31.field729 + class13.field198;
                              }
                           } else if(class31.field739 == 1) {
                              if(class101.field1756 == 85 && class31.field736.length() > 0) {
                                 class31.field736 = class31.field736.substring(0, class31.field736.length() - 1);
                              }

                              if(class101.field1756 == 84 || class101.field1756 == 80) {
                                 class31.field739 = 0;
                              }

                              if(class101.field1756 == 84) {
                                 class31.field729 = class31.field729.trim();
                                 if(class31.field729.length() == 0) {
                                    class111.method2477("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class31.field736.length() == 0) {
                                    class111.method2477("", "Please enter your password.", "");
                                    return;
                                 }

                                 class111.method2477("", "Connecting to server...", "");
                                 class31.field727 = class20.field580.field146.containsKey(Integer.valueOf(class159.method3197(class31.field729)))?class159.field2600:class159.field2593;
                                 class11.method156(20);
                                 return;
                              }

                              if(var7 && class31.field736.length() < 20) {
                                 class31.field736 = class31.field736 + class13.field198;
                              }
                           }
                        }

                        return;
                     }
                  } else if(class31.field724 == 3) {
                     var12 = 180 + class31.field731;
                     var5 = 276;
                     if(var9 == 1 && var2 >= var12 - 75 && var2 <= var12 + 75 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                        class31.field730 = "";
                        class31.field733 = "Enter your username/email & password.";
                        class31.field734 = "";
                        class31.field724 = 2;
                        class31.field739 = 0;
                     }

                     var12 = 180 + class31.field731;
                     var5 = 326;
                     if(var9 == 1 && var2 >= var12 - 75 && var2 <= var12 + 75 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                        class111.method2477("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class31.field724 = 5;
                        return;
                     }
                  } else {
                     boolean var15;
                     int var16;
                     if(class31.field724 == 4) {
                        var12 = 180 + class31.field731 - 80;
                        var5 = 321;
                        if(var9 == 1 && var2 >= var12 - 75 && var2 <= 75 + var12 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                           field1797.trim();
                           if(field1797.length() != 6) {
                              class111.method2477("", "Please enter a 6-digin PIN.", "");
                              return;
                           }

                           class107.field1880 = Integer.parseInt(field1797);
                           field1797 = "";
                           class31.field727 = class31.field738?class159.field2603:class159.field2594;
                           class111.method2477("", "Connecting to server...", "");
                           class11.method156(20);
                           return;
                        }

                        if(var9 == 1 && var2 >= class31.field731 + 180 - 9 && var2 <= 130 + 180 + class31.field731 && var3 >= 263 && var3 <= 296) {
                           class31.field738 = !class31.field738;
                        }

                        if(var9 == 1 && var2 >= 180 + class31.field731 - 34 && var2 <= 180 + class31.field731 + 34 && var3 >= 351 && var3 <= 363) {
                           class29.method707(class84.method1963("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                        }

                        var12 = class31.field731 + 180 + 80;
                        if(var9 == 1 && var2 >= var12 - 75 && var2 <= 75 + var12 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                           class31.field724 = 0;
                           class31.field729 = "";
                           class31.field736 = "";
                           class107.field1880 = 0;
                           field1797 = "";
                        }

                        while(class84.method1962()) {
                           var15 = false;

                           for(var16 = 0; var16 < "1234567890".length(); ++var16) {
                              if(class13.field198 == "1234567890".charAt(var16)) {
                                 var15 = true;
                                 break;
                              }
                           }

                           if(class101.field1756 == 13) {
                              class31.field724 = 0;
                              class31.field729 = "";
                              class31.field736 = "";
                              class107.field1880 = 0;
                              field1797 = "";
                           } else {
                              if(class101.field1756 == 85 && field1797.length() > 0) {
                                 field1797 = field1797.substring(0, field1797.length() - 1);
                              }

                              if(class101.field1756 == 84) {
                                 field1797.trim();
                                 if(field1797.length() != 6) {
                                    class111.method2477("", "Please enter a 6-digin PIN.", "");
                                    return;
                                 }

                                 class107.field1880 = Integer.parseInt(field1797);
                                 field1797 = "";
                                 class31.field727 = class31.field738?class159.field2603:class159.field2594;
                                 class111.method2477("", "Connecting to server...", "");
                                 class11.method156(20);
                                 return;
                              }

                              if(var15 && field1797.length() < 6) {
                                 field1797 = field1797 + class13.field198;
                              }
                           }
                        }
                     } else if(class31.field724 == 5) {
                        var12 = class31.field731 + 180 - 80;
                        var5 = 321;
                        if(var9 == 1 && var2 >= var12 - 75 && var2 <= var12 + 75 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                           class127.method2840();
                           return;
                        }

                        var12 = 80 + 180 + class31.field731;
                        if(var9 == 1 && var2 >= var12 - 75 && var2 <= 75 + var12 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                           class31.field730 = "";
                           class31.field733 = "Enter your username/email & password.";
                           class31.field734 = "";
                           class31.field724 = 2;
                           class31.field739 = 0;
                           class31.field736 = "";
                        }

                        while(class84.method1962()) {
                           var15 = false;

                           for(var16 = 0; var16 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var16) {
                              if(class13.field198 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var16)) {
                                 var15 = true;
                                 break;
                              }
                           }

                           if(class101.field1756 == 13) {
                              class31.field730 = "";
                              class31.field733 = "Enter your username/email & password.";
                              class31.field734 = "";
                              class31.field724 = 2;
                              class31.field739 = 0;
                              class31.field736 = "";
                           } else {
                              if(class101.field1756 == 85 && class31.field729.length() > 0) {
                                 class31.field729 = class31.field729.substring(0, class31.field729.length() - 1);
                              }

                              if(class101.field1756 == 84) {
                                 class127.method2840();
                                 return;
                              }

                              if(var15 && class31.field729.length() < 320) {
                                 class31.field729 = class31.field729 + class13.field198;
                              }
                           }
                        }
                     } else if(class31.field724 == 6) {
                        while(true) {
                           do {
                              if(!class84.method1962()) {
                                 var13 = 321;
                                 if(var9 == 1 && var3 >= var13 - 20 && var3 <= var13 + 20) {
                                    class31.field730 = "";
                                    class31.field733 = "Enter your username/email & password.";
                                    class31.field734 = "";
                                    class31.field724 = 2;
                                    class31.field739 = 0;
                                    class31.field736 = "";
                                 }

                                 return;
                              }
                           } while(class101.field1756 != 84 && class101.field1756 != 13);

                           class31.field730 = "";
                           class31.field733 = "Enter your username/email & password.";
                           class31.field734 = "";
                           class31.field724 = 2;
                           class31.field739 = 0;
                           class31.field736 = "";
                        }
                     }
                  }
               } else {
                  while(class84.method1962()) {
                     if(class101.field1756 == 84) {
                        class31.field730 = "";
                        class31.field733 = "Enter your username/email & password.";
                        class31.field734 = "";
                        class31.field724 = 2;
                        class31.field739 = 0;
                     } else if(class101.field1756 == 13) {
                        class31.field724 = 0;
                     }
                  }

                  var12 = class31.field731 + 180 - 80;
                  var5 = 321;
                  if(var9 == 1 && var2 >= var12 - 75 && var2 <= var12 + 75 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                     class31.field730 = "";
                     class31.field733 = "Enter your username/email & password.";
                     class31.field734 = "";
                     class31.field724 = 2;
                     class31.field739 = 0;
                  }

                  var12 = class31.field731 + 180 + 80;
                  if(var9 == 1 && var2 >= var12 - 75 && var2 <= var12 + 75 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                     class31.field724 = 0;
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "-23"
   )
   static byte[] method2349(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1005227047"
   )
   static void method2350(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(class25.field639[var5] != var0) {
            var2[var4] = class25.field639[var5];
            var3[var4] = class25.field649[var5];
            ++var4;
         }
      }

      class25.field639 = var2;
      class25.field649 = var3;
      class214.method3982(class25.field635, 0, class25.field635.length - 1, class25.field639, class25.field649);
   }
}
