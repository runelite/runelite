import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
@Implements("MilliTimer")
public class MilliTimer extends Timer {
   @ObfuscatedName("d")
   long[] field2124;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 933253185
   )
   int field2119;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1552796435
   )
   @Export("sleepTime")
   int sleepTime;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = -4331112901013839183L
   )
   @Export("milliTime")
   long milliTime;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -525968403
   )
   int field2122;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1379742535
   )
   int field2121;

   MilliTimer() {
      this.field2124 = new long[10];
      this.field2119 = 256;
      this.sleepTime = 1;
      this.field2122 = 0;
      this.milliTime = ServerPacket.currentTimeMs();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2124[var1] = this.milliTime;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1539441859"
   )
   public void vmethod3107() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2124[var1] = 0L;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1446056543"
   )
   public int vmethod3108(int var1, int var2) {
      int var3 = this.field2119;
      int var4 = this.sleepTime;
      this.field2119 = 300;
      this.sleepTime = 1;
      this.milliTime = ServerPacket.currentTimeMs();
      if(this.field2124[this.field2121] == 0L) {
         this.field2119 = var3;
         this.sleepTime = var4;
      } else if(this.milliTime > this.field2124[this.field2121]) {
         this.field2119 = (int)((long)(var1 * 2560) / (this.milliTime - this.field2124[this.field2121]));
      }

      if(this.field2119 < 25) {
         this.field2119 = 25;
      }

      if(this.field2119 > 256) {
         this.field2119 = 256;
         this.sleepTime = (int)((long)var1 - (this.milliTime - this.field2124[this.field2121]) / 10L);
      }

      if(this.sleepTime > var1) {
         this.sleepTime = var1;
      }

      this.field2124[this.field2121] = this.milliTime;
      this.field2121 = (this.field2121 + 1) % 10;
      int var5;
      if(this.sleepTime > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2124[var5]) {
               this.field2124[var5] += (long)this.sleepTime;
            }
         }
      }

      if(this.sleepTime < var2) {
         this.sleepTime = var2;
      }

      BaseVarType.method12((long)this.sleepTime);

      for(var5 = 0; this.field2122 < 256; this.field2122 += this.field2119) {
         ++var5;
      }

      this.field2122 &= 255;
      return var5;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)Lhx;",
      garbageValue = "-436183058"
   )
   public static Widget method3058(int var0, int var1) {
      Widget var2 = class87.method1762(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public static void method3053() {
      try {
         if(class210.field2598 == 1) {
            int var0 = class210.field2595.method3903();
            if(var0 > 0 && class210.field2595.method3948()) {
               var0 -= class164.field2216;
               if(var0 < 0) {
                  var0 = 0;
               }

               class210.field2595.method3857(var0);
               return;
            }

            class210.field2595.method3863();
            class210.field2595.method3907();
            if(class3.field22 != null) {
               class210.field2598 = 2;
            } else {
               class210.field2598 = 0;
            }

            class182.field2513 = null;
            class87.field1316 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class210.field2595.method3863();
         class210.field2598 = 0;
         class182.field2513 = null;
         class87.field1316 = null;
         class3.field22 = null;
      }

   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(Lby;I)V",
      garbageValue = "-1955704550"
   )
   static final void method3055(Actor var0) {
      var0.field1201 = false;
      Sequence var1;
      if(var0.poseAnimation != -1) {
         var1 = class13.getAnimation(var0.poseAnimation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.field1146;
            if(var0.poseFrame < var1.frameIDs.length && var0.field1146 > var1.frameLenghts[var0.poseFrame]) {
               var0.field1146 = 1;
               ++var0.poseFrame;
               class86.method1752(var1, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var1.frameIDs.length) {
               var0.field1146 = 0;
               var0.poseFrame = 0;
               class86.method1752(var1, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.graphicsDelay) {
         if(var0.field1184 < 0) {
            var0.field1184 = 0;
         }

         int var3 = class227.getSpotAnimType(var0.graphic).field3393;
         if(var3 != -1) {
            Sequence var2 = class13.getAnimation(var3);
            if(var2 != null && var2.frameIDs != null) {
               ++var0.field1185;
               if(var0.field1184 < var2.frameIDs.length && var0.field1185 > var2.frameLenghts[var0.field1184]) {
                  var0.field1185 = 1;
                  ++var0.field1184;
                  class86.method1752(var2, var0.field1184, var0.x, var0.y);
               }

               if(var0.field1184 >= var2.frameIDs.length && (var0.field1184 < 0 || var0.field1184 >= var2.frameIDs.length)) {
                  var0.graphic = -1;
               }
            } else {
               var0.graphic = -1;
            }
         } else {
            var0.graphic = -1;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable <= 1) {
         var1 = class13.getAnimation(var0.animation);
         if(var1.precedenceAnimating == 1 && var0.field1159 > 0 && var0.field1176 <= Client.gameCycle && var0.field1193 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var1 = class13.getAnimation(var0.animation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.field1180;
            if(var0.actionFrame < var1.frameIDs.length && var0.field1180 > var1.frameLenghts[var0.actionFrame]) {
               var0.field1180 = 1;
               ++var0.actionFrame;
               class86.method1752(var1, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var1.frameIDs.length) {
               var0.actionFrame -= var1.frameStep;
               ++var0.field1182;
               if(var0.field1182 >= var1.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var1.frameIDs.length) {
                  class86.method1752(var1, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field1201 = var1.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "25"
   )
   static final void method3057(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(ISAACCipher.loadWidget(var0)) {
         class149.field2108 = null;
         class231.gameDraw(class11.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class149.field2108 != null) {
            class231.gameDraw(class149.field2108, -1412584499, var1, var2, var3, var4, MouseInput.field712, class31.field422, var7);
            class149.field2108 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field1059[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field1059[var8] = true;
            }
         }

      }
   }
}
