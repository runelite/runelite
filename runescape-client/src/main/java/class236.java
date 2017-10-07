import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
public class class236 implements Runnable {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   public static Deque field3237;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   public static Deque field3233;
   @ObfuscatedName("p")
   public static Object field3236;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 429898751
   )
   public static int field3234;
   @ObfuscatedName("s")
   public static int[] field3238;
   @ObfuscatedName("q")
   static Thread field3235;

   static {
      field3237 = new Deque();
      field3233 = new Deque();
      field3234 = 0;
      field3236 = new Object();
   }

   public void run() {
      try {
         while(true) {
            Deque var2 = field3237;
            FileSystem var1;
            synchronized(field3237) {
               var1 = (FileSystem)field3237.getFront();
            }

            Object var14;
            if(var1 != null) {
               if(var1.field3206 == 0) {
                  var1.index.method3091((int)var1.hash, var1.field3203, var1.field3203.length);
                  var2 = field3237;
                  synchronized(field3237) {
                     var1.unlink();
                  }
               } else if(var1.field3206 == 1) {
                  var1.field3203 = var1.index.method3100((int)var1.hash);
                  var2 = field3237;
                  synchronized(field3237) {
                     field3233.addFront(var1);
                  }
               }

               var14 = field3236;
               synchronized(field3236) {
                  if(field3234 <= 1) {
                     field3234 = 0;
                     field3236.notifyAll();
                     return;
                  }

                  field3234 = 600;
               }
            } else {
               class211.method4044(100L);
               var14 = field3236;
               synchronized(field3236) {
                  if(field3234 <= 1) {
                     field3234 = 0;
                     field3236.notifyAll();
                     return;
                  }

                  --field3234;
               }
            }
         }
      } catch (Exception var13) {
         DynamicObject.method1932((String)null, var13);
      }
   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   static void method4311(int var0) {
      if(var0 == -3) {
         class1.method3("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class1.method3("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class1.method3("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class90.loginIndex = 3;
      } else if(var0 == 4) {
         class1.method3("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class1.method3("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         class1.method3("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class1.method3("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class1.method3("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class1.method3("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class1.method3("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class1.method3("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class1.method3("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class1.method3("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class1.method3("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class1.method3("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class1.method3("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class1.method3("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class1.method3("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class1.method3("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class1.method3("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class1.method3("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class1.method3("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class1.method3("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class1.method3("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class1.method3("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class1.method3("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class1.method3("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class1.method3("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class1.method3("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class1.method3("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class1.method3("Enter the 6-digit code generated by your", "authenticator app.", "");
            FrameMap.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class1.method3("The code you entered was incorrect.", "Please try again.", "");
            FrameMap.setGameState(11);
            return;
         }

         class1.method3("Unexpected server response", "Please try using a different world.", "");
      }

      FrameMap.setGameState(10);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Lja;",
      garbageValue = "74"
   )
   public static class277 method4309(int var0) {
      class277[] var1 = new class277[]{class277.field3751, class277.field3748, class277.field3752};
      class277[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class277 var4 = var2[var3];
         if(var0 == var4.field3749) {
            return var4;
         }
      }

      return null;
   }
}
