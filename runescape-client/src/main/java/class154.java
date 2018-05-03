import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
public class class154 extends class297 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1073141019
   )
   static int field2123;
   @ObfuscatedName("g")
   final boolean field2124;

   public class154(boolean var1) {
      this.field2124 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lku;Lku;I)I",
      garbageValue = "1393767066"
   )
   int method3225(ChatPlayer var1, ChatPlayer var2) {
      if(var1.world != 0) {
         if(var2.world == 0) {
            return this.field2124?-1:1;
         }
      } else if(var2.world != 0) {
         return this.field2124?1:-1;
      }

      return this.method5341(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3225((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(Lbm;B)V",
      garbageValue = "45"
   )
   static final void method3229(Actor var0) {
      var0.poseAnimation = var0.idlePoseAnimation;
      if(var0.queueSize == 0) {
         var0.field1192 = 0;
      } else {
         if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
            Sequence var1 = NPC.getAnimation(var0.animation);
            if(var0.field1178 > 0 && var1.precedenceAnimating == 0) {
               ++var0.field1192;
               return;
            }

            if(var0.field1178 <= 0 && var1.priority == 0) {
               ++var0.field1192;
               return;
            }
         }

         int var10 = var0.x;
         int var2 = var0.y;
         int var3 = var0.pathX[var0.queueSize - 1] * 128 + var0.field1143 * 64;
         int var4 = var0.pathY[var0.queueSize - 1] * 128 + var0.field1143 * 64;
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

            int var7 = var0.field1149;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field1148;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field1180;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field1150;
            }

            if(var7 == -1) {
               var7 = var0.field1148;
            }

            var0.poseAnimation = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof NPC) {
               var9 = ((NPC)var0).composition.isClickable;
            }

            if(var9) {
               if(var0.orientation != var0.angle && var0.interacting == -1 && var0.field1193 != 0) {
                  var8 = 2;
               }

               if(var0.queueSize > 2) {
                  var8 = 6;
               }

               if(var0.queueSize > 3) {
                  var8 = 8;
               }

               if(var0.field1192 > 0 && var0.queueSize > 1) {
                  var8 = 8;
                  --var0.field1192;
               }
            } else {
               if(var0.queueSize > 1) {
                  var8 = 6;
               }

               if(var0.queueSize > 2) {
                  var8 = 8;
               }

               if(var0.field1192 > 0 && var0.queueSize > 1) {
                  var8 = 8;
                  --var0.field1192;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.poseAnimation == var0.field1148 && var0.field1152 != -1) {
               var0.poseAnimation = var0.field1152;
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
               if(var0.field1178 > 0) {
                  --var0.field1178;
               }
            }

         } else {
            var0.x = var3;
            var0.y = var4;
            --var0.queueSize;
            if(var0.field1178 > 0) {
               --var0.field1178;
            }

         }
      }
   }
}
