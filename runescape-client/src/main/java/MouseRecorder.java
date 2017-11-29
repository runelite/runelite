import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
   @ObfuscatedName("oo")
   @ObfuscatedSignature(
      signature = "Lcu;"
   )
   static class101 field821;
   @ObfuscatedName("d")
   @Export("isRunning")
   boolean isRunning;
   @ObfuscatedName("x")
   @Export("lock")
   Object lock;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 346682153
   )
   @Export("index")
   int index;
   @ObfuscatedName("z")
   @Export("xs")
   int[] xs;
   @ObfuscatedName("v")
   @Export("ys")
   int[] ys;

   MouseRecorder() {
      this.isRunning = true;
      this.lock = new Object();
      this.index = 0;
      this.xs = new int[500];
      this.ys = new int[500];
   }

   public void run() {
      for(; this.isRunning; BaseVarType.method12(50L)) {
         Object var1 = this.lock;
         synchronized(this.lock) {
            if(this.index < 500) {
               this.xs[this.index] = MouseInput.field703;
               this.ys[this.index] = MouseInput.field715 * 10625923;
               ++this.index;
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([Lcw;II[I[II)V",
      garbageValue = "786306007"
   )
   static void method1127(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var2 + var1) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method1624()?1:0;
                     var12 = var8.method1624()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method1624()?1:0;
                     var12 = var8.method1624()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method1127(var0, var1, var6, var3, var4);
         method1127(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "(Lby;IB)V",
      garbageValue = "-114"
   )
   static final void method1129(Actor var0, int var1) {
      int var2;
      int var3;
      int var4;
      if(var0.field1176 > Client.gameCycle) {
         var2 = var0.field1176 - Client.gameCycle;
         var3 = var0.field1188 * 128 + var0.field1147 * 64;
         var4 = var0.field1190 * 128 + var0.field1147 * 64;
         var0.x += (var3 - var0.x) / var2;
         var0.y += (var4 - var0.y) / var2;
         var0.field1204 = 0;
         var0.orientation = var0.field1194;
      } else if(var0.field1193 >= Client.gameCycle) {
         if(var0.field1193 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field1180 + 1 > GrandExchangeEvents.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
            var2 = var0.field1193 - var0.field1176;
            var3 = Client.gameCycle - var0.field1176;
            var4 = var0.field1188 * 128 + var0.field1147 * 64;
            int var5 = var0.field1190 * 128 + var0.field1147 * 64;
            int var6 = var0.field1178 * 128 + var0.field1147 * 64;
            int var7 = var0.field1166 * 128 + var0.field1147 * 64;
            var0.x = (var6 * var3 + var4 * (var2 - var3)) / var2;
            var0.y = (var3 * var7 + var5 * (var2 - var3)) / var2;
         }

         var0.field1204 = 0;
         var0.orientation = var0.field1194;
         var0.angle = var0.orientation;
      } else {
         BaseVarType.method16(var0);
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1176 = 0;
         var0.field1193 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1147 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1147 * 64;
         var0.method1574();
      }

      if(class181.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1176 = 0;
         var0.field1193 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1147 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1147 * 64;
         var0.method1574();
      }

      if(var0.field1199 != 0) {
         if(var0.interacting != -1) {
            Object var8 = null;
            if(var0.interacting < 32768) {
               var8 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= 32768) {
               var8 = Client.cachedPlayers[var0.interacting - 32768];
            }

            if(var8 != null) {
               var3 = var0.x - ((Actor)var8).x;
               var4 = var0.y - ((Actor)var8).y;
               if(var3 != 0 || var4 != 0) {
                  var0.orientation = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field1173) {
               var0.interacting = -1;
               var0.field1173 = false;
            }
         }

         if(var0.field1174 != -1 && (var0.queueSize == 0 || var0.field1204 > 0)) {
            var0.orientation = var0.field1174;
            var0.field1174 = -1;
         }

         var2 = var0.orientation - var0.angle & 2047;
         if(var2 == 0 && var0.field1173) {
            var0.interacting = -1;
            var0.field1173 = false;
         }

         if(var2 != 0) {
            ++var0.field1198;
            boolean var10;
            if(var2 > 1024) {
               var0.angle -= var0.field1199;
               var10 = true;
               if(var2 < var0.field1199 || var2 > 2048 - var0.field1199) {
                  var0.angle = var0.orientation;
                  var10 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field1198 > 25 || var10)) {
                  if(var0.field1152 != -1) {
                     var0.poseAnimation = var0.field1152;
                  } else {
                     var0.poseAnimation = var0.field1154;
                  }
               }
            } else {
               var0.angle += var0.field1199;
               var10 = true;
               if(var2 < var0.field1199 || var2 > 2048 - var0.field1199) {
                  var0.angle = var0.orientation;
                  var10 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field1198 > 25 || var10)) {
                  if(var0.field1153 != -1) {
                     var0.poseAnimation = var0.field1153;
                  } else {
                     var0.poseAnimation = var0.field1154;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field1198 = 0;
         }
      }

      MilliTimer.method3055(var0);
   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(Lbw;IIB)V",
      garbageValue = "0"
   )
   static void method1130(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = GrandExchangeEvents.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field1180 = 0;
            var0.actionAnimationDisable = var2;
            var0.field1182 = 0;
         }

         if(var3 == 2) {
            var0.field1182 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || GrandExchangeEvents.getAnimation(var1).forcedPriority >= GrandExchangeEvents.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field1180 = 0;
         var0.actionAnimationDisable = var2;
         var0.field1182 = 0;
         var0.field1159 = var0.queueSize;
      }

   }

   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      signature = "([Lhx;II)V",
      garbageValue = "953786821"
   )
   static final void method1131(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.hasScript || !Buffer.method3509(var3))) {
            int var5;
            if(var3.type == 0) {
               if(!var3.hasScript && Buffer.method3509(var3) && var3 != FloorUnderlayDefinition.field3409) {
                  continue;
               }

               method1131(var0, var3.id);
               if(var3.children != null) {
                  method1131(var3.children, var3.id);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  var5 = var4.id;
                  if(ISAACCipher.loadWidget(var5)) {
                     method1131(class11.widgets[var5], -1);
                  }
               }
            }

            if(var3.type == 6) {
               if(var3.field2844 != -1 || var3.field2772 != -1) {
                  boolean var7 = Varcs.method1877(var3);
                  if(var7) {
                     var5 = var3.field2772;
                  } else {
                     var5 = var3.field2844;
                  }

                  if(var5 != -1) {
                     Sequence var6 = GrandExchangeEvents.getAnimation(var5);

                     for(var3.field2783 += Client.field992; var3.field2783 > var6.frameLenghts[var3.field2846]; class40.method556(var3)) {
                        var3.field2783 -= var6.frameLenghts[var3.field2846];
                        ++var3.field2846;
                        if(var3.field2846 >= var6.frameIDs.length) {
                           var3.field2846 -= var6.frameStep;
                           if(var3.field2846 < 0 || var3.field2846 >= var6.frameIDs.length) {
                              var3.field2846 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2780 != 0 && !var3.hasScript) {
                  int var8 = var3.field2780 >> 16;
                  var5 = var3.field2780 << 16 >> 16;
                  var8 *= Client.field992;
                  var5 *= Client.field992;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  class40.method556(var3);
               }
            }
         }
      }

   }
}
