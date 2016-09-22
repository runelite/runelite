import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
public class class59 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -747673619
   )
   int field1246 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 37108593
   )
   int field1247 = 0;
   @ObfuscatedName("ac")
   class69[] field1248 = new class69[8];
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1228711837
   )
   int field1249 = 0;
   @ObfuscatedName("i")
   class69 field1250;
   @ObfuscatedName("n")
   int[] field1251;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1860123019
   )
   int field1252 = 32;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -2914564610652817557L
   )
   long field1253 = class5.method63();
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 358893959
   )
   int field1254;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1976816265
   )
   int field1255;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -175574989
   )
   int field1256;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -8213576787016797081L
   )
   long field1257 = 0L;
   @ObfuscatedName("o")
   boolean field1258 = true;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1040882935
   )
   int field1259 = 0;
   @ObfuscatedName("r")
   static class75 field1260;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 3328922648673189187L
   )
   long field1261 = 0L;
   @ObfuscatedName("d")
   static boolean field1262;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1094862561
   )
   public static int field1265;
   @ObfuscatedName("f")
   class69[] field1266 = new class69[8];
   @ObfuscatedName("t")
   public static int[] field1268;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public final synchronized void method1235() {
      if(null != this.field1251) {
         long var1 = class5.method63();

         try {
            if(this.field1257 != 0L) {
               if(var1 < this.field1257) {
                  return;
               }

               this.vmethod1566(this.field1254);
               this.field1257 = 0L;
               this.field1258 = true;
            }

            int var3 = this.vmethod1563();
            if(this.field1246 - var3 > this.field1247) {
               this.field1247 = this.field1246 - var3;
            }

            int var4 = this.field1255 + this.field1256;
            if(256 + var4 > 16384) {
               var4 = 16128;
            }

            if(256 + var4 > this.field1254) {
               this.field1254 += 1024;
               if(this.field1254 > 16384) {
                  this.field1254 = 16384;
               }

               this.vmethod1565();
               this.vmethod1566(this.field1254);
               var3 = 0;
               this.field1258 = true;
               if(var4 + 256 > this.field1254) {
                  var4 = this.field1254 - 256;
                  this.field1256 = var4 - this.field1255;
               }
            }

            while(var3 < var4) {
               this.method1241(this.field1251, 256);
               this.vmethod1564();
               var3 += 256;
            }

            if(var1 > this.field1261) {
               if(!this.field1258) {
                  if(this.field1247 == 0 && this.field1259 == 0) {
                     this.vmethod1565();
                     this.field1257 = 2000L + var1;
                     return;
                  }

                  this.field1256 = Math.min(this.field1259, this.field1247);
                  this.field1259 = this.field1247;
               } else {
                  this.field1258 = false;
               }

               this.field1247 = 0;
               this.field1261 = 2000L + var1;
            }

            this.field1246 = var3;
         } catch (Exception var7) {
            this.vmethod1565();
            this.field1257 = var1 + 2000L;
         }

         try {
            if(var1 > 500000L + this.field1253) {
               var1 = this.field1253;
            }

            while(var1 > this.field1253 + 5000L) {
               this.method1239(256);
               this.field1253 += (long)(256000 / field1265);
            }
         } catch (Exception var6) {
            this.field1253 = var1;
         }

      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1668147311"
   )
   public final void method1236() {
      this.field1258 = true;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1606272651"
   )
   public final synchronized void method1237() {
      this.field1258 = true;

      try {
         this.vmethod1571();
      } catch (Exception var2) {
         this.vmethod1565();
         this.field1257 = class5.method63() + 2000L;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-148537161"
   )
   final void method1239(int var1) {
      this.field1249 -= var1;
      if(this.field1249 < 0) {
         this.field1249 = 0;
      }

      if(this.field1250 != null) {
         this.field1250.vmethod3749(var1);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1244119636"
   )
   public final synchronized void method1240() {
      if(null != field1260) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(field1260.field1424[var2] == this) {
               field1260.field1424[var2] = null;
            }

            if(field1260.field1424[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            field1260.field1419 = true;

            while(field1260.field1422) {
               Item.method681(50L);
            }

            field1260 = null;
         }
      }

      this.vmethod1565();
      this.field1251 = null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1241(int[] var1, int var2) {
      int var3 = var2;
      if(field1262) {
         var3 = var2 << 1;
      }

      class123.method2760(var1, 0, var3);
      this.field1249 -= var2;
      if(null != this.field1250 && this.field1249 <= 0) {
         this.field1249 += field1265 >> 4;
         Item.method677(this.field1250);
         this.method1272(this.field1250, this.field1250.vmethod1513());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class69 var10;
         label137:
         for(var6 = 7; var5 != 0; --var6) {
            int var16;
            int var17;
            if(var6 < 0) {
               var16 = var6 & 3;
               var17 = -(var6 >> 2);
            } else {
               var16 = var6;
               var17 = 0;
            }

            for(int var9 = var5 >>> var16 & 286331153; var9 != 0; var9 >>>= 4) {
               if((var9 & 1) != 0) {
                  var5 &= ~(1 << var16);
                  var10 = null;
                  class69 var11 = this.field1266[var16];

                  label131:
                  while(true) {
                     while(true) {
                        if(null == var11) {
                           break label131;
                        }

                        class68 var12 = var11.field1335;
                        if(null != var12 && var12.field1334 > var17) {
                           var5 |= 1 << var16;
                           var10 = var11;
                           var11 = var11.field1337;
                        } else {
                           var11.field1338 = true;
                           int var13 = var11.vmethod3747();
                           var4 += var13;
                           if(null != var12) {
                              var12.field1334 += var13;
                           }

                           if(var4 >= this.field1252) {
                              break label137;
                           }

                           class69 var14 = var11.vmethod3745();
                           if(var14 != null) {
                              for(int var18 = var11.field1336; null != var14; var14 = var11.vmethod3756()) {
                                 this.method1272(var14, var18 * var14.vmethod1513() >> 8);
                              }
                           }

                           class69 var15 = var11.field1337;
                           var11.field1337 = null;
                           if(var10 == null) {
                              this.field1266[var16] = var15;
                           } else {
                              var10.field1337 = var15;
                           }

                           if(var15 == null) {
                              this.field1248[var16] = var10;
                           }

                           var11 = var15;
                        }
                     }
                  }
               }

               var16 += 4;
               ++var17;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class69 var7 = this.field1266[var6];
            class69[] var8 = this.field1266;
            this.field1248[var6] = null;

            for(var8[var6] = null; null != var7; var7 = var10) {
               var10 = var7.field1337;
               var7.field1337 = null;
            }
         }
      }

      if(this.field1249 < 0) {
         this.field1249 = 0;
      }

      if(null != this.field1250) {
         this.field1250.vmethod3751(var1, 0, var2);
      }

      this.field1253 = class5.method63();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1930277508"
   )
   void vmethod1561(Component var1) throws Exception {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass69;B)V",
      garbageValue = "90"
   )
   public final synchronized void method1243(class69 var1) {
      this.field1250 = var1;
   }

   @ObfuscatedName("q")
   void vmethod1564() throws Exception {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-142755678"
   )
   void vmethod1565() {
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1830537427"
   )
   void vmethod1571() throws Exception {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-20243"
   )
   int vmethod1563() throws Exception {
      return this.field1254;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "48"
   )
   void vmethod1566(int var1) throws Exception {
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass69;II)V",
      garbageValue = "-1380874953"
   )
   final void method1272(class69 var1, int var2) {
      int var3 = var2 >> 5;
      class69 var4 = this.field1248[var3];
      if(null == var4) {
         this.field1266[var3] = var1;
      } else {
         var4.field1337 = var1;
      }

      this.field1248[var3] = var1;
      var1.field1336 = var2;
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIII)V",
      garbageValue = "-1099082215"
   )
   static final void method1277(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.field2815 || var9.type == 0 || var9.field2826 || GameEngine.method3133(var9) != 0 || Client.field443 == var9 || var9.contentType == 1338) && var1 == var9.parentId && (!var9.field2815 || !class11.method154(var9))) {
            int var10 = var9.relativeX + var6;
            int var11 = var7 + var9.relativeY;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var19;
            int var34;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.type == 9) {
               var16 = var10;
               var17 = var11;
               var34 = var10 + var9.width;
               var19 = var11 + var9.height;
               if(var34 < var10) {
                  var16 = var34;
                  var34 = var10;
               }

               if(var19 < var11) {
                  var17 = var19;
                  var19 = var11;
               }

               ++var34;
               ++var19;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var34 < var4?var34:var4;
               var15 = var19 < var5?var19:var5;
            } else {
               var16 = var10 + var9.width;
               var17 = var11 + var9.height;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(Client.field453 == var9) {
               Client.field461 = true;
               Client.field462 = var10;
               Client.field463 = var11;
            }

            if(!var9.field2815 || var12 < var14 && var13 < var15) {
               var16 = class143.field2225;
               var17 = class143.field2222;
               if(class143.field2227 != 0) {
                  var16 = class143.field2223;
                  var17 = class143.field2226;
               }

               int var20;
               int var21;
               int var22;
               int var23;
               int var24;
               int var25;
               int var27;
               int var29;
               int var35;
               int var62;
               if(var9.contentType == 1337) {
                  if(!Client.field411 && !Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     if(Client.field524 == 0 && !Client.field435) {
                        Ignore.addMenuEntry("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var34 = -1;
                     var19 = -1;

                     for(var20 = 0; var20 < Model.field1940; ++var20) {
                        var21 = Model.field1910[var20];
                        var22 = var21 & 127;
                        var23 = var21 >> 7 & 127;
                        var24 = var21 >> 29 & 3;
                        var25 = var21 >> 14 & 32767;
                        if(var19 != var21) {
                           var19 = var21;
                           if(var24 == 2 && class16.region.method2033(Item.plane, var22, var23, var21) >= 0) {
                              ObjectComposition var54 = class165.getObjectDefinition(var25);
                              if(var54.impostorIds != null) {
                                 var54 = var54.getImpostor();
                              }

                              if(var54 == null) {
                                 continue;
                              }

                              if(Client.field524 == 1) {
                                 Ignore.addMenuEntry("Use", Client.field529 + " " + "->" + " " + class153.method3186('\uffff') + var54.name, 1, var21, var22, var23);
                              } else if(Client.field435) {
                                 if((class50.field1116 & 4) == 4) {
                                    Ignore.addMenuEntry(Client.field438, Client.field439 + " " + "->" + " " + class153.method3186('\uffff') + var54.name, 2, var21, var22, var23);
                                 }
                              } else {
                                 String[] var37 = var54.actions;
                                 if(Client.field412) {
                                    var37 = class13.method165(var37);
                                 }

                                 if(var37 != null) {
                                    for(var35 = 4; var35 >= 0; --var35) {
                                       if(null != var37[var35]) {
                                          short var61 = 0;
                                          if(var35 == 0) {
                                             var61 = 3;
                                          }

                                          if(var35 == 1) {
                                             var61 = 4;
                                          }

                                          if(var35 == 2) {
                                             var61 = 5;
                                          }

                                          if(var35 == 3) {
                                             var61 = 6;
                                          }

                                          if(var35 == 4) {
                                             var61 = 1001;
                                          }

                                          Ignore.addMenuEntry(var37[var35], class153.method3186('\uffff') + var54.name, var61, var21, var22, var23);
                                       }
                                    }
                                 }

                                 Ignore.addMenuEntry("Examine", class153.method3186('\uffff') + var54.name, 1002, var54.field955 << 14, var22, var23);
                              }
                           }

                           NPC var28;
                           Player var39;
                           int[] var55;
                           if(var24 == 1) {
                              NPC var56 = Client.cachedNPCs[var25];
                              if(var56 == null) {
                                 continue;
                              }

                              if(var56.composition.field915 == 1 && (var56.x & 127) == 64 && (var56.y & 127) == 64) {
                                 for(var27 = 0; var27 < Client.field319; ++var27) {
                                    var28 = Client.cachedNPCs[Client.field320[var27]];
                                    if(var28 != null && var56 != var28 && var28.composition.field915 == 1 && var28.x == var56.x && var56.y == var28.y) {
                                       ObjectComposition.method841(var28.composition, Client.field320[var27], var22, var23);
                                    }
                                 }

                                 var27 = class34.field779;
                                 var55 = class34.field780;

                                 for(var29 = 0; var29 < var27; ++var29) {
                                    var39 = Client.cachedPlayers[var55[var29]];
                                    if(null != var39 && var39.x == var56.x && var56.y == var39.y) {
                                       class32.generateMenuActionsForPlayer(var39, var55[var29], var22, var23);
                                    }
                                 }
                              }

                              ObjectComposition.method841(var56.composition, var25, var22, var23);
                           }

                           if(var24 == 0) {
                              Player var58 = Client.cachedPlayers[var25];
                              if(var58 == null) {
                                 continue;
                              }

                              if((var58.x & 127) == 64 && (var58.y & 127) == 64) {
                                 for(var27 = 0; var27 < Client.field319; ++var27) {
                                    var28 = Client.cachedNPCs[Client.field320[var27]];
                                    if(var28 != null && var28.composition.field915 == 1 && var58.x == var28.x && var28.y == var58.y) {
                                       ObjectComposition.method841(var28.composition, Client.field320[var27], var22, var23);
                                    }
                                 }

                                 var27 = class34.field779;
                                 var55 = class34.field780;

                                 for(var29 = 0; var29 < var27; ++var29) {
                                    var39 = Client.cachedPlayers[var55[var29]];
                                    if(null != var39 && var39 != var58 && var58.x == var39.x && var39.y == var58.y) {
                                       class32.generateMenuActionsForPlayer(var39, var55[var29], var22, var23);
                                    }
                                 }
                              }

                              if(var25 != Client.field555) {
                                 class32.generateMenuActionsForPlayer(var58, var25, var22, var23);
                              } else {
                                 var34 = var21;
                              }
                           }

                           if(var24 == 3) {
                              Deque var60 = Client.groundItemDeque[Item.plane][var22][var23];
                              if(null != var60) {
                                 for(Item var66 = (Item)var60.method3855(); null != var66; var66 = (Item)var60.method3879()) {
                                    ItemComposition var57 = MessageNode.getItemDefinition(var66.id);
                                    if(Client.field524 == 1) {
                                       Ignore.addMenuEntry("Use", Client.field529 + " " + "->" + " " + class153.method3186(16748608) + var57.name, 16, var66.id, var22, var23);
                                    } else if(Client.field435) {
                                       if((class50.field1116 & 1) == 1) {
                                          Ignore.addMenuEntry(Client.field438, Client.field439 + " " + "->" + " " + class153.method3186(16748608) + var57.name, 17, var66.id, var22, var23);
                                       }
                                    } else {
                                       String[] var42 = var57.groundActions;
                                       if(Client.field412) {
                                          var42 = class13.method165(var42);
                                       }

                                       for(var62 = 4; var62 >= 0; --var62) {
                                          if(var42 != null && var42[var62] != null) {
                                             byte var63 = 0;
                                             if(var62 == 0) {
                                                var63 = 18;
                                             }

                                             if(var62 == 1) {
                                                var63 = 19;
                                             }

                                             if(var62 == 2) {
                                                var63 = 20;
                                             }

                                             if(var62 == 3) {
                                                var63 = 21;
                                             }

                                             if(var62 == 4) {
                                                var63 = 22;
                                             }

                                             Ignore.addMenuEntry(var42[var62], class153.method3186(16748608) + var57.name, var63, var66.id, var22, var23);
                                          } else if(var62 == 2) {
                                             Ignore.addMenuEntry("Take", class153.method3186(16748608) + var57.name, 20, var66.id, var22, var23);
                                          }
                                       }

                                       Ignore.addMenuEntry("Examine", class153.method3186(16748608) + var57.name, 1004, var66.id, var22, var23);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var34 != -1) {
                        var20 = var34 & 127;
                        var21 = var34 >> 7 & 127;
                        Player var67 = Client.cachedPlayers[Client.field555];
                        class32.generateMenuActionsForPlayer(var67, Client.field555, var20, var21);
                     }
                  }
               } else if(var9.contentType == 1338) {
                  if((Client.field404 == 0 || Client.field404 == 3) && (class143.field2227 == 1 || !class24.field626 && class143.field2227 == 4)) {
                     class178 var47 = var9.method3445(true);
                     if(null != var47) {
                        var19 = class143.field2223 - var10;
                        var20 = class143.field2226 - var11;
                        if(var47.method3499(var19, var20)) {
                           var19 -= var47.field2959 / 2;
                           var20 -= var47.field2964 / 2;
                           var21 = Client.mapScale + Client.mapAngle & 2047;
                           var22 = class94.field1670[var21];
                           var23 = class94.field1676[var21];
                           var22 = (256 + Client.mapScaleDelta) * var22 >> 8;
                           var23 = var23 * (Client.mapScaleDelta + 256) >> 8;
                           var24 = var20 * var22 + var19 * var23 >> 11;
                           var25 = var23 * var20 - var22 * var19 >> 11;
                           int var68 = var24 + WidgetNode.localPlayer.x >> 7;
                           var27 = WidgetNode.localPlayer.y - var25 >> 7;
                           Client.field323.method2801(102);
                           Client.field323.method2513(18);
                           Client.field323.method2711(var27 + KitDefinition.baseY);
                           Client.field323.method2558(class140.field2190[82]?(class140.field2190[81]?2:1):0);
                           Client.field323.method2711(class9.baseX + var68);
                           Client.field323.method2513(var19);
                           Client.field323.method2513(var20);
                           Client.field323.method2514(Client.mapAngle);
                           Client.field323.method2513(57);
                           Client.field323.method2513(Client.mapScale);
                           Client.field323.method2513(Client.mapScaleDelta);
                           Client.field323.method2513(89);
                           Client.field323.method2514(WidgetNode.localPlayer.x);
                           Client.field323.method2514(WidgetNode.localPlayer.y);
                           Client.field323.method2513(63);
                           Client.flagX = var68;
                           Client.flagY = var27;
                        }
                     }
                  }
               } else {
                  boolean var48;
                  if(!Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     var34 = var16 - var10;
                     var19 = var17 - var11;
                     if(var9.field2914 == 1) {
                        Ignore.addMenuEntry(var9.tooltip, "", 24, 0, 0, var9.id);
                     }

                     String var45;
                     if(var9.field2914 == 2 && !Client.field435) {
                        var45 = class1.method7(var9);
                        if(null != var45) {
                           Ignore.addMenuEntry(var45, class153.method3186('\uff00') + var9.field2932, 25, 0, -1, var9.id);
                        }
                     }

                     if(var9.field2914 == 3) {
                        Ignore.addMenuEntry("Close", "", 26, 0, 0, var9.id);
                     }

                     if(var9.field2914 == 4) {
                        Ignore.addMenuEntry(var9.tooltip, "", 28, 0, 0, var9.id);
                     }

                     if(var9.field2914 == 5) {
                        Ignore.addMenuEntry(var9.tooltip, "", 29, 0, 0, var9.id);
                     }

                     if(var9.field2914 == 6 && null == Client.field444) {
                        Ignore.addMenuEntry(var9.tooltip, "", 30, 0, -1, var9.id);
                     }

                     if(var9.type == 2) {
                        var20 = 0;

                        for(var21 = 0; var21 < var9.height; ++var21) {
                           for(var22 = 0; var22 < var9.width; ++var22) {
                              var23 = var22 * (var9.field2882 + 32);
                              var24 = (32 + var9.field2883) * var21;
                              if(var20 < 20) {
                                 var23 += var9.field2922[var20];
                                 var24 += var9.field2885[var20];
                              }

                              if(var34 >= var23 && var19 >= var24 && var34 < 32 + var23 && var19 < 32 + var24) {
                                 Client.field504 = var20;
                                 ItemComposition.field1217 = var9;
                                 if(var9.itemIds[var20] > 0) {
                                    label1831: {
                                       ItemComposition var38 = MessageNode.getItemDefinition(var9.itemIds[var20] - 1);
                                       boolean var41;
                                       if(Client.field524 == 1) {
                                          var27 = GameEngine.method3133(var9);
                                          var41 = (var27 >> 30 & 1) != 0;
                                          if(var41) {
                                             if(class12.field176 != var9.id || class22.field591 != var20) {
                                                Ignore.addMenuEntry("Use", Client.field529 + " " + "->" + " " + class153.method3186(16748608) + var38.name, 31, var38.id, var20, var9.id);
                                             }
                                             break label1831;
                                          }
                                       }

                                       if(Client.field435) {
                                          var27 = GameEngine.method3133(var9);
                                          var41 = (var27 >> 30 & 1) != 0;
                                          if(var41) {
                                             if((class50.field1116 & 16) == 16) {
                                                Ignore.addMenuEntry(Client.field438, Client.field439 + " " + "->" + " " + class153.method3186(16748608) + var38.name, 32, var38.id, var20, var9.id);
                                             }
                                             break label1831;
                                          }
                                       }

                                       String[] var26 = var38.inventoryActions;
                                       if(Client.field412) {
                                          var26 = class13.method165(var26);
                                       }

                                       var35 = GameEngine.method3133(var9);
                                       boolean var53 = (var35 >> 30 & 1) != 0;
                                       if(var53) {
                                          for(var29 = 4; var29 >= 3; --var29) {
                                             if(null != var26 && null != var26[var29]) {
                                                byte var30;
                                                if(var29 == 3) {
                                                   var30 = 36;
                                                } else {
                                                   var30 = 37;
                                                }

                                                Ignore.addMenuEntry(var26[var29], class153.method3186(16748608) + var38.name, var30, var38.id, var20, var9.id);
                                             } else if(var29 == 4) {
                                                Ignore.addMenuEntry("Drop", class153.method3186(16748608) + var38.name, 37, var38.id, var20, var9.id);
                                             }
                                          }
                                       }

                                       Object var10000 = null;
                                       if(NPC.method751(GameEngine.method3133(var9))) {
                                          Ignore.addMenuEntry("Use", class153.method3186(16748608) + var38.name, 38, var38.id, var20, var9.id);
                                       }

                                       var62 = GameEngine.method3133(var9);
                                       boolean var59 = (var62 >> 30 & 1) != 0;
                                       int var31;
                                       byte var32;
                                       if(var59 && null != var26) {
                                          for(var31 = 2; var31 >= 0; --var31) {
                                             if(var26[var31] != null) {
                                                var32 = 0;
                                                if(var31 == 0) {
                                                   var32 = 33;
                                                }

                                                if(var31 == 1) {
                                                   var32 = 34;
                                                }

                                                if(var31 == 2) {
                                                   var32 = 35;
                                                }

                                                Ignore.addMenuEntry(var26[var31], class153.method3186(16748608) + var38.name, var32, var38.id, var20, var9.id);
                                             }
                                          }
                                       }

                                       var26 = var9.field2832;
                                       if(Client.field412) {
                                          var26 = class13.method165(var26);
                                       }

                                       if(null != var26) {
                                          for(var31 = 4; var31 >= 0; --var31) {
                                             if(null != var26[var31]) {
                                                var32 = 0;
                                                if(var31 == 0) {
                                                   var32 = 39;
                                                }

                                                if(var31 == 1) {
                                                   var32 = 40;
                                                }

                                                if(var31 == 2) {
                                                   var32 = 41;
                                                }

                                                if(var31 == 3) {
                                                   var32 = 42;
                                                }

                                                if(var31 == 4) {
                                                   var32 = 43;
                                                }

                                                Ignore.addMenuEntry(var26[var31], class153.method3186(16748608) + var38.name, var32, var38.id, var20, var9.id);
                                             }
                                          }
                                       }

                                       Ignore.addMenuEntry("Examine", class153.method3186(16748608) + var38.name, 1005, var38.id, var20, var9.id);
                                    }
                                 }
                              }

                              ++var20;
                           }
                        }
                     }

                     if(var9.field2815) {
                        if(Client.field435) {
                           var21 = GameEngine.method3133(var9);
                           var48 = (var21 >> 21 & 1) != 0;
                           if(var48 && (class50.field1116 & 32) == 32) {
                              Ignore.addMenuEntry(Client.field438, Client.field439 + " " + "->" + " " + var9.name, 58, 0, var9.index, var9.id);
                           }
                        } else {
                           boolean var51;
                           for(var20 = 9; var20 >= 5; --var20) {
                              var23 = GameEngine.method3133(var9);
                              var51 = (var23 >> var20 + 1 & 1) != 0;
                              String var33;
                              if(!var51 && null == var9.field2887) {
                                 var33 = null;
                              } else if(null != var9.actions && var9.actions.length > var20 && null != var9.actions[var20] && var9.actions[var20].trim().length() != 0) {
                                 var33 = var9.actions[var20];
                              } else {
                                 var33 = null;
                              }

                              if(var33 != null) {
                                 Ignore.addMenuEntry(var33, var9.name, 1007, 1 + var20, var9.index, var9.id);
                              }
                           }

                           if(ChatMessages.method240(GameEngine.method3133(var9)) == 0) {
                              var45 = null;
                           } else if(var9.field2895 != null && var9.field2895.trim().length() != 0) {
                              var45 = var9.field2895;
                           } else {
                              var45 = null;
                           }

                           if(var45 != null) {
                              Ignore.addMenuEntry(var45, var9.name, 25, 0, var9.index, var9.id);
                           }

                           for(var22 = 4; var22 >= 0; --var22) {
                              var25 = GameEngine.method3133(var9);
                              boolean var52 = (var25 >> 1 + var22 & 1) != 0;
                              String var36;
                              if(!var52 && var9.field2887 == null) {
                                 var36 = null;
                              } else if(null != var9.actions && var9.actions.length > var22 && null != var9.actions[var22] && var9.actions[var22].trim().length() != 0) {
                                 var36 = var9.actions[var22];
                              } else {
                                 var36 = null;
                              }

                              if(null != var36) {
                                 Ignore.addMenuEntry(var36, var9.name, 57, 1 + var22, var9.index, var9.id);
                              }
                           }

                           var23 = GameEngine.method3133(var9);
                           var51 = (var23 & 1) != 0;
                           if(var51) {
                              Ignore.addMenuEntry("Continue", "", 30, 0, var9.index, var9.id);
                           }
                        }
                     }
                  }

                  if(var9.type == 0) {
                     if(!var9.field2815 && class11.method154(var9) && var9 != class40.field906) {
                        continue;
                     }

                     method1277(var0, var9.id, var12, var13, var14, var15, var10 - var9.itemId, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method1277(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.itemId, var11 - var9.scrollY);
                     }

                     WidgetNode var18 = (WidgetNode)Client.componentTable.method3817((long)var9.id);
                     if(null != var18) {
                        if(var18.field61 == 0 && class143.field2225 >= var12 && class143.field2222 >= var13 && class143.field2225 < var14 && class143.field2222 < var15 && !Client.isMenuOpen && !Client.field558) {
                           for(class0 var44 = (class0)Client.field479.method3854(); null != var44; var44 = (class0)Client.field479.method3869()) {
                              if(var44.field1) {
                                 var44.unlink();
                                 var44.field2.field2886 = false;
                              }
                           }

                           if(Client.field563 == 0) {
                              Client.field453 = null;
                              Client.field443 = null;
                           }

                           if(!Client.isMenuOpen) {
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.menuOptionCount = 1;
                           }
                        }

                        var19 = var18.id;
                        if(class93.method2114(var19)) {
                           method1277(Widget.widgets[var19], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  if(var9.field2815) {
                     class0 var46;
                     if(!var9.field2949) {
                        if(var9.field2854 && class143.field2225 >= var12 && class143.field2222 >= var13 && class143.field2225 < var14 && class143.field2222 < var15) {
                           for(var46 = (class0)Client.field479.method3854(); null != var46; var46 = (class0)Client.field479.method3869()) {
                              if(var46.field1 && var46.field2.field2820 == var46.field7) {
                                 var46.unlink();
                              }
                           }
                        }
                     } else if(class143.field2225 >= var12 && class143.field2222 >= var13 && class143.field2225 < var14 && class143.field2222 < var15) {
                        for(var46 = (class0)Client.field479.method3854(); null != var46; var46 = (class0)Client.field479.method3869()) {
                           if(var46.field1) {
                              var46.unlink();
                              var46.field2.field2886 = false;
                           }
                        }

                        if(Client.field563 == 0) {
                           Client.field453 = null;
                           Client.field443 = null;
                        }

                        if(!Client.isMenuOpen) {
                           Client.menuOptions[0] = "Cancel";
                           Client.menuTargets[0] = "";
                           Client.menuTypes[0] = 1006;
                           Client.menuOptionCount = 1;
                        }
                     }

                     boolean var65;
                     if(class143.field2225 >= var12 && class143.field2222 >= var13 && class143.field2225 < var14 && class143.field2222 < var15) {
                        var65 = true;
                     } else {
                        var65 = false;
                     }

                     boolean var49 = false;
                     if((class143.field2220 == 1 || !class24.field626 && class143.field2220 == 4) && var65) {
                        var49 = true;
                     }

                     var48 = false;
                     if((class143.field2227 == 1 || !class24.field626 && class143.field2227 == 4) && class143.field2223 >= var12 && class143.field2226 >= var13 && class143.field2223 < var14 && class143.field2226 < var15) {
                        var48 = true;
                     }

                     if(var48) {
                        class124.method2777(var9, class143.field2223 - var10, class143.field2226 - var11);
                     }

                     if(null != Client.field453 && Client.field453 != var9 && var65) {
                        var22 = GameEngine.method3133(var9);
                        boolean var50 = (var22 >> 20 & 1) != 0;
                        if(var50) {
                           Client.field457 = var9;
                        }
                     }

                     if(Client.field443 == var9) {
                        Client.field458 = true;
                        Client.field459 = var10;
                        Client.field460 = var11;
                     }

                     if(var9.field2826) {
                        class0 var64;
                        if(var65 && Client.field492 != 0 && null != var9.field2820) {
                           var64 = new class0();
                           var64.field1 = true;
                           var64.field2 = var9;
                           var64.field4 = Client.field492;
                           var64.field7 = var9.field2820;
                           Client.field479.method3849(var64);
                        }

                        if(Client.field453 != null || null != class26.field650 || Client.isMenuOpen) {
                           var48 = false;
                           var49 = false;
                           var65 = false;
                        }

                        if(!var9.field2837 && var48) {
                           var9.field2837 = true;
                           if(var9.field2898 != null) {
                              var64 = new class0();
                              var64.field1 = true;
                              var64.field2 = var9;
                              var64.field3 = class143.field2223 - var10;
                              var64.field4 = class143.field2226 - var11;
                              var64.field7 = var9.field2898;
                              Client.field479.method3849(var64);
                           }
                        }

                        if(var9.field2837 && var49 && var9.field2899 != null) {
                           var64 = new class0();
                           var64.field1 = true;
                           var64.field2 = var9;
                           var64.field3 = class143.field2225 - var10;
                           var64.field4 = class143.field2222 - var11;
                           var64.field7 = var9.field2899;
                           Client.field479.method3849(var64);
                        }

                        if(var9.field2837 && !var49) {
                           var9.field2837 = false;
                           if(var9.field2900 != null) {
                              var64 = new class0();
                              var64.field1 = true;
                              var64.field2 = var9;
                              var64.field3 = class143.field2225 - var10;
                              var64.field4 = class143.field2222 - var11;
                              var64.field7 = var9.field2900;
                              Client.field516.method3849(var64);
                           }
                        }

                        if(var49 && null != var9.field2901) {
                           var64 = new class0();
                           var64.field1 = true;
                           var64.field2 = var9;
                           var64.field3 = class143.field2225 - var10;
                           var64.field4 = class143.field2222 - var11;
                           var64.field7 = var9.field2901;
                           Client.field479.method3849(var64);
                        }

                        if(!var9.field2886 && var65) {
                           var9.field2886 = true;
                           if(var9.field2869 != null) {
                              var64 = new class0();
                              var64.field1 = true;
                              var64.field2 = var9;
                              var64.field3 = class143.field2225 - var10;
                              var64.field4 = class143.field2222 - var11;
                              var64.field7 = var9.field2869;
                              Client.field479.method3849(var64);
                           }
                        }

                        if(var9.field2886 && var65 && var9.field2903 != null) {
                           var64 = new class0();
                           var64.field1 = true;
                           var64.field2 = var9;
                           var64.field3 = class143.field2225 - var10;
                           var64.field4 = class143.field2222 - var11;
                           var64.field7 = var9.field2903;
                           Client.field479.method3849(var64);
                        }

                        if(var9.field2886 && !var65) {
                           var9.field2886 = false;
                           if(var9.field2904 != null) {
                              var64 = new class0();
                              var64.field1 = true;
                              var64.field2 = var9;
                              var64.field3 = class143.field2225 - var10;
                              var64.field4 = class143.field2222 - var11;
                              var64.field7 = var9.field2904;
                              Client.field516.method3849(var64);
                           }
                        }

                        if(var9.field2950 != null) {
                           var64 = new class0();
                           var64.field2 = var9;
                           var64.field7 = var9.field2950;
                           Client.field480.method3849(var64);
                        }

                        class0 var43;
                        if(var9.field2909 != null && Client.field467 > var9.field2944) {
                           if(var9.field2868 != null && Client.field467 - var9.field2944 <= 32) {
                              label1470:
                              for(var21 = var9.field2944; var21 < Client.field467; ++var21) {
                                 var22 = Client.field348[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2868.length; ++var23) {
                                    if(var22 == var9.field2868[var23]) {
                                       var43 = new class0();
                                       var43.field2 = var9;
                                       var43.field7 = var9.field2909;
                                       Client.field479.method3849(var43);
                                       break label1470;
                                    }
                                 }
                              }
                           } else {
                              var64 = new class0();
                              var64.field2 = var9;
                              var64.field7 = var9.field2909;
                              Client.field479.method3849(var64);
                           }

                           var9.field2944 = Client.field467;
                        }

                        if(null != var9.field2911 && Client.field314 > var9.field2945) {
                           if(var9.field2912 != null && Client.field314 - var9.field2945 <= 32) {
                              label1446:
                              for(var21 = var9.field2945; var21 < Client.field314; ++var21) {
                                 var22 = Client.field468[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2912.length; ++var23) {
                                    if(var9.field2912[var23] == var22) {
                                       var43 = new class0();
                                       var43.field2 = var9;
                                       var43.field7 = var9.field2911;
                                       Client.field479.method3849(var43);
                                       break label1446;
                                    }
                                 }
                              }
                           } else {
                              var64 = new class0();
                              var64.field2 = var9;
                              var64.field7 = var9.field2911;
                              Client.field479.method3849(var64);
                           }

                           var9.field2945 = Client.field314;
                        }

                        if(null != var9.field2836 && Client.field527 > var9.field2812) {
                           if(null != var9.field2915 && Client.field527 - var9.field2812 <= 32) {
                              label1422:
                              for(var21 = var9.field2812; var21 < Client.field527; ++var21) {
                                 var22 = Client.field494[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2915.length; ++var23) {
                                    if(var22 == var9.field2915[var23]) {
                                       var43 = new class0();
                                       var43.field2 = var9;
                                       var43.field7 = var9.field2836;
                                       Client.field479.method3849(var43);
                                       break label1422;
                                    }
                                 }
                              }
                           } else {
                              var64 = new class0();
                              var64.field2 = var9;
                              var64.field7 = var9.field2836;
                              Client.field479.method3849(var64);
                           }

                           var9.field2812 = Client.field527;
                        }

                        if(Client.field560 > var9.field2943 && var9.field2918 != null) {
                           var64 = new class0();
                           var64.field2 = var9;
                           var64.field7 = var9.field2918;
                           Client.field479.method3849(var64);
                        }

                        if(Client.field473 > var9.field2943 && null != var9.field2920) {
                           var64 = new class0();
                           var64.field2 = var9;
                           var64.field7 = var9.field2920;
                           Client.field479.method3849(var64);
                        }

                        if(Client.field474 > var9.field2943 && null != var9.field2921) {
                           var64 = new class0();
                           var64.field2 = var9;
                           var64.field7 = var9.field2921;
                           Client.field479.method3849(var64);
                        }

                        if(Client.field433 > var9.field2943 && null != var9.field2926) {
                           var64 = new class0();
                           var64.field2 = var9;
                           var64.field7 = var9.field2926;
                           Client.field479.method3849(var64);
                        }

                        if(Client.field476 > var9.field2943 && var9.field2821 != null) {
                           var64 = new class0();
                           var64.field2 = var9;
                           var64.field7 = var9.field2821;
                           Client.field479.method3849(var64);
                        }

                        if(Client.field477 > var9.field2943 && var9.field2927 != null) {
                           var64 = new class0();
                           var64.field2 = var9;
                           var64.field7 = var9.field2927;
                           Client.field479.method3849(var64);
                        }

                        var9.field2943 = Client.field465;
                        if(var9.field2919 != null) {
                           for(var21 = 0; var21 < Client.field503; ++var21) {
                              class0 var40 = new class0();
                              var40.field2 = var9;
                              var40.field6 = Client.field505[var21];
                              var40.field8 = Client.field410[var21];
                              var40.field7 = var9.field2919;
                              Client.field479.method3849(var40);
                           }
                        }
                     }
                  }

                  if(!var9.field2815 && null == Client.field453 && class26.field650 == null && !Client.isMenuOpen) {
                     if((var9.field2925 >= 0 || var9.field2913 != 0) && class143.field2225 >= var12 && class143.field2222 >= var13 && class143.field2225 < var14 && class143.field2222 < var15) {
                        if(var9.field2925 >= 0) {
                           class40.field906 = var0[var9.field2925];
                        } else {
                           class40.field906 = var9;
                        }
                     }

                     if(var9.type == 8 && class143.field2225 >= var12 && class143.field2222 >= var13 && class143.field2225 < var14 && class143.field2222 < var15) {
                        class107.field1865 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        class79.method1711(var9, var9.width + var10, var11, var9.height, var9.scrollHeight, class143.field2225, class143.field2222);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-1645320011"
   )
   static void method1284(int var0, String var1) {
      int var2 = class34.field779;
      int[] var3 = class34.field780;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         Player var6 = Client.cachedPlayers[var3[var5]];
         if(var6 != null && var6 != WidgetNode.localPlayer && null != var6.name && var6.name.equalsIgnoreCase(var1)) {
            if(var0 == 1) {
               Client.field323.method2801(24);
               Client.field323.method2558(0);
               Client.field323.method2562(var3[var5]);
            } else if(var0 == 4) {
               Client.field323.method2801(200);
               Client.field323.method2514(var3[var5]);
               Client.field323.method2552(0);
            } else if(var0 == 6) {
               Client.field323.method2801(149);
               Client.field323.method2558(0);
               Client.field323.method2562(var3[var5]);
            } else if(var0 == 7) {
               Client.field323.method2801(124);
               Client.field323.method2552(0);
               Client.field323.method2711(var3[var5]);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         class10.sendGameMessage(4, "", "Unable to find " + var1);
      }

   }
}
