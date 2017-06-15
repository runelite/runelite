import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -792985375
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 597009847
   )
   @Export("type")
   int type;
   @ObfuscatedName("t")
   @Export("name")
   String name;
   @ObfuscatedName("z")
   @Export("value")
   String value;
   @ObfuscatedName("w")
   @Export("sender")
   String sender;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 943787049
   )
   @Export("id")
   int id;
   @ObfuscatedName("pn")
   @ObfuscatedGetter(
      intValue = 1425817251
   )
   static int field856;

   MessageNode(int var1, String var2, String var3, String var4) {
      this.id = class90.method1620();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1338727180"
   )
   void method1053(int var1, String var2, String var3, String var4) {
      this.id = class90.method1620();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-265908772"
   )
   static final void method1055() {
      Client.secretPacketBuffer2.method3291();
      int var0 = Client.secretPacketBuffer2.method3290(8);
      int var1;
      if(var0 < Client.field930) {
         for(var1 = var0; var1 < Client.field930; ++var1) {
            Client.field1030[++Client.field1029 - 1] = Client.npcIndices[var1];
         }
      }

      if(var0 > Client.field930) {
         throw new RuntimeException("");
      } else {
         Client.field930 = 0;

         for(var1 = 0; var1 < var0; ++var1) {
            int var2 = Client.npcIndices[var1];
            NPC var3 = Client.cachedNPCs[var2];
            int var4 = Client.secretPacketBuffer2.method3290(1);
            if(var4 == 0) {
               Client.npcIndices[++Client.field930 - 1] = var2;
               var3.field1240 = Client.gameCycle;
            } else {
               int var5 = Client.secretPacketBuffer2.method3290(2);
               if(var5 == 0) {
                  Client.npcIndices[++Client.field930 - 1] = var2;
                  var3.field1240 = Client.gameCycle;
                  Client.field946[++Client.field1096 - 1] = var2;
               } else {
                  int var6;
                  int var7;
                  if(var5 == 1) {
                     Client.npcIndices[++Client.field930 - 1] = var2;
                     var3.field1240 = Client.gameCycle;
                     var6 = Client.secretPacketBuffer2.method3290(3);
                     var3.method1586(var6, (byte)1);
                     var7 = Client.secretPacketBuffer2.method3290(1);
                     if(var7 == 1) {
                        Client.field946[++Client.field1096 - 1] = var2;
                     }
                  } else if(var5 == 2) {
                     Client.npcIndices[++Client.field930 - 1] = var2;
                     var3.field1240 = Client.gameCycle;
                     var6 = Client.secretPacketBuffer2.method3290(3);
                     var3.method1586(var6, (byte)2);
                     var7 = Client.secretPacketBuffer2.method3290(3);
                     var3.method1586(var7, (byte)2);
                     int var8 = Client.secretPacketBuffer2.method3290(1);
                     if(var8 == 1) {
                        Client.field946[++Client.field1096 - 1] = var2;
                     }
                  } else if(var5 == 3) {
                     Client.field1030[++Client.field1029 - 1] = var2;
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("jb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "282278338"
   )
   static final void method1056() {
      Client.secretPacketBuffer1.putOpcode(105);
      Client.secretPacketBuffer1.putByte(0);
   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-47"
   )
   static void method1057(int var0, int var1) {
      Ignore.method1043(class243.field3325, var0, var1);
      class243.field3325 = null;
   }

   @ObfuscatedName("ex")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "71"
   )
   static void method1058(int var0) {
      if(var0 == -3) {
         class47.method674("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class47.method674("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class47.method674("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class92.loginIndex = 3;
      } else if(var0 == 4) {
         class47.method674("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class47.method674("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         class47.method674("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class47.method674("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class47.method674("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class47.method674("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class47.method674("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class47.method674("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class47.method674("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class47.method674("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class47.method674("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class47.method674("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class47.method674("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class47.method674("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class47.method674("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class47.method674("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class47.method674("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class47.method674("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class47.method674("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class47.method674("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class47.method674("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class47.method674("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class47.method674("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class47.method674("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class47.method674("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class47.method674("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class47.method674("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class47.method674("Enter the 6-digit code generated by your", "authenticator app.", "");
            class23.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class47.method674("The code you entered was incorrect.", "Please try again.", "");
            class23.setGameState(11);
            return;
         }

         class47.method674("Unexpected server response", "Please try using a different world.", "");
      }

      class23.setGameState(10);
   }
}
