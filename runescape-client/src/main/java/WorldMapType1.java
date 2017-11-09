import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("WorldMapType1")
public class WorldMapType1 implements WorldMapSectionBase {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1908284879
   )
   int field417;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1595455973
   )
   int field412;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1665489701
   )
   int field413;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 84455001
   )
   int field414;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 35617695
   )
   int field415;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 883667397
   )
   int field411;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1579127191
   )
   int field416;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 659642279
   )
   int field418;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1623922793
   )
   int field419;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1128778799
   )
   int field420;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lap;I)V",
      garbageValue = "-695326084"
   )
   public void vmethod772(WorldMapData var1) {
      if(var1.field430 > this.field416) {
         var1.field430 = this.field416;
      }

      if(var1.field432 < this.field419) {
         var1.field432 = this.field419;
      }

      if(var1.field438 > this.field418) {
         var1.field438 = this.field418;
      }

      if(var1.field439 < this.field420) {
         var1.field439 = this.field420;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "2104062915"
   )
   public boolean vmethod778(int var1, int var2, int var3) {
      return var1 >= this.field417 && var1 < this.field417 + this.field412?var2 >> 6 >= this.field413 && var2 >> 6 <= this.field415 && var3 >> 6 >= this.field414 && var3 >> 6 <= this.field411:false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "0"
   )
   public boolean vmethod774(int var1, int var2) {
      return var1 >> 6 >= this.field416 && var1 >> 6 <= this.field419 && var2 >> 6 >= this.field418 && var2 >> 6 <= this.field420;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-579666919"
   )
   public int[] vmethod775(int var1, int var2, int var3) {
      if(!this.vmethod778(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field416 * 64 - this.field413 * 64 + var2, var3 + (this.field418 * 64 - this.field414 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)Lhq;",
      garbageValue = "1"
   )
   public Coordinates vmethod797(int var1, int var2) {
      if(!this.vmethod774(var1, var2)) {
         return null;
      } else {
         int var3 = this.field413 * 64 - this.field416 * 64 + var1;
         int var4 = this.field414 * 64 - this.field418 * 64 + var2;
         return new Coordinates(this.field417, var3, var4);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfv;S)V",
      garbageValue = "256"
   )
   public void vmethod777(Buffer var1) {
      this.field417 = var1.readUnsignedByte();
      this.field412 = var1.readUnsignedByte();
      this.field413 = var1.readUnsignedShort();
      this.field414 = var1.readUnsignedShort();
      this.field415 = var1.readUnsignedShort();
      this.field411 = var1.readUnsignedShort();
      this.field416 = var1.readUnsignedShort();
      this.field418 = var1.readUnsignedShort();
      this.field419 = var1.readUnsignedShort();
      this.field420 = var1.readUnsignedShort();
      this.method286();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-129170663"
   )
   void method286() {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2141114245"
   )
   static final int method292() {
      return class133.field1912;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1700394310"
   )
   static void method288(boolean var0) {
      class91.loginMessage1 = "";
      class91.loginMessage2 = "Enter your username/email & password.";
      class91.loginMessage3 = "";
      class91.loginIndex = 2;
      if(var0) {
         class91.password = "";
      }

      class23.method190();
      class72.method1183();
   }

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1666424450"
   )
   static void method293(int var0) {
      if(var0 == -3) {
         class8.method43("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class8.method43("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class8.method43("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class91.loginIndex = 3;
      } else if(var0 == 4) {
         class8.method43("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class8.method43("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         class8.method43("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class8.method43("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class8.method43("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class8.method43("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class8.method43("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class8.method43("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class8.method43("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class8.method43("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class8.method43("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class8.method43("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class8.method43("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class8.method43("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class8.method43("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class8.method43("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class8.method43("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class8.method43("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class8.method43("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class8.method43("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class8.method43("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class8.method43("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class8.method43("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class8.method43("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class8.method43("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class8.method43("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class8.method43("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class8.method43("Enter the 6-digit code generated by your", "authenticator app.", "");
            class287.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class8.method43("The code you entered was incorrect.", "Please try again.", "");
            class287.setGameState(11);
            return;
         }

         class8.method43("Unexpected server response", "Please try using a different world.", "");
      }

      class287.setGameState(10);
   }
}
