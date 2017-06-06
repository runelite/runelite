import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
final class class95 implements Comparator {
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIII)V",
      garbageValue = "1468399908"
   )
   static final void method1754(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2726 || class210.method3903(var9) != 0 || Client.field1104 == var9 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.hasScript || !class89.method1700(var9))) {
            int var10 = var6 + var9.relativeX;
            int var11 = var9.relativeY + var7;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.type == 9) {
               var16 = var10;
               var17 = var11;
               int var18 = var9.width + var10;
               int var19 = var9.height + var11;
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
               var16 = var9.width + var10;
               var17 = var11 + var9.height;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(Client.field1164 == var9) {
               Client.field1111 = true;
               Client.field1112 = var10;
               Client.field1113 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = class59.field737;
               var17 = class59.field738;
               if(class59.field732 != 0) {
                  var16 = class59.field745;
                  var17 = class59.field750;
               }

               boolean var34 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
               if(var9.contentType == 1337) {
                  if(!Client.field978 && !Client.isMenuOpen && var34) {
                     KitDefinition.method4395(var16, var17, var12, var13);
                  }
               } else {
                  int var21;
                  int var23;
                  int var30;
                  if(var9.contentType == 1338) {
                     if((Client.field1170 == 0 || Client.field1170 == 3) && (class59.field732 == 1 || !class233.field3202 && class59.field732 == 4)) {
                        class210 var38 = var9.method3987(true);
                        if(var38 != null) {
                           int var36 = class59.field745 - var10;
                           var21 = class59.field750 - var11;
                           if(var38.method3902(var36, var21)) {
                              var36 -= var38.field2602 / 2;
                              var21 -= var38.field2601 / 2;
                              var30 = Client.mapAngle + Client.mapScale & 2047;
                              var23 = class136.SINE[var30];
                              int var32 = class136.COSINE[var30];
                              var23 = var23 * (Client.mapScaleDelta + 256) >> 8;
                              var32 = (Client.mapScaleDelta + 256) * var32 >> 8;
                              int var25 = var36 * var32 + var21 * var23 >> 11;
                              int var26 = var32 * var21 - var36 * var23 >> 11;
                              int var27 = World.localPlayer.x + var25 >> 7;
                              int var28 = World.localPlayer.y - var26 >> 7;
                              Client.secretPacketBuffer1.putOpcode(190);
                              Client.secretPacketBuffer1.putByte(18);
                              Client.secretPacketBuffer1.method3175(WorldMapType3.baseY + var28);
                              Client.secretPacketBuffer1.method3175(var27 + class41.baseX);
                              Client.secretPacketBuffer1.method3170(class50.field645[82]?(class50.field645[81]?2:1):0);
                              Client.secretPacketBuffer1.putByte(var36);
                              Client.secretPacketBuffer1.putByte(var21);
                              Client.secretPacketBuffer1.putShort(Client.mapAngle);
                              Client.secretPacketBuffer1.putByte(57);
                              Client.secretPacketBuffer1.putByte(Client.mapScale);
                              Client.secretPacketBuffer1.putByte(Client.mapScaleDelta);
                              Client.secretPacketBuffer1.putByte(89);
                              Client.secretPacketBuffer1.putShort(World.localPlayer.x);
                              Client.secretPacketBuffer1.putShort(World.localPlayer.y);
                              Client.secretPacketBuffer1.putByte(63);
                              Client.flagX = var27;
                              Client.flagY = var28;
                           }
                        }
                     }
                  } else {
                     if(var9.contentType == 1400) {
                        class1.field14.method5174(class59.field737, class59.field738, var34, var10, var11, var9.width, var9.height);
                     }

                     if(!Client.isMenuOpen && var34) {
                        if(var9.contentType == 1400) {
                           class1.field14.method5221(var10, var11, var9.width, var9.height, var16, var17);
                        } else {
                           VertexNormal.method2587(var9, var16 - var10, var17 - var11);
                        }
                     }

                     if(var9.type == 0) {
                        if(!var9.hasScript && class89.method1700(var9) && var9 != WorldMapType1.field434) {
                           continue;
                        }

                        method1754(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                        if(var9.children != null) {
                           method1754(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                        }

                        WidgetNode var31 = (WidgetNode)Client.componentTable.method3520((long)var9.id);
                        if(var31 != null) {
                           if(var31.field840 == 0 && class59.field737 >= var12 && class59.field738 >= var13 && class59.field737 < var14 && class59.field738 < var15 && !Client.isMenuOpen && !Client.field1100) {
                              for(class69 var33 = (class69)Client.field955.method3576(); var33 != null; var33 = (class69)Client.field955.method3578()) {
                                 if(var33.field858) {
                                    var33.unlink();
                                    var33.field852.field2776 = false;
                                 }
                              }

                              if(class64.field799 == 0) {
                                 Client.field1164 = null;
                                 Client.field1104 = null;
                              }

                              if(!Client.isMenuOpen) {
                                 Client.menuOptionCount = 0;
                                 Client.field1090 = -1;
                                 Client.isMenuOpen = false;
                                 Client.menuOptions[0] = "Cancel";
                                 Client.menuTargets[0] = "";
                                 Client.menuTypes[0] = 1006;
                                 Client.menuOptionCount = 1;
                              }
                           }

                           XClanMember.method1139(var31.id, var12, var13, var14, var15, var10, var11);
                        }
                     }

                     if(var9.hasScript) {
                        class69 var37;
                        if(!var9.field2784) {
                           if(var9.field2763 && class59.field737 >= var12 && class59.field738 >= var13 && class59.field737 < var14 && class59.field738 < var15) {
                              for(var37 = (class69)Client.field955.method3576(); var37 != null; var37 = (class69)Client.field955.method3578()) {
                                 if(var37.field858 && var37.field852.field2752 == var37.field849) {
                                    var37.unlink();
                                 }
                              }
                           }
                        } else if(class59.field737 >= var12 && class59.field738 >= var13 && class59.field737 < var14 && class59.field738 < var15) {
                           for(var37 = (class69)Client.field955.method3576(); var37 != null; var37 = (class69)Client.field955.method3578()) {
                              if(var37.field858) {
                                 var37.unlink();
                                 var37.field852.field2776 = false;
                              }
                           }

                           if(class64.field799 == 0) {
                              Client.field1164 = null;
                              Client.field1104 = null;
                           }

                           if(!Client.isMenuOpen) {
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.menuOptionCount = 1;
                           }
                        }

                        if(class59.field737 >= var12 && class59.field738 >= var13 && class59.field737 < var14 && class59.field738 < var15) {
                           var34 = true;
                        } else {
                           var34 = false;
                        }

                        boolean var35 = false;
                        if((class59.field736 == 1 || !class233.field3202 && class59.field736 == 4) && var34) {
                           var35 = true;
                        }

                        boolean var20 = false;
                        if((class59.field732 == 1 || !class233.field3202 && class59.field732 == 4) && class59.field745 >= var12 && class59.field750 >= var13 && class59.field745 < var14 && class59.field750 < var15) {
                           var20 = true;
                        }

                        if(var20) {
                           class14.method74(var9, class59.field745 - var10, class59.field750 - var11);
                        }

                        if(var9.contentType == 1400) {
                           class1.field14.method5327(class59.field737, class59.field738, var34 & var35);
                        }

                        if(Client.field1164 != null && var9 != Client.field1164 && var34 && GameEngine.method961(class210.method3903(var9))) {
                           Client.field1107 = var9;
                        }

                        if(Client.field1104 == var9) {
                           Client.field1108 = true;
                           Client.field1063 = var10;
                           Client.field1146 = var11;
                        }

                        if(var9.field2726) {
                           class69 var29;
                           if(var34 && Client.field954 != 0 && var9.field2752 != null) {
                              var29 = new class69();
                              var29.field858 = true;
                              var29.field852 = var9;
                              var29.field848 = Client.field954;
                              var29.field849 = var9.field2752;
                              Client.field955.method3571(var29);
                           }

                           if(Client.field1164 != null || GroundObject.field1885 != null || Client.isMenuOpen) {
                              var20 = false;
                              var35 = false;
                              var34 = false;
                           }

                           if(!var9.field2777 && var20) {
                              var9.field2777 = true;
                              if(var9.field2733 != null) {
                                 var29 = new class69();
                                 var29.field858 = true;
                                 var29.field852 = var9;
                                 var29.field850 = class59.field745 - var10;
                                 var29.field848 = class59.field750 - var11;
                                 var29.field849 = var9.field2733;
                                 Client.field955.method3571(var29);
                              }
                           }

                           if(var9.field2777 && var35 && var9.field2734 != null) {
                              var29 = new class69();
                              var29.field858 = true;
                              var29.field852 = var9;
                              var29.field850 = class59.field737 - var10;
                              var29.field848 = class59.field738 - var11;
                              var29.field849 = var9.field2734;
                              Client.field955.method3571(var29);
                           }

                           if(var9.field2777 && !var35) {
                              var9.field2777 = false;
                              if(var9.field2735 != null) {
                                 var29 = new class69();
                                 var29.field858 = true;
                                 var29.field852 = var9;
                                 var29.field850 = class59.field737 - var10;
                                 var29.field848 = class59.field738 - var11;
                                 var29.field849 = var9.field2735;
                                 Client.field1131.method3571(var29);
                              }
                           }

                           if(var35 && var9.field2744 != null) {
                              var29 = new class69();
                              var29.field858 = true;
                              var29.field852 = var9;
                              var29.field850 = class59.field737 - var10;
                              var29.field848 = class59.field738 - var11;
                              var29.field849 = var9.field2744;
                              Client.field955.method3571(var29);
                           }

                           if(!var9.field2776 && var34) {
                              var9.field2776 = true;
                              if(var9.field2737 != null) {
                                 var29 = new class69();
                                 var29.field858 = true;
                                 var29.field852 = var9;
                                 var29.field850 = class59.field737 - var10;
                                 var29.field848 = class59.field738 - var11;
                                 var29.field849 = var9.field2737;
                                 Client.field955.method3571(var29);
                              }
                           }

                           if(var9.field2776 && var34 && var9.field2738 != null) {
                              var29 = new class69();
                              var29.field858 = true;
                              var29.field852 = var9;
                              var29.field850 = class59.field737 - var10;
                              var29.field848 = class59.field738 - var11;
                              var29.field849 = var9.field2738;
                              Client.field955.method3571(var29);
                           }

                           if(var9.field2776 && !var34) {
                              var9.field2776 = false;
                              if(var9.field2739 != null) {
                                 var29 = new class69();
                                 var29.field858 = true;
                                 var29.field852 = var9;
                                 var29.field850 = class59.field737 - var10;
                                 var29.field848 = class59.field738 - var11;
                                 var29.field849 = var9.field2739;
                                 Client.field1131.method3571(var29);
                              }
                           }

                           if(var9.field2750 != null) {
                              var29 = new class69();
                              var29.field852 = var9;
                              var29.field849 = var9.field2750;
                              Client.field1130.method3571(var29);
                           }

                           class69 var24;
                           if(var9.field2729 != null && Client.field1117 > var9.field2779) {
                              if(var9.field2745 != null && Client.field1117 - var9.field2779 <= 32) {
                                 label814:
                                 for(var21 = var9.field2779; var21 < Client.field1117; ++var21) {
                                    var30 = Client.field1116[var21 & 31];

                                    for(var23 = 0; var23 < var9.field2745.length; ++var23) {
                                       if(var9.field2745[var23] == var30) {
                                          var24 = new class69();
                                          var24.field852 = var9;
                                          var24.field849 = var9.field2729;
                                          Client.field955.method3571(var24);
                                          break label814;
                                       }
                                    }
                                 }
                              } else {
                                 var29 = new class69();
                                 var29.field852 = var9;
                                 var29.field849 = var9.field2729;
                                 Client.field955.method3571(var29);
                              }

                              var9.field2779 = Client.field1117;
                           }

                           if(var9.field2746 != null && Client.field1137 > var9.field2736) {
                              if(var9.field2747 != null && Client.field1137 - var9.field2736 <= 32) {
                                 label790:
                                 for(var21 = var9.field2736; var21 < Client.field1137; ++var21) {
                                    var30 = Client.interfaceItemTriggers[var21 & 31];

                                    for(var23 = 0; var23 < var9.field2747.length; ++var23) {
                                       if(var30 == var9.field2747[var23]) {
                                          var24 = new class69();
                                          var24.field852 = var9;
                                          var24.field849 = var9.field2746;
                                          Client.field955.method3571(var24);
                                          break label790;
                                       }
                                    }
                                 }
                              } else {
                                 var29 = new class69();
                                 var29.field852 = var9;
                                 var29.field849 = var9.field2746;
                                 Client.field955.method3571(var29);
                              }

                              var9.field2736 = Client.field1137;
                           }

                           if(var9.field2748 != null && Client.field1051 > var9.field2781) {
                              if(var9.field2770 != null && Client.field1051 - var9.field2781 <= 32) {
                                 label766:
                                 for(var21 = var9.field2781; var21 < Client.field1051; ++var21) {
                                    var30 = Client.field1120[var21 & 31];

                                    for(var23 = 0; var23 < var9.field2770.length; ++var23) {
                                       if(var30 == var9.field2770[var23]) {
                                          var24 = new class69();
                                          var24.field852 = var9;
                                          var24.field849 = var9.field2748;
                                          Client.field955.method3571(var24);
                                          break label766;
                                       }
                                    }
                                 }
                              } else {
                                 var29 = new class69();
                                 var29.field852 = var9;
                                 var29.field849 = var9.field2748;
                                 Client.field955.method3571(var29);
                              }

                              var9.field2781 = Client.field1051;
                           }

                           if(Client.field1037 > var9.field2685 && var9.field2657 != null) {
                              var29 = new class69();
                              var29.field852 = var9;
                              var29.field849 = var9.field2657;
                              Client.field955.method3571(var29);
                           }

                           if(Client.field1066 > var9.field2685 && var9.field2757 != null) {
                              var29 = new class69();
                              var29.field852 = var9;
                              var29.field849 = var9.field2757;
                              Client.field955.method3571(var29);
                           }

                           if(Client.field1036 > var9.field2685 && var9.field2669 != null) {
                              var29 = new class69();
                              var29.field852 = var9;
                              var29.field849 = var9.field2669;
                              Client.field955.method3571(var29);
                           }

                           if(Client.field1125 > var9.field2685 && var9.field2761 != null) {
                              var29 = new class69();
                              var29.field852 = var9;
                              var29.field849 = var9.field2761;
                              Client.field955.method3571(var29);
                           }

                           if(Client.field1126 > var9.field2685 && var9.field2762 != null) {
                              var29 = new class69();
                              var29.field852 = var9;
                              var29.field849 = var9.field2762;
                              Client.field955.method3571(var29);
                           }

                           if(Client.field1128 > var9.field2685 && var9.field2725 != null) {
                              var29 = new class69();
                              var29.field852 = var9;
                              var29.field849 = var9.field2725;
                              Client.field955.method3571(var29);
                           }

                           var9.field2685 = Client.field1121;
                           if(var9.field2731 != null) {
                              for(var21 = 0; var21 < Client.field1151; ++var21) {
                                 class69 var22 = new class69();
                                 var22.field852 = var9;
                                 var22.field855 = Client.field1153[var21];
                                 var22.field856 = Client.field1152[var21];
                                 var22.field849 = var9.field2731;
                                 Client.field955.method3571(var22);
                              }
                           }
                        }
                     }

                     if(!var9.hasScript && Client.field1164 == null && GroundObject.field1885 == null && !Client.isMenuOpen) {
                        if((var9.field2766 >= 0 || var9.field2769 != 0) && class59.field737 >= var12 && class59.field738 >= var13 && class59.field737 < var14 && class59.field738 < var15) {
                           if(var9.field2766 >= 0) {
                              WorldMapType1.field434 = var0[var9.field2766];
                           } else {
                              WorldMapType1.field434 = var9;
                           }
                        }

                        if(var9.type == 8 && class59.field737 >= var12 && class59.field738 >= var13 && class59.field737 < var14 && class59.field738 < var15) {
                           XItemContainer.field791 = var9;
                        }

                        if(var9.scrollHeight > var9.height) {
                           Friend.method1074(var9, var10 + var9.width, var11, var9.height, var9.scrollHeight, class59.field737, class59.field738);
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
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "-1665414008"
   )
   int method1755(class14 var1, class14 var2) {
      if(var2.field288 == var1.field288) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(var1.field288 == Client.world) {
               return -1;
            }

            if(Client.world == var2.field288) {
               return 1;
            }
         }

         return var1.field288 < var2.field288?-1:1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;LIndexDataBase;I)V",
      garbageValue = "-921146373"
   )
   public static void method1756(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2) {
      class168.field2355 = var0;
      class254.field3407 = var1;
      class254.field3408 = var2;
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   class95(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;I)V",
      garbageValue = "-1883857908"
   )
   public static void method1761(IndexDataBase var0) {
      class241.field3282 = var0;
      class241.field3288 = class241.field3282.method4187(16);
   }

   public int compare(Object var1, Object var2) {
      return this.method1755((class14)var1, (class14)var2);
   }
}
