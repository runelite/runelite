import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
public class class57 {
   @ObfuscatedName("o")
   static Applet field674;
   @ObfuscatedName("k")
   public static String field667;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "[Lll;"
   )
   @Export("titlemuteSprite")
   static IndexedSprite[] titlemuteSprite;

   static {
      field674 = null;
      field667 = "";
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;S)V",
      garbageValue = "304"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      class20.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Llh;I)Ljava/lang/String;",
      garbageValue = "879307111"
   )
   public static String method861(CharSequence var0, JagexLoginType var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && WorldMapDecoration.method315(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2 && WorldMapDecoration.method315(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if(var4 >= 1) {
            byte var6;
            if(var1 == null) {
               var6 = 12;
            } else {
               switch(var1.field4073) {
               case 6:
                  var6 = 20;
                  break;
               default:
                  var6 = 12;
               }
            }

            if(var4 <= var6) {
               StringBuilder var13 = new StringBuilder(var4);

               for(int var14 = var2; var14 < var3; ++var14) {
                  char var7 = var0.charAt(var14);
                  boolean var8;
                  if(Character.isISOControl(var7)) {
                     var8 = false;
                  } else {
                     boolean var9 = var7 >= '0' && var7 <= '9' || var7 >= 'A' && var7 <= 'Z' || var7 >= 'a' && var7 <= 'z';
                     if(var9) {
                        var8 = true;
                     } else {
                        char[] var10 = class315.field3920;
                        int var11 = 0;

                        label96:
                        while(true) {
                           char var12;
                           if(var11 >= var10.length) {
                              var10 = class315.field3922;

                              for(var11 = 0; var11 < var10.length; ++var11) {
                                 var12 = var10[var11];
                                 if(var12 == var7) {
                                    var8 = true;
                                    break label96;
                                 }
                              }

                              var8 = false;
                              break;
                           }

                           var12 = var10[var11];
                           if(var7 == var12) {
                              var8 = true;
                              break;
                           }

                           ++var11;
                        }
                     }
                  }

                  if(var8) {
                     char var15 = ClanMember.method5259(var7);
                     if(var15 != 0) {
                        var13.append(var15);
                     }
                  }
               }

               if(var13.length() == 0) {
                  return null;
               }

               return var13.toString();
            }
         }

         return null;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BI)Lki;",
      garbageValue = "-1528138480"
   )
   static Font method868(byte[] var0) {
      if(var0 == null) {
         return null;
      } else {
         Font var1 = new Font(var0, class332.indexedSpriteOffsetXs, FileSystem.indexedSpriteOffsetYs, WorldMapDecoration.indexSpriteWidths, class332.indexedSpriteHeights, class332.indexedSpritePalette, class332.spritePixels);
         class36.method541();
         return var1;
      }
   }

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(Lgj;I)V",
      garbageValue = "233468918"
   )
   static final void method869(class183 var0) {
      PacketBuffer var1 = Client.field957.packetBuffer;
      int var2;
      int var3;
      int var5;
      int var6;
      int var7;
      int var8;
      int var37;
      int var39;
      int var43;
      if(class183.field2492 == var0) {
         var2 = var1.readUnsignedByte();
         var3 = (var2 >> 4 & 7) + WidgetNode.field794;
         var37 = (var2 & 7) + class278.field3551;
         var5 = var1.readUnsignedShortOb1();
         var6 = var5 >> 2;
         var7 = var5 & 3;
         var8 = Client.field929[var6];
         var39 = var1.method3553();
         if(var3 >= 0 && var37 >= 0 && var3 < 103 && var37 < 103) {
            if(var8 == 0) {
               WallObject var10 = class255.region.method2874(BoundingBox3DDrawMode.plane, var3, var37);
               if(var10 != null) {
                  var43 = var10.hash >> 14 & 32767;
                  if(var6 == 2) {
                     var10.renderable1 = new DynamicObject(var43, 2, var7 + 4, BoundingBox3DDrawMode.plane, var3, var37, var39, false, var10.renderable1);
                     var10.renderable2 = new DynamicObject(var43, 2, var7 + 1 & 3, BoundingBox3DDrawMode.plane, var3, var37, var39, false, var10.renderable2);
                  } else {
                     var10.renderable1 = new DynamicObject(var43, var6, var7, BoundingBox3DDrawMode.plane, var3, var37, var39, false, var10.renderable1);
                  }
               }
            }

            if(var8 == 1) {
               DecorativeObject var40 = class255.region.method2928(BoundingBox3DDrawMode.plane, var3, var37);
               if(var40 != null) {
                  var43 = var40.hash >> 14 & 32767;
                  if(var6 != 4 && var6 != 5) {
                     if(var6 == 6) {
                        var40.renderable1 = new DynamicObject(var43, 4, var7 + 4, BoundingBox3DDrawMode.plane, var3, var37, var39, false, var40.renderable1);
                     } else if(var6 == 7) {
                        var40.renderable1 = new DynamicObject(var43, 4, (var7 + 2 & 3) + 4, BoundingBox3DDrawMode.plane, var3, var37, var39, false, var40.renderable1);
                     } else if(var6 == 8) {
                        var40.renderable1 = new DynamicObject(var43, 4, var7 + 4, BoundingBox3DDrawMode.plane, var3, var37, var39, false, var40.renderable1);
                        var40.renderable2 = new DynamicObject(var43, 4, (var7 + 2 & 3) + 4, BoundingBox3DDrawMode.plane, var3, var37, var39, false, var40.renderable2);
                     }
                  } else {
                     var40.renderable1 = new DynamicObject(var43, 4, var7, BoundingBox3DDrawMode.plane, var3, var37, var39, false, var40.renderable1);
                  }
               }
            }

            if(var8 == 2) {
               GameObject var41 = class255.region.method2876(BoundingBox3DDrawMode.plane, var3, var37);
               if(var6 == 11) {
                  var6 = 10;
               }

               if(var41 != null) {
                  var41.renderable = new DynamicObject(var41.hash >> 14 & 32767, var6, var7, BoundingBox3DDrawMode.plane, var3, var37, var39, false, var41.renderable);
               }
            }

            if(var8 == 3) {
               GroundObject var42 = class255.region.getFloorDecoration(BoundingBox3DDrawMode.plane, var3, var37);
               if(var42 != null) {
                  var42.renderable = new DynamicObject(var42.hash >> 14 & 32767, 22, var7, BoundingBox3DDrawMode.plane, var3, var37, var39, false, var42.renderable);
               }
            }
         }

      } else {
         byte var11;
         int var12;
         int var13;
         int var14;
         int var44;
         if(class183.field2491 == var0) {
            var2 = var1.readUnsignedShortOb1() * 4;
            byte var38 = var1.method3725();
            var37 = var1.method3555();
            var5 = var1.readUnsignedByte();
            var6 = var1.method3553();
            var7 = var1.readUnsignedShort();
            var8 = var1.method3556();
            var39 = var1.readUnsignedByte();
            var44 = var1.readUnsignedShortOb1() * 4;
            var11 = var1.readByte();
            var12 = var1.readUnsignedByte();
            var13 = (var12 >> 4 & 7) + WidgetNode.field794;
            var14 = (var12 & 7) + class278.field3551;
            var3 = var38 + var13;
            var43 = var11 + var14;
            if(var13 >= 0 && var14 >= 0 && var13 < 104 && var14 < 104 && var3 >= 0 && var43 >= 0 && var3 < 104 && var43 < 104 && var6 != 65535) {
               var13 = var13 * 128 + 64;
               var14 = var14 * 128 + 64;
               var3 = var3 * 128 + 64;
               var43 = var43 * 128 + 64;
               Projectile var15 = new Projectile(var6, BoundingBox3DDrawMode.plane, var13, var14, class265.getTileHeight(var13, var14, BoundingBox3DDrawMode.plane) - var2, var7 + Client.gameCycle, var37 + Client.gameCycle, var5, var39, var8, var44);
               var15.moveProjectile(var3, var43, class265.getTileHeight(var3, var43, BoundingBox3DDrawMode.plane) - var44, var7 + Client.gameCycle);
               Client.projectiles.addFront(var15);
            }

         } else {
            if(class183.field2501 == var0) {
               var2 = var1.method3553();
               var3 = var1.method3553();
               byte var4 = var1.readByte();
               var5 = var1.readUnsignedByte();
               var6 = (var5 >> 4 & 7) + WidgetNode.field794;
               var7 = (var5 & 7) + class278.field3551;
               var8 = var1.readUnsignedShort();
               byte var9 = var1.method3634();
               byte var31 = var1.method3548();
               var11 = var1.method3725();
               var12 = var1.method3553();
               var13 = var1.readUnsignedShortOb1();
               var14 = var13 >> 2;
               int var32 = var13 & 3;
               int var16 = Client.field929[var14];
               Player var17;
               if(var8 == Client.localInteractingIndex) {
                  var17 = SoundTaskDataProvider.localPlayer;
               } else {
                  var17 = Client.cachedPlayers[var8];
               }

               if(var17 != null) {
                  ObjectComposition var18 = GameCanvas.getObjectDefinition(var12);
                  int var19;
                  int var20;
                  if(var32 != 1 && var32 != 3) {
                     var19 = var18.width;
                     var20 = var18.length;
                  } else {
                     var19 = var18.length;
                     var20 = var18.width;
                  }

                  int var21 = var6 + (var19 >> 1);
                  int var22 = var6 + (var19 + 1 >> 1);
                  int var23 = var7 + (var20 >> 1);
                  int var24 = var7 + (var20 + 1 >> 1);
                  int[][] var25 = class62.tileHeights[BoundingBox3DDrawMode.plane];
                  int var26 = var25[var22][var23] + var25[var21][var23] + var25[var21][var24] + var25[var22][var24] >> 2;
                  int var27 = (var6 << 7) + (var19 << 6);
                  int var28 = (var7 << 7) + (var20 << 6);
                  Model var29 = var18.method4999(var14, var32, var25, var27, var26, var28);
                  if(var29 != null) {
                     class264.method4683(BoundingBox3DDrawMode.plane, var6, var7, var16, -1, 0, 0, var3 + 1, var2 + 1);
                     var17.animationCycleStart = var3 + Client.gameCycle;
                     var17.animationCycleEnd = var2 + Client.gameCycle;
                     var17.model = var29;
                     var17.field845 = var6 * 128 + var19 * 64;
                     var17.field843 = var7 * 128 + var20 * 64;
                     var17.field858 = var26;
                     byte var30;
                     if(var4 > var31) {
                        var30 = var4;
                        var4 = var31;
                        var31 = var30;
                     }

                     if(var11 > var9) {
                        var30 = var11;
                        var11 = var9;
                        var9 = var30;
                     }

                     var17.field849 = var4 + var6;
                     var17.field851 = var31 + var6;
                     var17.field850 = var7 + var11;
                     var17.field852 = var9 + var7;
                  }
               }
            }

            if(class183.field2489 == var0) {
               var2 = var1.method3636();
               var3 = (var2 >> 4 & 7) + WidgetNode.field794;
               var37 = (var2 & 7) + class278.field3551;
               var5 = var1.method3636();
               var6 = var5 >> 2;
               var7 = var5 & 3;
               var8 = Client.field929[var6];
               if(var3 >= 0 && var37 >= 0 && var3 < 104 && var37 < 104) {
                  class264.method4683(BoundingBox3DDrawMode.plane, var3, var37, var8, -1, var6, var7, 0, -1);
               }

            } else if(class183.field2490 == var0) {
               var2 = var1.method3555();
               var3 = var1.readUnsignedByte();
               var37 = (var3 >> 4 & 7) + WidgetNode.field794;
               var5 = (var3 & 7) + class278.field3551;
               var6 = var1.method3555();
               var7 = var1.method3554();
               if(var37 >= 0 && var5 >= 0 && var37 < 104 && var5 < 104) {
                  Deque var45 = Client.groundItemDeque[BoundingBox3DDrawMode.plane][var37][var5];
                  if(var45 != null) {
                     for(Item var34 = (Item)var45.getFront(); var34 != null; var34 = (Item)var45.getNext()) {
                        if((var7 & 32767) == var34.id && var6 == var34.quantity) {
                           var34.quantity = var2;
                           break;
                        }
                     }

                     class18.groundItemSpawned(var37, var5);
                  }
               }

            } else if(class183.field2497 == var0) {
               var2 = var1.method3538();
               var3 = (var2 >> 4 & 7) + WidgetNode.field794;
               var37 = (var2 & 7) + class278.field3551;
               var5 = var1.method3553();
               var6 = var1.method3636();
               var7 = var1.method3554();
               if(var3 >= 0 && var37 >= 0 && var3 < 104 && var37 < 104) {
                  var3 = var3 * 128 + 64;
                  var37 = var37 * 128 + 64;
                  GraphicsObject var33 = new GraphicsObject(var7, BoundingBox3DDrawMode.plane, var3, var37, class265.getTileHeight(var3, var37, BoundingBox3DDrawMode.plane) - var6, var5, Client.gameCycle);
                  Client.graphicsObjectDeque.addFront(var33);
               }

            } else {
               if(class183.field2495 == var0) {
                  var2 = var1.readUnsignedShortOb1();
                  var3 = (var2 >> 4 & 7) + WidgetNode.field794;
                  var37 = (var2 & 7) + class278.field3551;
                  var5 = var1.method3636();
                  var6 = var5 >> 4 & 15;
                  var7 = var5 & 7;
                  var8 = var1.readUnsignedByte();
                  var39 = var1.method3554();
                  if(var3 >= 0 && var37 >= 0 && var3 < 104 && var37 < 104) {
                     var44 = var6 + 1;
                     if(SoundTaskDataProvider.localPlayer.pathX[0] >= var3 - var44 && SoundTaskDataProvider.localPlayer.pathX[0] <= var3 + var44 && SoundTaskDataProvider.localPlayer.pathY[0] >= var37 - var44 && SoundTaskDataProvider.localPlayer.pathY[0] <= var37 + var44 && Client.field951 != 0 && var7 > 0 && Client.queuedSoundEffectCount < 50) {
                        Client.queuedSoundEffectIDs[Client.queuedSoundEffectCount] = var39;
                        Client.unknownSoundValues1[Client.queuedSoundEffectCount] = var7;
                        Client.unknownSoundValues2[Client.queuedSoundEffectCount] = var8;
                        Client.audioEffects[Client.queuedSoundEffectCount] = null;
                        Client.soundLocations[Client.queuedSoundEffectCount] = var6 + (var37 << 8) + (var3 << 16);
                        ++Client.queuedSoundEffectCount;
                     }
                  }
               }

               Item var35;
               if(class183.field2494 == var0) {
                  var2 = var1.method3636();
                  var3 = (var2 >> 4 & 7) + WidgetNode.field794;
                  var37 = (var2 & 7) + class278.field3551;
                  var5 = var1.method3553();
                  var6 = var1.method3555();
                  if(var3 >= 0 && var37 >= 0 && var3 < 104 && var37 < 104) {
                     var35 = new Item();
                     var35.id = var5;
                     var35.quantity = var6;
                     if(Client.groundItemDeque[BoundingBox3DDrawMode.plane][var3][var37] == null) {
                        Client.groundItemDeque[BoundingBox3DDrawMode.plane][var3][var37] = new Deque();
                     }

                     Client.groundItemDeque[BoundingBox3DDrawMode.plane][var3][var37].addFront(var35);
                     class18.groundItemSpawned(var3, var37);
                  }

               } else if(class183.field2498 == var0) {
                  var2 = var1.readUnsignedByte();
                  var3 = (var2 >> 4 & 7) + WidgetNode.field794;
                  var37 = (var2 & 7) + class278.field3551;
                  var5 = var1.method3553();
                  var6 = var1.readUnsignedShortOb1();
                  var7 = var6 >> 2;
                  var8 = var6 & 3;
                  var39 = Client.field929[var7];
                  if(var3 >= 0 && var37 >= 0 && var3 < 104 && var37 < 104) {
                     class264.method4683(BoundingBox3DDrawMode.plane, var3, var37, var39, var5, var7, var8, 0, -1);
                  }

               } else if(class183.field2493 == var0) {
                  var2 = var1.readUnsignedByte();
                  var3 = (var2 >> 4 & 7) + WidgetNode.field794;
                  var37 = (var2 & 7) + class278.field3551;
                  var5 = var1.readUnsignedShort();
                  if(var3 >= 0 && var37 >= 0 && var3 < 104 && var37 < 104) {
                     Deque var36 = Client.groundItemDeque[BoundingBox3DDrawMode.plane][var3][var37];
                     if(var36 != null) {
                        for(var35 = (Item)var36.getFront(); var35 != null; var35 = (Item)var36.getNext()) {
                           if((var5 & 32767) == var35.id) {
                              var35.unlink();
                              break;
                           }
                        }

                        if(var36.getFront() == null) {
                           Client.groundItemDeque[BoundingBox3DDrawMode.plane][var3][var37] = null;
                        }

                        class18.groundItemSpawned(var3, var37);
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("jb")
   @ObfuscatedSignature(
      signature = "(Lbt;ZB)V",
      garbageValue = "0"
   )
   @Export("closeWidget")
   static final void closeWidget(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1 && var2 != -1 && class154.validInterfaces[var2]) {
         UrlRequest.widgetIndex.method4543(var2);
         if(MouseRecorder.widgets[var2] != null) {
            boolean var6 = true;

            for(int var5 = 0; var5 < MouseRecorder.widgets[var2].length; ++var5) {
               if(MouseRecorder.widgets[var2][var5] != null) {
                  if(MouseRecorder.widgets[var2][var5].type != 2) {
                     MouseRecorder.widgets[var2][var5] = null;
                  } else {
                     var6 = false;
                  }
               }
            }

            if(var6) {
               MouseRecorder.widgets[var2] = null;
            }

            class154.validInterfaces[var2] = false;
         }
      }

      for(IntegerNode var4 = (IntegerNode)Client.widgetFlags.first(); var4 != null; var4 = (IntegerNode)Client.widgetFlags.next()) {
         if((var4.hash >> 48 & 65535L) == (long)var2) {
            var4.unlink();
         }
      }

      Widget var7 = class44.getWidget(var3);
      if(var7 != null) {
         FontName.method5490(var7);
      }

      ScriptState.method1109();
      if(Client.widgetRoot != -1) {
         DynamicObject.method2026(Client.widgetRoot, 1);
      }

   }
}
