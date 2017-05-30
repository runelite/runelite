import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class44 extends WorldMapData {
   @ObfuscatedName("b")
   HashSet field571;
   @ObfuscatedName("o")
   List field572;
   @ObfuscatedName("rc")
   @ObfuscatedGetter(
      intValue = 441150583
   )
   static int field573;
   @ObfuscatedName("cu")
   @Export("indexTrack1")
   static IndexData indexTrack1;
   @ObfuscatedName("x")
   HashSet field578;

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "(LBuffer;LBuffer;LBuffer;IZI)V",
      garbageValue = "-310776848"
   )
   void method640(Buffer var1, Buffer var2, Buffer var3, int var4, boolean var5) {
      this.loadMapData(var1, var4);
      int var6 = var3.readUnsignedShort();
      this.field571 = new HashSet(var6);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         class22 var8 = new class22();

         try {
            var8.method159(var2, var3);
         } catch (IllegalStateException var13) {
            continue;
         }

         this.field571.add(var8);
      }

      var7 = var3.readUnsignedShort();
      this.field578 = new HashSet(var7);

      for(int var11 = 0; var11 < var7; ++var11) {
         class45 var9 = new class45();

         try {
            var9.method652(var2, var3);
         } catch (IllegalStateException var12) {
            continue;
         }

         this.field578.add(var9);
      }

      this.method641(var2, var5);
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(LBuffer;ZB)V",
      garbageValue = "107"
   )
   void method641(Buffer var1, boolean var2) {
      this.field572 = new LinkedList();
      int var3 = var1.readUnsignedShort();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1.method3214();
         Coordinates var6 = new Coordinates(var1.readInt());
         boolean var7 = var1.readUnsignedByte() == 1;
         if(var2 || !var7) {
            this.field572.add(new class25(var5, var6));
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1251495393"
   )
   static int method643() {
      return ++class98.field1520 - 1;
   }

   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIB)V",
      garbageValue = "75"
   )
   static void method644(Player var0, int var1, int var2) {
      if(var1 == var0.animation && var1 != -1) {
         int var3 = class165.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field1220 = 0;
            var0.actionAnimationDisable = var2;
            var0.field1234 = 0;
         }

         if(var3 == 2) {
            var0.field1234 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || class165.getAnimation(var1).forcedPriority >= class165.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field1220 = 0;
         var0.actionAnimationDisable = var2;
         var0.field1234 = 0;
         var0.field1236 = var0.field1252;
      }

   }

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-687599986"
   )
   static final void method645(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field1093; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var1 + var3) {
            Client.field1095[var4] = true;
         }
      }

   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-426037629"
   )
   static void method646(int var0) {
      if(var0 == -3) {
         Buffer.method3383("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         Buffer.method3383("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         Buffer.method3383("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class92.loginIndex = 3;
      } else if(var0 == 4) {
         Buffer.method3383("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         Buffer.method3383("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         Buffer.method3383("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         Buffer.method3383("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         Buffer.method3383("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         Buffer.method3383("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         Buffer.method3383("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         Buffer.method3383("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         Buffer.method3383("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         Buffer.method3383("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         Buffer.method3383("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         Buffer.method3383("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         Buffer.method3383("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         Buffer.method3383("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         Buffer.method3383("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         Buffer.method3383("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         Buffer.method3383("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         Buffer.method3383("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         Buffer.method3383("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         Buffer.method3383("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         Buffer.method3383("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         Buffer.method3383("", "Service unavailable.", "");
      } else if(var0 == 31) {
         Buffer.method3383("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         Buffer.method3383("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         Buffer.method3383("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         Buffer.method3383("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         Buffer.method3383("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            Buffer.method3383("Enter the 6-digit code generated by your", "authenticator app.", "");
            class12.setGameState(11);
            return;
         }

         if(var0 == 57) {
            Buffer.method3383("The code you entered was incorrect.", "Please try again.", "");
            class12.setGameState(11);
            return;
         }

         Buffer.method3383("Unexpected server response", "Please try using a different world.", "");
      }

      class12.setGameState(10);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILRegion;[LCollisionData;I)V",
      garbageValue = "-874713368"
   )
   static final void method647(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Region var8, CollisionData[] var9) {
      Buffer var10 = new Buffer(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.method3212();
         if(var12 == 0) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.method3212();
            if(var14 == 0) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.readUnsignedByte();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if(var4 == var17 && var16 >= var5 && var16 < var5 + 8 && var15 >= var6 && var15 < var6 + 8) {
               ObjectComposition var21 = class43.getObjectDefinition(var11);
               int var24 = var16 & 7;
               int var25 = var15 & 7;
               int var27 = var21.sizeX;
               int var28 = var21.sizeY;
               int var29;
               if((var20 & 1) == 1) {
                  var29 = var27;
                  var27 = var28;
                  var28 = var29;
               }

               int var26 = var7 & 3;
               int var23;
               if(var26 == 0) {
                  var23 = var24;
               } else if(var26 == 1) {
                  var23 = var25;
               } else if(var26 == 2) {
                  var23 = 7 - var24 - (var27 - 1);
               } else {
                  var23 = 7 - var25 - (var28 - 1);
               }

               var29 = var23 + var2;
               int var30 = var3 + class41.method605(var16 & 7, var15 & 7, var7, var21.sizeX, var21.sizeY, var20);
               if(var29 > 0 && var30 > 0 && var29 < 103 && var30 < 103) {
                  int var31 = var1;
                  if((class61.tileSettings[1][var29][var30] & 2) == 2) {
                     var31 = var1 - 1;
                  }

                  CollisionData var32 = null;
                  if(var31 >= 0) {
                     var32 = var9[var31];
                  }

                  class36.method500(var1, var29, var30, var11, var20 + var7 & 3, var19, var8, var32);
               }
            }
         }
      }
   }

   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "(IIII)LWidgetNode;",
      garbageValue = "-1839892904"
   )
   static final WidgetNode method649(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.field810 = var2;
      Client.componentTable.method3617(var3, (long)var0);
      class54.method789(var1);
      Widget var4 = class261.method4792(var0);
      class219.method4130(var4);
      if(Client.field1054 != null) {
         class219.method4130(Client.field1054);
         Client.field1054 = null;
      }

      XGrandExchangeOffer.method110();
      class24.method176(class90.widgets[var0 >> 16], var4, false);
      class17.method119(var1);
      if(Client.widgetRoot != -1) {
         int var5 = Client.widgetRoot;
         if(class14.method75(var5)) {
            ChatLineBuffer.method1907(class90.widgets[var5], 1);
         }
      }

      return var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lclass240;",
      garbageValue = "-2073192053"
   )
   public static class240 method650(int var0) {
      class240 var1 = (class240)class240.field3266.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class240.field3268.getConfigData(5, var0);
         var1 = new class240();
         if(var2 != null) {
            var1.method4346(new Buffer(var2));
         }

         class240.field3266.put(var1, (long)var0);
         return var1;
      }
   }
}
