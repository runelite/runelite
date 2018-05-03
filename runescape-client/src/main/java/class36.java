import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class36 {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lad;"
   )
   static final class36 field490;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lad;"
   )
   static final class36 field492;
   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("indexCache13")
   static IndexData indexCache13;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = -1469342123
   )
   static int field493;
   @ObfuscatedName("mx")
   @ObfuscatedGetter(
      intValue = -1550147173
   )
   static int field496;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2056803673
   )
   final int field491;

   static {
      field490 = new class36(0);
      field492 = new class36(1);
   }

   class36(int var1) {
      this.field491 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "76"
   )
   static boolean method543(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   public static void method546() {
      CombatInfo2.field3524.reset();
      CombatInfo2.field3525.reset();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-37"
   )
   static final int method540(int var0, int var1) {
      int var2 = class90.getSmoothNoise(var0 + 45365, var1 + 91923, 4) - 128 + (class90.getSmoothNoise(var0 + 10294, 37821 + var1, 2) - 128 >> 1) + (class90.getSmoothNoise(var0, var1, 1) - 128 >> 2);
      var2 = (int)((double)var2 * 0.3D) + 35;
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILcr;ZI)I",
      garbageValue = "-1442850991"
   )
   static int method544(int var0, Script var1, boolean var2) {
      if(var0 == 3300) {
         class81.intStack[++class171.intStackSize - 1] = Client.gameCycle;
         return 1;
      } else {
         int var3;
         int var4;
         int[] var5;
         int var6;
         int var7;
         ItemContainer var8;
         if(var0 == 3301) {
            class171.intStackSize -= 2;
            var3 = class81.intStack[class171.intStackSize];
            var4 = class81.intStack[class171.intStackSize + 1];
            var5 = class81.intStack;
            var6 = ++class171.intStackSize - 1;
            var8 = (ItemContainer)ItemContainer.itemContainers.get((long)var3);
            if(var8 == null) {
               var7 = -1;
            } else if(var4 >= 0 && var4 < var8.itemIds.length) {
               var7 = var8.itemIds[var4];
            } else {
               var7 = -1;
            }

            var5[var6] = var7;
            return 1;
         } else if(var0 == 3302) {
            class171.intStackSize -= 2;
            var3 = class81.intStack[class171.intStackSize];
            var4 = class81.intStack[class171.intStackSize + 1];
            class81.intStack[++class171.intStackSize - 1] = BoundingBox3D.method56(var3, var4);
            return 1;
         } else {
            int var9;
            int var10;
            if(var0 == 3303) {
               class171.intStackSize -= 2;
               var3 = class81.intStack[class171.intStackSize];
               var4 = class81.intStack[class171.intStackSize + 1];
               var5 = class81.intStack;
               var6 = ++class171.intStackSize - 1;
               var8 = (ItemContainer)ItemContainer.itemContainers.get((long)var3);
               if(var8 == null) {
                  var7 = 0;
               } else if(var4 == -1) {
                  var7 = 0;
               } else {
                  var9 = 0;

                  for(var10 = 0; var10 < var8.stackSizes.length; ++var10) {
                     if(var4 == var8.itemIds[var10]) {
                        var9 += var8.stackSizes[var10];
                     }
                  }

                  var7 = var9;
               }

               var5[var6] = var7;
               return 1;
            } else {
               int var12;
               if(var0 == 3304) {
                  var3 = class81.intStack[--class171.intStackSize];
                  int[] var11 = class81.intStack;
                  var12 = ++class171.intStackSize - 1;
                  InvType var13 = (InvType)InvType.inventoryCache.get((long)var3);
                  InvType var14;
                  if(var13 != null) {
                     var14 = var13;
                  } else {
                     byte[] var15 = InvType.field3441.getConfigData(5, var3);
                     var13 = new InvType();
                     if(var15 != null) {
                        var13.decode(new Buffer(var15));
                     }

                     InvType.inventoryCache.put(var13, (long)var3);
                     var14 = var13;
                  }

                  var11[var12] = var14.size;
                  return 1;
               } else if(var0 == 3305) {
                  var3 = class81.intStack[--class171.intStackSize];
                  class81.intStack[++class171.intStackSize - 1] = Client.boostedSkillLevels[var3];
                  return 1;
               } else if(var0 == 3306) {
                  var3 = class81.intStack[--class171.intStackSize];
                  class81.intStack[++class171.intStackSize - 1] = Client.realSkillLevels[var3];
                  return 1;
               } else if(var0 == 3307) {
                  var3 = class81.intStack[--class171.intStackSize];
                  class81.intStack[++class171.intStackSize - 1] = Client.skillExperiences[var3];
                  return 1;
               } else if(var0 == 3308) {
                  var3 = ScriptVarType.plane;
                  var4 = (class265.localPlayer.x >> 7) + ClientPacket.baseX;
                  var12 = (class265.localPlayer.y >> 7) + MapIconReference.baseY;
                  class81.intStack[++class171.intStackSize - 1] = (var4 << 14) + var12 + (var3 << 28);
                  return 1;
               } else if(var0 == 3309) {
                  var3 = class81.intStack[--class171.intStackSize];
                  class81.intStack[++class171.intStackSize - 1] = var3 >> 14 & 16383;
                  return 1;
               } else if(var0 == 3310) {
                  var3 = class81.intStack[--class171.intStackSize];
                  class81.intStack[++class171.intStackSize - 1] = var3 >> 28;
                  return 1;
               } else if(var0 == 3311) {
                  var3 = class81.intStack[--class171.intStackSize];
                  class81.intStack[++class171.intStackSize - 1] = var3 & 16383;
                  return 1;
               } else if(var0 == 3312) {
                  class81.intStack[++class171.intStackSize - 1] = Client.isMembers?1:0;
                  return 1;
               } else if(var0 == 3313) {
                  class171.intStackSize -= 2;
                  var3 = class81.intStack[class171.intStackSize] + 32768;
                  var4 = class81.intStack[class171.intStackSize + 1];
                  var5 = class81.intStack;
                  var6 = ++class171.intStackSize - 1;
                  var8 = (ItemContainer)ItemContainer.itemContainers.get((long)var3);
                  if(var8 == null) {
                     var7 = -1;
                  } else if(var4 >= 0 && var4 < var8.itemIds.length) {
                     var7 = var8.itemIds[var4];
                  } else {
                     var7 = -1;
                  }

                  var5[var6] = var7;
                  return 1;
               } else if(var0 == 3314) {
                  class171.intStackSize -= 2;
                  var3 = class81.intStack[class171.intStackSize] + 32768;
                  var4 = class81.intStack[class171.intStackSize + 1];
                  class81.intStack[++class171.intStackSize - 1] = BoundingBox3D.method56(var3, var4);
                  return 1;
               } else if(var0 != 3315) {
                  if(var0 == 3316) {
                     if(Client.rights >= 2) {
                        class81.intStack[++class171.intStackSize - 1] = Client.rights;
                     } else {
                        class81.intStack[++class171.intStackSize - 1] = 0;
                     }

                     return 1;
                  } else if(var0 == 3317) {
                     class81.intStack[++class171.intStackSize - 1] = Client.field869;
                     return 1;
                  } else if(var0 == 3318) {
                     class81.intStack[++class171.intStackSize - 1] = Client.world;
                     return 1;
                  } else if(var0 == 3321) {
                     class81.intStack[++class171.intStackSize - 1] = Client.energy;
                     return 1;
                  } else if(var0 == 3322) {
                     class81.intStack[++class171.intStackSize - 1] = Client.weight;
                     return 1;
                  } else if(var0 == 3323) {
                     if(Client.field1021) {
                        class81.intStack[++class171.intStackSize - 1] = 1;
                     } else {
                        class81.intStack[++class171.intStackSize - 1] = 0;
                     }

                     return 1;
                  } else if(var0 == 3324) {
                     class81.intStack[++class171.intStackSize - 1] = Client.flags;
                     return 1;
                  } else if(var0 == 3325) {
                     class171.intStackSize -= 4;
                     var3 = class81.intStack[class171.intStackSize];
                     var4 = class81.intStack[class171.intStackSize + 1];
                     var12 = class81.intStack[class171.intStackSize + 2];
                     var6 = class81.intStack[class171.intStackSize + 3];
                     var3 += var4 << 14;
                     var3 += var12 << 28;
                     var3 += var6;
                     class81.intStack[++class171.intStackSize - 1] = var3;
                     return 1;
                  } else {
                     return 2;
                  }
               } else {
                  class171.intStackSize -= 2;
                  var3 = class81.intStack[class171.intStackSize] + 32768;
                  var4 = class81.intStack[class171.intStackSize + 1];
                  var5 = class81.intStack;
                  var6 = ++class171.intStackSize - 1;
                  var8 = (ItemContainer)ItemContainer.itemContainers.get((long)var3);
                  if(var8 == null) {
                     var7 = 0;
                  } else if(var4 == -1) {
                     var7 = 0;
                  } else {
                     var9 = 0;

                     for(var10 = 0; var10 < var8.stackSizes.length; ++var10) {
                        if(var4 == var8.itemIds[var10]) {
                           var9 += var8.stackSizes[var10];
                        }
                     }

                     var7 = var9;
                  }

                  var5[var6] = var7;
                  return 1;
               }
            }
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILcr;ZI)I",
      garbageValue = "-2094650302"
   )
   static int method542(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      int var6;
      if(var0 == 3400) {
         class171.intStackSize -= 2;
         var3 = class81.intStack[class171.intStackSize];
         var4 = class81.intStack[class171.intStackSize + 1];
         Enum var5 = GroundObject.method2768(var3);
         if(var5.valType != 's') {
            ;
         }

         for(var6 = 0; var6 < var5.size; ++var6) {
            if(var4 == var5.keys[var6]) {
               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var5.stringVals[var6];
               var5 = null;
               break;
            }
         }

         if(var5 != null) {
            class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var5.defaultString;
         }

         return 1;
      } else if(var0 != 3408) {
         if(var0 == 3411) {
            var3 = class81.intStack[--class171.intStackSize];
            Enum var10 = GroundObject.method2768(var3);
            class81.intStack[++class171.intStackSize - 1] = var10.method5029();
            return 1;
         } else {
            return 2;
         }
      } else {
         class171.intStackSize -= 4;
         var3 = class81.intStack[class171.intStackSize];
         var4 = class81.intStack[class171.intStackSize + 1];
         int var9 = class81.intStack[class171.intStackSize + 2];
         var6 = class81.intStack[class171.intStackSize + 3];
         Enum var7 = GroundObject.method2768(var9);
         if(var3 == var7.keyType && var4 == var7.valType) {
            for(int var8 = 0; var8 < var7.size; ++var8) {
               if(var6 == var7.keys[var8]) {
                  if(var4 == 115) {
                     class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var7.stringVals[var8];
                  } else {
                     class81.intStack[++class171.intStackSize - 1] = var7.intVals[var8];
                  }

                  var7 = null;
                  break;
               }
            }

            if(var7 != null) {
               if(var4 == 115) {
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var7.defaultString;
               } else {
                  class81.intStack[++class171.intStackSize - 1] = var7.defaultInt;
               }
            }

            return 1;
         } else {
            if(var4 == 115) {
               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "null";
            } else {
               class81.intStack[++class171.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-82805187"
   )
   static final void method545() {
      if(MapIconReference.soundSystem1 != null) {
         MapIconReference.soundSystem1.method2328();
      }

      if(Resampler.soundSystem0 != null) {
         Resampler.soundSystem0.method2328();
      }

   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(Lbd;ZI)V",
      garbageValue = "2083811289"
   )
   static void method541(Player var0, boolean var1) {
      if(var0 != null && var0.hasConfig() && !var0.hidden) {
         int var2 = var0.playerId << 14;
         var0.isLowDetail = false;
         if((Client.lowMemory && class93.playerIndexesCount > 50 || class93.playerIndexesCount > 200) && var1 && var0.poseAnimation == var0.idlePoseAnimation) {
            var0.isLowDetail = true;
         }

         int var3 = var0.x >> 7;
         int var4 = var0.y >> 7;
         if(var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
            if(var0.model != null && Client.gameCycle >= var0.animationCycleStart && Client.gameCycle < var0.animationCycleEnd) {
               var0.isLowDetail = false;
               var0.field822 = GrandExchangeEvent.getTileHeight(var0.x, var0.y, ScriptVarType.plane);
               var0.field1144 = Client.gameCycle;
               GameSocket.region.method2959(ScriptVarType.plane, var0.x, var0.y, var0.field822, 60, var0, var0.angle, var2, var0.field829, var0.field830, var0.field818, var0.field836);
            } else {
               if((var0.x & 127) == 64 && (var0.y & 127) == 64) {
                  if(Client.field948[var3][var4] == Client.field1093) {
                     return;
                  }

                  Client.field948[var3][var4] = Client.field1093;
               }

               var0.field822 = GrandExchangeEvent.getTileHeight(var0.x, var0.y, ScriptVarType.plane);
               var0.field1144 = Client.gameCycle;
               GameSocket.region.method2958(ScriptVarType.plane, var0.x, var0.y, var0.field822, 60, var0, var0.angle, var2, var0.field1142);
            }
         }
      }

   }
}
