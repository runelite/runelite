import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class8 {
   @ObfuscatedName("ad")
   static SpritePixels[] field79;
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = 228200583
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = -1873838285
   )
   static int field82;
   @ObfuscatedName("b")
   static int[] field83;
   @ObfuscatedName("pj")
   static class30 field84;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1370190837
   )
   public static int field86;
   @ObfuscatedName("cd")
   static RSSocket field88;
   @ObfuscatedName("d")
   public static class182 field90;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "60"
   )
   static int method104(int var0, Script var1, boolean var2) {
      Widget var3 = World.method670(class32.field756[--class32.field752]);
      if(var0 == 2600) {
         class32.field756[++class32.field752 - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 2601) {
         class32.field756[++class32.field752 - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 2602) {
         class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 2603) {
         class32.field756[++class32.field752 - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 2604) {
         class32.field756[++class32.field752 - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 2605) {
         class32.field756[++class32.field752 - 1] = var3.field2240;
         return 1;
      } else if(var0 == 2606) {
         class32.field756[++class32.field752 - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 2607) {
         class32.field756[++class32.field752 - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 2608) {
         class32.field756[++class32.field752 - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 2609) {
         class32.field756[++class32.field752 - 1] = var3.opacity;
         return 1;
      } else if(var0 == 2610) {
         class32.field756[++class32.field752 - 1] = var3.field2218;
         return 1;
      } else if(var0 == 2611) {
         class32.field756[++class32.field752 - 1] = var3.textColor;
         return 1;
      } else if(var0 == 2612) {
         class32.field756[++class32.field752 - 1] = var3.field2212;
         return 1;
      } else if(var0 == 2613) {
         class32.field756[++class32.field752 - 1] = var3.field2194.vmethod4085();
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1956526894"
   )
   static void method105(int var0) {
      if(var0 == -3) {
         class5.method67("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class5.method67("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class5.method67("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class41.loginIndex = 3;
      } else if(var0 == 4) {
         class5.method67("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class5.method67("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         class5.method67("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class5.method67("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class5.method67("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class5.method67("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class5.method67("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class5.method67("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class5.method67("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class5.method67("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class5.method67("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class5.method67("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class5.method67("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class5.method67("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class5.method67("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class5.method67("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class5.method67("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class5.method67("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class5.method67("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class5.method67("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class5.method67("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class5.method67("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class5.method67("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class5.method67("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class5.method67("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class5.method67("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class5.method67("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class5.method67("Enter the 6-digit code generated by your", "authenticator app.", "");
            class187.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class5.method67("The code you entered was incorrect.", "Please try again.", "");
            class187.setGameState(11);
            return;
         }

         class5.method67("Unexpected server response", "Please try using a different world.", "");
      }

      class187.setGameState(10);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1870789238"
   )
   static int method106(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = World.method670(class32.field756[--class32.field752]);
      } else {
         var3 = var2?class26.field624:class32.field754;
      }

      class2.method36(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class32.field756[--class32.field752];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = class22.localPlayer.composition.method3168();
            return 1;
         } else {
            return 2;
         }
      } else {
         class32.field752 -= 2;
         int var4 = class32.field756[class32.field752];
         int var5 = class32.field756[1 + class32.field752];
         var3.item = var4;
         var3.stackSize = var5;
         ItemComposition var6 = class154.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2235 = var6.offsetX2d;
         var3.field2236 = var6.offsetY2d;
         var3.field2240 = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2244 = 0;
         } else if(var0 == 1212 | var6.isStackable == 1) {
            var3.field2244 = 1;
         } else {
            var3.field2244 = 2;
         }

         if(var3.field2179 > 0) {
            var3.field2240 = var3.field2240 * 32 / var3.field2179;
         } else if(var3.originalWidth > 0) {
            var3.field2240 = var3.field2240 * 32 / var3.originalWidth;
         }

         return 1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1276519435"
   )
   static long method107() {
      try {
         URL var0 = new URL(GroundObject.method1596("services", false) + "m=accountappeal/login.ws");
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
               long var7 = var4.readLong();
               return var7;
            }

            var4.offset += var5;
         } while(var4.offset < 1000);

         return 0L;
      } catch (Exception var9) {
         return 0L;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2113512335"
   )
   static int method108(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var0));
      return null == var1?0:var1.method983();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1077128600"
   )
   @Export("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class47.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.method981(var0, var1, var2, var3);
      class47.field951.method2356(var5, (long)var5.id);
      class47.field952.method2515(var5);
      Client.field505 = Client.field498;
   }

   class8() throws Throwable {
      throw new Error();
   }
}
