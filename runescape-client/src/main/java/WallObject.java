import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("ab")
   @Export("authCode")
   static String authCode;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -941617951
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1029687505
   )
   @Export("config")
   int config;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1965593273
   )
   @Export("x")
   int x;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lef;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1758108003
   )
   @Export("y")
   int y;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 896642659
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lef;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2060967649
   )
   @Export("orientationA")
   int orientationA;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 610135463
   )
   @Export("orientationB")
   int orientationB;

   WallObject() {
      this.hash = 0;
      this.config = 0;
   }

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(Lca;B)V",
      garbageValue = "93"
   )
   static final void method2865(Actor var0) {
      var0.poseAnimation = var0.idlePoseAnimation;
      if(var0.queueSize == 0) {
         var0.field1272 = 0;
      } else {
         if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
            Sequence var1 = class112.getAnimation(var0.animation);
            if(var0.field1273 > 0 && var1.precedenceAnimating == 0) {
               ++var0.field1272;
               return;
            }

            if(var0.field1273 <= 0 && var1.priority == 0) {
               ++var0.field1272;
               return;
            }
         }

         int var10 = var0.x;
         int var2 = var0.y;
         int var3 = 128 * var0.pathX[var0.queueSize - 1] + var0.field1218 * 64;
         int var4 = var0.pathY[var0.queueSize - 1] * 128 + var0.field1218 * 64;
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

         byte var5 = var0.field1239[var0.queueSize - 1];
         if(var3 - var10 <= 256 && var3 - var10 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            int var6 = var0.orientation - var0.angle & 2047;
            if(var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = var0.field1223;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field1251;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field1225;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field1224;
            }

            if(var7 == -1) {
               var7 = var0.field1251;
            }

            var0.poseAnimation = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof NPC) {
               var9 = ((NPC)var0).composition.isClickable;
            }

            if(var9) {
               if(var0.orientation != var0.angle && var0.interacting == -1 && var0.field1267 != 0) {
                  var8 = 2;
               }

               if(var0.queueSize > 2) {
                  var8 = 6;
               }

               if(var0.queueSize > 3) {
                  var8 = 8;
               }

               if(var0.field1272 > 0 && var0.queueSize > 1) {
                  var8 = 8;
                  --var0.field1272;
               }
            } else {
               if(var0.queueSize > 1) {
                  var8 = 6;
               }

               if(var0.queueSize > 2) {
                  var8 = 8;
               }

               if(var0.field1272 > 0 && var0.queueSize > 1) {
                  var8 = 8;
                  --var0.field1272;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.poseAnimation == var0.field1251 && var0.field1221 != -1) {
               var0.poseAnimation = var0.field1221;
            }

            if(var3 != var10 || var4 != var2) {
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
               if(var0.field1273 > 0) {
                  --var0.field1273;
               }
            }

         } else {
            var0.x = var3;
            var0.y = var4;
            --var0.queueSize;
            if(var0.field1273 > 0) {
               --var0.field1273;
            }

         }
      }
   }
}
