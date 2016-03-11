import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class18 {
   @ObfuscatedName("cp")
   public static char field254;
   @ObfuscatedName("a")
   DataInputStream field256;
   @ObfuscatedName("i")
   byte[] field257 = new byte[4];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 896240529
   )
   int field258;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 355721811
   )
   int field260;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -941340624410154625L
   )
   long field261;
   @ObfuscatedName("m")
   byte[] field262;
   @ObfuscatedName("k")
   static int[] field264;
   @ObfuscatedName("em")
   static class78[] field265;
   @ObfuscatedName("l")
   class145 field266;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 330634481
   )
   int field268;

   @ObfuscatedName("l")
   public static int method189(int var0, int var1, int var2, int var3, int var4, int var5) {
      if(1 == (var5 & 1)) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return 0 == var2?var0:(1 == var2?var1:(var2 == 2?7 - var0 - (var3 - 1):7 - var1 - (var4 - 1)));
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1026038056"
   )
   static void method190(int var0) {
      if(-1 == var0 && !client.field527) {
         class45.method951();
      } else if(-1 != var0 && client.field453 != var0 && 0 != client.field525 && !client.field527) {
         class167 var1 = class137.field2139;
         int var2 = client.field525;
         class182.field2957 = 1;
         class182.field2955 = var1;
         class125.field2043 = var0;
         class7.field138 = 0;
         class75.field1388 = var2;
         class11.field182 = false;
         class3.field62 = 2;
      }

      client.field453 = var0;
   }

   @ObfuscatedName("p")
   static final void method191() {
      class118.method2647();
      class42.method895();
      class44.field1026.method3720();
      class128.method2757();
      class4.method37();
      class7.method96();
      class42.field984.method3720();
      class42.field985.method3720();
      class93.method2137();
      class20.method567();
      class52.field1165.method3720();
      class178.field2918.method3720();
      class157.method3120();
      ((class94)class90.field1576).method2146();
      class22.field590.method3720();
      class10.field168.method3227();
      class46.field1062.method3227();
      class76.field1396.method3227();
      class31.field740.method3227();
      class24.field623.method3227();
      class137.field2139.method3227();
      class32.field757.method3227();
      class157.field2595.method3227();
      class108.field1915.method3227();
      class95.field1640.method3227();
      class97.field1669.method3227();
      class160.field2649.method3227();
   }

   class18(class135 var1, URL var2) {
      this.field266 = var1.method2814(var2);
      this.field268 = 0;
      this.field261 = class109.method2381() + 30000L;
   }

   @ObfuscatedName("cj")
   static final void method192(int var0, int var1) {
      if(class149.method3102(var0)) {
         class16.method187(class172.field2757[var0], var1);
      }
   }

   @ObfuscatedName("j")
   public static int method193(CharSequence var0, CharSequence var1) {
      int var2 = var0.length();
      int var3 = var1.length();
      int var4 = 0;
      int var5 = 0;
      byte var6 = 0;
      byte var7 = 0;

      while(var4 - var6 < var2 || var5 - var7 < var3) {
         if(var4 - var6 >= var2) {
            return -1;
         }

         if(var5 - var7 >= var3) {
            return 1;
         }

         char var8;
         if(0 != var6) {
            var8 = (char)var6;
            boolean var13 = false;
         } else {
            var8 = var0.charAt(var4++);
         }

         char var9;
         if(0 != var7) {
            var9 = (char)var7;
            boolean var14 = false;
         } else {
            var9 = var1.charAt(var5++);
         }

         byte var10;
         if(var8 == 198) {
            var10 = 69;
         } else if(230 == var8) {
            var10 = 101;
         } else if(223 == var8) {
            var10 = 115;
         } else if(338 == var8) {
            var10 = 69;
         } else if(339 == var8) {
            var10 = 101;
         } else {
            var10 = 0;
         }

         var6 = var10;
         byte var11;
         if(198 == var9) {
            var11 = 69;
         } else if(230 == var9) {
            var11 = 101;
         } else if(var9 == 223) {
            var11 = 115;
         } else if(338 == var9) {
            var11 = 69;
         } else if(var9 == 339) {
            var11 = 101;
         } else {
            var11 = 0;
         }

         var7 = var11;
         var8 = class95.method2165(var8);
         var9 = class95.method2165(var9);
         if(var8 != var9 && Character.toUpperCase(var8) != Character.toUpperCase(var9)) {
            var8 = Character.toLowerCase(var8);
            var9 = Character.toLowerCase(var9);
            if(var8 != var9) {
               return class48.method995(var8) - class48.method995(var9);
            }
         }
      }

      int var15 = Math.min(var2, var3);

      int var16;
      char var19;
      for(var16 = 0; var16 < var15; ++var16) {
         char var17 = var0.charAt(var16);
         var19 = var1.charAt(var16);
         if(var17 != var19 && Character.toUpperCase(var17) != Character.toUpperCase(var19)) {
            var17 = Character.toLowerCase(var17);
            var19 = Character.toLowerCase(var19);
            if(var19 != var17) {
               return class48.method995(var17) - class48.method995(var19);
            }
         }
      }

      var16 = var2 - var3;
      if(0 != var16) {
         return var16;
      } else {
         for(int var18 = 0; var18 < var15; ++var18) {
            var19 = var0.charAt(var18);
            char var12 = var1.charAt(var18);
            if(var19 != var12) {
               return class48.method995(var19) - class48.method995(var12);
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("do")
   static boolean method194(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = class134.method2803(var0, client.field473);

         for(int var2 = 0; var2 < client.field559; ++var2) {
            class7 var3 = client.field560[var2];
            if(var1.equalsIgnoreCase(class134.method2803(var3.field139, client.field473))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class134.method2803(var3.field136, client.field473))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("dj")
   static boolean method195(class172 var0) {
      if(client.field458) {
         if(class42.method898(var0) != 0) {
            return false;
         }

         if(0 == var0.field2849) {
            return false;
         }
      }

      return var0.field2794;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-37082840"
   )
   static void method196(int var0) {
      if(var0 == -3) {
         class3.method32("Connection timed out.", "Please try using a different world.", "");
      } else if(-2 == var0) {
         class3.method32("", "Error connecting to server.", "");
      } else if(-1 == var0) {
         class3.method32("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class31.field722 = 3;
      } else if(var0 == 4) {
         class3.method32("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(5 == var0) {
         class3.method32("Your account is already logged in.", "Try again in 60 secs...", "");
      } else if(6 == var0) {
         class3.method32("RuneScape has been updated!", "Please reload this page.", "");
      } else if(7 == var0) {
         class3.method32("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class3.method32("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class3.method32("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class3.method32("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class3.method32("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class3.method32("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(13 == var0) {
         class3.method32("Could not complete login.", "Please try using a different world.", "");
      } else if(14 == var0) {
         class3.method32("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(16 == var0) {
         class3.method32("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(17 == var0) {
         class3.method32("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(18 == var0) {
         class3.method32("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class3.method32("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(20 == var0) {
         class3.method32("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(22 == var0) {
         class3.method32("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class3.method32("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class3.method32("Error loading your profile.", "Please contact customer support.", "");
      } else if(25 == var0) {
         class3.method32("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class3.method32("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class3.method32("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class3.method32("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(32 == var0) {
         class3.method32("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class3.method32("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class3.method32("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class3.method32("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class3.method32("Enter the 6-digit code generated by your", "authenticator app.", "");
            client.method556(11);
            return;
         }

         if(57 == var0) {
            class3.method32("The code you entered was incorrect.", "Please try again.", "");
            client.method556(11);
            return;
         }

         class3.method32("Unexpected server response", "Please try using a different world.", "");
      }

      client.method556(10);
   }

   @ObfuscatedName("j")
   byte[] method197() throws IOException {
      if(class109.method2381() > this.field261) {
         throw new IOException();
      } else {
         if(this.field268 == 0) {
            if(2 == this.field266.field2222) {
               throw new IOException();
            }

            if(this.field266.field2222 == 1) {
               this.field256 = (DataInputStream)this.field266.field2223;
               this.field268 = 1;
            }
         }

         int var1;
         if(this.field268 == 1) {
            var1 = this.field256.available();
            if(var1 > 0) {
               if(this.field258 + var1 > 4) {
                  var1 = 4 - this.field258;
               }

               this.field258 += this.field256.read(this.field257, this.field258, var1);
               if(this.field258 == 4) {
                  int var2 = (new class118(this.field257)).method2458();
                  this.field262 = new byte[var2];
                  this.field268 = 2;
               }
            }
         }

         if(2 == this.field268) {
            var1 = this.field256.available();
            if(var1 > 0) {
               if(var1 + this.field260 > this.field262.length) {
                  var1 = this.field262.length - this.field260;
               }

               this.field260 += this.field256.read(this.field262, this.field260, var1);
               if(this.field262.length == this.field260) {
                  return this.field262;
               }
            }
         }

         return null;
      }
   }

   @ObfuscatedName("j")
   static String method198(int var0) {
      return "<img=" + var0 + ">";
   }
}
