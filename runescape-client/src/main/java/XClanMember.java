import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("m")
   String field892;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -875280239
   )
   @Export("world")
   int world;
   @ObfuscatedName("t")
   @Export("rank")
   byte rank;
   @ObfuscatedName("d")
   static int[] field897;
   @ObfuscatedName("p")
   @Export("username")
   String username;

   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "-39743135"
   )
   static final void method1096(Actor var0) {
      var0.poseAnimation = var0.idlePoseAnimation;
      if(var0.queueSize == 0) {
         var0.field1266 = 0;
      } else {
         if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
            Sequence var1 = GameEngine.getAnimation(var0.animation);
            if(var0.field1267 > 0 && var1.precedenceAnimating == 0) {
               ++var0.field1266;
               return;
            }

            if(var0.field1267 <= 0 && var1.priority == 0) {
               ++var0.field1266;
               return;
            }
         }

         int var10 = var0.x;
         int var2 = var0.y;
         int var3 = var0.field1212 * 64 + var0.pathX[var0.queueSize - 1] * 128;
         int var4 = var0.pathY[var0.queueSize - 1] * 128 + var0.field1212 * 64;
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

         byte var5 = var0.field1265[var0.queueSize - 1];
         if(var3 - var10 <= 256 && var3 - var10 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            int var6 = var0.orientation - var0.angle & 2047;
            if(var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = var0.field1217;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field1216;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field1219;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field1218;
            }

            if(var7 == -1) {
               var7 = var0.field1216;
            }

            var0.poseAnimation = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof NPC) {
               var9 = ((NPC)var0).composition.isClickable;
            }

            if(var9) {
               if(var0.angle != var0.orientation && var0.interacting == -1 && var0.field1227 != 0) {
                  var8 = 2;
               }

               if(var0.queueSize > 2) {
                  var8 = 6;
               }

               if(var0.queueSize > 3) {
                  var8 = 8;
               }

               if(var0.field1266 > 0 && var0.queueSize > 1) {
                  var8 = 8;
                  --var0.field1266;
               }
            } else {
               if(var0.queueSize > 1) {
                  var8 = 6;
               }

               if(var0.queueSize > 2) {
                  var8 = 8;
               }

               if(var0.field1266 > 0 && var0.queueSize > 1) {
                  var8 = 8;
                  --var0.field1266;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.poseAnimation == var0.field1216 && var0.field1220 != -1) {
               var0.poseAnimation = var0.field1220;
            }

            if(var3 != var10 || var2 != var4) {
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
               if(var0.field1267 > 0) {
                  --var0.field1267;
               }
            }

         } else {
            var0.x = var3;
            var0.y = var4;
            --var0.queueSize;
            if(var0.field1267 > 0) {
               --var0.field1267;
            }

         }
      }
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIZI)V",
      garbageValue = "-1821194273"
   )
   static void method1097(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var1 == var6.parentId) {
            Spotanim.method4223(var6, var2, var3, var4);
            class152.method2814(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class95.method1670(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "1588646295"
   )
   static SpritePixels method1098() {
      SpritePixels var0 = new SpritePixels();
      var0.maxWidth = class220.field2818;
      var0.maxHeight = class286.field3792;
      var0.offsetX = class286.field3793[0];
      var0.offsetY = class286.field3794[0];
      var0.width = class286.field3791[0];
      var0.height = class149.field2211[0];
      int var1 = var0.width * var0.height;
      byte[] var2 = class286.field3797[0];
      var0.image = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.image[var3] = class116.field1686[var2[var3] & 255];
      }

      class286.field3793 = null;
      class286.field3794 = null;
      class286.field3791 = null;
      class149.field2211 = null;
      class116.field1686 = null;
      class286.field3797 = null;
      return var0;
   }
}
