import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
public class class236 implements Runnable {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   static Deque field3235;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   static Deque field3230;
   @ObfuscatedName("r")
   static Object field3231;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -178142535
   )
   static int field3233;

   static {
      field3235 = new Deque();
      field3230 = new Deque();
      field3233 = 0;
      field3231 = new Object();
   }

   public void run() {
      try {
         while(true) {
            Deque var2 = field3235;
            FileSystem var1;
            synchronized(field3235) {
               var1 = (FileSystem)field3235.getFront();
            }

            Object var14;
            if(var1 != null) {
               if(var1.field3204 == 0) {
                  var1.index.method3017((int)var1.hash, var1.field3202, var1.field3202.length);
                  var2 = field3235;
                  synchronized(field3235) {
                     var1.unlink();
                  }
               } else if(var1.field3204 == 1) {
                  var1.field3202 = var1.index.method3011((int)var1.hash);
                  var2 = field3235;
                  synchronized(field3235) {
                     field3230.addFront(var1);
                  }
               }

               var14 = field3231;
               synchronized(field3231) {
                  if(field3233 <= 1) {
                     field3233 = 0;
                     field3231.notifyAll();
                     return;
                  }

                  field3233 = 600;
               }
            } else {
               class33.method354(100L);
               var14 = field3231;
               synchronized(field3231) {
                  if(field3233 <= 1) {
                     field3233 = 0;
                     field3231.notifyAll();
                     return;
                  }

                  --field3233;
               }
            }
         }
      } catch (Exception var13) {
         class54.method800((String)null, var13);
      }
   }

   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "458474447"
   )
   static final void method4172() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      if(Client.packetType == 109) {
         var0 = Client.secretPacketBuffer2.method3166();
         var1 = var0 >> 2;
         var2 = var0 & 3;
         var3 = Client.field934[var1];
         var4 = Client.secretPacketBuffer2.method3166();
         var5 = (var4 >> 4 & 7) + WorldMapType2.field514;
         var6 = (var4 & 7) + class251.field3390;
         if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
            class60.method1034(class45.plane, var5, var6, var3, -1, var1, var2, 0, -1);
         }

      } else {
         Item var30;
         if(Client.packetType == 56) {
            var0 = Client.secretPacketBuffer2.readUnsignedShort();
            var1 = Client.secretPacketBuffer2.method3249();
            var2 = (var1 >> 4 & 7) + WorldMapType2.field514;
            var3 = (var1 & 7) + class251.field3390;
            if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
               Deque var31 = Client.groundItemDeque[class45.plane][var2][var3];
               if(var31 != null) {
                  for(var30 = (Item)var31.getFront(); var30 != null; var30 = (Item)var31.getNext()) {
                     if((var0 & 32767) == var30.id) {
                        var30.unlink();
                        break;
                     }
                  }

                  if(var31.getFront() == null) {
                     Client.groundItemDeque[class45.plane][var2][var3] = null;
                  }

                  class47.groundItemSpawned(var2, var3);
               }
            }

         } else {
            int var7;
            int var9;
            if(Client.packetType == 34) {
               var0 = Client.secretPacketBuffer2.readUnsignedShort();
               var1 = Client.secretPacketBuffer2.method3249();
               var2 = (var1 >> 4 & 7) + WorldMapType2.field514;
               var3 = (var1 & 7) + class251.field3390;
               var4 = Client.secretPacketBuffer2.method3165();
               var5 = var4 >> 2;
               var6 = var4 & 3;
               var7 = Client.field934[var5];
               if(var2 >= 0 && var3 >= 0 && var2 < 103 && var3 < 103) {
                  if(var7 == 0) {
                     WallObject var8 = class29.region.method2815(class45.plane, var2, var3);
                     if(var8 != null) {
                        var9 = var8.hash >> 14 & 32767;
                        if(var5 == 2) {
                           var8.renderable1 = new DynamicObject(var9, 2, var6 + 4, class45.plane, var2, var3, var0, false, var8.renderable1);
                           var8.renderable2 = new DynamicObject(var9, 2, var6 + 1 & 3, class45.plane, var2, var3, var0, false, var8.renderable2);
                        } else {
                           var8.renderable1 = new DynamicObject(var9, var5, var6, class45.plane, var2, var3, var0, false, var8.renderable1);
                        }
                     }
                  }

                  if(var7 == 1) {
                     DecorativeObject var39 = class29.region.method2689(class45.plane, var2, var3);
                     if(var39 != null) {
                        var9 = var39.hash >> 14 & 32767;
                        if(var5 != 4 && var5 != 5) {
                           if(var5 == 6) {
                              var39.renderable1 = new DynamicObject(var9, 4, var6 + 4, class45.plane, var2, var3, var0, false, var39.renderable1);
                           } else if(var5 == 7) {
                              var39.renderable1 = new DynamicObject(var9, 4, (var6 + 2 & 3) + 4, class45.plane, var2, var3, var0, false, var39.renderable1);
                           } else if(var5 == 8) {
                              var39.renderable1 = new DynamicObject(var9, 4, var6 + 4, class45.plane, var2, var3, var0, false, var39.renderable1);
                              var39.renderable2 = new DynamicObject(var9, 4, (var6 + 2 & 3) + 4, class45.plane, var2, var3, var0, false, var39.renderable2);
                           }
                        } else {
                           var39.renderable1 = new DynamicObject(var9, 4, var6, class45.plane, var2, var3, var0, false, var39.renderable1);
                        }
                     }
                  }

                  if(var7 == 2) {
                     GameObject var40 = class29.region.method2690(class45.plane, var2, var3);
                     if(var5 == 11) {
                        var5 = 10;
                     }

                     if(var40 != null) {
                        var40.renderable = new DynamicObject(var40.hash >> 14 & 32767, var5, var6, class45.plane, var2, var3, var0, false, var40.renderable);
                     }
                  }

                  if(var7 == 3) {
                     GroundObject var41 = class29.region.method2735(class45.plane, var2, var3);
                     if(var41 != null) {
                        var41.renderable = new DynamicObject(var41.hash >> 14 & 32767, 22, var6, class45.plane, var2, var3, var0, false, var41.renderable);
                     }
                  }
               }

            } else if(Client.packetType == 121) {
               var0 = Client.secretPacketBuffer2.method3249();
               var1 = (var0 >> 4 & 7) + WorldMapType2.field514;
               var2 = (var0 & 7) + class251.field3390;
               var3 = Client.secretPacketBuffer2.method3165();
               var4 = var3 >> 2;
               var5 = var3 & 3;
               var6 = Client.field934[var4];
               var7 = Client.secretPacketBuffer2.method3176();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  class60.method1034(class45.plane, var1, var2, var6, var7, var4, var5, 0, -1);
               }

            } else if(Client.packetType == 105) {
               var0 = Client.secretPacketBuffer2.method3165();
               var1 = (var0 >> 4 & 7) + WorldMapType2.field514;
               var2 = (var0 & 7) + class251.field3390;
               var3 = Client.secretPacketBuffer2.readUnsignedShort();
               var4 = Client.secretPacketBuffer2.readByteOb1();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  var30 = new Item();
                  var30.id = var3;
                  var30.quantity = var4;
                  if(Client.groundItemDeque[class45.plane][var1][var2] == null) {
                     Client.groundItemDeque[class45.plane][var1][var2] = new Deque();
                  }

                  Client.groundItemDeque[class45.plane][var1][var2].addFront(var30);
                  class47.groundItemSpawned(var1, var2);
               }

            } else {
               int var32;
               if(Client.packetType == 248) {
                  var0 = Client.secretPacketBuffer2.readUnsignedByte();
                  var1 = (var0 >> 4 & 7) + WorldMapType2.field514;
                  var2 = (var0 & 7) + class251.field3390;
                  var3 = Client.secretPacketBuffer2.readUnsignedShort();
                  var4 = Client.secretPacketBuffer2.readUnsignedByte();
                  var5 = var4 >> 4 & 15;
                  var6 = var4 & 7;
                  var7 = Client.secretPacketBuffer2.readUnsignedByte();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var32 = var5 + 1;
                     if(Script.localPlayer.pathX[0] >= var1 - var32 && Script.localPlayer.pathX[0] <= var1 + var32 && Script.localPlayer.pathY[0] >= var2 - var32 && Script.localPlayer.pathY[0] <= var2 + var32 && Client.field1172 != 0 && var6 > 0 && Client.field1080 < 50) {
                        Client.field1147[Client.field1080] = var3;
                        Client.field965[Client.field1080] = var6;
                        Client.field1149[Client.field1080] = var7;
                        Client.audioEffects[Client.field1080] = null;
                        Client.field1014[Client.field1080] = var5 + (var2 << 8) + (var1 << 16);
                        ++Client.field1080;
                     }
                  }

               } else if(Client.packetType == 102) {
                  var0 = Client.secretPacketBuffer2.readUnsignedByte();
                  var1 = (var0 >> 4 & 7) + WorldMapType2.field514;
                  var2 = (var0 & 7) + class251.field3390;
                  var3 = Client.secretPacketBuffer2.readUnsignedShort();
                  var4 = Client.secretPacketBuffer2.readUnsignedByte();
                  var5 = Client.secretPacketBuffer2.readUnsignedShort();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var1 = var1 * 128 + 64;
                     var2 = var2 * 128 + 64;
                     GraphicsObject var42 = new GraphicsObject(var3, class45.plane, var1, var2, Actor.getTileHeight(var1, var2, class45.plane) - var4, var5, Client.gameCycle);
                     Client.graphicsObjectDeque.addFront(var42);
                  }

               } else if(Client.packetType == 214) {
                  var0 = Client.secretPacketBuffer2.readUnsignedByte();
                  var1 = (var0 >> 4 & 7) + WorldMapType2.field514;
                  var2 = (var0 & 7) + class251.field3390;
                  var3 = Client.secretPacketBuffer2.readUnsignedShort();
                  var4 = Client.secretPacketBuffer2.readUnsignedShort();
                  var5 = Client.secretPacketBuffer2.readUnsignedShort();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     Deque var29 = Client.groundItemDeque[class45.plane][var1][var2];
                     if(var29 != null) {
                        for(Item var33 = (Item)var29.getFront(); var33 != null; var33 = (Item)var29.getNext()) {
                           if((var3 & 32767) == var33.id && var4 == var33.quantity) {
                              var33.quantity = var5;
                              break;
                           }
                        }

                        class47.groundItemSpawned(var1, var2);
                     }
                  }

               } else {
                  int var10;
                  int var11;
                  int var12;
                  if(Client.packetType == 122) {
                     byte var35 = Client.secretPacketBuffer2.method3170();
                     byte var36 = Client.secretPacketBuffer2.method3299();
                     byte var37 = Client.secretPacketBuffer2.readByte();
                     var3 = Client.secretPacketBuffer2.readUnsignedByte();
                     var4 = var3 >> 2;
                     var5 = var3 & 3;
                     var6 = Client.field934[var4];
                     byte var38 = Client.secretPacketBuffer2.method3170();
                     var32 = Client.secretPacketBuffer2.readByteOb1();
                     var9 = Client.secretPacketBuffer2.readUnsignedShortOb1();
                     var10 = Client.secretPacketBuffer2.method3176();
                     var11 = Client.secretPacketBuffer2.readByteOb1();
                     var12 = Client.secretPacketBuffer2.method3249();
                     int var13 = (var12 >> 4 & 7) + WorldMapType2.field514;
                     int var14 = (var12 & 7) + class251.field3390;
                     Player var15;
                     if(var11 == Client.localInteractingIndex) {
                        var15 = Script.localPlayer;
                     } else {
                        var15 = Client.cachedPlayers[var11];
                     }

                     if(var15 != null) {
                        ObjectComposition var16 = PlayerComposition.getObjectDefinition(var32);
                        int var17;
                        int var18;
                        if(var5 != 1 && var5 != 3) {
                           var17 = var16.sizeX;
                           var18 = var16.sizeY;
                        } else {
                           var17 = var16.sizeY;
                           var18 = var16.sizeX;
                        }

                        int var19 = var13 + (var17 >> 1);
                        int var20 = var13 + (var17 + 1 >> 1);
                        int var21 = var14 + (var18 >> 1);
                        int var22 = var14 + (var18 + 1 >> 1);
                        int[][] var23 = class61.tileHeights[class45.plane];
                        int var24 = var23[var20][var22] + var23[var19][var22] + var23[var19][var21] + var23[var20][var21] >> 2;
                        int var25 = (var13 << 7) + (var17 << 6);
                        int var26 = (var14 << 7) + (var18 << 6);
                        Model var27 = var16.method4489(var4, var5, var23, var25, var24, var26);
                        if(var27 != null) {
                           class60.method1034(class45.plane, var13, var14, var6, -1, 0, 0, var10 + 1, var9 + 1);
                           var15.field878 = var10 + Client.gameCycle;
                           var15.field884 = var9 + Client.gameCycle;
                           var15.model = var27;
                           var15.field895 = var13 * 128 + 64 * var17;
                           var15.field880 = var14 * 128 + var18 * 64;
                           var15.field879 = var24;
                           byte var28;
                           if(var36 > var35) {
                              var28 = var36;
                              var36 = var35;
                              var35 = var28;
                           }

                           if(var37 > var38) {
                              var28 = var37;
                              var37 = var38;
                              var38 = var28;
                           }

                           var15.field882 = var36 + var13;
                           var15.field867 = var13 + var35;
                           var15.field883 = var14 + var37;
                           var15.field885 = var14 + var38;
                        }
                     }

                  } else if(Client.packetType == 221) {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + WorldMapType2.field514;
                     var2 = (var0 & 7) + class251.field3390;
                     var3 = var1 + Client.secretPacketBuffer2.readByte();
                     var4 = var2 + Client.secretPacketBuffer2.readByte();
                     var5 = Client.secretPacketBuffer2.readShort();
                     var6 = Client.secretPacketBuffer2.readUnsignedShort();
                     var7 = Client.secretPacketBuffer2.readUnsignedByte() * 4;
                     var32 = Client.secretPacketBuffer2.readUnsignedByte() * 4;
                     var9 = Client.secretPacketBuffer2.readUnsignedShort();
                     var10 = Client.secretPacketBuffer2.readUnsignedShort();
                     var11 = Client.secretPacketBuffer2.readUnsignedByte();
                     var12 = Client.secretPacketBuffer2.readUnsignedByte();
                     if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var6 != '\uffff') {
                        var1 = var1 * 128 + 64;
                        var2 = var2 * 128 + 64;
                        var3 = var3 * 128 + 64;
                        var4 = var4 * 128 + 64;
                        Projectile var34 = new Projectile(var6, class45.plane, var1, var2, Actor.getTileHeight(var1, var2, class45.plane) - var7, var9 + Client.gameCycle, var10 + Client.gameCycle, var11, var12, var5, var32);
                        var34.method1735(var3, var4, Actor.getTileHeight(var3, var4, class45.plane) - var32, var9 + Client.gameCycle);
                        Client.projectiles.addFront(var34);
                     }

                  }
               }
            }
         }
      }
   }
}
