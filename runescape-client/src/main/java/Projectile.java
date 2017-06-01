import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2057948965
   )
   int field1471;
   @ObfuscatedName("cf")
   static class153 field1472;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1281086885
   )
   @Export("id")
   int id;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1713836431
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -897348625
   )
   @Export("z1")
   int z1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1796651335
   )
   int field1476;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 761273219
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1979844109
   )
   int field1478;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1955463709
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -925099693
   )
   @Export("start")
   int start;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1084082975
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("q")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("z")
   @Export("x")
   double x;
   @ObfuscatedName("m")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("j")
   @Export("z")
   double z;
   @ObfuscatedName("k")
   double field1486;
   @ObfuscatedName("o")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1823405291
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("d")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("s")
   @Export("az")
   double az;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1050413569
   )
   int field1491;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1625102411
   )
   int field1492;
   @ObfuscatedName("p")
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 661977545
   )
   int field1494;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 184749987
   )
   int field1495;
   @ObfuscatedName("r")
   @Export("scalar")
   double scalar;

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.isMoving = false;
      this.field1494 = 0;
      this.field1495 = 0;
      this.id = var1;
      this.floor = var2;
      this.x1 = var3;
      this.y1 = var4;
      this.z1 = var5;
      this.startTime = var6;
      this.field1471 = var7;
      this.field1478 = var8;
      this.start = var9;
      this.interacting = var10;
      this.field1476 = var11;
      this.isMoving = false;
      int var12 = CombatInfo1.method1542(this.id).field3326;
      if(var12 != -1) {
         this.animationSequence = class227.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "550458767"
   )
   final void method1737(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.x = (double)this.start * var5 / var9 + (double)this.x1;
         this.velocityZ = (double)this.start * var7 / var9 + (double)this.y1;
         this.z = (double)this.z1;
      }

      var5 = (double)(this.field1471 + 1 - var4);
      this.field1486 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.field1486 * this.field1486 + this.scalar * this.scalar);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan(0.02454369D * (double)this.field1478);
      }

      this.az = ((double)var3 - this.z - var5 * this.velocityX) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "2096882887"
   )
   protected final Model getModel() {
      Spotanim var1 = CombatInfo1.method1542(this.id);
      Model var2 = var1.method4341(this.field1494);
      if(var2 == null) {
         return null;
      } else {
         var2.method2517(this.field1492);
         return var2;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "448042417"
   )
   final void method1744(int var1) {
      this.isMoving = true;
      this.x += this.field1486 * (double)var1;
      this.velocityZ += this.scalar * (double)var1;
      this.z += 0.5D * this.az * (double)var1 * (double)var1 + this.velocityX * (double)var1;
      this.velocityX += this.az * (double)var1;
      this.field1491 = (int)(Math.atan2(this.field1486, this.scalar) * 325.949D) + 1024 & 2047;
      this.field1492 = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.field1495 += var1;

         while(true) {
            do {
               do {
                  if(this.field1495 <= this.animationSequence.frameLenghts[this.field1494]) {
                     return;
                  }

                  this.field1495 -= this.animationSequence.frameLenghts[this.field1494];
                  ++this.field1494;
               } while(this.field1494 < this.animationSequence.frameIDs.length);

               this.field1494 -= this.animationSequence.frameStep;
            } while(this.field1494 >= 0 && this.field1494 < this.animationSequence.frameIDs.length);

            this.field1494 = 0;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass69;IB)V",
      garbageValue = "-22"
   )
   static void method1746(class69 var0, int var1) {
      Object[] var2 = var0.field849;
      class219 var5 = var0.field859;
      boolean var4 = var5 == class219.field2798 || var5 == class219.field2790 || var5 == class219.field2789 || class219.field2799 == var5 || var5 == class219.field2791 || class219.field2792 == var5 || var5 == class219.field2796 || var5 == class219.field2794;
      Script var3;
      int var29;
      if(var4) {
         class44.field585 = (class47)var2[0];
         class242 var6 = class223.field2839[class44.field585.field606];
         var3 = MessageNode.method1106(var0.field859, var6.field3289, var6.field3297);
      } else {
         var29 = ((Integer)var2[0]).intValue();
         var3 = class146.method2896(var29);
      }

      if(var3 != null) {
         class83.intStackSize = 0;
         class51.scriptStringStackSize = 0;
         var29 = -1;
         int[] var7 = var3.instructions;
         int[] var8 = var3.intOperands;
         byte var9 = -1;
         class83.scriptStackCount = 0;

         int var12;
         try {
            class83.scriptLocalInts = new int[var3.localIntCount];
            int var10 = 0;
            class83.scriptLocalStrings = new String[var3.localStringCount];
            int var11 = 0;

            int var13;
            String var30;
            for(var12 = 1; var12 < var2.length; ++var12) {
               if(var2[var12] instanceof Integer) {
                  var13 = ((Integer)var2[var12]).intValue();
                  if(var13 == -2147483647) {
                     var13 = var0.field850;
                  }

                  if(var13 == -2147483646) {
                     var13 = var0.field848;
                  }

                  if(var13 == -2147483645) {
                     var13 = var0.field852 != null?var0.field852.id:-1;
                  }

                  if(var13 == -2147483644) {
                     var13 = var0.field853;
                  }

                  if(var13 == -2147483643) {
                     var13 = var0.field852 != null?var0.field852.index:-1;
                  }

                  if(var13 == -2147483642) {
                     var13 = var0.field854 != null?var0.field854.id:-1;
                  }

                  if(var13 == -2147483641) {
                     var13 = var0.field854 != null?var0.field854.index:-1;
                  }

                  if(var13 == -2147483640) {
                     var13 = var0.field855;
                  }

                  if(var13 == -2147483639) {
                     var13 = var0.field856;
                  }

                  class83.scriptLocalInts[var10++] = var13;
               } else if(var2[var12] instanceof String) {
                  var30 = (String)var2[var12];
                  if(var30.equals("event_opbase")) {
                     var30 = var0.field851;
                  }

                  class83.scriptLocalStrings[var11++] = var30;
               }
            }

            var12 = 0;
            class83.field1368 = var0.field857;

            while(true) {
               while(true) {
                  while(true) {
                     while(true) {
                        while(true) {
                           while(true) {
                              while(true) {
                                 while(true) {
                                    while(true) {
                                       while(true) {
                                          while(true) {
                                             while(true) {
                                                while(true) {
                                                   while(true) {
                                                      while(true) {
                                                         while(true) {
                                                            while(true) {
                                                               while(true) {
                                                                  while(true) {
                                                                     while(true) {
                                                                        while(true) {
                                                                           while(true) {
                                                                              while(true) {
                                                                                 while(true) {
                                                                                    while(true) {
                                                                                       label2982:
                                                                                       while(true) {
                                                                                          ++var12;
                                                                                          if(var12 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var29;
                                                                                          int var54 = var7[var29];
                                                                                          int var14;
                                                                                          int var18;
                                                                                          int var20;
                                                                                          String var21;
                                                                                          int var32;
                                                                                          String var34;
                                                                                          String var58;
                                                                                          String[] var60;
                                                                                          int var62;
                                                                                          int var78;
                                                                                          if(var54 < 100) {
                                                                                             if(var54 != 0) {
                                                                                                if(var54 != 1) {
                                                                                                   if(var54 != 2) {
                                                                                                      if(var54 != 3) {
                                                                                                         if(var54 != 6) {
                                                                                                            if(var54 != 7) {
                                                                                                               if(var54 != 8) {
                                                                                                                  if(var54 != 9) {
                                                                                                                     if(var54 != 10) {
                                                                                                                        if(var54 != 21) {
                                                                                                                           if(var54 != 25) {
                                                                                                                              if(var54 != 27) {
                                                                                                                                 if(var54 != 31) {
                                                                                                                                    if(var54 != 32) {
                                                                                                                                       if(var54 != 33) {
                                                                                                                                          if(var54 != 34) {
                                                                                                                                             if(var54 != 35) {
                                                                                                                                                if(var54 != 36) {
                                                                                                                                                   if(var54 != 37) {
                                                                                                                                                      if(var54 != 38) {
                                                                                                                                                         if(var54 != 39) {
                                                                                                                                                            if(var54 != 40) {
                                                                                                                                                               if(var54 != 42) {
                                                                                                                                                                  if(var54 != 43) {
                                                                                                                                                                     if(var54 == 44) {
                                                                                                                                                                        var13 = var8[var29] >> 16;
                                                                                                                                                                        var14 = var8[var29] & '\uffff';
                                                                                                                                                                        int var113 = class83.intStack[--class83.intStackSize];
                                                                                                                                                                        if(var113 >= 0 && var113 <= 5000) {
                                                                                                                                                                           class83.field1359[var13] = var113;
                                                                                                                                                                           byte var112 = -1;
                                                                                                                                                                           if(var14 == 105) {
                                                                                                                                                                              var112 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var78 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var78 >= var113) {
                                                                                                                                                                                 continue label2982;
                                                                                                                                                                              }

                                                                                                                                                                              class83.field1357[var13][var78] = var112;
                                                                                                                                                                              ++var78;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var54 == 45) {
                                                                                                                                                                        var13 = var8[var29];
                                                                                                                                                                        var14 = class83.intStack[--class83.intStackSize];
                                                                                                                                                                        if(var14 < 0 || var14 >= class83.field1359[var13]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class83.intStack[++class83.intStackSize - 1] = class83.field1357[var13][var14];
                                                                                                                                                                     } else if(var54 == 46) {
                                                                                                                                                                        var13 = var8[var29];
                                                                                                                                                                        class83.intStackSize -= 2;
                                                                                                                                                                        var14 = class83.intStack[class83.intStackSize];
                                                                                                                                                                        if(var14 < 0 || var14 >= class83.field1359[var13]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class83.field1357[var13][var14] = class83.intStack[class83.intStackSize + 1];
                                                                                                                                                                     } else if(var54 == 47) {
                                                                                                                                                                        var30 = Player.chatMessages.method1787(var8[var29]);
                                                                                                                                                                        if(var30 == null) {
                                                                                                                                                                           var30 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var30;
                                                                                                                                                                     } else if(var54 == 48) {
                                                                                                                                                                        Player.chatMessages.method1786(var8[var29], class83.scriptStringStack[--class51.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var54 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        class186 var81 = var3.switches[var8[var29]];
                                                                                                                                                                        class198 var83 = (class198)var81.method3475((long)class83.intStack[--class83.intStackSize]);
                                                                                                                                                                        if(var83 != null) {
                                                                                                                                                                           var29 += var83.field2494;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     Player.chatMessages.method1811(var8[var29], class83.intStack[--class83.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class83.intStack[++class83.intStackSize - 1] = Player.chatMessages.method1785(var8[var29]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var13 = var8[var29];
                                                                                                                                                               Script var82 = class146.method2896(var13);
                                                                                                                                                               int[] var56 = new int[var82.localIntCount];
                                                                                                                                                               var60 = new String[var82.localStringCount];

                                                                                                                                                               for(var78 = 0; var78 < var82.intStackCount; ++var78) {
                                                                                                                                                                  var56[var78] = class83.intStack[var78 + (class83.intStackSize - var82.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var78 = 0; var78 < var82.stringStackCount; ++var78) {
                                                                                                                                                                  var60[var78] = class83.scriptStringStack[var78 + (class51.scriptStringStackSize - var82.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class83.intStackSize -= var82.intStackCount;
                                                                                                                                                               class51.scriptStringStackSize -= var82.stringStackCount;
                                                                                                                                                               ScriptState var80 = new ScriptState();
                                                                                                                                                               var80.invokedFromScript = var3;
                                                                                                                                                               var80.invokedFromPc = var29;
                                                                                                                                                               var80.savedLocalInts = class83.scriptLocalInts;
                                                                                                                                                               var80.savedLocalStrings = class83.scriptLocalStrings;
                                                                                                                                                               class83.scriptStack[++class83.scriptStackCount - 1] = var80;
                                                                                                                                                               var3 = var82;
                                                                                                                                                               var7 = var82.instructions;
                                                                                                                                                               var8 = var82.intOperands;
                                                                                                                                                               var29 = -1;
                                                                                                                                                               class83.scriptLocalInts = var56;
                                                                                                                                                               class83.scriptLocalStrings = var60;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --class51.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class83.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var13 = var8[var29];
                                                                                                                                                      class51.scriptStringStackSize -= var13;
                                                                                                                                                      String[] var55 = class83.scriptStringStack;
                                                                                                                                                      var32 = class51.scriptStringStackSize;
                                                                                                                                                      String var33;
                                                                                                                                                      if(var13 == 0) {
                                                                                                                                                         var33 = "";
                                                                                                                                                      } else if(var13 == 1) {
                                                                                                                                                         var58 = var55[var32];
                                                                                                                                                         if(var58 == null) {
                                                                                                                                                            var33 = "null";
                                                                                                                                                         } else {
                                                                                                                                                            var33 = var58.toString();
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         var78 = var13 + var32;
                                                                                                                                                         var18 = 0;

                                                                                                                                                         for(var62 = var32; var62 < var78; ++var62) {
                                                                                                                                                            var34 = var55[var62];
                                                                                                                                                            if(var34 == null) {
                                                                                                                                                               var18 += 4;
                                                                                                                                                            } else {
                                                                                                                                                               var18 += var34.length();
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         StringBuilder var98 = new StringBuilder(var18);

                                                                                                                                                         for(var20 = var32; var20 < var78; ++var20) {
                                                                                                                                                            var21 = var55[var20];
                                                                                                                                                            if(var21 == null) {
                                                                                                                                                               var98.append("null");
                                                                                                                                                            } else {
                                                                                                                                                               var98.append(var21);
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         var33 = var98.toString();
                                                                                                                                                      }

                                                                                                                                                      class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var33;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class83.scriptLocalStrings[var8[var29]] = class83.scriptStringStack[--class51.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class83.scriptStringStack[++class51.scriptStringStackSize - 1] = class83.scriptLocalStrings[var8[var29]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class83.scriptLocalInts[var8[var29]] = class83.intStack[--class83.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class83.intStack[++class83.intStackSize - 1] = class83.scriptLocalInts[var8[var29]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class83.intStackSize -= 2;
                                                                                                                                       if(class83.intStack[class83.intStackSize] >= class83.intStack[class83.intStackSize + 1]) {
                                                                                                                                          var29 += var8[var29];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class83.intStackSize -= 2;
                                                                                                                                    if(class83.intStack[class83.intStackSize] <= class83.intStack[class83.intStackSize + 1]) {
                                                                                                                                       var29 += var8[var29];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var13 = var8[var29];
                                                                                                                                 var14 = class83.intStack[--class83.intStackSize];
                                                                                                                                 Varbit var108 = (Varbit)Varbit.field3379.get((long)var13);
                                                                                                                                 Varbit var15;
                                                                                                                                 if(var108 != null) {
                                                                                                                                    var15 = var108;
                                                                                                                                 } else {
                                                                                                                                    byte[] var79 = Varbit.field3380.getConfigData(14, var13);
                                                                                                                                    var108 = new Varbit();
                                                                                                                                    if(var79 != null) {
                                                                                                                                       var108.method4425(new Buffer(var79));
                                                                                                                                    }

                                                                                                                                    Varbit.field3379.put(var108, (long)var13);
                                                                                                                                    var15 = var108;
                                                                                                                                 }

                                                                                                                                 var78 = var15.configId;
                                                                                                                                 var18 = var15.leastSignificantBit;
                                                                                                                                 var62 = var15.mostSignificantBit;
                                                                                                                                 var20 = class211.field2612[var62 - var18];
                                                                                                                                 if(var14 < 0 || var14 > var20) {
                                                                                                                                    var14 = 0;
                                                                                                                                 }

                                                                                                                                 var20 <<= var18;
                                                                                                                                 class211.widgetSettings[var78] = class211.widgetSettings[var78] & ~var20 | var14 << var18 & var20;
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var13 = var8[var29];
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = FileOnDisk.method2363(var13);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class83.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var77 = class83.scriptStack[--class83.scriptStackCount];
                                                                                                                           var3 = var77.invokedFromScript;
                                                                                                                           var7 = var3.instructions;
                                                                                                                           var8 = var3.intOperands;
                                                                                                                           var29 = var77.invokedFromPc;
                                                                                                                           class83.scriptLocalInts = var77.savedLocalInts;
                                                                                                                           class83.scriptLocalStrings = var77.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class83.intStackSize -= 2;
                                                                                                                        if(class83.intStack[class83.intStackSize] > class83.intStack[class83.intStackSize + 1]) {
                                                                                                                           var29 += var8[var29];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class83.intStackSize -= 2;
                                                                                                                     if(class83.intStack[class83.intStackSize] < class83.intStack[class83.intStackSize + 1]) {
                                                                                                                        var29 += var8[var29];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class83.intStackSize -= 2;
                                                                                                                  if(class83.intStack[class83.intStackSize + 1] == class83.intStack[class83.intStackSize]) {
                                                                                                                     var29 += var8[var29];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class83.intStackSize -= 2;
                                                                                                               if(class83.intStack[class83.intStackSize + 1] != class83.intStack[class83.intStackSize]) {
                                                                                                                  var29 += var8[var29];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var29 += var8[var29];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var3.stringOperands[var29];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var13 = var8[var29];
                                                                                                      class211.widgetSettings[var13] = class83.intStack[--class83.intStackSize];
                                                                                                      class10.method47(var13);
                                                                                                   }
                                                                                                } else {
                                                                                                   var13 = var8[var29];
                                                                                                   class83.intStack[++class83.intStackSize - 1] = class211.widgetSettings[var13];
                                                                                                }
                                                                                             } else {
                                                                                                class83.intStack[++class83.intStackSize - 1] = var8[var29];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var61;
                                                                                             if(var3.intOperands[var29] == 1) {
                                                                                                var61 = true;
                                                                                             } else {
                                                                                                var61 = false;
                                                                                             }

                                                                                             if(var54 < 1000) {
                                                                                                var14 = Actor.method1531(var54, var3, var61);
                                                                                             } else if(var54 < 1100) {
                                                                                                var14 = NPC.method1693(var54, var3, var61);
                                                                                             } else if(var54 < 1200) {
                                                                                                var14 = class226.method4080(var54, var3, var61);
                                                                                             } else if(var54 < 1300) {
                                                                                                var14 = class46.method649(var54, var3, var61);
                                                                                             } else if(var54 < 1400) {
                                                                                                var14 = class202.method3645(var54, var3, var61);
                                                                                             } else if(var54 < 1500) {
                                                                                                var14 = ScriptState.method1053(var54, var3, var61);
                                                                                             } else {
                                                                                                Widget var35;
                                                                                                byte var36;
                                                                                                if(var54 < 1600) {
                                                                                                   var35 = var61?class232.field3187:class2.field15;
                                                                                                   if(var54 == 1500) {
                                                                                                      class83.intStack[++class83.intStackSize - 1] = var35.relativeX;
                                                                                                      var36 = 1;
                                                                                                   } else if(var54 == 1501) {
                                                                                                      class83.intStack[++class83.intStackSize - 1] = var35.relativeY;
                                                                                                      var36 = 1;
                                                                                                   } else if(var54 == 1502) {
                                                                                                      class83.intStack[++class83.intStackSize - 1] = var35.width;
                                                                                                      var36 = 1;
                                                                                                   } else if(var54 == 1503) {
                                                                                                      class83.intStack[++class83.intStackSize - 1] = var35.height;
                                                                                                      var36 = 1;
                                                                                                   } else if(var54 == 1504) {
                                                                                                      class83.intStack[++class83.intStackSize - 1] = var35.isHidden?1:0;
                                                                                                      var36 = 1;
                                                                                                   } else if(var54 == 1505) {
                                                                                                      class83.intStack[++class83.intStackSize - 1] = var35.parentId;
                                                                                                      var36 = 1;
                                                                                                   } else {
                                                                                                      var36 = 2;
                                                                                                   }

                                                                                                   var14 = var36;
                                                                                                } else {
                                                                                                   Widget var16;
                                                                                                   if(var54 < 1700) {
                                                                                                      var16 = var61?class232.field3187:class2.field15;
                                                                                                      if(var54 == 1600) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var16.scrollX;
                                                                                                         var36 = 1;
                                                                                                      } else if(var54 == 1601) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var16.scrollY;
                                                                                                         var36 = 1;
                                                                                                      } else if(var54 == 1602) {
                                                                                                         class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var16.text;
                                                                                                         var36 = 1;
                                                                                                      } else if(var54 == 1603) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var16.scrollWidth;
                                                                                                         var36 = 1;
                                                                                                      } else if(var54 == 1604) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var16.scrollHeight;
                                                                                                         var36 = 1;
                                                                                                      } else if(var54 == 1605) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var16.field2705;
                                                                                                         var36 = 1;
                                                                                                      } else if(var54 == 1606) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var16.rotationX;
                                                                                                         var36 = 1;
                                                                                                      } else if(var54 == 1607) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var16.rotationY;
                                                                                                         var36 = 1;
                                                                                                      } else if(var54 == 1608) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var16.rotationZ;
                                                                                                         var36 = 1;
                                                                                                      } else if(var54 == 1609) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var16.opacity;
                                                                                                         var36 = 1;
                                                                                                      } else if(var54 == 1610) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var16.field2683;
                                                                                                         var36 = 1;
                                                                                                      } else if(var54 == 1611) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var16.textColor;
                                                                                                         var36 = 1;
                                                                                                      } else if(var54 == 1612) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var16.field2708;
                                                                                                         var36 = 1;
                                                                                                      } else if(var54 == 1613) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var16.field2681.vmethod5009();
                                                                                                         var36 = 1;
                                                                                                      } else {
                                                                                                         var36 = 2;
                                                                                                      }

                                                                                                      var14 = var36;
                                                                                                   } else if(var54 < 1800) {
                                                                                                      var35 = var61?class232.field3187:class2.field15;
                                                                                                      if(var54 == 1700) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var35.itemId;
                                                                                                         var36 = 1;
                                                                                                      } else if(var54 == 1701) {
                                                                                                         if(var35.itemId != -1) {
                                                                                                            class83.intStack[++class83.intStackSize - 1] = var35.itemQuantity;
                                                                                                         } else {
                                                                                                            class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                         }

                                                                                                         var36 = 1;
                                                                                                      } else if(var54 == 1702) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var35.index;
                                                                                                         var36 = 1;
                                                                                                      } else {
                                                                                                         var36 = 2;
                                                                                                      }

                                                                                                      var14 = var36;
                                                                                                   } else if(var54 < 1900) {
                                                                                                      var14 = class25.method167(var54, var3, var61);
                                                                                                   } else if(var54 < 2000) {
                                                                                                      var14 = IndexFile.method3011(var54, var3, var61);
                                                                                                   } else if(var54 < 2100) {
                                                                                                      var14 = NPC.method1693(var54, var3, var61);
                                                                                                   } else if(var54 < 2200) {
                                                                                                      var14 = class226.method4080(var54, var3, var61);
                                                                                                   } else if(var54 < 2300) {
                                                                                                      var14 = class46.method649(var54, var3, var61);
                                                                                                   } else if(var54 < 2400) {
                                                                                                      var14 = class202.method3645(var54, var3, var61);
                                                                                                   } else if(var54 < 2500) {
                                                                                                      var14 = ScriptState.method1053(var54, var3, var61);
                                                                                                   } else if(var54 < 2600) {
                                                                                                      var14 = CombatInfo1.method1544(var54, var3, var61);
                                                                                                   } else if(var54 < 2700) {
                                                                                                      var14 = class4.method7(var54, var3, var61);
                                                                                                   } else if(var54 < 2800) {
                                                                                                      if(var54 == 2700) {
                                                                                                         var16 = WorldMapType3.method199(class83.intStack[--class83.intStackSize]);
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var16.itemId;
                                                                                                         var36 = 1;
                                                                                                      } else if(var54 == 2701) {
                                                                                                         var16 = WorldMapType3.method199(class83.intStack[--class83.intStackSize]);
                                                                                                         if(var16.itemId != -1) {
                                                                                                            class83.intStack[++class83.intStackSize - 1] = var16.itemQuantity;
                                                                                                         } else {
                                                                                                            class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                         }

                                                                                                         var36 = 1;
                                                                                                      } else if(var54 == 2702) {
                                                                                                         var32 = class83.intStack[--class83.intStackSize];
                                                                                                         WidgetNode var17 = (WidgetNode)Client.componentTable.method3520((long)var32);
                                                                                                         if(var17 != null) {
                                                                                                            class83.intStack[++class83.intStackSize - 1] = 1;
                                                                                                         } else {
                                                                                                            class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                         }

                                                                                                         var36 = 1;
                                                                                                      } else if(var54 == 2706) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = Client.widgetRoot;
                                                                                                         var36 = 1;
                                                                                                      } else {
                                                                                                         var36 = 2;
                                                                                                      }

                                                                                                      var14 = var36;
                                                                                                   } else if(var54 < 2900) {
                                                                                                      var14 = Item.method1752(var54, var3, var61);
                                                                                                   } else if(var54 < 3000) {
                                                                                                      var14 = IndexFile.method3011(var54, var3, var61);
                                                                                                   } else {
                                                                                                      boolean var31;
                                                                                                      String var37;
                                                                                                      String var57;
                                                                                                      if(var54 < 3200) {
                                                                                                         if(var54 == 3100) {
                                                                                                            var57 = class83.scriptStringStack[--class51.scriptStringStackSize];
                                                                                                            class18.sendGameMessage(0, "", var57);
                                                                                                            var36 = 1;
                                                                                                         } else if(var54 == 3101) {
                                                                                                            class83.intStackSize -= 2;
                                                                                                            class11.method51(World.localPlayer, class83.intStack[class83.intStackSize], class83.intStack[class83.intStackSize + 1]);
                                                                                                            var36 = 1;
                                                                                                         } else if(var54 == 3103) {
                                                                                                            WorldMapType1.method260();
                                                                                                            var36 = 1;
                                                                                                         } else if(var54 == 3104) {
                                                                                                            var57 = class83.scriptStringStack[--class51.scriptStringStackSize];
                                                                                                            var78 = 0;
                                                                                                            if(class254.method4490(var57)) {
                                                                                                               var78 = class208.method3857(var57);
                                                                                                            }

                                                                                                            Client.secretPacketBuffer1.putOpcode(159);
                                                                                                            Client.secretPacketBuffer1.putInt(var78);
                                                                                                            var36 = 1;
                                                                                                         } else if(var54 == 3105) {
                                                                                                            var57 = class83.scriptStringStack[--class51.scriptStringStackSize];
                                                                                                            Client.secretPacketBuffer1.putOpcode(78);
                                                                                                            Client.secretPacketBuffer1.putByte(var57.length() + 1);
                                                                                                            Client.secretPacketBuffer1.method3150(var57);
                                                                                                            var36 = 1;
                                                                                                         } else if(var54 == 3106) {
                                                                                                            var57 = class83.scriptStringStack[--class51.scriptStringStackSize];
                                                                                                            Client.secretPacketBuffer1.putOpcode(10);
                                                                                                            Client.secretPacketBuffer1.putByte(var57.length() + 1);
                                                                                                            Client.secretPacketBuffer1.method3150(var57);
                                                                                                            var36 = 1;
                                                                                                         } else if(var54 == 3107) {
                                                                                                            var32 = class83.intStack[--class83.intStackSize];
                                                                                                            var58 = class83.scriptStringStack[--class51.scriptStringStackSize];
                                                                                                            class31.method263(var32, var58);
                                                                                                            var36 = 1;
                                                                                                         } else if(var54 == 3108) {
                                                                                                            class83.intStackSize -= 3;
                                                                                                            var32 = class83.intStack[class83.intStackSize];
                                                                                                            var78 = class83.intStack[class83.intStackSize + 1];
                                                                                                            var18 = class83.intStack[class83.intStackSize + 2];
                                                                                                            var35 = WorldMapType3.method199(var18);
                                                                                                            class14.method74(var35, var32, var78);
                                                                                                            var36 = 1;
                                                                                                         } else if(var54 == 3109) {
                                                                                                            class83.intStackSize -= 2;
                                                                                                            var32 = class83.intStack[class83.intStackSize];
                                                                                                            var78 = class83.intStack[class83.intStackSize + 1];
                                                                                                            Widget var89 = var61?class232.field3187:class2.field15;
                                                                                                            class14.method74(var89, var32, var78);
                                                                                                            var36 = 1;
                                                                                                         } else if(var54 == 3110) {
                                                                                                            class233.field3202 = class83.intStack[--class83.intStackSize] == 1;
                                                                                                            var36 = 1;
                                                                                                         } else if(var54 == 3111) {
                                                                                                            class83.intStack[++class83.intStackSize - 1] = XGrandExchangeOffer.field303.field1333?1:0;
                                                                                                            var36 = 1;
                                                                                                         } else if(var54 == 3112) {
                                                                                                            XGrandExchangeOffer.field303.field1333 = class83.intStack[--class83.intStackSize] == 1;
                                                                                                            ScriptState.method1052();
                                                                                                            var36 = 1;
                                                                                                         } else if(var54 == 3113) {
                                                                                                            var57 = class83.scriptStringStack[--class51.scriptStringStackSize];
                                                                                                            var31 = class83.intStack[--class83.intStackSize] == 1;
                                                                                                            if(var31) {
                                                                                                               label2933: {
                                                                                                                  if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                                                                                                                     try {
                                                                                                                        Desktop.getDesktop().browse(new URI(var57));
                                                                                                                        break label2933;
                                                                                                                     } catch (Exception var52) {
                                                                                                                        ;
                                                                                                                     }
                                                                                                                  }

                                                                                                                  if(class56.field690.startsWith("win")) {
                                                                                                                     class40.method534(var57, 0, "openjs");
                                                                                                                  } else if(class56.field690.startsWith("mac")) {
                                                                                                                     class40.method534(var57, 1, "openjs");
                                                                                                                  } else {
                                                                                                                     class40.method534(var57, 2, "openjs");
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class40.method534(var57, 3, "openjs");
                                                                                                            }

                                                                                                            var36 = 1;
                                                                                                         } else if(var54 == 3115) {
                                                                                                            var32 = class83.intStack[--class83.intStackSize];
                                                                                                            Client.secretPacketBuffer1.putOpcode(153);
                                                                                                            Client.secretPacketBuffer1.putShort(var32);
                                                                                                            var36 = 1;
                                                                                                         } else if(var54 == 3116) {
                                                                                                            var32 = class83.intStack[--class83.intStackSize];
                                                                                                            class51.scriptStringStackSize -= 2;
                                                                                                            var58 = class83.scriptStringStack[class51.scriptStringStackSize];
                                                                                                            var37 = class83.scriptStringStack[class51.scriptStringStackSize + 1];
                                                                                                            if(var58.length() > 500) {
                                                                                                               var36 = 1;
                                                                                                            } else if(var37.length() > 500) {
                                                                                                               var36 = 1;
                                                                                                            } else {
                                                                                                               Client.secretPacketBuffer1.putOpcode(148);
                                                                                                               Client.secretPacketBuffer1.putShort(class5.method11(var58) + 1 + class5.method11(var37));
                                                                                                               Client.secretPacketBuffer1.method3150(var37);
                                                                                                               Client.secretPacketBuffer1.method3150(var58);
                                                                                                               Client.secretPacketBuffer1.method3165(var32);
                                                                                                               var36 = 1;
                                                                                                            }
                                                                                                         } else if(var54 == 3117) {
                                                                                                            Client.field1078 = class83.intStack[--class83.intStackSize] == 1;
                                                                                                            var36 = 1;
                                                                                                         } else {
                                                                                                            var36 = 2;
                                                                                                         }

                                                                                                         var14 = var36;
                                                                                                      } else if(var54 < 3300) {
                                                                                                         if(var54 == 3200) {
                                                                                                            class83.intStackSize -= 3;
                                                                                                            class43.method602(class83.intStack[class83.intStackSize], class83.intStack[class83.intStackSize + 1], class83.intStack[class83.intStackSize + 2]);
                                                                                                            var36 = 1;
                                                                                                         } else if(var54 == 3201) {
                                                                                                            class205.method3791(class83.intStack[--class83.intStackSize]);
                                                                                                            var36 = 1;
                                                                                                         } else if(var54 == 3202) {
                                                                                                            class83.intStackSize -= 2;
                                                                                                            MessageNode.method1107(class83.intStack[class83.intStackSize], class83.intStack[class83.intStackSize + 1]);
                                                                                                            var36 = 1;
                                                                                                         } else {
                                                                                                            var36 = 2;
                                                                                                         }

                                                                                                         var14 = var36;
                                                                                                      } else if(var54 < 3400) {
                                                                                                         var14 = class60.method998(var54, var3, var61);
                                                                                                      } else if(var54 < 3500) {
                                                                                                         var14 = NPC.method1690(var54, var3, var61);
                                                                                                      } else {
                                                                                                         int var22;
                                                                                                         int var24;
                                                                                                         int var25;
                                                                                                         if(var54 < 3700) {
                                                                                                            if(var54 == 3600) {
                                                                                                               if(Client.field1196 == 0) {
                                                                                                                  class83.intStack[++class83.intStackSize - 1] = -2;
                                                                                                               } else if(Client.field1196 == 1) {
                                                                                                                  class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                               } else {
                                                                                                                  class83.intStack[++class83.intStackSize - 1] = Client.friendCount;
                                                                                                               }

                                                                                                               var36 = 1;
                                                                                                            } else if(var54 == 3601) {
                                                                                                               var32 = class83.intStack[--class83.intStackSize];
                                                                                                               if(Client.field1196 == 2 && var32 < Client.friendCount) {
                                                                                                                  class83.scriptStringStack[++class51.scriptStringStackSize - 1] = Client.friends[var32].name;
                                                                                                                  class83.scriptStringStack[++class51.scriptStringStackSize - 1] = Client.friends[var32].previousName;
                                                                                                               } else {
                                                                                                                  class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "";
                                                                                                                  class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "";
                                                                                                               }

                                                                                                               var36 = 1;
                                                                                                            } else if(var54 == 3602) {
                                                                                                               var32 = class83.intStack[--class83.intStackSize];
                                                                                                               if(Client.field1196 == 2 && var32 < Client.friendCount) {
                                                                                                                  class83.intStack[++class83.intStackSize - 1] = Client.friends[var32].world;
                                                                                                               } else {
                                                                                                                  class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                               }

                                                                                                               var36 = 1;
                                                                                                            } else if(var54 == 3603) {
                                                                                                               var32 = class83.intStack[--class83.intStackSize];
                                                                                                               if(Client.field1196 == 2 && var32 < Client.friendCount) {
                                                                                                                  class83.intStack[++class83.intStackSize - 1] = Client.friends[var32].rank;
                                                                                                               } else {
                                                                                                                  class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                               }

                                                                                                               var36 = 1;
                                                                                                            } else if(var54 == 3604) {
                                                                                                               var57 = class83.scriptStringStack[--class51.scriptStringStackSize];
                                                                                                               var78 = class83.intStack[--class83.intStackSize];
                                                                                                               class203.method3665(var57, var78);
                                                                                                               var36 = 1;
                                                                                                            } else {
                                                                                                               Ignore var87;
                                                                                                               Friend var91;
                                                                                                               if(var54 == 3605) {
                                                                                                                  var57 = class83.scriptStringStack[--class51.scriptStringStackSize];
                                                                                                                  if(var57 != null) {
                                                                                                                     if((Client.friendCount < 200 || Client.field997 == 1) && Client.friendCount < 400) {
                                                                                                                        var58 = class154.method2955(var57, World.field1331);
                                                                                                                        if(var58 != null) {
                                                                                                                           var18 = 0;

                                                                                                                           label2726:
                                                                                                                           while(true) {
                                                                                                                              if(var18 >= Client.friendCount) {
                                                                                                                                 for(var18 = 0; var18 < Client.ignoreCount; ++var18) {
                                                                                                                                    var87 = Client.ignores[var18];
                                                                                                                                    var34 = class154.method2955(var87.name, World.field1331);
                                                                                                                                    if(var34 != null && var34.equals(var58)) {
                                                                                                                                       class18.sendGameMessage(30, "", "Please remove " + var57 + " from your ignore list first");
                                                                                                                                       break label2726;
                                                                                                                                    }

                                                                                                                                    if(var87.previousName != null) {
                                                                                                                                       var21 = class154.method2955(var87.previousName, World.field1331);
                                                                                                                                       if(var21 != null && var21.equals(var58)) {
                                                                                                                                          class18.sendGameMessage(30, "", "Please remove " + var57 + " from your ignore list first");
                                                                                                                                          break label2726;
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 }

                                                                                                                                 if(class154.method2955(World.localPlayer.name, World.field1331).equals(var58)) {
                                                                                                                                    class18.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
                                                                                                                                 } else {
                                                                                                                                    Client.secretPacketBuffer1.putOpcode(94);
                                                                                                                                    Client.secretPacketBuffer1.putByte(class5.method11(var57));
                                                                                                                                    Client.secretPacketBuffer1.method3150(var57);
                                                                                                                                 }
                                                                                                                                 break;
                                                                                                                              }

                                                                                                                              var91 = Client.friends[var18];
                                                                                                                              var34 = class154.method2955(var91.name, World.field1331);
                                                                                                                              if(var34 != null && var34.equals(var58)) {
                                                                                                                                 class18.sendGameMessage(30, "", var57 + " is already on your friend list");
                                                                                                                                 break;
                                                                                                                              }

                                                                                                                              if(var91.previousName != null) {
                                                                                                                                 var21 = class154.method2955(var91.previousName, World.field1331);
                                                                                                                                 if(var21 != null && var21.equals(var58)) {
                                                                                                                                    class18.sendGameMessage(30, "", var57 + " is already on your friend list");
                                                                                                                                    break;
                                                                                                                                 }
                                                                                                                              }

                                                                                                                              ++var18;
                                                                                                                           }
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class18.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var36 = 1;
                                                                                                               } else if(var54 == 3606) {
                                                                                                                  var57 = class83.scriptStringStack[--class51.scriptStringStackSize];
                                                                                                                  Friend.method1076(var57);
                                                                                                                  var36 = 1;
                                                                                                               } else if(var54 == 3607) {
                                                                                                                  var57 = class83.scriptStringStack[--class51.scriptStringStackSize];
                                                                                                                  if(var57 != null) {
                                                                                                                     if((Client.ignoreCount < 100 || Client.field997 == 1) && Client.ignoreCount < 400) {
                                                                                                                        var58 = class154.method2955(var57, World.field1331);
                                                                                                                        if(var58 != null) {
                                                                                                                           var18 = 0;

                                                                                                                           label2760:
                                                                                                                           while(true) {
                                                                                                                              if(var18 >= Client.ignoreCount) {
                                                                                                                                 for(var18 = 0; var18 < Client.friendCount; ++var18) {
                                                                                                                                    var91 = Client.friends[var18];
                                                                                                                                    var34 = class154.method2955(var91.name, World.field1331);
                                                                                                                                    if(var34 != null && var34.equals(var58)) {
                                                                                                                                       class18.sendGameMessage(31, "", "Please remove " + var57 + " from your friend list first");
                                                                                                                                       break label2760;
                                                                                                                                    }

                                                                                                                                    if(var91.previousName != null) {
                                                                                                                                       var21 = class154.method2955(var91.previousName, World.field1331);
                                                                                                                                       if(var21 != null && var21.equals(var58)) {
                                                                                                                                          class18.sendGameMessage(31, "", "Please remove " + var57 + " from your friend list first");
                                                                                                                                          break label2760;
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 }

                                                                                                                                 if(class154.method2955(World.localPlayer.name, World.field1331).equals(var58)) {
                                                                                                                                    class18.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
                                                                                                                                 } else {
                                                                                                                                    Client.secretPacketBuffer1.putOpcode(217);
                                                                                                                                    Client.secretPacketBuffer1.putByte(class5.method11(var57));
                                                                                                                                    Client.secretPacketBuffer1.method3150(var57);
                                                                                                                                 }
                                                                                                                                 break;
                                                                                                                              }

                                                                                                                              var87 = Client.ignores[var18];
                                                                                                                              var34 = class154.method2955(var87.name, World.field1331);
                                                                                                                              if(var34 != null && var34.equals(var58)) {
                                                                                                                                 class18.sendGameMessage(31, "", var57 + " is already on your ignore list");
                                                                                                                                 break;
                                                                                                                              }

                                                                                                                              if(var87.previousName != null) {
                                                                                                                                 var21 = class154.method2955(var87.previousName, World.field1331);
                                                                                                                                 if(var21 != null && var21.equals(var58)) {
                                                                                                                                    class18.sendGameMessage(31, "", var57 + " is already on your ignore list");
                                                                                                                                    break;
                                                                                                                                 }
                                                                                                                              }

                                                                                                                              ++var18;
                                                                                                                           }
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class18.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var36 = 1;
                                                                                                               } else if(var54 == 3608) {
                                                                                                                  var57 = class83.scriptStringStack[--class51.scriptStringStackSize];
                                                                                                                  if(var57 != null) {
                                                                                                                     var58 = class154.method2955(var57, World.field1331);
                                                                                                                     if(var58 != null) {
                                                                                                                        for(var18 = 0; var18 < Client.ignoreCount; ++var18) {
                                                                                                                           var87 = Client.ignores[var18];
                                                                                                                           var34 = var87.name;
                                                                                                                           var21 = class154.method2955(var34, World.field1331);
                                                                                                                           if(class155.method2957(var57, var58, var34, var21)) {
                                                                                                                              --Client.ignoreCount;

                                                                                                                              for(var22 = var18; var22 < Client.ignoreCount; ++var22) {
                                                                                                                                 Client.ignores[var22] = Client.ignores[var22 + 1];
                                                                                                                              }

                                                                                                                              Client.field1066 = Client.field1121;
                                                                                                                              Client.secretPacketBuffer1.putOpcode(232);
                                                                                                                              Client.secretPacketBuffer1.putByte(class5.method11(var57));
                                                                                                                              Client.secretPacketBuffer1.method3150(var57);
                                                                                                                              break;
                                                                                                                           }
                                                                                                                        }
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var36 = 1;
                                                                                                               } else if(var54 == 3609) {
                                                                                                                  var57 = class83.scriptStringStack[--class51.scriptStringStackSize];
                                                                                                                  class230[] var59 = class100.method1857();

                                                                                                                  for(var18 = 0; var18 < var59.length; ++var18) {
                                                                                                                     class230 var86 = var59[var18];
                                                                                                                     if(var86.field3174 != -1) {
                                                                                                                        var22 = var86.field3174;
                                                                                                                        var21 = "<img=" + var22 + ">";
                                                                                                                        if(var57.startsWith(var21)) {
                                                                                                                           var57 = var57.substring(Integer.toString(var86.field3174).length() + 6);
                                                                                                                           break;
                                                                                                                        }
                                                                                                                     }
                                                                                                                  }

                                                                                                                  class83.intStack[++class83.intStackSize - 1] = method1749(var57, false)?1:0;
                                                                                                                  var36 = 1;
                                                                                                               } else {
                                                                                                                  char var26;
                                                                                                                  long var38;
                                                                                                                  String var42;
                                                                                                                  String var85;
                                                                                                                  if(var54 == 3611) {
                                                                                                                     if(Client.field1155 != null) {
                                                                                                                        var60 = class83.scriptStringStack;
                                                                                                                        var78 = ++class51.scriptStringStackSize - 1;
                                                                                                                        var85 = Client.field1155;
                                                                                                                        var38 = 0L;
                                                                                                                        var24 = var85.length();

                                                                                                                        for(var25 = 0; var25 < var24; ++var25) {
                                                                                                                           var38 *= 37L;
                                                                                                                           var26 = var85.charAt(var25);
                                                                                                                           if(var26 >= 65 && var26 <= 90) {
                                                                                                                              var38 += (long)(var26 + 1 - 65);
                                                                                                                           } else if(var26 >= 97 && var26 <= 122) {
                                                                                                                              var38 += (long)(var26 + 1 - 97);
                                                                                                                           } else if(var26 >= 48 && var26 <= 57) {
                                                                                                                              var38 += (long)(var26 + 27 - 48);
                                                                                                                           }

                                                                                                                           if(var38 >= 177917621779460413L) {
                                                                                                                              break;
                                                                                                                           }
                                                                                                                        }

                                                                                                                        while(0L == var38 % 37L && 0L != var38) {
                                                                                                                           var38 /= 37L;
                                                                                                                        }

                                                                                                                        var42 = Overlay.method4684(var38);
                                                                                                                        if(var42 == null) {
                                                                                                                           var42 = "";
                                                                                                                        }

                                                                                                                        var60[var78] = var42;
                                                                                                                     } else {
                                                                                                                        class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var36 = 1;
                                                                                                                  } else if(var54 == 3612) {
                                                                                                                     if(Client.field1155 != null) {
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = class4.clanChatCount;
                                                                                                                     } else {
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                     }

                                                                                                                     var36 = 1;
                                                                                                                  } else if(var54 == 3613) {
                                                                                                                     var32 = class83.intStack[--class83.intStackSize];
                                                                                                                     if(Client.field1155 != null && var32 < class4.clanChatCount) {
                                                                                                                        class83.scriptStringStack[++class51.scriptStringStackSize - 1] = class77.clanMembers[var32].username;
                                                                                                                     } else {
                                                                                                                        class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var36 = 1;
                                                                                                                  } else if(var54 == 3614) {
                                                                                                                     var32 = class83.intStack[--class83.intStackSize];
                                                                                                                     if(Client.field1155 != null && var32 < class4.clanChatCount) {
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = class77.clanMembers[var32].world;
                                                                                                                     } else {
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                     }

                                                                                                                     var36 = 1;
                                                                                                                  } else if(var54 == 3615) {
                                                                                                                     var32 = class83.intStack[--class83.intStackSize];
                                                                                                                     if(Client.field1155 != null && var32 < class4.clanChatCount) {
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = class77.clanMembers[var32].rank;
                                                                                                                     } else {
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                     }

                                                                                                                     var36 = 1;
                                                                                                                  } else if(var54 == 3616) {
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = class251.field3390;
                                                                                                                     var36 = 1;
                                                                                                                  } else if(var54 == 3617) {
                                                                                                                     var57 = class83.scriptStringStack[--class51.scriptStringStackSize];
                                                                                                                     if(class77.clanMembers != null) {
                                                                                                                        Client.secretPacketBuffer1.putOpcode(39);
                                                                                                                        Client.secretPacketBuffer1.putByte(class5.method11(var57));
                                                                                                                        Client.secretPacketBuffer1.method3150(var57);
                                                                                                                     }

                                                                                                                     var36 = 1;
                                                                                                                  } else if(var54 == 3618) {
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = class29.field429;
                                                                                                                     var36 = 1;
                                                                                                                  } else if(var54 == 3619) {
                                                                                                                     var57 = class83.scriptStringStack[--class51.scriptStringStackSize];
                                                                                                                     if(!var57.equals("")) {
                                                                                                                        Client.secretPacketBuffer1.putOpcode(9);
                                                                                                                        Client.secretPacketBuffer1.putByte(class5.method11(var57));
                                                                                                                        Client.secretPacketBuffer1.method3150(var57);
                                                                                                                     }

                                                                                                                     var36 = 1;
                                                                                                                  } else if(var54 == 3620) {
                                                                                                                     Client.secretPacketBuffer1.putOpcode(9);
                                                                                                                     Client.secretPacketBuffer1.putByte(0);
                                                                                                                     var36 = 1;
                                                                                                                  } else if(var54 == 3621) {
                                                                                                                     if(Client.field1196 == 0) {
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                     } else {
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = Client.ignoreCount;
                                                                                                                     }

                                                                                                                     var36 = 1;
                                                                                                                  } else if(var54 == 3622) {
                                                                                                                     var32 = class83.intStack[--class83.intStackSize];
                                                                                                                     if(Client.field1196 != 0 && var32 < Client.ignoreCount) {
                                                                                                                        class83.scriptStringStack[++class51.scriptStringStackSize - 1] = Client.ignores[var32].name;
                                                                                                                        class83.scriptStringStack[++class51.scriptStringStackSize - 1] = Client.ignores[var32].previousName;
                                                                                                                     } else {
                                                                                                                        class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "";
                                                                                                                        class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var36 = 1;
                                                                                                                  } else if(var54 == 3623) {
                                                                                                                     label2859: {
                                                                                                                        var57 = class83.scriptStringStack[--class51.scriptStringStackSize];
                                                                                                                        var37 = "<img=0>";
                                                                                                                        if(!var57.startsWith(var37)) {
                                                                                                                           var34 = "<img=1>";
                                                                                                                           if(!var57.startsWith(var34)) {
                                                                                                                              break label2859;
                                                                                                                           }
                                                                                                                        }

                                                                                                                        var57 = var57.substring(7);
                                                                                                                     }

                                                                                                                     class83.intStack[++class83.intStackSize - 1] = class211.method3910(var57)?1:0;
                                                                                                                     var36 = 1;
                                                                                                                  } else if(var54 == 3624) {
                                                                                                                     var32 = class83.intStack[--class83.intStackSize];
                                                                                                                     if(class77.clanMembers != null && var32 < class4.clanChatCount && class77.clanMembers[var32].username.equalsIgnoreCase(World.localPlayer.name)) {
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = 1;
                                                                                                                     } else {
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                     }

                                                                                                                     var36 = 1;
                                                                                                                  } else if(var54 != 3625) {
                                                                                                                     var36 = 2;
                                                                                                                  } else {
                                                                                                                     if(Client.clanChatOwner != null) {
                                                                                                                        var60 = class83.scriptStringStack;
                                                                                                                        var78 = ++class51.scriptStringStackSize - 1;
                                                                                                                        var85 = Client.clanChatOwner;
                                                                                                                        var38 = 0L;
                                                                                                                        var24 = var85.length();

                                                                                                                        for(var25 = 0; var25 < var24; ++var25) {
                                                                                                                           var38 *= 37L;
                                                                                                                           var26 = var85.charAt(var25);
                                                                                                                           if(var26 >= 65 && var26 <= 90) {
                                                                                                                              var38 += (long)(var26 + 1 - 65);
                                                                                                                           } else if(var26 >= 97 && var26 <= 122) {
                                                                                                                              var38 += (long)(var26 + 1 - 97);
                                                                                                                           } else if(var26 >= 48 && var26 <= 57) {
                                                                                                                              var38 += (long)(var26 + 27 - 48);
                                                                                                                           }

                                                                                                                           if(var38 >= 177917621779460413L) {
                                                                                                                              break;
                                                                                                                           }
                                                                                                                        }

                                                                                                                        while(var38 % 37L == 0L && 0L != var38) {
                                                                                                                           var38 /= 37L;
                                                                                                                        }

                                                                                                                        var42 = Overlay.method4684(var38);
                                                                                                                        if(var42 == null) {
                                                                                                                           var42 = "";
                                                                                                                        }

                                                                                                                        var60[var78] = var42;
                                                                                                                     } else {
                                                                                                                        class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var36 = 1;
                                                                                                                  }
                                                                                                               }
                                                                                                            }

                                                                                                            var14 = var36;
                                                                                                         } else {
                                                                                                            int var45;
                                                                                                            boolean var101;
                                                                                                            if(var54 < 4000) {
                                                                                                               if(var54 == 3903) {
                                                                                                                  var32 = class83.intStack[--class83.intStackSize];
                                                                                                                  class83.intStack[++class83.intStackSize - 1] = Client.grandExchangeOffers[var32].method93();
                                                                                                                  var36 = 1;
                                                                                                               } else if(var54 == 3904) {
                                                                                                                  var32 = class83.intStack[--class83.intStackSize];
                                                                                                                  class83.intStack[++class83.intStackSize - 1] = Client.grandExchangeOffers[var32].itemId;
                                                                                                                  var36 = 1;
                                                                                                               } else if(var54 == 3905) {
                                                                                                                  var32 = class83.intStack[--class83.intStackSize];
                                                                                                                  class83.intStack[++class83.intStackSize - 1] = Client.grandExchangeOffers[var32].price;
                                                                                                                  var36 = 1;
                                                                                                               } else if(var54 == 3906) {
                                                                                                                  var32 = class83.intStack[--class83.intStackSize];
                                                                                                                  class83.intStack[++class83.intStackSize - 1] = Client.grandExchangeOffers[var32].totalQuantity;
                                                                                                                  var36 = 1;
                                                                                                               } else if(var54 == 3907) {
                                                                                                                  var32 = class83.intStack[--class83.intStackSize];
                                                                                                                  class83.intStack[++class83.intStackSize - 1] = Client.grandExchangeOffers[var32].quantitySold;
                                                                                                                  var36 = 1;
                                                                                                               } else if(var54 == 3908) {
                                                                                                                  var32 = class83.intStack[--class83.intStackSize];
                                                                                                                  class83.intStack[++class83.intStackSize - 1] = Client.grandExchangeOffers[var32].spent;
                                                                                                                  var36 = 1;
                                                                                                               } else if(var54 == 3910) {
                                                                                                                  var32 = class83.intStack[--class83.intStackSize];
                                                                                                                  var78 = Client.grandExchangeOffers[var32].method86();
                                                                                                                  class83.intStack[++class83.intStackSize - 1] = var78 == 0?1:0;
                                                                                                                  var36 = 1;
                                                                                                               } else if(var54 == 3911) {
                                                                                                                  var32 = class83.intStack[--class83.intStackSize];
                                                                                                                  var78 = Client.grandExchangeOffers[var32].method86();
                                                                                                                  class83.intStack[++class83.intStackSize - 1] = var78 == 2?1:0;
                                                                                                                  var36 = 1;
                                                                                                               } else if(var54 == 3912) {
                                                                                                                  var32 = class83.intStack[--class83.intStackSize];
                                                                                                                  var78 = Client.grandExchangeOffers[var32].method86();
                                                                                                                  class83.intStack[++class83.intStackSize - 1] = var78 == 5?1:0;
                                                                                                                  var36 = 1;
                                                                                                               } else if(var54 == 3913) {
                                                                                                                  var32 = class83.intStack[--class83.intStackSize];
                                                                                                                  var78 = Client.grandExchangeOffers[var32].method86();
                                                                                                                  class83.intStack[++class83.intStackSize - 1] = var78 == 1?1:0;
                                                                                                                  var36 = 1;
                                                                                                               } else if(var54 == 3914) {
                                                                                                                  var101 = class83.intStack[--class83.intStackSize] == 1;
                                                                                                                  if(class214.field2633 != null) {
                                                                                                                     class214.field2633.method68(class13.field275, var101);
                                                                                                                  }

                                                                                                                  var36 = 1;
                                                                                                               } else if(var54 == 3915) {
                                                                                                                  var101 = class83.intStack[--class83.intStackSize] == 1;
                                                                                                                  if(class214.field2633 != null) {
                                                                                                                     class214.field2633.method68(class13.field274, var101);
                                                                                                                  }

                                                                                                                  var36 = 1;
                                                                                                               } else if(var54 == 3916) {
                                                                                                                  class83.intStackSize -= 2;
                                                                                                                  var101 = class83.intStack[class83.intStackSize] == 1;
                                                                                                                  var31 = class83.intStack[class83.intStackSize + 1] == 1;
                                                                                                                  if(class214.field2633 != null) {
                                                                                                                     class214.field2633.method68(new class95(var31), var101);
                                                                                                                  }

                                                                                                                  var36 = 1;
                                                                                                               } else if(var54 == 3917) {
                                                                                                                  var101 = class83.intStack[--class83.intStackSize] == 1;
                                                                                                                  if(class214.field2633 != null) {
                                                                                                                     class214.field2633.method68(class13.field273, var101);
                                                                                                                  }

                                                                                                                  var36 = 1;
                                                                                                               } else if(var54 == 3918) {
                                                                                                                  var101 = class83.intStack[--class83.intStackSize] == 1;
                                                                                                                  if(class214.field2633 != null) {
                                                                                                                     class214.field2633.method68(class13.field276, var101);
                                                                                                                  }

                                                                                                                  var36 = 1;
                                                                                                               } else if(var54 == 3919) {
                                                                                                                  class83.intStack[++class83.intStackSize - 1] = class214.field2633 == null?0:class214.field2633.field272.size();
                                                                                                                  var36 = 1;
                                                                                                               } else {
                                                                                                                  class14 var63;
                                                                                                                  if(var54 == 3920) {
                                                                                                                     var32 = class83.intStack[--class83.intStackSize];
                                                                                                                     var63 = (class14)class214.field2633.field272.get(var32);
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = var63.field288;
                                                                                                                     var36 = 1;
                                                                                                                  } else if(var54 == 3921) {
                                                                                                                     var32 = class83.intStack[--class83.intStackSize];
                                                                                                                     var63 = (class14)class214.field2633.field272.get(var32);
                                                                                                                     class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var63.method72();
                                                                                                                     var36 = 1;
                                                                                                                  } else if(var54 == 3922) {
                                                                                                                     var32 = class83.intStack[--class83.intStackSize];
                                                                                                                     var63 = (class14)class214.field2633.field272.get(var32);
                                                                                                                     class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var63.method70();
                                                                                                                     var36 = 1;
                                                                                                                  } else if(var54 == 3923) {
                                                                                                                     var32 = class83.intStack[--class83.intStackSize];
                                                                                                                     var63 = (class14)class214.field2633.field272.get(var32);
                                                                                                                     long var43 = XGrandExchangeOffer.method96() - class28.field414 - var63.field290;
                                                                                                                     var20 = (int)(var43 / 3600000L);
                                                                                                                     var45 = (int)((var43 - (long)(var20 * 3600000)) / 60000L);
                                                                                                                     var22 = (int)((var43 - (long)(var20 * 3600000) - (long)(var45 * '\uea60')) / 1000L);
                                                                                                                     String var23 = var20 + ":" + var45 / 10 + var45 % 10 + ":" + var22 / 10 + var22 % 10;
                                                                                                                     class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var23;
                                                                                                                     var36 = 1;
                                                                                                                  } else if(var54 == 3924) {
                                                                                                                     var32 = class83.intStack[--class83.intStackSize];
                                                                                                                     var63 = (class14)class214.field2633.field272.get(var32);
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = var63.field286.totalQuantity;
                                                                                                                     var36 = 1;
                                                                                                                  } else if(var54 == 3925) {
                                                                                                                     var32 = class83.intStack[--class83.intStackSize];
                                                                                                                     var63 = (class14)class214.field2633.field272.get(var32);
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = var63.field286.price;
                                                                                                                     var36 = 1;
                                                                                                                  } else if(var54 == 3926) {
                                                                                                                     var32 = class83.intStack[--class83.intStackSize];
                                                                                                                     var63 = (class14)class214.field2633.field272.get(var32);
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = var63.field286.itemId;
                                                                                                                     var36 = 1;
                                                                                                                  } else {
                                                                                                                     var36 = 2;
                                                                                                                  }
                                                                                                               }

                                                                                                               var14 = var36;
                                                                                                            } else if(var54 < 4100) {
                                                                                                               var14 = class67.method1081(var54, var3, var61);
                                                                                                            } else if(var54 < 4200) {
                                                                                                               var14 = class36.method483(var54, var3, var61);
                                                                                                            } else {
                                                                                                               boolean var19;
                                                                                                               int var47;
                                                                                                               if(var54 < 4300) {
                                                                                                                  if(var54 == 4200) {
                                                                                                                     var32 = class83.intStack[--class83.intStackSize];
                                                                                                                     class83.scriptStringStack[++class51.scriptStringStackSize - 1] = Buffer.getItemDefinition(var32).name;
                                                                                                                     var36 = 1;
                                                                                                                  } else {
                                                                                                                     ItemComposition var92;
                                                                                                                     if(var54 == 4201) {
                                                                                                                        class83.intStackSize -= 2;
                                                                                                                        var32 = class83.intStack[class83.intStackSize];
                                                                                                                        var78 = class83.intStack[class83.intStackSize + 1];
                                                                                                                        var92 = Buffer.getItemDefinition(var32);
                                                                                                                        if(var78 >= 1 && var78 <= 5 && var92.groundActions[var78 - 1] != null) {
                                                                                                                           class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var92.groundActions[var78 - 1];
                                                                                                                        } else {
                                                                                                                           class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "";
                                                                                                                        }

                                                                                                                        var36 = 1;
                                                                                                                     } else if(var54 == 4202) {
                                                                                                                        class83.intStackSize -= 2;
                                                                                                                        var32 = class83.intStack[class83.intStackSize];
                                                                                                                        var78 = class83.intStack[class83.intStackSize + 1];
                                                                                                                        var92 = Buffer.getItemDefinition(var32);
                                                                                                                        if(var78 >= 1 && var78 <= 5 && var92.inventoryActions[var78 - 1] != null) {
                                                                                                                           class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var92.inventoryActions[var78 - 1];
                                                                                                                        } else {
                                                                                                                           class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "";
                                                                                                                        }

                                                                                                                        var36 = 1;
                                                                                                                     } else if(var54 == 4203) {
                                                                                                                        var32 = class83.intStack[--class83.intStackSize];
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = Buffer.getItemDefinition(var32).price;
                                                                                                                        var36 = 1;
                                                                                                                     } else if(var54 == 4204) {
                                                                                                                        var32 = class83.intStack[--class83.intStackSize];
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = Buffer.getItemDefinition(var32).isStackable == 1?1:0;
                                                                                                                        var36 = 1;
                                                                                                                     } else {
                                                                                                                        ItemComposition var65;
                                                                                                                        if(var54 == 4205) {
                                                                                                                           var32 = class83.intStack[--class83.intStackSize];
                                                                                                                           var65 = Buffer.getItemDefinition(var32);
                                                                                                                           if(var65.notedTemplate == -1 && var65.note >= 0) {
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = var65.note;
                                                                                                                           } else {
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = var32;
                                                                                                                           }

                                                                                                                           var36 = 1;
                                                                                                                        } else if(var54 == 4206) {
                                                                                                                           var32 = class83.intStack[--class83.intStackSize];
                                                                                                                           var65 = Buffer.getItemDefinition(var32);
                                                                                                                           if(var65.notedTemplate >= 0 && var65.note >= 0) {
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = var65.note;
                                                                                                                           } else {
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = var32;
                                                                                                                           }

                                                                                                                           var36 = 1;
                                                                                                                        } else if(var54 == 4207) {
                                                                                                                           var32 = class83.intStack[--class83.intStackSize];
                                                                                                                           class83.intStack[++class83.intStackSize - 1] = Buffer.getItemDefinition(var32).isMembers?1:0;
                                                                                                                           var36 = 1;
                                                                                                                        } else if(var54 == 4208) {
                                                                                                                           var32 = class83.intStack[--class83.intStackSize];
                                                                                                                           var65 = Buffer.getItemDefinition(var32);
                                                                                                                           if(var65.field3536 == -1 && var65.field3535 >= 0) {
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = var65.field3535;
                                                                                                                           } else {
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = var32;
                                                                                                                           }

                                                                                                                           var36 = 1;
                                                                                                                        } else if(var54 == 4209) {
                                                                                                                           var32 = class83.intStack[--class83.intStackSize];
                                                                                                                           var65 = Buffer.getItemDefinition(var32);
                                                                                                                           if(var65.field3536 >= 0 && var65.field3535 >= 0) {
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = var65.field3535;
                                                                                                                           } else {
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = var32;
                                                                                                                           }

                                                                                                                           var36 = 1;
                                                                                                                        } else if(var54 == 4210) {
                                                                                                                           var57 = class83.scriptStringStack[--class51.scriptStringStackSize];
                                                                                                                           var78 = class83.intStack[--class83.intStackSize];
                                                                                                                           var19 = var78 == 1;
                                                                                                                           var37 = var57.toLowerCase();
                                                                                                                           short[] var84 = new short[16];
                                                                                                                           var45 = 0;
                                                                                                                           var22 = 0;

                                                                                                                           while(true) {
                                                                                                                              if(var22 >= ItemComposition.field3486) {
                                                                                                                                 class40.field543 = var84;
                                                                                                                                 Actor.field1291 = 0;
                                                                                                                                 class182.field2453 = var45;
                                                                                                                                 String[] var109 = new String[class182.field2453];

                                                                                                                                 for(var47 = 0; var47 < class182.field2453; ++var47) {
                                                                                                                                    var109[var47] = Buffer.getItemDefinition(var84[var47]).name;
                                                                                                                                 }

                                                                                                                                 class83.method1640(var109, class40.field543);
                                                                                                                                 break;
                                                                                                                              }

                                                                                                                              ItemComposition var69 = Buffer.getItemDefinition(var22);
                                                                                                                              if((!var19 || var69.field3532) && var69.notedTemplate == -1 && var69.name.toLowerCase().indexOf(var37) != -1) {
                                                                                                                                 if(var45 >= 250) {
                                                                                                                                    class182.field2453 = -1;
                                                                                                                                    class40.field543 = null;
                                                                                                                                    break;
                                                                                                                                 }

                                                                                                                                 if(var45 >= var84.length) {
                                                                                                                                    short[] var46 = new short[var84.length * 2];

                                                                                                                                    for(var25 = 0; var25 < var45; ++var25) {
                                                                                                                                       var46[var25] = var84[var25];
                                                                                                                                    }

                                                                                                                                    var84 = var46;
                                                                                                                                 }

                                                                                                                                 var84[var45++] = (short)var22;
                                                                                                                              }

                                                                                                                              ++var22;
                                                                                                                           }

                                                                                                                           class83.intStack[++class83.intStackSize - 1] = class182.field2453;
                                                                                                                           var36 = 1;
                                                                                                                        } else if(var54 != 4211) {
                                                                                                                           if(var54 == 4212) {
                                                                                                                              Actor.field1291 = 0;
                                                                                                                              var36 = 1;
                                                                                                                           } else {
                                                                                                                              var36 = 2;
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class40.field543 != null && Actor.field1291 < class182.field2453) {
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = class40.field543[++Actor.field1291 - 1] & '\uffff';
                                                                                                                           } else {
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                           }

                                                                                                                           var36 = 1;
                                                                                                                        }
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var14 = var36;
                                                                                                               } else {
                                                                                                                  byte[] var70;
                                                                                                                  if(var54 < 5100) {
                                                                                                                     if(var54 == 5000) {
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = Client.field1031;
                                                                                                                        var36 = 1;
                                                                                                                     } else if(var54 == 5001) {
                                                                                                                        class83.intStackSize -= 3;
                                                                                                                        Client.field1031 = class83.intStack[class83.intStackSize];
                                                                                                                        var78 = class83.intStack[class83.intStackSize + 1];
                                                                                                                        class276[] var100 = class208.method3865();
                                                                                                                        var62 = 0;

                                                                                                                        class276 var93;
                                                                                                                        while(true) {
                                                                                                                           if(var62 >= var100.length) {
                                                                                                                              var93 = null;
                                                                                                                              break;
                                                                                                                           }

                                                                                                                           class276 var90 = var100[var62];
                                                                                                                           if(var78 == var90.field3737) {
                                                                                                                              var93 = var90;
                                                                                                                              break;
                                                                                                                           }

                                                                                                                           ++var62;
                                                                                                                        }

                                                                                                                        class56.field695 = var93;
                                                                                                                        if(class56.field695 == null) {
                                                                                                                           class56.field695 = class276.field3734;
                                                                                                                        }

                                                                                                                        Client.field1147 = class83.intStack[class83.intStackSize + 2];
                                                                                                                        Client.secretPacketBuffer1.putOpcode(70);
                                                                                                                        Client.secretPacketBuffer1.putByte(Client.field1031);
                                                                                                                        Client.secretPacketBuffer1.putByte(class56.field695.field3737);
                                                                                                                        Client.secretPacketBuffer1.putByte(Client.field1147);
                                                                                                                        var36 = 1;
                                                                                                                     } else if(var54 == 5002) {
                                                                                                                        var57 = class83.scriptStringStack[--class51.scriptStringStackSize];
                                                                                                                        class83.intStackSize -= 2;
                                                                                                                        var78 = class83.intStack[class83.intStackSize];
                                                                                                                        var18 = class83.intStack[class83.intStackSize + 1];
                                                                                                                        Client.secretPacketBuffer1.putOpcode(119);
                                                                                                                        Client.secretPacketBuffer1.putByte(class5.method11(var57) + 2);
                                                                                                                        Client.secretPacketBuffer1.method3150(var57);
                                                                                                                        Client.secretPacketBuffer1.putByte(var78 - 1);
                                                                                                                        Client.secretPacketBuffer1.putByte(var18);
                                                                                                                        var36 = 1;
                                                                                                                     } else if(var54 == 5003) {
                                                                                                                        class83.intStackSize -= 2;
                                                                                                                        var32 = class83.intStack[class83.intStackSize];
                                                                                                                        var78 = class83.intStack[class83.intStackSize + 1];
                                                                                                                        MessageNode var99 = class21.method140(var32, var78);
                                                                                                                        if(var99 != null) {
                                                                                                                           class83.intStack[++class83.intStackSize - 1] = var99.id;
                                                                                                                           class83.intStack[++class83.intStackSize - 1] = var99.tick;
                                                                                                                           class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var99.name != null?var99.name:"";
                                                                                                                           class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var99.sender != null?var99.sender:"";
                                                                                                                           class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var99.value != null?var99.value:"";
                                                                                                                        } else {
                                                                                                                           class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                           class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                           class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "";
                                                                                                                           class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "";
                                                                                                                           class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "";
                                                                                                                        }

                                                                                                                        var36 = 1;
                                                                                                                     } else if(var54 == 5004) {
                                                                                                                        var32 = class83.intStack[--class83.intStackSize];
                                                                                                                        MessageNode var71 = class88.method1699(var32);
                                                                                                                        if(var71 != null) {
                                                                                                                           class83.intStack[++class83.intStackSize - 1] = var71.type;
                                                                                                                           class83.intStack[++class83.intStackSize - 1] = var71.tick;
                                                                                                                           class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var71.name != null?var71.name:"";
                                                                                                                           class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var71.sender != null?var71.sender:"";
                                                                                                                           class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var71.value != null?var71.value:"";
                                                                                                                        } else {
                                                                                                                           class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                           class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                           class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "";
                                                                                                                           class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "";
                                                                                                                           class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "";
                                                                                                                        }

                                                                                                                        var36 = 1;
                                                                                                                     } else if(var54 == 5005) {
                                                                                                                        if(class56.field695 == null) {
                                                                                                                           class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                        } else {
                                                                                                                           class83.intStack[++class83.intStackSize - 1] = class56.field695.field3737;
                                                                                                                        }

                                                                                                                        var36 = 1;
                                                                                                                     } else if(var54 == 5008) {
                                                                                                                        var57 = class83.scriptStringStack[--class51.scriptStringStackSize];
                                                                                                                        var78 = class83.intStack[--class83.intStackSize];
                                                                                                                        var37 = var57.toLowerCase();
                                                                                                                        byte var66 = 0;
                                                                                                                        if(var37.startsWith("yellow:")) {
                                                                                                                           var66 = 0;
                                                                                                                           var57 = var57.substring("yellow:".length());
                                                                                                                        } else if(var37.startsWith("red:")) {
                                                                                                                           var66 = 1;
                                                                                                                           var57 = var57.substring("red:".length());
                                                                                                                        } else if(var37.startsWith("green:")) {
                                                                                                                           var66 = 2;
                                                                                                                           var57 = var57.substring("green:".length());
                                                                                                                        } else if(var37.startsWith("cyan:")) {
                                                                                                                           var66 = 3;
                                                                                                                           var57 = var57.substring("cyan:".length());
                                                                                                                        } else if(var37.startsWith("purple:")) {
                                                                                                                           var66 = 4;
                                                                                                                           var57 = var57.substring("purple:".length());
                                                                                                                        } else if(var37.startsWith("white:")) {
                                                                                                                           var66 = 5;
                                                                                                                           var57 = var57.substring("white:".length());
                                                                                                                        } else if(var37.startsWith("flash1:")) {
                                                                                                                           var66 = 6;
                                                                                                                           var57 = var57.substring("flash1:".length());
                                                                                                                        } else if(var37.startsWith("flash2:")) {
                                                                                                                           var66 = 7;
                                                                                                                           var57 = var57.substring("flash2:".length());
                                                                                                                        } else if(var37.startsWith("flash3:")) {
                                                                                                                           var66 = 8;
                                                                                                                           var57 = var57.substring("flash3:".length());
                                                                                                                        } else if(var37.startsWith("glow1:")) {
                                                                                                                           var66 = 9;
                                                                                                                           var57 = var57.substring("glow1:".length());
                                                                                                                        } else if(var37.startsWith("glow2:")) {
                                                                                                                           var66 = 10;
                                                                                                                           var57 = var57.substring("glow2:".length());
                                                                                                                        } else if(var37.startsWith("glow3:")) {
                                                                                                                           var66 = 11;
                                                                                                                           var57 = var57.substring("glow3:".length());
                                                                                                                        } else if(Client.field1077 != 0) {
                                                                                                                           if(var37.startsWith("yellow:")) {
                                                                                                                              var66 = 0;
                                                                                                                              var57 = var57.substring("yellow:".length());
                                                                                                                           } else if(var37.startsWith("red:")) {
                                                                                                                              var66 = 1;
                                                                                                                              var57 = var57.substring("red:".length());
                                                                                                                           } else if(var37.startsWith("green:")) {
                                                                                                                              var66 = 2;
                                                                                                                              var57 = var57.substring("green:".length());
                                                                                                                           } else if(var37.startsWith("cyan:")) {
                                                                                                                              var66 = 3;
                                                                                                                              var57 = var57.substring("cyan:".length());
                                                                                                                           } else if(var37.startsWith("purple:")) {
                                                                                                                              var66 = 4;
                                                                                                                              var57 = var57.substring("purple:".length());
                                                                                                                           } else if(var37.startsWith("white:")) {
                                                                                                                              var66 = 5;
                                                                                                                              var57 = var57.substring("white:".length());
                                                                                                                           } else if(var37.startsWith("flash1:")) {
                                                                                                                              var66 = 6;
                                                                                                                              var57 = var57.substring("flash1:".length());
                                                                                                                           } else if(var37.startsWith("flash2:")) {
                                                                                                                              var66 = 7;
                                                                                                                              var57 = var57.substring("flash2:".length());
                                                                                                                           } else if(var37.startsWith("flash3:")) {
                                                                                                                              var66 = 8;
                                                                                                                              var57 = var57.substring("flash3:".length());
                                                                                                                           } else if(var37.startsWith("glow1:")) {
                                                                                                                              var66 = 9;
                                                                                                                              var57 = var57.substring("glow1:".length());
                                                                                                                           } else if(var37.startsWith("glow2:")) {
                                                                                                                              var66 = 10;
                                                                                                                              var57 = var57.substring("glow2:".length());
                                                                                                                           } else if(var37.startsWith("glow3:")) {
                                                                                                                              var66 = 11;
                                                                                                                              var57 = var57.substring("glow3:".length());
                                                                                                                           }
                                                                                                                        }

                                                                                                                        var37 = var57.toLowerCase();
                                                                                                                        byte var64 = 0;
                                                                                                                        if(var37.startsWith("wave:")) {
                                                                                                                           var64 = 1;
                                                                                                                           var57 = var57.substring("wave:".length());
                                                                                                                        } else if(var37.startsWith("wave2:")) {
                                                                                                                           var64 = 2;
                                                                                                                           var57 = var57.substring("wave2:".length());
                                                                                                                        } else if(var37.startsWith("shake:")) {
                                                                                                                           var64 = 3;
                                                                                                                           var57 = var57.substring("shake:".length());
                                                                                                                        } else if(var37.startsWith("scroll:")) {
                                                                                                                           var64 = 4;
                                                                                                                           var57 = var57.substring("scroll:".length());
                                                                                                                        } else if(var37.startsWith("slide:")) {
                                                                                                                           var64 = 5;
                                                                                                                           var57 = var57.substring("slide:".length());
                                                                                                                        } else if(Client.field1077 != 0) {
                                                                                                                           if(var37.startsWith("wave:")) {
                                                                                                                              var64 = 1;
                                                                                                                              var57 = var57.substring("wave:".length());
                                                                                                                           } else if(var37.startsWith("wave2:")) {
                                                                                                                              var64 = 2;
                                                                                                                              var57 = var57.substring("wave2:".length());
                                                                                                                           } else if(var37.startsWith("shake:")) {
                                                                                                                              var64 = 3;
                                                                                                                              var57 = var57.substring("shake:".length());
                                                                                                                           } else if(var37.startsWith("scroll:")) {
                                                                                                                              var64 = 4;
                                                                                                                              var57 = var57.substring("scroll:".length());
                                                                                                                           } else if(var37.startsWith("slide:")) {
                                                                                                                              var64 = 5;
                                                                                                                              var57 = var57.substring("slide:".length());
                                                                                                                           }
                                                                                                                        }

                                                                                                                        Client.secretPacketBuffer1.putOpcode(250);
                                                                                                                        Client.secretPacketBuffer1.putByte(0);
                                                                                                                        var45 = Client.secretPacketBuffer1.offset;
                                                                                                                        Client.secretPacketBuffer1.putByte(var78);
                                                                                                                        Client.secretPacketBuffer1.putByte(var66);
                                                                                                                        Client.secretPacketBuffer1.putByte(var64);
                                                                                                                        PacketBuffer var110 = Client.secretPacketBuffer1;
                                                                                                                        var47 = var110.offset;
                                                                                                                        var25 = var57.length();
                                                                                                                        byte[] var48 = new byte[var25];
                                                                                                                        int var27 = 0;

                                                                                                                        while(true) {
                                                                                                                           if(var27 >= var25) {
                                                                                                                              var110.method3139(var48.length);
                                                                                                                              var110.offset += class265.field3654.method3073(var48, 0, var48.length, var110.payload, var110.offset);
                                                                                                                              Client.secretPacketBuffer1.method3138(Client.secretPacketBuffer1.offset - var45);
                                                                                                                              var36 = 1;
                                                                                                                              break;
                                                                                                                           }

                                                                                                                           char var28 = var57.charAt(var27);
                                                                                                                           if(var28 > 0 && var28 < 128 || var28 >= 160 && var28 <= 255) {
                                                                                                                              var48[var27] = (byte)var28;
                                                                                                                           } else if(var28 == 8364) {
                                                                                                                              var48[var27] = -128;
                                                                                                                           } else if(var28 == 8218) {
                                                                                                                              var48[var27] = -126;
                                                                                                                           } else if(var28 == 402) {
                                                                                                                              var48[var27] = -125;
                                                                                                                           } else if(var28 == 8222) {
                                                                                                                              var48[var27] = -124;
                                                                                                                           } else if(var28 == 8230) {
                                                                                                                              var48[var27] = -123;
                                                                                                                           } else if(var28 == 8224) {
                                                                                                                              var48[var27] = -122;
                                                                                                                           } else if(var28 == 8225) {
                                                                                                                              var48[var27] = -121;
                                                                                                                           } else if(var28 == 710) {
                                                                                                                              var48[var27] = -120;
                                                                                                                           } else if(var28 == 8240) {
                                                                                                                              var48[var27] = -119;
                                                                                                                           } else if(var28 == 352) {
                                                                                                                              var48[var27] = -118;
                                                                                                                           } else if(var28 == 8249) {
                                                                                                                              var48[var27] = -117;
                                                                                                                           } else if(var28 == 338) {
                                                                                                                              var48[var27] = -116;
                                                                                                                           } else if(var28 == 381) {
                                                                                                                              var48[var27] = -114;
                                                                                                                           } else if(var28 == 8216) {
                                                                                                                              var48[var27] = -111;
                                                                                                                           } else if(var28 == 8217) {
                                                                                                                              var48[var27] = -110;
                                                                                                                           } else if(var28 == 8220) {
                                                                                                                              var48[var27] = -109;
                                                                                                                           } else if(var28 == 8221) {
                                                                                                                              var48[var27] = -108;
                                                                                                                           } else if(var28 == 8226) {
                                                                                                                              var48[var27] = -107;
                                                                                                                           } else if(var28 == 8211) {
                                                                                                                              var48[var27] = -106;
                                                                                                                           } else if(var28 == 8212) {
                                                                                                                              var48[var27] = -105;
                                                                                                                           } else if(var28 == 732) {
                                                                                                                              var48[var27] = -104;
                                                                                                                           } else if(var28 == 8482) {
                                                                                                                              var48[var27] = -103;
                                                                                                                           } else if(var28 == 353) {
                                                                                                                              var48[var27] = -102;
                                                                                                                           } else if(var28 == 8250) {
                                                                                                                              var48[var27] = -101;
                                                                                                                           } else if(var28 == 339) {
                                                                                                                              var48[var27] = -100;
                                                                                                                           } else if(var28 == 382) {
                                                                                                                              var48[var27] = -98;
                                                                                                                           } else if(var28 == 376) {
                                                                                                                              var48[var27] = -97;
                                                                                                                           } else {
                                                                                                                              var48[var27] = 63;
                                                                                                                           }

                                                                                                                           ++var27;
                                                                                                                        }
                                                                                                                     } else if(var54 == 5009) {
                                                                                                                        class51.scriptStringStackSize -= 2;
                                                                                                                        var57 = class83.scriptStringStack[class51.scriptStringStackSize];
                                                                                                                        var58 = class83.scriptStringStack[class51.scriptStringStackSize + 1];
                                                                                                                        Client.secretPacketBuffer1.putOpcode(117);
                                                                                                                        Client.secretPacketBuffer1.putShort(0);
                                                                                                                        var18 = Client.secretPacketBuffer1.offset;
                                                                                                                        Client.secretPacketBuffer1.method3150(var57);
                                                                                                                        PacketBuffer var94 = Client.secretPacketBuffer1;
                                                                                                                        var20 = var94.offset;
                                                                                                                        var22 = var58.length();
                                                                                                                        var70 = new byte[var22];
                                                                                                                        var24 = 0;

                                                                                                                        while(true) {
                                                                                                                           if(var24 >= var22) {
                                                                                                                              var94.method3139(var70.length);
                                                                                                                              var94.offset += class265.field3654.method3073(var70, 0, var70.length, var94.payload, var94.offset);
                                                                                                                              Client.secretPacketBuffer1.method3192(Client.secretPacketBuffer1.offset - var18);
                                                                                                                              var36 = 1;
                                                                                                                              break;
                                                                                                                           }

                                                                                                                           char var74 = var58.charAt(var24);
                                                                                                                           if((var74 <= 0 || var74 >= 128) && (var74 < 160 || var74 > 255)) {
                                                                                                                              if(var74 == 8364) {
                                                                                                                                 var70[var24] = -128;
                                                                                                                              } else if(var74 == 8218) {
                                                                                                                                 var70[var24] = -126;
                                                                                                                              } else if(var74 == 402) {
                                                                                                                                 var70[var24] = -125;
                                                                                                                              } else if(var74 == 8222) {
                                                                                                                                 var70[var24] = -124;
                                                                                                                              } else if(var74 == 8230) {
                                                                                                                                 var70[var24] = -123;
                                                                                                                              } else if(var74 == 8224) {
                                                                                                                                 var70[var24] = -122;
                                                                                                                              } else if(var74 == 8225) {
                                                                                                                                 var70[var24] = -121;
                                                                                                                              } else if(var74 == 710) {
                                                                                                                                 var70[var24] = -120;
                                                                                                                              } else if(var74 == 8240) {
                                                                                                                                 var70[var24] = -119;
                                                                                                                              } else if(var74 == 352) {
                                                                                                                                 var70[var24] = -118;
                                                                                                                              } else if(var74 == 8249) {
                                                                                                                                 var70[var24] = -117;
                                                                                                                              } else if(var74 == 338) {
                                                                                                                                 var70[var24] = -116;
                                                                                                                              } else if(var74 == 381) {
                                                                                                                                 var70[var24] = -114;
                                                                                                                              } else if(var74 == 8216) {
                                                                                                                                 var70[var24] = -111;
                                                                                                                              } else if(var74 == 8217) {
                                                                                                                                 var70[var24] = -110;
                                                                                                                              } else if(var74 == 8220) {
                                                                                                                                 var70[var24] = -109;
                                                                                                                              } else if(var74 == 8221) {
                                                                                                                                 var70[var24] = -108;
                                                                                                                              } else if(var74 == 8226) {
                                                                                                                                 var70[var24] = -107;
                                                                                                                              } else if(var74 == 8211) {
                                                                                                                                 var70[var24] = -106;
                                                                                                                              } else if(var74 == 8212) {
                                                                                                                                 var70[var24] = -105;
                                                                                                                              } else if(var74 == 732) {
                                                                                                                                 var70[var24] = -104;
                                                                                                                              } else if(var74 == 8482) {
                                                                                                                                 var70[var24] = -103;
                                                                                                                              } else if(var74 == 353) {
                                                                                                                                 var70[var24] = -102;
                                                                                                                              } else if(var74 == 8250) {
                                                                                                                                 var70[var24] = -101;
                                                                                                                              } else if(var74 == 339) {
                                                                                                                                 var70[var24] = -100;
                                                                                                                              } else if(var74 == 382) {
                                                                                                                                 var70[var24] = -98;
                                                                                                                              } else if(var74 == 376) {
                                                                                                                                 var70[var24] = -97;
                                                                                                                              } else {
                                                                                                                                 var70[var24] = 63;
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var70[var24] = (byte)var74;
                                                                                                                           }

                                                                                                                           ++var24;
                                                                                                                        }
                                                                                                                     } else if(var54 != 5015) {
                                                                                                                        if(var54 == 5016) {
                                                                                                                           class83.intStack[++class83.intStackSize - 1] = Client.field1147;
                                                                                                                           var36 = 1;
                                                                                                                        } else if(var54 == 5017) {
                                                                                                                           var32 = class83.intStack[--class83.intStackSize];
                                                                                                                           class83.intStack[++class83.intStackSize - 1] = Player.method1136(var32);
                                                                                                                           var36 = 1;
                                                                                                                        } else {
                                                                                                                           int[] var67;
                                                                                                                           MessageNode var88;
                                                                                                                           if(var54 == 5018) {
                                                                                                                              var32 = class83.intStack[--class83.intStackSize];
                                                                                                                              var67 = class83.intStack;
                                                                                                                              var18 = ++class83.intStackSize - 1;
                                                                                                                              var88 = (MessageNode)class98.field1532.method3475((long)var32);
                                                                                                                              if(var88 == null) {
                                                                                                                                 var62 = -1;
                                                                                                                              } else if(var88.previous == class98.field1534.field2499) {
                                                                                                                                 var62 = -1;
                                                                                                                              } else {
                                                                                                                                 var62 = ((MessageNode)var88.previous).id;
                                                                                                                              }

                                                                                                                              var67[var18] = var62;
                                                                                                                              var36 = 1;
                                                                                                                           } else if(var54 == 5019) {
                                                                                                                              var32 = class83.intStack[--class83.intStackSize];
                                                                                                                              var67 = class83.intStack;
                                                                                                                              var18 = ++class83.intStackSize - 1;
                                                                                                                              var88 = (MessageNode)class98.field1532.method3475((long)var32);
                                                                                                                              if(var88 == null) {
                                                                                                                                 var62 = -1;
                                                                                                                              } else if(var88.next == class98.field1534.field2499) {
                                                                                                                                 var62 = -1;
                                                                                                                              } else {
                                                                                                                                 var62 = ((MessageNode)var88.next).id;
                                                                                                                              }

                                                                                                                              var67[var18] = var62;
                                                                                                                              var36 = 1;
                                                                                                                           } else if(var54 == 5020) {
                                                                                                                              var57 = class83.scriptStringStack[--class51.scriptStringStackSize];
                                                                                                                              if(var57.equalsIgnoreCase("toggleroof")) {
                                                                                                                                 XGrandExchangeOffer.field303.field1333 = !XGrandExchangeOffer.field303.field1333;
                                                                                                                                 ScriptState.method1052();
                                                                                                                                 if(XGrandExchangeOffer.field303.field1333) {
                                                                                                                                    class18.sendGameMessage(99, "", "Roofs are now all hidden");
                                                                                                                                 } else {
                                                                                                                                    class18.sendGameMessage(99, "", "Roofs will only be removed selectively");
                                                                                                                                 }
                                                                                                                              }

                                                                                                                              if(var57.equalsIgnoreCase("displayfps")) {
                                                                                                                                 Client.field943 = !Client.field943;
                                                                                                                              }

                                                                                                                              if(var57.equalsIgnoreCase("clickbox")) {
                                                                                                                                 Model.field1998 = !Model.field1998;
                                                                                                                                 class18.sendGameMessage(99, "", "Clickbox Mode: " + (Model.field1998?"AABB":"Legacy"));
                                                                                                                              }

                                                                                                                              if(Client.field1097 >= 2) {
                                                                                                                                 if(var57.equalsIgnoreCase("aabb")) {
                                                                                                                                    if(!class7.field236) {
                                                                                                                                       class7.field236 = true;
                                                                                                                                       class7.field240 = class11.field263;
                                                                                                                                       class18.sendGameMessage(99, "", "AABB boxes: All");
                                                                                                                                    } else if(class7.field240 == class11.field263) {
                                                                                                                                       class7.field236 = true;
                                                                                                                                       class7.field240 = class11.field268;
                                                                                                                                       class18.sendGameMessage(99, "", "AABB boxes: Mouse Over");
                                                                                                                                    } else {
                                                                                                                                       class7.field236 = false;
                                                                                                                                       class18.sendGameMessage(99, "", "AABB boxes: Off");
                                                                                                                                    }
                                                                                                                                 }

                                                                                                                                 if(var57.equalsIgnoreCase("legacyboxes")) {
                                                                                                                                    class7.field235 = !class7.field235;
                                                                                                                                    class18.sendGameMessage(99, "", "Show legacy boxes: " + class7.field235);
                                                                                                                                 }

                                                                                                                                 if(var57.equalsIgnoreCase("geotests")) {
                                                                                                                                    class7.field237 = !class7.field237;
                                                                                                                                    class18.sendGameMessage(99, "", "Show geometry tests: " + class7.field237);
                                                                                                                                 }

                                                                                                                                 if(var57.equalsIgnoreCase("fpson")) {
                                                                                                                                    Client.field943 = true;
                                                                                                                                 }

                                                                                                                                 if(var57.equalsIgnoreCase("fpsoff")) {
                                                                                                                                    Client.field943 = false;
                                                                                                                                 }

                                                                                                                                 if(var57.equalsIgnoreCase("gc")) {
                                                                                                                                    System.gc();
                                                                                                                                 }

                                                                                                                                 if(var57.equalsIgnoreCase("clientdrop")) {
                                                                                                                                    class84.method1669();
                                                                                                                                 }

                                                                                                                                 if(var57.equalsIgnoreCase("errortest") && Client.field931 == 2) {
                                                                                                                                    throw new RuntimeException();
                                                                                                                                 }
                                                                                                                              }

                                                                                                                              Client.secretPacketBuffer1.putOpcode(106);
                                                                                                                              Client.secretPacketBuffer1.putByte(var57.length() + 1);
                                                                                                                              Client.secretPacketBuffer1.method3150(var57);
                                                                                                                              var36 = 1;
                                                                                                                           } else if(var54 == 5021) {
                                                                                                                              Client.field1148 = class83.scriptStringStack[--class51.scriptStringStackSize].toLowerCase().trim();
                                                                                                                              var36 = 1;
                                                                                                                           } else if(var54 == 5022) {
                                                                                                                              class83.scriptStringStack[++class51.scriptStringStackSize - 1] = Client.field1148;
                                                                                                                              var36 = 1;
                                                                                                                           } else {
                                                                                                                              var36 = 2;
                                                                                                                           }
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        if(World.localPlayer != null && World.localPlayer.name != null) {
                                                                                                                           var57 = World.localPlayer.name;
                                                                                                                        } else {
                                                                                                                           var57 = "";
                                                                                                                        }

                                                                                                                        class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var57;
                                                                                                                        var36 = 1;
                                                                                                                     }

                                                                                                                     var14 = var36;
                                                                                                                  } else if(var54 < 5400) {
                                                                                                                     var14 = class89.method1701(var54, var3, var61);
                                                                                                                  } else if(var54 < 5600) {
                                                                                                                     var14 = ISAACCipher.method3414(var54, var3, var61);
                                                                                                                  } else if(var54 < 5700) {
                                                                                                                     if(var54 == 5630) {
                                                                                                                        Client.field982 = 250;
                                                                                                                        var36 = 1;
                                                                                                                     } else {
                                                                                                                        var36 = 2;
                                                                                                                     }

                                                                                                                     var14 = var36;
                                                                                                                  } else if(var54 < 6300) {
                                                                                                                     var14 = class134.method2586(var54, var3, var61);
                                                                                                                  } else if(var54 < 6600) {
                                                                                                                     if(var54 == 6500) {
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = WorldMapType3.loadWorlds()?1:0;
                                                                                                                        var36 = 1;
                                                                                                                     } else {
                                                                                                                        World var96;
                                                                                                                        if(var54 == 6501) {
                                                                                                                           var96 = class154.method2943();
                                                                                                                           if(var96 != null) {
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = var96.id;
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = var96.mask;
                                                                                                                              class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var96.activity;
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = var96.location;
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = var96.playerCount;
                                                                                                                              class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var96.address;
                                                                                                                           } else {
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                              class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "";
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                              class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "";
                                                                                                                           }

                                                                                                                           var36 = 1;
                                                                                                                        } else if(var54 == 6502) {
                                                                                                                           var96 = class8.method32();
                                                                                                                           if(var96 != null) {
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = var96.id;
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = var96.mask;
                                                                                                                              class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var96.activity;
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = var96.location;
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = var96.playerCount;
                                                                                                                              class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var96.address;
                                                                                                                           } else {
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                              class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "";
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                              class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "";
                                                                                                                           }

                                                                                                                           var36 = 1;
                                                                                                                        } else {
                                                                                                                           World var72;
                                                                                                                           if(var54 == 6506) {
                                                                                                                              var32 = class83.intStack[--class83.intStackSize];
                                                                                                                              var72 = null;

                                                                                                                              for(var18 = 0; var18 < World.field1326; ++var18) {
                                                                                                                                 if(var32 == World.worldList[var18].id) {
                                                                                                                                    var72 = World.worldList[var18];
                                                                                                                                    break;
                                                                                                                                 }
                                                                                                                              }

                                                                                                                              if(var72 != null) {
                                                                                                                                 class83.intStack[++class83.intStackSize - 1] = var72.id;
                                                                                                                                 class83.intStack[++class83.intStackSize - 1] = var72.mask;
                                                                                                                                 class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var72.activity;
                                                                                                                                 class83.intStack[++class83.intStackSize - 1] = var72.location;
                                                                                                                                 class83.intStack[++class83.intStackSize - 1] = var72.playerCount;
                                                                                                                                 class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var72.address;
                                                                                                                              } else {
                                                                                                                                 class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                                 class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                                 class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "";
                                                                                                                                 class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                                 class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                                 class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "";
                                                                                                                              }

                                                                                                                              var36 = 1;
                                                                                                                           } else if(var54 == 6507) {
                                                                                                                              class83.intStackSize -= 4;
                                                                                                                              var32 = class83.intStack[class83.intStackSize];
                                                                                                                              var31 = class83.intStack[class83.intStackSize + 1] == 1;
                                                                                                                              var18 = class83.intStack[class83.intStackSize + 2];
                                                                                                                              var19 = class83.intStack[class83.intStackSize + 3] == 1;
                                                                                                                              if(World.worldList != null) {
                                                                                                                                 class4.method8(0, World.worldList.length - 1, var32, var31, var18, var19);
                                                                                                                              }

                                                                                                                              var36 = 1;
                                                                                                                           } else if(var54 != 6511) {
                                                                                                                              if(var54 == 6512) {
                                                                                                                                 Client.field1156 = class83.intStack[--class83.intStackSize] == 1;
                                                                                                                                 var36 = 1;
                                                                                                                              } else {
                                                                                                                                 class251 var103;
                                                                                                                                 if(var54 == 6513) {
                                                                                                                                    class83.intStackSize -= 2;
                                                                                                                                    var32 = class83.intStack[class83.intStackSize];
                                                                                                                                    var78 = class83.intStack[class83.intStackSize + 1];
                                                                                                                                    var103 = class39.method528(var78);
                                                                                                                                    if(var103.method4439()) {
                                                                                                                                       class83.scriptStringStack[++class51.scriptStringStackSize - 1] = class220.getNpcDefinition(var32).method4651(var78, var103.field3387);
                                                                                                                                    } else {
                                                                                                                                       class83.intStack[++class83.intStackSize - 1] = class220.getNpcDefinition(var32).method4650(var78, var103.field3386);
                                                                                                                                    }

                                                                                                                                    var36 = 1;
                                                                                                                                 } else if(var54 == 6514) {
                                                                                                                                    class83.intStackSize -= 2;
                                                                                                                                    var32 = class83.intStack[class83.intStackSize];
                                                                                                                                    var78 = class83.intStack[class83.intStackSize + 1];
                                                                                                                                    var103 = class39.method528(var78);
                                                                                                                                    if(var103.method4439()) {
                                                                                                                                       class83.scriptStringStack[++class51.scriptStringStackSize - 1] = class226.getObjectDefinition(var32).method4536(var78, var103.field3387);
                                                                                                                                    } else {
                                                                                                                                       class83.intStack[++class83.intStackSize - 1] = class226.getObjectDefinition(var32).method4535(var78, var103.field3386);
                                                                                                                                    }

                                                                                                                                    var36 = 1;
                                                                                                                                 } else if(var54 == 6515) {
                                                                                                                                    class83.intStackSize -= 2;
                                                                                                                                    var32 = class83.intStack[class83.intStackSize];
                                                                                                                                    var78 = class83.intStack[class83.intStackSize + 1];
                                                                                                                                    var103 = class39.method528(var78);
                                                                                                                                    if(var103.method4439()) {
                                                                                                                                       class83.scriptStringStack[++class51.scriptStringStackSize - 1] = Buffer.getItemDefinition(var32).method4637(var78, var103.field3387);
                                                                                                                                    } else {
                                                                                                                                       class83.intStack[++class83.intStackSize - 1] = Buffer.getItemDefinition(var32).method4583(var78, var103.field3386);
                                                                                                                                    }

                                                                                                                                    var36 = 1;
                                                                                                                                 } else if(var54 == 6516) {
                                                                                                                                    class83.intStackSize -= 2;
                                                                                                                                    var32 = class83.intStack[class83.intStackSize];
                                                                                                                                    var78 = class83.intStack[class83.intStackSize + 1];
                                                                                                                                    var103 = class39.method528(var78);
                                                                                                                                    class252 var68;
                                                                                                                                    class252 var111;
                                                                                                                                    if(var103.method4439()) {
                                                                                                                                       String[] var95 = class83.scriptStringStack;
                                                                                                                                       var20 = ++class51.scriptStringStackSize - 1;
                                                                                                                                       var111 = (class252)class252.field3392.get((long)var32);
                                                                                                                                       if(var111 != null) {
                                                                                                                                          var68 = var111;
                                                                                                                                       } else {
                                                                                                                                          var70 = class252.field3391.getConfigData(34, var32);
                                                                                                                                          var111 = new class252();
                                                                                                                                          if(var70 != null) {
                                                                                                                                             var111.method4460(new Buffer(var70));
                                                                                                                                          }

                                                                                                                                          var111.method4469();
                                                                                                                                          class252.field3392.put(var111, (long)var32);
                                                                                                                                          var68 = var111;
                                                                                                                                       }

                                                                                                                                       var95[var20] = var68.method4468(var78, var103.field3387);
                                                                                                                                    } else {
                                                                                                                                       int[] var97 = class83.intStack;
                                                                                                                                       var20 = ++class83.intStackSize - 1;
                                                                                                                                       var111 = (class252)class252.field3392.get((long)var32);
                                                                                                                                       if(var111 != null) {
                                                                                                                                          var68 = var111;
                                                                                                                                       } else {
                                                                                                                                          var70 = class252.field3391.getConfigData(34, var32);
                                                                                                                                          var111 = new class252();
                                                                                                                                          if(var70 != null) {
                                                                                                                                             var111.method4460(new Buffer(var70));
                                                                                                                                          }

                                                                                                                                          var111.method4469();
                                                                                                                                          class252.field3392.put(var111, (long)var32);
                                                                                                                                          var68 = var111;
                                                                                                                                       }

                                                                                                                                       var97[var20] = var68.method4462(var78, var103.field3386);
                                                                                                                                    }

                                                                                                                                    var36 = 1;
                                                                                                                                 } else {
                                                                                                                                    var36 = 2;
                                                                                                                                 }
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var32 = class83.intStack[--class83.intStackSize];
                                                                                                                              if(var32 >= 0 && var32 < World.field1326) {
                                                                                                                                 var72 = World.worldList[var32];
                                                                                                                                 class83.intStack[++class83.intStackSize - 1] = var72.id;
                                                                                                                                 class83.intStack[++class83.intStackSize - 1] = var72.mask;
                                                                                                                                 class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var72.activity;
                                                                                                                                 class83.intStack[++class83.intStackSize - 1] = var72.location;
                                                                                                                                 class83.intStack[++class83.intStackSize - 1] = var72.playerCount;
                                                                                                                                 class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var72.address;
                                                                                                                              } else {
                                                                                                                                 class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                                 class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                                 class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "";
                                                                                                                                 class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                                 class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                                 class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "";
                                                                                                                              }

                                                                                                                              var36 = 1;
                                                                                                                           }
                                                                                                                        }
                                                                                                                     }

                                                                                                                     var14 = var36;
                                                                                                                  } else if(var54 < 6700) {
                                                                                                                     if(var54 == 6600) {
                                                                                                                        var32 = FaceNormal.plane;
                                                                                                                        var78 = class41.baseX + (World.localPlayer.x >> 7);
                                                                                                                        var18 = WorldMapType3.baseY + (World.localPlayer.y >> 7);
                                                                                                                        Tile.method2489().method5234(var32, var78, var18, true);
                                                                                                                        var36 = 1;
                                                                                                                     } else {
                                                                                                                        WorldMapData var104;
                                                                                                                        if(var54 == 6601) {
                                                                                                                           var32 = class83.intStack[--class83.intStackSize];
                                                                                                                           var58 = "";
                                                                                                                           var104 = Tile.method2489().method5196(var32);
                                                                                                                           if(var104 != null) {
                                                                                                                              var58 = var104.method275();
                                                                                                                           }

                                                                                                                           class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var58;
                                                                                                                           var36 = 1;
                                                                                                                        } else if(var54 == 6602) {
                                                                                                                           var32 = class83.intStack[--class83.intStackSize];
                                                                                                                           Tile.method2489().method5181(var32);
                                                                                                                           var36 = 1;
                                                                                                                        } else if(var54 == 6603) {
                                                                                                                           class83.intStack[++class83.intStackSize - 1] = Tile.method2489().method5193();
                                                                                                                           var36 = 1;
                                                                                                                        } else if(var54 == 6604) {
                                                                                                                           var32 = class83.intStack[--class83.intStackSize];
                                                                                                                           Tile.method2489().method5240(var32);
                                                                                                                           var36 = 1;
                                                                                                                        } else if(var54 == 6605) {
                                                                                                                           class83.intStack[++class83.intStackSize - 1] = Tile.method2489().method5195()?1:0;
                                                                                                                           var36 = 1;
                                                                                                                        } else {
                                                                                                                           Coordinates var102;
                                                                                                                           if(var54 == 6606) {
                                                                                                                              var102 = new Coordinates(class83.intStack[--class83.intStackSize]);
                                                                                                                              Tile.method2489().method5197(var102.worldX, var102.worldY);
                                                                                                                              var36 = 1;
                                                                                                                           } else if(var54 == 6607) {
                                                                                                                              var102 = new Coordinates(class83.intStack[--class83.intStackSize]);
                                                                                                                              Tile.method2489().method5288(var102.worldX, var102.worldY);
                                                                                                                              var36 = 1;
                                                                                                                           } else if(var54 == 6608) {
                                                                                                                              var102 = new Coordinates(class83.intStack[--class83.intStackSize]);
                                                                                                                              Tile.method2489().method5199(var102.plane, var102.worldX, var102.worldY);
                                                                                                                              var36 = 1;
                                                                                                                           } else if(var54 == 6609) {
                                                                                                                              var102 = new Coordinates(class83.intStack[--class83.intStackSize]);
                                                                                                                              Tile.method2489().method5200(var102.plane, var102.worldX, var102.worldY);
                                                                                                                              var36 = 1;
                                                                                                                           } else if(var54 == 6610) {
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = Tile.method2489().method5258();
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = Tile.method2489().method5202();
                                                                                                                              var36 = 1;
                                                                                                                           } else {
                                                                                                                              WorldMapData var73;
                                                                                                                              if(var54 == 6611) {
                                                                                                                                 var32 = class83.intStack[--class83.intStackSize];
                                                                                                                                 var73 = Tile.method2489().method5196(var32);
                                                                                                                                 if(var73 == null) {
                                                                                                                                    class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                                 } else {
                                                                                                                                    class83.intStack[++class83.intStackSize - 1] = var73.method285().method3918();
                                                                                                                                 }

                                                                                                                                 var36 = 1;
                                                                                                                              } else if(var54 == 6612) {
                                                                                                                                 var32 = class83.intStack[--class83.intStackSize];
                                                                                                                                 var73 = Tile.method2489().method5196(var32);
                                                                                                                                 if(var73 == null) {
                                                                                                                                    class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                                    class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                                 } else {
                                                                                                                                    class83.intStack[++class83.intStackSize - 1] = (var73.method279() - var73.method303() + 1) * 64;
                                                                                                                                    class83.intStack[++class83.intStackSize - 1] = (var73.method281() - var73.method280() + 1) * 64;
                                                                                                                                 }

                                                                                                                                 var36 = 1;
                                                                                                                              } else if(var54 == 6613) {
                                                                                                                                 var32 = class83.intStack[--class83.intStackSize];
                                                                                                                                 var73 = Tile.method2489().method5196(var32);
                                                                                                                                 if(var73 == null) {
                                                                                                                                    class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                                    class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                                    class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                                    class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                                 } else {
                                                                                                                                    class83.intStack[++class83.intStackSize - 1] = var73.method303() * 64;
                                                                                                                                    class83.intStack[++class83.intStackSize - 1] = var73.method280() * 64;
                                                                                                                                    class83.intStack[++class83.intStackSize - 1] = var73.method279() * 64 + 64 - 1;
                                                                                                                                    class83.intStack[++class83.intStackSize - 1] = var73.method281() * 64 + 64 - 1;
                                                                                                                                 }

                                                                                                                                 var36 = 1;
                                                                                                                              } else if(var54 == 6614) {
                                                                                                                                 var32 = class83.intStack[--class83.intStackSize];
                                                                                                                                 var73 = Tile.method2489().method5196(var32);
                                                                                                                                 if(var73 == null) {
                                                                                                                                    class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                                 } else {
                                                                                                                                    class83.intStack[++class83.intStackSize - 1] = var73.method333();
                                                                                                                                 }

                                                                                                                                 var36 = 1;
                                                                                                                              } else if(var54 == 6615) {
                                                                                                                                 var102 = Tile.method2489().method5213();
                                                                                                                                 if(var102 == null) {
                                                                                                                                    class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                                    class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                                 } else {
                                                                                                                                    class83.intStack[++class83.intStackSize - 1] = var102.worldX;
                                                                                                                                    class83.intStack[++class83.intStackSize - 1] = var102.worldY;
                                                                                                                                 }

                                                                                                                                 var36 = 1;
                                                                                                                              } else if(var54 == 6616) {
                                                                                                                                 class83.intStack[++class83.intStackSize - 1] = Tile.method2489().method5208();
                                                                                                                                 var36 = 1;
                                                                                                                              } else if(var54 == 6617) {
                                                                                                                                 var102 = new Coordinates(class83.intStack[--class83.intStackSize]);
                                                                                                                                 var73 = Tile.method2489().method5183();
                                                                                                                                 if(var73 == null) {
                                                                                                                                    class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                                    class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                                    var36 = 1;
                                                                                                                                 } else {
                                                                                                                                    int[] var105 = var73.method269(var102.plane, var102.worldX, var102.worldY);
                                                                                                                                    if(var105 == null) {
                                                                                                                                       class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                                       class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                                    } else {
                                                                                                                                       class83.intStack[++class83.intStackSize - 1] = var105[0];
                                                                                                                                       class83.intStack[++class83.intStackSize - 1] = var105[1];
                                                                                                                                    }

                                                                                                                                    var36 = 1;
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 Coordinates var106;
                                                                                                                                 if(var54 == 6618) {
                                                                                                                                    var102 = new Coordinates(class83.intStack[--class83.intStackSize]);
                                                                                                                                    var73 = Tile.method2489().method5183();
                                                                                                                                    if(var73 == null) {
                                                                                                                                       class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                                       class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                                       var36 = 1;
                                                                                                                                    } else {
                                                                                                                                       var106 = var73.method270(var102.worldX, var102.worldY);
                                                                                                                                       if(var106 == null) {
                                                                                                                                          class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                                       } else {
                                                                                                                                          class83.intStack[++class83.intStackSize - 1] = var106.method3918();
                                                                                                                                       }

                                                                                                                                       var36 = 1;
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    Coordinates var75;
                                                                                                                                    if(var54 == 6619) {
                                                                                                                                       class83.intStackSize -= 2;
                                                                                                                                       var32 = class83.intStack[class83.intStackSize];
                                                                                                                                       var75 = new Coordinates(class83.intStack[class83.intStackSize + 1]);
                                                                                                                                       class34.method474(var32, var75, false);
                                                                                                                                       var36 = 1;
                                                                                                                                    } else if(var54 == 6620) {
                                                                                                                                       class83.intStackSize -= 2;
                                                                                                                                       var32 = class83.intStack[class83.intStackSize];
                                                                                                                                       var75 = new Coordinates(class83.intStack[class83.intStackSize + 1]);
                                                                                                                                       class34.method474(var32, var75, true);
                                                                                                                                       var36 = 1;
                                                                                                                                    } else if(var54 == 6621) {
                                                                                                                                       class83.intStackSize -= 2;
                                                                                                                                       var32 = class83.intStack[class83.intStackSize];
                                                                                                                                       var75 = new Coordinates(class83.intStack[class83.intStackSize + 1]);
                                                                                                                                       var104 = Tile.method2489().method5196(var32);
                                                                                                                                       if(var104 == null) {
                                                                                                                                          class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                                          var36 = 1;
                                                                                                                                       } else {
                                                                                                                                          class83.intStack[++class83.intStackSize - 1] = var104.method267(var75.plane, var75.worldX, var75.worldY)?1:0;
                                                                                                                                          var36 = 1;
                                                                                                                                       }
                                                                                                                                    } else if(var54 == 6622) {
                                                                                                                                       class83.intStack[++class83.intStackSize - 1] = Tile.method2489().method5294();
                                                                                                                                       class83.intStack[++class83.intStackSize - 1] = Tile.method2489().method5205();
                                                                                                                                       var36 = 1;
                                                                                                                                    } else if(var54 == 6623) {
                                                                                                                                       var102 = new Coordinates(class83.intStack[--class83.intStackSize]);
                                                                                                                                       var73 = Tile.method2489().method5179(var102.plane, var102.worldX, var102.worldY);
                                                                                                                                       if(var73 == null) {
                                                                                                                                          class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                                       } else {
                                                                                                                                          class83.intStack[++class83.intStackSize - 1] = var73.method277();
                                                                                                                                       }

                                                                                                                                       var36 = 1;
                                                                                                                                    } else if(var54 == 6624) {
                                                                                                                                       Tile.method2489().method5278(class83.intStack[--class83.intStackSize]);
                                                                                                                                       var36 = 1;
                                                                                                                                    } else if(var54 == 6625) {
                                                                                                                                       Tile.method2489().method5207();
                                                                                                                                       var36 = 1;
                                                                                                                                    } else if(var54 == 6626) {
                                                                                                                                       Tile.method2489().method5273(class83.intStack[--class83.intStackSize]);
                                                                                                                                       var36 = 1;
                                                                                                                                    } else if(var54 == 6627) {
                                                                                                                                       Tile.method2489().method5259();
                                                                                                                                       var36 = 1;
                                                                                                                                    } else if(var54 == 6628) {
                                                                                                                                       var101 = class83.intStack[--class83.intStackSize] == 1;
                                                                                                                                       Tile.method2489().method5210(var101);
                                                                                                                                       var36 = 1;
                                                                                                                                    } else if(var54 == 6629) {
                                                                                                                                       var32 = class83.intStack[--class83.intStackSize];
                                                                                                                                       Tile.method2489().method5211(var32);
                                                                                                                                       var36 = 1;
                                                                                                                                    } else if(var54 == 6630) {
                                                                                                                                       var32 = class83.intStack[--class83.intStackSize];
                                                                                                                                       Tile.method2489().method5212(var32);
                                                                                                                                       var36 = 1;
                                                                                                                                    } else if(var54 == 6631) {
                                                                                                                                       Tile.method2489().method5329();
                                                                                                                                       var36 = 1;
                                                                                                                                    } else if(var54 == 6632) {
                                                                                                                                       var101 = class83.intStack[--class83.intStackSize] == 1;
                                                                                                                                       Tile.method2489().method5214(var101);
                                                                                                                                       var36 = 1;
                                                                                                                                    } else if(var54 == 6633) {
                                                                                                                                       class83.intStackSize -= 2;
                                                                                                                                       var32 = class83.intStack[class83.intStackSize];
                                                                                                                                       var31 = class83.intStack[class83.intStackSize + 1] == 1;
                                                                                                                                       Tile.method2489().method5299(var32, var31);
                                                                                                                                       var36 = 1;
                                                                                                                                    } else if(var54 == 6634) {
                                                                                                                                       class83.intStackSize -= 2;
                                                                                                                                       var32 = class83.intStack[class83.intStackSize];
                                                                                                                                       var31 = class83.intStack[class83.intStackSize + 1] == 1;
                                                                                                                                       Tile.method2489().method5304(var32, var31);
                                                                                                                                       var36 = 1;
                                                                                                                                    } else if(var54 == 6635) {
                                                                                                                                       class83.intStack[++class83.intStackSize - 1] = Tile.method2489().method5217()?1:0;
                                                                                                                                       var36 = 1;
                                                                                                                                    } else if(var54 == 6636) {
                                                                                                                                       var32 = class83.intStack[--class83.intStackSize];
                                                                                                                                       class83.intStack[++class83.intStackSize - 1] = Tile.method2489().method5222(var32)?1:0;
                                                                                                                                       var36 = 1;
                                                                                                                                    } else if(var54 == 6637) {
                                                                                                                                       var32 = class83.intStack[--class83.intStackSize];
                                                                                                                                       class83.intStack[++class83.intStackSize - 1] = Tile.method2489().method5219(var32)?1:0;
                                                                                                                                       var36 = 1;
                                                                                                                                    } else if(var54 == 6638) {
                                                                                                                                       class83.intStackSize -= 2;
                                                                                                                                       var32 = class83.intStack[class83.intStackSize];
                                                                                                                                       var75 = new Coordinates(class83.intStack[class83.intStackSize + 1]);
                                                                                                                                       var106 = Tile.method2489().method5266(var32, var75);
                                                                                                                                       if(var106 == null) {
                                                                                                                                          class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                                       } else {
                                                                                                                                          class83.intStack[++class83.intStackSize - 1] = var106.method3918();
                                                                                                                                       }

                                                                                                                                       var36 = 1;
                                                                                                                                    } else {
                                                                                                                                       class39 var107;
                                                                                                                                       if(var54 == 6639) {
                                                                                                                                          var107 = Tile.method2489().method5232();
                                                                                                                                          if(var107 == null) {
                                                                                                                                             class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                                             class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                                          } else {
                                                                                                                                             class83.intStack[++class83.intStackSize - 1] = var107.field536;
                                                                                                                                             class83.intStack[++class83.intStackSize - 1] = var107.field525.method3918();
                                                                                                                                          }

                                                                                                                                          var36 = 1;
                                                                                                                                       } else if(var54 == 6640) {
                                                                                                                                          var107 = Tile.method2489().method5225();
                                                                                                                                          if(var107 == null) {
                                                                                                                                             class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                                             class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                                          } else {
                                                                                                                                             class83.intStack[++class83.intStackSize - 1] = var107.field536;
                                                                                                                                             class83.intStack[++class83.intStackSize - 1] = var107.field525.method3918();
                                                                                                                                          }

                                                                                                                                          var36 = 1;
                                                                                                                                       } else {
                                                                                                                                          class242 var76;
                                                                                                                                          if(var54 == 6693) {
                                                                                                                                             var32 = class83.intStack[--class83.intStackSize];
                                                                                                                                             var76 = class223.field2839[var32];
                                                                                                                                             if(var76.field3295 == null) {
                                                                                                                                                class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "";
                                                                                                                                             } else {
                                                                                                                                                class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var76.field3295;
                                                                                                                                             }

                                                                                                                                             var36 = 1;
                                                                                                                                          } else if(var54 == 6694) {
                                                                                                                                             var32 = class83.intStack[--class83.intStackSize];
                                                                                                                                             var76 = class223.field2839[var32];
                                                                                                                                             class83.intStack[++class83.intStackSize - 1] = var76.field3310;
                                                                                                                                             var36 = 1;
                                                                                                                                          } else if(var54 == 6695) {
                                                                                                                                             var32 = class83.intStack[--class83.intStackSize];
                                                                                                                                             var76 = class223.field2839[var32];
                                                                                                                                             if(var76 == null) {
                                                                                                                                                class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                                             } else {
                                                                                                                                                class83.intStack[++class83.intStackSize - 1] = var76.field3297;
                                                                                                                                             }

                                                                                                                                             var36 = 1;
                                                                                                                                          } else if(var54 == 6696) {
                                                                                                                                             var32 = class83.intStack[--class83.intStackSize];
                                                                                                                                             var76 = class223.field2839[var32];
                                                                                                                                             if(var76 == null) {
                                                                                                                                                class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                                             } else {
                                                                                                                                                class83.intStack[++class83.intStackSize - 1] = var76.field3293;
                                                                                                                                             }

                                                                                                                                             var36 = 1;
                                                                                                                                          } else if(var54 == 6697) {
                                                                                                                                             class83.intStack[++class83.intStackSize - 1] = class44.field585.field606;
                                                                                                                                             var36 = 1;
                                                                                                                                          } else if(var54 == 6698) {
                                                                                                                                             class83.intStack[++class83.intStackSize - 1] = class44.field585.field615.method3918();
                                                                                                                                             var36 = 1;
                                                                                                                                          } else if(var54 == 6699) {
                                                                                                                                             class83.intStack[++class83.intStackSize - 1] = class44.field585.field604.method3918();
                                                                                                                                             var36 = 1;
                                                                                                                                          } else {
                                                                                                                                             var36 = 2;
                                                                                                                                          }
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              }
                                                                                                                           }
                                                                                                                        }
                                                                                                                     }

                                                                                                                     var14 = var36;
                                                                                                                  } else {
                                                                                                                     var14 = 2;
                                                                                                                  }
                                                                                                               }
                                                                                                            }
                                                                                                         }
                                                                                                      }
                                                                                                   }
                                                                                                }
                                                                                             }

                                                                                             switch(var14) {
                                                                                             case 0:
                                                                                                return;
                                                                                             case 1:
                                                                                             default:
                                                                                                break;
                                                                                             case 2:
                                                                                                throw new IllegalStateException();
                                                                                             }
                                                                                          }
                                                                                       }
                                                                                    }
                                                                                 }
                                                                              }
                                                                           }
                                                                        }
                                                                     }
                                                                  }
                                                               }
                                                            }
                                                         }
                                                      }
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         } catch (Exception var53) {
            StringBuilder var51 = new StringBuilder(30);
            var51.append("").append(var3.hash).append(" ");

            for(var12 = class83.scriptStackCount - 1; var12 >= 0; --var12) {
               var51.append("").append(class83.scriptStack[var12].invokedFromScript.hash).append(" ");
            }

            var51.append("").append(var9);
            class21.method138(var51.toString(), var53);
         }
      }
   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-98057633"
   )
   static final void method1747() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var9;
      int var10;
      int var12;
      int var29;
      if(Client.field976 == 219) {
         var0 = Client.secretPacketBuffer2.readUnsignedByte();
         var1 = class88.field1418 + (var0 >> 4 & 7);
         var2 = (var0 & 7) + class207.field2593;
         var3 = var1 + Client.secretPacketBuffer2.readByte();
         var4 = var2 + Client.secretPacketBuffer2.readByte();
         var5 = Client.secretPacketBuffer2.readShort();
         var6 = Client.secretPacketBuffer2.readUnsignedShort();
         var7 = Client.secretPacketBuffer2.readUnsignedByte() * 4;
         var29 = Client.secretPacketBuffer2.readUnsignedByte() * 4;
         var9 = Client.secretPacketBuffer2.readUnsignedShort();
         var10 = Client.secretPacketBuffer2.readUnsignedShort();
         int var40 = Client.secretPacketBuffer2.readUnsignedByte();
         var12 = Client.secretPacketBuffer2.readUnsignedByte();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var6 != '\uffff') {
            var1 = var1 * 128 + 64;
            var2 = var2 * 128 + 64;
            var3 = var3 * 128 + 64;
            var4 = var4 * 128 + 64;
            Projectile var30 = new Projectile(var6, FaceNormal.plane, var1, var2, class21.method139(var1, var2, FaceNormal.plane) - var7, Client.gameCycle + var9, var10 + Client.gameCycle, var40, var12, var5, var29);
            var30.method1737(var3, var4, class21.method139(var3, var4, FaceNormal.plane) - var29, Client.gameCycle + var9);
            Client.projectiles.method3571(var30);
         }

      } else {
         Item var31;
         if(Client.field976 == 52) {
            var0 = Client.secretPacketBuffer2.method3178();
            var1 = Client.secretPacketBuffer2.method3314();
            var2 = class88.field1418 + (var1 >> 4 & 7);
            var3 = class207.field2593 + (var1 & 7);
            if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
               Deque var33 = Client.groundItemDeque[FaceNormal.plane][var2][var3];
               if(var33 != null) {
                  for(var31 = (Item)var33.method3576(); var31 != null; var31 = (Item)var33.method3578()) {
                     if(var31.id == (var0 & 32767)) {
                        var31.unlink();
                        break;
                     }
                  }

                  if(var33.method3576() == null) {
                     Client.groundItemDeque[FaceNormal.plane][var2][var3] = null;
                  }

                  World.groundItemSpawned(var2, var3);
               }
            }

         } else {
            if(Client.field976 == 191) {
               var0 = Client.secretPacketBuffer2.readUnsignedByte();
               var1 = class88.field1418 + (var0 >> 4 & 7);
               var2 = class207.field2593 + (var0 & 7);
               var3 = Client.secretPacketBuffer2.readUnsignedShort();
               var4 = Client.secretPacketBuffer2.readUnsignedByte();
               var5 = var4 >> 4 & 15;
               var6 = var4 & 7;
               var7 = Client.secretPacketBuffer2.readUnsignedByte();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  var29 = var5 + 1;
                  if(World.localPlayer.pathX[0] >= var1 - var29 && World.localPlayer.pathX[0] <= var29 + var1 && World.localPlayer.pathY[0] >= var2 - var29 && World.localPlayer.pathY[0] <= var29 + var2 && Client.field1169 != 0 && var6 > 0 && Client.field1061 < 50) {
                     Client.field1171[Client.field1061] = var3;
                     Client.field1018[Client.field1061] = var6;
                     Client.field1028[Client.field1061] = var7;
                     Client.field1008[Client.field1061] = null;
                     Client.field956[Client.field1061] = var5 + (var1 << 16) + (var2 << 8);
                     ++Client.field1061;
                  }
               }
            }

            if(Client.field976 == 99) {
               var0 = Client.secretPacketBuffer2.readUnsignedByte();
               var1 = var0 >> 2;
               var2 = var0 & 3;
               var3 = Client.field1022[var1];
               var4 = Client.secretPacketBuffer2.method3314();
               var5 = (var4 >> 4 & 7) + class88.field1418;
               var6 = (var4 & 7) + class207.field2593;
               var7 = Client.secretPacketBuffer2.method3177();
               if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                  class165.method3078(FaceNormal.plane, var5, var6, var3, var7, var1, var2, 0, -1);
               }

            } else {
               if(Client.field976 == 95) {
                  byte var35 = Client.secretPacketBuffer2.method3171();
                  var1 = Client.secretPacketBuffer2.readUnsignedShort();
                  byte var36 = Client.secretPacketBuffer2.method3171();
                  var3 = Client.secretPacketBuffer2.method3168();
                  var4 = (var3 >> 4 & 7) + class88.field1418;
                  var5 = class207.field2593 + (var3 & 7);
                  var6 = Client.secretPacketBuffer2.method3169();
                  var7 = var6 >> 2;
                  var29 = var6 & 3;
                  var9 = Client.field1022[var7];
                  var10 = Client.secretPacketBuffer2.method3177();
                  byte var11 = Client.secretPacketBuffer2.method3171();
                  var12 = Client.secretPacketBuffer2.readUnsignedShort();
                  int var13 = Client.secretPacketBuffer2.method3177();
                  byte var14 = Client.secretPacketBuffer2.method3172();
                  Player var15;
                  if(Client.localInteractingIndex == var10) {
                     var15 = World.localPlayer;
                  } else {
                     var15 = Client.cachedPlayers[var10];
                  }

                  if(var15 != null) {
                     ObjectComposition var16 = class226.getObjectDefinition(var1);
                     int var17;
                     int var18;
                     if(var29 != 1 && var29 != 3) {
                        var17 = var16.sizeX;
                        var18 = var16.sizeY;
                     } else {
                        var17 = var16.sizeY;
                        var18 = var16.sizeX;
                     }

                     int var19 = (var17 >> 1) + var4;
                     int var20 = var4 + (var17 + 1 >> 1);
                     int var21 = var5 + (var18 >> 1);
                     int var22 = (var18 + 1 >> 1) + var5;
                     int[][] var23 = class61.tileHeights[FaceNormal.plane];
                     int var24 = var23[var20][var21] + var23[var19][var21] + var23[var19][var22] + var23[var20][var22] >> 2;
                     int var25 = (var17 << 6) + (var4 << 7);
                     int var26 = (var18 << 6) + (var5 << 7);
                     Model var27 = var16.method4531(var7, var29, var23, var25, var24, var26);
                     if(var27 != null) {
                        class165.method3078(FaceNormal.plane, var4, var5, var9, -1, 0, 0, var13 + 1, var12 + 1);
                        var15.totalLevel = var13 + Client.gameCycle;
                        var15.field902 = Client.gameCycle + var12;
                        var15.model = var27;
                        var15.field900 = var17 * 64 + var4 * 128;
                        var15.field910 = var18 * 64 + var5 * 128;
                        var15.field894 = var24;
                        byte var28;
                        if(var36 > var11) {
                           var28 = var36;
                           var36 = var11;
                           var11 = var28;
                        }

                        if(var14 > var35) {
                           var28 = var14;
                           var14 = var35;
                           var35 = var28;
                        }

                        var15.field904 = var4 + var36;
                        var15.field889 = var4 + var11;
                        var15.field906 = var5 + var14;
                        var15.field907 = var35 + var5;
                     }
                  }
               }

               if(Client.field976 == 77) {
                  var0 = Client.secretPacketBuffer2.method3314();
                  var1 = (var0 >> 4 & 7) + class88.field1418;
                  var2 = class207.field2593 + (var0 & 7);
                  var3 = Client.secretPacketBuffer2.method3314();
                  var4 = var3 >> 2;
                  var5 = var3 & 3;
                  var6 = Client.field1022[var4];
                  var7 = Client.secretPacketBuffer2.method3176();
                  if(var1 >= 0 && var2 >= 0 && var1 < 103 && var2 < 103) {
                     if(var6 == 0) {
                        WallObject var8 = class1.region.method2696(FaceNormal.plane, var1, var2);
                        if(var8 != null) {
                           var9 = var8.hash >> 14 & 32767;
                           if(var4 == 2) {
                              var8.renderable1 = new class100(var9, 2, var5 + 4, FaceNormal.plane, var1, var2, var7, false, var8.renderable1);
                              var8.renderable2 = new class100(var9, 2, var5 + 1 & 3, FaceNormal.plane, var1, var2, var7, false, var8.renderable2);
                           } else {
                              var8.renderable1 = new class100(var9, var4, var5, FaceNormal.plane, var1, var2, var7, false, var8.renderable1);
                           }
                        }
                     }

                     if(var6 == 1) {
                        DecorativeObject var37 = class1.region.method2774(FaceNormal.plane, var1, var2);
                        if(var37 != null) {
                           var9 = var37.hash >> 14 & 32767;
                           if(var4 != 4 && var4 != 5) {
                              if(var4 == 6) {
                                 var37.renderable1 = new class100(var9, 4, var5 + 4, FaceNormal.plane, var1, var2, var7, false, var37.renderable1);
                              } else if(var4 == 7) {
                                 var37.renderable1 = new class100(var9, 4, (var5 + 2 & 3) + 4, FaceNormal.plane, var1, var2, var7, false, var37.renderable1);
                              } else if(var4 == 8) {
                                 var37.renderable1 = new class100(var9, 4, var5 + 4, FaceNormal.plane, var1, var2, var7, false, var37.renderable1);
                                 var37.renderable2 = new class100(var9, 4, (var5 + 2 & 3) + 4, FaceNormal.plane, var1, var2, var7, false, var37.renderable2);
                              }
                           } else {
                              var37.renderable1 = new class100(var9, 4, var5, FaceNormal.plane, var1, var2, var7, false, var37.renderable1);
                           }
                        }
                     }

                     if(var6 == 2) {
                        GameObject var38 = class1.region.method2698(FaceNormal.plane, var1, var2);
                        if(var4 == 11) {
                           var4 = 10;
                        }

                        if(var38 != null) {
                           var38.renderable = new class100(var38.hash >> 14 & 32767, var4, var5, FaceNormal.plane, var1, var2, var7, false, var38.renderable);
                        }
                     }

                     if(var6 == 3) {
                        GroundObject var39 = class1.region.method2699(FaceNormal.plane, var1, var2);
                        if(var39 != null) {
                           var39.renderable = new class100(var39.hash >> 14 & 32767, 22, var5, FaceNormal.plane, var1, var2, var7, false, var39.renderable);
                        }
                     }
                  }

               } else if(Client.field976 == 24) {
                  var0 = Client.secretPacketBuffer2.readUnsignedShort();
                  var1 = Client.secretPacketBuffer2.method3177();
                  var2 = Client.secretPacketBuffer2.method3169();
                  var3 = class88.field1418 + (var2 >> 4 & 7);
                  var4 = class207.field2593 + (var2 & 7);
                  if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                     var31 = new Item();
                     var31.id = var1;
                     var31.quantity = var0;
                     if(Client.groundItemDeque[FaceNormal.plane][var3][var4] == null) {
                        Client.groundItemDeque[FaceNormal.plane][var3][var4] = new Deque();
                     }

                     Client.groundItemDeque[FaceNormal.plane][var3][var4].method3571(var31);
                     World.groundItemSpawned(var3, var4);
                  }

               } else if(Client.field976 == 132) {
                  var0 = Client.secretPacketBuffer2.readUnsignedByte();
                  var1 = class88.field1418 + (var0 >> 4 & 7);
                  var2 = class207.field2593 + (var0 & 7);
                  var3 = Client.secretPacketBuffer2.readUnsignedShort();
                  var4 = Client.secretPacketBuffer2.readUnsignedByte();
                  var5 = Client.secretPacketBuffer2.readUnsignedShort();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var1 = var1 * 128 + 64;
                     var2 = var2 * 128 + 64;
                     class84 var41 = new class84(var3, FaceNormal.plane, var1, var2, class21.method139(var1, var2, FaceNormal.plane) - var4, var5, Client.gameCycle);
                     Client.field1172.method3571(var41);
                  }

               } else if(Client.field976 == 97) {
                  var0 = Client.secretPacketBuffer2.method3168();
                  var1 = var0 >> 2;
                  var2 = var0 & 3;
                  var3 = Client.field1022[var1];
                  var4 = Client.secretPacketBuffer2.method3168();
                  var5 = class88.field1418 + (var4 >> 4 & 7);
                  var6 = (var4 & 7) + class207.field2593;
                  if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                     class165.method3078(FaceNormal.plane, var5, var6, var3, -1, var1, var2, 0, -1);
                  }

               } else if(Client.field976 == 73) {
                  var0 = Client.secretPacketBuffer2.readUnsignedByte();
                  var1 = class88.field1418 + (var0 >> 4 & 7);
                  var2 = (var0 & 7) + class207.field2593;
                  var3 = Client.secretPacketBuffer2.readUnsignedShort();
                  var4 = Client.secretPacketBuffer2.readUnsignedShort();
                  var5 = Client.secretPacketBuffer2.readUnsignedShort();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     Deque var34 = Client.groundItemDeque[FaceNormal.plane][var1][var2];
                     if(var34 != null) {
                        for(Item var32 = (Item)var34.method3576(); var32 != null; var32 = (Item)var34.method3578()) {
                           if((var3 & 32767) == var32.id && var32.quantity == var4) {
                              var32.quantity = var5;
                              break;
                           }
                        }

                        World.groundItemSpawned(var1, var2);
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-999739001"
   )
   public static String method1748(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;
      int var5 = var1;

      int var8;
      for(int var6 = var1 + var2; var5 < var6; var3[var4++] = (char)var8) {
         int var7 = var0[var5++] & 255;
         if(var7 < 128) {
            if(var7 == 0) {
               var8 = '�';
            } else {
               var8 = var7;
            }
         } else if(var7 < 192) {
            var8 = '�';
         } else if(var7 < 224) {
            if(var5 < var6 && (var0[var5] & 192) == 128) {
               var8 = (var7 & 31) << 6 | var0[var5++] & 63;
               if(var8 < 128) {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else if(var7 < 240) {
            if(var5 + 1 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128) {
               var8 = (var7 & 15) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 < 2048) {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else if(var7 < 248) {
            if(var5 + 2 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128 && (var0[var5 + 2] & 192) == 128) {
               var8 = (var7 & 7) << 18 | (var0[var5++] & 63) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 >= 65536 && var8 <= 1114111) {
                  var8 = '�';
               } else {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else {
            var8 = '�';
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "1806248172"
   )
   static boolean method1749(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = class154.method2955(var0, World.field1331);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(class154.method2955(Client.friends[var3].name, World.field1331)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class154.method2955(World.localPlayer.name, World.field1331))) {
            return true;
         } else {
            return false;
         }
      }
   }
}
