import java.awt.FontMetrics;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class11 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lw;"
   )
   public static final class11 field255;
   @ObfuscatedName("av")
   static FontMetrics field254;
   @ObfuscatedName("en")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   static Task field256;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lw;"
   )
   public static final class11 field253;

   static {
      field255 = new class11();
      field253 = new class11();
   }

   @ObfuscatedName("eq")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-28652"
   )
   static void method53(int var0) {
      if(var0 == -3) {
         class22.method165("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class22.method165("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class22.method165("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class92.loginIndex = 3;
      } else if(var0 == 4) {
         class22.method165("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class22.method165("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         class22.method165("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class22.method165("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class22.method165("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class22.method165("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class22.method165("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class22.method165("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class22.method165("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class22.method165("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class22.method165("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class22.method165("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class22.method165("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class22.method165("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class22.method165("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class22.method165("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class22.method165("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class22.method165("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class22.method165("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class22.method165("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class22.method165("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class22.method165("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class22.method165("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class22.method165("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class22.method165("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class22.method165("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class22.method165("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class22.method165("Enter the 6-digit code generated by your", "authenticator app.", "");
            class152.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class22.method165("The code you entered was incorrect.", "Please try again.", "");
            class152.setGameState(11);
            return;
         }

         class22.method165("Unexpected server response", "Please try using a different world.", "");
      }

      class152.setGameState(10);
   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "(Lho;I)Z",
      garbageValue = "-1273201164"
   )
   static boolean method55(Widget var0) {
      if(Client.field1074) {
         if(class60.getWidgetConfig(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "(IIIB)Lbp;",
      garbageValue = "45"
   )
   static final WidgetNode method54(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.owner = var2;
      Client.componentTable.put(var3, (long)var0);
      class44.method599(var1);
      Widget var4 = class239.method4167(var0);
      class21.method156(var4);
      if(Client.field1068 != null) {
         class21.method156(Client.field1068);
         Client.field1068 = null;
      }

      class7.method37();
      class77.method1465(Widget.widgets[var0 >> 16], var4, false);
      class157.method2907(var1);
      if(Client.widgetRoot != -1) {
         class208.method3824(Client.widgetRoot, 1);
      }

      return var3;
   }
}
