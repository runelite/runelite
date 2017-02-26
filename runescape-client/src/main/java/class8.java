import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class8 {
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = -998633261
   )
   static int field81;
   @ObfuscatedName("bt")
   static ModIcon field84;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILclass48;ZB)I",
      garbageValue = "-3"
   )
   static int method94(int var0, Script var1, boolean var2) {
      if(var0 == 5000) {
         class32.scriptIntStack[++class103.scriptIntStackSize - 1] = Client.field588;
         return 1;
      } else if(var0 == 5001) {
         class103.scriptIntStackSize -= 3;
         Client.field588 = class32.scriptIntStack[class103.scriptIntStackSize];
         class177.field2674 = class114.method2264(class32.scriptIntStack[class103.scriptIntStackSize + 1]);
         if(class177.field2674 == null) {
            class177.field2674 = class216.field3179;
         }

         Client.field524 = class32.scriptIntStack[2 + class103.scriptIntStackSize];
         Client.field348.method3073(37);
         Client.field348.method2918(Client.field588);
         Client.field348.method2918(class177.field2674.field3181);
         Client.field348.method2918(Client.field524);
         return 1;
      } else {
         String var3;
         int var9;
         int var10;
         if(var0 == 5002) {
            var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
            class103.scriptIntStackSize -= 2;
            var9 = class32.scriptIntStack[class103.scriptIntStackSize];
            var10 = class32.scriptIntStack[class103.scriptIntStackSize + 1];
            Client.field348.method3073(90);
            Client.field348.method2918(class119.method2340(var3) + 2);
            Client.field348.method2824(var3);
            Client.field348.method2918(var9 - 1);
            Client.field348.method2918(var10);
            return 1;
         } else {
            int var11;
            if(var0 == 5003) {
               class103.scriptIntStackSize -= 2;
               var11 = class32.scriptIntStack[class103.scriptIntStackSize];
               var9 = class32.scriptIntStack[class103.scriptIntStackSize + 1];
               MessageNode var15 = FloorUnderlayDefinition.method3496(var11, var9);
               if(var15 != null) {
                  class32.scriptIntStack[++class103.scriptIntStackSize - 1] = var15.id;
                  class32.scriptIntStack[++class103.scriptIntStackSize - 1] = var15.tick;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var15.name != null?var15.name:"";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var15.sender != null?var15.sender:"";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = null != var15.value?var15.value:"";
               } else {
                  class32.scriptIntStack[++class103.scriptIntStackSize - 1] = -1;
                  class32.scriptIntStack[++class103.scriptIntStackSize - 1] = 0;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 5004) {
               var11 = class32.scriptIntStack[--class103.scriptIntStackSize];
               MessageNode var14 = (MessageNode)class47.field951.method2372((long)var11);
               if(null != var14) {
                  class32.scriptIntStack[++class103.scriptIntStackSize - 1] = var14.type;
                  class32.scriptIntStack[++class103.scriptIntStackSize - 1] = var14.tick;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var14.name != null?var14.name:"";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = null != var14.sender?var14.sender:"";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = null != var14.value?var14.value:"";
               } else {
                  class32.scriptIntStack[++class103.scriptIntStackSize - 1] = -1;
                  class32.scriptIntStack[++class103.scriptIntStackSize - 1] = 0;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 5005) {
               if(null == class177.field2674) {
                  class32.scriptIntStack[++class103.scriptIntStackSize - 1] = -1;
               } else {
                  class32.scriptIntStack[++class103.scriptIntStackSize - 1] = class177.field2674.field3181;
               }

               return 1;
            } else if(var0 == 5008) {
               var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
               var9 = class32.scriptIntStack[--class103.scriptIntStackSize];
               String var5 = var3.toLowerCase();
               byte var16 = 0;
               if(var5.startsWith("yellow:")) {
                  var16 = 0;
                  var3 = var3.substring("yellow:".length());
               } else if(var5.startsWith("red:")) {
                  var16 = 1;
                  var3 = var3.substring("red:".length());
               } else if(var5.startsWith("green:")) {
                  var16 = 2;
                  var3 = var3.substring("green:".length());
               } else if(var5.startsWith("cyan:")) {
                  var16 = 3;
                  var3 = var3.substring("cyan:".length());
               } else if(var5.startsWith("purple:")) {
                  var16 = 4;
                  var3 = var3.substring("purple:".length());
               } else if(var5.startsWith("white:")) {
                  var16 = 5;
                  var3 = var3.substring("white:".length());
               } else if(var5.startsWith("flash1:")) {
                  var16 = 6;
                  var3 = var3.substring("flash1:".length());
               } else if(var5.startsWith("flash2:")) {
                  var16 = 7;
                  var3 = var3.substring("flash2:".length());
               } else if(var5.startsWith("flash3:")) {
                  var16 = 8;
                  var3 = var3.substring("flash3:".length());
               } else if(var5.startsWith("glow1:")) {
                  var16 = 9;
                  var3 = var3.substring("glow1:".length());
               } else if(var5.startsWith("glow2:")) {
                  var16 = 10;
                  var3 = var3.substring("glow2:".length());
               } else if(var5.startsWith("glow3:")) {
                  var16 = 11;
                  var3 = var3.substring("glow3:".length());
               } else if(Client.field309 != 0) {
                  if(var5.startsWith("yellow:")) {
                     var16 = 0;
                     var3 = var3.substring("yellow:".length());
                  } else if(var5.startsWith("red:")) {
                     var16 = 1;
                     var3 = var3.substring("red:".length());
                  } else if(var5.startsWith("green:")) {
                     var16 = 2;
                     var3 = var3.substring("green:".length());
                  } else if(var5.startsWith("cyan:")) {
                     var16 = 3;
                     var3 = var3.substring("cyan:".length());
                  } else if(var5.startsWith("purple:")) {
                     var16 = 4;
                     var3 = var3.substring("purple:".length());
                  } else if(var5.startsWith("white:")) {
                     var16 = 5;
                     var3 = var3.substring("white:".length());
                  } else if(var5.startsWith("flash1:")) {
                     var16 = 6;
                     var3 = var3.substring("flash1:".length());
                  } else if(var5.startsWith("flash2:")) {
                     var16 = 7;
                     var3 = var3.substring("flash2:".length());
                  } else if(var5.startsWith("flash3:")) {
                     var16 = 8;
                     var3 = var3.substring("flash3:".length());
                  } else if(var5.startsWith("glow1:")) {
                     var16 = 9;
                     var3 = var3.substring("glow1:".length());
                  } else if(var5.startsWith("glow2:")) {
                     var16 = 10;
                     var3 = var3.substring("glow2:".length());
                  } else if(var5.startsWith("glow3:")) {
                     var16 = 11;
                     var3 = var3.substring("glow3:".length());
                  }
               }

               var5 = var3.toLowerCase();
               byte var12 = 0;
               if(var5.startsWith("wave:")) {
                  var12 = 1;
                  var3 = var3.substring("wave:".length());
               } else if(var5.startsWith("wave2:")) {
                  var12 = 2;
                  var3 = var3.substring("wave2:".length());
               } else if(var5.startsWith("shake:")) {
                  var12 = 3;
                  var3 = var3.substring("shake:".length());
               } else if(var5.startsWith("scroll:")) {
                  var12 = 4;
                  var3 = var3.substring("scroll:".length());
               } else if(var5.startsWith("slide:")) {
                  var12 = 5;
                  var3 = var3.substring("slide:".length());
               } else if(Client.field309 != 0) {
                  if(var5.startsWith("wave:")) {
                     var12 = 1;
                     var3 = var3.substring("wave:".length());
                  } else if(var5.startsWith("wave2:")) {
                     var12 = 2;
                     var3 = var3.substring("wave2:".length());
                  } else if(var5.startsWith("shake:")) {
                     var12 = 3;
                     var3 = var3.substring("shake:".length());
                  } else if(var5.startsWith("scroll:")) {
                     var12 = 4;
                     var3 = var3.substring("scroll:".length());
                  } else if(var5.startsWith("slide:")) {
                     var12 = 5;
                     var3 = var3.substring("slide:".length());
                  }
               }

               Client.field348.method3073(172);
               Client.field348.method2918(0);
               int var8 = Client.field348.offset;
               Client.field348.method2918(var9);
               Client.field348.method2918(var16);
               Client.field348.method2918(var12);
               class182.method3377(Client.field348, var3);
               Client.field348.method2830(Client.field348.offset - var8);
               return 1;
            } else if(var0 == 5009) {
               class32.scriptStringStackSize -= 2;
               var3 = class32.scriptStringStack[class32.scriptStringStackSize];
               String var13 = class32.scriptStringStack[1 + class32.scriptStringStackSize];
               Client.field348.method3073(56);
               Client.field348.method2831(0);
               var10 = Client.field348.offset;
               Client.field348.method2824(var3);
               class182.method3377(Client.field348, var13);
               Client.field348.method2829(Client.field348.offset - var10);
               return 1;
            } else if(var0 != 5015) {
               if(var0 == 5016) {
                  class32.scriptIntStack[++class103.scriptIntStackSize - 1] = Client.field524;
                  return 1;
               } else if(var0 == 5017) {
                  var11 = class32.scriptIntStack[--class103.scriptIntStackSize];
                  int[] var4 = class32.scriptIntStack;
                  var10 = ++class103.scriptIntStackSize - 1;
                  ChatLineBuffer var7 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var11));
                  int var6;
                  if(null == var7) {
                     var6 = 0;
                  } else {
                     var6 = var7.method979();
                  }

                  var4[var10] = var6;
                  return 1;
               } else if(var0 == 5018) {
                  var11 = class32.scriptIntStack[--class103.scriptIntStackSize];
                  class32.scriptIntStack[++class103.scriptIntStackSize - 1] = World.method650(var11);
                  return 1;
               } else if(var0 == 5019) {
                  var11 = class32.scriptIntStack[--class103.scriptIntStackSize];
                  class32.scriptIntStack[++class103.scriptIntStackSize - 1] = class188.method3457(var11);
                  return 1;
               } else if(var0 == 5020) {
                  var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
                  class44.method886(var3);
                  return 1;
               } else if(var0 == 5021) {
                  Client.field525 = class32.scriptStringStack[--class32.scriptStringStackSize].toLowerCase().trim();
                  return 1;
               } else if(var0 == 5022) {
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = Client.field525;
                  return 1;
               } else {
                  return 2;
               }
            } else {
		    //5015
               if(null != class36.localPlayer && null != class36.localPlayer.name) {
                  var3 = class36.localPlayer.name;
               } else {
                  var3 = "";
               }

               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3;
               return 1;
            }
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILclass48;ZI)I",
      garbageValue = "-655991608"
   )
   static int method95(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class179.method3296(class32.scriptIntStack[--class103.scriptIntStackSize]);
      } else {
         var3 = var2?XGrandExchangeOffer.field58:XClanMember.field297;
      }

      String var4 = class32.scriptStringStack[--class32.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 89) {
         int var8 = class32.scriptIntStack[--class103.scriptIntStackSize];
         if(var8 > 0) {
            for(var5 = new int[var8]; var8-- > 0; var5[var8] = class32.scriptIntStack[--class103.scriptIntStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var6 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var6.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 115) {
            var6[var7] = class32.scriptStringStack[--class32.scriptStringStackSize];
         } else {
            var6[var7] = new Integer(class32.scriptIntStack[--class103.scriptIntStackSize]);
         }
      }

      var7 = class32.scriptIntStack[--class103.scriptIntStackSize];
      if(var7 != -1) {
         var6[0] = new Integer(var7);
      } else {
         var6 = null;
      }

      if(var0 == 1400) {
         var3.field2287 = var6;
      } else if(var0 == 1401) {
         var3.field2290 = var6;
      } else if(var0 == 1402) {
         var3.field2286 = var6;
      } else if(var0 == 1403) {
         var3.field2266 = var6;
      } else if(var0 == 1404) {
         var3.field2293 = var6;
      } else if(var0 == 1405) {
         var3.field2282 = var6;
      } else if(var0 == 1406) {
         var3.field2206 = var6;
      } else if(var0 == 1407) {
         var3.field2227 = var6;
         var3.field2299 = var5;
      } else if(var0 == 1408) {
         var3.field2304 = var6;
      } else if(var0 == 1409) {
         var3.field2274 = var6;
      } else if(var0 == 1410) {
         var3.field2295 = var6;
      } else if(var0 == 1411) {
         var3.field2288 = var6;
      } else if(var0 == 1412) {
         var3.field2292 = var6;
      } else if(var0 == 1414) {
         var3.field2203 = var6;
         var3.field2301 = var5;
      } else if(var0 == 1415) {
         var3.field2302 = var6;
         var3.field2303 = var5;
      } else if(var0 == 1416) {
         var3.field2296 = var6;
      } else if(var0 == 1417) {
         var3.field2208 = var6;
      } else if(var0 == 1418) {
         var3.field2307 = var6;
      } else if(var0 == 1419) {
         var3.field2284 = var6;
      } else if(var0 == 1420) {
         var3.field2311 = var6;
      } else if(var0 == 1421) {
         var3.field2310 = var6;
      } else if(var0 == 1422) {
         var3.field2330 = var6;
      } else if(var0 == 1423) {
         var3.field2298 = var6;
      } else if(var0 == 1424) {
         var3.field2200 = var6;
      } else if(var0 == 1425) {
         var3.field2315 = var6;
      } else if(var0 == 1426) {
         var3.field2316 = var6;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2211 = var6;
      }

      var3.field2309 = true;
      return 1;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1375979516"
   )
   static void method96() {
      Client.field348.method3073(227);
      Client.field348.method2918(method97());
      Client.field348.method2831(class32.field758);
      Client.field348.method2831(class47.field950);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-20"
   )
   static int method97() {
      return Client.isResized?2:1;
   }

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIII)V",
      garbageValue = "-715102453"
   )
   static final void method98(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(null != var9 && (!var9.hasScript || var9.type == 0 || var9.field2309 || class196.method3614(var9) != 0 || var9 == Client.field530 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.hasScript || !VertexNormal.method1683(var9))) {
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
               int var18 = var10 + var9.width;
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

            if(Client.field523 == var9) {
               Client.field455 = true;
               Client.field531 = var10;
               Client.field488 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = class115.field1792;
               var17 = class115.field1799;
               if(class115.field1804 != 0) {
                  var16 = class115.field1796;
                  var17 = class115.field1806;
               }

               if(var9.contentType == 1337) {
                  if(!Client.field373 && !Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     class37.method821(var16, var17, var12, var13);
                  }
               } else if(var9.contentType == 1338) {
                  ScriptState.method151(var9, var10, var11);
               } else {
                  if(!Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     class37.method817(var9, var16 - var10, var17 - var11);
                  }

                  if(var9.type == 0) {
                     if(!var9.hasScript && VertexNormal.method1683(var9) && class114.field1787 != var9) {
                        continue;
                     }

                     method98(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method98(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var26 = (WidgetNode)Client.componentTable.method2399((long)var9.id);
                     if(var26 != null) {
                        if(var26.field189 == 0 && class115.field1792 >= var12 && class115.field1799 >= var13 && class115.field1792 < var14 && class115.field1799 < var15 && !Client.isMenuOpen && !Client.field505) {
                           for(class18 var27 = (class18)Client.field435.method2458(); null != var27; var27 = (class18)Client.field435.method2472()) {
                              if(var27.field213) {
                                 var27.unlink();
                                 var27.field198.field2229 = false;
                              }
                           }

                           if(class45.field922 == 0) {
                              Client.field523 = null;
                              Client.field530 = null;
                           }

                           if(!Client.isMenuOpen) {
                              class152.method2814();
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.menuOptionCount = 1;
                           }
                        }

                        var19 = var26.id;
                        if(class30.method696(var19)) {
                           method98(Widget.widgets[var19], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  if(var9.hasScript) {
                     class18 var31;
                     if(!var9.field2232) {
                        if(var9.field2199 && class115.field1792 >= var12 && class115.field1799 >= var13 && class115.field1792 < var14 && class115.field1799 < var15) {
                           for(var31 = (class18)Client.field435.method2458(); var31 != null; var31 = (class18)Client.field435.method2472()) {
                              if(var31.field213 && var31.field198.field2208 == var31.field209) {
                                 var31.unlink();
                              }
                           }
                        }
                     } else if(class115.field1792 >= var12 && class115.field1799 >= var13 && class115.field1792 < var14 && class115.field1799 < var15) {
                        for(var31 = (class18)Client.field435.method2458(); var31 != null; var31 = (class18)Client.field435.method2472()) {
                           if(var31.field213) {
                              var31.unlink();
                              var31.field198.field2229 = false;
                           }
                        }

                        if(class45.field922 == 0) {
                           Client.field523 = null;
                           Client.field530 = null;
                        }

                        if(!Client.isMenuOpen) {
                           Client.menuOptions[0] = "Cancel";
                           Client.menuTargets[0] = "";
                           Client.menuTypes[0] = 1006;
                           Client.menuOptionCount = 1;
                        }
                     }

                     boolean var29;
                     if(class115.field1792 >= var12 && class115.field1799 >= var13 && class115.field1792 < var14 && class115.field1799 < var15) {
                        var29 = true;
                     } else {
                        var29 = false;
                     }

                     boolean var30 = false;
                     if((class115.field1794 == 1 || !class15.field173 && class115.field1794 == 4) && var29) {
                        var30 = true;
                     }

                     boolean var20 = false;
                     if((class115.field1804 == 1 || !class15.field173 && class115.field1804 == 4) && class115.field1796 >= var12 && class115.field1806 >= var13 && class115.field1796 < var14 && class115.field1806 < var15) {
                        var20 = true;
                     }

                     if(var20) {
                        Friend.method176(var9, class115.field1796 - var10, class115.field1806 - var11);
                     }

                     if(Client.field523 != null && Client.field523 != var9 && var29 && class160.method3108(class196.method3614(var9))) {
                        Client.field343 = var9;
                     }

                     if(var9 == Client.field530) {
                        Client.field516 = true;
                        Client.field319 = var10;
                        Client.field485 = var11;
                     }

                     if(var9.field2309) {
                        class18 var21;
                        if(var29 && Client.field503 != 0 && null != var9.field2208) {
                           var21 = new class18();
                           var21.field213 = true;
                           var21.field198 = var9;
                           var21.field200 = Client.field503;
                           var21.field209 = var9.field2208;
                           Client.field435.method2453(var21);
                        }

                        if(Client.field523 != null || class0.field7 != null || Client.isMenuOpen) {
                           var20 = false;
                           var30 = false;
                           var29 = false;
                        }

                        if(!var9.field2264 && var20) {
                           var9.field2264 = true;
                           if(var9.field2287 != null) {
                              var21 = new class18();
                              var21.field213 = true;
                              var21.field198 = var9;
                              var21.field205 = class115.field1796 - var10;
                              var21.field200 = class115.field1806 - var11;
                              var21.field209 = var9.field2287;
                              Client.field435.method2453(var21);
                           }
                        }

                        if(var9.field2264 && var30 && var9.field2288 != null) {
                           var21 = new class18();
                           var21.field213 = true;
                           var21.field198 = var9;
                           var21.field205 = class115.field1792 - var10;
                           var21.field200 = class115.field1799 - var11;
                           var21.field209 = var9.field2288;
                           Client.field435.method2453(var21);
                        }

                        if(var9.field2264 && !var30) {
                           var9.field2264 = false;
                           if(null != var9.field2286) {
                              var21 = new class18();
                              var21.field213 = true;
                              var21.field198 = var9;
                              var21.field205 = class115.field1792 - var10;
                              var21.field200 = class115.field1799 - var11;
                              var21.field209 = var9.field2286;
                              Client.field506.method2453(var21);
                           }
                        }

                        if(var30 && var9.field2290 != null) {
                           var21 = new class18();
                           var21.field213 = true;
                           var21.field198 = var9;
                           var21.field205 = class115.field1792 - var10;
                           var21.field200 = class115.field1799 - var11;
                           var21.field209 = var9.field2290;
                           Client.field435.method2453(var21);
                        }

                        if(!var9.field2229 && var29) {
                           var9.field2229 = true;
                           if(var9.field2266 != null) {
                              var21 = new class18();
                              var21.field213 = true;
                              var21.field198 = var9;
                              var21.field205 = class115.field1792 - var10;
                              var21.field200 = class115.field1799 - var11;
                              var21.field209 = var9.field2266;
                              Client.field435.method2453(var21);
                           }
                        }

                        if(var9.field2229 && var29 && null != var9.field2292) {
                           var21 = new class18();
                           var21.field213 = true;
                           var21.field198 = var9;
                           var21.field205 = class115.field1792 - var10;
                           var21.field200 = class115.field1799 - var11;
                           var21.field209 = var9.field2292;
                           Client.field435.method2453(var21);
                        }

                        if(var9.field2229 && !var29) {
                           var9.field2229 = false;
                           if(null != var9.field2293) {
                              var21 = new class18();
                              var21.field213 = true;
                              var21.field198 = var9;
                              var21.field205 = class115.field1792 - var10;
                              var21.field200 = class115.field1799 - var11;
                              var21.field209 = var9.field2293;
                              Client.field506.method2453(var21);
                           }
                        }

                        if(null != var9.field2304) {
                           var21 = new class18();
                           var21.field198 = var9;
                           var21.field209 = var9.field2304;
                           Client.field543.method2453(var21);
                        }

                        int var23;
                        class18 var24;
                        int var25;
                        int var28;
                        if(var9.field2227 != null && Client.field535 > var9.field2233) {
                           if(null != var9.field2299 && Client.field535 - var9.field2233 <= 32) {
                              label757:
                              for(var25 = var9.field2233; var25 < Client.field535; ++var25) {
                                 var28 = Client.field445[var25 & 31];

                                 for(var23 = 0; var23 < var9.field2299.length; ++var23) {
                                    if(var28 == var9.field2299[var23]) {
                                       var24 = new class18();
                                       var24.field198 = var9;
                                       var24.field209 = var9.field2227;
                                       Client.field435.method2453(var24);
                                       break label757;
                                    }
                                 }
                              }
                           } else {
                              var21 = new class18();
                              var21.field198 = var9;
                              var21.field209 = var9.field2227;
                              Client.field435.method2453(var21);
                           }

                           var9.field2233 = Client.field535;
                        }

                        if(var9.field2203 != null && Client.field494 > var9.field2334) {
                           if(var9.field2301 != null && Client.field494 - var9.field2334 <= 32) {
                              label733:
                              for(var25 = var9.field2334; var25 < Client.field494; ++var25) {
                                 var28 = Client.interfaceItemTriggers[var25 & 31];

                                 for(var23 = 0; var23 < var9.field2301.length; ++var23) {
                                    if(var28 == var9.field2301[var23]) {
                                       var24 = new class18();
                                       var24.field198 = var9;
                                       var24.field209 = var9.field2203;
                                       Client.field435.method2453(var24);
                                       break label733;
                                    }
                                 }
                              }
                           } else {
                              var21 = new class18();
                              var21.field198 = var9;
                              var21.field209 = var9.field2203;
                              Client.field435.method2453(var21);
                           }

                           var9.field2334 = Client.field494;
                        }

                        if(var9.field2302 != null && Client.field460 > var9.field2335) {
                           if(null != var9.field2303 && Client.field460 - var9.field2335 <= 32) {
                              label709:
                              for(var25 = var9.field2335; var25 < Client.field460; ++var25) {
                                 var28 = Client.field495[var25 & 31];

                                 for(var23 = 0; var23 < var9.field2303.length; ++var23) {
                                    if(var9.field2303[var23] == var28) {
                                       var24 = new class18();
                                       var24.field198 = var9;
                                       var24.field209 = var9.field2302;
                                       Client.field435.method2453(var24);
                                       break label709;
                                    }
                                 }
                              }
                           } else {
                              var21 = new class18();
                              var21.field198 = var9;
                              var21.field209 = var9.field2302;
                              Client.field435.method2453(var21);
                           }

                           var9.field2335 = Client.field460;
                        }

                        if(Client.field497 > var9.field2332 && null != var9.field2307) {
                           var21 = new class18();
                           var21.field198 = var9;
                           var21.field209 = var9.field2307;
                           Client.field435.method2453(var21);
                        }

                        if(Client.field451 > var9.field2332 && var9.field2311 != null) {
                           var21 = new class18();
                           var21.field198 = var9;
                           var21.field209 = var9.field2311;
                           Client.field435.method2453(var21);
                        }

                        if(Client.field499 > var9.field2332 && var9.field2310 != null) {
                           var21 = new class18();
                           var21.field198 = var9;
                           var21.field209 = var9.field2310;
                           Client.field435.method2453(var21);
                        }

                        if(Client.field500 > var9.field2332 && null != var9.field2315) {
                           var21 = new class18();
                           var21.field198 = var9;
                           var21.field209 = var9.field2315;
                           Client.field435.method2453(var21);
                        }

                        if(Client.field440 > var9.field2332 && null != var9.field2316) {
                           var21 = new class18();
                           var21.field198 = var9;
                           var21.field209 = var9.field2316;
                           Client.field435.method2453(var21);
                        }

                        if(Client.field502 > var9.field2332 && var9.field2330 != null) {
                           var21 = new class18();
                           var21.field198 = var9;
                           var21.field209 = var9.field2330;
                           Client.field435.method2453(var21);
                        }

                        var9.field2332 = Client.field490;
                        if(var9.field2284 != null) {
                           for(var25 = 0; var25 < Client.field528; ++var25) {
                              class18 var22 = new class18();
                              var22.field198 = var9;
                              var22.field203 = Client.field323[var25];
                              var22.field204 = Client.field529[var25];
                              var22.field209 = var9.field2284;
                              Client.field435.method2453(var22);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && null == Client.field523 && null == class0.field7 && !Client.isMenuOpen) {
                     if((var9.field2314 >= 0 || var9.field2249 != 0) && class115.field1792 >= var12 && class115.field1799 >= var13 && class115.field1792 < var14 && class115.field1799 < var15) {
                        if(var9.field2314 >= 0) {
                           class114.field1787 = var0[var9.field2314];
                        } else {
                           class114.field1787 = var9;
                        }
                     }

                     if(var9.type == 8 && class115.field1792 >= var12 && class115.field1799 >= var13 && class115.field1792 < var14 && class115.field1799 < var15) {
                        class171.field2344 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        class116.method2304(var9, var9.width + var10, var11, var9.height, var9.scrollHeight, class115.field1792, class115.field1799);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LModIcon;I)V",
      garbageValue = "-2140673660"
   )
   static final void method99(ModIcon var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class41.field854.length; ++var2) {
         class41.field854[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class41.field854[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               MessageNode.field242[var5] = (class41.field854[128 + var5] + class41.field854[var5 - 128] + class41.field854[var5 - 1] + class41.field854[1 + var5]) / 4;
            }
         }

         int[] var8 = class41.field854;
         class41.field854 = MessageNode.field242;
         MessageNode.field242 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var0.offsetX + 16 + var4;
                  int var6 = 16 + var3 + var0.offsetY;
                  int var7 = var5 + (var6 << 7);
                  class41.field854[var7] = 0;
               }
            }
         }
      }

   }

   class8() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-297612881"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(Client.gameState != var0) {
         if(Client.gameState == 0) {
            class5.field65 = null;
            Varbit.field2849 = null;
            class13.field156 = null;
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.field518 = 0;
            Client.field361 = 0;
            Client.field341 = 0;
         }

         if(var0 != 20 && var0 != 40 && null != class159.field2130) {
            class159.field2130.method2118();
            class159.field2130 = null;
         }

         if(Client.gameState == 25) {
            Client.field364 = 0;
            Client.field360 = 0;
            Client.field486 = 1;
            Client.field362 = 0;
            Client.field381 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               MessageNode.method216(GameObject.canvas, class38.field821, class165.field2167, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               MessageNode.method216(GameObject.canvas, class38.field821, class165.field2167, false, 4);
            } else if(class41.field841) {
               class41.field871 = null;
               class203.field3076 = null;
               ChatLineBuffer.field989 = null;
               class5.field60 = null;
               XGrandExchangeOffer.field57 = null;
               XGrandExchangeOffer.field46 = null;
               class41.field874 = null;
               class37.field813 = null;
               class41.field842 = null;
               class32.field744 = null;
               Ignore.field221 = null;
               class36.field797 = null;
               class10.field101 = null;
               field84 = null;
               class211.field3128 = null;
               class31.field722 = null;
               class5.field61 = null;
               class41.field847 = null;
               class41.field854 = null;
               MessageNode.field242 = null;
               class41.field872 = null;
               VertexNormal.field1443 = null;
               class118.method2335(2);
               class110.method2137(true);
               class41.field841 = false;
            }
         } else {
            MessageNode.method216(GameObject.canvas, class38.field821, class165.field2167, true, 0);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(LNPCComposition;IIIB)V",
      garbageValue = "-65"
   )
   static final void method101(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(null != var0.configs) {
            var0 = var0.method3735();
         }

         if(null != var0) {
            if(var0.field3035) {
               if(!var0.field3002 || Client.field514 == var1) {
                  String var4 = var0.name;
                  int var7;
                  int var8;
                  if(var0.combatLevel != 0) {
                     var7 = var0.combatLevel;
                     var8 = class36.localPlayer.combatLevel;
                     int var9 = var8 - var7;
                     String var6;
                     if(var9 < -9) {
                        var6 = class18.method199(16711680);
                     } else if(var9 < -6) {
                        var6 = class18.method199(16723968);
                     } else if(var9 < -3) {
                        var6 = class18.method199(16740352);
                     } else if(var9 < 0) {
                        var6 = class18.method199(16756736);
                     } else if(var9 > 9) {
                        var6 = class18.method199('\uff00');
                     } else if(var9 > 6) {
                        var6 = class18.method199(4259584);
                     } else if(var9 > 3) {
                        var6 = class18.method199(8453888);
                     } else if(var9 > 0) {
                        var6 = class18.method199(12648192);
                     } else {
                        var6 = class18.method199(16776960);
                     }

                     var4 = var4 + var6 + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3002 && Client.field314) {
                     class115.addMenuEntry("Examine", class18.method199(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.field458 == 1) {
                     class115.addMenuEntry("Use", Client.field459 + " " + "->" + " " + class18.method199(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.field511) {
                     if((class31.field739 & 2) == 2) {
                        class115.addMenuEntry(Client.field463, Client.field380 + " " + "->" + " " + class18.method199(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var10 = var0.field3002 && Client.field314?2000:0;
                     String[] var11 = var0.actions;
                     if(Client.field476) {
                        var11 = class119.method2343(var11);
                     }

                     if(null != var11) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(null != var11[var7] && !var11[var7].equalsIgnoreCase("Attack")) {
                              var8 = 0;
                              if(var7 == 0) {
                                 var8 = 9 + var10;
                              }

                              if(var7 == 1) {
                                 var8 = 10 + var10;
                              }

                              if(var7 == 2) {
                                 var8 = 11 + var10;
                              }

                              if(var7 == 3) {
                                 var8 = 12 + var10;
                              }

                              if(var7 == 4) {
                                 var8 = 13 + var10;
                              }

                              class115.addMenuEntry(var11[var7], class18.method199(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(null != var11) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var11[var7] != null && var11[var7].equalsIgnoreCase("Attack")) {
                              short var12 = 0;
                              if(Client.field332 != class40.field836) {
                                 if(class40.field829 == Client.field332 || class40.field831 == Client.field332 && var0.combatLevel > class36.localPlayer.combatLevel) {
                                    var12 = 2000;
                                 }

                                 var8 = 0;
                                 if(var7 == 0) {
                                    var8 = var12 + 9;
                                 }

                                 if(var7 == 1) {
                                    var8 = 10 + var12;
                                 }

                                 if(var7 == 2) {
                                    var8 = 11 + var12;
                                 }

                                 if(var7 == 3) {
                                    var8 = var12 + 12;
                                 }

                                 if(var7 == 4) {
                                    var8 = 13 + var12;
                                 }

                                 class115.addMenuEntry(var11[var7], class18.method199(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3002 || !Client.field314) {
                        class115.addMenuEntry("Examine", class18.method199(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }
}
