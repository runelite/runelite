import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
final class class21 implements Comparator {
   @ObfuscatedName("n")
   public static String[] field588;
   @ObfuscatedName("bd")
   static class168 field591;
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;I)I",
      garbageValue = "-855156657"
   )
   int method643(class214 var1, class214 var2) {
      if(var2.field3155 == var1.field3155) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(client.field296 == var1.field3155) {
               return -1;
            }

            if(client.field296 == var2.field3155) {
               return 1;
            }
         }

         return var1.field3155 < var2.field3155?-1:1;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method643((class214)var1, (class214)var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "174641845"
   )
   static void method644(int var0) {
      if(var0 == -3) {
         class39.method878("Connection timed out.", "Please try using a different world.", "");
      } else if(-2 == var0) {
         class39.method878("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class39.method878("No response from server.", "Please try using a different world.", "");
      } else if(3 == var0) {
         class31.field726 = 3;
      } else if(var0 == 4) {
         class39.method878("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(5 == var0) {
         class39.method878("Your account is already logged in.", "Try again in 60 secs...", "");
      } else if(var0 == 6) {
         class39.method878("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class39.method878("This world is full.", "Please use a different world.", "");
      } else if(8 == var0) {
         class39.method878("Unable to connect.", "Login server offline.", "");
      } else if(9 == var0) {
         class39.method878("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class39.method878("Unable to connect.", "Bad session id.", "");
      } else if(11 == var0) {
         class39.method878("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class39.method878("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class39.method878("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class39.method878("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class39.method878("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(17 == var0) {
         class39.method878("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class39.method878("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class39.method878("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(20 == var0) {
         class39.method878("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(22 == var0) {
         class39.method878("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class39.method878("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class39.method878("Error loading your profile.", "Please contact customer support.", "");
      } else if(25 == var0) {
         class39.method878("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class39.method878("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(27 == var0) {
         class39.method878("", "Service unavailable.", "");
      } else if(31 == var0) {
         class39.method878("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class39.method878("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class39.method878("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class39.method878("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(55 == var0) {
         class39.method878("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(56 == var0) {
            class39.method878("Enter the 6-digit code generated by your", "authenticator app.", "");
            class3.method49(11);
            return;
         }

         if(57 == var0) {
            class39.method878("The code you entered was incorrect.", "Please try again.", "");
            class3.method49(11);
            return;
         }

         class39.method878("Unexpected server response", "Please try using a different world.", "");
      }

      class3.method49(10);
   }

   class21(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1629895476"
   )
   public static int method653(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }
}
