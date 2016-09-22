import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("q")
   @Export("z")
   double z;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1729126123
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 149394487
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("w")
   double field97;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 447222939
   )
   int field98;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 388972925
   )
   int field99;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2005866217
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("nz")
   static class59 field101;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 633038195
   )
   int field102;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1464396059
   )
   @Export("start")
   int start;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1212389159
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("x")
   @Export("isMoving")
   boolean isMoving = false;
   @ObfuscatedName("u")
   @Export("x")
   double x;
   @ObfuscatedName("j")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("b")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 862796633
   )
   @Export("id")
   int id;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -423530467
   )
   int field110;
   @ObfuscatedName("p")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("o")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("y")
   @Export("az")
   double az;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 16261891
   )
   int field114;
   @ObfuscatedName("h")
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -787935019
   )
   int field117 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -806110767
   )
   int field118 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2054300385
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -610652687
   )
   @Export("z1")
   int z1;

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.id = var1;
      this.floor = var2;
      this.x1 = var3;
      this.y1 = var4;
      this.z1 = var5;
      this.startTime = var6;
      this.field98 = var7;
      this.field114 = var8;
      this.start = var9;
      this.interacting = var10;
      this.field102 = var11;
      this.isMoving = false;
      int var12 = class49.method1029(this.id).field1034;
      if(var12 != -1) {
         this.animationSequence = Friend.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1045614614"
   )
   final void method89(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.x = (double)this.x1 + (double)this.start * var5 / var9;
         this.velocityZ = (double)this.y1 + var7 * (double)this.start / var9;
         this.z = (double)this.z1;
      }

      var5 = (double)(1 + this.field98 - var4);
      this.field97 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.field97 * this.field97 + this.scalar * this.scalar);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan(0.02454369D * (double)this.field114);
      }

      this.az = 2.0D * ((double)var3 - this.z - var5 * this.velocityX) / (var5 * var5);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1588390073"
   )
   final void method90(int var1) {
      this.isMoving = true;
      this.x += (double)var1 * this.field97;
      this.velocityZ += (double)var1 * this.scalar;
      this.z += (double)var1 * this.az * 0.5D * (double)var1 + (double)var1 * this.velocityX;
      this.velocityX += this.az * (double)var1;
      this.field110 = (int)(Math.atan2(this.field97, this.scalar) * 325.949D) + 1024 & 2047;
      this.field99 = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.field118 += var1;

         while(true) {
            do {
               do {
                  if(this.field118 <= this.animationSequence.field1015[this.field117]) {
                     return;
                  }

                  this.field118 -= this.animationSequence.field1015[this.field117];
                  ++this.field117;
               } while(this.field117 < this.animationSequence.field1009.length);

               this.field117 -= this.animationSequence.field1014;
            } while(this.field117 >= 0 && this.field117 < this.animationSequence.field1009.length);

            this.field117 = 0;
         }
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "82"
   )
   static final int method93() {
      if(class116.field2039.field131) {
         return Item.plane;
      } else {
         int var0 = class116.method2462(class165.cameraX, class9.cameraY, Item.plane);
         return var0 - class125.cameraZ < 800 && (class5.tileSettings[Item.plane][class165.cameraX >> 7][class9.cameraY >> 7] & 4) != 0?Item.plane:3;
      }
   }

   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-12"
   )
   static final void method98() {
      Client.field323.method2801(230);
      Client.field323.method2513(0);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass125;II)V",
      garbageValue = "-154020642"
   )
   static void method101(class125 var0, int var1) {
      boolean var2 = var0.method2792(1) == 1;
      if(var2) {
         class34.field787[++class34.field786 - 1] = var1;
      }

      int var3 = var0.method2792(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field55 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class34.field794[var1] = (var4.pathY[0] + KitDefinition.baseY >> 6) + (var4.pathX[0] + class9.baseX >> 6 << 14) + (var4.field40 << 28);
            if(var4.field885 != -1) {
               class34.field788[var1] = var4.field885;
            } else {
               class34.field788[var1] = var4.field891;
            }

            class34.field785[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.method2792(1) != 0) {
               class75.method1622(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method2792(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field55 = true;
                  var4.field45 = var6;
                  var4.field57 = var7;
               } else {
                  var4.field55 = false;
                  var4.method29(var6, var7, class34.field777[var1]);
               }
            } else {
               var4.method20(var6, var7);
               var4.field55 = false;
            }

         } else if(var3 == 2) {
            var5 = var0.method2792(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field55 = true;
                  var4.field45 = var6;
                  var4.field57 = var7;
               } else {
                  var4.field55 = false;
                  var4.method29(var6, var7, class34.field777[var1]);
               }
            } else {
               var4.method20(var6, var7);
               var4.field55 = false;
            }

         } else {
            var5 = var0.method2792(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method2792(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.pathX[0];
               var11 = var4.pathY[0] + var9;
               if(var1 == Client.localInteractingIndex && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method20(var10, var11);
                  var4.field55 = false;
               } else if(var2) {
                  var4.field55 = true;
                  var4.field45 = var10;
                  var4.field57 = var11;
               } else {
                  var4.field55 = false;
                  var4.method29(var10, var11, class34.field777[var1]);
               }

               var4.field40 = (byte)(var4.field40 + var7 & 3);
               if(Client.localInteractingIndex == var1) {
                  Item.plane = var4.field40;
               }

            } else {
               var6 = var0.method2792(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (class9.baseX + var4.pathX[0] + var8 & 16383) - class9.baseX;
               var11 = (var4.pathY[0] + KitDefinition.baseY + var9 & 16383) - KitDefinition.baseY;
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field55 = true;
                     var4.field45 = var10;
                     var4.field57 = var11;
                  } else {
                     var4.field55 = false;
                     var4.method29(var10, var11, class34.field777[var1]);
                  }
               } else {
                  var4.method20(var10, var11);
                  var4.field55 = false;
               }

               var4.field40 = (byte)(var4.field40 + var7 & 3);
               if(Client.localInteractingIndex == var1) {
                  Item.plane = var4.field40;
               }

            }
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "1853658170"
   )
   protected final Model getModel() {
      class45 var1 = class49.method1029(this.id);
      Model var2 = var1.method940(this.field117);
      if(var2 == null) {
         return null;
      } else {
         var2.method2333(this.field99);
         return var2;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass125;I)V",
      garbageValue = "-1326435680"
   )
   static final void method103(class125 var0) {
      int var1 = 0;
      var0.method2784();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class34.field779; ++var2) {
         var3 = class34.field780[var2];
         if((class34.field776[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class34.field776[var3] = (byte)(class34.field776[var3] | 2);
            } else {
               var4 = var0.method2792(1);
               if(var4 == 0) {
                  var1 = class56.method1185(var0);
                  class34.field776[var3] = (byte)(class34.field776[var3] | 2);
               } else {
                  method101(var0, var3);
               }
            }
         }
      }

      var0.method2805();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.method2784();

         for(var2 = 0; var2 < class34.field779; ++var2) {
            var3 = class34.field780[var2];
            if((class34.field776[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class34.field776[var3] = (byte)(class34.field776[var3] | 2);
               } else {
                  var4 = var0.method2792(1);
                  if(var4 == 0) {
                     var1 = class56.method1185(var0);
                     class34.field776[var3] = (byte)(class34.field776[var3] | 2);
                  } else {
                     method101(var0, var3);
                  }
               }
            }
         }

         var0.method2805();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.method2784();

            for(var2 = 0; var2 < class34.field781; ++var2) {
               var3 = class34.field782[var2];
               if((class34.field776[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class34.field776[var3] = (byte)(class34.field776[var3] | 2);
                  } else {
                     var4 = var0.method2792(1);
                     if(var4 == 0) {
                        var1 = class56.method1185(var0);
                        class34.field776[var3] = (byte)(class34.field776[var3] | 2);
                     } else if(class75.method1622(var0, var3)) {
                        class34.field776[var3] = (byte)(class34.field776[var3] | 2);
                     }
                  }
               }
            }

            var0.method2805();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.method2784();

               for(var2 = 0; var2 < class34.field781; ++var2) {
                  var3 = class34.field782[var2];
                  if((class34.field776[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class34.field776[var3] = (byte)(class34.field776[var3] | 2);
                     } else {
                        var4 = var0.method2792(1);
                        if(var4 == 0) {
                           var1 = class56.method1185(var0);
                           class34.field776[var3] = (byte)(class34.field776[var3] | 2);
                        } else if(class75.method1622(var0, var3)) {
                           class34.field776[var3] = (byte)(class34.field776[var3] | 2);
                        }
                     }
                  }
               }

               var0.method2805();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class34.field779 = 0;
                  class34.field781 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class34.field776[var2] = (byte)(class34.field776[var2] >> 1);
                     Player var5 = Client.cachedPlayers[var2];
                     if(null != var5) {
                        class34.field780[++class34.field779 - 1] = var2;
                     } else {
                        class34.field782[++class34.field781 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZI)I",
      garbageValue = "-1394527973"
   )
   static int method105(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method649()?(var1.method649()?0:1):(var1.method649()?-1:0)):(var2 == 5?(var0.method620()?(var1.method620()?0:1):(var1.method620()?-1:0)):(var2 == 6?(var0.method643()?(var1.method643()?0:1):(var1.method643()?-1:0)):(var2 == 7?(var0.method619()?(var1.method619()?0:1):(var1.method619()?-1:0)):var0.id - var1.id)))));
      }
   }
}
