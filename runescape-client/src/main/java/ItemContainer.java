import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
@Implements("ItemContainer")
public class ItemContainer extends Node {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   @Export("itemContainers")
   static HashTable itemContainers;
   @ObfuscatedName("z")
   @Export("itemIds")
   int[] itemIds;
   @ObfuscatedName("n")
   @Export("stackSizes")
   int[] stackSizes;

   static {
      itemContainers = new HashTable(32);
   }

   ItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILct;ZI)I",
      garbageValue = "-1232657961"
   )
   static int method1079(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class81.intStack[--class81.intStackSize];
         var3 = class5.getWidget(var4);
      } else {
         var3 = var2?class20.field338:class81.field1267;
      }

      if(var0 == 1100) {
         class81.intStackSize -= 2;
         var3.scrollX = class81.intStack[class81.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class81.intStack[class81.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         class171.method3363(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class81.intStack[--class81.intStackSize];
         class171.method3363(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.filled = class81.intStack[--class81.intStackSize] == 1;
         class171.method3363(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class81.intStack[--class81.intStackSize];
         class171.method3363(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.lineWidth = class81.intStack[--class81.intStackSize];
         class171.method3363(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class81.intStack[--class81.intStackSize];
         class171.method3363(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.textureId = class81.intStack[--class81.intStackSize];
         class171.method3363(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.spriteTiling = class81.intStack[--class81.intStackSize] == 1;
         class171.method3363(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class81.intStack[--class81.intStackSize];
         class171.method3363(var3);
         return 1;
      } else if(var0 == 1109) {
         class81.intStackSize -= 6;
         var3.field2874 = class81.intStack[class81.intStackSize];
         var3.field2875 = class81.intStack[class81.intStackSize + 1];
         var3.rotationX = class81.intStack[class81.intStackSize + 2];
         var3.rotationZ = class81.intStack[class81.intStackSize + 3];
         var3.rotationY = class81.intStack[class81.intStackSize + 4];
         var3.modelZoom = class81.intStack[class81.intStackSize + 5];
         class171.method3363(var3);
         return 1;
      } else {
         int var8;
         if(var0 == 1110) {
            var8 = class81.intStack[--class81.intStackSize];
            if(var8 != var3.field2820) {
               var3.field2820 = var8;
               var3.field2947 = 0;
               var3.field2948 = 0;
               class171.method3363(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2882 = class81.intStack[--class81.intStackSize] == 1;
            class171.method3363(var3);
            return 1;
         } else if(var0 == 1112) {
            String var7 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
            if(!var7.equals(var3.text)) {
               var3.text = var7;
               class171.method3363(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class81.intStack[--class81.intStackSize];
            class171.method3363(var3);
            return 1;
         } else if(var0 == 1114) {
            class81.intStackSize -= 3;
            var3.field2888 = class81.intStack[class81.intStackSize];
            var3.field2891 = class81.intStack[class81.intStackSize + 1];
            var3.field2850 = class81.intStack[class81.intStackSize + 2];
            class171.method3363(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.textShadowed = class81.intStack[--class81.intStackSize] == 1;
            class171.method3363(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class81.intStack[--class81.intStackSize];
            class171.method3363(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class81.intStack[--class81.intStackSize];
            class171.method3363(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class81.intStack[--class81.intStackSize] == 1;
            class171.method3363(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class81.intStack[--class81.intStackSize] == 1;
            class171.method3363(var3);
            return 1;
         } else if(var0 == 1120) {
            class81.intStackSize -= 2;
            var3.scrollWidth = class81.intStack[class81.intStackSize];
            var3.scrollHeight = class81.intStack[class81.intStackSize + 1];
            class171.method3363(var3);
            if(var4 != -1 && var3.type == 0) {
               class183.method3484(Widget.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            class61.method1023(var3.id, var3.index);
            Client.field1014 = var3;
            class171.method3363(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2861 = class81.intStack[--class81.intStackSize];
            class171.method3363(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2851 = class81.intStack[--class81.intStackSize];
            class171.method3363(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2857 = class81.intStack[--class81.intStackSize];
            class171.method3363(var3);
            return 1;
         } else if(var0 == 1125) {
            var8 = class81.intStack[--class81.intStackSize];
            class329 var6 = (class329)MapIcon.forOrdinal(CollisionData.method3464(), var8);
            if(var6 != null) {
               var3.field2868 = var6;
               class171.method3363(var3);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var5 = class81.intStack[--class81.intStackSize] == 1;
            var3.field2946 = var5;
            return 1;
         } else {
            return 2;
         }
      }
   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(Lgh;S)V",
      garbageValue = "11776"
   )
   static final void method1080(class183 var0) {
      PacketBuffer var1 = Client.field899.packetBuffer;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      if(class183.field2487 == var0) {
         var2 = var1.method3618();
         var3 = var1.method3609();
         var4 = var3 >> 2;
         var5 = var3 & 3;
         var6 = Client.field913[var4];
         var7 = var1.method3610();
         var8 = (var7 >> 4 & 7) + class28.field412;
         var9 = (var7 & 7) + class80.field1239;
         if(var8 >= 0 && var9 >= 0 && var8 < 104 && var9 < 104) {
            class158.method3248(class36.plane, var8, var9, var6, var2, var4, var5, 0, -1);
         }

      } else {
         int var10;
         if(class183.field2485 == var0) {
            var2 = var1.readUnsignedByte();
            var3 = var2 >> 4 & 15;
            var4 = var2 & 7;
            var5 = var1.method3610();
            var6 = (var5 >> 4 & 7) + class28.field412;
            var7 = (var5 & 7) + class80.field1239;
            var8 = var1.readUnsignedShortOb1();
            var9 = var1.method3583();
            if(var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
               var10 = var3 + 1;
               if(TotalQuantityComparator.localPlayer.pathX[0] >= var6 - var10 && TotalQuantityComparator.localPlayer.pathX[0] <= var6 + var10 && TotalQuantityComparator.localPlayer.pathY[0] >= var7 - var10 && TotalQuantityComparator.localPlayer.pathY[0] <= var7 + var10 && Client.field911 != 0 && var4 > 0 && Client.queuedSoundEffectCount < 50) {
                  Client.queuedSoundEffectIDs[Client.queuedSoundEffectCount] = var8;
                  Client.unknownSoundValues1[Client.queuedSoundEffectCount] = var4;
                  Client.unknownSoundValues2[Client.queuedSoundEffectCount] = var9;
                  Client.audioEffects[Client.queuedSoundEffectCount] = null;
                  Client.soundLocations[Client.queuedSoundEffectCount] = var3 + (var7 << 8) + (var6 << 16);
                  ++Client.queuedSoundEffectCount;
               }
            }
         }

         int var14;
         if(class183.field2484 == var0) {
            var2 = var1.method3610();
            var3 = var2 >> 2;
            var4 = var2 & 3;
            var5 = Client.field913[var3];
            var6 = var1.method3583();
            var7 = (var6 >> 4 & 7) + class28.field412;
            var8 = (var6 & 7) + class80.field1239;
            var9 = var1.method3620();
            var10 = var1.method3620();
            byte var11 = var1.readByte();
            byte var12 = var1.method3612();
            byte var13 = var1.method3613();
            var14 = var1.method3618();
            int var15 = var1.readUnsignedShort();
            byte var16 = var1.readByte();
            Player var17;
            if(var15 == Client.localInteractingIndex) {
               var17 = TotalQuantityComparator.localPlayer;
            } else {
               var17 = Client.cachedPlayers[var15];
            }

            if(var17 != null) {
               ObjectComposition var18 = class169.getObjectDefinition(var10);
               int var19;
               int var20;
               if(var4 != 1 && var4 != 3) {
                  var19 = var18.width;
                  var20 = var18.length;
               } else {
                  var19 = var18.length;
                  var20 = var18.width;
               }

               int var21 = var7 + (var19 >> 1);
               int var22 = var7 + (var19 + 1 >> 1);
               int var23 = var8 + (var20 >> 1);
               int var24 = var8 + (var20 + 1 >> 1);
               int[][] var25 = class62.tileHeights[class36.plane];
               int var26 = var25[var22][var23] + var25[var21][var23] + var25[var21][var24] + var25[var22][var24] >> 2;
               int var27 = (var7 << 7) + (var19 << 6);
               int var28 = (var8 << 7) + (var20 << 6);
               Model var29 = var18.method5116(var3, var4, var25, var27, var26, var28);
               if(var29 != null) {
                  class158.method3248(class36.plane, var7, var8, var5, -1, 0, 0, var9 + 1, var14 + 1);
                  var17.animationCycleStart = var9 + Client.gameCycle;
                  var17.animationCycleEnd = var14 + Client.gameCycle;
                  var17.model = var29;
                  var17.field830 = var7 * 128 + var19 * 64;
                  var17.field835 = var8 * 128 + var20 * 64;
                  var17.field837 = var26;
                  byte var30;
                  if(var13 > var11) {
                     var30 = var13;
                     var13 = var11;
                     var11 = var30;
                  }

                  if(var12 > var16) {
                     var30 = var12;
                     var12 = var16;
                     var16 = var30;
                  }

                  var17.field832 = var7 + var13;
                  var17.field846 = var11 + var7;
                  var17.field838 = var12 + var8;
                  var17.field834 = var16 + var8;
               }
            }
         }

         int var39;
         if(class183.field2488 == var0) {
            byte var37 = var1.method3613();
            var3 = var1.method3622();
            var4 = var1.method3620();
            var5 = var1.method3609() * 4;
            var6 = var1.readUnsignedShort();
            byte var38 = var1.method3612();
            var8 = var1.readUnsignedShortOb1();
            var9 = var1.method3583();
            var10 = (var9 >> 4 & 7) + class28.field412;
            var39 = (var9 & 7) + class80.field1239;
            int var40 = var1.readUnsignedByte();
            int var41 = var1.method3609();
            var14 = var1.method3610() * 4;
            var7 = var38 + var10;
            var2 = var37 + var39;
            if(var10 >= 0 && var39 >= 0 && var10 < 104 && var39 < 104 && var7 >= 0 && var2 >= 0 && var7 < 104 && var2 < 104 && var6 != 65535) {
               var10 = var10 * 128 + 64;
               var39 = var39 * 128 + 64;
               var7 = var7 * 128 + 64;
               var2 = var2 * 128 + 64;
               Projectile var31 = new Projectile(var6, class36.plane, var10, var39, class35.getTileHeight(var10, var39, class36.plane) - var5, var4 + Client.gameCycle, var8 + Client.gameCycle, var41, var40, var3, var14);
               var31.moveProjectile(var7, var2, class35.getTileHeight(var7, var2, class36.plane) - var14, var4 + Client.gameCycle);
               Client.projectiles.addFront(var31);
            }

         } else if(class183.field2491 == var0) {
            var2 = var1.method3583();
            var3 = var1.readUnsignedShortOb1();
            var4 = var1.method3610();
            var5 = (var4 >> 4 & 7) + class28.field412;
            var6 = (var4 & 7) + class80.field1239;
            var7 = var1.readUnsignedShortOb1();
            if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
               var5 = var5 * 128 + 64;
               var6 = var6 * 128 + 64;
               GraphicsObject var42 = new GraphicsObject(var3, class36.plane, var5, var6, class35.getTileHeight(var5, var6, class36.plane) - var2, var7, Client.gameCycle);
               Client.graphicsObjectDeque.addFront(var42);
            }

         } else if(class183.field2490 == var0) {
            var2 = var1.method3583();
            var3 = var2 >> 2;
            var4 = var2 & 3;
            var5 = Client.field913[var3];
            var6 = var1.readUnsignedShort();
            var7 = var1.method3609();
            var8 = (var7 >> 4 & 7) + class28.field412;
            var9 = (var7 & 7) + class80.field1239;
            if(var8 >= 0 && var9 >= 0 && var8 < 103 && var9 < 103) {
               if(var5 == 0) {
                  WallObject var33 = class86.region.method3008(class36.plane, var8, var9);
                  if(var33 != null) {
                     var39 = var33.hash >> 14 & 32767;
                     if(var3 == 2) {
                        var33.renderable1 = new DynamicObject(var39, 2, var4 + 4, class36.plane, var8, var9, var6, false, var33.renderable1);
                        var33.renderable2 = new DynamicObject(var39, 2, var4 + 1 & 3, class36.plane, var8, var9, var6, false, var33.renderable2);
                     } else {
                        var33.renderable1 = new DynamicObject(var39, var3, var4, class36.plane, var8, var9, var6, false, var33.renderable1);
                     }
                  }
               }

               if(var5 == 1) {
                  DecorativeObject var43 = class86.region.method2955(class36.plane, var8, var9);
                  if(var43 != null) {
                     var39 = var43.hash >> 14 & 32767;
                     if(var3 != 4 && var3 != 5) {
                        if(var3 == 6) {
                           var43.renderable1 = new DynamicObject(var39, 4, var4 + 4, class36.plane, var8, var9, var6, false, var43.renderable1);
                        } else if(var3 == 7) {
                           var43.renderable1 = new DynamicObject(var39, 4, (var4 + 2 & 3) + 4, class36.plane, var8, var9, var6, false, var43.renderable1);
                        } else if(var3 == 8) {
                           var43.renderable1 = new DynamicObject(var39, 4, var4 + 4, class36.plane, var8, var9, var6, false, var43.renderable1);
                           var43.renderable2 = new DynamicObject(var39, 4, (var4 + 2 & 3) + 4, class36.plane, var8, var9, var6, false, var43.renderable2);
                        }
                     } else {
                        var43.renderable1 = new DynamicObject(var39, 4, var4, class36.plane, var8, var9, var6, false, var43.renderable1);
                     }
                  }
               }

               if(var5 == 2) {
                  GameObject var44 = class86.region.method2958(class36.plane, var8, var9);
                  if(var3 == 11) {
                     var3 = 10;
                  }

                  if(var44 != null) {
                     var44.renderable = new DynamicObject(var44.hash >> 14 & 32767, var3, var4, class36.plane, var8, var9, var6, false, var44.renderable);
                  }
               }

               if(var5 == 3) {
                  GroundObject var45 = class86.region.getFloorDecoration(class36.plane, var8, var9);
                  if(var45 != null) {
                     var45.renderable = new DynamicObject(var45.hash >> 14 & 32767, 22, var4, class36.plane, var8, var9, var6, false, var45.renderable);
                  }
               }
            }

         } else {
            Item var34;
            if(class183.field2486 == var0) {
               var2 = var1.readUnsignedShort();
               var3 = var1.method3583();
               var4 = (var3 >> 4 & 7) + class28.field412;
               var5 = (var3 & 7) + class80.field1239;
               var6 = var1.method3618();
               if(var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
                  var34 = new Item();
                  var34.id = var6;
                  var34.quantity = var2;
                  if(Client.groundItemDeque[class36.plane][var4][var5] == null) {
                     Client.groundItemDeque[class36.plane][var4][var5] = new Deque();
                  }

                  Client.groundItemDeque[class36.plane][var4][var5].addFront(var34);
                  Size.groundItemSpawned(var4, var5);
               }

            } else if(class183.field2489 == var0) {
               var2 = var1.readUnsignedByte();
               var3 = (var2 >> 4 & 7) + class28.field412;
               var4 = (var2 & 7) + class80.field1239;
               var5 = var1.method3583();
               var6 = var5 >> 2;
               var7 = var5 & 3;
               var8 = Client.field913[var6];
               if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                  class158.method3248(class36.plane, var3, var4, var8, -1, var6, var7, 0, -1);
               }

            } else if(class183.field2483 == var0) {
               var2 = var1.readUnsignedShort();
               var3 = var1.method3583();
               var4 = (var3 >> 4 & 7) + class28.field412;
               var5 = (var3 & 7) + class80.field1239;
               var6 = var1.method3618();
               var7 = var1.method3618();
               if(var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
                  Deque var32 = Client.groundItemDeque[class36.plane][var4][var5];
                  if(var32 != null) {
                     for(Item var35 = (Item)var32.getFront(); var35 != null; var35 = (Item)var32.getNext()) {
                        if((var2 & 32767) == var35.id && var7 == var35.quantity) {
                           var35.quantity = var6;
                           break;
                        }
                     }

                     Size.groundItemSpawned(var4, var5);
                  }
               }

            } else if(class183.field2482 == var0) {
               var2 = var1.method3618();
               var3 = var1.method3609();
               var4 = (var3 >> 4 & 7) + class28.field412;
               var5 = (var3 & 7) + class80.field1239;
               if(var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
                  Deque var36 = Client.groundItemDeque[class36.plane][var4][var5];
                  if(var36 != null) {
                     for(var34 = (Item)var36.getFront(); var34 != null; var34 = (Item)var36.getNext()) {
                        if((var2 & 32767) == var34.id) {
                           var34.unlink();
                           break;
                        }
                     }

                     if(var36.getFront() == null) {
                        Client.groundItemDeque[class36.plane][var4][var5] = null;
                     }

                     Size.groundItemSpawned(var4, var5);
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(Liw;II)I",
      garbageValue = "-168500387"
   )
   static final int method1078(Widget var0, int var1) {
      if(var0.dynamicValues != null && var1 < var0.dynamicValues.length) {
         try {
            int[] var2 = var0.dynamicValues[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = Client.boostedSkillLevels[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = Client.realSkillLevels[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = Client.skillExperiences[var2[var4++]];
               }

               int var9;
               Widget var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class5.getWidget(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class251.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class237.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class248.field3010[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class237.widgetSettings[var2[var4++]] * 100 / 46875;
               }

               if(var6 == 8) {
                  var7 = TotalQuantityComparator.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class248.field3008[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class5.getWidget(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class251.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = Client.energy;
               }

               if(var6 == 12) {
                  var7 = Client.weight;
               }

               if(var6 == 13) {
                  var9 = class237.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class57.getVarbit(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = (TotalQuantityComparator.localPlayer.x >> 7) + WorldMapType1.baseX;
               }

               if(var6 == 19) {
                  var7 = (TotalQuantityComparator.localPlayer.y >> 7) + Enum.baseY;
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }
}
