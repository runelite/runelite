import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1528961309
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1254541689
   )
   @Export("y")
   int y;
   @ObfuscatedName("v")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1390956227
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1000294047
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;
   @ObfuscatedName("bb")
   static class184 field1308;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 745703895
   )
   @Export("x")
   int x;

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIBI)V",
      garbageValue = "891955784"
   )
   static final void method1625(Player var0, int var1, int var2, byte var3) {
      int var4 = var0.pathX[0];
      int var5 = var0.pathY[0];
      int var6 = var0.method232();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var8 = var0.method232();
            class119 var9 = class32.method768(var1, var2);
            CollisionData var10 = Client.collisionMaps[var0.field261];
            int[] var11 = Client.field570;
            int[] var12 = Client.field450;

            int var13;
            int var14;
            for(var13 = 0; var13 < 128; ++var13) {
               for(var14 = 0; var14 < 128; ++var14) {
                  class118.field1851[var13][var14] = 0;
                  class118.field1844[var13][var14] = 99999999;
               }
            }

            int var15;
            int var16;
            byte var17;
            byte var18;
            int var19;
            int var20;
            byte var21;
            int var22;
            int var24;
            int var25;
            int var26;
            int var27;
            int[][] var32;
            boolean var33;
            boolean var34;
            int var35;
            int var36;
            int var38;
            if(var8 == 1) {
               var15 = var4;
               var16 = var5;
               var17 = 64;
               var18 = 64;
               var19 = var4 - var17;
               var20 = var5 - var18;
               class118.field1851[var17][var18] = 99;
               class118.field1844[var17][var18] = 0;
               var21 = 0;
               var22 = 0;
               class118.field1843[var21] = var4;
               var38 = var21 + 1;
               class118.field1845[var21] = var5;
               var32 = var10.flags;

               while(true) {
                  if(var38 == var22) {
                     class118.field1842 = var15;
                     class118.field1846 = var16;
                     var34 = false;
                     break;
                  }

                  var15 = class118.field1843[var22];
                  var16 = class118.field1845[var22];
                  var22 = 1 + var22 & 4095;
                  var35 = var15 - var19;
                  var36 = var16 - var20;
                  var24 = var15 - var10.x;
                  var25 = var16 - var10.y;
                  if(var9.vmethod2386(1, var15, var16, var10)) {
                     class118.field1842 = var15;
                     class118.field1846 = var16;
                     var34 = true;
                     break;
                  }

                  var26 = 1 + class118.field1844[var35][var36];
                  if(var35 > 0 && class118.field1851[var35 - 1][var36] == 0 && (var32[var24 - 1][var25] & 19136776) == 0) {
                     class118.field1843[var38] = var15 - 1;
                     class118.field1845[var38] = var16;
                     var38 = var38 + 1 & 4095;
                     class118.field1851[var35 - 1][var36] = 2;
                     class118.field1844[var35 - 1][var36] = var26;
                  }

                  if(var35 < 127 && class118.field1851[var35 + 1][var36] == 0 && (var32[var24 + 1][var25] & 19136896) == 0) {
                     class118.field1843[var38] = 1 + var15;
                     class118.field1845[var38] = var16;
                     var38 = var38 + 1 & 4095;
                     class118.field1851[1 + var35][var36] = 8;
                     class118.field1844[var35 + 1][var36] = var26;
                  }

                  if(var36 > 0 && class118.field1851[var35][var36 - 1] == 0 && (var32[var24][var25 - 1] & 19136770) == 0) {
                     class118.field1843[var38] = var15;
                     class118.field1845[var38] = var16 - 1;
                     var38 = var38 + 1 & 4095;
                     class118.field1851[var35][var36 - 1] = 1;
                     class118.field1844[var35][var36 - 1] = var26;
                  }

                  if(var36 < 127 && class118.field1851[var35][var36 + 1] == 0 && (var32[var24][1 + var25] & 19136800) == 0) {
                     class118.field1843[var38] = var15;
                     class118.field1845[var38] = 1 + var16;
                     var38 = var38 + 1 & 4095;
                     class118.field1851[var35][1 + var36] = 4;
                     class118.field1844[var35][1 + var36] = var26;
                  }

                  if(var35 > 0 && var36 > 0 && class118.field1851[var35 - 1][var36 - 1] == 0 && (var32[var24 - 1][var25 - 1] & 19136782) == 0 && (var32[var24 - 1][var25] & 19136776) == 0 && (var32[var24][var25 - 1] & 19136770) == 0) {
                     class118.field1843[var38] = var15 - 1;
                     class118.field1845[var38] = var16 - 1;
                     var38 = 1 + var38 & 4095;
                     class118.field1851[var35 - 1][var36 - 1] = 3;
                     class118.field1844[var35 - 1][var36 - 1] = var26;
                  }

                  if(var35 < 127 && var36 > 0 && class118.field1851[1 + var35][var36 - 1] == 0 && (var32[1 + var24][var25 - 1] & 19136899) == 0 && (var32[var24 + 1][var25] & 19136896) == 0 && (var32[var24][var25 - 1] & 19136770) == 0) {
                     class118.field1843[var38] = var15 + 1;
                     class118.field1845[var38] = var16 - 1;
                     var38 = 1 + var38 & 4095;
                     class118.field1851[1 + var35][var36 - 1] = 9;
                     class118.field1844[var35 + 1][var36 - 1] = var26;
                  }

                  if(var35 > 0 && var36 < 127 && class118.field1851[var35 - 1][1 + var36] == 0 && (var32[var24 - 1][1 + var25] & 19136824) == 0 && (var32[var24 - 1][var25] & 19136776) == 0 && (var32[var24][1 + var25] & 19136800) == 0) {
                     class118.field1843[var38] = var15 - 1;
                     class118.field1845[var38] = 1 + var16;
                     var38 = 1 + var38 & 4095;
                     class118.field1851[var35 - 1][var36 + 1] = 6;
                     class118.field1844[var35 - 1][var36 + 1] = var26;
                  }

                  if(var35 < 127 && var36 < 127 && class118.field1851[var35 + 1][1 + var36] == 0 && (var32[1 + var24][1 + var25] & 19136992) == 0 && (var32[var24 + 1][var25] & 19136896) == 0 && (var32[var24][1 + var25] & 19136800) == 0) {
                     class118.field1843[var38] = var15 + 1;
                     class118.field1845[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class118.field1851[1 + var35][var36 + 1] = 12;
                     class118.field1844[var35 + 1][1 + var36] = var26;
                  }
               }

               var33 = var34;
            } else if(var8 == 2) {
               var33 = class16.method197(var4, var5, var9, var10);
            } else {
               var15 = var4;
               var16 = var5;
               var17 = 64;
               var18 = 64;
               var19 = var4 - var17;
               var20 = var5 - var18;
               class118.field1851[var17][var18] = 99;
               class118.field1844[var17][var18] = 0;
               var21 = 0;
               var22 = 0;
               class118.field1843[var21] = var4;
               var38 = var21 + 1;
               class118.field1845[var21] = var5;
               var32 = var10.flags;

               label736:
               while(true) {
                  label734:
                  while(true) {
                     do {
                        do {
                           do {
                              label711:
                              do {
                                 if(var38 == var22) {
                                    class118.field1842 = var15;
                                    class118.field1846 = var16;
                                    var34 = false;
                                    break label736;
                                 }

                                 var15 = class118.field1843[var22];
                                 var16 = class118.field1845[var22];
                                 var22 = 1 + var22 & 4095;
                                 var35 = var15 - var19;
                                 var36 = var16 - var20;
                                 var24 = var15 - var10.x;
                                 var25 = var16 - var10.y;
                                 if(var9.vmethod2386(var8, var15, var16, var10)) {
                                    class118.field1842 = var15;
                                    class118.field1846 = var16;
                                    var34 = true;
                                    break label736;
                                 }

                                 var26 = 1 + class118.field1844[var35][var36];
                                 if(var35 > 0 && class118.field1851[var35 - 1][var36] == 0 && (var32[var24 - 1][var25] & 19136782) == 0 && (var32[var24 - 1][var8 + var25 - 1] & 19136824) == 0) {
                                    var27 = 1;

                                    while(true) {
                                       if(var27 >= var8 - 1) {
                                          class118.field1843[var38] = var15 - 1;
                                          class118.field1845[var38] = var16;
                                          var38 = 1 + var38 & 4095;
                                          class118.field1851[var35 - 1][var36] = 2;
                                          class118.field1844[var35 - 1][var36] = var26;
                                          break;
                                       }

                                       if((var32[var24 - 1][var27 + var25] & 19136830) != 0) {
                                          break;
                                       }

                                       ++var27;
                                    }
                                 }

                                 if(var35 < 128 - var8 && class118.field1851[var35 + 1][var36] == 0 && (var32[var8 + var24][var25] & 19136899) == 0 && (var32[var24 + var8][var25 + var8 - 1] & 19136992) == 0) {
                                    var27 = 1;

                                    while(true) {
                                       if(var27 >= var8 - 1) {
                                          class118.field1843[var38] = var15 + 1;
                                          class118.field1845[var38] = var16;
                                          var38 = var38 + 1 & 4095;
                                          class118.field1851[var35 + 1][var36] = 8;
                                          class118.field1844[var35 + 1][var36] = var26;
                                          break;
                                       }

                                       if((var32[var24 + var8][var25 + var27] & 19136995) != 0) {
                                          break;
                                       }

                                       ++var27;
                                    }
                                 }

                                 if(var36 > 0 && class118.field1851[var35][var36 - 1] == 0 && (var32[var24][var25 - 1] & 19136782) == 0 && (var32[var8 + var24 - 1][var25 - 1] & 19136899) == 0) {
                                    var27 = 1;

                                    while(true) {
                                       if(var27 >= var8 - 1) {
                                          class118.field1843[var38] = var15;
                                          class118.field1845[var38] = var16 - 1;
                                          var38 = 1 + var38 & 4095;
                                          class118.field1851[var35][var36 - 1] = 1;
                                          class118.field1844[var35][var36 - 1] = var26;
                                          break;
                                       }

                                       if((var32[var27 + var24][var25 - 1] & 19136911) != 0) {
                                          break;
                                       }

                                       ++var27;
                                    }
                                 }

                                 if(var36 < 128 - var8 && class118.field1851[var35][var36 + 1] == 0 && (var32[var24][var8 + var25] & 19136824) == 0 && (var32[var8 + var24 - 1][var25 + var8] & 19136992) == 0) {
                                    var27 = 1;

                                    while(true) {
                                       if(var27 >= var8 - 1) {
                                          class118.field1843[var38] = var15;
                                          class118.field1845[var38] = var16 + 1;
                                          var38 = 1 + var38 & 4095;
                                          class118.field1851[var35][var36 + 1] = 4;
                                          class118.field1844[var35][1 + var36] = var26;
                                          break;
                                       }

                                       if((var32[var27 + var24][var25 + var8] & 19137016) != 0) {
                                          break;
                                       }

                                       ++var27;
                                    }
                                 }

                                 if(var35 > 0 && var36 > 0 && class118.field1851[var35 - 1][var36 - 1] == 0 && (var32[var24 - 1][var25 - 1] & 19136782) == 0) {
                                    var27 = 1;

                                    while(true) {
                                       if(var27 >= var8) {
                                          class118.field1843[var38] = var15 - 1;
                                          class118.field1845[var38] = var16 - 1;
                                          var38 = var38 + 1 & 4095;
                                          class118.field1851[var35 - 1][var36 - 1] = 3;
                                          class118.field1844[var35 - 1][var36 - 1] = var26;
                                          break;
                                       }

                                       if((var32[var24 - 1][var27 + (var25 - 1)] & 19136830) != 0 || (var32[var27 + (var24 - 1)][var25 - 1] & 19136911) != 0) {
                                          break;
                                       }

                                       ++var27;
                                    }
                                 }

                                 if(var35 < 128 - var8 && var36 > 0 && class118.field1851[1 + var35][var36 - 1] == 0 && (var32[var24 + var8][var25 - 1] & 19136899) == 0) {
                                    var27 = 1;

                                    while(true) {
                                       if(var27 >= var8) {
                                          class118.field1843[var38] = var15 + 1;
                                          class118.field1845[var38] = var16 - 1;
                                          var38 = var38 + 1 & 4095;
                                          class118.field1851[var35 + 1][var36 - 1] = 9;
                                          class118.field1844[1 + var35][var36 - 1] = var26;
                                          break;
                                       }

                                       if((var32[var24 + var8][var25 - 1 + var27] & 19136995) != 0 || (var32[var24 + var27][var25 - 1] & 19136911) != 0) {
                                          break;
                                       }

                                       ++var27;
                                    }
                                 }

                                 if(var35 > 0 && var36 < 128 - var8 && class118.field1851[var35 - 1][var36 + 1] == 0 && (var32[var24 - 1][var8 + var25] & 19136824) == 0) {
                                    for(var27 = 1; var27 < var8; ++var27) {
                                       if((var32[var24 - 1][var27 + var25] & 19136830) != 0 || (var32[var24 - 1 + var27][var8 + var25] & 19137016) != 0) {
                                          continue label711;
                                       }
                                    }

                                    class118.field1843[var38] = var15 - 1;
                                    class118.field1845[var38] = var16 + 1;
                                    var38 = var38 + 1 & 4095;
                                    class118.field1851[var35 - 1][1 + var36] = 6;
                                    class118.field1844[var35 - 1][1 + var36] = var26;
                                 }
                              } while(var35 >= 128 - var8);
                           } while(var36 >= 128 - var8);
                        } while(class118.field1851[1 + var35][1 + var36] != 0);
                     } while((var32[var8 + var24][var25 + var8] & 19136992) != 0);

                     for(var27 = 1; var27 < var8; ++var27) {
                        if((var32[var24 + var27][var25 + var8] & 19137016) != 0 || (var32[var8 + var24][var27 + var25] & 19136995) != 0) {
                           continue label734;
                        }
                     }

                     class118.field1843[var38] = 1 + var15;
                     class118.field1845[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class118.field1851[1 + var35][1 + var36] = 12;
                     class118.field1844[var35 + 1][var36 + 1] = var26;
                  }
               }

               var33 = var34;
            }

            int var7;
            label792: {
               var14 = var4 - 64;
               var15 = var5 - 64;
               var16 = class118.field1842;
               var35 = class118.field1846;
               if(!var33) {
                  var36 = Integer.MAX_VALUE;
                  var19 = Integer.MAX_VALUE;
                  byte var37 = 10;
                  var38 = var9.field1858;
                  var22 = var9.field1857;
                  int var23 = var9.field1861;
                  var24 = var9.field1856;

                  for(var25 = var38 - var37; var25 <= var37 + var38; ++var25) {
                     for(var26 = var22 - var37; var26 <= var37 + var22; ++var26) {
                        var27 = var25 - var14;
                        int var28 = var26 - var15;
                        if(var27 >= 0 && var28 >= 0 && var27 < 128 && var28 < 128 && class118.field1844[var27][var28] < 100) {
                           int var29 = 0;
                           if(var25 < var38) {
                              var29 = var38 - var25;
                           } else if(var25 > var38 + var23 - 1) {
                              var29 = var25 - (var38 + var23 - 1);
                           }

                           int var30 = 0;
                           if(var26 < var22) {
                              var30 = var22 - var26;
                           } else if(var26 > var22 + var24 - 1) {
                              var30 = var26 - (var24 + var22 - 1);
                           }

                           int var31 = var30 * var30 + var29 * var29;
                           if(var31 < var36 || var31 == var36 && class118.field1844[var27][var28] < var19) {
                              var36 = var31;
                              var19 = class118.field1844[var27][var28];
                              var16 = var25;
                              var35 = var26;
                           }
                        }
                     }
                  }

                  if(var36 == Integer.MAX_VALUE) {
                     var7 = -1;
                     break label792;
                  }
               }

               if(var4 == var16 && var35 == var5) {
                  var7 = 0;
               } else {
                  var18 = 0;
                  class118.field1843[var18] = var16;
                  var36 = var18 + 1;
                  class118.field1845[var18] = var35;

                  for(var19 = var20 = class118.field1851[var16 - var14][var35 - var15]; var16 != var4 || var35 != var5; var19 = class118.field1851[var16 - var14][var35 - var15]) {
                     if(var20 != var19) {
                        var20 = var19;
                        class118.field1843[var36] = var16;
                        class118.field1845[var36++] = var35;
                     }

                     if((var19 & 2) != 0) {
                        ++var16;
                     } else if((var19 & 8) != 0) {
                        --var16;
                     }

                     if((var19 & 1) != 0) {
                        ++var35;
                     } else if((var19 & 4) != 0) {
                        --var35;
                     }
                  }

                  var38 = 0;

                  while(var36-- > 0) {
                     var11[var38] = class118.field1843[var36];
                     var12[var38++] = class118.field1845[var36];
                     if(var38 >= var11.length) {
                        break;
                     }
                  }

                  var7 = var38;
               }
            }

            var13 = var7;
            if(var7 >= 1) {
               for(var14 = 0; var14 < var13 - 1; ++var14) {
                  var0.method245(Client.field570[var14], Client.field450[var14], var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;B)V",
      garbageValue = "23"
   )
   public static void method1626(class182 var0, class182 var1, class182 var2) {
      class196.field2890 = var0;
      class196.field2872 = var1;
      class196.field2873 = var2;
   }
}
