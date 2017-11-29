import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public class class47 {
   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("indexCache4")
   static IndexData indexCache4;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1325402321
   )
   public int field572;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   public Coordinates field575;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   public Coordinates field574;

   @ObfuscatedSignature(
      signature = "(ILhp;Lhp;)V"
   )
   public class47(int var1, Coordinates var2, Coordinates var3) {
      this.field572 = var1;
      this.field575 = var2;
      this.field574 = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILce;ZI)I",
      garbageValue = "2108971144"
   )
   static int method712(int var0, Script var1, boolean var2) {
      if(var0 == 6500) {
         class82.intStack[++GrandExchangeEvents.intStackSize - 1] = class46.loadWorlds()?1:0;
         return 1;
      } else {
         World var4;
         if(var0 == 6501) {
            World.field1217 = 0;
            if(World.field1217 < World.worldCount) {
               var4 = World.worldList[++World.field1217 - 1];
            } else {
               var4 = null;
            }

            if(var4 != null) {
               class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var4.id;
               class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var4.mask;
               class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var4.activity;
               class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var4.location;
               class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var4.playerCount;
               class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var4.address;
            } else {
               class82.intStack[++GrandExchangeEvents.intStackSize - 1] = -1;
               class82.intStack[++GrandExchangeEvents.intStackSize - 1] = 0;
               class82.scriptStringStack[++class82.scriptStringStackSize - 1] = "";
               class82.intStack[++GrandExchangeEvents.intStackSize - 1] = 0;
               class82.intStack[++GrandExchangeEvents.intStackSize - 1] = 0;
               class82.scriptStringStack[++class82.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 6502) {
            World var3;
            if(World.field1217 < World.worldCount) {
               var3 = World.worldList[++World.field1217 - 1];
            } else {
               var3 = null;
            }

            if(var3 != null) {
               class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var3.id;
               class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var3.mask;
               class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var3.activity;
               class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var3.location;
               class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var3.playerCount;
               class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var3.address;
            } else {
               class82.intStack[++GrandExchangeEvents.intStackSize - 1] = -1;
               class82.intStack[++GrandExchangeEvents.intStackSize - 1] = 0;
               class82.scriptStringStack[++class82.scriptStringStackSize - 1] = "";
               class82.intStack[++GrandExchangeEvents.intStackSize - 1] = 0;
               class82.intStack[++GrandExchangeEvents.intStackSize - 1] = 0;
               class82.scriptStringStack[++class82.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else {
            int var5;
            int var7;
            if(var0 == 6506) {
               var7 = class82.intStack[--GrandExchangeEvents.intStackSize];
               var4 = null;

               for(var5 = 0; var5 < World.worldCount; ++var5) {
                  if(var7 == World.worldList[var5].id) {
                     var4 = World.worldList[var5];
                     break;
                  }
               }

               if(var4 != null) {
                  class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var4.id;
                  class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var4.mask;
                  class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var4.activity;
                  class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var4.location;
                  class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var4.playerCount;
                  class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var4.address;
               } else {
                  class82.intStack[++GrandExchangeEvents.intStackSize - 1] = -1;
                  class82.intStack[++GrandExchangeEvents.intStackSize - 1] = 0;
                  class82.scriptStringStack[++class82.scriptStringStackSize - 1] = "";
                  class82.intStack[++GrandExchangeEvents.intStackSize - 1] = 0;
                  class82.intStack[++GrandExchangeEvents.intStackSize - 1] = 0;
                  class82.scriptStringStack[++class82.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 6507) {
               GrandExchangeEvents.intStackSize -= 4;
               var7 = class82.intStack[GrandExchangeEvents.intStackSize];
               boolean var10 = class82.intStack[GrandExchangeEvents.intStackSize + 1] == 1;
               var5 = class82.intStack[GrandExchangeEvents.intStackSize + 2];
               boolean var6 = class82.intStack[GrandExchangeEvents.intStackSize + 3] == 1;
               if(World.worldList != null) {
                  class40.method555(0, World.worldList.length - 1, var7, var10, var5, var6);
               }

               return 1;
            } else if(var0 != 6511) {
               if(var0 == 6512) {
                  Client.field1060 = class82.intStack[--GrandExchangeEvents.intStackSize] == 1;
                  return 1;
               } else {
                  int var8;
                  class258 var9;
                  if(var0 == 6513) {
                     GrandExchangeEvents.intStackSize -= 2;
                     var7 = class82.intStack[GrandExchangeEvents.intStackSize];
                     var8 = class82.intStack[GrandExchangeEvents.intStackSize + 1];
                     var9 = ClanMember.method1187(var8);
                     if(var9.method4607()) {
                        class82.scriptStringStack[++class82.scriptStringStackSize - 1] = class1.getNpcDefinition(var7).method4855(var8, var9.field3458);
                     } else {
                        class82.intStack[++GrandExchangeEvents.intStackSize - 1] = class1.getNpcDefinition(var7).method4834(var8, var9.field3457);
                     }

                     return 1;
                  } else if(var0 == 6514) {
                     GrandExchangeEvents.intStackSize -= 2;
                     var7 = class82.intStack[GrandExchangeEvents.intStackSize];
                     var8 = class82.intStack[GrandExchangeEvents.intStackSize + 1];
                     var9 = ClanMember.method1187(var8);
                     if(var9.method4607()) {
                        class82.scriptStringStack[++class82.scriptStringStackSize - 1] = class3.getObjectDefinition(var7).method4702(var8, var9.field3458);
                     } else {
                        class82.intStack[++GrandExchangeEvents.intStackSize - 1] = class3.getObjectDefinition(var7).method4701(var8, var9.field3457);
                     }

                     return 1;
                  } else if(var0 == 6515) {
                     GrandExchangeEvents.intStackSize -= 2;
                     var7 = class82.intStack[GrandExchangeEvents.intStackSize];
                     var8 = class82.intStack[GrandExchangeEvents.intStackSize + 1];
                     var9 = ClanMember.method1187(var8);
                     if(var9.method4607()) {
                        class82.scriptStringStack[++class82.scriptStringStackSize - 1] = WorldMapType2.getItemDefinition(var7).method4762(var8, var9.field3458);
                     } else {
                        class82.intStack[++GrandExchangeEvents.intStackSize - 1] = WorldMapType2.getItemDefinition(var7).method4792(var8, var9.field3457);
                     }

                     return 1;
                  } else if(var0 == 6516) {
                     GrandExchangeEvents.intStackSize -= 2;
                     var7 = class82.intStack[GrandExchangeEvents.intStackSize];
                     var8 = class82.intStack[GrandExchangeEvents.intStackSize + 1];
                     var9 = ClanMember.method1187(var8);
                     if(var9.method4607()) {
                        class82.scriptStringStack[++class82.scriptStringStackSize - 1] = class156.method3089(var7).method4621(var8, var9.field3458);
                     } else {
                        class82.intStack[++GrandExchangeEvents.intStackSize - 1] = class156.method3089(var7).method4616(var8, var9.field3457);
                     }

                     return 1;
                  } else if(var0 == 6518) {
                     class82.intStack[++GrandExchangeEvents.intStackSize - 1] = 0;
                     return 1;
                  } else {
                     return var0 == 6520?1:(var0 == 6521?1:2);
                  }
               }
            } else {
               var7 = class82.intStack[--GrandExchangeEvents.intStackSize];
               if(var7 >= 0 && var7 < World.worldCount) {
                  var4 = World.worldList[var7];
                  class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var4.id;
                  class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var4.mask;
                  class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var4.activity;
                  class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var4.location;
                  class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var4.playerCount;
                  class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var4.address;
               } else {
                  class82.intStack[++GrandExchangeEvents.intStackSize - 1] = -1;
                  class82.intStack[++GrandExchangeEvents.intStackSize - 1] = 0;
                  class82.scriptStringStack[++class82.scriptStringStackSize - 1] = "";
                  class82.intStack[++GrandExchangeEvents.intStackSize - 1] = 0;
                  class82.intStack[++GrandExchangeEvents.intStackSize - 1] = 0;
                  class82.scriptStringStack[++class82.scriptStringStackSize - 1] = "";
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-59314801"
   )
   static final void method710(boolean var0) {
      for(int var1 = 0; var1 < Client.npcIndexesCount; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.npcIndices[var1]];
         int var3 = (Client.npcIndices[var1] << 14) + 536870912;
         if(var2 != null && var2.hasConfig() && var2.composition.isVisible == var0 && var2.composition.method4830()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field1147 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field957[var4][var5] == Client.field958) {
                     continue;
                  }

                  Client.field957[var4][var5] = Client.field958;
               }

               if(!var2.composition.field3627) {
                  var3 -= Integer.MIN_VALUE;
               }

               GrandExchangeEvent.region.method2808(class233.plane, var2.x, var2.y, class41.getTileHeight(var2.field1147 * 64 - 64 + var2.x, var2.field1147 * 64 - 64 + var2.y, class233.plane), var2.field1147 * 64 - 64 + 60, var2, var2.angle, var3, var2.field1201);
            }
         }
      }

   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "1389853546"
   )
   static final void method711(int var0, int var1, int var2, boolean var3) {
      if(ISAACCipher.loadWidget(var0)) {
         class11.method66(class11.widgets[var0], -1, var1, var2, var3);
      }
   }
}
