import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
public abstract class class9 extends Node {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-191383716"
   )
   abstract void vmethod55();

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgd;II)V",
      garbageValue = "754393096"
   )
   static final void method46(PacketBuffer var0, int var1) {
      int var2 = var0.offset;
      class94.field1407 = 0;
      int var3 = 0;
      var0.bitAccess();

      int var4;
      int var5;
      int var6;
      for(var4 = 0; var4 < class94.playerIndexesCount; ++var4) {
         var5 = class94.playerIndices[var4];
         if((class94.field1397[var5] & 1) == 0) {
            if(var3 > 0) {
               --var3;
               class94.field1397[var5] = (byte)(class94.field1397[var5] | 2);
            } else {
               var6 = var0.getBits(1);
               if(var6 == 0) {
                  var3 = class228.method4085(var0);
                  class94.field1397[var5] = (byte)(class94.field1397[var5] | 2);
               } else {
                  World.decodeMovement(var0, var5);
               }
            }
         }
      }

      var0.byteAccess();
      if(var3 != 0) {
         throw new RuntimeException();
      } else {
         var0.bitAccess();

         for(var4 = 0; var4 < class94.playerIndexesCount; ++var4) {
            var5 = class94.playerIndices[var4];
            if((class94.field1397[var5] & 1) != 0) {
               if(var3 > 0) {
                  --var3;
                  class94.field1397[var5] = (byte)(class94.field1397[var5] | 2);
               } else {
                  var6 = var0.getBits(1);
                  if(var6 == 0) {
                     var3 = class228.method4085(var0);
                     class94.field1397[var5] = (byte)(class94.field1397[var5] | 2);
                  } else {
                     World.decodeMovement(var0, var5);
                  }
               }
            }
         }

         var0.byteAccess();
         if(var3 != 0) {
            throw new RuntimeException();
         } else {
            var0.bitAccess();

            for(var4 = 0; var4 < class94.field1402; ++var4) {
               var5 = class94.field1403[var4];
               if((class94.field1397[var5] & 1) != 0) {
                  if(var3 > 0) {
                     --var3;
                     class94.field1397[var5] = (byte)(class94.field1397[var5] | 2);
                  } else {
                     var6 = var0.getBits(1);
                     if(var6 == 0) {
                        var3 = class228.method4085(var0);
                        class94.field1397[var5] = (byte)(class94.field1397[var5] | 2);
                     } else if(class268.decodeRegionHash(var0, var5)) {
                        class94.field1397[var5] = (byte)(class94.field1397[var5] | 2);
                     }
                  }
               }
            }

            var0.byteAccess();
            if(var3 != 0) {
               throw new RuntimeException();
            } else {
               var0.bitAccess();

               for(var4 = 0; var4 < class94.field1402; ++var4) {
                  var5 = class94.field1403[var4];
                  if((class94.field1397[var5] & 1) == 0) {
                     if(var3 > 0) {
                        --var3;
                        class94.field1397[var5] = (byte)(class94.field1397[var5] | 2);
                     } else {
                        var6 = var0.getBits(1);
                        if(var6 == 0) {
                           var3 = class228.method4085(var0);
                           class94.field1397[var5] = (byte)(class94.field1397[var5] | 2);
                        } else if(class268.decodeRegionHash(var0, var5)) {
                           class94.field1397[var5] = (byte)(class94.field1397[var5] | 2);
                        }
                     }
                  }
               }

               var0.byteAccess();
               if(var3 != 0) {
                  throw new RuntimeException();
               } else {
                  class94.playerIndexesCount = 0;
                  class94.field1402 = 0;

                  Player var21;
                  for(var4 = 1; var4 < 2048; ++var4) {
                     class94.field1397[var4] = (byte)(class94.field1397[var4] >> 1);
                     var21 = Client.cachedPlayers[var4];
                     if(var21 != null) {
                        class94.playerIndices[++class94.playerIndexesCount - 1] = var4;
                     } else {
                        class94.field1403[++class94.field1402 - 1] = var4;
                     }
                  }

                  for(var3 = 0; var3 < class94.field1407; ++var3) {
                     var4 = class94.field1405[var3];
                     var21 = Client.cachedPlayers[var4];
                     var6 = var0.readUnsignedByte();
                     if((var6 & 128) != 0) {
                        var6 += var0.readUnsignedByte() << 8;
                     }

                     byte var7 = -1;
                     if((var6 & 256) != 0) {
                        class94.field1398[var4] = var0.readByte();
                     }

                     if((var6 & 64) != 0) {
                        var21.field1172 = var0.readUnsignedShort();
                        if(var21.queueSize == 0) {
                           var21.orientation = var21.field1172;
                           var21.field1172 = -1;
                        }
                     }

                     int var8;
                     int var9;
                     int var12;
                     int var13;
                     if((var6 & 32) != 0) {
                        var8 = var0.readUnsignedByte();
                        int var10;
                        int var11;
                        int var14;
                        if(var8 > 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              var11 = -1;
                              var12 = -1;
                              var13 = -1;
                              var10 = var0.getUSmart();
                              if(var10 == 32767) {
                                 var10 = var0.getUSmart();
                                 var12 = var0.getUSmart();
                                 var11 = var0.getUSmart();
                                 var13 = var0.getUSmart();
                              } else if(var10 != 32766) {
                                 var12 = var0.getUSmart();
                              } else {
                                 var10 = -1;
                              }

                              var14 = var0.getUSmart();
                              var21.method1501(var10, var12, var11, var13, Client.gameCycle, var14);
                           }
                        }

                        var9 = var0.readUnsignedShortOb1();
                        if(var9 > 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              var11 = var0.getUSmart();
                              var12 = var0.getUSmart();
                              if(var12 != 32767) {
                                 var13 = var0.getUSmart();
                                 var14 = var0.method3214();
                                 int var15 = var12 > 0?var0.method3215():var14;
                                 var21.method1511(var11, Client.gameCycle, var12, var13, var14, var15);
                              } else {
                                 var21.method1495(var11);
                              }
                           }
                        }
                     }

                     if((var6 & 512) != 0) {
                        for(var8 = 0; var8 < 3; ++var8) {
                           var21.actions[var8] = var0.readString();
                        }
                     }

                     if((var6 & 4) != 0) {
                        var21.interacting = var0.readUnsignedShort();
                        if(var21.interacting == 65535) {
                           var21.interacting = -1;
                        }
                     }

                     if((var6 & 1024) != 0) {
                        var21.field1186 = var0.method3216();
                        var21.field1162 = var0.method3278();
                        var21.field1174 = var0.method3216();
                        var21.field1164 = var0.method3216();
                        var21.field1178 = var0.method3290() + Client.gameCycle;
                        var21.field1191 = var0.method3224() + Client.gameCycle;
                        var21.field1195 = var0.method3290();
                        if(var21.field818) {
                           var21.field1186 += var21.field838;
                           var21.field1162 += var21.field833;
                           var21.field1174 += var21.field838;
                           var21.field1164 += var21.field833;
                           var21.queueSize = 0;
                        } else {
                           var21.field1186 += var21.pathX[0];
                           var21.field1162 += var21.pathY[0];
                           var21.field1174 += var21.pathX[0];
                           var21.field1164 += var21.pathY[0];
                           var21.queueSize = 1;
                        }

                        var21.field1203 = 0;
                     }

                     if((var6 & 16) != 0) {
                        var8 = var0.method3222();
                        if(var8 == 65535) {
                           var8 = -1;
                        }

                        var9 = var0.readUnsignedByte();
                        Ignore.method1045(var21, var8, var9);
                     }

                     if((var6 & 2048) != 0) {
                        var21.graphic = var0.method3224();
                        var8 = var0.method3231();
                        var21.field1185 = var8 >> 16;
                        var21.graphicsDelay = (var8 & 65535) + Client.gameCycle;
                        var21.field1190 = 0;
                        var21.field1183 = 0;
                        if(var21.graphicsDelay > Client.gameCycle) {
                           var21.field1190 = -1;
                        }

                        if(var21.graphic == 65535) {
                           var21.graphic = -1;
                        }
                     }

                     if((var6 & 1) != 0) {
                        var21.overhead = var0.readString();
                        if(var21.overhead.charAt(0) == '~') {
                           var21.overhead = var21.overhead.substring(1);
                           class3.sendGameMessage(2, var21.name, var21.overhead);
                        } else if(var21 == class275.localPlayer) {
                           class3.sendGameMessage(2, var21.name, var21.overhead);
                        }

                        var21.field1158 = false;
                        var21.field1161 = 0;
                        var21.field1145 = 0;
                        var21.field1201 = 150;
                     }

                     if((var6 & 4096) != 0) {
                        var7 = var0.method3189();
                     }

                     if((var6 & 8) != 0) {
                        var8 = var0.method3290();
                        Permission[] var22 = new Permission[]{Permission.field3237, Permission.field3235, Permission.field3234, Permission.field3233, Permission.field3240, Permission.field3232};
                        Permission var23 = (Permission)class153.forOrdinal(var22, var0.readUnsignedShortOb1());
                        boolean var28 = var0.method3214() == 1;
                        var12 = var0.readUnsignedShortOb1();
                        var13 = var0.offset;
                        if(var21.name != null && var21.composition != null) {
                           boolean var29 = false;
                           if(var23.field3239 && class13.isIgnored(var21.name)) {
                              var29 = true;
                           }

                           if(!var29 && Client.field966 == 0 && !var21.hidden) {
                              class94.field1399.offset = 0;
                              var0.method3267(class94.field1399.payload, 0, var12);
                              class94.field1399.offset = 0;
                              Buffer var16 = class94.field1399;

                              String var17;
                              int var18;
                              try {
                                 var18 = var16.getUSmart();
                                 if(var18 > 32767) {
                                    var18 = 32767;
                                 }

                                 byte[] var19 = new byte[var18];
                                 var16.offset += class272.field3707.decompress(var16.payload, var16.offset, var19, 0, var18);
                                 String var20 = class24.getString(var19, 0, var18);
                                 var17 = var20;
                              } catch (Exception var26) {
                                 var17 = "Cabbage";
                              }

                              var17 = FontTypeFace.appendTags(RSSocket.method3027(var17));
                              var21.overhead = var17.trim();
                              var21.field1161 = var8 >> 8;
                              var21.field1145 = var8 & 255;
                              var21.field1201 = 150;
                              var21.field1158 = var28;
                              var21.inSequence = var21 != class275.localPlayer && var23.field3239 && "" != Client.field1065 && var17.toLowerCase().indexOf(Client.field1065) == -1;
                              if(var23.field3231) {
                                 var18 = var28?91:1;
                              } else {
                                 var18 = var28?90:2;
                              }

                              if(var23.field3238 != -1) {
                                 class3.sendGameMessage(var18, Client.method1489(var23.field3238) + var21.name, var17);
                              } else {
                                 class3.sendGameMessage(var18, var21.name, var17);
                              }
                           }
                        }

                        var0.offset = var13 + var12;
                     }

                     if((var6 & 2) != 0) {
                        var8 = var0.readUnsignedByte();
                        byte[] var30 = new byte[var8];
                        Buffer var31 = new Buffer(var30);
                        var0.readBytes(var30, 0, var8);
                        class94.field1408[var4] = var31;
                        var21.decodeApperance(var31);
                     }

                     if(var21.field818) {
                        if(var7 == 127) {
                           var21.method1068(var21.field838, var21.field833);
                        } else {
                           byte var27;
                           if(var7 != -1) {
                              var27 = var7;
                           } else {
                              var27 = class94.field1398[var4];
                           }

                           var21.method1071(var21.field838, var21.field833, var27);
                        }
                     }
                  }

                  if(var0.offset - var2 != var1) {
                     throw new RuntimeException(var0.offset - var2 + " " + var1);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lev;IIIII)V",
      garbageValue = "1305615404"
   )
   public static final void method54(Model var0, int var1, int var2, int var3, int var4) {
      class7.field220.method3618(new class10(var0, var1, var2, var3, var4));
   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "1292157022"
   )
   static final void method53(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = var2 - var0;
      int var7 = var3 - var1;
      int var8 = var6 >= 0?var6:-var6;
      int var9 = var7 >= 0?var7:-var7;
      int var10 = var8;
      if(var8 < var9) {
         var10 = var9;
      }

      if(var10 != 0) {
         int var11 = (var6 << 16) / var10;
         int var12 = (var7 << 16) / var10;
         if(var12 <= var11) {
            var11 = -var11;
         } else {
            var12 = -var12;
         }

         int var13 = var5 * var12 >> 17;
         int var14 = var5 * var12 + 1 >> 17;
         int var15 = var5 * var11 >> 17;
         int var16 = var5 * var11 + 1 >> 17;
         var0 -= Rasterizer2D.draw_region_x;
         var1 -= Rasterizer2D.drawingAreaTop;
         int var17 = var0 + var13;
         int var18 = var0 - var14;
         int var19 = var0 + var6 - var14;
         int var20 = var0 + var13 + var6;
         int var21 = var15 + var1;
         int var22 = var1 - var16;
         int var23 = var7 + var1 - var16;
         int var24 = var15 + var7 + var1;
         Graphics3D.setRasterClippingEnabled(var17, var18, var19);
         Graphics3D.rasterFlat(var21, var22, var23, var17, var18, var19, var4);
         Graphics3D.setRasterClippingEnabled(var17, var19, var20);
         Graphics3D.rasterFlat(var21, var23, var24, var17, var19, var20, var4);
      }
   }
}
