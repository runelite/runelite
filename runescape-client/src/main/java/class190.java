import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class190 extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -962212087
   )
   int field2795 = 0;
   @ObfuscatedName("r")
   short[] field2796;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1949827591
   )
   int field2797;
   @ObfuscatedName("h")
   static NodeCache field2798 = new NodeCache(30);
   @ObfuscatedName("x")
   short[] field2799;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -562778707
   )
   int field2800 = 128;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1187357599
   )
   public int field2801 = -1;
   @ObfuscatedName("u")
   short[] field2802;
   @ObfuscatedName("b")
   short[] field2803;
   @ObfuscatedName("s")
   public static class182 field2804;
   @ObfuscatedName("c")
   public static class182 field2805;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 896916359
   )
   int field2806 = 128;
   @ObfuscatedName("f")
   static NodeCache field2807 = new NodeCache(64);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1734900905
   )
   int field2808;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -214829411
   )
   int field2809 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 241259981
   )
   int field2810 = 0;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)LModel;",
      garbageValue = "-1221828807"
   )
   public final Model method3353(int var1) {
      Model var2 = (Model)field2798.get((long)this.field2797);
      if(var2 == null) {
         ModelData var3 = ModelData.method1426(field2805, this.field2808, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(null != this.field2802) {
            for(var4 = 0; var4 < this.field2802.length; ++var4) {
               var3.method1439(this.field2802[var4], this.field2803[var4]);
            }
         }

         if(this.field2799 != null) {
            for(var4 = 0; var4 < this.field2799.length; ++var4) {
               var3.method1440(this.field2799[var4], this.field2796[var4]);
            }
         }

         var2 = var3.method1446(64 + this.field2809, this.field2810 + 850, -30, -50, -30);
         field2798.put(var2, (long)this.field2797);
      }

      Model var5;
      if(this.field2801 != -1 && var1 != -1) {
         var5 = class110.getAnimation(this.field2801).method3613(var2, var1);
      } else {
         var5 = var2.method1520(true);
      }

      if(this.field2806 != 128 || this.field2800 != 128) {
         var5.method1546(this.field2806, this.field2800, this.field2806);
      }

      if(this.field2795 != 0) {
         if(this.field2795 == 90) {
            var5.method1589();
         }

         if(this.field2795 == 180) {
            var5.method1589();
            var5.method1589();
         }

         if(this.field2795 == 270) {
            var5.method1589();
            var5.method1589();
            var5.method1589();
         }
      }

      return var5;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "606602726"
   )
   void method3354(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2808 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field2801 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field2806 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field2800 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field2795 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field2809 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field2810 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field2802 = new short[var3];
            this.field2803 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2802[var4] = (short)var1.readUnsignedShort();
               this.field2803[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field2799 = new short[var3];
            this.field2796 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2799[var4] = (short)var1.readUnsignedShort();
               this.field2796[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-925965049"
   )
   void method3364(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3354(var1, var2);
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "67"
   )
   static final void method3366(int var0, int var1, int var2, int var3) {
      ++Client.field397;
      class85.method1654(class15.field173);
      boolean var4 = false;
      int var5;
      int var7;
      if(Client.field292 >= 0) {
         var5 = class45.field894;
         int[] var28 = class45.field896;

         for(var7 = 0; var7 < var5; ++var7) {
            if(Client.field292 == var28[var7]) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         class85.method1654(class15.field168);
      }

      class202.method3651(true);
      class85.method1654(var4?class15.field170:class15.field169);
      class202.method3651(false);
      class176.method3155();
      ItemLayer.method1423();
      class1.method11(var0, var1, var2, var3, true);
      var0 = Client.field378;
      var1 = Client.field555;
      var2 = Client.camera2;
      var3 = Client.camera3;
      Rasterizer2D.method3844(var0, var1, var0 + var2, var1 + var3);
      class84.method1633();
      int var6;
      if(!Client.field499) {
         var5 = Client.field419;
         if(Client.field376 / 256 > var5) {
            var5 = Client.field376 / 256;
         }

         if(Client.field541[4] && Client.field543[4] + 128 > var5) {
            var5 = 128 + Client.field543[4];
         }

         var6 = Client.mapAngle + Client.field382 & 2047;
         GameEngine.method2113(class0.field7, XClanMember.method223(XItemContainer.localPlayer.x, XItemContainer.localPlayer.y, class118.plane) - Client.field366, class1.field11, var5, var6, 600 + var5 * 3);
      }

      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var15;
      if(!Client.field499) {
         if(class38.field794.field699) {
            var6 = class118.plane;
         } else {
            label574: {
               var7 = 3;
               if(class13.cameraPitch < 310) {
                  var8 = XItemContainer.cameraX >> 7;
                  var9 = class20.cameraY >> 7;
                  var10 = XItemContainer.localPlayer.x >> 7;
                  var11 = XItemContainer.localPlayer.y >> 7;
                  if(var8 < 0 || var9 < 0 || var8 >= 104 || var9 >= 104) {
                     var6 = class118.plane;
                     break label574;
                  }

                  if((class10.tileSettings[class118.plane][var8][var9] & 4) != 0) {
                     var7 = class118.plane;
                  }

                  if(var10 > var8) {
                     var12 = var10 - var8;
                  } else {
                     var12 = var8 - var10;
                  }

                  if(var11 > var9) {
                     var13 = var11 - var9;
                  } else {
                     var13 = var9 - var11;
                  }

                  int var14;
                  if(var12 > var13) {
                     var14 = 65536 * var13 / var12;
                     var15 = '耀';

                     while(var8 != var10) {
                        if(var8 < var10) {
                           ++var8;
                        } else if(var8 > var10) {
                           --var8;
                        }

                        if((class10.tileSettings[class118.plane][var8][var9] & 4) != 0) {
                           var7 = class118.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var9 < var11) {
                              ++var9;
                           } else if(var9 > var11) {
                              --var9;
                           }

                           if((class10.tileSettings[class118.plane][var8][var9] & 4) != 0) {
                              var7 = class118.plane;
                           }
                        }
                     }
                  } else {
                     var14 = var12 * 65536 / var13;
                     var15 = '耀';

                     while(var9 != var11) {
                        if(var9 < var11) {
                           ++var9;
                        } else if(var9 > var11) {
                           --var9;
                        }

                        if((class10.tileSettings[class118.plane][var8][var9] & 4) != 0) {
                           var7 = class118.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var8 < var10) {
                              ++var8;
                           } else if(var8 > var10) {
                              --var8;
                           }

                           if((class10.tileSettings[class118.plane][var8][var9] & 4) != 0) {
                              var7 = class118.plane;
                           }
                        }
                     }
                  }
               }

               if(XItemContainer.localPlayer.x >= 0 && XItemContainer.localPlayer.y >= 0 && XItemContainer.localPlayer.x < 13312 && XItemContainer.localPlayer.y < 13312) {
                  if((class10.tileSettings[class118.plane][XItemContainer.localPlayer.x >> 7][XItemContainer.localPlayer.y >> 7] & 4) != 0) {
                     var7 = class118.plane;
                  }

                  var6 = var7;
               } else {
                  var6 = class118.plane;
               }
            }
         }

         var5 = var6;
      } else {
         var5 = class1.method12();
      }

      var6 = XItemContainer.cameraX;
      var7 = class11.cameraZ;
      var8 = class20.cameraY;
      var9 = class13.cameraPitch;
      var10 = class105.cameraYaw;

      for(var11 = 0; var11 < 5; ++var11) {
         if(Client.field541[var11]) {
            var12 = (int)(Math.random() * (double)(1 + 2 * Client.field495[var11]) - (double)Client.field495[var11] + Math.sin((double)Client.field544[var11] / 100.0D * (double)Client.field545[var11]) * (double)Client.field543[var11]);
            if(var11 == 0) {
               XItemContainer.cameraX += var12;
            }

            if(var11 == 1) {
               class11.cameraZ += var12;
            }

            if(var11 == 2) {
               class20.cameraY += var12;
            }

            if(var11 == 3) {
               class105.cameraYaw = var12 + class105.cameraYaw & 2047;
            }

            if(var11 == 4) {
               class13.cameraPitch += var12;
               if(class13.cameraPitch < 128) {
                  class13.cameraPitch = 128;
               }

               if(class13.cameraPitch > 383) {
                  class13.cameraPitch = 383;
               }
            }
         }
      }

      var11 = class115.field1810;
      var12 = class115.field1803;
      if(class115.field1807 != 0) {
         var11 = class115.field1809;
         var12 = class115.field1796;
      }

      if(var11 >= var0 && var11 < var0 + var2 && var12 >= var1 && var12 < var3 + var1) {
         Model.field1411 = true;
         Model.field1414 = 0;
         Model.field1412 = var11 - var0;
         Model.field1413 = var12 - var1;
      } else {
         Model.field1411 = false;
         Model.field1414 = 0;
      }

      ChatMessages.method830();
      Rasterizer2D.method3876(var0, var1, var2, var3, 0);
      ChatMessages.method830();
      var13 = class84.field1435;
      class84.field1435 = Client.scale;
      class0.region.method1696(XItemContainer.cameraX, class11.cameraZ, class20.cameraY, class13.cameraPitch, class105.cameraYaw, var5);
      class84.field1435 = var13;
      ChatMessages.method830();
      class0.region.method1780();
      Client.field386 = 0;
      boolean var31 = false;
      var15 = -1;
      int var16 = class45.field894;
      int[] var17 = class45.field896;

      int var18;
      for(var18 = 0; var18 < Client.field332 + var16; ++var18) {
         Object var30;
         if(var18 < var16) {
            var30 = Client.cachedPlayers[var17[var18]];
            if(var17[var18] == Client.field292) {
               var31 = true;
               var15 = var18;
               continue;
            }
         } else {
            var30 = Client.cachedNPCs[Client.field333[var18 - var16]];
         }

         class49.method855((Actor)var30, var18, var0, var1, var2, var3);
      }

      if(var31) {
         class49.method855(Client.cachedPlayers[Client.field292], var15, var0, var1, var2, var3);
      }

      for(var18 = 0; var18 < Client.field386; ++var18) {
         int var19 = Client.field338[var18];
         int var20 = Client.field389[var18];
         int var21 = Client.field391[var18];
         int var22 = Client.field341[var18];
         boolean var23 = true;

         while(var23) {
            var23 = false;

            for(int var29 = 0; var29 < var18; ++var29) {
               if(2 + var20 > Client.field389[var29] - Client.field341[var29] && var20 - var22 < 2 + Client.field389[var29] && var19 - var21 < Client.field391[var29] + Client.field338[var29] && var19 + var21 > Client.field338[var29] - Client.field391[var29] && Client.field389[var29] - Client.field341[var29] < var20) {
                  var20 = Client.field389[var29] - Client.field341[var29];
                  var23 = true;
               }
            }
         }

         Client.field398 = Client.field338[var18];
         Client.field399 = Client.field389[var18] = var20;
         String var24 = Client.field395[var18];
         if(Client.field493 == 0) {
            int var25 = 16776960;
            if(Client.field392[var18] < 6) {
               var25 = Client.field403[Client.field392[var18]];
            }

            if(Client.field392[var18] == 6) {
               var25 = Client.field397 % 20 < 10?16711680:16776960;
            }

            if(Client.field392[var18] == 7) {
               var25 = Client.field397 % 20 < 10?255:'\uffff';
            }

            if(Client.field392[var18] == 8) {
               var25 = Client.field397 % 20 < 10?'뀀':8454016;
            }

            int var26;
            if(Client.field392[var18] == 9) {
               var26 = 150 - Client.field394[var18];
               if(var26 < 50) {
                  var25 = 16711680 + 1280 * var26;
               } else if(var26 < 100) {
                  var25 = 16776960 - 327680 * (var26 - 50);
               } else if(var26 < 150) {
                  var25 = '\uff00' + (var26 - 100) * 5;
               }
            }

            if(Client.field392[var18] == 10) {
               var26 = 150 - Client.field394[var18];
               if(var26 < 50) {
                  var25 = 5 * var26 + 16711680;
               } else if(var26 < 100) {
                  var25 = 16711935 - 327680 * (var26 - 50);
               } else if(var26 < 150) {
                  var25 = 255 + (var26 - 100) * 327680 - 5 * (var26 - 100);
               }
            }

            if(Client.field392[var18] == 11) {
               var26 = 150 - Client.field394[var18];
               if(var26 < 50) {
                  var25 = 16777215 - var26 * 327685;
               } else if(var26 < 100) {
                  var25 = '\uff00' + (var26 - 50) * 327685;
               } else if(var26 < 150) {
                  var25 = 16777215 - 327680 * (var26 - 100);
               }
            }

            if(Client.field393[var18] == 0) {
               class16.field187.method3739(var24, Client.field398 + var0, var1 + Client.field399, var25, 0);
            }

            if(Client.field393[var18] == 1) {
               class16.field187.method3792(var24, var0 + Client.field398, Client.field399 + var1, var25, 0, Client.field397);
            }

            if(Client.field393[var18] == 2) {
               class16.field187.method3732(var24, var0 + Client.field398, Client.field399 + var1, var25, 0, Client.field397);
            }

            if(Client.field393[var18] == 3) {
               class16.field187.method3734(var24, Client.field398 + var0, Client.field399 + var1, var25, 0, Client.field397, 150 - Client.field394[var18]);
            }

            if(Client.field393[var18] == 4) {
               var26 = (150 - Client.field394[var18]) * (class16.field187.method3722(var24) + 100) / 150;
               Rasterizer2D.method3845(var0 + Client.field398 - 50, var1, 50 + var0 + Client.field398, var1 + var3);
               class16.field187.method3727(var24, Client.field398 + var0 + 50 - var26, Client.field399 + var1, var25, 0);
               Rasterizer2D.method3844(var0, var1, var2 + var0, var1 + var3);
            }

            if(Client.field393[var18] == 5) {
               var26 = 150 - Client.field394[var18];
               int var27 = 0;
               if(var26 < 25) {
                  var27 = var26 - 25;
               } else if(var26 > 125) {
                  var27 = var26 - 125;
               }

               Rasterizer2D.method3845(var0, var1 + Client.field399 - class16.field187.field3102 - 1, var0 + var2, 5 + var1 + Client.field399);
               class16.field187.method3739(var24, var0 + Client.field398, var27 + Client.field399 + var1, var25, 0);
               Rasterizer2D.method3844(var0, var1, var2 + var0, var1 + var3);
            }
         } else {
            class16.field187.method3739(var24, var0 + Client.field398, var1 + Client.field399, 16776960, 0);
         }
      }

      if(Client.field311 == 2) {
         class2.method29(Client.field317 + (Client.field314 - class22.baseX << 7), Client.field318 + (Client.field315 - class103.baseY << 7), Client.field316 * 2);
         if(Client.field398 > -1 && Client.gameCycle % 20 < 10) {
            class101.field1658[0].method3971(var0 + Client.field398 - 12, Client.field399 + var1 - 28);
         }
      }

      ((TextureProvider)class84.field1438).method1405(Client.field533);
      World.method633(var0, var1, var2, var3);
      XItemContainer.cameraX = var6;
      class11.cameraZ = var7;
      class20.cameraY = var8;
      class13.cameraPitch = var9;
      class105.cameraYaw = var10;
      if(Client.field302 && class176.method3154(true, false) == 0) {
         Client.field302 = false;
      }

      if(Client.field302) {
         Rasterizer2D.method3876(var0, var1, var2, var3, 0);
         class36.method714("Loading - please wait.", false);
      }

   }
}
