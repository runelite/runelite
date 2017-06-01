import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("i")
   @Export("composition")
   NPCComposition composition;
   @ObfuscatedName("rm")
   static IndexFile field1398;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "-1595441038"
   )
   final void method1682(int var1, byte var2) {
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

      if(super.animation != -1 && class227.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(super.field1263 < 9) {
         ++super.field1263;
      }

      for(int var5 = super.field1263; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field1257[var5] = super.field1257[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field1257[0] = var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "-33"
   )
   final void method1683(int var1, int var2, boolean var3) {
      if(super.animation != -1 && class227.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field1263 < 9) {
               ++super.field1263;
            }

            for(int var6 = super.field1263; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.field1257[var6] = super.field1257[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field1257[0] = 1;
            return;
         }
      }

      super.field1263 = 0;
      super.field1301 = 0;
      super.field1300 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.pathX[0] * 128 + super.field1268 * 64;
      super.y = super.field1268 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "2096882887"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class227.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || super.poseAnimation == super.idlePoseAnimation && var1 != null?null:class227.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method4646(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2496();
            super.field1292 = var3.modelHeight;
            if(super.graphic != -1 && super.field1280 != -1) {
               Model var4 = CombatInfo1.method1542(super.graphic).method4341(super.field1280);
               if(var4 != null) {
                  var4.method2513(0, -super.field1302, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field3577 == 1) {
               var3.field1987 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-147112920"
   )
   static void method1686() {
      if(WorldMapType3.loadWorlds()) {
         class92.worldSelectShown = true;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1062114685"
   )
   static int method1690(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      int var6;
      if(var0 == 3400) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class253 var5 = Buffer.method3345(var3);
         if(var5.field3400 != 115) {
            ;
         }

         for(var6 = 0; var6 < var5.field3397; ++var6) {
            if(var4 == var5.field3403[var6]) {
               class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var5.field3405[var6];
               var5 = null;
               break;
            }
         }

         if(var5 != null) {
            class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var5.field3396;
         }

         return 1;
      } else if(var0 != 3408) {
         return 2;
      } else {
         class83.intStackSize -= 4;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         int var9 = class83.intStack[class83.intStackSize + 2];
         var6 = class83.intStack[class83.intStackSize + 3];
         class253 var7 = Buffer.method3345(var9);
         if(var7.field3398 == var3 && var7.field3400 == var4) {
            for(int var8 = 0; var8 < var7.field3397; ++var8) {
               if(var6 == var7.field3403[var8]) {
                  if(var4 == 115) {
                     class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var7.field3405[var8];
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = var7.field3404[var8];
                  }

                  var7 = null;
                  break;
               }
            }

            if(var7 != null) {
               if(var4 == 115) {
                  class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var7.field3396;
               } else {
                  class83.intStack[++class83.intStackSize - 1] = var7.field3401;
               }
            }

            return 1;
         } else {
            if(var4 == 115) {
               class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "null";
            } else {
               class83.intStack[++class83.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2030762499"
   )
   final boolean vmethod1691() {
      return this.composition != null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LGameEngine;I)V",
      garbageValue = "-896456131"
   )
   static void method1692(GameEngine var0) {
      if(class59.field732 == 1 || !class233.field3202 && class59.field732 == 4) {
         int var1 = class92.field1459 + 280;
         if(class59.field745 >= var1 && class59.field745 <= var1 + 14 && class59.field750 >= 4 && class59.field750 <= 18) {
            WorldMapType3.method200(0, 0);
            return;
         }

         if(class59.field745 >= var1 + 15 && class59.field745 <= var1 + 80 && class59.field750 >= 4 && class59.field750 <= 18) {
            WorldMapType3.method200(0, 1);
            return;
         }

         int var2 = class92.field1459 + 390;
         if(class59.field745 >= var2 && class59.field745 <= var2 + 14 && class59.field750 >= 4 && class59.field750 <= 18) {
            WorldMapType3.method200(1, 0);
            return;
         }

         if(class59.field745 >= var2 + 15 && class59.field745 <= var2 + 80 && class59.field750 >= 4 && class59.field750 <= 18) {
            WorldMapType3.method200(1, 1);
            return;
         }

         int var3 = class92.field1459 + 500;
         if(class59.field745 >= var3 && class59.field745 <= var3 + 14 && class59.field750 >= 4 && class59.field750 <= 18) {
            WorldMapType3.method200(2, 0);
            return;
         }

         if(class59.field745 >= var3 + 15 && class59.field745 <= var3 + 80 && class59.field750 >= 4 && class59.field750 <= 18) {
            WorldMapType3.method200(2, 1);
            return;
         }

         int var4 = class92.field1459 + 610;
         if(class59.field745 >= var4 && class59.field745 <= var4 + 14 && class59.field750 >= 4 && class59.field750 <= 18) {
            WorldMapType3.method200(3, 0);
            return;
         }

         if(class59.field745 >= var4 + 15 && class59.field745 <= var4 + 80 && class59.field750 >= 4 && class59.field750 <= 18) {
            WorldMapType3.method200(3, 1);
            return;
         }

         if(class59.field745 >= class92.field1459 + 708 && class59.field750 >= 4 && class59.field745 <= class92.field1459 + 708 + 50 && class59.field750 <= 20) {
            class92.worldSelectShown = false;
            class33.field474.method5045(class92.field1459, 0);
            class211.field2609.method5045(class92.field1459 + 382, 0);
            class92.field1457.method5017(class92.field1459 + 382 - class92.field1457.originalWidth / 2, 18);
            return;
         }

         if(class92.field1469 != -1) {
            World var5 = World.worldList[class92.field1469];
            class22.method153(var5);
            class92.worldSelectShown = false;
            class33.field474.method5045(class92.field1459, 0);
            class211.field2609.method5045(class92.field1459 + 382, 0);
            class92.field1457.method5017(class92.field1459 + 382 - class92.field1457.originalWidth / 2, 18);
            return;
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1534365715"
   )
   static int method1693(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class83.intStack[--class83.intStackSize];
         var4 = WorldMapType3.method199(var3);
      } else {
         var4 = var2?class232.field3187:class2.field15;
      }

      if(var0 == 1000) {
         class83.intStackSize -= 4;
         var4.originalX = class83.intStack[class83.intStackSize];
         var4.originalY = class83.intStack[class83.intStackSize + 1];
         var4.field2656 = class83.intStack[class83.intStackSize + 2];
         var4.field2643 = class83.intStack[class83.intStackSize + 3];
         class25.method169(var4);
         Client.field1214.method1370(var4);
         if(var3 != -1 && var4.type == 0) {
            class236.method4216(CombatInfo1.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class83.intStackSize -= 4;
         var4.originalWidth = class83.intStack[class83.intStackSize];
         var4.field2640 = class83.intStack[class83.intStackSize + 1];
         var4.field2658 = class83.intStack[class83.intStackSize + 2];
         var4.field2659 = class83.intStack[class83.intStackSize + 3];
         class25.method169(var4);
         Client.field1214.method1370(var4);
         if(var3 != -1 && var4.type == 0) {
            class236.method4216(CombatInfo1.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class83.intStack[--class83.intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            class25.method169(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.field2784 = class83.intStack[--class83.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2763 = class83.intStack[--class83.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;IB)Z",
      garbageValue = "93"
   )
   public static boolean method1694(IndexDataBase var0, int var1) {
      byte[] var2 = var0.method4115(var1);
      if(var2 == null) {
         return false;
      } else {
         class31.method262(var2);
         return true;
      }
   }
}
