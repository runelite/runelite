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
            int var10 = var6 + var9.relativeX;
            int var11 = var9.relativeY + var7;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var19;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.type == 9) {
               var16 = var10;
               var17 = var11;
               int var18 = var9.width + var10;
               var19 = var11 + var9.height;
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

               boolean var34 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
               if(var9.contentType == 1337) {
                  if(!Client.field960 && !Client.isMenuOpen && var34) {
                     class261.method4609(var16, var17, var12, var13);
                  }
               } else {
                  int var22;
                  int var23;
                  int var24;
                  int var25;
                  int var26;
                  int var36;
                  int var37;
                  if(var9.contentType == 1338) {
                     if((Client.field1087 == 0 || Client.field1087 == 3) && (class59.field736 == 1 || !class221.field2845 && class59.field736 == 4)) {
                        class210 var39 = var9.method3888(true);
                        if(var39 != null) {
                           var37 = class59.field737 - var10;
                           var36 = class59.field732 - var11;
                           if(var39.method3811(var37, var36)) {
                              var37 -= var39.field2607 / 2;
                              var36 -= var39.field2611 / 2;
                              var22 = Client.mapScale + Client.mapAngle & 2047;
                              var23 = class136.SINE[var22];
                              var24 = class136.COSINE[var22];
                              var23 = (Client.mapScaleDelta + 256) * var23 >> 8;
                              var24 = var24 * (Client.mapScaleDelta + 256) >> 8;
                              var25 = var36 * var23 + var24 * var37 >> 11;
                              var26 = var36 * var24 - var37 * var23 >> 11;
                              int var27 = class20.localPlayer.x + var25 >> 7;
                              int var28 = class20.localPlayer.y - var26 >> 7;
                              Client.secretPacketBuffer1.putOpcode(220);
                              Client.secretPacketBuffer1.putByte(18);
                              Client.secretPacketBuffer1.method3066(var27 + class19.baseX);
                              Client.secretPacketBuffer1.method3066(class21.baseY + var28);
                              Client.secretPacketBuffer1.method3196(class50.field660[82]?(class50.field660[81]?2:1):0);
                              Client.secretPacketBuffer1.putByte(var37);
                              Client.secretPacketBuffer1.putByte(var36);
                              Client.secretPacketBuffer1.putShort(Client.mapAngle);
                              Client.secretPacketBuffer1.putByte(57);
                              Client.secretPacketBuffer1.putByte(Client.mapScale);
                              Client.secretPacketBuffer1.putByte(Client.mapScaleDelta);
                              Client.secretPacketBuffer1.putByte(89);
                              Client.secretPacketBuffer1.putShort(class20.localPlayer.x);
                              Client.secretPacketBuffer1.putShort(class20.localPlayer.y);
                              Client.secretPacketBuffer1.putByte(63);
                              Client.detinationX = var27;
                              Client.destinationY = var28;
                           }
                        }
                     }
                  } else {
                     if(var9.contentType == 1400) {
                        class46.field601.method5046(class59.field730, class59.field731, var34, var10, var11, var9.width, var9.height);
                     }

                     if(!Client.isMenuOpen && var34) {
                        if(var9.contentType == 1400) {
                           class46.field601.method5093(var10, var11, var9.width, var9.height, var16, var17);
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

                        WidgetNode var29 = (WidgetNode)Client.componentTable.method3425((long)var9.id);
                        if(var29 != null) {
                           if(var29.field811 == 0 && class59.field730 >= var12 && class59.field731 >= var13 && class59.field730 < var14 && class59.field731 < var15 && !Client.isMenuOpen && !Client.field1076) {
                              for(class69 var30 = (class69)Client.field1105.method3487(); var30 != null; var30 = (class69)Client.field1105.method3512()) {
                                 if(var30.field826) {
                                    var30.unlink();
                                    var30.field822.field2779 = false;
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

                           class182.method3330(var29.id, var12, var13, var14, var15, var10, var11);
                        }
                     }

                     if(var9.hasScript) {
                        class69 var38;
                        if(!var9.field2787) {
                           if(var9.field2788 && class59.field730 >= var12 && class59.field731 >= var13 && class59.field730 < var14 && class59.field731 < var15) {
                              for(var38 = (class69)Client.field1105.method3487(); var38 != null; var38 = (class69)Client.field1105.method3512()) {
                                 if(var38.field826 && var38.field821 == var38.field822.field2672) {
                                    var38.unlink();
                                 }
                              }
                           }
                        } else if(class59.field730 >= var12 && class59.field731 >= var13 && class59.field730 < var14 && class59.field731 < var15) {
                           for(var38 = (class69)Client.field1105.method3487(); var38 != null; var38 = (class69)Client.field1105.method3512()) {
                              if(var38.field826) {
                                 var38.unlink();
                                 var38.field822.field2779 = false;
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
                           var34 = true;
                        } else {
                           var34 = false;
                        }

                        boolean var35 = false;
                        if((class59.field729 == 1 || !class221.field2845 && class59.field729 == 4) && var34) {
                           var35 = true;
                        }

                        boolean var20 = false;
                        if((class59.field736 == 1 || !class221.field2845 && class59.field736 == 4) && class59.field737 >= var12 && class59.field732 >= var13 && class59.field737 < var14 && class59.field732 < var15) {
                           var20 = true;
                        }

                        if(var20) {
                           ScriptState.method1009(var9, class59.field737 - var10, class59.field732 - var11);
                        }

                        if(var9.contentType == 1400) {
                           class46.field601.method5047(class59.field730, class59.field731, var34 & var35);
                        }

                        if(Client.field1079 != null && Client.field1079 != var9 && var34) {
                           var22 = class15.method92(var9);
                           boolean var21 = (var22 >> 20 & 1) != 0;
                           if(var21) {
                              Client.field963 = var9;
                           }
                        }

                        if(Client.field1080 == var9) {
                           Client.field1084 = true;
                           Client.field1093 = var10;
                           Client.field1086 = var11;
                        }

                        if(var9.field2734) {
                           class69 var31;
                           if(var34 && Client.field1186 != 0 && var9.field2672 != null) {
                              var31 = new class69();
                              var31.field826 = true;
                              var31.field822 = var9;
                              var31.field835 = Client.field1186;
                              var31.field821 = var9.field2672;
                              Client.field1105.method3505(var31);
                           }

                           if(Client.field1079 != null || class165.field2335 != null || Client.isMenuOpen) {
                              var20 = false;
                              var35 = false;
                              var34 = false;
                           }

                           if(!var9.field2642 && var20) {
                              var9.field2642 = true;
                              if(var9.field2770 != null) {
                                 var31 = new class69();
                                 var31.field826 = true;
                                 var31.field822 = var9;
                                 var31.field823 = class59.field737 - var10;
                                 var31.field835 = class59.field732 - var11;
                                 var31.field821 = var9.field2770;
                                 Client.field1105.method3505(var31);
                              }
                           }

                           if(var9.field2642 && var35 && var9.field2701 != null) {
                              var31 = new class69();
                              var31.field826 = true;
                              var31.field822 = var9;
                              var31.field823 = class59.field730 - var10;
                              var31.field835 = class59.field731 - var11;
                              var31.field821 = var9.field2701;
                              Client.field1105.method3505(var31);
                           }

                           if(var9.field2642 && !var35) {
                              var9.field2642 = false;
                              if(var9.field2738 != null) {
                                 var31 = new class69();
                                 var31.field826 = true;
                                 var31.field822 = var9;
                                 var31.field823 = class59.field730 - var10;
                                 var31.field835 = class59.field731 - var11;
                                 var31.field821 = var9.field2738;
                                 Client.field1136.method3505(var31);
                              }
                           }

                           if(var35 && var9.field2739 != null) {
                              var31 = new class69();
                              var31.field826 = true;
                              var31.field822 = var9;
                              var31.field823 = class59.field730 - var10;
                              var31.field835 = class59.field731 - var11;
                              var31.field821 = var9.field2739;
                              Client.field1105.method3505(var31);
                           }

                           if(!var9.field2779 && var34) {
                              var9.field2779 = true;
                              if(var9.field2707 != null) {
                                 var31 = new class69();
                                 var31.field826 = true;
                                 var31.field822 = var9;
                                 var31.field823 = class59.field730 - var10;
                                 var31.field835 = class59.field731 - var11;
                                 var31.field821 = var9.field2707;
                                 Client.field1105.method3505(var31);
                              }
                           }

                           if(var9.field2779 && var34 && var9.field2703 != null) {
                              var31 = new class69();
                              var31.field826 = true;
                              var31.field822 = var9;
                              var31.field823 = class59.field730 - var10;
                              var31.field835 = class59.field731 - var11;
                              var31.field821 = var9.field2703;
                              Client.field1105.method3505(var31);
                           }

                           if(var9.field2779 && !var34) {
                              var9.field2779 = false;
                              if(var9.field2742 != null) {
                                 var31 = new class69();
                                 var31.field826 = true;
                                 var31.field822 = var9;
                                 var31.field823 = class59.field730 - var10;
                                 var31.field835 = class59.field731 - var11;
                                 var31.field821 = var9.field2742;
                                 Client.field1136.method3505(var31);
                              }
                           }

                           if(var9.field2753 != null) {
                              var31 = new class69();
                              var31.field822 = var9;
                              var31.field821 = var9.field2753;
                              Client.field1106.method3505(var31);
                           }

                           class69 var33;
                           if(var9.field2747 != null && Client.field1026 > var9.field2677) {
                              if(var9.field2748 != null && Client.field1026 - var9.field2677 <= 32) {
                                 label860:
                                 for(var36 = var9.field2677; var36 < Client.field1026; ++var36) {
                                    var22 = Client.field1092[var36 & 31];

                                    for(var23 = 0; var23 < var9.field2748.length; ++var23) {
                                       if(var9.field2748[var23] == var22) {
                                          var33 = new class69();
                                          var33.field822 = var9;
                                          var33.field821 = var9.field2747;
                                          Client.field1105.method3505(var33);
                                          break label860;
                                       }
                                    }
                                 }
                              } else {
                                 var31 = new class69();
                                 var31.field822 = var9;
                                 var31.field821 = var9.field2747;
                                 Client.field1105.method3505(var31);
                              }

                              var9.field2677 = Client.field1026;
                           }

                           if(var9.field2749 != null && Client.field1095 > var9.field2783) {
                              if(var9.field2782 != null && Client.field1095 - var9.field2783 <= 32) {
                                 label836:
                                 for(var36 = var9.field2783; var36 < Client.field1095; ++var36) {
                                    var22 = Client.interfaceItemTriggers[var36 & 31];

                                    for(var23 = 0; var23 < var9.field2782.length; ++var23) {
                                       if(var9.field2782[var23] == var22) {
                                          var33 = new class69();
                                          var33.field822 = var9;
                                          var33.field821 = var9.field2749;
                                          Client.field1105.method3505(var33);
                                          break label836;
                                       }
                                    }
                                 }
                              } else {
                                 var31 = new class69();
                                 var31.field822 = var9;
                                 var31.field821 = var9.field2749;
                                 Client.field1105.method3505(var31);
                              }

                              var9.field2783 = Client.field1095;
                           }

                           if(var9.field2751 != null && Client.field1097 > var9.field2784) {
                              if(var9.field2752 != null && Client.field1097 - var9.field2784 <= 32) {
                                 label812:
                                 for(var36 = var9.field2784; var36 < Client.field1097; ++var36) {
                                    var22 = Client.field1174[var36 & 31];

                                    for(var23 = 0; var23 < var9.field2752.length; ++var23) {
                                       if(var9.field2752[var23] == var22) {
                                          var33 = new class69();
                                          var33.field822 = var9;
                                          var33.field821 = var9.field2751;
                                          Client.field1105.method3505(var33);
                                          break label812;
                                       }
                                    }
                                 }
                              } else {
                                 var31 = new class69();
                                 var31.field822 = var9;
                                 var31.field821 = var9.field2751;
                                 Client.field1105.method3505(var31);
                              }

                              var9.field2784 = Client.field1097;
                           }

                           if(Client.field1098 > var9.field2781 && var9.field2756 != null) {
                              var31 = new class69();
                              var31.field822 = var9;
                              var31.field821 = var9.field2756;
                              Client.field1105.method3505(var31);
                           }

                           if(Client.field1099 > var9.field2781 && var9.field2767 != null) {
                              var31 = new class69();
                              var31.field822 = var9;
                              var31.field821 = var9.field2767;
                              Client.field1105.method3505(var31);
                           }

                           if(Client.field1063 > var9.field2781 && var9.field2740 != null) {
                              var31 = new class69();
                              var31.field822 = var9;
                              var31.field821 = var9.field2740;
                              Client.field1105.method3505(var31);
                           }

                           if(Client.field1101 > var9.field2781 && var9.field2764 != null) {
                              var31 = new class69();
                              var31.field822 = var9;
                              var31.field821 = var9.field2764;
                              Client.field1105.method3505(var31);
                           }

                           if(Client.field1102 > var9.field2781 && var9.field2765 != null) {
                              var31 = new class69();
                              var31.field822 = var9;
                              var31.field821 = var9.field2765;
                              Client.field1105.method3505(var31);
                           }

                           if(Client.field1103 > var9.field2781 && var9.field2780 != null) {
                              var31 = new class69();
                              var31.field822 = var9;
                              var31.field821 = var9.field2780;
                              Client.field1105.method3505(var31);
                           }

                           var9.field2781 = Client.field1091;
                           if(var9.field2757 != null) {
                              for(var36 = 0; var36 < Client.field1132; ++var36) {
                                 class69 var32 = new class69();
                                 var32.field822 = var9;
                                 var32.field827 = Client.field1038[var36];
                                 var32.field828 = Client.field1135[var36];
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
                           var19 = var10 + var9.width;
                           var37 = var9.height;
                           var36 = var9.scrollHeight;
                           var22 = class59.field730;
                           var23 = class59.field731;
                           if(Client.field987) {
                              Client.field1073 = 32;
                           } else {
                              Client.field1073 = 0;
                           }

                           Client.field987 = false;
                           if(class59.field729 == 1 || !class221.field2845 && class59.field729 == 4) {
                              if(var22 >= var19 && var22 < var19 + 16 && var23 >= var11 && var23 < var11 + 16) {
                                 var9.scrollY -= 4;
                                 XItemContainer.method1020(var9);
                              } else if(var22 >= var19 && var22 < var19 + 16 && var23 >= var37 + var11 - 16 && var23 < var37 + var11) {
                                 var9.scrollY += 4;
                                 XItemContainer.method1020(var9);
                              } else if(var22 >= var19 - Client.field1073 && var22 < Client.field1073 + var19 + 16 && var23 >= var11 + 16 && var23 < var37 + var11 - 16) {
                                 var24 = var37 * (var37 - 32) / var36;
                                 if(var24 < 8) {
                                    var24 = 8;
                                 }

                                 var25 = var23 - var11 - 16 - var24 / 2;
                                 var26 = var37 - 32 - var24;
                                 var9.scrollY = (var36 - var37) * var25 / var26;
                                 XItemContainer.method1020(var9);
                                 Client.field987 = true;
                              }
                           }

                           if(Client.field1186 != 0) {
                              var24 = var9.width;
                              if(var22 >= var19 - var24 && var23 >= var11 && var22 < var19 + 16 && var23 <= var37 + var11) {
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
