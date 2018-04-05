import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public class class22 extends class28 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgc;Lgc;I)V",
      garbageValue = "1288395200"
   )
   void method185(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class37.field499.field500) {
         throw new IllegalStateException("");
      } else {
         super.field410 = var2.readUnsignedByte();
         super.field411 = var2.readUnsignedByte();
         super.field406 = var2.readUnsignedShort();
         super.field407 = var2.readUnsignedShort();
         super.field420 = var2.readUnsignedShort();
         super.field409 = var2.readUnsignedShort();
         super.field411 = Math.min(super.field411, 4);
         super.field414 = new short[1][64][64];
         super.field413 = new short[super.field411][64][64];
         super.field408 = new byte[super.field411][64][64];
         super.field415 = new byte[super.field411][64][64];
         super.decorations = new WorldMapDecoration[super.field411][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class36.field494.field496) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(var4 == super.field420 && var5 == super.field409) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method251(var6, var7, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class22)) {
         return false;
      } else {
         class22 var2 = (class22)var1;
         return var2.field420 == super.field420 && var2.field409 == super.field409;
      }
   }

   public int hashCode() {
      return super.field420 | super.field409 << 8;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgs;IB)V",
      garbageValue = "-84"
   )
   @Export("decodeMovement")
   static void decodeMovement(PacketBuffer var0, int var1) {
      boolean var2 = var0.getBits(1) == 1;
      if(var2) {
         class93.field1439[++class93.field1438 - 1] = var1;
      }

      int var3 = var0.getBits(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field860 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class93.Players_regions[var1] = (var4.field856 << 28) + (class138.baseX + var4.pathX[0] >> 13 << 14) + (class23.baseY + var4.pathY[0] >> 13);
            if(var4.field1185 != -1) {
               class93.Players_orientations[var1] = var4.field1185;
            } else {
               class93.Players_orientations[var1] = var4.orientation;
            }

            class93.Players_targetIndices[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.getBits(1) != 0) {
               ScriptEvent.decodeRegionHash(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.getBits(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1196(var6, var7);
               var4.field860 = false;
            } else if(var2) {
               var4.field860 = true;
               var4.field861 = var6;
               var4.field837 = var7;
            } else {
               var4.field860 = false;
               var4.method1195(var6, var7, class93.field1429[var1]);
            }

         } else if(var3 == 2) {
            var5 = var0.getBits(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1196(var6, var7);
               var4.field860 = false;
            } else if(var2) {
               var4.field860 = true;
               var4.field861 = var6;
               var4.field837 = var7;
            } else {
               var4.field860 = false;
               var4.method1195(var6, var7, class93.field1429[var1]);
            }

         } else {
            var5 = var0.getBits(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.getBits(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.pathX[0];
               var11 = var9 + var4.pathY[0];
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field860 = true;
                     var4.field861 = var10;
                     var4.field837 = var11;
                  } else {
                     var4.field860 = false;
                     var4.method1195(var10, var11, class93.field1429[var1]);
                  }
               } else {
                  var4.method1196(var10, var11);
                  var4.field860 = false;
               }

               var4.field856 = (byte)(var7 + var4.field856 & 3);
               if(Client.localInteractingIndex == var1) {
                  BoundingBox3DDrawMode.plane = var4.field856;
               }

            } else {
               var6 = var0.getBits(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + class138.baseX + var4.pathX[0] & 16383) - class138.baseX;
               var11 = (var9 + class23.baseY + var4.pathY[0] & 16383) - class23.baseY;
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field860 = true;
                     var4.field861 = var10;
                     var4.field837 = var11;
                  } else {
                     var4.field860 = false;
                     var4.method1195(var10, var11, class93.field1429[var1]);
                  }
               } else {
                  var4.method1196(var10, var11);
                  var4.field860 = false;
               }

               var4.field856 = (byte)(var7 + var4.field856 & 3);
               if(Client.localInteractingIndex == var1) {
                  BoundingBox3DDrawMode.plane = var4.field856;
               }

            }
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILcr;ZB)I",
      garbageValue = "58"
   )
   static int method173(int var0, Script var1, boolean var2) {
      if(var0 == 6500) {
         class81.intStack[++WorldComparator.intStackSize - 1] = WorldMapDecorationType.loadWorlds()?1:0;
         return 1;
      } else {
         World var4;
         if(var0 == 6501) {
            World.field1228 = 0;
            if(World.field1228 < World.worldCount) {
               var4 = World.worldList[++World.field1228 - 1];
            } else {
               var4 = null;
            }

            if(var4 != null) {
               class81.intStack[++WorldComparator.intStackSize - 1] = var4.id;
               class81.intStack[++WorldComparator.intStackSize - 1] = var4.mask;
               class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var4.activity;
               class81.intStack[++WorldComparator.intStackSize - 1] = var4.location;
               class81.intStack[++WorldComparator.intStackSize - 1] = var4.playerCount;
               class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var4.address;
            } else {
               class81.intStack[++WorldComparator.intStackSize - 1] = -1;
               class81.intStack[++WorldComparator.intStackSize - 1] = 0;
               class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
               class81.intStack[++WorldComparator.intStackSize - 1] = 0;
               class81.intStack[++WorldComparator.intStackSize - 1] = 0;
               class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 6502) {
            World var3;
            if(World.field1228 < World.worldCount) {
               var3 = World.worldList[++World.field1228 - 1];
            } else {
               var3 = null;
            }

            if(var3 != null) {
               class81.intStack[++WorldComparator.intStackSize - 1] = var3.id;
               class81.intStack[++WorldComparator.intStackSize - 1] = var3.mask;
               class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3.activity;
               class81.intStack[++WorldComparator.intStackSize - 1] = var3.location;
               class81.intStack[++WorldComparator.intStackSize - 1] = var3.playerCount;
               class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3.address;
            } else {
               class81.intStack[++WorldComparator.intStackSize - 1] = -1;
               class81.intStack[++WorldComparator.intStackSize - 1] = 0;
               class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
               class81.intStack[++WorldComparator.intStackSize - 1] = 0;
               class81.intStack[++WorldComparator.intStackSize - 1] = 0;
               class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else {
            int var5;
            int var11;
            if(var0 == 6506) {
               var11 = class81.intStack[--WorldComparator.intStackSize];
               var4 = null;

               for(var5 = 0; var5 < World.worldCount; ++var5) {
                  if(var11 == World.worldList[var5].id) {
                     var4 = World.worldList[var5];
                     break;
                  }
               }

               if(var4 != null) {
                  class81.intStack[++WorldComparator.intStackSize - 1] = var4.id;
                  class81.intStack[++WorldComparator.intStackSize - 1] = var4.mask;
                  class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var4.activity;
                  class81.intStack[++WorldComparator.intStackSize - 1] = var4.location;
                  class81.intStack[++WorldComparator.intStackSize - 1] = var4.playerCount;
                  class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var4.address;
               } else {
                  class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                  class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                  class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                  class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                  class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                  class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 6507) {
               WorldComparator.intStackSize -= 4;
               var11 = class81.intStack[WorldComparator.intStackSize];
               boolean var15 = class81.intStack[WorldComparator.intStackSize + 1] == 1;
               var5 = class81.intStack[WorldComparator.intStackSize + 2];
               boolean var6 = class81.intStack[WorldComparator.intStackSize + 3] == 1;
               class23.method187(var11, var15, var5, var6);
               return 1;
            } else if(var0 != 6511) {
               if(var0 == 6512) {
                  Client.field1014 = class81.intStack[--WorldComparator.intStackSize] == 1;
                  return 1;
               } else {
                  int var12;
                  class278 var13;
                  if(var0 == 6513) {
                     WorldComparator.intStackSize -= 2;
                     var11 = class81.intStack[WorldComparator.intStackSize];
                     var12 = class81.intStack[WorldComparator.intStackSize + 1];
                     var13 = CombatInfo2.method4877(var12);
                     if(var13.method4916()) {
                        class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = class234.getNpcDefinition(var11).method5125(var12, var13.field3549);
                     } else {
                        class81.intStack[++WorldComparator.intStackSize - 1] = class234.getNpcDefinition(var11).method5124(var12, var13.field3545);
                     }

                     return 1;
                  } else if(var0 == 6514) {
                     WorldComparator.intStackSize -= 2;
                     var11 = class81.intStack[WorldComparator.intStackSize];
                     var12 = class81.intStack[WorldComparator.intStackSize + 1];
                     var13 = CombatInfo2.method4877(var12);
                     if(var13.method4916()) {
                        class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = GameCanvas.getObjectDefinition(var11).method5008(var12, var13.field3549);
                     } else {
                        class81.intStack[++WorldComparator.intStackSize - 1] = GameCanvas.getObjectDefinition(var11).method5003(var12, var13.field3545);
                     }

                     return 1;
                  } else if(var0 == 6515) {
                     WorldComparator.intStackSize -= 2;
                     var11 = class81.intStack[WorldComparator.intStackSize];
                     var12 = class81.intStack[WorldComparator.intStackSize + 1];
                     var13 = CombatInfo2.method4877(var12);
                     if(var13.method4916()) {
                        class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = class47.getItemDefinition(var11).method5069(var12, var13.field3549);
                     } else {
                        class81.intStack[++WorldComparator.intStackSize - 1] = class47.getItemDefinition(var11).method5068(var12, var13.field3545);
                     }

                     return 1;
                  } else if(var0 == 6516) {
                     WorldComparator.intStackSize -= 2;
                     var11 = class81.intStack[WorldComparator.intStackSize];
                     var12 = class81.intStack[WorldComparator.intStackSize + 1];
                     var13 = CombatInfo2.method4877(var12);
                     if(var13.method4916()) {
                        class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = class228.method4119(var11).method4932(var12, var13.field3549);
                     } else {
                        int[] var14 = class81.intStack;
                        int var7 = ++WorldComparator.intStackSize - 1;
                        class279 var9 = (class279)class279.field3553.get((long)var11);
                        class279 var8;
                        if(var9 != null) {
                           var8 = var9;
                        } else {
                           byte[] var10 = class279.field3552.getConfigData(34, var11);
                           var9 = new class279();
                           if(var10 != null) {
                              var9.method4937(new Buffer(var10));
                           }

                           var9.method4925();
                           class279.field3553.put(var9, (long)var11);
                           var8 = var9;
                        }

                        var14[var7] = var8.method4924(var12, var13.field3545);
                     }

                     return 1;
                  } else if(var0 == 6518) {
                     class81.intStack[++WorldComparator.intStackSize - 1] = Client.field878?1:0;
                     return 1;
                  } else if(var0 == 6520) {
                     return 1;
                  } else if(var0 == 6521) {
                     return 1;
                  } else if(var0 == 6522) {
                     --KeyFocusListener.scriptStringStackSize;
                     --WorldComparator.intStackSize;
                     return 1;
                  } else if(var0 == 6523) {
                     --KeyFocusListener.scriptStringStackSize;
                     --WorldComparator.intStackSize;
                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               var11 = class81.intStack[--WorldComparator.intStackSize];
               if(var11 >= 0 && var11 < World.worldCount) {
                  var4 = World.worldList[var11];
                  class81.intStack[++WorldComparator.intStackSize - 1] = var4.id;
                  class81.intStack[++WorldComparator.intStackSize - 1] = var4.mask;
                  class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var4.activity;
                  class81.intStack[++WorldComparator.intStackSize - 1] = var4.location;
                  class81.intStack[++WorldComparator.intStackSize - 1] = var4.playerCount;
                  class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var4.address;
               } else {
                  class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                  class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                  class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                  class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                  class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                  class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "7"
   )
   static void method184(int var0) {
      Projectile.topContextMenuRow = new ContextMenuRow();
      Projectile.topContextMenuRow.param0 = Client.menuActionParams0[var0];
      Projectile.topContextMenuRow.param1 = Client.menuActionParams1[var0];
      Projectile.topContextMenuRow.type = Client.menuTypes[var0];
      Projectile.topContextMenuRow.identifier = Client.menuIdentifiers[var0];
      Projectile.topContextMenuRow.option = Client.menuOptions[var0];
   }
}
