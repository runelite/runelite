import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
public final class class9 {
   @ObfuscatedName("gp")
   static Widget field83;
   @ObfuscatedName("bx")
   static IndexData field84;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIIILRegion;LCollisionData;I)V",
      garbageValue = "-1081546478"
   )
   static final void method107(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.field285 || (class10.tileSettings[0][var1][var2] & 2) != 0 || (class10.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class10.field93) {
            class10.field93 = var0;
         }

         ObjectComposition var8 = class26.getObjectDefinition(var3);
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
            var12 = var1 + (var9 + 1 >> 1);
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = var2 + (var10 >> 1);
            var14 = var2 + (var10 + 1 >> 1);
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = class10.tileHeights[var0];
         int var16 = var15[var11][var13] + var15[var12][var13] + var15[var11][var14] + var15[var12][var14] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var10 << 6) + (var2 << 7);
         int var19 = (var3 << 14) + var1 + (var2 << 7) + 1073741824;
         if(var8.field2943 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = (var4 << 6) + var5;
         if(var8.field2964 == 1) {
            var20 += 256;
         }

         if(var8.method3691()) {
            FaceNormal.method1907(var0, var1, var2, var8, var4);
         }

         Object var21;
         if(var5 == 22) {
            if(!Client.field285 || var8.field2943 != 0 || var8.field2936 == 1 || var8.field2962) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var21 = var8.method3684(22, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class49(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var21, var19, var20);
               if(var8.field2936 == 1 && var7 != null) {
                  var7.method2253(var1, var2);
               }

            }
         } else {
            int var22;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.method3684(var5, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class49(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1746(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     class164.field2160[var0][var1][var2] |= 2340;
                  }

                  if(var8.field2936 != 0 && var7 != null) {
                     var7.method2252(var1, var2, var9, var10, var8.field2942);
                  }

               } else if(var5 == 0) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.method3684(0, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class49(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1729(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class10.field99[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.field2955) {
                        class44.field882[var0][var1][var2] = 50;
                        class44.field882[var0][var1][var2 + 1] = 50;
                     }

                     if(var8.field2939) {
                        class164.field2160[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.field2955) {
                        class44.field882[var0][var1][var2 + 1] = 50;
                        class44.field882[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.field2939) {
                        class164.field2160[var0][var1][var2 + 1] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.field2955) {
                        class44.field882[var0][var1 + 1][var2] = 50;
                        class44.field882[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.field2939) {
                        class164.field2160[var0][var1 + 1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.field2955) {
                        class44.field882[var0][var1][var2] = 50;
                        class44.field882[var0][var1 + 1][var2] = 50;
                     }

                     if(var8.field2939) {
                        class164.field2160[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.field2936 != 0 && var7 != null) {
                     var7.method2254(var1, var2, var5, var4, var8.field2942);
                  }

                  if(var8.field2951 != 16) {
                     var6.method1737(var0, var1, var2, var8.field2951);
                  }

               } else if(var5 == 1) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.method3684(1, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class49(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1729(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class10.field101[var4], 0, var19, var20);
                  if(var8.field2955) {
                     if(var4 == 0) {
                        class44.field882[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class44.field882[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class44.field882[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class44.field882[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field2936 != 0 && var7 != null) {
                     var7.method2254(var1, var2, var5, var4, var8.field2942);
                  }

               } else {
                  int var28;
                  Object var29;
                  if(var5 == 2) {
                     var28 = var4 + 1 & 3;
                     Object var27;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var27 = var8.method3684(2, var4 + 4, var15, var17, var16, var18);
                        var29 = var8.method3684(2, var28, var15, var17, var16, var18);
                     } else {
                        var27 = new class49(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var29 = new class49(var3, 2, var28, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1729(var0, var1, var2, var16, (Renderable)var27, (Renderable)var29, class10.field99[var4], class10.field99[var28], var19, var20);
                     if(var8.field2939) {
                        if(var4 == 0) {
                           class164.field2160[var0][var1][var2] |= 585;
                           class164.field2160[var0][var1][var2 + 1] |= 1170;
                        } else if(var4 == 1) {
                           class164.field2160[var0][var1][var2 + 1] |= 1170;
                           class164.field2160[var0][var1 + 1][var2] |= 585;
                        } else if(var4 == 2) {
                           class164.field2160[var0][var1 + 1][var2] |= 585;
                           class164.field2160[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           class164.field2160[var0][var1][var2] |= 1170;
                           class164.field2160[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.field2936 != 0 && var7 != null) {
                        var7.method2254(var1, var2, var5, var4, var8.field2942);
                     }

                     if(var8.field2951 != 16) {
                        var6.method1737(var0, var1, var2, var8.field2951);
                     }

                  } else if(var5 == 3) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.method3684(3, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1729(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class10.field101[var4], 0, var19, var20);
                     if(var8.field2955) {
                        if(var4 == 0) {
                           class44.field882[var0][var1][var2 + 1] = 50;
                        } else if(var4 == 1) {
                           class44.field882[var0][var1 + 1][var2 + 1] = 50;
                        } else if(var4 == 2) {
                           class44.field882[var0][var1 + 1][var2] = 50;
                        } else if(var4 == 3) {
                           class44.field882[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.field2936 != 0 && var7 != null) {
                        var7.method2254(var1, var2, var5, var4, var8.field2942);
                     }

                  } else if(var5 == 9) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.method3684(var5, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1746(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                     if(var8.field2936 != 0 && var7 != null) {
                        var7.method2252(var1, var2, var9, var10, var8.field2942);
                     }

                     if(var8.field2951 != 16) {
                        var6.method1737(var0, var1, var2, var8.field2951);
                     }

                  } else if(var5 == 4) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.method3684(4, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1730(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class10.field99[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var28 = 16;
                     var22 = var6.method1747(var0, var1, var2);
                     if(var22 != 0) {
                        var28 = class26.getObjectDefinition(var22 >> 14 & 32767).field2951;
                     }

                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var29 = var8.method3684(4, var4, var15, var17, var16, var18);
                     } else {
                        var29 = new class49(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1730(var0, var1, var2, var16, (Renderable)var29, (Renderable)null, class10.field99[var4], 0, class10.field100[var4] * var28, class10.field107[var4] * var28, var19, var20);
                  } else if(var5 == 6) {
                     var28 = 8;
                     var22 = var6.method1747(var0, var1, var2);
                     if(var22 != 0) {
                        var28 = class26.getObjectDefinition(var22 >> 14 & 32767).field2951 / 2;
                     }

                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var29 = var8.method3684(4, var4 + 4, var15, var17, var16, var18);
                     } else {
                        var29 = new class49(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1730(var0, var1, var2, var16, (Renderable)var29, (Renderable)null, 256, var4, var28 * class10.field110[var4], var28 * class10.field103[var4], var19, var20);
                  } else if(var5 == 7) {
                     var22 = var4 + 2 & 3;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.method3684(4, var22 + 4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, 4, var22 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1730(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, 256, var22, 0, 0, var19, var20);
                  } else if(var5 == 8) {
                     var28 = 8;
                     var22 = var6.method1747(var0, var1, var2);
                     if(var22 != 0) {
                        var28 = class26.getObjectDefinition(var22 >> 14 & 32767).field2951 / 2;
                     }

                     int var25 = var4 + 2 & 3;
                     Object var24;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var29 = var8.method3684(4, var4 + 4, var15, var17, var16, var18);
                        var24 = var8.method3684(4, var25 + 4, var15, var17, var16, var18);
                     } else {
                        var29 = new class49(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var24 = new class49(var3, 4, var25 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1730(var0, var1, var2, var16, (Renderable)var29, (Renderable)var24, 256, var4, var28 * class10.field110[var4], var28 * class10.field103[var4], var19, var20);
                  }
               }
            } else {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var21 = var8.method3684(10, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class49(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               if(var21 != null && var6.method1746(var0, var1, var2, var16, var9, var10, (Renderable)var21, var5 == 11?256:0, var19, var20) && var8.field2955) {
                  var22 = 15;
                  if(var21 instanceof Model) {
                     var22 = ((Model)var21).method1594() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(int var23 = 0; var23 <= var9; ++var23) {
                     for(int var26 = 0; var26 <= var10; ++var26) {
                        if(var22 > class44.field882[var0][var23 + var1][var2 + var26]) {
                           class44.field882[var0][var1 + var23][var26 + var2] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.field2936 != 0 && var7 != null) {
                  var7.method2252(var1, var2, var9, var10, var8.field2942);
               }

            }
         }
      }
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-378637405"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.isDynamicRegion = var0;
      int var1;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.isDynamicRegion) {
         var1 = Client.ingressBuffer.method2419();
         int var2 = Client.ingressBuffer.method2419();
         var3 = Client.ingressBuffer.readUnsignedShort();
         class118.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class118.xteaKeys[var4][var5] = Client.ingressBuffer.readInt();
            }
         }

         class164.mapRegions = new int[var3];
         XClanMember.field272 = new int[var3];
         Actor.field641 = new int[var3];
         class215.field3156 = new byte[var3][];
         RSCanvas.field1759 = new byte[var3][];
         boolean var15 = false;
         if((var1 / 8 == 48 || var1 / 8 == 49) && var2 / 8 == 48) {
            var15 = true;
         }

         if(var1 / 8 == 48 && var2 / 8 == 148) {
            var15 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (var1 + 6) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (var2 + 6) / 8; ++var6) {
               var7 = (var5 << 8) + var6;
               if(!var15 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class164.mapRegions[var3] = var7;
                  XClanMember.field272[var3] = FileOnDisk.indexMaps.method3296("m" + var5 + "_" + var6);
                  Actor.field641[var3] = FileOnDisk.indexMaps.method3296("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class131.method2613(var1, var2, true);
      } else {
         var1 = Client.ingressBuffer.method2419();
         boolean var14 = Client.ingressBuffer.method2410() == 1;
         var3 = Client.ingressBuffer.method2420();
         var4 = Client.ingressBuffer.readUnsignedShort();
         Client.ingressBuffer.method2644();

         int var8;
         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var8 = Client.ingressBuffer.readBits(1);
                  if(var8 == 1) {
                     Client.field344[var5][var6][var7] = Client.ingressBuffer.readBits(26);
                  } else {
                     Client.field344[var5][var6][var7] = -1;
                  }
               }
            }
         }

         Client.ingressBuffer.method2647();
         class118.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               class118.xteaKeys[var5][var6] = Client.ingressBuffer.readInt();
            }
         }

         class164.mapRegions = new int[var4];
         XClanMember.field272 = new int[var4];
         Actor.field641 = new int[var4];
         class215.field3156 = new byte[var4][];
         RSCanvas.field1759 = new byte[var4][];
         var4 = 0;

         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var8 = Client.field344[var5][var6][var7];
                  if(var8 != -1) {
                     int var9 = var8 >> 14 & 1023;
                     int var10 = var8 >> 3 & 2047;
                     int var11 = (var9 / 8 << 8) + var10 / 8;

                     int var12;
                     for(var12 = 0; var12 < var4; ++var12) {
                        if(var11 == class164.mapRegions[var12]) {
                           var11 = -1;
                           break;
                        }
                     }

                     if(var11 != -1) {
                        class164.mapRegions[var4] = var11;
                        var12 = var11 >> 8 & 255;
                        int var13 = var11 & 255;
                        XClanMember.field272[var4] = FileOnDisk.indexMaps.method3296("m" + var12 + "_" + var13);
                        Actor.field641[var4] = FileOnDisk.indexMaps.method3296("l" + var12 + "_" + var13);
                        ++var4;
                     }
                  }
               }
            }
         }

         class131.method2613(var1, var3, !var14);
      }

   }

   class9() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1099829410"
   )
   static final void method109() {
      for(class33 var0 = (class33)Client.field531.method2828(); var0 != null; var0 = (class33)Client.field531.method2830()) {
         if(var0.field735 == Client.plane && !var0.field740) {
            if(Client.gameCycle >= var0.field734) {
               var0.method720(Client.field358);
               if(var0.field740) {
                  var0.unlink();
               } else {
                  class172.region.method1732(var0.field735, var0.field736, var0.field742, var0.field737, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LFont;LFont;LFont;ZB)V",
      garbageValue = "82"
   )
   static void method110(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class41.field821 = (class187.field2760 - Client.field293) / 2;
         class41.loginWindowX = class41.field821 + 202;
      }

      if(class41.worldSelectShown) {
         class3.method40(var0, var1);
      } else {
         if(var3) {
            class41.field815.method4295(class41.field821, 0);
            class41.field816.method4295(class41.field821 + 382, 0);
            class41.field844.method4170(class41.field821 + 382 - class41.field844.originalWidth / 2, 18);
         }

         int var5;
         if(Client.gameState == 0 || Client.gameState == 5) {
            byte var4 = 20;
            var0.method3944("RuneScape is loading - please wait...", class41.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.method4095(class41.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.method4095(class41.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.method4089(class41.loginWindowX + 180 - 150, var5 + 2, class41.field817 * 3, 30, 9179409);
            Rasterizer2D.method4089(class41.loginWindowX + 180 - 150 + class41.field817 * 3, var5 + 2, 300 - class41.field817 * 3, 30, 0);
            var0.method3944(class41.field829, class41.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var6;
         String var8;
         String var9;
         String var10;
         short var24;
         int var25;
         short var26;
         if(Client.gameState == 20) {
            class41.field813.method4170(class41.loginWindowX + 180 - class41.field813.originalWidth / 2, 271 - class41.field813.height / 2);
            var24 = 211;
            var0.method3944(class41.loginMessage1, class41.loginWindowX + 180, var24, 16776960, 0);
            var25 = var24 + 15;
            var0.method3944(class41.loginMessage2, class41.loginWindowX + 180, var25, 16776960, 0);
            var25 += 15;
            var0.method3944(class41.loginMessage3, class41.loginWindowX + 180, var25, 16776960, 0);
            var25 += 15;
            var25 += 10;
            if(class41.loginIndex != 4) {
               var0.method3914("Login: ", class41.loginWindowX + 180 - 110, var25, 16777215, 0);
               var26 = 200;

               for(var6 = class41.username; var0.method3904(var6) > var26; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method3914(FontTypeFace.method3913(var6), class41.loginWindowX + 180 - 70, var25, 16777215, 0);
               var25 += 15;
               var8 = "Password: ";
               var10 = class41.password;
               var9 = class122.method2314('*', var10.length());
               var0.method3914(var8 + var9, class41.loginWindowX + 180 - 108, var25, 16777215, 0);
               var25 += 15;
            }
         }

         int var11;
         int var17;
         int var18;
         int var20;
         int var27;
         if(Client.gameState == 10 || Client.gameState == 11) {
            class41.field813.method4170(class41.loginWindowX, 171);
            short var15;
            if(class41.loginIndex == 0) {
               var24 = 251;
               var0.method3944("Welcome to RuneScape", class41.loginWindowX + 180, var24, 16776960, 0);
               var25 = var24 + 30;
               var5 = class41.loginWindowX + 180 - 80;
               var15 = 291;
               class41.field814.method4170(var5 - 73, var15 - 20);
               var0.method3905("New User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class41.loginWindowX + 180 + 80;
               class41.field814.method4170(var5 - 73, var15 - 20);
               var0.method3905("Existing User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class41.loginIndex == 1) {
               var0.method3944(class41.field840, class41.loginWindowX + 180, 211, 16776960, 0);
               var24 = 236;
               var0.method3944(class41.loginMessage1, class41.loginWindowX + 180, var24, 16777215, 0);
               var25 = var24 + 15;
               var0.method3944(class41.loginMessage2, class41.loginWindowX + 180, var25, 16777215, 0);
               var25 += 15;
               var0.method3944(class41.loginMessage3, class41.loginWindowX + 180, var25, 16777215, 0);
               var25 += 15;
               var5 = class41.loginWindowX + 180 - 80;
               var15 = 321;
               class41.field814.method4170(var5 - 73, var15 - 20);
               var0.method3944("Continue", var5, var15 + 5, 16777215, 0);
               var5 = class41.loginWindowX + 180 + 80;
               class41.field814.method4170(var5 - 73, var15 - 20);
               var0.method3944("Cancel", var5, var15 + 5, 16777215, 0);
            } else if(class41.loginIndex == 2) {
               var24 = 211;
               var0.method3944(class41.loginMessage1, class41.loginWindowX + 180, var24, 16776960, 0);
               var25 = var24 + 15;
               var0.method3944(class41.loginMessage2, class41.loginWindowX + 180, var25, 16776960, 0);
               var25 += 15;
               var0.method3944(class41.loginMessage3, class41.loginWindowX + 180, var25, 16776960, 0);
               var25 += 15;
               var25 += 10;
               var0.method3914("Login: ", class41.loginWindowX + 180 - 110, var25, 16777215, 0);
               var26 = 200;

               for(var6 = class41.username; var0.method3904(var6) > var26; var6 = var6.substring(1)) {
                  ;
               }

               var0.method3914(FontTypeFace.method3913(var6) + (class41.loginIndex2 == 0 & Client.gameCycle % 40 < 20?class213.method4037(16776960) + "|":""), class41.loginWindowX + 180 - 70, var25, 16777215, 0);
               var25 += 15;
               var8 = "Password: ";
               var10 = class41.password;
               var9 = class122.method2314('*', var10.length());
               var0.method3914(var8 + var9 + (class41.loginIndex2 == 1 & Client.gameCycle % 40 < 20?class213.method4037(16776960) + "|":""), class41.loginWindowX + 180 - 108, var25, 16777215, 0);
               var25 += 15;
               var11 = class41.loginWindowX + 180 - 80;
               short var12 = 321;
               class41.field814.method4170(var11 - 73, var12 - 20);
               var0.method3944("Login", var11, var12 + 5, 16777215, 0);
               var11 = class41.loginWindowX + 180 + 80;
               class41.field814.method4170(var11 - 73, var12 - 20);
               var0.method3944("Cancel", var11, var12 + 5, 16777215, 0);
               var24 = 357;
               var1.method3944("Forgotten your password? <col=ffffff>Click here.", class41.loginWindowX + 180, var24, 16776960, 0);
            } else if(class41.loginIndex == 3) {
               var24 = 201;
               var0.method3944("Invalid username or password.", class41.loginWindowX + 180, var24, 16776960, 0);
               var25 = var24 + 20;
               var1.method3944("For accounts created after 24th November 2010, please use your", class41.loginWindowX + 180, var25, 16776960, 0);
               var25 += 15;
               var1.method3944("email address to login. Otherwise please login with your username.", class41.loginWindowX + 180, var25, 16776960, 0);
               var25 += 15;
               var5 = class41.loginWindowX + 180;
               var15 = 276;
               class41.field814.method4170(var5 - 73, var15 - 20);
               var2.method3944("Try again", var5, var15 + 5, 16777215, 0);
               var5 = class41.loginWindowX + 180;
               var15 = 326;
               class41.field814.method4170(var5 - 73, var15 - 20);
               var2.method3944("Forgotten password?", var5, var15 + 5, 16777215, 0);
            } else if(class41.loginIndex == 4) {
               var0.method3944("Authenticator", class41.loginWindowX + 180, 211, 16776960, 0);
               var24 = 236;
               var0.method3944(class41.loginMessage1, class41.loginWindowX + 180, var24, 16777215, 0);
               var25 = var24 + 15;
               var0.method3944(class41.loginMessage2, class41.loginWindowX + 180, var25, 16777215, 0);
               var25 += 15;
               var0.method3944(class41.loginMessage3, class41.loginWindowX + 180, var25, 16777215, 0);
               var25 += 15;
               var6 = "PIN: ";
               var8 = class94.authCode;
               String var7 = class122.method2314('*', var8.length());
               var0.method3914(var6 + var7 + (Client.gameCycle % 40 < 20?class213.method4037(16776960) + "|":""), class41.loginWindowX + 180 - 108, var25, 16777215, 0);
               var25 -= 8;
               var0.method3914("Trust this computer", class41.loginWindowX + 180 - 9, var25, 16776960, 0);
               var25 += 15;
               var0.method3914("for 30 days: ", class41.loginWindowX + 180 - 9, var25, 16776960, 0);
               var17 = class41.loginWindowX + 180 - 9 + var0.method3904("for 30 days: ") + 15;
               var18 = var25 - var0.field3111;
               ModIcon var19;
               if(class41.field843) {
                  var19 = class41.field831;
               } else {
                  var19 = class39.field797;
               }

               var19.method4170(var17, var18);
               var25 += 15;
               var27 = class41.loginWindowX + 180 - 80;
               short var13 = 321;
               class41.field814.method4170(var27 - 73, var13 - 20);
               var0.method3944("Continue", var27, var13 + 5, 16777215, 0);
               var27 = class41.loginWindowX + 180 + 80;
               class41.field814.method4170(var27 - 73, var13 - 20);
               var0.method3944("Cancel", var27, var13 + 5, 16777215, 0);
               var1.method3944("<u=ff>Can\'t Log In?</u>", class41.loginWindowX + 180, var13 + 36, 255, 0);
            } else if(class41.loginIndex == 5) {
               var0.method3944("Forgotten your password?", class41.loginWindowX + 180, 201, 16776960, 0);
               var24 = 221;
               var2.method3944(class41.loginMessage1, class41.loginWindowX + 180, var24, 16776960, 0);
               var25 = var24 + 15;
               var2.method3944(class41.loginMessage2, class41.loginWindowX + 180, var25, 16776960, 0);
               var25 += 15;
               var2.method3944(class41.loginMessage3, class41.loginWindowX + 180, var25, 16776960, 0);
               var25 += 15;
               var25 += 14;
               var0.method3914("Username/email: ", class41.loginWindowX + 180 - 145, var25, 16777215, 0);
               var26 = 174;

               for(var6 = class41.username; var0.method3904(var6) > var26; var6 = var6.substring(1)) {
                  ;
               }

               var0.method3914(FontTypeFace.method3913(var6) + (Client.gameCycle % 40 < 20?class213.method4037(16776960) + "|":""), class41.loginWindowX + 180 - 34, var25, 16777215, 0);
               var25 += 15;
               var20 = class41.loginWindowX + 180 - 80;
               short var21 = 321;
               class41.field814.method4170(var20 - 73, var21 - 20);
               var0.method3944("Recover", var20, var21 + 5, 16777215, 0);
               var20 = class41.loginWindowX + 180 + 80;
               class41.field814.method4170(var20 - 73, var21 - 20);
               var0.method3944("Back", var20, var21 + 5, 16777215, 0);
            } else if(class41.loginIndex == 6) {
               var24 = 211;
               var0.method3944(class41.loginMessage1, class41.loginWindowX + 180, var24, 16776960, 0);
               var25 = var24 + 15;
               var0.method3944(class41.loginMessage2, class41.loginWindowX + 180, var25, 16776960, 0);
               var25 += 15;
               var0.method3944(class41.loginMessage3, class41.loginWindowX + 180, var25, 16776960, 0);
               var25 += 15;
               var5 = class41.loginWindowX + 180;
               var15 = 321;
               class41.field814.method4170(var5 - 73, var15 - 20);
               var0.method3944("Back", var5, var15 + 5, 16777215, 0);
            }
         }

         if(class41.field826 > 0) {
            Friend.method181(class41.field826);
            class41.field826 = 0;
         }

         var24 = 256;
         if(class41.field822 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class41.field822 > 768) {
                  class61.field1072[var5] = class130.method2604(class31.field697[var5], class41.field811[var5], 1024 - class41.field822);
               } else if(class41.field822 > 256) {
                  class61.field1072[var5] = class41.field811[var5];
               } else {
                  class61.field1072[var5] = class130.method2604(class41.field811[var5], class31.field697[var5], 256 - class41.field822);
               }
            }
         } else if(class41.field845 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class41.field845 > 768) {
                  class61.field1072[var5] = class130.method2604(class31.field697[var5], class183.field2706[var5], 1024 - class41.field845);
               } else if(class41.field845 > 256) {
                  class61.field1072[var5] = class183.field2706[var5];
               } else {
                  class61.field1072[var5] = class130.method2604(class183.field2706[var5], class31.field697[var5], 256 - class41.field845);
               }
            }
         } else {
            for(var5 = 0; var5 < 256; ++var5) {
               class61.field1072[var5] = class31.field697[var5];
            }
         }

         Rasterizer2D.method4083(class41.field821, 9, class41.field821 + 128, var24 + 7);
         class41.field815.method4295(class41.field821, 0);
         Rasterizer2D.method4082();
         var5 = 0;
         int var29 = class88.bufferProvider.width * 9 + class41.field821;

         int var14;
         int var28;
         int var31;
         for(var20 = 1; var20 < var24 - 1; ++var20) {
            var31 = (var24 - var20) * class41.field820[var20] / var24;
            var17 = var31 + 22;
            if(var17 < 0) {
               var17 = 0;
            }

            var5 += var17;

            for(var18 = var17; var18 < 128; ++var18) {
               var11 = class2.field24[var5++];
               if(var11 != 0) {
                  var27 = var11;
                  var28 = 256 - var11;
                  var11 = class61.field1072[var11];
                  var14 = class88.bufferProvider.pixels[var29];
                  class88.bufferProvider.pixels[var29++] = ((var14 & 16711935) * var28 + (var11 & 16711935) * var27 & -16711936) + (var28 * (var14 & '\uff00') + var27 * (var11 & '\uff00') & 16711680) >> 8;
               } else {
                  ++var29;
               }
            }

            var29 += class88.bufferProvider.width + var17 - 128;
         }

         Rasterizer2D.method4083(class41.field821 + 765 - 128, 9, class41.field821 + 765, var24 + 7);
         class41.field816.method4295(class41.field821 + 382, 0);
         Rasterizer2D.method4082();
         var5 = 0;
         var29 = class41.field821 + class88.bufferProvider.width * 9 + 24 + 637;

         for(var20 = 1; var20 < var24 - 1; ++var20) {
            var31 = (var24 - var20) * class41.field820[var20] / var24;
            var17 = 103 - var31;
            var29 += var31;

            for(var18 = 0; var18 < var17; ++var18) {
               var11 = class2.field24[var5++];
               if(var11 != 0) {
                  var27 = var11;
                  var28 = 256 - var11;
                  var11 = class61.field1072[var11];
                  var14 = class88.bufferProvider.pixels[var29];
                  class88.bufferProvider.pixels[var29++] = ((var14 & 16711935) * var28 + var27 * (var11 & 16711935) & -16711936) + ((var11 & '\uff00') * var27 + var28 * (var14 & '\uff00') & 16711680) >> 8;
               } else {
                  ++var29;
               }
            }

            var5 += 128 - var17;
            var29 += class88.bufferProvider.width - var17 - var31;
         }

         class13.field143[Actor.field656.field691?1:0].method4170(class41.field821 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.field286 == 0) {
            if(class47.field928 != null) {
               var25 = class41.field821 + 5;
               var26 = 463;
               byte var30 = 100;
               byte var32 = 35;
               class47.field928.method4170(var25, var26);
               var0.method3944("World" + " " + Client.world, var30 / 2 + var25, var32 / 2 + var26 - 2, 16777215, 0);
               if(class132.worldServersDownload != null) {
                  var1.method3944("Loading...", var30 / 2 + var25, var26 + var32 / 2 + 12, 16777215, 0);
               } else {
                  var1.method3944("Click to switch", var25 + var30 / 2, var26 + var32 / 2 + 12, 16777215, 0);
               }
            } else {
               class47.field928 = class173.method3258(WallObject.indexSprites, "sl_button", "");
            }
         }

         try {
            Graphics var22 = class65.canvas.getGraphics();
            class88.bufferProvider.draw(var22, 0, 0);
         } catch (Exception var23) {
            class65.canvas.repaint();
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2021002988"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            WidgetNode.field183 = null;
            Buffer.field1962 = null;
            class121.field1878 = null;
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field315 = 0;
            Client.field316 = 0;
         }

         if(var0 != 20 && var0 != 40 && class132.field1979 != null) {
            class132.field1979.method2093();
            class132.field1979 = null;
         }

         if(Client.gameState == 25) {
            Client.field341 = 0;
            Client.field337 = 0;
            Client.field544 = 1;
            Client.field369 = 0;
            Client.field340 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class199.method3611(class65.canvas, Client.field312, WallObject.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class199.method3611(class65.canvas, Client.field312, WallObject.indexSprites, false, 4);
            } else if(class41.field836) {
               class41.field813 = null;
               class41.field814 = null;
               class126.field1909 = null;
               class41.field815 = null;
               class41.field816 = null;
               class41.field844 = null;
               class13.field143 = null;
               class39.field797 = null;
               class41.field831 = null;
               Client.field569 = null;
               class33.field744 = null;
               class109.field1735 = null;
               class118.field1840 = null;
               class47.field928 = null;
               class31.field697 = null;
               class41.field811 = null;
               class183.field2706 = null;
               class61.field1072 = null;
               class94.field1580 = null;
               class32.field729 = null;
               class2.field24 = null;
               class133.field1983 = null;
               GameEngine.method2202(2);
               class112.method2101(true);
               class41.field836 = false;
            }
         } else {
            class199.method3611(class65.canvas, Client.field312, WallObject.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }
   }
}
