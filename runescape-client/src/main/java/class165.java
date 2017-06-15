import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class165 {
   @ObfuscatedName("m")
   byte[] field2333;
   @ObfuscatedName("e")
   int[] field2334;
   @ObfuscatedName("iu")
   static Widget field2335;
   @ObfuscatedName("p")
   int[] field2336;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BI[BIII)I",
      garbageValue = "-698068610"
   )
   public int method2962(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(var5 == 0) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.field2334[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.field2334[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 64) != 0) {
               var6 = this.field2334[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2334[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.field2334[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2334[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 16) != 0) {
               var6 = this.field2334[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2334[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 8) != 0) {
               var6 = this.field2334[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2334[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.field2334[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2334[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 2) != 0) {
               var6 = this.field2334[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2334[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 1) != 0) {
               var6 = this.field2334[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2334[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            ++var7;
         }

         return var7 + 1 - var2;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BII[BII)I",
      garbageValue = "-1044865160"
   )
   public int method2963(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field2336[var8];
         byte var10 = this.field2333[var8];
         if(var10 == 0) {
            throw new RuntimeException("");
         }

         int var11 = var7 >> 3;
         int var12 = var7 & 7;
         var6 &= -var12 >> 31;
         int var13 = var11 + (var10 + var12 - 1 >> 3);
         var12 += 24;
         var4[var11] = (byte)(var6 |= var9 >>> var12);
         if(var11 < var13) {
            ++var11;
            var12 -= 8;
            var4[var11] = (byte)(var6 = var9 >>> var12);
            if(var11 < var13) {
               ++var11;
               var12 -= 8;
               var4[var11] = (byte)(var6 = var9 >>> var12);
               if(var11 < var13) {
                  ++var11;
                  var12 -= 8;
                  var4[var11] = (byte)(var6 = var9 >>> var12);
                  if(var11 < var13) {
                     ++var11;
                     var12 -= 8;
                     var4[var11] = (byte)(var6 = var9 << -var12);
                  }
               }
            }
         }

         var7 += var10;
      }

      return (var7 + 7 >> 3) - var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass186;ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1239459798"
   )
   static String method2965(class186 var0, int var1, String var2) {
      if(var0 == null) {
         return var2;
      } else {
         class185 var3 = (class185)var0.method3389((long)var1);
         return var3 == null?var2:(String)var3.field2459;
      }
   }

   public class165(byte[] var1) {
      int var2 = var1.length;
      this.field2336 = new int[var2];
      this.field2333 = var1;
      int[] var3 = new int[33];
      this.field2334 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field2336[var5] = var8;
            int var9;
            int var10;
            int var11;
            int var12;
            if((var8 & var7) != 0) {
               var9 = var3[var6 - 1];
            } else {
               var9 = var8 | var7;

               for(var10 = var6 - 1; var10 >= 1; --var10) {
                  var11 = var3[var10];
                  if(var11 != var8) {
                     break;
                  }

                  var12 = 1 << 32 - var10;
                  if((var11 & var12) != 0) {
                     var3[var10] = var3[var10 - 1];
                     break;
                  }

                  var3[var10] = var11 | var12;
               }
            }

            var3[var6] = var9;

            for(var10 = var6 + 1; var10 <= 32; ++var10) {
               if(var3[var10] == var8) {
                  var3[var10] = var9;
               }
            }

            var10 = 0;

            for(var11 = 0; var11 < var6; ++var11) {
               var12 = Integer.MIN_VALUE >>> var11;
               if((var8 & var12) != 0) {
                  if(this.field2334[var10] == 0) {
                     this.field2334[var10] = var4;
                  }

                  var10 = this.field2334[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.field2334.length) {
                  int[] var13 = new int[this.field2334.length * 2];

                  for(int var14 = 0; var14 < this.field2334.length; ++var14) {
                     var13[var14] = this.field2334[var14];
                  }

                  this.field2334 = var13;
               }

               var12 >>>= 1;
            }

            this.field2334[var10] = ~var5;
            if(var10 >= var4) {
               var4 = var10 + 1;
            }
         }
      }

   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "107"
   )
   static final void method2968() {
      class73.method1065(false);
      Client.field1117 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < WidgetNode.field814.length; ++var1) {
         if(WallObject.field2143[var1] != -1 && WidgetNode.field814[var1] == null) {
            WidgetNode.field814[var1] = class177.indexMaps.getConfigData(WallObject.field2143[var1], 0);
            if(WidgetNode.field814[var1] == null) {
               var0 = false;
               ++Client.field1117;
            }
         }

         if(class168.field2352[var1] != -1 && class40.field554[var1] == null) {
            class40.field554[var1] = class177.indexMaps.getConfigData(class168.field2352[var1], 0, class36.xteaKeys[var1]);
            if(class40.field554[var1] == null) {
               var0 = false;
               ++Client.field1117;
            }
         }
      }

      if(!var0) {
         Client.field1113 = 1;
      } else {
         Client.field1127 = 0;
         var0 = true;

         int var3;
         int var4;
         Buffer var8;
         int var9;
         int var10;
         int var11;
         int var13;
         int var14;
         int var15;
         int var16;
         int var17;
         int var18;
         for(var1 = 0; var1 < WidgetNode.field814.length; ++var1) {
            byte[] var2 = class40.field554[var1];
            if(var2 != null) {
               var3 = (class13.mapRegions[var1] >> 8) * 64 - class19.baseX;
               var4 = (class13.mapRegions[var1] & 255) * 64 - class21.baseY;
               if(Client.isDynamicRegion) {
                  var3 = 10;
                  var4 = 10;
               }

               boolean var7 = true;
               var8 = new Buffer(var2);
               var9 = -1;

               label1459:
               while(true) {
                  var10 = var8.method3046();
                  if(var10 == 0) {
                     var0 &= var7;
                     break;
                  }

                  var9 += var10;
                  var11 = 0;
                  boolean var12 = false;

                  while(true) {
                     while(!var12) {
                        var13 = var8.method3046();
                        if(var13 == 0) {
                           continue label1459;
                        }

                        var11 += var13 - 1;
                        var14 = var11 & 63;
                        var15 = var11 >> 6 & 63;
                        var16 = var8.readUnsignedByte() >> 2;
                        var17 = var3 + var15;
                        var18 = var4 + var14;
                        if(var17 > 0 && var18 > 0 && var17 < 103 && var18 < 103) {
                           ObjectComposition var19 = class29.getObjectDefinition(var9);
                           if(var16 != 22 || !Client.field1055 || var19.field3445 != 0 || var19.field3476 == 1 || var19.field3480) {
                              if(!var19.method4429()) {
                                 ++Client.field1127;
                                 var7 = false;
                              }

                              var12 = true;
                           }
                        }
                     }

                     var13 = var8.method3046();
                     if(var13 == 0) {
                        break;
                     }

                     var8.readUnsignedByte();
                  }
               }
            }
         }

         if(!var0) {
            Client.field1113 = 2;
         } else {
            if(Client.field1113 != 0) {
               class158.method2877("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            class69.method1035();
            class7.method33();
            class69.method1035();
            class17.region.method2589();
            class69.method1035();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].method2912();
            }

            int var44;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var44 = 0; var44 < 104; ++var44) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class61.tileSettings[var1][var44][var3] = 0;
                  }
               }
            }

            class69.method1035();
            Ignore.method1044();
            var1 = WidgetNode.field814.length;
            class66.method1026();
            class73.method1065(true);
            int var5;
            int var6;
            int var20;
            int var21;
            int var53;
            int var62;
            int var64;
            if(!Client.isDynamicRegion) {
               byte[] var45;
               for(var44 = 0; var44 < var1; ++var44) {
                  var3 = (class13.mapRegions[var44] >> 8) * 64 - class19.baseX;
                  var4 = (class13.mapRegions[var44] & 255) * 64 - class21.baseY;
                  var45 = WidgetNode.field814[var44];
                  if(var45 != null) {
                     class69.method1035();
                     var6 = class34.field501 * 8 - 48;
                     var62 = class13.field289 * 8 - 48;
                     CollisionData[] var63 = Client.collisionMaps;

                     for(var9 = 0; var9 < 4; ++var9) {
                        for(var10 = 0; var10 < 64; ++var10) {
                           for(var11 = 0; var11 < 64; ++var11) {
                              if(var10 + var3 > 0 && var10 + var3 < 103 && var11 + var4 > 0 && var4 + var11 < 103) {
                                 var63[var9].flags[var10 + var3][var4 + var11] &= -16777217;
                              }
                           }
                        }
                     }

                     Buffer var46 = new Buffer(var45);

                     for(var10 = 0; var10 < 4; ++var10) {
                        for(var11 = 0; var11 < 64; ++var11) {
                           for(var64 = 0; var64 < 64; ++var64) {
                              class109.method1968(var46, var10, var3 + var11, var64 + var4, var6, var62, 0);
                           }
                        }
                     }
                  }
               }

               for(var44 = 0; var44 < var1; ++var44) {
                  var3 = (class13.mapRegions[var44] >> 8) * 64 - class19.baseX;
                  var4 = (class13.mapRegions[var44] & 255) * 64 - class21.baseY;
                  var45 = WidgetNode.field814[var44];
                  if(var45 == null && class13.field289 < 800) {
                     class69.method1035();
                     class174.method3250(var3, var4, 64, 64);
                  }
               }

               class73.method1065(true);

               for(var44 = 0; var44 < var1; ++var44) {
                  byte[] var47 = class40.field554[var44];
                  if(var47 != null) {
                     var4 = (class13.mapRegions[var44] >> 8) * 64 - class19.baseX;
                     var5 = (class13.mapRegions[var44] & 255) * 64 - class21.baseY;
                     class69.method1035();
                     Region var48 = class17.region;
                     CollisionData[] var49 = Client.collisionMaps;
                     var8 = new Buffer(var47);
                     var9 = -1;

                     while(true) {
                        var10 = var8.method3046();
                        if(var10 == 0) {
                           break;
                        }

                        var9 += var10;
                        var11 = 0;

                        while(true) {
                           var64 = var8.method3046();
                           if(var64 == 0) {
                              break;
                           }

                           var11 += var64 - 1;
                           var13 = var11 & 63;
                           var14 = var11 >> 6 & 63;
                           var15 = var11 >> 12;
                           var16 = var8.readUnsignedByte();
                           var17 = var16 >> 2;
                           var18 = var16 & 3;
                           var53 = var4 + var14;
                           var20 = var5 + var13;
                           if(var53 > 0 && var20 > 0 && var53 < 103 && var20 < 103) {
                              var21 = var15;
                              if((class61.tileSettings[1][var53][var20] & 2) == 2) {
                                 var21 = var15 - 1;
                              }

                              CollisionData var22 = null;
                              if(var21 >= 0) {
                                 var22 = var49[var21];
                              }

                              class47.method672(var15, var53, var20, var9, var18, var17, var48, var22);
                           }
                        }
                     }
                  }
               }
            }

            int var24;
            int var25;
            int var26;
            int var27;
            int var28;
            int var29;
            int var31;
            int var32;
            int var33;
            int var50;
            int var56;
            int var57;
            if(Client.isDynamicRegion) {
               CollisionData[] var52;
               Buffer var65;
               for(var44 = 0; var44 < 4; ++var44) {
                  class69.method1035();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var61 = false;
                        var6 = Client.field967[var44][var3][var4];
                        if(var6 != -1) {
                           var62 = var6 >> 24 & 3;
                           var50 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = (var9 / 8 << 8) + var10 / 8;

                           for(var64 = 0; var64 < class13.mapRegions.length; ++var64) {
                              if(class13.mapRegions[var64] == var11 && WidgetNode.field814[var64] != null) {
                                 byte[] var51 = WidgetNode.field814[var64];
                                 var14 = var3 * 8;
                                 var15 = var4 * 8;
                                 var16 = (var9 & 7) * 8;
                                 var17 = (var10 & 7) * 8;
                                 var52 = Client.collisionMaps;

                                 for(var53 = 0; var53 < 8; ++var53) {
                                    for(var20 = 0; var20 < 8; ++var20) {
                                       if(var53 + var14 > 0 && var53 + var14 < 103 && var20 + var15 > 0 && var15 + var20 < 103) {
                                          var52[var44].flags[var53 + var14][var15 + var20] &= -16777217;
                                       }
                                    }
                                 }

                                 var65 = new Buffer(var51);

                                 for(var20 = 0; var20 < 4; ++var20) {
                                    for(var21 = 0; var21 < 64; ++var21) {
                                       for(var56 = 0; var56 < 64; ++var56) {
                                          if(var62 == var20 && var21 >= var16 && var21 < var16 + 8 && var56 >= var17 && var56 < var17 + 8) {
                                             var27 = var21 & 7;
                                             var28 = var56 & 7;
                                             var29 = var50 & 3;
                                             if(var29 == 0) {
                                                var26 = var27;
                                             } else if(var29 == 1) {
                                                var26 = var28;
                                             } else if(var29 == 2) {
                                                var26 = 7 - var27;
                                             } else {
                                                var26 = 7 - var28;
                                             }

                                             class109.method1968(var65, var44, var26 + var14, var15 + ChatMessages.method1716(var21 & 7, var56 & 7, var50), 0, 0, var50);
                                          } else {
                                             class109.method1968(var65, 0, -1, -1, 0, 0, 0);
                                          }
                                       }
                                    }
                                 }

                                 var61 = true;
                                 break;
                              }
                           }
                        }

                        if(!var61) {
                           var62 = var44;
                           var50 = var3 * 8;
                           var9 = var4 * 8;

                           for(var10 = 0; var10 < 8; ++var10) {
                              for(var11 = 0; var11 < 8; ++var11) {
                                 class61.tileHeights[var62][var50 + var10][var11 + var9] = 0;
                              }
                           }

                           if(var50 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class61.tileHeights[var62][var50][var10 + var9] = class61.tileHeights[var62][var50 - 1][var10 + var9];
                              }
                           }

                           if(var9 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class61.tileHeights[var62][var10 + var50][var9] = class61.tileHeights[var62][var10 + var50][var9 - 1];
                              }
                           }

                           if(var50 > 0 && class61.tileHeights[var62][var50 - 1][var9] != 0) {
                              class61.tileHeights[var62][var50][var9] = class61.tileHeights[var62][var50 - 1][var9];
                           } else if(var9 > 0 && class61.tileHeights[var62][var50][var9 - 1] != 0) {
                              class61.tileHeights[var62][var50][var9] = class61.tileHeights[var62][var50][var9 - 1];
                           } else if(var50 > 0 && var9 > 0 && class61.tileHeights[var62][var50 - 1][var9 - 1] != 0) {
                              class61.tileHeights[var62][var50][var9] = class61.tileHeights[var62][var50 - 1][var9 - 1];
                           }
                        }
                     }
                  }
               }

               for(var44 = 0; var44 < 13; ++var44) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.field967[0][var44][var3];
                     if(var4 == -1) {
                        class174.method3250(var44 * 8, var3 * 8, 8, 8);
                     }
                  }
               }

               class73.method1065(true);

               for(var44 = 0; var44 < 4; ++var44) {
                  class69.method1035();

                  for(var3 = 0; var3 < 13; ++var3) {
                     label1217:
                     for(var4 = 0; var4 < 13; ++var4) {
                        var5 = Client.field967[var44][var3][var4];
                        if(var5 != -1) {
                           var6 = var5 >> 24 & 3;
                           var62 = var5 >> 1 & 3;
                           var50 = var5 >> 14 & 1023;
                           var9 = var5 >> 3 & 2047;
                           var10 = var9 / 8 + (var50 / 8 << 8);

                           for(var11 = 0; var11 < class13.mapRegions.length; ++var11) {
                              if(var10 == class13.mapRegions[var11] && class40.field554[var11] != null) {
                                 byte[] var54 = class40.field554[var11];
                                 var13 = var3 * 8;
                                 var14 = var4 * 8;
                                 var15 = (var50 & 7) * 8;
                                 var16 = (var9 & 7) * 8;
                                 Region var55 = class17.region;
                                 var52 = Client.collisionMaps;
                                 var65 = new Buffer(var54);
                                 var20 = -1;

                                 while(true) {
                                    var21 = var65.method3046();
                                    if(var21 == 0) {
                                       continue label1217;
                                    }

                                    var20 += var21;
                                    var56 = 0;

                                    while(true) {
                                       var57 = var65.method3046();
                                       if(var57 == 0) {
                                          break;
                                       }

                                       var56 += var57 - 1;
                                       var24 = var56 & 63;
                                       var25 = var56 >> 6 & 63;
                                       var26 = var56 >> 12;
                                       var27 = var65.readUnsignedByte();
                                       var28 = var27 >> 2;
                                       var29 = var27 & 3;
                                       if(var6 == var26 && var25 >= var15 && var25 < var15 + 8 && var24 >= var16 && var24 < var16 + 8) {
                                          ObjectComposition var30 = class29.getObjectDefinition(var20);
                                          var31 = var13 + class162.method2948(var25 & 7, var24 & 7, var62, var30.sizeX, var30.sizeY, var29);
                                          var32 = var14 + class163.method2955(var25 & 7, var24 & 7, var62, var30.sizeX, var30.sizeY, var29);
                                          if(var31 > 0 && var32 > 0 && var31 < 103 && var32 < 103) {
                                             var33 = var44;
                                             if((class61.tileSettings[1][var31][var32] & 2) == 2) {
                                                var33 = var44 - 1;
                                             }

                                             CollisionData var34 = null;
                                             if(var33 >= 0) {
                                                var34 = var52[var33];
                                             }

                                             class47.method672(var44, var31, var32, var20, var62 + var29 & 3, var28, var55, var34);
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

            class73.method1065(true);
            class7.method33();
            class69.method1035();
            Region var60 = class17.region;
            CollisionData[] var70 = Client.collisionMaps;

            for(var4 = 0; var4 < 4; ++var4) {
               for(var5 = 0; var5 < 104; ++var5) {
                  for(var6 = 0; var6 < 104; ++var6) {
                     if((class61.tileSettings[var4][var5][var6] & 1) == 1) {
                        var62 = var4;
                        if((class61.tileSettings[1][var5][var6] & 2) == 2) {
                           var62 = var4 - 1;
                        }

                        if(var62 >= 0) {
                           var70[var62].method2913(var5, var6);
                        }
                     }
                  }
               }
            }

            class61.field761 += (int)(Math.random() * 5.0D) - 2;
            if(class61.field761 < -8) {
               class61.field761 = -8;
            }

            if(class61.field761 > 8) {
               class61.field761 = 8;
            }

            class61.field762 += (int)(Math.random() * 5.0D) - 2;
            if(class61.field762 < -16) {
               class61.field762 = -16;
            }

            if(class61.field762 > 16) {
               class61.field762 = 16;
            }

            for(var4 = 0; var4 < 4; ++var4) {
               byte[][] var68 = class267.field3669[var4];
               var11 = (int)Math.sqrt(5100.0D);
               var64 = var11 * 768 >> 8;

               for(var13 = 1; var13 < 103; ++var13) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     var15 = class61.tileHeights[var4][var14 + 1][var13] - class61.tileHeights[var4][var14 - 1][var13];
                     var16 = class61.tileHeights[var4][var14][var13 + 1] - class61.tileHeights[var4][var14][var13 - 1];
                     var17 = (int)Math.sqrt((double)(var15 * var15 + 65536 + var16 * var16));
                     var18 = (var15 << 8) / var17;
                     var53 = 65536 / var17;
                     var20 = (var16 << 8) / var17;
                     var21 = (var18 * -50 + var53 * -10 + var20 * -50) / var64 + 96;
                     var56 = (var68[var14][var13] >> 1) + (var68[var14 + 1][var13] >> 3) + (var68[var14 - 1][var13] >> 2) + (var68[var14][var13 - 1] >> 2) + (var68[var14][var13 + 1] >> 3);
                     XItemContainer.field774[var14][var13] = var21 - var56;
                  }
               }

               for(var13 = 0; var13 < 104; ++var13) {
                  Widget.field2648[var13] = 0;
                  class61.field753[var13] = 0;
                  WallObject.field2140[var13] = 0;
                  class40.field552[var13] = 0;
                  WidgetNode.field810[var13] = 0;
               }

               for(var13 = -5; var13 < 109; ++var13) {
                  for(var14 = 0; var14 < 104; ++var14) {
                     var15 = var13 + 5;
                     if(var15 >= 0 && var15 < 104) {
                        var16 = class61.underlayIds[var4][var15][var14] & 255;
                        if(var16 > 0) {
                           FloorUnderlayDefinition var72 = Preferences.method1512(var16 - 1);
                           Widget.field2648[var14] += var72.field3356;
                           class61.field753[var14] += var72.field3350;
                           WallObject.field2140[var14] += var72.field3352;
                           class40.field552[var14] += var72.field3353;
                           ++WidgetNode.field810[var14];
                        }
                     }

                     var16 = var13 - 5;
                     if(var16 >= 0 && var16 < 104) {
                        var17 = class61.underlayIds[var4][var16][var14] & 255;
                        if(var17 > 0) {
                           FloorUnderlayDefinition var71 = Preferences.method1512(var17 - 1);
                           Widget.field2648[var14] -= var71.field3356;
                           class61.field753[var14] -= var71.field3350;
                           WallObject.field2140[var14] -= var71.field3352;
                           class40.field552[var14] -= var71.field3353;
                           --WidgetNode.field810[var14];
                        }
                     }
                  }

                  if(var13 >= 1 && var13 < 103) {
                     var14 = 0;
                     var15 = 0;
                     var16 = 0;
                     var17 = 0;
                     var18 = 0;

                     for(var53 = -5; var53 < 109; ++var53) {
                        var20 = var53 + 5;
                        if(var20 >= 0 && var20 < 104) {
                           var14 += Widget.field2648[var20];
                           var15 += class61.field753[var20];
                           var16 += WallObject.field2140[var20];
                           var17 += class40.field552[var20];
                           var18 += WidgetNode.field810[var20];
                        }

                        var21 = var53 - 5;
                        if(var21 >= 0 && var21 < 104) {
                           var14 -= Widget.field2648[var21];
                           var15 -= class61.field753[var21];
                           var16 -= WallObject.field2140[var21];
                           var17 -= class40.field552[var21];
                           var18 -= WidgetNode.field810[var21];
                        }

                        if(var53 >= 1 && var53 < 103 && (!Client.field1055 || (class61.tileSettings[0][var13][var53] & 2) != 0 || (class61.tileSettings[var4][var13][var53] & 16) == 0)) {
                           if(var4 < class61.field759) {
                              class61.field759 = var4;
                           }

                           var56 = class61.underlayIds[var4][var13][var53] & 255;
                           var57 = class61.overlayIds[var4][var13][var53] & 255;
                           if(var56 > 0 || var57 > 0) {
                              var24 = class61.tileHeights[var4][var13][var53];
                              var25 = class61.tileHeights[var4][var13 + 1][var53];
                              var26 = class61.tileHeights[var4][var13 + 1][var53 + 1];
                              var27 = class61.tileHeights[var4][var13][var53 + 1];
                              var28 = XItemContainer.field774[var13][var53];
                              var29 = XItemContainer.field774[var13 + 1][var53];
                              int var58 = XItemContainer.field774[var13 + 1][var53 + 1];
                              var31 = XItemContainer.field774[var13][var53 + 1];
                              var32 = -1;
                              var33 = -1;
                              int var35;
                              int var59;
                              if(var56 > 0) {
                                 var59 = var14 * 256 / var17;
                                 var35 = var15 / var18;
                                 int var36 = var16 / var18;
                                 var32 = class9.method47(var59, var35, var36);
                                 var59 = class61.field761 + var59 & 255;
                                 var36 += class61.field762;
                                 if(var36 < 0) {
                                    var36 = 0;
                                 } else if(var36 > 255) {
                                    var36 = 255;
                                 }

                                 var33 = class9.method47(var59, var35, var36);
                              }

                              if(var4 > 0) {
                                 boolean var73 = true;
                                 if(var56 == 0 && class90.overlayPaths[var4][var13][var53] != 0) {
                                    var73 = false;
                                 }

                                 if(var57 > 0 && !class252.method4319(var57 - 1).isHidden) {
                                    var73 = false;
                                 }

                                 if(var73 && var24 == var25 && var26 == var24 && var24 == var27) {
                                    class61.field750[var4][var13][var53] |= 2340;
                                 }
                              }

                              var59 = 0;
                              if(var33 != -1) {
                                 var59 = class136.colorPalette[class45.method627(var33, 96)];
                              }

                              if(var57 == 0) {
                                 var60.method2583(var4, var13, var53, 0, 0, -1, var24, var25, var26, var27, class45.method627(var32, var28), class45.method627(var32, var29), class45.method627(var32, var58), class45.method627(var32, var31), 0, 0, 0, 0, var59, 0);
                              } else {
                                 var35 = class90.overlayPaths[var4][var13][var53] + 1;
                                 byte var67 = class275.overlayRotations[var4][var13][var53];
                                 Overlay var37 = class252.method4319(var57 - 1);
                                 int var38 = var37.texture;
                                 int var39;
                                 int var40;
                                 int var41;
                                 int var42;
                                 if(var38 >= 0) {
                                    var40 = class136.field2028.vmethod2771(var38);
                                    var39 = -1;
                                 } else if(var37.color == 16711935) {
                                    var39 = -2;
                                    var38 = -1;
                                    var40 = -2;
                                 } else {
                                    var39 = class9.method47(var37.hue, var37.saturation, var37.lightness);
                                    var41 = class61.field761 + var37.hue & 255;
                                    var42 = class61.field762 + var37.lightness;
                                    if(var42 < 0) {
                                       var42 = 0;
                                    } else if(var42 > 255) {
                                       var42 = 255;
                                    }

                                    var40 = class9.method47(var41, var37.saturation, var42);
                                 }

                                 var41 = 0;
                                 if(var40 != -2) {
                                    var41 = class136.colorPalette[WorldMapType1.method275(var40, 96)];
                                 }

                                 if(var37.field3595 != -1) {
                                    var42 = class61.field761 + var37.field3599 & 255;
                                    int var43 = class61.field762 + var37.field3598;
                                    if(var43 < 0) {
                                       var43 = 0;
                                    } else if(var43 > 255) {
                                       var43 = 255;
                                    }

                                    var40 = class9.method47(var42, var37.field3600, var43);
                                    var41 = class136.colorPalette[WorldMapType1.method275(var40, 96)];
                                 }

                                 var60.method2583(var4, var13, var53, var35, var67, var38, var24, var25, var26, var27, class45.method627(var32, var28), class45.method627(var32, var29), class45.method627(var32, var58), class45.method627(var32, var31), WorldMapType1.method275(var39, var28), WorldMapType1.method275(var39, var29), WorldMapType1.method275(var39, var58), WorldMapType1.method275(var39, var31), var59, var41);
                              }
                           }
                        }
                     }
                  }
               }

               for(var13 = 1; var13 < 103; ++var13) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     var60.method2582(var4, var14, var13, class12.method70(var4, var14, var13));
                  }
               }

               class61.underlayIds[var4] = null;
               class61.overlayIds[var4] = null;
               class90.overlayPaths[var4] = null;
               class275.overlayRotations[var4] = null;
               class267.field3669[var4] = null;
            }

            var60.method2609(-50, -10, -50);

            for(var4 = 0; var4 < 104; ++var4) {
               for(var5 = 0; var5 < 104; ++var5) {
                  if((class61.tileSettings[1][var4][var5] & 2) == 2) {
                     var60.method2580(var4, var5);
                  }
               }
            }

            var4 = 1;
            var5 = 2;
            var6 = 4;

            for(var62 = 0; var62 < 4; ++var62) {
               if(var62 > 0) {
                  var4 <<= 3;
                  var5 <<= 3;
                  var6 <<= 3;
               }

               for(var50 = 0; var50 <= var62; ++var50) {
                  for(var9 = 0; var9 <= 104; ++var9) {
                     for(var10 = 0; var10 <= 104; ++var10) {
                        short var66;
                        if((class61.field750[var50][var10][var9] & var4) != 0) {
                           var11 = var9;
                           var64 = var9;
                           var13 = var50;

                           for(var14 = var50; var11 > 0 && (class61.field750[var50][var10][var11 - 1] & var4) != 0; --var11) {
                              ;
                           }

                           while(var64 < 104 && (class61.field750[var50][var10][var64 + 1] & var4) != 0) {
                              ++var64;
                           }

                           label952:
                           while(var13 > 0) {
                              for(var15 = var11; var15 <= var64; ++var15) {
                                 if((class61.field750[var13 - 1][var10][var15] & var4) == 0) {
                                    break label952;
                                 }
                              }

                              --var13;
                           }

                           label941:
                           while(var14 < var62) {
                              for(var15 = var11; var15 <= var64; ++var15) {
                                 if((class61.field750[var14 + 1][var10][var15] & var4) == 0) {
                                    break label941;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (var64 - var11 + 1) * (var14 + 1 - var13);
                           if(var15 >= 8) {
                              var66 = 240;
                              var17 = class61.tileHeights[var14][var10][var11] - var66;
                              var18 = class61.tileHeights[var13][var10][var11];
                              Region.method2581(var62, 1, var10 * 128, var10 * 128, var11 * 128, var64 * 128 + 128, var17, var18);

                              for(var53 = var13; var53 <= var14; ++var53) {
                                 for(var20 = var11; var20 <= var64; ++var20) {
                                    class61.field750[var53][var10][var20] &= ~var4;
                                 }
                              }
                           }
                        }

                        if((class61.field750[var50][var10][var9] & var5) != 0) {
                           var11 = var10;
                           var64 = var10;
                           var13 = var50;

                           for(var14 = var50; var11 > 0 && (class61.field750[var50][var11 - 1][var9] & var5) != 0; --var11) {
                              ;
                           }

                           while(var64 < 104 && (class61.field750[var50][var64 + 1][var9] & var5) != 0) {
                              ++var64;
                           }

                           label1005:
                           while(var13 > 0) {
                              for(var15 = var11; var15 <= var64; ++var15) {
                                 if((class61.field750[var13 - 1][var15][var9] & var5) == 0) {
                                    break label1005;
                                 }
                              }

                              --var13;
                           }

                           label994:
                           while(var14 < var62) {
                              for(var15 = var11; var15 <= var64; ++var15) {
                                 if((class61.field750[var14 + 1][var15][var9] & var5) == 0) {
                                    break label994;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (var64 - var11 + 1) * (var14 + 1 - var13);
                           if(var15 >= 8) {
                              var66 = 240;
                              var17 = class61.tileHeights[var14][var11][var9] - var66;
                              var18 = class61.tileHeights[var13][var11][var9];
                              Region.method2581(var62, 2, var11 * 128, var64 * 128 + 128, var9 * 128, var9 * 128, var17, var18);

                              for(var53 = var13; var53 <= var14; ++var53) {
                                 for(var20 = var11; var20 <= var64; ++var20) {
                                    class61.field750[var53][var20][var9] &= ~var5;
                                 }
                              }
                           }
                        }

                        if((class61.field750[var50][var10][var9] & var6) != 0) {
                           var11 = var10;
                           var64 = var10;
                           var13 = var9;

                           for(var14 = var9; var13 > 0 && (class61.field750[var50][var10][var13 - 1] & var6) != 0; --var13) {
                              ;
                           }

                           while(var14 < 104 && (class61.field750[var50][var10][var14 + 1] & var6) != 0) {
                              ++var14;
                           }

                           label1058:
                           while(var11 > 0) {
                              for(var15 = var13; var15 <= var14; ++var15) {
                                 if((class61.field750[var50][var11 - 1][var15] & var6) == 0) {
                                    break label1058;
                                 }
                              }

                              --var11;
                           }

                           label1047:
                           while(var64 < 104) {
                              for(var15 = var13; var15 <= var14; ++var15) {
                                 if((class61.field750[var50][var64 + 1][var15] & var6) == 0) {
                                    break label1047;
                                 }
                              }

                              ++var64;
                           }

                           if((var14 - var13 + 1) * (var64 - var11 + 1) >= 4) {
                              var15 = class61.tileHeights[var50][var11][var13];
                              Region.method2581(var62, 4, var11 * 128, var64 * 128 + 128, var13 * 128, var14 * 128 + 128, var15, var15);

                              for(var16 = var11; var16 <= var64; ++var16) {
                                 for(var17 = var13; var17 <= var14; ++var17) {
                                    class61.field750[var50][var16][var17] &= ~var6;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            class73.method1065(true);
            var4 = class61.field759;
            if(var4 > Player.plane) {
               var4 = Player.plane;
            }

            if(var4 < Player.plane - 1) {
               var4 = Player.plane - 1;
            }

            if(Client.field1055) {
               class17.region.method2631(class61.field759);
            } else {
               class17.region.method2631(0);
            }

            for(var5 = 0; var5 < 104; ++var5) {
               for(var6 = 0; var6 < 104; ++var6) {
                  class47.groundItemSpawned(var5, var6);
               }
            }

            class69.method1035();

            for(PendingSpawn var69 = (PendingSpawn)Client.pendingSpawns.method3487(); var69 != null; var69 = (PendingSpawn)Client.pendingSpawns.method3512()) {
               if(var69.hitpoints == -1) {
                  var69.delay = 0;
                  class50.method727(var69);
               } else {
                  var69.unlink();
               }
            }

            ObjectComposition.field3453.reset();
            if(class220.field2817.method828()) {
               Client.secretPacketBuffer1.putOpcode(194);
               Client.secretPacketBuffer1.putInt(1057001181);
            }

            if(!Client.isDynamicRegion) {
               var5 = (class34.field501 - 6) / 8;
               var6 = (class34.field501 + 6) / 8;
               var62 = (class13.field289 - 6) / 8;
               var50 = (class13.field289 + 6) / 8;

               for(var9 = var5 - 1; var9 <= var6 + 1; ++var9) {
                  for(var10 = var62 - 1; var10 <= var50 + 1; ++var10) {
                     if(var9 < var5 || var9 > var6 || var10 < var62 || var10 > var50) {
                        class177.indexMaps.method4008("m" + var9 + "_" + var10);
                        class177.indexMaps.method4008("l" + var9 + "_" + var10);
                     }
                  }
               }
            }

            class23.setGameState(30);
            class69.method1035();
            class50.method726();
            Client.secretPacketBuffer1.putOpcode(9);
            GameEngine.field707.vmethod2872();

            for(var5 = 0; var5 < 32; ++var5) {
               GameEngine.field702[var5] = 0L;
            }

            for(var5 = 0; var5 < 32; ++var5) {
               GameEngine.field703[var5] = 0L;
            }

            GameEngine.field697 = 0;
         }
      }
   }
}
