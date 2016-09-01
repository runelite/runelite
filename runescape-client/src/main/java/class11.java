import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
public class class11 {
   @ObfuscatedName("r")
   static final class201 field164 = new class201(1024);
   @ObfuscatedName("j")
   static final class203 field165 = new class203();
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1194101273
   )
   static int field166 = 0;
   @ObfuscatedName("i")
   public static class170 field169;
   @ObfuscatedName("jz")
   static Widget[] field170;
   @ObfuscatedName("x")
   @Export("chatLineMap")
   static final Map chatLineMap = new HashMap();

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "-358128559"
   )
   static final void method145(Actor var0) {
      var0.poseAnimation = var0.idlePoseAnimation;
      if(var0.field871 == 0) {
         var0.field875 = 0;
      } else {
         if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
            Sequence var1 = class113.getAnimation(var0.animation);
            if(var0.field822 > 0 && var1.precedenceAnimating == 0) {
               ++var0.field875;
               return;
            }

            if(var0.field822 <= 0 && var1.field1009 == 0) {
               ++var0.field875;
               return;
            }
         }

         int var10 = var0.x;
         int var2 = var0.y;
         int var3 = var0.field821 * 64 + var0.pathX[var0.field871 - 1] * 128;
         int var4 = 128 * var0.pathY[var0.field871 - 1] + var0.field821 * 64;
         if(var10 < var3) {
            if(var2 < var4) {
               var0.field835 = 1280;
            } else if(var2 > var4) {
               var0.field835 = 1792;
            } else {
               var0.field835 = 1536;
            }
         } else if(var10 > var3) {
            if(var2 < var4) {
               var0.field835 = 768;
            } else if(var2 > var4) {
               var0.field835 = 256;
            } else {
               var0.field835 = 512;
            }
         } else if(var2 < var4) {
            var0.field835 = 1024;
         } else if(var2 > var4) {
            var0.field835 = 0;
         }

         byte var5 = var0.field830[var0.field871 - 1];
         if(var3 - var10 <= 256 && var3 - var10 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            int var6 = var0.field835 - var0.angle & 2047;
            if(var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = var0.field826;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field825;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field869;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field827;
            }

            if(var7 == -1) {
               var7 = var0.field825;
            }

            var0.poseAnimation = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof NPC) {
               var9 = ((NPC)var0).composition.isClickable;
            }

            if(var9) {
               if(var0.field835 != var0.angle && var0.interacting == -1 && var0.field870 != 0) {
                  var8 = 2;
               }

               if(var0.field871 > 2) {
                  var8 = 6;
               }

               if(var0.field871 > 3) {
                  var8 = 8;
               }

               if(var0.field875 > 0 && var0.field871 > 1) {
                  var8 = 8;
                  --var0.field875;
               }
            } else {
               if(var0.field871 > 1) {
                  var8 = 6;
               }

               if(var0.field871 > 2) {
                  var8 = 8;
               }

               if(var0.field875 > 0 && var0.field871 > 1) {
                  var8 = 8;
                  --var0.field875;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.poseAnimation == var0.field825 && var0.field829 != -1) {
               var0.poseAnimation = var0.field829;
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

            if(var3 == var0.x && var0.y == var4) {
               --var0.field871;
               if(var0.field822 > 0) {
                  --var0.field822;
               }
            }

         } else {
            var0.x = var3;
            var0.y = var4;
            --var0.field871;
            if(var0.field822 > 0) {
               --var0.field822;
            }

         }
      }
   }
}
