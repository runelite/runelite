import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class37 {
   @ObfuscatedName("il")
   static Widget field507;

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "502622789"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[Sequence.plane][var0][var1];
      if(var2 == null) {
         class46.region.method2728(Sequence.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.method3660(); var6 != null; var6 = (Item)var2.method3661()) {
            ItemComposition var7 = class51.getItemDefinition(var6.id);
            long var10 = (long)var7.price;
            if(var7.isStackable == 1) {
               var10 *= (long)(var6.quantity + 1);
            }

            if(var10 > var3) {
               var3 = var10;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class46.region.method2728(Sequence.plane, var0, var1);
         } else {
            var2.method3686(var5);
            Item var12 = null;
            Item var8 = null;

            for(var6 = (Item)var2.method3660(); var6 != null; var6 = (Item)var2.method3661()) {
               if(var6.id != var5.id) {
                  if(var12 == null) {
                     var12 = var6;
                  }

                  if(var12.id != var6.id && var8 == null) {
                     var8 = var6;
                  }
               }
            }

            int var9 = var0 + (var1 << 7) + 1610612736;
            class46.region.method2716(Sequence.plane, var0, var1, Ignore.method1119(var0 * 128 + 64, var1 * 128 + 64, Sequence.plane), var5, var9, var12, var8);
         }
      }
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIB)V",
      garbageValue = "101"
   )
   static final void method510(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2722 || class43.method626(var9) != 0 || Client.field1084 == var9 || var9.contentType == 1338) && var1 == var9.parentId && (!var9.hasScript || !class149.method2945(var9))) {
            int var10 = var9.relativeX + var6;
            int var11 = var7 + var9.relativeY;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var33;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.type == 9) {
               var16 = var10;
               var17 = var11;
               int var18 = var9.width + var10;
               var33 = var9.height + var11;
               if(var18 < var10) {
                  var16 = var18;
                  var18 = var10;
               }

               if(var33 < var11) {
                  var17 = var33;
                  var33 = var11;
               }

               ++var18;
               ++var33;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var18 < var4?var18:var4;
               var15 = var33 < var5?var33:var5;
            } else {
               var16 = var10 + var9.width;
               var17 = var9.height + var11;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(Client.field961 == var9) {
               Client.field1071 = true;
               Client.field1072 = var10;
               Client.field1073 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = class59.field721;
               var17 = class59.field722;
               if(class59.field727 != 0) {
                  var16 = class59.field717;
                  var17 = class59.field729;
               }

               boolean var44 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
               int var22;
               int var23;
               int var24;
               int var25;
               int var26;
               int var28;
               int var47;
               int var56;
               if(var9.contentType == 1337) {
                  if(!Client.field898 && !Client.isMenuOpen && var44) {
                     if(Client.field1043 == 0 && !Client.field1045) {
                        class176.addMenuEntry("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var33 = -1;
                     var47 = -1;

                     for(var56 = 0; var56 < class134.field1986; ++var56) {
                        var22 = class134.field1987[var56];
                        var23 = var22 & 127;
                        var24 = var22 >> 7 & 127;
                        var25 = var22 >> 29 & 3;
                        var26 = var22 >> 14 & 32767;
                        if(var22 != var47) {
                           var47 = var22;
                           if(var25 == 2 && class46.region.method2896(Sequence.plane, var23, var24, var22) >= 0) {
                              ObjectComposition var27 = class43.getObjectDefinition(var26);
                              if(var27.impostorIds != null) {
                                 var27 = var27.getImpostor();
                              }

                              if(var27 == null) {
                                 continue;
                              }

                              if(Client.field1043 == 1) {
                                 class176.addMenuEntry("Use", Client.field1142 + " " + "->" + " " + class82.method1610('\uffff') + var27.name, 1, var22, var23, var24);
                              } else if(Client.field1045) {
                                 if((class24.field364 & 4) == 4) {
                                    class176.addMenuEntry(Client.field1048, Client.field1049 + " " + "->" + " " + class82.method1610('\uffff') + var27.name, 2, var22, var23, var24);
                                 }
                              } else {
                                 String[] var34 = var27.actions;
                                 if(Client.field994) {
                                    var34 = class9.method37(var34);
                                 }

                                 if(var34 != null) {
                                    for(int var37 = 4; var37 >= 0; --var37) {
                                       if(var34[var37] != null) {
                                          short var30 = 0;
                                          if(var37 == 0) {
                                             var30 = 3;
                                          }

                                          if(var37 == 1) {
                                             var30 = 4;
                                          }

                                          if(var37 == 2) {
                                             var30 = 5;
                                          }

                                          if(var37 == 3) {
                                             var30 = 6;
                                          }

                                          if(var37 == 4) {
                                             var30 = 1001;
                                          }

                                          class176.addMenuEntry(var34[var37], class82.method1610('\uffff') + var27.name, var30, var22, var23, var24);
                                       }
                                    }
                                 }

                                 class176.addMenuEntry("Examine", class82.method1610('\uffff') + var27.name, 1002, var27.field3436 << 14, var23, var24);
                              }
                           }

                           NPC var29;
                           Player var31;
                           int[] var51;
                           int var53;
                           if(var25 == 1) {
                              NPC var48 = Client.cachedNPCs[var26];
                              if(var48 == null) {
                                 continue;
                              }

                              if(var48.composition.field3548 == 1 && (var48.x & 127) == 64 && (var48.y & 127) == 64) {
                                 for(var28 = 0; var28 < Client.field928; ++var28) {
                                    var29 = Client.cachedNPCs[Client.field1013[var28]];
                                    if(var29 != null && var48 != var29 && var29.composition.field3548 == 1 && var48.x == var29.x && var48.y == var29.y) {
                                       class174.method3416(var29.composition, Client.field1013[var28], var23, var24);
                                    }
                                 }

                                 var28 = class96.field1489;
                                 var51 = class96.field1496;

                                 for(var53 = 0; var53 < var28; ++var53) {
                                    var31 = Client.cachedPlayers[var51[var53]];
                                    if(var31 != null && var48.x == var31.x && var31.y == var48.y) {
                                       class50.method766(var31, var51[var53], var23, var24);
                                    }
                                 }
                              }

                              class174.method3416(var48.composition, var26, var23, var24);
                           }

                           if(var25 == 0) {
                              Player var49 = Client.cachedPlayers[var26];
                              if(var49 == null) {
                                 continue;
                              }

                              if((var49.x & 127) == 64 && (var49.y & 127) == 64) {
                                 for(var28 = 0; var28 < Client.field928; ++var28) {
                                    var29 = Client.cachedNPCs[Client.field1013[var28]];
                                    if(var29 != null && var29.composition.field3548 == 1 && var29.x == var49.x && var49.y == var29.y) {
                                       class174.method3416(var29.composition, Client.field1013[var28], var23, var24);
                                    }
                                 }

                                 var28 = class96.field1489;
                                 var51 = class96.field1496;

                                 for(var53 = 0; var53 < var28; ++var53) {
                                    var31 = Client.cachedPlayers[var51[var53]];
                                    if(var31 != null && var31 != var49 && var49.x == var31.x && var31.y == var49.y) {
                                       class50.method766(var31, var51[var53], var23, var24);
                                    }
                                 }
                              }

                              if(Client.field1106 != var26) {
                                 class50.method766(var49, var26, var23, var24);
                              } else {
                                 var33 = var22;
                              }
                           }

                           if(var25 == 3) {
                              Deque var50 = Client.groundItemDeque[Sequence.plane][var23][var24];
                              if(var50 != null) {
                                 for(Item var55 = (Item)var50.method3666(); var55 != null; var55 = (Item)var50.method3662()) {
                                    ItemComposition var52 = class51.getItemDefinition(var55.id);
                                    if(Client.field1043 == 1) {
                                       class176.addMenuEntry("Use", Client.field1142 + " " + "->" + " " + class82.method1610(16748608) + var52.name, 16, var55.id, var23, var24);
                                    } else if(Client.field1045) {
                                       if((class24.field364 & 1) == 1) {
                                          class176.addMenuEntry(Client.field1048, Client.field1049 + " " + "->" + " " + class82.method1610(16748608) + var52.name, 17, var55.id, var23, var24);
                                       }
                                    } else {
                                       String[] var39 = var52.groundActions;
                                       if(Client.field994) {
                                          var39 = class9.method37(var39);
                                       }

                                       for(int var38 = 4; var38 >= 0; --var38) {
                                          if(var39 != null && var39[var38] != null) {
                                             byte var32 = 0;
                                             if(var38 == 0) {
                                                var32 = 18;
                                             }

                                             if(var38 == 1) {
                                                var32 = 19;
                                             }

                                             if(var38 == 2) {
                                                var32 = 20;
                                             }

                                             if(var38 == 3) {
                                                var32 = 21;
                                             }

                                             if(var38 == 4) {
                                                var32 = 22;
                                             }

                                             class176.addMenuEntry(var39[var38], class82.method1610(16748608) + var52.name, var32, var55.id, var23, var24);
                                          } else if(var38 == 2) {
                                             class176.addMenuEntry("Take", class82.method1610(16748608) + var52.name, 20, var55.id, var23, var24);
                                          }
                                       }

                                       class176.addMenuEntry("Examine", class82.method1610(16748608) + var52.name, 1004, var55.id, var23, var24);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var33 != -1) {
                        var56 = var33 & 127;
                        var22 = var33 >> 7 & 127;
                        Player var40 = Client.cachedPlayers[Client.field1106];
                        class50.method766(var40, Client.field1106, var56, var22);
                     }
                  }
               } else if(var9.contentType == 1338) {
                  if((Client.field1017 == 0 || Client.field1017 == 3) && (class59.field727 == 1 || !class149.field2178 && class59.field727 == 4)) {
                     class210 var46 = var9.method4067(true);
                     if(var46 != null) {
                        var47 = class59.field717 - var10;
                        var56 = class59.field729 - var11;
                        if(var46.method3980(var47, var56)) {
                           var47 -= var46.field2591 / 2;
                           var56 -= var46.field2590 / 2;
                           var22 = Client.mapScale + Client.mapAngle & 2047;
                           var23 = class136.SINE[var22];
                           var24 = class136.COSINE[var22];
                           var23 = var23 * (Client.mapScaleDelta + 256) >> 8;
                           var24 = (Client.mapScaleDelta + 256) * var24 >> 8;
                           var25 = var47 * var24 + var56 * var23 >> 11;
                           var26 = var24 * var56 - var47 * var23 >> 11;
                           int var41 = XGrandExchangeOffer.localPlayer.x + var25 >> 7;
                           var28 = XGrandExchangeOffer.localPlayer.y - var26 >> 7;
                           Client.secretPacketBuffer1.putOpcode(253);
                           Client.secretPacketBuffer1.putByte(18);
                           Client.secretPacketBuffer1.putShort(var41 + class166.baseX);
                           Client.secretPacketBuffer1.method3225(class50.field624[82]?(class50.field624[81]?2:1):0);
                           Client.secretPacketBuffer1.putShort(var28 + class146.baseY);
                           Client.secretPacketBuffer1.putByte(var47);
                           Client.secretPacketBuffer1.putByte(var56);
                           Client.secretPacketBuffer1.putShort(Client.mapAngle);
                           Client.secretPacketBuffer1.putByte(57);
                           Client.secretPacketBuffer1.putByte(Client.mapScale);
                           Client.secretPacketBuffer1.putByte(Client.mapScaleDelta);
                           Client.secretPacketBuffer1.putByte(89);
                           Client.secretPacketBuffer1.putShort(XGrandExchangeOffer.localPlayer.x);
                           Client.secretPacketBuffer1.putShort(XGrandExchangeOffer.localPlayer.y);
                           Client.secretPacketBuffer1.putByte(63);
                           Client.flagX = var41;
                           Client.flagY = var28;
                        }
                     }
                  }
               } else {
                  if(var9.contentType == 1400) {
                     class83.field1325.method5256(class59.field721, class59.field722, var44, var10, var11, var9.width, var9.height);
                  }

                  if(!Client.isMenuOpen && var44) {
                     if(var9.contentType == 1400) {
                        class83.field1325.method5397(var10, var11, var9.width, var9.height, var16, var17);
                     } else {
                        class217.method4120(var9, var16 - var10, var17 - var11);
                     }
                  }

                  if(var9.type == 0) {
                     if(!var9.hasScript && class149.method2945(var9) && var9 != Player.field868) {
                        continue;
                     }

                     method510(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method510(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var19 = (WidgetNode)Client.componentTable.method3615((long)var9.id);
                     if(var19 != null) {
                        if(var19.field810 == 0 && class59.field721 >= var12 && class59.field722 >= var13 && class59.field721 < var14 && class59.field722 < var15 && !Client.isMenuOpen && !Client.field1060) {
                           for(class69 var43 = (class69)Client.field1089.method3660(); var43 != null; var43 = (class69)Client.field1089.method3661()) {
                              if(var43.field821) {
                                 var43.unlink();
                                 var43.field816.field2767 = false;
                              }
                           }

                           if(FaceNormal.field2120 == 0) {
                              Client.field961 = null;
                              Client.field1084 = null;
                           }

                           if(!Client.isMenuOpen) {
                              IndexDataBase.method4272();
                           }
                        }

                        RSSocket.method3039(var19.id, var12, var13, var14, var15, var10, var11);
                     }
                  }

                  if(var9.hasScript) {
                     class69 var45;
                     if(!var9.field2775) {
                        if(var9.field2776 && class59.field721 >= var12 && class59.field722 >= var13 && class59.field721 < var14 && class59.field722 < var15) {
                           for(var45 = (class69)Client.field1089.method3660(); var45 != null; var45 = (class69)Client.field1089.method3661()) {
                              if(var45.field821 && var45.field816.field2743 == var45.field826) {
                                 var45.unlink();
                              }
                           }
                        }
                     } else if(class59.field721 >= var12 && class59.field722 >= var13 && class59.field721 < var14 && class59.field722 < var15) {
                        for(var45 = (class69)Client.field1089.method3660(); var45 != null; var45 = (class69)Client.field1089.method3661()) {
                           if(var45.field821) {
                              var45.unlink();
                              var45.field816.field2767 = false;
                           }
                        }

                        if(FaceNormal.field2120 == 0) {
                           Client.field961 = null;
                           Client.field1084 = null;
                        }

                        if(!Client.isMenuOpen) {
                           Client.menuOptions[0] = "Cancel";
                           Client.menuTargets[0] = "";
                           Client.menuTypes[0] = 1006;
                           Client.menuOptionCount = 1;
                        }
                     }

                     if(class59.field721 >= var12 && class59.field722 >= var13 && class59.field721 < var14 && class59.field722 < var15) {
                        var44 = true;
                     } else {
                        var44 = false;
                     }

                     boolean var54 = false;
                     if((class59.field732 == 1 || !class149.field2178 && class59.field732 == 4) && var44) {
                        var54 = true;
                     }

                     boolean var20 = false;
                     if((class59.field727 == 1 || !class149.field2178 && class59.field727 == 4) && class59.field717 >= var12 && class59.field729 >= var13 && class59.field717 < var14 && class59.field729 < var15) {
                        var20 = true;
                     }

                     if(var20) {
                        Ignore.method1120(var9, class59.field717 - var10, class59.field729 - var11);
                     }

                     if(var9.contentType == 1400) {
                        class83.field1325.method5359(class59.field721, class59.field722, var44 & var54);
                     }

                     if(Client.field961 != null && var9 != Client.field961 && var44) {
                        var22 = class43.method626(var9);
                        boolean var36 = (var22 >> 20 & 1) != 0;
                        if(var36) {
                           Client.field1067 = var9;
                        }
                     }

                     if(var9 == Client.field1084) {
                        Client.field1068 = true;
                        Client.field1034 = var10;
                        Client.field989 = var11;
                     }

                     if(var9.field2722) {
                        class69 var21;
                        if(var44 && Client.field1088 != 0 && var9.field2743 != null) {
                           var21 = new class69();
                           var21.field821 = true;
                           var21.field816 = var9;
                           var21.field819 = Client.field1088;
                           var21.field826 = var9.field2743;
                           Client.field1089.method3655(var21);
                        }

                        if(Client.field961 != null || class20.field323 != null || Client.isMenuOpen) {
                           var20 = false;
                           var54 = false;
                           var44 = false;
                        }

                        if(!var9.field2758 && var20) {
                           var9.field2758 = true;
                           if(var9.field2724 != null) {
                              var21 = new class69();
                              var21.field821 = true;
                              var21.field816 = var9;
                              var21.field817 = class59.field717 - var10;
                              var21.field819 = class59.field729 - var11;
                              var21.field826 = var9.field2724;
                              Client.field1089.method3655(var21);
                           }
                        }

                        if(var9.field2758 && var54 && var9.field2725 != null) {
                           var21 = new class69();
                           var21.field821 = true;
                           var21.field816 = var9;
                           var21.field817 = class59.field721 - var10;
                           var21.field819 = class59.field722 - var11;
                           var21.field826 = var9.field2725;
                           Client.field1089.method3655(var21);
                        }

                        if(var9.field2758 && !var54) {
                           var9.field2758 = false;
                           if(var9.field2726 != null) {
                              var21 = new class69();
                              var21.field821 = true;
                              var21.field816 = var9;
                              var21.field817 = class59.field721 - var10;
                              var21.field819 = class59.field722 - var11;
                              var21.field826 = var9.field2726;
                              Client.field974.method3655(var21);
                           }
                        }

                        if(var54 && var9.field2727 != null) {
                           var21 = new class69();
                           var21.field821 = true;
                           var21.field816 = var9;
                           var21.field817 = class59.field721 - var10;
                           var21.field819 = class59.field722 - var11;
                           var21.field826 = var9.field2727;
                           Client.field1089.method3655(var21);
                        }

                        if(!var9.field2767 && var44) {
                           var9.field2767 = true;
                           if(var9.field2683 != null) {
                              var21 = new class69();
                              var21.field821 = true;
                              var21.field816 = var9;
                              var21.field817 = class59.field721 - var10;
                              var21.field819 = class59.field722 - var11;
                              var21.field826 = var9.field2683;
                              Client.field1089.method3655(var21);
                           }
                        }

                        if(var9.field2767 && var44 && var9.field2768 != null) {
                           var21 = new class69();
                           var21.field821 = true;
                           var21.field816 = var9;
                           var21.field817 = class59.field721 - var10;
                           var21.field819 = class59.field722 - var11;
                           var21.field826 = var9.field2768;
                           Client.field1089.method3655(var21);
                        }

                        if(var9.field2767 && !var44) {
                           var9.field2767 = false;
                           if(var9.field2730 != null) {
                              var21 = new class69();
                              var21.field821 = true;
                              var21.field816 = var9;
                              var21.field817 = class59.field721 - var10;
                              var21.field819 = class59.field722 - var11;
                              var21.field826 = var9.field2730;
                              Client.field974.method3655(var21);
                           }
                        }

                        if(var9.field2741 != null) {
                           var21 = new class69();
                           var21.field816 = var9;
                           var21.field826 = var9.field2741;
                           Client.field1114.method3655(var21);
                        }

                        class69 var35;
                        if(var9.field2708 != null && Client.field1145 > var9.field2688) {
                           if(var9.field2766 != null && Client.field1145 - var9.field2688 <= 32) {
                              label1257:
                              for(var56 = var9.field2688; var56 < Client.field1145; ++var56) {
                                 var22 = Client.field955[var56 & 31];

                                 for(var23 = 0; var23 < var9.field2766.length; ++var23) {
                                    if(var22 == var9.field2766[var23]) {
                                       var35 = new class69();
                                       var35.field816 = var9;
                                       var35.field826 = var9.field2708;
                                       Client.field1089.method3655(var35);
                                       break label1257;
                                    }
                                 }
                              }
                           } else {
                              var21 = new class69();
                              var21.field816 = var9;
                              var21.field826 = var9.field2708;
                              Client.field1089.method3655(var21);
                           }

                           var9.field2688 = Client.field1145;
                        }

                        if(var9.field2764 != null && Client.field1079 > var9.field2771) {
                           if(var9.field2738 != null && Client.field1079 - var9.field2771 <= 32) {
                              label1233:
                              for(var56 = var9.field2771; var56 < Client.field1079; ++var56) {
                                 var22 = Client.field1051[var56 & 31];

                                 for(var23 = 0; var23 < var9.field2738.length; ++var23) {
                                    if(var22 == var9.field2738[var23]) {
                                       var35 = new class69();
                                       var35.field816 = var9;
                                       var35.field826 = var9.field2764;
                                       Client.field1089.method3655(var35);
                                       break label1233;
                                    }
                                 }
                              }
                           } else {
                              var21 = new class69();
                              var21.field816 = var9;
                              var21.field826 = var9.field2764;
                              Client.field1089.method3655(var21);
                           }

                           var9.field2771 = Client.field1079;
                        }

                        if(var9.field2632 != null && Client.field1081 > var9.field2693) {
                           if(var9.field2740 != null && Client.field1081 - var9.field2693 <= 32) {
                              label1209:
                              for(var56 = var9.field2693; var56 < Client.field1081; ++var56) {
                                 var22 = Client.field1080[var56 & 31];

                                 for(var23 = 0; var23 < var9.field2740.length; ++var23) {
                                    if(var22 == var9.field2740[var23]) {
                                       var35 = new class69();
                                       var35.field816 = var9;
                                       var35.field826 = var9.field2632;
                                       Client.field1089.method3655(var35);
                                       break label1209;
                                    }
                                 }
                              }
                           } else {
                              var21 = new class69();
                              var21.field816 = var9;
                              var21.field826 = var9.field2632;
                              Client.field1089.method3655(var21);
                           }

                           var9.field2693 = Client.field1081;
                        }

                        if(Client.field1082 > var9.field2769 && var9.field2650 != null) {
                           var21 = new class69();
                           var21.field816 = var9;
                           var21.field826 = var9.field2650;
                           Client.field1089.method3655(var21);
                        }

                        if(Client.field1083 > var9.field2769 && var9.field2680 != null) {
                           var21 = new class69();
                           var21.field816 = var9;
                           var21.field826 = var9.field2680;
                           Client.field1089.method3655(var21);
                        }

                        if(Client.field1126 > var9.field2769 && var9.field2747 != null) {
                           var21 = new class69();
                           var21.field816 = var9;
                           var21.field826 = var9.field2747;
                           Client.field1089.method3655(var21);
                        }

                        if(Client.field1085 > var9.field2769 && var9.field2717 != null) {
                           var21 = new class69();
                           var21.field816 = var9;
                           var21.field826 = var9.field2717;
                           Client.field1089.method3655(var21);
                        }

                        if(Client.field1086 > var9.field2769 && var9.field2753 != null) {
                           var21 = new class69();
                           var21.field816 = var9;
                           var21.field826 = var9.field2753;
                           Client.field1089.method3655(var21);
                        }

                        if(Client.field1053 > var9.field2769 && var9.field2748 != null) {
                           var21 = new class69();
                           var21.field816 = var9;
                           var21.field826 = var9.field2748;
                           Client.field1089.method3655(var21);
                        }

                        var9.field2769 = Client.field1075;
                        if(var9.field2745 != null) {
                           for(var56 = 0; var56 < Client.field1111; ++var56) {
                              class69 var42 = new class69();
                              var42.field816 = var9;
                              var42.field822 = Client.field1113[var56];
                              var42.field818 = Client.field1112[var56];
                              var42.field826 = var9.field2745;
                              Client.field1089.method3655(var42);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && Client.field961 == null && class20.field323 == null && !Client.isMenuOpen) {
                     if((var9.field2690 >= 0 || var9.field2706 != 0) && class59.field721 >= var12 && class59.field722 >= var13 && class59.field721 < var14 && class59.field722 < var15) {
                        if(var9.field2690 >= 0) {
                           Player.field868 = var0[var9.field2690];
                        } else {
                           Player.field868 = var9;
                        }
                     }

                     if(var9.type == 8 && class59.field721 >= var12 && class59.field722 >= var13 && class59.field721 < var14 && class59.field722 < var15) {
                        NPCComposition.field3579 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        var33 = var10 + var9.width;
                        var47 = var9.height;
                        var56 = var9.scrollHeight;
                        var22 = class59.field721;
                        var23 = class59.field722;
                        if(Client.field971) {
                           Client.field972 = 32;
                        } else {
                           Client.field972 = 0;
                        }

                        Client.field971 = false;
                        if(class59.field732 == 1 || !class149.field2178 && class59.field732 == 4) {
                           if(var22 >= var33 && var22 < var33 + 16 && var23 >= var11 && var23 < var11 + 16) {
                              var9.scrollY -= 4;
                              class219.method4130(var9);
                           } else if(var22 >= var33 && var22 < var33 + 16 && var23 >= var11 + var47 - 16 && var23 < var47 + var11) {
                              var9.scrollY += 4;
                              class219.method4130(var9);
                           } else if(var22 >= var33 - Client.field972 && var22 < Client.field972 + var33 + 16 && var23 >= var11 + 16 && var23 < var47 + var11 - 16) {
                              var24 = var47 * (var47 - 32) / var56;
                              if(var24 < 8) {
                                 var24 = 8;
                              }

                              var25 = var23 - var11 - 16 - var24 / 2;
                              var26 = var47 - 32 - var24;
                              var9.scrollY = (var56 - var47) * var25 / var26;
                              class219.method4130(var9);
                              Client.field971 = true;
                           }
                        }

                        if(Client.field1088 != 0) {
                           var24 = var9.width;
                           if(var22 >= var33 - var24 && var23 >= var11 && var22 < var33 + 16 && var23 <= var11 + var47) {
                              var9.scrollY += Client.field1088 * 45;
                              class219.method4130(var9);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIZB)Ljava/lang/String;",
      garbageValue = "-113"
   )
   public static String method511(int var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         if(var0 < 0) {
            return Integer.toString(var0, var1);
         } else {
            int var3 = 2;

            for(int var4 = var0 / var1; var4 != 0; ++var3) {
               var4 /= var1;
            }

            char[] var5 = new char[var3];
            var5[0] = 43;

            for(int var6 = var3 - 1; var6 > 0; --var6) {
               int var7 = var0;
               var0 /= var1;
               int var8 = var7 - var0 * var1;
               if(var8 >= 10) {
                  var5[var6] = (char)(var8 + 87);
               } else {
                  var5[var6] = (char)(var8 + 48);
               }
            }

            return new String(var5);
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
