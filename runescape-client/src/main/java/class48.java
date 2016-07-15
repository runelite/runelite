import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class48 extends class207 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -754255201
   )
   public int field1080 = -1;
   @ObfuscatedName("r")
   public boolean field1081 = true;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1765379431
   )
   public int field1082 = 0;
   @ObfuscatedName("bq")
   static class171 field1083;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2012007429
   )
   public int field1084 = -1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -814636035
   )
   public int field1086;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -161993775
   )
   public int field1087;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2043610399
   )
   public int field1088;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -834073755
   )
   public int field1089;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 762917779
   )
   public int field1090;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1981938061
   )
   public int field1092;
   @ObfuscatedName("l")
   static class196 field1093 = new class196(64);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1934551313"
   )
   void method1025(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var10 + var8) / 2.0D;
      if(var10 != var8) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field1092 = (int)(var12 * 256.0D);
      this.field1086 = (int)(var14 * 256.0D);
      this.field1087 = (int)(var16 * 256.0D);
      if(this.field1086 < 0) {
         this.field1086 = 0;
      } else if(this.field1086 > 255) {
         this.field1086 = 255;
      }

      if(this.field1087 < 0) {
         this.field1087 = 0;
      } else if(this.field1087 > 255) {
         this.field1087 = 255;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass122;IB)Ljava/lang/String;",
      garbageValue = "35"
   )
   public static String method1027(class122 var0, int var1) {
      try {
         int var2 = var0.method2672();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.field2061 += class225.field3225.method2521(var0.field2054, var0.field2061, var3, 0, var2);
         String var4 = class35.method747(var3, 0, var2);
         return var4;
      } catch (Exception var6) {
         return "Cabbage";
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass122;III)V",
      garbageValue = "-598331532"
   )
   void method1028(class122 var1, int var2, int var3) {
      if(var2 == 1) {
         this.field1082 = var1.method2703();
      } else if(var2 == 2) {
         this.field1080 = var1.method2610();
      } else if(var2 == 5) {
         this.field1081 = false;
      } else if(var2 == 7) {
         this.field1084 = var1.method2703();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1642456214"
   )
   void method1029() {
      if(this.field1084 != -1) {
         this.method1025(this.field1084);
         this.field1088 = this.field1092;
         this.field1089 = this.field1086;
         this.field1090 = this.field1087;
      }

      this.method1025(this.field1082);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1505589601"
   )
   public static int method1033(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return 1 + var0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass122;IB)V",
      garbageValue = "-107"
   )
   void method1038(class122 var1, int var2) {
      while(true) {
         int var3 = var1.method2610();
         if(var3 == 0) {
            return;
         }

         this.method1028(var1, var3, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "1"
   )
   public static int method1045(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var0 + var2) / var1 - var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "1"
   )
   public static int method1046(CharSequence var0) {
      return class153.method3230(var0, 10, true);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "-6"
   )
   public static final boolean method1048(String var0, String var1, String var2, String var3) {
      return null != var0 && null != var2?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1420748662"
   )
   static void method1049(int var0) {
      if(var0 == -3) {
         class117.method2529("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class117.method2529("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class117.method2529("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class33.field778 = 3;
      } else if(var0 == 4) {
         class117.method2529("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class117.method2529("Your account is already logged in.", "Try again in 60 secs...", "");
      } else if(var0 == 6) {
         class117.method2529("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class117.method2529("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class117.method2529("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class117.method2529("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class117.method2529("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class117.method2529("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class117.method2529("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class117.method2529("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class117.method2529("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class117.method2529("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class117.method2529("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class117.method2529("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class117.method2529("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class117.method2529("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class117.method2529("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class117.method2529("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class117.method2529("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class117.method2529("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class117.method2529("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class117.method2529("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class117.method2529("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class117.method2529("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class117.method2529("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class117.method2529("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class117.method2529("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class117.method2529("Enter the 6-digit code generated by your", "authenticator app.", "");
            class92.method2179(11);
            return;
         }

         if(var0 == 57) {
            class117.method2529("The code you entered was incorrect.", "Please try again.", "");
            class92.method2179(11);
            return;
         }

         class117.method2529("Unexpected server response", "Please try using a different world.", "");
      }

      class92.method2179(10);
   }
}
