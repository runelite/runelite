import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
@Implements("WorldMapDecoration")
public class WorldMapDecoration {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1304585155
   )
   static int field167;
   @ObfuscatedName("j")
   static int[][] field162;
   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   @Export("loginType")
   static JagexLoginType loginType;
   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   @Export("indexCache3")
   static IndexData indexCache3;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 562997841
   )
   @Export("objectDefinitionId")
   final int objectDefinitionId;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1184023187
   )
   @Export("decoration")
   final int decoration;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 707908647
   )
   @Export("rotation")
   final int rotation;

   WorldMapDecoration(int var1, int var2, int var3) {
      this.objectDefinitionId = var1;
      this.decoration = var2;
      this.rotation = var3;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Ldu;I)V",
      garbageValue = "217117259"
   )
   static final void method222(TaskDataNode var0) {
      var0.field1409 = false;
      if(var0.data != null) {
         var0.data.int1 = 0;
      }

      for(TaskDataNode var1 = var0.vmethod4421(); var1 != null; var1 = var0.vmethod4422()) {
         method222(var1);
      }

   }

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1362629320"
   )
   static void method221(int var0) {
      if(var0 == -3) {
         Resampler.method2307("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         Resampler.method2307("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         Resampler.method2307("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class78.loginIndex = 3;
      } else if(var0 == 4) {
         Resampler.method2307("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         Resampler.method2307("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         Resampler.method2307("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         Resampler.method2307("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         Resampler.method2307("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         Resampler.method2307("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         Resampler.method2307("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         Resampler.method2307("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         Resampler.method2307("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         Resampler.method2307("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         Resampler.method2307("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         Resampler.method2307("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         Resampler.method2307("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         Resampler.method2307("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         Resampler.method2307("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         Resampler.method2307("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         Resampler.method2307("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         Resampler.method2307("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         Resampler.method2307("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         Resampler.method2307("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         Resampler.method2307("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         Resampler.method2307("", "Service unavailable.", "");
      } else if(var0 == 31) {
         Resampler.method2307("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         Resampler.method2307("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         Resampler.method2307("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         Resampler.method2307("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class78.loginIndex = 8;
      } else {
         if(var0 == 56) {
            Resampler.method2307("Enter the 6-digit code generated by your", "authenticator app.", "");
            Resampler.setGameState(11);
            return;
         }

         if(var0 == 57) {
            Resampler.method2307("The code you entered was incorrect.", "Please try again.", "");
            Resampler.setGameState(11);
            return;
         }

         if(var0 == 61) {
            class78.loginIndex = 7;
         } else {
            Resampler.method2307("Unexpected server response", "Please try using a different world.", "");
         }
      }

      Resampler.setGameState(10);
   }

   @ObfuscatedName("jx")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-611935095"
   )
   static boolean method220() {
      return Client.field669 || KeyFocusListener.keyPressed[81];
   }
}
