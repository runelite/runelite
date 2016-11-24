import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1325552057
   )
   int field243;
   @ObfuscatedName("d")
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1771947245
   )
   int field245;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1381212041
   )
   int field246 = -1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1320258915
   )
   int field247;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -711119153
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1069248393
   )
   int field249;
   @ObfuscatedName("r")
   @Export("actions")
   String[] actions = new String[3];
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1954105247
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1524998829
   )
   int field252;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1571977589
   )
   int field253;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1002059397
   )
   int field254;
   @ObfuscatedName("x")
   @Export("model")
   Model model;
   @ObfuscatedName("n")
   @Export("name")
   String name;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 649327507
   )
   int field257;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1687595919
   )
   int field258;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1111011517
   )
   int field259 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1025124757
   )
   int field260;
   @ObfuscatedName("a")
   boolean field261;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1594551405
   )
   @Export("team")
   int team;
   @ObfuscatedName("j")
   boolean field263;
   @ObfuscatedName("u")
   boolean field264;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1229764485
   )
   int field265;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 376585505
   )
   int field266;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 343416585
   )
   int field267;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 516731807
   )
   int field268;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-729568845"
   )
   final void method230(Buffer var1) {
      var1.offset = 0;
      int var2 = var1.method3033();
      this.field259 = var1.method3047();
      this.field246 = var1.method3047();
      int var3 = -1;
      this.team = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var5 = 0; var5 < 12; ++var5) {
         var6 = var1.method3033();
         if(var6 == 0) {
            var4[var5] = 0;
         } else {
            var7 = var1.method3033();
            var4[var5] = (var6 << 8) + var7;
            if(var5 == 0 && var4[0] == '\uffff') {
               var3 = var1.method3097();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = class18.getItemDefinition(var4[var5] - 512).field2986;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.method3033();
         if(var7 < 0 || var7 >= class116.field1823[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.method3097();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field601 = var1.method3097();
      if(super.field601 == '\uffff') {
         super.field601 = -1;
      }

      super.field604 = super.field601;
      super.field603 = var1.method3097();
      if(super.field603 == '\uffff') {
         super.field603 = -1;
      }

      super.field650 = var1.method3097();
      if(super.field650 == '\uffff') {
         super.field650 = -1;
      }

      super.field605 = var1.method3097();
      if(super.field605 == '\uffff') {
         super.field605 = -1;
      }

      super.field606 = var1.method3097();
      if(super.field606 == '\uffff') {
         super.field606 = -1;
      }

      super.field630 = var1.method3097();
      if(super.field630 == '\uffff') {
         super.field630 = -1;
      }

      this.name = var1.method3057();
      if(class40.localPlayer == this) {
         class101.field1644 = this.name;
      }

      this.combatLevel = var1.method3033();
      this.field249 = var1.method3097();
      this.field263 = var1.method3033() == 1;
      if(Client.field443 == 0 && Client.field503 >= 2) {
         this.field263 = false;
      }

      if(null == this.composition) {
         this.composition = new PlayerComposition();
      }

      this.composition.method2794(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "1672156994"
   )
   protected final Model getModel() {
      if(null == this.composition) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class9.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && !this.field261 && (super.poseAnimation != super.idlePoseAnimation || null == var1)?class9.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method2799(var1, super.actionFrame, var2, super.poseFrame);
         if(null == var3) {
            return null;
         } else {
            var3.method1584();
            super.field621 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field261 && super.graphic != -1 && super.field633 != -1) {
               var4 = class179.method3320(super.graphic).method3510(super.field633);
               if(var4 != null) {
                  var4.method1588(0, -super.field636, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field261 && null != this.model) {
               if(Client.gameCycle >= this.field252) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.totalLevel && Client.gameCycle < this.field252) {
                  var4 = this.model;
                  var4.method1588(this.field253 - super.x, this.field254 - this.field243, this.field257 - super.y);
                  if(super.field646 == 512) {
                     var4.method1590();
                     var4.method1590();
                     var4.method1590();
                  } else if(super.field646 == 1024) {
                     var4.method1590();
                     var4.method1590();
                  } else if(super.field646 == 1536) {
                     var4.method1590();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.field646 == 512) {
                     var4.method1590();
                  } else if(super.field646 == 1024) {
                     var4.method1590();
                     var4.method1590();
                  } else if(super.field646 == 1536) {
                     var4.method1590();
                     var4.method1590();
                     var4.method1590();
                  }

                  var4.method1588(super.x - this.field253, this.field243 - this.field254, super.y - this.field257);
               }
            }

            var3.field1399 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "-75"
   )
   final void method233(int var1, int var2, byte var3) {
      if(super.animation != -1 && class9.getAnimation(super.animation).field3062 == 1) {
         super.animation = -1;
      }

      super.field623 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               class101.method1988(this, var1, var2, (byte)2);
            }

            this.method235(var1, var2, var3);
         } else {
            this.method234(var1, var2);
         }
      } else {
         this.method234(var1, var2);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2136218319"
   )
   void method234(int var1, int var2) {
      super.field649 = 0;
      super.field654 = 0;
      super.field634 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.method240();
      super.x = 128 * super.pathX[0] + 64 * var3;
      super.y = 128 * super.pathY[0] + 64 * var3;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-1752023462"
   )
   final void method235(int var1, int var2, byte var3) {
      if(super.field649 < 9) {
         ++super.field649;
      }

      for(int var4 = super.field649; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field625[var4] = super.field625[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field625[0] = var3;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1389298352"
   )
   final boolean vmethod746() {
      return null != this.composition;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "109"
   )
   int method240() {
      return this.composition != null && this.composition.field2035 != -1?class152.getNpcDefinition(this.composition.field2035).field3009:1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIIIIII)V",
      garbageValue = "-1686105627"
   )
   static final void method255(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class11.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.method3033();
            if(var7 == 0) {
               if(var1 == 0) {
                  int[] var8 = class11.tileHeights[0][var2];
                  int var11 = 932731 + var2 + var4;
                  int var12 = 556238 + var3 + var5;
                  int var13 = class48.method891('넵' + var11, var12 + 91923, 4) - 128 + (class48.method891(10294 + var11, var12 + '鎽', 2) - 128 >> 1) + (class48.method891(var11, var12, 1) - 128 >> 2);
                  var13 = 35 + (int)((double)var13 * 0.3D);
                  if(var13 < 10) {
                     var13 = 10;
                  } else if(var13 > 60) {
                     var13 = 60;
                  }

                  var8[var3] = 8 * -var13;
               } else {
                  class11.tileHeights[var1][var2][var3] = class11.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var14 = var0.method3033();
               if(var14 == 1) {
                  var14 = 0;
               }

               if(var1 == 0) {
                  class11.tileHeights[0][var2][var3] = 8 * -var14;
               } else {
                  class11.tileHeights[var1][var2][var3] = class11.tileHeights[var1 - 1][var2][var3] - var14 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class11.field106[var1][var2][var3] = var0.method3047();
               class38.field797[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class11.field107[var1][var2][var3] = (byte)(var6 + (var7 - 2) & 3);
            } else if(var7 <= 81) {
               class11.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class11.field105[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.method3033();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.method3033();
               break;
            }

            if(var7 <= 49) {
               var0.method3033();
            }
         }
      }

   }

   Player() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.field249 = 0;
      this.totalLevel = 0;
      this.field252 = 0;
      this.field261 = false;
      this.team = 0;
      this.field263 = false;
      this.field264 = false;
   }
}
