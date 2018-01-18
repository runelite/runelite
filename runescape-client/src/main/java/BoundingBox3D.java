import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
@Implements("BoundingBox3D")
public final class BoundingBox3D extends BoundingBox {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2069990477
   )
   @Export("int1")
   final int int1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 73860137
   )
   @Export("int2")
   final int int2;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 669668565
   )
   @Export("int3")
   final int int3;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -150028949
   )
   @Export("int4")
   final int int4;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -8820899
   )
   @Export("int5")
   final int int5;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -99451583
   )
   @Export("int6")
   final int int6;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1054629821
   )
   @Export("color")
   final int color;

   @ObfuscatedSignature(
      signature = "(Les;IIII)V"
   )
   BoundingBox3D(Model var1, int var2, int var3, int var4, int var5) {
      this.int1 = var2 + var1.field1896 - var1.field1863;
      this.int2 = var3 + var1.field1861 - var1.field1864;
      this.int3 = var4 + var1.field1862 - var1.field1885;
      this.int4 = var2 + var1.field1863 + var1.field1896;
      this.int5 = var3 + var1.field1861 + var1.field1864;
      this.int6 = var4 + var1.field1862 + var1.field1885;
      this.color = var5;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "980177459"
   )
   final void draw() {
      for(int var4 = 0; var4 < 8; ++var4) {
         int var1 = (var4 & 1) == 0?this.int1:this.int4;
         int var2 = (var4 & 2) == 0?this.int2:this.int5;
         int var3 = (var4 & 4) == 0?this.int3:this.int6;
         if((var4 & 1) == 0) {
            class72.method1131(var1, var2, var3, this.int4, var2, var3, this.color);
         }

         if((var4 & 2) == 0) {
            class72.method1131(var1, var2, var3, var1, this.int5, var3, this.color);
         }

         if((var4 & 4) == 0) {
            class72.method1131(var1, var2, var3, var1, var2, this.int6, this.color);
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "-283657637"
   )
   static boolean method51(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)Ldg;",
      garbageValue = "317866164"
   )
   @Export("getPreferencesFile")
   public static FileOnDisk getPreferencesFile(String var0, String var1, boolean var2) {
      File var3 = new File(class157.field2164, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(Bounds.field3817 == 33) {
         var4 = "_rc";
      } else if(Bounds.field3817 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class153.userHome, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1848230855"
   )
   static void method52(int var0) {
      if(var0 == -3) {
         ClanMember.method1170("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         ClanMember.method1170("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         ClanMember.method1170("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class91.loginIndex = 3;
      } else if(var0 == 4) {
         ClanMember.method1170("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         ClanMember.method1170("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         ClanMember.method1170("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         ClanMember.method1170("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         ClanMember.method1170("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         ClanMember.method1170("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         ClanMember.method1170("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         ClanMember.method1170("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         ClanMember.method1170("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         ClanMember.method1170("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         ClanMember.method1170("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         ClanMember.method1170("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         ClanMember.method1170("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         ClanMember.method1170("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         ClanMember.method1170("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         ClanMember.method1170("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         ClanMember.method1170("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         ClanMember.method1170("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         ClanMember.method1170("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         ClanMember.method1170("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         ClanMember.method1170("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         ClanMember.method1170("", "Service unavailable.", "");
      } else if(var0 == 31) {
         ClanMember.method1170("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         ClanMember.method1170("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         ClanMember.method1170("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         ClanMember.method1170("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         ClanMember.method1170("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            ClanMember.method1170("Enter the 6-digit code generated by your", "authenticator app.", "");
            ClanMember.setGameState(11);
            return;
         }

         if(var0 == 57) {
            ClanMember.method1170("The code you entered was incorrect.", "Please try again.", "");
            ClanMember.setGameState(11);
            return;
         }

         ClanMember.method1170("Unexpected server response", "Please try using a different world.", "");
      }

      ClanMember.setGameState(10);
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(Lbm;II)V",
      garbageValue = "-69800362"
   )
   @Export("characterToScreen")
   static final void characterToScreen(Actor var0, int var1) {
      class61.worldToScreen(var0.x, var0.y, var1);
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lhq;I)Ljava/lang/String;",
      garbageValue = "-1619699946"
   )
   static String method53(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         for(int var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               String var4 = var0.substring(0, var3);
               int var6 = ClanMember.method1169(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(var3 + 2);
            }
         }
      }

      return var0;
   }
}
