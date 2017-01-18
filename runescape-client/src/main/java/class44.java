import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
final class class44 implements Comparator {
   final boolean val$preferOwnWorld;
   @ObfuscatedName("pd")
   public static class103 field881;

   public int compare(Object var1, Object var2) {
      return this.method788((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "1124616710"
   )
   int method788(class2 var1, class2 var2) {
      if(var2.field22 == var1.field22) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(Client.world == var1.field22) {
               return -1;
            }

            if(Client.world == var2.field22) {
               return 1;
            }
         }

         return var1.field22 < var2.field22?-1:1;
      }
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "45"
   )
   static final void method792(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.field286 && class60.plane != var0) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class6.region.method1696(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class6.region.method1697(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class6.region.method1698(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class6.region.method1699(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class6.region.method1714(var0, var2, var3, var7);
            int var12 = var7 >> 14 & 32767;
            int var13 = var11 & 31;
            int var14 = var11 >> 6 & 3;
            ObjectComposition var15;
            if(var1 == 0) {
               class6.region.method1829(var0, var2, var3);
               var15 = Tile.getObjectDefinition(var12);
               if(var15.field2923 != 0) {
                  Client.collisionMaps[var0].method2235(var2, var3, var13, var14, var15.field2898);
               }
            }

            if(var1 == 1) {
               class6.region.method1688(var0, var2, var3);
            }

            if(var1 == 2) {
               class6.region.method1672(var0, var2, var3);
               var15 = Tile.getObjectDefinition(var12);
               if(var2 + var15.sizeX > 103 || var3 + var15.sizeX > 103 || var2 + var15.sizeY > 103 || var3 + var15.sizeY > 103) {
                  return;
               }

               if(var15.field2923 != 0) {
                  Client.collisionMaps[var0].method2236(var2, var3, var15.sizeX, var15.sizeY, var14, var15.field2898);
               }
            }

            if(var1 == 3) {
               class6.region.method1692(var0, var2, var3);
               var15 = Tile.getObjectDefinition(var12);
               if(var15.field2923 == 1) {
                  Client.collisionMaps[var0].method2238(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class10.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            class164.method3112(var0, var11, var2, var3, var4, var5, var6, class6.region, Client.collisionMaps[var0]);
         }
      }

   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "-35"
   )
   static void method794(int var0, String var1) {
      int var2 = class45.field888;
      int[] var3 = class45.field892;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         Player var6 = Client.cachedPlayers[var3[var5]];
         if(var6 != null && var6 != class148.localPlayer && null != var6.name && var6.name.equalsIgnoreCase(var1)) {
            if(var0 == 1) {
               Client.field326.method3029(240);
               Client.field326.method2807(var3[var5]);
               Client.field326.method2801(0);
            } else if(var0 == 4) {
               Client.field326.method3029(175);
               Client.field326.method2801(0);
               Client.field326.method2942(var3[var5]);
            } else if(var0 == 6) {
               Client.field326.method3029(245);
               Client.field326.method2807(var3[var5]);
               Client.field326.method2799(0);
            } else if(var0 == 7) {
               Client.field326.method3029(103);
               Client.field326.method2801(0);
               Client.field326.method2807(var3[var5]);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         class7.method99(4, "", "Unable to find " + var1);
      }

   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "1"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class60.plane][var0][var1];
      if(var2 == null) {
         class6.region.method1718(class60.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.method2391(); null != var6; var6 = (Item)var2.method2393()) {
            ItemComposition var7 = class88.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(1 + var6.quantity);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(null == var5) {
            class6.region.method1718(class60.plane, var0, var1);
         } else {
            var2.method2387(var5);
            Item var10 = null;
            Item var11 = null;

            for(var6 = (Item)var2.method2391(); var6 != null; var6 = (Item)var2.method2393()) {
               if(var5.id != var6.id) {
                  if(var10 == null) {
                     var10 = var6;
                  }

                  if(var10.id != var6.id && null == var11) {
                     var11 = var6;
                  }
               }
            }

            int var9 = 1610612736 + var0 + (var1 << 7);
            class6.region.method1677(class60.plane, var0, var1, class176.method3243(128 * var0 + 64, 64 + var1 * 128, class60.plane), var5, var9, var10, var11);
         }
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(LActor;IIIIII)V",
      garbageValue = "1182892823"
   )
   static final void method796(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(null != var0 && var0.vmethod718()) {
         if(var0 instanceof NPC) {
            NPCComposition var6 = ((NPC)var0).composition;
            if(null != var6.field3016) {
               var6 = var6.method3705();
            }

            if(null == var6) {
               return;
            }
         }

         int var75 = class45.field888;
         int[] var7 = class45.field892;
         int var8 = 3;
         int var9;
         int var10;
         int var11;
         int var22;
         int var23;
         if(!var0.combatInfoList.method2362()) {
            CombatInfo1.method622(var0, 15 + var0.field649);

            for(CombatInfoListHolder var12 = (CombatInfoListHolder)var0.combatInfoList.method2358(); null != var12; var12 = (CombatInfoListHolder)var0.combatInfoList.method2360()) {
               CombatInfo1 var13 = var12.method707(Client.gameCycle);
               if(var13 == null) {
                  if(var12.method703()) {
                     var12.unlink();
                  }
               } else {
                  CombatInfo2 var14 = var12.combatInfo2;
                  SpritePixels var15 = var14.method3517();
                  SpritePixels var16 = var14.method3519();
                  int var17 = 0;
                  if(var15 != null && null != var16) {
                     if(var14.field2820 * 2 < var16.width) {
                        var17 = var14.field2820;
                     }

                     var9 = var16.width - 2 * var17;
                  } else {
                     var9 = var14.healthScale;
                  }

                  int var18 = 255;
                  boolean var19 = true;
                  int var20 = Client.gameCycle - var13.field662;
                  int var21 = var13.field660 * var9 / var14.healthScale;
                  if(var13.field663 > var20) {
                     var22 = var14.field2823 == 0?0:var14.field2823 * (var20 / var14.field2823);
                     var10 = var9 * var13.healthRatio / var14.healthScale;
                     var23 = var10 + (var21 - var10) * var22 / var13.field663;
                  } else {
                     var23 = var21;
                     var22 = var13.field663 + var14.field2814 - var20;
                     if(var14.field2822 >= 0) {
                        var18 = (var22 << 8) / (var14.field2814 - var14.field2822);
                     }
                  }

                  if(var13.field660 > 0 && var23 < 1) {
                     var23 = 1;
                  }

                  var22 = var2 + Client.field388 - (var9 >> 1);
                  var10 = Client.field491 + var3 - var8;
                  if(var15 != null && null != var16) {
                     var22 -= var17;
                     if(var9 == var23) {
                        var23 += var17 * 2;
                     } else {
                        var23 += var17;
                     }

                     var11 = var15.height;
                     var8 += var11;
                     if(var18 >= 0 && var18 < 255) {
                        var15.method4148(var22, var10, var18);
                        class219.method4000(var22, var10, var23 + var22, var10 + var11);
                        var16.method4148(var22, var10, var18);
                     } else {
                        var15.method4122(var22, var10);
                        class219.method4000(var22, var10, var23 + var22, var10 + var11);
                        var16.method4122(var22, var10);
                     }

                     class219.method3965(var2, var3, var2 + var4, var5 + var3);
                     var8 += 2;
                  } else {
                     if(Client.field388 > -1) {
                        class219.method3993(var22, var10, var23, 5, '\uff00');
                        class219.method3993(var23 + var22, var10, var9 - var23, 5, 16711680);
                     }

                     var8 += 7;
                  }
               }
            }
         }

         if(var8 < 30) {
            var8 = 30;
         }

         if(var1 < var75) {
            Player var78 = (Player)var0;
            if(var78.field260) {
               return;
            }

            if(var78.skullIcon != -1 || var78.overheadIcon != -1) {
               CombatInfo1.method622(var0, 15 + var0.field649);
               if(Client.field388 > -1) {
                  if(var78.skullIcon != -1) {
                     class140.field1936[var78.skullIcon].method4122(var2 + Client.field388 - 12, var3 + Client.field491 - var8);
                     var8 += 25;
                  }

                  if(var78.overheadIcon != -1) {
                     class7.field66[var78.overheadIcon].method4122(Client.field388 + var2 - 12, Client.field491 + var3 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.field298 == 10 && var7[var1] == Client.field544) {
               CombatInfo1.method622(var0, var0.field649 + 15);
               if(Client.field388 > -1) {
                  Player.field253[1].method4122(var2 + Client.field388 - 12, Client.field491 + var3 - var8);
               }
            }
         } else {
            NPCComposition var76 = ((NPC)var0).composition;
            if(var76.field3016 != null) {
               var76 = var76.method3705();
            }

            if(var76.field3014 >= 0 && var76.field3014 < class7.field66.length) {
               CombatInfo1.method622(var0, 15 + var0.field649);
               if(Client.field388 > -1) {
                  class7.field66[var76.field3014].method4122(var2 + Client.field388 - 12, var3 + Client.field491 - 30);
               }
            }

            if(Client.field298 == 1 && Client.field299 == Client.field483[var1 - var75] && Client.gameCycle % 20 < 10) {
               CombatInfo1.method622(var0, var0.field649 + 15);
               if(Client.field388 > -1) {
                  Player.field253[0].method4122(Client.field388 + var2 - 12, Client.field491 + var3 - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var75 || !var0.inSequence && (Client.field498 == 4 || !var0.field645 && (Client.field498 == 0 || Client.field498 == 3 || Client.field498 == 1 && class60.method1098(((Player)var0).name, false))))) {
            CombatInfo1.method622(var0, var0.field649);
            if(Client.field388 > -1 && Client.field376 < Client.field377) {
               Client.field381[Client.field376] = class97.field1621.method3874(var0.overhead) / 2;
               Client.field380[Client.field376] = class97.field1621.field3087;
               Client.field378[Client.field376] = Client.field388;
               Client.field439[Client.field376] = Client.field491;
               Client.field443[Client.field376] = var0.field599;
               Client.field407[Client.field376] = var0.field617;
               Client.field384[Client.field376] = var0.field615;
               Client.field423[Client.field376] = var0.overhead;
               ++Client.field376;
            }
         }

         for(int var79 = 0; var79 < 4; ++var79) {
            int var77 = var0.field601[var79];
            int var80 = var0.field619[var79];
            class196 var81 = null;
            int var82 = 0;
            if(var80 >= 0) {
               if(var77 <= Client.gameCycle) {
                  continue;
               }

               var81 = class65.method1118(var0.field619[var79]);
               var82 = var81.field2873;
               if(null != var81 && var81.field2874 != null) {
                  var81 = var81.method3556();
                  if(var81 == null) {
                     var0.field601[var79] = -1;
                     continue;
                  }
               }
            } else if(var77 < 0) {
               continue;
            }

            var9 = var0.field644[var79];
            class196 var83 = null;
            if(var9 >= 0) {
               var83 = class65.method1118(var9);
               if(var83 != null && var83.field2874 != null) {
                  var83 = var83.method3556();
               }
            }

            if(var77 - var82 <= Client.gameCycle) {
               if(null == var81) {
                  var0.field601[var79] = -1;
               } else {
                  CombatInfo1.method622(var0, var0.field649 / 2);
                  if(Client.field388 > -1) {
                     if(var79 == 1) {
                        Client.field491 -= 20;
                     }

                     if(var79 == 2) {
                        Client.field388 -= 15;
                        Client.field491 -= 10;
                     }

                     if(var79 == 3) {
                        Client.field388 += 15;
                        Client.field491 -= 10;
                     }

                     SpritePixels var84 = null;
                     SpritePixels var85 = null;
                     SpritePixels var86 = null;
                     SpritePixels var87 = null;
                     var10 = 0;
                     var11 = 0;
                     var22 = 0;
                     var23 = 0;
                     int var24 = 0;
                     int var25 = 0;
                     int var26 = 0;
                     int var27 = 0;
                     SpritePixels var28 = null;
                     SpritePixels var29 = null;
                     SpritePixels var30 = null;
                     SpritePixels var31 = null;
                     int var32 = 0;
                     int var33 = 0;
                     int var34 = 0;
                     int var35 = 0;
                     int var36 = 0;
                     int var37 = 0;
                     int var38 = 0;
                     int var39 = 0;
                     int var40 = 0;
                     var84 = var81.method3558();
                     int var41;
                     if(var84 != null) {
                        var10 = var84.width;
                        var41 = var84.height;
                        if(var41 > var40) {
                           var40 = var41;
                        }

                        var24 = var84.field3209;
                     }

                     var85 = var81.method3559();
                     if(null != var85) {
                        var11 = var85.width;
                        var41 = var85.height;
                        if(var41 > var40) {
                           var40 = var41;
                        }

                        var25 = var85.field3209;
                     }

                     var86 = var81.method3560();
                     if(var86 != null) {
                        var22 = var86.width;
                        var41 = var86.height;
                        if(var41 > var40) {
                           var40 = var41;
                        }

                        var26 = var86.field3209;
                     }

                     var87 = var81.method3561();
                     if(null != var87) {
                        var23 = var87.width;
                        var41 = var87.height;
                        if(var41 > var40) {
                           var40 = var41;
                        }

                        var27 = var87.field3209;
                     }

                     if(null != var83) {
                        var28 = var83.method3558();
                        if(var28 != null) {
                           var32 = var28.width;
                           var41 = var28.height;
                           if(var41 > var40) {
                              var40 = var41;
                           }

                           var36 = var28.field3209;
                        }

                        var29 = var83.method3559();
                        if(var29 != null) {
                           var33 = var29.width;
                           var41 = var29.height;
                           if(var41 > var40) {
                              var40 = var41;
                           }

                           var37 = var29.field3209;
                        }

                        var30 = var83.method3560();
                        if(var30 != null) {
                           var34 = var30.width;
                           var41 = var30.height;
                           if(var41 > var40) {
                              var40 = var41;
                           }

                           var38 = var30.field3209;
                        }

                        var31 = var83.method3561();
                        if(var31 != null) {
                           var35 = var31.width;
                           var41 = var31.height;
                           if(var41 > var40) {
                              var40 = var41;
                           }

                           var39 = var31.field3209;
                        }
                     }

                     class208 var42 = var81.method3590();
                     if(null == var42) {
                        var42 = FileOnDisk.field1186;
                     }

                     class208 var43;
                     if(var83 != null) {
                        var43 = var83.method3590();
                        if(null == var43) {
                           var43 = FileOnDisk.field1186;
                        }
                     } else {
                        var43 = FileOnDisk.field1186;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var81.method3555(var0.field651[var79]);
                     int var48 = var42.method3874(var44);
                     if(var83 != null) {
                        var45 = var83.method3555(var0.field623[var79]);
                        var47 = var43.method3874(var45);
                     }

                     int var49 = 0;
                     int var50 = 0;
                     if(var11 > 0) {
                        if(null == var86 && null == var87) {
                           var49 = 1;
                        } else {
                           var49 = 1 + var48 / var11;
                        }
                     }

                     if(var83 != null && var33 > 0) {
                        if(null == var30 && null == var31) {
                           var50 = 1;
                        } else {
                           var50 = 1 + var47 / var33;
                        }
                     }

                     int var51 = 0;
                     int var52 = var51;
                     if(var10 > 0) {
                        var51 += var10;
                     }

                     var51 += 2;
                     int var53 = var51;
                     if(var22 > 0) {
                        var51 += var22;
                     }

                     int var54 = var51;
                     int var55 = var51;
                     int var56;
                     if(var11 > 0) {
                        var56 = var11 * var49;
                        var51 += var56;
                        var55 += (var56 - var48) / 2;
                     } else {
                        var51 += var48;
                     }

                     var56 = var51;
                     if(var23 > 0) {
                        var51 += var23;
                     }

                     int var57 = 0;
                     int var58 = 0;
                     int var59 = 0;
                     int var60 = 0;
                     int var61 = 0;
                     int var62;
                     if(null != var83) {
                        var51 += 2;
                        var57 = var51;
                        if(var32 > 0) {
                           var51 += var32;
                        }

                        var51 += 2;
                        var58 = var51;
                        if(var34 > 0) {
                           var51 += var34;
                        }

                        var59 = var51;
                        var61 = var51;
                        if(var33 > 0) {
                           var62 = var33 * var50;
                           var51 += var62;
                           var61 += (var62 - var47) / 2;
                        } else {
                           var51 += var47;
                        }

                        var60 = var51;
                        if(var35 > 0) {
                           var51 += var35;
                        }
                     }

                     var62 = var0.field601[var79] - Client.gameCycle;
                     int var63 = var81.field2868 - var62 * var81.field2868 / var81.field2873;
                     int var64 = -var81.field2869 + var62 * var81.field2869 / var81.field2873;
                     int var65 = var2 + Client.field388 - (var51 >> 1) + var63;
                     int var66 = var3 + Client.field491 - 12 + var64;
                     int var67 = var66;
                     int var68 = var66 + var40;
                     int var69 = 15 + var66 + var81.field2857;
                     int var70 = var69 - var42.field3088;
                     int var71 = var42.field3094 + var69;
                     if(var70 < var66) {
                        var67 = var70;
                     }

                     if(var71 > var68) {
                        var68 = var71;
                     }

                     int var72 = 0;
                     int var73;
                     int var74;
                     if(null != var83) {
                        var72 = var83.field2857 + var66 + 15;
                        var73 = var72 - var43.field3088;
                        var74 = var43.field3094 + var72;
                        if(var73 < var67) {
                           ;
                        }

                        if(var74 > var68) {
                           ;
                        }
                     }

                     var73 = 255;
                     if(var81.field2870 >= 0) {
                        var73 = (var62 << 8) / (var81.field2873 - var81.field2870);
                     }

                     if(var73 >= 0 && var73 < 255) {
                        if(null != var84) {
                           var84.method4148(var65 + var52 - var24, var66, var73);
                        }

                        if(null != var86) {
                           var86.method4148(var53 + var65 - var26, var66, var73);
                        }

                        if(var85 != null) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var85.method4148(var65 + var54 - var25 + var11 * var74, var66, var73);
                           }
                        }

                        if(var87 != null) {
                           var87.method4148(var65 + var56 - var27, var66, var73);
                        }

                        var42.method3868(var44, var55 + var65, var69, var81.field2862, 0, var73);
                        if(null != var83) {
                           if(var28 != null) {
                              var28.method4148(var65 + var57 - var36, var66, var73);
                           }

                           if(var30 != null) {
                              var30.method4148(var58 + var65 - var38, var66, var73);
                           }

                           if(null != var29) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var29.method4148(var59 + var65 - var37 + var74 * var33, var66, var73);
                              }
                           }

                           if(null != var31) {
                              var31.method4148(var65 + var60 - var39, var66, var73);
                           }

                           var43.method3868(var45, var65 + var61, var72, var83.field2862, 0, var73);
                        }
                     } else {
                        if(var84 != null) {
                           var84.method4122(var65 + var52 - var24, var66);
                        }

                        if(null != var86) {
                           var86.method4122(var65 + var53 - var26, var66);
                        }

                        if(var85 != null) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var85.method4122(var74 * var11 + (var65 + var54 - var25), var66);
                           }
                        }

                        if(null != var87) {
                           var87.method4122(var65 + var56 - var27, var66);
                        }

                        var42.method3867(var44, var55 + var65, var69, var81.field2862 | -16777216, 0);
                        if(null != var83) {
                           if(null != var28) {
                              var28.method4122(var65 + var57 - var36, var66);
                           }

                           if(null != var30) {
                              var30.method4122(var65 + var58 - var38, var66);
                           }

                           if(null != var29) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var29.method4122(var33 * var74 + (var59 + var65 - var37), var66);
                              }
                           }

                           if(null != var31) {
                              var31.method4122(var65 + var60 - var39, var66);
                           }

                           var43.method3867(var45, var61 + var65, var72, var83.field2862 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "-785664253"
   )
   static char method797(char var0) {
      return (char)(var0 == 198?'E':(var0 == 230?'e':(var0 == 223?'s':(var0 == 338?'E':(var0 == 339?'e':'\u0000')))));
   }

   class44(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)LWidget;",
      garbageValue = "2111471958"
   )
   public static Widget method799(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(Widget.widgets[var1] == null || null == Widget.widgets[var1][var2]) {
         boolean var3 = class94.method1870(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }
}
