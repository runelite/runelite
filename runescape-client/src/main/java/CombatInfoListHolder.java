import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   @Export("NetCache_reference")
   public static Buffer NetCache_reference;
   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   @Export("indexInterfaces")
   static IndexData indexInterfaces;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("combatInfo1")
   CombatInfoList combatInfo1;

   @ObfuscatedSignature(
      signature = "(Liu;)V"
   )
   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo1 = new CombatInfoList();
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1188267432"
   )
   void method1696(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.last(); var7 != null; var7 = (CombatInfo1)this.combatInfo1.previous()) {
         ++var6;
         if(var7.cycle == var1) {
            var7.set(var1, var2, var3, var4);
            return;
         }

         if(var7.cycle <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.addLast(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method3766(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.last().unlink();
         }

      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Lcj;",
      garbageValue = "200755774"
   )
   CombatInfo1 method1697(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.last();
      if(var2 != null && var2.cycle <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.previous(); var3 != null && var3.cycle <= var1; var3 = (CombatInfo1)this.combatInfo1.previous()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field3462 + var2.cycle + var2.int2 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1946000399"
   )
   boolean method1698() {
      return this.combatInfo1.isEmpty();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-54"
   )
   static String method1706(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "652741514"
   )
   static void method1704() {
      if(class91.username == null || class91.username.length() <= 0) {
         if(class222.preferences.rememberedUsername != null) {
            class91.username = class222.preferences.rememberedUsername;
            class91.Login_isUsernameRemembered = true;
         } else {
            class91.Login_isUsernameRemembered = false;
         }

      }
   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-81"
   )
   static final void method1707() {
      Actor.flush(false);
      Client.field921 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < UnitPriceComparator.field301.length; ++var1) {
         if(class235.landMapFileIds[var1] != -1 && UnitPriceComparator.field301[var1] == null) {
            UnitPriceComparator.field301[var1] = ScriptState.indexMaps.getConfigData(class235.landMapFileIds[var1], 0);
            if(UnitPriceComparator.field301[var1] == null) {
               var0 = false;
               ++Client.field921;
            }
         }

         if(Huffman.landRegionFileIds[var1] != -1 && Client.field926[var1] == null) {
            Client.field926[var1] = ScriptState.indexMaps.getConfigData(Huffman.landRegionFileIds[var1], 0, WorldMapType3.xteaKeys[var1]);
            if(Client.field926[var1] == null) {
               var0 = false;
               ++Client.field921;
            }
         }
      }

      if(!var0) {
         Client.field1052 = 1;
      } else {
         Client.field923 = 0;
         var0 = true;

         int var3;
         int var4;
         int var9;
         int var10;
         int var11;
         int var13;
         int var14;
         int var15;
         int var16;
         int var17;
         for(var1 = 0; var1 < UnitPriceComparator.field301.length; ++var1) {
            byte[] var2 = Client.field926[var1];
            if(var2 != null) {
               var3 = (class214.mapRegions[var1] >> 8) * 64 - class175.baseX;
               var4 = (class214.mapRegions[var1] & 255) * 64 - GraphicsObject.baseY;
               if(Client.isDynamicRegion) {
                  var3 = 10;
                  var4 = 10;
               }

               boolean var7 = true;
               Buffer var8 = new Buffer(var2);
               var9 = -1;

               label638:
               while(true) {
                  var10 = var8.getUSmart();
                  if(var10 == 0) {
                     var0 &= var7;
                     break;
                  }

                  var9 += var10;
                  var11 = 0;
                  boolean var12 = false;

                  while(true) {
                     while(!var12) {
                        var13 = var8.getUSmart();
                        if(var13 == 0) {
                           continue label638;
                        }

                        var11 += var13 - 1;
                        var14 = var11 & 63;
                        var15 = var11 >> 6 & 63;
                        var16 = var8.readUnsignedByte() >> 2;
                        var17 = var3 + var15;
                        int var18 = var14 + var4;
                        if(var17 > 0 && var18 > 0 && var17 < 103 && var18 < 103) {
                           ObjectComposition var19 = NPC.getObjectDefinition(var9);
                           if(var16 != 22 || !Client.lowMemory || var19.int1 != 0 || var19.clipType == 1 || var19.obstructsGround) {
                              if(!var19.method4709()) {
                                 ++Client.field923;
                                 var7 = false;
                              }

                              var12 = true;
                           }
                        }
                     }

                     var13 = var8.getUSmart();
                     if(var13 == 0) {
                        break;
                     }

                     var8.readUnsignedByte();
                  }
               }
            }
         }

         if(!var0) {
            Client.field1052 = 2;
         } else {
            if(Client.field1052 != 0) {
               GrandExchangeEvents.drawStatusBox("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            FontName.method4928();
            class175.method3264();
            FontName.method4928();
            class45.region.reset();
            FontName.method4928();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].reset();
            }

            int var49;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var49 = 0; var49 < 104; ++var49) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class61.tileSettings[var1][var49][var3] = 0;
                  }
               }
            }

            FontName.method4928();
            Huffman.method3275();
            var1 = UnitPriceComparator.field301.length;

            for(class81 var59 = (class81)class81.field1247.getFront(); var59 != null; var59 = (class81)class81.field1247.getNext()) {
               if(var59.field1249 != null) {
                  class89.field1328.method1924(var59.field1249);
                  var59.field1249 = null;
               }

               if(var59.field1250 != null) {
                  class89.field1328.method1924(var59.field1250);
                  var59.field1250 = null;
               }
            }

            class81.field1247.clear();
            Actor.flush(true);
            int var5;
            if(!Client.isDynamicRegion) {
               byte[] var50;
               for(var49 = 0; var49 < var1; ++var49) {
                  var3 = (class214.mapRegions[var49] >> 8) * 64 - class175.baseX;
                  var4 = (class214.mapRegions[var49] & 255) * 64 - GraphicsObject.baseY;
                  var50 = UnitPriceComparator.field301[var49];
                  if(var50 != null) {
                     FontName.method4928();
                     CollisionData.method3225(var50, var3, var4, class60.field724 * 8 - 48, GrandExchangeEvents.field263 * 8 - 48, Client.collisionMaps);
                  }
               }

               for(var49 = 0; var49 < var1; ++var49) {
                  var3 = (class214.mapRegions[var49] >> 8) * 64 - class175.baseX;
                  var4 = (class214.mapRegions[var49] & 255) * 64 - GraphicsObject.baseY;
                  var50 = UnitPriceComparator.field301[var49];
                  if(var50 == null && GrandExchangeEvents.field263 < 800) {
                     FontName.method4928();
                     class115.method2169(var3, var4, 64, 64);
                  }
               }

               Actor.flush(true);

               for(var49 = 0; var49 < var1; ++var49) {
                  byte[] var51 = Client.field926[var49];
                  if(var51 != null) {
                     var4 = (class214.mapRegions[var49] >> 8) * 64 - class175.baseX;
                     var5 = (class214.mapRegions[var49] & 255) * 64 - GraphicsObject.baseY;
                     FontName.method4928();
                     PendingSpawn.method1552(var51, var4, var5, class45.region, Client.collisionMaps);
                  }
               }
            }

            int var6;
            int var52;
            int var61;
            if(Client.isDynamicRegion) {
               int var20;
               int var21;
               int var22;
               int var26;
               int var27;
               int var28;
               int var29;
               CollisionData[] var54;
               Buffer var63;
               for(var49 = 0; var49 < 4; ++var49) {
                  FontName.method4928();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var60 = false;
                        var6 = Client.field1118[var49][var3][var4];
                        if(var6 != -1) {
                           var61 = var6 >> 24 & 3;
                           var52 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = (var9 / 8 << 8) + var10 / 8;

                           for(int var62 = 0; var62 < class214.mapRegions.length; ++var62) {
                              if(class214.mapRegions[var62] == var11 && UnitPriceComparator.field301[var62] != null) {
                                 byte[] var53 = UnitPriceComparator.field301[var62];
                                 var14 = var3 * 8;
                                 var15 = var4 * 8;
                                 var16 = (var9 & 7) * 8;
                                 var17 = (var10 & 7) * 8;
                                 var54 = Client.collisionMaps;

                                 for(int var55 = 0; var55 < 8; ++var55) {
                                    for(var20 = 0; var20 < 8; ++var20) {
                                       if(var14 + var55 > 0 && var55 + var14 < 103 && var20 + var15 > 0 && var20 + var15 < 103) {
                                          var54[var49].flags[var14 + var55][var20 + var15] &= -16777217;
                                       }
                                    }
                                 }

                                 var63 = new Buffer(var53);

                                 for(var20 = 0; var20 < 4; ++var20) {
                                    for(var21 = 0; var21 < 64; ++var21) {
                                       for(var22 = 0; var22 < 64; ++var22) {
                                          if(var61 == var20 && var21 >= var16 && var21 < var16 + 8 && var22 >= var17 && var22 < var17 + 8) {
                                             var27 = var21 & 7;
                                             var28 = var22 & 7;
                                             var29 = var52 & 3;
                                             if(var29 == 0) {
                                                var26 = var27;
                                             } else if(var29 == 1) {
                                                var26 = var28;
                                             } else if(var29 == 2) {
                                                var26 = 7 - var27;
                                             } else {
                                                var26 = 7 - var28;
                                             }

                                             PacketBuffer.loadTerrain(var63, var49, var26 + var14, var15 + class188.method3599(var21 & 7, var22 & 7, var52), 0, 0, var52);
                                          } else {
                                             PacketBuffer.loadTerrain(var63, 0, -1, -1, 0, 0, 0);
                                          }
                                       }
                                    }
                                 }

                                 var60 = true;
                                 break;
                              }
                           }
                        }

                        if(!var60) {
                           KeyFocusListener.method753(var49, var3 * 8, var4 * 8);
                        }
                     }
                  }
               }

               for(var49 = 0; var49 < 13; ++var49) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.field1118[0][var49][var3];
                     if(var4 == -1) {
                        class115.method2169(var49 * 8, var3 * 8, 8, 8);
                     }
                  }
               }

               Actor.flush(true);

               for(var49 = 0; var49 < 4; ++var49) {
                  FontName.method4928();

                  for(var3 = 0; var3 < 13; ++var3) {
                     label473:
                     for(var4 = 0; var4 < 13; ++var4) {
                        var5 = Client.field1118[var49][var3][var4];
                        if(var5 != -1) {
                           var6 = var5 >> 24 & 3;
                           var61 = var5 >> 1 & 3;
                           var52 = var5 >> 14 & 1023;
                           var9 = var5 >> 3 & 2047;
                           var10 = (var52 / 8 << 8) + var9 / 8;

                           for(var11 = 0; var11 < class214.mapRegions.length; ++var11) {
                              if(class214.mapRegions[var11] == var10 && Client.field926[var11] != null) {
                                 byte[] var56 = Client.field926[var11];
                                 var13 = var3 * 8;
                                 var14 = var4 * 8;
                                 var15 = (var52 & 7) * 8;
                                 var16 = (var9 & 7) * 8;
                                 Region var57 = class45.region;
                                 var54 = Client.collisionMaps;
                                 var63 = new Buffer(var56);
                                 var20 = -1;

                                 while(true) {
                                    var21 = var63.getUSmart();
                                    if(var21 == 0) {
                                       continue label473;
                                    }

                                    var20 += var21;
                                    var22 = 0;

                                    while(true) {
                                       int var58 = var63.getUSmart();
                                       if(var58 == 0) {
                                          break;
                                       }

                                       var22 += var58 - 1;
                                       int var24 = var22 & 63;
                                       int var25 = var22 >> 6 & 63;
                                       var26 = var22 >> 12;
                                       var27 = var63.readUnsignedByte();
                                       var28 = var27 >> 2;
                                       var29 = var27 & 3;
                                       if(var6 == var26 && var25 >= var15 && var25 < var15 + 8 && var24 >= var16 && var24 < var16 + 8) {
                                          ObjectComposition var30 = NPC.getObjectDefinition(var20);
                                          int var33 = var25 & 7;
                                          int var34 = var24 & 7;
                                          int var36 = var30.width;
                                          int var37 = var30.length;
                                          int var38;
                                          if((var29 & 1) == 1) {
                                             var38 = var36;
                                             var36 = var37;
                                             var37 = var38;
                                          }

                                          int var35 = var61 & 3;
                                          int var32;
                                          if(var35 == 0) {
                                             var32 = var33;
                                          } else if(var35 == 1) {
                                             var32 = var34;
                                          } else if(var35 == 2) {
                                             var32 = 7 - var33 - (var36 - 1);
                                          } else {
                                             var32 = 7 - var34 - (var37 - 1);
                                          }

                                          var38 = var32 + var13;
                                          int var41 = var25 & 7;
                                          int var42 = var24 & 7;
                                          int var44 = var30.width;
                                          int var45 = var30.length;
                                          int var46;
                                          if((var29 & 1) == 1) {
                                             var46 = var44;
                                             var44 = var45;
                                             var45 = var46;
                                          }

                                          int var43 = var61 & 3;
                                          int var40;
                                          if(var43 == 0) {
                                             var40 = var42;
                                          } else if(var43 == 1) {
                                             var40 = 7 - var41 - (var44 - 1);
                                          } else if(var43 == 2) {
                                             var40 = 7 - var42 - (var45 - 1);
                                          } else {
                                             var40 = var41;
                                          }

                                          var46 = var14 + var40;
                                          if(var38 > 0 && var46 > 0 && var38 < 103 && var46 < 103) {
                                             int var47 = var49;
                                             if((class61.tileSettings[1][var38][var46] & 2) == 2) {
                                                var47 = var49 - 1;
                                             }

                                             CollisionData var48 = null;
                                             if(var47 >= 0) {
                                                var48 = var54[var47];
                                             }

                                             Ignore.addObject(var49, var38, var46, var20, var29 + var61 & 3, var28, var57, var48);
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            Actor.flush(true);
            class175.method3264();
            FontName.method4928();
            class168.method3242(class45.region, Client.collisionMaps);
            Actor.flush(true);
            var49 = class61.field729;
            if(var49 > class7.plane) {
               var49 = class7.plane;
            }

            if(var49 < class7.plane - 1) {
               var49 = class7.plane - 1;
            }

            if(Client.lowMemory) {
               class45.region.setup(class61.field729);
            } else {
               class45.region.setup(0);
            }

            for(var3 = 0; var3 < 104; ++var3) {
               for(var4 = 0; var4 < 104; ++var4) {
                  MessageNode.groundItemSpawned(var3, var4);
               }
            }

            FontName.method4928();

            for(PendingSpawn var64 = (PendingSpawn)Client.pendingSpawns.getFront(); var64 != null; var64 = (PendingSpawn)Client.pendingSpawns.getNext()) {
               if(var64.hitpoints == -1) {
                  var64.delay = 0;
                  WorldMapData.method338(var64);
               } else {
                  var64.unlink();
               }
            }

            ObjectComposition.field3524.reset();
            PacketNode var65;
            if(class160.clientInstance.method864()) {
               var65 = class235.method4272(ClientPacket.field2374, Client.field915.field1462);
               var65.packetBuffer.putInt(1057001181);
               Client.field915.method1898(var65);
            }

            if(!Client.isDynamicRegion) {
               var3 = (class60.field724 - 6) / 8;
               var4 = (class60.field724 + 6) / 8;
               var5 = (GrandExchangeEvents.field263 - 6) / 8;
               var6 = (GrandExchangeEvents.field263 + 6) / 8;

               for(var61 = var3 - 1; var61 <= var4 + 1; ++var61) {
                  for(var52 = var5 - 1; var52 <= var6 + 1; ++var52) {
                     if(var61 < var3 || var61 > var4 || var52 < var5 || var52 > var6) {
                        ScriptState.indexMaps.method4328("m" + var61 + "_" + var52);
                        ScriptState.indexMaps.method4328("l" + var61 + "_" + var52);
                     }
                  }
               }
            }

            ClanMember.setGameState(30);
            FontName.method4928();
            FileRequest.method4300();
            var65 = class235.method4272(ClientPacket.field2412, Client.field915.field1462);
            Client.field915.method1898(var65);
            IndexDataBase.method4323();
         }
      }
   }
}
