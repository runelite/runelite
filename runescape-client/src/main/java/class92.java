import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
public final class class92 {
   @ObfuscatedName("j")
   boolean field1608 = true;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 744603869
   )
   int field1609;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 34829235
   )
   int field1610;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 522587815
   )
   int field1611;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1687581447
   )
   int field1613;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 699322083
   )
   int field1614;
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = 231695473
   )
   static int field1615;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 230343147
   )
   int field1616;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1969757862"
   )
   static final void method2152() {
      if(Client.field509 != class145.plane) {
         Client.field509 = class145.plane;
         class54.method1105(class145.plane);
      }

   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIBI)V",
      garbageValue = "-516683907"
   )
   static final void method2153(Player var0, int var1, int var2, byte var3) {
      int var4 = var0.pathX[0];
      int var5 = var0.pathY[0];
      int var6 = var0.method18();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var8 = var0.method18();
            Client.field469.field1938 = var1;
            Client.field469.field1937 = var2;
            Client.field469.field1941 = 1;
            Client.field469.field1939 = 1;
            class10 var9 = Client.field469;
            class10 var10 = var9;
            CollisionData var11 = Client.collisionMaps[var0.field55];
            int[] var12 = Client.field560;
            int[] var13 = Client.field561;

            int var14;
            int var15;
            for(var14 = 0; var14 < 128; ++var14) {
               for(var15 = 0; var15 < 128; ++var15) {
                  class109.field1924[var14][var15] = 0;
                  class109.field1927[var14][var15] = 99999999;
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
            int var28;
            boolean var34;
            int var36;
            int var37;
            int var39;
            if(var8 == 1) {
               var34 = class179.method3481(var4, var5, var9, var11);
            } else if(var8 == 2) {
               var34 = Widget.method3442(var4, var5, var9, var11);
            } else {
               var16 = var4;
               var17 = var5;
               byte var18 = 64;
               var19 = 64;
               var20 = var4 - var18;
               var21 = var5 - var19;
               class109.field1924[var18][var19] = 99;
               class109.field1927[var18][var19] = 0;
               byte var22 = 0;
               var23 = 0;
               class109.field1928[var22] = var4;
               var39 = var22 + 1;
               class109.field1929[var22] = var5;
               int[][] var24 = var11.flags;

               boolean var35;
               label565:
               while(true) {
                  label563:
                  while(true) {
                     do {
                        do {
                           do {
                              label540:
                              do {
                                 if(var23 == var39) {
                                    class214.field3184 = var16;
                                    class109.field1934 = var17;
                                    var35 = false;
                                    break label565;
                                 }

                                 var16 = class109.field1928[var23];
                                 var17 = class109.field1929[var23];
                                 var23 = var23 + 1 & 4095;
                                 var36 = var16 - var20;
                                 var37 = var17 - var21;
                                 var25 = var16 - var11.x;
                                 var26 = var17 - var11.y;
                                 if(var10.vmethod2444(var8, var16, var17, var11)) {
                                    class214.field3184 = var16;
                                    class109.field1934 = var17;
                                    var35 = true;
                                    break label565;
                                 }

                                 var27 = class109.field1927[var36][var37] + 1;
                                 if(var36 > 0 && class109.field1924[var36 - 1][var37] == 0 && (var24[var25 - 1][var26] & 19136782) == 0 && (var24[var25 - 1][var26 + var8 - 1] & 19136824) == 0) {
                                    var28 = 1;

                                    while(true) {
                                       if(var28 >= var8 - 1) {
                                          class109.field1928[var39] = var16 - 1;
                                          class109.field1929[var39] = var17;
                                          var39 = 1 + var39 & 4095;
                                          class109.field1924[var36 - 1][var37] = 2;
                                          class109.field1927[var36 - 1][var37] = var27;
                                          break;
                                       }

                                       if((var24[var25 - 1][var28 + var26] & 19136830) != 0) {
                                          break;
                                       }

                                       ++var28;
                                    }
                                 }

                                 if(var36 < 128 - var8 && class109.field1924[1 + var36][var37] == 0 && (var24[var25 + var8][var26] & 19136899) == 0 && (var24[var25 + var8][var26 + var8 - 1] & 19136992) == 0) {
                                    var28 = 1;

                                    while(true) {
                                       if(var28 >= var8 - 1) {
                                          class109.field1928[var39] = 1 + var16;
                                          class109.field1929[var39] = var17;
                                          var39 = 1 + var39 & 4095;
                                          class109.field1924[var36 + 1][var37] = 8;
                                          class109.field1927[1 + var36][var37] = var27;
                                          break;
                                       }

                                       if((var24[var8 + var25][var28 + var26] & 19136995) != 0) {
                                          break;
                                       }

                                       ++var28;
                                    }
                                 }

                                 if(var37 > 0 && class109.field1924[var36][var37 - 1] == 0 && (var24[var25][var26 - 1] & 19136782) == 0 && (var24[var25 + var8 - 1][var26 - 1] & 19136899) == 0) {
                                    var28 = 1;

                                    while(true) {
                                       if(var28 >= var8 - 1) {
                                          class109.field1928[var39] = var16;
                                          class109.field1929[var39] = var17 - 1;
                                          var39 = var39 + 1 & 4095;
                                          class109.field1924[var36][var37 - 1] = 1;
                                          class109.field1927[var36][var37 - 1] = var27;
                                          break;
                                       }

                                       if((var24[var28 + var25][var26 - 1] & 19136911) != 0) {
                                          break;
                                       }

                                       ++var28;
                                    }
                                 }

                                 if(var37 < 128 - var8 && class109.field1924[var36][var37 + 1] == 0 && (var24[var25][var26 + var8] & 19136824) == 0 && (var24[var8 + var25 - 1][var26 + var8] & 19136992) == 0) {
                                    var28 = 1;

                                    while(true) {
                                       if(var28 >= var8 - 1) {
                                          class109.field1928[var39] = var16;
                                          class109.field1929[var39] = var17 + 1;
                                          var39 = var39 + 1 & 4095;
                                          class109.field1924[var36][var37 + 1] = 4;
                                          class109.field1927[var36][1 + var37] = var27;
                                          break;
                                       }

                                       if((var24[var25 + var28][var8 + var26] & 19137016) != 0) {
                                          break;
                                       }

                                       ++var28;
                                    }
                                 }

                                 if(var36 > 0 && var37 > 0 && class109.field1924[var36 - 1][var37 - 1] == 0 && (var24[var25 - 1][var26 - 1] & 19136782) == 0) {
                                    var28 = 1;

                                    while(true) {
                                       if(var28 >= var8) {
                                          class109.field1928[var39] = var16 - 1;
                                          class109.field1929[var39] = var17 - 1;
                                          var39 = 1 + var39 & 4095;
                                          class109.field1924[var36 - 1][var37 - 1] = 3;
                                          class109.field1927[var36 - 1][var37 - 1] = var27;
                                          break;
                                       }

                                       if((var24[var25 - 1][var28 + (var26 - 1)] & 19136830) != 0 || (var24[var28 + (var25 - 1)][var26 - 1] & 19136911) != 0) {
                                          break;
                                       }

                                       ++var28;
                                    }
                                 }

                                 if(var36 < 128 - var8 && var37 > 0 && class109.field1924[var36 + 1][var37 - 1] == 0 && (var24[var25 + var8][var26 - 1] & 19136899) == 0) {
                                    var28 = 1;

                                    while(true) {
                                       if(var28 >= var8) {
                                          class109.field1928[var39] = var16 + 1;
                                          class109.field1929[var39] = var17 - 1;
                                          var39 = var39 + 1 & 4095;
                                          class109.field1924[1 + var36][var37 - 1] = 9;
                                          class109.field1927[1 + var36][var37 - 1] = var27;
                                          break;
                                       }

                                       if((var24[var8 + var25][var28 + (var26 - 1)] & 19136995) != 0 || (var24[var25 + var28][var26 - 1] & 19136911) != 0) {
                                          break;
                                       }

                                       ++var28;
                                    }
                                 }

                                 if(var36 > 0 && var37 < 128 - var8 && class109.field1924[var36 - 1][1 + var37] == 0 && (var24[var25 - 1][var26 + var8] & 19136824) == 0) {
                                    for(var28 = 1; var28 < var8; ++var28) {
                                       if((var24[var25 - 1][var28 + var26] & 19136830) != 0 || (var24[var28 + (var25 - 1)][var8 + var26] & 19137016) != 0) {
                                          continue label540;
                                       }
                                    }

                                    class109.field1928[var39] = var16 - 1;
                                    class109.field1929[var39] = 1 + var17;
                                    var39 = var39 + 1 & 4095;
                                    class109.field1924[var36 - 1][1 + var37] = 6;
                                    class109.field1927[var36 - 1][var37 + 1] = var27;
                                 }
                              } while(var36 >= 128 - var8);
                           } while(var37 >= 128 - var8);
                        } while(class109.field1924[1 + var36][var37 + 1] != 0);
                     } while((var24[var8 + var25][var26 + var8] & 19136992) != 0);

                     for(var28 = 1; var28 < var8; ++var28) {
                        if((var24[var28 + var25][var8 + var26] & 19137016) != 0 || (var24[var25 + var8][var28 + var26] & 19136995) != 0) {
                           continue label563;
                        }
                     }

                     class109.field1928[var39] = var16 + 1;
                     class109.field1929[var39] = 1 + var17;
                     var39 = 1 + var39 & 4095;
                     class109.field1924[var36 + 1][1 + var37] = 12;
                     class109.field1927[1 + var36][1 + var37] = var27;
                  }
               }

               var34 = var35;
            }

            int var7;
            label611: {
               var15 = var4 - 64;
               var16 = var5 - 64;
               var17 = class214.field3184;
               var36 = class109.field1934;
               if(!var34) {
                  var37 = Integer.MAX_VALUE;
                  var20 = Integer.MAX_VALUE;
                  byte var38 = 10;
                  var39 = var10.field1938;
                  var23 = var10.field1937;
                  int var33 = var10.field1941;
                  var25 = var10.field1939;

                  for(var26 = var39 - var38; var26 <= var38 + var39; ++var26) {
                     for(var27 = var23 - var38; var27 <= var23 + var38; ++var27) {
                        var28 = var26 - var15;
                        int var29 = var27 - var16;
                        if(var28 >= 0 && var29 >= 0 && var28 < 128 && var29 < 128 && class109.field1927[var28][var29] < 100) {
                           int var30 = 0;
                           if(var26 < var39) {
                              var30 = var39 - var26;
                           } else if(var26 > var39 + var33 - 1) {
                              var30 = var26 - (var33 + var39 - 1);
                           }

                           int var31 = 0;
                           if(var27 < var23) {
                              var31 = var23 - var27;
                           } else if(var27 > var23 + var25 - 1) {
                              var31 = var27 - (var25 + var23 - 1);
                           }

                           int var32 = var30 * var30 + var31 * var31;
                           if(var32 < var37 || var32 == var37 && class109.field1927[var28][var29] < var20) {
                              var37 = var32;
                              var20 = class109.field1927[var28][var29];
                              var17 = var26;
                              var36 = var27;
                           }
                        }
                     }
                  }

                  if(var37 == Integer.MAX_VALUE) {
                     var7 = -1;
                     break label611;
                  }
               }

               if(var4 == var17 && var36 == var5) {
                  var7 = 0;
               } else {
                  var19 = 0;
                  class109.field1928[var19] = var17;
                  var37 = var19 + 1;
                  class109.field1929[var19] = var36;

                  for(var20 = var21 = class109.field1924[var17 - var15][var36 - var16]; var4 != var17 || var36 != var5; var20 = class109.field1924[var17 - var15][var36 - var16]) {
                     if(var21 != var20) {
                        var21 = var20;
                        class109.field1928[var37] = var17;
                        class109.field1929[var37++] = var36;
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
                     var12[var39] = class109.field1928[var37];
                     var13[var39++] = class109.field1929[var37];
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
                  var0.method16(Client.field560[var15], Client.field561[var15], var3);
               }

            }
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   class92(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1616 = var1;
      this.field1609 = var2;
      this.field1614 = var3;
      this.field1613 = var4;
      this.field1610 = var5;
      this.field1611 = var6;
      this.field1608 = var7;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-832265228"
   )
   static final void method2154(int var0, int var1, int var2, int var3, int var4) {
      int var5 = Frames.region.method1986(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = Frames.region.method1990(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = DecorativeObject.field1677.image;
         var11 = 4 * var1 + 24624 + 2048 * (103 - var2);
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = Projectile.getObjectDefinition(var12);
         if(var13.field960 != -1) {
            ModIcon var14 = Ignore.field132[var13.field960];
            if(var14 != null) {
               int var15 = (var13.field950 * 4 - var14.originalWidth) / 2;
               int var16 = (var13.field948 * 4 - var14.height) / 2;
               var14.method1911(4 * var1 + 48 + var15, var16 + 4 * (104 - var2 - var13.field948) + 48);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[512 + var11] = var9;
                  var10[var11 + 1024] = var9;
                  var10[1536 + var11] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[var11 + 2] = var9;
                  var10[3 + var11] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[512 + 3 + var11] = var9;
                  var10[3 + var11 + 1024] = var9;
                  var10[3 + var11 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[1536 + var11] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[2 + 1536 + var11] = var9;
                  var10[1536 + var11 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[3 + var11 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[1536 + var11] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[1024 + var11] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[3 + var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[512 + var11 + 3] = var9;
                  var10[1024 + 3 + var11] = var9;
                  var10[var11 + 3 + 1536] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[1 + 1536 + var11] = var9;
                  var10[2 + 1536 + var11] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = Frames.region.method2108(var0, var1, var2);
      if(var5 != 0) {
         var6 = Frames.region.method1990(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = Projectile.getObjectDefinition(var9);
         int var18;
         if(var23.field960 != -1) {
            ModIcon var17 = Ignore.field132[var23.field960];
            if(null != var17) {
               var12 = (var23.field950 * 4 - var17.originalWidth) / 2;
               var18 = (var23.field948 * 4 - var17.height) / 2;
               var17.method1911(48 + var1 * 4 + var12, var18 + (104 - var2 - var23.field948) * 4 + 48);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var19 = DecorativeObject.field1677.image;
            var18 = 4 * var1 + 24624 + (103 - var2) * 2048;
            if(var7 != 0 && var7 != 2) {
               var19[var18] = var11;
               var19[var18 + 512 + 1] = var11;
               var19[1024 + var18 + 2] = var11;
               var19[3 + 1536 + var18] = var11;
            } else {
               var19[var18 + 1536] = var11;
               var19[var18 + 1024 + 1] = var11;
               var19[var18 + 512 + 2] = var11;
               var19[var18 + 3] = var11;
            }
         }
      }

      var5 = Frames.region.method2102(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var20 = Projectile.getObjectDefinition(var6);
         if(var20.field960 != -1) {
            ModIcon var21 = Ignore.field132[var20.field960];
            if(var21 != null) {
               var9 = (var20.field950 * 4 - var21.originalWidth) / 2;
               int var22 = (var20.field948 * 4 - var21.height) / 2;
               var21.method1911(var9 + 48 + 4 * var1, var22 + 48 + 4 * (104 - var2 - var20.field948));
            }
         }
      }

   }
}
