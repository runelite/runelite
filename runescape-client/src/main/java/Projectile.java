import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -623327607
   )
   @Export("id")
   int id;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1173893145
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -217171077
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1473091927
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -302590985
   )
   @Export("height")
   int height;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2139108743
   )
   @Export("endHeight")
   int endHeight;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 706162689
   )
   @Export("startMovementCycle")
   int startMovementCycle;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2623133
   )
   @Export("endCycle")
   int endCycle;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1917638751
   )
   @Export("slope")
   int slope;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1931453645
   )
   @Export("startHeight")
   int startHeight;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2034407867
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("u")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("p")
   @Export("x")
   double x;
   @ObfuscatedName("w")
   @Export("y")
   double y;
   @ObfuscatedName("t")
   @Export("z")
   double z;
   @ObfuscatedName("o")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("a")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("i")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("m")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("x")
   @Export("heightOffset")
   double heightOffset;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1633053303
   )
   @Export("rotationX")
   int rotationX;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1048200603
   )
   @Export("rotationY")
   int rotationY;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1814836045
   )
   @Export("int7")
   int int7;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1796280389
   )
   @Export("int6")
   int int6;

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.isMoving = false;
      this.int7 = 0;
      this.int6 = 0;
      this.id = var1;
      this.floor = var2;
      this.x1 = var3;
      this.y1 = var4;
      this.height = var5;
      this.startMovementCycle = var6;
      this.endCycle = var7;
      this.slope = var8;
      this.startHeight = var9;
      this.interacting = var10;
      this.endHeight = var11;
      this.isMoving = false;
      int var12 = NPCComposition.getSpotAnimType(this.id).field3419;
      if(var12 != -1) {
         this.animationSequence = class45.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "72"
   )
   @Export("moveProjectile")
   @Hook("projectileMoved")
   final void moveProjectile(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.x = (double)this.x1 + var5 * (double)this.startHeight / var9;
         this.y = var7 * (double)this.startHeight / var9 + (double)this.y1;
         this.z = (double)this.height;
      }

      var5 = (double)(this.endCycle + 1 - var4);
      this.velocityX = ((double)var1 - this.x) / var5;
      this.velocityY = ((double)var2 - this.y) / var5;
      this.scalar = Math.sqrt(this.velocityX * this.velocityX + this.velocityY * this.velocityY);
      if(!this.isMoving) {
         this.velocityZ = -this.scalar * Math.tan((double)this.slope * 0.02454369D);
      }

      this.heightOffset = 2.0D * ((double)var3 - this.z - var5 * this.velocityZ) / (var5 * var5);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-126"
   )
   @Export("update")
   final void update(int var1) {
      this.isMoving = true;
      this.x += (double)var1 * this.velocityX;
      this.y += (double)var1 * this.velocityY;
      this.z += (double)var1 * 0.5D * this.heightOffset * (double)var1 + (double)var1 * this.velocityZ;
      this.velocityZ += (double)var1 * this.heightOffset;
      this.rotationX = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) + 1024 & 2047;
      this.rotationY = (int)(Math.atan2(this.velocityZ, this.scalar) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.int6 += var1;

         while(true) {
            do {
               do {
                  if(this.int6 <= this.animationSequence.frameLenghts[this.int7]) {
                     return;
                  }

                  this.int6 -= this.animationSequence.frameLenghts[this.int7];
                  ++this.int7;
               } while(this.int7 < this.animationSequence.frameIDs.length);

               this.int7 -= this.animationSequence.frameStep;
            } while(this.int7 >= 0 && this.int7 < this.animationSequence.frameIDs.length);

            this.int7 = 0;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Les;",
      garbageValue = "-17"
   )
   protected final Model getModel() {
      Spotanim var1 = NPCComposition.getSpotAnimType(this.id);
      Model var2 = var1.getModel(this.int7);
      if(var2 == null) {
         return null;
      } else {
         var2.rotateZ(this.rotationY);
         return var2;
      }
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(Lbf;IIBI)V",
      garbageValue = "1249775782"
   )
   static final void method1806(Player var0, int var1, int var2, byte var3) {
      int var4 = var0.pathX[0];
      int var5 = var0.pathY[0];
      int var6 = var0.getSize();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var8 = var0.getSize();
            Client.field1131.field2243 = var1;
            Client.field1131.field2242 = var2;
            Client.field1131.field2244 = 1;
            Client.field1131.field2245 = 1;
            class72 var9 = Client.field1131;
            class72 var10 = var9;
            CollisionData var11 = Client.collisionMaps[var0.field856];
            int[] var12 = Client.field1132;
            int[] var13 = Client.field1133;

            int var14;
            int var15;
            for(var14 = 0; var14 < 128; ++var14) {
               for(var15 = 0; var15 < 128; ++var15) {
                  class167.field2236[var14][var15] = 0;
                  class167.field2238[var14][var15] = 99999999;
               }
            }

            int var16;
            int var17;
            byte var19;
            int var20;
            int var21;
            int var23;
            int var25;
            int var26;
            int var27;
            boolean var34;
            int var36;
            int var37;
            int var39;
            if(var8 == 1) {
               var16 = var4;
               var17 = var5;
               byte var18 = 64;
               var19 = 64;
               var20 = var4 - var18;
               var21 = var5 - var19;
               class167.field2236[var18][var19] = 99;
               class167.field2238[var18][var19] = 0;
               byte var22 = 0;
               var23 = 0;
               class167.field2241[var22] = var4;
               var39 = var22 + 1;
               class167.field2240[var22] = var5;
               int[][] var24 = var11.flags;

               boolean var35;
               while(true) {
                  if(var23 == var39) {
                     class3.field16 = var16;
                     class3.field19 = var17;
                     var35 = false;
                     break;
                  }

                  var16 = class167.field2241[var23];
                  var17 = class167.field2240[var23];
                  var23 = var23 + 1 & 4095;
                  var36 = var16 - var20;
                  var37 = var17 - var21;
                  var25 = var16 - var11.x;
                  var26 = var17 - var11.y;
                  if(var10.vmethod3237(1, var16, var17, var11)) {
                     class3.field16 = var16;
                     class3.field19 = var17;
                     var35 = true;
                     break;
                  }

                  var27 = class167.field2238[var36][var37] + 1;
                  if(var36 > 0 && class167.field2236[var36 - 1][var37] == 0 && (var24[var25 - 1][var26] & 19136776) == 0) {
                     class167.field2241[var39] = var16 - 1;
                     class167.field2240[var39] = var17;
                     var39 = var39 + 1 & 4095;
                     class167.field2236[var36 - 1][var37] = 2;
                     class167.field2238[var36 - 1][var37] = var27;
                  }

                  if(var36 < 127 && class167.field2236[var36 + 1][var37] == 0 && (var24[var25 + 1][var26] & 19136896) == 0) {
                     class167.field2241[var39] = var16 + 1;
                     class167.field2240[var39] = var17;
                     var39 = var39 + 1 & 4095;
                     class167.field2236[var36 + 1][var37] = 8;
                     class167.field2238[var36 + 1][var37] = var27;
                  }

                  if(var37 > 0 && class167.field2236[var36][var37 - 1] == 0 && (var24[var25][var26 - 1] & 19136770) == 0) {
                     class167.field2241[var39] = var16;
                     class167.field2240[var39] = var17 - 1;
                     var39 = var39 + 1 & 4095;
                     class167.field2236[var36][var37 - 1] = 1;
                     class167.field2238[var36][var37 - 1] = var27;
                  }

                  if(var37 < 127 && class167.field2236[var36][var37 + 1] == 0 && (var24[var25][var26 + 1] & 19136800) == 0) {
                     class167.field2241[var39] = var16;
                     class167.field2240[var39] = var17 + 1;
                     var39 = var39 + 1 & 4095;
                     class167.field2236[var36][var37 + 1] = 4;
                     class167.field2238[var36][var37 + 1] = var27;
                  }

                  if(var36 > 0 && var37 > 0 && class167.field2236[var36 - 1][var37 - 1] == 0 && (var24[var25 - 1][var26 - 1] & 19136782) == 0 && (var24[var25 - 1][var26] & 19136776) == 0 && (var24[var25][var26 - 1] & 19136770) == 0) {
                     class167.field2241[var39] = var16 - 1;
                     class167.field2240[var39] = var17 - 1;
                     var39 = var39 + 1 & 4095;
                     class167.field2236[var36 - 1][var37 - 1] = 3;
                     class167.field2238[var36 - 1][var37 - 1] = var27;
                  }

                  if(var36 < 127 && var37 > 0 && class167.field2236[var36 + 1][var37 - 1] == 0 && (var24[var25 + 1][var26 - 1] & 19136899) == 0 && (var24[var25 + 1][var26] & 19136896) == 0 && (var24[var25][var26 - 1] & 19136770) == 0) {
                     class167.field2241[var39] = var16 + 1;
                     class167.field2240[var39] = var17 - 1;
                     var39 = var39 + 1 & 4095;
                     class167.field2236[var36 + 1][var37 - 1] = 9;
                     class167.field2238[var36 + 1][var37 - 1] = var27;
                  }

                  if(var36 > 0 && var37 < 127 && class167.field2236[var36 - 1][var37 + 1] == 0 && (var24[var25 - 1][var26 + 1] & 19136824) == 0 && (var24[var25 - 1][var26] & 19136776) == 0 && (var24[var25][var26 + 1] & 19136800) == 0) {
                     class167.field2241[var39] = var16 - 1;
                     class167.field2240[var39] = var17 + 1;
                     var39 = var39 + 1 & 4095;
                     class167.field2236[var36 - 1][var37 + 1] = 6;
                     class167.field2238[var36 - 1][var37 + 1] = var27;
                  }

                  if(var36 < 127 && var37 < 127 && class167.field2236[var36 + 1][var37 + 1] == 0 && (var24[var25 + 1][var26 + 1] & 19136992) == 0 && (var24[var25 + 1][var26] & 19136896) == 0 && (var24[var25][var26 + 1] & 19136800) == 0) {
                     class167.field2241[var39] = var16 + 1;
                     class167.field2240[var39] = var17 + 1;
                     var39 = var39 + 1 & 4095;
                     class167.field2236[var36 + 1][var37 + 1] = 12;
                     class167.field2238[var36 + 1][var37 + 1] = var27;
                  }
               }

               var34 = var35;
            } else if(var8 == 2) {
               var34 = UrlRequest.method2985(var4, var5, var9, var11);
            } else {
               var34 = ScriptVarType.method25(var4, var5, var8, var9, var11);
            }

            int var7;
            label366: {
               var15 = var4 - 64;
               var16 = var5 - 64;
               var17 = class3.field16;
               var36 = class3.field19;
               if(!var34) {
                  var37 = Integer.MAX_VALUE;
                  var20 = Integer.MAX_VALUE;
                  byte var38 = 10;
                  var39 = var10.field2243;
                  var23 = var10.field2242;
                  int var33 = var10.field2244;
                  var25 = var10.field2245;

                  for(var26 = var39 - var38; var26 <= var39 + var38; ++var26) {
                     for(var27 = var23 - var38; var27 <= var23 + var38; ++var27) {
                        int var28 = var26 - var15;
                        int var29 = var27 - var16;
                        if(var28 >= 0 && var29 >= 0 && var28 < 128 && var29 < 128 && class167.field2238[var28][var29] < 100) {
                           int var30 = 0;
                           if(var26 < var39) {
                              var30 = var39 - var26;
                           } else if(var26 > var33 + var39 - 1) {
                              var30 = var26 - (var39 + var33 - 1);
                           }

                           int var31 = 0;
                           if(var27 < var23) {
                              var31 = var23 - var27;
                           } else if(var27 > var25 + var23 - 1) {
                              var31 = var27 - (var23 + var25 - 1);
                           }

                           int var32 = var31 * var31 + var30 * var30;
                           if(var32 < var37 || var37 == var32 && class167.field2238[var28][var29] < var20) {
                              var37 = var32;
                              var20 = class167.field2238[var28][var29];
                              var17 = var26;
                              var36 = var27;
                           }
                        }
                     }
                  }

                  if(var37 == Integer.MAX_VALUE) {
                     var7 = -1;
                     break label366;
                  }
               }

               if(var17 == var4 && var5 == var36) {
                  var7 = 0;
               } else {
                  var19 = 0;
                  class167.field2241[var19] = var17;
                  var37 = var19 + 1;
                  class167.field2240[var19] = var36;

                  for(var20 = var21 = class167.field2236[var17 - var15][var36 - var16]; var17 != var4 || var5 != var36; var20 = class167.field2236[var17 - var15][var36 - var16]) {
                     if(var21 != var20) {
                        var21 = var20;
                        class167.field2241[var37] = var17;
                        class167.field2240[var37++] = var36;
                     }

                     if((var20 & 2) != 0) {
                        ++var17;
                     } else if((var20 & 8) != 0) {
                        --var17;
                     }

                     if((var20 & 1) != 0) {
                        ++var36;
                     } else if((var20 & 4) != 0) {
                        --var36;
                     }
                  }

                  var39 = 0;

                  while(var37-- > 0) {
                     var12[var39] = class167.field2241[var37];
                     var13[var39++] = class167.field2240[var37];
                     if(var39 >= var12.length) {
                        break;
                     }
                  }

                  var7 = var39;
               }
            }

            var14 = var7;
            if(var7 >= 1) {
               for(var15 = 0; var15 < var14 - 1; ++var15) {
                  var0.method1140(Client.field1132[var15], Client.field1133[var15], var3);
               }

            }
         }
      }
   }
}
