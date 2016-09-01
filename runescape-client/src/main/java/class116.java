import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
public class class116 {
   @ObfuscatedName("j")
   int[] field2020;
   @ObfuscatedName("r")
   byte[] field2021;
   @ObfuscatedName("x")
   int[] field2022;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BII[BIS)I",
      garbageValue = "128"
   )
   public int method2490(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field2022[var8];
         byte var10 = this.field2021[var8];
         if(var10 == 0) {
            throw new RuntimeException("");
         }

         int var11 = var7 >> 3;
         int var12 = var7 & 7;
         var6 &= -var12 >> 31;
         int var13 = var11 + (var12 + var10 - 1 >> 3);
         var12 += 24;
         var4[var11] = (byte)(var6 |= var9 >>> var12);
         if(var11 < var13) {
            ++var11;
            var12 -= 8;
            var4[var11] = (byte)(var6 = var9 >>> var12);
            if(var11 < var13) {
               ++var11;
               var12 -= 8;
               var4[var11] = (byte)(var6 = var9 >>> var12);
               if(var11 < var13) {
                  ++var11;
                  var12 -= 8;
                  var4[var11] = (byte)(var6 = var9 >>> var12);
                  if(var11 < var13) {
                     ++var11;
                     var12 -= 8;
                     var4[var11] = (byte)(var6 = var9 << -var12);
                  }
               }
            }
         }

         var7 += var10;
      }

      return (7 + var7 >> 3) - var5;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "606142026"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[FrameMap.plane][var0][var1];
      if(var2 == null) {
         Projectile.region.method1969(FrameMap.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.method3850(); null != var6; var6 = (Item)var2.method3852()) {
            ItemComposition var7 = MessageNode.getItemDefinition(var6.id);
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
            Projectile.region.method1969(FrameMap.plane, var0, var1);
         } else {
            var2.method3846(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.method3850(); var6 != null; var6 = (Item)var2.method3852()) {
               if(var5.id != var6.id) {
                  if(null == var11) {
                     var11 = var6;
                  }

                  if(var11.id != var6.id && null == var10) {
                     var10 = var6;
                  }
               }
            }

            int var9 = 1610612736 + (var1 << 7) + var0;
            Projectile.region.method1955(FrameMap.plane, var0, var1, KitDefinition.method936(128 * var0 + 64, var1 * 128 + 64, FrameMap.plane), var5, var9, var11, var10);
         }
      }
   }

   public class116(byte[] var1) {
      int var2 = var1.length;
      this.field2022 = new int[var2];
      this.field2021 = var1;
      int[] var3 = new int[33];
      this.field2020 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field2022[var5] = var8;
            int var9;
            int var10;
            int var11;
            int var12;
            if((var8 & var7) != 0) {
               var9 = var3[var6 - 1];
            } else {
               var9 = var8 | var7;

               for(var10 = var6 - 1; var10 >= 1; --var10) {
                  var11 = var3[var10];
                  if(var11 != var8) {
                     break;
                  }

                  var12 = 1 << 32 - var10;
                  if((var11 & var12) != 0) {
                     var3[var10] = var3[var10 - 1];
                     break;
                  }

                  var3[var10] = var11 | var12;
               }
            }

            var3[var6] = var9;

            for(var10 = 1 + var6; var10 <= 32; ++var10) {
               if(var3[var10] == var8) {
                  var3[var10] = var9;
               }
            }

            var10 = 0;

            for(var11 = 0; var11 < var6; ++var11) {
               var12 = Integer.MIN_VALUE >>> var11;
               if((var8 & var12) != 0) {
                  if(this.field2020[var10] == 0) {
                     this.field2020[var10] = var4;
                  }

                  var10 = this.field2020[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.field2020.length) {
                  int[] var13 = new int[this.field2020.length * 2];

                  for(int var14 = 0; var14 < this.field2020.length; ++var14) {
                     var13[var14] = this.field2020[var14];
                  }

                  this.field2020 = var13;
               }

               var12 >>>= 1;
            }

            this.field2020[var10] = ~var5;
            if(var10 >= var4) {
               var4 = 1 + var10;
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BI[BIII)I",
      garbageValue = "-1587306208"
   )
   public int method2495(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(var5 == 0) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.field2020[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.field2020[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 64) != 0) {
               var6 = this.field2020[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2020[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.field2020[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2020[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 16) != 0) {
               var6 = this.field2020[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2020[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 8) != 0) {
               var6 = this.field2020[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2020[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.field2020[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2020[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 2) != 0) {
               var6 = this.field2020[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2020[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 1) != 0) {
               var6 = this.field2020[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2020[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            ++var7;
         }

         return var7 + 1 - var2;
      }
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIII)V",
      garbageValue = "945281351"
   )
   static final void method2496(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.field2809 || var9.type == 0 || var9.field2829 || class132.method2880(var9) != 0 || Client.field453 == var9 || var9.contentType == 1338) && var1 == var9.parentId && (!var9.field2809 || !class34.method712(var9))) {
            int var10 = var6 + var9.relativeX;
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
               var18 = var9.width + var10;
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
               var17 = var11 + var9.height;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(var9 == Client.field494) {
               Client.field460 = true;
               Client.field298 = var10;
               Client.field462 = var11;
            }

            if(!var9.field2809 || var12 < var14 && var13 < var15) {
               var16 = class143.field2204;
               var17 = class143.field2210;
               if(class143.field2198 != 0) {
                  var16 = class143.field2211;
                  var17 = class143.field2213;
               }

               int var21;
               int var23;
               int var24;
               int var25;
               int var33;
               int var43;
               if(var9.contentType == 1337) {
                  if(!Client.field289 && !Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     if(Client.field432 == 0 && !Client.field404) {
                        XItemContainer.addMenuEntry("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var18 = -1;
                     var19 = -1;

                     for(var43 = 0; var43 < Model.field1913; ++var43) {
                        var21 = Model.field1914[var43];
                        var33 = var21 & 127;
                        var23 = var21 >> 7 & 127;
                        var24 = var21 >> 29 & 3;
                        var25 = var21 >> 14 & 32767;
                        if(var19 != var21) {
                           var19 = var21;
                           if(var24 == 2 && Projectile.region.method1978(FrameMap.plane, var33, var23, var21) >= 0) {
                              ObjectComposition var26 = class1.getObjectDefinition(var25);
                              if(null != var26.impostorIds) {
                                 var26 = var26.getImpostor();
                              }

                              if(var26 == null) {
                                 continue;
                              }

                              if(Client.field432 == 1) {
                                 XItemContainer.addMenuEntry("Use", Client.field433 + " " + "->" + " " + class154.method3185('\uffff') + var26.name, 1, var21, var33, var23);
                              } else if(Client.field404) {
                                 if((class171.field2749 & 4) == 4) {
                                    XItemContainer.addMenuEntry(Client.field437, Client.field438 + " " + "->" + " " + class154.method3185('\uffff') + var26.name, 2, var21, var33, var23);
                                 }
                              } else {
                                 String[] var27 = var26.actions;
                                 if(Client.field293) {
                                    var27 = class75.method1607(var27);
                                 }

                                 if(null != var27) {
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

                                          XItemContainer.addMenuEntry(var27[var36], class154.method3185('\uffff') + var26.name, var29, var21, var33, var23);
                                       }
                                    }
                                 }

                                 XItemContainer.addMenuEntry("Examine", class154.method3185('\uffff') + var26.name, 1002, var26.field947 << 14, var33, var23);
                              }
                           }

                           NPC var28;
                           int var37;
                           Player var38;
                           int[] var49;
                           int var51;
                           if(var24 == 1) {
                              NPC var45 = Client.cachedNPCs[var25];
                              if(var45 == null) {
                                 continue;
                              }

                              if(var45.composition.field902 == 1 && (var45.x & 127) == 64 && (var45.y & 127) == 64) {
                                 for(var37 = 0; var37 < Client.field319; ++var37) {
                                    var28 = Client.cachedNPCs[Client.field320[var37]];
                                    if(null != var28 && var45 != var28 && var28.composition.field902 == 1 && var45.x == var28.x && var28.y == var45.y) {
                                       World.method627(var28.composition, Client.field320[var37], var33, var23);
                                    }
                                 }

                                 var37 = class34.field760;
                                 var49 = class34.field755;

                                 for(var51 = 0; var51 < var37; ++var51) {
                                    var38 = Client.cachedPlayers[var49[var51]];
                                    if(null != var38 && var38.x == var45.x && var38.y == var45.y) {
                                       XGrandExchangeOffer.generateMenuActionsForPlayer(var38, var49[var51], var33, var23);
                                    }
                                 }
                              }

                              World.method627(var45.composition, var25, var33, var23);
                           }

                           if(var24 == 0) {
                              Player var46 = Client.cachedPlayers[var25];
                              if(var46 == null) {
                                 continue;
                              }

                              if((var46.x & 127) == 64 && (var46.y & 127) == 64) {
                                 for(var37 = 0; var37 < Client.field319; ++var37) {
                                    var28 = Client.cachedNPCs[Client.field320[var37]];
                                    if(null != var28 && var28.composition.field902 == 1 && var46.x == var28.x && var46.y == var28.y) {
                                       World.method627(var28.composition, Client.field320[var37], var33, var23);
                                    }
                                 }

                                 var37 = class34.field760;
                                 var49 = class34.field755;

                                 for(var51 = 0; var51 < var37; ++var51) {
                                    var38 = Client.cachedPlayers[var49[var51]];
                                    if(null != var38 && var38 != var46 && var38.x == var46.x && var38.y == var46.y) {
                                       XGrandExchangeOffer.generateMenuActionsForPlayer(var38, var49[var51], var33, var23);
                                    }
                                 }
                              }

                              if(var25 != Client.field411) {
                                 XGrandExchangeOffer.generateMenuActionsForPlayer(var46, var25, var33, var23);
                              } else {
                                 var18 = var21;
                              }
                           }

                           if(var24 == 3) {
                              Deque var47 = Client.groundItemDeque[FrameMap.plane][var33][var23];
                              if(var47 != null) {
                                 for(Item var48 = (Item)var47.method3867(); null != var48; var48 = (Item)var47.method3853()) {
                                    ItemComposition var50 = MessageNode.getItemDefinition(var48.id);
                                    if(Client.field432 == 1) {
                                       XItemContainer.addMenuEntry("Use", Client.field433 + " " + "->" + " " + class154.method3185(16748608) + var50.name, 16, var48.id, var33, var23);
                                    } else if(Client.field404) {
                                       if((class171.field2749 & 1) == 1) {
                                          XItemContainer.addMenuEntry(Client.field437, Client.field438 + " " + "->" + " " + class154.method3185(16748608) + var50.name, 17, var48.id, var33, var23);
                                       }
                                    } else {
                                       String[] var39 = var50.groundActions;
                                       if(Client.field293) {
                                          var39 = class75.method1607(var39);
                                       }

                                       for(int var30 = 4; var30 >= 0; --var30) {
                                          if(var39 != null && var39[var30] != null) {
                                             byte var31 = 0;
                                             if(var30 == 0) {
                                                var31 = 18;
                                             }

                                             if(var30 == 1) {
                                                var31 = 19;
                                             }

                                             if(var30 == 2) {
                                                var31 = 20;
                                             }

                                             if(var30 == 3) {
                                                var31 = 21;
                                             }

                                             if(var30 == 4) {
                                                var31 = 22;
                                             }

                                             XItemContainer.addMenuEntry(var39[var30], class154.method3185(16748608) + var50.name, var31, var48.id, var33, var23);
                                          } else if(var30 == 2) {
                                             XItemContainer.addMenuEntry("Take", class154.method3185(16748608) + var50.name, 20, var48.id, var33, var23);
                                          }
                                       }

                                       XItemContainer.addMenuEntry("Examine", class154.method3185(16748608) + var50.name, 1004, var48.id, var33, var23);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var18 != -1) {
                        var43 = var18 & 127;
                        var21 = var18 >> 7 & 127;
                        Player var44 = Client.cachedPlayers[Client.field411];
                        XGrandExchangeOffer.generateMenuActionsForPlayer(var44, Client.field411, var43, var21);
                     }
                  }
               } else if(var9.contentType == 1338) {
                  ChatLineBuffer.method640(var9, var10, var11);
               } else {
                  if(!Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     Client.method508(var9, var16 - var10, var17 - var11);
                  }

                  if(var9.type == 0) {
                     if(!var9.field2809 && class34.method712(var9) && ItemComposition.field1180 != var9) {
                        continue;
                     }

                     method2496(var0, var9.id, var12, var13, var14, var15, var10 - var9.itemId, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method2496(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.itemId, var11 - var9.scrollY);
                     }

                     WidgetNode var34 = (WidgetNode)Client.componentTable.method3830((long)var9.id);
                     if(var34 != null) {
                        if(var34.field53 == 0 && class143.field2204 >= var12 && class143.field2210 >= var13 && class143.field2204 < var14 && class143.field2210 < var15 && !Client.isMenuOpen && !Client.field449) {
                           for(class0 var40 = (class0)Client.field478.method3850(); null != var40; var40 = (class0)Client.field478.method3852()) {
                              if(var40.field14) {
                                 var40.unlink();
                                 var40.field7.field2935 = false;
                              }
                           }

                           if(class14.field211 == 0) {
                              Client.field494 = null;
                              Client.field453 = null;
                           }

                           if(!Client.isMenuOpen) {
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.menuOptionCount = 1;
                           }
                        }

                        var19 = var34.id;
                        if(class175.method3419(var19)) {
                           method2496(Widget.widgets[var19], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  if(var9.field2809) {
                     class0 var52;
                     if(!var9.field2943) {
                        if(var9.field2944 && class143.field2204 >= var12 && class143.field2210 >= var13 && class143.field2204 < var14 && class143.field2210 < var15) {
                           for(var52 = (class0)Client.field478.method3850(); var52 != null; var52 = (class0)Client.field478.method3852()) {
                              if(var52.field14 && var52.field8 == var52.field7.field2911) {
                                 var52.unlink();
                              }
                           }
                        }
                     } else if(class143.field2204 >= var12 && class143.field2210 >= var13 && class143.field2204 < var14 && class143.field2210 < var15) {
                        for(var52 = (class0)Client.field478.method3850(); var52 != null; var52 = (class0)Client.field478.method3852()) {
                           if(var52.field14) {
                              var52.unlink();
                              var52.field7.field2935 = false;
                           }
                        }

                        if(class14.field211 == 0) {
                           Client.field494 = null;
                           Client.field453 = null;
                        }

                        if(!Client.isMenuOpen) {
                           Client.menuOptions[0] = "Cancel";
                           Client.menuTargets[0] = "";
                           Client.menuTypes[0] = 1006;
                           Client.menuOptionCount = 1;
                        }
                     }

                     boolean var41;
                     if(class143.field2204 >= var12 && class143.field2210 >= var13 && class143.field2204 < var14 && class143.field2210 < var15) {
                        var41 = true;
                     } else {
                        var41 = false;
                     }

                     boolean var42 = false;
                     if((class143.field2203 == 1 || !class134.field2117 && class143.field2203 == 4) && var41) {
                        var42 = true;
                     }

                     boolean var20 = false;
                     if((class143.field2198 == 1 || !class134.field2117 && class143.field2198 == 4) && class143.field2211 >= var12 && class143.field2213 >= var13 && class143.field2211 < var14 && class143.field2213 < var15) {
                        var20 = true;
                     }

                     if(var20) {
                        VertexNormal.method2255(var9, class143.field2211 - var10, class143.field2213 - var11);
                     }

                     if(null != Client.field494 && var9 != Client.field494 && var41 && class26.method591(class132.method2880(var9))) {
                        Client.field456 = var9;
                     }

                     if(Client.field453 == var9) {
                        Client.field457 = true;
                        Client.field310 = var10;
                        Client.field459 = var11;
                     }

                     if(var9.field2829) {
                        class0 var32;
                        if(var41 && Client.field477 != 0 && null != var9.field2911) {
                           var32 = new class0();
                           var32.field14 = true;
                           var32.field7 = var9;
                           var32.field4 = Client.field477;
                           var32.field8 = var9.field2911;
                           Client.field478.method3844(var32);
                        }

                        if(null != Client.field494 || null != class180.field2965 || Client.isMenuOpen) {
                           var20 = false;
                           var42 = false;
                           var41 = false;
                        }

                        if(!var9.field2936 && var20) {
                           var9.field2936 = true;
                           if(null != var9.field2892) {
                              var32 = new class0();
                              var32.field14 = true;
                              var32.field7 = var9;
                              var32.field3 = class143.field2211 - var10;
                              var32.field4 = class143.field2213 - var11;
                              var32.field8 = var9.field2892;
                              Client.field478.method3844(var32);
                           }
                        }

                        if(var9.field2936 && var42 && var9.field2848 != null) {
                           var32 = new class0();
                           var32.field14 = true;
                           var32.field7 = var9;
                           var32.field3 = class143.field2204 - var10;
                           var32.field4 = class143.field2210 - var11;
                           var32.field8 = var9.field2848;
                           Client.field478.method3844(var32);
                        }

                        if(var9.field2936 && !var42) {
                           var9.field2936 = false;
                           if(var9.field2894 != null) {
                              var32 = new class0();
                              var32.field14 = true;
                              var32.field7 = var9;
                              var32.field3 = class143.field2204 - var10;
                              var32.field4 = class143.field2210 - var11;
                              var32.field8 = var9.field2894;
                              Client.field480.method3844(var32);
                           }
                        }

                        if(var42 && var9.field2913 != null) {
                           var32 = new class0();
                           var32.field14 = true;
                           var32.field7 = var9;
                           var32.field3 = class143.field2204 - var10;
                           var32.field4 = class143.field2210 - var11;
                           var32.field8 = var9.field2913;
                           Client.field478.method3844(var32);
                        }

                        if(!var9.field2935 && var41) {
                           var9.field2935 = true;
                           if(var9.field2858 != null) {
                              var32 = new class0();
                              var32.field14 = true;
                              var32.field7 = var9;
                              var32.field3 = class143.field2204 - var10;
                              var32.field4 = class143.field2210 - var11;
                              var32.field8 = var9.field2858;
                              Client.field478.method3844(var32);
                           }
                        }

                        if(var9.field2935 && var41 && null != var9.field2897) {
                           var32 = new class0();
                           var32.field14 = true;
                           var32.field7 = var9;
                           var32.field3 = class143.field2204 - var10;
                           var32.field4 = class143.field2210 - var11;
                           var32.field8 = var9.field2897;
                           Client.field478.method3844(var32);
                        }

                        if(var9.field2935 && !var41) {
                           var9.field2935 = false;
                           if(var9.field2898 != null) {
                              var32 = new class0();
                              var32.field14 = true;
                              var32.field7 = var9;
                              var32.field3 = class143.field2204 - var10;
                              var32.field4 = class143.field2210 - var11;
                              var32.field8 = var9.field2898;
                              Client.field480.method3844(var32);
                           }
                        }

                        if(var9.field2815 != null) {
                           var32 = new class0();
                           var32.field7 = var9;
                           var32.field8 = var9.field2815;
                           Client.field479.method3844(var32);
                        }

                        class0 var35;
                        if(var9.field2903 != null && Client.field543 > var9.field2938) {
                           if(var9.field2863 != null && Client.field543 - var9.field2938 <= 32) {
                              label1206:
                              for(var21 = var9.field2938; var21 < Client.field543; ++var21) {
                                 var33 = Client.field339[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2863.length; ++var23) {
                                    if(var9.field2863[var23] == var33) {
                                       var35 = new class0();
                                       var35.field7 = var9;
                                       var35.field8 = var9.field2903;
                                       Client.field478.method3844(var35);
                                       break label1206;
                                    }
                                 }
                              }
                           } else {
                              var32 = new class0();
                              var32.field7 = var9;
                              var32.field8 = var9.field2903;
                              Client.field478.method3844(var32);
                           }

                           var9.field2938 = Client.field543;
                        }

                        if(var9.field2876 != null && Client.field557 > var9.field2939) {
                           if(null != var9.field2906 && Client.field557 - var9.field2939 <= 32) {
                              label1182:
                              for(var21 = var9.field2939; var21 < Client.field557; ++var21) {
                                 var33 = Client.field467[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2906.length; ++var23) {
                                    if(var33 == var9.field2906[var23]) {
                                       var35 = new class0();
                                       var35.field7 = var9;
                                       var35.field8 = var9.field2876;
                                       Client.field478.method3844(var35);
                                       break label1182;
                                    }
                                 }
                              }
                           } else {
                              var32 = new class0();
                              var32.field7 = var9;
                              var32.field8 = var9.field2876;
                              Client.field478.method3844(var32);
                           }

                           var9.field2939 = Client.field557;
                        }

                        if(var9.field2907 != null && Client.field458 > var9.field2940) {
                           if(null != var9.field2908 && Client.field458 - var9.field2940 <= 32) {
                              label1158:
                              for(var21 = var9.field2940; var21 < Client.field458; ++var21) {
                                 var33 = Client.field342[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2908.length; ++var23) {
                                    if(var9.field2908[var23] == var33) {
                                       var35 = new class0();
                                       var35.field7 = var9;
                                       var35.field8 = var9.field2907;
                                       Client.field478.method3844(var35);
                                       break label1158;
                                    }
                                 }
                              }
                           } else {
                              var32 = new class0();
                              var32.field7 = var9;
                              var32.field8 = var9.field2907;
                              Client.field478.method3844(var32);
                           }

                           var9.field2940 = Client.field458;
                        }

                        if(Client.field471 > var9.field2803 && null != var9.field2912) {
                           var32 = new class0();
                           var32.field7 = var9;
                           var32.field8 = var9.field2912;
                           Client.field478.method3844(var32);
                        }

                        if(Client.field472 > var9.field2803 && var9.field2914 != null) {
                           var32 = new class0();
                           var32.field7 = var9;
                           var32.field8 = var9.field2914;
                           Client.field478.method3844(var32);
                        }

                        if(Client.field534 > var9.field2803 && null != var9.field2915) {
                           var32 = new class0();
                           var32.field7 = var9;
                           var32.field8 = var9.field2915;
                           Client.field478.method3844(var32);
                        }

                        if(Client.field474 > var9.field2803 && var9.field2917 != null) {
                           var32 = new class0();
                           var32.field7 = var9;
                           var32.field8 = var9.field2917;
                           Client.field478.method3844(var32);
                        }

                        if(Client.field496 > var9.field2803 && null != var9.field2921) {
                           var32 = new class0();
                           var32.field7 = var9;
                           var32.field8 = var9.field2921;
                           Client.field478.method3844(var32);
                        }

                        if(Client.field476 > var9.field2803 && var9.field2888 != null) {
                           var32 = new class0();
                           var32.field7 = var9;
                           var32.field8 = var9.field2888;
                           Client.field478.method3844(var32);
                        }

                        var9.field2803 = Client.field532;
                        if(null != var9.field2847) {
                           for(var21 = 0; var21 < Client.field528; ++var21) {
                              class0 var22 = new class0();
                              var22.field7 = var9;
                              var22.field2 = Client.field504[var21];
                              var22.field1 = Client.field445[var21];
                              var22.field8 = var9.field2847;
                              Client.field478.method3844(var22);
                           }
                        }
                     }
                  }

                  if(!var9.field2809 && null == Client.field494 && null == class180.field2965 && !Client.isMenuOpen) {
                     if((var9.field2865 >= 0 || var9.field2890 != 0) && class143.field2204 >= var12 && class143.field2210 >= var13 && class143.field2204 < var14 && class143.field2210 < var15) {
                        if(var9.field2865 >= 0) {
                           ItemComposition.field1180 = var0[var9.field2865];
                        } else {
                           ItemComposition.field1180 = var9;
                        }
                     }

                     if(var9.type == 8 && class143.field2204 >= var12 && class143.field2210 >= var13 && class143.field2204 < var14 && class143.field2210 < var15) {
                        BufferProvider.field1434 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        var18 = var10 + var9.width;
                        var19 = var9.height;
                        var43 = var9.scrollHeight;
                        var21 = class143.field2204;
                        var33 = class143.field2210;
                        if(Client.field429) {
                           Client.field364 = 32;
                        } else {
                           Client.field364 = 0;
                        }

                        Client.field429 = false;
                        if(class143.field2203 == 1 || !class134.field2117 && class143.field2203 == 4) {
                           if(var21 >= var18 && var21 < 16 + var18 && var33 >= var11 && var33 < 16 + var11) {
                              var9.scrollY -= 4;
                              class75.method1606(var9);
                           } else if(var21 >= var18 && var21 < var18 + 16 && var33 >= var19 + var11 - 16 && var33 < var19 + var11) {
                              var9.scrollY += 4;
                              class75.method1606(var9);
                           } else if(var21 >= var18 - Client.field364 && var21 < Client.field364 + 16 + var18 && var33 >= var11 + 16 && var33 < var11 + var19 - 16) {
                              var23 = var19 * (var19 - 32) / var43;
                              if(var23 < 8) {
                                 var23 = 8;
                              }

                              var24 = var33 - var11 - 16 - var23 / 2;
                              var25 = var19 - 32 - var23;
                              var9.scrollY = var24 * (var43 - var19) / var25;
                              class75.method1606(var9);
                              Client.field429 = true;
                           }
                        }

                        if(Client.field477 != 0) {
                           var23 = var9.width;
                           if(var21 >= var18 - var23 && var33 >= var11 && var21 < 16 + var18 && var33 <= var11 + var19) {
                              var9.scrollY += Client.field477 * 45;
                              class75.method1606(var9);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LModIcon;I)V",
      garbageValue = "-1822970497"
   )
   static final void method2497(ModIcon var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class130.field2098.length; ++var2) {
         class130.field2098[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class130.field2098[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = (var3 << 7) + var4;
               World.field659[var5] = (class130.field2098[var5 - 1] + class130.field2098[1 + var5] + class130.field2098[var5 - 128] + class130.field2098[128 + var5]) / 4;
            }
         }

         int[] var8 = class130.field2098;
         class130.field2098 = World.field659;
         World.field659 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = 16 + var4 + var0.offsetX;
                  int var6 = 16 + var3 + var0.offsetY;
                  int var7 = (var6 << 7) + var5;
                  class130.field2098[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([LWorld;II[I[II)V",
      garbageValue = "-75677981"
   )
   static void method2498(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var1 + var2) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method593()?1:0;
                     var12 = var8.method593()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method593()?1:0;
                     var12 = var8.method593()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method2498(var0, var1, var6, var3, var4);
         method2498(var0, 1 + var6, var2, var3, var4);
      }

   }
}
