import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public abstract class class28 {
   @ObfuscatedName("lw")
   @ObfuscatedSignature(
      signature = "Lcr;"
   )
   @Export("chatMessages")
   static Varcs chatMessages;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lao;"
   )
   static class47 field380;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 90263743
   )
   static int field392;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -277573637
   )
   static int field390;
   @ObfuscatedName("bo")
   static String field393;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1027266783
   )
   int field391;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -155634581
   )
   int field379;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1380303627
   )
   int field385;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1121550813
   )
   int field381;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2013165057
   )
   int field389;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 425297541
   )
   int field383;
   @ObfuscatedName("b")
   short[][][] field384;
   @ObfuscatedName("t")
   short[][][] field386;
   @ObfuscatedName("p")
   byte[][][] field378;
   @ObfuscatedName("r")
   byte[][][] field387;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "[[[[Lau;"
   )
   class31[][][][] field388;

   class28() {
      new LinkedList();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IILfr;I)V",
      garbageValue = "973593322"
   )
   void method221(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if(var4 != 0) {
         if((var4 & 1) != 0) {
            this.method222(var1, var2, var3, var4);
         } else {
            this.method223(var1, var2, var3, var4);
         }

      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IILfr;II)V",
      garbageValue = "-2084837461"
   )
   void method222(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if(var5) {
         this.field386[0][var1][var2] = (short)var3.readUnsignedByte();
      }

      this.field384[0][var1][var2] = (short)var3.readUnsignedByte();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IILfr;II)V",
      garbageValue = "1612453869"
   )
   void method223(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.field384[0][var1][var2] = (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var11;
      if(var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var10 = var3.readUnsignedByte();
            if(var10 != 0) {
               this.field386[var9][var1][var2] = (short)var10;
               var11 = var3.readUnsignedByte();
               this.field378[var9][var1][var2] = (byte)(var11 >> 2);
               this.field387[var9][var1][var2] = (byte)(var11 & 3);
            }
         }
      }

      if(var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if(var9 != 0) {
               class31[] var14 = this.field388[var8][var1][var2] = new class31[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  int var12 = var3.method3444();
                  int var13 = var3.readUnsignedByte();
                  var14[var11] = new class31(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1308235560"
   )
   int method234(int var1, int var2) {
      return var1 >= 0 && var2 >= 0?(var1 < 64 && var2 < 64?this.field384[0][var1][var2] - 1:-1):-1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-20724"
   )
   int method224() {
      return this.field385;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   int method225() {
      return this.field381;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Leh;IIIII)V",
      garbageValue = "1129213741"
   )
   static final void method238(Model var0, int var1, int var2, int var3, int var4) {
      class7.boundingBoxes.addFirst(new BoundingBox3D(var0, var1, var2, var3, var4));
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/String;",
      garbageValue = "1"
   )
   public static String method240(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            char var6;
            if(var5 != 181 && var5 != 131) {
               var6 = Character.toTitleCase(var5);
            } else {
               var6 = var5;
            }

            var5 = var6;
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != '.' && var5 != '?' && var5 != '!') {
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1469935911"
   )
   public static void method239() {
      ItemComposition.itemSpriteCache.reset();
   }

   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1760669306"
   )
   static void method236(int var0) {
      if(var0 == -3) {
         NPC.method1749("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         NPC.method1749("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         NPC.method1749("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class91.loginIndex = 3;
      } else if(var0 == 4) {
         NPC.method1749("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         NPC.method1749("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         NPC.method1749("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         NPC.method1749("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         NPC.method1749("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         NPC.method1749("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         NPC.method1749("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         NPC.method1749("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         NPC.method1749("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         NPC.method1749("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         NPC.method1749("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         NPC.method1749("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         NPC.method1749("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         NPC.method1749("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         NPC.method1749("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         NPC.method1749("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         NPC.method1749("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         NPC.method1749("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         NPC.method1749("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         NPC.method1749("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         NPC.method1749("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         NPC.method1749("", "Service unavailable.", "");
      } else if(var0 == 31) {
         NPC.method1749("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         NPC.method1749("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         NPC.method1749("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         NPC.method1749("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         NPC.method1749("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            NPC.method1749("Enter the 6-digit code generated by your", "authenticator app.", "");
            WorldComparator.setGameState(11);
            return;
         }

         if(var0 == 57) {
            NPC.method1749("The code you entered was incorrect.", "Please try again.", "");
            WorldComparator.setGameState(11);
            return;
         }

         NPC.method1749("Unexpected server response", "Please try using a different world.", "");
      }

      WorldComparator.setGameState(10);
   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(Lby;II)V",
      garbageValue = "278686468"
   )
   @Export("characterToScreen")
   static final void characterToScreen(Actor var0, int var1) {
      class35.worldToScreen(var0.x, var0.y, var1);
   }
}
