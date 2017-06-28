import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jt")
public class class275 {
   @ObfuscatedName("j")
   @Export("overlayRotations")
   static byte[][][] overlayRotations;

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIII)V",
      garbageValue = "-136278930"
   )
   static final void method4791(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2734 || class15.method92(var9) != 0 || var9 == Client.field1080 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.hasScript || !WorldMapType2.method510(var9))) {
            int var10 = var9.relativeX + var6;
            int var11 = var9.relativeY + var7;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.type == 9) {
               var16 = var10;
               var17 = var11;
               int var19 = var10 + var9.width;
               var18 = var11 + var9.height;
               if(var19 < var10) {
                  var16 = var19;
                  var19 = var10;
               }

               if(var18 < var11) {
                  var17 = var18;
                  var18 = var11;
               }

               ++var19;
               ++var18;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var19 < var4?var19:var4;
               var15 = var18 < var5?var18:var5;
            } else {
               var16 = var10 + var9.width;
               var17 = var11 + var9.height;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(var9 == Client.field1079) {
               Client.field980 = true;
               Client.field981 = var10;
               Client.field1089 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = class59.field730;
               var17 = class59.field731;
               if(class59.field736 != 0) {
                  var16 = class59.field737;
                  var17 = class59.field732;
               }

               boolean var33 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
               if(var9.contentType == 1337) {
                  if(!Client.field960 && !Client.isMenuOpen && var33) {
                     class261.method4609(var16, var17, var12, var13);
                  }
               } else {
                  int var20;
                  int var21;
                  int var22;
                  int var23;
                  int var24;
                  int var25;
                  int var26;
                  if(var9.contentType == 1338) {
                     if((Client.field1087 == 0 || Client.field1087 == 3) && (class59.field736 == 1 || !class221.field2845 && class59.field736 == 4)) {
                        class210 var35 = var9.method3888(true);
                        if(var35 != null) {
                           var26 = class59.field737 - var10;
                           var25 = class59.field732 - var11;
                           if(var35.method3811(var26, var25)) {
                              var26 -= var35.field2607 / 2;
                              var25 -= var35.field2611 / 2;
                              var20 = Client.mapScale + Client.mapAngle & 2047;
                              var21 = class136.SINE[var20];
                              var22 = class136.COSINE[var20];
                              var21 = (Client.mapScaleDelta + 256) * var21 >> 8;
                              var22 = (Client.mapScaleDelta + 256) * var22 >> 8;
                              var23 = var25 * var21 + var22 * var26 >> 11;
                              var24 = var25 * var22 - var21 * var26 >> 11;
                              int var39 = var23 + class20.localPlayer.x >> 7;
                              int var38 = class20.localPlayer.y - var24 >> 7;
                              Client.secretPacketBuffer1.putOpcode(220);
                              Client.secretPacketBuffer1.putByte(18);
                              Client.secretPacketBuffer1.putShortOb1(var39 + class19.baseX);
                              Client.secretPacketBuffer1.putShortOb1(var38 + class21.baseY);
                              Client.secretPacketBuffer1.putByteNegated(class50.field660[82]?(class50.field660[81]?2:1):0);
                              Client.secretPacketBuffer1.putByte(var26);
                              Client.secretPacketBuffer1.putByte(var25);
                              Client.secretPacketBuffer1.putShort(Client.mapAngle);
                              Client.secretPacketBuffer1.putByte(57);
                              Client.secretPacketBuffer1.putByte(Client.mapScale);
                              Client.secretPacketBuffer1.putByte(Client.mapScaleDelta);
                              Client.secretPacketBuffer1.putByte(89);
                              Client.secretPacketBuffer1.putShort(class20.localPlayer.x);
                              Client.secretPacketBuffer1.putShort(class20.localPlayer.y);
                              Client.secretPacketBuffer1.putByte(63);
                              Client.destinationX = var39;
                              Client.destinationY = var38;
                           }
                        }
                     }
                  } else {
                     if(var9.contentType == 1400) {
                        class46.renderOverview.method5046(class59.field730, class59.field731, var33, var10, var11, var9.width, var9.height);
                     }

                     if(!Client.isMenuOpen && var33) {
                        if(var9.contentType == 1400) {
                           class46.renderOverview.method5093(var10, var11, var9.width, var9.height, var16, var17);
                        } else {
                           class162.method2943(var9, var16 - var10, var17 - var11);
                        }
                     }

                     if(var9.type == 0) {
                        if(!var9.hasScript && WorldMapType2.method510(var9) && var9 != Item.field1476) {
                           continue;
                        }

                        method4791(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                        if(var9.children != null) {
                           method4791(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                        }

                        WidgetNode var27 = (WidgetNode)Client.componentTable.method3425((long)var9.id);
                        if(var27 != null) {
                           if(var27.field811 == 0 && class59.field730 >= var12 && class59.field731 >= var13 && class59.field730 < var14 && class59.field731 < var15 && !Client.isMenuOpen && !Client.field1076) {
                              for(class69 var28 = (class69)Client.field1105.method3487(); var28 != null; var28 = (class69)Client.field1105.method3512()) {
                                 if(var28.field826) {
                                    var28.unlink();
                                    var28.field822.field2779 = false;
                                 }
                              }

                              if(class33.field478 == 0) {
                                 Client.field1079 = null;
                                 Client.field1080 = null;
                              }

                              if(!Client.isMenuOpen) {
                                 Client.menuOptionCount = 0;
                                 Client.field1053 = -1;
                                 Client.isMenuOpen = false;
                                 Client.menuOptions[0] = "Cancel";
                                 Client.menuTargets[0] = "";
                                 Client.menuTypes[0] = 1006;
                                 Client.menuOptionCount = 1;
                              }
                           }

                           class182.method3330(var27.id, var12, var13, var14, var15, var10, var11);
                        }
                     }

                     if(var9.hasScript) {
                        class69 var34;
                        if(!var9.field2787) {
                           if(var9.field2788 && class59.field730 >= var12 && class59.field731 >= var13 && class59.field730 < var14 && class59.field731 < var15) {
                              for(var34 = (class69)Client.field1105.method3487(); var34 != null; var34 = (class69)Client.field1105.method3512()) {
                                 if(var34.field826 && var34.field822.field2672 == var34.field821) {
                                    var34.unlink();
                                 }
                              }
                           }
                        } else if(class59.field730 >= var12 && class59.field731 >= var13 && class59.field730 < var14 && class59.field731 < var15) {
                           for(var34 = (class69)Client.field1105.method3487(); var34 != null; var34 = (class69)Client.field1105.method3512()) {
                              if(var34.field826) {
                                 var34.unlink();
                                 var34.field822.field2779 = false;
                              }
                           }

                           if(class33.field478 == 0) {
                              Client.field1079 = null;
                              Client.field1080 = null;
                           }

                           if(!Client.isMenuOpen) {
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.menuOptionCount = 1;
                           }
                        }

                        if(class59.field730 >= var12 && class59.field731 >= var13 && class59.field730 < var14 && class59.field731 < var15) {
                           var33 = true;
                        } else {
                           var33 = false;
                        }

                        boolean var36 = false;
                        if((class59.field729 == 1 || !class221.field2845 && class59.field729 == 4) && var33) {
                           var36 = true;
                        }

                        boolean var29 = false;
                        if((class59.field736 == 1 || !class221.field2845 && class59.field736 == 4) && class59.field737 >= var12 && class59.field732 >= var13 && class59.field737 < var14 && class59.field732 < var15) {
                           var29 = true;
                        }

                        if(var29) {
                           ScriptState.method1009(var9, class59.field737 - var10, class59.field732 - var11);
                        }

                        if(var9.contentType == 1400) {
                           class46.renderOverview.method5047(class59.field730, class59.field731, var33 & var36);
                        }

                        if(Client.field1079 != null && var9 != Client.field1079 && var33) {
                           var20 = class15.method92(var9);
                           boolean var30 = (var20 >> 20 & 1) != 0;
                           if(var30) {
                              Client.field963 = var9;
                           }
                        }

                        if(var9 == Client.field1080) {
                           Client.field1084 = true;
                           Client.field1093 = var10;
                           Client.field1086 = var11;
                        }

                        if(var9.field2734) {
                           class69 var37;
                           if(var33 && Client.field1186 != 0 && var9.field2672 != null) {
                              var37 = new class69();
                              var37.field826 = true;
                              var37.field822 = var9;
                              var37.field835 = Client.field1186;
                              var37.field821 = var9.field2672;
                              Client.field1105.method3505(var37);
                           }

                           if(Client.field1079 != null || class165.field2335 != null || Client.isMenuOpen) {
                              var29 = false;
                              var36 = false;
                              var33 = false;
                           }

                           if(!var9.field2642 && var29) {
                              var9.field2642 = true;
                              if(var9.field2770 != null) {
                                 var37 = new class69();
                                 var37.field826 = true;
                                 var37.field822 = var9;
                                 var37.field823 = class59.field737 - var10;
                                 var37.field835 = class59.field732 - var11;
                                 var37.field821 = var9.field2770;
                                 Client.field1105.method3505(var37);
                              }
                           }

                           if(var9.field2642 && var36 && var9.field2701 != null) {
                              var37 = new class69();
                              var37.field826 = true;
                              var37.field822 = var9;
                              var37.field823 = class59.field730 - var10;
                              var37.field835 = class59.field731 - var11;
                              var37.field821 = var9.field2701;
                              Client.field1105.method3505(var37);
                           }

                           if(var9.field2642 && !var36) {
                              var9.field2642 = false;
                              if(var9.field2738 != null) {
                                 var37 = new class69();
                                 var37.field826 = true;
                                 var37.field822 = var9;
                                 var37.field823 = class59.field730 - var10;
                                 var37.field835 = class59.field731 - var11;
                                 var37.field821 = var9.field2738;
                                 Client.field1136.method3505(var37);
                              }
                           }

                           if(var36 && var9.field2739 != null) {
                              var37 = new class69();
                              var37.field826 = true;
                              var37.field822 = var9;
                              var37.field823 = class59.field730 - var10;
                              var37.field835 = class59.field731 - var11;
                              var37.field821 = var9.field2739;
                              Client.field1105.method3505(var37);
                           }

                           if(!var9.field2779 && var33) {
                              var9.field2779 = true;
                              if(var9.field2707 != null) {
                                 var37 = new class69();
                                 var37.field826 = true;
                                 var37.field822 = var9;
                                 var37.field823 = class59.field730 - var10;
                                 var37.field835 = class59.field731 - var11;
                                 var37.field821 = var9.field2707;
                                 Client.field1105.method3505(var37);
                              }
                           }

                           if(var9.field2779 && var33 && var9.field2703 != null) {
                              var37 = new class69();
                              var37.field826 = true;
                              var37.field822 = var9;
                              var37.field823 = class59.field730 - var10;
                              var37.field835 = class59.field731 - var11;
                              var37.field821 = var9.field2703;
                              Client.field1105.method3505(var37);
                           }

                           if(var9.field2779 && !var33) {
                              var9.field2779 = false;
                              if(var9.field2742 != null) {
                                 var37 = new class69();
                                 var37.field826 = true;
                                 var37.field822 = var9;
                                 var37.field823 = class59.field730 - var10;
                                 var37.field835 = class59.field731 - var11;
                                 var37.field821 = var9.field2742;
                                 Client.field1136.method3505(var37);
                              }
                           }

                           if(var9.field2753 != null) {
                              var37 = new class69();
                              var37.field822 = var9;
                              var37.field821 = var9.field2753;
                              Client.field1106.method3505(var37);
                           }

                           class69 var31;
                           if(var9.field2747 != null && Client.field1026 > var9.field2677) {
                              if(var9.field2748 != null && Client.field1026 - var9.field2677 <= 32) {
                                 label578:
                                 for(var25 = var9.field2677; var25 < Client.field1026; ++var25) {
                                    var20 = Client.field1092[var25 & 31];

                                    for(var21 = 0; var21 < var9.field2748.length; ++var21) {
                                       if(var9.field2748[var21] == var20) {
                                          var31 = new class69();
                                          var31.field822 = var9;
                                          var31.field821 = var9.field2747;
                                          Client.field1105.method3505(var31);
                                          break label578;
                                       }
                                    }
                                 }
                              } else {
                                 var37 = new class69();
                                 var37.field822 = var9;
                                 var37.field821 = var9.field2747;
                                 Client.field1105.method3505(var37);
                              }

                              var9.field2677 = Client.field1026;
                           }

                           if(var9.field2749 != null && Client.field1095 > var9.field2783) {
                              if(var9.field2782 != null && Client.field1095 - var9.field2783 <= 32) {
                                 label554:
                                 for(var25 = var9.field2783; var25 < Client.field1095; ++var25) {
                                    var20 = Client.interfaceItemTriggers[var25 & 31];

                                    for(var21 = 0; var21 < var9.field2782.length; ++var21) {
                                       if(var9.field2782[var21] == var20) {
                                          var31 = new class69();
                                          var31.field822 = var9;
                                          var31.field821 = var9.field2749;
                                          Client.field1105.method3505(var31);
                                          break label554;
                                       }
                                    }
                                 }
                              } else {
                                 var37 = new class69();
                                 var37.field822 = var9;
                                 var37.field821 = var9.field2749;
                                 Client.field1105.method3505(var37);
                              }

                              var9.field2783 = Client.field1095;
                           }

                           if(var9.field2751 != null && Client.field1097 > var9.field2784) {
                              if(var9.field2752 != null && Client.field1097 - var9.field2784 <= 32) {
                                 label530:
                                 for(var25 = var9.field2784; var25 < Client.field1097; ++var25) {
                                    var20 = Client.field1174[var25 & 31];

                                    for(var21 = 0; var21 < var9.field2752.length; ++var21) {
                                       if(var9.field2752[var21] == var20) {
                                          var31 = new class69();
                                          var31.field822 = var9;
                                          var31.field821 = var9.field2751;
                                          Client.field1105.method3505(var31);
                                          break label530;
                                       }
                                    }
                                 }
                              } else {
                                 var37 = new class69();
                                 var37.field822 = var9;
                                 var37.field821 = var9.field2751;
                                 Client.field1105.method3505(var37);
                              }

                              var9.field2784 = Client.field1097;
                           }

                           if(Client.field1098 > var9.field2781 && var9.field2756 != null) {
                              var37 = new class69();
                              var37.field822 = var9;
                              var37.field821 = var9.field2756;
                              Client.field1105.method3505(var37);
                           }

                           if(Client.field1099 > var9.field2781 && var9.field2767 != null) {
                              var37 = new class69();
                              var37.field822 = var9;
                              var37.field821 = var9.field2767;
                              Client.field1105.method3505(var37);
                           }

                           if(Client.field1063 > var9.field2781 && var9.field2740 != null) {
                              var37 = new class69();
                              var37.field822 = var9;
                              var37.field821 = var9.field2740;
                              Client.field1105.method3505(var37);
                           }

                           if(Client.field1101 > var9.field2781 && var9.field2764 != null) {
                              var37 = new class69();
                              var37.field822 = var9;
                              var37.field821 = var9.field2764;
                              Client.field1105.method3505(var37);
                           }

                           if(Client.field1102 > var9.field2781 && var9.field2765 != null) {
                              var37 = new class69();
                              var37.field822 = var9;
                              var37.field821 = var9.field2765;
                              Client.field1105.method3505(var37);
                           }

                           if(Client.field1103 > var9.field2781 && var9.field2780 != null) {
                              var37 = new class69();
                              var37.field822 = var9;
                              var37.field821 = var9.field2780;
                              Client.field1105.method3505(var37);
                           }

                           var9.field2781 = Client.field1091;
                           if(var9.field2757 != null) {
                              for(var25 = 0; var25 < Client.field1132; ++var25) {
                                 class69 var32 = new class69();
                                 var32.field822 = var9;
                                 var32.field827 = Client.field1038[var25];
                                 var32.field828 = Client.field1135[var25];
                                 var32.field821 = var9.field2757;
                                 Client.field1105.method3505(var32);
                              }
                           }
                        }
                     }

                     if(!var9.hasScript && Client.field1079 == null && class165.field2335 == null && !Client.isMenuOpen) {
                        if((var9.field2720 >= 0 || var9.field2681 != 0) && class59.field730 >= var12 && class59.field731 >= var13 && class59.field730 < var14 && class59.field731 < var15) {
                           if(var9.field2720 >= 0) {
                              Item.field1476 = var0[var9.field2720];
                           } else {
                              Item.field1476 = var9;
                           }
                        }

                        if(var9.type == 8 && class59.field730 >= var12 && class59.field731 >= var13 && class59.field730 < var14 && class59.field731 < var15) {
                           class12.field280 = var9;
                        }

                        if(var9.scrollHeight > var9.height) {
                           var18 = var10 + var9.width;
                           var26 = var9.height;
                           var25 = var9.scrollHeight;
                           var20 = class59.field730;
                           var21 = class59.field731;
                           if(Client.field987) {
                              Client.field1073 = 32;
                           } else {
                              Client.field1073 = 0;
                           }

                           Client.field987 = false;
                           if(class59.field729 == 1 || !class221.field2845 && class59.field729 == 4) {
                              if(var20 >= var18 && var20 < var18 + 16 && var21 >= var11 && var21 < var11 + 16) {
                                 var9.scrollY -= 4;
                                 XItemContainer.method1020(var9);
                              } else if(var20 >= var18 && var20 < var18 + 16 && var21 >= var11 + var26 - 16 && var21 < var11 + var26) {
                                 var9.scrollY += 4;
                                 XItemContainer.method1020(var9);
                              } else if(var20 >= var18 - Client.field1073 && var20 < var18 + Client.field1073 + 16 && var21 >= var11 + 16 && var21 < var11 + var26 - 16) {
                                 var22 = (var26 - 32) * var26 / var25;
                                 if(var22 < 8) {
                                    var22 = 8;
                                 }

                                 var23 = var21 - var11 - 16 - var22 / 2;
                                 var24 = var26 - 32 - var22;
                                 var9.scrollY = var23 * (var25 - var26) / var24;
                                 XItemContainer.method1020(var9);
                                 Client.field987 = true;
                              }
                           }

                           if(Client.field1186 != 0) {
                              var22 = var9.width;
                              if(var20 >= var18 - var22 && var21 >= var11 && var20 < var18 + 16 && var21 <= var11 + var26) {
                                 var9.scrollY += Client.field1186 * 45;
                                 XItemContainer.method1020(var9);
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
