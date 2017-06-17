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

         int var2;
         int var3;
         Buffer var4;
         int var5;
         int var6;
         int var7;
         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         int var13;
         for(var1 = 0; var1 < WidgetNode.field814.length; ++var1) {
            byte[] var14 = class40.field554[var1];
            if(var14 != null) {
               var2 = (class13.mapRegions[var1] >> 8) * 64 - class19.baseX;
               var3 = (class13.mapRegions[var1] & 255) * 64 - class21.baseY;
               if(Client.isDynamicRegion) {
                  var2 = 10;
                  var3 = 10;
               }

               boolean var15 = true;
               var4 = new Buffer(var14);
               var5 = -1;

               label1255:
               while(true) {
                  var6 = var4.method3046();
                  if(var6 == 0) {
                     var0 &= var15;
                     break;
                  }

                  var5 += var6;
                  var7 = 0;
                  boolean var16 = false;

                  while(true) {
                     ObjectComposition var17;
                     do {
                        do {
                           do {
                              do {
                                 do {
                                    while(var16) {
                                       var8 = var4.method3046();
                                       if(var8 == 0) {
                                          continue label1255;
                                       }

                                       var4.readUnsignedByte();
                                    }

                                    var8 = var4.method3046();
                                    if(var8 == 0) {
                                       continue label1255;
                                    }

                                    var7 += var8 - 1;
                                    var9 = var7 & 63;
                                    var10 = var7 >> 6 & 63;
                                    var11 = var4.readUnsignedByte() >> 2;
                                    var12 = var2 + var10;
                                    var13 = var3 + var9;
                                 } while(var12 <= 0);
                              } while(var13 <= 0);
                           } while(var12 >= 103);
                        } while(var13 >= 103);

                        var17 = class29.getObjectDefinition(var5);
                     } while(var11 == 22 && Client.field1055 && var17.field3445 == 0 && var17.field3476 != 1 && !var17.field3480);

                     if(!var17.method4429()) {
                        ++Client.field1127;
                        var15 = false;
                     }

                     var16 = true;
                  }
               }
            }
         }

         if(!var0) {
            Client.field1113 = 2;
         } else {
            if(Client.field1113 != 0) {
               class158.drawStatusBox("Loading - please wait.<br> (100%)", true);
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

            int var48;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var48 = 0; var48 < 104; ++var48) {
                  for(var2 = 0; var2 < 104; ++var2) {
                     class61.tileSettings[var1][var48][var2] = 0;
                  }
               }
            }

            class69.method1035();
            Ignore.method1044();
            var1 = WidgetNode.field814.length;
            class66.method1026();
            class73.method1065(true);
            int var18;
            int var19;
            int var20;
            int var21;
            int var49;
            int var50;
            int var51;
            if(!Client.isDynamicRegion) {
               var48 = 0;

               label1179:
               while(true) {
                  byte[] var22;
                  if(var48 >= var1) {
                     for(var48 = 0; var48 < var1; ++var48) {
                        var2 = (class13.mapRegions[var48] >> 8) * 64 - class19.baseX;
                        var3 = (class13.mapRegions[var48] & 255) * 64 - class21.baseY;
                        var22 = WidgetNode.field814[var48];
                        if(var22 == null && class13.field289 < 800) {
                           class69.method1035();
                           class174.method3250(var2, var3, 64, 64);
                        }
                     }

                     class73.method1065(true);
                     var48 = 0;

                     while(true) {
                        if(var48 >= var1) {
                           break label1179;
                        }

                        byte[] var53 = class40.field554[var48];
                        if(var53 != null) {
                           var3 = (class13.mapRegions[var48] >> 8) * 64 - class19.baseX;
                           var49 = (class13.mapRegions[var48] & 255) * 64 - class21.baseY;
                           class69.method1035();
                           Region var55 = class17.region;
                           CollisionData[] var25 = Client.collisionMaps;
                           var4 = new Buffer(var53);
                           var5 = -1;

                           while(true) {
                              var6 = var4.method3046();
                              if(var6 == 0) {
                                 break;
                              }

                              var5 += var6;
                              var7 = 0;

                              while(true) {
                                 var21 = var4.method3046();
                                 if(var21 == 0) {
                                    break;
                                 }

                                 var7 += var21 - 1;
                                 var8 = var7 & 63;
                                 var9 = var7 >> 6 & 63;
                                 var10 = var7 >> 12;
                                 var11 = var4.readUnsignedByte();
                                 var12 = var11 >> 2;
                                 var13 = var11 & 3;
                                 var19 = var3 + var9;
                                 var51 = var49 + var8;
                                 if(var19 > 0 && var51 > 0 && var19 < 103 && var51 < 103) {
                                    var18 = var10;
                                    if((class61.tileSettings[1][var19][var51] & 2) == 2) {
                                       var18 = var10 - 1;
                                    }

                                    CollisionData var26 = null;
                                    if(var18 >= 0) {
                                       var26 = var25[var18];
                                    }

                                    class47.method672(var10, var19, var51, var5, var13, var12, var55, var26);
                                 }
                              }
                           }
                        }

                        ++var48;
                     }
                  }

                  var2 = (class13.mapRegions[var48] >> 8) * 64 - class19.baseX;
                  var3 = (class13.mapRegions[var48] & 255) * 64 - class21.baseY;
                  var22 = WidgetNode.field814[var48];
                  if(var22 != null) {
                     class69.method1035();
                     var50 = class34.field501 * 8 - 48;
                     var20 = class13.field289 * 8 - 48;
                     CollisionData[] var23 = Client.collisionMaps;
                     var5 = 0;

                     label1176:
                     while(true) {
                        if(var5 >= 4) {
                           Buffer var24 = new Buffer(var22);
                           var6 = 0;

                           while(true) {
                              if(var6 >= 4) {
                                 break label1176;
                              }

                              for(var7 = 0; var7 < 64; ++var7) {
                                 for(var21 = 0; var21 < 64; ++var21) {
                                    class109.method1968(var24, var6, var2 + var7, var21 + var3, var50, var20, 0);
                                 }
                              }

                              ++var6;
                           }
                        }

                        for(var6 = 0; var6 < 64; ++var6) {
                           for(var7 = 0; var7 < 64; ++var7) {
                              if(var6 + var2 > 0 && var6 + var2 < 103 && var7 + var3 > 0 && var3 + var7 < 103) {
                                 var23[var5].flags[var6 + var2][var3 + var7] &= -16777217;
                              }
                           }
                        }

                        ++var5;
                     }
                  }

                  ++var48;
               }
            }

            int var27;
            int var28;
            int var29;
            int var30;
            int var31;
            int var32;
            int var33;
            int var52;
            int var54;
            int var56;
            int var57;
            int var58;
            if(Client.isDynamicRegion) {
               var48 = 0;

               label1112:
               while(true) {
                  CollisionData[] var34;
                  Buffer var35;
                  if(var48 >= 4) {
                     for(var48 = 0; var48 < 13; ++var48) {
                        for(var2 = 0; var2 < 13; ++var2) {
                           var3 = Client.field967[0][var48][var2];
                           if(var3 == -1) {
                              class174.method3250(var48 * 8, var2 * 8, 8, 8);
                           }
                        }
                     }

                     class73.method1065(true);
                     var48 = 0;

                     while(true) {
                        if(var48 >= 4) {
                           break label1112;
                        }

                        class69.method1035();

                        for(var2 = 0; var2 < 13; ++var2) {
                           label1001:
                           for(var3 = 0; var3 < 13; ++var3) {
                              var49 = Client.field967[var48][var2][var3];
                              if(var49 != -1) {
                                 var50 = var49 >> 24 & 3;
                                 var20 = var49 >> 1 & 3;
                                 var31 = var49 >> 14 & 1023;
                                 var5 = var49 >> 3 & 2047;
                                 var6 = var5 / 8 + (var31 / 8 << 8);

                                 for(var7 = 0; var7 < class13.mapRegions.length; ++var7) {
                                    if(var6 == class13.mapRegions[var7] && class40.field554[var7] != null) {
                                       byte[] var61 = class40.field554[var7];
                                       var8 = var2 * 8;
                                       var9 = var3 * 8;
                                       var10 = (var31 & 7) * 8;
                                       var11 = (var5 & 7) * 8;
                                       Region var63 = class17.region;
                                       var34 = Client.collisionMaps;
                                       var35 = new Buffer(var61);
                                       var51 = -1;

                                       while(true) {
                                          var18 = var35.method3046();
                                          if(var18 == 0) {
                                             continue label1001;
                                          }

                                          var51 += var18;
                                          var32 = 0;

                                          while(true) {
                                             var33 = var35.method3046();
                                             if(var33 == 0) {
                                                break;
                                             }

                                             var32 += var33 - 1;
                                             var52 = var32 & 63;
                                             var54 = var32 >> 6 & 63;
                                             var56 = var32 >> 12;
                                             var57 = var35.readUnsignedByte();
                                             var58 = var57 >> 2;
                                             var27 = var57 & 3;
                                             if(var50 == var56 && var54 >= var10 && var54 < var10 + 8 && var52 >= var11 && var52 < var11 + 8) {
                                                ObjectComposition var38 = class29.getObjectDefinition(var51);
                                                var28 = var8 + class162.method2948(var54 & 7, var52 & 7, var20, var38.sizeX, var38.sizeY, var27);
                                                var29 = var9 + class163.method2955(var54 & 7, var52 & 7, var20, var38.sizeX, var38.sizeY, var27);
                                                if(var28 > 0 && var29 > 0 && var28 < 103 && var29 < 103) {
                                                   var30 = var48;
                                                   if((class61.tileSettings[1][var28][var29] & 2) == 2) {
                                                      var30 = var48 - 1;
                                                   }

                                                   CollisionData var39 = null;
                                                   if(var30 >= 0) {
                                                      var39 = var34[var30];
                                                   }

                                                   class47.method672(var48, var28, var29, var51, var20 + var27 & 3, var58, var63, var39);
                                                }
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }

                        ++var48;
                     }
                  }

                  class69.method1035();

                  for(var2 = 0; var2 < 13; ++var2) {
                     for(var3 = 0; var3 < 13; ++var3) {
                        boolean var36 = false;
                        var50 = Client.field967[var48][var2][var3];
                        if(var50 != -1) {
                           var20 = var50 >> 24 & 3;
                           var31 = var50 >> 1 & 3;
                           var5 = var50 >> 14 & 1023;
                           var6 = var50 >> 3 & 2047;
                           var7 = (var5 / 8 << 8) + var6 / 8;

                           for(var21 = 0; var21 < class13.mapRegions.length; ++var21) {
                              if(class13.mapRegions[var21] == var7 && WidgetNode.field814[var21] != null) {
                                 byte[] var37 = WidgetNode.field814[var21];
                                 var9 = var2 * 8;
                                 var10 = var3 * 8;
                                 var11 = (var5 & 7) * 8;
                                 var12 = (var6 & 7) * 8;
                                 var34 = Client.collisionMaps;

                                 for(var19 = 0; var19 < 8; ++var19) {
                                    for(var51 = 0; var51 < 8; ++var51) {
                                       if(var19 + var9 > 0 && var19 + var9 < 103 && var51 + var10 > 0 && var10 + var51 < 103) {
                                          var34[var48].flags[var19 + var9][var10 + var51] &= -16777217;
                                       }
                                    }
                                 }

                                 var35 = new Buffer(var37);

                                 for(var51 = 0; var51 < 4; ++var51) {
                                    for(var18 = 0; var18 < 64; ++var18) {
                                       for(var32 = 0; var32 < 64; ++var32) {
                                          if(var20 == var51 && var18 >= var11 && var18 < var11 + 8 && var32 >= var12 && var32 < var12 + 8) {
                                             var57 = var18 & 7;
                                             var58 = var32 & 7;
                                             var27 = var31 & 3;
                                             if(var27 == 0) {
                                                var56 = var57;
                                             } else if(var27 == 1) {
                                                var56 = var58;
                                             } else if(var27 == 2) {
                                                var56 = 7 - var57;
                                             } else {
                                                var56 = 7 - var58;
                                             }

                                             class109.method1968(var35, var48, var56 + var9, var10 + ChatMessages.method1716(var18 & 7, var32 & 7, var31), 0, 0, var31);
                                          } else {
                                             class109.method1968(var35, 0, -1, -1, 0, 0, 0);
                                          }
                                       }
                                    }
                                 }

                                 var36 = true;
                                 break;
                              }
                           }
                        }

                        if(!var36) {
                           var20 = var48;
                           var31 = var2 * 8;
                           var5 = var3 * 8;

                           for(var6 = 0; var6 < 8; ++var6) {
                              for(var7 = 0; var7 < 8; ++var7) {
                                 class61.tileHeights[var20][var31 + var6][var7 + var5] = 0;
                              }
                           }

                           if(var31 > 0) {
                              for(var6 = 1; var6 < 8; ++var6) {
                                 class61.tileHeights[var20][var31][var6 + var5] = class61.tileHeights[var20][var31 - 1][var6 + var5];
                              }
                           }

                           if(var5 > 0) {
                              for(var6 = 1; var6 < 8; ++var6) {
                                 class61.tileHeights[var20][var6 + var31][var5] = class61.tileHeights[var20][var6 + var31][var5 - 1];
                              }
                           }

                           if(var31 > 0 && class61.tileHeights[var20][var31 - 1][var5] != 0) {
                              class61.tileHeights[var20][var31][var5] = class61.tileHeights[var20][var31 - 1][var5];
                           } else if(var5 > 0 && class61.tileHeights[var20][var31][var5 - 1] != 0) {
                              class61.tileHeights[var20][var31][var5] = class61.tileHeights[var20][var31][var5 - 1];
                           } else if(var31 > 0 && var5 > 0 && class61.tileHeights[var20][var31 - 1][var5 - 1] != 0) {
                              class61.tileHeights[var20][var31][var5] = class61.tileHeights[var20][var31 - 1][var5 - 1];
                           }
                        }
                     }
                  }

                  ++var48;
               }
            }

            class73.method1065(true);
            class7.method33();
            class69.method1035();
            Region var59 = class17.region;
            CollisionData[] var60 = Client.collisionMaps;

            for(var3 = 0; var3 < 4; ++var3) {
               for(var49 = 0; var49 < 104; ++var49) {
                  for(var50 = 0; var50 < 104; ++var50) {
                     if((class61.tileSettings[var3][var49][var50] & 1) == 1) {
                        var20 = var3;
                        if((class61.tileSettings[1][var49][var50] & 2) == 2) {
                           var20 = var3 - 1;
                        }

                        if(var20 >= 0) {
                           var60[var20].method2913(var49, var50);
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

            for(var3 = 0; var3 < 4; ++var3) {
               byte[][] var62 = class267.field3669[var3];
               var7 = (int)Math.sqrt(5100.0D);
               var21 = var7 * 768 >> 8;

               for(var8 = 1; var8 < 103; ++var8) {
                  for(var9 = 1; var9 < 103; ++var9) {
                     var10 = class61.tileHeights[var3][var9 + 1][var8] - class61.tileHeights[var3][var9 - 1][var8];
                     var11 = class61.tileHeights[var3][var9][var8 + 1] - class61.tileHeights[var3][var9][var8 - 1];
                     var12 = (int)Math.sqrt((double)(var10 * var10 + 65536 + var11 * var11));
                     var13 = (var10 << 8) / var12;
                     var19 = 65536 / var12;
                     var51 = (var11 << 8) / var12;
                     var18 = (var13 * -50 + var19 * -10 + var51 * -50) / var21 + 96;
                     var32 = (var62[var9][var8] >> 1) + (var62[var9 + 1][var8] >> 3) + (var62[var9 - 1][var8] >> 2) + (var62[var9][var8 - 1] >> 2) + (var62[var9][var8 + 1] >> 3);
                     XItemContainer.field774[var9][var8] = var18 - var32;
                  }
               }

               for(var8 = 0; var8 < 104; ++var8) {
                  Widget.field2648[var8] = 0;
                  class61.field753[var8] = 0;
                  WallObject.field2140[var8] = 0;
                  class40.field552[var8] = 0;
                  WidgetNode.field810[var8] = 0;
               }

               for(var8 = -5; var8 < 109; ++var8) {
                  for(var9 = 0; var9 < 104; ++var9) {
                     var10 = var8 + 5;
                     FloorUnderlayDefinition var64;
                     if(var10 >= 0 && var10 < 104) {
                        var11 = class61.underlayIds[var3][var10][var9] & 255;
                        if(var11 > 0) {
                           var64 = Preferences.method1512(var11 - 1);
                           Widget.field2648[var9] += var64.field3356;
                           class61.field753[var9] += var64.field3350;
                           WallObject.field2140[var9] += var64.field3352;
                           class40.field552[var9] += var64.field3353;
                           ++WidgetNode.field810[var9];
                        }
                     }

                     var11 = var8 - 5;
                     if(var11 >= 0 && var11 < 104) {
                        var12 = class61.underlayIds[var3][var11][var9] & 255;
                        if(var12 > 0) {
                           var64 = Preferences.method1512(var12 - 1);
                           Widget.field2648[var9] -= var64.field3356;
                           class61.field753[var9] -= var64.field3350;
                           WallObject.field2140[var9] -= var64.field3352;
                           class40.field552[var9] -= var64.field3353;
                           --WidgetNode.field810[var9];
                        }
                     }
                  }

                  if(var8 >= 1 && var8 < 103) {
                     var9 = 0;
                     var10 = 0;
                     var11 = 0;
                     var12 = 0;
                     var13 = 0;

                     for(var19 = -5; var19 < 109; ++var19) {
                        var51 = var19 + 5;
                        if(var51 >= 0 && var51 < 104) {
                           var9 += Widget.field2648[var51];
                           var10 += class61.field753[var51];
                           var11 += WallObject.field2140[var51];
                           var12 += class40.field552[var51];
                           var13 += WidgetNode.field810[var51];
                        }

                        var18 = var19 - 5;
                        if(var18 >= 0 && var18 < 104) {
                           var9 -= Widget.field2648[var18];
                           var10 -= class61.field753[var18];
                           var11 -= WallObject.field2140[var18];
                           var12 -= class40.field552[var18];
                           var13 -= WidgetNode.field810[var18];
                        }

                        if(var19 >= 1 && var19 < 103 && (!Client.field1055 || (class61.tileSettings[0][var8][var19] & 2) != 0 || (class61.tileSettings[var3][var8][var19] & 16) == 0)) {
                           if(var3 < class61.field759) {
                              class61.field759 = var3;
                           }

                           var32 = class61.underlayIds[var3][var8][var19] & 255;
                           var33 = class61.overlayIds[var3][var8][var19] & 255;
                           if(var32 > 0 || var33 > 0) {
                              var52 = class61.tileHeights[var3][var8][var19];
                              var54 = class61.tileHeights[var3][var8 + 1][var19];
                              var56 = class61.tileHeights[var3][var8 + 1][var19 + 1];
                              var57 = class61.tileHeights[var3][var8][var19 + 1];
                              var58 = XItemContainer.field774[var8][var19];
                              var27 = XItemContainer.field774[var8 + 1][var19];
                              int var67 = XItemContainer.field774[var8 + 1][var19 + 1];
                              var28 = XItemContainer.field774[var8][var19 + 1];
                              var29 = -1;
                              var30 = -1;
                              int var68;
                              int var69;
                              if(var32 > 0) {
                                 var69 = var9 * 256 / var12;
                                 var68 = var10 / var13;
                                 int var40 = var11 / var13;
                                 var29 = class9.method47(var69, var68, var40);
                                 var69 = class61.field761 + var69 & 255;
                                 var40 += class61.field762;
                                 if(var40 < 0) {
                                    var40 = 0;
                                 } else if(var40 > 255) {
                                    var40 = 255;
                                 }

                                 var30 = class9.method47(var69, var68, var40);
                              }

                              if(var3 > 0) {
                                 boolean var70 = true;
                                 if(var32 == 0 && class90.overlayPaths[var3][var8][var19] != 0) {
                                    var70 = false;
                                 }

                                 if(var33 > 0 && !class252.method4319(var33 - 1).isHidden) {
                                    var70 = false;
                                 }

                                 if(var70 && var52 == var54 && var56 == var52 && var52 == var57) {
                                    class61.field750[var3][var8][var19] |= 2340;
                                 }
                              }

                              var69 = 0;
                              if(var30 != -1) {
                                 var69 = class136.colorPalette[class45.method627(var30, 96)];
                              }

                              if(var33 == 0) {
                                 var59.method2583(var3, var8, var19, 0, 0, -1, var52, var54, var56, var57, class45.method627(var29, var58), class45.method627(var29, var27), class45.method627(var29, var67), class45.method627(var29, var28), 0, 0, 0, 0, var69, 0);
                              } else {
                                 var68 = class90.overlayPaths[var3][var8][var19] + 1;
                                 byte var71 = class275.overlayRotations[var3][var8][var19];
                                 Overlay var41 = class252.method4319(var33 - 1);
                                 int var42 = var41.texture;
                                 int var43;
                                 int var44;
                                 int var45;
                                 int var46;
                                 if(var42 >= 0) {
                                    var44 = class136.field2028.vmethod2771(var42);
                                    var43 = -1;
                                 } else if(var41.color == 16711935) {
                                    var43 = -2;
                                    var42 = -1;
                                    var44 = -2;
                                 } else {
                                    var43 = class9.method47(var41.hue, var41.saturation, var41.lightness);
                                    var45 = class61.field761 + var41.hue & 255;
                                    var46 = class61.field762 + var41.lightness;
                                    if(var46 < 0) {
                                       var46 = 0;
                                    } else if(var46 > 255) {
                                       var46 = 255;
                                    }

                                    var44 = class9.method47(var45, var41.saturation, var46);
                                 }

                                 var45 = 0;
                                 if(var44 != -2) {
                                    var45 = class136.colorPalette[WorldMapType1.method275(var44, 96)];
                                 }

                                 if(var41.field3595 != -1) {
                                    var46 = class61.field761 + var41.field3599 & 255;
                                    int var47 = class61.field762 + var41.field3598;
                                    if(var47 < 0) {
                                       var47 = 0;
                                    } else if(var47 > 255) {
                                       var47 = 255;
                                    }

                                    var44 = class9.method47(var46, var41.field3600, var47);
                                    var45 = class136.colorPalette[WorldMapType1.method275(var44, 96)];
                                 }

                                 var59.method2583(var3, var8, var19, var68, var71, var42, var52, var54, var56, var57, class45.method627(var29, var58), class45.method627(var29, var27), class45.method627(var29, var67), class45.method627(var29, var28), WorldMapType1.method275(var43, var58), WorldMapType1.method275(var43, var27), WorldMapType1.method275(var43, var67), WorldMapType1.method275(var43, var28), var69, var45);
                              }
                           }
                        }
                     }
                  }
               }

               for(var8 = 1; var8 < 103; ++var8) {
                  for(var9 = 1; var9 < 103; ++var9) {
                     var59.method2582(var3, var9, var8, class12.method70(var3, var9, var8));
                  }
               }

               class61.underlayIds[var3] = (byte[][])null;
               class61.overlayIds[var3] = (byte[][])null;
               class90.overlayPaths[var3] = (byte[][])null;
               class275.overlayRotations[var3] = (byte[][])null;
               class267.field3669[var3] = (byte[][])null;
            }

            var59.method2609(-50, -10, -50);

            for(var3 = 0; var3 < 104; ++var3) {
               for(var49 = 0; var49 < 104; ++var49) {
                  if((class61.tileSettings[1][var3][var49] & 2) == 2) {
                     var59.method2580(var3, var49);
                  }
               }
            }

            var3 = 1;
            var49 = 2;
            var50 = 4;

            for(var20 = 0; var20 < 4; ++var20) {
               if(var20 > 0) {
                  var3 <<= 3;
                  var49 <<= 3;
                  var50 <<= 3;
               }

               for(var31 = 0; var31 <= var20; ++var31) {
                  for(var5 = 0; var5 <= 104; ++var5) {
                     for(var6 = 0; var6 <= 104; ++var6) {
                        short var65;
                        if((class61.field750[var31][var6][var5] & var3) != 0) {
                           var7 = var5;
                           var21 = var5;
                           var8 = var31;

                           for(var9 = var31; var7 > 0 && (class61.field750[var31][var6][var7 - 1] & var3) != 0; --var7) {
                              ;
                           }

                           while(var21 < 104 && (class61.field750[var31][var6][var21 + 1] & var3) != 0) {
                              ++var21;
                           }

                           label727:
                           while(var8 > 0) {
                              for(var10 = var7; var10 <= var21; ++var10) {
                                 if((class61.field750[var8 - 1][var6][var10] & var3) == 0) {
                                    break label727;
                                 }
                              }

                              --var8;
                           }

                           label716:
                           while(var9 < var20) {
                              for(var10 = var7; var10 <= var21; ++var10) {
                                 if((class61.field750[var9 + 1][var6][var10] & var3) == 0) {
                                    break label716;
                                 }
                              }

                              ++var9;
                           }

                           var10 = (var21 - var7 + 1) * (var9 + 1 - var8);
                           if(var10 >= 8) {
                              var65 = 240;
                              var12 = class61.tileHeights[var9][var6][var7] - var65;
                              var13 = class61.tileHeights[var8][var6][var7];
                              Region.method2581(var20, 1, var6 * 128, var6 * 128, var7 * 128, var21 * 128 + 128, var12, var13);

                              for(var19 = var8; var19 <= var9; ++var19) {
                                 for(var51 = var7; var51 <= var21; ++var51) {
                                    class61.field750[var19][var6][var51] &= ~var3;
                                 }
                              }
                           }
                        }

                        if((class61.field750[var31][var6][var5] & var49) != 0) {
                           var7 = var6;
                           var21 = var6;
                           var8 = var31;

                           for(var9 = var31; var7 > 0 && (class61.field750[var31][var7 - 1][var5] & var49) != 0; --var7) {
                              ;
                           }

                           while(var21 < 104 && (class61.field750[var31][var21 + 1][var5] & var49) != 0) {
                              ++var21;
                           }

                           label780:
                           while(var8 > 0) {
                              for(var10 = var7; var10 <= var21; ++var10) {
                                 if((class61.field750[var8 - 1][var10][var5] & var49) == 0) {
                                    break label780;
                                 }
                              }

                              --var8;
                           }

                           label769:
                           while(var9 < var20) {
                              for(var10 = var7; var10 <= var21; ++var10) {
                                 if((class61.field750[var9 + 1][var10][var5] & var49) == 0) {
                                    break label769;
                                 }
                              }

                              ++var9;
                           }

                           var10 = (var21 - var7 + 1) * (var9 + 1 - var8);
                           if(var10 >= 8) {
                              var65 = 240;
                              var12 = class61.tileHeights[var9][var7][var5] - var65;
                              var13 = class61.tileHeights[var8][var7][var5];
                              Region.method2581(var20, 2, var7 * 128, var21 * 128 + 128, var5 * 128, var5 * 128, var12, var13);

                              for(var19 = var8; var19 <= var9; ++var19) {
                                 for(var51 = var7; var51 <= var21; ++var51) {
                                    class61.field750[var19][var51][var5] &= ~var49;
                                 }
                              }
                           }
                        }

                        if((class61.field750[var31][var6][var5] & var50) != 0) {
                           var7 = var6;
                           var21 = var6;
                           var8 = var5;

                           for(var9 = var5; var8 > 0 && (class61.field750[var31][var6][var8 - 1] & var50) != 0; --var8) {
                              ;
                           }

                           while(var9 < 104 && (class61.field750[var31][var6][var9 + 1] & var50) != 0) {
                              ++var9;
                           }

                           label833:
                           while(var7 > 0) {
                              for(var10 = var8; var10 <= var9; ++var10) {
                                 if((class61.field750[var31][var7 - 1][var10] & var50) == 0) {
                                    break label833;
                                 }
                              }

                              --var7;
                           }

                           label822:
                           while(var21 < 104) {
                              for(var10 = var8; var10 <= var9; ++var10) {
                                 if((class61.field750[var31][var21 + 1][var10] & var50) == 0) {
                                    break label822;
                                 }
                              }

                              ++var21;
                           }

                           if((var9 - var8 + 1) * (var21 - var7 + 1) >= 4) {
                              var10 = class61.tileHeights[var31][var7][var8];
                              Region.method2581(var20, 4, var7 * 128, var21 * 128 + 128, var8 * 128, var9 * 128 + 128, var10, var10);

                              for(var11 = var7; var11 <= var21; ++var11) {
                                 for(var12 = var8; var12 <= var9; ++var12) {
                                    class61.field750[var31][var11][var12] &= ~var50;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            class73.method1065(true);
            var3 = class61.field759;
            if(var3 > Player.plane) {
               var3 = Player.plane;
            }

            if(var3 < Player.plane - 1) {
               var3 = Player.plane - 1;
            }

            if(Client.field1055) {
               class17.region.method2631(class61.field759);
            } else {
               class17.region.method2631(0);
            }

            for(var49 = 0; var49 < 104; ++var49) {
               for(var50 = 0; var50 < 104; ++var50) {
                  class47.groundItemSpawned(var49, var50);
               }
            }

            class69.method1035();

            for(PendingSpawn var66 = (PendingSpawn)Client.pendingSpawns.method3487(); var66 != null; var66 = (PendingSpawn)Client.pendingSpawns.method3512()) {
               if(var66.hitpoints == -1) {
                  var66.delay = 0;
                  class50.method727(var66);
               } else {
                  var66.unlink();
               }
            }

            ObjectComposition.field3453.reset();
            if(class220.field2817.method828()) {
               Client.secretPacketBuffer1.putOpcode(194);
               Client.secretPacketBuffer1.putInt(1057001181);
            }

            if(!Client.isDynamicRegion) {
               var49 = (class34.field501 - 6) / 8;
               var50 = (class34.field501 + 6) / 8;
               var20 = (class13.field289 - 6) / 8;
               var31 = (class13.field289 + 6) / 8;

               for(var5 = var49 - 1; var5 <= var50 + 1; ++var5) {
                  for(var6 = var20 - 1; var6 <= var31 + 1; ++var6) {
                     if(var5 < var49 || var5 > var50 || var6 < var20 || var6 > var31) {
                        class177.indexMaps.method4008("m" + var5 + "_" + var6);
                        class177.indexMaps.method4008("l" + var5 + "_" + var6);
                     }
                  }
               }
            }

            class23.setGameState(30);
            class69.method1035();
            class50.method726();
            Client.secretPacketBuffer1.putOpcode(9);
            GameEngine.field707.vmethod2872();

            for(var49 = 0; var49 < 32; ++var49) {
               GameEngine.field702[var49] = 0L;
            }

            for(var49 = 0; var49 < 32; ++var49) {
               GameEngine.field703[var49] = 0L;
            }

            GameEngine.field697 = 0;
         }
      }

   }
}
