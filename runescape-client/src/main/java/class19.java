import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
final class class19 implements Comparator {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lr;Lr;I)I",
      garbageValue = "-1907724389"
   )
   int method147(class14 var1, class14 var2) {
      return var1.field286 < var2.field286?-1:(var2.field286 == var1.field286?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method147((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(CB)B",
      garbageValue = "-42"
   )
   public static byte method146(char var0) {
      byte var1;
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         var1 = (byte)var0;
      } else if(var0 == 8364) {
         var1 = -128;
      } else if(var0 == 8218) {
         var1 = -126;
      } else if(var0 == 402) {
         var1 = -125;
      } else if(var0 == 8222) {
         var1 = -124;
      } else if(var0 == 8230) {
         var1 = -123;
      } else if(var0 == 8224) {
         var1 = -122;
      } else if(var0 == 8225) {
         var1 = -121;
      } else if(var0 == 710) {
         var1 = -120;
      } else if(var0 == 8240) {
         var1 = -119;
      } else if(var0 == 352) {
         var1 = -118;
      } else if(var0 == 8249) {
         var1 = -117;
      } else if(var0 == 338) {
         var1 = -116;
      } else if(var0 == 381) {
         var1 = -114;
      } else if(var0 == 8216) {
         var1 = -111;
      } else if(var0 == 8217) {
         var1 = -110;
      } else if(var0 == 8220) {
         var1 = -109;
      } else if(var0 == 8221) {
         var1 = -108;
      } else if(var0 == 8226) {
         var1 = -107;
      } else if(var0 == 8211) {
         var1 = -106;
      } else if(var0 == 8212) {
         var1 = -105;
      } else if(var0 == 732) {
         var1 = -104;
      } else if(var0 == 8482) {
         var1 = -103;
      } else if(var0 == 353) {
         var1 = -102;
      } else if(var0 == 8250) {
         var1 = -101;
      } else if(var0 == 339) {
         var1 = -100;
      } else if(var0 == 382) {
         var1 = -98;
      } else if(var0 == 376) {
         var1 = -97;
      } else {
         var1 = 63;
      }

      return var1;
   }

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "32"
   )
   static void method156(int var0) {
      if(var0 == -3) {
         class69.method1159("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class69.method1159("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class69.method1159("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class93.loginIndex = 3;
      } else if(var0 == 4) {
         class69.method1159("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class69.method1159("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         class69.method1159("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class69.method1159("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class69.method1159("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class69.method1159("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class69.method1159("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class69.method1159("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class69.method1159("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class69.method1159("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class69.method1159("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class69.method1159("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class69.method1159("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class69.method1159("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class69.method1159("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class69.method1159("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class69.method1159("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class69.method1159("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class69.method1159("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class69.method1159("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class69.method1159("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class69.method1159("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class69.method1159("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class69.method1159("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class69.method1159("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class69.method1159("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class69.method1159("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class69.method1159("Enter the 6-digit code generated by your", "authenticator app.", "");
            MouseInput.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class69.method1159("The code you entered was incorrect.", "Please try again.", "");
            MouseInput.setGameState(11);
            return;
         }

         class69.method1159("Unexpected server response", "Please try using a different world.", "");
      }

      MouseInput.setGameState(10);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "1484380570"
   )
   @Export("parseInt")
   public static int parseInt(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-1887622659"
   )
   static final void method164(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int[] var7 = Region.method2817(var0, var1, var2);
      int[] var8 = Region.method2817(var3, var4, var5);
      Rasterizer2D.drawLine(var7[0], var7[1], var8[0], var8[1], var6);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1758452654"
   )
   public static void method162() {
      FloorUnderlayDefinition.underlays.reset();
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "2139252835"
   )
   static final void method159(int var0, int var1, int var2, int var3, int var4) {
      class60.field753[0].method5058(var0, var1);
      class60.field753[1].method5058(var0, var3 + var1 - 16);
      Rasterizer2D.method4968(var0, var1 + 16, 16, var3 - 32, Client.field1002);
      int var5 = var3 * (var3 - 32) / var4;
      if(var5 < 8) {
         var5 = 8;
      }

      int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
      Rasterizer2D.method4968(var0, var6 + var1 + 16, 16, var5, Client.field1003);
      Rasterizer2D.method4979(var0, var6 + var1 + 16, var5, Client.field1179);
      Rasterizer2D.method4979(var0 + 1, var6 + var1 + 16, var5, Client.field1179);
      Rasterizer2D.method4985(var0, var6 + var1 + 16, 16, Client.field1179);
      Rasterizer2D.method4985(var0, var6 + var1 + 17, 16, Client.field1179);
      Rasterizer2D.method4979(var0 + 15, var6 + var1 + 16, var5, Client.field1004);
      Rasterizer2D.method4979(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field1004);
      Rasterizer2D.method4985(var0, var5 + var6 + var1 + 15, 16, Client.field1004);
      Rasterizer2D.method4985(var0 + 1, var6 + var5 + var1 + 14, 15, Client.field1004);
   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "340754593"
   )
   static final void method150(int var0, int var1, boolean var2) {
      if(!var2 || var0 != class13.field278 || GroundObject.field1873 != var1) {
         class13.field278 = var0;
         GroundObject.field1873 = var1;
         MouseInput.setGameState(25);
         class88.drawStatusBox("Loading - please wait.", true);
         int var3 = class47.baseX;
         int var4 = class44.baseY;
         class47.baseX = (var0 - 6) * 8;
         class44.baseY = (var1 - 6) * 8;
         int var5 = class47.baseX - var3;
         int var6 = class44.baseY - var4;
         var3 = class47.baseX;
         var4 = class44.baseY;

         int var7;
         int var9;
         for(var7 = 0; var7 < '耀'; ++var7) {
            NPC var8 = Client.cachedNPCs[var7];
            if(var8 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var8.pathX[var9] -= var5;
                  var8.pathY[var9] -= var6;
               }

               var8.x -= var5 * 128;
               var8.y -= var6 * 128;
            }
         }

         for(var7 = 0; var7 < 2048; ++var7) {
            Player var21 = Client.cachedPlayers[var7];
            if(var21 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var21.pathX[var9] -= var5;
                  var21.pathY[var9] -= var6;
               }

               var21.x -= var5 * 128;
               var21.y -= var6 * 128;
            }
         }

         byte var20 = 0;
         byte var18 = 104;
         byte var22 = 1;
         if(var5 < 0) {
            var20 = 103;
            var18 = -1;
            var22 = -1;
         }

         byte var10 = 0;
         byte var11 = 104;
         byte var12 = 1;
         if(var6 < 0) {
            var10 = 103;
            var11 = -1;
            var12 = -1;
         }

         int var14;
         for(int var13 = var20; var13 != var18; var13 += var22) {
            for(var14 = var10; var14 != var11; var14 += var12) {
               int var15 = var5 + var13;
               int var16 = var6 + var14;

               for(int var17 = 0; var17 < 4; ++var17) {
                  if(var15 >= 0 && var16 >= 0 && var15 < 104 && var16 < 104) {
                     Client.groundItemDeque[var17][var13][var14] = Client.groundItemDeque[var17][var15][var16];
                  } else {
                     Client.groundItemDeque[var17][var13][var14] = null;
                  }
               }
            }
         }

         for(PendingSpawn var19 = (PendingSpawn)Client.pendingSpawns.getFront(); var19 != null; var19 = (PendingSpawn)Client.pendingSpawns.getNext()) {
            var19.x -= var5;
            var19.y -= var6;
            if(var19.x < 0 || var19.y < 0 || var19.x >= 104 || var19.y >= 104) {
               var19.unlink();
            }
         }

         if(Client.destinationX != 0) {
            Client.destinationX -= var5;
            Client.destinationY -= var6;
         }

         Client.field1166 = 0;
         Client.field1172 = false;
         Client.field1153 = -1;
         Client.graphicsObjectDeque.clear();
         Client.projectiles.clear();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].reset();
         }

      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "1"
   )
   public static boolean method160(int var0) {
      return (var0 >> 21 & 1) != 0;
   }
}
