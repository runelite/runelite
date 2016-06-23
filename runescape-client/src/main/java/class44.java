import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
@Implements("KitDefinition")
public class class44 extends class204 {
   @ObfuscatedName("d")
   int[] field1040;
   @ObfuscatedName("s")
   short[] field1041;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1607035295
   )
   public int field1042 = -1;
   @ObfuscatedName("u")
   static class167 field1043;
   @ObfuscatedName("n")
   short[] field1044;
   @ObfuscatedName("m")
   short[] field1045;
   @ObfuscatedName("g")
   short[] field1046;
   @ObfuscatedName("b")
   public static class193 field1047 = new class193(64);
   @ObfuscatedName("r")
   int[] field1048 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("k")
   public boolean field1049 = false;
   @ObfuscatedName("nm")
   @ObfuscatedGetter(
      intValue = 288049561
   )
   static int field1050;
   @ObfuscatedName("f")
   static class167 field1051;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "99"
   )
   void method956(class119 var1) {
      while(true) {
         int var2 = var1.method2554();
         if(var2 == 0) {
            return;
         }

         this.method957(var1, var2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "1"
   )
   void method957(class119 var1, int var2) {
      if(var2 == 1) {
         this.field1042 = var1.method2554();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.method2554();
            this.field1040 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1040[var4] = var1.method2556();
            }
         } else if(var2 == 3) {
            this.field1049 = true;
         } else if(var2 == 40) {
            var3 = var1.method2554();
            this.field1044 = new short[var3];
            this.field1045 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1044[var4] = (short)var1.method2556();
               this.field1045[var4] = (short)var1.method2556();
            }
         } else if(var2 == 41) {
            var3 = var1.method2554();
            this.field1046 = new short[var3];
            this.field1041 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1046[var4] = (short)var1.method2556();
               this.field1041[var4] = (short)var1.method2556();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field1048[var2 - 60] = var1.method2556();
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Lclass100;",
      garbageValue = "-14"
   )
   @Export("getModelData")
   public class100 method959() {
      if(null == this.field1040) {
         return null;
      } else {
         class100[] var1 = new class100[this.field1040.length];

         for(int var2 = 0; var2 < this.field1040.length; ++var2) {
            var1[var2] = class100.method2280(field1043, this.field1040[var2], 0);
         }

         class100 var4;
         if(var1.length == 1) {
            var4 = var1[0];
         } else {
            var4 = new class100(var1, var1.length);
         }

         int var3;
         if(this.field1044 != null) {
            for(var3 = 0; var3 < this.field1044.length; ++var3) {
               var4.method2341(this.field1044[var3], this.field1045[var3]);
            }
         }

         if(this.field1046 != null) {
            for(var3 = 0; var3 < this.field1046.length; ++var3) {
               var4.method2300(this.field1046[var3], this.field1041[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Lclass100;",
      garbageValue = "558640431"
   )
   public class100 method961() {
      class100[] var1 = new class100[5];
      int var2 = 0;

      for(int var5 = 0; var5 < 5; ++var5) {
         if(this.field1048[var5] != -1) {
            var1[var2++] = class100.method2280(field1043, this.field1048[var5], 0);
         }
      }

      class100 var3 = new class100(var1, var2);
      int var4;
      if(this.field1044 != null) {
         for(var4 = 0; var4 < this.field1044.length; ++var4) {
            var3.method2341(this.field1044[var4], this.field1045[var4]);
         }
      }

      if(this.field1046 != null) {
         for(var4 = 0; var4 < this.field1046.length; ++var4) {
            var3.method2300(this.field1046[var4], this.field1041[var4]);
         }
      }

      return var3;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1279679990"
   )
   public boolean method975() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.field1048[var2] != -1 && !field1043.method3288(this.field1048[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "12863"
   )
   @Export("ready")
   public boolean method981() {
      if(this.field1040 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field1040.length; ++var2) {
            if(!field1043.method3288(this.field1040[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(IIIILclass78;Lclass175;I)V",
      garbageValue = "-444095646"
   )
   static final void method982(int var0, int var1, int var2, int var3, class78 var4, class175 var5) {
      int var6 = var2 * var2 + var3 * var3;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = client.field500 + client.field374 & 2047;
         int var8 = class91.field1597[var7];
         int var9 = class91.field1577[var7];
         var8 = 256 * var8 / (256 + client.field363);
         var9 = 256 * var9 / (256 + client.field363);
         int var10 = var9 * var2 + var8 * var3 >> 16;
         int var11 = var9 * var3 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class189.field3051.method1839(94 + var0 + var14 + 4 - 10, 83 + var1 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class160.method3199(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1774460639"
   )
   static void method983(int var0) {
      if(var0 == -3) {
         class111.method2477("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class111.method2477("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class111.method2477("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class31.field724 = 3;
      } else if(var0 == 4) {
         class111.method2477("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class111.method2477("Your account is already logged in.", "Try again in 60 secs...", "");
      } else if(var0 == 6) {
         class111.method2477("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class111.method2477("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class111.method2477("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class111.method2477("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class111.method2477("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class111.method2477("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class111.method2477("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class111.method2477("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class111.method2477("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class111.method2477("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class111.method2477("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class111.method2477("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class111.method2477("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class111.method2477("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class111.method2477("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class111.method2477("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class111.method2477("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class111.method2477("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class111.method2477("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class111.method2477("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class111.method2477("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class111.method2477("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class111.method2477("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class111.method2477("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class111.method2477("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class111.method2477("Enter the 6-digit code generated by your", "authenticator app.", "");
            class11.method156(11);
            return;
         }

         if(var0 == 57) {
            class111.method2477("The code you entered was incorrect.", "Please try again.", "");
            class11.method156(11);
            return;
         }

         class111.method2477("Unexpected server response", "Please try using a different world.", "");
      }

      class11.method156(10);
   }
}
