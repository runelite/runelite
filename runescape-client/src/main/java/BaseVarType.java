import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("BaseVarType")
public enum BaseVarType implements Enumerated {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   @Export("INTEGER")
   INTEGER(0, 0, Integer.class, new IntegerToken()),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   @Export("LONG")
   LONG(1, 1, Long.class, new class3()),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   @Export("STRING")
   STRING(2, 2, String.class, new class5());

   @ObfuscatedName("qz")
   @ObfuscatedSignature(
      signature = "Lc;"
   )
   @Export("grandExchangeEvents")
   static GrandExchangeEvents grandExchangeEvents;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 555864259
   )
   static int field30;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -699849717
   )
   @Export("id2")
   final int id2;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1080732597
   )
   @Export("id")
   final int id;

   @ObfuscatedSignature(
      signature = "(IILjava/lang/Class;Ld;)V"
   )
   BaseVarType(int var3, int var4, Class var5, class0 var6) {
      this.id2 = var3;
      this.id = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1940611593"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("d")
   public static final void method12(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var7) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var6) {
               ;
            }
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var8) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1988382681"
   )
   static final int method11() {
      return class133.Viewport_mouseX;
   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(Lby;B)V",
      garbageValue = "-1"
   )
   static final void method16(Actor var0) {
      var0.poseAnimation = var0.idlePoseAnimation;
      if(var0.queueSize == 0) {
         var0.field1204 = 0;
      } else {
         if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
            Sequence var1 = GrandExchangeEvents.getAnimation(var0.animation);
            if(var0.field1159 > 0 && var1.precedenceAnimating == 0) {
               ++var0.field1204;
               return;
            }

            if(var0.field1159 <= 0 && var1.priority == 0) {
               ++var0.field1204;
               return;
            }
         }

         int var10 = var0.x;
         int var2 = var0.y;
         int var3 = var0.pathX[var0.queueSize - 1] * 128 + var0.field1147 * 64;
         int var4 = var0.pathY[var0.queueSize - 1] * 128 + var0.field1147 * 64;
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

            int var7 = var0.field1155;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field1154;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field1157;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field1156;
            }

            if(var7 == -1) {
               var7 = var0.field1154;
            }

            var0.poseAnimation = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof NPC) {
               var9 = ((NPC)var0).composition.isClickable;
            }

            if(var9) {
               if(var0.orientation != var0.angle && var0.interacting == -1 && var0.field1199 != 0) {
                  var8 = 2;
               }

               if(var0.queueSize > 2) {
                  var8 = 6;
               }

               if(var0.queueSize > 3) {
                  var8 = 8;
               }

               if(var0.field1204 > 0 && var0.queueSize > 1) {
                  var8 = 8;
                  --var0.field1204;
               }
            } else {
               if(var0.queueSize > 1) {
                  var8 = 6;
               }

               if(var0.queueSize > 2) {
                  var8 = 8;
               }

               if(var0.field1204 > 0 && var0.queueSize > 1) {
                  var8 = 8;
                  --var0.field1204;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.poseAnimation == var0.field1154 && var0.field1158 != -1) {
               var0.poseAnimation = var0.field1158;
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

            if(var3 == var0.x && var4 == var0.y) {
               --var0.queueSize;
               if(var0.field1159 > 0) {
                  --var0.field1159;
               }
            }

         } else {
            var0.x = var3;
            var0.y = var4;
            --var0.queueSize;
            if(var0.field1159 > 0) {
               --var0.field1159;
            }

         }
      }
   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(Lbi;I)V",
      garbageValue = "-2081984752"
   )
   static final void method18(PendingSpawn var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.type == 0) {
         var1 = GrandExchangeEvent.region.method2823(var0.level, var0.x, var0.y);
      }

      if(var0.type == 1) {
         var1 = GrandExchangeEvent.region.method2903(var0.level, var0.x, var0.y);
      }

      if(var0.type == 2) {
         var1 = GrandExchangeEvent.region.method2825(var0.level, var0.x, var0.y);
      }

      if(var0.type == 3) {
         var1 = GrandExchangeEvent.region.method2826(var0.level, var0.x, var0.y);
      }

      if(var1 != 0) {
         int var5 = GrandExchangeEvent.region.getObjectFlags(var0.level, var0.x, var0.y, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field1134 = var2;
      var0.field1140 = var3;
      var0.field1139 = var4;
   }
}
