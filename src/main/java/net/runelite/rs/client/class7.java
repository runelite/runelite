package net.runelite.rs.client;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("h")
@Implements("Ignore")
public class class7 {
   @ObfuscatedName("ns")
   @ObfuscatedGetter(
      intValue = 536556077
   )
   static int field135;
   @ObfuscatedName("l")
   @Export("previousName")
   String field136;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1897789005
   )
   public static int field138;
   @ObfuscatedName("j")
   @Export("name")
   String field139;

   @ObfuscatedName("i")
   static void method95(int var0, int var1, int var2, int var3) {
      class15 var4 = (class15)class15.field225.method3744((long)var0);
      if(var4 == null) {
         var4 = new class15();
         class15.field225.method3746(var4, (long)var0);
      }

      if(var4.field223.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.field223.length; ++var7) {
            var5[var7] = var4.field223[var7];
            var6[var7] = var4.field229[var7];
         }

         for(var7 = var4.field223.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.field223 = var5;
         var4.field229 = var6;
      }

      var4.field223[var1] = var2;
      var4.field229[var1] = var3;
   }

   @ObfuscatedName("y")
   public static void method96() {
      class51.field1140.method3720();
      class51.field1111.method3720();
      class51.field1118.method3720();
   }

   @ObfuscatedName("l")
   public static class52 method97(int var0) {
      class52 var1 = (class52)class52.field1165.method3711((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class52.field1172.method3214(16, var0);
         var1 = new class52();
         if(null != var2) {
            var1.method1093(new class118(var2));
         }

         class52.field1165.method3713(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   static void method98() {
      if(class31.field721) {
         class6.method86();
      } else {
         int var1;
         int var2;
         if((class139.field2168 == 1 || !class94.field1617 && 4 == class139.field2168) && class139.field2169 >= class31.field732 + 765 - 50 && class139.field2163 >= 453) {
            class10.field169.field143 = !class10.field169.field143;
            class3.method35();
            if(!class10.field169.field143) {
               class167 var0 = class137.field2139;
               var1 = var0.method3248("scape main");
               var2 = var0.method3238(var1, "");
               class108.method2379(var0, var1, var2, 255, false);
            } else {
               class45.method951();
            }
         }

         if(5 != client.field295) {
            ++class31.field730;
            if(10 == client.field295 || 11 == client.field295) {
               int var8;
               if(client.field472 == 0) {
                  if(class139.field2168 == 1 || !class94.field1617 && class139.field2168 == 4) {
                     var8 = class31.field732 + 5;
                     short var9 = 463;
                     byte var10 = 100;
                     byte var3 = 35;
                     if(class139.field2169 >= var8 && class139.field2169 <= var10 + var8 && class139.field2163 >= var9 && class139.field2163 <= var3 + var9) {
                        class19.method232();
                        return;
                     }
                  }

                  if(class216.field3156 != null) {
                     class19.method232();
                  }
               }

               var8 = class139.field2168;
               var1 = class139.field2169;
               var2 = class139.field2163;
               if(!class94.field1617 && var8 == 4) {
                  var8 = 1;
               }

               short var4;
               int var11;
               if(0 == class31.field722) {
                  var11 = 180 + class31.field738 - 80;
                  var4 = 291;
                  if(1 == var8 && var1 >= var11 - 75 && var1 <= 75 + var11 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                     class164.method3191(class135.method2838("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true);
                  }

                  var11 = class31.field738 + 180 + 80;
                  if(1 == var8 && var1 >= var11 - 75 && var1 <= 75 + var11 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                     if(0 != (client.field287 & 33554432)) {
                        class31.field711 = "";
                        class31.field728 = "This is a <col=00ffff>Tournament<col=ffffff> world.";
                        class31.field729 = "Max stats and high level gear are provided.";
                        class31.field720 = "Your normal account will not be affected.";
                        class31.field722 = 1;
                        class31.field735 = 0;
                     } else if((client.field287 & 4) != 0) {
                        if(0 != (client.field287 & 1024)) {
                           class31.field728 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class31.field729 = "Players can attack each other almost everywhere";
                           class31.field720 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class31.field728 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class31.field729 = "Players can attack each other";
                           class31.field720 = "almost everywhere.";
                        }

                        class31.field711 = "Warning!";
                        class31.field722 = 1;
                        class31.field735 = 0;
                     } else if(0 != (client.field287 & 1024)) {
                        class31.field728 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class31.field729 = "The Protect Item prayer will";
                        class31.field720 = "not work on this world.";
                        class31.field711 = "Warning!";
                        class31.field722 = 1;
                        class31.field735 = 0;
                     } else {
                        class31.field728 = "";
                        class31.field729 = "Enter your username/email & password.";
                        class31.field720 = "";
                        class31.field722 = 2;
                        class31.field735 = 0;
                     }
                  }
               } else if(class31.field722 != 1) {
                  short var12;
                  if(class31.field722 == 2) {
                     var12 = 231;
                     var11 = var12 + 30;
                     if(var8 == 1 && var2 >= var11 - 15 && var2 < var11) {
                        class31.field735 = 0;
                     }

                     var11 += 15;
                     if(1 == var8 && var2 >= var11 - 15 && var2 < var11) {
                        class31.field735 = 1;
                     }

                     var11 += 15;
                     var12 = 361;
                     if(var8 == 1 && var2 >= var12 - 15 && var2 < var12) {
                        class3.method32("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class31.field722 = 5;
                        return;
                     }

                     int var13 = class31.field738 + 180 - 80;
                     short var5 = 321;
                     if(var8 == 1 && var1 >= var13 - 75 && var1 <= 75 + var13 && var2 >= var5 - 20 && var2 <= var5 + 20) {
                        class31.field731 = class31.field731.trim();
                        if(class31.field731.length() == 0) {
                           class3.method32("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class31.field718.length() == 0) {
                           class3.method32("", "Please enter your password.", "");
                           return;
                        }

                        class3.method32("", "Connecting to server...", "");
                        class31.field733 = class10.field169.field145.containsKey(Integer.valueOf(class15.method179(class31.field731)))?class158.field2605:class158.field2607;
                        client.method556(20);
                        return;
                     }

                     var13 = 80 + class31.field738 + 180;
                     if(var8 == 1 && var1 >= var13 - 75 && var1 <= var13 + 75 && var2 >= var5 - 20 && var2 <= var5 + 20) {
                        class31.field722 = 0;
                        class31.field731 = "";
                        class31.field718 = "";
                        class1.field21 = 0;
                        class150.field2268 = "";
                        class31.field734 = true;
                     }

                     while(true) {
                        while(class190.method3703()) {
                           boolean var6 = false;

                           for(int var7 = 0; var7 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var7) {
                              if(class18.field254 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var7)) {
                                 var6 = true;
                                 break;
                              }
                           }

                           if(class3.field70 == 13) {
                              class31.field722 = 0;
                              class31.field731 = "";
                              class31.field718 = "";
                              class1.field21 = 0;
                              class150.field2268 = "";
                              class31.field734 = true;
                           } else if(class31.field735 == 0) {
                              if(85 == class3.field70 && class31.field731.length() > 0) {
                                 class31.field731 = class31.field731.substring(0, class31.field731.length() - 1);
                              }

                              if(84 == class3.field70 || class3.field70 == 80) {
                                 class31.field735 = 1;
                              }

                              if(var6 && class31.field731.length() < 320) {
                                 class31.field731 = class31.field731 + class18.field254;
                              }
                           } else if(1 == class31.field735) {
                              if(85 == class3.field70 && class31.field718.length() > 0) {
                                 class31.field718 = class31.field718.substring(0, class31.field718.length() - 1);
                              }

                              if(class3.field70 == 84 || class3.field70 == 80) {
                                 class31.field735 = 0;
                              }

                              if(class3.field70 == 84) {
                                 class31.field731 = class31.field731.trim();
                                 if(class31.field731.length() == 0) {
                                    class3.method32("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class31.field718.length() == 0) {
                                    class3.method32("", "Please enter your password.", "");
                                    return;
                                 }

                                 class3.method32("", "Connecting to server...", "");
                                 class31.field733 = class10.field169.field145.containsKey(Integer.valueOf(class15.method179(class31.field731)))?class158.field2605:class158.field2607;
                                 client.method556(20);
                                 return;
                              }

                              if(var6 && class31.field718.length() < 20) {
                                 class31.field718 = class31.field718 + class18.field254;
                              }
                           }
                        }

                        return;
                     }
                  } else if(class31.field722 == 3) {
                     var11 = 180 + class31.field738;
                     var4 = 276;
                     if(1 == var8 && var1 >= var11 - 75 && var1 <= 75 + var11 && var2 >= var4 - 20 && var2 <= 20 + var4) {
                        class31.field728 = "";
                        class31.field729 = "Enter your username/email & password.";
                        class31.field720 = "";
                        class31.field722 = 2;
                        class31.field735 = 0;
                     }

                     var11 = class31.field738 + 180;
                     var4 = 326;
                     if(1 == var8 && var1 >= var11 - 75 && var1 <= 75 + var11 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                        class3.method32("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class31.field722 = 5;
                        return;
                     }
                  } else {
                     boolean var14;
                     int var15;
                     if(4 == class31.field722) {
                        var11 = class31.field738 + 180 - 80;
                        var4 = 321;
                        if(1 == var8 && var1 >= var11 - 75 && var1 <= var11 + 75 && var2 >= var4 - 20 && var2 <= 20 + var4) {
                           class150.field2268.trim();
                           if(class150.field2268.length() != 6) {
                              class3.method32("", "Please enter a 6-digin PIN.", "");
                              return;
                           }

                           class1.field21 = Integer.parseInt(class150.field2268);
                           class150.field2268 = "";
                           class31.field733 = class31.field734?class158.field2609:class158.field2608;
                           class3.method32("", "Connecting to server...", "");
                           client.method556(20);
                           return;
                        }

                        if(1 == var8 && var1 >= 180 + class31.field738 - 9 && var1 <= 130 + class31.field738 + 180 && var2 >= 263 && var2 <= 296) {
                           class31.field734 = !class31.field734;
                        }

                        if(1 == var8 && var1 >= class31.field738 + 180 - 34 && var1 <= 180 + class31.field738 + 34 && var2 >= 351 && var2 <= 363) {
                           class164.method3191(class135.method2838("secure", true) + "m=totp-authenticator/disableTOTPRequest", true);
                        }

                        var11 = 180 + class31.field738 + 80;
                        if(var8 == 1 && var1 >= var11 - 75 && var1 <= var11 + 75 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                           class31.field722 = 0;
                           class31.field731 = "";
                           class31.field718 = "";
                           class1.field21 = 0;
                           class150.field2268 = "";
                        }

                        while(class190.method3703()) {
                           var14 = false;

                           for(var15 = 0; var15 < "1234567890".length(); ++var15) {
                              if(class18.field254 == "1234567890".charAt(var15)) {
                                 var14 = true;
                                 break;
                              }
                           }

                           if(13 == class3.field70) {
                              class31.field722 = 0;
                              class31.field731 = "";
                              class31.field718 = "";
                              class1.field21 = 0;
                              class150.field2268 = "";
                           } else {
                              if(85 == class3.field70 && class150.field2268.length() > 0) {
                                 class150.field2268 = class150.field2268.substring(0, class150.field2268.length() - 1);
                              }

                              if(84 == class3.field70) {
                                 class150.field2268.trim();
                                 if(class150.field2268.length() != 6) {
                                    class3.method32("", "Please enter a 6-digin PIN.", "");
                                    return;
                                 }

                                 class1.field21 = Integer.parseInt(class150.field2268);
                                 class150.field2268 = "";
                                 class31.field733 = class31.field734?class158.field2609:class158.field2608;
                                 class3.method32("", "Connecting to server...", "");
                                 client.method556(20);
                                 return;
                              }

                              if(var14 && class150.field2268.length() < 6) {
                                 class150.field2268 = class150.field2268 + class18.field254;
                              }
                           }
                        }
                     } else if(5 == class31.field722) {
                        var11 = 180 + class31.field738 - 80;
                        var4 = 321;
                        if(1 == var8 && var1 >= var11 - 75 && var1 <= var11 + 75 && var2 >= var4 - 20 && var2 <= 20 + var4) {
                           class120.method2679();
                           return;
                        }

                        var11 = class31.field738 + 180 + 80;
                        if(var8 == 1 && var1 >= var11 - 75 && var1 <= 75 + var11 && var2 >= var4 - 20 && var2 <= 20 + var4) {
                           class31.field728 = "";
                           class31.field729 = "Enter your username/email & password.";
                           class31.field720 = "";
                           class31.field722 = 2;
                           class31.field735 = 0;
                           class31.field718 = "";
                        }

                        while(class190.method3703()) {
                           var14 = false;

                           for(var15 = 0; var15 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var15) {
                              if(class18.field254 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var15)) {
                                 var14 = true;
                                 break;
                              }
                           }

                           if(class3.field70 == 13) {
                              class31.field728 = "";
                              class31.field729 = "Enter your username/email & password.";
                              class31.field720 = "";
                              class31.field722 = 2;
                              class31.field735 = 0;
                              class31.field718 = "";
                           } else {
                              if(85 == class3.field70 && class31.field731.length() > 0) {
                                 class31.field731 = class31.field731.substring(0, class31.field731.length() - 1);
                              }

                              if(84 == class3.field70) {
                                 class120.method2679();
                                 return;
                              }

                              if(var14 && class31.field731.length() < 320) {
                                 class31.field731 = class31.field731 + class18.field254;
                              }
                           }
                        }
                     } else if(6 == class31.field722) {
                        while(true) {
                           do {
                              if(!class190.method3703()) {
                                 var12 = 321;
                                 if(1 == var8 && var2 >= var12 - 20 && var2 <= var12 + 20) {
                                    class31.field728 = "";
                                    class31.field729 = "Enter your username/email & password.";
                                    class31.field720 = "";
                                    class31.field722 = 2;
                                    class31.field735 = 0;
                                    class31.field718 = "";
                                 }

                                 return;
                              }
                           } while(84 != class3.field70 && class3.field70 != 13);

                           class31.field728 = "";
                           class31.field729 = "Enter your username/email & password.";
                           class31.field720 = "";
                           class31.field722 = 2;
                           class31.field735 = 0;
                           class31.field718 = "";
                        }
                     }
                  }
               } else {
                  while(class190.method3703()) {
                     if(class3.field70 == 84) {
                        class31.field728 = "";
                        class31.field729 = "Enter your username/email & password.";
                        class31.field720 = "";
                        class31.field722 = 2;
                        class31.field735 = 0;
                     } else if(13 == class3.field70) {
                        class31.field722 = 0;
                     }
                  }

                  var11 = class31.field738 + 180 - 80;
                  var4 = 321;
                  if(var8 == 1 && var1 >= var11 - 75 && var1 <= var11 + 75 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                     class31.field728 = "";
                     class31.field729 = "Enter your username/email & password.";
                     class31.field720 = "";
                     class31.field722 = 2;
                     class31.field735 = 0;
                  }

                  var11 = 80 + class31.field738 + 180;
                  if(var8 == 1 && var1 >= var11 - 75 && var1 <= 75 + var11 && var2 >= var4 - 20 && var2 <= 20 + var4) {
                     class31.field722 = 0;
                  }
               }

            }
         }
      }
   }
}
