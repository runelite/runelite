import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
final class class12 implements Comparator {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("varbit_ref")
   public static IndexDataBase varbit_ref;
   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("indexTextures")
   static IndexData indexTextures;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lk;Lk;I)I",
      garbageValue = "-259508340"
   )
   int method64(class14 var1, class14 var2) {
      return var1.field291 < var2.field291?-1:(var2.field291 == var1.field291?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method64((class14)var1, (class14)var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIILfm;Lfa;Z[I[II)I",
      garbageValue = "1873738157"
   )
   public static int method76(int var0, int var1, int var2, class164 var3, CollisionData var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class163.field2204[var8][var9] = 0;
            class163.field2207[var8][var9] = 99999999;
         }
      }

      int var10;
      int var11;
      byte var12;
      byte var13;
      int var14;
      int var15;
      byte var16;
      int var17;
      int[][] var18;
      int var19;
      int var20;
      int var21;
      int var22;
      boolean var28;
      boolean var29;
      int var30;
      int var31;
      int var33;
      if(var2 == 1) {
         var10 = var0;
         var11 = var1;
         var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class163.field2204[var12][var13] = 99;
         class163.field2207[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class163.field2211[var16] = var0;
         var33 = var16 + 1;
         class163.field2212[var16] = var1;
         var18 = var4.flags;

         while(true) {
            if(var17 == var33) {
               class163.field2208 = var10;
               class163.field2209 = var11;
               var29 = false;
               break;
            }

            var10 = class163.field2211[var17];
            var11 = class163.field2212[var17];
            var17 = var17 + 1 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.x;
            var20 = var11 - var4.y;
            if(var3.vmethod3175(1, var10, var11, var4)) {
               class163.field2208 = var10;
               class163.field2209 = var11;
               var29 = true;
               break;
            }

            var21 = class163.field2207[var30][var31] + 1;
            if(var30 > 0 && class163.field2204[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136776) == 0) {
               class163.field2211[var33] = var10 - 1;
               class163.field2212[var33] = var11;
               var33 = var33 + 1 & 4095;
               class163.field2204[var30 - 1][var31] = 2;
               class163.field2207[var30 - 1][var31] = var21;
            }

            if(var30 < 127 && class163.field2204[var30 + 1][var31] == 0 && (var18[var19 + 1][var20] & 19136896) == 0) {
               class163.field2211[var33] = var10 + 1;
               class163.field2212[var33] = var11;
               var33 = var33 + 1 & 4095;
               class163.field2204[var30 + 1][var31] = 8;
               class163.field2207[var30 + 1][var31] = var21;
            }

            if(var31 > 0 && class163.field2204[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class163.field2211[var33] = var10;
               class163.field2212[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class163.field2204[var30][var31 - 1] = 1;
               class163.field2207[var30][var31 - 1] = var21;
            }

            if(var31 < 127 && class163.field2204[var30][var31 + 1] == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class163.field2211[var33] = var10;
               class163.field2212[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class163.field2204[var30][var31 + 1] = 4;
               class163.field2207[var30][var31 + 1] = var21;
            }

            if(var30 > 0 && var31 > 0 && class163.field2204[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class163.field2211[var33] = var10 - 1;
               class163.field2212[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class163.field2204[var30 - 1][var31 - 1] = 3;
               class163.field2207[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 127 && var31 > 0 && class163.field2204[var30 + 1][var31 - 1] == 0 && (var18[var19 + 1][var20 - 1] & 19136899) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class163.field2211[var33] = var10 + 1;
               class163.field2212[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class163.field2204[var30 + 1][var31 - 1] = 9;
               class163.field2207[var30 + 1][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 127 && class163.field2204[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var20 + 1] & 19136824) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class163.field2211[var33] = var10 - 1;
               class163.field2212[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class163.field2204[var30 - 1][var31 + 1] = 6;
               class163.field2207[var30 - 1][var31 + 1] = var21;
            }

            if(var30 < 127 && var31 < 127 && class163.field2204[var30 + 1][var31 + 1] == 0 && (var18[var19 + 1][var20 + 1] & 19136992) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class163.field2211[var33] = var10 + 1;
               class163.field2212[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class163.field2204[var30 + 1][var31 + 1] = 12;
               class163.field2207[var30 + 1][var31 + 1] = var21;
            }
         }

         var28 = var29;
      } else if(var2 == 2) {
         var28 = class15.method111(var0, var1, var3, var4);
      } else {
         var10 = var0;
         var11 = var1;
         var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class163.field2204[var12][var13] = 99;
         class163.field2207[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class163.field2211[var16] = var0;
         var33 = var16 + 1;
         class163.field2212[var16] = var1;
         var18 = var4.flags;

         label641:
         while(true) {
            label639:
            while(true) {
               do {
                  do {
                     do {
                        label616:
                        do {
                           if(var33 == var17) {
                              class163.field2208 = var10;
                              class163.field2209 = var11;
                              var29 = false;
                              break label641;
                           }

                           var10 = class163.field2211[var17];
                           var11 = class163.field2212[var17];
                           var17 = var17 + 1 & 4095;
                           var30 = var10 - var14;
                           var31 = var11 - var15;
                           var19 = var10 - var4.x;
                           var20 = var11 - var4.y;
                           if(var3.vmethod3175(var2, var10, var11, var4)) {
                              class163.field2208 = var10;
                              class163.field2209 = var11;
                              var29 = true;
                              break label641;
                           }

                           var21 = class163.field2207[var30][var31] + 1;
                           if(var30 > 0 && class163.field2204[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && (var18[var19 - 1][var20 + var2 - 1] & 19136824) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class163.field2211[var33] = var10 - 1;
                                    class163.field2212[var33] = var11;
                                    var33 = var33 + 1 & 4095;
                                    class163.field2204[var30 - 1][var31] = 2;
                                    class163.field2207[var30 - 1][var31] = var21;
                                    break;
                                 }

                                 if((var18[var19 - 1][var20 + var22] & 19136830) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 < 128 - var2 && class163.field2204[var30 + 1][var31] == 0 && (var18[var19 + var2][var20] & 19136899) == 0 && (var18[var19 + var2][var20 + var2 - 1] & 19136992) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class163.field2211[var33] = var10 + 1;
                                    class163.field2212[var33] = var11;
                                    var33 = var33 + 1 & 4095;
                                    class163.field2204[var30 + 1][var31] = 8;
                                    class163.field2207[var30 + 1][var31] = var21;
                                    break;
                                 }

                                 if((var18[var19 + var2][var20 + var22] & 19136995) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var31 > 0 && class163.field2204[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[var19 + var2 - 1][var20 - 1] & 19136899) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class163.field2211[var33] = var10;
                                    class163.field2212[var33] = var11 - 1;
                                    var33 = var33 + 1 & 4095;
                                    class163.field2204[var30][var31 - 1] = 1;
                                    class163.field2207[var30][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var22 + var19][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var31 < 128 - var2 && class163.field2204[var30][var31 + 1] == 0 && (var18[var19][var20 + var2] & 19136824) == 0 && (var18[var19 + var2 - 1][var20 + var2] & 19136992) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class163.field2211[var33] = var10;
                                    class163.field2212[var33] = var11 + 1;
                                    var33 = var33 + 1 & 4095;
                                    class163.field2204[var30][var31 + 1] = 4;
                                    class163.field2207[var30][var31 + 1] = var21;
                                    break;
                                 }

                                 if((var18[var22 + var19][var20 + var2] & 19137016) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 > 0 && var31 > 0 && class163.field2204[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2) {
                                    class163.field2211[var33] = var10 - 1;
                                    class163.field2212[var33] = var11 - 1;
                                    var33 = var33 + 1 & 4095;
                                    class163.field2204[var30 - 1][var31 - 1] = 3;
                                    class163.field2207[var30 - 1][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var19 - 1][var22 + (var20 - 1)] & 19136830) != 0 || (var18[var22 + (var19 - 1)][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 < 128 - var2 && var31 > 0 && class163.field2204[var30 + 1][var31 - 1] == 0 && (var18[var19 + var2][var20 - 1] & 19136899) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2) {
                                    class163.field2211[var33] = var10 + 1;
                                    class163.field2212[var33] = var11 - 1;
                                    var33 = var33 + 1 & 4095;
                                    class163.field2204[var30 + 1][var31 - 1] = 9;
                                    class163.field2207[var30 + 1][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var19 + var2][var22 + (var20 - 1)] & 19136995) != 0 || (var18[var19 + var22][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 > 0 && var31 < 128 - var2 && class163.field2204[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var20 + var2] & 19136824) == 0) {
                              for(var22 = 1; var22 < var2; ++var22) {
                                 if((var18[var19 - 1][var20 + var22] & 19136830) != 0 || (var18[var22 + (var19 - 1)][var20 + var2] & 19137016) != 0) {
                                    continue label616;
                                 }
                              }

                              class163.field2211[var33] = var10 - 1;
                              class163.field2212[var33] = var11 + 1;
                              var33 = var33 + 1 & 4095;
                              class163.field2204[var30 - 1][var31 + 1] = 6;
                              class163.field2207[var30 - 1][var31 + 1] = var21;
                           }
                        } while(var30 >= 128 - var2);
                     } while(var31 >= 128 - var2);
                  } while(class163.field2204[var30 + 1][var31 + 1] != 0);
               } while((var18[var19 + var2][var20 + var2] & 19136992) != 0);

               for(var22 = 1; var22 < var2; ++var22) {
                  if((var18[var19 + var22][var20 + var2] & 19137016) != 0 || (var18[var19 + var2][var22 + var20] & 19136995) != 0) {
                     continue label639;
                  }
               }

               class163.field2211[var33] = var10 + 1;
               class163.field2212[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class163.field2204[var30 + 1][var31 + 1] = 12;
               class163.field2207[var30 + 1][var31 + 1] = var21;
            }
         }

         var28 = var29;
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = class163.field2208;
      var30 = class163.field2209;
      if(!var28) {
         var31 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var32 = 10;
         var33 = var3.field2214;
         var17 = var3.field2215;
         int var27 = var3.field2217;
         var19 = var3.field2216;

         for(var20 = var33 - var32; var20 <= var32 + var33; ++var20) {
            for(var21 = var17 - var32; var21 <= var32 + var17; ++var21) {
               var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class163.field2207[var22][var23] < 100) {
                  int var24 = 0;
                  if(var20 < var33) {
                     var24 = var33 - var20;
                  } else if(var20 > var27 + var33 - 1) {
                     var24 = var20 - (var27 + var33 - 1);
                  }

                  int var25 = 0;
                  if(var21 < var17) {
                     var25 = var17 - var21;
                  } else if(var21 > var17 + var19 - 1) {
                     var25 = var21 - (var19 + var17 - 1);
                  }

                  int var26 = var25 * var25 + var24 * var24;
                  if(var26 < var31 || var31 == var26 && class163.field2207[var22][var23] < var14) {
                     var31 = var26;
                     var14 = class163.field2207[var22][var23];
                     var11 = var20;
                     var30 = var21;
                  }
               }
            }
         }

         if(var31 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var0 == var11 && var30 == var1) {
         return 0;
      } else {
         var13 = 0;
         class163.field2211[var13] = var11;
         var31 = var13 + 1;
         class163.field2212[var13] = var30;

         for(var14 = var15 = class163.field2204[var11 - var9][var30 - var10]; var0 != var11 || var30 != var1; var14 = class163.field2204[var11 - var9][var30 - var10]) {
            if(var14 != var15) {
               var15 = var14;
               class163.field2211[var31] = var11;
               class163.field2212[var31++] = var30;
            }

            if((var14 & 2) != 0) {
               ++var11;
            } else if((var14 & 8) != 0) {
               --var11;
            }

            if((var14 & 1) != 0) {
               ++var30;
            } else if((var14 & 4) != 0) {
               --var30;
            }
         }

         var33 = 0;

         while(var31-- > 0) {
            var6[var33] = class163.field2211[var31];
            var7[var33++] = class163.field2212[var31];
            if(var33 >= var6.length) {
               break;
            }
         }

         return var33;
      }
   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(Lhk;IB)I",
      garbageValue = "-13"
   )
   static final int method73(Widget var0, int var1) {
      if(var0.dynamicValues != null && var1 < var0.dynamicValues.length) {
         try {
            int[] var2 = var0.dynamicValues[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = Client.boostedSkillLevels[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = Client.realSkillLevels[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = Client.skillExperiences[var2[var4++]];
               }

               int var9;
               Widget var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = PendingSpawn.method1612(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class250.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class218.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class229.field2909[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class218.widgetSettings[var2[var4++]] * 100 / 46875;
               }

               if(var6 == 8) {
                  var7 = class48.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class229.field2908[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = PendingSpawn.method1612(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class250.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = Client.energy;
               }

               if(var6 == 12) {
                  var7 = Client.weight;
               }

               if(var6 == 13) {
                  var9 = class218.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = Item.method1849(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = (class48.localPlayer.x >> 7) + ItemLayer.baseX;
               }

               if(var6 == 19) {
                  var7 = (class48.localPlayer.y >> 7) + ItemLayer.baseY;
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "([Lhk;II)V",
      garbageValue = "-229044247"
   )
   static final void method71(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.hasScript || !class258.method4629(var3))) {
            int var5;
            if(var3.type == 0) {
               if(!var3.hasScript && class258.method4629(var3) && var3 != ItemContainer.field751) {
                  continue;
               }

               method71(var0, var3.id);
               if(var3.children != null) {
                  method71(var3.children, var3.id);
               }

               WidgetNode var7 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var7 != null) {
                  var5 = var7.id;
                  if(CombatInfoListHolder.loadWidget(var5)) {
                     method71(class243.widgets[var5], -1);
                  }
               }
            }

            if(var3.type == 6) {
               if(var3.field2773 != -1 || var3.field2806 != -1) {
                  boolean var4 = class168.method3183(var3);
                  if(var4) {
                     var5 = var3.field2806;
                  } else {
                     var5 = var3.field2773;
                  }

                  if(var5 != -1) {
                     Sequence var6 = ItemLayer.getAnimation(var5);

                     for(var3.field2849 += Client.field925; var3.field2849 > var6.frameLenghts[var3.field2737]; WorldMapData.method394(var3)) {
                        var3.field2849 -= var6.frameLenghts[var3.field2737];
                        ++var3.field2737;
                        if(var3.field2737 >= var6.frameIDs.length) {
                           var3.field2737 -= var6.frameStep;
                           if(var3.field2737 < 0 || var3.field2737 >= var6.frameIDs.length) {
                              var3.field2737 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2782 != 0 && !var3.hasScript) {
                  int var8 = var3.field2782 >> 16;
                  var5 = var3.field2782 << 16 >> 16;
                  var8 *= Client.field925;
                  var5 *= Client.field925;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  WorldMapData.method394(var3);
               }
            }
         }
      }

   }
}
