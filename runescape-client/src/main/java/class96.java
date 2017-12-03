import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
public class class96 {
   @ObfuscatedName("a")
   @Export("chatLineMap")
   static final Map chatLineMap;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("messages")
   static final IterableHashTable messages;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   static final IterableDualNodeQueue field1414;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2125472343
   )
   static int field1416;
   @ObfuscatedName("f")
   static byte[][][] field1418;

   static {
      chatLineMap = new HashMap();
      messages = new IterableHashTable(1024);
      field1414 = new IterableDualNodeQueue();
      field1416 = 0;
   }

   @ObfuscatedName("a")
   public static String method1808(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class279.field3739[(int)(var6 - 37L * var0)];
               if(var8 == '_') {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("ex")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   static void method1815(int var0) {
      if(var0 == -3) {
         class64.method1033("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class64.method1033("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class64.method1033("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class91.loginIndex = 3;
      } else if(var0 == 4) {
         class64.method1033("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class64.method1033("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         class64.method1033("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class64.method1033("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class64.method1033("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class64.method1033("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class64.method1033("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class64.method1033("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class64.method1033("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class64.method1033("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class64.method1033("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class64.method1033("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class64.method1033("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class64.method1033("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class64.method1033("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class64.method1033("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class64.method1033("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class64.method1033("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class64.method1033("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class64.method1033("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class64.method1033("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class64.method1033("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class64.method1033("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class64.method1033("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class64.method1033("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class64.method1033("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class64.method1033("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class64.method1033("Enter the 6-digit code generated by your", "authenticator app.", "");
            Friend.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class64.method1033("The code you entered was incorrect.", "Please try again.", "");
            Friend.setGameState(11);
            return;
         }

         class64.method1033("Unexpected server response", "Please try using a different world.", "");
      }

      Friend.setGameState(10);
   }

   @ObfuscatedName("en")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-78"
   )
   static final void method1831() {
      Client.field888.close();
      class5.method16();
      class48.region.reset();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].reset();
      }

      System.gc();
      class214.field2620 = 1;
      class214.field2623 = null;
      class61.field692 = -1;
      class282.field3754 = -1;
      class214.field2625 = 0;
      IndexFile.field2181 = false;
      Timer.field2159 = 2;
      Client.field850 = -1;
      Client.field1008 = false;
      class27.method218();
      Friend.setGameState(10);
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(IIII)Lbt;",
      garbageValue = "1141618675"
   )
   static final WidgetNode method1828(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.owner = var2;
      Client.componentTable.put(var3, (long)var0);
      class33.method343(var1);
      Widget var4 = VertexNormal.getWidget(var0);
      class33.method344(var4);
      if(Client.field958 != null) {
         class33.method344(Client.field958);
         Client.field958 = null;
      }

      GrandExchangeEvent.method82();
      GrandExchangeOffer.method102(Widget.widgets[var0 >> 16], var4, false);
      class11.method52(var1);
      if(Client.widgetRoot != -1) {
         int var5 = Client.widgetRoot;
         if(GraphicsObject.loadWidget(var5)) {
            class22.method165(Widget.widgets[var5], 1);
         }
      }

      return var3;
   }
}
