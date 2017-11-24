import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
@Implements("KeyFocusListener")
public final class KeyFocusListener implements KeyListener, FocusListener {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   @Export("keyboard")
   static KeyFocusListener keyboard;
   @ObfuscatedName("cn")
   public static boolean[] field606;
   @ObfuscatedName("cc")
   static int[] field619;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = -2059746819
   )
   static int field608;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 658646341
   )
   static int field614;
   @ObfuscatedName("cp")
   static char[] field610;
   @ObfuscatedName("ci")
   static int[] field611;
   @ObfuscatedName("cz")
   public static int[] field612;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = 1090757975
   )
   public static int field613;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = -180791883
   )
   static int field600;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = 1934041419
   )
   static int field618;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 1329267783
   )
   static int field616;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -53535837
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks;
   @ObfuscatedName("ct")
   static int[] field595;
   @ObfuscatedName("ev")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   @Export("font_p12full")
   static Font font_p12full;

   static {
      keyboard = new KeyFocusListener();
      field606 = new boolean[112];
      field619 = new int[128];
      field608 = 0;
      field614 = 0;
      field610 = new char[128];
      field611 = new int[128];
      field612 = new int[128];
      field613 = 0;
      field600 = 0;
      field618 = 0;
      field616 = 0;
      keyboardIdleTicks = 0;
      field595 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field595.length) {
            var2 = field595[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field614 >= 0 && var2 >= 0) {
            field619[field614] = ~var2;
            field614 = field614 + 1 & 127;
            if(field608 == field614) {
               field614 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void keyTyped(KeyEvent var1) {
      if(keyboard != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff' && class153.method3060(var2)) {
            int var3 = field618 + 1 & 127;
            if(var3 != field600) {
               field611[field618] = -1;
               field610[field618] = var2;
               field618 = var3;
            }
         }
      }

      var1.consume();
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field614 = -1;
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field595.length) {
            var2 = field595[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field614 >= 0 && var2 >= 0) {
            field619[field614] = var2;
            field614 = field614 + 1 & 127;
            if(field608 == field614) {
               field614 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field618 + 1 & 127;
            if(var3 != field600) {
               field611[field618] = var2;
               field610[field618] = 0;
               field618 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I[BLff;I)V",
      garbageValue = "-1301084547"
   )
   static void method762(int var0, byte[] var1, IndexFile var2) {
      FileSystem var3 = new FileSystem();
      var3.field3282 = 0;
      var3.hash = (long)var0;
      var3.field3280 = var1;
      var3.index = var2;
      Deque var4 = class243.field3307;
      synchronized(class243.field3307) {
         class243.field3307.addFront(var3);
      }

      class209.method3827();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-495685061"
   )
   static void method765() {
      class61.field724 = null;
      class61.field736 = null;
      class36.field481 = null;
      class61.field726 = null;
      class10.field242 = null;
      ScriptState.field745 = null;
      class61.field727 = null;
      class15.field287 = null;
      class43.field545 = null;
      GrandExchangeOffer.field300 = null;
      Permission.field3260 = null;
      Frames.field2044 = null;
   }

   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-737241912"
   )
   static final void method774(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         RSCanvas.preferences.hideRoofs = !RSCanvas.preferences.hideRoofs;
         class64.method1103();
         if(RSCanvas.preferences.hideRoofs) {
            class54.sendGameMessage(99, "", "Roofs are now all hidden");
         } else {
            class54.sendGameMessage(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         Client.displayFps = !Client.displayFps;
      }

      if(Client.rights >= 2) {
         if(var0.equalsIgnoreCase("aabb")) {
            if(!class7.field227) {
               class7.field227 = true;
               class7.field225 = class11.field254;
            } else if(class7.field225 == class11.field254) {
               class7.field227 = true;
               class7.field225 = class11.field258;
            } else {
               class7.field227 = false;
            }
         }

         if(var0.equalsIgnoreCase("fpson")) {
            Client.displayFps = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            Client.displayFps = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            class111.method2179();
         }

         if(var0.equalsIgnoreCase("errortest") && Client.socketType == 2) {
            throw new RuntimeException();
         }
      }

      PacketNode var1 = class218.method4105(ClientPacket.field2340, Client.field916.field1470);
      var1.packetBuffer.putByte(var0.length() + 1);
      var1.packetBuffer.putString(var0);
      Client.field916.method1925(var1);
   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(Lby;IIIIII)V",
      garbageValue = "-1062322571"
   )
   static final void method775(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(var0 != null && var0.hasConfig()) {
         if(var0 instanceof NPC) {
            NPCComposition var6 = ((NPC)var0).composition;
            if(var6.configs != null) {
               var6 = var6.transform();
            }

            if(var6 == null) {
               return;
            }
         }

         int var74 = class94.playerIndexesCount;
         int[] var7 = class94.playerIndices;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.combatInfoList.method3726()) {
            class28.characterToScreen(var0, var0.field1179 + 15);

            for(CombatInfoListHolder var9 = (CombatInfoListHolder)var0.combatInfoList.method3723(); var9 != null; var9 = (CombatInfoListHolder)var0.combatInfoList.method3720()) {
               CombatInfo1 var10 = var9.method1732(Client.gameCycle);
               if(var10 == null) {
                  if(var9.method1731()) {
                     var9.unlink();
                  }
               } else {
                  CombatInfo2 var11 = var9.combatInfo2;
                  SpritePixels var12 = var11.method4550();
                  SpritePixels var13 = var11.method4549();
                  int var15 = 0;
                  if(var12 != null && var13 != null) {
                     if(var11.field3431 * 2 < var13.width) {
                        var15 = var11.field3431;
                     }

                     var14 = var13.width - var15 * 2;
                  } else {
                     var14 = var11.healthScale;
                  }

                  int var16 = 255;
                  boolean var17 = true;
                  int var18 = Client.gameCycle - var10.field1206;
                  int var19 = var14 * var10.health / var11.healthScale;
                  int var20;
                  int var88;
                  if(var10.field1208 > var18) {
                     var20 = var11.field3436 == 0?0:var11.field3436 * (var18 / var11.field3436);
                     var21 = var14 * var10.healthRatio / var11.healthScale;
                     var88 = var20 * (var19 - var21) / var10.field1208 + var21;
                  } else {
                     var88 = var19;
                     var20 = var10.field1208 + var11.field3440 - var18;
                     if(var11.field3438 >= 0) {
                        var16 = (var20 << 8) / (var11.field3440 - var11.field3438);
                     }
                  }

                  if(var10.health > 0 && var88 < 1) {
                     var88 = 1;
                  }

                  var20 = var2 + Client.screenY - (var14 >> 1);
                  var21 = var3 + Client.screenX - var8;
                  if(var12 != null && var13 != null) {
                     var20 -= var15;
                     if(var88 == var14) {
                        var88 += var15 * 2;
                     } else {
                        var88 += var15;
                     }

                     var22 = var12.height;
                     var8 += var22;
                     if(var16 >= 0 && var16 < 255) {
                        var12.method5274(var20, var21, var16);
                        Rasterizer2D.setInnerDrawRegion(var20, var21, var20 + var88, var21 + var22);
                        var13.method5274(var20, var21, var16);
                     } else {
                        var12.drawAt(var20, var21);
                        Rasterizer2D.setInnerDrawRegion(var20, var21, var20 + var88, var22 + var21);
                        var13.drawAt(var20, var21);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var2 + var4, var3 + var5);
                     var8 += 2;
                  } else {
                     if(Client.screenY > -1) {
                        Rasterizer2D.method5173(var20, var21, var88, 5, 65280);
                        Rasterizer2D.method5173(var20 + var88, var21, var14 - var88, 5, 16711680);
                     }

                     var8 += 7;
                  }
               }
            }
         }

         if(var8 < 30) {
            var8 = 30;
         }

         if(var1 < var74) {
            Player var85 = (Player)var0;
            if(var85.hidden) {
               return;
            }

            if(var85.skullIcon != -1 || var85.overheadIcon != -1) {
               class28.characterToScreen(var0, var0.field1179 + 15);
               if(Client.screenY > -1) {
                  if(var85.skullIcon != -1) {
                     class43.headIconsPk[var85.skullIcon].drawAt(var2 + Client.screenY - 12, var3 + Client.screenX - var8);
                     var8 += 25;
                  }

                  if(var85.overheadIcon != -1) {
                     ScriptEvent.headIconsPrayer[var85.overheadIcon].drawAt(var2 + Client.screenY - 12, var3 + Client.screenX - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.hintArrowTargetType == 10 && var7[var1] == Client.hintArrowPlayerTargetIdx) {
               class28.characterToScreen(var0, var0.field1179 + 15);
               if(Client.screenY > -1) {
                  class33.headIconsHint[1].drawAt(var2 + Client.screenY - 12, var3 + Client.screenX - var8);
               }
            }
         } else {
            NPCComposition var86 = ((NPC)var0).composition;
            if(var86.configs != null) {
               var86 = var86.transform();
            }

            if(var86.field3621 >= 0 && var86.field3621 < ScriptEvent.headIconsPrayer.length) {
               class28.characterToScreen(var0, var0.field1179 + 15);
               if(Client.screenY > -1) {
                  ScriptEvent.headIconsPrayer[var86.field3621].drawAt(var2 + Client.screenY - 12, var3 + Client.screenX - 30);
               }
            }

            if(Client.hintArrowTargetType == 1 && Client.npcIndices[var1 - var74] == Client.hintArrowNpcTargetIdx && Client.gameCycle % 20 < 10) {
               class28.characterToScreen(var0, var0.field1179 + 15);
               if(Client.screenY > -1) {
                  class33.headIconsHint[0].drawAt(var2 + Client.screenY - 12, var3 + Client.screenX - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var74 || !var0.inSequence && (Client.field1070 == 4 || !var0.field1160 && (Client.field1070 == 0 || Client.field1070 == 3 || Client.field1070 == 1 && class2.isFriended(((Player)var0).name, false))))) {
            class28.characterToScreen(var0, var0.field1179);
            if(Client.screenY > -1 && Client.field947 < Client.field948) {
               Client.field952[Client.field947] = World.field1226.method4925(var0.overhead) / 2;
               Client.field951[Client.field947] = World.field1226.verticalSpace;
               Client.field949[Client.field947] = Client.screenY;
               Client.field950[Client.field947] = Client.screenX;
               Client.field910[Client.field947] = var0.field1163;
               Client.field954[Client.field947] = var0.field1164;
               Client.field913[Client.field947] = var0.field1177;
               Client.field876[Client.field947] = var0.overhead;
               ++Client.field947;
            }
         }

         for(int var75 = 0; var75 < 4; ++var75) {
            int var76 = var0.hitsplatCycles[var75];
            int var77 = var0.field1196[var75];
            class261 var87 = null;
            int var78 = 0;
            if(var77 >= 0) {
               if(var76 <= Client.gameCycle) {
                  continue;
               }

               var87 = class64.method1105(var0.field1196[var75]);
               var78 = var87.field3491;
               if(var87 != null && var87.field3496 != null) {
                  var87 = var87.method4661();
                  if(var87 == null) {
                     var0.hitsplatCycles[var75] = -1;
                     continue;
                  }
               }
            } else if(var76 < 0) {
               continue;
            }

            var14 = var0.field1162[var75];
            class261 var79 = null;
            if(var14 >= 0) {
               var79 = class64.method1105(var14);
               if(var79 != null && var79.field3496 != null) {
                  var79 = var79.method4661();
               }
            }

            if(var76 - var78 <= Client.gameCycle) {
               if(var87 == null) {
                  var0.hitsplatCycles[var75] = -1;
               } else {
                  class28.characterToScreen(var0, var0.field1179 / 2);
                  if(Client.screenY > -1) {
                     if(var75 == 1) {
                        Client.screenX -= 20;
                     }

                     if(var75 == 2) {
                        Client.screenY -= 15;
                        Client.screenX -= 10;
                     }

                     if(var75 == 3) {
                        Client.screenY += 15;
                        Client.screenX -= 10;
                     }

                     SpritePixels var80 = null;
                     SpritePixels var81 = null;
                     SpritePixels var82 = null;
                     SpritePixels var83 = null;
                     var21 = 0;
                     var22 = 0;
                     int var23 = 0;
                     int var24 = 0;
                     int var25 = 0;
                     int var26 = 0;
                     int var27 = 0;
                     int var28 = 0;
                     SpritePixels var29 = null;
                     SpritePixels var30 = null;
                     SpritePixels var31 = null;
                     SpritePixels var32 = null;
                     int var33 = 0;
                     int var34 = 0;
                     int var35 = 0;
                     int var36 = 0;
                     int var37 = 0;
                     int var38 = 0;
                     int var39 = 0;
                     int var40 = 0;
                     int var41 = 0;
                     var80 = var87.method4652();
                     int var42;
                     if(var80 != null) {
                        var21 = var80.width;
                        var42 = var80.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var25 = var80.offsetX;
                     }

                     var81 = var87.method4653();
                     if(var81 != null) {
                        var22 = var81.width;
                        var42 = var81.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var26 = var81.offsetX;
                     }

                     var82 = var87.method4654();
                     if(var82 != null) {
                        var23 = var82.width;
                        var42 = var82.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var27 = var82.offsetX;
                     }

                     var83 = var87.method4655();
                     if(var83 != null) {
                        var24 = var83.width;
                        var42 = var83.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var28 = var83.offsetX;
                     }

                     if(var79 != null) {
                        var29 = var79.method4652();
                        if(var29 != null) {
                           var33 = var29.width;
                           var42 = var29.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var37 = var29.offsetX;
                        }

                        var30 = var79.method4653();
                        if(var30 != null) {
                           var34 = var30.width;
                           var42 = var30.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var79.method4654();
                        if(var31 != null) {
                           var35 = var31.width;
                           var42 = var31.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var39 = var31.offsetX;
                        }

                        var32 = var79.method4655();
                        if(var32 != null) {
                           var36 = var32.width;
                           var42 = var32.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var40 = var32.offsetX;
                        }
                     }

                     Font var84 = var87.method4656();
                     if(var84 == null) {
                        var84 = class13.field262;
                     }

                     Font var43;
                     if(var79 != null) {
                        var43 = var79.method4656();
                        if(var43 == null) {
                           var43 = class13.field262;
                        }
                     } else {
                        var43 = class13.field262;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var87.method4651(var0.hitsplatTypes[var75]);
                     int var89 = var84.method4925(var44);
                     if(var79 != null) {
                        var45 = var79.method4651(var0.field1170[var75]);
                        var47 = var43.method4925(var45);
                     }

                     int var48 = 0;
                     int var49 = 0;
                     if(var22 > 0) {
                        if(var82 == null && var83 == null) {
                           var48 = 1;
                        } else {
                           var48 = var89 / var22 + 1;
                        }
                     }

                     if(var79 != null && var34 > 0) {
                        if(var31 == null && var32 == null) {
                           var49 = 1;
                        } else {
                           var49 = var47 / var34 + 1;
                        }
                     }

                     int var50 = 0;
                     int var51 = var50;
                     if(var21 > 0) {
                        var50 += var21;
                     }

                     var50 += 2;
                     int var52 = var50;
                     if(var23 > 0) {
                        var50 += var23;
                     }

                     int var53 = var50;
                     int var54 = var50;
                     int var55;
                     if(var22 > 0) {
                        var55 = var48 * var22;
                        var50 += var55;
                        var54 += (var55 - var89) / 2;
                     } else {
                        var50 += var89;
                     }

                     var55 = var50;
                     if(var24 > 0) {
                        var50 += var24;
                     }

                     int var56 = 0;
                     int var57 = 0;
                     int var58 = 0;
                     int var59 = 0;
                     int var60 = 0;
                     int var61;
                     if(var79 != null) {
                        var50 += 2;
                        var56 = var50;
                        if(var33 > 0) {
                           var50 += var33;
                        }

                        var50 += 2;
                        var57 = var50;
                        if(var35 > 0) {
                           var50 += var35;
                        }

                        var58 = var50;
                        var60 = var50;
                        if(var34 > 0) {
                           var61 = var49 * var34;
                           var50 += var61;
                           var60 += (var61 - var47) / 2;
                        } else {
                           var50 += var47;
                        }

                        var59 = var50;
                        if(var36 > 0) {
                           var50 += var36;
                        }
                     }

                     var61 = var0.hitsplatCycles[var75] - Client.gameCycle;
                     int var62 = var87.field3478 - var61 * var87.field3478 / var87.field3491;
                     int var63 = var61 * var87.field3493 / var87.field3491 + -var87.field3493;
                     int var64 = var62 + (var2 + Client.screenY - (var50 >> 1));
                     int var65 = var63 + (var3 + Client.screenX - 12);
                     int var66 = var65;
                     int var67 = var41 + var65;
                     int var68 = var65 + var87.field3486 + 15;
                     int var69 = var68 - var84.minSpacing;
                     int var70 = var68 + var84.maxSpacing;
                     if(var69 < var65) {
                        var66 = var69;
                     }

                     if(var70 > var67) {
                        var67 = var70;
                     }

                     int var71 = 0;
                     int var72;
                     int var73;
                     if(var79 != null) {
                        var71 = var65 + var79.field3486 + 15;
                        var72 = var71 - var43.minSpacing;
                        var73 = var71 + var43.maxSpacing;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var87.field3497 >= 0) {
                        var72 = (var61 << 8) / (var87.field3491 - var87.field3497);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(var80 != null) {
                           var80.method5274(var51 + var64 - var25, var65, var72);
                        }

                        if(var82 != null) {
                           var82.method5274(var64 + var52 - var27, var65, var72);
                        }

                        if(var81 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var81.method5274(var22 * var73 + (var64 + var53 - var26), var65, var72);
                           }
                        }

                        if(var83 != null) {
                           var83.method5274(var55 + var64 - var28, var65, var72);
                        }

                        var84.method4932(var44, var64 + var54, var68, var87.field3485, 0, var72);
                        if(var79 != null) {
                           if(var29 != null) {
                              var29.method5274(var56 + var64 - var37, var65, var72);
                           }

                           if(var31 != null) {
                              var31.method5274(var64 + var57 - var39, var65, var72);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method5274(var34 * var73 + (var58 + var64 - var38), var65, var72);
                              }
                           }

                           if(var32 != null) {
                              var32.method5274(var59 + var64 - var40, var65, var72);
                           }

                           var43.method4932(var45, var64 + var60, var71, var79.field3485, 0, var72);
                        }
                     } else {
                        if(var80 != null) {
                           var80.drawAt(var51 + var64 - var25, var65);
                        }

                        if(var82 != null) {
                           var82.drawAt(var52 + var64 - var27, var65);
                        }

                        if(var81 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var81.drawAt(var73 * var22 + (var53 + var64 - var26), var65);
                           }
                        }

                        if(var83 != null) {
                           var83.drawAt(var64 + var55 - var28, var65);
                        }

                        var84.method4931(var44, var64 + var54, var68, var87.field3485 | -16777216, 0);
                        if(var79 != null) {
                           if(var29 != null) {
                              var29.drawAt(var64 + var56 - var37, var65);
                           }

                           if(var31 != null) {
                              var31.drawAt(var57 + var64 - var39, var65);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.drawAt(var73 * var34 + (var58 + var64 - var38), var65);
                              }
                           }

                           if(var32 != null) {
                              var32.drawAt(var59 + var64 - var40, var65);
                           }

                           var43.method4931(var45, var64 + var60, var71, var79.field3485 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
