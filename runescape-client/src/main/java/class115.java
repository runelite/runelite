import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
public class class115 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 680264175
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1169698957
   )
   public static volatile int field1791 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 163885317
   )
   public static volatile int field1792 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 978494409
   )
   public static volatile int field1793 = -1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2077972959
   )
   public static int field1794 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 21401489
   )
   public static int field1795 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -5834422927762704753L
   )
   public static volatile long field1796 = 0L;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -58669887
   )
   public static int field1797 = 0;
   @ObfuscatedName("i")
   @Export("mouse")
   public static class115 mouse = new class115();
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -645322143
   )
   public static volatile int field1800 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2064831491
   )
   public static volatile int field1801 = -1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 798976189
   )
   public static int field1802 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -128814295
   )
   public static int field1803 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -822014061
   )
   public static int field1804 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -3260149052182273815L
   )
   public static long field1805 = 0L;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1558535211
   )
   public static volatile int field1806 = 0;

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1792 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1793 = var1.getX();
         field1801 = var1.getY();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1793 = -1;
         field1801 = -1;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "22"
   )
   static long method2169() {
      try {
         URL var0 = new URL(class6.method85("services", false) + "m=accountappeal/login.ws");
         URLConnection var1 = var0.openConnection();
         var1.setRequestProperty("connection", "close");
         var1.setDoInput(true);
         var1.setDoOutput(true);
         var1.setConnectTimeout(5000);
         OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
         var2.write("data1=req");
         var2.flush();
         InputStream var3 = var1.getInputStream();
         Buffer var4 = new Buffer(new byte[1000]);

         do {
            int var5 = var3.read(var4.payload, var4.offset, 1000 - var4.offset);
            if(var5 == -1) {
               var4.offset = 0;
               long var8 = var4.method2866();
               return var8;
            }

            var4.offset += var5;
         } while(var4.offset < 1000);

         return 0L;
      } catch (Exception var7) {
         return 0L;
      }
   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1793 = var1.getX();
         field1801 = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field1792 = 0;
      }

   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1791 = var1.getX();
         field1800 = var1.getY();
         field1796 = class72.method1385();
         if(var1.isAltDown()) {
            field1806 = 4;
            field1792 = 4;
         } else if(var1.isMetaDown()) {
            field1806 = 2;
            field1792 = 2;
         } else {
            field1806 = 1;
            field1792 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1793 = var1.getX();
         field1801 = var1.getY();
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "126"
   )
   static void method2181(int var0) {
      if(var0 == -3) {
         class22.method204("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class22.method204("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class22.method204("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class41.loginIndex = 3;
      } else if(var0 == 4) {
         class22.method204("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class22.method204("Your account is already logged in.", "Try again in 60 secs...", "");
      } else if(var0 == 6) {
         class22.method204("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class22.method204("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class22.method204("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class22.method204("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class22.method204("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class22.method204("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class22.method204("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class22.method204("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class22.method204("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class22.method204("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class22.method204("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class22.method204("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class22.method204("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class22.method204("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class22.method204("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class22.method204("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class22.method204("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class22.method204("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class22.method204("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class22.method204("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class22.method204("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class22.method204("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class22.method204("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class22.method204("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class22.method204("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class22.method204("Enter the 6-digit code generated by your", "authenticator app.", "");
            XGrandExchangeOffer.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class22.method204("The code you entered was incorrect.", "Please try again.", "");
            XGrandExchangeOffer.setGameState(11);
            return;
         }

         class22.method204("Unexpected server response", "Please try using a different world.", "");
      }

      XGrandExchangeOffer.setGameState(10);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1803434864"
   )
   static final void method2194() {
      if(class104.field1680 != null) {
         class104.field1680.method1016();
      }

      if(null != Client.field568) {
         Client.field568.method1016();
      }

   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1859070222"
   )
   static final String method2195(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class155.method2949('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class155.method2949(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class155.method2949(16776960) + var1 + "</col>");
   }
}
