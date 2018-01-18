import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
@Implements("KeyFocusListener")
public final class KeyFocusListener implements KeyListener, FocusListener {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   @Export("keyboard")
   public static KeyFocusListener keyboard;
   @ObfuscatedName("cx")
   @Export("keyPressed")
   public static boolean[] keyPressed;
   @ObfuscatedName("cc")
   public static int[] field604;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = -2014194753
   )
   public static int field610;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 75262509
   )
   public static int field611;
   @ObfuscatedName("cy")
   static char[] field612;
   @ObfuscatedName("ct")
   static int[] field613;
   @ObfuscatedName("cp")
   public static int[] field614;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = -1252519125
   )
   public static int field615;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 711740489
   )
   public static int field600;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = 1113588999
   )
   public static int field595;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = 1870050307
   )
   public static int field618;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 2110236291
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks;
   @ObfuscatedName("cg")
   @Export("KeyHandler_keyCodes")
   static int[] KeyHandler_keyCodes;

   static {
      keyboard = new KeyFocusListener();
      keyPressed = new boolean[112];
      field604 = new int[128];
      field610 = 0;
      field611 = 0;
      field612 = new char[128];
      field613 = new int[128];
      field614 = new int[128];
      field615 = 0;
      field600 = 0;
      field595 = 0;
      field618 = 0;
      keyboardIdleTicks = 0;
      KeyHandler_keyCodes = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   }

   @Export("keyPressed")
   @ObfuscatedName("keyPressed")
   public final synchronized void keyPressed(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < KeyHandler_keyCodes.length) {
            var2 = KeyHandler_keyCodes[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field611 >= 0 && var2 >= 0) {
            field604[field611] = var2;
            field611 = field611 + 1 & 127;
            if(field610 == field611) {
               field611 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field595 + 1 & 127;
            if(var3 != field600) {
               field613[field595] = var2;
               field612[field595] = 0;
               field595 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < KeyHandler_keyCodes.length) {
            var2 = KeyHandler_keyCodes[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field611 >= 0 && var2 >= 0) {
            field604[field611] = ~var2;
            field611 = field611 + 1 & 127;
            if(field611 == field610) {
               field611 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field611 = -1;
      }

   }

   public final void keyTyped(KeyEvent var1) {
      if(keyboard != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff') {
            boolean var3;
            if(var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
               var3 = true;
            } else {
               label56: {
                  if(var2 != 0) {
                     char[] var7 = class277.cp1252AsciiExtension;

                     for(int var5 = 0; var5 < var7.length; ++var5) {
                        char var6 = var7[var5];
                        if(var2 == var6) {
                           var3 = true;
                           break label56;
                        }
                     }
                  }

                  var3 = false;
               }
            }

            if(var3) {
               int var4 = field595 + 1 & 127;
               if(var4 != field600) {
                  field613[field595] = -1;
                  field612[field595] = var2;
                  field595 = var4;
               }
            }
         }
      }

      var1.consume();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "91"
   )
   static final void method753(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class61.tileHeights[var0][var3 + var1][var4 + var2] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class61.tileHeights[var0][var1][var3 + var2] = class61.tileHeights[var0][var1 - 1][var3 + var2];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class61.tileHeights[var0][var3 + var1][var2] = class61.tileHeights[var0][var3 + var1][var2 - 1];
         }
      }

      if(var1 > 0 && class61.tileHeights[var0][var1 - 1][var2] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1 - 1][var2];
      } else if(var2 > 0 && class61.tileHeights[var0][var1][var2 - 1] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class61.tileHeights[var0][var1 - 1][var2 - 1] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1 - 1][var2 - 1];
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgr;ILbf;IB)V",
      garbageValue = "29"
   )
   static final void method755(PacketBuffer var0, int var1, Player var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 4096) != 0) {
         var2.graphic = var0.method3518();
         var5 = var0.readInt();
         var2.field1190 = var5 >> 16;
         var2.graphicsDelay = (var5 & 65535) + Client.gameCycle;
         var2.field1187 = 0;
         var2.field1188 = 0;
         if(var2.graphicsDelay > Client.gameCycle) {
            var2.field1187 = -1;
         }

         if(var2.graphic == 65535) {
            var2.graphic = -1;
         }
      }

      if((var3 & 32) != 0) {
         var2.interacting = var0.method3337();
         if(var2.interacting == 65535) {
            var2.interacting = -1;
         }
      }

      if((var3 & 512) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.readString();
         }
      }

      int var9;
      int var10;
      if((var3 & 16) != 0) {
         var5 = var0.method3518();
         Permission[] var6 = new Permission[]{Permission.field3273, Permission.field3275, Permission.field3282, Permission.field3278, Permission.field3272, Permission.field3276};
         Permission var7 = (Permission)class34.forOrdinal(var6, var0.method3363());
         boolean var8 = var0.readUnsignedByteNegate() == 1;
         var9 = var0.readUnsignedByte();
         var10 = var0.offset;
         if(var2.name != null && var2.composition != null) {
            boolean var11 = false;
            if(var7.field3281 && class33.isIgnored(var2.name)) {
               var11 = true;
            }

            if(!var11 && Client.myPlayerIndex == 0 && !var2.hidden) {
               class94.field1414.offset = 0;
               var0.method3479(class94.field1414.payload, 0, var9);
               class94.field1414.offset = 0;
               String var12 = FontTypeFace.appendTags(class159.method3093(UrlRequester.method2972(class94.field1414)));
               var2.overhead = var12.trim();
               var2.field1166 = var5 >> 8;
               var2.field1167 = var5 & 255;
               var2.overheadTextCyclesRemaining = 150;
               var2.field1195 = var8;
               var2.inSequence = var2 != GrandExchangeOffer.localPlayer && var7.field3281 && "" != Client.field885 && var12.toLowerCase().indexOf(Client.field885) == -1;
               int var13;
               if(var7.field3280) {
                  var13 = var8?91:1;
               } else {
                  var13 = var8?90:2;
               }

               if(var7.field3279 != -1) {
                  Preferences.sendGameMessage(var13, CombatInfoListHolder.method1706(var7.field3279) + var2.name, var12);
               } else {
                  Preferences.sendGameMessage(var13, var2.name, var12);
               }
            }
         }

         var0.offset = var10 + var9;
      }

      if((var3 & 2) != 0) {
         var5 = var0.readUnsignedByteNegate();
         byte[] var17 = new byte[var5];
         Buffer var18 = new Buffer(var17);
         var0.method3479(var17, 0, var5);
         class94.field1404[var1] = var18;
         var2.decodeApperance(var18);
      }

      if((var3 & 1024) != 0) {
         class94.field1401[var1] = var0.method3368();
      }

      if((var3 & 2048) != 0) {
         var2.field1191 = var0.method3367();
         var2.field1193 = var0.method3395();
         var2.field1174 = var0.method3367();
         var2.field1206 = var0.method3395();
         var2.field1200 = var0.method3337() + Client.gameCycle;
         var2.field1196 = var0.method3337() + Client.gameCycle;
         var2.field1197 = var0.method3518();
         if(var2.field858) {
            var2.field1191 += var2.field839;
            var2.field1193 += var2.field835;
            var2.field1174 += var2.field839;
            var2.field1206 += var2.field835;
            var2.queueSize = 0;
         } else {
            var2.field1191 += var2.pathX[0];
            var2.field1193 += var2.pathY[0];
            var2.field1174 += var2.pathX[0];
            var2.field1206 += var2.pathY[0];
            var2.queueSize = 1;
         }

         var2.field1208 = 0;
      }

      int var14;
      if((var3 & 4) != 0) {
         var5 = var0.method3518();
         if(var5 == 65535) {
            var5 = -1;
         }

         var14 = var0.readUnsignedByte();
         class27.method207(var2, var5, var14);
      }

      if((var3 & 256) != 0) {
         var4 = var0.method3367();
      }

      if((var3 & 64) != 0) {
         var5 = var0.method3363();
         int var15;
         int var20;
         int var21;
         if(var5 > 0) {
            for(var14 = 0; var14 < var5; ++var14) {
               var20 = -1;
               var9 = -1;
               var10 = -1;
               var15 = var0.getUSmart();
               if(var15 == 32767) {
                  var15 = var0.getUSmart();
                  var9 = var0.getUSmart();
                  var20 = var0.getUSmart();
                  var10 = var0.getUSmart();
               } else if(var15 != 32766) {
                  var9 = var0.getUSmart();
               } else {
                  var15 = -1;
               }

               var21 = var0.getUSmart();
               var2.method1560(var15, var9, var20, var10, Client.gameCycle, var21);
            }
         }

         var14 = var0.readUnsignedByteNegate();
         if(var14 > 0) {
            for(var15 = 0; var15 < var14; ++var15) {
               var20 = var0.getUSmart();
               var9 = var0.getUSmart();
               if(var9 != 32767) {
                  var10 = var0.getUSmart();
                  var21 = var0.method3374();
                  int var16 = var9 > 0?var0.method3374():var21;
                  var2.method1556(var20, Client.gameCycle, var9, var10, var21, var16);
               } else {
                  var2.method1558(var20);
               }
            }
         }
      }

      if((var3 & 1) != 0) {
         var2.field1177 = var0.method3337();
         if(var2.queueSize == 0) {
            var2.orientation = var2.field1177;
            var2.field1177 = -1;
         }
      }

      if((var3 & 8) != 0) {
         var2.overhead = var0.readString();
         if(var2.overhead.charAt(0) == '~') {
            var2.overhead = var2.overhead.substring(1);
            Preferences.sendGameMessage(2, var2.name, var2.overhead);
         } else if(var2 == GrandExchangeOffer.localPlayer) {
            Preferences.sendGameMessage(2, var2.name, var2.overhead);
         }

         var2.field1195 = false;
         var2.field1166 = 0;
         var2.field1167 = 0;
         var2.overheadTextCyclesRemaining = 150;
      }

      if(var2.field858) {
         if(var4 == 127) {
            var2.method1154(var2.field839, var2.field835);
         } else {
            byte var19;
            if(var4 != -1) {
               var19 = var4;
            } else {
               var19 = class94.field1401[var1];
            }

            var2.method1151(var2.field839, var2.field835, var19);
         }
      }

   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(Lbm;B)V",
      garbageValue = "0"
   )
   static final void method754(Actor var0) {
      if(var0.field1202 != 0) {
         if(var0.interacting != -1) {
            Object var1 = null;
            if(var0.interacting < 32768) {
               var1 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= 32768) {
               var1 = Client.cachedPlayers[var0.interacting - 32768];
            }

            if(var1 != null) {
               int var2 = var0.x - ((Actor)var1).x;
               int var3 = var0.y - ((Actor)var1).y;
               if(var2 != 0 || var3 != 0) {
                  var0.orientation = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field1176) {
               var0.interacting = -1;
               var0.field1176 = false;
            }
         }

         if(var0.field1177 != -1 && (var0.queueSize == 0 || var0.field1207 > 0)) {
            var0.orientation = var0.field1177;
            var0.field1177 = -1;
         }

         int var4 = var0.orientation - var0.angle & 2047;
         if(var4 == 0 && var0.field1176) {
            var0.interacting = -1;
            var0.field1176 = false;
         }

         if(var4 != 0) {
            ++var0.field1201;
            boolean var6;
            if(var4 > 1024) {
               var0.angle -= var0.field1202;
               var6 = true;
               if(var4 < var0.field1202 || var4 > 2048 - var0.field1202) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field1201 > 25 || var6)) {
                  if(var0.field1156 != -1) {
                     var0.poseAnimation = var0.field1156;
                  } else {
                     var0.poseAnimation = var0.field1168;
                  }
               }
            } else {
               var0.angle += var0.field1202;
               var6 = true;
               if(var4 < var0.field1202 || var4 > 2048 - var0.field1202) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1201 > 25 || var6)) {
                  if(var0.field1173 != -1) {
                     var0.poseAnimation = var0.field1173;
                  } else {
                     var0.poseAnimation = var0.field1168;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field1201 = 0;
         }

      }
   }
}
