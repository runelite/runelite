import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class47 {
   @ObfuscatedName("u")
   static String field927;
   @ObfuscatedName("g")
   static final class121 field928 = new class121(1024);
   @ObfuscatedName("x")
   static final class136 field929 = new class136();
   @ObfuscatedName("s")
   static byte[][][] field931;
   @ObfuscatedName("p")
   @Export("chatLineMap")
   static final Map chatLineMap = new HashMap();
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1813768389
   )
   static int field934 = 0;
   @ObfuscatedName("na")
   static class57 field935;

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "1507694347"
   )
   static final void method869(Actor var0) {
      var0.poseAnimation = var0.idlePoseAnimation;
      if(var0.field646 == 0) {
         var0.field627 = 0;
      } else {
         if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
            Sequence var1 = class146.getAnimation(var0.animation);
            if(var0.field651 > 0 && var1.precedenceAnimating == 0) {
               ++var0.field627;
               return;
            }

            if(var0.field651 <= 0 && var1.priority == 0) {
               ++var0.field627;
               return;
            }
         }

         int var10 = var0.x;
         int var2 = var0.y;
         int var3 = var0.pathX[var0.field646 - 1] * 128 + var0.field596 * 64;
         int var4 = var0.pathY[var0.field646 - 1] * 128 + var0.field596 * 64;
         if(var10 < var3) {
            if(var2 < var4) {
               var0.field643 = 1280;
            } else if(var2 > var4) {
               var0.field643 = 1792;
            } else {
               var0.field643 = 1536;
            }
         } else if(var10 > var3) {
            if(var2 < var4) {
               var0.field643 = 768;
            } else if(var2 > var4) {
               var0.field643 = 256;
            } else {
               var0.field643 = 512;
            }
         } else if(var2 < var4) {
            var0.field643 = 1024;
         } else if(var2 > var4) {
            var0.field643 = 0;
         }

         byte var5 = var0.field649[var0.field646 - 1];
         if(var3 - var10 <= 256 && var3 - var10 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            int var6 = var0.field643 - var0.angle & 2047;
            if(var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = var0.field601;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field600;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field603;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field602;
            }

            if(var7 == -1) {
               var7 = var0.field600;
            }

            var0.poseAnimation = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof NPC) {
               var9 = ((NPC)var0).composition.isClickable;
            }

            if(var9) {
               if(var0.field643 != var0.angle && var0.interacting == -1 && var0.field645 != 0) {
                  var8 = 2;
               }

               if(var0.field646 > 2) {
                  var8 = 6;
               }

               if(var0.field646 > 3) {
                  var8 = 8;
               }

               if(var0.field627 > 0 && var0.field646 > 1) {
                  var8 = 8;
                  --var0.field627;
               }
            } else {
               if(var0.field646 > 1) {
                  var8 = 6;
               }

               if(var0.field646 > 2) {
                  var8 = 8;
               }

               if(var0.field627 > 0 && var0.field646 > 1) {
                  var8 = 8;
                  --var0.field627;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.poseAnimation == var0.field600 && var0.field604 != -1) {
               var0.poseAnimation = var0.field604;
            }

            if(var10 != var3 || var2 != var4) {
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
               --var0.field646;
               if(var0.field651 > 0) {
                  --var0.field651;
               }
            }

         } else {
            var0.x = var3;
            var0.y = var4;
            --var0.field646;
            if(var0.field651 > 0) {
               --var0.field651;
            }

         }
      }
   }

   class47() throws Throwable {
      throw new Error();
   }
}
