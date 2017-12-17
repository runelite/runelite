import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
@Implements("FriendLoginUpdate")
public class FriendLoginUpdate extends Link {
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = -924167109
   )
   static int field751;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1347425195
   )
   static int field754;
   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "[Lks;"
   )
   static SpritePixels[] field760;
   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("indexWorldMap")
   static IndexData indexWorldMap;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 282769357
   )
   int field758;
   @ObfuscatedName("w")
   String field752;
   @ObfuscatedName("e")
   short field753;

   FriendLoginUpdate(String var1, int var2) {
      this.field758 = (int)(Preferences.currentTimeMs() / 1000L);
      this.field752 = var1;
      this.field753 = (short)var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-875870287"
   )
   static int method1044() {
      return ++class96.field1416 - 1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1763239430"
   )
   static final boolean method1040() {
      return class133.Viewport_containsMouse;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Lck;",
      garbageValue = "-1289975346"
   )
   static Script method1043(int var0) {
      Script var1 = (Script)Script.field1431.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class161.indexScripts.getConfigData(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = WidgetNode.newScript(var2);
            Script.field1431.put(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIIIILeh;Lfp;I)V",
      garbageValue = "-1994835977"
   )
   @Export("addObject")
   static final void addObject(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.lowMemory || (class61.tileSettings[0][var1][var2] & 2) != 0 || (class61.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class61.field694) {
            class61.field694 = var0;
         }

         ObjectComposition var8 = CacheFile.getObjectDefinition(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.sizeX;
            var10 = var8.sizeY;
         } else {
            var9 = var8.sizeY;
            var10 = var8.sizeX;
         }

         int var11;
         int var12;
         if(var9 + var1 <= 104) {
            var11 = (var9 >> 1) + var1;
            var12 = (var9 + 1 >> 1) + var1;
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = (var10 >> 1) + var2;
            var14 = var2 + (var10 + 1 >> 1);
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = class61.tileHeights[var0];
         int var16 = var15[var12][var14] + var15[var11][var13] + var15[var12][var13] + var15[var11][var14] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = (var3 << 14) + (var2 << 7) + var1 + 1073741824;
         if(var8.int1 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.int3 == 1) {
            var20 += 256;
         }

         int var22;
         int var23;
         if(var8.method4670()) {
            class81 var21 = new class81();
            var21.field1225 = var0;
            var21.field1223 = var1 * 128;
            var21.field1224 = var2 * 128;
            var22 = var8.sizeX;
            var23 = var8.sizeY;
            if(var4 == 1 || var4 == 3) {
               var22 = var8.sizeY;
               var23 = var8.sizeX;
            }

            var21.field1232 = (var22 + var1) * 128;
            var21.field1236 = (var23 + var2) * 128;
            var21.field1228 = var8.ambientSoundId;
            var21.field1221 = var8.int4 * 128;
            var21.field1230 = var8.int5;
            var21.field1231 = var8.int6;
            var21.field1226 = var8.field3540;
            if(var8.impostorIds != null) {
               var21.field1227 = var8;
               var21.method1540();
            }

            class81.field1235.addFront(var21);
            if(var21.field1226 != null) {
               var21.field1233 = var21.field1230 + (int)(Math.random() * (double)(var21.field1231 - var21.field1230));
            }
         }

         Object var30;
         if(var5 == 22) {
            if(!Client.lowMemory || var8.int1 != 0 || var8.interactType == 1 || var8.boolean2) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.getModel(22, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var30, var19, var20);
               if(var8.interactType == 1 && var7 != null) {
                  var7.method3150(var1, var2);
               }

            }
         } else if(var5 != 10 && var5 != 11) {
            if(var5 >= 12) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.getModel(var5, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.method2700(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
               if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                  TextureProvider.field1667[var0][var1][var2] |= 2340;
               }

               if(var8.interactType != 0 && var7 != null) {
                  var7.addObject(var1, var2, var9, var10, var8.boolean1);
               }

            } else if(var5 == 0) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.getModel(0, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field701[var4], 0, var19, var20);
               if(var4 == 0) {
                  if(var8.clipped) {
                     class96.field1418[var0][var1][var2] = 50;
                     class96.field1418[var0][var1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     TextureProvider.field1667[var0][var1][var2] |= 585;
                  }
               } else if(var4 == 1) {
                  if(var8.clipped) {
                     class96.field1418[var0][var1][var2 + 1] = 50;
                     class96.field1418[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     TextureProvider.field1667[var0][var1][var2 + 1] |= 1170;
                  }
               } else if(var4 == 2) {
                  if(var8.clipped) {
                     class96.field1418[var0][var1 + 1][var2] = 50;
                     class96.field1418[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     TextureProvider.field1667[var0][var1 + 1][var2] |= 585;
                  }
               } else if(var4 == 3) {
                  if(var8.clipped) {
                     class96.field1418[var0][var1][var2] = 50;
                     class96.field1418[var0][var1 + 1][var2] = 50;
                  }

                  if(var8.modelClipped) {
                     TextureProvider.field1667[var0][var1][var2] |= 1170;
                  }
               }

               if(var8.interactType != 0 && var7 != null) {
                  var7.method3130(var1, var2, var5, var4, var8.boolean1);
               }

               if(var8.int2 != 16) {
                  var6.method2769(var0, var1, var2, var8.int2);
               }

            } else if(var5 == 1) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.getModel(1, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field703[var4], 0, var19, var20);
               if(var8.clipped) {
                  if(var4 == 0) {
                     class96.field1418[var0][var1][var2 + 1] = 50;
                  } else if(var4 == 1) {
                     class96.field1418[var0][var1 + 1][var2 + 1] = 50;
                  } else if(var4 == 2) {
                     class96.field1418[var0][var1 + 1][var2] = 50;
                  } else if(var4 == 3) {
                     class96.field1418[var0][var1][var2] = 50;
                  }
               }

               if(var8.interactType != 0 && var7 != null) {
                  var7.method3130(var1, var2, var5, var4, var8.boolean1);
               }

            } else {
               int var26;
               Object var28;
               if(var5 == 2) {
                  var26 = var4 + 1 & 3;
                  Object var27;
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var27 = var8.getModel(2, var4 + 4, var15, var17, var16, var18);
                     var28 = var8.getModel(2, var26, var15, var17, var16, var18);
                  } else {
                     var27 = new DynamicObject(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     var28 = new DynamicObject(var3, 2, var26, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var27, (Renderable)var28, class61.field701[var4], class61.field701[var26], var19, var20);
                  if(var8.modelClipped) {
                     if(var4 == 0) {
                        TextureProvider.field1667[var0][var1][var2] |= 585;
                        TextureProvider.field1667[var0][var1][var2 + 1] |= 1170;
                     } else if(var4 == 1) {
                        TextureProvider.field1667[var0][var1][1 + var2] |= 1170;
                        TextureProvider.field1667[var0][var1 + 1][var2] |= 585;
                     } else if(var4 == 2) {
                        TextureProvider.field1667[var0][var1 + 1][var2] |= 585;
                        TextureProvider.field1667[var0][var1][var2] |= 1170;
                     } else if(var4 == 3) {
                        TextureProvider.field1667[var0][var1][var2] |= 1170;
                        TextureProvider.field1667[var0][var1][var2] |= 585;
                     }
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.method3130(var1, var2, var5, var4, var8.boolean1);
                  }

                  if(var8.int2 != 16) {
                     var6.method2769(var0, var1, var2, var8.int2);
                  }

               } else if(var5 == 3) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(3, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field703[var4], 0, var19, var20);
                  if(var8.clipped) {
                     if(var4 == 0) {
                        class96.field1418[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class96.field1418[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class96.field1418[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class96.field1418[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.method3130(var1, var2, var5, var4, var8.boolean1);
                  }

               } else if(var5 == 9) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(var5, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2700(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
                  if(var8.interactType != 0 && var7 != null) {
                     var7.addObject(var1, var2, var9, var10, var8.boolean1);
                  }

                  if(var8.int2 != 16) {
                     var6.method2769(var0, var1, var2, var8.int2);
                  }

               } else if(var5 == 4) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(4, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field701[var4], 0, 0, 0, var19, var20);
               } else if(var5 == 5) {
                  var26 = 16;
                  var22 = var6.method2716(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = CacheFile.getObjectDefinition(var22 >> 14 & 32767).int2;
                  }

                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.getModel(4, var4, var15, var17, var16, var18);
                  } else {
                     var28 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, class61.field701[var4], 0, var26 * class61.field704[var4], var26 * class61.field702[var4], var19, var20);
               } else if(var5 == 6) {
                  var26 = 8;
                  var22 = var6.method2716(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = CacheFile.getObjectDefinition(var22 >> 14 & 32767).int2 / 2;
                  }

                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                  } else {
                     var28 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, 256, var4, var26 * class61.field705[var4], var26 * class61.field706[var4], var19, var20);
               } else if(var5 == 7) {
                  var22 = var4 + 2 & 3;
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(4, var22 + 4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, 4, var22 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, 256, var22, 0, 0, var19, var20);
               } else if(var5 == 8) {
                  var26 = 8;
                  var22 = var6.method2716(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = CacheFile.getObjectDefinition(var22 >> 14 & 32767).int2 / 2;
                  }

                  int var25 = var4 + 2 & 3;
                  Object var29;
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                     var29 = var8.getModel(4, var25 + 4, var15, var17, var16, var18);
                  } else {
                     var28 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     var29 = new DynamicObject(var3, 4, var25 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)var29, 256, var4, var26 * class61.field705[var4], var26 * class61.field706[var4], var19, var20);
               }
            }
         } else {
            if(var8.animationId == -1 && var8.impostorIds == null) {
               var30 = var8.getModel(10, var4, var15, var17, var16, var18);
            } else {
               var30 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
            }

            if(var30 != null && var6.method2700(var0, var1, var2, var16, var9, var10, (Renderable)var30, var5 == 11?256:0, var19, var20) && var8.clipped) {
               var22 = 15;
               if(var30 instanceof Model) {
                  var22 = ((Model)var30).method2515() / 4;
                  if(var22 > 30) {
                     var22 = 30;
                  }
               }

               for(var23 = 0; var23 <= var9; ++var23) {
                  for(int var24 = 0; var24 <= var10; ++var24) {
                     if(var22 > class96.field1418[var0][var23 + var1][var24 + var2]) {
                        class96.field1418[var0][var23 + var1][var24 + var2] = (byte)var22;
                     }
                  }
               }
            }

            if(var8.interactType != 0 && var7 != null) {
               var7.addObject(var1, var2, var9, var10, var8.boolean1);
            }

         }
      }
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "(Lbt;ZI)V",
      garbageValue = "1594876715"
   )
   static final void method1042(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1) {
         Varbit.method4570(var2);
      }

      KeyFocusListener.method750(var2);
      Widget var4 = VertexNormal.getWidget(var3);
      if(var4 != null) {
         class33.method344(var4);
      }

      GrandExchangeEvent.method82();
      if(Client.widgetRoot != -1) {
         int var5 = Client.widgetRoot;
         if(GraphicsObject.loadWidget(var5)) {
            class22.method165(Widget.widgets[var5], 1);
         }
      }

   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1683928681"
   )
   public static boolean method1041() {
      return Client.rights >= 2;
   }
}
