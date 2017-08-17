import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
public class class237 implements Runnable {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   static Deque field3224;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   static Deque field3220;
   @ObfuscatedName("p")
   static Object field3222;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -971620285
   )
   static int field3219;
   @ObfuscatedName("x")
   static Thread field3221;

   static {
      field3224 = new Deque();
      field3220 = new Deque();
      field3219 = 0;
      field3222 = new Object();
   }

   public void run() {
      try {
         while(true) {
            Deque var2 = field3224;
            FileSystem var1;
            synchronized(field3224) {
               var1 = (FileSystem)field3224.getFront();
            }

            Object var14;
            if(var1 != null) {
               if(var1.field3196 == 0) {
                  var1.index.method3035((int)var1.hash, var1.field3194, var1.field3194.length);
                  var2 = field3224;
                  synchronized(field3224) {
                     var1.unlink();
                  }
               } else if(var1.field3196 == 1) {
                  var1.field3194 = var1.index.method3039((int)var1.hash);
                  var2 = field3224;
                  synchronized(field3224) {
                     field3220.addFront(var1);
                  }
               }

               var14 = field3222;
               synchronized(field3222) {
                  if(field3219 <= 1) {
                     field3219 = 0;
                     field3222.notifyAll();
                     return;
                  }

                  field3219 = 600;
               }
            } else {
               class10.method51(100L);
               var14 = field3222;
               synchronized(field3222) {
                  if(field3219 <= 1) {
                     field3219 = 0;
                     field3222.notifyAll();
                     return;
                  }

                  --field3219;
               }
            }
         }
      } catch (Exception var13) {
         Varcs.method1853((String)null, var13);
      }
   }

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "837386278"
   )
   static final void method4222() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      if(Client.packetType == (Client.RUNELITE_PACKET?38:113)) {
         if(Client.RUNELITE_PACKET) {
            var0 = Client.secretPacketBuffer2.runeliteReadInt();
            var3 = Client.secretPacketBuffer2.runeliteReadInt();
            var1 = (var0 >> 4 & 7) + TextureProvider.field1788;
            var2 = (var0 & 7) + class34.field498;
         } else {
            var0 = Client.secretPacketBuffer2.readUnsignedShortOb1();
            var1 = (var0 >> 4 & 7) + TextureProvider.field1788;
            var2 = (var0 & 7) + class34.field498;
            var3 = Client.secretPacketBuffer2.readUnsignedByte();
         }

         var4 = var3 >> 2;
         var5 = var3 & 3;
         var6 = Client.field999[var4];
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            class253.method4495(class35.plane, var1, var2, var6, -1, var4, var5, 0, -1);
         }

      } else {
         Item var30;
         if(Client.packetType == (Client.RUNELITE_PACKET?39:79)) {
            if(Client.RUNELITE_PACKET) {
               var0 = Client.secretPacketBuffer2.runeliteReadInt();
               var3 = Client.secretPacketBuffer2.runeliteReadInt();
               var1 = (var0 >> 4 & 7) + TextureProvider.field1788;
               var2 = (var0 & 7) + class34.field498;
            } else {
               var0 = Client.secretPacketBuffer2.method3185();
               var1 = (var0 >> 4 & 7) + TextureProvider.field1788;
               var2 = (var0 & 7) + class34.field498;
               var3 = Client.secretPacketBuffer2.method3209();
            }

            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               Deque var29 = Client.groundItemDeque[class35.plane][var1][var2];
               if(var29 != null) {
                  for(var30 = (Item)var29.getFront(); var30 != null; var30 = (Item)var29.getNext()) {
                     if((var3 & 32767) == var30.id) {
                        var30.unlink();
                        break;
                     }
                  }

                  if(var29.getFront() == null) {
                     Client.groundItemDeque[class35.plane][var1][var2] = null;
                  }

                  class209.groundItemSpawned(var1, var2);
               }
            }

         } else {
            int var7;
            int var9;
            if(Client.packetType == (Client.RUNELITE_PACKET?46:131)) {
               if(Client.RUNELITE_PACKET) {
                  var1 = Client.secretPacketBuffer2.runeliteReadInt();
                  var5 = Client.secretPacketBuffer2.runeliteReadInt();
                  var0 = Client.secretPacketBuffer2.runeliteReadInt();
                  var2 = var1 >> 2;
                  var3 = var1 & 3;
                  var4 = Client.field999[var2];
               } else {
                  var0 = Client.secretPacketBuffer2.method3329();
                  var1 = Client.secretPacketBuffer2.readUnsignedByte();
                  var2 = var1 >> 2;
                  var3 = var1 & 3;
                  var4 = Client.field999[var2];
                  var5 = Client.secretPacketBuffer2.method3185();
               }

               var6 = (var5 >> 4 & 7) + TextureProvider.field1788;
               var7 = (var5 & 7) + class34.field498;
               if(var6 >= 0 && var7 >= 0 && var6 < 103 && var7 < 103) {
                  if(var4 == 0) {
                     WallObject var31 = class36.region.method2794(class35.plane, var6, var7);
                     if(var31 != null) {
                        var9 = var31.hash >> 14 & 32767;
                        if(var2 == 2) {
                           var31.renderable1 = new DynamicObject(var9, 2, var3 + 4, class35.plane, var6, var7, var0, false, var31.renderable1);
                           var31.renderable2 = new DynamicObject(var9, 2, var3 + 1 & 3, class35.plane, var6, var7, var0, false, var31.renderable2);
                        } else {
                           var31.renderable1 = new DynamicObject(var9, var2, var3, class35.plane, var6, var7, var0, false, var31.renderable1);
                        }
                     }
                  }

                  if(var4 == 1) {
                     DecorativeObject var38 = class36.region.method2795(class35.plane, var6, var7);
                     if(var38 != null) {
                        var9 = var38.hash >> 14 & 32767;
                        if(var2 != 4 && var2 != 5) {
                           if(var2 == 6) {
                              var38.renderable1 = new DynamicObject(var9, 4, var3 + 4, class35.plane, var6, var7, var0, false, var38.renderable1);
                           } else if(var2 == 7) {
                              var38.renderable1 = new DynamicObject(var9, 4, (var3 + 2 & 3) + 4, class35.plane, var6, var7, var0, false, var38.renderable1);
                           } else if(var2 == 8) {
                              var38.renderable1 = new DynamicObject(var9, 4, var3 + 4, class35.plane, var6, var7, var0, false, var38.renderable1);
                              var38.renderable2 = new DynamicObject(var9, 4, 4 + (var3 + 2 & 3), class35.plane, var6, var7, var0, false, var38.renderable2);
                           }
                        } else {
                           var38.renderable1 = new DynamicObject(var9, 4, var3, class35.plane, var6, var7, var0, false, var38.renderable1);
                        }
                     }
                  }

                  if(var4 == 2) {
                     GameObject var39 = class36.region.method2815(class35.plane, var6, var7);
                     if(var2 == 11) {
                        var2 = 10;
                     }

                     if(var39 != null) {
                        var39.renderable = new DynamicObject(var39.hash >> 14 & 32767, var2, var3, class35.plane, var6, var7, var0, false, var39.renderable);
                     }
                  }

                  if(var4 == 3) {
                     GroundObject var40 = class36.region.method2875(class35.plane, var6, var7);
                     if(var40 != null) {
                        var40.renderable = new DynamicObject(var40.hash >> 14 & 32767, 22, var3, class35.plane, var6, var7, var0, false, var40.renderable);
                     }
                  }
               }

            } else if(Client.packetType == (Client.RUNELITE_PACKET?48:231)) {
               if(Client.RUNELITE_PACKET) {
                  var0 = Client.secretPacketBuffer2.runeliteReadInt();
                  var3 = Client.secretPacketBuffer2.runeliteReadInt();
                  var7 = Client.secretPacketBuffer2.runeliteReadInt();
                  var1 = (var0 >> 4 & 7) + TextureProvider.field1788;
                  var2 = (var0 & 7) + class34.field498;
                  var4 = var3 >> 2;
                  var5 = var3 & 3;
                  var6 = Client.field999[var4];
               } else {
                  var0 = Client.secretPacketBuffer2.readUnsignedByte();
                  var1 = (var0 >> 4 & 7) + TextureProvider.field1788;
                  var2 = (var0 & 7) + class34.field498;
                  var3 = Client.secretPacketBuffer2.method3201();
                  var4 = var3 >> 2;
                  var5 = var3 & 3;
                  var6 = Client.field999[var4];
                  var7 = Client.secretPacketBuffer2.method3209();
               }

               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  class253.method4495(class35.plane, var1, var2, var6, var7, var4, var5, 0, -1);
               }

            } else if(Client.packetType == (Client.RUNELITE_PACKET?52:212)) {
               if(Client.RUNELITE_PACKET) {
                  var0 = Client.secretPacketBuffer2.runeliteReadInt();
                  var4 = Client.secretPacketBuffer2.runeliteReadInt();
                  var3 = Client.secretPacketBuffer2.runeliteReadInt();
                  var1 = (var0 >> 4 & 7) + TextureProvider.field1788;
                  var2 = (var0 & 7) + class34.field498;
               } else {
                  var0 = Client.secretPacketBuffer2.readUnsignedByte();
                  var1 = (var0 >> 4 & 7) + TextureProvider.field1788;
                  var2 = (var0 & 7) + class34.field498;
                  var3 = Client.secretPacketBuffer2.readUnsignedShort();
                  var4 = Client.secretPacketBuffer2.readUnsignedShort();
               }

               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  var30 = new Item();
                  var30.id = var4;
                  var30.quantity = var3;
                  if(Client.groundItemDeque[class35.plane][var1][var2] == null) {
                     Client.groundItemDeque[class35.plane][var1][var2] = new Deque();
                  }

                  Client.groundItemDeque[class35.plane][var1][var2].addFront(var30);
                  class209.groundItemSpawned(var1, var2);
               }

            } else {
               int var8;
               if(Client.packetType == (Client.RUNELITE_PACKET?58:92)) {
                  if(Client.RUNELITE_PACKET) {
                     var0 = Client.secretPacketBuffer2.runeliteReadInt();
                     var4 = Client.secretPacketBuffer2.runeliteReadInt();
                     var3 = Client.secretPacketBuffer2.runeliteReadInt();
                     var7 = Client.secretPacketBuffer2.runeliteReadInt();
                     var1 = (var0 >> 4 & 7) + TextureProvider.field1788;
                     var2 = (var0 & 7) + class34.field498;
                     var5 = var4 >> 4 & 15;
                     var6 = var4 & 7;
                  } else {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + TextureProvider.field1788;
                     var2 = (var0 & 7) + class34.field498;
                     var3 = Client.secretPacketBuffer2.readUnsignedShort();
                     var4 = Client.secretPacketBuffer2.readUnsignedByte();
                     var5 = var4 >> 4 & 15;
                     var6 = var4 & 7;
                     var7 = Client.secretPacketBuffer2.readUnsignedByte();
                  }

                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var8 = var5 + 1;
                     if(XGrandExchangeOffer.localPlayer.pathX[0] >= var1 - var8 && XGrandExchangeOffer.localPlayer.pathX[0] <= var8 + var1 && XGrandExchangeOffer.localPlayer.pathY[0] >= var2 - var8 && XGrandExchangeOffer.localPlayer.pathY[0] <= var2 + var8 && Client.field1148 != 0 && var6 > 0 && Client.field1166 < 50) {
                        Client.field1167[Client.field1166] = var3;
                        Client.field1168[Client.field1166] = var6;
                        Client.field1169[Client.field1166] = var7;
                        Client.audioEffects[Client.field1166] = null;
                        Client.field1170[Client.field1166] = var5 + (var2 << 8) + (var1 << 16);
                        ++Client.field1166;
                     }
                  }

               } else if(Client.packetType == (Client.RUNELITE_PACKET?59:156)) {
                  if(Client.RUNELITE_PACKET) {
                     var0 = Client.secretPacketBuffer2.runeliteReadInt();
                     var3 = Client.secretPacketBuffer2.runeliteReadInt();
                     var4 = Client.secretPacketBuffer2.runeliteReadInt();
                     var5 = Client.secretPacketBuffer2.runeliteReadInt();
                     var1 = (var0 >> 4 & 7) + TextureProvider.field1788;
                     var2 = (var0 & 7) + class34.field498;
                  } else {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + TextureProvider.field1788;
                     var2 = (var0 & 7) + class34.field498;
                     var3 = Client.secretPacketBuffer2.readUnsignedShort();
                     var4 = Client.secretPacketBuffer2.readUnsignedByte();
                     var5 = Client.secretPacketBuffer2.readUnsignedShort();
                  }

                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var1 = var1 * 128 + 64;
                     var2 = var2 * 128 + 64;
                     GraphicsObject var41 = new GraphicsObject(var3, class35.plane, var1, var2, class25.getTileHeight(var1, var2, class35.plane) - var4, var5, Client.gameCycle);
                     Client.graphicsObjectDeque.addFront(var41);
                  }

               } else if(Client.packetType == (Client.RUNELITE_PACKET?62:115)) {
                  if(Client.RUNELITE_PACKET) {
                     var0 = Client.secretPacketBuffer2.runeliteReadInt();
                     var3 = Client.secretPacketBuffer2.runeliteReadInt();
                     var4 = Client.secretPacketBuffer2.runeliteReadInt();
                     var5 = Client.secretPacketBuffer2.runeliteReadInt();
                     var1 = (var0 >> 4 & 7) + TextureProvider.field1788;
                     var2 = (var0 & 7) + class34.field498;
                  } else {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + TextureProvider.field1788;
                     var2 = (var0 & 7) + class34.field498;
                     var3 = Client.secretPacketBuffer2.readUnsignedShort();
                     var4 = Client.secretPacketBuffer2.readUnsignedShort();
                     var5 = Client.secretPacketBuffer2.readUnsignedShort();
                  }

                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     Deque var33 = Client.groundItemDeque[class35.plane][var1][var2];
                     if(var33 != null) {
                        for(Item var34 = (Item)var33.getFront(); var34 != null; var34 = (Item)var33.getNext()) {
                           if((var3 & 32767) == var34.id && var4 == var34.quantity) {
                              var34.quantity = var5;
                              break;
                           }
                        }

                        class209.groundItemSpawned(var1, var2);
                     }
                  }

               } else {
                  int var10;
                  int var11;
                  int var12;
                  if(Client.packetType == (Client.RUNELITE_PACKET?75:73)) {
                     byte var14;
                     int var32;
                     byte var35;
                     byte var36;
                     byte var37;
                     if(Client.RUNELITE_PACKET) {
                        var2 = Client.secretPacketBuffer2.runeliteReadInt();
                        var10 = Client.secretPacketBuffer2.runeliteReadInt();
                        var32 = Client.secretPacketBuffer2.runeliteReadInt();
                        var7 = Client.secretPacketBuffer2.runeliteReadInt();
                        var35 = Client.secretPacketBuffer2.runeliteReadByte();
                        var36 = Client.secretPacketBuffer2.runeliteReadByte();
                        var6 = Client.secretPacketBuffer2.runeliteReadInt();
                        var8 = Client.secretPacketBuffer2.runeliteReadInt();
                        var37 = Client.secretPacketBuffer2.runeliteReadByte();
                        var14 = Client.secretPacketBuffer2.runeliteReadByte();
                        var3 = var2 >> 2;
                        var4 = var2 & 3;
                        var5 = Client.field999[var3];
                        var11 = (var10 >> 4 & 7) + TextureProvider.field1788;
                        var12 = (var10 & 7) + class34.field498;
                     } else {
                        var35 = Client.secretPacketBuffer2.method3204();
                        var36 = Client.secretPacketBuffer2.readByte();
                        var2 = Client.secretPacketBuffer2.readUnsignedShortOb1();
                        var3 = var2 >> 2;
                        var4 = var2 & 3;
                        var5 = Client.field999[var3];
                        var6 = Client.secretPacketBuffer2.method3329();
                        var7 = Client.secretPacketBuffer2.readUnsignedShort();
                        var8 = Client.secretPacketBuffer2.method3329();
                        var37 = Client.secretPacketBuffer2.method3345();
                        var10 = Client.secretPacketBuffer2.readUnsignedByte();
                        var11 = (var10 >> 4 & 7) + TextureProvider.field1788;
                        var12 = (var10 & 7) + class34.field498;
                        var32 = Client.secretPacketBuffer2.method3329();
                        var14 = Client.secretPacketBuffer2.method3204();
                     }

                     Player var15;
                     if(var32 == Client.localInteractingIndex) {
                        var15 = XGrandExchangeOffer.localPlayer;
                     } else {
                        var15 = Client.cachedPlayers[var32];
                     }

                     if(var15 != null) {
                        ObjectComposition var16 = class37.getObjectDefinition(var7);
                        int var17;
                        int var18;
                        if(var4 != 1 && var4 != 3) {
                           var17 = var16.sizeX;
                           var18 = var16.sizeY;
                        } else {
                           var17 = var16.sizeY;
                           var18 = var16.sizeX;
                        }

                        int var19 = var11 + (var17 >> 1);
                        int var20 = (var17 + 1 >> 1) + var11;
                        int var21 = var12 + (var18 >> 1);
                        int var22 = var12 + (var18 + 1 >> 1);
                        int[][] var23 = class61.tileHeights[class35.plane];
                        int var24 = var23[var20][var21] + var23[var19][var21] + var23[var19][var22] + var23[var20][var22] >> 2;
                        int var25 = (var11 << 7) + (var17 << 6);
                        int var26 = (var12 << 7) + (var18 << 6);
                        Model var27 = var16.method4560(var3, var4, var23, var25, var24, var26);
                        if(var27 != null) {
                           class253.method4495(class35.plane, var11, var12, var5, -1, 0, 0, var6 + 1, var8 + 1);
                           var15.field905 = var6 + Client.gameCycle;
                           var15.field906 = var8 + Client.gameCycle;
                           var15.model = var27;
                           var15.field907 = var17 * 64 + var11 * 128;
                           var15.field911 = var12 * 128 + var18 * 64;
                           var15.field908 = var24;
                           byte var28;
                           if(var14 > var37) {
                              var28 = var14;
                              var14 = var37;
                              var37 = var28;
                           }

                           if(var36 > var35) {
                              var28 = var36;
                              var36 = var35;
                              var35 = var28;
                           }

                           var15.field901 = var14 + var11;
                           var15.field919 = var37 + var11;
                           var15.field920 = var36 + var12;
                           var15.field923 = var12 + var35;
                        }
                     }

                  } else if(Client.packetType == (Client.RUNELITE_PACKET?77:13)) {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + TextureProvider.field1788;
                     var2 = (var0 & 7) + class34.field498;
                     var3 = var1 + Client.secretPacketBuffer2.readByte();
                     var4 = var2 + Client.secretPacketBuffer2.readByte();
                     var5 = Client.secretPacketBuffer2.readShort();
                     var6 = Client.secretPacketBuffer2.readUnsignedShort();
                     var7 = Client.secretPacketBuffer2.readUnsignedByte() * 4;
                     var8 = Client.secretPacketBuffer2.readUnsignedByte() * 4;
                     var9 = Client.secretPacketBuffer2.readUnsignedShort();
                     var10 = Client.secretPacketBuffer2.readUnsignedShort();
                     var11 = Client.secretPacketBuffer2.readUnsignedByte();
                     var12 = Client.secretPacketBuffer2.readUnsignedByte();
                     if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var6 != '\uffff') {
                        var1 = var1 * 128 + 64;
                        var2 = var2 * 128 + 64;
                        var3 = var3 * 128 + 64;
                        var4 = var4 * 128 + 64;
                        Projectile var13 = new Projectile(var6, class35.plane, var1, var2, class25.getTileHeight(var1, var2, class35.plane) - var7, var9 + Client.gameCycle, var10 + Client.gameCycle, var11, var12, var5, var8);
                        var13.method1768(var3, var4, class25.getTileHeight(var3, var4, class35.plane) - var8, var9 + Client.gameCycle);
                        Client.projectiles.addFront(var13);
                     }

                  }
               }
            }
         }
      }
   }
}
