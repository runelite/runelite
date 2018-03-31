import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljo;"
   )
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   @Export("combatInfo1")
   CombatInfoList combatInfo1;

   @ObfuscatedSignature(
      signature = "(Ljo;)V"
   )
   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo1 = new CombatInfoList();
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-266560985"
   )
   void method1818(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.last(); var7 != null; var7 = (CombatInfo1)this.combatInfo1.previous()) {
         ++var6;
         if(var7.cycle == var1) {
            var7.set(var1, var2, var3, var4);
            return;
         }

         if(var7.cycle <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.addLast(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method3986(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.last().unlink();
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lbd;",
      garbageValue = "445097597"
   )
   CombatInfo1 method1811(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.last();
      if(var2 != null && var2.cycle <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.previous(); var3 != null && var3.cycle <= var1; var3 = (CombatInfo1)this.combatInfo1.previous()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field3524 + var2.int2 + var2.cycle > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-17630"
   )
   boolean method1810() {
      return this.combatInfo1.isEmpty();
   }

   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      signature = "(Lbg;I)V",
      garbageValue = "666301995"
   )
   static final void method1823(Actor var0) {
      var0.poseAnimation = var0.idlePoseAnimation;
      if(var0.queueSize == 0) {
         var0.field1208 = 0;
      } else {
         if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
            Sequence var1 = ISAACCipher.getAnimation(var0.animation);
            if(var0.field1194 > 0 && var1.precedenceAnimating == 0) {
               ++var0.field1208;
               return;
            }

            if(var0.field1194 <= 0 && var1.priority == 0) {
               ++var0.field1208;
               return;
            }
         }

         int var10 = var0.x;
         int var2 = var0.y;
         int var3 = var0.pathX[var0.queueSize - 1] * 128 + var0.field1153 * 64;
         int var4 = var0.pathY[var0.queueSize - 1] * 128 + var0.field1153 * 64;
         if(var10 < var3) {
            if(var2 < var4) {
               var0.orientation = 1280;
            } else if(var2 > var4) {
               var0.orientation = 1792;
            } else {
               var0.orientation = 1536;
            }
         } else if(var10 > var3) {
            if(var2 < var4) {
               var0.orientation = 768;
            } else if(var2 > var4) {
               var0.orientation = 256;
            } else {
               var0.orientation = 512;
            }
         } else if(var2 < var4) {
            var0.orientation = 1024;
         } else if(var2 > var4) {
            var0.orientation = 0;
         }

         byte var5 = var0.pathTraversed[var0.queueSize - 1];
         if(var3 - var10 <= 256 && var3 - var10 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            int var6 = var0.orientation - var0.angle & 2047;
            if(var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = var0.field1172;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field1158;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field1161;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field1160;
            }

            if(var7 == -1) {
               var7 = var0.field1158;
            }

            var0.poseAnimation = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof NPC) {
               var9 = ((NPC)var0).composition.isClickable;
            }

            if(var9) {
               if(var0.angle != var0.orientation && var0.interacting == -1 && var0.field1203 != 0) {
                  var8 = 2;
               }

               if(var0.queueSize > 2) {
                  var8 = 6;
               }

               if(var0.queueSize > 3) {
                  var8 = 8;
               }

               if(var0.field1208 > 0 && var0.queueSize > 1) {
                  var8 = 8;
                  --var0.field1208;
               }
            } else {
               if(var0.queueSize > 1) {
                  var8 = 6;
               }

               if(var0.queueSize > 2) {
                  var8 = 8;
               }

               if(var0.field1208 > 0 && var0.queueSize > 1) {
                  var8 = 8;
                  --var0.field1208;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.poseAnimation == var0.field1158 && var0.field1162 != -1) {
               var0.poseAnimation = var0.field1162;
            }

            if(var10 != var3 || var4 != var2) {
               if(var10 < var3) {
                  var0.x += var8;
                  if(var0.x > var3) {
                     var0.x = var3;
                  }
               } else if(var10 > var3) {
                  var0.x -= var8;
                  if(var0.x < var3) {
                     var0.x = var3;
                  }
               }

               if(var2 < var4) {
                  var0.y += var8;
                  if(var0.y > var4) {
                     var0.y = var4;
                  }
               } else if(var2 > var4) {
                  var0.y -= var8;
                  if(var0.y < var4) {
                     var0.y = var4;
                  }
               }
            }

            if(var3 == var0.x && var4 == var0.y) {
               --var0.queueSize;
               if(var0.field1194 > 0) {
                  --var0.field1194;
               }
            }

         } else {
            var0.x = var3;
            var0.y = var4;
            --var0.queueSize;
            if(var0.field1194 > 0) {
               --var0.field1194;
            }

         }
      }
   }
}
