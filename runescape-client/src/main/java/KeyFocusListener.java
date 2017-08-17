import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
@Implements("KeyFocusListener")
public final class KeyFocusListener implements KeyListener, FocusListener {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lac;"
   )
   @Export("keyboard")
   static KeyFocusListener keyboard;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -421699511
   )
   static int field645;
   @ObfuscatedName("cj")
   static int[] field653;
   @ObfuscatedName("ci")
   public static boolean[] field642;
   @ObfuscatedName("cv")
   static int[] field635;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = -1004168307
   )
   static int field650;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 181760547
   )
   static int field651;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -112391569
   )
   static int field659;
   @ObfuscatedName("cq")
   static char[] field631;
   @ObfuscatedName("cx")
   static int[] field633;
   @ObfuscatedName("cw")
   public static int[] field637;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = 6209327
   )
   public static int field649;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = -2134929115
   )
   static int field652;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 1122227223
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks;
   @ObfuscatedName("pd")
   @ObfuscatedGetter(
      intValue = -877801823
   )
   static int field657;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = 1801940433
   )
   @Export("cameraPitch")
   static int cameraPitch;

   static {
      keyboard = new KeyFocusListener();
      field642 = new boolean[112];
      field635 = new int[128];
      field650 = 0;
      field645 = 0;
      field631 = new char[128];
      field633 = new int[128];
      field637 = new int[128];
      field649 = 0;
      field659 = 0;
      field651 = 0;
      field652 = 0;
      keyboardIdleTicks = 0;
      field653 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field653.length) {
            var2 = field653[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field645 >= 0 && var2 >= 0) {
            field635[field645] = ~var2;
            field645 = field645 + 1 & 127;
            if(field650 == field645) {
               field645 = -1;
            }
         }
      }

      var1.consume();
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field645 = -1;
      }

   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field653.length) {
            var2 = field653[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field645 >= 0 && var2 >= 0) {
            field635[field645] = var2;
            field645 = field645 + 1 & 127;
            if(field650 == field645) {
               field645 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field651 + 1 & 127;
            if(var3 != field659) {
               field633[field651] = var2;
               field631[field651] = 0;
               field651 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final void keyTyped(KeyEvent var1) {
      if(keyboard != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff' && class170.method3141(var2)) {
            int var3 = field651 + 1 & 127;
            if(var3 != field659) {
               field633[field651] = -1;
               field631[field651] = var2;
               field651 = var3;
            }
         }
      }

      var1.consume();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILfx;Lil;B)V",
      garbageValue = "81"
   )
   static void method807(int var0, IndexFile var1, IndexData var2) {
      byte[] var3 = null;
      Deque var4 = class237.field3224;
      synchronized(class237.field3224) {
         for(FileSystem var5 = (FileSystem)class237.field3224.getFront(); var5 != null; var5 = (FileSystem)class237.field3224.getNext()) {
            if((long)var0 == var5.hash && var1 == var5.index && var5.field3196 == 0) {
               var3 = var5.field3194;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method4228(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method3039(var0);
         var2.method4228(var1, var0, var8, true);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1688493572"
   )
   static void method806(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.get((long)var0);
      if(var1 != null) {
         var1.unlink();
      }
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "(Lhi;IIII)V",
      garbageValue = "-205372061"
   )
   static final void method784(Widget var0, int var1, int var2, int var3) {
      class182.method3458();
      class211 var4 = var0.method4043(false);
      if(var4 != null) {
         Rasterizer2D.setDrawRegion(var1, var2, var4.field2599 + var1, var2 + var4.field2597);
         if(Client.field1160 != 2 && Client.field1160 != 5) {
            int var5 = Client.mapAngle & 2047;
            int var6 = XGrandExchangeOffer.localPlayer.x / 32 + 48;
            int var7 = 464 - XGrandExchangeOffer.localPlayer.y / 32;
            ItemComposition.field3531.method5111(var1, var2, var4.field2599, var4.field2597, var6, var7, var5, 256, var4.field2595, var4.field2596);

            int var8;
            int var9;
            int var10;
            for(var8 = 0; var8 < Client.field1154; ++var8) {
               var9 = Client.field935[var8] * 4 + 2 - XGrandExchangeOffer.localPlayer.x / 32;
               var10 = Client.field946[var8] * 4 + 2 - XGrandExchangeOffer.localPlayer.y / 32;
               class44.drawDot(var1, var2, var9, var10, Client.field1113[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var9 = 0; var9 < 104; ++var9) {
                  Deque var17 = Client.groundItemDeque[class35.plane][var8][var9];
                  if(var17 != null) {
                     var11 = var8 * 4 + 2 - XGrandExchangeOffer.localPlayer.x / 32;
                     var12 = var9 * 4 + 2 - XGrandExchangeOffer.localPlayer.y / 32;
                     class44.drawDot(var1, var2, var11, var12, class60.mapDots[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < Client.field958; ++var8) {
               NPC var18 = Client.cachedNPCs[Client.npcIndices[var8]];
               if(var18 != null && var18.hasConfig()) {
                  NPCComposition var21 = var18.composition;
                  if(var21 != null && var21.configs != null) {
                     var21 = var21.transform();
                  }

                  if(var21 != null && var21.isMinimapVisible && var21.field3570) {
                     var11 = var18.x / 32 - XGrandExchangeOffer.localPlayer.x / 32;
                     var12 = var18.y / 32 - XGrandExchangeOffer.localPlayer.y / 32;
                     class44.drawDot(var1, var2, var11, var12, class60.mapDots[1], var4);
                  }
               }
            }

            var8 = class97.field1510;
            int[] var22 = class97.field1511;

            for(var10 = 0; var10 < var8; ++var10) {
               Player var19 = Client.cachedPlayers[var22[var10]];
               if(var19 != null && var19.hasConfig() && !var19.hidden && var19 != XGrandExchangeOffer.localPlayer) {
                  var12 = var19.x / 32 - XGrandExchangeOffer.localPlayer.x / 32;
                  int var13 = var19.y / 32 - XGrandExchangeOffer.localPlayer.y / 32;
                  boolean var14 = false;
                  if(WorldMapType2.isFriended(var19.name, true)) {
                     var14 = true;
                  }

                  boolean var15 = false;

                  for(int var16 = 0; var16 < class82.clanChatCount; ++var16) {
                     if(var19.name.equals(class28.clanMembers[var16].username)) {
                        var15 = true;
                        break;
                     }
                  }

                  boolean var20 = false;
                  if(XGrandExchangeOffer.localPlayer.team != 0 && var19.team != 0 && var19.team == XGrandExchangeOffer.localPlayer.team) {
                     var20 = true;
                  }

                  if(var14) {
                     class44.drawDot(var1, var2, var12, var13, class60.mapDots[3], var4);
                  } else if(var20) {
                     class44.drawDot(var1, var2, var12, var13, class60.mapDots[4], var4);
                  } else if(var15) {
                     class44.drawDot(var1, var2, var12, var13, class60.mapDots[5], var4);
                  } else {
                     class44.drawDot(var1, var2, var12, var13, class60.mapDots[2], var4);
                  }
               }
            }

            if(Client.field951 != 0 && Client.gameCycle % 20 < 10) {
               if(Client.field951 == 1 && Client.field952 >= 0 && Client.field952 < Client.cachedNPCs.length) {
                  NPC var23 = Client.cachedNPCs[Client.field952];
                  if(var23 != null) {
                     var11 = var23.x / 32 - XGrandExchangeOffer.localPlayer.x / 32;
                     var12 = var23.y / 32 - XGrandExchangeOffer.localPlayer.y / 32;
                     class36.method510(var1, var2, var11, var12, class9.field249[1], var4);
                  }
               }

               if(Client.field951 == 2) {
                  var10 = 2 + (Client.hintArrowX * 4 - class47.baseX * 4) - XGrandExchangeOffer.localPlayer.x / 32;
                  var11 = Client.hintArrowY * 4 - class44.baseY * 4 + 2 - XGrandExchangeOffer.localPlayer.y / 32;
                  class36.method510(var1, var2, var10, var11, class9.field249[1], var4);
               }

               if(Client.field951 == 10 && Client.field953 >= 0 && Client.field953 < Client.cachedPlayers.length) {
                  Player var24 = Client.cachedPlayers[Client.field953];
                  if(var24 != null) {
                     var11 = var24.x / 32 - XGrandExchangeOffer.localPlayer.x / 32;
                     var12 = var24.y / 32 - XGrandExchangeOffer.localPlayer.y / 32;
                     class36.method510(var1, var2, var11, var12, class9.field249[1], var4);
                  }
               }
            }

            if(Client.destinationX != 0) {
               var10 = Client.destinationX * 4 + 2 - XGrandExchangeOffer.localPlayer.x / 32;
               var11 = Client.destinationY * 4 + 2 - XGrandExchangeOffer.localPlayer.y / 32;
               class44.drawDot(var1, var2, var10, var11, class9.field249[0], var4);
            }

            if(!XGrandExchangeOffer.localPlayer.hidden) {
               Rasterizer2D.method4968(var4.field2599 / 2 + var1 - 1, var4.field2597 / 2 + var2 - 1, 3, 3, 16777215);
            }
         } else {
            Rasterizer2D.method4983(var1, var2, 0, var4.field2595, var4.field2596);
         }

         Client.field1132[var3] = true;
      }
   }
}
