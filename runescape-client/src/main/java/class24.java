import java.io.IOException;
import java.util.LinkedHashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
@Implements("XClanMember")
public class class24 extends class208 {
   @ObfuscatedName("r")
   public static class167 field614;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 291619745
   )
   @Export("world")
   int field615;
   @ObfuscatedName("h")
   @Export("rank")
   byte field616;
   @ObfuscatedName("ic")
   static class173 field617;
   @ObfuscatedName("ev")
   static class78[] field618;
   @ObfuscatedName("pu")
   static class134 field620;
   @ObfuscatedName("i")
   String field621;
   @ObfuscatedName("t")
   @Export("username")
   String field622;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = -167262949
   )
   static int field624;
   @ObfuscatedName("cc")
   public static char field625;

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "0"
   )
   static final void method572(boolean var0) {
      class135.method2845();
      ++client.field514;
      if(client.field514 >= 50) {
         client.field514 = 0;
         if(!client.field336 && null != class51.field1112) {
            client.field325.method2733(133);

            try {
               class51.field1112.method2964(client.field325.field2001, 0, client.field325.field2000);
               client.field325.field2000 = 0;
            } catch (IOException var2) {
               client.field336 = true;
            }
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass144;I)V",
      garbageValue = "-2099189842"
   )
   static void method573(class144 var0) {
      int var1;
      int var19;
      int var20;
      int var21;
      if(class31.field702) {
         if(class140.field2185 == 1 || !class101.field1755 && class140.field2185 == 4) {
            var1 = class31.field703 + 280;
            if(class140.field2190 >= var1 && class140.field2190 <= 14 + var1 && class140.field2187 >= 4 && class140.field2187 <= 18) {
               class110.method2384(0, 0);
            } else if(class140.field2190 >= 15 + var1 && class140.field2190 <= 80 + var1 && class140.field2187 >= 4 && class140.field2187 <= 18) {
               class110.method2384(0, 1);
            } else {
               var19 = 390 + class31.field703;
               if(class140.field2190 >= var19 && class140.field2190 <= 14 + var19 && class140.field2187 >= 4 && class140.field2187 <= 18) {
                  class110.method2384(1, 0);
               } else if(class140.field2190 >= 15 + var19 && class140.field2190 <= var19 + 80 && class140.field2187 >= 4 && class140.field2187 <= 18) {
                  class110.method2384(1, 1);
               } else {
                  var20 = class31.field703 + 500;
                  if(class140.field2190 >= var20 && class140.field2190 <= var20 + 14 && class140.field2187 >= 4 && class140.field2187 <= 18) {
                     class110.method2384(2, 0);
                  } else if(class140.field2190 >= 15 + var20 && class140.field2190 <= 80 + var20 && class140.field2187 >= 4 && class140.field2187 <= 18) {
                     class110.method2384(2, 1);
                  } else {
                     var21 = 610 + class31.field703;
                     if(class140.field2190 >= var21 && class140.field2190 <= 14 + var21 && class140.field2187 >= 4 && class140.field2187 <= 18) {
                        class110.method2384(3, 0);
                     } else if(class140.field2190 >= var21 + 15 && class140.field2190 <= var21 + 80 && class140.field2187 >= 4 && class140.field2187 <= 18) {
                        class110.method2384(3, 1);
                     } else if(class140.field2190 >= 708 + class31.field703 && class140.field2187 >= 4 && class140.field2190 <= 50 + 708 + class31.field703 && class140.field2187 <= 20) {
                        class31.field702 = false;
                        class49.field1100.method1727(class31.field703, 0);
                        class31.field705.method1727(382 + class31.field703, 0);
                        class135.field2101.method1822(382 + class31.field703 - class135.field2101.field1424 / 2, 18);
                     } else if(class31.field730 != -1) {
                        class25 var14 = class25.field636[class31.field730];
                        class75.method1598(var14);
                        class31.field702 = false;
                        class49.field1100.method1727(class31.field703, 0);
                        class31.field705.method1727(382 + class31.field703, 0);
                        class135.field2101.method1822(382 + class31.field703 - class135.field2101.field1424 / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((class140.field2185 == 1 || !class101.field1755 && class140.field2185 == 4) && class140.field2190 >= class31.field703 + 765 - 50 && class140.field2187 >= 453) {
            class116.field1988.field145 = !class116.field1988.field145;
            class25.method590();
            if(!class116.field1988.field145) {
               class188.method3706(class103.field1783, "scape main", "", 255, false);
            } else {
               class172.method3364();
            }
         }

         if(client.field462 != 5) {
            ++class31.field713;
            if(client.field462 == 10 || client.field462 == 11) {
               if(client.field288 == 0) {
                  if(class140.field2185 == 1 || !class101.field1755 && class140.field2185 == 4) {
                     var1 = class31.field703 + 5;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(class140.field2190 >= var1 && class140.field2190 <= var1 + var3 && class140.field2187 >= var2 && class140.field2187 <= var4 + var2) {
                        if(class16.method163()) {
                           class31.field702 = true;
                        }

                        return;
                     }
                  }

                  if(null != class41.field969 && class16.method163()) {
                     class31.field702 = true;
                  }
               }

               var1 = class140.field2185;
               var19 = class140.field2190;
               var20 = class140.field2187;
               if(!class101.field1755 && var1 == 4) {
                  var1 = 1;
               }

               short var5;
               if(class31.field717 == 0) {
                  var21 = 180 + class31.field721 - 80;
                  var5 = 291;
                  if(var1 == 1 && var19 >= var21 - 75 && var19 <= var21 + 75 && var20 >= var5 - 20 && var20 <= var5 + 20) {
                     class135.method2850(class17.method167("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var21 = 80 + class31.field721 + 180;
                  if(var1 == 1 && var19 >= var21 - 75 && var19 <= 75 + var21 && var20 >= var5 - 20 && var20 <= 20 + var5) {
                     if((client.field283 & 33554432) != 0) {
                        class31.field708 = "";
                        class31.field719 = "This is a <col=00ffff>Tournament<col=ffffff> world.";
                        class31.field734 = "Max stats and high level gear are provided.";
                        class31.field712 = "Your normal account will not be affected.";
                        class31.field717 = 1;
                        class31.field726 = 0;
                     } else if((client.field283 & 4) != 0) {
                        if((client.field283 & 1024) != 0) {
                           class31.field719 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class31.field734 = "Players can attack each other almost everywhere";
                           class31.field712 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class31.field719 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class31.field734 = "Players can attack each other";
                           class31.field712 = "almost everywhere.";
                        }

                        class31.field708 = "Warning!";
                        class31.field717 = 1;
                        class31.field726 = 0;
                     } else if((client.field283 & 1024) != 0) {
                        class31.field719 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class31.field734 = "The Protect Item prayer will";
                        class31.field712 = "not work on this world.";
                        class31.field708 = "Warning!";
                        class31.field717 = 1;
                        class31.field726 = 0;
                     } else {
                        class31.field719 = "";
                        class31.field734 = "Enter your username/email & password.";
                        class31.field712 = "";
                        class31.field717 = 2;
                        class31.field726 = 0;
                     }
                  }
               } else if(class31.field717 != 1) {
                  short var22;
                  if(class31.field717 == 2) {
                     var22 = 231;
                     var21 = var22 + 30;
                     if(var1 == 1 && var20 >= var21 - 15 && var20 < var21) {
                        class31.field726 = 0;
                     }

                     var21 += 15;
                     if(var1 == 1 && var20 >= var21 - 15 && var20 < var21) {
                        class31.field726 = 1;
                     }

                     var21 += 15;
                     var22 = 361;
                     if(var1 == 1 && var20 >= var22 - 15 && var20 < var22) {
                        class50.method987("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class31.field717 = 5;
                        return;
                     }

                     int var23 = class31.field721 + 180 - 80;
                     short var6 = 321;
                     int var11;
                     int var12;
                     if(var1 == 1 && var19 >= var23 - 75 && var19 <= 75 + var23 && var20 >= var6 - 20 && var20 <= 20 + var6) {
                        class31.field722 = class31.field722.trim();
                        if(class31.field722.length() == 0) {
                           class50.method987("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class31.field723.length() == 0) {
                           class50.method987("", "Please enter your password.", "");
                           return;
                        }

                        class50.method987("", "Connecting to server...", "");
                        LinkedHashMap var15 = class116.field1988.field141;
                        String var9 = class31.field722;
                        int var17 = var9.length();
                        var11 = 0;

                        for(var12 = 0; var12 < var17; ++var12) {
                           var11 = (var11 << 5) - var11 + var9.charAt(var12);
                        }

                        class31.field724 = var15.containsKey(Integer.valueOf(var11))?class159.field2632:class159.field2625;
                        class2.method14(20);
                        return;
                     }

                     var23 = 180 + class31.field721 + 80;
                     if(var1 == 1 && var19 >= var23 - 75 && var19 <= var23 + 75 && var20 >= var6 - 20 && var20 <= var6 + 20) {
                        class31.field717 = 0;
                        class31.field722 = "";
                        class31.field723 = "";
                        class1.field33 = 0;
                        class96.field1643 = "";
                        class31.field725 = true;
                     }

                     while(true) {
                        while(class131.method2811()) {
                           boolean var7 = false;

                           for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                              if(field625 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                 var7 = true;
                                 break;
                              }
                           }

                           if(class137.field2142 == 13) {
                              class31.field717 = 0;
                              class31.field722 = "";
                              class31.field723 = "";
                              class1.field33 = 0;
                              class96.field1643 = "";
                              class31.field725 = true;
                           } else if(class31.field726 == 0) {
                              if(class137.field2142 == 85 && class31.field722.length() > 0) {
                                 class31.field722 = class31.field722.substring(0, class31.field722.length() - 1);
                              }

                              if(class137.field2142 == 84 || class137.field2142 == 80) {
                                 class31.field726 = 1;
                              }

                              if(var7 && class31.field722.length() < 320) {
                                 class31.field722 = class31.field722 + field625;
                              }
                           } else if(class31.field726 == 1) {
                              if(class137.field2142 == 85 && class31.field723.length() > 0) {
                                 class31.field723 = class31.field723.substring(0, class31.field723.length() - 1);
                              }

                              if(class137.field2142 == 84 || class137.field2142 == 80) {
                                 class31.field726 = 0;
                              }

                              if(class137.field2142 == 84) {
                                 class31.field722 = class31.field722.trim();
                                 if(class31.field722.length() == 0) {
                                    class50.method987("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class31.field723.length() == 0) {
                                    class50.method987("", "Please enter your password.", "");
                                    return;
                                 }

                                 class50.method987("", "Connecting to server...", "");
                                 LinkedHashMap var16 = class116.field1988.field141;
                                 String var10 = class31.field722;
                                 var11 = var10.length();
                                 var12 = 0;

                                 for(int var13 = 0; var13 < var11; ++var13) {
                                    var12 = (var12 << 5) - var12 + var10.charAt(var13);
                                 }

                                 class31.field724 = var16.containsKey(Integer.valueOf(var12))?class159.field2632:class159.field2625;
                                 class2.method14(20);
                                 return;
                              }

                              if(var7 && class31.field723.length() < 20) {
                                 class31.field723 = class31.field723 + field625;
                              }
                           }
                        }

                        return;
                     }
                  } else if(class31.field717 == 3) {
                     var21 = 180 + class31.field721;
                     var5 = 276;
                     if(var1 == 1 && var19 >= var21 - 75 && var19 <= 75 + var21 && var20 >= var5 - 20 && var20 <= 20 + var5) {
                        class31.field719 = "";
                        class31.field734 = "Enter your username/email & password.";
                        class31.field712 = "";
                        class31.field717 = 2;
                        class31.field726 = 0;
                     }

                     var21 = 180 + class31.field721;
                     var5 = 326;
                     if(var1 == 1 && var19 >= var21 - 75 && var19 <= var21 + 75 && var20 >= var5 - 20 && var20 <= var5 + 20) {
                        class50.method987("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class31.field717 = 5;
                        return;
                     }
                  } else {
                     boolean var24;
                     int var25;
                     if(class31.field717 == 4) {
                        var21 = class31.field721 + 180 - 80;
                        var5 = 321;
                        if(var1 == 1 && var19 >= var21 - 75 && var19 <= 75 + var21 && var20 >= var5 - 20 && var20 <= 20 + var5) {
                           class96.field1643.trim();
                           if(class96.field1643.length() != 6) {
                              class50.method987("", "Please enter a 6-digin PIN.", "");
                              return;
                           }

                           class1.field33 = Integer.parseInt(class96.field1643);
                           class96.field1643 = "";
                           class31.field724 = class31.field725?class159.field2634:class159.field2628;
                           class50.method987("", "Connecting to server...", "");
                           class2.method14(20);
                           return;
                        }

                        if(var1 == 1 && var19 >= class31.field721 + 180 - 9 && var19 <= 180 + class31.field721 + 130 && var20 >= 263 && var20 <= 296) {
                           class31.field725 = !class31.field725;
                        }

                        if(var1 == 1 && var19 >= class31.field721 + 180 - 34 && var19 <= class31.field721 + 180 + 34 && var20 >= 351 && var20 <= 363) {
                           class135.method2850(class17.method167("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                        }

                        var21 = 180 + class31.field721 + 80;
                        if(var1 == 1 && var19 >= var21 - 75 && var19 <= 75 + var21 && var20 >= var5 - 20 && var20 <= 20 + var5) {
                           class31.field717 = 0;
                           class31.field722 = "";
                           class31.field723 = "";
                           class1.field33 = 0;
                           class96.field1643 = "";
                        }

                        while(class131.method2811()) {
                           var24 = false;

                           for(var25 = 0; var25 < "1234567890".length(); ++var25) {
                              if(field625 == "1234567890".charAt(var25)) {
                                 var24 = true;
                                 break;
                              }
                           }

                           if(class137.field2142 == 13) {
                              class31.field717 = 0;
                              class31.field722 = "";
                              class31.field723 = "";
                              class1.field33 = 0;
                              class96.field1643 = "";
                           } else {
                              if(class137.field2142 == 85 && class96.field1643.length() > 0) {
                                 class96.field1643 = class96.field1643.substring(0, class96.field1643.length() - 1);
                              }

                              if(class137.field2142 == 84) {
                                 class96.field1643.trim();
                                 if(class96.field1643.length() != 6) {
                                    class50.method987("", "Please enter a 6-digin PIN.", "");
                                    return;
                                 }

                                 class1.field33 = Integer.parseInt(class96.field1643);
                                 class96.field1643 = "";
                                 class31.field724 = class31.field725?class159.field2634:class159.field2628;
                                 class50.method987("", "Connecting to server...", "");
                                 class2.method14(20);
                                 return;
                              }

                              if(var24 && class96.field1643.length() < 6) {
                                 class96.field1643 = class96.field1643 + field625;
                              }
                           }
                        }
                     } else if(class31.field717 == 5) {
                        var21 = 180 + class31.field721 - 80;
                        var5 = 321;
                        if(var1 == 1 && var19 >= var21 - 75 && var19 <= var21 + 75 && var20 >= var5 - 20 && var20 <= var5 + 20) {
                           class1.method6();
                           return;
                        }

                        var21 = class31.field721 + 180 + 80;
                        if(var1 == 1 && var19 >= var21 - 75 && var19 <= 75 + var21 && var20 >= var5 - 20 && var20 <= 20 + var5) {
                           class31.field719 = "";
                           class31.field734 = "Enter your username/email & password.";
                           class31.field712 = "";
                           class31.field717 = 2;
                           class31.field726 = 0;
                           class31.field723 = "";
                        }

                        while(class131.method2811()) {
                           var24 = false;

                           for(var25 = 0; var25 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var25) {
                              if(field625 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var25)) {
                                 var24 = true;
                                 break;
                              }
                           }

                           if(class137.field2142 == 13) {
                              class31.field719 = "";
                              class31.field734 = "Enter your username/email & password.";
                              class31.field712 = "";
                              class31.field717 = 2;
                              class31.field726 = 0;
                              class31.field723 = "";
                           } else {
                              if(class137.field2142 == 85 && class31.field722.length() > 0) {
                                 class31.field722 = class31.field722.substring(0, class31.field722.length() - 1);
                              }

                              if(class137.field2142 == 84) {
                                 class1.method6();
                                 return;
                              }

                              if(var24 && class31.field722.length() < 320) {
                                 class31.field722 = class31.field722 + field625;
                              }
                           }
                        }
                     } else if(class31.field717 == 6) {
                        while(true) {
                           do {
                              if(!class131.method2811()) {
                                 var22 = 321;
                                 if(var1 == 1 && var20 >= var22 - 20 && var20 <= var22 + 20) {
                                    class31.field719 = "";
                                    class31.field734 = "Enter your username/email & password.";
                                    class31.field712 = "";
                                    class31.field717 = 2;
                                    class31.field726 = 0;
                                    class31.field723 = "";
                                 }

                                 return;
                              }
                           } while(class137.field2142 != 84 && class137.field2142 != 13);

                           class31.field719 = "";
                           class31.field734 = "Enter your username/email & password.";
                           class31.field712 = "";
                           class31.field717 = 2;
                           class31.field726 = 0;
                           class31.field723 = "";
                        }
                     }
                  }
               } else {
                  while(class131.method2811()) {
                     if(class137.field2142 == 84) {
                        class31.field719 = "";
                        class31.field734 = "Enter your username/email & password.";
                        class31.field712 = "";
                        class31.field717 = 2;
                        class31.field726 = 0;
                     } else if(class137.field2142 == 13) {
                        class31.field717 = 0;
                     }
                  }

                  var21 = 180 + class31.field721 - 80;
                  var5 = 321;
                  if(var1 == 1 && var19 >= var21 - 75 && var19 <= 75 + var21 && var20 >= var5 - 20 && var20 <= 20 + var5) {
                     class31.field719 = "";
                     class31.field734 = "Enter your username/email & password.";
                     class31.field712 = "";
                     class31.field717 = 2;
                     class31.field726 = 0;
                  }

                  var21 = class31.field721 + 180 + 80;
                  if(var1 == 1 && var19 >= var21 - 75 && var19 <= var21 + 75 && var20 >= var5 - 20 && var20 <= var5 + 20) {
                     class31.field717 = 0;
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIILclass40;II)V",
      garbageValue = "260990950"
   )
   static void method574(int var0, int var1, int var2, class40 var3, int var4) {
      class23 var5 = new class23();
      var5.field596 = var0;
      var5.field595 = var1 * 128;
      var5.field609 = var2 * 128;
      int var6 = var3.field954;
      int var7 = var3.field923;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.field923;
         var7 = var3.field954;
      }

      var5.field612 = (var1 + var6) * 128;
      var5.field605 = (var7 + var2) * 128;
      var5.field602 = var3.field958;
      var5.field601 = var3.field959 * 128;
      var5.field597 = var3.field960;
      var5.field604 = var3.field961 * 1392302051;
      var5.field606 = var3.field962;
      if(var3.field955 != null) {
         var5.field598 = var3;
         var5.method564();
      }

      class23.field599.method3771(var5);
      if(null != var5.field606) {
         var5.field607 = var5.field597 + (int)(Math.random() * (double)(var5.field604 * 992715 - var5.field597));
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "70"
   )
   public static int method575(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return 1 + var0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-116306014"
   )
   static void method576(int var0, int var1) {
      if(client.field519 != 0 && var0 != -1) {
         class101.method2235(class106.field1878, var0, 0, client.field519, false);
         client.field521 = true;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1879190673"
   )
   static void method577() {
      for(class23 var0 = (class23)class23.field599.method3797(); var0 != null; var0 = (class23)class23.field599.method3779()) {
         if(null != var0.field603) {
            class129.field2065.method1092(var0.field603);
            var0.field603 = null;
         }

         if(null != var0.field600) {
            class129.field2065.method1092(var0.field600);
            var0.field600 = null;
         }
      }

      class23.field599.method3772();
   }
}
