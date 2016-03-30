import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class41 extends class204 {
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = -1372192149
   )
   static int field980;
   @ObfuscatedName("x")
   static class193 field981 = new class193(64);
   @ObfuscatedName("w")
   static class167 field982;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1646947451
   )
   public int field983;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2003791971
   )
   public int field984;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 443078005
   )
   public int field985;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 851160215
   )
   public int field986;
   @ObfuscatedName("dw")
   static byte[][] field987;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 636742529
   )
   int field988 = 0;
   @ObfuscatedName("pf")
   static class8 field989;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = -134749931
   )
   @Export("baseX")
   static int field990;

   @ObfuscatedName("t")
   void method875() {
      this.method892(this.field988);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-426849475"
   )
   void method877(class119 var1) {
      while(true) {
         int var2 = var1.method2506();
         if(0 == var2) {
            return;
         }

         this.method878(var1, var2);
      }
   }

   @ObfuscatedName("e")
   void method878(class119 var1, int var2) {
      if(var2 == 1) {
         this.field988 = var1.method2510();
      }

   }

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1922684587"
   )
   static final void method886(String var0) {
      if(null != class8.field162) {
         client.field318.method2757(147);
         client.field318.method2573(class45.method992(var0));
         client.field318.method2661(var0);
      }
   }

   @ObfuscatedName("j")
   static final int method887(int var0, int var1) {
      int var2 = class19.method209(var0 - 1, var1 - 1) + class19.method209(1 + var0, var1 - 1) + class19.method209(var0 - 1, 1 + var1) + class19.method209(1 + var0, 1 + var1);
      int var3 = class19.method209(var0 - 1, var1) + class19.method209(var0 + 1, var1) + class19.method209(var0, var1 - 1) + class19.method209(var0, var1 + 1);
      int var4 = class19.method209(var0, var1);
      return var4 / 4 + var3 / 8 + var2 / 16;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "247386058"
   )
   void method892(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var8 + var10) / 2.0D;
      if(var10 != var8) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var10 == var6) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.field984 = (int)(256.0D * var14);
      this.field985 = (int)(var16 * 256.0D);
      if(this.field984 < 0) {
         this.field984 = 0;
      } else if(this.field984 > 255) {
         this.field984 = 255;
      }

      if(this.field985 < 0) {
         this.field985 = 0;
      } else if(this.field985 > 255) {
         this.field985 = 255;
      }

      if(var16 > 0.5D) {
         this.field986 = (int)((1.0D - var16) * var14 * 512.0D);
      } else {
         this.field986 = (int)(var16 * var14 * 512.0D);
      }

      if(this.field986 < 1) {
         this.field986 = 1;
      }

      this.field983 = (int)(var12 * (double)this.field986);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass144;I)V",
      garbageValue = "-651916655"
   )
   static void method896() {
      int var1;
      int var2;
      int var10;
      int var13;
      if(class31.field741) {
         if(class140.field2177 == 1 || !class39.field922 && class140.field2177 == 4) {
            var10 = class31.field720 + 280;
            if(class140.field2176 >= var10 && class140.field2176 <= var10 + 14 && class140.field2167 >= 4 && class140.field2167 <= 18) {
               class13.method160(0, 0);
            } else if(class140.field2176 >= var10 + 15 && class140.field2176 <= var10 + 80 && class140.field2167 >= 4 && class140.field2167 <= 18) {
               class13.method160(0, 1);
            } else {
               var1 = 390 + class31.field720;
               if(class140.field2176 >= var1 && class140.field2176 <= var1 + 14 && class140.field2167 >= 4 && class140.field2167 <= 18) {
                  class13.method160(1, 0);
               } else if(class140.field2176 >= 15 + var1 && class140.field2176 <= var1 + 80 && class140.field2167 >= 4 && class140.field2167 <= 18) {
                  class13.method160(1, 1);
               } else {
                  var2 = class31.field720 + 500;
                  if(class140.field2176 >= var2 && class140.field2176 <= 14 + var2 && class140.field2167 >= 4 && class140.field2167 <= 18) {
                     class13.method160(2, 0);
                  } else if(class140.field2176 >= 15 + var2 && class140.field2176 <= var2 + 80 && class140.field2167 >= 4 && class140.field2167 <= 18) {
                     class13.method160(2, 1);
                  } else {
                     var13 = 610 + class31.field720;
                     if(class140.field2176 >= var13 && class140.field2176 <= var13 + 14 && class140.field2167 >= 4 && class140.field2167 <= 18) {
                        class13.method160(3, 0);
                     } else if(class140.field2176 >= 15 + var13 && class140.field2176 <= var13 + 80 && class140.field2167 >= 4 && class140.field2167 <= 18) {
                        class13.method160(3, 1);
                     } else if(class140.field2176 >= 708 + class31.field720 && class140.field2167 >= 4 && class140.field2176 <= 50 + class31.field720 + 708 && class140.field2167 <= 20) {
                        class31.field741 = false;
                        class161.field2668.method1697(class31.field720, 0);
                        class213.field3152.method1697(382 + class31.field720, 0);
                        class139.field2156.method1855(class31.field720 + 382 - class139.field2156.field1425 / 2, 18);
                     } else if(-1 != class31.field742) {
                        class25 var18 = class189.field3062[class31.field742];
                        class115.method2447(var18);
                        class31.field741 = false;
                        class161.field2668.method1697(class31.field720, 0);
                        class213.field3152.method1697(class31.field720 + 382, 0);
                        class139.field2156.method1855(382 + class31.field720 - class139.field2156.field1425 / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((1 == class140.field2177 || !class39.field922 && 4 == class140.field2177) && class140.field2176 >= 765 + class31.field720 - 50 && class140.field2167 >= 453) {
            field989.field157 = !field989.field157;
            class11.method152();
            if(!field989.field157) {
               class168 var0 = class19.field289;
               var1 = var0.method3303("scape main");
               var2 = var0.method3289(var1, "");
               class39.method819(var0, var1, var2, 255, false);
            } else {
               class183.field2967.method3652();
               class183.field2968 = 1;
               class151.field2279 = null;
            }
         }

         if(client.field303 != 5) {
            ++class31.field725;
            if(client.field303 == 10 || client.field303 == 11) {
               if(0 == client.field302) {
                  if(class140.field2177 == 1 || !class39.field922 && 4 == class140.field2177) {
                     var10 = class31.field720 + 5;
                     short var11 = 463;
                     byte var12 = 100;
                     byte var3 = 35;
                     if(class140.field2176 >= var10 && class140.field2176 <= var10 + var12 && class140.field2167 >= var11 && class140.field2167 <= var3 + var11) {
                        if(class10.method129()) {
                           class31.field741 = true;
                        }

                        return;
                     }
                  }

                  if(class47.field1080 != null && class10.method129()) {
                     class31.field741 = true;
                  }
               }

               var10 = class140.field2177;
               var1 = class140.field2176;
               var2 = class140.field2167;
               if(!class39.field922 && var10 == 4) {
                  var10 = 1;
               }

               short var4;
               String var5;
               if(class31.field729 == 0) {
                  var13 = class31.field718 + 180 - 80;
                  var4 = 291;
                  if(var10 == 1 && var1 >= var13 - 75 && var1 <= 75 + var13 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                     label910: {
                        var5 = class36.method763("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws";
                        if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                           try {
                              Desktop.getDesktop().browse(new URI(var5));
                              break label910;
                           } catch (Exception var8) {
                              ;
                           }
                        }

                        if(class138.field2151.startsWith("win")) {
                           class35.method749(var5, 0, "openjs");
                        } else if(class138.field2151.startsWith("mac")) {
                           class35.method749(var5, 1, "openjs");
                        } else {
                           class35.method749(var5, 2, "openjs");
                        }
                     }
                  }

                  var13 = 80 + class31.field718 + 180;
                  if(1 == var10 && var1 >= var13 - 75 && var1 <= 75 + var13 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                     if(0 != (client.field503 & 33554432)) {
                        class31.field730 = "";
                        class31.field714 = "This is a <col=00ffff>Tournament<col=ffffff> world.";
                        class31.field732 = "Max stats and high level gear are provided.";
                        class31.field739 = "Your normal account will not be affected.";
                        class31.field729 = 1;
                        class31.field738 = 0;
                     } else if((client.field503 & 4) != 0) {
                        if((client.field503 & 1024) != 0) {
                           class31.field714 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class31.field732 = "Players can attack each other almost everywhere";
                           class31.field739 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class31.field714 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class31.field732 = "Players can attack each other";
                           class31.field739 = "almost everywhere.";
                        }

                        class31.field730 = "Warning!";
                        class31.field729 = 1;
                        class31.field738 = 0;
                     } else if(0 != (client.field503 & 1024)) {
                        class31.field714 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class31.field732 = "The Protect Item prayer will";
                        class31.field739 = "not work on this world.";
                        class31.field730 = "Warning!";
                        class31.field729 = 1;
                        class31.field738 = 0;
                     } else {
                        class31.field714 = "";
                        class31.field732 = "Enter your username/email & password.";
                        class31.field739 = "";
                        class31.field729 = 2;
                        class31.field738 = 0;
                     }
                  }
               } else if(1 != class31.field729) {
                  short var14;
                  if(class31.field729 == 2) {
                     var14 = 231;
                     var13 = var14 + 30;
                     if(1 == var10 && var2 >= var13 - 15 && var2 < var13) {
                        class31.field738 = 0;
                     }

                     var13 += 15;
                     if(1 == var10 && var2 >= var13 - 15 && var2 < var13) {
                        class31.field738 = 1;
                     }

                     var13 += 15;
                     var14 = 361;
                     if(var10 == 1 && var2 >= var14 - 15 && var2 < var14) {
                        class21.method590("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class31.field729 = 5;
                        return;
                     }

                     int var15 = class31.field718 + 180 - 80;
                     short var16 = 321;
                     if(var10 == 1 && var1 >= var15 - 75 && var1 <= 75 + var15 && var2 >= var16 - 20 && var2 <= 20 + var16) {
                        class31.field734 = class31.field734.trim();
                        if(class31.field734.length() == 0) {
                           class21.method590("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class31.field735.length() == 0) {
                           class21.method590("", "Please enter your password.", "");
                           return;
                        }

                        class21.method590("", "Connecting to server...", "");
                        class31.field736 = field989.field156.containsKey(Integer.valueOf(class87.method2073(class31.field734)))?class159.field2629:class159.field2626;
                        class138.method2937(20);
                        return;
                     }

                     var15 = 180 + class31.field718 + 80;
                     if(var10 == 1 && var1 >= var15 - 75 && var1 <= var15 + 75 && var2 >= var16 - 20 && var2 <= var16 + 20) {
                        class31.field729 = 0;
                        class31.field734 = "";
                        class31.field735 = "";
                        class33.field778 = 0;
                        class26.field668 = "";
                        class31.field722 = true;
                     }

                     while(true) {
                        while(class124.method2790()) {
                           boolean var6 = false;

                           for(int var7 = 0; var7 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var7) {
                              if(class33.field772 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var7)) {
                                 var6 = true;
                                 break;
                              }
                           }

                           if(13 == class137.field2118) {
                              class31.field729 = 0;
                              class31.field734 = "";
                              class31.field735 = "";
                              class33.field778 = 0;
                              class26.field668 = "";
                              class31.field722 = true;
                           } else if(class31.field738 == 0) {
                              if(85 == class137.field2118 && class31.field734.length() > 0) {
                                 class31.field734 = class31.field734.substring(0, class31.field734.length() - 1);
                              }

                              if(84 == class137.field2118 || 80 == class137.field2118) {
                                 class31.field738 = 1;
                              }

                              if(var6 && class31.field734.length() < 320) {
                                 class31.field734 = class31.field734 + class33.field772;
                              }
                           } else if(1 == class31.field738) {
                              if(class137.field2118 == 85 && class31.field735.length() > 0) {
                                 class31.field735 = class31.field735.substring(0, class31.field735.length() - 1);
                              }

                              if(84 == class137.field2118 || 80 == class137.field2118) {
                                 class31.field738 = 0;
                              }

                              if(class137.field2118 == 84) {
                                 class31.field734 = class31.field734.trim();
                                 if(class31.field734.length() == 0) {
                                    class21.method590("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class31.field735.length() == 0) {
                                    class21.method590("", "Please enter your password.", "");
                                    return;
                                 }

                                 class21.method590("", "Connecting to server...", "");
                                 class31.field736 = field989.field156.containsKey(Integer.valueOf(class87.method2073(class31.field734)))?class159.field2629:class159.field2626;
                                 class138.method2937(20);
                                 return;
                              }

                              if(var6 && class31.field735.length() < 20) {
                                 class31.field735 = class31.field735 + class33.field772;
                              }
                           }
                        }

                        return;
                     }
                  } else if(3 == class31.field729) {
                     var13 = class31.field718 + 180;
                     var4 = 276;
                     if(1 == var10 && var1 >= var13 - 75 && var1 <= 75 + var13 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                        class31.field714 = "";
                        class31.field732 = "Enter your username/email & password.";
                        class31.field739 = "";
                        class31.field729 = 2;
                        class31.field738 = 0;
                     }

                     var13 = 180 + class31.field718;
                     var4 = 326;
                     if(1 == var10 && var1 >= var13 - 75 && var1 <= 75 + var13 && var2 >= var4 - 20 && var2 <= 20 + var4) {
                        class21.method590("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class31.field729 = 5;
                        return;
                     }
                  } else {
                     boolean var17;
                     int var19;
                     if(class31.field729 == 4) {
                        var13 = class31.field718 + 180 - 80;
                        var4 = 321;
                        if(1 == var10 && var1 >= var13 - 75 && var1 <= 75 + var13 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                           class26.field668.trim();
                           if(class26.field668.length() != 6) {
                              class21.method590("", "Please enter a 6-digin PIN.", "");
                              return;
                           }

                           class33.field778 = Integer.parseInt(class26.field668);
                           class26.field668 = "";
                           class31.field736 = class31.field722?class159.field2624:class159.field2625;
                           class21.method590("", "Connecting to server...", "");
                           class138.method2937(20);
                           return;
                        }

                        if(1 == var10 && var1 >= class31.field718 + 180 - 9 && var1 <= 130 + class31.field718 + 180 && var2 >= 263 && var2 <= 296) {
                           class31.field722 = !class31.field722;
                        }

                        if(var10 == 1 && var1 >= class31.field718 + 180 - 34 && var1 <= 34 + class31.field718 + 180 && var2 >= 351 && var2 <= 363) {
                           label925: {
                              var5 = class36.method763("secure", true) + "m=totp-authenticator/disableTOTPRequest";
                              if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                                 try {
                                    Desktop.getDesktop().browse(new URI(var5));
                                    break label925;
                                 } catch (Exception var9) {
                                    ;
                                 }
                              }

                              if(class138.field2151.startsWith("win")) {
                                 class35.method749(var5, 0, "openjs");
                              } else if(class138.field2151.startsWith("mac")) {
                                 class35.method749(var5, 1, "openjs");
                              } else {
                                 class35.method749(var5, 2, "openjs");
                              }
                           }
                        }

                        var13 = 180 + class31.field718 + 80;
                        if(var10 == 1 && var1 >= var13 - 75 && var1 <= var13 + 75 && var2 >= var4 - 20 && var2 <= 20 + var4) {
                           class31.field729 = 0;
                           class31.field734 = "";
                           class31.field735 = "";
                           class33.field778 = 0;
                           class26.field668 = "";
                        }

                        while(class124.method2790()) {
                           var17 = false;

                           for(var19 = 0; var19 < "1234567890".length(); ++var19) {
                              if(class33.field772 == "1234567890".charAt(var19)) {
                                 var17 = true;
                                 break;
                              }
                           }

                           if(class137.field2118 == 13) {
                              class31.field729 = 0;
                              class31.field734 = "";
                              class31.field735 = "";
                              class33.field778 = 0;
                              class26.field668 = "";
                           } else {
                              if(85 == class137.field2118 && class26.field668.length() > 0) {
                                 class26.field668 = class26.field668.substring(0, class26.field668.length() - 1);
                              }

                              if(class137.field2118 == 84) {
                                 class26.field668.trim();
                                 if(class26.field668.length() != 6) {
                                    class21.method590("", "Please enter a 6-digin PIN.", "");
                                    return;
                                 }

                                 class33.field778 = Integer.parseInt(class26.field668);
                                 class26.field668 = "";
                                 class31.field736 = class31.field722?class159.field2624:class159.field2625;
                                 class21.method590("", "Connecting to server...", "");
                                 class138.method2937(20);
                                 return;
                              }

                              if(var17 && class26.field668.length() < 6) {
                                 class26.field668 = class26.field668 + class33.field772;
                              }
                           }
                        }
                     } else if(class31.field729 == 5) {
                        var13 = class31.field718 + 180 - 80;
                        var4 = 321;
                        if(var10 == 1 && var1 >= var13 - 75 && var1 <= 75 + var13 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                           class14.method167();
                           return;
                        }

                        var13 = 180 + class31.field718 + 80;
                        if(var10 == 1 && var1 >= var13 - 75 && var1 <= var13 + 75 && var2 >= var4 - 20 && var2 <= 20 + var4) {
                           class31.field714 = "";
                           class31.field732 = "Enter your username/email & password.";
                           class31.field739 = "";
                           class31.field729 = 2;
                           class31.field738 = 0;
                           class31.field735 = "";
                        }

                        while(class124.method2790()) {
                           var17 = false;

                           for(var19 = 0; var19 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var19) {
                              if(class33.field772 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var19)) {
                                 var17 = true;
                                 break;
                              }
                           }

                           if(13 == class137.field2118) {
                              class31.field714 = "";
                              class31.field732 = "Enter your username/email & password.";
                              class31.field739 = "";
                              class31.field729 = 2;
                              class31.field738 = 0;
                              class31.field735 = "";
                           } else {
                              if(85 == class137.field2118 && class31.field734.length() > 0) {
                                 class31.field734 = class31.field734.substring(0, class31.field734.length() - 1);
                              }

                              if(84 == class137.field2118) {
                                 class14.method167();
                                 return;
                              }

                              if(var17 && class31.field734.length() < 320) {
                                 class31.field734 = class31.field734 + class33.field772;
                              }
                           }
                        }
                     } else if(class31.field729 == 6) {
                        while(true) {
                           do {
                              if(!class124.method2790()) {
                                 var14 = 321;
                                 if(1 == var10 && var2 >= var14 - 20 && var2 <= var14 + 20) {
                                    class31.field714 = "";
                                    class31.field732 = "Enter your username/email & password.";
                                    class31.field739 = "";
                                    class31.field729 = 2;
                                    class31.field738 = 0;
                                    class31.field735 = "";
                                 }

                                 return;
                              }
                           } while(84 != class137.field2118 && class137.field2118 != 13);

                           class31.field714 = "";
                           class31.field732 = "Enter your username/email & password.";
                           class31.field739 = "";
                           class31.field729 = 2;
                           class31.field738 = 0;
                           class31.field735 = "";
                        }
                     }
                  }
               } else {
                  while(class124.method2790()) {
                     if(class137.field2118 == 84) {
                        class31.field714 = "";
                        class31.field732 = "Enter your username/email & password.";
                        class31.field739 = "";
                        class31.field729 = 2;
                        class31.field738 = 0;
                     } else if(13 == class137.field2118) {
                        class31.field729 = 0;
                     }
                  }

                  var13 = 180 + class31.field718 - 80;
                  var4 = 321;
                  if(1 == var10 && var1 >= var13 - 75 && var1 <= 75 + var13 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                     class31.field714 = "";
                     class31.field732 = "Enter your username/email & password.";
                     class31.field739 = "";
                     class31.field729 = 2;
                     class31.field738 = 0;
                  }

                  var13 = class31.field718 + 180 + 80;
                  if(1 == var10 && var1 >= var13 - 75 && var1 <= 75 + var13 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                     class31.field729 = 0;
                  }
               }

            }
         }
      }
   }
}
