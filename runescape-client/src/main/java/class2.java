import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public class class2 {
   @ObfuscatedName("q")
   String field16;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -4796870220854322847L
   )
   public final long field17;
   @ObfuscatedName("x")
   public final XGrandExchangeOffer field18;
   @ObfuscatedName("d")
   String field20;
   @ObfuscatedName("en")
   static SpritePixels field21;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1057225449
   )
   public final int field24;
   @ObfuscatedName("po")
   static class116 field26;

   class2(Buffer var1, byte var2, int var3) {
      this.field16 = var1.method2846();
      this.field20 = var1.method2846();
      this.field24 = var1.readUnsignedShort();
      this.field17 = var1.method2820();
      int var4 = var1.method2819();
      int var5 = var1.method2819();
      this.field18 = new XGrandExchangeOffer();
      this.field18.method63(2);
      this.field18.method50(var2);
      this.field18.price = var4;
      this.field18.totalQuantity = var5;
      this.field18.quantitySold = 0;
      this.field18.spent = 0;
      this.field18.itemId = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1880779493"
   )
   public static String method22(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            char var6;
            if(var5 != 181 && var5 != 402) {
               var6 = Character.toTitleCase(var5);
            } else {
               var6 = var5;
            }

            var5 = var6;
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "334821224"
   )
   static final int method23(int var0, int var1) {
      int var2 = var0 + var1 * 57;
      var2 ^= var2 << 13;
      int var3 = var2 * (15731 * var2 * var2 + 789221) + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LGameEngine;I)V",
      garbageValue = "1073196596"
   )
   static void method28(GameEngine var0) {
      if(class41.worldSelectShown) {
         Ignore.method194(var0);
      } else {
         if((class115.field1813 == 1 || !class48.field937 && class115.field1813 == 4) && class115.field1811 >= 765 + class41.field818 - 50 && class115.field1812 >= 453) {
            class107.field1733.field693 = !class107.field1733.field693;
            class85.method1694();
            if(!class107.field1733.field693) {
               class101.method1945(class227.field3228, "scape main", "", 255, false);
            } else {
               class138.field1920.method2513();
               class138.field1921 = 1;
               Item.field887 = null;
            }
         }

         if(Client.gameState != 5) {
            ++class41.field834;
            if(Client.gameState == 10 || Client.gameState == 11) {
               int var1;
               if(Client.field353 == 0) {
                  if(class115.field1813 == 1 || !class48.field937 && class115.field1813 == 4) {
                     var1 = class41.field818 + 5;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(class115.field1811 >= var1 && class115.field1811 <= var1 + var3 && class115.field1812 >= var2 && class115.field1812 <= var4 + var2) {
                        if(Ignore.loadWorlds()) {
                           class41.worldSelectShown = true;
                        }

                        return;
                     }
                  }

                  if(null != class13.worldServersDownload && Ignore.loadWorlds()) {
                     class41.worldSelectShown = true;
                  }
               }

               var1 = class115.field1813;
               int var9 = class115.field1811;
               int var10 = class115.field1812;
               if(!class48.field937 && var1 == 4) {
                  var1 = 1;
               }

               short var5;
               int var11;
               if(class41.loginIndex == 0) {
                  var11 = 180 + class41.loginWindowX - 80;
                  var5 = 291;
                  if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                     NPC.method714(MessageNode.method203("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var11 = 80 + class41.loginWindowX + 180;
                  if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                     if((Client.flags & 33554432) != 0) {
                        class41.field822 = "";
                        class41.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class41.loginMessage2 = "Your normal account will not be affected.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else if((Client.flags & 4) != 0) {
                        if((Client.flags & 1024) != 0) {
                           class41.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class41.loginMessage2 = "Players can attack each other almost everywhere";
                           class41.loginMessage3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class41.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class41.loginMessage2 = "Players can attack each other";
                           class41.loginMessage3 = "almost everywhere.";
                        }

                        class41.field822 = "Warning!";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class41.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class41.loginMessage2 = "The Protect Item prayer will";
                        class41.loginMessage3 = "not work on this world.";
                        class41.field822 = "Warning!";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     }
                  }
               } else if(class41.loginIndex != 1) {
                  short var12;
                  if(class41.loginIndex == 2) {
                     var12 = 231;
                     var11 = var12 + 30;
                     if(var1 == 1 && var10 >= var11 - 15 && var10 < var11) {
                        class41.loginIndex2 = 0;
                     }

                     var11 += 15;
                     if(var1 == 1 && var10 >= var11 - 15 && var10 < var11) {
                        class41.loginIndex2 = 1;
                     }

                     var11 += 15;
                     var12 = 361;
                     if(var1 == 1 && var10 >= var12 - 15 && var10 < var12) {
                        MessageNode.method204("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class41.loginIndex = 5;
                        return;
                     }

                     int var13 = class41.loginWindowX + 180 - 80;
                     short var6 = 321;
                     if(var1 == 1 && var9 >= var13 - 75 && var9 <= var13 + 75 && var10 >= var6 - 20 && var10 <= 20 + var6) {
                        class41.username = class41.username.trim();
                        if(class41.username.length() == 0) {
                           MessageNode.method204("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class41.field844.length() == 0) {
                           MessageNode.method204("", "Please enter your password.", "");
                           return;
                        }

                        MessageNode.method204("", "Connecting to server...", "");
                        class41.field845 = class107.field1733.field688.containsKey(Integer.valueOf(class186.method3408(class41.username)))?class97.field1633:class97.field1630;
                        class212.setGameState(20);
                        return;
                     }

                     var13 = 80 + class41.loginWindowX + 180;
                     if(var1 == 1 && var9 >= var13 - 75 && var9 <= 75 + var13 && var10 >= var6 - 20 && var10 <= var6 + 20) {
                        class41.loginIndex = 0;
                        class41.username = "";
                        class41.field844 = "";
                        class31.field713 = 0;
                        ChatMessages.authCode = "";
                        class41.field846 = true;
                     }

                     while(true) {
                        while(class65.method1142()) {
                           boolean var7 = false;

                           for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                              if(VertexNormal.field1424 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                 var7 = true;
                                 break;
                              }
                           }

                           if(class109.field1744 == 13) {
                              class41.loginIndex = 0;
                              class41.username = "";
                              class41.field844 = "";
                              class31.field713 = 0;
                              ChatMessages.authCode = "";
                              class41.field846 = true;
                           } else if(class41.loginIndex2 == 0) {
                              if(class109.field1744 == 85 && class41.username.length() > 0) {
                                 class41.username = class41.username.substring(0, class41.username.length() - 1);
                              }

                              if(class109.field1744 == 84 || class109.field1744 == 80) {
                                 class41.loginIndex2 = 1;
                              }

                              if(var7 && class41.username.length() < 320) {
                                 class41.username = class41.username + VertexNormal.field1424;
                              }
                           } else if(class41.loginIndex2 == 1) {
                              if(class109.field1744 == 85 && class41.field844.length() > 0) {
                                 class41.field844 = class41.field844.substring(0, class41.field844.length() - 1);
                              }

                              if(class109.field1744 == 84 || class109.field1744 == 80) {
                                 class41.loginIndex2 = 0;
                              }

                              if(class109.field1744 == 84) {
                                 class41.username = class41.username.trim();
                                 if(class41.username.length() == 0) {
                                    MessageNode.method204("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class41.field844.length() == 0) {
                                    MessageNode.method204("", "Please enter your password.", "");
                                    return;
                                 }

                                 MessageNode.method204("", "Connecting to server...", "");
                                 class41.field845 = class107.field1733.field688.containsKey(Integer.valueOf(class186.method3408(class41.username)))?class97.field1633:class97.field1630;
                                 class212.setGameState(20);
                                 return;
                              }

                              if(var7 && class41.field844.length() < 20) {
                                 class41.field844 = class41.field844 + VertexNormal.field1424;
                              }
                           }
                        }

                        return;
                     }
                  } else if(class41.loginIndex == 3) {
                     var11 = class41.loginWindowX + 180;
                     var5 = 276;
                     if(var1 == 1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     }

                     var11 = class41.loginWindowX + 180;
                     var5 = 326;
                     if(var1 == 1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                        MessageNode.method204("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class41.loginIndex = 5;
                        return;
                     }
                  } else {
                     boolean var14;
                     int var15;
                     if(class41.loginIndex == 4) {
                        var11 = 180 + class41.loginWindowX - 80;
                        var5 = 321;
                        if(var1 == 1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                           ChatMessages.authCode.trim();
                           if(ChatMessages.authCode.length() != 6) {
                              MessageNode.method204("", "Please enter a 6-digit PIN.", "");
                              return;
                           }

                           class31.field713 = Integer.parseInt(ChatMessages.authCode);
                           ChatMessages.authCode = "";
                           class41.field845 = class41.field846?class97.field1629:class97.field1631;
                           MessageNode.method204("", "Connecting to server...", "");
                           class212.setGameState(20);
                           return;
                        }

                        if(var1 == 1 && var9 >= 180 + class41.loginWindowX - 9 && var9 <= 130 + 180 + class41.loginWindowX && var10 >= 263 && var10 <= 296) {
                           class41.field846 = !class41.field846;
                        }

                        if(var1 == 1 && var9 >= class41.loginWindowX + 180 - 34 && var9 <= class41.loginWindowX + 180 + 34 && var10 >= 351 && var10 <= 363) {
                           NPC.method714(MessageNode.method203("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                        }

                        var11 = class41.loginWindowX + 180 + 80;
                        if(var1 == 1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                           class41.loginIndex = 0;
                           class41.username = "";
                           class41.field844 = "";
                           class31.field713 = 0;
                           ChatMessages.authCode = "";
                        }

                        while(class65.method1142()) {
                           var14 = false;

                           for(var15 = 0; var15 < "1234567890".length(); ++var15) {
                              if(VertexNormal.field1424 == "1234567890".charAt(var15)) {
                                 var14 = true;
                                 break;
                              }
                           }

                           if(class109.field1744 == 13) {
                              class41.loginIndex = 0;
                              class41.username = "";
                              class41.field844 = "";
                              class31.field713 = 0;
                              ChatMessages.authCode = "";
                           } else {
                              if(class109.field1744 == 85 && ChatMessages.authCode.length() > 0) {
                                 ChatMessages.authCode = ChatMessages.authCode.substring(0, ChatMessages.authCode.length() - 1);
                              }

                              if(class109.field1744 == 84) {
                                 ChatMessages.authCode.trim();
                                 if(ChatMessages.authCode.length() != 6) {
                                    MessageNode.method204("", "Please enter a 6-digit PIN.", "");
                                    return;
                                 }

                                 class31.field713 = Integer.parseInt(ChatMessages.authCode);
                                 ChatMessages.authCode = "";
                                 class41.field845 = class41.field846?class97.field1629:class97.field1631;
                                 MessageNode.method204("", "Connecting to server...", "");
                                 class212.setGameState(20);
                                 return;
                              }

                              if(var14 && ChatMessages.authCode.length() < 6) {
                                 ChatMessages.authCode = ChatMessages.authCode + VertexNormal.field1424;
                              }
                           }
                        }
                     } else if(class41.loginIndex == 5) {
                        var11 = 180 + class41.loginWindowX - 80;
                        var5 = 321;
                        if(var1 == 1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                           CombatInfo1.method601();
                           return;
                        }

                        var11 = 80 + class41.loginWindowX + 180;
                        if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                           class41.loginMessage1 = "";
                           class41.loginMessage2 = "Enter your username/email & password.";
                           class41.loginMessage3 = "";
                           class41.loginIndex = 2;
                           class41.loginIndex2 = 0;
                           class41.field844 = "";
                        }

                        while(class65.method1142()) {
                           var14 = false;

                           for(var15 = 0; var15 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var15) {
                              if(VertexNormal.field1424 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var15)) {
                                 var14 = true;
                                 break;
                              }
                           }

                           if(class109.field1744 == 13) {
                              class41.loginMessage1 = "";
                              class41.loginMessage2 = "Enter your username/email & password.";
                              class41.loginMessage3 = "";
                              class41.loginIndex = 2;
                              class41.loginIndex2 = 0;
                              class41.field844 = "";
                           } else {
                              if(class109.field1744 == 85 && class41.username.length() > 0) {
                                 class41.username = class41.username.substring(0, class41.username.length() - 1);
                              }

                              if(class109.field1744 == 84) {
                                 CombatInfo1.method601();
                                 return;
                              }

                              if(var14 && class41.username.length() < 320) {
                                 class41.username = class41.username + VertexNormal.field1424;
                              }
                           }
                        }
                     } else if(class41.loginIndex == 6) {
                        while(true) {
                           do {
                              if(!class65.method1142()) {
                                 var12 = 321;
                                 if(var1 == 1 && var10 >= var12 - 20 && var10 <= 20 + var12) {
                                    class41.loginMessage1 = "";
                                    class41.loginMessage2 = "Enter your username/email & password.";
                                    class41.loginMessage3 = "";
                                    class41.loginIndex = 2;
                                    class41.loginIndex2 = 0;
                                    class41.field844 = "";
                                 }

                                 return;
                              }
                           } while(class109.field1744 != 84 && class109.field1744 != 13);

                           class41.loginMessage1 = "";
                           class41.loginMessage2 = "Enter your username/email & password.";
                           class41.loginMessage3 = "";
                           class41.loginIndex = 2;
                           class41.loginIndex2 = 0;
                           class41.field844 = "";
                        }
                     }
                  }
               } else {
                  while(class65.method1142()) {
                     if(class109.field1744 == 84) {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     } else if(class109.field1744 == 13) {
                        class41.loginIndex = 0;
                     }
                  }

                  var11 = 180 + class41.loginWindowX - 80;
                  var5 = 321;
                  if(var1 == 1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                     class41.loginMessage1 = "";
                     class41.loginMessage2 = "Enter your username/email & password.";
                     class41.loginMessage3 = "";
                     class41.loginIndex = 2;
                     class41.loginIndex2 = 0;
                  }

                  var11 = 80 + class41.loginWindowX + 180;
                  if(var1 == 1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                     class41.loginIndex = 0;
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "15"
   )
   public String method29() {
      return this.field16;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)Lclass48;",
      garbageValue = "22"
   )
   static class48 method30(int var0) {
      class48 var1 = (class48)class48.field952.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class8.field74.getConfigData(var0, 0);
         if(null == var2) {
            return null;
         } else {
            var1 = new class48();
            Buffer var3 = new Buffer(var2);
            var3.offset = var3.payload.length - 12;
            int var4 = var3.method2819();
            var1.field938 = var3.readUnsignedShort();
            var1.field942 = var3.readUnsignedShort();
            var1.field943 = var3.readUnsignedShort();
            var1.field944 = var3.readUnsignedShort();
            var3.offset = 0;
            var3.method2821();
            var1.field941 = new int[var4];
            var1.field947 = new int[var4];
            var1.field940 = new String[var4];

            int var6;
            for(int var5 = 0; var3.offset < var3.payload.length - 12; var1.field941[var5++] = var6) {
               var6 = var3.readUnsignedShort();
               if(var6 == 3) {
                  var1.field940[var5] = var3.method2846();
               } else if(var6 < 100 && var6 != 21 && var6 != 38 && var6 != 39) {
                  var1.field947[var5] = var3.method2819();
               } else {
                  var1.field947[var5] = var3.readUnsignedByte();
               }
            }

            class48.field952.put(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "2119842552"
   )
   public String method31() {
      return this.field20;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "2113550116"
   )
   public static byte[] method32(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var6 = (byte[])((byte[])var0);
         if(var1) {
            int var4 = var6.length;
            byte[] var5 = new byte[var4];
            System.arraycopy(var6, 0, var5, 0, var4);
            return var5;
         } else {
            return var6;
         }
      } else if(var0 instanceof class156) {
         class156 var2 = (class156)var0;
         return var2.vmethod3013();
      } else {
         throw new IllegalArgumentException();
      }
   }
}
