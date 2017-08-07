import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class40 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   public static final class40 field542;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   public static final class40 field535;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   public static final class40 field538;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   public static final class40 field536;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   public static final class40 field539;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   static class47 field541;
   @ObfuscatedName("k")
   public final String field540;

   static {
      field542 = new class40("details");
      field535 = new class40("compositemap");
      field536 = new class40("compositetexture");
      field538 = new class40("area");
      field539 = new class40("labels");
   }

   class40(String var1) {
      this.field540 = var1;
   }

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-95"
   )
   static final void method540() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      if(Client.packetType == (Client.RUNELITE_PACKET?38:191)) {
         if(Client.RUNELITE_PACKET) {
            var0 = Client.secretPacketBuffer2.runeliteReadInt();
            var3 = Client.secretPacketBuffer2.runeliteReadInt();
            var1 = (var0 >> 4 & 7) + GameEngine.field672;
            var2 = (var0 & 7) + class64.field791;
         } else {
            var0 = Client.secretPacketBuffer2.readUnsignedByte();
            var1 = (var0 >> 4 & 7) + GameEngine.field672;
            var2 = (var0 & 7) + class64.field791;
            var3 = Client.secretPacketBuffer2.method3202();
         }

         var4 = var3 >> 2;
         var5 = var3 & 3;
         var6 = Client.field977[var4];
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            Sequence.method4745(class29.plane, var1, var2, var6, -1, var4, var5, 0, -1);
         }

      } else {
         Item var31;
         if(Client.packetType == (Client.RUNELITE_PACKET?39:14)) {
            if(Client.RUNELITE_PACKET) {
               var1 = Client.secretPacketBuffer2.runeliteReadInt();
               var0 = Client.secretPacketBuffer2.runeliteReadInt();
            } else {
               var0 = Client.secretPacketBuffer2.method3212();
               var1 = Client.secretPacketBuffer2.method3202();
            }

            var2 = (var1 >> 4 & 7) + GameEngine.field672;
            var3 = (var1 & 7) + class64.field791;
            if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
               Deque var30 = Client.groundItemDeque[class29.plane][var2][var3];
               if(var30 != null) {
                  for(var31 = (Item)var30.getFront(); var31 != null; var31 = (Item)var30.getNext()) {
                     if((var0 & 32767) == var31.id) {
                        var31.unlink();
                        break;
                     }
                  }

                  if(var30.getFront() == null) {
                     Client.groundItemDeque[class29.plane][var2][var3] = null;
                  }

                  class35.groundItemSpawned(var2, var3);
               }
            }

         } else {
            int var7;
            int var9;
            if(Client.packetType == (Client.RUNELITE_PACKET?46:101)) {
               if(Client.RUNELITE_PACKET) {
                  var0 = Client.secretPacketBuffer2.runeliteReadInt();
                  var5 = Client.secretPacketBuffer2.runeliteReadInt();
                  var4 = Client.secretPacketBuffer2.runeliteReadInt();
                  var1 = var0 >> 2;
                  var2 = var0 & 3;
                  var3 = Client.field977[var1];
               } else {
                  var0 = Client.secretPacketBuffer2.method3203();
                  var1 = var0 >> 2;
                  var2 = var0 & 3;
                  var3 = Client.field977[var1];
                  var4 = Client.secretPacketBuffer2.method3212();
                  var5 = Client.secretPacketBuffer2.readUnsignedByte();
               }

               var6 = (var5 >> 4 & 7) + GameEngine.field672;
               var7 = (var5 & 7) + class64.field791;
               if(var6 >= 0 && var7 >= 0 && var6 < 103 && var7 < 103) {
                  if(var3 == 0) {
                     WallObject var8 = class84.region.method2733(class29.plane, var6, var7);
                     if(var8 != null) {
                        var9 = var8.hash >> 14 & 32767;
                        if(var1 == 2) {
                           var8.renderable1 = new DynamicObject(var9, 2, var2 + 4, class29.plane, var6, var7, var4, false, var8.renderable1);
                           var8.renderable2 = new DynamicObject(var9, 2, var2 + 1 & 3, class29.plane, var6, var7, var4, false, var8.renderable2);
                        } else {
                           var8.renderable1 = new DynamicObject(var9, var1, var2, class29.plane, var6, var7, var4, false, var8.renderable1);
                        }
                     }
                  }

                  if(var3 == 1) {
                     DecorativeObject var36 = class84.region.method2734(class29.plane, var6, var7);
                     if(var36 != null) {
                        var9 = var36.hash >> 14 & 32767;
                        if(var1 != 4 && var1 != 5) {
                           if(var1 == 6) {
                              var36.renderable1 = new DynamicObject(var9, 4, var2 + 4, class29.plane, var6, var7, var4, false, var36.renderable1);
                           } else if(var1 == 7) {
                              var36.renderable1 = new DynamicObject(var9, 4, (var2 + 2 & 3) + 4, class29.plane, var6, var7, var4, false, var36.renderable1);
                           } else if(var1 == 8) {
                              var36.renderable1 = new DynamicObject(var9, 4, var2 + 4, class29.plane, var6, var7, var4, false, var36.renderable1);
                              var36.renderable2 = new DynamicObject(var9, 4, (var2 + 2 & 3) + 4, class29.plane, var6, var7, var4, false, var36.renderable2);
                           }
                        } else {
                           var36.renderable1 = new DynamicObject(var9, 4, var2, class29.plane, var6, var7, var4, false, var36.renderable1);
                        }
                     }
                  }

                  if(var3 == 2) {
                     GameObject var37 = class84.region.method2885(class29.plane, var6, var7);
                     if(var1 == 11) {
                        var1 = 10;
                     }

                     if(var37 != null) {
                        var37.renderable = new DynamicObject(var37.hash >> 14 & 32767, var1, var2, class29.plane, var6, var7, var4, false, var37.renderable);
                     }
                  }

                  if(var3 == 3) {
                     GroundObject var38 = class84.region.method2735(class29.plane, var6, var7);
                     if(var38 != null) {
                        var38.renderable = new DynamicObject(var38.hash >> 14 & 32767, 22, var2, class29.plane, var6, var7, var4, false, var38.renderable);
                     }
                  }
               }

            } else if(Client.packetType == (Client.RUNELITE_PACKET?48:245)) {
               if(Client.RUNELITE_PACKET) {
                  var0 = Client.secretPacketBuffer2.runeliteReadInt();
                  var4 = Client.secretPacketBuffer2.runeliteReadInt();
                  var3 = Client.secretPacketBuffer2.runeliteReadInt();
                  var1 = (var0 >> 4 & 7) + GameEngine.field672;
                  var2 = (var0 & 7) + class64.field791;
               } else {
                  var0 = Client.secretPacketBuffer2.readUnsignedShortOb1();
                  var1 = (var0 >> 4 & 7) + GameEngine.field672;
                  var2 = (var0 & 7) + class64.field791;
                  var3 = Client.secretPacketBuffer2.readUnsignedShort();
                  var4 = Client.secretPacketBuffer2.method3203();
               }

               var5 = var4 >> 2;
               var6 = var4 & 3;
               var7 = Client.field977[var5];
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  Sequence.method4745(class29.plane, var1, var2, var7, var3, var5, var6, 0, -1);
               }

            } else if(Client.packetType == (Client.RUNELITE_PACKET?52:215)) {
               if(Client.RUNELITE_PACKET) {
                  var1 = Client.secretPacketBuffer2.runeliteReadInt();
                  var4 = Client.secretPacketBuffer2.runeliteReadInt();
                  var0 = Client.secretPacketBuffer2.runeliteReadInt();
                  var2 = (var1 >> 4 & 7) + GameEngine.field672;
                  var3 = (var1 & 7) + class64.field791;
               } else {
                  var0 = Client.secretPacketBuffer2.method3337();
                  var1 = Client.secretPacketBuffer2.method3203();
                  var2 = (var1 >> 4 & 7) + GameEngine.field672;
                  var3 = (var1 & 7) + class64.field791;
                  var4 = Client.secretPacketBuffer2.method3337();
               }

               if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
                  var31 = new Item();
                  var31.id = var4;
                  var31.quantity = var0;
                  if(Client.groundItemDeque[class29.plane][var2][var3] == null) {
                     Client.groundItemDeque[class29.plane][var2][var3] = new Deque();
                  }

                  Client.groundItemDeque[class29.plane][var2][var3].addFront(var31);
                  class35.groundItemSpawned(var2, var3);
               }

            } else {
               int var33;
               if(Client.packetType == (Client.RUNELITE_PACKET?58:62)) {
                  if(Client.RUNELITE_PACKET) {
                     var0 = Client.secretPacketBuffer2.runeliteReadInt();
                     var4 = Client.secretPacketBuffer2.runeliteReadInt();
                     var3 = Client.secretPacketBuffer2.runeliteReadInt();
                     var7 = Client.secretPacketBuffer2.runeliteReadInt();
                     var1 = (var0 >> 4 & 7) + GameEngine.field672;
                     var2 = (var0 & 7) + class64.field791;
                     var5 = var4 >> 4 & 15;
                     var6 = var4 & 7;
                  } else {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + GameEngine.field672;
                     var2 = (var0 & 7) + class64.field791;
                     var3 = Client.secretPacketBuffer2.readUnsignedShort();
                     var4 = Client.secretPacketBuffer2.readUnsignedByte();
                     var5 = var4 >> 4 & 15;
                     var6 = var4 & 7;
                     var7 = Client.secretPacketBuffer2.readUnsignedByte();
                  }

                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var33 = var5 + 1;
                     if(class54.localPlayer.pathX[0] >= var1 - var33 && class54.localPlayer.pathX[0] <= var33 + var1 && class54.localPlayer.pathY[0] >= var2 - var33 && class54.localPlayer.pathY[0] <= var2 + var33 && Client.field1143 != 0 && var6 > 0 && Client.field1144 < 50) {
                        Client.field1175[Client.field1144] = var3;
                        Client.field1146[Client.field1144] = var6;
                        Client.field1147[Client.field1144] = var7;
                        Client.audioEffects[Client.field1144] = null;
                        Client.field1148[Client.field1144] = var5 + (var2 << 8) + (var1 << 16);
                        ++Client.field1144;
                     }
                  }

               } else if(Client.packetType == (Client.RUNELITE_PACKET?59:37)) {
                  if(Client.RUNELITE_PACKET) {
                     var0 = Client.secretPacketBuffer2.runeliteReadInt();
                     var3 = Client.secretPacketBuffer2.runeliteReadInt();
                     var4 = Client.secretPacketBuffer2.runeliteReadInt();
                     var5 = Client.secretPacketBuffer2.runeliteReadInt();
                     var1 = (var0 >> 4 & 7) + GameEngine.field672;
                     var2 = (var0 & 7) + class64.field791;
                  } else {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + GameEngine.field672;
                     var2 = (var0 & 7) + class64.field791;
                     var3 = Client.secretPacketBuffer2.readUnsignedShort();
                     var4 = Client.secretPacketBuffer2.readUnsignedByte();
                     var5 = Client.secretPacketBuffer2.readUnsignedShort();
                  }

                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var1 = var1 * 128 + 64;
                     var2 = 64 + var2 * 128;
                     GraphicsObject var39 = new GraphicsObject(var3, class29.plane, var1, var2, Friend.getTileHeight(var1, var2, class29.plane) - var4, var5, Client.gameCycle);
                     Client.graphicsObjectDeque.addFront(var39);
                  }

               } else if(Client.packetType == (Client.RUNELITE_PACKET?62:1)) {
                  if(Client.RUNELITE_PACKET) {
                     var0 = Client.secretPacketBuffer2.runeliteReadInt();
                     var3 = Client.secretPacketBuffer2.runeliteReadInt();
                     var4 = Client.secretPacketBuffer2.runeliteReadInt();
                     var5 = Client.secretPacketBuffer2.runeliteReadInt();
                     var1 = (var0 >> 4 & 7) + GameEngine.field672;
                     var2 = (var0 & 7) + class64.field791;
                  } else {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + GameEngine.field672;
                     var2 = (var0 & 7) + class64.field791;
                     var3 = Client.secretPacketBuffer2.readUnsignedShort();
                     var4 = Client.secretPacketBuffer2.readUnsignedShort();
                     var5 = Client.secretPacketBuffer2.readUnsignedShort();
                  }

                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     Deque var29 = Client.groundItemDeque[class29.plane][var1][var2];
                     if(var29 != null) {
                        for(Item var32 = (Item)var29.getFront(); var32 != null; var32 = (Item)var29.getNext()) {
                           if((var3 & 32767) == var32.id && var4 == var32.quantity) {
                              var32.quantity = var5;
                              break;
                           }
                        }

                        class35.groundItemSpawned(var1, var2);
                     }
                  }

               } else {
                  int var10;
                  int var11;
                  int var12;
                  if(Client.packetType == (Client.RUNELITE_PACKET?75:224)) {
                     byte var13;
                     byte var14;
                     byte var35;
                     byte var40;
                     if(Client.RUNELITE_PACKET) {
                        var4 = Client.secretPacketBuffer2.runeliteReadInt();
                        var9 = Client.secretPacketBuffer2.runeliteReadInt();
                        var7 = Client.secretPacketBuffer2.runeliteReadInt();
                        var2 = Client.secretPacketBuffer2.runeliteReadInt();
                        var0 = Client.secretPacketBuffer2.runeliteReadInt();
                        var1 = Client.secretPacketBuffer2.runeliteReadInt();
                        var35 = Client.secretPacketBuffer2.runeliteReadByte();
                        var40 = Client.secretPacketBuffer2.runeliteReadByte();
                        var13 = Client.secretPacketBuffer2.runeliteReadByte();
                        var14 = Client.secretPacketBuffer2.runeliteReadByte();
                        var5 = (var4 >> 4 & 7) + GameEngine.field672;
                        var6 = (var4 & 7) + class64.field791;
                        var10 = var9 >> 2;
                        var11 = var9 & 3;
                        var12 = Client.field977[var10];
                     } else {
                        var0 = Client.secretPacketBuffer2.method3213();
                        var1 = Client.secretPacketBuffer2.method3213();
                        var2 = Client.secretPacketBuffer2.method3213();
                        var35 = Client.secretPacketBuffer2.readByte();
                        var4 = Client.secretPacketBuffer2.readUnsignedByte();
                        var5 = (var4 >> 4 & 7) + GameEngine.field672;
                        var6 = (var4 & 7) + class64.field791;
                        var7 = Client.secretPacketBuffer2.readUnsignedShort();
                        var40 = Client.secretPacketBuffer2.method3303();
                        var9 = Client.secretPacketBuffer2.readUnsignedByte();
                        var10 = var9 >> 2;
                        var11 = var9 & 3;
                        var12 = Client.field977[var10];
                        var13 = Client.secretPacketBuffer2.method3206();
                        var14 = Client.secretPacketBuffer2.method3207();
                     }

                     Player var15;
                     if(var7 == Client.localInteractingIndex) {
                        var15 = class54.localPlayer;
                     } else {
                        var15 = Client.cachedPlayers[var7];
                     }

                     if(var15 != null) {
                        ObjectComposition var16 = WorldMapType1.getObjectDefinition(var2);
                        int var17;
                        int var18;
                        if(var11 != 1 && var11 != 3) {
                           var17 = var16.sizeX;
                           var18 = var16.sizeY;
                        } else {
                           var17 = var16.sizeY;
                           var18 = var16.sizeX;
                        }

                        int var19 = var5 + (var17 >> 1);
                        int var20 = var5 + (var17 + 1 >> 1);
                        int var21 = var6 + (var18 >> 1);
                        int var22 = var6 + (var18 + 1 >> 1);
                        int[][] var23 = class61.tileHeights[class29.plane];
                        int var24 = var23[var20][var22] + var23[var19][var22] + var23[var19][var21] + var23[var20][var21] >> 2;
                        int var25 = (var5 << 7) + (var17 << 6);
                        int var26 = (var6 << 7) + (var18 << 6);
                        Model var27 = var16.method4539(var10, var11, var23, var25, var24, var26);
                        if(var27 != null) {
                           Sequence.method4745(class29.plane, var5, var6, var12, -1, 0, 0, var1 + 1, var0 + 1);
                           var15.field883 = var1 + Client.gameCycle;
                           var15.field881 = var0 + Client.gameCycle;
                           var15.model = var27;
                           var15.field889 = var17 * 64 + var5 * 128;
                           var15.field891 = var18 * 64 + var6 * 128;
                           var15.field890 = var24;
                           byte var28;
                           if(var35 > var40) {
                              var28 = var35;
                              var35 = var40;
                              var40 = var28;
                           }

                           if(var13 > var14) {
                              var28 = var13;
                              var13 = var14;
                              var14 = var28;
                           }

                           var15.field903 = var35 + var5;
                           var15.field879 = var5 + var40;
                           var15.field894 = var6 + var13;
                           var15.field887 = var6 + var14;
                        }
                     }

                  } else if(Client.packetType == (Client.RUNELITE_PACKET?77:3)) {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + GameEngine.field672;
                     var2 = (var0 & 7) + class64.field791;
                     var3 = var1 + Client.secretPacketBuffer2.readByte();
                     var4 = var2 + Client.secretPacketBuffer2.readByte();
                     var5 = Client.secretPacketBuffer2.readShort();
                     var6 = Client.secretPacketBuffer2.readUnsignedShort();
                     var7 = Client.secretPacketBuffer2.readUnsignedByte() * 4;
                     var33 = Client.secretPacketBuffer2.readUnsignedByte() * 4;
                     var9 = Client.secretPacketBuffer2.readUnsignedShort();
                     var10 = Client.secretPacketBuffer2.readUnsignedShort();
                     var11 = Client.secretPacketBuffer2.readUnsignedByte();
                     var12 = Client.secretPacketBuffer2.readUnsignedByte();
                     if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var6 != '\uffff') {
                        var1 = var1 * 128 + 64;
                        var2 = var2 * 128 + 64;
                        var3 = var3 * 128 + 64;
                        var4 = var4 * 128 + 64;
                        Projectile var34 = new Projectile(var6, class29.plane, var1, var2, Friend.getTileHeight(var1, var2, class29.plane) - var7, var9 + Client.gameCycle, var10 + Client.gameCycle, var11, var12, var5, var33);
                        var34.method1792(var3, var4, Friend.getTileHeight(var3, var4, class29.plane) - var33, var9 + Client.gameCycle);
                        Client.projectiles.addFront(var34);
                     }

                  }
               }
            }
         }
      }
   }
}
