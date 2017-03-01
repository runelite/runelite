import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class170 {
   class170() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)LSpritePixels;",
      garbageValue = "-1895511471"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var3 << 42) + ((long)var2 << 38) + ((long)var1 << 16) + (long)var0 + ((long)var4 << 40);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = ChatLineBuffer.getItemDefinition(var0);
      if(var1 > 1 && null != var9.countObj) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.countCo[var11] && var9.countCo[var11] != 0) {
               var10 = var9.countObj[var11];
            }
         }

         if(var10 != -1) {
            var9 = ChatLineBuffer.getItemDefinition(var10);
         }
      }

      Model var20 = var9.getModel(1);
      if(null == var20) {
         return null;
      } else {
         SpritePixels var19 = null;
         if(var9.notedTemplate != -1) {
            var19 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(var19 == null) {
               return null;
            }
         } else if(var9.field3000 != -1) {
            var19 = createSprite(var9.field2983, var1, var2, var3, 0, false);
            if(null == var19) {
               return null;
            }
         } else if(var9.field2999 != -1) {
            var19 = createSprite(var9.field3001, var1, 0, 0, 0, false);
            if(var19 == null) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.graphicsPixels;
         int var13 = Rasterizer2D.graphicsPixelsWidth;
         int var14 = Rasterizer2D.graphicsPixelsHeight;
         int[] var15 = new int[4];
         Rasterizer2D.method4015(var15);
         var8 = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         Rasterizer2D.method4017();
         class84.method1747();
         class84.method1726(16, 16);
         class84.rasterGouraudLowRes = false;
         if(var9.field2999 != -1) {
            var19.method4174(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = class84.field1460[var9.xan2d] * var16 >> 16;
         int var18 = class84.field1446[var9.xan2d] * var16 >> 16;
         var20.method1649();
         var20.method1661(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var9.offsetY2d + var20.modelHeight / 2 + var17, var9.offsetY2d + var18);
         if(var9.field3000 != -1) {
            var19.method4174(0, 0);
         }

         if(var2 >= 1) {
            var8.method4170(1);
         }

         if(var2 >= 2) {
            var8.method4170(16777215);
         }

         if(var3 != 0) {
            var8.method4171(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         if(var9.notedTemplate != -1) {
            var19.method4174(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            class22.field235.method3973(ObjectComposition.method3703(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.method4016(var15);
         class84.method1747();
         class84.rasterGouraudLowRes = true;
         return var8;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "542481379"
   )
   static void method3329(int var0) {
      if(var0 == -3) {
         class41.method864("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class41.method864("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class41.method864("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class41.loginIndex = 3;
      } else if(var0 == 4) {
         class41.method864("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class41.method864("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         class41.method864("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class41.method864("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class41.method864("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class41.method864("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class41.method864("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class41.method864("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class41.method864("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class41.method864("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class41.method864("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class41.method864("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class41.method864("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class41.method864("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class41.method864("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class41.method864("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class41.method864("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class41.method864("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class41.method864("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class41.method864("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class41.method864("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class41.method864("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class41.method864("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class41.method864("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class41.method864("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class41.method864("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class41.method864("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class41.method864("Enter the 6-digit code generated by your", "authenticator app.", "");
            World.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class41.method864("The code you entered was incorrect.", "Please try again.", "");
            World.setGameState(11);
            return;
         }

         class41.method864("Unexpected server response", "Please try using a different world.", "");
      }

      World.setGameState(10);
   }
}
