import java.io.IOException;
import java.util.HashMap;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
public class class109 {
   @ObfuscatedName("qe")
   protected static class133 field1888;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1536987945
   )
   public static int field1890;

   static {
      new HashMap();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "0"
   )
   public static Object method2426(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !class125.field2026) {
            try {
               class118 var2 = new class118();
               var2.vmethod2827(var0);
               return var2;
            } catch (Throwable var3) {
               class125.field2026 = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass144;I)V",
      garbageValue = "600857563"
   )
   static void method2429(class144 var0) {
      if(class31.field727) {
         class84.method1908(var0);
      } else {
         if((class140.field2140 == 1 || !class161.field2631 && class140.field2140 == 4) && class140.field2141 >= class31.field695 + 765 - 50 && class140.field2142 >= 453) {
            class162.field2637.field128 = !class162.field2637.field128;
            class8.method96();
            if(!class162.field2637.field128) {
               class171.method3388(client.field358, "scape main", "", 255, false);
            } else {
               class183.field2952.method3614();
               class183.field2953 = 1;
               class50.field1075 = null;
            }
         }

         if(client.field294 != 5) {
            ++class31.field697;
            if(client.field294 == 10 || client.field294 == 11) {
               int var1;
               if(client.field292 == 0) {
                  if(class140.field2140 == 1 || !class161.field2631 && class140.field2140 == 4) {
                     var1 = class31.field695 + 5;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(class140.field2141 >= var1 && class140.field2141 <= var3 + var1 && class140.field2142 >= var2 && class140.field2142 <= var4 + var2) {
                        if(class85.method1923()) {
                           class31.field727 = true;
                        }

                        return;
                     }
                  }

                  if(class155.field2283 != null && class85.method1923()) {
                     class31.field727 = true;
                  }
               }

               var1 = class140.field2140;
               int var10 = class140.field2141;
               int var11 = class140.field2142;
               if(!class161.field2631 && var1 == 4) {
                  var1 = 1;
               }

               short var5;
               String var9;
               int var12;
               if(class31.field715 == 0) {
                  var12 = class31.field711 + 180 - 80;
                  var5 = 291;
                  if(var1 == 1 && var10 >= var12 - 75 && var10 <= var12 + 75 && var11 >= var5 - 20 && var11 <= var5 + 20) {
                     var9 = class174.method3451("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws";
                     class8.method111(var9, true, "openjs", false);
                  }

                  var12 = class31.field711 + 180 + 80;
                  if(var1 == 1 && var10 >= var12 - 75 && var10 <= 75 + var12 && var11 >= var5 - 20 && var11 <= 20 + var5) {
                     if((client.field477 & 33554432) != 0) {
                        class31.field705 = "";
                        class31.field717 = "This is a <col=00ffff>Tournament<col=ffffff> world.";
                        class31.field718 = "Max stats and high level gear are provided.";
                        class31.field719 = "Your normal account will not be affected.";
                        class31.field715 = 1;
                        class31.field724 = 0;
                     } else if((client.field477 & 4) != 0) {
                        if((client.field477 & 1024) != 0) {
                           class31.field717 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class31.field718 = "Players can attack each other almost everywhere";
                           class31.field719 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class31.field717 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class31.field718 = "Players can attack each other";
                           class31.field719 = "almost everywhere.";
                        }

                        class31.field705 = "Warning!";
                        class31.field715 = 1;
                        class31.field724 = 0;
                     } else if((client.field477 & 1024) != 0) {
                        class31.field717 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class31.field718 = "The Protect Item prayer will";
                        class31.field719 = "not work on this world.";
                        class31.field705 = "Warning!";
                        class31.field715 = 1;
                        class31.field724 = 0;
                     } else {
                        class31.field717 = "";
                        class31.field718 = "Enter your username/email & password.";
                        class31.field719 = "";
                        class31.field715 = 2;
                        class31.field724 = 0;
                     }
                  }
               } else if(class31.field715 != 1) {
                  short var13;
                  if(class31.field715 == 2) {
                     var13 = 231;
                     var12 = var13 + 30;
                     if(var1 == 1 && var11 >= var12 - 15 && var11 < var12) {
                        class31.field724 = 0;
                     }

                     var12 += 15;
                     if(var1 == 1 && var11 >= var12 - 15 && var11 < var12) {
                        class31.field724 = 1;
                     }

                     var12 += 15;
                     var13 = 361;
                     if(var1 == 1 && var11 >= var13 - 15 && var11 < var13) {
                        class12.method152("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class31.field715 = 5;
                        return;
                     }

                     int var14 = class31.field711 + 180 - 80;
                     short var6 = 321;
                     if(var1 == 1 && var10 >= var14 - 75 && var10 <= 75 + var14 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                        class31.field726 = class31.field726.trim();
                        if(class31.field726.length() == 0) {
                           class12.method152("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class31.field716.length() == 0) {
                           class12.method152("", "Please enter your password.", "");
                           return;
                        }

                        class12.method152("", "Connecting to server...", "");
                        class31.field722 = class162.field2637.field133.containsKey(Integer.valueOf(class52.method1080(class31.field726)))?class159.field2591:class159.field2594;
                        class43.method919(20);
                        return;
                     }

                     var14 = 80 + class31.field711 + 180;
                     if(var1 == 1 && var10 >= var14 - 75 && var10 <= var14 + 75 && var11 >= var6 - 20 && var11 <= 20 + var6) {
                        class31.field715 = 0;
                        class31.field726 = "";
                        class31.field716 = "";
                        class38.field854 = 0;
                        class170.field2705 = "";
                        class31.field723 = true;
                     }

                     while(true) {
                        while(class95.method2192()) {
                           boolean var7 = false;

                           for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                              if(class25.field644 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                 var7 = true;
                                 break;
                              }
                           }

                           if(class10.field158 == 13) {
                              class31.field715 = 0;
                              class31.field726 = "";
                              class31.field716 = "";
                              class38.field854 = 0;
                              class170.field2705 = "";
                              class31.field723 = true;
                           } else if(class31.field724 == 0) {
                              if(class10.field158 == 85 && class31.field726.length() > 0) {
                                 class31.field726 = class31.field726.substring(0, class31.field726.length() - 1);
                              }

                              if(class10.field158 == 84 || class10.field158 == 80) {
                                 class31.field724 = 1;
                              }

                              if(var7 && class31.field726.length() < 320) {
                                 class31.field726 = class31.field726 + class25.field644;
                              }
                           } else if(class31.field724 == 1) {
                              if(class10.field158 == 85 && class31.field716.length() > 0) {
                                 class31.field716 = class31.field716.substring(0, class31.field716.length() - 1);
                              }

                              if(class10.field158 == 84 || class10.field158 == 80) {
                                 class31.field724 = 0;
                              }

                              if(class10.field158 == 84) {
                                 class31.field726 = class31.field726.trim();
                                 if(class31.field726.length() == 0) {
                                    class12.method152("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class31.field716.length() == 0) {
                                    class12.method152("", "Please enter your password.", "");
                                    return;
                                 }

                                 class12.method152("", "Connecting to server...", "");
                                 class31.field722 = class162.field2637.field133.containsKey(Integer.valueOf(class52.method1080(class31.field726)))?class159.field2591:class159.field2594;
                                 class43.method919(20);
                                 return;
                              }

                              if(var7 && class31.field716.length() < 20) {
                                 class31.field716 = class31.field716 + class25.field644;
                              }
                           }
                        }

                        return;
                     }
                  } else if(class31.field715 == 3) {
                     var12 = 180 + class31.field711;
                     var5 = 276;
                     if(var1 == 1 && var10 >= var12 - 75 && var10 <= var12 + 75 && var11 >= var5 - 20 && var11 <= var5 + 20) {
                        class31.field717 = "";
                        class31.field718 = "Enter your username/email & password.";
                        class31.field719 = "";
                        class31.field715 = 2;
                        class31.field724 = 0;
                     }

                     var12 = 180 + class31.field711;
                     var5 = 326;
                     if(var1 == 1 && var10 >= var12 - 75 && var10 <= var12 + 75 && var11 >= var5 - 20 && var11 <= 20 + var5) {
                        class12.method152("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class31.field715 = 5;
                        return;
                     }
                  } else {
                     boolean var15;
                     int var16;
                     if(class31.field715 == 4) {
                        var12 = 180 + class31.field711 - 80;
                        var5 = 321;
                        if(var1 == 1 && var10 >= var12 - 75 && var10 <= 75 + var12 && var11 >= var5 - 20 && var11 <= 20 + var5) {
                           class170.field2705.trim();
                           if(class170.field2705.length() != 6) {
                              class12.method152("", "Please enter a 6-digin PIN.", "");
                              return;
                           }

                           class38.field854 = Integer.parseInt(class170.field2705);
                           class170.field2705 = "";
                           class31.field722 = class31.field723?class159.field2590:class159.field2592;
                           class12.method152("", "Connecting to server...", "");
                           class43.method919(20);
                           return;
                        }

                        if(var1 == 1 && var10 >= class31.field711 + 180 - 9 && var10 <= 130 + 180 + class31.field711 && var11 >= 263 && var11 <= 296) {
                           class31.field723 = !class31.field723;
                        }

                        if(var1 == 1 && var10 >= class31.field711 + 180 - 34 && var10 <= 34 + 180 + class31.field711 && var11 >= 351 && var11 <= 363) {
                           var9 = class174.method3451("secure", true) + "m=totp-authenticator/disableTOTPRequest";
                           class8.method111(var9, true, "openjs", false);
                        }

                        var12 = class31.field711 + 180 + 80;
                        if(var1 == 1 && var10 >= var12 - 75 && var10 <= 75 + var12 && var11 >= var5 - 20 && var11 <= var5 + 20) {
                           class31.field715 = 0;
                           class31.field726 = "";
                           class31.field716 = "";
                           class38.field854 = 0;
                           class170.field2705 = "";
                        }

                        while(class95.method2192()) {
                           var15 = false;

                           for(var16 = 0; var16 < "1234567890".length(); ++var16) {
                              if(class25.field644 == "1234567890".charAt(var16)) {
                                 var15 = true;
                                 break;
                              }
                           }

                           if(class10.field158 == 13) {
                              class31.field715 = 0;
                              class31.field726 = "";
                              class31.field716 = "";
                              class38.field854 = 0;
                              class170.field2705 = "";
                           } else {
                              if(class10.field158 == 85 && class170.field2705.length() > 0) {
                                 class170.field2705 = class170.field2705.substring(0, class170.field2705.length() - 1);
                              }

                              if(class10.field158 == 84) {
                                 class170.field2705.trim();
                                 if(class170.field2705.length() != 6) {
                                    class12.method152("", "Please enter a 6-digin PIN.", "");
                                    return;
                                 }

                                 class38.field854 = Integer.parseInt(class170.field2705);
                                 class170.field2705 = "";
                                 class31.field722 = class31.field723?class159.field2590:class159.field2592;
                                 class12.method152("", "Connecting to server...", "");
                                 class43.method919(20);
                                 return;
                              }

                              if(var15 && class170.field2705.length() < 6) {
                                 class170.field2705 = class170.field2705 + class25.field644;
                              }
                           }
                        }
                     } else if(class31.field715 == 5) {
                        var12 = 180 + class31.field711 - 80;
                        var5 = 321;
                        if(var1 == 1 && var10 >= var12 - 75 && var10 <= 75 + var12 && var11 >= var5 - 20 && var11 <= 20 + var5) {
                           class24.method593();
                           return;
                        }

                        var12 = 80 + class31.field711 + 180;
                        if(var1 == 1 && var10 >= var12 - 75 && var10 <= var12 + 75 && var11 >= var5 - 20 && var11 <= 20 + var5) {
                           class31.field717 = "";
                           class31.field718 = "Enter your username/email & password.";
                           class31.field719 = "";
                           class31.field715 = 2;
                           class31.field724 = 0;
                           class31.field716 = "";
                        }

                        while(class95.method2192()) {
                           var15 = false;

                           for(var16 = 0; var16 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var16) {
                              if(class25.field644 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var16)) {
                                 var15 = true;
                                 break;
                              }
                           }

                           if(class10.field158 == 13) {
                              class31.field717 = "";
                              class31.field718 = "Enter your username/email & password.";
                              class31.field719 = "";
                              class31.field715 = 2;
                              class31.field724 = 0;
                              class31.field716 = "";
                           } else {
                              if(class10.field158 == 85 && class31.field726.length() > 0) {
                                 class31.field726 = class31.field726.substring(0, class31.field726.length() - 1);
                              }

                              if(class10.field158 == 84) {
                                 class24.method593();
                                 return;
                              }

                              if(var15 && class31.field726.length() < 320) {
                                 class31.field726 = class31.field726 + class25.field644;
                              }
                           }
                        }
                     } else if(class31.field715 == 6) {
                        while(true) {
                           do {
                              if(!class95.method2192()) {
                                 var13 = 321;
                                 if(var1 == 1 && var11 >= var13 - 20 && var11 <= 20 + var13) {
                                    class31.field717 = "";
                                    class31.field718 = "Enter your username/email & password.";
                                    class31.field719 = "";
                                    class31.field715 = 2;
                                    class31.field724 = 0;
                                    class31.field716 = "";
                                 }

                                 return;
                              }
                           } while(class10.field158 != 84 && class10.field158 != 13);

                           class31.field717 = "";
                           class31.field718 = "Enter your username/email & password.";
                           class31.field719 = "";
                           class31.field715 = 2;
                           class31.field724 = 0;
                           class31.field716 = "";
                        }
                     }
                  }
               } else {
                  while(class95.method2192()) {
                     if(class10.field158 == 84) {
                        class31.field717 = "";
                        class31.field718 = "Enter your username/email & password.";
                        class31.field719 = "";
                        class31.field715 = 2;
                        class31.field724 = 0;
                     } else if(class10.field158 == 13) {
                        class31.field715 = 0;
                     }
                  }

                  var12 = class31.field711 + 180 - 80;
                  var5 = 321;
                  if(var1 == 1 && var10 >= var12 - 75 && var10 <= var12 + 75 && var11 >= var5 - 20 && var11 <= 20 + var5) {
                     class31.field717 = "";
                     class31.field718 = "Enter your username/email & password.";
                     class31.field719 = "";
                     class31.field715 = 2;
                     class31.field724 = 0;
                  }

                  var12 = 80 + class31.field711 + 180;
                  if(var1 == 1 && var10 >= var12 - 75 && var10 <= var12 + 75 && var11 >= var5 - 20 && var11 <= var5 + 20) {
                     class31.field715 = 0;
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1464714645"
   )
   public static void method2430() {
      class40.field902.method3755();
      class40.field901.method3755();
      class40.field934.method3755();
      class40.field941.method3755();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-296976988"
   )
   public static int method2431(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class39.method797(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-183225769"
   )
   public static boolean method2432() {
      long var0 = class90.method2090();
      int var2 = (int)(var0 - class229.field3231);
      class229.field3231 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class171.field2709 += var2;
      if(class171.field2718 == 0 && class171.field2713 == 0 && class171.field2716 == 0 && class171.field2711 == 0) {
         return true;
      } else if(class171.field2719 == null) {
         return false;
      } else {
         try {
            if(class171.field2709 > 30000) {
               throw new IOException();
            } else {
               class172 var3;
               class119 var4;
               while(class171.field2713 < 20 && class171.field2711 > 0) {
                  var3 = (class172)class171.field2720.method3799();
                  var4 = new class119(4);
                  var4.method2650(1);
                  var4.method2501((int)var3.field3113);
                  class171.field2719.method3020(var4.field1982, 0, 4);
                  class171.field2712.method3797(var3, var3.field3113);
                  --class171.field2711;
                  ++class171.field2713;
               }

               while(class171.field2718 < 20 && class171.field2716 > 0) {
                  var3 = (class172)class171.field2728.method3885();
                  var4 = new class119(4);
                  var4.method2650(0);
                  var4.method2501((int)var3.field3113);
                  class171.field2719.method3020(var4.field1982, 0, 4);
                  var3.method3889();
                  class171.field2717.method3797(var3, var3.field3113);
                  --class171.field2716;
                  ++class171.field2718;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class171.field2719.method3018();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class171.field2709 = 0;
                  byte var5 = 0;
                  if(null == class137.field2099) {
                     var5 = 8;
                  } else if(class171.field2721 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class171.field2726.field1976;
                     if(var6 > var16) {
                        var6 = var16;
                     }

                     class171.field2719.method3019(class171.field2726.field1982, class171.field2726.field1976, var6);
                     if(class171.field2724 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class171.field2726.field1982[class171.field2726.field1976 + var7] ^= class171.field2724;
                        }
                     }

                     class171.field2726.field1976 += var6;
                     if(class171.field2726.field1976 < var5) {
                        break;
                     }

                     if(class137.field2099 == null) {
                        class171.field2726.field1976 = 0;
                        var7 = class171.field2726.method2514();
                        var8 = class171.field2726.method2516();
                        int var9 = class171.field2726.method2514();
                        var10 = class171.field2726.method2519();
                        long var11 = (long)(var8 + (var7 << 16));
                        class172 var13 = (class172)class171.field2712.method3807(var11);
                        class171.field2708 = true;
                        if(var13 == null) {
                           var13 = (class172)class171.field2717.method3807(var11);
                           class171.field2708 = false;
                        }

                        if(var13 == null) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0?5:9;
                        class137.field2099 = var13;
                        class75.field1348 = new class119(var10 + var14 + class137.field2099.field2734);
                        class75.field1348.method2650(var9);
                        class75.field1348.method2502(var10);
                        class171.field2721 = 8;
                        class171.field2726.field1976 = 0;
                     } else if(class171.field2721 == 0) {
                        if(class171.field2726.field1982[0] == -1) {
                           class171.field2721 = 1;
                           class171.field2726.field1976 = 0;
                        } else {
                           class137.field2099 = null;
                        }
                     }
                  } else {
                     var6 = class75.field1348.field1982.length - class137.field2099.field2734;
                     var7 = 512 - class171.field2721;
                     if(var7 > var6 - class75.field1348.field1976) {
                        var7 = var6 - class75.field1348.field1976;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class171.field2719.method3019(class75.field1348.field1982, class75.field1348.field1976, var7);
                     if(class171.field2724 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           class75.field1348.field1982[var8 + class75.field1348.field1976] ^= class171.field2724;
                        }
                     }

                     class75.field1348.field1976 += var7;
                     class171.field2721 += var7;
                     if(var6 == class75.field1348.field1976) {
                        if(16711935L == class137.field2099.field3113) {
                           class14.field214 = class75.field1348;

                           for(var8 = 0; var8 < 256; ++var8) {
                              class168 var17 = class171.field2723[var8];
                              if(null != var17) {
                                 class14.field214.field1976 = 8 * var8 + 5;
                                 var10 = class14.field214.method2519();
                                 int var21 = class14.field214.method2519();
                                 var17.method3348(var10, var21);
                              }
                           }
                        } else {
                           class171.field2722.reset();
                           class171.field2722.update(class75.field1348.field1982, 0, var6);
                           var8 = (int)class171.field2722.getValue();
                           if(var8 != class137.field2099.field2736) {
                              try {
                                 class171.field2719.method3025();
                              } catch (Exception var19) {
                                 ;
                              }

                              ++class171.field2725;
                              class171.field2719 = null;
                              class171.field2724 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class171.field2725 = 0;
                           class171.field2710 = 0;
                           class137.field2099.field2733.method3351((int)(class137.field2099.field3113 & 65535L), class75.field1348.field1982, (class137.field2099.field3113 & 16711680L) == 16711680L, class171.field2708);
                        }

                        class137.field2099.method3916();
                        if(class171.field2708) {
                           --class171.field2713;
                        } else {
                           --class171.field2718;
                        }

                        class171.field2721 = 0;
                        class137.field2099 = null;
                        class75.field1348 = null;
                     } else {
                        if(class171.field2721 != 512) {
                           break;
                        }

                        class171.field2721 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var20) {
            try {
               class171.field2719.method3025();
            } catch (Exception var18) {
               ;
            }

            ++class171.field2710;
            class171.field2719 = null;
            return false;
         }
      }
   }
}
