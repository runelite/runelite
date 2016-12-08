import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
public final class class116 {
   @ObfuscatedName("b")
   class72 field1829 = null;
   @ObfuscatedName("iw")
   @ObfuscatedGetter(
      intValue = 1985017895
   )
   static int field1831;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1865968751
   )
   int field1832;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1267166229
   )
   int field1833 = '\ufde8';
   @ObfuscatedName("o")
   static byte[] field1835 = new byte[520];
   @ObfuscatedName("m")
   class72 field1836 = null;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = 1500204859
   )
   static int field1837;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "2102505203"
   )
   boolean method2184(int var1, byte[] var2, int var3, boolean var4) {
      class72 var5 = this.field1836;
      synchronized(this.field1836) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field1829.method1354() < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field1829.method1353((long)(6 * var1));
               this.field1829.method1356(field1835, 0, 6);
               var6 = (field1835[5] & 255) + ((field1835[4] & 255) << 8) + ((field1835[3] & 255) << 16);
               if(var6 <= 0 || (long)var6 > this.field1836.method1354() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field1836.method1354() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field1835[0] = (byte)(var3 >> 16);
            field1835[1] = (byte)(var3 >> 8);
            field1835[2] = (byte)var3;
            field1835[3] = (byte)(var6 >> 16);
            field1835[4] = (byte)(var6 >> 8);
            field1835[5] = (byte)var6;
            this.field1829.method1353((long)(var1 * 6));
            this.field1829.method1358(field1835, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label135: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        label154: {
                           this.field1836.method1353((long)(520 * var6));

                           try {
                              this.field1836.method1356(field1835, 0, 8);
                           } catch (EOFException var16) {
                              break label135;
                           }

                           var14 = (field1835[1] & 255) + ((field1835[0] & 255) << 8);
                           int var11 = (field1835[3] & 255) + ((field1835[2] & 255) << 8);
                           var9 = (field1835[6] & 255) + ((field1835[4] & 255) << 16) + ((field1835[5] & 255) << 8);
                           int var12 = field1835[7] & 255;
                           if(var1 == var14 && var11 == var8 && var12 == this.field1832) {
                              if(var9 >= 0 && (long)var9 <= this.field1836.method1354() / 520L) {
                                 break label154;
                              }

                              var10000 = false;
                              return var10000;
                           }

                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field1836.method1354() + 519L) / 520L);
                        if(var9 == 0) {
                           ++var9;
                        }

                        if(var6 == var9) {
                           ++var9;
                        }
                     }

                     if(var3 - var7 <= 512) {
                        var9 = 0;
                     }

                     field1835[0] = (byte)(var1 >> 8);
                     field1835[1] = (byte)var1;
                     field1835[2] = (byte)(var8 >> 8);
                     field1835[3] = (byte)var8;
                     field1835[4] = (byte)(var9 >> 16);
                     field1835[5] = (byte)(var9 >> 8);
                     field1835[6] = (byte)var9;
                     field1835[7] = (byte)this.field1832;
                     this.field1836.method1353((long)(var6 * 520));
                     this.field1836.method1358(field1835, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field1836.method1358(var2, var7, var14);
                     var7 += var14;
                     var6 = var9;
                     ++var8;
                     continue;
                  }
               }

               var10000 = true;
               return var10000;
            }
         } catch (IOException var17) {
            return false;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1714438106"
   )
   public byte[] method2185(int var1) {
      class72 var2 = this.field1836;
      synchronized(this.field1836) {
         try {
            Object var10000;
            if(this.field1829.method1354() < (long)(6 * var1 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field1829.method1353((long)(var1 * 6));
               this.field1829.method1356(field1835, 0, 6);
               int var3 = (field1835[2] & 255) + ((field1835[0] & 255) << 16) + ((field1835[1] & 255) << 8);
               int var4 = ((field1835[4] & 255) << 8) + ((field1835[3] & 255) << 16) + (field1835[5] & 255);
               if(var3 < 0 || var3 > this.field1833) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field1836.method1354() / 520L) {
                  var10000 = null;
                  return (byte[])var10000;
               } else {
                  byte[] var5 = new byte[var3];
                  int var6 = 0;
                  int var7 = 0;

                  while(var6 < var3) {
                     if(var4 == 0) {
                        var10000 = null;
                        return (byte[])var10000;
                     }

                     this.field1836.method1353((long)(var4 * 520));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field1836.method1356(field1835, 0, 8 + var8);
                     int var9 = (field1835[1] & 255) + ((field1835[0] & 255) << 8);
                     int var10 = (field1835[3] & 255) + ((field1835[2] & 255) << 8);
                     int var11 = (field1835[6] & 255) + ((field1835[5] & 255) << 8) + ((field1835[4] & 255) << 16);
                     int var12 = field1835[7] & 255;
                     if(var9 == var1 && var10 == var7 && this.field1832 == var12) {
                        if(var11 >= 0 && (long)var11 <= this.field1836.method1354() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field1835[8 + var13];
                           }

                           var4 = var11;
                           ++var7;
                           continue;
                        }

                        var10000 = null;
                        return (byte[])var10000;
                     }

                     var10000 = null;
                     return (byte[])var10000;
                  }

                  byte[] var18 = var5;
                  return var18;
               }
            }
         } catch (IOException var16) {
            return null;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I[BIB)Z",
      garbageValue = "102"
   )
   public boolean method2186(int var1, byte[] var2, int var3) {
      class72 var4 = this.field1836;
      synchronized(this.field1836) {
         if(var3 >= 0 && var3 <= this.field1833) {
            boolean var5 = this.method2184(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2184(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(ILclass72;Lclass72;I)V",
      garbageValue = "500000"
   )
   public class116(int var1, class72 var2, class72 var3, int var4) {
      this.field1832 = var1;
      this.field1836 = var2;
      this.field1829 = var3;
      this.field1833 = var4;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILclass116;Lclass184;I)V",
      garbageValue = "1579604139"
   )
   static void method2195(int var0, class116 var1, class184 var2) {
      byte[] var3 = null;
      Deque var4 = class183.field2733;
      synchronized(class183.field2733) {
         for(class180 var5 = (class180)class183.field2733.method2349(); var5 != null; var5 = (class180)class183.field2733.method2351()) {
            if(var5.hash == (long)var0 && var5.field2704 == var1 && var5.field2702 == 0) {
               var3 = var5.field2703;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method3298(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method2185(var0);
         var2.method3298(var1, var0, var8, true);
      }
   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIII)V",
      garbageValue = "-441854408"
   )
   static final void method2196(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.field2204 || var9.type == 0 || var9.field2287 || class217.method3874(var9) != 0 || Client.field435 == var9 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.field2204 || !class8.method90(var9))) {
            int var10 = var6 + var9.relativeX;
            int var11 = var7 + var9.relativeY;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var29;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.type == 9) {
               var16 = var10;
               var17 = var11;
               var18 = var10 + var9.width;
               var29 = var9.height + var11;
               if(var18 < var10) {
                  var16 = var18;
                  var18 = var10;
               }

               if(var29 < var11) {
                  var17 = var29;
                  var29 = var11;
               }

               ++var18;
               ++var29;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var18 < var4?var18:var4;
               var15 = var29 < var5?var29:var5;
            } else {
               var16 = var9.width + var10;
               var17 = var11 + var9.height;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(Client.field455 == var9) {
               Client.field465 = true;
               Client.field433 = var10;
               Client.field467 = var11;
            }

            if(!var9.field2204 || var12 < var14 && var13 < var15) {
               var16 = class115.field1814;
               var17 = class115.field1821;
               if(class115.field1820 != 0) {
                  var16 = class115.field1823;
                  var17 = class115.field1825;
               }

               if(var9.contentType == 1337) {
                  if(!Client.field297 && !Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     class31.method658(var16, var17, var12, var13);
                  }
               } else {
                  int var20;
                  int var21;
                  int var22;
                  int var23;
                  int var27;
                  int var32;
                  if(var9.contentType == 1338) {
                     if((Client.field520 == 0 || Client.field520 == 3) && (class115.field1820 == 1 || !class148.field2047 && class115.field1820 == 4)) {
                        class164 var43 = var9.method3114(true);
                        if(null != var43) {
                           var29 = class115.field1823 - var10;
                           var20 = class115.field1825 - var11;
                           if(var43.method3052(var29, var20)) {
                              var29 -= var43.field2164 / 2;
                              var20 -= var43.field2165 / 2;
                              var21 = Client.mapScale + Client.mapAngle & 2047;
                              var22 = class84.field1435[var21];
                              var23 = class84.field1446[var21];
                              var22 = (256 + Client.mapScaleDelta) * var22 >> 8;
                              var23 = var23 * (Client.mapScaleDelta + 256) >> 8;
                              var32 = var20 * var22 + var29 * var23 >> 11;
                              int var33 = var23 * var20 - var29 * var22 >> 11;
                              int var26 = class5.localPlayer.x + var32 >> 7;
                              var27 = class5.localPlayer.y - var33 >> 7;
                              Client.field330.method2967(198);
                              Client.field330.method2815(18);
                              Client.field330.method2752(class105.field1728[82]?(class105.field1728[81]?2:1):0);
                              Client.field330.method2760(var26 + class107.baseX);
                              Client.field330.method2759(XClanMember.baseY + var27);
                              Client.field330.method2815(var29);
                              Client.field330.method2815(var20);
                              Client.field330.method2712(Client.mapAngle);
                              Client.field330.method2815(57);
                              Client.field330.method2815(Client.mapScale);
                              Client.field330.method2815(Client.mapScaleDelta);
                              Client.field330.method2815(89);
                              Client.field330.method2712(class5.localPlayer.x);
                              Client.field330.method2712(class5.localPlayer.y);
                              Client.field330.method2815(63);
                              Client.flagX = var26;
                              Client.flagY = var27;
                           }
                        }
                     }
                  } else {
                     if(!Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                        var18 = var16 - var10;
                        var29 = var17 - var11;
                        if(var9.field2336 == 1) {
                           class48.addMenuEntry(var9.tooltip, "", 24, 0, 0, var9.id);
                        }

                        String var35;
                        if(var9.field2336 == 2 && !Client.field439) {
                           var22 = class217.method3874(var9);
                           var21 = var22 >> 11 & 63;
                           if(var21 == 0) {
                              var35 = null;
                           } else if(var9.field2286 != null && var9.field2286.trim().length() != 0) {
                              var35 = var9.field2286;
                           } else {
                              var35 = null;
                           }

                           if(var35 != null) {
                              class48.addMenuEntry(var35, class16.method182('\uff00') + var9.field2323, 25, 0, -1, var9.id);
                           }
                        }

                        if(var9.field2336 == 3) {
                           class48.addMenuEntry("Close", "", 26, 0, 0, var9.id);
                        }

                        if(var9.field2336 == 4) {
                           class48.addMenuEntry(var9.tooltip, "", 28, 0, 0, var9.id);
                        }

                        if(var9.field2336 == 5) {
                           class48.addMenuEntry(var9.tooltip, "", 29, 0, 0, var9.id);
                        }

                        if(var9.field2336 == 6 && Client.field448 == null) {
                           class48.addMenuEntry(var9.tooltip, "", 30, 0, -1, var9.id);
                        }

                        if(var9.type == 2) {
                           var20 = 0;

                           for(var21 = 0; var21 < var9.height; ++var21) {
                              for(var22 = 0; var22 < var9.width; ++var22) {
                                 var23 = var22 * (var9.field2273 + 32);
                                 var32 = var21 * (var9.field2200 + 32);
                                 if(var20 < 20) {
                                    var23 += var9.field2275[var20];
                                    var32 += var9.field2315[var20];
                                 }

                                 if(var18 >= var23 && var29 >= var32 && var18 < var23 + 32 && var29 < 32 + var32) {
                                    Client.field403 = var20;
                                    class7.field51 = var9;
                                    if(var9.itemIds[var20] > 0) {
                                       ItemComposition var25 = class137.getItemDefinition(var9.itemIds[var20] - 1);
                                       if(Client.field437 == 1 && class0.method8(class217.method3874(var9))) {
                                          if(class22.field244 != var9.id || var20 != class138.field1925) {
                                             class48.addMenuEntry("Use", Client.field438 + " " + "->" + " " + class16.method182(16748608) + var25.name, 31, var25.id, var20, var9.id);
                                          }
                                       } else if(Client.field439 && class0.method8(class217.method3874(var9))) {
                                          if((field1837 & 16) == 16) {
                                             class48.addMenuEntry(Client.field562, Client.field443 + " " + "->" + " " + class16.method182(16748608) + var25.name, 32, var25.id, var20, var9.id);
                                          }
                                       } else {
                                          String[] var34 = var25.inventoryActions;
                                          if(Client.field434) {
                                             var34 = class38.method726(var34);
                                          }

                                          byte var28;
                                          if(class0.method8(class217.method3874(var9))) {
                                             for(var27 = 4; var27 >= 3; --var27) {
                                                if(var34 != null && var34[var27] != null) {
                                                   if(var27 == 3) {
                                                      var28 = 36;
                                                   } else {
                                                      var28 = 37;
                                                   }

                                                   class48.addMenuEntry(var34[var27], class16.method182(16748608) + var25.name, var28, var25.id, var20, var9.id);
                                                } else if(var27 == 4) {
                                                   class48.addMenuEntry("Drop", class16.method182(16748608) + var25.name, 37, var25.id, var20, var9.id);
                                                }
                                             }
                                          }

                                          if(WidgetNode.method186(class217.method3874(var9))) {
                                             class48.addMenuEntry("Use", class16.method182(16748608) + var25.name, 38, var25.id, var20, var9.id);
                                          }

                                          if(class0.method8(class217.method3874(var9)) && var34 != null) {
                                             for(var27 = 2; var27 >= 0; --var27) {
                                                if(null != var34[var27]) {
                                                   var28 = 0;
                                                   if(var27 == 0) {
                                                      var28 = 33;
                                                   }

                                                   if(var27 == 1) {
                                                      var28 = 34;
                                                   }

                                                   if(var27 == 2) {
                                                      var28 = 35;
                                                   }

                                                   class48.addMenuEntry(var34[var27], class16.method182(16748608) + var25.name, var28, var25.id, var20, var9.id);
                                                }
                                             }
                                          }

                                          var34 = var9.field2278;
                                          if(Client.field434) {
                                             var34 = class38.method726(var34);
                                          }

                                          if(null != var34) {
                                             for(var27 = 4; var27 >= 0; --var27) {
                                                if(var34[var27] != null) {
                                                   var28 = 0;
                                                   if(var27 == 0) {
                                                      var28 = 39;
                                                   }

                                                   if(var27 == 1) {
                                                      var28 = 40;
                                                   }

                                                   if(var27 == 2) {
                                                      var28 = 41;
                                                   }

                                                   if(var27 == 3) {
                                                      var28 = 42;
                                                   }

                                                   if(var27 == 4) {
                                                      var28 = 43;
                                                   }

                                                   class48.addMenuEntry(var34[var27], class16.method182(16748608) + var25.name, var28, var25.id, var20, var9.id);
                                                }
                                             }
                                          }

                                          class48.addMenuEntry("Examine", class16.method182(16748608) + var25.name, 1005, var25.id, var20, var9.id);
                                       }
                                    }
                                 }

                                 ++var20;
                              }
                           }
                        }

                        if(var9.field2204) {
                           if(Client.field439) {
                              if(class140.method2567(class217.method3874(var9)) && (field1837 & 32) == 32) {
                                 class48.addMenuEntry(Client.field562, Client.field443 + " " + "->" + " " + var9.name, 58, 0, var9.index, var9.id);
                              }
                           } else {
                              for(var20 = 9; var20 >= 5; --var20) {
                                 String var30;
                                 if(!class94.method1869(class217.method3874(var9), var20) && null == var9.field2307) {
                                    var30 = null;
                                 } else if(var9.actions != null && var9.actions.length > var20 && var9.actions[var20] != null && var9.actions[var20].trim().length() != 0) {
                                    var30 = var9.actions[var20];
                                 } else {
                                    var30 = null;
                                 }

                                 if(null != var30) {
                                    class48.addMenuEntry(var30, var9.name, 1007, 1 + var20, var9.index, var9.id);
                                 }
                              }

                              var22 = class217.method3874(var9);
                              var21 = var22 >> 11 & 63;
                              if(var21 == 0) {
                                 var35 = null;
                              } else if(null != var9.field2286 && var9.field2286.trim().length() != 0) {
                                 var35 = var9.field2286;
                              } else {
                                 var35 = null;
                              }

                              if(var35 != null) {
                                 class48.addMenuEntry(var35, var9.name, 25, 0, var9.index, var9.id);
                              }

                              for(var22 = 4; var22 >= 0; --var22) {
                                 String var37;
                                 if(!class94.method1869(class217.method3874(var9), var22) && null == var9.field2307) {
                                    var37 = null;
                                 } else if(null != var9.actions && var9.actions.length > var22 && null != var9.actions[var22] && var9.actions[var22].trim().length() != 0) {
                                    var37 = var9.actions[var22];
                                 } else {
                                    var37 = null;
                                 }

                                 if(null != var37) {
                                    class48.addMenuEntry(var37, var9.name, 57, 1 + var22, var9.index, var9.id);
                                 }
                              }

                              if(class167.method3095(class217.method3874(var9))) {
                                 class48.addMenuEntry("Continue", "", 30, 0, var9.index, var9.id);
                              }
                           }
                        }
                     }

                     if(var9.type == 0) {
                        if(!var9.field2204 && class8.method90(var9) && class22.field245 != var9) {
                           continue;
                        }

                        method2196(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                        if(null != var9.children) {
                           method2196(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                        }

                        WidgetNode var31 = (WidgetNode)Client.componentTable.method2299((long)var9.id);
                        if(var31 != null) {
                           if(var31.field191 == 0 && class115.field1814 >= var12 && class115.field1821 >= var13 && class115.field1814 < var14 && class115.field1821 < var15 && !Client.isMenuOpen && !Client.field454) {
                              for(class18 var19 = (class18)Client.field483.method2349(); null != var19; var19 = (class18)Client.field483.method2351()) {
                                 if(var19.field196) {
                                    var19.unlink();
                                    var19.field193.field2332 = false;
                                 }
                              }

                              if(class36.field774 == 0) {
                                 Client.field455 = null;
                                 Client.field435 = null;
                              }

                              if(!Client.isMenuOpen) {
                                 Client.menuOptions[0] = "Cancel";
                                 Client.menuTargets[0] = "";
                                 Client.menuTypes[0] = 1006;
                                 Client.menuOptionCount = 1;
                              }
                           }

                           var29 = var31.id;
                           if(class2.method25(var29)) {
                              method2196(Widget.widgets[var29], -1, var12, var13, var14, var15, var10, var11);
                           }
                        }
                     }

                     if(var9.field2204) {
                        class18 var41;
                        if(!var9.field2340) {
                           if(var9.field2299 && class115.field1814 >= var12 && class115.field1821 >= var13 && class115.field1814 < var14 && class115.field1821 < var15) {
                              for(var41 = (class18)Client.field483.method2349(); var41 != null; var41 = (class18)Client.field483.method2351()) {
                                 if(var41.field196 && var41.field203 == var41.field193.field2295) {
                                    var41.unlink();
                                 }
                              }
                           }
                        } else if(class115.field1814 >= var12 && class115.field1821 >= var13 && class115.field1814 < var14 && class115.field1821 < var15) {
                           for(var41 = (class18)Client.field483.method2349(); null != var41; var41 = (class18)Client.field483.method2351()) {
                              if(var41.field196) {
                                 var41.unlink();
                                 var41.field193.field2332 = false;
                              }
                           }

                           if(class36.field774 == 0) {
                              Client.field455 = null;
                              Client.field435 = null;
                           }

                           if(!Client.isMenuOpen) {
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.menuOptionCount = 1;
                           }
                        }

                        boolean var38;
                        if(class115.field1814 >= var12 && class115.field1821 >= var13 && class115.field1814 < var14 && class115.field1821 < var15) {
                           var38 = true;
                        } else {
                           var38 = false;
                        }

                        boolean var40 = false;
                        if((class115.field1822 == 1 || !class148.field2047 && class115.field1822 == 4) && var38) {
                           var40 = true;
                        }

                        boolean var39 = false;
                        if((class115.field1820 == 1 || !class148.field2047 && class115.field1820 == 4) && class115.field1823 >= var12 && class115.field1825 >= var13 && class115.field1823 < var14 && class115.field1825 < var15) {
                           var39 = true;
                        }

                        if(var39) {
                           class108.method1999(var9, class115.field1823 - var10, class115.field1825 - var11);
                        }

                        if(null != Client.field455 && Client.field455 != var9 && var38 && class177.method3184(class217.method3874(var9))) {
                           Client.field461 = var9;
                        }

                        if(Client.field435 == var9) {
                           Client.field388 = true;
                           Client.field463 = var10;
                           Client.field464 = var11;
                        }

                        if(var9.field2287) {
                           class18 var42;
                           if(var38 && Client.field482 != 0 && var9.field2295 != null) {
                              var42 = new class18();
                              var42.field196 = true;
                              var42.field193 = var9;
                              var42.field194 = Client.field482;
                              var42.field203 = var9.field2295;
                              Client.field483.method2361(var42);
                           }

                           if(null != Client.field455 || null != CombatInfo1.field669 || Client.isMenuOpen) {
                              var39 = false;
                              var40 = false;
                              var38 = false;
                           }

                           if(!var9.field2333 && var39) {
                              var9.field2333 = true;
                              if(var9.field2289 != null) {
                                 var42 = new class18();
                                 var42.field196 = true;
                                 var42.field193 = var9;
                                 var42.field195 = class115.field1823 - var10;
                                 var42.field194 = class115.field1825 - var11;
                                 var42.field203 = var9.field2289;
                                 Client.field483.method2361(var42);
                              }
                           }

                           if(var9.field2333 && var40 && null != var9.field2279) {
                              var42 = new class18();
                              var42.field196 = true;
                              var42.field193 = var9;
                              var42.field195 = class115.field1814 - var10;
                              var42.field194 = class115.field1821 - var11;
                              var42.field203 = var9.field2279;
                              Client.field483.method2361(var42);
                           }

                           if(var9.field2333 && !var40) {
                              var9.field2333 = false;
                              if(var9.field2213 != null) {
                                 var42 = new class18();
                                 var42.field196 = true;
                                 var42.field193 = var9;
                                 var42.field195 = class115.field1814 - var10;
                                 var42.field194 = class115.field1821 - var11;
                                 var42.field203 = var9.field2213;
                                 Client.field485.method2361(var42);
                              }
                           }

                           if(var40 && var9.field2292 != null) {
                              var42 = new class18();
                              var42.field196 = true;
                              var42.field193 = var9;
                              var42.field195 = class115.field1814 - var10;
                              var42.field194 = class115.field1821 - var11;
                              var42.field203 = var9.field2292;
                              Client.field483.method2361(var42);
                           }

                           if(!var9.field2332 && var38) {
                              var9.field2332 = true;
                              if(null != var9.field2293) {
                                 var42 = new class18();
                                 var42.field196 = true;
                                 var42.field193 = var9;
                                 var42.field195 = class115.field1814 - var10;
                                 var42.field194 = class115.field1821 - var11;
                                 var42.field203 = var9.field2293;
                                 Client.field483.method2361(var42);
                              }
                           }

                           if(var9.field2332 && var38 && var9.field2272 != null) {
                              var42 = new class18();
                              var42.field196 = true;
                              var42.field193 = var9;
                              var42.field195 = class115.field1814 - var10;
                              var42.field194 = class115.field1821 - var11;
                              var42.field203 = var9.field2272;
                              Client.field483.method2361(var42);
                           }

                           if(var9.field2332 && !var38) {
                              var9.field2332 = false;
                              if(var9.field2237 != null) {
                                 var42 = new class18();
                                 var42.field196 = true;
                                 var42.field193 = var9;
                                 var42.field195 = class115.field1814 - var10;
                                 var42.field194 = class115.field1821 - var11;
                                 var42.field203 = var9.field2237;
                                 Client.field485.method2361(var42);
                              }
                           }

                           if(null != var9.field2306) {
                              var42 = new class18();
                              var42.field193 = var9;
                              var42.field203 = var9.field2306;
                              Client.field484.method2361(var42);
                           }

                           class18 var24;
                           if(null != var9.field2290 && Client.field471 > var9.field2335) {
                              if(var9.field2301 != null && Client.field471 - var9.field2335 <= 32) {
                                 label1065:
                                 for(var21 = var9.field2335; var21 < Client.field471; ++var21) {
                                    var22 = Client.field470[var21 & 31];

                                    for(var23 = 0; var23 < var9.field2301.length; ++var23) {
                                       if(var22 == var9.field2301[var23]) {
                                          var24 = new class18();
                                          var24.field193 = var9;
                                          var24.field203 = var9.field2290;
                                          Client.field483.method2361(var24);
                                          break label1065;
                                       }
                                    }
                                 }
                              } else {
                                 var42 = new class18();
                                 var42.field193 = var9;
                                 var42.field203 = var9.field2290;
                                 Client.field483.method2361(var42);
                              }

                              var9.field2335 = Client.field471;
                           }

                           if(var9.field2303 != null && Client.field473 > var9.field2206) {
                              if(null != var9.field2276 && Client.field473 - var9.field2206 <= 32) {
                                 label1041:
                                 for(var21 = var9.field2206; var21 < Client.field473; ++var21) {
                                    var22 = Client.field472[var21 & 31];

                                    for(var23 = 0; var23 < var9.field2276.length; ++var23) {
                                       if(var9.field2276[var23] == var22) {
                                          var24 = new class18();
                                          var24.field193 = var9;
                                          var24.field203 = var9.field2303;
                                          Client.field483.method2361(var24);
                                          break label1041;
                                       }
                                    }
                                 }
                              } else {
                                 var42 = new class18();
                                 var42.field193 = var9;
                                 var42.field203 = var9.field2303;
                                 Client.field483.method2361(var42);
                              }

                              var9.field2206 = Client.field473;
                           }

                           if(null != var9.field2304 && Client.field557 > var9.field2337) {
                              if(null != var9.field2305 && Client.field557 - var9.field2337 <= 32) {
                                 label1017:
                                 for(var21 = var9.field2337; var21 < Client.field557; ++var21) {
                                    var22 = Client.field326[var21 & 31];

                                    for(var23 = 0; var23 < var9.field2305.length; ++var23) {
                                       if(var9.field2305[var23] == var22) {
                                          var24 = new class18();
                                          var24.field193 = var9;
                                          var24.field203 = var9.field2304;
                                          Client.field483.method2361(var24);
                                          break label1017;
                                       }
                                    }
                                 }
                              } else {
                                 var42 = new class18();
                                 var42.field193 = var9;
                                 var42.field203 = var9.field2304;
                                 Client.field483.method2361(var42);
                              }

                              var9.field2337 = Client.field557;
                           }

                           if(Client.field457 > var9.field2334 && null != var9.field2309) {
                              var42 = new class18();
                              var42.field193 = var9;
                              var42.field203 = var9.field2309;
                              Client.field483.method2361(var42);
                           }

                           if(Client.field477 > var9.field2334 && null != var9.field2317) {
                              var42 = new class18();
                              var42.field193 = var9;
                              var42.field203 = var9.field2317;
                              Client.field483.method2361(var42);
                           }

                           if(Client.field338 > var9.field2334 && var9.field2312 != null) {
                              var42 = new class18();
                              var42.field193 = var9;
                              var42.field203 = var9.field2312;
                              Client.field483.method2361(var42);
                           }

                           if(Client.field466 > var9.field2334 && var9.field2310 != null) {
                              var42 = new class18();
                              var42.field193 = var9;
                              var42.field203 = var9.field2310;
                              Client.field483.method2361(var42);
                           }

                           if(Client.field480 > var9.field2334 && null != var9.field2318) {
                              var42 = new class18();
                              var42.field193 = var9;
                              var42.field203 = var9.field2318;
                              Client.field483.method2361(var42);
                           }

                           if(Client.field481 > var9.field2334 && null != var9.field2313) {
                              var42 = new class18();
                              var42.field193 = var9;
                              var42.field203 = var9.field2313;
                              Client.field483.method2361(var42);
                           }

                           var9.field2334 = Client.field469;
                           if(null != var9.field2274) {
                              for(var21 = 0; var21 < Client.field507; ++var21) {
                                 class18 var36 = new class18();
                                 var36.field193 = var9;
                                 var36.field199 = Client.field302[var21];
                                 var36.field200 = Client.field508[var21];
                                 var36.field203 = var9.field2274;
                                 Client.field483.method2361(var36);
                              }
                           }
                        }
                     }

                     if(!var9.field2204 && Client.field455 == null && null == CombatInfo1.field669 && !Client.isMenuOpen) {
                        if((var9.field2322 >= 0 || var9.field2234 != 0) && class115.field1814 >= var12 && class115.field1821 >= var13 && class115.field1814 < var14 && class115.field1821 < var15) {
                           if(var9.field2322 >= 0) {
                              class22.field245 = var0[var9.field2322];
                           } else {
                              class22.field245 = var9;
                           }
                        }

                        if(var9.type == 8 && class115.field1814 >= var12 && class115.field1821 >= var13 && class115.field1814 < var14 && class115.field1821 < var15) {
                           class72.field1192 = var9;
                        }

                        if(var9.scrollHeight > var9.height) {
                           World.method630(var9, var9.width + var10, var11, var9.height, var9.scrollHeight, class115.field1814, class115.field1821);
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
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)[LModIcon;",
      garbageValue = "-1361587751"
   )
   public static ModIcon[] method2197(class182 var0, String var1, String var2) {
      int var3 = var0.method3218(var1);
      int var4 = var0.method3219(var3, var2);
      return class178.method3194(var0, var3, var4);
   }
}
