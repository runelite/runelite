import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
public class class272 extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   public static IndexDataBase field3481;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static NodeCache field3480;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   IterableHashTable field3482;

   static {
      field3480 = new NodeCache(64);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2077362055"
   )
   public void method4896() {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgn;B)V",
      garbageValue = "57"
   )
   public void method4884(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4883(var1, var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgn;II)V",
      garbageValue = "-276338023"
   )
   void method4883(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3482 = Tile.readStringIntParameters(var1, this.field3482);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2125799939"
   )
   public int method4886(int var1, int var2) {
      IterableHashTable var4 = this.field3482;
      int var3;
      if(var4 == null) {
         var3 = var2;
      } else {
         IntegerNode var5 = (IntegerNode)var4.get((long)var1);
         if(var5 == null) {
            var3 = var2;
         } else {
            var3 = var5.value;
         }
      }

      return var3;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "303146818"
   )
   public String method4887(int var1, String var2) {
      return MouseInput.method1038(this.field3482, var1, var2);
   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(Lgt;S)V",
      garbageValue = "255"
   )
   static final void method4891(class182 var0) {
      PacketBuffer var1 = Client.field863.packetBuffer;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      if(class182.field2452 == var0) {
         var2 = var1.readUnsignedByteNegate();
         var3 = (var2 >> 4 & 7) + MessageNode.field774;
         var4 = (var2 & 7) + class65.field734;
         var5 = var1.method3575();
         var6 = var5 >> 2;
         var7 = var5 & 3;
         var8 = Client.field851[var6];
         var9 = var1.readUnsignedShortOb1();
         if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
            class61.method1055(class230.plane, var3, var4, var8, var9, var6, var7, 0, -1);
         }

      } else if(class182.field2451 == var0) {
         var2 = var1.method3577();
         var3 = var2 >> 2;
         var4 = var2 & 3;
         var5 = Client.field851[var3];
         var6 = var1.method3577();
         var7 = (var6 >> 4 & 7) + MessageNode.field774;
         var8 = (var6 & 7) + class65.field734;
         if(var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104) {
            class61.method1055(class230.plane, var7, var8, var5, -1, var3, var4, 0, -1);
         }

      } else {
         int var10;
         if(class182.field2445 == var0) {
            var2 = var1.method3577();
            var3 = var2 >> 4 & 15;
            var4 = var2 & 7;
            var5 = var1.method3577();
            var6 = var1.readUnsignedShortOb1();
            var7 = var1.readUnsignedByte();
            var8 = (var7 >> 4 & 7) + MessageNode.field774;
            var9 = (var7 & 7) + class65.field734;
            if(var8 >= 0 && var9 >= 0 && var8 < 104 && var9 < 104) {
               var10 = var3 + 1;
               if(OwnWorldComparator.localPlayer.pathX[0] >= var8 - var10 && OwnWorldComparator.localPlayer.pathX[0] <= var8 + var10 && OwnWorldComparator.localPlayer.pathY[0] >= var9 - var10 && OwnWorldComparator.localPlayer.pathY[0] <= var10 + var9 && Client.field1041 != 0 && var4 > 0 && Client.queuedSoundEffectCount < 50) {
                  Client.queuedSoundEffectIDs[Client.queuedSoundEffectCount] = var6;
                  Client.unknownSoundValues1[Client.queuedSoundEffectCount] = var4;
                  Client.unknownSoundValues2[Client.queuedSoundEffectCount] = var5;
                  Client.audioEffects[Client.queuedSoundEffectCount] = null;
                  Client.soundLocations[Client.queuedSoundEffectCount] = var3 + (var9 << 8) + (var8 << 16);
                  ++Client.queuedSoundEffectCount;
               }
            }
         }

         int var12;
         int var13;
         int var14;
         byte var38;
         int var41;
         if(class182.field2448 == var0) {
            var2 = var1.method3577() * 4;
            var3 = var1.method3666();
            byte var39 = var1.method3685();
            var5 = var1.readUnsignedShortOb1();
            var38 = var1.readByte();
            var7 = var1.method3564();
            var8 = var1.method3577();
            var9 = var1.readUnsignedShortOb1();
            var10 = var1.readUnsignedByte();
            var41 = (var10 >> 4 & 7) + MessageNode.field774;
            var12 = (var10 & 7) + class65.field734;
            var13 = var1.readUnsignedByte() * 4;
            var14 = var1.method3575();
            var6 = var38 + var41;
            var4 = var39 + var12;
            if(var41 >= 0 && var12 >= 0 && var41 < 104 && var12 < 104 && var6 >= 0 && var4 >= 0 && var6 < 104 && var4 < 104 && var5 != 65535) {
               var41 = var41 * 128 + 64;
               var12 = var12 * 128 + 64;
               var6 = var6 * 128 + 64;
               var4 = var4 * 128 + 64;
               Projectile var15 = new Projectile(var5, class230.plane, var41, var12, WorldMapType1.getTileHeight(var41, var12, class230.plane) - var2, var9 + Client.gameCycle, var3 + Client.gameCycle, var14, var8, var7, var13);
               var15.moveProjectile(var6, var4, WorldMapType1.getTileHeight(var6, var4, class230.plane) - var13, var9 + Client.gameCycle);
               Client.projectiles.addFront(var15);
            }

         } else {
            Item var31;
            if(class182.field2449 == var0) {
               var2 = var1.method3699();
               var3 = var1.readUnsignedShort();
               var4 = var1.method3575();
               var5 = (var4 >> 4 & 7) + MessageNode.field774;
               var6 = (var4 & 7) + class65.field734;
               if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                  var31 = new Item();
                  var31.id = var3;
                  var31.quantity = var2;
                  if(Client.groundItemDeque[class230.plane][var5][var6] == null) {
                     Client.groundItemDeque[class230.plane][var5][var6] = new Deque();
                  }

                  Client.groundItemDeque[class230.plane][var5][var6].addFront(var31);
                  class22.groundItemSpawned(var5, var6);
               }

            } else if(class182.field2453 == var0) {
               var2 = var1.method3666();
               var3 = var1.readUnsignedByte();
               var4 = (var3 >> 4 & 7) + MessageNode.field774;
               var5 = (var3 & 7) + class65.field734;
               if(var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
                  Deque var32 = Client.groundItemDeque[class230.plane][var4][var5];
                  if(var32 != null) {
                     for(var31 = (Item)var32.getFront(); var31 != null; var31 = (Item)var32.getNext()) {
                        if((var2 & 32767) == var31.id) {
                           var31.unlink();
                           break;
                        }
                     }

                     if(var32.getFront() == null) {
                        Client.groundItemDeque[class230.plane][var4][var5] = null;
                     }

                     class22.groundItemSpawned(var4, var5);
                  }
               }

            } else if(class182.field2456 == var0) {
               var2 = var1.method3575();
               var3 = (var2 >> 4 & 7) + MessageNode.field774;
               var4 = (var2 & 7) + class65.field734;
               var5 = var1.method3699();
               var6 = var1.readUnsignedShort();
               var7 = var1.method3666();
               if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                  Deque var42 = Client.groundItemDeque[class230.plane][var3][var4];
                  if(var42 != null) {
                     for(Item var34 = (Item)var42.getFront(); var34 != null; var34 = (Item)var42.getNext()) {
                        if((var7 & 32767) == var34.id && var5 == var34.quantity) {
                           var34.quantity = var6;
                           break;
                        }
                     }

                     class22.groundItemSpawned(var3, var4);
                  }
               }

            } else {
               if(class182.field2450 == var0) {
                  byte var37 = var1.method3579();
                  var3 = var1.method3699();
                  var4 = var1.readUnsignedShortOb1();
                  var5 = var1.method3666();
                  var38 = var1.readByte();
                  byte var40 = var1.method3579();
                  var8 = var1.readUnsignedByteNegate();
                  var9 = (var8 >> 4 & 7) + MessageNode.field774;
                  var10 = (var8 & 7) + class65.field734;
                  byte var11 = var1.readByte();
                  var12 = var1.readUnsignedShort();
                  var13 = var1.readUnsignedByteNegate();
                  var14 = var13 >> 2;
                  int var35 = var13 & 3;
                  int var16 = Client.field851[var14];
                  Player var17;
                  if(var5 == Client.localInteractingIndex) {
                     var17 = OwnWorldComparator.localPlayer;
                  } else {
                     var17 = Client.cachedPlayers[var5];
                  }

                  if(var17 != null) {
                     ObjectComposition var18 = Preferences.getObjectDefinition(var3);
                     int var19;
                     int var20;
                     if(var35 != 1 && var35 != 3) {
                        var19 = var18.width;
                        var20 = var18.length;
                     } else {
                        var19 = var18.length;
                        var20 = var18.width;
                     }

                     int var21 = var9 + (var19 >> 1);
                     int var22 = var9 + (var19 + 1 >> 1);
                     int var23 = var10 + (var20 >> 1);
                     int var24 = var10 + (var20 + 1 >> 1);
                     int[][] var25 = class61.tileHeights[class230.plane];
                     int var26 = var25[var21][var24] + var25[var22][var23] + var25[var21][var23] + var25[var22][var24] >> 2;
                     int var27 = (var9 << 7) + (var19 << 6);
                     int var28 = (var10 << 7) + (var20 << 6);
                     Model var29 = var18.method4957(var14, var35, var25, var27, var26, var28);
                     if(var29 != null) {
                        class61.method1055(class230.plane, var9, var10, var16, -1, 0, 0, var4 + 1, var12 + 1);
                        var17.animationCycleStart = var4 + Client.gameCycle;
                        var17.animationCycleEnd = var12 + Client.gameCycle;
                        var17.model = var29;
                        var17.field798 = var9 * 128 + var19 * 64;
                        var17.field793 = var10 * 128 + var20 * 64;
                        var17.field792 = var26;
                        byte var30;
                        if(var40 > var11) {
                           var30 = var40;
                           var40 = var11;
                           var11 = var30;
                        }

                        if(var37 > var38) {
                           var30 = var37;
                           var37 = var38;
                           var38 = var30;
                        }

                        var17.field781 = var9 + var40;
                        var17.field784 = var11 + var9;
                        var17.field796 = var37 + var10;
                        var17.field795 = var10 + var38;
                     }
                  }
               }

               if(class182.field2447 != var0) {
                  if(class182.field2455 == var0) {
                     var2 = var1.method3575();
                     var3 = (var2 >> 4 & 7) + MessageNode.field774;
                     var4 = (var2 & 7) + class65.field734;
                     var5 = var1.method3575();
                     var6 = var1.readUnsignedShortOb1();
                     var7 = var1.method3666();
                     if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                        var3 = var3 * 128 + 64;
                        var4 = var4 * 128 + 64;
                        GraphicsObject var33 = new GraphicsObject(var7, class230.plane, var3, var4, WorldMapType1.getTileHeight(var3, var4, class230.plane) - var5, var6, Client.gameCycle);
                        Client.graphicsObjectDeque.addFront(var33);
                     }

                  }
               } else {
                  var2 = var1.method3575();
                  var3 = (var2 >> 4 & 7) + MessageNode.field774;
                  var4 = (var2 & 7) + class65.field734;
                  var5 = var1.method3699();
                  var6 = var1.method3575();
                  var7 = var6 >> 2;
                  var8 = var6 & 3;
                  var9 = Client.field851[var7];
                  if(var3 >= 0 && var4 >= 0 && var3 < 103 && var4 < 103) {
                     if(var9 == 0) {
                        WallObject var36 = GameObject.region.method2965(class230.plane, var3, var4);
                        if(var36 != null) {
                           var41 = var36.hash >> 14 & 32767;
                           if(var7 == 2) {
                              var36.renderable1 = new DynamicObject(var41, 2, var8 + 4, class230.plane, var3, var4, var5, false, var36.renderable1);
                              var36.renderable2 = new DynamicObject(var41, 2, var8 + 1 & 3, class230.plane, var3, var4, var5, false, var36.renderable2);
                           } else {
                              var36.renderable1 = new DynamicObject(var41, var7, var8, class230.plane, var3, var4, var5, false, var36.renderable1);
                           }
                        }
                     }

                     if(var9 == 1) {
                        DecorativeObject var43 = GameObject.region.method2906(class230.plane, var3, var4);
                        if(var43 != null) {
                           var41 = var43.hash >> 14 & 32767;
                           if(var7 != 4 && var7 != 5) {
                              if(var7 == 6) {
                                 var43.renderable1 = new DynamicObject(var41, 4, var8 + 4, class230.plane, var3, var4, var5, false, var43.renderable1);
                              } else if(var7 == 7) {
                                 var43.renderable1 = new DynamicObject(var41, 4, (var8 + 2 & 3) + 4, class230.plane, var3, var4, var5, false, var43.renderable1);
                              } else if(var7 == 8) {
                                 var43.renderable1 = new DynamicObject(var41, 4, var8 + 4, class230.plane, var3, var4, var5, false, var43.renderable1);
                                 var43.renderable2 = new DynamicObject(var41, 4, (var8 + 2 & 3) + 4, class230.plane, var3, var4, var5, false, var43.renderable2);
                              }
                           } else {
                              var43.renderable1 = new DynamicObject(var41, 4, var8, class230.plane, var3, var4, var5, false, var43.renderable1);
                           }
                        }
                     }

                     if(var9 == 2) {
                        GameObject var44 = GameObject.region.method2981(class230.plane, var3, var4);
                        if(var7 == 11) {
                           var7 = 10;
                        }

                        if(var44 != null) {
                           var44.renderable = new DynamicObject(var44.hash >> 14 & 32767, var7, var8, class230.plane, var3, var4, var5, false, var44.renderable);
                        }
                     }

                     if(var9 == 3) {
                        GroundObject var45 = GameObject.region.getFloorDecoration(class230.plane, var3, var4);
                        if(var45 != null) {
                           var45.renderable = new DynamicObject(var45.hash >> 14 & 32767, 22, var8, class230.plane, var3, var4, var5, false, var45.renderable);
                        }
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1602473156"
   )
   static void method4902() {
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
   }
}
