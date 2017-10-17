import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
@Implements("ClanMember")
public class ClanMember extends Node {
   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static Widget field915;
   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "[Lkr;"
   )
   static SpritePixels[] field916;
   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   static IndexData field918;
   @ObfuscatedName("ab")
   static int[] field917;
   @ObfuscatedName("d")
   @Export("username")
   String username;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -543118029
   )
   @Export("world")
   int world;
   @ObfuscatedName("k")
   String field910;
   @ObfuscatedName("p")
   @Export("rank")
   byte rank;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1670798572"
   )
   public static void method1198() {
      class251.field3386.reset();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1866476521"
   )
   public static int method1196(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var0 + var2) / var1 - var2;
   }

   @ObfuscatedName("js")
   @ObfuscatedSignature(
      signature = "(Lhj;IIIB)V",
      garbageValue = "40"
   )
   static final void method1193(Widget var0, int var1, int var2, int var3) {
      class28.method234();
      class210 var4 = var0.method4117(false);
      if(var4 != null) {
         Rasterizer2D.setDrawRegion(var1, var2, var4.field2615 + var1, var2 + var4.field2611);
         if(Client.field1183 != 2 && Client.field1183 != 5) {
            int var5 = Client.mapAngle & 2047;
            int var6 = AbstractByteBuffer.localPlayer.x / 32 + 48;
            int var7 = 464 - AbstractByteBuffer.localPlayer.y / 32;
            BaseVarType.field33.method5186(var1, var2, var4.field2615, var4.field2611, var6, var7, var5, 256, var4.field2616, var4.field2613);

            int var8;
            int var9;
            int var10;
            for(var8 = 0; var8 < Client.field1141; ++var8) {
               var9 = 2 + Client.field1142[var8] * 4 - AbstractByteBuffer.localPlayer.x / 32;
               var10 = 2 + Client.field1143[var8] * 4 - AbstractByteBuffer.localPlayer.y / 32;
               class43.drawDot(var1, var2, var9, var10, Client.field1176[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var9 = 0; var9 < 104; ++var9) {
                  Deque var17 = Client.groundItemDeque[class5.plane][var8][var9];
                  if(var17 != null) {
                     var11 = 2 + var8 * 4 - AbstractByteBuffer.localPlayer.x / 32;
                     var12 = 2 + var9 * 4 - AbstractByteBuffer.localPlayer.y / 32;
                     class43.drawDot(var1, var2, var11, var12, MouseInput.mapDots[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < Client.npcIndexesCount; ++var8) {
               NPC var18 = Client.cachedNPCs[Client.npcIndices[var8]];
               if(var18 != null && var18.hasConfig()) {
                  NPCComposition var21 = var18.composition;
                  if(var21 != null && var21.configs != null) {
                     var21 = var21.transform();
                  }

                  if(var21 != null && var21.isMinimapVisible && var21.field3586) {
                     var11 = var18.x / 32 - AbstractByteBuffer.localPlayer.x / 32;
                     var12 = var18.y / 32 - AbstractByteBuffer.localPlayer.y / 32;
                     class43.drawDot(var1, var2, var11, var12, MouseInput.mapDots[1], var4);
                  }
               }
            }

            var8 = class94.field1485;
            int[] var22 = class94.field1480;

            for(var10 = 0; var10 < var8; ++var10) {
               Player var19 = Client.cachedPlayers[var22[var10]];
               if(var19 != null && var19.hasConfig() && !var19.hidden && var19 != AbstractByteBuffer.localPlayer) {
                  var12 = var19.x / 32 - AbstractByteBuffer.localPlayer.x / 32;
                  int var13 = var19.y / 32 - AbstractByteBuffer.localPlayer.y / 32;
                  boolean var14 = false;
                  if(class44.isFriended(var19.name, true)) {
                     var14 = true;
                  }

                  boolean var15 = false;

                  for(int var16 = 0; var16 < class21.clanChatCount; ++var16) {
                     if(var19.name.equals(WorldMapType1.clanMembers[var16].username)) {
                        var15 = true;
                        break;
                     }
                  }

                  boolean var20 = false;
                  if(AbstractByteBuffer.localPlayer.team != 0 && var19.team != 0 && var19.team == AbstractByteBuffer.localPlayer.team) {
                     var20 = true;
                  }

                  if(var14) {
                     class43.drawDot(var1, var2, var12, var13, MouseInput.mapDots[3], var4);
                  } else if(var20) {
                     class43.drawDot(var1, var2, var12, var13, MouseInput.mapDots[4], var4);
                  } else if(var15) {
                     class43.drawDot(var1, var2, var12, var13, MouseInput.mapDots[5], var4);
                  } else {
                     class43.drawDot(var1, var2, var12, var13, MouseInput.mapDots[2], var4);
                  }
               }
            }

            if(Client.field938 != 0 && Client.gameCycle % 20 < 10) {
               if(Client.field938 == 1 && Client.field939 >= 0 && Client.field939 < Client.cachedNPCs.length) {
                  NPC var23 = Client.cachedNPCs[Client.field939];
                  if(var23 != null) {
                     var11 = var23.x / 32 - AbstractByteBuffer.localPlayer.x / 32;
                     var12 = var23.y / 32 - AbstractByteBuffer.localPlayer.y / 32;
                     MilliTimer.method3013(var1, var2, var11, var12, class54.field687[1], var4);
                  }
               }

               if(Client.field938 == 2) {
                  var10 = Client.hintArrowX * 4 - WallObject.baseX * 4 + 2 - AbstractByteBuffer.localPlayer.x / 32;
                  var11 = Client.hintArrowY * 4 - Varcs.baseY * 4 + 2 - AbstractByteBuffer.localPlayer.y / 32;
                  MilliTimer.method3013(var1, var2, var10, var11, class54.field687[1], var4);
               }

               if(Client.field938 == 10 && Client.field940 >= 0 && Client.field940 < Client.cachedPlayers.length) {
                  Player var24 = Client.cachedPlayers[Client.field940];
                  if(var24 != null) {
                     var11 = var24.x / 32 - AbstractByteBuffer.localPlayer.x / 32;
                     var12 = var24.y / 32 - AbstractByteBuffer.localPlayer.y / 32;
                     MilliTimer.method3013(var1, var2, var11, var12, class54.field687[1], var4);
                  }
               }
            }

            if(Client.destinationX != 0) {
               var10 = 2 + Client.destinationX * 4 - AbstractByteBuffer.localPlayer.x / 32;
               var11 = 2 + Client.destinationY * 4 - AbstractByteBuffer.localPlayer.y / 32;
               class43.drawDot(var1, var2, var10, var11, class54.field687[0], var4);
            }

            if(!AbstractByteBuffer.localPlayer.hidden) {
               Rasterizer2D.method5129(var4.field2615 / 2 + var1 - 1, var4.field2611 / 2 + var2 - 1, 3, 3, 16777215);
            }
         } else {
            Rasterizer2D.method5068(var1, var2, 0, var4.field2616, var4.field2613);
         }

         Client.field1119[var3] = true;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZI)V",
      garbageValue = "2096263852"
   )
   public static void method1197(String var0, boolean var1, boolean var2) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var4) {
               ;
            }
         }

         if(class56.field695.startsWith("win")) {
            CombatInfoListHolder.method1743(var0, 0);
         } else if(class56.field695.startsWith("mac")) {
            KeyFocusListener.method783(var0, 1, "openjs");
         } else {
            CombatInfoListHolder.method1743(var0, 2);
         }
      } else {
         CombatInfoListHolder.method1743(var0, 3);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILcv;ZB)I",
      garbageValue = "101"
   )
   static int method1191(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class81.field1341:class81.field1340;
      if(var0 == 1700) {
         class81.intStack[++class81.intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 1701) {
         if(var3.itemId != -1) {
            class81.intStack[++class81.intStackSize - 1] = var3.itemQuantity;
         } else {
            class81.intStack[++class81.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 1702) {
         class81.intStack[++class81.intStackSize - 1] = var3.index;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "-164964746"
   )
   static int method1194(int var0, Script var1, boolean var2) {
      if(var0 == 6500) {
         class81.intStack[++class81.intStackSize - 1] = class12.loadWorlds()?1:0;
         return 1;
      } else {
         World var3;
         if(var0 == 6501) {
            World.field1284 = 0;
            var3 = class88.method1779();
            if(var3 != null) {
               class81.intStack[++class81.intStackSize - 1] = var3.id;
               class81.intStack[++class81.intStackSize - 1] = var3.mask;
               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var3.activity;
               class81.intStack[++class81.intStackSize - 1] = var3.location;
               class81.intStack[++class81.intStackSize - 1] = var3.playerCount;
               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var3.address;
            } else {
               class81.intStack[++class81.intStackSize - 1] = -1;
               class81.intStack[++class81.intStackSize - 1] = 0;
               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
               class81.intStack[++class81.intStackSize - 1] = 0;
               class81.intStack[++class81.intStackSize - 1] = 0;
               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 6502) {
            var3 = class88.method1779();
            if(var3 != null) {
               class81.intStack[++class81.intStackSize - 1] = var3.id;
               class81.intStack[++class81.intStackSize - 1] = var3.mask;
               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var3.activity;
               class81.intStack[++class81.intStackSize - 1] = var3.location;
               class81.intStack[++class81.intStackSize - 1] = var3.playerCount;
               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var3.address;
            } else {
               class81.intStack[++class81.intStackSize - 1] = -1;
               class81.intStack[++class81.intStackSize - 1] = 0;
               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
               class81.intStack[++class81.intStackSize - 1] = 0;
               class81.intStack[++class81.intStackSize - 1] = 0;
               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else {
            World var4;
            int var5;
            int var7;
            if(var0 == 6506) {
               var7 = class81.intStack[--class81.intStackSize];
               var4 = null;

               for(var5 = 0; var5 < World.worldCount; ++var5) {
                  if(var7 == class138.worldList[var5].id) {
                     var4 = class138.worldList[var5];
                     break;
                  }
               }

               if(var4 != null) {
                  class81.intStack[++class81.intStackSize - 1] = var4.id;
                  class81.intStack[++class81.intStackSize - 1] = var4.mask;
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var4.activity;
                  class81.intStack[++class81.intStackSize - 1] = var4.location;
                  class81.intStack[++class81.intStackSize - 1] = var4.playerCount;
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var4.address;
               } else {
                  class81.intStack[++class81.intStackSize - 1] = -1;
                  class81.intStack[++class81.intStackSize - 1] = 0;
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                  class81.intStack[++class81.intStackSize - 1] = 0;
                  class81.intStack[++class81.intStackSize - 1] = 0;
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 6507) {
               class81.intStackSize -= 4;
               var7 = class81.intStack[class81.intStackSize];
               boolean var10 = class81.intStack[class81.intStackSize + 1] == 1;
               var5 = class81.intStack[class81.intStackSize + 2];
               boolean var6 = class81.intStack[class81.intStackSize + 3] == 1;
               class56.method837(var7, var10, var5, var6);
               return 1;
            } else if(var0 != 6511) {
               if(var0 == 6512) {
                  Client.field1060 = class81.intStack[--class81.intStackSize] == 1;
                  return 1;
               } else {
                  int var8;
                  class251 var9;
                  if(var0 == 6513) {
                     class81.intStackSize -= 2;
                     var7 = class81.intStack[class81.intStackSize];
                     var8 = class81.intStack[class81.intStackSize + 1];
                     var9 = class155.method3049(var8);
                     if(var9.method4528()) {
                        class81.scriptStringStack[++class81.scriptStringStackSize - 1] = class72.getNpcDefinition(var7).method4742(var8, var9.field3389);
                     } else {
                        class81.intStack[++class81.intStackSize - 1] = class72.getNpcDefinition(var7).method4731(var8, var9.field3392);
                     }

                     return 1;
                  } else if(var0 == 6514) {
                     class81.intStackSize -= 2;
                     var7 = class81.intStack[class81.intStackSize];
                     var8 = class81.intStack[class81.intStackSize + 1];
                     var9 = class155.method3049(var8);
                     if(var9.method4528()) {
                        class81.scriptStringStack[++class81.scriptStringStackSize - 1] = Occluder.getObjectDefinition(var7).method4618(var8, var9.field3389);
                     } else {
                        class81.intStack[++class81.intStackSize - 1] = Occluder.getObjectDefinition(var7).method4620(var8, var9.field3392);
                     }

                     return 1;
                  } else if(var0 == 6515) {
                     class81.intStackSize -= 2;
                     var7 = class81.intStack[class81.intStackSize];
                     var8 = class81.intStack[class81.intStackSize + 1];
                     var9 = class155.method3049(var8);
                     if(var9.method4528()) {
                        class81.scriptStringStack[++class81.scriptStringStackSize - 1] = class46.getItemDefinition(var7).method4674(var8, var9.field3389);
                     } else {
                        class81.intStack[++class81.intStackSize - 1] = class46.getItemDefinition(var7).method4667(var8, var9.field3392);
                     }

                     return 1;
                  } else if(var0 == 6516) {
                     class81.intStackSize -= 2;
                     var7 = class81.intStack[class81.intStackSize];
                     var8 = class81.intStack[class81.intStackSize + 1];
                     var9 = class155.method3049(var8);
                     if(var9.method4528()) {
                        class81.scriptStringStack[++class81.scriptStringStackSize - 1] = BuildType.method4211(var7).method4551(var8, var9.field3389);
                     } else {
                        class81.intStack[++class81.intStackSize - 1] = BuildType.method4211(var7).method4550(var8, var9.field3392);
                     }

                     return 1;
                  } else if(var0 == 6518) {
                     class81.intStack[++class81.intStackSize - 1] = 0;
                     return 1;
                  } else {
                     return var0 == 6520?1:(var0 == 6521?1:2);
                  }
               }
            } else {
               var7 = class81.intStack[--class81.intStackSize];
               if(var7 >= 0 && var7 < World.worldCount) {
                  var4 = class138.worldList[var7];
                  class81.intStack[++class81.intStackSize - 1] = var4.id;
                  class81.intStack[++class81.intStackSize - 1] = var4.mask;
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var4.activity;
                  class81.intStack[++class81.intStackSize - 1] = var4.location;
                  class81.intStack[++class81.intStackSize - 1] = var4.playerCount;
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var4.address;
               } else {
                  class81.intStack[++class81.intStackSize - 1] = -1;
                  class81.intStack[++class81.intStackSize - 1] = 0;
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                  class81.intStack[++class81.intStackSize - 1] = 0;
                  class81.intStack[++class81.intStackSize - 1] = 0;
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)[Lhi;",
      garbageValue = "-754387298"
   )
   public static Permission[] method1195() {
      return new Permission[]{Permission.field3175, Permission.field3180, Permission.field3178, Permission.field3174, Permission.field3176, Permission.field3179};
   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(Lbs;I)V",
      garbageValue = "1576501496"
   )
   static final void method1192(Actor var0) {
      int var1 = var0.field1255 - Client.gameCycle;
      int var2 = var0.field1236 * 128 + var0.field1211 * 64;
      int var3 = var0.field1229 * 128 + var0.field1211 * 64;
      var0.x += (var2 - var0.x) / var1;
      var0.y += (var3 - var0.y) / var1;
      var0.field1251 = 0;
      var0.orientation = var0.field1261;
   }
}
