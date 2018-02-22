import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
final class class18 implements Comparator {
   @ObfuscatedName("my")
   @ObfuscatedSignature(
      signature = "Lfu;"
   )
   @Export("mouseWheel")
   static MouseWheel mouseWheel;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   @Export("ItemDefinition_modelIndexCache")
   public static IndexDataBase ItemDefinition_modelIndexCache;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1919042789
   )
   static int field300;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ls;Ls;I)I",
      garbageValue = "-2146871174"
   )
   int method135(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.method76().compareTo(var2.method76());
   }

   public int compare(Object var1, Object var2) {
      return this.method135((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1413657203"
   )
   static final void method143(int var0) {
      short var1 = 256;
      class89.field1308 += var0 * 128;
      int var2;
      if(class89.field1308 > class36.field471.length) {
         class89.field1308 -= class36.field471.length;
         var2 = (int)(Math.random() * 12.0D);
         class246.method4510(class89.runeSprites[var2]);
      }

      var2 = 0;
      int var3 = var0 * 128;
      int var4 = (var1 - var0) * 128;

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = class89.field1307[var3 + var2] - class36.field471[var2 + class89.field1308 & class36.field471.length - 1] * var0 / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         class89.field1307[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = var5 * 128;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               class89.field1307[var6 + var7] = 255;
            } else {
               class89.field1307[var7 + var6] = 0;
            }
         }
      }

      if(class89.field1330 > 0) {
         class89.field1330 -= var0 * 4;
      }

      if(class89.field1306 > 0) {
         class89.field1306 -= var0 * 4;
      }

      if(class89.field1330 == 0 && class89.field1306 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class89.field1330 = 1024;
         }

         if(var5 == 1) {
            class89.field1306 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class89.field1304[var5] = class89.field1304[var0 + var5];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class89.field1304[var5] = (int)(Math.sin((double)class89.field1335 / 14.0D) * 16.0D + Math.sin((double)class89.field1335 / 15.0D) * 14.0D + Math.sin((double)class89.field1335 / 16.0D) * 12.0D);
         ++class89.field1335;
      }

      class89.field1309 += var0;
      var5 = (var0 + (Client.gameCycle & 1)) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class89.field1309 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            class89.field1307[var7 + (var8 << 7)] = 192;
         }

         class89.field1309 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = var6 * 128;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var9 + var5 < 128) {
                  var7 += class89.field1307[var5 + var8 + var9];
               }

               if(var9 - (var5 + 1) >= 0) {
                  var7 -= class89.field1307[var9 + var8 - (var5 + 1)];
               }

               if(var9 >= 0) {
                  DynamicObject.field1422[var9 + var8] = var7 / (var5 * 2 + 1);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = var8 * 128;
               if(var8 + var5 < var1) {
                  var7 += DynamicObject.field1422[var5 * 128 + var6 + var9];
               }

               if(var8 - (var5 + 1) >= 0) {
                  var7 -= DynamicObject.field1422[var6 + var9 - (var5 + 1) * 128];
               }

               if(var8 >= 0) {
                  class89.field1307[var6 + var9] = var7 / (var5 * 2 + 1);
               }
            }
         }
      }

   }

   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2088567454"
   )
   static void method146(int var0) {
      if(var0 == -3) {
         class194.method3794("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class194.method3794("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class194.method3794("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class89.loginIndex = 3;
      } else if(var0 == 4) {
         class194.method3794("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class194.method3794("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         class194.method3794("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class194.method3794("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class194.method3794("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class194.method3794("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class194.method3794("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class194.method3794("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class194.method3794("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class194.method3794("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class194.method3794("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class194.method3794("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class194.method3794("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class194.method3794("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class194.method3794("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class194.method3794("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class194.method3794("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class194.method3794("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class194.method3794("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class194.method3794("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class194.method3794("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class194.method3794("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class194.method3794("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class194.method3794("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class194.method3794("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class194.method3794("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class194.method3794("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class194.method3794("Enter the 6-digit code generated by your", "authenticator app.", "");
            WorldMapType1.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class194.method3794("The code you entered was incorrect.", "Please try again.", "");
            WorldMapType1.setGameState(11);
            return;
         }

         class194.method3794("Unexpected server response", "Please try using a different world.", "");
      }

      WorldMapType1.setGameState(10);
   }
}
