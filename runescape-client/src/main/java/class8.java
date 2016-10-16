import java.awt.Font;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class8 {
   @ObfuscatedName("pb")
   public static class139 field121;
   @ObfuscatedName("t")
   boolean field123;
   @ObfuscatedName("y")
   boolean field124;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1275251823
   )
   int field125 = 1;
   @ObfuscatedName("g")
   LinkedHashMap field126 = new LinkedHashMap();
   @ObfuscatedName("nr")
   @ObfuscatedGetter(
      intValue = -1295320897
   )
   static int field127;
   @ObfuscatedName("m")
   static int[] field129;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1169908963
   )
   static int field130 = 4;
   @ObfuscatedName("qv")
   protected static Font field131;
   @ObfuscatedName("db")
   @ObfuscatedGetter(
      intValue = 781255923
   )
   @Export("baseY")
   static int baseY;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)LBuffer;",
      garbageValue = "109"
   )
   Buffer method107() {
      Buffer var1 = new Buffer(100);
      var1.method2467(field130);
      var1.method2467(this.field123?1:0);
      var1.method2467(this.field124?1:0);
      var1.method2467(this.field125);
      var1.method2467(this.field126.size());
      Iterator var2 = this.field126.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2642(((Integer)var3.getKey()).intValue());
         var1.method2642(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   static void method108(int var0) {
      if(var0 == -3) {
         class79.method1681("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class79.method1681("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class79.method1681("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class33.loginIndex = 3;
      } else if(var0 == 4) {
         class79.method1681("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class79.method1681("Your account is already logged in.", "Try again in 60 secs...", "");
      } else if(var0 == 6) {
         class79.method1681("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class79.method1681("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class79.method1681("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class79.method1681("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class79.method1681("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class79.method1681("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class79.method1681("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class79.method1681("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class79.method1681("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class79.method1681("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class79.method1681("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class79.method1681("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class79.method1681("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class79.method1681("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class79.method1681("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class79.method1681("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class79.method1681("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class79.method1681("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class79.method1681("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class79.method1681("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class79.method1681("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class79.method1681("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class79.method1681("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class79.method1681("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class79.method1681("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class79.method1681("Enter the 6-digit code generated by your", "authenticator app.", "");
            class112.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class79.method1681("The code you entered was incorrect.", "Please try again.", "");
            class112.setGameState(11);
            return;
         }

         class79.method1681("Unexpected server response", "Please try using a different world.", "");
      }

      class112.setGameState(10);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "1"
   )
   void method109(boolean var1) {
   }

   class8(Buffer var1) {
      if(var1 != null && var1.payload != null) {
         int var2 = var1.method2481();
         if(var2 >= 0 && var2 <= field130) {
            if(var1.method2481() == 1) {
               this.field123 = true;
            }

            if(var2 > 1) {
               this.field124 = var1.method2481() == 1;
            }

            if(var2 > 3) {
               this.field125 = var1.method2481();
            }

            if(var2 > 2) {
               int var3 = var1.method2481();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method2526();
                  int var6 = var1.method2526();
                  this.field126.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method109(true);
         }
      } else {
         this.method109(true);
      }

   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;LWidget;I)Ljava/lang/String;",
      garbageValue = "-1536443025"
   )
   static String method116(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               String var4 = var0.substring(0, var3);
               int var6 = Projectile.method87(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(2 + var3);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var7 = "";
            if(class54.field1129 != null) {
               var7 = class158.method3157(class54.field1129.field2254);
               if(null != class54.field1129.field2261) {
                  var7 = (String)class54.field1129.field2261;
               }
            }

            var0 = var0.substring(0, var2) + var7 + var0.substring(4 + var2);
         }
      }

      return var0;
   }

   class8() {
      this.method109(true);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "-2"
   )
   public static int method117(CharSequence var0) {
      return class54.method1075(var0, 10, true);
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(LNPCComposition;IIII)V",
      garbageValue = "935369018"
   )
   static final void method118(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(null != var0.field897) {
            var0 = var0.method790();
         }

         if(var0 != null) {
            if(var0.field900) {
               if(!var0.field874 || Client.field436 == var1) {
                  String var4 = var0.name;
                  if(var0.combatLevel != 0) {
                     var4 = var4 + class9.method120(var0.combatLevel, TextureProvider.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(Client.field421 == 1) {
                     class10.addMenuEntry("Use", Client.field416 + " " + "->" + " " + class188.method3706(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.field270) {
                     if((class124.field2042 & 2) == 2) {
                        class10.addMenuEntry(Client.field333, Client.field497 + " " + "->" + " " + class188.method3706(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     String[] var5 = var0.actions;
                     if(Client.field439) {
                        var5 = MessageNode.method755(var5);
                     }

                     int var6;
                     if(null != var5) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(var5[var6] != null && !var5[var6].equalsIgnoreCase("Attack")) {
                              byte var7 = 0;
                              if(var6 == 0) {
                                 var7 = 9;
                              }

                              if(var6 == 1) {
                                 var7 = 10;
                              }

                              if(var6 == 2) {
                                 var7 = 11;
                              }

                              if(var6 == 3) {
                                 var7 = 12;
                              }

                              if(var6 == 4) {
                                 var7 = 13;
                              }

                              class10.addMenuEntry(var5[var6], class188.method3706(16776960) + var4, var7, var1, var2, var3);
                           }
                        }
                     }

                     if(null != var5) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(null != var5[var6] && var5[var6].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(Client.field293 != class21.field564) {
                                 if(Client.field293 == class21.field561 || Client.field293 == class21.field562 && var0.combatLevel > TextureProvider.localPlayer.combatLevel) {
                                    var9 = 2000;
                                 }

                                 int var8 = 0;
                                 if(var6 == 0) {
                                    var8 = var9 + 9;
                                 }

                                 if(var6 == 1) {
                                    var8 = 10 + var9;
                                 }

                                 if(var6 == 2) {
                                    var8 = var9 + 11;
                                 }

                                 if(var6 == 3) {
                                    var8 = var9 + 12;
                                 }

                                 if(var6 == 4) {
                                    var8 = 13 + var9;
                                 }

                                 class10.addMenuEntry(var5[var6], class188.method3706(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     class10.addMenuEntry("Examine", class188.method3706(16776960) + var4, 1003, var1, var2, var3);
                  }

               }
            }
         }
      }
   }
}
