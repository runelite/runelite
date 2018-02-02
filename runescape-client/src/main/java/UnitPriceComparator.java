import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
@Implements("UnitPriceComparator")
final class UnitPriceComparator implements Comparator {
   @ObfuscatedName("g")
   static int[] field300;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ln;Ln;I)I",
      garbageValue = "-178501253"
   )
   int method131(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.grandExchangeOffer.price < var2.grandExchangeOffer.price?-1:(var2.grandExchangeOffer.price == var1.grandExchangeOffer.price?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method131((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Len;IIII)Z",
      garbageValue = "-191667935"
   )
   @Export("boundingBox3DContainsMouse")
   static final boolean boundingBox3DContainsMouse(Model var0, int var1, int var2, int var3) {
      boolean var4 = class131.Viewport_containsMouse;
      if(!var4) {
         return false;
      } else {
         int var5;
         int var6;
         int var7;
         int var8;
         int var11;
         int var12;
         int var13;
         int var16;
         int var17;
         if(!class131.Viewport_false0) {
            var5 = Region.pitchSin;
            var6 = Region.pitchCos;
            var7 = Region.yawSin;
            var8 = Region.yawCos;
            byte var9 = 50;
            short var10 = 3500;
            var11 = (class131.Viewport_mouseX - Graphics3D.centerX) * var9 / Graphics3D.Rasterizer3D_zoom;
            var12 = (class131.Viewport_mouseY - Graphics3D.centerY) * var9 / Graphics3D.Rasterizer3D_zoom;
            var13 = (class131.Viewport_mouseX - Graphics3D.centerX) * var10 / Graphics3D.Rasterizer3D_zoom;
            int var14 = (class131.Viewport_mouseY - Graphics3D.centerY) * var10 / Graphics3D.Rasterizer3D_zoom;
            int var15 = Graphics3D.method2763(var12, var9, var6, var5);
            var16 = Graphics3D.method2754(var12, var9, var6, var5);
            var12 = var15;
            var15 = Graphics3D.method2763(var14, var10, var6, var5);
            var17 = Graphics3D.method2754(var14, var10, var6, var5);
            var14 = var15;
            var15 = Graphics3D.method2761(var11, var16, var8, var7);
            var16 = Graphics3D.method2762(var11, var16, var8, var7);
            var11 = var15;
            var15 = Graphics3D.method2761(var13, var17, var8, var7);
            var17 = Graphics3D.method2762(var13, var17, var8, var7);
            class131.field1873 = (var15 + var11) / 2;
            class300.field3825 = (var14 + var12) / 2;
            class63.field718 = (var17 + var16) / 2;
            class31.field417 = (var15 - var11) / 2;
            class131.field1869 = (var14 - var12) / 2;
            CombatInfoListHolder.field1254 = (var17 - var16) / 2;
            class131.field1875 = Math.abs(class31.field417);
            class56.field621 = Math.abs(class131.field1869);
            GrandExchangeEvents.field264 = Math.abs(CombatInfoListHolder.field1254);
         }

         var5 = var0.centerX + var1;
         var6 = var2 + var0.centerY;
         var7 = var3 + var0.centerZ;
         var8 = var0.extremeX;
         var16 = var0.extremeY;
         var17 = var0.extremeZ;
         var11 = class131.field1873 - var5;
         var12 = class300.field3825 - var6;
         var13 = class63.field718 - var7;
         return Math.abs(var11) > var8 + class131.field1875?false:(Math.abs(var12) > var16 + class56.field621?false:(Math.abs(var13) > var17 + GrandExchangeEvents.field264?false:(Math.abs(var13 * class131.field1869 - var12 * CombatInfoListHolder.field1254) > var16 * GrandExchangeEvents.field264 + var17 * class56.field621?false:(Math.abs(var11 * CombatInfoListHolder.field1254 - var13 * class31.field417) > var17 * class131.field1875 + var8 * GrandExchangeEvents.field264?false:Math.abs(var12 * class31.field417 - var11 * class131.field1869) <= var16 * class131.field1875 + var8 * class56.field621))));
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lbi;Lbi;IZI)I",
      garbageValue = "-1125581255"
   )
   static int method134(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method1611()?(var1.method1611()?0:1):(var1.method1611()?-1:0)):(var2 == 5?(var0.method1609()?(var1.method1609()?0:1):(var1.method1609()?-1:0)):(var2 == 6?(var0.method1610()?(var1.method1610()?0:1):(var1.method1610()?-1:0)):(var2 == 7?(var0.method1608()?(var1.method1608()?0:1):(var1.method1608()?-1:0)):var0.id - var1.id)))));
      }
   }

   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static final void method138() {
      if(Client.field1043 > 0) {
         GrandExchangeEvents.method89();
      } else {
         Client.field1076.method5339();
         class5.setGameState(40);
         class28.field387 = Client.field867.getSocket();
         Client.field867.method2023();
      }
   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(Lfh;I)V",
      garbageValue = "-2119386060"
   )
   static final void method139(class173 var0) {
      PacketBuffer var1 = Client.field867.packetBuffer;
      int var2;
      int var3;
      int var4;
      int var5;
      Item var7;
      if(class173.field2393 == var0) {
         var2 = var1.readUnsignedByteNegate();
         var3 = (var2 >> 4 & 7) + GZipDecompressor.field2423;
         var4 = (var2 & 7) + class36.field465;
         var5 = var1.method3442();
         if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
            Deque var6 = Client.groundItemDeque[MessageNode.plane][var3][var4];
            if(var6 != null) {
               for(var7 = (Item)var6.getFront(); var7 != null; var7 = (Item)var6.getNext()) {
                  if((var5 & 32767) == var7.id) {
                     var7.unlink();
                     break;
                  }
               }

               if(var6.getFront() == null) {
                  Client.groundItemDeque[MessageNode.plane][var3][var4] = null;
               }

               AbstractSoundSystem.groundItemSpawned(var3, var4);
            }
         }

      } else {
         int var8;
         int var9;
         int var10;
         int var31;
         int var32;
         if(class173.field2392 == var0) {
            var2 = var1.method3432();
            var3 = var1.method3432();
            var4 = (var3 >> 4 & 7) + GZipDecompressor.field2423;
            var5 = (var3 & 7) + class36.field465;
            var31 = var1.method3442();
            var32 = var1.readUnsignedByte();
            var8 = var32 >> 4 & 15;
            var9 = var32 & 7;
            if(var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
               var10 = var8 + 1;
               if(class36.localPlayer.pathX[0] >= var4 - var10 && class36.localPlayer.pathX[0] <= var4 + var10 && class36.localPlayer.pathY[0] >= var5 - var10 && class36.localPlayer.pathY[0] <= var10 + var5 && Client.field879 != 0 && var9 > 0 && Client.queuedSoundEffectCount < 50) {
                  Client.queuedSoundEffectIDs[Client.queuedSoundEffectCount] = var31;
                  Client.unknownSoundValues1[Client.queuedSoundEffectCount] = var9;
                  Client.unknownSoundValues2[Client.queuedSoundEffectCount] = var2;
                  Client.audioEffects[Client.queuedSoundEffectCount] = null;
                  Client.soundLocations[Client.queuedSoundEffectCount] = var8 + (var5 << 8) + (var4 << 16);
                  ++Client.queuedSoundEffectCount;
               }
            }
         }

         if(class173.field2396 == var0) {
            var2 = var1.readUnsignedShort();
            var3 = var1.method3432();
            var4 = (var3 >> 4 & 7) + GZipDecompressor.field2423;
            var5 = (var3 & 7) + class36.field465;
            var31 = var1.readUnsignedByteNegate();
            var32 = var31 >> 2;
            var8 = var31 & 3;
            var9 = Client.field1070[var32];
            if(var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
               GraphicsObject.method1805(MessageNode.plane, var4, var5, var9, var2, var32, var8, 0, -1);
            }

         } else if(class173.field2395 == var0) {
            var2 = var1.readUnsignedShortOb1();
            var3 = var1.readUnsignedByteNegate();
            var4 = (var3 >> 4 & 7) + GZipDecompressor.field2423;
            var5 = (var3 & 7) + class36.field465;
            var31 = var1.method3440();
            var32 = var1.method3442();
            if(var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
               Deque var41 = Client.groundItemDeque[MessageNode.plane][var4][var5];
               if(var41 != null) {
                  for(Item var34 = (Item)var41.getFront(); var34 != null; var34 = (Item)var41.getNext()) {
                     if((var32 & 32767) == var34.id && var2 == var34.quantity) {
                        var34.quantity = var31;
                        break;
                     }
                  }

                  AbstractSoundSystem.groundItemSpawned(var4, var5);
               }
            }

         } else if(class173.field2391 == var0) {
            var2 = var1.readUnsignedByteNegate();
            var3 = (var2 >> 4 & 7) + GZipDecompressor.field2423;
            var4 = (var2 & 7) + class36.field465;
            var5 = var1.method3442();
            var31 = var1.method3440();
            var32 = var1.readUnsignedByte();
            if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
               var3 = var3 * 128 + 64;
               var4 = var4 * 128 + 64;
               GraphicsObject var33 = new GraphicsObject(var5, MessageNode.plane, var3, var4, GameCanvas.getTileHeight(var3, var4, MessageNode.plane) - var32, var31, Client.gameCycle);
               Client.graphicsObjectDeque.addFront(var33);
            }

         } else {
            int var11;
            int var12;
            int var13;
            int var14;
            byte var40;
            if(class173.field2390 == var0) {
               byte var37 = var1.method3458();
               byte var38 = var1.method3396();
               var4 = var1.readUnsignedShortOb1();
               var5 = var1.readUnsignedShort();
               var31 = var1.readUnsignedByte();
               var32 = (var31 >> 4 & 7) + GZipDecompressor.field2423;
               var8 = (var31 & 7) + class36.field465;
               var40 = var1.readByte();
               var10 = var1.method3440();
               var11 = var1.method3432();
               var12 = var11 >> 2;
               var13 = var11 & 3;
               var14 = Client.field1070[var12];
               byte var15 = var1.method3396();
               int var16 = var1.readUnsignedShortOb1();
               Player var17;
               if(var4 == Client.localInteractingIndex) {
                  var17 = class36.localPlayer;
               } else {
                  var17 = Client.cachedPlayers[var4];
               }

               if(var17 != null) {
                  ObjectComposition var18 = TextureProvider.getObjectDefinition(var10);
                  int var19;
                  int var20;
                  if(var13 != 1 && var13 != 3) {
                     var19 = var18.width;
                     var20 = var18.length;
                  } else {
                     var19 = var18.length;
                     var20 = var18.width;
                  }

                  int var21 = var32 + (var19 >> 1);
                  int var22 = var32 + (var19 + 1 >> 1);
                  int var23 = var8 + (var20 >> 1);
                  int var24 = var8 + (var20 + 1 >> 1);
                  int[][] var25 = class61.tileHeights[MessageNode.plane];
                  int var26 = var25[var22][var24] + var25[var21][var24] + var25[var21][var23] + var25[var22][var23] >> 2;
                  int var27 = (var32 << 7) + (var19 << 6);
                  int var28 = (var8 << 7) + (var20 << 6);
                  Model var29 = var18.method4799(var12, var13, var25, var27, var26, var28);
                  if(var29 != null) {
                     GraphicsObject.method1805(MessageNode.plane, var32, var8, var14, -1, 0, 0, var5 + 1, var16 + 1);
                     var17.animationCycleStart = var5 + Client.gameCycle;
                     var17.animationCycleEnd = var16 + Client.gameCycle;
                     var17.model = var29;
                     var17.field797 = var32 * 128 + var19 * 64;
                     var17.field806 = var8 * 128 + var20 * 64;
                     var17.field791 = var26;
                     byte var30;
                     if(var40 > var37) {
                        var30 = var40;
                        var40 = var37;
                        var37 = var30;
                     }

                     if(var15 > var38) {
                        var30 = var15;
                        var15 = var38;
                        var38 = var30;
                     }

                     var17.field801 = var40 + var32;
                     var17.field803 = var37 + var32;
                     var17.field804 = var15 + var8;
                     var17.field816 = var38 + var8;
                  }
               }
            }

            if(class173.field2389 == var0) {
               var2 = var1.readUnsignedByte();
               var3 = var1.readUnsignedByteNegate();
               var4 = var1.readUnsignedShortOb1();
               byte var39 = var1.readByte();
               var31 = var1.readUnsignedByteNegate() * 4;
               var32 = var1.method3432() * 4;
               var8 = var1.readUnsignedShortOb1();
               var40 = var1.method3466();
               var10 = var1.readUnsignedByte();
               var11 = (var10 >> 4 & 7) + GZipDecompressor.field2423;
               var12 = (var10 & 7) + class36.field465;
               var13 = var1.method3440();
               var14 = var1.method3443();
               var9 = var40 + var11;
               var5 = var39 + var12;
               if(var11 >= 0 && var12 >= 0 && var11 < 104 && var12 < 104 && var9 >= 0 && var5 >= 0 && var9 < 104 && var5 < 104 && var4 != 65535) {
                  var11 = var11 * 128 + 64;
                  var12 = var12 * 128 + 64;
                  var9 = var9 * 128 + 64;
                  var5 = var5 * 128 + 64;
                  Projectile var35 = new Projectile(var4, MessageNode.plane, var11, var12, GameCanvas.getTileHeight(var11, var12, MessageNode.plane) - var32, var13 + Client.gameCycle, var8 + Client.gameCycle, var2, var3, var14, var31);
                  var35.moveProjectile(var9, var5, GameCanvas.getTileHeight(var9, var5, MessageNode.plane) - var31, var13 + Client.gameCycle);
                  Client.projectiles.addFront(var35);
               }

            } else if(class173.field2394 != var0) {
               if(class173.field2388 == var0) {
                  var2 = var1.readUnsignedByte();
                  var3 = (var2 >> 4 & 7) + GZipDecompressor.field2423;
                  var4 = (var2 & 7) + class36.field465;
                  var5 = var1.readUnsignedByteNegate();
                  var31 = var5 >> 2;
                  var32 = var5 & 3;
                  var8 = Client.field1070[var31];
                  if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                     GraphicsObject.method1805(MessageNode.plane, var3, var4, var8, -1, var31, var32, 0, -1);
                  }

               } else if(class173.field2397 == var0) {
                  var2 = var1.method3440();
                  var3 = var1.readUnsignedByte();
                  var4 = (var3 >> 4 & 7) + GZipDecompressor.field2423;
                  var5 = (var3 & 7) + class36.field465;
                  var31 = var1.method3440();
                  if(var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
                     var7 = new Item();
                     var7.id = var31;
                     var7.quantity = var2;
                     if(Client.groundItemDeque[MessageNode.plane][var4][var5] == null) {
                        Client.groundItemDeque[MessageNode.plane][var4][var5] = new Deque();
                     }

                     Client.groundItemDeque[MessageNode.plane][var4][var5].addFront(var7);
                     AbstractSoundSystem.groundItemSpawned(var4, var5);
                  }

               }
            } else {
               var2 = var1.readUnsignedShort();
               var3 = var1.readUnsignedByte();
               var4 = var3 >> 2;
               var5 = var3 & 3;
               var31 = Client.field1070[var4];
               var32 = var1.method3433();
               var8 = (var32 >> 4 & 7) + GZipDecompressor.field2423;
               var9 = (var32 & 7) + class36.field465;
               if(var8 >= 0 && var9 >= 0 && var8 < 103 && var9 < 103) {
                  if(var31 == 0) {
                     WallObject var36 = class48.region.method2833(MessageNode.plane, var8, var9);
                     if(var36 != null) {
                        var11 = var36.hash >> 14 & 32767;
                        if(var4 == 2) {
                           var36.renderable1 = new DynamicObject(var11, 2, var5 + 4, MessageNode.plane, var8, var9, var2, false, var36.renderable1);
                           var36.renderable2 = new DynamicObject(var11, 2, var5 + 1 & 3, MessageNode.plane, var8, var9, var2, false, var36.renderable2);
                        } else {
                           var36.renderable1 = new DynamicObject(var11, var4, var5, MessageNode.plane, var8, var9, var2, false, var36.renderable1);
                        }
                     }
                  }

                  if(var31 == 1) {
                     DecorativeObject var42 = class48.region.method2834(MessageNode.plane, var8, var9);
                     if(var42 != null) {
                        var11 = var42.hash >> 14 & 32767;
                        if(var4 != 4 && var4 != 5) {
                           if(var4 == 6) {
                              var42.renderable1 = new DynamicObject(var11, 4, var5 + 4, MessageNode.plane, var8, var9, var2, false, var42.renderable1);
                           } else if(var4 == 7) {
                              var42.renderable1 = new DynamicObject(var11, 4, (var5 + 2 & 3) + 4, MessageNode.plane, var8, var9, var2, false, var42.renderable1);
                           } else if(var4 == 8) {
                              var42.renderable1 = new DynamicObject(var11, 4, var5 + 4, MessageNode.plane, var8, var9, var2, false, var42.renderable1);
                              var42.renderable2 = new DynamicObject(var11, 4, (var5 + 2 & 3) + 4, MessageNode.plane, var8, var9, var2, false, var42.renderable2);
                           }
                        } else {
                           var42.renderable1 = new DynamicObject(var11, 4, var5, MessageNode.plane, var8, var9, var2, false, var42.renderable1);
                        }
                     }
                  }

                  if(var31 == 2) {
                     GameObject var43 = class48.region.method2835(MessageNode.plane, var8, var9);
                     if(var4 == 11) {
                        var4 = 10;
                     }

                     if(var43 != null) {
                        var43.renderable = new DynamicObject(var43.hash >> 14 & 32767, var4, var5, MessageNode.plane, var8, var9, var2, false, var43.renderable);
                     }
                  }

                  if(var31 == 3) {
                     GroundObject var44 = class48.region.getFloorDecoration(MessageNode.plane, var8, var9);
                     if(var44 != null) {
                        var44.renderable = new DynamicObject(var44.hash >> 14 & 32767, 22, var5, MessageNode.plane, var8, var9, var2, false, var44.renderable);
                     }
                  }
               }

            }
         }
      }
   }
}
