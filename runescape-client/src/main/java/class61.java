import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
public final class class61 {
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = 594851983
   )
   static int field711;
   @ObfuscatedName("b")
   @Export("tileHeights")
   static int[][][] tileHeights;
   @ObfuscatedName("s")
   @Export("tileSettings")
   static byte[][][] tileSettings;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2063217609
   )
   static int field705;
   @ObfuscatedName("f")
   static byte[][][] field702;
   @ObfuscatedName("k")
   static int[][] field703;
   @ObfuscatedName("n")
   static int[] field706;
   @ObfuscatedName("d")
   static int[] field707;
   @ObfuscatedName("o")
   static int[] field719;
   @ObfuscatedName("y")
   static final int[] field709;
   @ObfuscatedName("p")
   static final int[] field710;
   @ObfuscatedName("i")
   static final int[] field704;
   @ObfuscatedName("l")
   static final int[] field721;
   @ObfuscatedName("z")
   static final int[] field713;
   @ObfuscatedName("e")
   static final int[] field714;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -288977379
   )
   static int field715;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -612059797
   )
   static int field716;
   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("indexTrack2")
   static IndexData indexTrack2;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field705 = 99;
      field709 = new int[]{1, 2, 4, 8};
      field710 = new int[]{16, 32, 64, 128};
      field704 = new int[]{1, 0, -1, 0};
      field721 = new int[]{0, -1, 0, 1};
      field713 = new int[]{1, -1, -1, 1};
      field714 = new int[]{-1, -1, 1, 1};
      field715 = (int)(Math.random() * 17.0D) - 8;
      field716 = (int)(Math.random() * 33.0D) - 16;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "133135245"
   )
   @Export("parseInt")
   public static int parseInt(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == '-') {
                  var3 = true;
                  continue;
               }

               if(var8 == '+') {
                  continue;
               }
            }

            int var10;
            if(var8 >= '0' && var8 <= '9') {
               var10 = var8 - '0';
            } else if(var8 >= 'A' && var8 <= 'Z') {
               var10 = var8 - '7';
            } else {
               if(var8 < 'a' || var8 > 'z') {
                  throw new NumberFormatException();
               }

               var10 = var8 - 'W';
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(Lbw;I)V",
      garbageValue = "637374611"
   )
   static final void method997(Actor var0) {
      var0.field1147 = false;
      Sequence var1;
      if(var0.poseAnimation != -1) {
         var1 = class90.getAnimation(var0.poseAnimation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.field1175;
            if(var0.poseFrame < var1.frameIDs.length && var0.field1175 > var1.frameLenghts[var0.poseFrame]) {
               var0.field1175 = 1;
               ++var0.poseFrame;
               GameEngine.method899(var1, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var1.frameIDs.length) {
               var0.field1175 = 0;
               var0.poseFrame = 0;
               GameEngine.method899(var1, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.graphicsDelay) {
         if(var0.field1190 < 0) {
            var0.field1190 = 0;
         }

         int var3 = class245.getSpotAnimType(var0.graphic).field3387;
         if(var3 != -1) {
            Sequence var2 = class90.getAnimation(var3);
            if(var2 != null && var2.frameIDs != null) {
               ++var0.field1183;
               if(var0.field1190 < var2.frameIDs.length && var0.field1183 > var2.frameLenghts[var0.field1190]) {
                  var0.field1183 = 1;
                  ++var0.field1190;
                  GameEngine.method899(var2, var0.field1190, var0.x, var0.y);
               }

               if(var0.field1190 >= var2.frameIDs.length && (var0.field1190 < 0 || var0.field1190 >= var2.frameIDs.length)) {
                  var0.graphic = -1;
               }
            } else {
               var0.graphic = -1;
            }
         } else {
            var0.graphic = -1;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable <= 1) {
         var1 = class90.getAnimation(var0.animation);
         if(var1.precedenceAnimating == 1 && var0.field1203 > 0 && var0.field1178 <= Client.gameCycle && var0.field1191 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var1 = class90.getAnimation(var0.animation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.field1144;
            if(var0.actionFrame < var1.frameIDs.length && var0.field1144 > var1.frameLenghts[var0.actionFrame]) {
               var0.field1144 = 1;
               ++var0.actionFrame;
               GameEngine.method899(var1, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var1.frameIDs.length) {
               var0.actionFrame -= var1.frameStep;
               ++var0.field1188;
               if(var0.field1188 >= var1.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var1.frameIDs.length) {
                  GameEngine.method899(var1, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field1147 = var1.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(Lfu;S)V",
      garbageValue = "27193"
   )
   static final void method973(class169 var0) {
      PacketBuffer var1 = Client.field905.field1461;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var37;
      int var38;
      if(class169.field2409 == var0) {
         var37 = var1.readUnsignedShortOb1();
         var38 = (var37 >> 4 & 7) + PacketNode.field2415;
         var4 = (var37 & 7) + ClanMember.field861;
         var5 = var1.readUnsignedShort();
         var6 = var1.method3214();
         var7 = var6 >> 2;
         var8 = var6 & 3;
         var9 = Client.field1076[var7];
         if(var38 >= 0 && var4 >= 0 && var38 < 103 && var4 < 103) {
            if(var9 == 0) {
               WallObject var10 = Client.region.method2710(class28.plane, var38, var4);
               if(var10 != null) {
                  var11 = var10.hash >> 14 & 32767;
                  if(var7 == 2) {
                     var10.renderable1 = new DynamicObject(var11, 2, var8 + 4, class28.plane, var38, var4, var5, false, var10.renderable1);
                     var10.renderable2 = new DynamicObject(var11, 2, var8 + 1 & 3, class28.plane, var38, var4, var5, false, var10.renderable2);
                  } else {
                     var10.renderable1 = new DynamicObject(var11, var7, var8, class28.plane, var38, var4, var5, false, var10.renderable1);
                  }
               }
            }

            if(var9 == 1) {
               DecorativeObject var40 = Client.region.method2711(class28.plane, var38, var4);
               if(var40 != null) {
                  var11 = var40.hash >> 14 & 32767;
                  if(var7 != 4 && var7 != 5) {
                     if(var7 == 6) {
                        var40.renderable1 = new DynamicObject(var11, 4, var8 + 4, class28.plane, var38, var4, var5, false, var40.renderable1);
                     } else if(var7 == 7) {
                        var40.renderable1 = new DynamicObject(var11, 4, (var8 + 2 & 3) + 4, class28.plane, var38, var4, var5, false, var40.renderable1);
                     } else if(var7 == 8) {
                        var40.renderable1 = new DynamicObject(var11, 4, var8 + 4, class28.plane, var38, var4, var5, false, var40.renderable1);
                        var40.renderable2 = new DynamicObject(var11, 4, (var8 + 2 & 3) + 4, class28.plane, var38, var4, var5, false, var40.renderable2);
                     }
                  } else {
                     var40.renderable1 = new DynamicObject(var11, 4, var8, class28.plane, var38, var4, var5, false, var40.renderable1);
                  }
               }
            }

            if(var9 == 2) {
               GameObject var41 = Client.region.method2712(class28.plane, var38, var4);
               if(var7 == 11) {
                  var7 = 10;
               }

               if(var41 != null) {
                  var41.renderable = new DynamicObject(var41.hash >> 14 & 32767, var7, var8, class28.plane, var38, var4, var5, false, var41.renderable);
               }
            }

            if(var9 == 3) {
               GroundObject var42 = Client.region.method2713(class28.plane, var38, var4);
               if(var42 != null) {
                  var42.renderable = new DynamicObject(var42.hash >> 14 & 32767, 22, var8, class28.plane, var38, var4, var5, false, var42.renderable);
               }
            }
         }

      } else if(class169.field2406 == var0) {
         var37 = var1.readUnsignedShortOb1();
         var38 = var37 >> 2;
         var4 = var37 & 3;
         var5 = Client.field1076[var38];
         var6 = var1.method3214();
         var7 = (var6 >> 4 & 7) + PacketNode.field2415;
         var8 = (var6 & 7) + ClanMember.field861;
         if(var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104) {
            class20.method150(class28.plane, var7, var8, var5, -1, var38, var4, 0, -1);
         }

      } else {
         int var12;
         int var13;
         int var14;
         int var31;
         if(class169.field2413 == var0) {
            var37 = var1.readUnsignedShortOb1() * 4;
            var38 = var1.method3214() * 4;
            var4 = var1.readUnsignedByte();
            var5 = (var4 >> 4 & 7) + PacketNode.field2415;
            var6 = (var4 & 7) + ClanMember.field861;
            var7 = var1.method3222();
            var8 = var1.readUnsignedByte();
            byte var39 = var1.method3278();
            var31 = var1.method3222();
            byte var43 = var1.method3216();
            var12 = var1.method3188();
            var13 = var1.method3222();
            var14 = var1.readUnsignedShortOb1();
            var11 = var43 + var5;
            var9 = var39 + var6;
            if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104 && var11 >= 0 && var9 >= 0 && var11 < 104 && var9 < 104 && var13 != 65535) {
               var5 = var5 * 128 + 64;
               var6 = var6 * 128 + 64;
               var11 = var11 * 128 + 64;
               var9 = var9 * 128 + 64;
               Projectile var15 = new Projectile(var13, class28.plane, var5, var6, class18.getTileHeight(var5, var6, class28.plane) - var38, var31 + Client.gameCycle, var7 + Client.gameCycle, var14, var8, var12, var37);
               var15.method1747(var11, var9, class18.getTileHeight(var11, var9, class28.plane) - var37, var31 + Client.gameCycle);
               Client.projectiles.addFront(var15);
            }

         } else if(class169.field2412 == var0) {
            var37 = var1.method3222();
            var38 = var1.method3215();
            var4 = (var38 >> 4 & 7) + PacketNode.field2415;
            var5 = (var38 & 7) + ClanMember.field861;
            var6 = var1.method3290();
            var7 = var1.method3214();
            if(var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
               var4 = var4 * 128 + 64;
               var5 = var5 * 128 + 64;
               GraphicsObject var44 = new GraphicsObject(var6, class28.plane, var4, var5, class18.getTileHeight(var4, var5, class28.plane) - var7, var37, Client.gameCycle);
               Client.graphicsObjectDeque.addFront(var44);
            }

         } else {
            Item var34;
            if(class169.field2414 == var0) {
               var37 = var1.readUnsignedByte();
               var38 = (var37 >> 4 & 7) + PacketNode.field2415;
               var4 = (var37 & 7) + ClanMember.field861;
               var5 = var1.method3222();
               if(var38 >= 0 && var4 >= 0 && var38 < 104 && var4 < 104) {
                  Deque var33 = Client.groundItemDeque[class28.plane][var38][var4];
                  if(var33 != null) {
                     for(var34 = (Item)var33.getFront(); var34 != null; var34 = (Item)var33.getNext()) {
                        if((var5 & 32767) == var34.id) {
                           var34.unlink();
                           break;
                        }
                     }

                     if(var33.getFront() == null) {
                        Client.groundItemDeque[class28.plane][var38][var4] = null;
                     }

                     ScriptEvent.groundItemSpawned(var38, var4);
                  }
               }

            } else {
               if(class169.field2404 == var0) {
                  byte var2 = var1.method3189();
                  byte var3 = var1.method3189();
                  var4 = var1.method3290();
                  var5 = var1.method3224();
                  var6 = var1.readUnsignedShort();
                  var7 = var1.method3224();
                  var8 = var1.readUnsignedShortOb1();
                  var9 = var8 >> 2;
                  var31 = var8 & 3;
                  var11 = Client.field1076[var9];
                  var12 = var1.method3215();
                  var13 = (var12 >> 4 & 7) + PacketNode.field2415;
                  var14 = (var12 & 7) + ClanMember.field861;
                  byte var35 = var1.readByte();
                  byte var16 = var1.method3216();
                  Player var17;
                  if(var4 == Client.localInteractingIndex) {
                     var17 = class275.localPlayer;
                  } else {
                     var17 = Client.cachedPlayers[var4];
                  }

                  if(var17 != null) {
                     ObjectComposition var18 = ClientPacket.getObjectDefinition(var7);
                     int var19;
                     int var20;
                     if(var31 != 1 && var31 != 3) {
                        var19 = var18.sizeX;
                        var20 = var18.sizeY;
                     } else {
                        var19 = var18.sizeY;
                        var20 = var18.sizeX;
                     }

                     int var21 = var13 + (var19 >> 1);
                     int var22 = var13 + (var19 + 1 >> 1);
                     int var23 = var14 + (var20 >> 1);
                     int var24 = var14 + (var20 + 1 >> 1);
                     int[][] var25 = tileHeights[class28.plane];
                     int var26 = var25[var21][var24] + var25[var22][var23] + var25[var21][var23] + var25[var22][var24] >> 2;
                     int var27 = (var13 << 7) + (var19 << 6);
                     int var28 = (var14 << 7) + (var20 << 6);
                     Model var29 = var18.method4545(var9, var31, var25, var27, var26, var28);
                     if(var29 != null) {
                        class20.method150(class28.plane, var13, var14, var11, -1, 0, 0, var6 + 1, var5 + 1);
                        var17.field839 = var6 + Client.gameCycle;
                        var17.field837 = var5 + Client.gameCycle;
                        var17.model = var29;
                        var17.field824 = var13 * 128 + var19 * 64;
                        var17.field826 = var14 * 128 + var20 * 64;
                        var17.field823 = var26;
                        byte var30;
                        if(var2 > var35) {
                           var30 = var2;
                           var2 = var35;
                           var35 = var30;
                        }

                        if(var16 > var3) {
                           var30 = var16;
                           var16 = var3;
                           var3 = var30;
                        }

                        var17.field828 = var2 + var13;
                        var17.field830 = var13 + var35;
                        var17.field829 = var14 + var16;
                        var17.field831 = var3 + var14;
                     }
                  }
               }

               if(class169.field2405 != var0) {
                  if(class169.field2410 == var0) {
                     var37 = var1.readUnsignedByte();
                     var38 = (var37 >> 4 & 7) + PacketNode.field2415;
                     var4 = (var37 & 7) + ClanMember.field861;
                     var5 = var1.method3222();
                     var6 = var1.readUnsignedShortOb1();
                     var7 = var6 >> 2;
                     var8 = var6 & 3;
                     var9 = Client.field1076[var7];
                     if(var38 >= 0 && var4 >= 0 && var38 < 104 && var4 < 104) {
                        class20.method150(class28.plane, var38, var4, var9, var5, var7, var8, 0, -1);
                     }

                  } else {
                     if(class169.field2408 == var0) {
                        var37 = var1.readUnsignedByte();
                        var38 = var1.method3215();
                        var4 = (var38 >> 4 & 7) + PacketNode.field2415;
                        var5 = (var38 & 7) + ClanMember.field861;
                        var6 = var1.readUnsignedShort();
                        var7 = var1.method3214();
                        var8 = var7 >> 4 & 15;
                        var9 = var7 & 7;
                        if(var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
                           var31 = var8 + 1;
                           if(class275.localPlayer.pathX[0] >= var4 - var31 && class275.localPlayer.pathX[0] <= var31 + var4 && class275.localPlayer.pathY[0] >= var5 - var31 && class275.localPlayer.pathY[0] <= var5 + var31 && Client.field1051 != 0 && var9 > 0 && Client.field1031 < 50) {
                              Client.field956[Client.field1031] = var6;
                              Client.field986[Client.field1031] = var9;
                              Client.field1086[Client.field1031] = var37;
                              Client.audioEffects[Client.field1031] = null;
                              Client.field1092[Client.field1031] = var8 + (var5 << 8) + (var4 << 16);
                              ++Client.field1031;
                           }
                        }
                     }

                     if(class169.field2407 == var0) {
                        var37 = var1.method3222();
                        var38 = var1.method3222();
                        var4 = var1.method3215();
                        var5 = (var4 >> 4 & 7) + PacketNode.field2415;
                        var6 = (var4 & 7) + ClanMember.field861;
                        if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                           var34 = new Item();
                           var34.id = var38;
                           var34.quantity = var37;
                           if(Client.groundItemDeque[class28.plane][var5][var6] == null) {
                              Client.groundItemDeque[class28.plane][var5][var6] = new Deque();
                           }

                           Client.groundItemDeque[class28.plane][var5][var6].addFront(var34);
                           ScriptEvent.groundItemSpawned(var5, var6);
                        }

                     }
                  }
               } else {
                  var37 = var1.method3290();
                  var38 = var1.method3290();
                  var4 = var1.readUnsignedByte();
                  var5 = (var4 >> 4 & 7) + PacketNode.field2415;
                  var6 = (var4 & 7) + ClanMember.field861;
                  var7 = var1.method3224();
                  if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                     Deque var32 = Client.groundItemDeque[class28.plane][var5][var6];
                     if(var32 != null) {
                        for(Item var36 = (Item)var32.getFront(); var36 != null; var36 = (Item)var32.getNext()) {
                           if((var7 & 32767) == var36.id && var38 == var36.quantity) {
                              var36.quantity = var37;
                              break;
                           }
                        }

                        ScriptEvent.groundItemSpawned(var5, var6);
                     }
                  }

               }
            }
         }
      }
   }
}
