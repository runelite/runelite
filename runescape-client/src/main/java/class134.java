import java.awt.Component;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
public abstract class class134 {
   @ObfuscatedName("mi")
   static byte field2116;
   @ObfuscatedName("c")
   static int[] field2117;
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = -815458093
   )
   static int field2120;
   @ObfuscatedName("l")
   static int[] field2122;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "9"
   )
   public abstract void vmethod3132(Component var1);

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass125;I)V",
      garbageValue = "30801133"
   )
   public static void method2880(class125 var0) {
      ClassInfo var1 = (ClassInfo)class214.field3183.method3893();
      if(var1 != null) {
         int var2 = var0.offset;
         var0.method2559(var1.field3176);

         for(int var3 = 0; var3 < var1.field3178; ++var3) {
            if(var1.field3173[var3] != 0) {
               var0.method2556(var1.field3173[var3]);
            } else {
               try {
                  int var4 = var1.field3172[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = var5.getInt((Object)null);
                     var0.method2556(0);
                     var0.method2559(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     var5.setInt((Object)null, var1.field3170[var3]);
                     var0.method2556(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.method2556(0);
                     var0.method2559(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.methods[var3];
                        var6 = var25.getModifiers();
                        var0.method2556(0);
                        var0.method2559(var6);
                     }
                  } else {
                     var25 = var1.methods[var3];
                     byte[][] var10 = var1.args[var3];
                     Object[] var7 = new Object[var10.length];

                     for(int var8 = 0; var8 < var10.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var11 = var25.invoke((Object)null, var7);
                     if(var11 == null) {
                        var0.method2556(0);
                     } else if(var11 instanceof Number) {
                        var0.method2556(1);
                        var0.method2667(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.method2556(2);
                        var0.method2562((String)var11);
                     } else {
                        var0.method2556(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.method2556(-10);
               } catch (InvalidClassException var14) {
                  var0.method2556(-11);
               } catch (StreamCorruptedException var15) {
                  var0.method2556(-12);
               } catch (OptionalDataException var16) {
                  var0.method2556(-13);
               } catch (IllegalAccessException var17) {
                  var0.method2556(-14);
               } catch (IllegalArgumentException var18) {
                  var0.method2556(-15);
               } catch (InvocationTargetException var19) {
                  var0.method2556(-16);
               } catch (SecurityException var20) {
                  var0.method2556(-17);
               } catch (IOException var21) {
                  var0.method2556(-18);
               } catch (NullPointerException var22) {
                  var0.method2556(-19);
               } catch (Exception var23) {
                  var0.method2556(-20);
               } catch (Throwable var24) {
                  var0.method2556(-21);
               }
            }
         }

         var0.method2690(var2);
         var1.unlink();
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-94"
   )
   public abstract int vmethod3133();

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIII)V",
      garbageValue = "-1418962757"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class82.method1834(var2, var3, var4, var5);
      class94.method2158();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var1 == var10.parentId || var1 == -1412584499 && var10 == Client.field453)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field483] = var6 + var10.relativeX;
               Client.widgetPositionY[Client.field483] = var10.relativeY + var7;
               Client.widgetBoundsWidth[Client.field483] = var10.width;
               Client.widgetBoundsHeight[Client.field483] = var10.height;
               var11 = ++Client.field483 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.field2930 = Client.gameCycle;
            if(!var10.field2815 || !class5.method56(var10)) {
               int var12;
               if(var10.contentType > 0) {
                  var12 = var10.contentType;
                  if(var12 == 324) {
                     if(Client.field554 == -1) {
                        Client.field554 = var10.textureId;
                        Client.field550 = var10.field2834;
                     }

                     if(Client.field553.isFemale) {
                        var10.textureId = Client.field554;
                     } else {
                        var10.textureId = Client.field550;
                     }
                  } else if(var12 == 325) {
                     if(Client.field554 == -1) {
                        Client.field554 = var10.textureId;
                        Client.field550 = var10.field2834;
                     }

                     if(Client.field553.isFemale) {
                        var10.textureId = Client.field550;
                     } else {
                        var10.textureId = Client.field554;
                     }
                  } else if(var12 == 327) {
                     var10.rotationX = 150;
                     var10.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
                     var10.modelType = 5;
                     var10.modelId = 0;
                  } else if(var12 == 328) {
                     var10.rotationX = 150;
                     var10.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
                     var10.modelType = 5;
                     var10.modelId = 1;
                  }
               }

               var12 = var6 + var10.relativeX;
               int var13 = var7 + var10.relativeY;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(var10 == Client.field453) {
                  if(var1 != -1412584499 && !var10.field2876) {
                     ChatMessages.field272 = var0;
                     field2120 = var6;
                     class162.field2649 = var7;
                     continue;
                  }

                  if(Client.field375 && Client.field458) {
                     var15 = class143.field2200;
                     var16 = class143.field2204;
                     var15 -= Client.field504;
                     var16 -= Client.field456;
                     if(var15 < Client.field545) {
                        var15 = Client.field545;
                     }

                     if(var15 + var10.width > Client.field388.width + Client.field545) {
                        var15 = Client.field388.width + Client.field545 - var10.width;
                     }

                     if(var16 < Client.field526) {
                        var16 = Client.field526;
                     }

                     if(var10.height + var16 > Client.field388.height + Client.field526) {
                        var16 = Client.field388.height + Client.field526 - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2876) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var20;
               int var21;
               int var22;
               int var47;
               if(var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.type == 9) {
                  var47 = var12;
                  var20 = var13;
                  var21 = var10.width + var12;
                  var22 = var13 + var10.height;
                  if(var21 < var12) {
                     var47 = var21;
                     var21 = var12;
                  }

                  if(var22 < var13) {
                     var20 = var22;
                     var22 = var13;
                  }

                  ++var21;
                  ++var22;
                  var15 = var47 > var2?var47:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var21 < var4?var21:var4;
                  var18 = var22 < var5?var22:var5;
               } else {
                  var47 = var12 + var10.width;
                  var20 = var10.height + var13;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var47 < var4?var47:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.field2815 || var15 < var17 && var16 < var18) {
                  int var23;
                  int var26;
                  int var27;
                  int var28;
                  int var29;
                  int var30;
                  int var31;
                  int var32;
                  int var33;
                  int var34;
                  int var35;
                  int var48;
                  int var50;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.field294) {
                           var13 += 15;
                           MessageNode.field800.method4053("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var61 = Runtime.getRuntime();
                           var20 = (int)((var61.totalMemory() - var61.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && Client.field282) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.field282) {
                              var21 = 16711680;
                           }

                           MessageNode.field800.method4053("Mem:" + var20 + "k", var10.width + var12, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field429 = var12;
                        Client.field437 = var13;
                        var21 = var10.width;
                        var22 = var10.height;
                        ++Client.field386;
                        WallObject.method2151(class35.field788);
                        boolean var69 = false;
                        if(Client.field411 >= 0) {
                           var48 = class34.field777;
                           int[] var68 = class34.field773;

                           for(var26 = 0; var26 < var48; ++var26) {
                              if(Client.field411 == var68[var26]) {
                                 var69 = true;
                                 break;
                              }
                           }
                        }

                        if(var69) {
                           WallObject.method2151(class35.field784);
                        }

                        class43.method876(true);
                        WallObject.method2151(var69?class35.field785:class35.field786);
                        class43.method876(false);
                        class31.method677();
                        class24.method600();
                        WidgetNode.method46(var12, var13, var21, var22, true);
                        var47 = Client.field474;
                        var20 = Client.field543;
                        var21 = Client.camera2;
                        var22 = Client.camera3;
                        class82.method1834(var47, var20, var21 + var47, var20 + var22);
                        class94.method2158();
                        if(!Client.field528) {
                           var48 = Client.field365;
                           if(Client.field348 / 256 > var48) {
                              var48 = Client.field348 / 256;
                           }

                           if(Client.field351[4] && Client.field493[4] + 128 > var48) {
                              var48 = 128 + Client.field493[4];
                           }

                           var50 = Client.mapAngle + Client.field349 & 2047;
                           class8.method102(class168.field2706, class109.method2439(class165.localPlayer.x, class165.localPlayer.y, class145.plane) - Client.field371, class75.field1406, var48, var50, 600 + 3 * var48);
                        }

                        if(!Client.field528) {
                           if(class130.field2102.field138) {
                              var50 = class145.plane;
                           } else {
                              label1916: {
                                 var26 = 3;
                                 if(class116.cameraPitch < 310) {
                                    var27 = class79.cameraX >> 7;
                                    var28 = class170.cameraY >> 7;
                                    var29 = class165.localPlayer.x >> 7;
                                    var30 = class165.localPlayer.y >> 7;
                                    if(var27 < 0 || var28 < 0 || var27 >= 104 || var28 >= 104) {
                                       var50 = class145.plane;
                                       break label1916;
                                    }

                                    if((class5.tileSettings[class145.plane][var27][var28] & 4) != 0) {
                                       var26 = class145.plane;
                                    }

                                    if(var29 > var27) {
                                       var31 = var29 - var27;
                                    } else {
                                       var31 = var27 - var29;
                                    }

                                    if(var30 > var28) {
                                       var32 = var30 - var28;
                                    } else {
                                       var32 = var28 - var30;
                                    }

                                    if(var31 > var32) {
                                       var33 = var32 * 65536 / var31;
                                       var34 = '耀';

                                       while(var27 != var29) {
                                          if(var27 < var29) {
                                             ++var27;
                                          } else if(var27 > var29) {
                                             --var27;
                                          }

                                          if((class5.tileSettings[class145.plane][var27][var28] & 4) != 0) {
                                             var26 = class145.plane;
                                          }

                                          var34 += var33;
                                          if(var34 >= 65536) {
                                             var34 -= 65536;
                                             if(var28 < var30) {
                                                ++var28;
                                             } else if(var28 > var30) {
                                                --var28;
                                             }

                                             if((class5.tileSettings[class145.plane][var27][var28] & 4) != 0) {
                                                var26 = class145.plane;
                                             }
                                          }
                                       }
                                    } else {
                                       var33 = 65536 * var31 / var32;
                                       var34 = '耀';

                                       while(var28 != var30) {
                                          if(var28 < var30) {
                                             ++var28;
                                          } else if(var28 > var30) {
                                             --var28;
                                          }

                                          if((class5.tileSettings[class145.plane][var27][var28] & 4) != 0) {
                                             var26 = class145.plane;
                                          }

                                          var34 += var33;
                                          if(var34 >= 65536) {
                                             var34 -= 65536;
                                             if(var27 < var29) {
                                                ++var27;
                                             } else if(var27 > var29) {
                                                --var27;
                                             }

                                             if((class5.tileSettings[class145.plane][var27][var28] & 4) != 0) {
                                                var26 = class145.plane;
                                             }
                                          }
                                       }
                                    }
                                 }

                                 if(class165.localPlayer.x >= 0 && class165.localPlayer.y >= 0 && class165.localPlayer.x < 13312 && class165.localPlayer.y < 13312) {
                                    if((class5.tileSettings[class145.plane][class165.localPlayer.x >> 7][class165.localPlayer.y >> 7] & 4) != 0) {
                                       var26 = class145.plane;
                                    }

                                    var50 = var26;
                                 } else {
                                    var50 = class145.plane;
                                 }
                              }
                           }

                           var48 = var50;
                        } else {
                           if(class130.field2102.field138) {
                              var50 = class145.plane;
                           } else {
                              var26 = class109.method2439(class79.cameraX, class170.cameraY, class145.plane);
                              if(var26 - class10.cameraZ < 800 && (class5.tileSettings[class145.plane][class79.cameraX >> 7][class170.cameraY >> 7] & 4) != 0) {
                                 var50 = class145.plane;
                              } else {
                                 var50 = 3;
                              }
                           }

                           var48 = var50;
                        }

                        var50 = class79.cameraX;
                        var26 = class10.cameraZ;
                        var27 = class170.cameraY;
                        var28 = class116.cameraPitch;
                        var29 = SecondaryBufferProvider.cameraYaw;

                        for(var30 = 0; var30 < 5; ++var30) {
                           if(Client.field351[var30]) {
                              var31 = (int)(Math.random() * (double)(2 * Client.field471[var30] + 1) - (double)Client.field471[var30] + Math.sin((double)Client.field533[var30] * ((double)Client.field362[var30] / 100.0D)) * (double)Client.field493[var30]);
                              if(var30 == 0) {
                                 class79.cameraX += var31;
                              }

                              if(var30 == 1) {
                                 class10.cameraZ += var31;
                              }

                              if(var30 == 2) {
                                 class170.cameraY += var31;
                              }

                              if(var30 == 3) {
                                 SecondaryBufferProvider.cameraYaw = SecondaryBufferProvider.cameraYaw + var31 & 2047;
                              }

                              if(var30 == 4) {
                                 class116.cameraPitch += var31;
                                 if(class116.cameraPitch < 128) {
                                    class116.cameraPitch = 128;
                                 }

                                 if(class116.cameraPitch > 383) {
                                    class116.cameraPitch = 383;
                                 }
                              }
                           }
                        }

                        var30 = class143.field2200;
                        var31 = class143.field2204;
                        if(class143.field2206 != 0) {
                           var30 = class143.field2207;
                           var31 = class143.field2196;
                        }

                        if(var30 >= var47 && var30 < var21 + var47 && var31 >= var20 && var31 < var20 + var22) {
                           Model.field1912 = true;
                           Model.field1915 = 0;
                           Model.field1867 = var30 - var47;
                           Model.field1904 = var31 - var20;
                        } else {
                           Model.field1912 = false;
                           Model.field1915 = 0;
                        }

                        class110.method2445();
                        class82.method1885(var47, var20, var21, var22, 0);
                        class110.method2445();
                        var32 = class94.field1636;
                        class94.field1636 = Client.scale;
                        Frames.region.method1998(class79.cameraX, class10.cameraZ, class170.cameraY, class116.cameraPitch, SecondaryBufferProvider.cameraYaw, var48);
                        class94.field1636 = var32;
                        class110.method2445();
                        Frames.region.method1975();
                        Client.field530 = 0;
                        boolean var73 = false;
                        var34 = -1;
                        var35 = class34.field777;
                        int[] var36 = class34.field773;

                        int var37;
                        for(var37 = 0; var37 < var35 + Client.field319; ++var37) {
                           Object var38;
                           if(var37 < var35) {
                              var38 = Client.cachedPlayers[var36[var37]];
                              if(var36[var37] == Client.field411) {
                                 var73 = true;
                                 var34 = var37;
                                 continue;
                              }
                           } else {
                              var38 = Client.cachedNPCs[Client.field501[var37 - var35]];
                           }

                           ChatMessages.method224((Actor)var38, var37, var47, var20, var21, var22);
                        }

                        if(var73) {
                           ChatMessages.method224(Client.cachedPlayers[Client.field411], var34, var47, var20, var21, var22);
                        }

                        for(var37 = 0; var37 < Client.field530; ++var37) {
                           int var54 = Client.field377[var37];
                           int var39 = Client.field354[var37];
                           int var40 = Client.field380[var37];
                           int var41 = Client.field379[var37];
                           boolean var42 = true;

                           while(var42) {
                              var42 = false;

                              for(int var43 = 0; var43 < var37; ++var43) {
                                 if(var39 + 2 > Client.field354[var43] - Client.field379[var43] && var39 - var41 < Client.field354[var43] + 2 && var54 - var40 < Client.field377[var43] + Client.field380[var43] && var54 + var40 > Client.field377[var43] - Client.field380[var43] && Client.field354[var43] - Client.field379[var43] < var39) {
                                    var39 = Client.field354[var43] - Client.field379[var43];
                                    var42 = true;
                                 }
                              }
                           }

                           Client.field387 = Client.field377[var37];
                           Client.field333 = Client.field354[var37] = var39;
                           String var55 = Client.field384[var37];
                           if(Client.field442 == 0) {
                              int var44 = 16776960;
                              if(Client.field381[var37] < 6) {
                                 var44 = Client.field346[Client.field381[var37]];
                              }

                              if(Client.field381[var37] == 6) {
                                 var44 = Client.field386 % 20 < 10?16711680:16776960;
                              }

                              if(Client.field381[var37] == 7) {
                                 var44 = Client.field386 % 20 < 10?255:'\uffff';
                              }

                              if(Client.field381[var37] == 8) {
                                 var44 = Client.field386 % 20 < 10?'뀀':8454016;
                              }

                              int var45;
                              if(Client.field381[var37] == 9) {
                                 var45 = 150 - Client.field383[var37];
                                 if(var45 < 50) {
                                    var44 = var45 * 1280 + 16711680;
                                 } else if(var45 < 100) {
                                    var44 = 16776960 - (var45 - 50) * 327680;
                                 } else if(var45 < 150) {
                                    var44 = (var45 - 100) * 5 + '\uff00';
                                 }
                              }

                              if(Client.field381[var37] == 10) {
                                 var45 = 150 - Client.field383[var37];
                                 if(var45 < 50) {
                                    var44 = 5 * var45 + 16711680;
                                 } else if(var45 < 100) {
                                    var44 = 16711935 - 327680 * (var45 - 50);
                                 } else if(var45 < 150) {
                                    var44 = 255 + 327680 * (var45 - 100) - (var45 - 100) * 5;
                                 }
                              }

                              if(Client.field381[var37] == 11) {
                                 var45 = 150 - Client.field383[var37];
                                 if(var45 < 50) {
                                    var44 = 16777215 - 327685 * var45;
                                 } else if(var45 < 100) {
                                    var44 = '\uff00' + 327685 * (var45 - 50);
                                 } else if(var45 < 150) {
                                    var44 = 16777215 - (var45 - 100) * 327680;
                                 }
                              }

                              if(Client.field345[var37] == 0) {
                                 PlayerComposition.field2977.method4059(var55, var47 + Client.field387, Client.field333 + var20, var44, 0);
                              }

                              if(Client.field345[var37] == 1) {
                                 PlayerComposition.field2977.method4056(var55, var47 + Client.field387, var20 + Client.field333, var44, 0, Client.field386);
                              }

                              if(Client.field345[var37] == 2) {
                                 PlayerComposition.field2977.method4057(var55, var47 + Client.field387, var20 + Client.field333, var44, 0, Client.field386);
                              }

                              if(Client.field345[var37] == 3) {
                                 PlayerComposition.field2977.method4058(var55, var47 + Client.field387, Client.field333 + var20, var44, 0, Client.field386, 150 - Client.field383[var37]);
                              }

                              if(Client.field345[var37] == 4) {
                                 var45 = (150 - Client.field383[var37]) * (PlayerComposition.field2977.method4047(var55) + 100) / 150;
                                 class82.method1835(var47 + Client.field387 - 50, var20, 50 + var47 + Client.field387, var20 + var22);
                                 PlayerComposition.field2977.method4118(var55, 50 + Client.field387 + var47 - var45, var20 + Client.field333, var44, 0);
                                 class82.method1834(var47, var20, var47 + var21, var22 + var20);
                              }

                              if(Client.field345[var37] == 5) {
                                 var45 = 150 - Client.field383[var37];
                                 int var46 = 0;
                                 if(var45 < 25) {
                                    var46 = var45 - 25;
                                 } else if(var45 > 125) {
                                    var46 = var45 - 125;
                                 }

                                 class82.method1835(var47, Client.field333 + var20 - PlayerComposition.field2977.field3240 - 1, var21 + var47, 5 + Client.field333 + var20);
                                 PlayerComposition.field2977.method4059(var55, var47 + Client.field387, Client.field333 + var20 + var46, var44, 0);
                                 class82.method1834(var47, var20, var47 + var21, var22 + var20);
                              }
                           } else {
                              PlayerComposition.field2977.method4059(var55, var47 + Client.field387, Client.field333 + var20, 16776960, 0);
                           }
                        }

                        class10.method124(var47, var20);
                        ((TextureProvider)class94.field1647).method2258(Client.field357);
                        class178.method3474(var47, var20, var21, var22);
                        class79.cameraX = var50;
                        class10.cameraZ = var26;
                        class170.cameraY = var27;
                        class116.cameraPitch = var28;
                        SecondaryBufferProvider.cameraYaw = var29;
                        if(Client.field287) {
                           byte var74 = 0;
                           var34 = var74 + class174.field2775 + class174.field2774;
                           if(var34 == 0) {
                              Client.field287 = false;
                           }
                        }

                        if(Client.field287) {
                           class82.method1885(var47, var20, var21, var22, 0);
                           class20.method570("Loading - please wait.", false);
                        }

                        Client.field485[var10.boundsIndex] = true;
                        class82.method1834(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        class110.method2445();
                        class178 var60 = var10.method3425(false);
                        if(null != var60) {
                           class82.method1834(var12, var13, var12 + var60.field2947, var13 + var60.field2942);
                           if(Client.field516 != 2 && Client.field516 != 5) {
                              var20 = Client.mapAngle + Client.mapScale & 2047;
                              var21 = class165.localPlayer.x / 32 + 48;
                              var22 = 464 - class165.localPlayer.y / 32;
                              DecorativeObject.field1677.method1825(var12, var13, var60.field2947, var60.field2942, var21, var22, var20, 256 + Client.mapScaleDelta, var60.field2944, var60.field2941);

                              for(var23 = 0; var23 < Client.field510; ++var23) {
                                 var48 = 2 + 4 * Client.field511[var23] - class165.localPlayer.x / 32;
                                 var50 = Client.field368[var23] * 4 + 2 - class165.localPlayer.y / 32;
                                 class31.method687(var12, var13, var48, var50, Client.field513[var23], var60);
                              }

                              var23 = 0;

                              while(true) {
                                 if(var23 >= 104) {
                                    for(var23 = 0; var23 < Client.field319; ++var23) {
                                       NPC var64 = Client.cachedNPCs[Client.field501[var23]];
                                       if(var64 != null && var64.vmethod774()) {
                                          NPCComposition var62 = var64.composition;
                                          if(var62 != null && var62.field923 != null) {
                                             var62 = var62.method801();
                                          }

                                          if(var62 != null && var62.isMinimapVisible && var62.field926) {
                                             var26 = var64.x / 32 - class165.localPlayer.x / 32;
                                             var27 = var64.y / 32 - class165.localPlayer.y / 32;
                                             class31.method687(var12, var13, var26, var27, class9.field152[1], var60);
                                          }
                                       }
                                    }

                                    var23 = class34.field777;
                                    int[] var65 = class34.field773;

                                    for(var50 = 0; var50 < var23; ++var50) {
                                       Player var52 = Client.cachedPlayers[var65[var50]];
                                       if(null != var52 && var52.vmethod774() && !var52.field49 && class165.localPlayer != var52) {
                                          var27 = var52.x / 32 - class165.localPlayer.x / 32;
                                          var28 = var52.y / 32 - class165.localPlayer.y / 32;
                                          boolean var72 = false;
                                          if(class0.method1(var52.name, true)) {
                                             var72 = true;
                                          }

                                          boolean var70 = false;

                                          for(var31 = 0; var31 < class16.field235; ++var31) {
                                             if(var52.name.equals(class114.clanMembers[var31].username)) {
                                                var70 = true;
                                                break;
                                             }
                                          }

                                          boolean var71 = false;
                                          if(class165.localPlayer.team != 0 && var52.team != 0 && class165.localPlayer.team == var52.team) {
                                             var71 = true;
                                          }

                                          if(var72) {
                                             class31.method687(var12, var13, var27, var28, class9.field152[3], var60);
                                          } else if(var71) {
                                             class31.method687(var12, var13, var27, var28, class9.field152[4], var60);
                                          } else if(var70) {
                                             class31.method687(var12, var13, var27, var28, class9.field152[5], var60);
                                          } else {
                                             class31.method687(var12, var13, var27, var28, class9.field152[2], var60);
                                          }
                                       }
                                    }

                                    if(Client.field278 != 0 && Client.gameCycle % 20 < 10) {
                                       if(Client.field278 == 1 && Client.field427 >= 0 && Client.field427 < Client.cachedNPCs.length) {
                                          NPC var66 = Client.cachedNPCs[Client.field427];
                                          if(null != var66) {
                                             var26 = var66.x / 32 - class165.localPlayer.x / 32;
                                             var27 = var66.y / 32 - class165.localPlayer.y / 32;
                                             class23.method592(var12, var13, var26, var27, class31.field716[1], var60);
                                          }
                                       }

                                       if(Client.field278 == 2) {
                                          var50 = 2 + (Client.field525 * 4 - class47.baseX * 4) - class165.localPlayer.x / 32;
                                          var26 = Client.field300 * 4 - class21.baseY * 4 + 2 - class165.localPlayer.y / 32;
                                          class23.method592(var12, var13, var50, var26, class31.field716[1], var60);
                                       }

                                       if(Client.field278 == 10 && Client.field467 >= 0 && Client.field467 < Client.cachedPlayers.length) {
                                          Player var67 = Client.cachedPlayers[Client.field467];
                                          if(null != var67) {
                                             var26 = var67.x / 32 - class165.localPlayer.x / 32;
                                             var27 = var67.y / 32 - class165.localPlayer.y / 32;
                                             class23.method592(var12, var13, var26, var27, class31.field716[1], var60);
                                          }
                                       }
                                    }

                                    if(Client.flagX != 0) {
                                       var50 = Client.flagX * 4 + 2 - class165.localPlayer.x / 32;
                                       var26 = Client.flagY * 4 + 2 - class165.localPlayer.y / 32;
                                       class31.method687(var12, var13, var50, var26, class31.field716[0], var60);
                                    }

                                    if(!class165.localPlayer.field49) {
                                       class82.method1885(var12 + var60.field2947 / 2 - 1, var60.field2942 / 2 + var13 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var48 = 0; var48 < 104; ++var48) {
                                    Deque var25 = Client.groundItemDeque[class145.plane][var23][var48];
                                    if(var25 != null) {
                                       var26 = 2 + 4 * var23 - class165.localPlayer.x / 32;
                                       var27 = 2 + var48 * 4 - class165.localPlayer.y / 32;
                                       class31.method687(var12, var13, var26, var27, class9.field152[0], var60);
                                    }
                                 }

                                 ++var23;
                              }
                           } else {
                              class82.method1852(var12, var13, 0, var60.field2944, var60.field2941);
                           }

                           Client.field486[var11] = true;
                        }

                        class82.method1834(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class136.method2897(var10, var12, var13, var11);
                        class82.method1834(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.field2815 && class5.method56(var10) && Player.field31 != var10) {
                        continue;
                     }

                     if(!var10.field2815) {
                        if(var10.scrollY > var10.scrollHeight - var10.height) {
                           var10.scrollY = var10.scrollHeight - var10.height;
                        }

                        if(var10.scrollY < 0) {
                           var10.scrollY = 0;
                        }
                     }

                     gameDraw(var0, var10.id, var15, var16, var17, var18, var12 - var10.itemId, var13 - var10.scrollY, var11);
                     if(null != var10.children) {
                        gameDraw(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.itemId, var13 - var10.scrollY, var11);
                     }

                     WidgetNode var19 = (WidgetNode)Client.componentTable.method3828((long)var10.id);
                     if(var19 != null) {
                        class53.method1098(var19.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     class82.method1834(var2, var3, var4, var5);
                     class94.method2158();
                  }

                  if(Client.isResized || Client.field487[var11] || Client.field492 > 1) {
                     if(var10.type == 0 && !var10.field2815 && var10.scrollHeight > var10.height) {
                        var47 = var10.width + var12;
                        var20 = var10.scrollY;
                        var21 = var10.height;
                        var22 = var10.scrollHeight;
                        DecorativeObject.field1666[0].method1911(var47, var13);
                        DecorativeObject.field1666[1].method1911(var47, var21 + var13 - 16);
                        class82.method1885(var47, 16 + var13, 16, var21 - 32, Client.field374);
                        var23 = var21 * (var21 - 32) / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var48 = (var21 - 32 - var23) * var20 / (var22 - var21);
                        class82.method1885(var47, 16 + var13 + var48, 16, var23, Client.field360);
                        class82.method1902(var47, var13 + 16 + var48, var23, Client.field558);
                        class82.method1902(1 + var47, var48 + var13 + 16, var23, Client.field558);
                        class82.method1895(var47, var13 + 16 + var48, 16, Client.field558);
                        class82.method1895(var47, 17 + var13 + var48, 16, Client.field558);
                        class82.method1902(15 + var47, var48 + var13 + 16, var23, Client.field407);
                        class82.method1902(var47 + 14, var48 + 17 + var13, var23 - 1, Client.field407);
                        class82.method1895(var47, var23 + var13 + 15 + var48, 16, Client.field407);
                        class82.method1895(1 + var47, var13 + 14 + var48 + var23, 15, Client.field407);
                     }

                     if(var10.type != 1) {
                        if(var10.type == 2) {
                           var47 = 0;

                           for(var20 = 0; var20 < var10.field2854; ++var20) {
                              for(var21 = 0; var21 < var10.field2798; ++var21) {
                                 var22 = var12 + (32 + var10.field2864) * var21;
                                 var23 = var13 + var20 * (var10.field2841 + 32);
                                 if(var47 < 20) {
                                    var22 += var10.field2866[var47];
                                    var23 += var10.field2867[var47];
                                 }

                                 if(var10.itemIds[var47] <= 0) {
                                    if(null != var10.field2839 && var47 < 20) {
                                       SpritePixels var63 = var10.method3423(var47);
                                       if(var63 != null) {
                                          var63.method1760(var22, var23);
                                       } else if(Widget.field2796) {
                                          class166.method3253(var10);
                                       }
                                    }
                                 } else {
                                    boolean var78 = false;
                                    boolean var79 = false;
                                    var26 = var10.itemIds[var47] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && 32 + var23 > var3 && var23 < var5 || var10 == class12.field182 && Client.field395 == var47) {
                                       SpritePixels var57;
                                       if(Client.field497 == 1 && class12.field184 == var47 && class20.field569 == var10.id) {
                                          var57 = class40.createSprite(var26, var10.itemQuantities[var47], 2, 0, 2, false);
                                       } else {
                                          var57 = class40.createSprite(var26, var10.itemQuantities[var47], 1, 3153952, 2, false);
                                       }

                                       if(null != var57) {
                                          if(var10 == class12.field182 && var47 == Client.field395) {
                                             var48 = class143.field2200 - Client.field396;
                                             var50 = class143.field2204 - Client.field295;
                                             if(var48 < 5 && var48 > -5) {
                                                var48 = 0;
                                             }

                                             if(var50 < 5 && var50 > -5) {
                                                var50 = 0;
                                             }

                                             if(Client.field428 < 5) {
                                                var48 = 0;
                                                var50 = 0;
                                             }

                                             var57.method1755(var48 + var22, var23 + var50, 128);
                                             if(var1 != -1) {
                                                Widget var56 = var0[var1 & '\uffff'];
                                                if(var50 + var23 < class82.field1470 && var56.scrollY > 0) {
                                                   var29 = Client.field357 * (class82.field1470 - var23 - var50) / 3;
                                                   if(var29 > Client.field357 * 10) {
                                                      var29 = Client.field357 * 10;
                                                   }

                                                   if(var29 > var56.scrollY) {
                                                      var29 = var56.scrollY;
                                                   }

                                                   var56.scrollY -= var29;
                                                   Client.field295 += var29;
                                                   class166.method3253(var56);
                                                }

                                                if(32 + var23 + var50 > class82.field1471 && var56.scrollY < var56.scrollHeight - var56.height) {
                                                   var29 = Client.field357 * (32 + var50 + var23 - class82.field1471) / 3;
                                                   if(var29 > Client.field357 * 10) {
                                                      var29 = Client.field357 * 10;
                                                   }

                                                   if(var29 > var56.scrollHeight - var56.height - var56.scrollY) {
                                                      var29 = var56.scrollHeight - var56.height - var56.scrollY;
                                                   }

                                                   var56.scrollY += var29;
                                                   Client.field295 -= var29;
                                                   class166.method3253(var56);
                                                }
                                             }
                                          } else if(class53.field1157 == var10 && var47 == Client.field394) {
                                             var57.method1755(var22, var23, 128);
                                          } else {
                                             var57.method1760(var22, var23);
                                          }
                                       } else {
                                          class166.method3253(var10);
                                       }
                                    }
                                 }

                                 ++var47;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(Player.method30(var10)) {
                              var47 = var10.field2824;
                              if(Player.field31 == var10 && var10.field2829 != 0) {
                                 var47 = var10.field2829;
                              }
                           } else {
                              var47 = var10.textColor;
                              if(Player.field31 == var10 && var10.field2825 != 0) {
                                 var47 = var10.field2825;
                              }
                           }

                           if(var10.field2827) {
                              switch(var10.field2828.field1488) {
                              case 1:
                                 class82.method1840(var12, var13, var10.width, var10.height, var10.textColor, var10.field2824, 256 - (var10.opacity & 255), 256 - (var10.field2830 & 255));
                                 break;
                              case 2:
                                 class82.method1841(var12, var13, var10.width, var10.height, var10.textColor, var10.field2824, 256 - (var10.opacity & 255), 256 - (var10.field2830 & 255));
                                 break;
                              case 3:
                                 class82.method1842(var12, var13, var10.width, var10.height, var10.textColor, var10.field2824, 256 - (var10.opacity & 255), 256 - (var10.field2830 & 255));
                                 break;
                              case 4:
                                 class82.method1843(var12, var13, var10.width, var10.height, var10.textColor, var10.field2824, 256 - (var10.opacity & 255), 256 - (var10.field2830 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    class82.method1885(var12, var13, var10.width, var10.height, var47);
                                 } else {
                                    class82.method1864(var12, var13, var10.width, var10.height, var47, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              class82.method1845(var12, var13, var10.width, var10.height, var47);
                           } else {
                              class82.method1846(var12, var13, var10.width, var10.height, var47, 256 - (var14 & 255));
                           }
                        } else {
                           class227 var58;
                           if(var10.type == 4) {
                              var58 = var10.method3422();
                              if(var58 == null) {
                                 if(Widget.field2796) {
                                    class166.method3253(var10);
                                 }
                              } else {
                                 String var77 = var10.text;
                                 if(Player.method30(var10)) {
                                    var20 = var10.field2824;
                                    if(var10 == Player.field31 && var10.field2829 != 0) {
                                       var20 = var10.field2829;
                                    }

                                    if(var10.field2836.length() > 0) {
                                       var77 = var10.field2836;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == Player.field31 && var10.field2825 != 0) {
                                       var20 = var10.field2825;
                                    }
                                 }

                                 if(var10.field2815 && var10.item != -1) {
                                    ItemComposition var81 = class22.getItemDefinition(var10.item);
                                    var77 = var81.name;
                                    if(null == var77) {
                                       var77 = "null";
                                    }

                                    if((var81.isStackable == 1 || var10.stackSize != 1) && var10.stackSize != -1) {
                                       var77 = class144.method3013(16748608) + var77 + "</col>" + " " + 'x' + class144.method3015(var10.stackSize);
                                    }
                                 }

                                 if(var10 == Client.field361) {
                                    Object var10000 = null;
                                    var77 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.field2815) {
                                    var77 = class10.method125(var77, var10);
                                 }

                                 var58.method4055(var77, var12, var13, var10.width, var10.height, var20, var10.field2863?0:-1, var10.field2861, var10.field2862, var10.field2860);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var59;
                              if(!var10.field2815) {
                                 var59 = var10.method3466(Player.method30(var10));
                                 if(null != var59) {
                                    var59.method1760(var12, var13);
                                 } else if(Widget.field2796) {
                                    class166.method3253(var10);
                                 }
                              } else {
                                 if(var10.item != -1) {
                                    var59 = class40.createSprite(var10.item, var10.stackSize, var10.borderThickness, var10.sprite2, var10.field2810, false);
                                 } else {
                                    var59 = var10.method3466(false);
                                 }

                                 if(null == var59) {
                                    if(Widget.field2796) {
                                       class166.method3253(var10);
                                    }
                                 } else {
                                    var20 = var59.field1460;
                                    var21 = var59.field1464;
                                    if(!var10.field2831) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.field2835 != 0) {
                                          var59.method1762(var10.width / 2 + var12, var10.height / 2 + var13, var10.field2835, var22);
                                       } else if(var14 != 0) {
                                          var59.method1757(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var10.width == var20 && var21 == var10.height) {
                                          var59.method1760(var12, var13);
                                       } else {
                                          var59.method1786(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       class82.method1835(var12, var13, var10.width + var12, var10.height + var13);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var10.height + (var21 - 1)) / var21;

                                       for(var48 = 0; var48 < var22; ++var48) {
                                          for(var50 = 0; var50 < var23; ++var50) {
                                             if(var10.field2835 != 0) {
                                                var59.method1762(var20 * var48 + var12 + var20 / 2, var13 + var21 * var50 + var21 / 2, var10.field2835, 4096);
                                             } else if(var14 != 0) {
                                                var59.method1755(var12 + var20 * var48, var50 * var21 + var13, 256 - (var14 & 255));
                                             } else {
                                                var59.method1760(var20 * var48 + var12, var13 + var21 * var50);
                                             }
                                          }
                                       }

                                       class82.method1834(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var53;
                              if(var10.type == 6) {
                                 boolean var76 = Player.method30(var10);
                                 if(var76) {
                                    var20 = var10.field2846;
                                 } else {
                                    var20 = var10.field2845;
                                 }

                                 Model var75 = null;
                                 var22 = 0;
                                 if(var10.item != -1) {
                                    var53 = class22.getItemDefinition(var10.item);
                                    if(var53 != null) {
                                       var53 = var53.method1121(var10.stackSize);
                                       var75 = var53.getModel(1);
                                       if(var75 != null) {
                                          var75.method2366();
                                          var22 = var75.modelHeight / 2;
                                       } else {
                                          class166.method3253(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var75 = Client.field553.method3514((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var75 = class165.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var75 = var10.method3451((Sequence)null, -1, var76, class165.localPlayer.composition);
                                    if(var75 == null && Widget.field2796) {
                                       class166.method3253(var10);
                                    }
                                 } else {
                                    Sequence var82 = NPC.getAnimation(var20);
                                    var75 = var10.method3451(var82, var10.field2920, var76, class165.localPlayer.composition);
                                    if(var75 == null && Widget.field2796) {
                                       class166.method3253(var10);
                                    }
                                 }

                                 class94.method2165(var12 + var10.width / 2, var10.height / 2 + var13);
                                 var23 = class94.field1650[var10.rotationX] * var10.field2852 >> 16;
                                 var48 = class94.field1651[var10.rotationX] * var10.field2852 >> 16;
                                 if(null != var75) {
                                    if(!var10.field2815) {
                                       var75.method2377(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var48);
                                    } else {
                                       var75.method2366();
                                       if(var10.field2855) {
                                          var75.method2378(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2903, var10.field2848 + var23 + var22, var48 + var10.field2848, var10.field2852);
                                       } else {
                                          var75.method2377(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2903, var22 + var23 + var10.field2848, var10.field2848 + var48);
                                       }
                                    }
                                 }

                                 class94.method2160();
                              } else {
                                 if(var10.type == 7) {
                                    var58 = var10.method3422();
                                    if(null == var58) {
                                       if(Widget.field2796) {
                                          class166.method3253(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2854; ++var21) {
                                       for(var22 = 0; var22 < var10.field2798; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var53 = class22.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var24;
                                             if(var53.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var24 = class144.method3013(16748608) + var53.name + "</col>";
                                             } else {
                                                var24 = class144.method3013(16748608) + var53.name + "</col>" + " " + 'x' + class144.method3015(var10.itemQuantities[var20]);
                                             }

                                             var50 = var12 + (var10.field2864 + 115) * var22;
                                             var26 = var13 + (var10.field2841 + 12) * var21;
                                             if(var10.field2861 == 0) {
                                                var58.method4118(var24, var50, var26, var10.textColor, var10.field2863?0:-1);
                                             } else if(var10.field2861 == 1) {
                                                var58.method4059(var24, var10.width / 2 + var50, var26, var10.textColor, var10.field2863?0:-1);
                                             } else {
                                                var58.method4053(var24, var10.width + var50 - 1, var26, var10.textColor, var10.field2863?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == Actor.field885 && Client.field432 == Client.field431) {
                                    var47 = 0;
                                    var20 = 0;
                                    class227 var49 = MessageNode.field800;
                                    String var51 = var10.text;

                                    String var80;
                                    for(var51 = class10.method125(var51, var10); var51.length() > 0; var20 += var49.field3240 + 1) {
                                       var48 = var51.indexOf("<br>");
                                       if(var48 != -1) {
                                          var80 = var51.substring(0, var48);
                                          var51 = var51.substring(4 + var48);
                                       } else {
                                          var80 = var51;
                                          var51 = "";
                                       }

                                       var50 = var49.method4047(var80);
                                       if(var50 > var47) {
                                          var47 = var50;
                                       }
                                    }

                                    var47 += 6;
                                    var20 += 7;
                                    var48 = var12 + var10.width - 5 - var47;
                                    var50 = 5 + var10.height + var13;
                                    if(var48 < var12 + 5) {
                                       var48 = 5 + var12;
                                    }

                                    if(var48 + var47 > var4) {
                                       var48 = var4 - var47;
                                    }

                                    if(var20 + var50 > var5) {
                                       var50 = var5 - var20;
                                    }

                                    class82.method1885(var48, var50, var47, var20, 16777120);
                                    class82.method1845(var48, var50, var47, var20, 0);
                                    var51 = var10.text;
                                    var26 = 2 + var50 + var49.field3240;

                                    for(var51 = class10.method125(var51, var10); var51.length() > 0; var26 += var49.field3240 + 1) {
                                       var27 = var51.indexOf("<br>");
                                       if(var27 != -1) {
                                          var80 = var51.substring(0, var27);
                                          var51 = var51.substring(4 + var27);
                                       } else {
                                          var80 = var51;
                                          var51 = "";
                                       }

                                       var49.method4118(var80, 3 + var48, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2879 == 1) {
                                       if(var10.field2832) {
                                          var47 = var12;
                                          var20 = var13 + var10.height;
                                          var21 = var12 + var10.width;
                                          var22 = var13;
                                       } else {
                                          var47 = var12;
                                          var20 = var13;
                                          var21 = var12 + var10.width;
                                          var22 = var13 + var10.height;
                                       }

                                       class82.method1851(var47, var20, var21, var22, var10.textColor);
                                    } else {
                                       var47 = var10.width >= 0?var10.width:-var10.width;
                                       var20 = var10.height >= 0?var10.height:-var10.height;
                                       var21 = var47;
                                       if(var47 < var20) {
                                          var21 = var20;
                                       }

                                       if(var21 != 0) {
                                          var22 = (var10.width << 16) / var21;
                                          var23 = (var10.height << 16) / var21;
                                          if(var23 <= var22) {
                                             var22 = -var22;
                                          } else {
                                             var23 = -var23;
                                          }

                                          var48 = var10.field2879 * var23 >> 17;
                                          var50 = var10.field2879 * var23 + 1 >> 17;
                                          var26 = var22 * var10.field2879 >> 17;
                                          var27 = var22 * var10.field2879 + 1 >> 17;
                                          var28 = var48 + var12;
                                          var29 = var12 - var50;
                                          var30 = var12 + var10.width - var50;
                                          var31 = var48 + var12 + var10.width;
                                          var32 = var26 + var13;
                                          var33 = var13 - var27;
                                          var34 = var13 + var10.height - var27;
                                          var35 = var26 + var13 + var10.height;
                                          class94.setRasterClippingEnabled(var28, var29, var30);
                                          class94.rasterFlat(var32, var33, var34, var28, var29, var30, var10.textColor);
                                          class94.setRasterClippingEnabled(var28, var30, var31);
                                          class94.rasterFlat(var32, var34, var35, var28, var30, var31, var10.textColor);
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1852653658"
   )
   public abstract void vmethod3134(Component var1);
}
