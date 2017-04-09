import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("d")
   static String field780;
   @ObfuscatedName("f")
   @Export("composition")
   NPCComposition composition;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1707040151
   )
   public static int field783;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IBB)V",
      garbageValue = "-25"
   )
   final void method735(int var1, byte var2) {
      int var3 = super.pathX[0];
      int var4 = super.pathY[0];
      if(var1 == 0) {
         --var3;
         ++var4;
      }

      if(var1 == 1) {
         ++var4;
      }

      if(var1 == 2) {
         ++var3;
         ++var4;
      }

      if(var1 == 3) {
         --var3;
      }

      if(var1 == 4) {
         ++var3;
      }

      if(var1 == 5) {
         --var3;
         --var4;
      }

      if(var1 == 6) {
         --var4;
      }

      if(var1 == 7) {
         ++var3;
         --var4;
      }

      if(super.animation != -1 && Friend.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(super.field672 < 9) {
         ++super.field672;
      }

      for(int var5 = super.field672; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field675[var5] = super.field675[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field675[0] = var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "-79884070"
   )
   final void method736(int var1, int var2, boolean var3) {
      if(super.animation != -1 && Friend.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field672 < 9) {
               ++super.field672;
            }

            for(int var6 = super.field672; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.field675[var6] = super.field675[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field675[0] = 1;
            return;
         }
      }

      super.field672 = 0;
      super.field655 = 0;
      super.field651 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field622 * 64 + super.pathX[0] * 128;
      super.y = super.field622 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1006538820"
   )
   final boolean vmethod738() {
      return this.composition != null;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "1"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?Friend.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || super.idlePoseAnimation == super.poseAnimation && var1 != null?null:Friend.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method3739(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method1643();
            super.field676 = var3.modelHeight;
            if(super.graphic != -1 && super.field678 != -1) {
               Model var4 = class145.method2800(super.graphic).method3517(super.field678);
               if(var4 != null) {
                  var4.method1597(0, -super.field659, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field3011 == 1) {
               var3.field1409 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(LWidget;II)I",
      garbageValue = "-230287285"
   )
   static final int method748(Widget var0, int var1) {
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
                  var10 = FaceNormal.method1932(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class196.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var10.itemIds[var12] == var11 + 1) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class165.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class172.field2369[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class165.widgetSettings[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = Projectile.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class172.field2371[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = FaceNormal.method1932(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class196.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var10.itemIds[var12] == var11 + 1) {
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
                  var9 = class165.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class25.method560(var9);
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
                  var7 = (Projectile.localPlayer.x >> 7) + class119.baseX;
               }

               if(var6 == 19) {
                  var7 = class187.baseY + (Projectile.localPlayer.y >> 7);
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-583610041"
   )
   static int method749(int var0) {
      MessageNode var1 = (MessageNode)class47.field949.method2380((long)var0);
      return var1 == null?-1:(var1.previous == class47.field952.field1923?-1:((MessageNode)var1.previous).id);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static final void method750() {
      for(Projectile var0 = (Projectile)Client.projectiles.method2464(); var0 != null; var0 = (Projectile)Client.projectiles.method2472()) {
         if(Sequence.plane == var0.floor && Client.gameCycle <= var0.field894) {
            if(Client.gameCycle >= var0.startTime) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.method816(var1.x, var1.y, class103.method2025(var1.x, var1.y, var0.floor) - var0.field878, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var3 = -var0.interacting - 1;
                  Player var2;
                  if(var3 == Client.localInteractingIndex) {
                     var2 = Projectile.localPlayer;
                  } else {
                     var2 = Client.cachedPlayers[var3];
                  }

                  if(var2 != null && var2.x >= 0 && var2.x < 13312 && var2.y >= 0 && var2.y < 13312) {
                     var0.method816(var2.x, var2.y, class103.method2025(var2.x, var2.y, var0.floor) - var0.field878, Client.gameCycle);
                  }
               }

               var0.method823(Client.field511);
               CombatInfo1.region.method1747(Sequence.plane, (int)var0.x, (int)var0.velocityZ, (int)var0.z, 60, var0, var0.field895, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }
}
