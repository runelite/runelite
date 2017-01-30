import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("h")
   static int[] field759;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 395775309
   )
   static int field761;
   @ObfuscatedName("p")
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "2063755858"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class146.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && (super.idlePoseAnimation != super.poseAnimation || null == var1)?class146.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method3707(var1, super.actionFrame, var2, super.poseFrame);
         if(null == var3) {
            return null;
         } else {
            var3.method1602();
            super.field642 = var3.modelHeight;
            if(super.graphic != -1 && super.field630 != -1) {
               Model var4 = TextureProvider.method1452(super.graphic).method3456(super.field630);
               if(null != var4) {
                  var4.method1590(0, -super.field633, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field2999 == 1) {
               var3.field1380 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "-1810094731"
   )
   final void method700(int var1, int var2, boolean var3) {
      if(super.animation != -1 && class146.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field646 < 9) {
               ++super.field646;
            }

            for(int var6 = super.field646; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.field649[var6] = super.field649[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field649[0] = 1;
            return;
         }
      }

      super.field646 = 0;
      super.field651 = 0;
      super.field627 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.pathX[0] * 128 + super.field596 * 64;
      super.y = 128 * super.pathY[0] + super.field596 * 64;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass159;I)I",
      garbageValue = "1380357929"
   )
   static int method701(class159 var0) {
      int var1 = var0.method3061(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method3061(5);
      } else if(var1 == 2) {
         var2 = var0.method3061(8);
      } else {
         var2 = var0.method3061(11);
      }

      return var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-94"
   )
   final boolean vmethod702() {
      return null != this.composition;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "1587633550"
   )
   public static char method706(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      if(var0 == 338) {
         return 'O';
      } else if(var0 == 339) {
         return 'o';
      } else if(var0 == 376) {
         return 'Y';
      } else {
         return var0;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "1338978079"
   )
   final void method710(int var1, byte var2) {
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

      if(super.animation != -1 && class146.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(super.field646 < 9) {
         ++super.field646;
      }

      for(int var5 = super.field646; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field649[var5] = super.field649[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field649[0] = var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1612891490"
   )
   public static void method713() {
      class105 var0 = class105.keyboard;
      synchronized(class105.keyboard) {
         ++class105.keyboardIdleTicks;
         class105.field1701 = class105.field1718;
         class105.field1715 = 0;
         int var1;
         if(class105.field1711 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               class105.field1708[var1] = false;
            }

            class105.field1711 = class105.field1710;
         } else {
            while(class105.field1710 != class105.field1711) {
               var1 = class105.field1719[class105.field1710];
               class105.field1710 = class105.field1710 + 1 & 127;
               if(var1 < 0) {
                  class105.field1708[~var1] = false;
               } else {
                  if(!class105.field1708[var1] && class105.field1715 < class105.field1714.length - 1) {
                     class105.field1714[++class105.field1715 - 1] = var1;
                  }

                  class105.field1708[var1] = true;
               }
            }
         }

         class105.field1718 = class105.field1717;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZI)V",
      garbageValue = "359698120"
   )
   public static void method714(String var0, boolean var1, boolean var2) {
      RSCanvas.method2079(var0, var1, "openjs", var2);
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1778159098"
   )
   static final void method717(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field480; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field482[var4] = true;
         }
      }

   }
}
