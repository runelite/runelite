import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
@Implements("WorldMapType1")
public class WorldMapType1 implements WorldMapSectionBase {
   @ObfuscatedName("qi")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   static IndexFile field406;
   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   static BuildType field415;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1456219561
   )
   int field402;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -38668213
   )
   int field412;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 763892137
   )
   int field410;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1884851041
   )
   int field403;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -91207
   )
   int field409;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -380861341
   )
   int field404;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1151197723
   )
   int field411;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1537593979
   )
   int field405;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -28579691
   )
   int field413;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1434562221
   )
   int field408;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-198305855"
   )
   public boolean vmethod715(int var1, int var2) {
      return var1 >> 6 >= this.field402 && var1 >> 6 <= this.field410 && var2 >> 6 >= this.field409 && var2 >> 6 <= this.field411;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIS)Z",
      garbageValue = "4496"
   )
   public boolean vmethod714(int var1, int var2, int var3) {
      return var1 >= this.field412 && var1 < this.field412 + this.field403?var2 >> 6 >= this.field404 && var2 >> 6 <= this.field405 && var3 >> 6 >= this.field413 && var3 >> 6 <= this.field408:false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lae;B)V",
      garbageValue = "103"
   )
   public void vmethod713(WorldMapData var1) {
      if(var1.field429 > this.field402) {
         var1.field429 = this.field402;
      }

      if(var1.field430 < this.field410) {
         var1.field430 = this.field410;
      }

      if(var1.field431 > this.field409) {
         var1.field431 = this.field409;
      }

      if(var1.field432 < this.field411) {
         var1.field432 = this.field411;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)Lhy;",
      garbageValue = "-93"
   )
   public Coordinates vmethod717(int var1, int var2) {
      if(!this.vmethod715(var1, var2)) {
         return null;
      } else {
         int var3 = this.field404 * 64 - this.field402 * 64 + var1;
         int var4 = this.field413 * 64 - this.field409 * 64 + var2;
         return new Coordinates(this.field412, var3, var4);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIB)[I",
      garbageValue = "32"
   )
   public int[] vmethod716(int var1, int var2, int var3) {
      if(!this.vmethod714(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field402 * 64 - this.field404 * 64 + var2, var3 + (this.field409 * 64 - this.field413 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfw;I)V",
      garbageValue = "996105043"
   )
   public void vmethod718(Buffer var1) {
      this.field412 = var1.readUnsignedByte();
      this.field403 = var1.readUnsignedByte();
      this.field404 = var1.readUnsignedShort();
      this.field413 = var1.readUnsignedShort();
      this.field405 = var1.readUnsignedShort();
      this.field408 = var1.readUnsignedShort();
      this.field402 = var1.readUnsignedShort();
      this.field409 = var1.readUnsignedShort();
      this.field410 = var1.readUnsignedShort();
      this.field411 = var1.readUnsignedShort();
      this.method244();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1587070345"
   )
   void method244() {
   }

   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-27131"
   )
   static void method269(int var0) {
      if(var0 == -3) {
         PendingSpawn.method1526("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         PendingSpawn.method1526("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         PendingSpawn.method1526("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class92.loginIndex = 3;
      } else if(var0 == 4) {
         PendingSpawn.method1526("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         PendingSpawn.method1526("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         PendingSpawn.method1526("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         PendingSpawn.method1526("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         PendingSpawn.method1526("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         PendingSpawn.method1526("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         PendingSpawn.method1526("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         PendingSpawn.method1526("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         PendingSpawn.method1526("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         PendingSpawn.method1526("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         PendingSpawn.method1526("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         PendingSpawn.method1526("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         PendingSpawn.method1526("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         PendingSpawn.method1526("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         PendingSpawn.method1526("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         PendingSpawn.method1526("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         PendingSpawn.method1526("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         PendingSpawn.method1526("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         PendingSpawn.method1526("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         PendingSpawn.method1526("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         PendingSpawn.method1526("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         PendingSpawn.method1526("", "Service unavailable.", "");
      } else if(var0 == 31) {
         PendingSpawn.method1526("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         PendingSpawn.method1526("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         PendingSpawn.method1526("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         PendingSpawn.method1526("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         PendingSpawn.method1526("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            PendingSpawn.method1526("Enter the 6-digit code generated by your", "authenticator app.", "");
            class2.setGameState(11);
            return;
         }

         if(var0 == 57) {
            PendingSpawn.method1526("The code you entered was incorrect.", "Please try again.", "");
            class2.setGameState(11);
            return;
         }

         PendingSpawn.method1526("Unexpected server response", "Please try using a different world.", "");
      }

      class2.setGameState(10);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "76"
   )
   public static int method249(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1299849549"
   )
   public static void method270() {
      Spotanim.spotanims.reset();
      Spotanim.field3307.reset();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "8"
   )
   @Export("setItemTableSlot")
   static void setItemTableSlot(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.get((long)var0);
      if(var4 == null) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.put(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }
}
