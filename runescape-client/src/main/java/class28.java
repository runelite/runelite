import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public abstract class class28 {
   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("indexModels")
   static IndexData indexModels;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1331303077
   )
   int field405;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2052420463
   )
   int field399;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -931678763
   )
   int field410;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2096064817
   )
   int field398;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1741595549
   )
   int field402;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1437598101
   )
   int field403;
   @ObfuscatedName("s")
   short[][][] field404;
   @ObfuscatedName("y")
   short[][][] field400;
   @ObfuscatedName("c")
   byte[][][] field406;
   @ObfuscatedName("h")
   byte[][][] field407;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "[[[[Lay;"
   )
   @Export("decorations")
   WorldMapDecoration[][][][] decorations;

   class28() {
      new LinkedList();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IILgg;I)V",
      garbageValue = "698201121"
   )
   void method223(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if(var4 != 0) {
         if((var4 & 1) != 0) {
            this.method236(var1, var2, var3, var4);
         } else {
            this.method231(var1, var2, var3, var4);
         }

      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IILgg;II)V",
      garbageValue = "-1011939675"
   )
   void method236(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if(var5) {
         this.field400[0][var1][var2] = (short)var3.readUnsignedByte();
      }

      this.field404[0][var1][var2] = (short)var3.readUnsignedByte();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IILgg;II)V",
      garbageValue = "914077383"
   )
   void method231(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.field404[0][var1][var2] = (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var11;
      if(var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var10 = var3.readUnsignedByte();
            if(var10 != 0) {
               this.field400[var9][var1][var2] = (short)var10;
               var11 = var3.readUnsignedByte();
               this.field406[var9][var1][var2] = (byte)(var11 >> 2);
               this.field407[var9][var1][var2] = (byte)(var11 & 3);
            }
         }
      }

      if(var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if(var9 != 0) {
               WorldMapDecoration[] var14 = this.decorations[var8][var1][var2] = new WorldMapDecoration[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  int var12 = var3.method3614();
                  int var13 = var3.readUnsignedByte();
                  var14[var11] = new WorldMapDecoration(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "0"
   )
   int method226(int var1, int var2) {
      return var1 >= 0 && var2 >= 0?(var1 < 64 && var2 < 64?this.field404[0][var1][var2] - 1:-1):-1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1489738419"
   )
   int method227() {
      return this.field410;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1832301011"
   )
   int method228() {
      return this.field398;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljr;Ljr;ZIS)V",
      garbageValue = "8222"
   )
   static void method245(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(class90.field1335) {
         if(var3 == 4) {
            class90.loginIndex = 4;
         }

      } else {
         class90.loginIndex = var3;
         Rasterizer2D.reset();
         byte[] var4 = var0.takeRecordByNames("title.jpg", "");
         class90.field1359 = class265.method4809(var4);
         class90.field1340 = class90.field1359.method5905();
         if((Client.flags & 536870912) != 0) {
            GrandExchangeOffer.logoSprite = class62.getSprite(var1, "logo_deadman_mode", "");
         } else {
            GrandExchangeOffer.logoSprite = class62.getSprite(var1, "logo", "");
         }

         class90.field1337 = class62.getSprite(var1, "titlebox", "");
         class149.field2106 = class62.getSprite(var1, "titlebutton", "");
         class90.runeSprites = class243.getIndexedSprites(var1, "runes", "");
         class85.titlemuteSprite = class243.getIndexedSprites(var1, "title_mute", "");
         BaseVarType.field33 = class62.getSprite(var1, "options_radio_buttons,0", "");
         BoundingBox3D.field262 = class62.getSprite(var1, "options_radio_buttons,4", "");
         class21.field339 = class62.getSprite(var1, "options_radio_buttons,2", "");
         MessageNode.field811 = class62.getSprite(var1, "options_radio_buttons,6", "");
         Buffer.field2571 = BaseVarType.field33.width;
         WidgetNode.field770 = BaseVarType.field33.height;
         class37.field501 = new int[256];

         int var5;
         for(var5 = 0; var5 < 64; ++var5) {
            class37.field501[var5] = var5 * 262144;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class37.field501[var5 + 64] = var5 * 1024 + 16711680;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class37.field501[var5 + 128] = var5 * 4 + 16776960;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class37.field501[var5 + 192] = 16777215;
         }

         class317.field3926 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            class317.field3926[var5] = var5 * 1024;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class317.field3926[var5 + 64] = var5 * 4 + 65280;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class317.field3926[var5 + 128] = var5 * 262144 + 65535;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class317.field3926[var5 + 192] = 16777215;
         }

         class3.field18 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            class3.field18[var5] = var5 * 4;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class3.field18[var5 + 64] = var5 * 262144 + 255;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class3.field18[var5 + 128] = var5 * 1024 + 16711935;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class3.field18[var5 + 192] = 16777215;
         }

         class90.field1338 = new int[256];
         class199.field2604 = new int['耀'];
         class33.field459 = new int['耀'];
         CombatInfoListHolder.method1931((IndexedSprite)null);
         MouseRecorder.field789 = new int['耀'];
         WorldMapManager.field559 = new int['耀'];
         if(var2) {
            class90.username = "";
            class90.password = "";
         }

         class21.field338 = 0;
         WidgetNode.field767 = "";
         class90.field1362 = true;
         class90.worldSelectShown = false;
         if(!Client.preferences.muted) {
            VarPlayerType.method4853(2, class7.indexTrack1, "scape main", "", 255, false);
         } else {
            class229.field2694 = 1;
            class132.field1905 = null;
            class321.field3940 = -1;
            class132.field1897 = -1;
            AttackOption.field1334 = 0;
            Signlink.field2193 = false;
            class20.field335 = 2;
         }

         class19.sendConInfo(false);
         class90.field1335 = true;
         class90.field1336 = (FaceNormal.canvasWidth - 765) / 2;
         class90.loginWindowX = class90.field1336 + 202;
         GrandExchangeEvent.field293 = class90.loginWindowX + 180;
         class90.field1359.method5915(class90.field1336, 0);
         class90.field1340.method5915(class90.field1336 + 382, 0);
         GrandExchangeOffer.logoSprite.method5898(class90.field1336 + 382 - GrandExchangeOffer.logoSprite.width / 2, 18);
      }
   }

   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1674049905"
   )
   static void method242(int var0) {
      if(var0 == -3) {
         VerticalAlignment.method4829("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         VerticalAlignment.method4829("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         VerticalAlignment.method4829("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class90.loginIndex = 3;
      } else if(var0 == 4) {
         VerticalAlignment.method4829("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         VerticalAlignment.method4829("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         VerticalAlignment.method4829("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         VerticalAlignment.method4829("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         VerticalAlignment.method4829("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         VerticalAlignment.method4829("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         VerticalAlignment.method4829("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         VerticalAlignment.method4829("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         VerticalAlignment.method4829("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         VerticalAlignment.method4829("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         VerticalAlignment.method4829("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         VerticalAlignment.method4829("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         VerticalAlignment.method4829("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         VerticalAlignment.method4829("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         VerticalAlignment.method4829("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         VerticalAlignment.method4829("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         VerticalAlignment.method4829("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         VerticalAlignment.method4829("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         VerticalAlignment.method4829("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         VerticalAlignment.method4829("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         VerticalAlignment.method4829("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         VerticalAlignment.method4829("", "Service unavailable.", "");
      } else if(var0 == 31) {
         VerticalAlignment.method4829("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         VerticalAlignment.method4829("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         VerticalAlignment.method4829("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         VerticalAlignment.method4829("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         VerticalAlignment.method4829("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            VerticalAlignment.method4829("Enter the 6-digit code generated by your", "authenticator app.", "");
            class55.setGameState(11);
            return;
         }

         if(var0 == 57) {
            VerticalAlignment.method4829("The code you entered was incorrect.", "Please try again.", "");
            class55.setGameState(11);
            return;
         }

         VerticalAlignment.method4829("Unexpected server response", "Please try using a different world.", "");
      }

      class55.setGameState(10);
   }

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1902804331"
   )
   static final void method240() {
      if(Client.field899 > 0) {
         class1.method1();
      } else {
         Client.field902.method5273();
         class55.setGameState(40);
         Tile.field1812 = Client.field911.getSocket();
         Client.field911.method2138();
      }
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-29"
   )
   static final void method244() {
      PacketBuffer var0 = Client.field911.packetBuffer;
      var0.bitAccess();
      int var1 = var0.getBits(8);
      int var2;
      if(var1 < Client.npcIndexesCount) {
         for(var2 = var1; var2 < Client.npcIndexesCount; ++var2) {
            Client.field973[++Client.field972 - 1] = Client.npcIndices[var2];
         }
      }

      if(var1 > Client.npcIndexesCount) {
         throw new RuntimeException("");
      } else {
         Client.npcIndexesCount = 0;

         for(var2 = 0; var2 < var1; ++var2) {
            int var3 = Client.npcIndices[var2];
            NPC var4 = Client.cachedNPCs[var3];
            int var5 = var0.getBits(1);
            if(var5 == 0) {
               Client.npcIndices[++Client.npcIndexesCount - 1] = var3;
               var4.npcCycle = Client.gameCycle;
            } else {
               int var6 = var0.getBits(2);
               if(var6 == 0) {
                  Client.npcIndices[++Client.npcIndexesCount - 1] = var3;
                  var4.npcCycle = Client.gameCycle;
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var3;
               } else {
                  int var7;
                  int var8;
                  if(var6 == 1) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var3;
                     var4.npcCycle = Client.gameCycle;
                     var7 = var0.getBits(3);
                     var4.method1940(var7, (byte)1);
                     var8 = var0.getBits(1);
                     if(var8 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var3;
                     }
                  } else if(var6 == 2) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var3;
                     var4.npcCycle = Client.gameCycle;
                     var7 = var0.getBits(3);
                     var4.method1940(var7, (byte)2);
                     var8 = var0.getBits(3);
                     var4.method1940(var8, (byte)2);
                     int var9 = var0.getBits(1);
                     if(var9 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var3;
                     }
                  } else if(var6 == 3) {
                     Client.field973[++Client.field972 - 1] = var3;
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-29576"
   )
   static void method243() {
      class57.method880(ISAACCipher.field2620 / 2 + Varcs.menuX, class90.menuY);
   }
}
