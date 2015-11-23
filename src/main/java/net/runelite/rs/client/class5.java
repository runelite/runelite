package net.runelite.rs.client;

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("a")
public final class class5 {
   @ObfuscatedName("d")
   static final int[] field72 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("z")
   static int[] field73;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -842259375
   )
   static int field74 = 99;
   @ObfuscatedName("k")
   static int[] field75;
   @ObfuscatedName("a")
   static byte[][][] field76;
   @ObfuscatedName("t")
   static int[][] field77;
   @ObfuscatedName("q")
   static final int[] field78 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("j")
   @Export("tileHeights")
   static int[][][] field79 = new int[4][105][105];
   @ObfuscatedName("y")
   static final int[] field82 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("v")
   static final int[] field83 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("o")
   static final int[] field84 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("l")
   static byte[][][] field85;
   @ObfuscatedName("m")
   @Export("tileSettings")
   static byte[][][] field86 = new byte[4][104][104];
   @ObfuscatedName("x")
   static final int[] field87 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1269572109
   )
   static int field88 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -211092391
   )
   static int field89 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("be")
   static class167 field90;
   @ObfuscatedName("me")
   static byte field91;

   @ObfuscatedName("l")
   static void method59() {
      int var1;
      int var2;
      int var8;
      int var11;
      if(class31.field721) {
         if(class139.field2140 == 1 || !class33.field752 && class139.field2140 == 4) {
            var8 = 280 + class31.field691;
            if(class139.field2130 >= var8 && class139.field2130 <= var8 + 14 && class139.field2142 >= 4 && class139.field2142 <= 18) {
               class37.method793(0, 0);
            } else if(class139.field2130 >= 15 + var8 && class139.field2130 <= 80 + var8 && class139.field2142 >= 4 && class139.field2142 <= 18) {
               class37.method793(0, 1);
            } else {
               var1 = class31.field691 + 390;
               if(class139.field2130 >= var1 && class139.field2130 <= var1 + 14 && class139.field2142 >= 4 && class139.field2142 <= 18) {
                  class37.method793(1, 0);
               } else if(class139.field2130 >= var1 + 15 && class139.field2130 <= var1 + 80 && class139.field2142 >= 4 && class139.field2142 <= 18) {
                  class37.method793(1, 1);
               } else {
                  var2 = 500 + class31.field691;
                  if(class139.field2130 >= var2 && class139.field2130 <= var2 + 14 && class139.field2142 >= 4 && class139.field2142 <= 18) {
                     class37.method793(2, 0);
                  } else if(class139.field2130 >= 15 + var2 && class139.field2130 <= var2 + 80 && class139.field2142 >= 4 && class139.field2142 <= 18) {
                     class37.method793(2, 1);
                  } else {
                     var11 = class31.field691 + 610;
                     if(class139.field2130 >= var11 && class139.field2130 <= var11 + 14 && class139.field2142 >= 4 && class139.field2142 <= 18) {
                        class37.method793(3, 0);
                     } else if(class139.field2130 >= var11 + 15 && class139.field2130 <= 80 + var11 && class139.field2142 >= 4 && class139.field2142 <= 18) {
                        class37.method793(3, 1);
                     } else if(class139.field2130 >= 708 + class31.field691 && class139.field2142 >= 4 && class139.field2130 <= class31.field691 + 708 + 50 && class139.field2142 <= 20) {
                        class31.field721 = false;
                        class150.field2240.method1728(class31.field691, 0);
                        class31.field693.method1728(382 + class31.field691, 0);
                        class33.field755.method1881(class31.field691 + 382 - class33.field755.field1407 / 2, 18);
                     } else if(-1 != class31.field722) {
                        class25 var15 = class25.field615[class31.field722];
                        class26.method675(var15);
                        class31.field721 = false;
                        class150.field2240.method1728(class31.field691, 0);
                        class31.field693.method1728(class31.field691 + 382, 0);
                        class33.field755.method1881(class31.field691 + 382 - class33.field755.field1407 / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((1 == class139.field2140 || !class33.field752 && class139.field2140 == 4) && class139.field2130 >= class31.field691 + 765 - 50 && class139.field2142 >= 453) {
            class153.field2277.field135 = !class153.field2277.field135;
            class125.method2852();
            if(!class153.field2277.field135) {
               class167 var0 = class142.field2165;
               var1 = var0.method3327("scape main");
               var2 = var0.method3323(var1, "");
               class41.method903(var0, var1, var2, 255, false);
            } else {
               class182.field2943.method3658();
               class182.field2940 = 1;
               class188.field3038 = null;
            }
         }

         if(5 != client.field296) {
            ++class31.field705;
            if(client.field296 == 10 || 11 == client.field296) {
               if(client.field283 == 0) {
                  if(class139.field2140 == 1 || !class33.field752 && 4 == class139.field2140) {
                     var8 = class31.field691 + 5;
                     short var9 = 463;
                     byte var10 = 100;
                     byte var3 = 35;
                     if(class139.field2130 >= var8 && class139.field2130 <= var8 + var10 && class139.field2142 >= var9 && class139.field2142 <= var9 + var3) {
                        if(class160.method3226()) {
                           class31.field721 = true;
                        }

                        return;
                     }
                  }

                  if(class25.field620 != null && class160.method3226()) {
                     class31.field721 = true;
                  }
               }

               var8 = class139.field2140;
               var1 = class139.field2130;
               var2 = class139.field2142;
               if(!class33.field752 && 4 == var8) {
                  var8 = 1;
               }

               short var4;
               if(class31.field709 == 0) {
                  var11 = 180 + class31.field715 - 80;
                  var4 = 291;
                  if(var8 == 1 && var1 >= var11 - 75 && var1 <= var11 + 75 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                     class158.method3209(class22.method617("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true);
                  }

                  var11 = 80 + 180 + class31.field715;
                  if(var8 == 1 && var1 >= var11 - 75 && var1 <= 75 + var11 && var2 >= var4 - 20 && var2 <= 20 + var4) {
                     if((client.field277 & 4) != 0) {
                        if((client.field277 & 1024) != 0) {
                           class31.field710 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class31.field714 = "Players can attack each other almost everywhere";
                           class31.field712 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class31.field710 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class31.field714 = "Players can attack each other";
                           class31.field712 = "almost everywhere.";
                        }

                        class31.field709 = 1;
                        class31.field717 = 0;
                     } else if(0 != (client.field277 & 1024)) {
                        class31.field710 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class31.field714 = "The Protect Item prayer will";
                        class31.field712 = "not work on this world.";
                        class31.field709 = 1;
                        class31.field717 = 0;
                     } else {
                        class31.field710 = "";
                        class31.field714 = "Enter your username/email & password.";
                        class31.field712 = "";
                        class31.field709 = 2;
                        class31.field717 = 0;
                     }
                  }
               } else if(1 != class31.field709) {
                  short var12;
                  if(2 == class31.field709) {
                     var12 = 231;
                     var11 = var12 + 30;
                     if(var8 == 1 && var2 >= var11 - 15 && var2 < var11) {
                        class31.field717 = 0;
                     }

                     var11 += 15;
                     if(1 == var8 && var2 >= var11 - 15 && var2 < var11) {
                        class31.field717 = 1;
                     }

                     var11 += 15;
                     var12 = 361;
                     if(var8 == 1 && var2 >= var12 - 15 && var2 < var12) {
                        class9.method143("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class31.field709 = 5;
                        return;
                     }

                     int var13 = 180 + class31.field715 - 80;
                     short var5 = 321;
                     if(1 == var8 && var1 >= var13 - 75 && var1 <= 75 + var13 && var2 >= var5 - 20 && var2 <= 20 + var5) {
                        class31.field713 = class31.field713.trim();
                        if(class31.field713.length() == 0) {
                           class9.method143("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class31.field726.length() == 0) {
                           class9.method143("", "Please enter your password.", "");
                           return;
                        }

                        class9.method143("", "Connecting to server...", "");
                        class31.field720 = class153.field2277.field137.containsKey(Integer.valueOf(class20.method597(class31.field713)))?class158.field2582:class158.field2579;
                        class31.method714(20);
                        return;
                     }

                     var13 = class31.field715 + 180 + 80;
                     if(1 == var8 && var1 >= var13 - 75 && var1 <= 75 + var13 && var2 >= var5 - 20 && var2 <= 20 + var5) {
                        class31.field709 = 0;
                        class31.field713 = "";
                        class31.field726 = "";
                        class3.field64 = 0;
                        class50.field1083 = "";
                        class31.field716 = true;
                     }

                     while(true) {
                        while(class11.method180()) {
                           boolean var6 = false;

                           for(int var7 = 0; var7 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var7) {
                              if(class14.field208 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var7)) {
                                 var6 = true;
                                 break;
                              }
                           }

                           if(class136.field2095 == 13) {
                              class31.field709 = 0;
                              class31.field713 = "";
                              class31.field726 = "";
                              class3.field64 = 0;
                              class50.field1083 = "";
                              class31.field716 = true;
                           } else if(0 == class31.field717) {
                              if(class136.field2095 == 85 && class31.field713.length() > 0) {
                                 class31.field713 = class31.field713.substring(0, class31.field713.length() - 1);
                              }

                              if(class136.field2095 == 84 || 80 == class136.field2095) {
                                 class31.field717 = 1;
                              }

                              if(var6 && class31.field713.length() < 320) {
                                 class31.field713 = class31.field713 + class14.field208;
                              }
                           } else if(class31.field717 == 1) {
                              if(85 == class136.field2095 && class31.field726.length() > 0) {
                                 class31.field726 = class31.field726.substring(0, class31.field726.length() - 1);
                              }

                              if(84 == class136.field2095 || class136.field2095 == 80) {
                                 class31.field717 = 0;
                              }

                              if(class136.field2095 == 84) {
                                 class31.field713 = class31.field713.trim();
                                 if(class31.field713.length() == 0) {
                                    class9.method143("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class31.field726.length() == 0) {
                                    class9.method143("", "Please enter your password.", "");
                                    return;
                                 }

                                 class9.method143("", "Connecting to server...", "");
                                 class31.field720 = class153.field2277.field137.containsKey(Integer.valueOf(class20.method597(class31.field713)))?class158.field2582:class158.field2579;
                                 class31.method714(20);
                                 return;
                              }

                              if(var6 && class31.field726.length() < 20) {
                                 class31.field726 = class31.field726 + class14.field208;
                              }
                           }
                        }

                        return;
                     }
                  } else {
                     boolean var14;
                     int var16;
                     if(class31.field709 == 4) {
                        var11 = 180 + class31.field715 - 80;
                        var4 = 321;
                        if(1 == var8 && var1 >= var11 - 75 && var1 <= var11 + 75 && var2 >= var4 - 20 && var2 <= 20 + var4) {
                           class50.field1083.trim();
                           if(class50.field1083.length() != 6) {
                              class9.method143("", "Please enter a 6-digin PIN.", "");
                              return;
                           }

                           class3.field64 = Integer.parseInt(class50.field1083);
                           class50.field1083 = "";
                           class31.field720 = class31.field716?class158.field2578:class158.field2587;
                           class9.method143("", "Connecting to server...", "");
                           class31.method714(20);
                           return;
                        }

                        if(var8 == 1 && var1 >= 180 + class31.field715 - 9 && var1 <= 180 + class31.field715 + 130 && var2 >= 263 && var2 <= 296) {
                           class31.field716 = !class31.field716;
                        }

                        if(1 == var8 && var1 >= class31.field715 + 180 - 34 && var1 <= class31.field715 + 180 + 34 && var2 >= 351 && var2 <= 363) {
                           class158.method3209(class22.method617("secure", true) + "m=totp-authenticator/disableTOTPRequest", true);
                        }

                        var11 = 80 + 180 + class31.field715;
                        if(1 == var8 && var1 >= var11 - 75 && var1 <= 75 + var11 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                           class31.field709 = 0;
                           class31.field713 = "";
                           class31.field726 = "";
                           class3.field64 = 0;
                           class50.field1083 = "";
                        }

                        while(class11.method180()) {
                           var14 = false;

                           for(var16 = 0; var16 < "1234567890".length(); ++var16) {
                              if(class14.field208 == "1234567890".charAt(var16)) {
                                 var14 = true;
                                 break;
                              }
                           }

                           if(class136.field2095 == 13) {
                              class31.field709 = 0;
                              class31.field713 = "";
                              class31.field726 = "";
                              class3.field64 = 0;
                              class50.field1083 = "";
                           } else {
                              if(85 == class136.field2095 && class50.field1083.length() > 0) {
                                 class50.field1083 = class50.field1083.substring(0, class50.field1083.length() - 1);
                              }

                              if(class136.field2095 == 84) {
                                 class50.field1083.trim();
                                 if(class50.field1083.length() != 6) {
                                    class9.method143("", "Please enter a 6-digin PIN.", "");
                                    return;
                                 }

                                 class3.field64 = Integer.parseInt(class50.field1083);
                                 class50.field1083 = "";
                                 class31.field720 = class31.field716?class158.field2578:class158.field2587;
                                 class9.method143("", "Connecting to server...", "");
                                 class31.method714(20);
                                 return;
                              }

                              if(var14 && class50.field1083.length() < 6) {
                                 class50.field1083 = class50.field1083 + class14.field208;
                              }
                           }
                        }
                     } else if(5 == class31.field709) {
                        var11 = 180 + class31.field715 - 80;
                        var4 = 321;
                        if(var8 == 1 && var1 >= var11 - 75 && var1 <= var11 + 75 && var2 >= var4 - 20 && var2 <= 20 + var4) {
                           class76.method1697();
                           return;
                        }

                        var11 = 80 + class31.field715 + 180;
                        if(var8 == 1 && var1 >= var11 - 75 && var1 <= 75 + var11 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                           class31.field710 = "";
                           class31.field714 = "Enter your username/email & password.";
                           class31.field712 = "";
                           class31.field709 = 2;
                           class31.field717 = 0;
                           class31.field726 = "";
                        }

                        while(class11.method180()) {
                           var14 = false;

                           for(var16 = 0; var16 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var16) {
                              if(class14.field208 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var16)) {
                                 var14 = true;
                                 break;
                              }
                           }

                           if(13 == class136.field2095) {
                              class31.field710 = "";
                              class31.field714 = "Enter your username/email & password.";
                              class31.field712 = "";
                              class31.field709 = 2;
                              class31.field717 = 0;
                              class31.field726 = "";
                           } else {
                              if(85 == class136.field2095 && class31.field713.length() > 0) {
                                 class31.field713 = class31.field713.substring(0, class31.field713.length() - 1);
                              }

                              if(84 == class136.field2095) {
                                 class76.method1697();
                                 return;
                              }

                              if(var14 && class31.field713.length() < 320) {
                                 class31.field713 = class31.field713 + class14.field208;
                              }
                           }
                        }
                     } else if(class31.field709 == 6) {
                        while(true) {
                           do {
                              if(!class11.method180()) {
                                 var12 = 321;
                                 if(1 == var8 && var2 >= var12 - 20 && var2 <= var12 + 20) {
                                    class31.field710 = "";
                                    class31.field714 = "Enter your username/email & password.";
                                    class31.field712 = "";
                                    class31.field709 = 2;
                                    class31.field717 = 0;
                                    class31.field726 = "";
                                 }

                                 return;
                              }
                           } while(84 != class136.field2095 && class136.field2095 != 13);

                           class31.field710 = "";
                           class31.field714 = "Enter your username/email & password.";
                           class31.field712 = "";
                           class31.field709 = 2;
                           class31.field717 = 0;
                           class31.field726 = "";
                        }
                     }
                  }
               } else {
                  while(class11.method180()) {
                     if(84 == class136.field2095) {
                        class31.field710 = "";
                        class31.field714 = "Enter your username/email & password.";
                        class31.field712 = "";
                        class31.field709 = 2;
                        class31.field717 = 0;
                     } else if(13 == class136.field2095) {
                        class31.field709 = 0;
                     }
                  }

                  var11 = 180 + class31.field715 - 80;
                  var4 = 321;
                  if(1 == var8 && var1 >= var11 - 75 && var1 <= var11 + 75 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                     class31.field710 = "";
                     class31.field714 = "Enter your username/email & password.";
                     class31.field712 = "";
                     class31.field709 = 2;
                     class31.field717 = 0;
                  }

                  var11 = 80 + 180 + class31.field715;
                  if(1 == var8 && var1 >= var11 - 75 && var1 <= 75 + var11 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                     class31.field709 = 0;
                  }
               }

            }
         }
      }
   }
}
