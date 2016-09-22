import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
public final class class107 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1797270825
   )
   int field1861;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1535956907
   )
   int field1862;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -979157515
   )
   int field1863;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1835197317
   )
   int field1864;
   @ObfuscatedName("io")
   static Widget field1865;
   @ObfuscatedName("et")
   static SpritePixels[] field1866;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -325628627
   )
   int field1868;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1939896641
   )
   int field1869;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -146034795
   )
   int field1870;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1180032155
   )
   int field1871;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 766949003
   )
   int field1872;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 974281427
   )
   int field1873;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 616971361
   )
   int field1874;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1753339321
   )
   int field1875;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 372953339
   )
   int field1876;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 636917915
   )
   int field1877;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1310010795
   )
   int field1878;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1669650739
   )
   int field1879;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -919674781
   )
   int field1880;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 413648995
   )
   int field1881;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "48"
   )
   public static int method2313(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LSequence;IIII)V",
      garbageValue = "-1014576208"
   )
   static void method2314(Sequence var0, int var1, int var2, int var3) {
      if(Client.field522 < 50 && Client.field414 != 0) {
         if(null != var0.field1016 && var1 < var0.field1016.length) {
            int var4 = var0.field1016[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field523[Client.field522] = var5;
               Client.field428[Client.field522] = var6;
               Client.field471[Client.field522] = 0;
               Client.field432[Client.field522] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field526[Client.field522] = var7 + (var8 << 16) + (var9 << 8);
               ++Client.field522;
            }
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)Lclass133;",
      garbageValue = "-83"
   )
   public static class133 method2315(int var0) {
      class133[] var1 = new class133[]{class133.field2130, class133.field2131, class133.field2132};
      class133[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class133 var4 = var2[var3];
         if(var4.field2133 == var0) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Lclass48;",
      garbageValue = "1109133640"
   )
   public static class48 method2316(int var0) {
      class48 var1 = (class48)class48.field1072.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class48.field1084.method3309(4, var0);
         var1 = new class48();
         if(var2 != null) {
            var1.method1006(new Buffer(var2), var0);
         }

         var1.method997();
         class48.field1072.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "-36"
   )
   public static boolean method2317(char var0) {
      return var0 >= 32 && var0 <= 126?true:(var0 >= 160 && var0 <= 255?true:var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376);
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIII)V",
      garbageValue = "-81166592"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class82.method1830(var2, var3, var4, var5);
      class94.method2118();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.field453)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field518] = var6 + var10.relativeX;
               Client.widgetPositionY[Client.field518] = var7 + var10.relativeY;
               Client.widgetBoundsWidth[Client.field518] = var10.width;
               Client.widgetBoundsHeight[Client.field518] = var10.height;
               var11 = ++Client.field518 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.field2948 = Client.gameCycle;
            if(!var10.field2815 || !class11.method154(var10)) {
               if(var10.contentType > 0) {
                  class12.method161(var10);
               }

               int var12 = var6 + var10.relativeX;
               int var13 = var7 + var10.relativeY;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(var10 == Client.field453) {
                  if(var1 != -1412584499 && !var10.field2894) {
                     class18.field249 = var0;
                     class117.field2048 = var6;
                     class24.field628 = var7;
                     continue;
                  }

                  if(Client.field464 && Client.field458) {
                     var15 = class143.field2225;
                     var16 = class143.field2222;
                     var15 -= Client.field511;
                     var16 -= Client.field456;
                     if(var15 < Client.field459) {
                        var15 = Client.field459;
                     }

                     if(var10.width + var15 > Client.field443.width + Client.field459) {
                        var15 = Client.field443.width + Client.field459 - var10.width;
                     }

                     if(var16 < Client.field460) {
                        var16 = Client.field460;
                     }

                     if(var16 + var10.height > Client.field460 + Client.field443.height) {
                        var16 = Client.field460 + Client.field443.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2894) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var20;
               int var21;
               int var36;
               int var38;
               if(var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.type == 9) {
                  var36 = var12;
                  var20 = var13;
                  var21 = var10.width + var12;
                  var38 = var10.height + var13;
                  if(var21 < var12) {
                     var36 = var21;
                     var21 = var12;
                  }

                  if(var38 < var13) {
                     var20 = var38;
                     var38 = var13;
                  }

                  ++var21;
                  ++var38;
                  var15 = var36 > var2?var36:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var21 < var4?var21:var4;
                  var18 = var38 < var5?var38:var5;
               } else {
                  var36 = var12 + var10.width;
                  var20 = var10.height + var13;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var36 < var4?var36:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.field2815 || var15 < var17 && var16 < var18) {
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.field296) {
                           var13 += 15;
                           class0.field14.method4072("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var46 = Runtime.getRuntime();
                           var20 = (int)((var46.totalMemory() - var46.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && Client.field285) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.field285) {
                              var21 = 16711680;
                           }

                           class0.field14.method4072("Mem:" + var20 + "k", var10.width + var12, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field429 = var12;
                        Client.field430 = var13;
                        SecondaryBufferProvider.method1678(var12, var13, var10.width, var10.height);
                        Client.field374[var10.boundsIndex] = true;
                        class82.method1830(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        class24.method597(var10, var12, var13, var11);
                        class82.method1830(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class178 var45 = var10.method3445(false);
                        if(var45 != null) {
                           if(Client.field404 < 3) {
                              Frames.field1853.method1789(var12, var13, var45.field2959, var45.field2964, 25, 25, Client.mapAngle, 256, var45.field2961, var45.field2960);
                           } else {
                              class82.method1874(var12, var13, 0, var45.field2961, var45.field2960);
                           }
                        }

                        class82.method1830(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.field2815 && class11.method154(var10) && class40.field906 != var10) {
                        continue;
                     }

                     if(!var10.field2815) {
                        if(var10.scrollY > var10.scrollHeight - var10.height) {
                           var10.scrollY = var10.scrollHeight - var10.height;
                        }

                        if(var10.scrollY < 0) {
                           var10.scrollY = 0;
                        }
                     }

                     gameDraw(var0, var10.id, var15, var16, var17, var18, var12 - var10.itemId, var13 - var10.scrollY, var11);
                     if(null != var10.children) {
                        gameDraw(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.itemId, var13 - var10.scrollY, var11);
                     }

                     WidgetNode var19 = (WidgetNode)Client.componentTable.method3817((long)var10.id);
                     if(null != var19) {
                        class51.method1048(var19.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     class82.method1830(var2, var3, var4, var5);
                     class94.method2118();
                  }

                  if(Client.isResized || Client.field402[var11] || Client.field519 > 1) {
                     int var24;
                     int var39;
                     if(var10.type == 0 && !var10.field2815 && var10.scrollHeight > var10.height) {
                        var36 = var10.width + var12;
                        var20 = var10.scrollY;
                        var21 = var10.height;
                        var38 = var10.scrollHeight;
                        class113.field2023[0].method1900(var36, var13);
                        class113.field2023[1].method1900(var36, var13 + var21 - 16);
                        class82.method1883(var36, var13 + 16, 16, var21 - 32, Client.field360);
                        var39 = (var21 - 32) * var21 / var38;
                        if(var39 < 8) {
                           var39 = 8;
                        }

                        var24 = var20 * (var21 - 32 - var39) / (var38 - var21);
                        class82.method1883(var36, 16 + var13 + var24, 16, var39, Client.field361);
                        class82.method1838(var36, 16 + var13 + var24, var39, Client.field363);
                        class82.method1838(var36 + 1, var24 + 16 + var13, var39, Client.field363);
                        class82.method1828(var36, var24 + var13 + 16, 16, Client.field363);
                        class82.method1828(var36, var24 + var13 + 17, 16, Client.field363);
                        class82.method1838(var36 + 15, 16 + var13 + var24, var39, Client.field362);
                        class82.method1838(var36 + 14, var24 + 17 + var13, var39 - 1, Client.field362);
                        class82.method1828(var36, var39 + 15 + var13 + var24, 16, Client.field362);
                        class82.method1828(1 + var36, var24 + var13 + 14 + var39, 15, Client.field362);
                     }

                     if(var10.type != 1) {
                        int var25;
                        int var26;
                        int var29;
                        if(var10.type == 2) {
                           var36 = 0;

                           for(var20 = 0; var20 < var10.field2828; ++var20) {
                              for(var21 = 0; var21 < var10.field2827; ++var21) {
                                 var38 = var12 + var21 * (var10.field2882 + 32);
                                 var39 = (32 + var10.field2883) * var20 + var13;
                                 if(var36 < 20) {
                                    var38 += var10.field2922[var36];
                                    var39 += var10.field2885[var36];
                                 }

                                 if(var10.itemIds[var36] <= 0) {
                                    if(var10.field2858 != null && var36 < 20) {
                                       SpritePixels var55 = var10.method3443(var36);
                                       if(var55 != null) {
                                          var55.method1746(var38, var39);
                                       } else if(Widget.field2814) {
                                          class53.method1101(var10);
                                       }
                                    }
                                 } else {
                                    boolean var50 = false;
                                    boolean var51 = false;
                                    var26 = var10.itemIds[var36] - 1;
                                    if(var38 + 32 > var2 && var38 < var4 && 32 + var39 > var3 && var39 < var5 || var10 == class26.field650 && Client.field396 == var36) {
                                       SpritePixels var37;
                                       if(Client.field524 == 1 && class22.field591 == var36 && class12.field176 == var10.id) {
                                          var37 = class134.createSprite(var26, var10.itemQuantities[var36], 2, 0, 2, false);
                                       } else {
                                          var37 = class134.createSprite(var26, var10.itemQuantities[var36], 1, 3153952, 2, false);
                                       }

                                       if(var37 != null) {
                                          if(class26.field650 == var10 && var36 == Client.field396) {
                                             var24 = class143.field2225 - Client.field450;
                                             var25 = class143.field2222 - Client.field398;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.field515 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var37.method1752(var38 + var24, var25 + var39, 128);
                                             if(var1 != -1) {
                                                Widget var28 = var0[var1 & '\uffff'];
                                                if(var39 + var25 < class82.field1491 && var28.scrollY > 0) {
                                                   var29 = (class82.field1491 - var39 - var25) * Client.field358 / 3;
                                                   if(var29 > Client.field358 * 10) {
                                                      var29 = Client.field358 * 10;
                                                   }

                                                   if(var29 > var28.scrollY) {
                                                      var29 = var28.scrollY;
                                                   }

                                                   var28.scrollY -= var29;
                                                   Client.field398 += var29;
                                                   class53.method1101(var28);
                                                }

                                                if(32 + var39 + var25 > class82.field1490 && var28.scrollY < var28.scrollHeight - var28.height) {
                                                   var29 = (32 + var39 + var25 - class82.field1490) * Client.field358 / 3;
                                                   if(var29 > Client.field358 * 10) {
                                                      var29 = Client.field358 * 10;
                                                   }

                                                   if(var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                      var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                   }

                                                   var28.scrollY += var29;
                                                   Client.field398 -= var29;
                                                   class53.method1101(var28);
                                                }
                                             }
                                          } else if(class35.field801 == var10 && Client.field395 == var36) {
                                             var37.method1752(var38, var39, 128);
                                          } else {
                                             var37.method1746(var38, var39);
                                          }
                                       } else {
                                          class53.method1101(var10);
                                       }
                                    }
                                 }

                                 ++var36;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class49.method1030(var10)) {
                              var36 = var10.field2861;
                              if(class40.field906 == var10 && var10.field2844 != 0) {
                                 var36 = var10.field2844;
                              }
                           } else {
                              var36 = var10.textColor;
                              if(var10 == class40.field906 && var10.field2913 != 0) {
                                 var36 = var10.field2913;
                              }
                           }

                           if(var10.field2811) {
                              switch(var10.field2910.field1515) {
                              case 1:
                                 class82.method1879(var12, var13, var10.width, var10.height, var10.textColor, var10.field2861, 256 - (var10.opacity & 255), 256 - (var10.field2848 & 255));
                                 break;
                              case 2:
                                 class82.method1831(var12, var13, var10.width, var10.height, var10.textColor, var10.field2861, 256 - (var10.opacity & 255), 256 - (var10.field2848 & 255));
                                 break;
                              case 3:
                                 class82.method1832(var12, var13, var10.width, var10.height, var10.textColor, var10.field2861, 256 - (var10.opacity & 255), 256 - (var10.field2848 & 255));
                                 break;
                              case 4:
                                 class82.method1880(var12, var13, var10.width, var10.height, var10.textColor, var10.field2861, 256 - (var10.opacity & 255), 256 - (var10.field2848 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    class82.method1883(var12, var13, var10.width, var10.height, var36);
                                 } else {
                                    class82.method1866(var12, var13, var10.width, var10.height, var36, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              class82.method1834(var12, var13, var10.width, var10.height, var36);
                           } else {
                              class82.method1835(var12, var13, var10.width, var10.height, var36, 256 - (var14 & 255));
                           }
                        } else {
                           class227 var43;
                           if(var10.type == 4) {
                              var43 = var10.method3442();
                              if(null == var43) {
                                 if(Widget.field2814) {
                                    class53.method1101(var10);
                                 }
                              } else {
                                 String var54 = var10.text;
                                 if(class49.method1030(var10)) {
                                    var20 = var10.field2861;
                                    if(class40.field906 == var10 && var10.field2844 != 0) {
                                       var20 = var10.field2844;
                                    }

                                    if(var10.field2859.length() > 0) {
                                       var54 = var10.field2859;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(class40.field906 == var10 && var10.field2913 != 0) {
                                       var20 = var10.field2913;
                                    }
                                 }

                                 if(var10.field2815 && var10.item != -1) {
                                    ItemComposition var48 = MessageNode.getItemDefinition(var10.item);
                                    var54 = var48.name;
                                    if(null == var54) {
                                       var54 = "null";
                                    }

                                    if((var48.isStackable == 1 || var10.stackSize != 1) && var10.stackSize != -1) {
                                       var54 = class153.method3186(16748608) + var54 + "</col>" + " " + 'x' + class4.method49(var10.stackSize);
                                    }
                                 }

                                 if(var10 == Client.field444) {
                                    Object var10000 = null;
                                    var54 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.field2815) {
                                    var54 = class10.method135(var54, var10);
                                 }

                                 var43.method4073(var54, var12, var13, var10.width, var10.height, var20, var10.field2881?0:-1, var10.field2879, var10.field2880, var10.field2878);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var44;
                              if(!var10.field2815) {
                                 var44 = var10.method3441(class49.method1030(var10));
                                 if(var44 != null) {
                                    var44.method1746(var12, var13);
                                 } else if(Widget.field2814) {
                                    class53.method1101(var10);
                                 }
                              } else {
                                 if(var10.item != -1) {
                                    var44 = class134.createSprite(var10.item, var10.stackSize, var10.borderThickness, var10.sprite2, var10.field2874, false);
                                 } else {
                                    var44 = var10.method3441(false);
                                 }

                                 if(null == var44) {
                                    if(Widget.field2814) {
                                       class53.method1101(var10);
                                    }
                                 } else {
                                    var20 = var44.field1481;
                                    var21 = var44.field1482;
                                    if(!var10.field2845) {
                                       var38 = var10.width * 4096 / var20;
                                       if(var10.field2807 != 0) {
                                          var44.method1759(var10.width / 2 + var12, var10.height / 2 + var13, var10.field2807, var38);
                                       } else if(var14 != 0) {
                                          var44.method1754(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var21 == var10.height) {
                                          var44.method1746(var12, var13);
                                       } else {
                                          var44.method1770(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       class82.method1824(var12, var13, var10.width + var12, var13 + var10.height);
                                       var38 = (var10.width + (var20 - 1)) / var20;
                                       var39 = (var10.height + (var21 - 1)) / var21;

                                       for(var24 = 0; var24 < var38; ++var24) {
                                          for(var25 = 0; var25 < var39; ++var25) {
                                             if(var10.field2807 != 0) {
                                                var44.method1759(var20 / 2 + var12 + var24 * var20, var13 + var25 * var21 + var21 / 2, var10.field2807, 4096);
                                             } else if(var14 != 0) {
                                                var44.method1752(var24 * var20 + var12, var13 + var21 * var25, 256 - (var14 & 255));
                                             } else {
                                                var44.method1746(var24 * var20 + var12, var25 * var21 + var13);
                                             }
                                          }
                                       }

                                       class82.method1830(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var23;
                              if(var10.type == 6) {
                                 boolean var52 = class49.method1030(var10);
                                 if(var52) {
                                    var20 = var10.field2864;
                                 } else {
                                    var20 = var10.field2938;
                                 }

                                 Model var53 = null;
                                 var38 = 0;
                                 if(var10.item != -1) {
                                    var23 = MessageNode.getItemDefinition(var10.item);
                                    if(var23 != null) {
                                       var23 = var23.method1127(var10.stackSize);
                                       var53 = var23.getModel(1);
                                       if(null != var53) {
                                          var53.method2347();
                                          var38 = var53.modelHeight / 2;
                                       } else {
                                          class53.method1101(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var53 = Client.field554.method3524((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var53 = WidgetNode.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var53 = var10.method3478((Sequence)null, -1, var52, WidgetNode.localPlayer.composition);
                                    if(null == var53 && Widget.field2814) {
                                       class53.method1101(var10);
                                    }
                                 } else {
                                    Sequence var49 = Friend.getAnimation(var20);
                                    var53 = var10.method3478(var49, var10.field2862, var52, WidgetNode.localPlayer.composition);
                                    if(var53 == null && Widget.field2814) {
                                       class53.method1101(var10);
                                    }
                                 }

                                 class94.method2121(var10.width / 2 + var12, var13 + var10.height / 2);
                                 var39 = class94.field1670[var10.rotationX] * var10.field2870 >> 16;
                                 var24 = var10.field2870 * class94.field1676[var10.rotationX] >> 16;
                                 if(null != var53) {
                                    if(!var10.field2815) {
                                       var53.method2319(0, var10.rotationZ, 0, var10.rotationX, 0, var39, var24);
                                    } else {
                                       var53.method2347();
                                       if(var10.field2873) {
                                          var53.method2337(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2865, var38 + var39 + var10.field2843, var24 + var10.field2843, var10.field2870);
                                       } else {
                                          var53.method2319(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2865, var39 + var38 + var10.field2843, var10.field2843 + var24);
                                       }
                                    }
                                 }

                                 class94.method2179();
                              } else {
                                 if(var10.type == 7) {
                                    var43 = var10.method3442();
                                    if(var43 == null) {
                                       if(Widget.field2814) {
                                          class53.method1101(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2828; ++var21) {
                                       for(var38 = 0; var38 < var10.field2827; ++var38) {
                                          if(var10.itemIds[var20] > 0) {
                                             var23 = MessageNode.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var41;
                                             if(var23.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var41 = class153.method3186(16748608) + var23.name + "</col>";
                                             } else {
                                                var41 = class153.method3186(16748608) + var23.name + "</col>" + " " + 'x' + class4.method49(var10.itemQuantities[var20]);
                                             }

                                             var25 = var12 + var38 * (var10.field2882 + 115);
                                             var26 = var21 * (var10.field2883 + 12) + var13;
                                             if(var10.field2879 == 0) {
                                                var43.method4157(var41, var25, var26, var10.textColor, var10.field2881?0:-1);
                                             } else if(var10.field2879 == 1) {
                                                var43.method4080(var41, var25 + var10.width / 2, var26, var10.textColor, var10.field2881?0:-1);
                                             } else {
                                                var43.method4072(var41, var25 + var10.width - 1, var26, var10.textColor, var10.field2881?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 int var27;
                                 if(var10.type == 8 && var10 == field1865 && Client.field565 == Client.field431) {
                                    var36 = 0;
                                    var20 = 0;
                                    class227 var40 = class0.field14;
                                    String var22 = var10.text;

                                    String var47;
                                    for(var22 = class10.method135(var22, var10); var22.length() > 0; var20 += var40.field3237 + 1) {
                                       var24 = var22.indexOf("<br>");
                                       if(var24 != -1) {
                                          var47 = var22.substring(0, var24);
                                          var22 = var22.substring(4 + var24);
                                       } else {
                                          var47 = var22;
                                          var22 = "";
                                       }

                                       var25 = var40.method4065(var47);
                                       if(var25 > var36) {
                                          var36 = var25;
                                       }
                                    }

                                    var36 += 6;
                                    var20 += 7;
                                    var24 = var10.width + var12 - 5 - var36;
                                    var25 = var10.height + var13 + 5;
                                    if(var24 < var12 + 5) {
                                       var24 = var12 + 5;
                                    }

                                    if(var36 + var24 > var4) {
                                       var24 = var4 - var36;
                                    }

                                    if(var25 + var20 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    class82.method1883(var24, var25, var36, var20, 16777120);
                                    class82.method1834(var24, var25, var36, var20, 0);
                                    var22 = var10.text;
                                    var26 = var40.field3237 + var25 + 2;

                                    for(var22 = class10.method135(var22, var10); var22.length() > 0; var26 += var40.field3237 + 1) {
                                       var27 = var22.indexOf("<br>");
                                       if(var27 != -1) {
                                          var47 = var22.substring(0, var27);
                                          var22 = var22.substring(var27 + 4);
                                       } else {
                                          var47 = var22;
                                          var22 = "";
                                       }

                                       var40.method4157(var47, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2849 == 1) {
                                       if(var10.field2939) {
                                          var36 = var12;
                                          var20 = var13 + var10.height;
                                          var21 = var10.width + var12;
                                          var38 = var13;
                                       } else {
                                          var36 = var12;
                                          var20 = var13;
                                          var21 = var12 + var10.width;
                                          var38 = var13 + var10.height;
                                       }

                                       class82.method1876(var36, var20, var21, var38, var10.textColor);
                                    } else {
                                       var36 = var10.width >= 0?var10.width:-var10.width;
                                       var20 = var10.height >= 0?var10.height:-var10.height;
                                       var21 = var36;
                                       if(var36 < var20) {
                                          var21 = var20;
                                       }

                                       if(var21 != 0) {
                                          var38 = (var10.width << 16) / var21;
                                          var39 = (var10.height << 16) / var21;
                                          if(var39 <= var38) {
                                             var38 = -var38;
                                          } else {
                                             var39 = -var39;
                                          }

                                          var24 = var10.field2849 * var39 >> 17;
                                          var25 = 1 + var10.field2849 * var39 >> 17;
                                          var26 = var10.field2849 * var38 >> 17;
                                          var27 = 1 + var38 * var10.field2849 >> 17;
                                          int var42 = var24 + var12;
                                          var29 = var12 - var25;
                                          int var30 = var10.width + var12 - var25;
                                          int var31 = var10.width + var12 + var24;
                                          int var32 = var26 + var13;
                                          int var33 = var13 - var27;
                                          int var34 = var13 + var10.height - var27;
                                          int var35 = var26 + var10.height + var13;
                                          class94.setRasterClippingEnabled(var42, var29, var30);
                                          class94.rasterFlat(var32, var33, var34, var42, var29, var30, var10.textColor);
                                          class94.setRasterClippingEnabled(var42, var30, var31);
                                          class94.rasterFlat(var32, var34, var35, var42, var30, var31, var10.textColor);
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
      }

   }
}
