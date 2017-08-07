import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
public class class245 extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   static NodeCache field3314;
   @ObfuscatedName("g")
   public boolean field3308;

   static {
      field3314 = new NodeCache(64);
   }

   class245() {
      this.field3308 = false;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfh;IB)V",
      garbageValue = "18"
   )
   void method4322(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3308 = true;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfh;B)V",
      garbageValue = "3"
   )
   void method4326(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4322(var1, var2);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)I",
      garbageValue = "0"
   )
   @Export("parseInt")
   public static int parseInt(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-1727293179"
   )
   public static int method4332(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(Lcp;B)V",
      garbageValue = "-108"
   )
   static final void method4333(Actor var0) {
      var0.field1208 = false;
      Sequence var1;
      if(var0.poseAnimation != -1) {
         var1 = Ignore.getAnimation(var0.poseAnimation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.field1236;
            if(var0.poseFrame < var1.frameIDs.length && var0.field1236 > var1.frameLenghts[var0.poseFrame]) {
               var0.field1236 = 1;
               ++var0.poseFrame;
               class2.method1(var1, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var1.frameIDs.length) {
               var0.field1236 = 0;
               var0.poseFrame = 0;
               class2.method1(var1, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.graphicsDelay) {
         if(var0.field1209 < 0) {
            var0.field1209 = 0;
         }

         int var3 = GameEngine.getSpotAnimType(var0.graphic).field3331;
         if(var3 != -1) {
            Sequence var2 = Ignore.getAnimation(var3);
            if(var2 != null && var2.frameIDs != null) {
               ++var0.field1244;
               if(var0.field1209 < var2.frameIDs.length && var0.field1244 > var2.frameLenghts[var0.field1209]) {
                  var0.field1244 = 1;
                  ++var0.field1209;
                  class2.method1(var2, var0.field1209, var0.x, var0.y);
               }

               if(var0.field1209 >= var2.frameIDs.length && (var0.field1209 < 0 || var0.field1209 >= var2.frameIDs.length)) {
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
         var1 = Ignore.getAnimation(var0.animation);
         if(var1.precedenceAnimating == 1 && var0.field1264 > 0 && var0.field1238 <= Client.gameCycle && var0.field1252 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var1 = Ignore.getAnimation(var0.animation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.field1239;
            if(var0.actionFrame < var1.frameIDs.length && var0.field1239 > var1.frameLenghts[var0.actionFrame]) {
               var0.field1239 = 1;
               ++var0.actionFrame;
               class2.method1(var1, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var1.frameIDs.length) {
               var0.actionFrame -= var1.frameStep;
               ++var0.field1246;
               if(var0.field1246 >= var1.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var1.frameIDs.length) {
                  class2.method1(var1, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field1208 = var1.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }
}
