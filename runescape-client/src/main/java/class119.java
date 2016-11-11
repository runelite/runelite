import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
public class class119 {
   @ObfuscatedName("i")
   Inflater field2029;
   @ObfuscatedName("ef")
   static SpritePixels field2032;

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class119(int var1, int var2, int var3) {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;[BI)V",
      garbageValue = "-915992001"
   )
   public void method2487(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[var1.offset + 1] == -117) {
         if(this.field2029 == null) {
            this.field2029 = new Inflater(true);
         }

         try {
            this.field2029.setInput(var1.payload, var1.offset + 10, var1.payload.length - (10 + var1.offset + 8));
            this.field2029.inflate(var2);
         } catch (Exception var4) {
            this.field2029.reset();
            throw new RuntimeException("");
         }

         this.field2029.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   public class119() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIII)V",
      garbageValue = "403098794"
   )
   static final void method2492(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(null != var9 && (!var9.field2862 || var9.type == 0 || var9.field2882 || Projectile.method96(var9) != 0 || var9 == Client.field474 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.field2862 || !FaceNormal.method1940(var9))) {
            int var10 = var9.relativeX + var6;
            int var11 = var7 + var9.relativeY;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.type == 9) {
               var16 = var10;
               var17 = var11;
               var18 = var10 + var9.width;
               var19 = var9.height + var11;
               if(var18 < var10) {
                  var16 = var18;
                  var18 = var10;
               }

               if(var19 < var11) {
                  var17 = var19;
                  var19 = var11;
               }

               ++var18;
               ++var19;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var18 < var4?var18:var4;
               var15 = var19 < var5?var19:var5;
            } else {
               var16 = var10 + var9.width;
               var17 = var9.height + var11;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(Client.field473 == var9) {
               Client.field585 = true;
               Client.field482 = var10;
               Client.field447 = var11;
            }

            if(!var9.field2862 || var12 < var14 && var13 < var15) {
               var16 = class143.field2204;
               var17 = class143.field2206;
               if(class143.field2210 != 0) {
                  var16 = class143.field2211;
                  var17 = class143.field2212;
               }

               int var22;
               int var23;
               int var24;
               int var25;
               int var34;
               int var44;
               int var45;
               if(var9.contentType == 1337) {
                  if(!Client.field439 && !Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     if(Client.field453 == 0 && !Client.field455) {
                        class132.addMenuEntry("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var18 = -1;
                     var19 = -1;

                     for(var45 = 0; var45 < Model.field1868; ++var45) {
                        var44 = Model.field1914[var45];
                        var22 = var44 & 127;
                        var23 = var44 >> 7 & 127;
                        var24 = var44 >> 29 & 3;
                        var25 = var44 >> 14 & 32767;
                        if(var44 != var19) {
                           var19 = var44;
                           if(var24 == 2 && class128.region.method1995(class173.plane, var22, var23, var44) >= 0) {
                              ObjectComposition var26 = class9.getObjectDefinition(var25);
                              if(null != var26.impostorIds) {
                                 var26 = var26.getImpostor();
                              }

                              if(null == var26) {
                                 continue;
                              }

                              if(Client.field453 == 1) {
                                 class132.addMenuEntry("Use", Client.field312 + " " + "->" + " " + class137.method2909('\uffff') + var26.name, 1, var44, var22, var23);
                              } else if(Client.field455) {
                                 if((class18.field285 & 4) == 4) {
                                    class132.addMenuEntry(Client.field458, Client.field459 + " " + "->" + " " + class137.method2909('\uffff') + var26.name, 2, var44, var22, var23);
                                 }
                              } else {
                                 String[] var27 = var26.actions;
                                 if(Client.field471) {
                                    var27 = Friend.method193(var27);
                                 }

                                 if(var27 != null) {
                                    for(int var36 = 4; var36 >= 0; --var36) {
                                       if(var27[var36] != null) {
                                          short var29 = 0;
                                          if(var36 == 0) {
                                             var29 = 3;
                                          }

                                          if(var36 == 1) {
                                             var29 = 4;
                                          }

                                          if(var36 == 2) {
                                             var29 = 5;
                                          }

                                          if(var36 == 3) {
                                             var29 = 6;
                                          }

                                          if(var36 == 4) {
                                             var29 = 1001;
                                          }

                                          class132.addMenuEntry(var27[var36], class137.method2909('\uffff') + var26.name, var29, var44, var22, var23);
                                       }
                                    }
                                 }

                                 class132.addMenuEntry("Examine", class137.method2909('\uffff') + var26.name, 1002, var26.field954 << 14, var22, var23);
                              }
                           }

                           NPC var28;
                           Player var30;
                           int[] var50;
                           int var52;
                           if(var24 == 1) {
                              NPC var46 = Client.cachedNPCs[var25];
                              if(null == var46) {
                                 continue;
                              }

                              if(var46.composition.field910 == 1 && (var46.x & 127) == 64 && (var46.y & 127) == 64) {
                                 for(var34 = 0; var34 < Client.field341; ++var34) {
                                    var28 = Client.cachedNPCs[Client.field342[var34]];
                                    if(null != var28 && var28 != var46 && var28.composition.field910 == 1 && var28.x == var46.x && var46.y == var28.y) {
                                       class9.method126(var28.composition, Client.field342[var34], var22, var23);
                                    }
                                 }

                                 var34 = class34.field779;
                                 var50 = class34.field786;

                                 for(var52 = 0; var52 < var34; ++var52) {
                                    var30 = Client.cachedPlayers[var50[var52]];
                                    if(null != var30 && var46.x == var30.x && var46.y == var30.y) {
                                       Player.method17(var30, var50[var52], var22, var23);
                                    }
                                 }
                              }

                              class9.method126(var46.composition, var25, var22, var23);
                           }

                           if(var24 == 0) {
                              Player var47 = Client.cachedPlayers[var25];
                              if(var47 == null) {
                                 continue;
                              }

                              if((var47.x & 127) == 64 && (var47.y & 127) == 64) {
                                 for(var34 = 0; var34 < Client.field341; ++var34) {
                                    var28 = Client.cachedNPCs[Client.field342[var34]];
                                    if(var28 != null && var28.composition.field910 == 1 && var47.x == var28.x && var47.y == var28.y) {
                                       class9.method126(var28.composition, Client.field342[var34], var22, var23);
                                    }
                                 }

                                 var34 = class34.field779;
                                 var50 = class34.field786;

                                 for(var52 = 0; var52 < var34; ++var52) {
                                    var30 = Client.cachedPlayers[var50[var52]];
                                    if(var30 != null && var47 != var30 && var30.x == var47.x && var30.y == var47.y) {
                                       Player.method17(var30, var50[var52], var22, var23);
                                    }
                                 }
                              }

                              if(Client.field432 != var25) {
                                 Player.method17(var47, var25, var22, var23);
                              } else {
                                 var18 = var44;
                              }
                           }

                           if(var24 == 3) {
                              Deque var48 = Client.groundItemDeque[class173.plane][var22][var23];
                              if(null != var48) {
                                 for(Item var49 = (Item)var48.method3846(); var49 != null; var49 = (Item)var48.method3848()) {
                                    ItemComposition var51 = class92.getItemDefinition(var49.id);
                                    if(Client.field453 == 1) {
                                       class132.addMenuEntry("Use", Client.field312 + " " + "->" + " " + class137.method2909(16748608) + var51.name, 16, var49.id, var22, var23);
                                    } else if(Client.field455) {
                                       if((class18.field285 & 1) == 1) {
                                          class132.addMenuEntry(Client.field458, Client.field459 + " " + "->" + " " + class137.method2909(16748608) + var51.name, 17, var49.id, var22, var23);
                                       }
                                    } else {
                                       String[] var35 = var51.groundActions;
                                       if(Client.field471) {
                                          var35 = Friend.method193(var35);
                                       }

                                       for(int var38 = 4; var38 >= 0; --var38) {
                                          if(var35 != null && null != var35[var38]) {
                                             byte var31 = 0;
                                             if(var38 == 0) {
                                                var31 = 18;
                                             }

                                             if(var38 == 1) {
                                                var31 = 19;
                                             }

                                             if(var38 == 2) {
                                                var31 = 20;
                                             }

                                             if(var38 == 3) {
                                                var31 = 21;
                                             }

                                             if(var38 == 4) {
                                                var31 = 22;
                                             }

                                             class132.addMenuEntry(var35[var38], class137.method2909(16748608) + var51.name, var31, var49.id, var22, var23);
                                          } else if(var38 == 2) {
                                             class132.addMenuEntry("Take", class137.method2909(16748608) + var51.name, 20, var49.id, var22, var23);
                                          }
                                       }

                                       class132.addMenuEntry("Examine", class137.method2909(16748608) + var51.name, 1004, var49.id, var22, var23);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var18 != -1) {
                        var45 = var18 & 127;
                        var44 = var18 >> 7 & 127;
                        Player var55 = Client.cachedPlayers[Client.field432];
                        Player.method17(var55, Client.field432, var45, var44);
                     }
                  }
               } else if(var9.contentType == 1338) {
                  if((Client.field403 == 0 || Client.field403 == 3) && (class143.field2210 == 1 || !class4.field81 && class143.field2210 == 4)) {
                     class178 var54 = var9.method3462(true);
                     if(null != var54) {
                        var19 = class143.field2211 - var10;
                        var45 = class143.field2212 - var11;
                        if(var54.method3475(var19, var45)) {
                           var19 -= var54.field2948 / 2;
                           var45 -= var54.field2947 / 2;
                           var44 = Client.mapScale + Client.mapAngle & 2047;
                           var22 = class94.field1623[var44];
                           var23 = class94.field1642[var44];
                           var22 = var22 * (256 + Client.mapScaleDelta) >> 8;
                           var23 = (256 + Client.mapScaleDelta) * var23 >> 8;
                           var24 = var19 * var23 + var45 * var22 >> 11;
                           var25 = var23 * var45 - var22 * var19 >> 11;
                           int var40 = class138.localPlayer.x + var24 >> 7;
                           var34 = class138.localPlayer.y - var25 >> 7;
                           Client.field378.method2801(227);
                           Client.field378.method2529(18);
                           Client.field378.method2569(class140.field2165[82]?(class140.field2165[81]?2:1):0);
                           Client.field378.method2701(var34 + DecorativeObject.baseY);
                           Client.field378.method2577(class193.baseX + var40);
                           Client.field378.method2529(var19);
                           Client.field378.method2529(var45);
                           Client.field378.method2701(Client.mapAngle);
                           Client.field378.method2529(57);
                           Client.field378.method2529(Client.mapScale);
                           Client.field378.method2529(Client.mapScaleDelta);
                           Client.field378.method2529(89);
                           Client.field378.method2701(class138.localPlayer.x);
                           Client.field378.method2701(class138.localPlayer.y);
                           Client.field378.method2529(63);
                           Client.flagX = var40;
                           Client.flagY = var34;
                        }
                     }
                  }
               } else {
                  if(!Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     BufferProvider.method1733(var9, var16 - var10, var17 - var11);
                  }

                  if(var9.type == 0) {
                     if(!var9.field2862 && FaceNormal.method1940(var9) && var9 != class53.field1153) {
                        continue;
                     }

                     method2492(var0, var9.id, var12, var13, var14, var15, var10 - var9.itemId, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method2492(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.itemId, var11 - var9.scrollY);
                     }

                     WidgetNode var33 = (WidgetNode)Client.componentTable.method3812((long)var9.id);
                     if(var33 != null) {
                        if(var33.field70 == 0 && class143.field2204 >= var12 && class143.field2206 >= var13 && class143.field2204 < var14 && class143.field2206 < var15 && !Client.isMenuOpen && !Client.field470) {
                           for(class0 var41 = (class0)Client.field522.method3845(); null != var41; var41 = (class0)Client.field522.method3847()) {
                              if(var41.field5) {
                                 var41.unlink();
                                 var41.field13.field2927 = false;
                              }
                           }

                           if(class38.field826 == 0) {
                              Client.field473 = null;
                              Client.field474 = null;
                           }

                           if(!Client.isMenuOpen) {
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.menuOptionCount = 1;
                           }
                        }

                        var19 = var33.id;
                        if(class14.method172(var19)) {
                           method2492(Widget.widgets[var19], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  if(var9.field2862) {
                     class0 var53;
                     if(!var9.field2874) {
                        if(var9.field2936 && class143.field2204 >= var12 && class143.field2206 >= var13 && class143.field2204 < var14 && class143.field2206 < var15) {
                           for(var53 = (class0)Client.field522.method3845(); var53 != null; var53 = (class0)Client.field522.method3847()) {
                              if(var53.field5 && var53.field8 == var53.field13.field2903) {
                                 var53.unlink();
                              }
                           }
                        }
                     } else if(class143.field2204 >= var12 && class143.field2206 >= var13 && class143.field2204 < var14 && class143.field2206 < var15) {
                        for(var53 = (class0)Client.field522.method3845(); null != var53; var53 = (class0)Client.field522.method3847()) {
                           if(var53.field5) {
                              var53.unlink();
                              var53.field13.field2927 = false;
                           }
                        }

                        if(class38.field826 == 0) {
                           Client.field473 = null;
                           Client.field474 = null;
                        }

                        if(!Client.isMenuOpen) {
                           Client.menuOptions[0] = "Cancel";
                           Client.menuTargets[0] = "";
                           Client.menuTypes[0] = 1006;
                           Client.menuOptionCount = 1;
                        }
                     }

                     boolean var42;
                     if(class143.field2204 >= var12 && class143.field2206 >= var13 && class143.field2204 < var14 && class143.field2206 < var15) {
                        var42 = true;
                     } else {
                        var42 = false;
                     }

                     boolean var43 = false;
                     if((class143.field2203 == 1 || !class4.field81 && class143.field2203 == 4) && var42) {
                        var43 = true;
                     }

                     boolean var20 = false;
                     if((class143.field2210 == 1 || !class4.field81 && class143.field2210 == 4) && class143.field2211 >= var12 && class143.field2212 >= var13 && class143.field2211 < var14 && class143.field2212 < var15) {
                        var20 = true;
                     }

                     if(var20) {
                        Player.method39(var9, class143.field2211 - var10, class143.field2212 - var11);
                     }

                     if(Client.field473 != null && var9 != Client.field473 && var42) {
                        var22 = Projectile.method96(var9);
                        boolean var21 = (var22 >> 20 & 1) != 0;
                        if(var21) {
                           Client.field460 = var9;
                        }
                     }

                     if(var9 == Client.field474) {
                        Client.field478 = true;
                        Client.field479 = var10;
                        Client.field324 = var11;
                     }

                     if(var9.field2882) {
                        class0 var32;
                        if(var42 && Client.field530 != 0 && var9.field2903 != null) {
                           var32 = new class0();
                           var32.field5 = true;
                           var32.field13 = var9;
                           var32.field4 = Client.field530;
                           var32.field8 = var9.field2903;
                           Client.field522.method3865(var32);
                        }

                        if(Client.field473 != null || FrameMap.field1821 != null || Client.isMenuOpen) {
                           var20 = false;
                           var43 = false;
                           var42 = false;
                        }

                        if(!var9.field2928 && var20) {
                           var9.field2928 = true;
                           if(null != var9.field2884) {
                              var32 = new class0();
                              var32.field5 = true;
                              var32.field13 = var9;
                              var32.field3 = class143.field2211 - var10;
                              var32.field4 = class143.field2212 - var11;
                              var32.field8 = var9.field2884;
                              Client.field522.method3865(var32);
                           }
                        }

                        if(var9.field2928 && var43 && null != var9.field2885) {
                           var32 = new class0();
                           var32.field5 = true;
                           var32.field13 = var9;
                           var32.field3 = class143.field2204 - var10;
                           var32.field4 = class143.field2206 - var11;
                           var32.field8 = var9.field2885;
                           Client.field522.method3865(var32);
                        }

                        if(var9.field2928 && !var43) {
                           var9.field2928 = false;
                           if(null != var9.field2894) {
                              var32 = new class0();
                              var32.field5 = true;
                              var32.field13 = var9;
                              var32.field3 = class143.field2204 - var10;
                              var32.field4 = class143.field2206 - var11;
                              var32.field8 = var9.field2894;
                              Client.field501.method3865(var32);
                           }
                        }

                        if(var43 && null != var9.field2887) {
                           var32 = new class0();
                           var32.field5 = true;
                           var32.field13 = var9;
                           var32.field3 = class143.field2204 - var10;
                           var32.field4 = class143.field2206 - var11;
                           var32.field8 = var9.field2887;
                           Client.field522.method3865(var32);
                        }

                        if(!var9.field2927 && var42) {
                           var9.field2927 = true;
                           if(null != var9.field2838) {
                              var32 = new class0();
                              var32.field5 = true;
                              var32.field13 = var9;
                              var32.field3 = class143.field2204 - var10;
                              var32.field4 = class143.field2206 - var11;
                              var32.field8 = var9.field2838;
                              Client.field522.method3865(var32);
                           }
                        }

                        if(var9.field2927 && var42 && null != var9.field2889) {
                           var32 = new class0();
                           var32.field5 = true;
                           var32.field13 = var9;
                           var32.field3 = class143.field2204 - var10;
                           var32.field4 = class143.field2206 - var11;
                           var32.field8 = var9.field2889;
                           Client.field522.method3865(var32);
                        }

                        if(var9.field2927 && !var42) {
                           var9.field2927 = false;
                           if(var9.field2890 != null) {
                              var32 = new class0();
                              var32.field5 = true;
                              var32.field13 = var9;
                              var32.field3 = class143.field2204 - var10;
                              var32.field4 = class143.field2206 - var11;
                              var32.field8 = var9.field2890;
                              Client.field501.method3865(var32);
                           }
                        }

                        if(null != var9.field2926) {
                           var32 = new class0();
                           var32.field13 = var9;
                           var32.field8 = var9.field2926;
                           Client.field500.method3865(var32);
                        }

                        class0 var39;
                        if(null != var9.field2895 && Client.field426 > var9.field2930) {
                           if(null != var9.field2896 && Client.field426 - var9.field2930 <= 32) {
                              label1259:
                              for(var44 = var9.field2930; var44 < Client.field426; ++var44) {
                                 var22 = Client.field486[var44 & 31];

                                 for(var23 = 0; var23 < var9.field2896.length; ++var23) {
                                    if(var9.field2896[var23] == var22) {
                                       var39 = new class0();
                                       var39.field13 = var9;
                                       var39.field8 = var9.field2895;
                                       Client.field522.method3865(var39);
                                       break label1259;
                                    }
                                 }
                              }
                           } else {
                              var32 = new class0();
                              var32.field13 = var9;
                              var32.field8 = var9.field2895;
                              Client.field522.method3865(var32);
                           }

                           var9.field2930 = Client.field426;
                        }

                        if(var9.field2851 != null && Client.field489 > var9.field2931) {
                           if(null != var9.field2917 && Client.field489 - var9.field2931 <= 32) {
                              label1235:
                              for(var44 = var9.field2931; var44 < Client.field489; ++var44) {
                                 var22 = Client.field488[var44 & 31];

                                 for(var23 = 0; var23 < var9.field2917.length; ++var23) {
                                    if(var22 == var9.field2917[var23]) {
                                       var39 = new class0();
                                       var39.field13 = var9;
                                       var39.field8 = var9.field2851;
                                       Client.field522.method3865(var39);
                                       break label1235;
                                    }
                                 }
                              }
                           } else {
                              var32 = new class0();
                              var32.field13 = var9;
                              var32.field8 = var9.field2851;
                              Client.field522.method3865(var32);
                           }

                           var9.field2931 = Client.field489;
                        }

                        if(null != var9.field2899 && Client.field491 > var9.field2932) {
                           if(null != var9.field2795 && Client.field491 - var9.field2932 <= 32) {
                              label1211:
                              for(var44 = var9.field2932; var44 < Client.field491; ++var44) {
                                 var22 = Client.field490[var44 & 31];

                                 for(var23 = 0; var23 < var9.field2795.length; ++var23) {
                                    if(var22 == var9.field2795[var23]) {
                                       var39 = new class0();
                                       var39.field13 = var9;
                                       var39.field8 = var9.field2899;
                                       Client.field522.method3865(var39);
                                       break label1211;
                                    }
                                 }
                              }
                           } else {
                              var32 = new class0();
                              var32.field13 = var9;
                              var32.field8 = var9.field2899;
                              Client.field522.method3865(var32);
                           }

                           var9.field2932 = Client.field491;
                        }

                        if(Client.field492 > var9.field2811 && null != var9.field2904) {
                           var32 = new class0();
                           var32.field13 = var9;
                           var32.field8 = var9.field2904;
                           Client.field522.method3865(var32);
                        }

                        if(Client.field493 > var9.field2811 && null != var9.field2915) {
                           var32 = new class0();
                           var32.field13 = var9;
                           var32.field8 = var9.field2915;
                           Client.field522.method3865(var32);
                        }

                        if(Client.field570 > var9.field2811 && var9.field2886 != null) {
                           var32 = new class0();
                           var32.field13 = var9;
                           var32.field8 = var9.field2886;
                           Client.field522.method3865(var32);
                        }

                        if(Client.field575 > var9.field2811 && var9.field2912 != null) {
                           var32 = new class0();
                           var32.field13 = var9;
                           var32.field8 = var9.field2912;
                           Client.field522.method3865(var32);
                        }

                        if(Client.field496 > var9.field2811 && null != var9.field2837) {
                           var32 = new class0();
                           var32.field13 = var9;
                           var32.field8 = var9.field2837;
                           Client.field522.method3865(var32);
                        }

                        if(Client.field497 > var9.field2811 && var9.field2853 != null) {
                           var32 = new class0();
                           var32.field13 = var9;
                           var32.field8 = var9.field2853;
                           Client.field522.method3865(var32);
                        }

                        var9.field2811 = Client.field485;
                        if(var9.field2929 != null) {
                           for(var44 = 0; var44 < Client.field523; ++var44) {
                              class0 var37 = new class0();
                              var37.field13 = var9;
                              var37.field7 = Client.field477[var44];
                              var37.field17 = Client.field336[var44];
                              var37.field8 = var9.field2929;
                              Client.field522.method3865(var37);
                           }
                        }
                     }
                  }

                  if(!var9.field2862 && Client.field473 == null && FrameMap.field1821 == null && !Client.isMenuOpen) {
                     if((var9.field2796 >= 0 || var9.field2819 != 0) && class143.field2204 >= var12 && class143.field2206 >= var13 && class143.field2204 < var14 && class143.field2206 < var15) {
                        if(var9.field2796 >= 0) {
                           class53.field1153 = var0[var9.field2796];
                        } else {
                           class53.field1153 = var9;
                        }
                     }

                     if(var9.type == 8 && class143.field2204 >= var12 && class143.field2206 >= var13 && class143.field2204 < var14 && class143.field2206 < var15) {
                        Friend.field267 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        var18 = var10 + var9.width;
                        var19 = var9.height;
                        var45 = var9.scrollHeight;
                        var44 = class143.field2204;
                        var22 = class143.field2206;
                        if(Client.field384) {
                           Client.field362 = 32;
                        } else {
                           Client.field362 = 0;
                        }

                        Client.field384 = false;
                        if(class143.field2203 == 1 || !class4.field81 && class143.field2203 == 4) {
                           if(var44 >= var18 && var44 < var18 + 16 && var22 >= var11 && var22 < 16 + var11) {
                              var9.scrollY -= 4;
                              class32.method673(var9);
                           } else if(var44 >= var18 && var44 < var18 + 16 && var22 >= var11 + var19 - 16 && var22 < var11 + var19) {
                              var9.scrollY += 4;
                              class32.method673(var9);
                           } else if(var44 >= var18 - Client.field362 && var44 < Client.field362 + 16 + var18 && var22 >= var11 + 16 && var22 < var11 + var19 - 16) {
                              var23 = (var19 - 32) * var19 / var45;
                              if(var23 < 8) {
                                 var23 = 8;
                              }

                              var24 = var22 - var11 - 16 - var23 / 2;
                              var25 = var19 - 32 - var23;
                              var9.scrollY = (var45 - var19) * var24 / var25;
                              class32.method673(var9);
                              Client.field384 = true;
                           }
                        }

                        if(Client.field530 != 0) {
                           var23 = var9.width;
                           if(var44 >= var18 - var23 && var22 >= var11 && var44 < 16 + var18 && var22 <= var11 + var19) {
                              var9.scrollY += Client.field530 * 45;
                              class32.method673(var9);
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
