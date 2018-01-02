import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("GameObjectTransformMetadata")
public final class GameObjectTransformMetadata extends Node {
   @ObfuscatedName("lg")
   @ObfuscatedGetter(
      intValue = 1509846049
   )
   static int field1222;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   static Deque field1235;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1893584993
   )
   int field1225;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 669210017
   )
   int field1223;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 964161605
   )
   int field1224;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 926151209
   )
   int field1232;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1253289707
   )
   int field1236;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1312874469
   )
   int field1221;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1244594291
   )
   int field1228;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ldg;"
   )
   SongMetadata field1229;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1292317037
   )
   int field1230;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1010519453
   )
   int field1231;
   @ObfuscatedName("c")
   int[] field1226;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -323310929
   )
   int field1233;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ldg;"
   )
   SongMetadata field1234;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   ObjectComposition field1227;

   static {
      field1235 = new Deque();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "871558708"
   )
   void method1540() {
      int var1 = this.field1228;
      ObjectComposition var2 = this.field1227.getImpostor();
      if(var2 != null) {
         this.field1228 = var2.ambientSoundId;
         this.field1221 = var2.int4 * 128;
         this.field1230 = var2.int5;
         this.field1231 = var2.int6;
         this.field1226 = var2.field3540;
      } else {
         this.field1228 = -1;
         this.field1221 = 0;
         this.field1230 = 0;
         this.field1231 = 0;
         this.field1226 = null;
      }

      if(var1 != this.field1228 && this.field1229 != null) {
         class214.field2628.method1882(this.field1229);
         this.field1229 = null;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IILfk;Lfp;I)Z",
      garbageValue = "-1160641537"
   )
   public static final boolean method1542(int var0, int var1, class168 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class167.field2218[var6][var7] = 99;
      class167.field2216[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class167.field2220[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class167.field2221[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var18 != var11) {
         var4 = class167.field2220[var11];
         var5 = class167.field2221[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod3167(1, var4, var5, var3)) {
            class167.field2217 = var4;
            class167.field2215 = var5;
            return true;
         }

         int var15 = class167.field2216[var16][var17] + 1;
         if(var16 > 0 && class167.field2218[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
            class167.field2220[var18] = var4 - 1;
            class167.field2221[var18] = var5;
            var18 = var18 + 1 & 4095;
            class167.field2218[var16 - 1][var17] = 2;
            class167.field2216[var16 - 1][var17] = var15;
         }

         if(var16 < 127 && class167.field2218[var16 + 1][var17] == 0 && (var12[var13 + 1][var14] & 19136896) == 0) {
            class167.field2220[var18] = var4 + 1;
            class167.field2221[var18] = var5;
            var18 = var18 + 1 & 4095;
            class167.field2218[var16 + 1][var17] = 8;
            class167.field2216[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class167.field2218[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class167.field2220[var18] = var4;
            class167.field2221[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class167.field2218[var16][var17 - 1] = 1;
            class167.field2216[var16][var17 - 1] = var15;
         }

         if(var17 < 127 && class167.field2218[var16][var17 + 1] == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class167.field2220[var18] = var4;
            class167.field2221[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class167.field2218[var16][var17 + 1] = 4;
            class167.field2216[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class167.field2218[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class167.field2220[var18] = var4 - 1;
            class167.field2221[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class167.field2218[var16 - 1][var17 - 1] = 3;
            class167.field2216[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 127 && var17 > 0 && class167.field2218[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class167.field2220[var18] = var4 + 1;
            class167.field2221[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class167.field2218[var16 + 1][var17 - 1] = 9;
            class167.field2216[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 127 && class167.field2218[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class167.field2220[var18] = var4 - 1;
            class167.field2221[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class167.field2218[var16 - 1][var17 + 1] = 6;
            class167.field2216[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 127 && var17 < 127 && class167.field2218[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 1] & 19136992) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class167.field2220[var18] = var4 + 1;
            class167.field2221[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class167.field2218[var16 + 1][var17 + 1] = 12;
            class167.field2216[var16 + 1][var17 + 1] = var15;
         }
      }

      class167.field2217 = var4;
      class167.field2215 = var5;
      return false;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "-502846568"
   )
   static int method1551(int var0, Script var1, boolean var2) {
      if(var0 == 6500) {
         class82.intStack[++class82.intStackSize - 1] = MouseRecorder.loadWorlds()?1:0;
         return 1;
      } else {
         World var4;
         if(var0 == 6501) {
            World.field1196 = 0;
            if(World.field1196 < World.worldCount) {
               var4 = ItemContainer.worldList[++World.field1196 - 1];
            } else {
               var4 = null;
            }

            if(var4 != null) {
               class82.intStack[++class82.intStackSize - 1] = var4.id;
               class82.intStack[++class82.intStackSize - 1] = var4.mask;
               class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var4.activity;
               class82.intStack[++class82.intStackSize - 1] = var4.location;
               class82.intStack[++class82.intStackSize - 1] = var4.playerCount;
               class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var4.address;
            } else {
               class82.intStack[++class82.intStackSize - 1] = -1;
               class82.intStack[++class82.intStackSize - 1] = 0;
               class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
               class82.intStack[++class82.intStackSize - 1] = 0;
               class82.intStack[++class82.intStackSize - 1] = 0;
               class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 6502) {
            World var3;
            if(World.field1196 < World.worldCount) {
               var3 = ItemContainer.worldList[++World.field1196 - 1];
            } else {
               var3 = null;
            }

            if(var3 != null) {
               class82.intStack[++class82.intStackSize - 1] = var3.id;
               class82.intStack[++class82.intStackSize - 1] = var3.mask;
               class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var3.activity;
               class82.intStack[++class82.intStackSize - 1] = var3.location;
               class82.intStack[++class82.intStackSize - 1] = var3.playerCount;
               class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var3.address;
            } else {
               class82.intStack[++class82.intStackSize - 1] = -1;
               class82.intStack[++class82.intStackSize - 1] = 0;
               class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
               class82.intStack[++class82.intStackSize - 1] = 0;
               class82.intStack[++class82.intStackSize - 1] = 0;
               class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else {
            int var5;
            int var11;
            if(var0 == 6506) {
               var11 = class82.intStack[--class82.intStackSize];
               var4 = null;

               for(var5 = 0; var5 < World.worldCount; ++var5) {
                  if(var11 == ItemContainer.worldList[var5].id) {
                     var4 = ItemContainer.worldList[var5];
                     break;
                  }
               }

               if(var4 != null) {
                  class82.intStack[++class82.intStackSize - 1] = var4.id;
                  class82.intStack[++class82.intStackSize - 1] = var4.mask;
                  class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var4.activity;
                  class82.intStack[++class82.intStackSize - 1] = var4.location;
                  class82.intStack[++class82.intStackSize - 1] = var4.playerCount;
                  class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var4.address;
               } else {
                  class82.intStack[++class82.intStackSize - 1] = -1;
                  class82.intStack[++class82.intStackSize - 1] = 0;
                  class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
                  class82.intStack[++class82.intStackSize - 1] = 0;
                  class82.intStack[++class82.intStackSize - 1] = 0;
                  class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 6507) {
               class82.intStackSize -= 4;
               var11 = class82.intStack[class82.intStackSize];
               boolean var15 = class82.intStack[class82.intStackSize + 1] == 1;
               var5 = class82.intStack[class82.intStackSize + 2];
               boolean var6 = class82.intStack[class82.intStackSize + 3] == 1;
               if(ItemContainer.worldList != null) {
                  class219.method4044(0, ItemContainer.worldList.length - 1, var11, var15, var5, var6);
               }

               return 1;
            } else if(var0 != 6511) {
               if(var0 == 6512) {
                  Client.field975 = class82.intStack[--class82.intStackSize] == 1;
                  return 1;
               } else {
                  int var12;
                  class262 var13;
                  if(var0 == 6513) {
                     class82.intStackSize -= 2;
                     var11 = class82.intStack[class82.intStackSize];
                     var12 = class82.intStack[class82.intStackSize + 1];
                     var13 = VarPlayerType.method4426(var12);
                     if(var13.method4579()) {
                        class82.scriptStringStack[++class35.scriptStringStackSize - 1] = Client.getNpcDefinition(var11).method4779(var12, var13.field3468);
                     } else {
                        class82.intStack[++class82.intStackSize - 1] = Client.getNpcDefinition(var11).method4778(var12, var13.field3469);
                     }

                     return 1;
                  } else if(var0 == 6514) {
                     class82.intStackSize -= 2;
                     var11 = class82.intStack[class82.intStackSize];
                     var12 = class82.intStack[class82.intStackSize + 1];
                     var13 = VarPlayerType.method4426(var12);
                     if(var13.method4579()) {
                        class82.scriptStringStack[++class35.scriptStringStackSize - 1] = CacheFile.getObjectDefinition(var11).method4685(var12, var13.field3468);
                     } else {
                        class82.intStack[++class82.intStackSize - 1] = CacheFile.getObjectDefinition(var11).method4668(var12, var13.field3469);
                     }

                     return 1;
                  } else if(var0 == 6515) {
                     class82.intStackSize -= 2;
                     var11 = class82.intStack[class82.intStackSize];
                     var12 = class82.intStack[class82.intStackSize + 1];
                     var13 = VarPlayerType.method4426(var12);
                     if(var13.method4579()) {
                        class82.scriptStringStack[++class35.scriptStringStackSize - 1] = KitDefinition.getItemDefinition(var11).method4722(var12, var13.field3468);
                     } else {
                        class82.intStack[++class82.intStackSize - 1] = KitDefinition.getItemDefinition(var11).method4721(var12, var13.field3469);
                     }

                     return 1;
                  } else if(var0 == 6516) {
                     class82.intStackSize -= 2;
                     var11 = class82.intStack[class82.intStackSize];
                     var12 = class82.intStack[class82.intStackSize + 1];
                     var13 = VarPlayerType.method4426(var12);
                     int var7;
                     class263 var8;
                     class263 var9;
                     byte[] var10;
                     if(var13.method4579()) {
                        String[] var14 = class82.scriptStringStack;
                        var7 = ++class35.scriptStringStackSize - 1;
                        var9 = (class263)class263.field3472.get((long)var11);
                        if(var9 != null) {
                           var8 = var9;
                        } else {
                           var10 = class263.field3471.getConfigData(34, var11);
                           var9 = new class263();
                           if(var10 != null) {
                              var9.method4599(new Buffer(var10));
                           }

                           var9.method4591();
                           class263.field3472.put(var9, (long)var11);
                           var8 = var9;
                        }

                        var14[var7] = var8.method4590(var12, var13.field3468);
                     } else {
                        int[] var16 = class82.intStack;
                        var7 = ++class82.intStackSize - 1;
                        var9 = (class263)class263.field3472.get((long)var11);
                        if(var9 != null) {
                           var8 = var9;
                        } else {
                           var10 = class263.field3471.getConfigData(34, var11);
                           var9 = new class263();
                           if(var10 != null) {
                              var9.method4599(new Buffer(var10));
                           }

                           var9.method4591();
                           class263.field3472.put(var9, (long)var11);
                           var8 = var9;
                        }

                        var16[var7] = var8.method4594(var12, var13.field3469);
                     }

                     return 1;
                  } else if(var0 == 6518) {
                     class82.intStack[++class82.intStackSize - 1] = 0;
                     return 1;
                  } else {
                     return var0 == 6520?1:(var0 == 6521?1:2);
                  }
               }
            } else {
               var11 = class82.intStack[--class82.intStackSize];
               if(var11 >= 0 && var11 < World.worldCount) {
                  var4 = ItemContainer.worldList[var11];
                  class82.intStack[++class82.intStackSize - 1] = var4.id;
                  class82.intStack[++class82.intStackSize - 1] = var4.mask;
                  class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var4.activity;
                  class82.intStack[++class82.intStackSize - 1] = var4.location;
                  class82.intStack[++class82.intStackSize - 1] = var4.playerCount;
                  class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var4.address;
               } else {
                  class82.intStack[++class82.intStackSize - 1] = -1;
                  class82.intStack[++class82.intStackSize - 1] = 0;
                  class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
                  class82.intStack[++class82.intStackSize - 1] = 0;
                  class82.intStack[++class82.intStackSize - 1] = 0;
                  class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
               }

               return 1;
            }
         }
      }
   }
}
