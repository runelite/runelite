import java.util.Date;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
public class class55 {
   @ObfuscatedName("i")
   @Export("scriptLocalInts")
   static int[] scriptLocalInts;
   @ObfuscatedName("ae")
   static int[] field626;
   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   @Export("indexTrack2")
   static IndexData indexTrack2;

   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "-745778848"
   )
   static int method855(int var0, Script var1, boolean var2) {
      if(var0 < 1000) {
         return PacketNode.method3446(var0, var1, var2);
      } else if(var0 < 1100) {
         return WidgetNode.method1151(var0, var1, var2);
      } else if(var0 < 1200) {
         return GZipDecompressor.method3475(var0, var1, var2);
      } else if(var0 < 1300) {
         return AbstractSoundSystem.method2265(var0, var1, var2);
      } else if(var0 < 1400) {
         return SoundTaskDataProvider.method837(var0, var1, var2);
      } else if(var0 < 1500) {
         return GameObject.method3072(var0, var1, var2);
      } else {
         byte var3;
         Widget var33;
         if(var0 < 1600) {
            var33 = var2?class233.field2755:class81.field1260;
            if(var0 == 1500) {
               class81.intStack[++class5.intStackSize - 1] = var33.relativeX;
               var3 = 1;
            } else if(var0 == 1501) {
               class81.intStack[++class5.intStackSize - 1] = var33.relativeY;
               var3 = 1;
            } else if(var0 == 1502) {
               class81.intStack[++class5.intStackSize - 1] = var33.width;
               var3 = 1;
            } else if(var0 == 1503) {
               class81.intStack[++class5.intStackSize - 1] = var33.height;
               var3 = 1;
            } else if(var0 == 1504) {
               class81.intStack[++class5.intStackSize - 1] = var33.isHidden?1:0;
               var3 = 1;
            } else if(var0 == 1505) {
               class81.intStack[++class5.intStackSize - 1] = var33.parentId;
               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 1700) {
            Widget var50 = var2?class233.field2755:class81.field1260;
            if(var0 == 1600) {
               class81.intStack[++class5.intStackSize - 1] = var50.scrollX;
               var3 = 1;
            } else if(var0 == 1601) {
               class81.intStack[++class5.intStackSize - 1] = var50.scrollY;
               var3 = 1;
            } else if(var0 == 1602) {
               class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var50.text;
               var3 = 1;
            } else if(var0 == 1603) {
               class81.intStack[++class5.intStackSize - 1] = var50.scrollWidth;
               var3 = 1;
            } else if(var0 == 1604) {
               class81.intStack[++class5.intStackSize - 1] = var50.scrollHeight;
               var3 = 1;
            } else if(var0 == 1605) {
               class81.intStack[++class5.intStackSize - 1] = var50.modelZoom;
               var3 = 1;
            } else if(var0 == 1606) {
               class81.intStack[++class5.intStackSize - 1] = var50.rotationX;
               var3 = 1;
            } else if(var0 == 1607) {
               class81.intStack[++class5.intStackSize - 1] = var50.rotationY;
               var3 = 1;
            } else if(var0 == 1608) {
               class81.intStack[++class5.intStackSize - 1] = var50.rotationZ;
               var3 = 1;
            } else if(var0 == 1609) {
               class81.intStack[++class5.intStackSize - 1] = var50.opacity;
               var3 = 1;
            } else if(var0 == 1610) {
               class81.intStack[++class5.intStackSize - 1] = var50.field2952;
               var3 = 1;
            } else if(var0 == 1611) {
               class81.intStack[++class5.intStackSize - 1] = var50.textColor;
               var3 = 1;
            } else if(var0 == 1612) {
               class81.intStack[++class5.intStackSize - 1] = var50.field2879;
               var3 = 1;
            } else if(var0 == 1613) {
               class81.intStack[++class5.intStackSize - 1] = var50.field2808.rsOrdinal();
               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 1800) {
            var33 = var2?class233.field2755:class81.field1260;
            if(var0 == 1700) {
               class81.intStack[++class5.intStackSize - 1] = var33.itemId;
               var3 = 1;
            } else if(var0 == 1701) {
               if(var33.itemId != -1) {
                  class81.intStack[++class5.intStackSize - 1] = var33.itemQuantity;
               } else {
                  class81.intStack[++class5.intStackSize - 1] = 0;
               }

               var3 = 1;
            } else if(var0 == 1702) {
               class81.intStack[++class5.intStackSize - 1] = var33.index;
               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 1900) {
            return GrandExchangeEvent.method88(var0, var1, var2);
         } else if(var0 < 2000) {
            return class197.method3776(var0, var1, var2);
         } else if(var0 < 2100) {
            return WidgetNode.method1151(var0, var1, var2);
         } else if(var0 < 2200) {
            return GZipDecompressor.method3475(var0, var1, var2);
         } else if(var0 < 2300) {
            return AbstractSoundSystem.method2265(var0, var1, var2);
         } else if(var0 < 2400) {
            return SoundTaskDataProvider.method837(var0, var1, var2);
         } else if(var0 < 2500) {
            return GameObject.method3072(var0, var1, var2);
         } else if(var0 < 2600) {
            return class88.method1917(var0, var1, var2);
         } else if(var0 < 2700) {
            return Signlink.method3242(var0, var1, var2);
         } else if(var0 < 2800) {
            return UnitPriceComparator.method139(var0, var1, var2);
         } else if(var0 < 2900) {
            return WorldMapRegion.method535(var0, var1, var2);
         } else if(var0 < 3000) {
            return class197.method3776(var0, var1, var2);
         } else if(var0 < 3200) {
            return MouseInput.method1077(var0, var1, var2);
         } else if(var0 < 3300) {
            if(var0 == 3200) {
               class5.intStackSize -= 3;
               DynamicObject.method2052(class81.intStack[class5.intStackSize], class81.intStack[class5.intStackSize + 1], class81.intStack[class5.intStackSize + 2]);
               var3 = 1;
            } else if(var0 == 3201) {
               WorldMapData.method363(class81.intStack[--class5.intStackSize]);
               var3 = 1;
            } else if(var0 == 3202) {
               class5.intStackSize -= 2;
               class90.method1929(class81.intStack[class5.intStackSize], class81.intStack[class5.intStackSize + 1]);
               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 3400) {
            return FileOnDisk.method2563(var0, var1, var2);
         } else {
            int var4;
            int var6;
            int var9;
            int var12;
            int var47;
            if(var0 < 3500) {
               if(var0 == 3400) {
                  class5.intStackSize -= 2;
                  var4 = class81.intStack[class5.intStackSize];
                  var12 = class81.intStack[class5.intStackSize + 1];
                  Enum var43 = class294.method5225(var4);
                  if(var43.valType != 's') {
                     ;
                  }

                  for(var47 = 0; var47 < var43.size; ++var47) {
                     if(var12 == var43.keys[var47]) {
                        class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var43.stringVals[var47];
                        var43 = null;
                        break;
                     }
                  }

                  if(var43 != null) {
                     class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var43.defaultString;
                  }

                  var3 = 1;
               } else if(var0 == 3408) {
                  class5.intStackSize -= 4;
                  var4 = class81.intStack[class5.intStackSize];
                  var12 = class81.intStack[class5.intStackSize + 1];
                  var6 = class81.intStack[class5.intStackSize + 2];
                  var47 = class81.intStack[class5.intStackSize + 3];
                  Enum var34 = class294.method5225(var6);
                  if(var4 == var34.keyType && var12 == var34.valType) {
                     for(var9 = 0; var9 < var34.size; ++var9) {
                        if(var47 == var34.keys[var9]) {
                           if(var12 == 115) {
                              class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var34.stringVals[var9];
                           } else {
                              class81.intStack[++class5.intStackSize - 1] = var34.intVals[var9];
                           }

                           var34 = null;
                           break;
                        }
                     }

                     if(var34 != null) {
                        if(var12 == 115) {
                           class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var34.defaultString;
                        } else {
                           class81.intStack[++class5.intStackSize - 1] = var34.defaultInt;
                        }
                     }

                     var3 = 1;
                  } else {
                     if(var12 == 115) {
                        class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "null";
                     } else {
                        class81.intStack[++class5.intStackSize - 1] = 0;
                     }

                     var3 = 1;
                  }
               } else if(var0 == 3411) {
                  var4 = class81.intStack[--class5.intStackSize];
                  Enum var37 = class294.method5225(var4);
                  class81.intStack[++class5.intStackSize - 1] = var37.method4938();
                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else if(var0 < 3700) {
               return Preferences.method1717(var0, var1, var2);
            } else if(var0 < 4000) {
               return class190.method3505(var0, var1, var2);
            } else {
               int var15;
               if(var0 < 4100) {
                  if(var0 == 4000) {
                     class5.intStackSize -= 2;
                     var4 = class81.intStack[class5.intStackSize];
                     var12 = class81.intStack[class5.intStackSize + 1];
                     class81.intStack[++class5.intStackSize - 1] = var12 + var4;
                     var3 = 1;
                  } else if(var0 == 4001) {
                     class5.intStackSize -= 2;
                     var4 = class81.intStack[class5.intStackSize];
                     var12 = class81.intStack[class5.intStackSize + 1];
                     class81.intStack[++class5.intStackSize - 1] = var4 - var12;
                     var3 = 1;
                  } else if(var0 == 4002) {
                     class5.intStackSize -= 2;
                     var4 = class81.intStack[class5.intStackSize];
                     var12 = class81.intStack[class5.intStackSize + 1];
                     class81.intStack[++class5.intStackSize - 1] = var4 * var12;
                     var3 = 1;
                  } else if(var0 == 4003) {
                     class5.intStackSize -= 2;
                     var4 = class81.intStack[class5.intStackSize];
                     var12 = class81.intStack[class5.intStackSize + 1];
                     class81.intStack[++class5.intStackSize - 1] = var4 / var12;
                     var3 = 1;
                  } else if(var0 == 4004) {
                     var4 = class81.intStack[--class5.intStackSize];
                     class81.intStack[++class5.intStackSize - 1] = (int)(Math.random() * (double)var4);
                     var3 = 1;
                  } else if(var0 == 4005) {
                     var4 = class81.intStack[--class5.intStackSize];
                     class81.intStack[++class5.intStackSize - 1] = (int)(Math.random() * (double)(var4 + 1));
                     var3 = 1;
                  } else if(var0 == 4006) {
                     class5.intStackSize -= 5;
                     var4 = class81.intStack[class5.intStackSize];
                     var12 = class81.intStack[class5.intStackSize + 1];
                     var6 = class81.intStack[class5.intStackSize + 2];
                     var47 = class81.intStack[class5.intStackSize + 3];
                     var15 = class81.intStack[class5.intStackSize + 4];
                     class81.intStack[++class5.intStackSize - 1] = var4 + (var15 - var6) * (var12 - var4) / (var47 - var6);
                     var3 = 1;
                  } else if(var0 == 4007) {
                     class5.intStackSize -= 2;
                     var4 = class81.intStack[class5.intStackSize];
                     var12 = class81.intStack[class5.intStackSize + 1];
                     class81.intStack[++class5.intStackSize - 1] = var4 + var12 * var4 / 100;
                     var3 = 1;
                  } else if(var0 == 4008) {
                     class5.intStackSize -= 2;
                     var4 = class81.intStack[class5.intStackSize];
                     var12 = class81.intStack[class5.intStackSize + 1];
                     class81.intStack[++class5.intStackSize - 1] = var4 | 1 << var12;
                     var3 = 1;
                  } else if(var0 == 4009) {
                     class5.intStackSize -= 2;
                     var4 = class81.intStack[class5.intStackSize];
                     var12 = class81.intStack[class5.intStackSize + 1];
                     class81.intStack[++class5.intStackSize - 1] = var4 & -1 - (1 << var12);
                     var3 = 1;
                  } else if(var0 == 4010) {
                     class5.intStackSize -= 2;
                     var4 = class81.intStack[class5.intStackSize];
                     var12 = class81.intStack[class5.intStackSize + 1];
                     class81.intStack[++class5.intStackSize - 1] = (var4 & 1 << var12) != 0?1:0;
                     var3 = 1;
                  } else if(var0 == 4011) {
                     class5.intStackSize -= 2;
                     var4 = class81.intStack[class5.intStackSize];
                     var12 = class81.intStack[class5.intStackSize + 1];
                     class81.intStack[++class5.intStackSize - 1] = var4 % var12;
                     var3 = 1;
                  } else if(var0 == 4012) {
                     class5.intStackSize -= 2;
                     var4 = class81.intStack[class5.intStackSize];
                     var12 = class81.intStack[class5.intStackSize + 1];
                     if(var4 == 0) {
                        class81.intStack[++class5.intStackSize - 1] = 0;
                     } else {
                        class81.intStack[++class5.intStackSize - 1] = (int)Math.pow((double)var4, (double)var12);
                     }

                     var3 = 1;
                  } else if(var0 == 4013) {
                     class5.intStackSize -= 2;
                     var4 = class81.intStack[class5.intStackSize];
                     var12 = class81.intStack[class5.intStackSize + 1];
                     if(var4 == 0) {
                        class81.intStack[++class5.intStackSize - 1] = 0;
                        var3 = 1;
                     } else {
                        switch(var12) {
                        case 0:
                           class81.intStack[++class5.intStackSize - 1] = Integer.MAX_VALUE;
                           break;
                        case 1:
                           class81.intStack[++class5.intStackSize - 1] = var4;
                           break;
                        case 2:
                           class81.intStack[++class5.intStackSize - 1] = (int)Math.sqrt((double)var4);
                           break;
                        case 3:
                           class81.intStack[++class5.intStackSize - 1] = (int)Math.cbrt((double)var4);
                           break;
                        case 4:
                           class81.intStack[++class5.intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)var4));
                           break;
                        default:
                           class81.intStack[++class5.intStackSize - 1] = (int)Math.pow((double)var4, 1.0D / (double)var12);
                        }

                        var3 = 1;
                     }
                  } else if(var0 == 4014) {
                     class5.intStackSize -= 2;
                     var4 = class81.intStack[class5.intStackSize];
                     var12 = class81.intStack[class5.intStackSize + 1];
                     class81.intStack[++class5.intStackSize - 1] = var4 & var12;
                     var3 = 1;
                  } else if(var0 == 4015) {
                     class5.intStackSize -= 2;
                     var4 = class81.intStack[class5.intStackSize];
                     var12 = class81.intStack[class5.intStackSize + 1];
                     class81.intStack[++class5.intStackSize - 1] = var4 | var12;
                     var3 = 1;
                  } else if(var0 == 4018) {
                     class5.intStackSize -= 3;
                     long var19 = (long)class81.intStack[class5.intStackSize];
                     long var21 = (long)class81.intStack[class5.intStackSize + 1];
                     long var23 = (long)class81.intStack[class5.intStackSize + 2];
                     class81.intStack[++class5.intStackSize - 1] = (int)(var23 * var19 / var21);
                     var3 = 1;
                  } else {
                     var3 = 2;
                  }

                  return var3;
               } else {
                  String var25;
                  String var38;
                  if(var0 < 4200) {
                     if(var0 == 4100) {
                        var38 = class81.scriptStringStack[--class316.scriptStringStackSize];
                        var12 = class81.intStack[--class5.intStackSize];
                        class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var38 + var12;
                        var3 = 1;
                     } else if(var0 == 4101) {
                        class316.scriptStringStackSize -= 2;
                        var38 = class81.scriptStringStack[class316.scriptStringStackSize];
                        var25 = class81.scriptStringStack[class316.scriptStringStackSize + 1];
                        class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var38 + var25;
                        var3 = 1;
                     } else if(var0 == 4102) {
                        var38 = class81.scriptStringStack[--class316.scriptStringStackSize];
                        var12 = class81.intStack[--class5.intStackSize];
                        class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var38 + class177.method3421(var12, true);
                        var3 = 1;
                     } else if(var0 == 4103) {
                        var38 = class81.scriptStringStack[--class316.scriptStringStackSize];
                        class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var38.toLowerCase();
                        var3 = 1;
                     } else if(var0 == 4104) {
                        var4 = class81.intStack[--class5.intStackSize];
                        long var17 = ((long)var4 + 11745L) * 86400000L;
                        class81.field1262.setTime(new Date(var17));
                        var47 = class81.field1262.get(5);
                        var15 = class81.field1262.get(2);
                        var9 = class81.field1262.get(1);
                        class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var47 + "-" + class81.field1264[var15] + "-" + var9;
                        var3 = 1;
                     } else if(var0 == 4105) {
                        class316.scriptStringStackSize -= 2;
                        var38 = class81.scriptStringStack[class316.scriptStringStackSize];
                        var25 = class81.scriptStringStack[class316.scriptStringStackSize + 1];
                        if(WorldMapData.localPlayer.composition != null && WorldMapData.localPlayer.composition.isFemale) {
                           class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var25;
                        } else {
                           class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var38;
                        }

                        var3 = 1;
                     } else if(var0 == 4106) {
                        var4 = class81.intStack[--class5.intStackSize];
                        class81.scriptStringStack[++class316.scriptStringStackSize - 1] = Integer.toString(var4);
                        var3 = 1;
                     } else if(var0 == 4107) {
                        class316.scriptStringStackSize -= 2;
                        int[] var49 = class81.intStack;
                        var12 = ++class5.intStackSize - 1;
                        var47 = WorldMapRectangle.method255(class81.scriptStringStack[class316.scriptStringStackSize], class81.scriptStringStack[class316.scriptStringStackSize + 1], Client.languageId);
                        byte var28;
                        if(var47 > 0) {
                           var28 = 1;
                        } else if(var47 < 0) {
                           var28 = -1;
                        } else {
                           var28 = 0;
                        }

                        var49[var12] = var28;
                        var3 = 1;
                     } else {
                        Font var8;
                        byte[] var31;
                        if(var0 == 4108) {
                           var38 = class81.scriptStringStack[--class316.scriptStringStackSize];
                           class5.intStackSize -= 2;
                           var12 = class81.intStack[class5.intStackSize];
                           var6 = class81.intStack[class5.intStackSize + 1];
                           var31 = Client.indexCache13.getConfigData(var6, 0);
                           var8 = new Font(var31);
                           class81.intStack[++class5.intStackSize - 1] = var8.method5498(var38, var12);
                           var3 = 1;
                        } else if(var0 == 4109) {
                           var38 = class81.scriptStringStack[--class316.scriptStringStackSize];
                           class5.intStackSize -= 2;
                           var12 = class81.intStack[class5.intStackSize];
                           var6 = class81.intStack[class5.intStackSize + 1];
                           var31 = Client.indexCache13.getConfigData(var6, 0);
                           var8 = new Font(var31);
                           class81.intStack[++class5.intStackSize - 1] = var8.method5491(var38, var12);
                           var3 = 1;
                        } else if(var0 == 4110) {
                           class316.scriptStringStackSize -= 2;
                           var38 = class81.scriptStringStack[class316.scriptStringStackSize];
                           var25 = class81.scriptStringStack[class316.scriptStringStackSize + 1];
                           if(class81.intStack[--class5.intStackSize] == 1) {
                              class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var38;
                           } else {
                              class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var25;
                           }

                           var3 = 1;
                        } else if(var0 == 4111) {
                           var38 = class81.scriptStringStack[--class316.scriptStringStackSize];
                           class81.scriptStringStack[++class316.scriptStringStackSize - 1] = FontTypeFace.appendTags(var38);
                           var3 = 1;
                        } else if(var0 == 4112) {
                           var38 = class81.scriptStringStack[--class316.scriptStringStackSize];
                           var12 = class81.intStack[--class5.intStackSize];
                           class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var38 + (char)var12;
                           var3 = 1;
                        } else {
                           int[] var32;
                           char var46;
                           boolean var48;
                           if(var0 == 4113) {
                              var4 = class81.intStack[--class5.intStackSize];
                              var32 = class81.intStack;
                              var6 = ++class5.intStackSize - 1;
                              var46 = (char)var4;
                              if(var46 >= ' ' && var46 <= '~') {
                                 var48 = true;
                              } else if(var46 >= 160 && var46 <= 255) {
                                 var48 = true;
                              } else if(var46 != 8364 && var46 != 338 && var46 != 8212 && var46 != 339 && var46 != 376) {
                                 var48 = false;
                              } else {
                                 var48 = true;
                              }

                              var32[var6] = var48?1:0;
                              var3 = 1;
                           } else if(var0 == 4114) {
                              var4 = class81.intStack[--class5.intStackSize];
                              class81.intStack[++class5.intStackSize - 1] = VerticalAlignment.method4747((char)var4)?1:0;
                              var3 = 1;
                           } else if(var0 == 4115) {
                              var4 = class81.intStack[--class5.intStackSize];
                              class81.intStack[++class5.intStackSize - 1] = class19.method163((char)var4)?1:0;
                              var3 = 1;
                           } else if(var0 == 4116) {
                              var4 = class81.intStack[--class5.intStackSize];
                              var32 = class81.intStack;
                              var6 = ++class5.intStackSize - 1;
                              var46 = (char)var4;
                              var48 = var46 >= '0' && var46 <= '9';
                              var32[var6] = var48?1:0;
                              var3 = 1;
                           } else if(var0 == 4117) {
                              var38 = class81.scriptStringStack[--class316.scriptStringStackSize];
                              if(var38 != null) {
                                 class81.intStack[++class5.intStackSize - 1] = var38.length();
                              } else {
                                 class81.intStack[++class5.intStackSize - 1] = 0;
                              }

                              var3 = 1;
                           } else if(var0 == 4118) {
                              var38 = class81.scriptStringStack[--class316.scriptStringStackSize];
                              class5.intStackSize -= 2;
                              var12 = class81.intStack[class5.intStackSize];
                              var6 = class81.intStack[class5.intStackSize + 1];
                              class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var38.substring(var12, var6);
                              var3 = 1;
                           } else if(var0 == 4119) {
                              var38 = class81.scriptStringStack[--class316.scriptStringStackSize];
                              StringBuilder var35 = new StringBuilder(var38.length());
                              boolean var36 = false;

                              for(var47 = 0; var47 < var38.length(); ++var47) {
                                 var46 = var38.charAt(var47);
                                 if(var46 == '<') {
                                    var36 = true;
                                 } else if(var46 == '>') {
                                    var36 = false;
                                 } else if(!var36) {
                                    var35.append(var46);
                                 }
                              }

                              class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var35.toString();
                              var3 = 1;
                           } else if(var0 == 4120) {
                              var38 = class81.scriptStringStack[--class316.scriptStringStackSize];
                              var12 = class81.intStack[--class5.intStackSize];
                              class81.intStack[++class5.intStackSize - 1] = var38.indexOf(var12);
                              var3 = 1;
                           } else if(var0 == 4121) {
                              class316.scriptStringStackSize -= 2;
                              var38 = class81.scriptStringStack[class316.scriptStringStackSize];
                              var25 = class81.scriptStringStack[class316.scriptStringStackSize + 1];
                              var6 = class81.intStack[--class5.intStackSize];
                              class81.intStack[++class5.intStackSize - 1] = var38.indexOf(var25, var6);
                              var3 = 1;
                           } else {
                              var3 = 2;
                           }
                        }
                     }

                     return var3;
                  } else if(var0 < 4300) {
                     if(var0 == 4200) {
                        var4 = class81.intStack[--class5.intStackSize];
                        class81.scriptStringStack[++class316.scriptStringStackSize - 1] = class81.getItemDefinition(var4).name;
                        var3 = 1;
                     } else {
                        ItemComposition var42;
                        if(var0 == 4201) {
                           class5.intStackSize -= 2;
                           var4 = class81.intStack[class5.intStackSize];
                           var12 = class81.intStack[class5.intStackSize + 1];
                           var42 = class81.getItemDefinition(var4);
                           if(var12 >= 1 && var12 <= 5 && var42.groundActions[var12 - 1] != null) {
                              class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var42.groundActions[var12 - 1];
                           } else {
                              class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
                           }

                           var3 = 1;
                        } else if(var0 == 4202) {
                           class5.intStackSize -= 2;
                           var4 = class81.intStack[class5.intStackSize];
                           var12 = class81.intStack[class5.intStackSize + 1];
                           var42 = class81.getItemDefinition(var4);
                           if(var12 >= 1 && var12 <= 5 && var42.inventoryActions[var12 - 1] != null) {
                              class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var42.inventoryActions[var12 - 1];
                           } else {
                              class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
                           }

                           var3 = 1;
                        } else if(var0 == 4203) {
                           var4 = class81.intStack[--class5.intStackSize];
                           class81.intStack[++class5.intStackSize - 1] = class81.getItemDefinition(var4).price;
                           var3 = 1;
                        } else if(var0 == 4204) {
                           var4 = class81.intStack[--class5.intStackSize];
                           class81.intStack[++class5.intStackSize - 1] = class81.getItemDefinition(var4).isStackable == 1?1:0;
                           var3 = 1;
                        } else {
                           ItemComposition var27;
                           if(var0 == 4205) {
                              var4 = class81.intStack[--class5.intStackSize];
                              var27 = class81.getItemDefinition(var4);
                              if(var27.notedTemplate == -1 && var27.note >= 0) {
                                 class81.intStack[++class5.intStackSize - 1] = var27.note;
                              } else {
                                 class81.intStack[++class5.intStackSize - 1] = var4;
                              }

                              var3 = 1;
                           } else if(var0 == 4206) {
                              var4 = class81.intStack[--class5.intStackSize];
                              var27 = class81.getItemDefinition(var4);
                              if(var27.notedTemplate >= 0 && var27.note >= 0) {
                                 class81.intStack[++class5.intStackSize - 1] = var27.note;
                              } else {
                                 class81.intStack[++class5.intStackSize - 1] = var4;
                              }

                              var3 = 1;
                           } else if(var0 == 4207) {
                              var4 = class81.intStack[--class5.intStackSize];
                              class81.intStack[++class5.intStackSize - 1] = class81.getItemDefinition(var4).isMembers?1:0;
                              var3 = 1;
                           } else if(var0 == 4208) {
                              var4 = class81.intStack[--class5.intStackSize];
                              var27 = class81.getItemDefinition(var4);
                              if(var27.int3 == -1 && var27.int2 >= 0) {
                                 class81.intStack[++class5.intStackSize - 1] = var27.int2;
                              } else {
                                 class81.intStack[++class5.intStackSize - 1] = var4;
                              }

                              var3 = 1;
                           } else if(var0 == 4209) {
                              var4 = class81.intStack[--class5.intStackSize];
                              var27 = class81.getItemDefinition(var4);
                              if(var27.int3 >= 0 && var27.int2 >= 0) {
                                 class81.intStack[++class5.intStackSize - 1] = var27.int2;
                              } else {
                                 class81.intStack[++class5.intStackSize - 1] = var4;
                              }

                              var3 = 1;
                           } else if(var0 == 4210) {
                              var38 = class81.scriptStringStack[--class316.scriptStringStackSize];
                              var12 = class81.intStack[--class5.intStackSize];
                              class195.method3774(var38, var12 == 1);
                              class81.intStack[++class5.intStackSize - 1] = SoundTask.field1569;
                              var3 = 1;
                           } else if(var0 == 4211) {
                              if(class49.field576 != null && BoundingBox3D.field250 < SoundTask.field1569) {
                                 class81.intStack[++class5.intStackSize - 1] = class49.field576[++BoundingBox3D.field250 - 1] & '\uffff';
                              } else {
                                 class81.intStack[++class5.intStackSize - 1] = -1;
                              }

                              var3 = 1;
                           } else if(var0 == 4212) {
                              BoundingBox3D.field250 = 0;
                              var3 = 1;
                           } else {
                              var3 = 2;
                           }
                        }
                     }

                     return var3;
                  } else if(var0 >= 5100) {
                     if(var0 < 5400) {
                        return class49.method777(var0, var1, var2);
                     } else if(var0 < 5600) {
                        if(var0 == 5504) {
                           class5.intStackSize -= 2;
                           var47 = class81.intStack[class5.intStackSize];
                           var15 = class81.intStack[class5.intStackSize + 1];
                           if(!Client.field851) {
                              Client.cameraPitchTarget = var47;
                              Client.mapAngle = var15;
                           }

                           var3 = 1;
                        } else if(var0 == 5505) {
                           class81.intStack[++class5.intStackSize - 1] = Client.cameraPitchTarget;
                           var3 = 1;
                        } else if(var0 == 5506) {
                           class81.intStack[++class5.intStackSize - 1] = Client.mapAngle;
                           var3 = 1;
                        } else if(var0 == 5530) {
                           var47 = class81.intStack[--class5.intStackSize];
                           if(var47 < 0) {
                              var47 = 0;
                           }

                           Client.field924 = var47;
                           var3 = 1;
                        } else if(var0 == 5531) {
                           class81.intStack[++class5.intStackSize - 1] = Client.field924;
                           var3 = 1;
                        } else {
                           var3 = 2;
                        }

                        return var3;
                     } else if(var0 < 5700) {
                        if(var0 == 5630) {
                           Client.field1036 = 250;
                           var3 = 1;
                        } else {
                           var3 = 2;
                        }

                        return var3;
                     } else {
                        return var0 < 6300?CombatInfo1.method1670(var0, var1, var2):(var0 < 6600?WorldMapRectangle.method254(var0, var1, var2):(var0 < 6700?Tile.method2683(var0, var1, var2):2));
                     }
                  } else {
                     if(var0 == 5000) {
                        class81.intStack[++class5.intStackSize - 1] = Client.publicChatMode;
                        var3 = 1;
                     } else {
                        PacketNode var39;
                        if(var0 == 5001) {
                           class5.intStackSize -= 3;
                           Client.publicChatMode = class81.intStack[class5.intStackSize];
                           var12 = class81.intStack[class5.intStackSize + 1];
                           class320[] var13 = new class320[]{class320.field3933, class320.field3935, class320.field3934};
                           class320[] var7 = var13;
                           var15 = 0;

                           class320 var11;
                           while(true) {
                              if(var15 >= var7.length) {
                                 var11 = null;
                                 break;
                              }

                              class320 var16 = var7[var15];
                              if(var12 == var16.field3936) {
                                 var11 = var16;
                                 break;
                              }

                              ++var15;
                           }

                           class196.field2568 = var11;
                           if(class196.field2568 == null) {
                              class196.field2568 = class320.field3935;
                           }

                           Client.field1063 = class81.intStack[class5.intStackSize + 2];
                           var39 = class33.method382(ClientPacket.field2437, Client.field1072.field1456);
                           var39.packetBuffer.putByte(Client.publicChatMode);
                           var39.packetBuffer.putByte(class196.field2568.field3936);
                           var39.packetBuffer.putByte(Client.field1063);
                           Client.field1072.method2073(var39);
                           var3 = 1;
                        } else if(var0 == 5002) {
                           var38 = class81.scriptStringStack[--class316.scriptStringStackSize];
                           class5.intStackSize -= 2;
                           var12 = class81.intStack[class5.intStackSize];
                           var6 = class81.intStack[class5.intStackSize + 1];
                           PacketNode var29 = class33.method382(ClientPacket.field2438, Client.field1072.field1456);
                           var29.packetBuffer.putByte(UnitPriceComparator.getLength(var38) + 2);
                           var29.packetBuffer.putString(var38);
                           var29.packetBuffer.putByte(var12 - 1);
                           var29.packetBuffer.putByte(var6);
                           Client.field1072.method2073(var29);
                           var3 = 1;
                        } else if(var0 == 5003) {
                           class5.intStackSize -= 2;
                           var4 = class81.intStack[class5.intStackSize];
                           var12 = class81.intStack[class5.intStackSize + 1];
                           ChatLineBuffer var30 = (ChatLineBuffer)class95.chatLineMap.get(Integer.valueOf(var4));
                           MessageNode var40 = var30.getMessage(var12);
                           if(var40 != null) {
                              class81.intStack[++class5.intStackSize - 1] = var40.id;
                              class81.intStack[++class5.intStackSize - 1] = var40.tick;
                              class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var40.name != null?var40.name:"";
                              class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var40.sender != null?var40.sender:"";
                              class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var40.value != null?var40.value:"";
                              class81.intStack[++class5.intStackSize - 1] = var40.method1174()?1:(var40.method1186()?2:0);
                           } else {
                              class81.intStack[++class5.intStackSize - 1] = -1;
                              class81.intStack[++class5.intStackSize - 1] = 0;
                              class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
                              class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
                              class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
                              class81.intStack[++class5.intStackSize - 1] = 0;
                           }

                           var3 = 1;
                        } else if(var0 == 5004) {
                           var4 = class81.intStack[--class5.intStackSize];
                           MessageNode var5 = class18.method151(var4);
                           if(var5 != null) {
                              class81.intStack[++class5.intStackSize - 1] = var5.type;
                              class81.intStack[++class5.intStackSize - 1] = var5.tick;
                              class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var5.name != null?var5.name:"";
                              class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var5.sender != null?var5.sender:"";
                              class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var5.value != null?var5.value:"";
                              class81.intStack[++class5.intStackSize - 1] = var5.method1174()?1:(var5.method1186()?2:0);
                           } else {
                              class81.intStack[++class5.intStackSize - 1] = -1;
                              class81.intStack[++class5.intStackSize - 1] = 0;
                              class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
                              class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
                              class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
                              class81.intStack[++class5.intStackSize - 1] = 0;
                           }

                           var3 = 1;
                        } else if(var0 == 5005) {
                           if(class196.field2568 == null) {
                              class81.intStack[++class5.intStackSize - 1] = -1;
                           } else {
                              class81.intStack[++class5.intStackSize - 1] = class196.field2568.field3936;
                           }

                           var3 = 1;
                        } else if(var0 == 5008) {
                           var38 = class81.scriptStringStack[--class316.scriptStringStackSize];
                           var12 = class81.intStack[--class5.intStackSize];
                           String var41 = var38.toLowerCase();
                           byte var14 = 0;
                           if(var41.startsWith("yellow:")) {
                              var14 = 0;
                              var38 = var38.substring("yellow:".length());
                           } else if(var41.startsWith("red:")) {
                              var14 = 1;
                              var38 = var38.substring("red:".length());
                           } else if(var41.startsWith("green:")) {
                              var14 = 2;
                              var38 = var38.substring("green:".length());
                           } else if(var41.startsWith("cyan:")) {
                              var14 = 3;
                              var38 = var38.substring("cyan:".length());
                           } else if(var41.startsWith("purple:")) {
                              var14 = 4;
                              var38 = var38.substring("purple:".length());
                           } else if(var41.startsWith("white:")) {
                              var14 = 5;
                              var38 = var38.substring("white:".length());
                           } else if(var41.startsWith("flash1:")) {
                              var14 = 6;
                              var38 = var38.substring("flash1:".length());
                           } else if(var41.startsWith("flash2:")) {
                              var14 = 7;
                              var38 = var38.substring("flash2:".length());
                           } else if(var41.startsWith("flash3:")) {
                              var14 = 8;
                              var38 = var38.substring("flash3:".length());
                           } else if(var41.startsWith("glow1:")) {
                              var14 = 9;
                              var38 = var38.substring("glow1:".length());
                           } else if(var41.startsWith("glow2:")) {
                              var14 = 10;
                              var38 = var38.substring("glow2:".length());
                           } else if(var41.startsWith("glow3:")) {
                              var14 = 11;
                              var38 = var38.substring("glow3:".length());
                           } else if(Client.languageId != 0) {
                              if(var41.startsWith("yellow:")) {
                                 var14 = 0;
                                 var38 = var38.substring("yellow:".length());
                              } else if(var41.startsWith("red:")) {
                                 var14 = 1;
                                 var38 = var38.substring("red:".length());
                              } else if(var41.startsWith("green:")) {
                                 var14 = 2;
                                 var38 = var38.substring("green:".length());
                              } else if(var41.startsWith("cyan:")) {
                                 var14 = 3;
                                 var38 = var38.substring("cyan:".length());
                              } else if(var41.startsWith("purple:")) {
                                 var14 = 4;
                                 var38 = var38.substring("purple:".length());
                              } else if(var41.startsWith("white:")) {
                                 var14 = 5;
                                 var38 = var38.substring("white:".length());
                              } else if(var41.startsWith("flash1:")) {
                                 var14 = 6;
                                 var38 = var38.substring("flash1:".length());
                              } else if(var41.startsWith("flash2:")) {
                                 var14 = 7;
                                 var38 = var38.substring("flash2:".length());
                              } else if(var41.startsWith("flash3:")) {
                                 var14 = 8;
                                 var38 = var38.substring("flash3:".length());
                              } else if(var41.startsWith("glow1:")) {
                                 var14 = 9;
                                 var38 = var38.substring("glow1:".length());
                              } else if(var41.startsWith("glow2:")) {
                                 var14 = 10;
                                 var38 = var38.substring("glow2:".length());
                              } else if(var41.startsWith("glow3:")) {
                                 var14 = 11;
                                 var38 = var38.substring("glow3:".length());
                              }
                           }

                           var41 = var38.toLowerCase();
                           byte var44 = 0;
                           if(var41.startsWith("wave:")) {
                              var44 = 1;
                              var38 = var38.substring("wave:".length());
                           } else if(var41.startsWith("wave2:")) {
                              var44 = 2;
                              var38 = var38.substring("wave2:".length());
                           } else if(var41.startsWith("shake:")) {
                              var44 = 3;
                              var38 = var38.substring("shake:".length());
                           } else if(var41.startsWith("scroll:")) {
                              var44 = 4;
                              var38 = var38.substring("scroll:".length());
                           } else if(var41.startsWith("slide:")) {
                              var44 = 5;
                              var38 = var38.substring("slide:".length());
                           } else if(Client.languageId != 0) {
                              if(var41.startsWith("wave:")) {
                                 var44 = 1;
                                 var38 = var38.substring("wave:".length());
                              } else if(var41.startsWith("wave2:")) {
                                 var44 = 2;
                                 var38 = var38.substring("wave2:".length());
                              } else if(var41.startsWith("shake:")) {
                                 var44 = 3;
                                 var38 = var38.substring("shake:".length());
                              } else if(var41.startsWith("scroll:")) {
                                 var44 = 4;
                                 var38 = var38.substring("scroll:".length());
                              } else if(var41.startsWith("slide:")) {
                                 var44 = 5;
                                 var38 = var38.substring("slide:".length());
                              }
                           }

                           PacketNode var45 = class33.method382(ClientPacket.field2390, Client.field1072.field1456);
                           var45.packetBuffer.putByte(0);
                           int var10 = var45.packetBuffer.offset;
                           var45.packetBuffer.putByte(var12);
                           var45.packetBuffer.putByte(var14);
                           var45.packetBuffer.putByte(var44);
                           PlayerComposition.method4446(var45.packetBuffer, var38);
                           var45.packetBuffer.method3534(var45.packetBuffer.offset - var10);
                           Client.field1072.method2073(var45);
                           var3 = 1;
                        } else if(var0 == 5009) {
                           class316.scriptStringStackSize -= 2;
                           var38 = class81.scriptStringStack[class316.scriptStringStackSize];
                           var25 = class81.scriptStringStack[class316.scriptStringStackSize + 1];
                           var39 = class33.method382(ClientPacket.field2405, Client.field1072.field1456);
                           var39.packetBuffer.putShort(0);
                           var47 = var39.packetBuffer.offset;
                           var39.packetBuffer.putString(var38);
                           PlayerComposition.method4446(var39.packetBuffer, var25);
                           var39.packetBuffer.method3681(var39.packetBuffer.offset - var47);
                           Client.field1072.method2073(var39);
                           var3 = 1;
                        } else if(var0 == 5015) {
                           if(WorldMapData.localPlayer != null && WorldMapData.localPlayer.name != null) {
                              var38 = WorldMapData.localPlayer.name.getName();
                           } else {
                              var38 = "";
                           }

                           class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var38;
                           var3 = 1;
                        } else if(var0 == 5016) {
                           class81.intStack[++class5.intStackSize - 1] = Client.field1063;
                           var3 = 1;
                        } else if(var0 == 5017) {
                           var4 = class81.intStack[--class5.intStackSize];
                           class81.intStack[++class5.intStackSize - 1] = MapIconReference.method759(var4);
                           var3 = 1;
                        } else if(var0 == 5018) {
                           var4 = class81.intStack[--class5.intStackSize];
                           class81.intStack[++class5.intStackSize - 1] = Actor.method1667(var4);
                           var3 = 1;
                        } else if(var0 == 5019) {
                           var4 = class81.intStack[--class5.intStackSize];
                           class81.intStack[++class5.intStackSize - 1] = class71.method1199(var4);
                           var3 = 1;
                        } else if(var0 == 5020) {
                           var38 = class81.scriptStringStack[--class316.scriptStringStackSize];
                           if(var38.equalsIgnoreCase("toggleroof")) {
                              MapIcon.preferences.hideRoofs = !MapIcon.preferences.hideRoofs;
                              class37.method538();
                              if(MapIcon.preferences.hideRoofs) {
                                 TotalQuantityComparator.sendGameMessage(99, "", "Roofs are now all hidden");
                              } else {
                                 TotalQuantityComparator.sendGameMessage(99, "", "Roofs will only be removed selectively");
                              }
                           }

                           if(var38.equalsIgnoreCase("displayfps")) {
                              Client.displayFps = !Client.displayFps;
                           }

                           if(var38.equalsIgnoreCase("renderself")) {
                              Client.field967 = !Client.field967;
                           }

                           if(var38.equalsIgnoreCase("mouseovertext")) {
                              Client.field996 = !Client.field996;
                           }

                           if(Client.rights >= 2) {
                              if(var38.equalsIgnoreCase("aabb")) {
                                 if(!class7.drawBoundingBoxes3D) {
                                    class7.drawBoundingBoxes3D = true;
                                    class7.boundingBox3DDrawMode = BoundingBox3DDrawMode.ALWAYS;
                                 } else if(BoundingBox3DDrawMode.ALWAYS == class7.boundingBox3DDrawMode) {
                                    class7.drawBoundingBoxes3D = true;
                                    class7.boundingBox3DDrawMode = BoundingBox3DDrawMode.ON_MOUSEOVER;
                                 } else {
                                    class7.drawBoundingBoxes3D = false;
                                 }
                              }

                              if(var38.equalsIgnoreCase("showcoord")) {
                                 class251.renderOverview.field4061 = !class251.renderOverview.field4061;
                              }

                              if(var38.equalsIgnoreCase("fpson")) {
                                 Client.displayFps = true;
                              }

                              if(var38.equalsIgnoreCase("fpsoff")) {
                                 Client.displayFps = false;
                              }

                              if(var38.equalsIgnoreCase("gc")) {
                                 System.gc();
                              }

                              if(var38.equalsIgnoreCase("clientdrop")) {
                                 class28.method253();
                              }

                              if(var38.equalsIgnoreCase("cs")) {
                                 TotalQuantityComparator.sendGameMessage(99, "", "" + Client.field1067);
                              }

                              if(var38.equalsIgnoreCase("errortest") && Client.socketType == 2) {
                                 throw new RuntimeException();
                              }
                           }

                           PacketNode var26 = class33.method382(ClientPacket.field2425, Client.field1072.field1456);
                           var26.packetBuffer.putByte(var38.length() + 1);
                           var26.packetBuffer.putString(var38);
                           Client.field1072.method2073(var26);
                           var3 = 1;
                        } else if(var0 == 5021) {
                           Client.field1064 = class81.scriptStringStack[--class316.scriptStringStackSize].toLowerCase().trim();
                           var3 = 1;
                        } else if(var0 == 5022) {
                           class81.scriptStringStack[++class316.scriptStringStackSize - 1] = Client.field1064;
                           var3 = 1;
                        } else {
                           var3 = 2;
                        }
                     }

                     return var3;
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "507752683"
   )
   public static int method858(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0 - (var3 - 1):7 - var1 - (var4 - 1)));
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1515082939"
   )
   public static void method857() {
      KitDefinition.identKits.reset();
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "([Lig;IIIZI)V",
      garbageValue = "208811133"
   )
   static void method856(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            class44.method674(var6, var2, var3, var4);
            class19.method159(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               GameEngine.method1051(var0, var6, var4);
            }
         }
      }

   }
}
