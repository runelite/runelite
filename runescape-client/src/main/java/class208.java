import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
public class class208 extends class119 {
   @ObfuscatedName("i")
   class204 field2581;
   @ObfuscatedName("h")
   Deque field2582;
   @ObfuscatedName("u")
   class102 field2583;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass205;IB)V",
      garbageValue = "-22"
   )
   void method3943(class205 var1, int var2) {
      if((this.field2581.field2518[var1.field2544] & 4) != 0 && var1.field2541 < 0) {
         int var3 = this.field2581.field2527[var1.field2544] / class109.field1628;
         int var4 = (var3 + 1048575 - var1.field2554) / var3;
         var1.field2554 = var2 * var3 + var1.field2554 & 1048575;
         if(var4 <= var2) {
            if(this.field2581.field2514[var1.field2544] == 0) {
               var1.field2552 = class117.method2271(var1.field2537, var1.field2552.method2172(), var1.field2552.method2211(), var1.field2552.method2164());
            } else {
               var1.field2552 = class117.method2271(var1.field2537, var1.field2552.method2172(), 0, var1.field2552.method2164());
               this.field2581.method3858(var1, var1.field2535.field2571[var1.field2534] < 0);
            }

            if(var1.field2535.field2571[var1.field2534] < 0) {
               var1.field2552.method2160(-1);
            }

            var2 = var1.field2554 / var3;
         }
      }

      var1.field2552.vmethod3969(var2);
   }

   @ObfuscatedName("v")
   protected class119 vmethod3944() {
      class205 var1 = (class205)this.field2582.method3660();
      return (class119)(var1 == null?null:(var1.field2552 != null?var1.field2552:this.vmethod3945()));
   }

   @ObfuscatedName("t")
   protected class119 vmethod3945() {
      class205 var1;
      do {
         var1 = (class205)this.field2582.method3661();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2552 == null);

      return var1.field2552;
   }

   @ObfuscatedName("p")
   protected int vmethod3946() {
      return 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1319531402"
   )
   static int method3947(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class98.chatLineMap.get(Integer.valueOf(var0));
      return var1 == null?0:var1.method1898();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass205;[IIIII)V",
      garbageValue = "576263774"
   )
   void method3948(class205 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2581.field2518[var1.field2544] & 4) != 0 && var1.field2541 < 0) {
         int var6 = this.field2581.field2527[var1.field2544] / class109.field1628;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2554) / var6;
            if(var7 > var4) {
               var1.field2554 += var4 * var6;
               break;
            }

            var1.field2552.vmethod3949(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2554 += var6 * var7 - 1048576;
            int var8 = class109.field1628 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class117 var10 = var1.field2552;
            if(this.field2581.field2514[var1.field2544] == 0) {
               var1.field2552 = class117.method2271(var1.field2537, var10.method2172(), var10.method2211(), var10.method2164());
            } else {
               var1.field2552 = class117.method2271(var1.field2537, var10.method2172(), 0, var10.method2164());
               this.field2581.method3858(var1, var1.field2535.field2571[var1.field2534] < 0);
               var1.field2552.method2168(var8, var10.method2211());
            }

            if(var1.field2535.field2571[var1.field2534] < 0) {
               var1.field2552.method2160(-1);
            }

            var10.method2170(var8);
            var10.vmethod3949(var2, var3, var5 - var3);
            if(var10.method2174()) {
               this.field2583.method1936(var10);
            }
         }
      }

      var1.field2552.vmethod3949(var2, var3, var4);
   }

   class208(class204 var1) {
      this.field2582 = new Deque();
      this.field2583 = new class102();
      this.field2581 = var1;
   }

   @ObfuscatedName("l")
   protected void vmethod3949(int[] var1, int var2, int var3) {
      this.field2583.vmethod3949(var1, var2, var3);

      for(class205 var6 = (class205)this.field2582.method3660(); var6 != null; var6 = (class205)this.field2582.method3661()) {
         if(!this.field2581.method3787(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2553) {
                  this.method3948(var6, var1, var4, var5, var4 + var5);
                  var6.field2553 -= var5;
                  break;
               }

               this.method3948(var6, var1, var4, var6.field2553, var4 + var5);
               var4 += var6.field2553;
               var5 -= var6.field2553;
            } while(!this.field2581.method3788(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "-74646214"
   )
   static void method3966(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var11 = World.worldList[var9];
            int var12 = WorldMapData.method348(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = WorldMapData.method348(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               World var14 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var14;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method3966(var0, var7 - 1, var2, var3, var4, var5);
         method3966(var7 + 1, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1660588075"
   )
   static void method3967() {
      XItemContainer.itemContainers = new XHashTable(32);
   }

   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "(LActor;IIIIII)V",
      garbageValue = "1752670731"
   )
   static final void method3968(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(var0 != null && var0.vmethod1721()) {
         if(var0 instanceof NPC) {
            NPCComposition var6 = ((NPC)var0).composition;
            if(var6.configs != null) {
               var6 = var6.method4705();
            }

            if(var6 == null) {
               return;
            }
         }

         int var74 = class96.field1489;
         int[] var7 = class96.field1496;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.combatInfoList.method3626()) {
            class214.method4043(var0, var0.field1248 + 15);

            for(CombatInfoListHolder var9 = (CombatInfoListHolder)var0.combatInfoList.method3620(); var9 != null; var9 = (CombatInfoListHolder)var0.combatInfoList.method3625()) {
               CombatInfo1 var10 = var9.method1699(Client.gameCycle);
               if(var10 == null) {
                  if(var9.method1703()) {
                     var9.unlink();
                  }
               } else {
                  CombatInfo2 var11 = var9.combatInfo2;
                  SpritePixels var12 = var11.method4468();
                  SpritePixels var13 = var11.method4467();
                  int var15 = 0;
                  if(var12 != null && var13 != null) {
                     if(var11.field3365 * 2 < var13.width) {
                        var15 = var11.field3365;
                     }

                     var14 = var13.width - var15 * 2;
                  } else {
                     var14 = var11.healthScale;
                  }

                  int var16 = 255;
                  boolean var17 = true;
                  int var75 = Client.gameCycle - var10.field1259;
                  int var19 = var10.health * var14 / var11.healthScale;
                  int var20;
                  int var88;
                  if(var10.field1261 > var75) {
                     var20 = var11.field3360 == 0?0:var11.field3360 * (var75 / var11.field3360);
                     var21 = var14 * var10.healthRatio / var11.healthScale;
                     var88 = var21 + (var19 - var21) * var20 / var10.field1261;
                  } else {
                     var88 = var19;
                     var20 = var11.field3359 + var10.field1261 - var75;
                     if(var11.field3363 >= 0) {
                        var16 = (var20 << 8) / (var11.field3359 - var11.field3363);
                     }
                  }

                  if(var10.health > 0 && var88 < 1) {
                     var88 = 1;
                  }

                  var20 = var2 + Client.field995 - (var14 >> 1);
                  var21 = Client.field996 + var3 - var8;
                  if(var12 != null && var13 != null) {
                     var20 -= var15;
                     if(var88 == var14) {
                        var88 += var15 * 2;
                     } else {
                        var88 += var15;
                     }

                     var22 = var12.height;
                     var8 += var22;
                     if(var16 >= 0 && var16 < 255) {
                        var12.method5138(var20, var21, var16);
                        Rasterizer2D.method4999(var20, var21, var88 + var20, var22 + var21);
                        var13.method5138(var20, var21, var16);
                     } else {
                        var12.method5207(var20, var21);
                        Rasterizer2D.method4999(var20, var21, var20 + var88, var21 + var22);
                        var13.method5207(var20, var21);
                     }

                     Rasterizer2D.method4998(var2, var3, var2 + var4, var3 + var5);
                     var8 += 2;
                  } else {
                     if(Client.field995 > -1) {
                        Rasterizer2D.method5042(var20, var21, var88, 5, '\uff00');
                        Rasterizer2D.method5042(var20 + var88, var21, var14 - var88, 5, 16711680);
                     }

                     var8 += 7;
                  }
               }
            }
         }

         if(var8 < 30) {
            var8 = 30;
         }

         if(var1 < var74) {
            Player var85 = (Player)var0;
            if(var85.field867) {
               return;
            }

            if(var85.skullIcon != -1 || var85.overheadIcon != -1) {
               class214.method4043(var0, var0.field1248 + 15);
               if(Client.field995 > -1) {
                  if(var85.skullIcon != -1) {
                     class89.field1383[var85.skullIcon].method5207(var2 + Client.field995 - 12, Client.field996 + var3 - var8);
                     var8 += 25;
                  }

                  if(var85.overheadIcon != -1) {
                     class23.field347[var85.overheadIcon].method5207(Client.field995 + var2 - 12, Client.field996 + var3 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.field907 == 10 && var7[var1] == Client.field909) {
               class214.method4043(var0, var0.field1248 + 15);
               if(Client.field995 > -1) {
                  class10.field261[1].method5207(var2 + Client.field995 - 12, var3 + Client.field996 - var8);
               }
            }
         } else {
            NPCComposition var86 = ((NPC)var0).composition;
            if(var86.configs != null) {
               var86 = var86.method4705();
            }

            if(var86.field3557 >= 0 && var86.field3557 < class23.field347.length) {
               class214.method4043(var0, var0.field1248 + 15);
               if(Client.field995 > -1) {
                  class23.field347[var86.field3557].method5207(Client.field995 + var2 - 12, Client.field996 + var3 - 30);
               }
            }

            if(Client.field907 == 1 && Client.field1013[var1 - var74] == Client.field908 && Client.gameCycle % 20 < 10) {
               class214.method4043(var0, var0.field1248 + 15);
               if(Client.field995 > -1) {
                  class10.field261[0].method5207(var2 + Client.field995 - 12, var3 + Client.field996 - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var74 || !var0.inSequence && (Client.field1099 == 4 || !var0.field1212 && (Client.field1099 == 0 || Client.field1099 == 3 || Client.field1099 == 1 && class158.method3025(((Player)var0).name, false))))) {
            class214.method4043(var0, var0.field1248);
            if(Client.field995 > -1 && Client.field983 < Client.field984) {
               Client.field988[Client.field983] = class40.field531.method4809(var0.overhead) / 2;
               Client.field987[Client.field983] = class40.field531.field3638;
               Client.field985[Client.field983] = Client.field995;
               Client.field910[Client.field983] = Client.field996;
               Client.field1056[Client.field983] = var0.field1215;
               Client.field925[Client.field983] = var0.field1216;
               Client.field952[Client.field983] = var0.field1214;
               Client.field992[Client.field983] = var0.overhead;
               ++Client.field983;
            }
         }

         for(int var79 = 0; var79 < 4; ++var79) {
            int var82 = var0.field1238[var79];
            int var80 = var0.field1256[var79];
            class254 var87 = null;
            int var83 = 0;
            if(var80 >= 0) {
               if(var82 <= Client.gameCycle) {
                  continue;
               }

               var87 = class149.method2942(var0.field1256[var79]);
               var83 = var87.field3426;
               if(var87 != null && var87.field3424 != null) {
                  var87 = var87.method4546();
                  if(var87 == null) {
                     var0.field1238[var79] = -1;
                     continue;
                  }
               }
            } else if(var82 < 0) {
               continue;
            }

            var14 = var0.field1233[var79];
            class254 var76 = null;
            if(var14 >= 0) {
               var76 = class149.method2942(var14);
               if(var76 != null && var76.field3424 != null) {
                  var76 = var76.method4546();
               }
            }

            if(var82 - var83 <= Client.gameCycle) {
               if(var87 == null) {
                  var0.field1238[var79] = -1;
               } else {
                  class214.method4043(var0, var0.field1248 / 2);
                  if(Client.field995 > -1) {
                     if(var79 == 1) {
                        Client.field996 -= 20;
                     }

                     if(var79 == 2) {
                        Client.field995 -= 15;
                        Client.field996 -= 10;
                     }

                     if(var79 == 3) {
                        Client.field995 += 15;
                        Client.field996 -= 10;
                     }

                     SpritePixels var84 = null;
                     SpritePixels var18 = null;
                     SpritePixels var81 = null;
                     SpritePixels var78 = null;
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
                     var84 = var87.method4545();
                     int var77;
                     if(var84 != null) {
                        var21 = var84.width;
                        var77 = var84.height;
                        if(var77 > var41) {
                           var41 = var77;
                        }

                        var25 = var84.offsetX;
                     }

                     var18 = var87.method4561();
                     if(var18 != null) {
                        var22 = var18.width;
                        var77 = var18.height;
                        if(var77 > var41) {
                           var41 = var77;
                        }

                        var26 = var18.offsetX;
                     }

                     var81 = var87.method4550();
                     if(var81 != null) {
                        var23 = var81.width;
                        var77 = var81.height;
                        if(var77 > var41) {
                           var41 = var77;
                        }

                        var27 = var81.offsetX;
                     }

                     var78 = var87.method4551();
                     if(var78 != null) {
                        var24 = var78.width;
                        var77 = var78.height;
                        if(var77 > var41) {
                           var41 = var77;
                        }

                        var28 = var78.offsetX;
                     }

                     if(var76 != null) {
                        var29 = var76.method4545();
                        if(var29 != null) {
                           var33 = var29.width;
                           var77 = var29.height;
                           if(var77 > var41) {
                              var41 = var77;
                           }

                           var37 = var29.offsetX;
                        }

                        var30 = var76.method4561();
                        if(var30 != null) {
                           var34 = var30.width;
                           var77 = var30.height;
                           if(var77 > var41) {
                              var41 = var77;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var76.method4550();
                        if(var31 != null) {
                           var35 = var31.width;
                           var77 = var31.height;
                           if(var77 > var41) {
                              var41 = var77;
                           }

                           var39 = var31.offsetX;
                        }

                        var32 = var76.method4551();
                        if(var32 != null) {
                           var36 = var32.width;
                           var77 = var32.height;
                           if(var77 > var41) {
                              var41 = var77;
                           }

                           var40 = var32.offsetX;
                        }
                     }

                     Font var42 = var87.method4567();
                     if(var42 == null) {
                        var42 = class3.field15;
                     }

                     Font var43;
                     if(var76 != null) {
                        var43 = var76.method4567();
                        if(var43 == null) {
                           var43 = class3.field15;
                        }
                     } else {
                        var43 = class3.field15;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var87.method4547(var0.field1219[var79]);
                     int var89 = var42.method4809(var44);
                     if(var76 != null) {
                        var45 = var76.method4547(var0.field1222[var79]);
                        var47 = var43.method4809(var45);
                     }

                     int var48 = 0;
                     int var49 = 0;
                     if(var22 > 0) {
                        if(var81 == null && var78 == null) {
                           var48 = 1;
                        } else {
                           var48 = var89 / var22 + 1;
                        }
                     }

                     if(var76 != null && var34 > 0) {
                        if(var31 == null && var32 == null) {
                           var49 = 1;
                        } else {
                           var49 = var47 / var34 + 1;
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
                     if(var76 != null) {
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
                           var61 = var49 * var34;
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

                     var61 = var0.field1238[var79] - Client.gameCycle;
                     int var62 = var87.field3407 - var61 * var87.field3407 / var87.field3426;
                     int var63 = var61 * var87.field3406 / var87.field3426 + -var87.field3406;
                     int var64 = var62 + (Client.field995 + var2 - (var50 >> 1));
                     int var65 = var63 + (Client.field996 + var3 - 12);
                     int var66 = var65;
                     int var67 = var41 + var65;
                     int var68 = var65 + 15 + var87.field3423;
                     int var69 = var68 - var42.field3639;
                     int var70 = var68 + var42.field3636;
                     if(var69 < var65) {
                        var66 = var69;
                     }

                     if(var70 > var67) {
                        var67 = var70;
                     }

                     int var71 = 0;
                     int var72;
                     int var73;
                     if(var76 != null) {
                        var71 = var65 + 15 + var76.field3423;
                        var72 = var71 - var43.field3639;
                        var73 = var43.field3636 + var71;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var87.field3403 >= 0) {
                        var72 = (var61 << 8) / (var87.field3426 - var87.field3403);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(var84 != null) {
                           var84.method5138(var51 + var64 - var25, var65, var72);
                        }

                        if(var81 != null) {
                           var81.method5138(var64 + var52 - var27, var65, var72);
                        }

                        if(var18 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var18.method5138(var73 * var22 + (var53 + var64 - var26), var65, var72);
                           }
                        }

                        if(var78 != null) {
                           var78.method5138(var55 + var64 - var28, var65, var72);
                        }

                        var42.method4872(var44, var64 + var54, var68, var87.field3412, 0, var72);
                        if(var76 != null) {
                           if(var29 != null) {
                              var29.method5138(var56 + var64 - var37, var65, var72);
                           }

                           if(var31 != null) {
                              var31.method5138(var64 + var57 - var39, var65, var72);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method5138(var73 * var34 + (var58 + var64 - var38), var65, var72);
                              }
                           }

                           if(var32 != null) {
                              var32.method5138(var64 + var59 - var40, var65, var72);
                           }

                           var43.method4872(var45, var64 + var60, var71, var76.field3412, 0, var72);
                        }
                     } else {
                        if(var84 != null) {
                           var84.method5207(var64 + var51 - var25, var65);
                        }

                        if(var81 != null) {
                           var81.method5207(var52 + var64 - var27, var65);
                        }

                        if(var18 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var18.method5207(var22 * var73 + (var64 + var53 - var26), var65);
                           }
                        }

                        if(var78 != null) {
                           var78.method5207(var55 + var64 - var28, var65);
                        }

                        var42.method4889(var44, var64 + var54, var68, var87.field3412 | -16777216, 0);
                        if(var76 != null) {
                           if(var29 != null) {
                              var29.method5207(var64 + var56 - var37, var65);
                           }

                           if(var31 != null) {
                              var31.method5207(var57 + var64 - var39, var65);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method5207(var58 + var64 - var38 + var73 * var34, var65);
                              }
                           }

                           if(var32 != null) {
                              var32.method5207(var59 + var64 - var40, var65);
                           }

                           var43.method4889(var45, var64 + var60, var71, var76.field3412 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("k")
   protected void vmethod3969(int var1) {
      this.field2583.vmethod3969(var1);

      for(class205 var3 = (class205)this.field2582.method3660(); var3 != null; var3 = (class205)this.field2582.method3661()) {
         if(!this.field2581.method3787(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2553) {
                  this.method3943(var3, var2);
                  var3.field2553 -= var2;
                  break;
               }

               this.method3943(var3, var3.field2553);
               var2 -= var3.field2553;
            } while(!this.field2581.method3788(var3, (int[])null, 0, var2));
         }
      }

   }
}
