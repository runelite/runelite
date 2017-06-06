import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public final class class10 extends class9 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1464073971
   )
   final int field251;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1827694963
   )
   final int field252;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1756048577
   )
   final int field254;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1916169949
   )
   final int field255;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2108714691
   )
   final int field256;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1875100459
   )
   final int field257;
   @ObfuscatedName("u")
   static int[] field258;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1245043403
   )
   final int field259;

   @ObfuscatedName("ev")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1586897259"
   )
   static void method43(int var0) {
      if(var0 == -3) {
         WorldMapType2.method496("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         WorldMapType2.method496("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         WorldMapType2.method496("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class92.loginIndex = 3;
      } else if(var0 == 4) {
         WorldMapType2.method496("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         WorldMapType2.method496("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         WorldMapType2.method496("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         WorldMapType2.method496("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         WorldMapType2.method496("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         WorldMapType2.method496("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         WorldMapType2.method496("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         WorldMapType2.method496("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         WorldMapType2.method496("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         WorldMapType2.method496("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         WorldMapType2.method496("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         WorldMapType2.method496("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         WorldMapType2.method496("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         WorldMapType2.method496("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         WorldMapType2.method496("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         WorldMapType2.method496("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         WorldMapType2.method496("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         WorldMapType2.method496("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         WorldMapType2.method496("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         WorldMapType2.method496("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         WorldMapType2.method496("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         WorldMapType2.method496("", "Service unavailable.", "");
      } else if(var0 == 31) {
         WorldMapType2.method496("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         WorldMapType2.method496("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         WorldMapType2.method496("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         WorldMapType2.method496("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         WorldMapType2.method496("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            WorldMapType2.method496("Enter the 6-digit code generated by your", "authenticator app.", "");
            class249.setGameState(11);
            return;
         }

         if(var0 == 57) {
            WorldMapType2.method496("The code you entered was incorrect.", "Please try again.", "");
            class249.setGameState(11);
            return;
         }

         WorldMapType2.method496("Unexpected server response", "Please try using a different world.", "");
      }

      class249.setGameState(10);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1403509867"
   )
   public final void vmethod44() {
      for(int var4 = 0; var4 < 8; ++var4) {
         int var1 = (var4 & 1) == 0?this.field255:this.field254;
         int var2 = (var4 & 2) == 0?this.field252:this.field259;
         int var3 = (var4 & 4) == 0?this.field256:this.field251;
         if((var4 & 1) == 0) {
            Actor.method1534(var1, var2, var3, this.field254, var2, var3, this.field257);
         }

         if((var4 & 2) == 0) {
            Actor.method1534(var1, var2, var3, var1, this.field259, var3, this.field257);
         }

         if((var4 & 4) == 0) {
            Actor.method1534(var1, var2, var3, var1, var2, this.field251, this.field257);
         }
      }

   }

   class10(Model var1, int var2, int var3, int var4, int var5) {
      this.field255 = var1.field1969 + var2 - var1.field1972;
      this.field252 = var3 + var1.field1937 - var1.field1973;
      this.field256 = var4 + var1.field1980 - var1.field1981;
      this.field254 = var1.field1972 + var1.field1969 + var2;
      this.field259 = var1.field1973 + var3 + var1.field1937;
      this.field251 = var1.field1981 + var1.field1980 + var4;
      this.field257 = var5;
   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-62154925"
   )
   static final void method47(int var0) {
      class2.method0();

      for(class82 var1 = (class82)class82.field1348.method3576(); var1 != null; var1 = (class82)class82.field1348.method3578()) {
         if(var1.field1354 != null) {
            var1.method1597();
         }
      }

      int var4 = class23.method159(var0).field3285;
      if(var4 != 0) {
         int var2 = class211.widgetSettings[var0];
         if(var4 == 1) {
            if(var2 == 1) {
               class136.method2645(0.9D);
               ((TextureProvider)class136.field2049).method2367(0.9D);
            }

            if(var2 == 2) {
               class136.method2645(0.8D);
               ((TextureProvider)class136.field2049).method2367(0.8D);
            }

            if(var2 == 3) {
               class136.method2645(0.7D);
               ((TextureProvider)class136.field2049).method2367(0.7D);
            }

            if(var2 == 4) {
               class136.method2645(0.6D);
               ((TextureProvider)class136.field2049).method2367(0.6D);
            }

            ItemComposition.itemSpriteCache.reset();
         }

         if(var4 == 3) {
            short var5 = 0;
            if(var2 == 0) {
               var5 = 255;
            }

            if(var2 == 1) {
               var5 = 192;
            }

            if(var2 == 2) {
               var5 = 128;
            }

            if(var2 == 3) {
               var5 = 64;
            }

            if(var2 == 4) {
               var5 = 0;
            }

            if(Client.field1165 != var5) {
               if(Client.field1165 == 0 && Client.field1166 != -1) {
                  class59.method985(class22.indexTrack1, Client.field1166, 0, var5, false);
                  Client.field1123 = false;
               } else if(var5 == 0) {
                  class164.method3060();
                  Client.field1123 = false;
               } else {
                  class66.method1078(var5);
               }

               Client.field1165 = var5;
            }
         }

         if(var4 == 4) {
            if(var2 == 0) {
               Client.field1168 = 127;
            }

            if(var2 == 1) {
               Client.field1168 = 96;
            }

            if(var2 == 2) {
               Client.field1168 = 64;
            }

            if(var2 == 3) {
               Client.field1168 = 32;
            }

            if(var2 == 4) {
               Client.field1168 = 0;
            }
         }

         if(var4 == 5) {
            Client.field1067 = var2;
         }

         if(var4 == 6) {
            Client.field1092 = var2;
         }

         if(var4 == 9) {
            Client.field1005 = var2;
         }

         if(var4 == 10) {
            if(var2 == 0) {
               Client.field1169 = 127;
            }

            if(var2 == 1) {
               Client.field1169 = 96;
            }

            if(var2 == 2) {
               Client.field1169 = 64;
            }

            if(var2 == 3) {
               Client.field1169 = 32;
            }

            if(var2 == 4) {
               Client.field1169 = 0;
            }
         }

         if(var4 == 17) {
            Client.field1193 = var2 & '\uffff';
         }

         class91[] var3;
         if(var4 == 18) {
            var3 = new class91[]{class91.field1435, class91.field1439, class91.field1440, class91.field1436};
            Client.field953 = (class91)Item.method1751(var3, var2);
            if(Client.field953 == null) {
               Client.field953 = class91.field1440;
            }
         }

         if(var4 == 19) {
            if(var2 == -1) {
               Client.field1059 = -1;
            } else {
               Client.field1059 = var2 & 2047;
            }
         }

         if(var4 == 22) {
            var3 = new class91[]{class91.field1435, class91.field1439, class91.field1440, class91.field1436};
            Client.field984 = (class91)Item.method1751(var3, var2);
            if(Client.field984 == null) {
               Client.field984 = class91.field1440;
            }
         }

      }
   }

   @ObfuscatedName("el")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "16711935"
   )
   static final void method48() {
      class88.method1697();
      FloorUnderlayDefinition.field3338.reset();
      class211.method3906();
      ObjectComposition.field3440.reset();
      ObjectComposition.field3455.reset();
      ObjectComposition.field3436.reset();
      ObjectComposition.field3447.reset();
      class18.method119();
      ItemComposition.field3487.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
      class28.method225();
      Spotanim.field3322.reset();
      Spotanim.field3321.reset();
      Varbit.field3379.reset();
      class241.field3284.reset();
      class96.method1764();
      CombatInfo2.field3362.reset();
      CombatInfo2.spriteCache.reset();
      class252.field3392.reset();
      class98.method1839();
      Area.field3291.reset();
      class22.method144();
      VertexNormal.method2588();
      ((TextureProvider)class136.field2049).method2372();
      Script.field1552.reset();
      class46.indexInterfaces.method4173();
      class31.indexSoundEffects.method4173();
      class25.field365.method4173();
      ChatLineBuffer.field1567.method4173();
      XClanMember.indexMaps.method4173();
      class22.indexTrack1.method4173();
      class36.indexModels.method4173();
      class261.indexSprites.method4173();
      WorldMapType3.indexTextures.method4173();
      WidgetNode.field841.method4173();
      class4.indexTrack2.method4173();
      class23.indexScripts.method4173();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "947959196"
   )
   public static String method49(CharSequence var0) {
      return class17.method109('*', var0.length());
   }
}
