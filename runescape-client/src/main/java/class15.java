import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
@Implements("XItemContainer")
public class class15 extends class211 {
   @ObfuscatedName("g")
   @Export("itemIds")
   int[] field221 = new int[]{-1};
   @ObfuscatedName("p")
   static String field223;
   @ObfuscatedName("r")
   @Export("stackSizes")
   int[] field224 = new int[]{0};
   @ObfuscatedName("l")
   @Export("itemContainers")
   static class199 field225 = new class199(32);
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1891841803
   )
   public static int field227;

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "2022311415"
   )
   static final void method187(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < client.field496; ++var4) {
         if(client.field501[var4] + client.field503[var4] > var0 && client.field501[var4] < var2 + var0 && client.field504[var4] + client.field502[var4] > var1 && client.field502[var4] < var1 + var3) {
            client.field499[var4] = true;
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass147;I)V",
      garbageValue = "14240292"
   )
   static void method201(class147 var0) {
      if(class33.field772) {
         class18.method217(var0);
      } else {
         if((class143.field2217 == 1 || !class214.field3188 && class143.field2217 == 4) && class143.field2215 >= 765 + class33.field741 - 50 && class143.field2216 >= 453) {
            class136.field2123.field148 = !class136.field2123.field148;
            class42.method886();
            if(!class136.field2123.field148) {
               class35.method757(class188.field3051, "scape main", "", 255, false);
            } else {
               class59.field1266.method3754();
               class186.field3010 = 1;
               class111.field1970 = null;
            }
         }

         if(client.field303 != 5) {
            ++class33.field775;
            if(client.field303 == 10 || client.field303 == 11) {
               int var1;
               if(client.field326 == 0) {
                  if(class143.field2217 == 1 || !class214.field3188 && class143.field2217 == 4) {
                     var1 = 5 + class33.field741;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(class143.field2215 >= var1 && class143.field2215 <= var3 + var1 && class143.field2216 >= var2 && class143.field2216 <= var2 + var4) {
                        if(class2.method38()) {
                           class33.field772 = true;
                        }

                        return;
                     }
                  }

                  if(class117.field2027 != null && class2.method38()) {
                     class33.field772 = true;
                  }
               }

               var1 = class143.field2217;
               int var9 = class143.field2215;
               int var10 = class143.field2216;
               if(!class214.field3188 && var1 == 4) {
                  var1 = 1;
               }

               short var5;
               int var11;
               if(class33.field761 == 0) {
                  var11 = 180 + class33.field777 - 80;
                  var5 = 291;
                  if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                     class105.method2384(class138.method3023("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var11 = 80 + class33.field777 + 180;
                  if(var1 == 1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                     if((client.field561 & 33554432) != 0) {
                        class33.field740 = "";
                        class33.field748 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class33.field762 = "Your normal account will not be affected.";
                        class33.field755 = "";
                        class33.field761 = 1;
                        class33.field769 = 0;
                     } else if((client.field561 & 4) != 0) {
                        if((client.field561 & 1024) != 0) {
                           class33.field748 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class33.field762 = "Players can attack each other almost everywhere";
                           class33.field755 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class33.field748 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class33.field762 = "Players can attack each other";
                           class33.field755 = "almost everywhere.";
                        }

                        class33.field740 = "Warning!";
                        class33.field761 = 1;
                        class33.field769 = 0;
                     } else if((client.field561 & 1024) != 0) {
                        class33.field748 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class33.field762 = "The Protect Item prayer will";
                        class33.field755 = "not work on this world.";
                        class33.field740 = "Warning!";
                        class33.field761 = 1;
                        class33.field769 = 0;
                     } else {
                        class33.field748 = "";
                        class33.field762 = "Enter your username/email & password.";
                        class33.field755 = "";
                        class33.field761 = 2;
                        class33.field769 = 0;
                     }
                  }
               } else if(class33.field761 != 1) {
                  short var12;
                  if(class33.field761 == 2) {
                     var12 = 231;
                     var11 = var12 + 30;
                     if(var1 == 1 && var10 >= var11 - 15 && var10 < var11) {
                        class33.field769 = 0;
                     }

                     var11 += 15;
                     if(var1 == 1 && var10 >= var11 - 15 && var10 < var11) {
                        class33.field769 = 1;
                     }

                     var11 += 15;
                     var12 = 361;
                     if(var1 == 1 && var10 >= var12 - 15 && var10 < var12) {
                        class37.method781("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class33.field761 = 5;
                        return;
                     }

                     int var13 = 180 + class33.field777 - 80;
                     short var6 = 321;
                     if(var1 == 1 && var9 >= var13 - 75 && var9 <= 75 + var13 && var10 >= var6 - 20 && var10 <= var6 + 20) {
                        class33.field764 = class33.field764.trim();
                        if(class33.field764.length() == 0) {
                           class37.method781("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class33.field765.length() == 0) {
                           class37.method781("", "Please enter your password.", "");
                           return;
                        }

                        class37.method781("", "Connecting to server...", "");
                        class33.field766 = class136.field2123.field147.containsKey(Integer.valueOf(class55.method1234(class33.field764)))?class162.field2664:class162.field2661;
                        class138.method3024(20);
                        return;
                     }

                     var13 = 180 + class33.field777 + 80;
                     if(var1 == 1 && var9 >= var13 - 75 && var9 <= var13 + 75 && var10 >= var6 - 20 && var10 <= var6 + 20) {
                        class33.field761 = 0;
                        class33.field764 = "";
                        class33.field765 = "";
                        class174.field2788 = 0;
                        class33.field767 = "";
                        class33.field768 = true;
                     }

                     while(true) {
                        while(class151.method3275()) {
                           boolean var7 = false;

                           for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                              if(class51.field1146 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                 var7 = true;
                                 break;
                              }
                           }

                           if(class25.field643 == 13) {
                              class33.field761 = 0;
                              class33.field764 = "";
                              class33.field765 = "";
                              class174.field2788 = 0;
                              class33.field767 = "";
                              class33.field768 = true;
                           } else if(class33.field769 == 0) {
                              if(class25.field643 == 85 && class33.field764.length() > 0) {
                                 class33.field764 = class33.field764.substring(0, class33.field764.length() - 1);
                              }

                              if(class25.field643 == 84 || class25.field643 == 80) {
                                 class33.field769 = 1;
                              }

                              if(var7 && class33.field764.length() < 320) {
                                 class33.field764 = class33.field764 + class51.field1146;
                              }
                           } else if(class33.field769 == 1) {
                              if(class25.field643 == 85 && class33.field765.length() > 0) {
                                 class33.field765 = class33.field765.substring(0, class33.field765.length() - 1);
                              }

                              if(class25.field643 == 84 || class25.field643 == 80) {
                                 class33.field769 = 0;
                              }

                              if(class25.field643 == 84) {
                                 class33.field764 = class33.field764.trim();
                                 if(class33.field764.length() == 0) {
                                    class37.method781("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class33.field765.length() == 0) {
                                    class37.method781("", "Please enter your password.", "");
                                    return;
                                 }

                                 class37.method781("", "Connecting to server...", "");
                                 class33.field766 = class136.field2123.field147.containsKey(Integer.valueOf(class55.method1234(class33.field764)))?class162.field2664:class162.field2661;
                                 class138.method3024(20);
                                 return;
                              }

                              if(var7 && class33.field765.length() < 20) {
                                 class33.field765 = class33.field765 + class51.field1146;
                              }
                           }
                        }

                        return;
                     }
                  } else if(class33.field761 == 3) {
                     var11 = 180 + class33.field777;
                     var5 = 276;
                     if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                        class33.field748 = "";
                        class33.field762 = "Enter your username/email & password.";
                        class33.field755 = "";
                        class33.field761 = 2;
                        class33.field769 = 0;
                     }

                     var11 = 180 + class33.field777;
                     var5 = 326;
                     if(var1 == 1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                        class37.method781("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class33.field761 = 5;
                        return;
                     }
                  } else {
                     boolean var14;
                     int var15;
                     if(class33.field761 == 4) {
                        var11 = 180 + class33.field777 - 80;
                        var5 = 321;
                        if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                           class33.field767.trim();
                           if(class33.field767.length() != 6) {
                              class37.method781("", "Please enter a 6-digin PIN.", "");
                              return;
                           }

                           class174.field2788 = Integer.parseInt(class33.field767);
                           class33.field767 = "";
                           class33.field766 = class33.field768?class162.field2660:class162.field2662;
                           class37.method781("", "Connecting to server...", "");
                           class138.method3024(20);
                           return;
                        }

                        if(var1 == 1 && var9 >= 180 + class33.field777 - 9 && var9 <= 130 + class33.field777 + 180 && var10 >= 263 && var10 <= 296) {
                           class33.field768 = !class33.field768;
                        }

                        if(var1 == 1 && var9 >= 180 + class33.field777 - 34 && var9 <= 34 + class33.field777 + 180 && var10 >= 351 && var10 <= 363) {
                           class105.method2384(class138.method3023("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                        }

                        var11 = class33.field777 + 180 + 80;
                        if(var1 == 1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                           class33.field761 = 0;
                           class33.field764 = "";
                           class33.field765 = "";
                           class174.field2788 = 0;
                           class33.field767 = "";
                        }

                        while(class151.method3275()) {
                           var14 = false;

                           for(var15 = 0; var15 < "1234567890".length(); ++var15) {
                              if(class51.field1146 == "1234567890".charAt(var15)) {
                                 var14 = true;
                                 break;
                              }
                           }

                           if(class25.field643 == 13) {
                              class33.field761 = 0;
                              class33.field764 = "";
                              class33.field765 = "";
                              class174.field2788 = 0;
                              class33.field767 = "";
                           } else {
                              if(class25.field643 == 85 && class33.field767.length() > 0) {
                                 class33.field767 = class33.field767.substring(0, class33.field767.length() - 1);
                              }

                              if(class25.field643 == 84) {
                                 class33.field767.trim();
                                 if(class33.field767.length() != 6) {
                                    class37.method781("", "Please enter a 6-digin PIN.", "");
                                    return;
                                 }

                                 class174.field2788 = Integer.parseInt(class33.field767);
                                 class33.field767 = "";
                                 class33.field766 = class33.field768?class162.field2660:class162.field2662;
                                 class37.method781("", "Connecting to server...", "");
                                 class138.method3024(20);
                                 return;
                              }

                              if(var14 && class33.field767.length() < 6) {
                                 class33.field767 = class33.field767 + class51.field1146;
                              }
                           }
                        }
                     } else if(class33.field761 == 5) {
                        var11 = class33.field777 + 180 - 80;
                        var5 = 321;
                        if(var1 == 1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                           class109.method2475();
                           return;
                        }

                        var11 = 80 + 180 + class33.field777;
                        if(var1 == 1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                           class33.field748 = "";
                           class33.field762 = "Enter your username/email & password.";
                           class33.field755 = "";
                           class33.field761 = 2;
                           class33.field769 = 0;
                           class33.field765 = "";
                        }

                        while(class151.method3275()) {
                           var14 = false;

                           for(var15 = 0; var15 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var15) {
                              if(class51.field1146 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var15)) {
                                 var14 = true;
                                 break;
                              }
                           }

                           if(class25.field643 == 13) {
                              class33.field748 = "";
                              class33.field762 = "Enter your username/email & password.";
                              class33.field755 = "";
                              class33.field761 = 2;
                              class33.field769 = 0;
                              class33.field765 = "";
                           } else {
                              if(class25.field643 == 85 && class33.field764.length() > 0) {
                                 class33.field764 = class33.field764.substring(0, class33.field764.length() - 1);
                              }

                              if(class25.field643 == 84) {
                                 class109.method2475();
                                 return;
                              }

                              if(var14 && class33.field764.length() < 320) {
                                 class33.field764 = class33.field764 + class51.field1146;
                              }
                           }
                        }
                     } else if(class33.field761 == 6) {
                        while(true) {
                           do {
                              if(!class151.method3275()) {
                                 var12 = 321;
                                 if(var1 == 1 && var10 >= var12 - 20 && var10 <= 20 + var12) {
                                    class33.field748 = "";
                                    class33.field762 = "Enter your username/email & password.";
                                    class33.field755 = "";
                                    class33.field761 = 2;
                                    class33.field769 = 0;
                                    class33.field765 = "";
                                 }

                                 return;
                              }
                           } while(class25.field643 != 84 && class25.field643 != 13);

                           class33.field748 = "";
                           class33.field762 = "Enter your username/email & password.";
                           class33.field755 = "";
                           class33.field761 = 2;
                           class33.field769 = 0;
                           class33.field765 = "";
                        }
                     }
                  }
               } else {
                  while(class151.method3275()) {
                     if(class25.field643 == 84) {
                        class33.field748 = "";
                        class33.field762 = "Enter your username/email & password.";
                        class33.field755 = "";
                        class33.field761 = 2;
                        class33.field769 = 0;
                     } else if(class25.field643 == 13) {
                        class33.field761 = 0;
                     }
                  }

                  var11 = 180 + class33.field777 - 80;
                  var5 = 321;
                  if(var1 == 1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                     class33.field748 = "";
                     class33.field762 = "Enter your username/email & password.";
                     class33.field755 = "";
                     class33.field761 = 2;
                     class33.field769 = 0;
                  }

                  var11 = class33.field777 + 180 + 80;
                  if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                     class33.field761 = 0;
                  }
               }

            }
         }
      }
   }
}
