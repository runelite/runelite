import java.applet.Applet;
import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("ClanMember")
public class ClanMember extends Node {
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      intValue = -762446825
   )
   static int field871;
   @ObfuscatedName("n")
   @Export("username")
   String username;
   @ObfuscatedName("v")
   String field870;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 705196955
   )
   @Export("world")
   int world;
   @ObfuscatedName("r")
   @Export("rank")
   byte rank;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;I)V",
      garbageValue = "704121120"
   )
   public static void method1172(Applet var0, String var1) {
      class56.field654 = var0;
      if(var1 != null) {
         class56.field647 = var1;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "559411065"
   )
   static void method1168(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(KeyFocusListener.keyboard);
      var0.addFocusListener(KeyFocusListener.keyboard);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "1725585972"
   )
   @Export("byteArrayToObject")
   public static Object byteArrayToObject(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !AbstractByteBuffer.directBufferUnavailable) {
            try {
               DirectByteBuffer var2 = new DirectByteBuffer();
               var2.put(var0);
               return var2;
            } catch (Throwable var3) {
               AbstractByteBuffer.directBufferUnavailable = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "-39"
   )
   static void method1170(String var0, String var1, String var2) {
      class91.loginMessage1 = var0;
      class91.loginMessage2 = var1;
      class91.loginMessage3 = var2;
   }

   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2123627343"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            class160.clientInstance.method860();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field905 = 0;
            Client.field906 = 0;
            Client.field894.method5098(var0);
            if(var0 != 20) {
               class48.method722(false);
            }
         }

         if(var0 != 20 && var0 != 40 && class40.field525 != null) {
            class40.field525.vmethod3136();
            class40.field525 = null;
         }

         if(Client.gameState == 25) {
            Client.field1052 = 0;
            Client.field921 = 0;
            Client.field922 = 1;
            Client.field923 = 0;
            Client.field924 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class64.method1100(MouseInput.indexCache10, Renderable.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class64.method1100(MouseInput.indexCache10, Renderable.indexSprites, false, 4);
            } else if(class91.field1341) {
               class91.field1337 = null;
               class277.field3744 = null;
               class91.runeSprites = null;
               class91.field1339 = null;
               GrandExchangeEvents.field269 = null;
               class91.logoSprite = null;
               ItemContainer.titlemuteSprite = null;
               MouseRecorder.field812 = null;
               class2.field11 = null;
               class219.field2709 = null;
               ItemLayer.slFlagSprites = null;
               WorldMapData.slArrowSprites = null;
               class41.slStarSprites = null;
               class43.field550 = null;
               Friend.field777 = null;
               GrandExchangeOffer.field296 = null;
               class33.field451 = null;
               class39.field515 = null;
               FrameMap.field1958 = null;
               class72.field833 = null;
               GrandExchangeEvent.field282 = null;
               SoundTask.field1571 = null;
               class214.field2631 = 1;
               class214.field2632 = null;
               Ignore.field810 = -1;
               class262.field3474 = -1;
               class35.field477 = 0;
               class214.field2627 = false;
               FontName.field3711 = 2;
               Overlay.sendConInfo(true);
               class91.field1341 = false;
            }
         } else {
            class64.method1100(MouseInput.indexCache10, Renderable.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "(Lhq;II)I",
      garbageValue = "1233964775"
   )
   static final int method1169(Widget var0, int var1) {
      if(var0.dynamicValues != null && var1 < var0.dynamicValues.length) {
         try {
            int[] var2 = var0.dynamicValues[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = Client.boostedSkillLevels[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = Client.realSkillLevels[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = Client.skillExperiences[var2[var4++]];
               }

               int var9;
               Widget var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = UrlRequester.getWidget(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class115.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class222.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class233.field2948[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class222.widgetSettings[var2[var4++]] * 100 / 46875;
               }

               if(var6 == 8) {
                  var7 = GrandExchangeOffer.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class233.field2947[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = UrlRequester.getWidget(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class115.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = Client.energy;
               }

               if(var6 == 12) {
                  var7 = Client.weight;
               }

               if(var6 == 13) {
                  var9 = class222.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = PendingSpawn.getVarbit(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = (GrandExchangeOffer.localPlayer.x >> 7) + class175.baseX;
               }

               if(var6 == 19) {
                  var7 = (GrandExchangeOffer.localPlayer.y >> 7) + GraphicsObject.baseY;
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }
}
