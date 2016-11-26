import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public class class20 implements Runnable {
   @ObfuscatedName("ez")
   static SpritePixels field213;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1656707901
   )
   int field214 = 0;
   @ObfuscatedName("n")
   boolean field215 = true;
   @ObfuscatedName("h")
   int[] field216 = new int[500];
   @ObfuscatedName("w")
   int[] field217 = new int[500];
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -1620810505
   )
   static int field219;
   @ObfuscatedName("ha")
   @ObfuscatedGetter(
      intValue = -204616537
   )
   @Export("menuHeight")
   static int menuHeight;
   @ObfuscatedName("d")
   Object field222 = new Object();

   public void run() {
      for(; this.field215; class0.method12(50L)) {
         Object var1 = this.field222;
         synchronized(this.field222) {
            if(this.field214 < 500) {
               this.field216[this.field214] = class115.field1811;
               this.field217[this.field214] = class115.field1810;
               ++this.field214;
            }
         }
      }

   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2024062480"
   )
   static final void method211() {
      class0.method10(false);
      Client.field342 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class11.field104.length; ++var1) {
         if(PlayerComposition.field2044[var1] != -1 && class11.field104[var1] == null) {
            class11.field104[var1] = Client.field413.method3329(PlayerComposition.field2044[var1], 0);
            if(null == class11.field104[var1]) {
               var0 = false;
               ++Client.field342;
            }
         }

         if(class32.field728[var1] != -1 && class22.field239[var1] == null) {
            class22.field239[var1] = Client.field413.method3330(class32.field728[var1], 0, class28.xteaKeys[var1]);
            if(class22.field239[var1] == null) {
               var0 = false;
               ++Client.field342;
            }
         }
      }

      if(!var0) {
         Client.field367 = 1;
      } else {
         Client.field344 = 0;
         var0 = true;

         int var3;
         int var4;
         int var10;
         int var11;
         int var23;
         for(var1 = 0; var1 < class11.field104.length; ++var1) {
            byte[] var21 = class22.field239[var1];
            if(var21 != null) {
               var3 = (FrameMap.mapRegions[var1] >> 8) * 64 - class16.baseX;
               var4 = 64 * (FrameMap.mapRegions[var1] & 255) - Client.baseY;
               if(Client.field348) {
                  var3 = 10;
                  var4 = 10;
               }

               boolean var7 = true;
               Buffer var22 = new Buffer(var21);
               var23 = -1;

               label648:
               while(true) {
                  var10 = var22.method3003();
                  if(var10 == 0) {
                     var0 &= var7;
                     break;
                  }

                  var23 += var10;
                  var11 = 0;
                  boolean var12 = false;

                  while(true) {
                     int var13;
                     while(!var12) {
                        var13 = var22.method3003();
                        if(var13 == 0) {
                           continue label648;
                        }

                        var11 += var13 - 1;
                        int var14 = var11 & 63;
                        int var15 = var11 >> 6 & 63;
                        int var16 = var22.readUnsignedByte() >> 2;
                        int var17 = var3 + var15;
                        int var18 = var14 + var4;
                        if(var17 > 0 && var18 > 0 && var17 < 103 && var18 < 103) {
                           ObjectComposition var19 = class15.getObjectDefinition(var23);
                           if(var16 != 22 || !Client.field288 || var19.field2910 != 0 || var19.field2908 == 1 || var19.field2929) {
                              if(!var19.method3689()) {
                                 ++Client.field344;
                                 var7 = false;
                              }

                              var12 = true;
                           }
                        }
                     }

                     var13 = var22.method3003();
                     if(var13 == 0) {
                        break;
                     }

                     var22.readUnsignedByte();
                  }
               }
            }
         }

         if(!var0) {
            Client.field367 = 2;
         } else {
            if(Client.field367 != 0) {
               World.method669("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            class13.method185();
            XItemContainer.method179();
            class13.method185();
            class157.region.method1740();
            class13.method185();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].method2302();
            }

            int var2;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var2 = 0; var2 < 104; ++var2) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class11.tileSettings[var1][var2][var3] = 0;
                  }
               }
            }

            class13.method185();
            class11.field102 = 99;
            class11.field105 = new byte[4][104][104];
            class11.field106 = new byte[4][104][104];
            class38.field797 = new byte[4][104][104];
            class11.field107 = new byte[4][104][104];
            class187.field2778 = new int[4][105][105];
            class5.field51 = new byte[4][105][105];
            class48.field933 = new int[105][105];
            class162.field2307 = new int[104];
            class107.field1728 = new int[104];
            class205.field3075 = new int[104];
            class72.field1179 = new int[104];
            class202.field3064 = new int[104];
            var1 = class11.field104.length;
            WallObject.method1921();
            class0.method10(true);
            int var5;
            int var6;
            int var26;
            int var27;
            if(!Client.field348) {
               byte[] var20;
               for(var2 = 0; var2 < var1; ++var2) {
                  var3 = 64 * (FrameMap.mapRegions[var2] >> 8) - class16.baseX;
                  var4 = (FrameMap.mapRegions[var2] & 255) * 64 - Client.baseY;
                  var20 = class11.field104[var2];
                  if(var20 != null) {
                     class13.method185();
                     var6 = class40.field807 * 8 - 48;
                     var26 = FrameMap.field1464 * 8 - 48;
                     CollisionData[] var28 = Client.collisionMaps;

                     for(var23 = 0; var23 < 4; ++var23) {
                        for(var10 = 0; var10 < 64; ++var10) {
                           for(var11 = 0; var11 < 64; ++var11) {
                              if(var3 + var10 > 0 && var3 + var10 < 103 && var11 + var4 > 0 && var4 + var11 < 103) {
                                 var28[var23].flags[var3 + var10][var11 + var4] &= -16777217;
                              }
                           }
                        }
                     }

                     Buffer var9 = new Buffer(var20);

                     for(var10 = 0; var10 < 4; ++var10) {
                        for(var11 = 0; var11 < 64; ++var11) {
                           for(var27 = 0; var27 < 64; ++var27) {
                              Player.method255(var9, var10, var3 + var11, var4 + var27, var6, var26, 0);
                           }
                        }
                     }
                  }
               }

               for(var2 = 0; var2 < var1; ++var2) {
                  var3 = (FrameMap.mapRegions[var2] >> 8) * 64 - class16.baseX;
                  var4 = (FrameMap.mapRegions[var2] & 255) * 64 - Client.baseY;
                  var20 = class11.field104[var2];
                  if(null == var20 && FrameMap.field1464 < 800) {
                     class13.method185();
                     Tile.method1578(var3, var4, 64, 64);
                  }
               }

               class0.method10(true);

               for(var2 = 0; var2 < var1; ++var2) {
                  byte[] var24 = class22.field239[var2];
                  if(null != var24) {
                     var4 = 64 * (FrameMap.mapRegions[var2] >> 8) - class16.baseX;
                     var5 = (FrameMap.mapRegions[var2] & 255) * 64 - Client.baseY;
                     class13.method185();
                     class114.method2252(var24, var4, var5, class157.region, Client.collisionMaps);
                  }
               }
            }

            int var8;
            if(Client.field348) {
               for(var2 = 0; var2 < 4; ++var2) {
                  class13.method185();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var25 = false;
                        var6 = Client.field349[var2][var3][var4];
                        if(var6 != -1) {
                           var26 = var6 >> 24 & 3;
                           var8 = var6 >> 1 & 3;
                           var23 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = (var23 / 8 << 8) + var10 / 8;

                           for(var27 = 0; var27 < FrameMap.mapRegions.length; ++var27) {
                              if(FrameMap.mapRegions[var27] == var11 && class11.field104[var27] != null) {
                                 class114.method2253(class11.field104[var27], var2, 8 * var3, var4 * 8, var26, (var23 & 7) * 8, 8 * (var10 & 7), var8, Client.collisionMaps);
                                 var25 = true;
                                 break;
                              }
                           }
                        }

                        if(!var25) {
                           var26 = var2;
                           var8 = 8 * var3;
                           var23 = var4 * 8;

                           for(var10 = 0; var10 < 8; ++var10) {
                              for(var11 = 0; var11 < 8; ++var11) {
                                 class11.tileHeights[var26][var10 + var8][var23 + var11] = 0;
                              }
                           }

                           if(var8 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class11.tileHeights[var26][var8][var23 + var10] = class11.tileHeights[var26][var8 - 1][var10 + var23];
                              }
                           }

                           if(var23 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class11.tileHeights[var26][var8 + var10][var23] = class11.tileHeights[var26][var10 + var8][var23 - 1];
                              }
                           }

                           if(var8 > 0 && class11.tileHeights[var26][var8 - 1][var23] != 0) {
                              class11.tileHeights[var26][var8][var23] = class11.tileHeights[var26][var8 - 1][var23];
                           } else if(var23 > 0 && class11.tileHeights[var26][var8][var23 - 1] != 0) {
                              class11.tileHeights[var26][var8][var23] = class11.tileHeights[var26][var8][var23 - 1];
                           } else if(var8 > 0 && var23 > 0 && class11.tileHeights[var26][var8 - 1][var23 - 1] != 0) {
                              class11.tileHeights[var26][var8][var23] = class11.tileHeights[var26][var8 - 1][var23 - 1];
                           }
                        }
                     }
                  }
               }

               for(var2 = 0; var2 < 13; ++var2) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.field349[0][var2][var3];
                     if(var4 == -1) {
                        Tile.method1578(8 * var2, 8 * var3, 8, 8);
                     }
                  }
               }

               class0.method10(true);

               for(var2 = 0; var2 < 4; ++var2) {
                  class13.method185();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        var5 = Client.field349[var2][var3][var4];
                        if(var5 != -1) {
                           var6 = var5 >> 24 & 3;
                           var26 = var5 >> 1 & 3;
                           var8 = var5 >> 14 & 1023;
                           var23 = var5 >> 3 & 2047;
                           var10 = var23 / 8 + (var8 / 8 << 8);

                           for(var11 = 0; var11 < FrameMap.mapRegions.length; ++var11) {
                              if(FrameMap.mapRegions[var11] == var10 && null != class22.field239[var11]) {
                                 class60.method1138(class22.field239[var11], var2, var3 * 8, 8 * var4, var6, (var8 & 7) * 8, 8 * (var23 & 7), var26, class157.region, Client.collisionMaps);
                                 break;
                              }
                           }
                        }
                     }
                  }
               }
            }

            class0.method10(true);
            XItemContainer.method179();
            class13.method185();
            class178.method3313(class157.region, Client.collisionMaps);
            class0.method10(true);
            var2 = class11.field102;
            if(var2 > class166.plane) {
               var2 = class166.plane;
            }

            if(var2 < class166.plane - 1) {
               var2 = class166.plane - 1;
            }

            if(Client.field288) {
               class157.region.method1741(class11.field102);
            } else {
               class157.region.method1741(0);
            }

            for(var3 = 0; var3 < 104; ++var3) {
               for(var4 = 0; var4 < 104; ++var4) {
                  ChatLineBuffer.groundItemSpawned(var3, var4);
               }
            }

            class13.method185();
            class18.method205();
            ObjectComposition.field2904.reset();
            if(null != MessageNode.field230) {
               Client.field330.method3234(124);
               Client.field330.method2978(1057001181);
            }

            if(!Client.field348) {
               var3 = (class40.field807 - 6) / 8;
               var4 = (class40.field807 + 6) / 8;
               var5 = (FrameMap.field1464 - 6) / 8;
               var6 = (6 + FrameMap.field1464) / 8;

               for(var26 = var3 - 1; var26 <= 1 + var4; ++var26) {
                  for(var8 = var5 - 1; var8 <= 1 + var6; ++var8) {
                     if(var26 < var3 || var26 > var4 || var8 < var5 || var8 > var6) {
                        Client.field413.method3384("m" + var26 + "_" + var8);
                        Client.field413.method3384("l" + var26 + "_" + var8);
                     }
                  }
               }
            }

            class186.setGameState(30);
            class13.method185();
            class30.method675();
            Client.field330.method3234(254);
            Client.method604();
         }
      }
   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "1161"
   )
   static final void method214() {
      int var0 = Projectile.menuX;
      int var1 = XClanMember.menuY;
      int var2 = class37.menuWidth;
      int var3 = menuHeight;
      int var4 = 6116423;
      class219.method4071(var0, var1, var2, var3, var4);
      class219.method4071(var0 + 1, var1 + 1, var2 - 2, 16, 0);
      class219.method4053(var0 + 1, 18 + var1, var2 - 2, var3 - 19, 0);
      class156.field2236.method3920("Choose Option", var0 + 3, var1 + 14, var4, -1);
      int var5 = class115.field1811;
      int var6 = class115.field1810;

      for(int var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         int var8 = (Client.menuOptionCount - 1 - var7) * 15 + 31 + var1;
         int var9 = 16777215;
         if(var5 > var0 && var5 < var2 + var0 && var6 > var8 - 13 && var6 < 3 + var8) {
            var9 = 16776960;
         }

         class208 var10 = class156.field2236;
         String var11;
         if(Client.menuTargets[var7].length() > 0) {
            var11 = Client.menuOptions[var7] + " " + Client.menuTargets[var7];
         } else {
            var11 = Client.menuOptions[var7];
         }

         var10.method3920(var11, var0 + 3, var8, var9, 0);
      }

      class16.method199(Projectile.menuX, XClanMember.menuY, class37.menuWidth, menuHeight);
   }
}
