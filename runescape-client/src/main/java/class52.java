import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
public class class52 extends class207 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 496452033
   )
   public int field1142 = 0;
   @ObfuscatedName("w")
   public static class196 field1143 = new class196(64);
   @ObfuscatedName("o")
   public char field1145;
   @ObfuscatedName("g")
   public String field1146 = "null";
   @ObfuscatedName("e")
   public char field1147;
   @ObfuscatedName("m")
   public static class170 field1149;
   @ObfuscatedName("x")
   public int[] field1150;
   @ObfuscatedName("k")
   public String[] field1151;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1199909123
   )
   public int field1152;
   @ObfuscatedName("r")
   public int[] field1153;
   @ObfuscatedName("f")
   public static String[] field1154;
   @ObfuscatedName("z")
   public static String field1155;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "112"
   )
   public void method1099(class122 var1) {
      while(true) {
         int var2 = var1.method2556();
         if(var2 == 0) {
            return;
         }

         this.method1100(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "2008600662"
   )
   void method1100(class122 var1, int var2) {
      if(var2 == 1) {
         this.field1147 = (char)var1.method2556();
      } else if(var2 == 2) {
         this.field1145 = (char)var1.method2556();
      } else if(var2 == 3) {
         this.field1146 = var1.method2580();
      } else if(var2 == 4) {
         this.field1152 = var1.method2577();
      } else {
         int var3;
         if(var2 == 5) {
            this.field1142 = var1.method2706();
            this.field1153 = new int[this.field1142];
            this.field1151 = new String[this.field1142];

            for(var3 = 0; var3 < this.field1142; ++var3) {
               this.field1153[var3] = var1.method2577();
               this.field1151[var3] = var1.method2580();
            }
         } else if(var2 == 6) {
            this.field1142 = var1.method2706();
            this.field1153 = new int[this.field1142];
            this.field1150 = new int[this.field1142];

            for(var3 = 0; var3 < this.field1142; ++var3) {
               this.field1153[var3] = var1.method2577();
               this.field1150[var3] = var1.method2577();
            }
         }
      }

   }

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1570668247"
   )
   static final void method1109(String var0) {
      if(null != var0) {
         String var1 = class23.method579(var0, class134.field2117);
         if(null != var1) {
            for(int var2 = 0; var2 < client.field543; ++var2) {
               class7 var3 = client.field384[var2];
               String var4 = var3.field120;
               String var5 = class23.method579(var4, class134.field2117);
               if(class128.method2857(var0, var1, var4, var5)) {
                  --client.field543;

                  for(int var6 = var2; var6 < client.field543; ++var6) {
                     client.field384[var6] = client.field384[var6 + 1];
                  }

                  client.field548 = client.field455;
                  client.field313.method2797(81);
                  client.field313.method2557(class77.method1679(var0));
                  client.field313.method2563(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1358174534"
   )
   static final void method1110(int var0, int var1) {
      if(class9.field149 != var0 || var1 != class36.field803) {
         class9.field149 = var0;
         class36.field803 = var1;
         class171.method3414(25);
         class15.method175("Loading - please wait.", true);
         int var2 = class39.field838;
         int var3 = class13.field184;
         class39.field838 = (var0 - 6) * 8;
         class13.field184 = (var1 - 6) * 8;
         int var4 = class39.field838 - var2;
         int var5 = class13.field184 - var3;
         var2 = class39.field838;
         var3 = class13.field184;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            class36 var7 = client.field308[var6];
            if(null != var7) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var7.field885[var8] -= var4;
                  var7.field886[var8] -= var5;
               }

               var7.field864 -= var4 * 128;
               var7.field831 -= var5 * 128;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            class2 var20 = client.field393[var6];
            if(var20 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var20.field885[var8] -= var4;
                  var20.field886[var8] -= var5;
               }

               var20.field864 -= 128 * var4;
               var20.field831 -= var5 * 128;
            }
         }

         byte var19 = 0;
         byte var18 = 104;
         byte var21 = 1;
         if(var4 < 0) {
            var19 = 103;
            var18 = -1;
            var21 = -1;
         }

         byte var9 = 0;
         byte var10 = 104;
         byte var11 = 1;
         if(var5 < 0) {
            var9 = 103;
            var10 = -1;
            var11 = -1;
         }

         int var13;
         for(int var17 = var19; var18 != var17; var17 += var21) {
            for(var13 = var9; var10 != var13; var13 += var11) {
               int var14 = var4 + var17;
               int var15 = var13 + var5;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     client.field403[var16][var17][var13] = client.field403[var16][var14][var15];
                  } else {
                     client.field403[var16][var17][var13] = null;
                  }
               }
            }
         }

         for(class16 var12 = (class16)client.field369.method3882(); var12 != null; var12 = (class16)client.field369.method3891()) {
            var12.field209 -= var4;
            var12.field210 -= var5;
            if(var12.field209 < 0 || var12.field210 < 0 || var12.field209 >= 104 || var12.field210 >= 104) {
               var12.method3990();
            }
         }

         if(client.field504 != 0) {
            client.field504 -= var4;
            client.field464 -= var5;
         }

         client.field274 = 0;
         client.field518 = false;
         client.field410 = -1;
         client.field406.method3893();
         client.field405.method3893();

         for(var13 = 0; var13 < 4; ++var13) {
            client.field331[var13].method2479();
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass147;B)V",
      garbageValue = "2"
   )
   static void method1111(class147 var0) {
      if(class33.field728) {
         class36.method751(var0);
      } else {
         if((class143.field2224 == 1 || !class17.field235 && class143.field2224 == 4) && class143.field2220 >= 765 + class33.field730 - 50 && class143.field2222 >= 453) {
            class12.field162.field132 = !class12.field162.field132;
            class32.method679();
            if(!class12.field162.field132) {
               class175.method3440(class38.field814, "scape main", "", 255, false);
            } else {
               class46.method969();
            }
         }

         if(client.field280 != 5) {
            ++class33.field750;
            if(client.field280 == 10 || client.field280 == 11) {
               int var1;
               if(client.field533 == 0) {
                  if(class143.field2224 == 1 || !class17.field235 && class143.field2224 == 4) {
                     var1 = class33.field730 + 5;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(class143.field2220 >= var1 && class143.field2220 <= var3 + var1 && class143.field2222 >= var2 && class143.field2222 <= var2 + var4) {
                        if(class17.method186()) {
                           class33.field728 = true;
                        }

                        return;
                     }
                  }

                  if(null != class224.field3228 && class17.method186()) {
                     class33.field728 = true;
                  }
               }

               var1 = class143.field2224;
               int var10 = class143.field2220;
               int var11 = class143.field2222;
               if(!class17.field235 && var1 == 4) {
                  var1 = 1;
               }

               short var5;
               String var6;
               int var12;
               if(class33.field759 == 0) {
                  var12 = 180 + class33.field733 - 80;
                  var5 = 291;
                  if(var1 == 1 && var10 >= var12 - 75 && var10 <= 75 + var12 && var11 >= var5 - 20 && var11 <= var5 + 20) {
                     var6 = class177.method3494("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws";
                     class157.method3211(var6, true, "openjs", false);
                  }

                  var12 = 180 + class33.field733 + 80;
                  if(var1 == 1 && var10 >= var12 - 75 && var10 <= var12 + 75 && var11 >= var5 - 20 && var11 <= var5 + 20) {
                     if((client.field480 & 33554432) != 0) {
                        class33.field748 = "";
                        class33.field729 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class33.field738 = "Your normal account will not be affected.";
                        class33.field751 = "";
                        class33.field759 = 1;
                        class33.field754 = 0;
                     } else if((client.field480 & 4) != 0) {
                        if((client.field480 & 1024) != 0) {
                           class33.field729 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class33.field738 = "Players can attack each other almost everywhere";
                           class33.field751 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class33.field729 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class33.field738 = "Players can attack each other";
                           class33.field751 = "almost everywhere.";
                        }

                        class33.field748 = "Warning!";
                        class33.field759 = 1;
                        class33.field754 = 0;
                     } else if((client.field480 & 1024) != 0) {
                        class33.field729 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class33.field738 = "The Protect Item prayer will";
                        class33.field751 = "not work on this world.";
                        class33.field748 = "Warning!";
                        class33.field759 = 1;
                        class33.field754 = 0;
                     } else {
                        class33.field729 = "";
                        class33.field738 = "Enter your username/email & password.";
                        class33.field751 = "";
                        class33.field759 = 2;
                        class33.field754 = 0;
                     }
                  }
               } else if(class33.field759 != 1) {
                  short var13;
                  if(class33.field759 == 2) {
                     var13 = 231;
                     var12 = var13 + 30;
                     if(var1 == 1 && var11 >= var12 - 15 && var11 < var12) {
                        class33.field754 = 0;
                     }

                     var12 += 15;
                     if(var1 == 1 && var11 >= var12 - 15 && var11 < var12) {
                        class33.field754 = 1;
                     }

                     var12 += 15;
                     var13 = 361;
                     if(var1 == 1 && var11 >= var13 - 15 && var11 < var13) {
                        class126.method2836("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class33.field759 = 5;
                        return;
                     }

                     int var14 = class33.field733 + 180 - 80;
                     short var9 = 321;
                     if(var1 == 1 && var10 >= var14 - 75 && var10 <= var14 + 75 && var11 >= var9 - 20 && var11 <= 20 + var9) {
                        class33.field758 = class33.field758.trim();
                        if(class33.field758.length() == 0) {
                           class126.method2836("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class33.field735.length() == 0) {
                           class126.method2836("", "Please enter your password.", "");
                           return;
                        }

                        class126.method2836("", "Connecting to server...", "");
                        class33.field753 = class12.field162.field126.containsKey(Integer.valueOf(class130.method2876(class33.field758)))?class162.field2665:class162.field2658;
                        class171.method3414(20);
                        return;
                     }

                     var14 = 80 + class33.field733 + 180;
                     if(var1 == 1 && var10 >= var14 - 75 && var10 <= var14 + 75 && var11 >= var9 - 20 && var11 <= var9 + 20) {
                        class33.field759 = 0;
                        class33.field758 = "";
                        class33.field735 = "";
                        class17.field232 = 0;
                        class33.field760 = "";
                        class33.field749 = true;
                     }

                     while(true) {
                        while(class0.method0()) {
                           boolean var7 = false;

                           for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                              if(class48.field1079 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                 var7 = true;
                                 break;
                              }
                           }

                           if(class139.field2152 == 13) {
                              class33.field759 = 0;
                              class33.field758 = "";
                              class33.field735 = "";
                              class17.field232 = 0;
                              class33.field760 = "";
                              class33.field749 = true;
                           } else if(class33.field754 == 0) {
                              if(class139.field2152 == 85 && class33.field758.length() > 0) {
                                 class33.field758 = class33.field758.substring(0, class33.field758.length() - 1);
                              }

                              if(class139.field2152 == 84 || class139.field2152 == 80) {
                                 class33.field754 = 1;
                              }

                              if(var7 && class33.field758.length() < 320) {
                                 class33.field758 = class33.field758 + class48.field1079;
                              }
                           } else if(class33.field754 == 1) {
                              if(class139.field2152 == 85 && class33.field735.length() > 0) {
                                 class33.field735 = class33.field735.substring(0, class33.field735.length() - 1);
                              }

                              if(class139.field2152 == 84 || class139.field2152 == 80) {
                                 class33.field754 = 0;
                              }

                              if(class139.field2152 == 84) {
                                 class33.field758 = class33.field758.trim();
                                 if(class33.field758.length() == 0) {
                                    class126.method2836("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class33.field735.length() == 0) {
                                    class126.method2836("", "Please enter your password.", "");
                                    return;
                                 }

                                 class126.method2836("", "Connecting to server...", "");
                                 class33.field753 = class12.field162.field126.containsKey(Integer.valueOf(class130.method2876(class33.field758)))?class162.field2665:class162.field2658;
                                 class171.method3414(20);
                                 return;
                              }

                              if(var7 && class33.field735.length() < 20) {
                                 class33.field735 = class33.field735 + class48.field1079;
                              }
                           }
                        }

                        return;
                     }
                  } else if(class33.field759 == 3) {
                     var12 = class33.field733 + 180;
                     var5 = 276;
                     if(var1 == 1 && var10 >= var12 - 75 && var10 <= var12 + 75 && var11 >= var5 - 20 && var11 <= 20 + var5) {
                        class33.field729 = "";
                        class33.field738 = "Enter your username/email & password.";
                        class33.field751 = "";
                        class33.field759 = 2;
                        class33.field754 = 0;
                     }

                     var12 = class33.field733 + 180;
                     var5 = 326;
                     if(var1 == 1 && var10 >= var12 - 75 && var10 <= var12 + 75 && var11 >= var5 - 20 && var11 <= var5 + 20) {
                        class126.method2836("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class33.field759 = 5;
                        return;
                     }
                  } else {
                     int var15;
                     boolean var16;
                     if(class33.field759 == 4) {
                        var12 = class33.field733 + 180 - 80;
                        var5 = 321;
                        if(var1 == 1 && var10 >= var12 - 75 && var10 <= var12 + 75 && var11 >= var5 - 20 && var11 <= 20 + var5) {
                           class33.field760.trim();
                           if(class33.field760.length() != 6) {
                              class126.method2836("", "Please enter a 6-digin PIN.", "");
                              return;
                           }

                           class17.field232 = Integer.parseInt(class33.field760);
                           class33.field760 = "";
                           class33.field753 = class33.field749?class162.field2662:class162.field2659;
                           class126.method2836("", "Connecting to server...", "");
                           class171.method3414(20);
                           return;
                        }

                        if(var1 == 1 && var10 >= class33.field733 + 180 - 9 && var10 <= 130 + class33.field733 + 180 && var11 >= 263 && var11 <= 296) {
                           class33.field749 = !class33.field749;
                        }

                        if(var1 == 1 && var10 >= 180 + class33.field733 - 34 && var10 <= 34 + 180 + class33.field733 && var11 >= 351 && var11 <= 363) {
                           var6 = class177.method3494("secure", true) + "m=totp-authenticator/disableTOTPRequest";
                           class157.method3211(var6, true, "openjs", false);
                        }

                        var12 = 80 + 180 + class33.field733;
                        if(var1 == 1 && var10 >= var12 - 75 && var10 <= 75 + var12 && var11 >= var5 - 20 && var11 <= var5 + 20) {
                           class33.field759 = 0;
                           class33.field758 = "";
                           class33.field735 = "";
                           class17.field232 = 0;
                           class33.field760 = "";
                        }

                        while(class0.method0()) {
                           var16 = false;

                           for(var15 = 0; var15 < "1234567890".length(); ++var15) {
                              if(class48.field1079 == "1234567890".charAt(var15)) {
                                 var16 = true;
                                 break;
                              }
                           }

                           if(class139.field2152 == 13) {
                              class33.field759 = 0;
                              class33.field758 = "";
                              class33.field735 = "";
                              class17.field232 = 0;
                              class33.field760 = "";
                           } else {
                              if(class139.field2152 == 85 && class33.field760.length() > 0) {
                                 class33.field760 = class33.field760.substring(0, class33.field760.length() - 1);
                              }

                              if(class139.field2152 == 84) {
                                 class33.field760.trim();
                                 if(class33.field760.length() != 6) {
                                    class126.method2836("", "Please enter a 6-digin PIN.", "");
                                    return;
                                 }

                                 class17.field232 = Integer.parseInt(class33.field760);
                                 class33.field760 = "";
                                 class33.field753 = class33.field749?class162.field2662:class162.field2659;
                                 class126.method2836("", "Connecting to server...", "");
                                 class171.method3414(20);
                                 return;
                              }

                              if(var16 && class33.field760.length() < 6) {
                                 class33.field760 = class33.field760 + class48.field1079;
                              }
                           }
                        }
                     } else if(class33.field759 == 5) {
                        var12 = 180 + class33.field733 - 80;
                        var5 = 321;
                        if(var1 == 1 && var10 >= var12 - 75 && var10 <= var12 + 75 && var11 >= var5 - 20 && var11 <= 20 + var5) {
                           class126.method2835();
                           return;
                        }

                        var12 = 80 + 180 + class33.field733;
                        if(var1 == 1 && var10 >= var12 - 75 && var10 <= 75 + var12 && var11 >= var5 - 20 && var11 <= var5 + 20) {
                           class33.field729 = "";
                           class33.field738 = "Enter your username/email & password.";
                           class33.field751 = "";
                           class33.field759 = 2;
                           class33.field754 = 0;
                           class33.field735 = "";
                        }

                        while(class0.method0()) {
                           var16 = false;

                           for(var15 = 0; var15 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var15) {
                              if(class48.field1079 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var15)) {
                                 var16 = true;
                                 break;
                              }
                           }

                           if(class139.field2152 == 13) {
                              class33.field729 = "";
                              class33.field738 = "Enter your username/email & password.";
                              class33.field751 = "";
                              class33.field759 = 2;
                              class33.field754 = 0;
                              class33.field735 = "";
                           } else {
                              if(class139.field2152 == 85 && class33.field758.length() > 0) {
                                 class33.field758 = class33.field758.substring(0, class33.field758.length() - 1);
                              }

                              if(class139.field2152 == 84) {
                                 class126.method2835();
                                 return;
                              }

                              if(var16 && class33.field758.length() < 320) {
                                 class33.field758 = class33.field758 + class48.field1079;
                              }
                           }
                        }
                     } else if(class33.field759 == 6) {
                        while(true) {
                           do {
                              if(!class0.method0()) {
                                 var13 = 321;
                                 if(var1 == 1 && var11 >= var13 - 20 && var11 <= var13 + 20) {
                                    class33.field729 = "";
                                    class33.field738 = "Enter your username/email & password.";
                                    class33.field751 = "";
                                    class33.field759 = 2;
                                    class33.field754 = 0;
                                    class33.field735 = "";
                                 }

                                 return;
                              }
                           } while(class139.field2152 != 84 && class139.field2152 != 13);

                           class33.field729 = "";
                           class33.field738 = "Enter your username/email & password.";
                           class33.field751 = "";
                           class33.field759 = 2;
                           class33.field754 = 0;
                           class33.field735 = "";
                        }
                     }
                  }
               } else {
                  while(class0.method0()) {
                     if(class139.field2152 == 84) {
                        class33.field729 = "";
                        class33.field738 = "Enter your username/email & password.";
                        class33.field751 = "";
                        class33.field759 = 2;
                        class33.field754 = 0;
                     } else if(class139.field2152 == 13) {
                        class33.field759 = 0;
                     }
                  }

                  var12 = 180 + class33.field733 - 80;
                  var5 = 321;
                  if(var1 == 1 && var10 >= var12 - 75 && var10 <= var12 + 75 && var11 >= var5 - 20 && var11 <= 20 + var5) {
                     class33.field729 = "";
                     class33.field738 = "Enter your username/email & password.";
                     class33.field751 = "";
                     class33.field759 = 2;
                     class33.field754 = 0;
                  }

                  var12 = class33.field733 + 180 + 80;
                  if(var1 == 1 && var10 >= var12 - 75 && var10 <= 75 + var12 && var11 >= var5 - 20 && var11 <= var5 + 20) {
                     class33.field759 = 0;
                  }
               }

            }
         }
      }
   }
}
