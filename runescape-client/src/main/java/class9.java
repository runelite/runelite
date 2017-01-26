import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public final class class9 {
   @ObfuscatedName("d")
   public static class182 field83;

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(LWidgetNode;ZI)V",
      garbageValue = "-1212666115"
   )
   static final void method117(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1) {
         class103.method1972(var2);
      }

      class45.method821(var2);
      Widget var4 = class37.method736(var3);
      if(null != var4) {
         class33.method682(var4);
      }

      class13.method175();
      if(Client.widgetRoot != -1) {
         class148.method2783(Client.widgetRoot, 1);
      }

   }

   class9() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIIILRegion;LCollisionData;I)V",
      garbageValue = "-1941305824"
   )
   static final void method118(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.field283 || (class10.tileSettings[0][var1][var2] & 2) != 0 || (class10.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class10.field87) {
            class10.field87 = var0;
         }

         ObjectComposition var8 = class217.getObjectDefinition(var3);
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
         if(var1 + var9 <= 104) {
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
            var14 = 1 + var2;
         }

         int[][] var15 = class10.tileHeights[var0];
         int var16 = var15[var12][var14] + var15[var12][var13] + var15[var11][var13] + var15[var11][var14] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var10 << 6) + (var2 << 7);
         int var19 = 1073741824 + var1 + (var2 << 7) + (var3 << 14);
         if(var8.field2908 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.field2929 == 1) {
            var20 += 256;
         }

         int var22;
         int var23;
         if(var8.method3638()) {
            class31 var21 = new class31();
            var21.field707 = var0;
            var21.field696 = var1 * 128;
            var21.field697 = var2 * 128;
            var22 = var8.sizeX;
            var23 = var8.sizeY;
            if(var4 == 1 || var4 == 3) {
               var22 = var8.sizeY;
               var23 = var8.sizeX;
            }

            var21.field698 = (var22 + var1) * 128;
            var21.field699 = (var2 + var23) * 128;
            var21.field704 = var8.ambientSoundId;
            var21.field709 = var8.field2910 * 128;
            var21.field703 = var8.field2888;
            var21.field695 = var8.field2911;
            var21.field700 = var8.field2937;
            if(var8.impostorIds != null) {
               var21.field708 = var8;
               var21.method662();
            }

            class31.field711.method2407(var21);
            if(var21.field700 != null) {
               var21.field701 = var21.field703 + (int)(Math.random() * (double)(var21.field695 - var21.field703));
            }
         }

         Object var30;
         if(var5 == 22) {
            if(!Client.field283 || var8.field2908 != 0 || var8.field2906 == 1 || var8.field2927) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.method3639(22, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class49(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var30, var19, var20);
               if(var8.field2906 == 1 && var7 != null) {
                  var7.method2257(var1, var2);
               }

            }
         } else if(var5 != 10 && var5 != 11) {
            if(var5 >= 12) {
               if(var8.animationId == -1 && null == var8.impostorIds) {
                  var30 = var8.method3639(var5, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class49(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.method1709(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
               if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                  class137.field1909[var0][var1][var2] |= 2340;
               }

               if(var8.field2906 != 0 && var7 != null) {
                  var7.method2255(var1, var2, var9, var10, var8.field2934);
               }

            } else if(var5 == 0) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.method3639(0, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class49(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.method1867(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class10.field91[var4], 0, var19, var20);
               if(var4 == 0) {
                  if(var8.field2920) {
                     class47.field931[var0][var1][var2] = 50;
                     class47.field931[var0][var1][var2 + 1] = 50;
                  }

                  if(var8.field2892) {
                     class137.field1909[var0][var1][var2] |= 585;
                  }
               } else if(var4 == 1) {
                  if(var8.field2920) {
                     class47.field931[var0][var1][var2 + 1] = 50;
                     class47.field931[var0][var1 + 1][1 + var2] = 50;
                  }

                  if(var8.field2892) {
                     class137.field1909[var0][var1][var2 + 1] |= 1170;
                  }
               } else if(var4 == 2) {
                  if(var8.field2920) {
                     class47.field931[var0][var1 + 1][var2] = 50;
                     class47.field931[var0][1 + var1][1 + var2] = 50;
                  }

                  if(var8.field2892) {
                     class137.field1909[var0][var1 + 1][var2] |= 585;
                  }
               } else if(var4 == 3) {
                  if(var8.field2920) {
                     class47.field931[var0][var1][var2] = 50;
                     class47.field931[var0][1 + var1][var2] = 50;
                  }

                  if(var8.field2892) {
                     class137.field1909[var0][var1][var2] |= 1170;
                  }
               }

               if(var8.field2906 != 0 && null != var7) {
                  var7.method2254(var1, var2, var5, var4, var8.field2934);
               }

               if(var8.field2935 != 16) {
                  var6.method1715(var0, var1, var2, var8.field2935);
               }

            } else if(var5 == 1) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.method3639(1, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class49(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.method1867(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class10.field92[var4], 0, var19, var20);
               if(var8.field2920) {
                  if(var4 == 0) {
                     class47.field931[var0][var1][var2 + 1] = 50;
                  } else if(var4 == 1) {
                     class47.field931[var0][var1 + 1][1 + var2] = 50;
                  } else if(var4 == 2) {
                     class47.field931[var0][var1 + 1][var2] = 50;
                  } else if(var4 == 3) {
                     class47.field931[var0][var1][var2] = 50;
                  }
               }

               if(var8.field2906 != 0 && var7 != null) {
                  var7.method2254(var1, var2, var5, var4, var8.field2934);
               }

            } else {
               int var26;
               Object var27;
               if(var5 == 2) {
                  var26 = 1 + var4 & 3;
                  Object var29;
                  if(var8.animationId == -1 && null == var8.impostorIds) {
                     var29 = var8.method3639(2, 4 + var4, var15, var17, var16, var18);
                     var27 = var8.method3639(2, var26, var15, var17, var16, var18);
                  } else {
                     var29 = new class49(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     var27 = new class49(var3, 2, var26, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1867(var0, var1, var2, var16, (Renderable)var29, (Renderable)var27, class10.field91[var4], class10.field91[var26], var19, var20);
                  if(var8.field2892) {
                     if(var4 == 0) {
                        class137.field1909[var0][var1][var2] |= 585;
                        class137.field1909[var0][var1][var2 + 1] |= 1170;
                     } else if(var4 == 1) {
                        class137.field1909[var0][var1][1 + var2] |= 1170;
                        class137.field1909[var0][var1 + 1][var2] |= 585;
                     } else if(var4 == 2) {
                        class137.field1909[var0][1 + var1][var2] |= 585;
                        class137.field1909[var0][var1][var2] |= 1170;
                     } else if(var4 == 3) {
                        class137.field1909[var0][var1][var2] |= 1170;
                        class137.field1909[var0][var1][var2] |= 585;
                     }
                  }

                  if(var8.field2906 != 0 && var7 != null) {
                     var7.method2254(var1, var2, var5, var4, var8.field2934);
                  }

                  if(var8.field2935 != 16) {
                     var6.method1715(var0, var1, var2, var8.field2935);
                  }

               } else if(var5 == 3) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.method3639(3, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new class49(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1867(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class10.field92[var4], 0, var19, var20);
                  if(var8.field2920) {
                     if(var4 == 0) {
                        class47.field931[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class47.field931[var0][1 + var1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class47.field931[var0][1 + var1][var2] = 50;
                     } else if(var4 == 3) {
                        class47.field931[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field2906 != 0 && null != var7) {
                     var7.method2254(var1, var2, var5, var4, var8.field2934);
                  }

               } else if(var5 == 9) {
                  if(var8.animationId == -1 && null == var8.impostorIds) {
                     var30 = var8.method3639(var5, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new class49(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1709(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
                  if(var8.field2906 != 0 && var7 != null) {
                     var7.method2255(var1, var2, var9, var10, var8.field2934);
                  }

                  if(var8.field2935 != 16) {
                     var6.method1715(var0, var1, var2, var8.field2935);
                  }

               } else if(var5 == 4) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.method3639(4, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new class49(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1757(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class10.field91[var4], 0, 0, 0, var19, var20);
               } else if(var5 == 5) {
                  var26 = 16;
                  var22 = var6.method1778(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = class217.getObjectDefinition(var22 >> 14 & 32767).field2935;
                  }

                  if(var8.animationId == -1 && null == var8.impostorIds) {
                     var27 = var8.method3639(4, var4, var15, var17, var16, var18);
                  } else {
                     var27 = new class49(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1757(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, class10.field91[var4], 0, var26 * class10.field95[var4], var26 * class10.field94[var4], var19, var20);
               } else if(var5 == 6) {
                  var26 = 8;
                  var22 = var6.method1778(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = class217.getObjectDefinition(var22 >> 14 & 32767).field2935 / 2;
                  }

                  if(var8.animationId == -1 && null == var8.impostorIds) {
                     var27 = var8.method3639(4, var4 + 4, var15, var17, var16, var18);
                  } else {
                     var27 = new class49(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1757(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, 256, var4, class10.field85[var4] * var26, var26 * class10.field96[var4], var19, var20);
               } else if(var5 == 7) {
                  var22 = var4 + 2 & 3;
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.method3639(4, var22 + 4, var15, var17, var16, var18);
                  } else {
                     var30 = new class49(var3, 4, var22 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1757(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, 256, var22, 0, 0, var19, var20);
               } else if(var5 == 8) {
                  var26 = 8;
                  var22 = var6.method1778(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = class217.getObjectDefinition(var22 >> 14 & 32767).field2935 / 2;
                  }

                  int var25 = 2 + var4 & 3;
                  Object var28;
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var27 = var8.method3639(4, 4 + var4, var15, var17, var16, var18);
                     var28 = var8.method3639(4, 4 + var25, var15, var17, var16, var18);
                  } else {
                     var27 = new class49(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     var28 = new class49(var3, 4, var25 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1757(var0, var1, var2, var16, (Renderable)var27, (Renderable)var28, 256, var4, var26 * class10.field85[var4], class10.field96[var4] * var26, var19, var20);
               }
            }
         } else {
            if(var8.animationId == -1 && var8.impostorIds == null) {
               var30 = var8.method3639(10, var4, var15, var17, var16, var18);
            } else {
               var30 = new class49(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
            }

            if(var30 != null && var6.method1709(var0, var1, var2, var16, var9, var10, (Renderable)var30, var5 == 11?256:0, var19, var20) && var8.field2920) {
               var22 = 15;
               if(var30 instanceof Model) {
                  var22 = ((Model)var30).method1560() / 4;
                  if(var22 > 30) {
                     var22 = 30;
                  }
               }

               for(var23 = 0; var23 <= var9; ++var23) {
                  for(int var24 = 0; var24 <= var10; ++var24) {
                     if(var22 > class47.field931[var0][var23 + var1][var24 + var2]) {
                        class47.field931[var0][var23 + var1][var24 + var2] = (byte)var22;
                     }
                  }
               }
            }

            if(var8.field2906 != 0 && var7 != null) {
               var7.method2255(var1, var2, var9, var10, var8.field2934);
            }

         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1048463778"
   )
   static void method119() {
      Client.field394.offset = 0;
      Client.field323.offset = 0;
      Client.packetOpcode = -1;
      Client.field328 = -1;
      Client.field400 = -1;
      Client.field330 = -1;
      Client.field541 = 0;
      Client.field326 = 0;
      Client.field295 = 0;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.field513 = 0;
      Client.flagX = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      class16.localPlayer = null;

      for(var0 = 0; var0 < Client.cachedNPCs.length; ++var0) {
         NPC var1 = Client.cachedNPCs[var0];
         if(var1 != null) {
            var1.interacting = -1;
            var1.field619 = false;
         }
      }

      XItemContainer.itemContainers = new XHashTable(32);
      class212.setGameState(30);

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field482[var0] = true;
      }

      class167.method3159();
   }

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1167013226"
   )
   static final void method120(int var0) {
      if(class103.method1973(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(null != var3) {
               var3.field2221 = 0;
               var3.field2319 = 0;
            }
         }

      }
   }
}
