import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public class class174 {
   @ObfuscatedName("n")
   public static class182 field2643;

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "981137804"
   )
   static final void method3183() {
      XClanMember.method237(false);
      Client.field341 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class179.field2690.length; ++var1) {
         if(XGrandExchangeOffer.field41[var1] != -1 && class179.field2690[var1] == null) {
            class179.field2690[var1] = Friend.field150.method3211(XGrandExchangeOffer.field41[var1], 0);
            if(null == class179.field2690[var1]) {
               var0 = false;
               ++Client.field341;
            }
         }

         if(class16.field171[var1] != -1 && class18.field186[var1] == null) {
            class18.field186[var1] = Friend.field150.method3219(class16.field171[var1], 0, class196.xteaKeys[var1]);
            if(class18.field186[var1] == null) {
               var0 = false;
               ++Client.field341;
            }
         }
      }

      if(!var0) {
         Client.field345 = 1;
      } else {
         Client.field343 = 0;
         var0 = true;

         int var3;
         int var4;
         int var9;
         int var10;
         int var11;
         int var14;
         int var15;
         int var16;
         int var17;
         for(var1 = 0; var1 < class179.field2690.length; ++var1) {
            byte[] var25 = class18.field186[var1];
            if(null != var25) {
               var3 = (Client.mapRegions[var1] >> 8) * 64 - class15.baseX;
               var4 = (Client.mapRegions[var1] & 255) * 64 - class20.baseY;
               if(Client.field349) {
                  var3 = 10;
                  var4 = 10;
               }

               boolean var7 = true;
               Buffer var8 = new Buffer(var25);
               var9 = -1;

               label611:
               while(true) {
                  var10 = var8.method2772();
                  if(var10 == 0) {
                     var0 &= var7;
                     break;
                  }

                  var9 += var10;
                  var11 = 0;
                  boolean var12 = false;

                  while(true) {
                     int var13;
                     while(!var12) {
                        var13 = var8.method2772();
                        if(var13 == 0) {
                           continue label611;
                        }

                        var11 += var13 - 1;
                        var14 = var11 & 63;
                        var15 = var11 >> 6 & 63;
                        var16 = var8.readUnsignedByte() >> 2;
                        var17 = var15 + var3;
                        int var18 = var4 + var14;
                        if(var17 > 0 && var18 > 0 && var17 < 103 && var18 < 103) {
                           ObjectComposition var19 = ItemLayer.getObjectDefinition(var9);
                           if(var16 != 22 || !Client.field289 || var19.field2911 != 0 || var19.field2909 == 1 || var19.field2930) {
                              if(!var19.method3543()) {
                                 ++Client.field343;
                                 var7 = false;
                              }

                              var12 = true;
                           }
                        }
                     }

                     var13 = var8.method2772();
                     if(var13 == 0) {
                        break;
                     }

                     var8.readUnsignedByte();
                  }
               }
            }
         }

         if(!var0) {
            Client.field345 = 2;
         } else {
            if(Client.field345 != 0) {
               Frames.method1868("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            class115.method2194();
            class108.method2015();
            class115.method2194();
            Client.region.method1698();
            class115.method2194();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].method2210();
            }

            int var2;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var2 = 0; var2 < 104; ++var2) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class10.tileSettings[var1][var2][var3] = 0;
                  }
               }
            }

            class115.method2194();
            class188.method3391();
            var1 = class179.field2690.length;

            for(class31 var35 = (class31)class31.field706.method2359(); var35 != null; var35 = (class31)class31.field706.method2361()) {
               if(var35.field709 != null) {
                  class0.field3.method911(var35.field709);
                  var35.field709 = null;
               }

               if(null != var35.field714) {
                  class0.field3.method911(var35.field714);
                  var35.field714 = null;
               }
            }

            class31.field706.method2353();
            XClanMember.method237(true);
            int var5;
            if(!Client.field349) {
               byte[] var26;
               for(var2 = 0; var2 < var1; ++var2) {
                  var3 = (Client.mapRegions[var2] >> 8) * 64 - class15.baseX;
                  var4 = (Client.mapRegions[var2] & 255) * 64 - class20.baseY;
                  var26 = class179.field2690[var2];
                  if(var26 != null) {
                     class115.method2194();
                     class2.method26(var26, var3, var4, MessageNode.field227 * 8 - 48, Client.field503 * 8 - 48, Client.collisionMaps);
                  }
               }

               for(var2 = 0; var2 < var1; ++var2) {
                  var3 = 64 * (Client.mapRegions[var2] >> 8) - class15.baseX;
                  var4 = 64 * (Client.mapRegions[var2] & 255) - class20.baseY;
                  var26 = class179.field2690[var2];
                  if(null == var26 && Client.field503 < 800) {
                     class115.method2194();
                     class103.method1933(var3, var4, 64, 64);
                  }
               }

               XClanMember.method237(true);

               for(var2 = 0; var2 < var1; ++var2) {
                  byte[] var24 = class18.field186[var2];
                  if(var24 != null) {
                     var4 = (Client.mapRegions[var2] >> 8) * 64 - class15.baseX;
                     var5 = (Client.mapRegions[var2] & 255) * 64 - class20.baseY;
                     class115.method2194();
                     class101.method1924(var24, var4, var5, Client.region, Client.collisionMaps);
                  }
               }
            }

            int var6;
            int var23;
            int var31;
            if(Client.field349) {
               for(var2 = 0; var2 < 4; ++var2) {
                  class115.method2194();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var30 = false;
                        var6 = Client.field350[var2][var3][var4];
                        if(var6 != -1) {
                           var31 = var6 >> 24 & 3;
                           var23 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = var10 / 8 + (var9 / 8 << 8);

                           for(int var32 = 0; var32 < Client.mapRegions.length; ++var32) {
                              if(Client.mapRegions[var32] == var11 && null != class179.field2690[var32]) {
                                 byte[] var28 = class179.field2690[var32];
                                 var14 = var3 * 8;
                                 var15 = 8 * var4;
                                 var16 = (var9 & 7) * 8;
                                 var17 = (var10 & 7) * 8;
                                 CollisionData[] var29 = Client.collisionMaps;

                                 int var20;
                                 for(int var27 = 0; var27 < 8; ++var27) {
                                    for(var20 = 0; var20 < 8; ++var20) {
                                       if(var14 + var27 > 0 && var27 + var14 < 103 && var15 + var20 > 0 && var20 + var15 < 103) {
                                          var29[var2].flags[var14 + var27][var20 + var15] &= -16777217;
                                       }
                                    }
                                 }

                                 Buffer var33 = new Buffer(var28);

                                 for(var20 = 0; var20 < 4; ++var20) {
                                    for(int var21 = 0; var21 < 64; ++var21) {
                                       for(int var22 = 0; var22 < 64; ++var22) {
                                          if(var31 == var20 && var21 >= var16 && var21 < var16 + 8 && var22 >= var17 && var22 < 8 + var17) {
                                             WidgetNode.method184(var33, var2, var14 + class48.method855(var21 & 7, var22 & 7, var23), var15 + class30.method632(var21 & 7, var22 & 7, var23), 0, 0, var23);
                                          } else {
                                             WidgetNode.method184(var33, 0, -1, -1, 0, 0, 0);
                                          }
                                       }
                                    }
                                 }

                                 var30 = true;
                                 break;
                              }
                           }
                        }

                        if(!var30) {
                           class6.method80(var2, var3 * 8, var4 * 8);
                        }
                     }
                  }
               }

               for(var2 = 0; var2 < 13; ++var2) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.field350[0][var2][var3];
                     if(var4 == -1) {
                        class103.method1933(8 * var2, 8 * var3, 8, 8);
                     }
                  }
               }

               XClanMember.method237(true);

               for(var2 = 0; var2 < 4; ++var2) {
                  class115.method2194();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        var5 = Client.field350[var2][var3][var4];
                        if(var5 != -1) {
                           var6 = var5 >> 24 & 3;
                           var31 = var5 >> 1 & 3;
                           var23 = var5 >> 14 & 1023;
                           var9 = var5 >> 3 & 2047;
                           var10 = (var23 / 8 << 8) + var9 / 8;

                           for(var11 = 0; var11 < Client.mapRegions.length; ++var11) {
                              if(var10 == Client.mapRegions[var11] && class18.field186[var11] != null) {
                                 class119.method2253(class18.field186[var11], var2, var3 * 8, var4 * 8, var6, (var23 & 7) * 8, (var9 & 7) * 8, var31, Client.region, Client.collisionMaps);
                                 break;
                              }
                           }
                        }
                     }
                  }
               }
            }

            XClanMember.method237(true);
            class108.method2015();
            class115.method2194();
            class20.method198(Client.region, Client.collisionMaps);
            XClanMember.method237(true);
            var2 = class10.field102;
            if(var2 > class171.plane) {
               var2 = class171.plane;
            }

            if(var2 < class171.plane - 1) {
               var2 = class171.plane - 1;
            }

            if(Client.field289) {
               Client.region.method1692(class10.field102);
            } else {
               Client.region.method1692(0);
            }

            for(var3 = 0; var3 < 104; ++var3) {
               for(var4 = 0; var4 < 104; ++var4) {
                  class6.groundItemSpawned(var3, var4);
               }
            }

            class115.method2194();

            for(class25 var34 = (class25)Client.field370.method2359(); null != var34; var34 = (class25)Client.field370.method2361()) {
               if(var34.field578 == -1) {
                  var34.field582 = 0;
                  class101.method1916(var34);
               } else {
                  var34.unlink();
               }
            }

            ObjectComposition.field2895.reset();
            if(class164.field2162 != null) {
               Client.field294.method2976(213);
               Client.field294.method2748(1057001181);
            }

            if(!Client.field349) {
               var3 = (MessageNode.field227 - 6) / 8;
               var4 = (MessageNode.field227 + 6) / 8;
               var5 = (Client.field503 - 6) / 8;
               var6 = (6 + Client.field503) / 8;

               for(var31 = var3 - 1; var31 <= var4 + 1; ++var31) {
                  for(var23 = var5 - 1; var23 <= var6 + 1; ++var23) {
                     if(var31 < var3 || var31 > var4 || var23 < var5 || var23 > var6) {
                        Friend.field150.method3230("m" + var31 + "_" + var23);
                        Friend.field150.method3230("l" + var31 + "_" + var23);
                     }
                  }
               }
            }

            XGrandExchangeOffer.setGameState(30);
            class115.method2194();
            class138.method2458();
            Client.field294.method2976(115);
            class101.method1927();
         }
      }
   }
}
