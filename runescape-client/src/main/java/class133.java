import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
public abstract class class133 {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "14"
   )
   abstract void vmethod3104();

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-650846426"
   )
   abstract int vmethod3106(int var1, int var2);

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Z",
      garbageValue = "-1762213950"
   )
   public static boolean method2844(CharSequence var0) {
      boolean var1 = false;
      boolean var2 = false;
      int var3 = 0;
      int var4 = var0.length();
      int var5 = 0;

      boolean var6;
      while(true) {
         if(var5 >= var4) {
            var6 = var2;
            break;
         }

         label73: {
            char var7 = var0.charAt(var5);
            if(var5 == 0) {
               if(45 == var7) {
                  var1 = true;
                  break label73;
               }

               if(43 == var7) {
                  break label73;
               }
            }

            int var8;
            if(var7 >= 48 && var7 <= 57) {
               var8 = var7 - 48;
            } else if(var7 >= 65 && var7 <= 90) {
               var8 = var7 - 55;
            } else {
               if(var7 < 97 || var7 > 122) {
                  var6 = false;
                  break;
               }

               var8 = var7 - 87;
            }

            if(var8 >= 10) {
               var6 = false;
               break;
            }

            if(var1) {
               var8 = -var8;
            }

            int var9 = var8 + 10 * var3;
            if(var3 != var9 / 10) {
               var6 = false;
               break;
            }

            var3 = var9;
            var2 = true;
         }

         ++var5;
      }

      return var6;
   }

   @ObfuscatedName("qh")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/awt/Color;ZI)V",
      garbageValue = "258541790"
   )
   protected static final void method2845(int var0, String var1, Color var2, boolean var3) {
      try {
         Graphics var4 = class122.field2024.getGraphics();
         if(class99.field1695 == null) {
            class99.field1695 = new Font("Helvetica", 1, 13);
            class123.field2039 = class122.field2024.getFontMetrics(class99.field1695);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, class15.field214, class15.field215);
         }

         if(null == var2) {
            var2 = new Color(140, 17, 17);
         }

         try {
            if(null == class44.field1030) {
               class44.field1030 = class122.field2024.createImage(304, 34);
            }

            Graphics var5 = class44.field1030.getGraphics();
            var5.setColor(var2);
            var5.drawRect(0, 0, 303, 33);
            var5.fillRect(2, 2, var0 * 3, 30);
            var5.setColor(Color.black);
            var5.drawRect(1, 1, 301, 31);
            var5.fillRect(2 + 3 * var0, 2, 300 - 3 * var0, 30);
            var5.setFont(class99.field1695);
            var5.setColor(Color.white);
            var5.drawString(var1, (304 - class123.field2039.stringWidth(var1)) / 2, 22);
            var4.drawImage(class44.field1030, class15.field214 / 2 - 152, class15.field215 / 2 - 18, (ImageObserver)null);
         } catch (Exception var8) {
            int var6 = class15.field214 / 2 - 152;
            int var7 = class15.field215 / 2 - 18;
            var4.setColor(var2);
            var4.drawRect(var6, var7, 303, 33);
            var4.fillRect(var6 + 2, var7 + 2, 3 * var0, 30);
            var4.setColor(Color.black);
            var4.drawRect(var6 + 1, var7 + 1, 301, 31);
            var4.fillRect(2 + var6 + 3 * var0, 2 + var7, 300 - 3 * var0, 30);
            var4.setFont(class99.field1695);
            var4.setColor(Color.white);
            var4.drawString(var1, var6 + (304 - class123.field2039.stringWidth(var1)) / 2, 22 + var7);
         }
      } catch (Exception var9) {
         class122.field2024.repaint();
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1544059891"
   )
   static void method2846(int var0) {
      if(-3 == var0) {
         class8.method107("Connection timed out.", "Please try using a different world.", "");
      } else if(-2 == var0) {
         class8.method107("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class8.method107("No response from server.", "Please try using a different world.", "");
      } else if(3 == var0) {
         class31.field732 = 3;
      } else if(4 == var0) {
         class8.method107("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class8.method107("Your account is already logged in.", "Try again in 60 secs...", "");
      } else if(6 == var0) {
         class8.method107("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class8.method107("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class8.method107("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class8.method107("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(10 == var0) {
         class8.method107("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class8.method107("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class8.method107("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(13 == var0) {
         class8.method107("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class8.method107("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(16 == var0) {
         class8.method107("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(17 == var0) {
         class8.method107("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class8.method107("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class8.method107("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(20 == var0) {
         class8.method107("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class8.method107("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class8.method107("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class8.method107("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class8.method107("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(26 == var0) {
         class8.method107("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class8.method107("", "Service unavailable.", "");
      } else if(31 == var0) {
         class8.method107("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(32 == var0) {
         class8.method107("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class8.method107("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class8.method107("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(55 == var0) {
         class8.method107("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(56 == var0) {
            class8.method107("Enter the 6-digit code generated by your", "authenticator app.", "");
            class15.method188(11);
            return;
         }

         if(var0 == 57) {
            class8.method107("The code you entered was incorrect.", "Please try again.", "");
            class15.method188(11);
            return;
         }

         class8.method107("Unexpected server response", "Please try using a different world.", "");
      }

      class15.method188(10);
   }
}
