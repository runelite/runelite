import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
public class class227 {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-598601446"
   )
   static final void method4063(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int[] var7 = Region.method2719(var0, var1, var2);
      int[] var8 = Region.method2719(var3, var4, var5);
      Rasterizer2D.drawLine(var7[0], var7[1], var8[0], var8[1], var6);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lej;IIIIB)V",
      garbageValue = "-65"
   )
   public static final void method4064(Model var0, int var1, int var2, int var3, int var4) {
      class7.field226.method3563(new class10(var0, var1, var2, var3, var4));
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILcg;ZB)I",
      garbageValue = "43"
   )
   static int method4065(int var0, Script var1, boolean var2) {
      if(var0 == 3300) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = Client.gameCycle;
         return 1;
      } else {
         int var3;
         int var4;
         if(var0 == 3301) {
            WorldMapType2.intStackSize -= 2;
            var3 = class83.intStack[WorldMapType2.intStackSize];
            var4 = class83.intStack[WorldMapType2.intStackSize + 1];
            class83.intStack[++WorldMapType2.intStackSize - 1] = BaseVarType.method12(var3, var4);
            return 1;
         } else {
            int[] var5;
            int var6;
            int var7;
            XItemContainer var8;
            if(var0 == 3302) {
               WorldMapType2.intStackSize -= 2;
               var3 = class83.intStack[WorldMapType2.intStackSize];
               var4 = class83.intStack[WorldMapType2.intStackSize + 1];
               var5 = class83.intStack;
               var6 = ++WorldMapType2.intStackSize - 1;
               var8 = (XItemContainer)XItemContainer.itemContainers.get((long)var3);
               if(var8 == null) {
                  var7 = 0;
               } else if(var4 >= 0 && var4 < var8.stackSizes.length) {
                  var7 = var8.stackSizes[var4];
               } else {
                  var7 = 0;
               }

               var5[var6] = var7;
               return 1;
            } else {
               int var9;
               int var10;
               if(var0 == 3303) {
                  WorldMapType2.intStackSize -= 2;
                  var3 = class83.intStack[WorldMapType2.intStackSize];
                  var4 = class83.intStack[WorldMapType2.intStackSize + 1];
                  var5 = class83.intStack;
                  var6 = ++WorldMapType2.intStackSize - 1;
                  var8 = (XItemContainer)XItemContainer.itemContainers.get((long)var3);
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
                     var3 = class83.intStack[--WorldMapType2.intStackSize];
                     int[] var11 = class83.intStack;
                     var12 = ++WorldMapType2.intStackSize - 1;
                     InvType var13 = (InvType)InvType.field3280.get((long)var3);
                     InvType var14;
                     if(var13 != null) {
                        var14 = var13;
                     } else {
                        byte[] var15 = InvType.field3281.getConfigData(5, var3);
                        var13 = new InvType();
                        if(var15 != null) {
                           var13.decode(new Buffer(var15));
                        }

                        InvType.field3280.put(var13, (long)var3);
                        var14 = var13;
                     }

                     var11[var12] = var14.field3279;
                     return 1;
                  } else if(var0 == 3305) {
                     var3 = class83.intStack[--WorldMapType2.intStackSize];
                     class83.intStack[++WorldMapType2.intStackSize - 1] = Client.boostedSkillLevels[var3];
                     return 1;
                  } else if(var0 == 3306) {
                     var3 = class83.intStack[--WorldMapType2.intStackSize];
                     class83.intStack[++WorldMapType2.intStackSize - 1] = Client.realSkillLevels[var3];
                     return 1;
                  } else if(var0 == 3307) {
                     var3 = class83.intStack[--WorldMapType2.intStackSize];
                     class83.intStack[++WorldMapType2.intStackSize - 1] = Client.skillExperiences[var3];
                     return 1;
                  } else if(var0 == 3308) {
                     var3 = class45.plane;
                     var4 = (Script.localPlayer.x >> 7) + class163.baseX;
                     var12 = (Script.localPlayer.y >> 7) + class10.baseY;
                     class83.intStack[++WorldMapType2.intStackSize - 1] = (var4 << 14) + (var3 << 28) + var12;
                     return 1;
                  } else if(var0 == 3309) {
                     var3 = class83.intStack[--WorldMapType2.intStackSize];
                     class83.intStack[++WorldMapType2.intStackSize - 1] = var3 >> 14 & 16383;
                     return 1;
                  } else if(var0 == 3310) {
                     var3 = class83.intStack[--WorldMapType2.intStackSize];
                     class83.intStack[++WorldMapType2.intStackSize - 1] = var3 >> 28;
                     return 1;
                  } else if(var0 == 3311) {
                     var3 = class83.intStack[--WorldMapType2.intStackSize];
                     class83.intStack[++WorldMapType2.intStackSize - 1] = var3 & 16383;
                     return 1;
                  } else if(var0 == 3312) {
                     class83.intStack[++WorldMapType2.intStackSize - 1] = Client.isMembers?1:0;
                     return 1;
                  } else if(var0 == 3313) {
                     WorldMapType2.intStackSize -= 2;
                     var3 = class83.intStack[WorldMapType2.intStackSize] + '耀';
                     var4 = class83.intStack[WorldMapType2.intStackSize + 1];
                     class83.intStack[++WorldMapType2.intStackSize - 1] = BaseVarType.method12(var3, var4);
                     return 1;
                  } else if(var0 == 3314) {
                     WorldMapType2.intStackSize -= 2;
                     var3 = class83.intStack[WorldMapType2.intStackSize] + '耀';
                     var4 = class83.intStack[WorldMapType2.intStackSize + 1];
                     var5 = class83.intStack;
                     var6 = ++WorldMapType2.intStackSize - 1;
                     var8 = (XItemContainer)XItemContainer.itemContainers.get((long)var3);
                     if(var8 == null) {
                        var7 = 0;
                     } else if(var4 >= 0 && var4 < var8.stackSizes.length) {
                        var7 = var8.stackSizes[var4];
                     } else {
                        var7 = 0;
                     }

                     var5[var6] = var7;
                     return 1;
                  } else if(var0 != 3315) {
                     if(var0 == 3316) {
                        if(Client.rights >= 2) {
                           class83.intStack[++WorldMapType2.intStackSize - 1] = Client.rights;
                        } else {
                           class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                        }

                        return 1;
                     } else if(var0 == 3317) {
                        class83.intStack[++WorldMapType2.intStackSize - 1] = Client.field986;
                        return 1;
                     } else if(var0 == 3318) {
                        class83.intStack[++WorldMapType2.intStackSize - 1] = Client.world;
                        return 1;
                     } else if(var0 == 3321) {
                        class83.intStack[++WorldMapType2.intStackSize - 1] = Client.energy;
                        return 1;
                     } else if(var0 == 3322) {
                        class83.intStack[++WorldMapType2.intStackSize - 1] = Client.weight;
                        return 1;
                     } else if(var0 == 3323) {
                        if(Client.field1075) {
                           class83.intStack[++WorldMapType2.intStackSize - 1] = 1;
                        } else {
                           class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                        }

                        return 1;
                     } else if(var0 == 3324) {
                        class83.intStack[++WorldMapType2.intStackSize - 1] = Client.flags;
                        return 1;
                     } else if(var0 == 3325) {
                        WorldMapType2.intStackSize -= 4;
                        var3 = class83.intStack[WorldMapType2.intStackSize];
                        var4 = class83.intStack[WorldMapType2.intStackSize + 1];
                        var12 = class83.intStack[WorldMapType2.intStackSize + 2];
                        var6 = class83.intStack[WorldMapType2.intStackSize + 3];
                        var3 += var4 << 14;
                        var3 += var12 << 28;
                        var3 += var6;
                        class83.intStack[++WorldMapType2.intStackSize - 1] = var3;
                        return 1;
                     } else {
                        return 2;
                     }
                  } else {
                     WorldMapType2.intStackSize -= 2;
                     var3 = class83.intStack[WorldMapType2.intStackSize] + '耀';
                     var4 = class83.intStack[WorldMapType2.intStackSize + 1];
                     var5 = class83.intStack;
                     var6 = ++WorldMapType2.intStackSize - 1;
                     var8 = (XItemContainer)XItemContainer.itemContainers.get((long)var3);
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
   }
}
