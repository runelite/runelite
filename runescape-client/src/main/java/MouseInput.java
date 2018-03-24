import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("MouseInput")
public class MouseInput implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lbs;"
   )
   @Export("mouse")
   public static MouseInput mouse;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1039254745
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 222922667
   )
   @Export("MouseHandler_currentButton")
   static volatile int MouseHandler_currentButton;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1482181311
   )
   @Export("mouseX")
   static volatile int mouseX;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -94662513
   )
   @Export("mouseLastY")
   public static int mouseLastY;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -77050521
   )
   @Export("mouseY")
   static volatile int mouseY;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -335696129
   )
   @Export("mouseCurrentButton")
   public static int mouseCurrentButton;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1993211147
   )
   @Export("mouseLastX")
   public static int mouseLastX;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -231159235
   )
   @Export("MouseHandler_lastButton")
   static volatile int MouseHandler_lastButton;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1542129439
   )
   @Export("MouseHandler_lastPressedX")
   static volatile int MouseHandler_lastPressedX;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -959194879
   )
   @Export("MouseHandler_lastPressedY")
   static volatile int MouseHandler_lastPressedY;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = -1430249809890186845L
   )
   @Export("MouseHandler_lastPressedTimeMillis")
   static volatile long MouseHandler_lastPressedTimeMillis;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -617671749
   )
   @Export("mouseLastButton")
   public static int mouseLastButton;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1423466469
   )
   @Export("mouseLastPressedX")
   public static int mouseLastPressedX;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1551951163
   )
   @Export("mouseLastPressedY")
   public static int mouseLastPressedY;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = -5818258179646689341L
   )
   @Export("mouseLastPressedTimeMillis")
   public static long mouseLastPressedTimeMillis;

   static {
      mouse = new MouseInput();
      mouseIdleTicks = 0;
      MouseHandler_currentButton = 0;
      mouseX = -1;
      mouseY = -1;
      mouseCurrentButton = 0;
      mouseLastX = 0;
      mouseLastY = 0;
      MouseHandler_lastButton = 0;
      MouseHandler_lastPressedX = 0;
      MouseHandler_lastPressedY = 0;
      MouseHandler_lastPressedTimeMillis = 0L;
      mouseLastButton = 0;
      mouseLastPressedX = 0;
      mouseLastPressedY = 0;
      mouseLastPressedTimeMillis = 0L;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/event/MouseEvent;I)I",
      garbageValue = "789790295"
   )
   final int method1055(MouseEvent var1) {
      int var2 = var1.getButton();
      return !var1.isAltDown() && var2 != 2?(!var1.isMetaDown() && var2 != 3?1:2):4;
   }

   @Export("mousePressed")
   @ObfuscatedName("mousePressed")
   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         MouseHandler_lastPressedX = var1.getX();
         MouseHandler_lastPressedY = var1.getY();
         MouseHandler_lastPressedTimeMillis = WorldMapRegion.method465();
         MouseHandler_lastButton = this.method1055(var1);
         if(MouseHandler_lastButton != 0) {
            MouseHandler_currentButton = MouseHandler_lastButton;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         MouseHandler_currentButton = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = -1;
         mouseY = -1;
      }

   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         MouseHandler_currentButton = 0;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZI)V",
      garbageValue = "-1658842350"
   )
   public static void method1090(String var0, boolean var1, boolean var2) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var4) {
               ;
            }
         }

         if(class57.field636.startsWith("win")) {
            SoundTaskDataProvider.method835(var0, 0, "openjs");
         } else if(class57.field636.startsWith("mac")) {
            SoundTaskDataProvider.method835(var0, 1, "openjs");
         } else {
            SoundTaskDataProvider.method835(var0, 2, "openjs");
         }
      } else {
         SoundTaskDataProvider.method835(var0, 3, "openjs");
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "100"
   )
   static final void method1091(int var0) {
      short var1 = 256;
      class90.field1334 += var0 * 128;
      int var2;
      if(class90.field1334 > class27.field365.length) {
         class90.field1334 -= class27.field365.length;
         var2 = (int)(Math.random() * 12.0D);
         FloorUnderlayDefinition.method4830(class241.runeSprites[var2]);
      }

      var2 = 0;
      int var3 = var0 * 128;
      int var4 = (var1 - var0) * 128;

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = class228.field2670[var2 + var3] - var0 * class27.field365[var2 + class90.field1334 & class27.field365.length - 1] / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         class228.field2670[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = var5 * 128;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               class228.field2670[var6 + var7] = 255;
            } else {
               class228.field2670[var6 + var7] = 0;
            }
         }
      }

      if(class90.field1332 > 0) {
         class90.field1332 -= var0 * 4;
      }

      if(class90.field1333 > 0) {
         class90.field1333 -= var0 * 4;
      }

      if(class90.field1332 == 0 && class90.field1333 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class90.field1332 = 1024;
         }

         if(var5 == 1) {
            class90.field1333 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class90.field1330[var5] = class90.field1330[var0 + var5];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class90.field1330[var5] = (int)(Math.sin((double)class90.field1338 / 14.0D) * 16.0D + Math.sin((double)class90.field1338 / 15.0D) * 14.0D + Math.sin((double)class90.field1338 / 16.0D) * 12.0D);
         ++class90.field1338;
      }

      class90.field1335 += var0;
      var5 = (var0 + (Client.gameCycle & 1)) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class90.field1335 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            class228.field2670[var7 + (var8 << 7)] = 192;
         }

         class90.field1335 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = var6 * 128;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var9 + var5 < 128) {
                  var7 += class228.field2670[var9 + var8 + var5];
               }

               if(var9 - (var5 + 1) >= 0) {
                  var7 -= class228.field2670[var9 + var8 - (var5 + 1)];
               }

               if(var9 >= 0) {
                  class55.field626[var8 + var9] = var7 / (var5 * 2 + 1);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = var8 * 128;
               if(var5 + var8 < var1) {
                  var7 += class55.field626[var9 + var6 + var5 * 128];
               }

               if(var8 - (var5 + 1) >= 0) {
                  var7 -= class55.field626[var6 + var9 - (var5 + 1) * 128];
               }

               if(var8 >= 0) {
                  class228.field2670[var9 + var6] = var7 / (var5 * 2 + 1);
               }
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILcj;ZB)I",
      garbageValue = "0"
   )
   static int method1077(int var0, Script var1, boolean var2) {
      String var3;
      if(var0 == 3100) {
         var3 = class81.scriptStringStack[--class316.scriptStringStackSize];
         TotalQuantityComparator.sendGameMessage(0, "", var3);
         return 1;
      } else if(var0 == 3101) {
         class5.intStackSize -= 2;
         GZipDecompressor.method3473(WorldMapData.localPlayer, class81.intStack[class5.intStackSize], class81.intStack[class5.intStackSize + 1]);
         return 1;
      } else if(var0 == 3103) {
         PacketNode var15 = class33.method382(ClientPacket.field2399, Client.field1072.field1456);
         Client.field1072.method2073(var15);

         for(WidgetNode var18 = (WidgetNode)Client.componentTable.first(); var18 != null; var18 = (WidgetNode)Client.componentTable.next()) {
            if(var18.owner == 0 || var18.owner == 3) {
               class93.closeWidget(var18, true);
            }
         }

         if(Client.field1012 != null) {
            GameEngine.method1053(Client.field1012);
            Client.field1012 = null;
         }

         return 1;
      } else {
         int var22;
         if(var0 == 3104) {
            var3 = class81.scriptStringStack[--class316.scriptStringStackSize];
            var22 = 0;
            if(class163.method3210(var3)) {
               var22 = class158.method3176(var3);
            }

            PacketNode var19 = class33.method382(ClientPacket.field2369, Client.field1072.field1456);
            var19.packetBuffer.putInt(var22);
            Client.field1072.method2073(var19);
            return 1;
         } else {
            PacketNode var16;
            if(var0 == 3105) {
               var3 = class81.scriptStringStack[--class316.scriptStringStackSize];
               var16 = class33.method382(ClientPacket.field2386, Client.field1072.field1456);
               var16.packetBuffer.putByte(var3.length() + 1);
               var16.packetBuffer.putString(var3);
               Client.field1072.method2073(var16);
               return 1;
            } else if(var0 == 3106) {
               var3 = class81.scriptStringStack[--class316.scriptStringStackSize];
               var16 = class33.method382(ClientPacket.field2423, Client.field1072.field1456);
               var16.packetBuffer.putByte(var3.length() + 1);
               var16.packetBuffer.putString(var3);
               Client.field1072.method2073(var16);
               return 1;
            } else {
               String var4;
               int var13;
               int var14;
               if(var0 != 3107) {
                  if(var0 == 3108) {
                     class5.intStackSize -= 3;
                     var13 = class81.intStack[class5.intStackSize];
                     var22 = class81.intStack[class5.intStackSize + 1];
                     var14 = class81.intStack[class5.intStackSize + 2];
                     Widget var21 = GZipDecompressor.getWidget(var14);
                     WorldMapRegion.method534(var21, var13, var22);
                     return 1;
                  } else if(var0 == 3109) {
                     class5.intStackSize -= 2;
                     var13 = class81.intStack[class5.intStackSize];
                     var22 = class81.intStack[class5.intStackSize + 1];
                     Widget var17 = var2?class233.field2755:class81.field1260;
                     WorldMapRegion.method534(var17, var13, var22);
                     return 1;
                  } else if(var0 == 3110) {
                     class153.middleMouseMovesCamera = class81.intStack[--class5.intStackSize] == 1;
                     return 1;
                  } else if(var0 == 3111) {
                     class81.intStack[++class5.intStackSize - 1] = MapIcon.preferences.hideRoofs?1:0;
                     return 1;
                  } else if(var0 == 3112) {
                     MapIcon.preferences.hideRoofs = class81.intStack[--class5.intStackSize] == 1;
                     class37.method538();
                     return 1;
                  } else if(var0 == 3113) {
                     var3 = class81.scriptStringStack[--class316.scriptStringStackSize];
                     boolean var12 = class81.intStack[--class5.intStackSize] == 1;
                     method1090(var3, var12, false);
                     return 1;
                  } else if(var0 == 3115) {
                     var13 = class81.intStack[--class5.intStackSize];
                     var16 = class33.method382(ClientPacket.field2394, Client.field1072.field1456);
                     var16.packetBuffer.putShort(var13);
                     Client.field1072.method2073(var16);
                     return 1;
                  } else if(var0 == 3116) {
                     var13 = class81.intStack[--class5.intStackSize];
                     class316.scriptStringStackSize -= 2;
                     var4 = class81.scriptStringStack[class316.scriptStringStackSize];
                     String var5 = class81.scriptStringStack[class316.scriptStringStackSize + 1];
                     if(var4.length() > 500) {
                        return 1;
                     } else if(var5.length() > 500) {
                        return 1;
                     } else {
                        PacketNode var20 = class33.method382(ClientPacket.field2388, Client.field1072.field1456);
                        var20.packetBuffer.putShort(1 + UnitPriceComparator.getLength(var4) + UnitPriceComparator.getLength(var5));
                        var20.packetBuffer.method3562(var13);
                        var20.packetBuffer.putString(var5);
                        var20.packetBuffer.putString(var4);
                        Client.field1072.method2073(var20);
                        return 1;
                     }
                  } else if(var0 == 3117) {
                     Client.field994 = class81.intStack[--class5.intStackSize] == 1;
                     return 1;
                  } else if(var0 == 3118) {
                     Client.field996 = class81.intStack[--class5.intStackSize] == 1;
                     return 1;
                  } else if(var0 == 3119) {
                     Client.field967 = class81.intStack[--class5.intStackSize] == 1;
                     return 1;
                  } else if(var0 == 3120) {
                     if(class81.intStack[--class5.intStackSize] == 1) {
                        Client.field968 |= 1;
                     } else {
                        Client.field968 &= -2;
                     }

                     return 1;
                  } else if(var0 == 3121) {
                     if(class81.intStack[--class5.intStackSize] == 1) {
                        Client.field968 |= 2;
                     } else {
                        Client.field968 &= -3;
                     }

                     return 1;
                  } else if(var0 == 3122) {
                     if(class81.intStack[--class5.intStackSize] == 1) {
                        Client.field968 |= 4;
                     } else {
                        Client.field968 &= -5;
                     }

                     return 1;
                  } else if(var0 == 3123) {
                     if(class81.intStack[--class5.intStackSize] == 1) {
                        Client.field968 |= 8;
                     } else {
                        Client.field968 &= -9;
                     }

                     return 1;
                  } else if(var0 == 3124) {
                     Client.field968 = 0;
                     return 1;
                  } else if(var0 == 3125) {
                     Client.field953 = class81.intStack[--class5.intStackSize] == 1;
                     return 1;
                  } else if(var0 == 3126) {
                     Client.field963 = class81.intStack[--class5.intStackSize] == 1;
                     return 1;
                  } else if(var0 == 3127) {
                     class33.method380(class81.intStack[--class5.intStackSize] == 1);
                     return 1;
                  } else if(var0 == 3128) {
                     class81.intStack[++class5.intStackSize - 1] = WorldMapManager.method643()?1:0;
                     return 1;
                  } else if(var0 == 3129) {
                     class5.intStackSize -= 2;
                     Client.field1115 = class81.intStack[class5.intStackSize];
                     Client.field857 = class81.intStack[class5.intStackSize + 1];
                     return 1;
                  } else {
                     return 2;
                  }
               } else {
                  var13 = class81.intStack[--class5.intStackSize];
                  var4 = class81.scriptStringStack[--class316.scriptStringStackSize];
                  var14 = class93.playerIndexesCount;
                  int[] var6 = class93.playerIndices;
                  boolean var7 = false;
                  Name var8 = new Name(var4, KeyFocusListener.loginType);

                  for(int var9 = 0; var9 < var14; ++var9) {
                     Player var10 = Client.cachedPlayers[var6[var9]];
                     if(var10 != null && var10 != WorldMapData.localPlayer && var10.name != null && var10.name.equals(var8)) {
                        PacketNode var11;
                        if(var13 == 1) {
                           var11 = class33.method382(ClientPacket.field2446, Client.field1072.field1456);
                           var11.packetBuffer.method3619(0);
                           var11.packetBuffer.method3573(var6[var9]);
                           Client.field1072.method2073(var11);
                        } else if(var13 == 4) {
                           var11 = class33.method382(ClientPacket.field2360, Client.field1072.field1456);
                           var11.packetBuffer.method3562(0);
                           var11.packetBuffer.method3573(var6[var9]);
                           Client.field1072.method2073(var11);
                        } else if(var13 == 6) {
                           var11 = class33.method382(ClientPacket.field2350, Client.field1072.field1456);
                           var11.packetBuffer.putByte(0);
                           var11.packetBuffer.putShort(var6[var9]);
                           Client.field1072.method2073(var11);
                        } else if(var13 == 7) {
                           var11 = class33.method382(ClientPacket.field2433, Client.field1072.field1456);
                           var11.packetBuffer.method3562(0);
                           var11.packetBuffer.method3570(var6[var9]);
                           Client.field1072.method2073(var11);
                        }

                        var7 = true;
                        break;
                     }
                  }

                  if(!var7) {
                     TotalQuantityComparator.sendGameMessage(4, "", "Unable to find " + var4);
                  }

                  return 1;
               }
            }
         }
      }
   }
}
