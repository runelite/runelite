import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class41 extends class204 {
   @ObfuscatedName("w")
   public static class193 field978 = new class193(64);
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 33844335
   )
   public int field980;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1822238927
   )
   public int field981;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1737680259
   )
   public int field982;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -274544241
   )
   public int field983;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1090449471
   )
   int field984 = 0;
   @ObfuscatedName("p")
   static byte[][][] field985;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "5"
   )
   static final void method935() {
      if(client.field577 != null) {
         client.field577.method1277();
      }

      if(null != class96.field1627) {
         class96.field1627.method1277();
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-409112321"
   )
   public void method936() {
      this.method941(this.field984);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "9"
   )
   public void method937(class119 var1, int var2) {
      while(true) {
         int var3 = var1.method2613();
         if(0 == var3) {
            return;
         }

         this.method938(var1, var3, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass119;III)V",
      garbageValue = "605596924"
   )
   void method938(class119 var1, int var2, int var3) {
      if(var2 == 1) {
         this.field984 = var1.method2617();
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "36"
   )
   void method941(int var1) {
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
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var6 == var10) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.field980 = (int)(256.0D * var14);
      this.field983 = (int)(256.0D * var16);
      if(this.field980 < 0) {
         this.field980 = 0;
      } else if(this.field980 > 255) {
         this.field980 = 255;
      }

      if(this.field983 < 0) {
         this.field983 = 0;
      } else if(this.field983 > 255) {
         this.field983 = 255;
      }

      if(var16 > 0.5D) {
         this.field982 = (int)((1.0D - var16) * var14 * 512.0D);
      } else {
         this.field982 = (int)(var16 * var14 * 512.0D);
      }

      if(this.field982 < 1) {
         this.field982 = 1;
      }

      this.field981 = (int)((double)this.field982 * var12);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "0"
   )
   public static byte[] method945(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var3;
      } else if(var0 instanceof class125) {
         class125 var2 = (class125)var0;
         return var2.vmethod2915();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIB)I",
      garbageValue = "119"
   )
   public static int method946(byte[] var0, int var1) {
      return class6.method119(var0, 0, var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass144;I)V",
      garbageValue = "2013797405"
   )
   static void method947(class144 var0) {
      if(class31.field748) {
         class115.method2547(var0);
      } else {
         if((1 == class140.field2157 || !class7.field143 && 4 == class140.field2157) && class140.field2160 >= 765 + class31.field723 - 50 && class140.field2159 >= 453) {
            class134.field2078.field154 = !class134.field2078.field154;
            class213.method4031();
            if(!class134.field2078.field154) {
               class29.method742(class38.field884, "scape main", "", 255, false);
            } else {
               class9.method163();
            }
         }

         if(5 != client.field554) {
            ++class31.field737;
            if(10 == client.field554 || client.field554 == 11) {
               int var1;
               if(0 == client.field372) {
                  if(1 == class140.field2157 || !class7.field143 && class140.field2157 == 4) {
                     var1 = class31.field723 + 5;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(class140.field2160 >= var1 && class140.field2160 <= var1 + var3 && class140.field2159 >= var2 && class140.field2159 <= var2 + var4) {
                        if(class74.method1690()) {
                           class31.field748 = true;
                        }

                        return;
                     }
                  }

                  if(null != class25.field645 && class74.method1690()) {
                     class31.field748 = true;
                  }
               }

               var1 = class140.field2157;
               int var9 = class140.field2160;
               int var10 = class140.field2159;
               if(!class7.field143 && 4 == var1) {
                  var1 = 1;
               }

               short var5;
               String var6;
               int var11;
               if(0 == class31.field726) {
                  var11 = 180 + class31.field730 - 80;
                  var5 = 291;
                  if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                     var6 = class17.method218("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws";
                     class23.method670(var6, true, "openjs", false);
                  }

                  var11 = class31.field730 + 180 + 80;
                  if(var1 == 1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                     if((client.field431 & 33554432) != 0) {
                        class31.field742 = "";
                        class31.field743 = "This is a <col=00ffff>Tournament<col=ffffff> world.";
                        class31.field724 = "Max stats and high level gear are provided.";
                        class31.field745 = "Your normal account will not be affected.";
                        class31.field726 = 1;
                        class31.field750 = 0;
                     } else if((client.field431 & 4) != 0) {
                        if(0 != (client.field431 & 1024)) {
                           class31.field743 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class31.field724 = "Players can attack each other almost everywhere";
                           class31.field745 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class31.field743 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class31.field724 = "Players can attack each other";
                           class31.field745 = "almost everywhere.";
                        }

                        class31.field742 = "Warning!";
                        class31.field726 = 1;
                        class31.field750 = 0;
                     } else if((client.field431 & 1024) != 0) {
                        class31.field743 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class31.field724 = "The Protect Item prayer will";
                        class31.field745 = "not work on this world.";
                        class31.field742 = "Warning!";
                        class31.field726 = 1;
                        class31.field750 = 0;
                     } else {
                        class31.field743 = "";
                        class31.field724 = "Enter your username/email & password.";
                        class31.field745 = "";
                        class31.field726 = 2;
                        class31.field750 = 0;
                     }
                  }
               } else if(class31.field726 != 1) {
                  short var12;
                  if(2 == class31.field726) {
                     var12 = 231;
                     var11 = var12 + 30;
                     if(var1 == 1 && var10 >= var11 - 15 && var10 < var11) {
                        class31.field750 = 0;
                     }

                     var11 += 15;
                     if(1 == var1 && var10 >= var11 - 15 && var10 < var11) {
                        class31.field750 = 1;
                     }

                     var11 += 15;
                     var12 = 361;
                     if(1 == var1 && var10 >= var12 - 15 && var10 < var12) {
                        class39.method878("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class31.field726 = 5;
                        return;
                     }

                     int var13 = class31.field730 + 180 - 80;
                     short var14 = 321;
                     if(1 == var1 && var9 >= var13 - 75 && var9 <= 75 + var13 && var10 >= var14 - 20 && var10 <= var14 + 20) {
                        class31.field749 = class31.field749.trim();
                        if(class31.field749.length() == 0) {
                           class39.method878("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class31.field740.length() == 0) {
                           class39.method878("", "Please enter your password.", "");
                           return;
                        }

                        class39.method878("", "Connecting to server...", "");
                        class31.field739 = class134.field2078.field150.containsKey(Integer.valueOf(class113.method2541(class31.field749)))?class159.field2592:class159.field2596;
                        class3.method49(20);
                        return;
                     }

                     var13 = class31.field730 + 180 + 80;
                     if(1 == var1 && var9 >= var13 - 75 && var9 <= 75 + var13 && var10 >= var14 - 20 && var10 <= var14 + 20) {
                        class31.field726 = 0;
                        class31.field749 = "";
                        class31.field740 = "";
                        class154.field2287 = 0;
                        class25.field653 = "";
                        class31.field735 = true;
                     }

                     while(true) {
                        while(class114.method2545()) {
                           boolean var7 = false;

                           for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                              if(class137.field2128 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                 var7 = true;
                                 break;
                              }
                           }

                           if(13 == class18.field277) {
                              class31.field726 = 0;
                              class31.field749 = "";
                              class31.field740 = "";
                              class154.field2287 = 0;
                              class25.field653 = "";
                              class31.field735 = true;
                           } else if(class31.field750 == 0) {
                              if(class18.field277 == 85 && class31.field749.length() > 0) {
                                 class31.field749 = class31.field749.substring(0, class31.field749.length() - 1);
                              }

                              if(class18.field277 == 84 || 80 == class18.field277) {
                                 class31.field750 = 1;
                              }

                              if(var7 && class31.field749.length() < 320) {
                                 class31.field749 = class31.field749 + class137.field2128;
                              }
                           } else if(class31.field750 == 1) {
                              if(class18.field277 == 85 && class31.field740.length() > 0) {
                                 class31.field740 = class31.field740.substring(0, class31.field740.length() - 1);
                              }

                              if(84 == class18.field277 || class18.field277 == 80) {
                                 class31.field750 = 0;
                              }

                              if(class18.field277 == 84) {
                                 class31.field749 = class31.field749.trim();
                                 if(class31.field749.length() == 0) {
                                    class39.method878("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class31.field740.length() == 0) {
                                    class39.method878("", "Please enter your password.", "");
                                    return;
                                 }

                                 class39.method878("", "Connecting to server...", "");
                                 class31.field739 = class134.field2078.field150.containsKey(Integer.valueOf(class113.method2541(class31.field749)))?class159.field2592:class159.field2596;
                                 class3.method49(20);
                                 return;
                              }

                              if(var7 && class31.field740.length() < 20) {
                                 class31.field740 = class31.field740 + class137.field2128;
                              }
                           }
                        }

                        return;
                     }
                  } else if(3 == class31.field726) {
                     var11 = class31.field730 + 180;
                     var5 = 276;
                     if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                        class31.field743 = "";
                        class31.field724 = "Enter your username/email & password.";
                        class31.field745 = "";
                        class31.field726 = 2;
                        class31.field750 = 0;
                     }

                     var11 = class31.field730 + 180;
                     var5 = 326;
                     if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                        class39.method878("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class31.field726 = 5;
                        return;
                     }
                  } else {
                     boolean var15;
                     int var16;
                     if(4 == class31.field726) {
                        var11 = class31.field730 + 180 - 80;
                        var5 = 321;
                        if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                           class25.field653.trim();
                           if(class25.field653.length() != 6) {
                              class39.method878("", "Please enter a 6-digin PIN.", "");
                              return;
                           }

                           class154.field2287 = Integer.parseInt(class25.field653);
                           class25.field653 = "";
                           class31.field739 = class31.field735?class159.field2590:class159.field2591;
                           class39.method878("", "Connecting to server...", "");
                           class3.method49(20);
                           return;
                        }

                        if(var1 == 1 && var9 >= class31.field730 + 180 - 9 && var9 <= 130 + 180 + class31.field730 && var10 >= 263 && var10 <= 296) {
                           class31.field735 = !class31.field735;
                        }

                        if(1 == var1 && var9 >= 180 + class31.field730 - 34 && var9 <= 34 + class31.field730 + 180 && var10 >= 351 && var10 <= 363) {
                           var6 = class17.method218("secure", true) + "m=totp-authenticator/disableTOTPRequest";
                           class23.method670(var6, true, "openjs", false);
                        }

                        var11 = 180 + class31.field730 + 80;
                        if(1 == var1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                           class31.field726 = 0;
                           class31.field749 = "";
                           class31.field740 = "";
                           class154.field2287 = 0;
                           class25.field653 = "";
                        }

                        while(class114.method2545()) {
                           var15 = false;

                           for(var16 = 0; var16 < "1234567890".length(); ++var16) {
                              if(class137.field2128 == "1234567890".charAt(var16)) {
                                 var15 = true;
                                 break;
                              }
                           }

                           if(13 == class18.field277) {
                              class31.field726 = 0;
                              class31.field749 = "";
                              class31.field740 = "";
                              class154.field2287 = 0;
                              class25.field653 = "";
                           } else {
                              if(85 == class18.field277 && class25.field653.length() > 0) {
                                 class25.field653 = class25.field653.substring(0, class25.field653.length() - 1);
                              }

                              if(84 == class18.field277) {
                                 class25.field653.trim();
                                 if(class25.field653.length() != 6) {
                                    class39.method878("", "Please enter a 6-digin PIN.", "");
                                    return;
                                 }

                                 class154.field2287 = Integer.parseInt(class25.field653);
                                 class25.field653 = "";
                                 class31.field739 = class31.field735?class159.field2590:class159.field2591;
                                 class39.method878("", "Connecting to server...", "");
                                 class3.method49(20);
                                 return;
                              }

                              if(var15 && class25.field653.length() < 6) {
                                 class25.field653 = class25.field653 + class137.field2128;
                              }
                           }
                        }
                     } else if(5 == class31.field726) {
                        var11 = 180 + class31.field730 - 80;
                        var5 = 321;
                        if(var1 == 1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                           class121.method2859();
                           return;
                        }

                        var11 = class31.field730 + 180 + 80;
                        if(1 == var1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                           class31.field743 = "";
                           class31.field724 = "Enter your username/email & password.";
                           class31.field745 = "";
                           class31.field726 = 2;
                           class31.field750 = 0;
                           class31.field740 = "";
                        }

                        while(class114.method2545()) {
                           var15 = false;

                           for(var16 = 0; var16 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var16) {
                              if(class137.field2128 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var16)) {
                                 var15 = true;
                                 break;
                              }
                           }

                           if(class18.field277 == 13) {
                              class31.field743 = "";
                              class31.field724 = "Enter your username/email & password.";
                              class31.field745 = "";
                              class31.field726 = 2;
                              class31.field750 = 0;
                              class31.field740 = "";
                           } else {
                              if(class18.field277 == 85 && class31.field749.length() > 0) {
                                 class31.field749 = class31.field749.substring(0, class31.field749.length() - 1);
                              }

                              if(84 == class18.field277) {
                                 class121.method2859();
                                 return;
                              }

                              if(var15 && class31.field749.length() < 320) {
                                 class31.field749 = class31.field749 + class137.field2128;
                              }
                           }
                        }
                     } else if(class31.field726 == 6) {
                        while(true) {
                           do {
                              if(!class114.method2545()) {
                                 var12 = 321;
                                 if(var1 == 1 && var10 >= var12 - 20 && var10 <= 20 + var12) {
                                    class31.field743 = "";
                                    class31.field724 = "Enter your username/email & password.";
                                    class31.field745 = "";
                                    class31.field726 = 2;
                                    class31.field750 = 0;
                                    class31.field740 = "";
                                 }

                                 return;
                              }
                           } while(class18.field277 != 84 && class18.field277 != 13);

                           class31.field743 = "";
                           class31.field724 = "Enter your username/email & password.";
                           class31.field745 = "";
                           class31.field726 = 2;
                           class31.field750 = 0;
                           class31.field740 = "";
                        }
                     }
                  }
               } else {
                  while(class114.method2545()) {
                     if(class18.field277 == 84) {
                        class31.field743 = "";
                        class31.field724 = "Enter your username/email & password.";
                        class31.field745 = "";
                        class31.field726 = 2;
                        class31.field750 = 0;
                     } else if(class18.field277 == 13) {
                        class31.field726 = 0;
                     }
                  }

                  var11 = class31.field730 + 180 - 80;
                  var5 = 321;
                  if(1 == var1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                     class31.field743 = "";
                     class31.field724 = "Enter your username/email & password.";
                     class31.field745 = "";
                     class31.field726 = 2;
                     class31.field750 = 0;
                  }

                  var11 = 80 + 180 + class31.field730;
                  if(1 == var1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                     class31.field726 = 0;
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "0"
   )
   static boolean method948(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = class23.method672(var0, client.field551);

         for(int var3 = 0; var3 < client.field561; ++var3) {
            if(var2.equalsIgnoreCase(class23.method672(client.field563[var3].field261, client.field551))) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class23.method672(class5.field93.field58, client.field551))) {
            return true;
         } else {
            return false;
         }
      }
   }
}
