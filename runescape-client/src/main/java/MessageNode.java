import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("og")
   @ObfuscatedSignature(
      signature = "Ldi;"
   )
   @Export("soundSystem1")
   static AbstractSoundSystem soundSystem1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1451836321
   )
   @Export("id")
   int id;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 351966103
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -970738499
   )
   @Export("type")
   int type;
   @ObfuscatedName("u")
   @Export("name")
   String name;
   @ObfuscatedName("g")
   @Export("sender")
   String sender;
   @ObfuscatedName("m")
   @Export(
      value = "value",
      setter = true
   )
   String value;

   @Hook("setMessage")
   MessageNode(int var1, String var2, String var3, String var4) {
      int var5 = ++class98.field1496 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1505673459"
   )
   @Export("setMessage")
   @Hook("setMessage")
   void setMessage(int var1, String var2, String var3, String var4) {
      int var5 = ++class98.field1496 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1628405774"
   )
   static String method1060(int var0) {
      return var0 < 0?"":(Client.menuTargets[var0].length() > 0?Client.menuOptions[var0] + " " + Client.menuTargets[var0]:Client.menuOptions[var0]);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-411576377"
   )
   public static void method1062() {
      Object var0 = class236.field3203;
      synchronized(class236.field3203) {
         if(class236.field3205 != 0) {
            class236.field3205 = 1;

            try {
               class236.field3203.wait();
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-39"
   )
   static final void method1063() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      if(Client.packetType == 45) {
         var0 = Client.secretPacketBuffer2.readUnsignedByte();
         var1 = var0 >> 2;
         var2 = var0 & 3;
         var3 = Client.field978[var1];
         var4 = Client.secretPacketBuffer2.method3280();
         var5 = (var4 >> 4 & 7) + World.field1293;
         var6 = (var4 & 7) + Signlink.field2193;
         if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
            Client.method1268(class10.plane, var5, var6, var3, -1, var1, var2, 0, -1);
         }

      } else {
         Item var32;
         if(Client.packetType == 240) {
            var0 = Client.secretPacketBuffer2.readUnsignedByte();
            var1 = (var0 >> 4 & 7) + World.field1293;
            var2 = (var0 & 7) + Signlink.field2193;
            var3 = Client.secretPacketBuffer2.method3132();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               Deque var31 = Client.groundItemDeque[class10.plane][var1][var2];
               if(var31 != null) {
                  for(var32 = (Item)var31.getFront(); var32 != null; var32 = (Item)var31.getNext()) {
                     if((var3 & 32767) == var32.id) {
                        var32.unlink();
                        break;
                     }
                  }

                  if(var31.getFront() == null) {
                     Client.groundItemDeque[class10.plane][var1][var2] = null;
                  }

                  ChatLineBuffer.groundItemSpawned(var1, var2);
               }
            }

         } else {
            int var9;
            int var30;
            if(Client.packetType == 76) {
               var0 = Client.secretPacketBuffer2.method3124();
               var1 = var0 >> 2;
               var2 = var0 & 3;
               var3 = Client.field978[var1];
               var4 = Client.secretPacketBuffer2.method3132();
               var5 = Client.secretPacketBuffer2.readUnsignedByte();
               var6 = (var5 >> 4 & 7) + World.field1293;
               var30 = (var5 & 7) + Signlink.field2193;
               if(var6 >= 0 && var30 >= 0 && var6 < 103 && var30 < 103) {
                  if(var3 == 0) {
                     WallObject var8 = class19.region.method2639(class10.plane, var6, var30);
                     if(var8 != null) {
                        var9 = var8.hash >> 14 & 32767;
                        if(var1 == 2) {
                           var8.renderable1 = new DynamicObject(var9, 2, var2 + 4, class10.plane, var6, var30, var4, false, var8.renderable1);
                           var8.renderable2 = new DynamicObject(var9, 2, var2 + 1 & 3, class10.plane, var6, var30, var4, false, var8.renderable2);
                        } else {
                           var8.renderable1 = new DynamicObject(var9, var1, var2, class10.plane, var6, var30, var4, false, var8.renderable1);
                        }
                     }
                  }

                  if(var3 == 1) {
                     DecorativeObject var37 = class19.region.method2640(class10.plane, var6, var30);
                     if(var37 != null) {
                        var9 = var37.hash >> 14 & 32767;
                        if(var1 != 4 && var1 != 5) {
                           if(var1 == 6) {
                              var37.renderable1 = new DynamicObject(var9, 4, var2 + 4, class10.plane, var6, var30, var4, false, var37.renderable1);
                           } else if(var1 == 7) {
                              var37.renderable1 = new DynamicObject(var9, 4, (var2 + 2 & 3) + 4, class10.plane, var6, var30, var4, false, var37.renderable1);
                           } else if(var1 == 8) {
                              var37.renderable1 = new DynamicObject(var9, 4, var2 + 4, class10.plane, var6, var30, var4, false, var37.renderable1);
                              var37.renderable2 = new DynamicObject(var9, 4, (var2 + 2 & 3) + 4, class10.plane, var6, var30, var4, false, var37.renderable2);
                           }
                        } else {
                           var37.renderable1 = new DynamicObject(var9, 4, var2, class10.plane, var6, var30, var4, false, var37.renderable1);
                        }
                     }
                  }

                  if(var3 == 2) {
                     GameObject var38 = class19.region.method2641(class10.plane, var6, var30);
                     if(var1 == 11) {
                        var1 = 10;
                     }

                     if(var38 != null) {
                        var38.renderable = new DynamicObject(var38.hash >> 14 & 32767, var1, var2, class10.plane, var6, var30, var4, false, var38.renderable);
                     }
                  }

                  if(var3 == 3) {
                     GroundObject var39 = class19.region.method2618(class10.plane, var6, var30);
                     if(var39 != null) {
                        var39.renderable = new DynamicObject(var39.hash >> 14 & 32767, 22, var2, class10.plane, var6, var30, var4, false, var39.renderable);
                     }
                  }
               }

            } else if(Client.packetType == 157) {
               var0 = Client.secretPacketBuffer2.readUnsignedShort();
               var1 = Client.secretPacketBuffer2.method3124();
               var2 = var1 >> 2;
               var3 = var1 & 3;
               var4 = Client.field978[var2];
               var5 = Client.secretPacketBuffer2.method3280();
               var6 = (var5 >> 4 & 7) + World.field1293;
               var30 = (var5 & 7) + Signlink.field2193;
               if(var6 >= 0 && var30 >= 0 && var6 < 104 && var30 < 104) {
                  Client.method1268(class10.plane, var6, var30, var4, var0, var2, var3, 0, -1);
               }

            } else if(Client.packetType == 153) {
               var0 = Client.secretPacketBuffer2.readUnsignedShort();
               var1 = Client.secretPacketBuffer2.readByteOb1();
               var2 = Client.secretPacketBuffer2.readUnsignedByte();
               var3 = (var2 >> 4 & 7) + World.field1293;
               var4 = (var2 & 7) + Signlink.field2193;
               if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                  var32 = new Item();
                  var32.id = var1;
                  var32.quantity = var0;
                  if(Client.groundItemDeque[class10.plane][var3][var4] == null) {
                     Client.groundItemDeque[class10.plane][var3][var4] = new Deque();
                  }

                  Client.groundItemDeque[class10.plane][var3][var4].addFront(var32);
                  ChatLineBuffer.groundItemSpawned(var3, var4);
               }

            } else {
               int var33;
               if(Client.packetType == 239) {
                  var0 = Client.secretPacketBuffer2.readUnsignedByte();
                  var1 = (var0 >> 4 & 7) + World.field1293;
                  var2 = (var0 & 7) + Signlink.field2193;
                  var3 = Client.secretPacketBuffer2.readUnsignedShort();
                  var4 = Client.secretPacketBuffer2.readUnsignedByte();
                  var5 = var4 >> 4 & 15;
                  var6 = var4 & 7;
                  var30 = Client.secretPacketBuffer2.readUnsignedByte();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var33 = var5 + 1;
                     if(class226.localPlayer.pathX[0] >= var1 - var33 && class226.localPlayer.pathX[0] <= var33 + var1 && class226.localPlayer.pathY[0] >= var2 - var33 && class226.localPlayer.pathY[0] <= var33 + var2 && Client.field1035 != 0 && var6 > 0 && Client.field935 < 50) {
                        Client.field1081[Client.field935] = var3;
                        Client.field1151[Client.field935] = var6;
                        Client.field1010[Client.field935] = var30;
                        Client.audioEffects[Client.field935] = null;
                        Client.field1148[Client.field935] = var5 + (var1 << 16) + (var2 << 8);
                        ++Client.field935;
                     }
                  }

               } else if(Client.packetType == 234) {
                  var0 = Client.secretPacketBuffer2.readUnsignedByte();
                  var1 = (var0 >> 4 & 7) + World.field1293;
                  var2 = (var0 & 7) + Signlink.field2193;
                  var3 = Client.secretPacketBuffer2.readUnsignedShort();
                  var4 = Client.secretPacketBuffer2.readUnsignedByte();
                  var5 = Client.secretPacketBuffer2.readUnsignedShort();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var1 = var1 * 128 + 64;
                     var2 = var2 * 128 + 64;
                     GraphicsObject var41 = new GraphicsObject(var3, class10.plane, var1, var2, class23.getTileHeight(var1, var2, class10.plane) - var4, var5, Client.gameCycle);
                     Client.graphicsObjectDeque.addFront(var41);
                  }

               } else if(Client.packetType == 23) {
                  var0 = Client.secretPacketBuffer2.readUnsignedByte();
                  var1 = (var0 >> 4 & 7) + World.field1293;
                  var2 = (var0 & 7) + Signlink.field2193;
                  var3 = Client.secretPacketBuffer2.readUnsignedShort();
                  var4 = Client.secretPacketBuffer2.readUnsignedShort();
                  var5 = Client.secretPacketBuffer2.readUnsignedShort();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     Deque var29 = Client.groundItemDeque[class10.plane][var1][var2];
                     if(var29 != null) {
                        for(Item var7 = (Item)var29.getFront(); var7 != null; var7 = (Item)var29.getNext()) {
                           if((var3 & 32767) == var7.id && var4 == var7.quantity) {
                              var7.quantity = var5;
                              break;
                           }
                        }

                        ChatLineBuffer.groundItemSpawned(var1, var2);
                     }
                  }

               } else {
                  int var10;
                  int var12;
                  if(Client.packetType == 217) {
                     var0 = Client.secretPacketBuffer2.readUnsignedShort();
                     byte var35 = Client.secretPacketBuffer2.method3298();
                     byte var36 = Client.secretPacketBuffer2.method3298();
                     var3 = Client.secretPacketBuffer2.readByteOb1();
                     var4 = Client.secretPacketBuffer2.method3122();
                     var5 = var4 >> 2;
                     var6 = var4 & 3;
                     var30 = Client.field978[var5];
                     byte var42 = Client.secretPacketBuffer2.method3187();
                     var9 = Client.secretPacketBuffer2.readUnsignedShort();
                     var10 = Client.secretPacketBuffer2.method3132();
                     byte var40 = Client.secretPacketBuffer2.readByte();
                     var12 = Client.secretPacketBuffer2.readUnsignedByte();
                     int var13 = (var12 >> 4 & 7) + World.field1293;
                     int var14 = (var12 & 7) + Signlink.field2193;
                     Player var15;
                     if(var10 == Client.localInteractingIndex) {
                        var15 = class226.localPlayer;
                     } else {
                        var15 = Client.cachedPlayers[var10];
                     }

                     if(var15 != null) {
                        ObjectComposition var16 = class169.getObjectDefinition(var3);
                        int var17;
                        int var18;
                        if(var6 != 1 && var6 != 3) {
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
                        int[][] var23 = class61.tileHeights[class10.plane];
                        int var24 = var23[var20][var22] + var23[var20][var21] + var23[var19][var21] + var23[var19][var22] >> 2;
                        int var25 = (var13 << 7) + (var17 << 6);
                        int var26 = (var14 << 7) + (var18 << 6);
                        Model var27 = var16.method4404(var5, var6, var23, var25, var24, var26);
                        if(var27 != null) {
                           Client.method1268(class10.plane, var13, var14, var30, -1, 0, 0, var0 + 1, var9 + 1);
                           var15.field904 = var0 + Client.gameCycle;
                           var15.field875 = var9 + Client.gameCycle;
                           var15.model = var27;
                           var15.field885 = var13 * 128 + var17 * 64;
                           var15.field876 = 128 * var14 + var18 * 64;
                           var15.field886 = var24;
                           byte var28;
                           if(var35 > var42) {
                              var28 = var35;
                              var35 = var42;
                              var42 = var28;
                           }

                           if(var40 > var36) {
                              var28 = var40;
                              var40 = var36;
                              var36 = var28;
                           }

                           var15.field889 = var13 + var35;
                           var15.field891 = var13 + var42;
                           var15.field890 = var14 + var40;
                           var15.field892 = var14 + var36;
                        }
                     }

                  } else if(Client.packetType == 183) {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + World.field1293;
                     var2 = (var0 & 7) + Signlink.field2193;
                     var3 = var1 + Client.secretPacketBuffer2.readByte();
                     var4 = var2 + Client.secretPacketBuffer2.readByte();
                     var5 = Client.secretPacketBuffer2.readShort();
                     var6 = Client.secretPacketBuffer2.readUnsignedShort();
                     var30 = Client.secretPacketBuffer2.readUnsignedByte() * 4;
                     var33 = Client.secretPacketBuffer2.readUnsignedByte() * 4;
                     var9 = Client.secretPacketBuffer2.readUnsignedShort();
                     var10 = Client.secretPacketBuffer2.readUnsignedShort();
                     int var11 = Client.secretPacketBuffer2.readUnsignedByte();
                     var12 = Client.secretPacketBuffer2.readUnsignedByte();
                     if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var6 != '\uffff') {
                        var1 = var1 * 128 + 64;
                        var2 = var2 * 128 + 64;
                        var3 = 128 * var3 + 64;
                        var4 = var4 * 128 + 64;
                        Projectile var34 = new Projectile(var6, class10.plane, var1, var2, class23.getTileHeight(var1, var2, class10.plane) - var30, var9 + Client.gameCycle, var10 + Client.gameCycle, var11, var12, var5, var33);
                        var34.method1696(var3, var4, class23.getTileHeight(var3, var4, class10.plane) - var33, var9 + Client.gameCycle);
                        Client.projectiles.addFront(var34);
                     }

                  }
               }
            }
         }
      }
   }
}
