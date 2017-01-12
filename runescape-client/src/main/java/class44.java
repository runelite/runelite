import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
final class class44 implements Comparator {
   // $FF: synthetic field
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
            int var13 = var7 >> 14 & 32767;
            int var14 = var11 & 31;
            int var15 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               class6.region.method1829(var0, var2, var3);
               var12 = Tile.getObjectDefinition(var13);
               if(var12.field2923 != 0) {
                  Client.collisionMaps[var0].method2235(var2, var3, var14, var15, var12.field2898);
               }
            }

            if(var1 == 1) {
               class6.region.method1688(var0, var2, var3);
            }

            if(var1 == 2) {
               class6.region.method1672(var0, var2, var3);
               var12 = Tile.getObjectDefinition(var13);
               if(var2 + var12.field2895 > 103 || var3 + var12.field2895 > 103 || var2 + var12.field2931 > 103 || var3 + var12.field2931 > 103) {
                  return;
               }

               if(var12.field2923 != 0) {
                  Client.collisionMaps[var0].method2236(var2, var3, var12.field2895, var12.field2931, var15, var12.field2898);
               }
            }

            if(var1 == 3) {
               class6.region.method1692(var0, var2, var3);
               var12 = Tile.getObjectDefinition(var13);
               if(var12.field2923 == 1) {
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
            long var10 = (long)var7.price;
            if(var7.isStackable == 1) {
               var10 *= (long)(1 + var6.quantity);
            }

            if(var10 > var3) {
               var3 = var10;
               var5 = var6;
            }
         }

         if(null == var5) {
            class6.region.method1718(class60.plane, var0, var1);
         } else {
            var2.method2387(var5);
            Item var12 = null;
            Item var8 = null;

            for(var6 = (Item)var2.method2391(); var6 != null; var6 = (Item)var2.method2393()) {
               if(var5.id != var6.id) {
                  if(var12 == null) {
                     var12 = var6;
                  }

                  if(var12.id != var6.id && null == var8) {
                     var8 = var6;
                  }
               }
            }

            int var9 = 1610612736 + var0 + (var1 << 7);
            class6.region.method1677(class60.plane, var0, var1, class176.method3243(128 * var0 + 64, 64 + var1 * 128, class60.plane), var5, var9, var12, var8);
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

         int var77 = class45.field888;
         int[] var7 = class45.field892;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.combatInfoList.method2362()) {
            CombatInfo1.method622(var0, 15 + var0.field649);

            for(CombatInfoListHolder var9 = (CombatInfoListHolder)var0.combatInfoList.method2358(); null != var9; var9 = (CombatInfoListHolder)var0.combatInfoList.method2360()) {
               CombatInfo1 var10 = var9.method707(Client.gameCycle);
               if(var10 == null) {
                  if(var9.method703()) {
                     var9.unlink();
                  }
               } else {
                  CombatInfo2 var11 = var9.combatInfo2;
                  SpritePixels var12 = var11.method3517();
                  SpritePixels var13 = var11.method3519();
                  int var15 = 0;
                  if(var12 != null && null != var13) {
                     if(var11.field2820 * 2 < var13.width) {
                        var15 = var11.field2820;
                     }

                     var14 = var13.width - 2 * var15;
                  } else {
                     var14 = var11.healthScale;
                  }

                  int var16 = 255;
                  boolean var17 = true;
                  int var18 = Client.gameCycle - var10.field662;
                  int var19 = var10.field660 * var14 / var11.healthScale;
                  int var20;
                  int var88;
                  if(var10.field663 > var18) {
                     var20 = var11.field2823 == 0?0:var11.field2823 * (var18 / var11.field2823);
                     var21 = var14 * var10.healthRatio / var11.healthScale;
                     var88 = var21 + (var19 - var21) * var20 / var10.field663;
                  } else {
                     var88 = var19;
                     var20 = var10.field663 + var11.field2814 - var18;
                     if(var11.field2822 >= 0) {
                        var16 = (var20 << 8) / (var11.field2814 - var11.field2822);
                     }
                  }

                  if(var10.field660 > 0 && var88 < 1) {
                     var88 = 1;
                  }

                  var20 = var2 + Client.field388 - (var14 >> 1);
                  var21 = Client.field491 + var3 - var8;
                  if(var12 != null && null != var13) {
                     var20 -= var15;
                     if(var14 == var88) {
                        var88 += var15 * 2;
                     } else {
                        var88 += var15;
                     }

                     var22 = var12.height;
                     var8 += var22;
                     if(var16 >= 0 && var16 < 255) {
                        var12.method4148(var20, var21, var16);
                        class219.method4000(var20, var21, var88 + var20, var21 + var22);
                        var13.method4148(var20, var21, var16);
                     } else {
                        var12.method4122(var20, var21);
                        class219.method4000(var20, var21, var88 + var20, var21 + var22);
                        var13.method4122(var20, var21);
                     }

                     class219.method3965(var2, var3, var2 + var4, var5 + var3);
                     var8 += 2;
                  } else {
                     if(Client.field388 > -1) {
                        class219.method3993(var20, var21, var88, 5, '\uff00');
                        class219.method3993(var88 + var20, var21, var14 - var88, 5, 16711680);
                     }

                     var8 += 7;
                  }
               }
            }
         }

         if(var8 < 30) {
            var8 = 30;
         }

         if(var1 < var77) {
            Player var85 = (Player)var0;
            if(var85.field260) {
               return;
            }

            if(var85.skullIcon != -1 || var85.overheadIcon != -1) {
               CombatInfo1.method622(var0, 15 + var0.field649);
               if(Client.field388 > -1) {
                  if(var85.skullIcon != -1) {
                     class140.field1936[var85.skullIcon].method4122(var2 + Client.field388 - 12, var3 + Client.field491 - var8);
                     var8 += 25;
                  }

                  if(var85.overheadIcon != -1) {
                     class7.field66[var85.overheadIcon].method4122(Client.field388 + var2 - 12, Client.field491 + var3 - var8);
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
            NPCComposition var86 = ((NPC)var0).composition;
            if(var86.field3016 != null) {
               var86 = var86.method3705();
            }

            if(var86.field3014 >= 0 && var86.field3014 < class7.field66.length) {
               CombatInfo1.method622(var0, 15 + var0.field649);
               if(Client.field388 > -1) {
                  class7.field66[var86.field3014].method4122(var2 + Client.field388 - 12, var3 + Client.field491 - 30);
               }
            }

            if(Client.field298 == 1 && Client.field299 == Client.field483[var1 - var77] && Client.gameCycle % 20 < 10) {
               CombatInfo1.method622(var0, var0.field649 + 15);
               if(Client.field388 > -1) {
                  Player.field253[0].method4122(Client.field388 + var2 - 12, Client.field491 + var3 - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var77 || !var0.inSequence && (Client.field498 == 4 || !var0.field645 && (Client.field498 == 0 || Client.field498 == 3 || Client.field498 == 1 && class60.method1098(((Player)var0).name, false))))) {
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

         for(int var75 = 0; var75 < 4; ++var75) {
            int var78 = var0.field601[var75];
            int var82 = var0.field619[var75];
            class196 var87 = null;
            int var81 = 0;
            if(var82 >= 0) {
               if(var78 <= Client.gameCycle) {
                  continue;
               }

               var87 = class65.method1118(var0.field619[var75]);
               var81 = var87.field2873;
               if(null != var87 && var87.field2874 != null) {
                  var87 = var87.method3556();
                  if(var87 == null) {
                     var0.field601[var75] = -1;
                     continue;
                  }
               }
            } else if(var78 < 0) {
               continue;
            }

            var14 = var0.field644[var75];
            class196 var76 = null;
            if(var14 >= 0) {
               var76 = class65.method1118(var14);
               if(var76 != null && var76.field2874 != null) {
                  var76 = var76.method3556();
               }
            }

            if(var78 - var81 <= Client.gameCycle) {
               if(null == var87) {
                  var0.field601[var75] = -1;
               } else {
                  CombatInfo1.method622(var0, var0.field649 / 2);
                  if(Client.field388 > -1) {
                     if(var75 == 1) {
                        Client.field491 -= 20;
                     }

                     if(var75 == 2) {
                        Client.field388 -= 15;
                        Client.field491 -= 10;
                     }

                     if(var75 == 3) {
                        Client.field388 += 15;
                        Client.field491 -= 10;
                     }

                     SpritePixels var74 = null;
                     SpritePixels var83 = null;
                     SpritePixels var79 = null;
                     SpritePixels var80 = null;
                     var21 = 0;
                     var22 = 0;
                     int var23 = 0;
                     int var24 = 0;
                     int var25 = 0;
                     int var26 = 0;
                     int var27 = 0;
                     int var28 = 0;
                     SpritePixels var29 = null;
                     SpritePixels var30 = null;
                     SpritePixels var31 = null;
                     SpritePixels var32 = null;
                     int var33 = 0;
                     int var34 = 0;
                     int var35 = 0;
                     int var36 = 0;
                     int var37 = 0;
                     int var38 = 0;
                     int var39 = 0;
                     int var40 = 0;
                     int var41 = 0;
                     var74 = var87.method3558();
                     int var42;
                     if(var74 != null) {
                        var21 = var74.width;
                        var42 = var74.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var25 = var74.field3209;
                     }

                     var83 = var87.method3559();
                     if(null != var83) {
                        var22 = var83.width;
                        var42 = var83.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var26 = var83.field3209;
                     }

                     var79 = var87.method3560();
                     if(var79 != null) {
                        var23 = var79.width;
                        var42 = var79.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var27 = var79.field3209;
                     }

                     var80 = var87.method3561();
                     if(null != var80) {
                        var24 = var80.width;
                        var42 = var80.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var28 = var80.field3209;
                     }

                     if(null != var76) {
                        var29 = var76.method3558();
                        if(var29 != null) {
                           var33 = var29.width;
                           var42 = var29.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var37 = var29.field3209;
                        }

                        var30 = var76.method3559();
                        if(var30 != null) {
                           var34 = var30.width;
                           var42 = var30.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var38 = var30.field3209;
                        }

                        var31 = var76.method3560();
                        if(var31 != null) {
                           var35 = var31.width;
                           var42 = var31.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var39 = var31.field3209;
                        }

                        var32 = var76.method3561();
                        if(var32 != null) {
                           var36 = var32.width;
                           var42 = var32.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var40 = var32.field3209;
                        }
                     }

                     class208 var84 = var87.method3590();
                     if(null == var84) {
                        var84 = FileOnDisk.field1186;
                     }

                     class208 var43;
                     if(var76 != null) {
                        var43 = var76.method3590();
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
                     var44 = var87.method3555(var0.field651[var75]);
                     int var89 = var84.method3874(var44);
                     if(var76 != null) {
                        var45 = var76.method3555(var0.field623[var75]);
                        var47 = var43.method3874(var45);
                     }

                     int var48 = 0;
                     int var49 = 0;
                     if(var22 > 0) {
                        if(null == var79 && null == var80) {
                           var48 = 1;
                        } else {
                           var48 = 1 + var89 / var22;
                        }
                     }

                     if(var76 != null && var34 > 0) {
                        if(null == var31 && null == var32) {
                           var49 = 1;
                        } else {
                           var49 = 1 + var47 / var34;
                        }
                     }

                     int var50 = 0;
                     int var51 = var50;
                     if(var21 > 0) {
                        var50 += var21;
                     }

                     var50 += 2;
                     int var52 = var50;
                     if(var23 > 0) {
                        var50 += var23;
                     }

                     int var53 = var50;
                     int var54 = var50;
                     int var55;
                     if(var22 > 0) {
                        var55 = var22 * var48;
                        var50 += var55;
                        var54 += (var55 - var89) / 2;
                     } else {
                        var50 += var89;
                     }

                     var55 = var50;
                     if(var24 > 0) {
                        var50 += var24;
                     }

                     int var56 = 0;
                     int var57 = 0;
                     int var58 = 0;
                     int var59 = 0;
                     int var60 = 0;
                     int var61;
                     if(null != var76) {
                        var50 += 2;
                        var56 = var50;
                        if(var33 > 0) {
                           var50 += var33;
                        }

                        var50 += 2;
                        var57 = var50;
                        if(var35 > 0) {
                           var50 += var35;
                        }

                        var58 = var50;
                        var60 = var50;
                        if(var34 > 0) {
                           var61 = var34 * var49;
                           var50 += var61;
                           var60 += (var61 - var47) / 2;
                        } else {
                           var50 += var47;
                        }

                        var59 = var50;
                        if(var36 > 0) {
                           var50 += var36;
                        }
                     }

                     var61 = var0.field601[var75] - Client.gameCycle;
                     int var62 = var87.field2868 - var61 * var87.field2868 / var87.field2873;
                     int var63 = -var87.field2869 + var61 * var87.field2869 / var87.field2873;
                     int var64 = var2 + Client.field388 - (var50 >> 1) + var62;
                     int var65 = var3 + Client.field491 - 12 + var63;
                     int var66 = var65;
                     int var67 = var65 + var41;
                     int var68 = 15 + var65 + var87.field2857;
                     int var69 = var68 - var84.field3088;
                     int var70 = var84.field3094 + var68;
                     if(var69 < var65) {
                        var66 = var69;
                     }

                     if(var70 > var67) {
                        var67 = var70;
                     }

                     int var71 = 0;
                     int var72;
                     int var73;
                     if(null != var76) {
                        var71 = var76.field2857 + var65 + 15;
                        var72 = var71 - var43.field3088;
                        var73 = var43.field3094 + var71;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var87.field2870 >= 0) {
                        var72 = (var61 << 8) / (var87.field2873 - var87.field2870);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(null != var74) {
                           var74.method4148(var64 + var51 - var25, var65, var72);
                        }

                        if(null != var79) {
                           var79.method4148(var52 + var64 - var27, var65, var72);
                        }

                        if(var83 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var83.method4148(var64 + var53 - var26 + var22 * var73, var65, var72);
                           }
                        }

                        if(var80 != null) {
                           var80.method4148(var64 + var55 - var28, var65, var72);
                        }

                        var84.method3868(var44, var54 + var64, var68, var87.field2862, 0, var72);
                        if(null != var76) {
                           if(var29 != null) {
                              var29.method4148(var64 + var56 - var37, var65, var72);
                           }

                           if(var31 != null) {
                              var31.method4148(var57 + var64 - var39, var65, var72);
                           }

                           if(null != var30) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method4148(var58 + var64 - var38 + var73 * var34, var65, var72);
                              }
                           }

                           if(null != var32) {
                              var32.method4148(var64 + var59 - var40, var65, var72);
                           }

                           var43.method3868(var45, var64 + var60, var71, var76.field2862, 0, var72);
                        }
                     } else {
                        if(var74 != null) {
                           var74.method4122(var64 + var51 - var25, var65);
                        }

                        if(null != var79) {
                           var79.method4122(var64 + var52 - var27, var65);
                        }

                        if(var83 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var83.method4122(var73 * var22 + (var64 + var53 - var26), var65);
                           }
                        }

                        if(null != var80) {
                           var80.method4122(var64 + var55 - var28, var65);
                        }

                        var84.method3867(var44, var54 + var64, var68, var87.field2862 | -16777216, 0);
                        if(null != var76) {
                           if(null != var29) {
                              var29.method4122(var64 + var56 - var37, var65);
                           }

                           if(null != var31) {
                              var31.method4122(var64 + var57 - var39, var65);
                           }

                           if(null != var30) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method4122(var34 * var73 + (var58 + var64 - var38), var65);
                              }
                           }

                           if(null != var32) {
                              var32.method4122(var64 + var59 - var40, var65);
                           }

                           var43.method3867(var45, var60 + var64, var71, var76.field2862 | -16777216, 0);
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
