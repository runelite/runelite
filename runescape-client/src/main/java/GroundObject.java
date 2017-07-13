import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("r")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1499343347
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1585125123
   )
   @Export("x")
   int x;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -561541477
   )
   @Export("y")
   int y;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 73637843
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 509985867
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(CIB)Ljava/lang/String;",
      garbageValue = "124"
   )
   static String method2480(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;II)V",
      garbageValue = "-429997307"
   )
   static final void method2477(PacketBuffer var0, int var1) {
      int var2 = var0.offset;
      class96.field1498 = 0;
      int var3 = 0;
      var0.bitAccess();

      int var4;
      int var5;
      int var6;
      for(var4 = 0; var4 < class96.field1499; ++var4) {
         var5 = class96.field1492[var4];
         if((class96.field1491[var5] & 1) == 0) {
            if(var3 > 0) {
               --var3;
               class96.field1491[var5] = (byte)(class96.field1491[var5] | 2);
            } else {
               var6 = var0.getBits(1);
               if(var6 == 0) {
                  var3 = class37.method490(var0);
                  class96.field1491[var5] = (byte)(class96.field1491[var5] | 2);
               } else {
                  class56.decodeMovement(var0, var5);
               }
            }
         }
      }

      var0.byteAccess();
      if(var3 != 0) {
         throw new RuntimeException();
      } else {
         var0.bitAccess();

         for(var4 = 0; var4 < class96.field1499; ++var4) {
            var5 = class96.field1492[var4];
            if((class96.field1491[var5] & 1) != 0) {
               if(var3 > 0) {
                  --var3;
                  class96.field1491[var5] = (byte)(class96.field1491[var5] | 2);
               } else {
                  var6 = var0.getBits(1);
                  if(var6 == 0) {
                     var3 = class37.method490(var0);
                     class96.field1491[var5] = (byte)(class96.field1491[var5] | 2);
                  } else {
                     class56.decodeMovement(var0, var5);
                  }
               }
            }
         }

         var0.byteAccess();
         if(var3 != 0) {
            throw new RuntimeException();
         } else {
            var0.bitAccess();

            for(var4 = 0; var4 < class96.field1489; ++var4) {
               var5 = class96.field1494[var4];
               if((class96.field1491[var5] & 1) != 0) {
                  if(var3 > 0) {
                     --var3;
                     class96.field1491[var5] = (byte)(class96.field1491[var5] | 2);
                  } else {
                     var6 = var0.getBits(1);
                     if(var6 == 0) {
                        var3 = class37.method490(var0);
                        class96.field1491[var5] = (byte)(class96.field1491[var5] | 2);
                     } else if(class157.decodeRegionHash(var0, var5)) {
                        class96.field1491[var5] = (byte)(class96.field1491[var5] | 2);
                     }
                  }
               }
            }

            var0.byteAccess();
            if(var3 != 0) {
               throw new RuntimeException();
            } else {
               var0.bitAccess();

               for(var4 = 0; var4 < class96.field1489; ++var4) {
                  var5 = class96.field1494[var4];
                  if((class96.field1491[var5] & 1) == 0) {
                     if(var3 > 0) {
                        --var3;
                        class96.field1491[var5] = (byte)(class96.field1491[var5] | 2);
                     } else {
                        var6 = var0.getBits(1);
                        if(var6 == 0) {
                           var3 = class37.method490(var0);
                           class96.field1491[var5] = (byte)(class96.field1491[var5] | 2);
                        } else if(class157.decodeRegionHash(var0, var5)) {
                           class96.field1491[var5] = (byte)(class96.field1491[var5] | 2);
                        }
                     }
                  }
               }

               var0.byteAccess();
               if(var3 != 0) {
                  throw new RuntimeException();
               } else {
                  class96.field1499 = 0;
                  class96.field1489 = 0;

                  Player var21;
                  for(var4 = 1; var4 < 2048; ++var4) {
                     class96.field1491[var4] = (byte)(class96.field1491[var4] >> 1);
                     var21 = Client.cachedPlayers[var4];
                     if(var21 != null) {
                        class96.field1492[++class96.field1499 - 1] = var4;
                     } else {
                        class96.field1494[++class96.field1489 - 1] = var4;
                     }
                  }

                  for(var3 = 0; var3 < class96.field1498; ++var3) {
                     var4 = class96.field1493[var3];
                     var21 = Client.cachedPlayers[var4];
                     var6 = var0.readUnsignedByte();
                     if((var6 & 2) != 0) {
                        var6 += var0.readUnsignedByte() << 8;
                     }

                     byte var7 = -1;
                     int var8;
                     if((var6 & 64) != 0) {
                        var8 = var0.readUnsignedByte();
                        byte[] var9 = new byte[var8];
                        Buffer var10 = new Buffer(var9);
                        var0.readBytes(var9, 0, var8);
                        class96.field1490[var4] = var10;
                        var21.decodeApperance(var10);
                     }

                     int var22;
                     if((var6 & 1) != 0) {
                        var8 = var0.readUnsignedShort();
                        if(var8 == '\uffff') {
                           var8 = -1;
                        }

                        var22 = var0.readUnsignedByte();
                        Timer.method2981(var21, var8, var22);
                     }

                     if((var6 & 32) != 0) {
                        var21.interacting = var0.readUnsignedShort();
                        if(var21.interacting == '\uffff') {
                           var21.interacting = -1;
                        }
                     }

                     if((var6 & 16) != 0) {
                        var21.overhead = var0.readString();
                        if(var21.overhead.charAt(0) == 126) {
                           var21.overhead = var21.overhead.substring(1);
                           WidgetNode.sendGameMessage(2, var21.name, var21.overhead);
                        } else if(var21 == Script.localPlayer) {
                           WidgetNode.sendGameMessage(2, var21.name, var21.overhead);
                        }

                        var21.field1228 = false;
                        var21.field1231 = 0;
                        var21.field1241 = 0;
                        var21.field1230 = 150;
                     }

                     int var12;
                     int var13;
                     if((var6 & 8) != 0) {
                        var8 = var0.readUnsignedByte();
                        int var11;
                        int var14;
                        int var23;
                        if(var8 > 0) {
                           for(var22 = 0; var22 < var8; ++var22) {
                              var11 = -1;
                              var12 = -1;
                              var13 = -1;
                              var23 = var0.getUSmart();
                              if(var23 == 32767) {
                                 var23 = var0.getUSmart();
                                 var12 = var0.getUSmart();
                                 var11 = var0.getUSmart();
                                 var13 = var0.getUSmart();
                              } else if(var23 != 32766) {
                                 var12 = var0.getUSmart();
                              } else {
                                 var23 = -1;
                              }

                              var14 = var0.getUSmart();
                              var21.method1489(var23, var12, var11, var13, Client.gameCycle, var14);
                           }
                        }

                        var22 = var0.readUnsignedByte();
                        if(var22 > 0) {
                           for(var23 = 0; var23 < var22; ++var23) {
                              var11 = var0.getUSmart();
                              var12 = var0.getUSmart();
                              if(var12 != 32767) {
                                 var13 = var0.getUSmart();
                                 var14 = var0.readUnsignedByte();
                                 int var15 = var12 > 0?var0.readUnsignedByte():var14;
                                 var21.method1490(var11, Client.gameCycle, var12, var13, var14, var15);
                              } else {
                                 var21.method1491(var11);
                              }
                           }
                        }
                     }

                     if((var6 & 128) != 0) {
                        var21.field1242 = var0.readUnsignedShort();
                        if(var21.queueSize == 0) {
                           var21.orientation = var21.field1242;
                           var21.field1242 = -1;
                        }
                     }

                     if((var6 & 4) != 0) {
                        var8 = var0.readUnsignedShort();
                        Permission[] var27 = new Permission[]{Permission.field3176, Permission.field3175, Permission.field3174, Permission.field3180, Permission.field3177, Permission.field3179};
                        Permission var28 = (Permission)PendingSpawn.forOrdinal(var27, var0.readUnsignedByte());
                        boolean var30 = var0.readUnsignedByte() == 1;
                        var12 = var0.readUnsignedByte();
                        var13 = var0.offset;
                        if(var21.name != null && var21.composition != null) {
                           boolean var31 = false;
                           if(var28.field3182 && MilliTimer.isIgnored(var21.name)) {
                              var31 = true;
                           }

                           if(!var31 && Client.field1025 == 0 && !var21.hidden) {
                              class96.field1500.offset = 0;
                              var0.readBytes(class96.field1500.payload, 0, var12);
                              class96.field1500.offset = 0;
                              Buffer var16 = class96.field1500;

                              String var17;
                              int var18;
                              try {
                                 var18 = var16.getUSmart();
                                 if(var18 > 32767) {
                                    var18 = 32767;
                                 }

                                 byte[] var19 = new byte[var18];
                                 var16.offset += class265.field3657.decompress(var16.payload, var16.offset, var19, 0, var18);
                                 String var20 = class7.getString(var19, 0, var18);
                                 var17 = var20;
                              } catch (Exception var26) {
                                 var17 = "Cabbage";
                              }

                              var17 = FontTypeFace.appendTags(XGrandExchangeOffer.method116(var17));
                              var21.overhead = var17.trim();
                              var21.field1231 = var8 >> 8;
                              var21.field1241 = var8 & 255;
                              var21.field1230 = 150;
                              var21.field1228 = var30;
                              var21.inSequence = var21 != Script.localPlayer && var28.field3182 && "" != Client.field1124 && var17.toLowerCase().indexOf(Client.field1124) == -1;
                              if(var28.field3181) {
                                 var18 = var30?91:1;
                              } else {
                                 var18 = var30?90:2;
                              }

                              if(var28.field3178 != -1) {
                                 WidgetNode.sendGameMessage(var18, CombatInfo1.method1517(var28.field3178) + var21.name, var17);
                              } else {
                                 WidgetNode.sendGameMessage(var18, var21.name, var17);
                              }
                           }
                        }

                        var0.offset = var12 + var13;
                     }

                     if((var6 & 512) != 0) {
                        var21.graphic = var0.readUnsignedShort();
                        var8 = var0.readInt();
                        var21.field1255 = var8 >> 16;
                        var21.graphicsDelay = (var8 & '\uffff') + Client.gameCycle;
                        var21.field1250 = 0;
                        var21.field1253 = 0;
                        if(var21.graphicsDelay > Client.gameCycle) {
                           var21.field1250 = -1;
                        }

                        if(var21.graphic == '\uffff') {
                           var21.graphic = -1;
                        }
                     }

                     if((var6 & 1024) != 0) {
                        var21.field1256 = var0.readByte();
                        var21.field1258 = var0.readByte();
                        var21.field1257 = var0.readByte();
                        var21.field1222 = var0.readByte();
                        var21.field1260 = var0.readUnsignedShort() + Client.gameCycle;
                        var21.field1261 = var0.readUnsignedShort() + Client.gameCycle;
                        var21.field1262 = var0.readUnsignedShort();
                        if(var21.field891) {
                           var21.field1256 += var21.field892;
                           var21.field1258 += var21.field893;
                           var21.field1257 += var21.field892;
                           var21.field1222 += var21.field893;
                           var21.queueSize = 0;
                        } else {
                           var21.field1256 += var21.pathX[0];
                           var21.field1258 += var21.pathY[0];
                           var21.field1257 += var21.pathX[0];
                           var21.field1222 += var21.pathY[0];
                           var21.queueSize = 1;
                        }

                        var21.field1273 = 0;
                     }

                     if((var6 & 256) != 0) {
                        class96.field1487[var4] = var0.readByte();
                     }

                     if((var6 & 4096) != 0) {
                        var7 = var0.readByte();
                     }

                     if((var6 & 2048) != 0) {
                        for(var8 = 0; var8 < 3; ++var8) {
                           var21.actions[var8] = var0.readString();
                        }
                     }

                     if(var21.field891) {
                        if(var7 == 127) {
                           var21.method1116(var21.field892, var21.field893);
                        } else {
                           byte var29;
                           if(var7 != -1) {
                              var29 = var7;
                           } else {
                              var29 = class96.field1487[var4];
                           }

                           var21.method1115(var21.field892, var21.field893, var29);
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

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "-1385359006"
   )
   static final void method2478(String var0, int var1) {
      Client.secretPacketBuffer1.putOpcode(179);
      Client.secretPacketBuffer1.putByte(DecorativeObject.getLength(var0) + 1);
      Client.secretPacketBuffer1.method3127(var1);
      Client.secretPacketBuffer1.putString(var0);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "1663083699"
   )
   static void method2479(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var11 = World.worldList[var9];
            int var12 = CombatInfo1.method1508(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = CombatInfo1.method1508(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               World var14 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var14;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method2479(var0, var7 - 1, var2, var3, var4, var5);
         method2479(var7 + 1, var1, var2, var3, var4, var5);
      }

   }
}
