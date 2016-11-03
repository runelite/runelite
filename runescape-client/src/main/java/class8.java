import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class8 {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 371281247
   )
   int field136 = 1;
   @ObfuscatedName("f")
   boolean field138;
   @ObfuscatedName("j")
   LinkedHashMap field139 = new LinkedHashMap();
   @ObfuscatedName("c")
   boolean field140;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1549219255
   )
   static int field141 = 4;
   @ObfuscatedName("dx")
   @ObfuscatedGetter(
      intValue = 1382633603
   )
   static int field144;

   class8(Buffer var1) {
      if(null != var1 && null != var1.payload) {
         int var2 = var1.method2571();
         if(var2 >= 0 && var2 <= field141) {
            if(var1.method2571() == 1) {
               this.field138 = true;
            }

            if(var2 > 1) {
               this.field140 = var1.method2571() == 1;
            }

            if(var2 > 3) {
               this.field136 = var1.method2571();
            }

            if(var2 > 2) {
               int var3 = var1.method2571();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method2576();
                  int var6 = var1.method2576();
                  this.field139.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method99(true);
         }
      } else {
         this.method99(true);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "0"
   )
   void method99(boolean var1) {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)LBuffer;",
      garbageValue = "-928996104"
   )
   Buffer method100() {
      Buffer var1 = new Buffer(100);
      var1.method2556(field141);
      var1.method2556(this.field138?1:0);
      var1.method2556(this.field140?1:0);
      var1.method2556(this.field136);
      var1.method2556(this.field139.size());
      Iterator var2 = this.field139.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2559(((Integer)var3.getKey()).intValue());
         var1.method2559(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "62776916"
   )
   static final void method101(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.field282 && var0 != class145.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = Frames.region.method1986(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = Frames.region.method1987(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = Frames.region.method2108(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = Frames.region.method2102(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = Frames.region.method1990(var0, var2, var3, var7);
            int var34 = var7 >> 14 & 32767;
            int var35 = var11 & 31;
            int var36 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               Frames.region.method1978(var0, var2, var3);
               var12 = Projectile.getObjectDefinition(var34);
               if(var12.field952 != 0) {
                  Client.collisionMaps[var0].method2454(var2, var3, var35, var36, var12.field953);
               }
            }

            if(var1 == 1) {
               Frames.region.method1979(var0, var2, var3);
            }

            if(var1 == 2) {
               Frames.region.method1980(var0, var2, var3);
               var12 = Projectile.getObjectDefinition(var34);
               if(var2 + var12.field950 > 103 || var3 + var12.field950 > 103 || var12.field948 + var2 > 103 || var3 + var12.field948 > 103) {
                  return;
               }

               if(var12.field952 != 0) {
                  Client.collisionMaps[var0].method2455(var2, var3, var12.field950, var12.field948, var36, var12.field953);
               }
            }

            if(var1 == 3) {
               Frames.region.method1981(var0, var2, var3);
               var12 = Projectile.getObjectDefinition(var34);
               if(var12.field952 == 1) {
                  Client.collisionMaps[var0].method2457(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class5.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            Region var37 = Frames.region;
            CollisionData var13 = Client.collisionMaps[var0];
            ObjectComposition var14 = Projectile.getObjectDefinition(var4);
            int var15;
            int var16;
            if(var5 != 1 && var5 != 3) {
               var15 = var14.field950;
               var16 = var14.field948;
            } else {
               var15 = var14.field948;
               var16 = var14.field950;
            }

            int var17;
            int var18;
            if(var2 + var15 <= 104) {
               var17 = var2 + (var15 >> 1);
               var18 = var2 + (1 + var15 >> 1);
            } else {
               var17 = var2;
               var18 = 1 + var2;
            }

            int var19;
            int var20;
            if(var16 + var3 <= 104) {
               var19 = var3 + (var16 >> 1);
               var20 = var3 + (1 + var16 >> 1);
            } else {
               var19 = var3;
               var20 = 1 + var3;
            }

            int[][] var21 = class5.tileHeights[var11];
            int var22 = var21[var18][var20] + var21[var17][var19] + var21[var18][var19] + var21[var17][var20] >> 2;
            int var23 = (var2 << 7) + (var15 << 6);
            int var24 = (var3 << 7) + (var16 << 6);
            int var25 = 1073741824 + (var4 << 14) + var2 + (var3 << 7);
            if(var14.field982 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = var6 + (var5 << 6);
            if(var14.field940 == 1) {
               var26 += 256;
            }

            Object var27;
            if(var6 == 22) {
               if(var14.field964 == -1 && var14.impostorIds == null) {
                  var27 = var14.method841(22, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class12(var4, 22, var5, var11, var2, var3, var14.field964, true, (Renderable)null);
               }

               var37.groundObjectSpawned(var0, var2, var3, var22, (Renderable)var27, var25, var26);
               if(var14.field952 == 1) {
                  var13.method2453(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var14.field964 == -1 && null == var14.impostorIds) {
                     var27 = var14.method841(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, var6, var5, var11, var2, var3, var14.field964, true, (Renderable)null);
                  }

                  var37.method1971(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                  if(var14.field952 != 0) {
                     var13.method2450(var2, var3, var15, var16, var14.field953);
                  }
               } else if(var6 == 0) {
                  if(var14.field964 == -1 && null == var14.impostorIds) {
                     var27 = var14.method841(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, 0, var5, var11, var2, var3, var14.field964, true, (Renderable)null);
                  }

                  var37.method1962(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class5.field83[var5], 0, var25, var26);
                  if(var14.field952 != 0) {
                     var13.method2449(var2, var3, var6, var5, var14.field953);
                  }
               } else if(var6 == 1) {
                  if(var14.field964 == -1 && var14.impostorIds == null) {
                     var27 = var14.method841(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, 1, var5, var11, var2, var3, var14.field964, true, (Renderable)null);
                  }

                  var37.method1962(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class5.field84[var5], 0, var25, var26);
                  if(var14.field952 != 0) {
                     var13.method2449(var2, var3, var6, var5, var14.field953);
                  }
               } else {
                  Object var29;
                  int var32;
                  if(var6 == 2) {
                     var32 = 1 + var5 & 3;
                     Object var33;
                     if(var14.field964 == -1 && var14.impostorIds == null) {
                        var33 = var14.method841(2, var5 + 4, var21, var23, var22, var24);
                        var29 = var14.method841(2, var32, var21, var23, var22, var24);
                     } else {
                        var33 = new class12(var4, 2, var5 + 4, var11, var2, var3, var14.field964, true, (Renderable)null);
                        var29 = new class12(var4, 2, var32, var11, var2, var3, var14.field964, true, (Renderable)null);
                     }

                     var37.method1962(var0, var2, var3, var22, (Renderable)var33, (Renderable)var29, class5.field83[var5], class5.field83[var32], var25, var26);
                     if(var14.field952 != 0) {
                        var13.method2449(var2, var3, var6, var5, var14.field953);
                     }
                  } else if(var6 == 3) {
                     if(var14.field964 == -1 && null == var14.impostorIds) {
                        var27 = var14.method841(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, 3, var5, var11, var2, var3, var14.field964, true, (Renderable)null);
                     }

                     var37.method1962(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class5.field84[var5], 0, var25, var26);
                     if(var14.field952 != 0) {
                        var13.method2449(var2, var3, var6, var5, var14.field953);
                     }
                  } else if(var6 == 9) {
                     if(var14.field964 == -1 && null == var14.impostorIds) {
                        var27 = var14.method841(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, var6, var5, var11, var2, var3, var14.field964, true, (Renderable)null);
                     }

                     var37.method1971(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                     if(var14.field952 != 0) {
                        var13.method2450(var2, var3, var15, var16, var14.field953);
                     }
                  } else if(var6 == 4) {
                     if(var14.field964 == -1 && null == var14.impostorIds) {
                        var27 = var14.method841(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, 4, var5, var11, var2, var3, var14.field964, true, (Renderable)null);
                     }

                     var37.method1970(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class5.field83[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var28;
                     if(var6 == 5) {
                        var32 = 16;
                        var28 = var37.method1986(var0, var2, var3);
                        if(var28 != 0) {
                           var32 = Projectile.getObjectDefinition(var28 >> 14 & 32767).field959;
                        }

                        if(var14.field964 == -1 && null == var14.impostorIds) {
                           var29 = var14.method841(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, var5, var11, var2, var3, var14.field964, true, (Renderable)null);
                        }

                        var37.method1970(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, class5.field83[var5], 0, class5.field85[var5] * var32, var32 * class5.field79[var5], var25, var26);
                     } else if(var6 == 6) {
                        var32 = 8;
                        var28 = var37.method1986(var0, var2, var3);
                        if(var28 != 0) {
                           var32 = Projectile.getObjectDefinition(var28 >> 14 & 32767).field959 / 2;
                        }

                        if(var14.field964 == -1 && var14.impostorIds == null) {
                           var29 = var14.method841(4, var5 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, 4 + var5, var11, var2, var3, var14.field964, true, (Renderable)null);
                        }

                        var37.method1970(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, 256, var5, var32 * class5.field95[var5], class5.field88[var5] * var32, var25, var26);
                     } else if(var6 == 7) {
                        var28 = var5 + 2 & 3;
                        if(var14.field964 == -1 && null == var14.impostorIds) {
                           var27 = var14.method841(4, var28 + 4, var21, var23, var22, var24);
                        } else {
                           var27 = new class12(var4, 4, var28 + 4, var11, var2, var3, var14.field964, true, (Renderable)null);
                        }

                        var37.method1970(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, 256, var28, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var32 = 8;
                        var28 = var37.method1986(var0, var2, var3);
                        if(var28 != 0) {
                           var32 = Projectile.getObjectDefinition(var28 >> 14 & 32767).field959 / 2;
                        }

                        int var31 = var5 + 2 & 3;
                        Object var30;
                        if(var14.field964 == -1 && null == var14.impostorIds) {
                           var29 = var14.method841(4, 4 + var5, var21, var23, var22, var24);
                           var30 = var14.method841(4, var31 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, var5 + 4, var11, var2, var3, var14.field964, true, (Renderable)null);
                           var30 = new class12(var4, 4, 4 + var31, var11, var2, var3, var14.field964, true, (Renderable)null);
                        }

                        var37.method1970(var0, var2, var3, var22, (Renderable)var29, (Renderable)var30, 256, var5, class5.field95[var5] * var32, class5.field88[var5] * var32, var25, var26);
                     }
                  }
               }
            } else {
               if(var14.field964 == -1 && var14.impostorIds == null) {
                  var27 = var14.method841(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class12(var4, 10, var5, var11, var2, var3, var14.field964, true, (Renderable)null);
               }

               if(null != var27) {
                  var37.method1971(var0, var2, var3, var22, var15, var16, (Renderable)var27, var6 == 11?256:0, var25, var26);
               }

               if(var14.field952 != 0) {
                  var13.method2450(var2, var3, var15, var16, var14.field953);
               }
            }
         }
      }

   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "6695213"
   )
   static final void method102(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = class94.field1650[var6];
         var12 = class94.field1651[var6];
         var13 = var12 * var9 - var11 * var5 >> 16;
         var10 = var11 * var9 + var12 * var5 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = class94.field1650[var7];
         var12 = class94.field1651[var7];
         var13 = var12 * var8 + var11 * var10 >> 16;
         var10 = var10 * var12 - var11 * var8 >> 16;
         var8 = var13;
      }

      class79.cameraX = var0 - var8;
      class10.cameraZ = var1 - var9;
      class170.cameraY = var2 - var10;
      class116.cameraPitch = var3;
      SecondaryBufferProvider.cameraYaw = var4;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "1523259723"
   )
   public static final boolean method110(String var0, String var1, String var2, String var3) {
      return null != var0 && var2 != null?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1754345951"
   )
   static final void method111() {
      class107.method2360(false);
      Client.field336 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class33.field764.length; ++var1) {
         if(KitDefinition.field1060[var1] != -1 && null == class33.field764[var1]) {
            class33.field764[var1] = class38.field820.method3305(KitDefinition.field1060[var1], 0);
            if(class33.field764[var1] == null) {
               var0 = false;
               ++Client.field336;
            }
         }

         if(class12.field185[var1] != -1 && class45.field1049[var1] == null) {
            class45.field1049[var1] = class38.field820.method3281(class12.field185[var1], 0, Sequence.xteaKeys[var1]);
            if(null == class45.field1049[var1]) {
               var0 = false;
               ++Client.field336;
            }
         }
      }

      if(!var0) {
         Client.field548 = 1;
      } else {
         Client.field514 = 0;
         var0 = true;

         int var3;
         int var4;
         for(var1 = 0; var1 < class33.field764.length; ++var1) {
            byte[] var31 = class45.field1049[var1];
            if(null != var31) {
               var3 = 64 * (class77.mapRegions[var1] >> 8) - class47.baseX;
               var4 = 64 * (class77.mapRegions[var1] & 255) - class21.baseY;
               if(Client.field342) {
                  var3 = 10;
                  var4 = 10;
               }

               var0 &= World.method646(var31, var3, var4);
            }
         }

         if(!var0) {
            Client.field548 = 2;
         } else {
            if(Client.field548 != 0) {
               class20.method570("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            class110.method2445();
            class31.method676();
            class110.method2445();
            Frames.region.method2016();
            class110.method2445();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].method2469();
            }

            int var2;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var2 = 0; var2 < 104; ++var2) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class5.tileSettings[var1][var2][var3] = 0;
                  }
               }
            }

            class110.method2445();
            class5.field77 = 99;
            class5.field78 = new byte[4][104][104];
            class5.field75 = new byte[4][104][104];
            class212.field3169 = new byte[4][104][104];
            class13.field199 = new byte[4][104][104];
            class5.field82 = new int[4][105][105];
            class53.field1155 = new byte[4][105][105];
            class232.field3278 = new int[105][105];
            class5.field91 = new int[104];
            class134.field2122 = new int[104];
            class5.field87 = new int[104];
            Ignore.field130 = new int[104];
            class153.field2294 = new int[104];
            var1 = class33.field764.length;

            for(class24 var37 = (class24)class24.field609.method3864(); null != var37; var37 = (class24)class24.field609.method3851()) {
               if(var37.field601 != null) {
                  class112.field1970.method1177(var37.field601);
                  var37.field601 = null;
               }

               if(var37.field614 != null) {
                  class112.field1970.method1177(var37.field614);
                  var37.field614 = null;
               }
            }

            class24.field609.method3850();
            class107.method2360(true);
            int var6;
            int var7;
            int var9;
            int var10;
            int var11;
            int var12;
            int var35;
            if(!Client.field342) {
               byte[] var5;
               for(var2 = 0; var2 < var1; ++var2) {
                  var3 = 64 * (class77.mapRegions[var2] >> 8) - class47.baseX;
                  var4 = (class77.mapRegions[var2] & 255) * 64 - class21.baseY;
                  var5 = class33.field764[var2];
                  if(null != var5) {
                     class110.method2445();
                     var6 = Projectile.field117 * 8 - 48;
                     var7 = field144 * 8 - 48;
                     CollisionData[] var32 = Client.collisionMaps;

                     for(var9 = 0; var9 < 4; ++var9) {
                        for(var10 = 0; var10 < 64; ++var10) {
                           for(var11 = 0; var11 < 64; ++var11) {
                              if(var10 + var3 > 0 && var10 + var3 < 103 && var11 + var4 > 0 && var4 + var11 < 103) {
                                 var32[var9].flags[var10 + var3][var4 + var11] &= -16777217;
                              }
                           }
                        }
                     }

                     Buffer var33 = new Buffer(var5);

                     for(var10 = 0; var10 < 4; ++var10) {
                        for(var11 = 0; var11 < 64; ++var11) {
                           for(var12 = 0; var12 < 64; ++var12) {
                              class16.method173(var33, var10, var3 + var11, var4 + var12, var6, var7, 0);
                           }
                        }
                     }
                  }
               }

               for(var2 = 0; var2 < var1; ++var2) {
                  var3 = 64 * (class77.mapRegions[var2] >> 8) - class47.baseX;
                  var4 = 64 * (class77.mapRegions[var2] & 255) - class21.baseY;
                  var5 = class33.field764[var2];
                  if(var5 == null && field144 < 800) {
                     class110.method2445();
                     Ignore.method97(var3, var4, 64, 64);
                  }
               }

               class107.method2360(true);

               for(var2 = 0; var2 < var1; ++var2) {
                  byte[] var34 = class45.field1049[var2];
                  if(var34 != null) {
                     var4 = (class77.mapRegions[var2] >> 8) * 64 - class47.baseX;
                     var35 = 64 * (class77.mapRegions[var2] & 255) - class21.baseY;
                     class110.method2445();
                     class112.method2487(var34, var4, var35, Frames.region, Client.collisionMaps);
                  }
               }
            }

            int var8;
            if(Client.field342) {
               for(var2 = 0; var2 < 4; ++var2) {
                  class110.method2445();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var38 = false;
                        var6 = Client.field334[var2][var3][var4];
                        if(var6 != -1) {
                           var7 = var6 >> 24 & 3;
                           var8 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = var10 / 8 + (var9 / 8 << 8);

                           for(var12 = 0; var12 < class77.mapRegions.length; ++var12) {
                              if(var11 == class77.mapRegions[var12] && class33.field764[var12] != null) {
                                 byte[] var13 = class33.field764[var12];
                                 int var14 = var3 * 8;
                                 int var15 = 8 * var4;
                                 int var16 = (var9 & 7) * 8;
                                 int var17 = (var10 & 7) * 8;
                                 CollisionData[] var18 = Client.collisionMaps;

                                 int var20;
                                 for(int var19 = 0; var19 < 8; ++var19) {
                                    for(var20 = 0; var20 < 8; ++var20) {
                                       if(var14 + var19 > 0 && var19 + var14 < 103 && var20 + var15 > 0 && var15 + var20 < 103) {
                                          var18[var2].flags[var19 + var14][var15 + var20] &= -16777217;
                                       }
                                    }
                                 }

                                 Buffer var36 = new Buffer(var13);

                                 for(var20 = 0; var20 < 4; ++var20) {
                                    for(int var21 = 0; var21 < 64; ++var21) {
                                       for(int var22 = 0; var22 < 64; ++var22) {
                                          if(var20 == var7 && var21 >= var16 && var21 < var16 + 8 && var22 >= var17 && var22 < 8 + var17) {
                                             int var25 = var14 + class43.method879(var21 & 7, var22 & 7, var8);
                                             int var28 = var21 & 7;
                                             int var29 = var22 & 7;
                                             int var30 = var8 & 3;
                                             int var27;
                                             if(var30 == 0) {
                                                var27 = var29;
                                             } else if(var30 == 1) {
                                                var27 = 7 - var28;
                                             } else if(var30 == 2) {
                                                var27 = 7 - var29;
                                             } else {
                                                var27 = var28;
                                             }

                                             class16.method173(var36, var2, var25, var27 + var15, 0, 0, var8);
                                          } else {
                                             class16.method173(var36, 0, -1, -1, 0, 0, 0);
                                          }
                                       }
                                    }
                                 }

                                 var38 = true;
                                 break;
                              }
                           }
                        }

                        if(!var38) {
                           var7 = var2;
                           var8 = var3 * 8;
                           var9 = var4 * 8;

                           for(var10 = 0; var10 < 8; ++var10) {
                              for(var11 = 0; var11 < 8; ++var11) {
                                 class5.tileHeights[var7][var10 + var8][var11 + var9] = 0;
                              }
                           }

                           if(var8 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class5.tileHeights[var7][var8][var9 + var10] = class5.tileHeights[var7][var8 - 1][var10 + var9];
                              }
                           }

                           if(var9 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class5.tileHeights[var7][var8 + var10][var9] = class5.tileHeights[var7][var10 + var8][var9 - 1];
                              }
                           }

                           if(var8 > 0 && class5.tileHeights[var7][var8 - 1][var9] != 0) {
                              class5.tileHeights[var7][var8][var9] = class5.tileHeights[var7][var8 - 1][var9];
                           } else if(var9 > 0 && class5.tileHeights[var7][var8][var9 - 1] != 0) {
                              class5.tileHeights[var7][var8][var9] = class5.tileHeights[var7][var8][var9 - 1];
                           } else if(var8 > 0 && var9 > 0 && class5.tileHeights[var7][var8 - 1][var9 - 1] != 0) {
                              class5.tileHeights[var7][var8][var9] = class5.tileHeights[var7][var8 - 1][var9 - 1];
                           }
                        }
                     }
                  }
               }

               for(var2 = 0; var2 < 13; ++var2) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.field334[0][var2][var3];
                     if(var4 == -1) {
                        Ignore.method97(var2 * 8, var3 * 8, 8, 8);
                     }
                  }
               }

               class107.method2360(true);

               for(var2 = 0; var2 < 4; ++var2) {
                  class110.method2445();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        var35 = Client.field334[var2][var3][var4];
                        if(var35 != -1) {
                           var6 = var35 >> 24 & 3;
                           var7 = var35 >> 1 & 3;
                           var8 = var35 >> 14 & 1023;
                           var9 = var35 >> 3 & 2047;
                           var10 = (var8 / 8 << 8) + var9 / 8;

                           for(var11 = 0; var11 < class77.mapRegions.length; ++var11) {
                              if(var10 == class77.mapRegions[var11] && null != class45.field1049[var11]) {
                                 class117.method2509(class45.field1049[var11], var2, 8 * var3, 8 * var4, var6, (var8 & 7) * 8, (var9 & 7) * 8, var7, Frames.region, Client.collisionMaps);
                                 break;
                              }
                           }
                        }
                     }
                  }
               }
            }

            class107.method2360(true);
            class31.method676();
            class110.method2445();
            class40.method794(Frames.region, Client.collisionMaps);
            class107.method2360(true);
            var2 = class5.field77;
            if(var2 > class145.plane) {
               var2 = class145.plane;
            }

            if(var2 < class145.plane - 1) {
               var2 = class145.plane - 1;
            }

            if(Client.field282) {
               Frames.region.method2142(class5.field77);
            } else {
               Frames.region.method2142(0);
            }

            for(var3 = 0; var3 < 104; ++var3) {
               for(var4 = 0; var4 < 104; ++var4) {
                  BufferProvider.groundItemSpawned(var3, var4);
               }
            }

            class110.method2445();
            class48.method992();
            ObjectComposition.field938.reset();
            if(class12.field188 != null) {
               Client.field324.method2828(185);
               Client.field324.method2559(1057001181);
            }

            if(!Client.field342) {
               var3 = (Projectile.field117 - 6) / 8;
               var4 = (Projectile.field117 + 6) / 8;
               var35 = (field144 - 6) / 8;
               var6 = (field144 + 6) / 8;

               for(var7 = var3 - 1; var7 <= var4 + 1; ++var7) {
                  for(var8 = var35 - 1; var8 <= 1 + var6; ++var8) {
                     if(var7 < var3 || var7 > var4 || var8 < var35 || var8 > var6) {
                        class38.field820.method3300("m" + var7 + "_" + var8);
                        class38.field820.method3300("l" + var7 + "_" + var8);
                     }
                  }
               }
            }

            class127.setGameState(30);
            class110.method2445();
            class5.field78 = null;
            class5.field75 = null;
            class212.field3169 = null;
            class13.field199 = null;
            class5.field82 = null;
            class53.field1155 = null;
            class232.field3278 = null;
            class5.field91 = null;
            class134.field2122 = null;
            class5.field87 = null;
            Ignore.field130 = null;
            class153.field2294 = null;
            Client.field324.method2828(54);
            class132.method2876();
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "74"
   )
   static void method112(int var0) {
      if(var0 != -1) {
         if(class85.method1938(var0)) {
            Widget[] var1 = Widget.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2871 != null) {
                  class0 var4 = new class0();
                  var4.field11 = var3;
                  var4.field0 = var3.field2871;
                  WallObject.method2150(var4, 2000000);
               }
            }

         }
      }
   }

   class8() {
      this.method99(true);
   }
}
