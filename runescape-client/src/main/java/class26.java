import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public class class26 {
   @ObfuscatedName("h")
   byte[] field613;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -720641046451742901L
   )
   long field614;
   @ObfuscatedName("c")
   DataInputStream field615;
   @ObfuscatedName("d")
   byte[] field616 = new byte[4];
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 776900901
   )
   int field617;
   @ObfuscatedName("j")
   class102 field618;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -646370601
   )
   int field620;
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = 623736675
   )
   static int field621;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1340541933
   )
   int field623;
   @ObfuscatedName("l")
   static Widget field624;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)LModIcon;",
      garbageValue = "-210983406"
   )
   public static ModIcon method600(class182 var0, String var1, String var2) {
      int var3 = var0.method3321(var1);
      int var4 = var0.method3322(var3, var2);
      return XItemContainer.method192(var0, var3, var4);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1576985976"
   )
   byte[] method601() throws IOException {
      if(class99.method2005() > this.field614) {
         throw new IOException();
      } else {
         if(this.field620 == 0) {
            if(this.field618.field1673 == 2) {
               throw new IOException();
            }

            if(this.field618.field1673 == 1) {
               this.field615 = (DataInputStream)this.field618.field1677;
               this.field620 = 1;
            }
         }

         if(this.field620 == 1) {
            this.field617 += this.field615.read(this.field616, this.field617, this.field616.length - this.field617);
            if(this.field617 == 4) {
               int var1 = (new Buffer(this.field616)).readInt();
               this.field613 = new byte[var1];
               this.field620 = 2;
            }
         }

         if(this.field620 == 2) {
            this.field623 += this.field615.read(this.field613, this.field623, this.field613.length - this.field623);
            if(this.field613.length == this.field623) {
               return this.field613;
            }
         }

         return null;
      }
   }

   class26(class103 var1, URL var2) {
      this.field618 = var1.method2036(var2);
      this.field620 = 0;
      this.field614 = class99.method2005() + 30000L;
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIII)V",
      garbageValue = "1836322894"
   )
   static final void method604(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(null != var9 && (!var9.hasScript || var9.type == 0 || var9.field2178 || class174.method3271(var9) != 0 || var9 == Client.field487 || var9.contentType == 1338) && var1 == var9.parentId && (!var9.hasScript || !class13.method195(var9))) {
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
               var16 = var9.width + var10;
               var17 = var9.height + var11;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(Client.field486 == var9) {
               Client.field450 = true;
               Client.field495 = var10;
               Client.field530 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = class115.field1807;
               var17 = class115.field1801;
               if(class115.field1813 != 0) {
                  var16 = class115.field1814;
                  var17 = class115.field1815;
               }

               if(var9.contentType == 1337) {
                  if(!Client.field318 && !Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     class13.method197(var16, var17, var12, var13);
                  }
               } else {
                  int var21;
                  int var22;
                  int var23;
                  if(var9.contentType == 1338) {
                     if((Client.field549 == 0 || Client.field549 == 3) && (class115.field1813 == 1 || !class202.field3076 && class115.field1813 == 4)) {
                        class164 var37 = var9.method3213(true);
                        if(null != var37) {
                           var19 = class115.field1814 - var10;
                           int var35 = class115.field1815 - var11;
                           if(var37.method3155(var19, var35)) {
                              var19 -= var37.field2146 / 2;
                              var35 -= var37.field2150 / 2;
                              var21 = Client.mapAngle + Client.mapScale & 2047;
                              var22 = class84.field1441[var21];
                              var23 = class84.field1462[var21];
                              var22 = (256 + Client.mapScaleDelta) * var22 >> 8;
                              var23 = (Client.mapScaleDelta + 256) * var23 >> 8;
                              int var24 = var23 * var19 + var22 * var35 >> 11;
                              int var25 = var23 * var35 - var19 * var22 >> 11;
                              int var26 = var24 + class22.localPlayer.x >> 7;
                              int var27 = class22.localPlayer.y - var25 >> 7;
                              Client.field309.method3076(95);
                              Client.field309.putByte(18);
                              Client.field309.method2855(class105.field1725[82]?(class105.field1725[81]?2:1):0);
                              Client.field309.method2909(var27 + class3.baseY);
                              Client.field309.method2909(var26 + CombatInfoListHolder.baseX);
                              Client.field309.putByte(var19);
                              Client.field309.putByte(var35);
                              Client.field309.putShort(Client.mapAngle);
                              Client.field309.putByte(57);
                              Client.field309.putByte(Client.mapScale);
                              Client.field309.putByte(Client.mapScaleDelta);
                              Client.field309.putByte(89);
                              Client.field309.putShort(class22.localPlayer.x);
                              Client.field309.putShort(class22.localPlayer.y);
                              Client.field309.putByte(63);
                              Client.flagX = var26;
                              Client.flagY = var27;
                           }
                        }
                     }
                  } else {
                     if(!Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                        class6.method91(var9, var16 - var10, var17 - var11);
                     }

                     if(var9.type == 0) {
                        if(!var9.hasScript && class13.method195(var9) && var9 != class1.field16) {
                           continue;
                        }

                        method604(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                        if(null != var9.children) {
                           method604(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                        }

                        WidgetNode var29 = (WidgetNode)Client.componentTable.method2405((long)var9.id);
                        if(var29 != null) {
                           if(var29.field212 == 0 && class115.field1807 >= var12 && class115.field1801 >= var13 && class115.field1807 < var14 && class115.field1801 < var15 && !Client.isMenuOpen && !Client.field562) {
                              for(class18 var30 = (class18)Client.field512.method2448(); var30 != null; var30 = (class18)Client.field512.method2445()) {
                                 if(var30.field237) {
                                    var30.unlink();
                                    var30.field223.field2311 = false;
                                 }
                              }

                              if(World.field709 == 0) {
                                 Client.field486 = null;
                                 Client.field487 = null;
                              }

                              if(!Client.isMenuOpen) {
                                 Client.menuOptionCount = 0;
                                 Client.field391 = -1;
                                 Client.isMenuOpen = false;
                                 Client.menuOptions[0] = "Cancel";
                                 Client.menuTargets[0] = "";
                                 Client.menuTypes[0] = 1006;
                                 Client.menuOptionCount = 1;
                              }
                           }

                           var19 = var29.id;
                           if(class44.method892(var19)) {
                              method604(Widget.widgets[var19], -1, var12, var13, var14, var15, var10, var11);
                           }
                        }
                     }

                     if(var9.hasScript) {
                        class18 var36;
                        if(!var9.field2287) {
                           if(var9.field2230 && class115.field1807 >= var12 && class115.field1801 >= var13 && class115.field1807 < var14 && class115.field1801 < var15) {
                              for(var36 = (class18)Client.field512.method2448(); null != var36; var36 = (class18)Client.field512.method2445()) {
                                 if(var36.field237 && var36.field223.field2317 == var36.field232) {
                                    var36.unlink();
                                 }
                              }
                           }
                        } else if(class115.field1807 >= var12 && class115.field1801 >= var13 && class115.field1807 < var14 && class115.field1801 < var15) {
                           for(var36 = (class18)Client.field512.method2448(); var36 != null; var36 = (class18)Client.field512.method2445()) {
                              if(var36.field237) {
                                 var36.unlink();
                                 var36.field223.field2311 = false;
                              }
                           }

                           if(World.field709 == 0) {
                              Client.field486 = null;
                              Client.field487 = null;
                           }

                           if(!Client.isMenuOpen) {
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.menuOptionCount = 1;
                           }
                        }

                        boolean var33;
                        if(class115.field1807 >= var12 && class115.field1801 >= var13 && class115.field1807 < var14 && class115.field1801 < var15) {
                           var33 = true;
                        } else {
                           var33 = false;
                        }

                        boolean var34 = false;
                        if((class115.field1806 == 1 || !class202.field3076 && class115.field1806 == 4) && var33) {
                           var34 = true;
                        }

                        boolean var20 = false;
                        if((class115.field1813 == 1 || !class202.field3076 && class115.field1813 == 4) && class115.field1814 >= var12 && class115.field1815 >= var13 && class115.field1814 < var14 && class115.field1815 < var15) {
                           var20 = true;
                        }

                        if(var20) {
                           class7.method95(var9, class115.field1814 - var10, class115.field1815 - var11);
                        }

                        if(null != Client.field486 && Client.field486 != var9 && var33 && ScriptState.method169(class174.method3271(var9))) {
                           Client.field490 = var9;
                        }

                        if(var9 == Client.field487) {
                           Client.field491 = true;
                           Client.field344 = var10;
                           Client.field590 = var11;
                        }

                        if(var9.field2178) {
                           class18 var28;
                           if(var33 && Client.field511 != 0 && null != var9.field2317) {
                              var28 = new class18();
                              var28.field237 = true;
                              var28.field223 = var9;
                              var28.field225 = Client.field511;
                              var28.field232 = var9.field2317;
                              Client.field512.method2458(var28);
                           }

                           if(Client.field486 != null || null != CombatInfoListHolder.field784 || Client.isMenuOpen) {
                              var20 = false;
                              var34 = false;
                              var33 = false;
                           }

                           if(!var9.field2312 && var20) {
                              var9.field2312 = true;
                              if(var9.field2268 != null) {
                                 var28 = new class18();
                                 var28.field237 = true;
                                 var28.field223 = var9;
                                 var28.field222 = class115.field1814 - var10;
                                 var28.field225 = class115.field1815 - var11;
                                 var28.field232 = var9.field2268;
                                 Client.field512.method2458(var28);
                              }
                           }

                           if(var9.field2312 && var34 && null != var9.field2253) {
                              var28 = new class18();
                              var28.field237 = true;
                              var28.field223 = var9;
                              var28.field222 = class115.field1807 - var10;
                              var28.field225 = class115.field1801 - var11;
                              var28.field232 = var9.field2253;
                              Client.field512.method2458(var28);
                           }

                           if(var9.field2312 && !var34) {
                              var9.field2312 = false;
                              if(var9.field2309 != null) {
                                 var28 = new class18();
                                 var28.field237 = true;
                                 var28.field223 = var9;
                                 var28.field222 = class115.field1807 - var10;
                                 var28.field225 = class115.field1801 - var11;
                                 var28.field232 = var9.field2309;
                                 Client.field514.method2458(var28);
                              }
                           }

                           if(var34 && var9.field2271 != null) {
                              var28 = new class18();
                              var28.field237 = true;
                              var28.field223 = var9;
                              var28.field222 = class115.field1807 - var10;
                              var28.field225 = class115.field1801 - var11;
                              var28.field232 = var9.field2271;
                              Client.field512.method2458(var28);
                           }

                           if(!var9.field2311 && var33) {
                              var9.field2311 = true;
                              if(var9.field2272 != null) {
                                 var28 = new class18();
                                 var28.field237 = true;
                                 var28.field223 = var9;
                                 var28.field222 = class115.field1807 - var10;
                                 var28.field225 = class115.field1801 - var11;
                                 var28.field232 = var9.field2272;
                                 Client.field512.method2458(var28);
                              }
                           }

                           if(var9.field2311 && var33 && var9.field2273 != null) {
                              var28 = new class18();
                              var28.field237 = true;
                              var28.field223 = var9;
                              var28.field222 = class115.field1807 - var10;
                              var28.field225 = class115.field1801 - var11;
                              var28.field232 = var9.field2273;
                              Client.field512.method2458(var28);
                           }

                           if(var9.field2311 && !var33) {
                              var9.field2311 = false;
                              if(null != var9.field2274) {
                                 var28 = new class18();
                                 var28.field237 = true;
                                 var28.field223 = var9;
                                 var28.field222 = class115.field1807 - var10;
                                 var28.field225 = class115.field1801 - var11;
                                 var28.field232 = var9.field2274;
                                 Client.field514.method2458(var28);
                              }
                           }

                           if(var9.field2285 != null) {
                              var28 = new class18();
                              var28.field223 = var9;
                              var28.field232 = var9.field2285;
                              Client.field513.method2458(var28);
                           }

                           class18 var32;
                           if(null != var9.field2279 && Client.field500 > var9.field2314) {
                              if(null != var9.field2280 && Client.field500 - var9.field2314 <= 32) {
                                 label818:
                                 for(var21 = var9.field2314; var21 < Client.field500; ++var21) {
                                    var22 = Client.field499[var21 & 31];

                                    for(var23 = 0; var23 < var9.field2280.length; ++var23) {
                                       if(var22 == var9.field2280[var23]) {
                                          var32 = new class18();
                                          var32.field223 = var9;
                                          var32.field232 = var9.field2279;
                                          Client.field512.method2458(var32);
                                          break label818;
                                       }
                                    }
                                 }
                              } else {
                                 var28 = new class18();
                                 var28.field223 = var9;
                                 var28.field232 = var9.field2279;
                                 Client.field512.method2458(var28);
                              }

                              var9.field2314 = Client.field500;
                           }

                           if(var9.field2281 != null && Client.field502 > var9.field2315) {
                              if(var9.field2205 != null && Client.field502 - var9.field2315 <= 32) {
                                 label794:
                                 for(var21 = var9.field2315; var21 < Client.field502; ++var21) {
                                    var22 = Client.interfaceItemTriggers[var21 & 31];

                                    for(var23 = 0; var23 < var9.field2205.length; ++var23) {
                                       if(var9.field2205[var23] == var22) {
                                          var32 = new class18();
                                          var32.field223 = var9;
                                          var32.field232 = var9.field2281;
                                          Client.field512.method2458(var32);
                                          break label794;
                                       }
                                    }
                                 }
                              } else {
                                 var28 = new class18();
                                 var28.field223 = var9;
                                 var28.field232 = var9.field2281;
                                 Client.field512.method2458(var28);
                              }

                              var9.field2315 = Client.field502;
                           }

                           if(null != var9.field2283 && Client.field504 > var9.field2316) {
                              if(var9.field2245 != null && Client.field504 - var9.field2316 <= 32) {
                                 label770:
                                 for(var21 = var9.field2316; var21 < Client.field504; ++var21) {
                                    var22 = Client.field516[var21 & 31];

                                    for(var23 = 0; var23 < var9.field2245.length; ++var23) {
                                       if(var22 == var9.field2245[var23]) {
                                          var32 = new class18();
                                          var32.field223 = var9;
                                          var32.field232 = var9.field2283;
                                          Client.field512.method2458(var32);
                                          break label770;
                                       }
                                    }
                                 }
                              } else {
                                 var28 = new class18();
                                 var28.field223 = var9;
                                 var28.field232 = var9.field2283;
                                 Client.field512.method2458(var28);
                              }

                              var9.field2316 = Client.field504;
                           }

                           if(Client.field505 > var9.field2313 && var9.field2288 != null) {
                              var28 = new class18();
                              var28.field223 = var9;
                              var28.field232 = var9.field2288;
                              Client.field512.method2458(var28);
                           }

                           if(Client.field506 > var9.field2313 && var9.field2290 != null) {
                              var28 = new class18();
                              var28.field223 = var9;
                              var28.field232 = var9.field2290;
                              Client.field512.method2458(var28);
                           }

                           if(Client.field507 > var9.field2313 && var9.field2291 != null) {
                              var28 = new class18();
                              var28.field223 = var9;
                              var28.field232 = var9.field2291;
                              Client.field512.method2458(var28);
                           }

                           if(Client.field545 > var9.field2313 && null != var9.field2296) {
                              var28 = new class18();
                              var28.field223 = var9;
                              var28.field232 = var9.field2296;
                              Client.field512.method2458(var28);
                           }

                           if(Client.field509 > var9.field2313 && null != var9.field2299) {
                              var28 = new class18();
                              var28.field223 = var9;
                              var28.field232 = var9.field2299;
                              Client.field512.method2458(var28);
                           }

                           if(Client.field510 > var9.field2313 && var9.field2292 != null) {
                              var28 = new class18();
                              var28.field223 = var9;
                              var28.field232 = var9.field2292;
                              Client.field512.method2458(var28);
                           }

                           var9.field2313 = Client.field498;
                           if(null != var9.field2289) {
                              for(var21 = 0; var21 < Client.field474; ++var21) {
                                 class18 var31 = new class18();
                                 var31.field223 = var9;
                                 var31.field230 = Client.field538[var21];
                                 var31.field229 = Client.field537[var21];
                                 var31.field232 = var9.field2289;
                                 Client.field512.method2458(var31);
                              }
                           }
                        }
                     }

                     if(!var9.hasScript && null == Client.field486 && CombatInfoListHolder.field784 == null && !Client.isMenuOpen) {
                        if((var9.field2204 >= 0 || var9.field2223 != 0) && class115.field1807 >= var12 && class115.field1801 >= var13 && class115.field1807 < var14 && class115.field1801 < var15) {
                           if(var9.field2204 >= 0) {
                              class1.field16 = var0[var9.field2204];
                           } else {
                              class1.field16 = var9;
                           }
                        }

                        if(var9.type == 8 && class115.field1807 >= var12 && class115.field1801 >= var13 && class115.field1807 < var14 && class115.field1801 < var15) {
                           FloorUnderlayDefinition.field2809 = var9;
                        }

                        if(var9.scrollHeight > var9.height) {
                           NPC.method794(var9, var9.width + var10, var11, var9.height, var9.scrollHeight, class115.field1807, class115.field1801);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "1544454017"
   )
   static void method605(Widget var0) {
      Widget var1 = var0.parentId == -1?null:World.method670(var0.parentId);
      int var2;
      int var3;
      if(var1 == null) {
         var2 = class108.field1748;
         var3 = class145.field2018;
      } else {
         var2 = var1.width;
         var3 = var1.height;
      }

      class150.method2799(var0, var2, var3, false);
      class2.method35(var0, var2, var3);
   }
}
