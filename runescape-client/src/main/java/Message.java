import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
@Implements("Message")
public class Message extends DualNode {
   @ObfuscatedName("i")
   @Export("__bm_i")
   static int[] __bm_i;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1597147817
   )
   @Export("count")
   int count;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1164592791
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1223792995
   )
   @Export("type")
   int type;
   @ObfuscatedName("w")
   @Export("sender")
   String sender;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   @Export("senderUsername")
   Username senderUsername;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   @Export("isFromFriend0")
   TriBool isFromFriend0;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   @Export("isFromIgnored0")
   TriBool isFromIgnored0;
   @ObfuscatedName("l")
   @Export("prefix")
   String prefix;
   @ObfuscatedName("e")
   @Export("text")
   String text;

   Message(int var1, String var2, String var3, String var4) {
      this.isFromFriend0 = TriBool.TriBool_unknown;
      this.isFromIgnored0 = TriBool.TriBool_unknown;
      this.set(var1, var2, var3, var4);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "0"
   )
   @Export("set")
   void set(int var1, String var2, String var3, String var4) {
      int var5 = ++Messages.Messages_count - 1;
      this.count = var5;
      this.cycle = Client.cycle;
      this.type = var1;
      this.sender = var2;
      this.fillSenderUsername();
      this.prefix = var3;
      this.text = var4;
      this.clearIsFromFriend();
      this.clearIsFromIgnored();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1329978160"
   )
   @Export("clearIsFromFriend")
   void clearIsFromFriend() {
      this.isFromFriend0 = TriBool.TriBool_unknown;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1101818251"
   )
   @Export("isFromFriend")
   final boolean isFromFriend() {
      if(this.isFromFriend0 == TriBool.TriBool_unknown) {
         this.fillIsFromFriend();
      }

      return this.isFromFriend0 == TriBool.TriBool_true;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "633960833"
   )
   @Export("fillIsFromFriend")
   void fillIsFromFriend() {
      this.isFromFriend0 = WorldMapArea.friendSystem.friendsList.contains(this.senderUsername)?TriBool.TriBool_true:TriBool.TriBool_false;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1102127876"
   )
   @Export("clearIsFromIgnored")
   void clearIsFromIgnored() {
      this.isFromIgnored0 = TriBool.TriBool_unknown;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "21"
   )
   @Export("isFromIgnored")
   final boolean isFromIgnored() {
      if(this.isFromIgnored0 == TriBool.TriBool_unknown) {
         this.fillIsFromIgnored();
      }

      return this.isFromIgnored0 == TriBool.TriBool_true;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-3962"
   )
   @Export("fillIsFromIgnored")
   void fillIsFromIgnored() {
      this.isFromIgnored0 = WorldMapArea.friendSystem.ignoreList.contains(this.senderUsername)?TriBool.TriBool_true:TriBool.TriBool_false;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "89"
   )
   @Export("fillSenderUsername")
   final void fillSenderUsername() {
      if(this.sender != null) {
         this.senderUsername = new Username(NpcDefinition.method5161(this.sender), KeyHandler.loginType);
      } else {
         this.senderUsername = null;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Llx;I)Ljava/lang/String;",
      garbageValue = "-1905151806"
   )
   public static String method1229(CharSequence var0, LoginType var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         boolean var4;
         char var5;
         for(var3 = var0.length(); var2 < var3; ++var2) {
            var5 = var0.charAt(var2);
            var4 = var5 == 160 || var5 == ' ' || var5 == '_' || var5 == '-';
            if(!var4) {
               break;
            }
         }

         while(var3 > var2) {
            var5 = var0.charAt(var3 - 1);
            var4 = var5 == 160 || var5 == ' ' || var5 == '_' || var5 == '-';
            if(!var4) {
               break;
            }

            --var3;
         }

         int var14 = var3 - var2;
         if(var14 >= 1) {
            byte var6;
            if(var1 == null) {
               var6 = 12;
            } else {
               switch(var1.__x) {
               case 7:
                  var6 = 20;
                  break;
               default:
                  var6 = 12;
               }
            }

            if(var14 <= var6) {
               StringBuilder var12 = new StringBuilder(var14);

               for(int var15 = var2; var15 < var3; ++var15) {
                  char var7 = var0.charAt(var15);
                  boolean var8;
                  if(Character.isISOControl(var7)) {
                     var8 = false;
                  } else if(VarcInt.method4807(var7)) {
                     var8 = true;
                  } else {
                     char[] var13 = class305.__kb_q;
                     int var10 = 0;

                     label118:
                     while(true) {
                        char var11;
                        if(var10 >= var13.length) {
                           var13 = class305.__kb_w;

                           for(var10 = 0; var10 < var13.length; ++var10) {
                              var11 = var13[var10];
                              if(var7 == var11) {
                                 var8 = true;
                                 break label118;
                              }
                           }

                           var8 = false;
                           break;
                        }

                        var11 = var13[var10];
                        if(var7 == var11) {
                           var8 = true;
                           break;
                        }

                        ++var10;
                     }
                  }

                  if(var8) {
                     char var9;
                     switch(var7) {
                     case ' ':
                     case '-':
                     case '_':
                     case ' ':
                        var9 = '_';
                        break;
                     case '#':
                     case '[':
                     case ']':
                        var9 = var7;
                        break;
                     case 'À':
                     case 'Á':
                     case 'Â':
                     case 'Ã':
                     case 'Ä':
                     case 'à':
                     case 'á':
                     case 'â':
                     case 'ã':
                     case 'ä':
                        var9 = 'a';
                        break;
                     case 'Ç':
                     case 'ç':
                        var9 = 'c';
                        break;
                     case 'È':
                     case 'É':
                     case 'Ê':
                     case 'Ë':
                     case 'è':
                     case 'é':
                     case 'ê':
                     case 'ë':
                        var9 = 'e';
                        break;
                     case 'Í':
                     case 'Î':
                     case 'Ï':
                     case 'í':
                     case 'î':
                     case 'ï':
                        var9 = 'i';
                        break;
                     case 'Ñ':
                     case 'ñ':
                        var9 = 'n';
                        break;
                     case 'Ò':
                     case 'Ó':
                     case 'Ô':
                     case 'Õ':
                     case 'Ö':
                     case 'ò':
                     case 'ó':
                     case 'ô':
                     case 'õ':
                     case 'ö':
                        var9 = 'o';
                        break;
                     case 'Ù':
                     case 'Ú':
                     case 'Û':
                     case 'Ü':
                     case 'ù':
                     case 'ú':
                     case 'û':
                     case 'ü':
                        var9 = 'u';
                        break;
                     case 'ß':
                        var9 = 'b';
                        break;
                     case 'ÿ':
                     case 'Ÿ':
                        var9 = 'y';
                        break;
                     default:
                        var9 = Character.toLowerCase(var7);
                     }

                     if(var9 != 0) {
                        var12.append(var9);
                     }
                  }
               }

               if(var12.length() == 0) {
                  return null;
               }

               return var12.toString();
            }
         }

         return null;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)Lbm;",
      garbageValue = "-1262174034"
   )
   static Message method1226(int var0, int var1) {
      ChatChannel var2 = (ChatChannel)Messages.Messages_channels.get(Integer.valueOf(var0));
      return var2.getMessage(var1);
   }

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2007966264"
   )
   static final void method1228() {
      if(SoundSystem.plane != Client.__client_ph) {
         Client.__client_ph = SoundSystem.plane;
         int var0 = SoundSystem.plane;
         int[] var1 = WidgetGroupParent.sceneMinimapSprite.pixels;
         int var2 = var1.length;

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            var1[var3] = 0;
         }

         int var4;
         int var5;
         for(var3 = 1; var3 < 103; ++var3) {
            var4 = (103 - var3) * 2048 + 24628;

            for(var5 = 1; var5 < 103; ++var5) {
               if((Tiles.Tiles_renderFlags[var0][var5][var3] & 24) == 0) {
                  class65.scene.drawTileMinimap(var1, var4, 512, var0, var5, var3);
               }

               if(var0 < 3 && (Tiles.Tiles_renderFlags[var0 + 1][var5][var3] & 8) != 0) {
                  class65.scene.drawTileMinimap(var1, var4, 512, var0 + 1, var5, var3);
               }

               var4 += 4;
            }
         }

         var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
         var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
         WidgetGroupParent.sceneMinimapSprite.setRaster();

         int var6;
         for(var5 = 1; var5 < 103; ++var5) {
            for(var6 = 1; var6 < 103; ++var6) {
               if((Tiles.Tiles_renderFlags[var0][var6][var5] & 24) == 0) {
                  MouseRecorder.drawObject(var0, var6, var5, var3, var4);
               }

               if(var0 < 3 && (Tiles.Tiles_renderFlags[var0 + 1][var6][var5] & 8) != 0) {
                  MouseRecorder.drawObject(var0 + 1, var6, var5, var3, var4);
               }
            }
         }

         Client.mapIconCount = 0;

         for(var5 = 0; var5 < 104; ++var5) {
            for(var6 = 0; var6 < 104; ++var6) {
               long var7 = class65.scene.getFloorDecorationTag(SoundSystem.plane, var5, var6);
               if(var7 != 0L) {
                  int var9 = HitSplatDefinition.method4972(var7);
                  int var10 = class50.getObjectDefinition(var9).mapIconId;
                  if(var10 >= 0) {
                     Client.mapIcons[Client.mapIconCount] = ViewportMouse.getWorldMapElement(var10).getSprite(false);
                     Client.mapIconXs[Client.mapIconCount] = var5;
                     Client.mapIconYs[Client.mapIconCount] = var6;
                     ++Client.mapIconCount;
                  }
               }
            }
         }

         class197.rasterProvider.apply();
      }

   }

   @ObfuscatedName("kx")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "1047910257"
   )
   static String method1227(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.gameBuild == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.gameBuild == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.gameBuild == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.gameBuild == 5) {
         var0 = var0 + "-wti";
      } else if(Client.gameBuild == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(class21.__b_by != null) {
         var3 = "/p=" + class21.__b_by;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.language + "/a=" + AbstractIndexCache.__ir_bu + var3 + "/";
   }
}
