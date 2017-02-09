import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public class class15 {
   @ObfuscatedName("o")
   static final class15 field161 = new class15();
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      intValue = 1207309837
   )
   static int field162;
   @ObfuscatedName("y")
   static final class15 field163 = new class15();
   @ObfuscatedName("r")
   static final class15 field164 = new class15();
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 930387721
   )
   public static int field165;
   @ObfuscatedName("k")
   static final class15 field166 = new class15();

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIB)V",
      garbageValue = "-26"
   )
   static final void method192(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2129 || class88.method1872(var9) != 0 || Client.field420 == var9 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.hasScript || !class48.method894(var9))) {
            int var10 = var6 + var9.relativeX;
            int var11 = var7 + var9.relativeY;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var28;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.type == 9) {
               var16 = var10;
               var17 = var11;
               int var18 = var10 + var9.width;
               var28 = var11 + var9.height;
               if(var18 < var10) {
                  var16 = var18;
                  var18 = var10;
               }

               if(var28 < var11) {
                  var17 = var28;
                  var28 = var11;
               }

               ++var18;
               ++var28;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var18 < var4?var18:var4;
               var15 = var28 < var5?var28:var5;
            } else {
               var16 = var10 + var9.width;
               var17 = var9.height + var11;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(var9 == Client.field450) {
               Client.field458 = true;
               Client.field375 = var10;
               Client.field555 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = class115.field1799;
               var17 = class115.field1794;
               if(class115.field1804 != 0) {
                  var16 = class115.field1800;
                  var17 = class115.field1807;
               }

               if(var9.contentType == 1337) {
                  if(!Client.field287 && !Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     CombatInfoListHolder.method731(var16, var17, var12, var13);
                  }
               } else {
                  int var22;
                  int var23;
                  int var30;
                  if(var9.contentType == 1338) {
                     if((Client.field514 == 0 || Client.field514 == 3) && (class115.field1804 == 1 || !class115.field1809 && class115.field1804 == 4)) {
                        class145 var37 = var9.method2778(true);
                        if(null != var37) {
                           var28 = class115.field1800 - var10;
                           int var34 = class115.field1807 - var11;
                           if(var37.method2726(var28, var34)) {
                              var28 -= var37.field2007 / 2;
                              var34 -= var37.field2004 / 2;
                              var30 = Client.mapScale + Client.mapAngle & 2047;
                              var22 = class84.field1428[var30];
                              var23 = class84.field1452[var30];
                              var22 = (Client.mapScaleDelta + 256) * var22 >> 8;
                              var23 = (Client.mapScaleDelta + 256) * var23 >> 8;
                              int var31 = var22 * var34 + var28 * var23 >> 11;
                              int var25 = var34 * var23 - var22 * var28 >> 11;
                              int var26 = var31 + VertexNormal.localPlayer.x >> 7;
                              int var27 = VertexNormal.localPlayer.y - var25 >> 7;
                              Client.field321.method3195(57);
                              Client.field321.method2912(18);
                              Client.field321.method2959(var26 + class114.baseX);
                              Client.field321.method3094(var27 + CombatInfo1.baseY);
                              Client.field321.method2952(class105.field1712[82]?(class105.field1712[81]?2:1):0);
                              Client.field321.method2912(var28);
                              Client.field321.method2912(var34);
                              Client.field321.method3094(Client.mapAngle);
                              Client.field321.method2912(57);
                              Client.field321.method2912(Client.mapScale);
                              Client.field321.method2912(Client.mapScaleDelta);
                              Client.field321.method2912(89);
                              Client.field321.method3094(VertexNormal.localPlayer.x);
                              Client.field321.method3094(VertexNormal.localPlayer.y);
                              Client.field321.method2912(63);
                              Client.flagX = var26;
                              Client.flagY = var27;
                           }
                        }
                     }
                  } else {
                     if(!Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                        class47.method889(var9, var16 - var10, var17 - var11);
                     }

                     if(var9.type == 0) {
                        if(!var9.hasScript && class48.method894(var9) && var9 != class138.field1907) {
                           continue;
                        }

                        method192(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                        if(null != var9.children) {
                           method192(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                        }

                        WidgetNode var29 = (WidgetNode)Client.componentTable.method2331((long)var9.id);
                        if(var29 != null) {
                           if(var29.field178 == 0 && class115.field1799 >= var12 && class115.field1794 >= var13 && class115.field1799 < var14 && class115.field1794 < var15 && !Client.isMenuOpen && !Client.field486) {
                              for(class18 var19 = (class18)Client.field476.method2403(); var19 != null; var19 = (class18)Client.field476.method2398()) {
                                 if(var19.field192) {
                                    var19.unlink();
                                    var19.field190.field2174 = false;
                                 }
                              }

                              if(MessageNode.field230 == 0) {
                                 Client.field450 = null;
                                 Client.field420 = null;
                              }

                              if(!Client.isMenuOpen) {
                                 Client.menuOptions[0] = "Cancel";
                                 Client.menuTargets[0] = "";
                                 Client.menuTypes[0] = 1006;
                                 Client.menuOptionCount = 1;
                              }
                           }

                           class7.method112(var29.id, var12, var13, var14, var15, var10, var11);
                        }
                     }

                     if(var9.hasScript) {
                        class18 var35;
                        if(!var9.field2182) {
                           if(var9.field2183 && class115.field1799 >= var12 && class115.field1794 >= var13 && class115.field1799 < var14 && class115.field1794 < var15) {
                              for(var35 = (class18)Client.field476.method2403(); null != var35; var35 = (class18)Client.field476.method2398()) {
                                 if(var35.field192 && var35.field198 == var35.field190.field2106) {
                                    var35.unlink();
                                 }
                              }
                           }
                        } else if(class115.field1799 >= var12 && class115.field1794 >= var13 && class115.field1799 < var14 && class115.field1794 < var15) {
                           for(var35 = (class18)Client.field476.method2403(); var35 != null; var35 = (class18)Client.field476.method2398()) {
                              if(var35.field192) {
                                 var35.unlink();
                                 var35.field190.field2174 = false;
                              }
                           }

                           if(MessageNode.field230 == 0) {
                              Client.field450 = null;
                              Client.field420 = null;
                           }

                           if(!Client.isMenuOpen) {
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.menuOptionCount = 1;
                           }
                        }

                        boolean var33;
                        if(class115.field1799 >= var12 && class115.field1794 >= var13 && class115.field1799 < var14 && class115.field1794 < var15) {
                           var33 = true;
                        } else {
                           var33 = false;
                        }

                        boolean var36 = false;
                        if((class115.field1805 == 1 || !class115.field1809 && class115.field1805 == 4) && var33) {
                           var36 = true;
                        }

                        boolean var20 = false;
                        if((class115.field1804 == 1 || !class115.field1809 && class115.field1804 == 4) && class115.field1800 >= var12 && class115.field1807 >= var13 && class115.field1800 < var14 && class115.field1807 < var15) {
                           var20 = true;
                        }

                        if(var20) {
                           class25.method611(var9, class115.field1800 - var10, class115.field1807 - var11);
                        }

                        if(null != Client.field450 && Client.field450 != var9 && var33 && class16.method197(class88.method1872(var9))) {
                           Client.field454 = var9;
                        }

                        if(var9 == Client.field420) {
                           Client.field388 = true;
                           Client.field456 = var10;
                           Client.field457 = var11;
                        }

                        if(var9.field2129) {
                           class18 var21;
                           if(var33 && Client.field475 != 0 && null != var9.field2106) {
                              var21 = new class18();
                              var21.field192 = true;
                              var21.field190 = var9;
                              var21.field188 = Client.field475;
                              var21.field198 = var9.field2106;
                              Client.field476.method2380(var21);
                           }

                           if(Client.field450 != null || class178.field2665 != null || Client.isMenuOpen) {
                              var20 = false;
                              var36 = false;
                              var33 = false;
                           }

                           if(!var9.field2175 && var20) {
                              var9.field2175 = true;
                              if(null != var9.field2131) {
                                 var21 = new class18();
                                 var21.field192 = true;
                                 var21.field190 = var9;
                                 var21.field191 = class115.field1800 - var10;
                                 var21.field188 = class115.field1807 - var11;
                                 var21.field198 = var9.field2131;
                                 Client.field476.method2380(var21);
                              }
                           }

                           if(var9.field2175 && var36 && null != var9.field2132) {
                              var21 = new class18();
                              var21.field192 = true;
                              var21.field190 = var9;
                              var21.field191 = class115.field1799 - var10;
                              var21.field188 = class115.field1794 - var11;
                              var21.field198 = var9.field2132;
                              Client.field476.method2380(var21);
                           }

                           if(var9.field2175 && !var36) {
                              var9.field2175 = false;
                              if(var9.field2133 != null) {
                                 var21 = new class18();
                                 var21.field192 = true;
                                 var21.field190 = var9;
                                 var21.field191 = class115.field1799 - var10;
                                 var21.field188 = class115.field1794 - var11;
                                 var21.field198 = var9.field2133;
                                 Client.field478.method2380(var21);
                              }
                           }

                           if(var36 && var9.field2134 != null) {
                              var21 = new class18();
                              var21.field192 = true;
                              var21.field190 = var9;
                              var21.field191 = class115.field1799 - var10;
                              var21.field188 = class115.field1794 - var11;
                              var21.field198 = var9.field2134;
                              Client.field476.method2380(var21);
                           }

                           if(!var9.field2174 && var33) {
                              var9.field2174 = true;
                              if(null != var9.field2135) {
                                 var21 = new class18();
                                 var21.field192 = true;
                                 var21.field190 = var9;
                                 var21.field191 = class115.field1799 - var10;
                                 var21.field188 = class115.field1794 - var11;
                                 var21.field198 = var9.field2135;
                                 Client.field476.method2380(var21);
                              }
                           }

                           if(var9.field2174 && var33 && null != var9.field2136) {
                              var21 = new class18();
                              var21.field192 = true;
                              var21.field190 = var9;
                              var21.field191 = class115.field1799 - var10;
                              var21.field188 = class115.field1794 - var11;
                              var21.field198 = var9.field2136;
                              Client.field476.method2380(var21);
                           }

                           if(var9.field2174 && !var33) {
                              var9.field2174 = false;
                              if(null != var9.field2137) {
                                 var21 = new class18();
                                 var21.field192 = true;
                                 var21.field190 = var9;
                                 var21.field191 = class115.field1799 - var10;
                                 var21.field188 = class115.field1794 - var11;
                                 var21.field198 = var9.field2137;
                                 Client.field478.method2380(var21);
                              }
                           }

                           if(null != var9.field2148) {
                              var21 = new class18();
                              var21.field190 = var9;
                              var21.field198 = var9.field2148;
                              Client.field477.method2380(var21);
                           }

                           class18 var24;
                           if(var9.field2073 != null && Client.field561 > var9.field2085) {
                              if(null != var9.field2127 && Client.field561 - var9.field2085 <= 32) {
                                 label802:
                                 for(var30 = var9.field2085; var30 < Client.field561; ++var30) {
                                    var22 = Client.field393[var30 & 31];

                                    for(var23 = 0; var23 < var9.field2127.length; ++var23) {
                                       if(var22 == var9.field2127[var23]) {
                                          var24 = new class18();
                                          var24.field190 = var9;
                                          var24.field198 = var9.field2073;
                                          Client.field476.method2380(var24);
                                          break label802;
                                       }
                                    }
                                 }
                              } else {
                                 var21 = new class18();
                                 var21.field190 = var9;
                                 var21.field198 = var9.field2073;
                                 Client.field476.method2380(var21);
                              }

                              var9.field2085 = Client.field561;
                           }

                           if(var9.field2144 != null && Client.field466 > var9.field2178) {
                              if(var9.field2145 != null && Client.field466 - var9.field2178 <= 32) {
                                 label778:
                                 for(var30 = var9.field2178; var30 < Client.field466; ++var30) {
                                    var22 = Client.interfaceItemTriggers[var30 & 31];

                                    for(var23 = 0; var23 < var9.field2145.length; ++var23) {
                                       if(var9.field2145[var23] == var22) {
                                          var24 = new class18();
                                          var24.field190 = var9;
                                          var24.field198 = var9.field2144;
                                          Client.field476.method2380(var24);
                                          break label778;
                                       }
                                    }
                                 }
                              } else {
                                 var21 = new class18();
                                 var21.field190 = var9;
                                 var21.field198 = var9.field2144;
                                 Client.field476.method2380(var21);
                              }

                              var9.field2178 = Client.field466;
                           }

                           if(var9.field2086 != null && Client.field468 > var9.field2149) {
                              if(null != var9.field2147 && Client.field468 - var9.field2149 <= 32) {
                                 label754:
                                 for(var30 = var9.field2149; var30 < Client.field468; ++var30) {
                                    var22 = Client.field448[var30 & 31];

                                    for(var23 = 0; var23 < var9.field2147.length; ++var23) {
                                       if(var9.field2147[var23] == var22) {
                                          var24 = new class18();
                                          var24.field190 = var9;
                                          var24.field198 = var9.field2086;
                                          Client.field476.method2380(var24);
                                          break label754;
                                       }
                                    }
                                 }
                              } else {
                                 var21 = new class18();
                                 var21.field190 = var9;
                                 var21.field198 = var9.field2086;
                                 Client.field476.method2380(var21);
                              }

                              var9.field2149 = Client.field468;
                           }

                           if(Client.field469 > var9.field2166 && null != var9.field2070) {
                              var21 = new class18();
                              var21.field190 = var9;
                              var21.field198 = var9.field2070;
                              Client.field476.method2380(var21);
                           }

                           if(Client.field470 > var9.field2166 && var9.field2153 != null) {
                              var21 = new class18();
                              var21.field190 = var9;
                              var21.field198 = var9.field2153;
                              Client.field476.method2380(var21);
                           }

                           if(Client.field471 > var9.field2166 && null != var9.field2154) {
                              var21 = new class18();
                              var21.field190 = var9;
                              var21.field198 = var9.field2154;
                              Client.field476.method2380(var21);
                           }

                           if(Client.field415 > var9.field2166 && null != var9.field2159) {
                              var21 = new class18();
                              var21.field190 = var9;
                              var21.field198 = var9.field2159;
                              Client.field476.method2380(var21);
                           }

                           if(Client.field293 > var9.field2166 && var9.field2055 != null) {
                              var21 = new class18();
                              var21.field190 = var9;
                              var21.field198 = var9.field2055;
                              Client.field476.method2380(var21);
                           }

                           if(Client.field474 > var9.field2166 && var9.field2155 != null) {
                              var21 = new class18();
                              var21.field190 = var9;
                              var21.field198 = var9.field2155;
                              Client.field476.method2380(var21);
                           }

                           var9.field2166 = Client.field462;
                           if(var9.field2152 != null) {
                              for(var30 = 0; var30 < Client.field500; ++var30) {
                                 class18 var32 = new class18();
                                 var32.field190 = var9;
                                 var32.field195 = Client.field502[var30];
                                 var32.field196 = Client.field501[var30];
                                 var32.field198 = var9.field2152;
                                 Client.field476.method2380(var32);
                              }
                           }
                        }
                     }

                     if(!var9.hasScript && null == Client.field450 && null == class178.field2665 && !Client.isMenuOpen) {
                        if((var9.field2146 >= 0 || var9.field2076 != 0) && class115.field1799 >= var12 && class115.field1794 >= var13 && class115.field1799 < var14 && class115.field1794 < var15) {
                           if(var9.field2146 >= 0) {
                              class138.field1907 = var0[var9.field2146];
                           } else {
                              class138.field1907 = var9;
                           }
                        }

                        if(var9.type == 8 && class115.field1799 >= var12 && class115.field1794 >= var13 && class115.field1799 < var14 && class115.field1794 < var15) {
                           class137.field1893 = var9;
                        }

                        if(var9.scrollHeight > var9.height) {
                           class166.method3183(var9, var9.width + var10, var11, var9.height, var9.scrollHeight, class115.field1799, class115.field1794);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "115"
   )
   public static boolean method193(int var0) {
      if(Widget.validInterfaces[var0]) {
         return true;
      } else if(!class156.field2213.method3276(var0)) {
         return false;
      } else {
         int var1 = class156.field2213.method3283(var0);
         if(var1 == 0) {
            Widget.validInterfaces[var0] = true;
            return true;
         } else {
            if(null == Widget.widgets[var0]) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(Widget.widgets[var0][var2] == null) {
                  byte[] var3 = class156.field2213.getConfigData(var0, var2);
                  if(var3 != null) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].method2776(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].method2806(new Buffer(var3));
                     }
                  }
               }
            }

            Widget.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILclass116;Lclass184;B)V",
      garbageValue = "98"
   )
   static void method194(int var0, class116 var1, class184 var2) {
      byte[] var3 = null;
      Deque var4 = class183.field2714;
      synchronized(class183.field2714) {
         for(class180 var5 = (class180)class183.field2714.method2403(); null != var5; var5 = (class180)class183.field2714.method2398()) {
            if(var5.hash == (long)var0 && var1 == var5.field2683 && var5.field2685 == 0) {
               var3 = var5.field2682;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method3387(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method2236(var0);
         var2.method3387(var1, var0, var8, true);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "346258358"
   )
   public static char method195(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      if(var0 == 338) {
         return 'O';
      } else if(var0 == 339) {
         return 'o';
      } else if(var0 == 376) {
         return 'Y';
      } else {
         return var0;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BI)Ljava/lang/String;",
      garbageValue = "-1611821689"
   )
   public static String method196(byte[] var0) {
      int var2 = var0.length;
      StringBuilder var3 = new StringBuilder();

      for(int var4 = 0; var4 < var2 + 0; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class206.field3076[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class206.field3076[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class206.field3076[(var6 & 15) << 2 | var7 >>> 6]).append(class206.field3076[var7 & 63]);
            } else {
               var3.append(class206.field3076[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class206.field3076[(var5 & 3) << 4]).append("==");
         }
      }

      String var1 = var3.toString();
      return var1;
   }
}
