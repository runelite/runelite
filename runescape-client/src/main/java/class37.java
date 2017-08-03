import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public class class37 {
   @ObfuscatedName("t")
   @Export("isMembersWorld")
   static boolean isMembersWorld;
   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "[Lji;"
   )
   @Export("pkIcons")
   static SpritePixels[] pkIcons;
   @ObfuscatedName("nb")
   @ObfuscatedSignature(
      signature = "[Lbo;"
   )
   @Export("clanMembers")
   static XClanMember[] clanMembers;

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1447566932"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.isDynamicRegion = var0;
      int var1;
      int var2;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.isDynamicRegion) {
         var1 = Client.secretPacketBuffer2.readByteOb1();
         var2 = Client.secretPacketBuffer2.readByteOb1();
         int var3 = Client.secretPacketBuffer2.readUnsignedShort();
         class41.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class41.xteaKeys[var4][var5] = Client.secretPacketBuffer2.readInt();
            }
         }

         Buffer.mapRegions = new int[var3];
         class27.field373 = new int[var3];
         class12.landRegionFielIds = new int[var3];
         SoundTask.field1651 = new byte[var3][];
         CombatInfo1.field1250 = new byte[var3][];
         boolean var15 = false;
         if((var2 / 8 == 48 || var2 / 8 == 49) && var1 / 8 == 48) {
            var15 = true;
         }

         if(var2 / 8 == 48 && var1 / 8 == 148) {
            var15 = true;
         }

         var3 = 0;

         for(var5 = (var2 - 6) / 8; var5 <= (var2 + 6) / 8; ++var5) {
            for(var6 = (var1 - 6) / 8; var6 <= (var1 + 6) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var15 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  Buffer.mapRegions[var3] = var7;
                  class27.field373[var3] = Client.indexMaps.getFile("m" + var5 + "_" + var6);
                  class12.landRegionFielIds[var3] = Client.indexMaps.getFile("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class140.method2889(var2, var1, true);
      } else {
         var1 = Client.secretPacketBuffer2.method3236();
         var2 = Client.secretPacketBuffer2.readUnsignedShortOb1();
         boolean var14 = Client.secretPacketBuffer2.readUnsignedByte() == 1;
         var4 = Client.secretPacketBuffer2.readUnsignedShort();
         Client.secretPacketBuffer2.bitAccess();

         int var8;
         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var8 = Client.secretPacketBuffer2.getBits(1);
                  if(var8 == 1) {
                     Client.field956[var5][var6][var7] = Client.secretPacketBuffer2.getBits(26);
                  } else {
                     Client.field956[var5][var6][var7] = -1;
                  }
               }
            }
         }

         Client.secretPacketBuffer2.byteAccess();
         class41.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               class41.xteaKeys[var5][var6] = Client.secretPacketBuffer2.readInt();
            }
         }

         Buffer.mapRegions = new int[var4];
         class27.field373 = new int[var4];
         class12.landRegionFielIds = new int[var4];
         SoundTask.field1651 = new byte[var4][];
         CombatInfo1.field1250 = new byte[var4][];
         var4 = 0;

         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var8 = Client.field956[var5][var6][var7];
                  if(var8 != -1) {
                     int var9 = var8 >> 14 & 1023;
                     int var10 = var8 >> 3 & 2047;
                     int var11 = (var9 / 8 << 8) + var10 / 8;

                     int var12;
                     for(var12 = 0; var12 < var4; ++var12) {
                        if(Buffer.mapRegions[var12] == var11) {
                           var11 = -1;
                           break;
                        }
                     }

                     if(var11 != -1) {
                        Buffer.mapRegions[var4] = var11;
                        var12 = var11 >> 8 & 255;
                        int var13 = var11 & 255;
                        class27.field373[var4] = Client.indexMaps.getFile("m" + var12 + "_" + var13);
                        class12.landRegionFielIds[var4] = Client.indexMaps.getFile("l" + var12 + "_" + var13);
                        ++var4;
                     }
                  }
               }
            }
         }

         class140.method2889(var1, var2, !var14);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1534517752"
   )
   @Export("getSmoothNoise")
   static final int getSmoothNoise(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class82.getSmoothNoise2D(var3, var5);
      int var8 = class82.getSmoothNoise2D(var3 + 1, var5);
      int var9 = class82.getSmoothNoise2D(var3, var5 + 1);
      int var10 = class82.getSmoothNoise2D(var3 + 1, var5 + 1);
      int var12 = 65536 - Graphics3D.COSINE[var4 * 1024 / var2] >> 1;
      int var11 = (var12 * var8 >> 16) + ((65536 - var12) * var7 >> 16);
      int var14 = 65536 - Graphics3D.COSINE[var4 * 1024 / var2] >> 1;
      int var13 = (var10 * var14 >> 16) + ((65536 - var14) * var9 >> 16);
      int var16 = 65536 - Graphics3D.COSINE[var6 * 1024 / var2] >> 1;
      int var15 = ((65536 - var16) * var11 >> 16) + (var13 * var16 >> 16);
      return var15;
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "([Lhn;IIIIIIIB)V",
      garbageValue = "7"
   )
   static final void method510(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2745 || class169.getWidgetConfig(var9) != 0 || var9 == Client.field1057 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.hasScript || !class177.method3423(var9))) {
            int var10 = var9.relativeX + var6;
            int var11 = var7 + var9.relativeY;
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
               int var18 = var10 + var9.width;
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
               var17 = var11 + var9.height;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(var9 == Client.field912) {
               Client.field1064 = true;
               Client.field1065 = var10;
               Client.field942 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = MouseInput.field696;
               var17 = MouseInput.field705;
               if(MouseInput.field697 != 0) {
                  var16 = MouseInput.field709;
                  var17 = MouseInput.field713;
               }

               boolean var32 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
               if(var9.contentType == 1337) {
                  if(!Client.field900 && !Client.isMenuOpen && var32) {
                     DynamicObject.method1866(var16, var17, var12, var13);
                  }
               } else if(var9.contentType == 1338) {
                  Signlink.method2952(var9, var10, var11);
               } else {
                  if(var9.contentType == 1400) {
                     class7.renderOverview.method5196(MouseInput.field696, MouseInput.field705, var32, var10, var11, var9.width, var9.height);
                  }

                  if(!Client.isMenuOpen && var32) {
                     if(var9.contentType == 1400) {
                        class7.renderOverview.method5259(var10, var11, var9.width, var9.height, var16, var17);
                     } else {
                        class35.method497(var9, var16 - var10, var17 - var11);
                     }
                  }

                  if(var9.type == 0) {
                     if(!var9.hasScript && class177.method3423(var9) && var9 != class244.field3302) {
                        continue;
                     }

                     method510(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method510(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var27 = (WidgetNode)Client.componentTable.get((long)var9.id);
                     if(var27 != null) {
                        if(var27.owner == 0 && MouseInput.field696 >= var12 && MouseInput.field705 >= var13 && MouseInput.field696 < var14 && MouseInput.field705 < var15 && !Client.isMenuOpen && !Client.field1120) {
                           for(ScriptEvent var28 = (ScriptEvent)Client.field1082.getFront(); var28 != null; var28 = (ScriptEvent)Client.field1082.getNext()) {
                              if(var28.field811) {
                                 var28.unlink();
                                 var28.widget.field2754 = false;
                              }
                           }

                           if(Enum.field3384 == 0) {
                              Client.field912 = null;
                              Client.field1057 = null;
                           }

                           if(!Client.isMenuOpen) {
                              Client.menuOptionCount = 0;
                              Client.isMenuOpen = false;
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.field1013[0] = false;
                              Client.menuOptionCount = 1;
                           }
                        }

                        class46.method665(var27.id, var12, var13, var14, var15, var10, var11);
                     }
                  }

                  int var22;
                  int var23;
                  int var34;
                  if(var9.hasScript) {
                     ScriptEvent var36;
                     if(!var9.field2681) {
                        if(var9.field2763 && MouseInput.field696 >= var12 && MouseInput.field705 >= var13 && MouseInput.field696 < var14 && MouseInput.field705 < var15) {
                           for(var36 = (ScriptEvent)Client.field1082.getFront(); var36 != null; var36 = (ScriptEvent)Client.field1082.getNext()) {
                              if(var36.field811 && var36.widget.scrollListener == var36.field818) {
                                 var36.unlink();
                              }
                           }
                        }
                     } else if(MouseInput.field696 >= var12 && MouseInput.field705 >= var13 && MouseInput.field696 < var14 && MouseInput.field705 < var15) {
                        for(var36 = (ScriptEvent)Client.field1082.getFront(); var36 != null; var36 = (ScriptEvent)Client.field1082.getNext()) {
                           if(var36.field811) {
                              var36.unlink();
                              var36.widget.field2754 = false;
                           }
                        }

                        if(Enum.field3384 == 0) {
                           Client.field912 = null;
                           Client.field1057 = null;
                        }

                        if(!Client.isMenuOpen) {
                           Client.menuOptionCount = 0;
                           Client.isMenuOpen = false;
                           Client.menuOptions[0] = "Cancel";
                           Client.menuTargets[0] = "";
                           Client.menuTypes[0] = 1006;
                           Client.field1013[0] = false;
                           Client.menuOptionCount = 1;
                        }
                     }

                     if(MouseInput.field696 >= var12 && MouseInput.field705 >= var13 && MouseInput.field696 < var14 && MouseInput.field705 < var15) {
                        var32 = true;
                     } else {
                        var32 = false;
                     }

                     boolean var33 = false;
                     if((MouseInput.field704 == 1 || !class67.field792 && MouseInput.field704 == 4) && var32) {
                        var33 = true;
                     }

                     boolean var20 = false;
                     if((MouseInput.field697 == 1 || !class67.field792 && MouseInput.field697 == 4) && MouseInput.field709 >= var12 && MouseInput.field713 >= var13 && MouseInput.field709 < var14 && MouseInput.field713 < var15) {
                        var20 = true;
                     }

                     if(var20) {
                        class25.method171(var9, MouseInput.field709 - var10, MouseInput.field713 - var11);
                     }

                     if(var9.contentType == 1400) {
                        class7.renderOverview.method5197(MouseInput.field696, MouseInput.field705, var32 & var33);
                     }

                     if(Client.field912 != null && var9 != Client.field912 && var32) {
                        var22 = class169.getWidgetConfig(var9);
                        boolean var21 = (var22 >> 20 & 1) != 0;
                        if(var21) {
                           Client.field1060 = var9;
                        }
                     }

                     if(var9 == Client.field1057) {
                        Client.field1061 = true;
                        Client.field1062 = var10;
                        Client.field943 = var11;
                     }

                     if(var9.field2745) {
                        ScriptEvent var29;
                        if(var32 && Client.field1081 != 0 && var9.scrollListener != null) {
                           var29 = new ScriptEvent();
                           var29.field811 = true;
                           var29.widget = var9;
                           var29.field814 = Client.field1081;
                           var29.field818 = var9.scrollListener;
                           Client.field1082.addFront(var29);
                        }

                        if(Client.field912 != null || class18.field307 != null || Client.isMenuOpen) {
                           var20 = false;
                           var33 = false;
                           var32 = false;
                        }

                        if(!var9.field2755 && var20) {
                           var9.field2755 = true;
                           if(var9.field2711 != null) {
                              var29 = new ScriptEvent();
                              var29.field811 = true;
                              var29.widget = var9;
                              var29.field813 = MouseInput.field709 - var10;
                              var29.field814 = MouseInput.field713 - var11;
                              var29.field818 = var9.field2711;
                              Client.field1082.addFront(var29);
                           }
                        }

                        if(var9.field2755 && var33 && var9.field2707 != null) {
                           var29 = new ScriptEvent();
                           var29.field811 = true;
                           var29.widget = var9;
                           var29.field813 = MouseInput.field696 - var10;
                           var29.field814 = MouseInput.field705 - var11;
                           var29.field818 = var9.field2707;
                           Client.field1082.addFront(var29);
                        }

                        if(var9.field2755 && !var33) {
                           var9.field2755 = false;
                           if(var9.field2690 != null) {
                              var29 = new ScriptEvent();
                              var29.field811 = true;
                              var29.widget = var9;
                              var29.field813 = MouseInput.field696 - var10;
                              var29.field814 = MouseInput.field705 - var11;
                              var29.field818 = var9.field2690;
                              Client.field926.addFront(var29);
                           }
                        }

                        if(var33 && var9.field2714 != null) {
                           var29 = new ScriptEvent();
                           var29.field811 = true;
                           var29.widget = var9;
                           var29.field813 = MouseInput.field696 - var10;
                           var29.field814 = MouseInput.field705 - var11;
                           var29.field818 = var9.field2714;
                           Client.field1082.addFront(var29);
                        }

                        if(!var9.field2754 && var32) {
                           var9.field2754 = true;
                           if(var9.mouseEnterListener != null) {
                              var29 = new ScriptEvent();
                              var29.field811 = true;
                              var29.widget = var9;
                              var29.field813 = MouseInput.field696 - var10;
                              var29.field814 = MouseInput.field705 - var11;
                              var29.field818 = var9.mouseEnterListener;
                              Client.field1082.addFront(var29);
                           }
                        }

                        if(var9.field2754 && var32 && var9.mouseHoverListener != null) {
                           var29 = new ScriptEvent();
                           var29.field811 = true;
                           var29.widget = var9;
                           var29.field813 = MouseInput.field696 - var10;
                           var29.field814 = MouseInput.field705 - var11;
                           var29.field818 = var9.mouseHoverListener;
                           Client.field1082.addFront(var29);
                        }

                        if(var9.field2754 && !var32) {
                           var9.field2754 = false;
                           if(var9.mouseExitListener != null) {
                              var29 = new ScriptEvent();
                              var29.field811 = true;
                              var29.widget = var9;
                              var29.field813 = MouseInput.field696 - var10;
                              var29.field814 = MouseInput.field705 - var11;
                              var29.field818 = var9.mouseExitListener;
                              Client.field926.addFront(var29);
                           }
                        }

                        if(var9.renderListener != null) {
                           var29 = new ScriptEvent();
                           var29.widget = var9;
                           var29.field818 = var9.renderListener;
                           Client.field974.addFront(var29);
                        }

                        ScriptEvent var31;
                        if(var9.configListenerArgs != null && Client.field990 > var9.field2757) {
                           if(var9.configTriggers != null && Client.field990 - var9.field2757 <= 32) {
                              label816:
                              for(var34 = var9.field2757; var34 < Client.field990; ++var34) {
                                 var22 = Client.field1079[var34 & 31];

                                 for(var23 = 0; var23 < var9.configTriggers.length; ++var23) {
                                    if(var22 == var9.configTriggers[var23]) {
                                       var31 = new ScriptEvent();
                                       var31.widget = var9;
                                       var31.field818 = var9.configListenerArgs;
                                       Client.field1082.addFront(var31);
                                       break label816;
                                    }
                                 }
                              }
                           } else {
                              var29 = new ScriptEvent();
                              var29.widget = var9;
                              var29.field818 = var9.configListenerArgs;
                              Client.field1082.addFront(var29);
                           }

                           var9.field2757 = Client.field990;
                        }

                        if(var9.tableListenerArgs != null && Client.field1160 > var9.field2671) {
                           if(var9.tableModTriggers != null && Client.field1160 - var9.field2671 <= 32) {
                              label792:
                              for(var34 = var9.field2671; var34 < Client.field1160; ++var34) {
                                 var22 = Client.interfaceItemTriggers[var34 & 31];

                                 for(var23 = 0; var23 < var9.tableModTriggers.length; ++var23) {
                                    if(var22 == var9.tableModTriggers[var23]) {
                                       var31 = new ScriptEvent();
                                       var31.widget = var9;
                                       var31.field818 = var9.tableListenerArgs;
                                       Client.field1082.addFront(var31);
                                       break label792;
                                    }
                                 }
                              }
                           } else {
                              var29 = new ScriptEvent();
                              var29.widget = var9;
                              var29.field818 = var9.tableListenerArgs;
                              Client.field1082.addFront(var29);
                           }

                           var9.field2671 = Client.field1160;
                        }

                        if(var9.skillListenerArgs != null && Client.field1074 > var9.field2679) {
                           if(var9.skillTriggers != null && Client.field1074 - var9.field2679 <= 32) {
                              label768:
                              for(var34 = var9.field2679; var34 < Client.field1074; ++var34) {
                                 var22 = Client.field1142[var34 & 31];

                                 for(var23 = 0; var23 < var9.skillTriggers.length; ++var23) {
                                    if(var22 == var9.skillTriggers[var23]) {
                                       var31 = new ScriptEvent();
                                       var31.widget = var9;
                                       var31.field818 = var9.skillListenerArgs;
                                       Client.field1082.addFront(var31);
                                       break label768;
                                    }
                                 }
                              }
                           } else {
                              var29 = new ScriptEvent();
                              var29.widget = var9;
                              var29.field818 = var9.skillListenerArgs;
                              Client.field1082.addFront(var29);
                           }

                           var9.field2679 = Client.field1074;
                        }

                        if(Client.chatCycle > var9.field2756 && var9.field2731 != null) {
                           var29 = new ScriptEvent();
                           var29.widget = var9;
                           var29.field818 = var9.field2731;
                           Client.field1082.addFront(var29);
                        }

                        if(Client.field1076 > var9.field2756 && var9.field2677 != null) {
                           var29 = new ScriptEvent();
                           var29.widget = var9;
                           var29.field818 = var9.field2677;
                           Client.field1082.addFront(var29);
                        }

                        if(Client.field1077 > var9.field2756 && var9.field2631 != null) {
                           var29 = new ScriptEvent();
                           var29.widget = var9;
                           var29.field818 = var9.field2631;
                           Client.field1082.addFront(var29);
                        }

                        if(Client.field1133 > var9.field2756 && var9.field2762 != null) {
                           var29 = new ScriptEvent();
                           var29.widget = var9;
                           var29.field818 = var9.field2762;
                           Client.field1082.addFront(var29);
                        }

                        if(Client.field992 > var9.field2756 && var9.field2740 != null) {
                           var29 = new ScriptEvent();
                           var29.widget = var9;
                           var29.field818 = var9.field2740;
                           Client.field1082.addFront(var29);
                        }

                        if(Client.field893 > var9.field2756 && var9.field2705 != null) {
                           var29 = new ScriptEvent();
                           var29.widget = var9;
                           var29.field818 = var9.field2705;
                           Client.field1082.addFront(var29);
                        }

                        var9.field2756 = Client.cycleCntr;
                        if(var9.field2732 != null) {
                           for(var34 = 0; var34 < Client.field1033; ++var34) {
                              ScriptEvent var30 = new ScriptEvent();
                              var30.widget = var9;
                              var30.field817 = Client.field1107[var34];
                              var30.field810 = Client.field1106[var34];
                              var30.field818 = var9.field2732;
                              Client.field1082.addFront(var30);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && Client.field912 == null && class18.field307 == null && !Client.isMenuOpen) {
                     if((var9.field2760 >= 0 || var9.field2656 != 0) && MouseInput.field696 >= var12 && MouseInput.field705 >= var13 && MouseInput.field696 < var14 && MouseInput.field705 < var15) {
                        if(var9.field2760 >= 0) {
                           class244.field3302 = var0[var9.field2760];
                        } else {
                           class244.field3302 = var9;
                        }
                     }

                     if(var9.type == 8 && MouseInput.field696 >= var12 && MouseInput.field705 >= var13 && MouseInput.field696 < var14 && MouseInput.field705 < var15) {
                        class89.field1372 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        var19 = var10 + var9.width;
                        int var35 = var9.height;
                        var34 = var9.scrollHeight;
                        var22 = MouseInput.field696;
                        var23 = MouseInput.field705;
                        if(Client.field963) {
                           Client.field964 = 32;
                        } else {
                           Client.field964 = 0;
                        }

                        Client.field963 = false;
                        int var24;
                        if(MouseInput.field704 == 1 || !class67.field792 && MouseInput.field704 == 4) {
                           if(var22 >= var19 && var22 < var19 + 16 && var23 >= var11 && var23 < var11 + 16) {
                              var9.scrollY -= 4;
                              class48.method732(var9);
                           } else if(var22 >= var19 && var22 < var19 + 16 && var23 >= var11 + var35 - 16 && var23 < var11 + var35) {
                              var9.scrollY += 4;
                              class48.method732(var9);
                           } else if(var22 >= var19 - Client.field964 && var22 < var19 + Client.field964 + 16 && var23 >= var11 + 16 && var23 < var11 + var35 - 16) {
                              var24 = var35 * (var35 - 32) / var34;
                              if(var24 < 8) {
                                 var24 = 8;
                              }

                              int var25 = var23 - var11 - 16 - var24 / 2;
                              int var26 = var35 - 32 - var24;
                              var9.scrollY = var25 * (var34 - var35) / var26;
                              class48.method732(var9);
                              Client.field963 = true;
                           }
                        }

                        if(Client.field1081 != 0) {
                           var24 = var9.width;
                           if(var22 >= var19 - var24 && var23 >= var11 && var22 < var19 + 16 && var23 <= var11 + var35) {
                              var9.scrollY += Client.field1081 * 45;
                              class48.method732(var9);
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
