import net.runelite.mapping.*;

import java.util.Date;

@ObfuscatedName("hc")
@Implements("Coordinates")
public class Coordinates {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   static IndexDataBase field2726;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -269383583
   )
   @Export("plane")
   public int plane;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1934805779
   )
   @Export("worldX")
   public int worldX;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -397623979
   )
   @Export("worldY")
   public int worldY;

   public Coordinates() {
      this.plane = -1;
   }

   @ObfuscatedSignature(
      signature = "(Lhc;)V"
   )
   public Coordinates(Coordinates var1) {
      this.plane = var1.plane;
      this.worldX = var1.worldX;
      this.worldY = var1.worldY;
   }

   public Coordinates(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   public Coordinates(int var1) {
      if(var1 == -1) {
         this.plane = -1;
      } else {
         this.plane = var1 >> 28 & 3;
         this.worldX = var1 >> 14 & 16383;
         this.worldY = var1 & 16383;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-303470005"
   )
   @Export("set")
   public void set(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1055672674"
   )
   @Export("hash30")
   public int hash30() {
      return this.plane << 28 | this.worldX << 14 | this.worldY;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lhc;I)Z",
      garbageValue = "1042031753"
   )
   boolean method4082(Coordinates var1) {
      return this.plane != var1.plane?false:(this.worldX != var1.worldX?false:this.worldY == var1.worldY);
   }

   public boolean equals(Object var1) {
      return this == var1?true:(!(var1 instanceof Coordinates)?false:this.method4082((Coordinates)var1));
   }

   public int hashCode() {
      return this.hash30();
   }

   public String toString() {
      return this.plane + "," + (this.worldX >> 6) + "," + (this.worldY >> 6) + "," + (this.worldX & 63) + "," + (this.worldY & 63);
   }

   @ObfuscatedName("w")
   static final void method4079(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "889444613"
   )
   static int method4091(int var0, Script var1, boolean var2) {
      if(var0 < 1000) {
         return PendingSpawn.method1459(var0, var1, var2);
      } else if(var0 < 1100) {
         return Friend.method1034(var0, var1, var2);
      } else if(var0 < 1200) {
         return AreaMapIconMetadata.method547(var0, var1, var2);
      } else if(var0 < 1300) {
         return GraphicsObject.method1619(var0, var1, var2);
      } else if(var0 < 1400) {
         return class2.method5(var0, var1, var2);
      } else if(var0 < 1500) {
         return class60.method984(var0, var1, var2);
      } else if(var0 < 1600) {
         return VertexNormal.method2601(var0, var1, var2);
      } else {
         byte var3;
         Widget var70;
         if(var0 < 1700) {
            var70 = var2?class139.field2008:AttackOption.field1306;
            if(var0 == 1600) {
               class82.intStack[++class82.intStackSize - 1] = var70.scrollX;
               var3 = 1;
            } else if(var0 == 1601) {
               class82.intStack[++class82.intStackSize - 1] = var70.scrollY;
               var3 = 1;
            } else if(var0 == 1602) {
               class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var70.text;
               var3 = 1;
            } else if(var0 == 1603) {
               class82.intStack[++class82.intStackSize - 1] = var70.scrollWidth;
               var3 = 1;
            } else if(var0 == 1604) {
               class82.intStack[++class82.intStackSize - 1] = var70.scrollHeight;
               var3 = 1;
            } else if(var0 == 1605) {
               class82.intStack[++class82.intStackSize - 1] = var70.modelZoom;
               var3 = 1;
            } else if(var0 == 1606) {
               class82.intStack[++class82.intStackSize - 1] = var70.rotationX;
               var3 = 1;
            } else if(var0 == 1607) {
               class82.intStack[++class82.intStackSize - 1] = var70.rotationY;
               var3 = 1;
            } else if(var0 == 1608) {
               class82.intStack[++class82.intStackSize - 1] = var70.rotationZ;
               var3 = 1;
            } else if(var0 == 1609) {
               class82.intStack[++class82.intStackSize - 1] = var70.opacity;
               var3 = 1;
            } else if(var0 == 1610) {
               class82.intStack[++class82.intStackSize - 1] = var70.field2874;
               var3 = 1;
            } else if(var0 == 1611) {
               class82.intStack[++class82.intStackSize - 1] = var70.textColor;
               var3 = 1;
            } else if(var0 == 1612) {
               class82.intStack[++class82.intStackSize - 1] = var70.field2785;
               var3 = 1;
            } else if(var0 == 1613) {
               class82.intStack[++class82.intStackSize - 1] = var70.field2789.rsOrdinal();
               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 1800) {
            return BuildType.method4241(var0, var1, var2);
         } else {
            int var6;
            int var18;
            int[] var40;
            int var45;
            int var49;
            if(var0 < 1900) {
               var70 = var2?class139.field2008:AttackOption.field1306;
               if(var0 == 1800) {
                  var40 = class82.intStack;
                  var6 = ++class82.intStackSize - 1;
                  var45 = class36.getWidgetConfig(var70);
                  var49 = var45 >> 11 & 63;
                  var40[var6] = var49;
                  var3 = 1;
               } else if(var0 == 1801) {
                  var18 = class82.intStack[--class82.intStackSize];
                  --var18;
                  if(var70.actions != null && var18 < var70.actions.length && var70.actions[var18] != null) {
                     class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var70.actions[var18];
                  } else {
                     class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
                  }

                  var3 = 1;
               } else if(var0 == 1802) {
                  if(var70.name == null) {
                     class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
                  } else {
                     class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var70.name;
                  }

                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else if(var0 < 2000) {
               return AbstractSoundSystem.cs2_2000s(var0, var1, var2);
            } else if(var0 < 2100) {
               return Friend.method1034(var0, var1, var2);
            } else if(var0 < 2200) {
               return AreaMapIconMetadata.method547(var0, var1, var2);
            } else if(var0 < 2300) {
               return GraphicsObject.method1619(var0, var1, var2);
            } else if(var0 < 2400) {
               return class2.method5(var0, var1, var2);
            } else if(var0 < 2500) {
               return class60.method984(var0, var1, var2);
            } else if(var0 < 2600) {
               var70 = VertexNormal.getWidget(class82.intStack[--class82.intStackSize]);
               if(var0 == 2500) {
                  class82.intStack[++class82.intStackSize - 1] = var70.relativeX;
                  var3 = 1;
               } else if(var0 == 2501) {
                  class82.intStack[++class82.intStackSize - 1] = var70.relativeY;
                  var3 = 1;
               } else if(var0 == 2502) {
                  class82.intStack[++class82.intStackSize - 1] = var70.width;
                  var3 = 1;
               } else if(var0 == 2503) {
                  class82.intStack[++class82.intStackSize - 1] = var70.height;
                  var3 = 1;
               } else if(var0 == 2504) {
                  class82.intStack[++class82.intStackSize - 1] = var70.isHidden?1:0;
                  var3 = 1;
               } else if(var0 == 2505) {
                  class82.intStack[++class82.intStackSize - 1] = var70.parentId;
                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else if(var0 < 2700) {
               return Client.cs2_2600s(var0, var1, var2);
            } else {
               int var19;
               if(var0 < 2800) {
                  if(var0 == 2700) {
                     var70 = VertexNormal.getWidget(class82.intStack[--class82.intStackSize]);
                     class82.intStack[++class82.intStackSize - 1] = var70.itemId;
                     var3 = 1;
                  } else if(var0 == 2701) {
                     var70 = VertexNormal.getWidget(class82.intStack[--class82.intStackSize]);
                     if(var70.itemId != -1) {
                        class82.intStack[++class82.intStackSize - 1] = var70.itemQuantity;
                     } else {
                        class82.intStack[++class82.intStackSize - 1] = 0;
                     }

                     var3 = 1;
                  } else if(var0 == 2702) {
                     var19 = class82.intStack[--class82.intStackSize];
                     WidgetNode var48 = (WidgetNode)Client.componentTable.get((long)var19);
                     if(var48 != null) {
                        class82.intStack[++class82.intStackSize - 1] = 1;
                     } else {
                        class82.intStack[++class82.intStackSize - 1] = 0;
                     }

                     var3 = 1;
                  } else if(var0 == 2706) {
                     class82.intStack[++class82.intStackSize - 1] = Client.widgetRoot;
                     var3 = 1;
                  } else {
                     var3 = 2;
                  }

                  return var3;
               } else if(var0 < 2900) {
                  return MouseInput.cs2_2800s(var0, var1, var2);
               } else if(var0 < 3000) {
                  return AbstractSoundSystem.cs2_2000s(var0, var1, var2);
               } else if(var0 < 3200) {
                  return class168.handleCs2_3100(var0, var1, var2);
               } else if(var0 < 3300) {
                  if(var0 == 3200) {
                     class82.intStackSize -= 3;
                     class36.method498(class82.intStack[class82.intStackSize], class82.intStack[class82.intStackSize + 1], class82.intStack[class82.intStackSize + 2]);
                     var3 = 1;
                  } else if(var0 == 3201) {
                     var19 = class82.intStack[--class82.intStackSize];
                     if(var19 == -1 && !Client.field1008) {
                        class282.field3753.method3849();
                        class214.field2620 = 1;
                        class214.field2623 = null;
                     } else if(var19 != -1 && var19 != Client.field850 && Client.field845 != 0 && !Client.field1008) {
                        CollisionData.method3152(2, class29.indexTrack1, var19, 0, Client.field845, false);
                     }

                     Client.field850 = var19;
                     var3 = 1;
                  } else if(var0 == 3202) {
                     class82.intStackSize -= 2;
                     var19 = class82.intStack[class82.intStackSize];
                     var18 = class82.intStack[class82.intStackSize + 1];
                     if(Client.field845 != 0 && var19 != -1) {
                        class2.method3(class20.indexTrack2, var19, 0, Client.field845, false);
                        Client.field1008 = true;
                     }

                     var3 = 1;
                  } else {
                     var3 = 2;
                  }

                  return var3;
               } else if(var0 < 3400) {
                  return ScriptVarType.cs2_3300s(var0, var1, var2);
               } else {
                  int var9;
                  if(var0 < 3500) {
                     if(var0 == 3400) {
                        class82.intStackSize -= 2;
                        var19 = class82.intStack[class82.intStackSize];
                        var18 = class82.intStack[class82.intStackSize + 1];
                        Enum var65 = GrandExchangeEvents.enumForId(var19);
                        if(var65.valType != 's') {
                           ;
                        }

                        for(var49 = 0; var49 < var65.size; ++var49) {
                           if(var18 == var65.keys[var49]) {
                              class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var65.stringVals[var49];
                              var65 = null;
                              break;
                           }
                        }

                        if(var65 != null) {
                           class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var65.defaultString;
                        }

                        var3 = 1;
                     } else if(var0 == 3408) {
                        class82.intStackSize -= 4;
                        var19 = class82.intStack[class82.intStackSize];
                        var18 = class82.intStack[class82.intStackSize + 1];
                        var6 = class82.intStack[class82.intStackSize + 2];
                        var49 = class82.intStack[class82.intStackSize + 3];
                        Enum var62 = GrandExchangeEvents.enumForId(var6);
                        if(var19 == var62.keyType && var18 == var62.valType) {
                           for(var9 = 0; var9 < var62.size; ++var9) {
                              if(var49 == var62.keys[var9]) {
                                 if(var18 == 115) {
                                    class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var62.stringVals[var9];
                                 } else {
                                    class82.intStack[++class82.intStackSize - 1] = var62.intVals[var9];
                                 }

                                 var62 = null;
                                 break;
                              }
                           }

                           if(var62 != null) {
                              if(var18 == 115) {
                                 class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var62.defaultString;
                              } else {
                                 class82.intStack[++class82.intStackSize - 1] = var62.defaultInt;
                              }
                           }

                           var3 = 1;
                        } else {
                           if(var18 == 115) {
                              class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "null";
                           } else {
                              class82.intStack[++class82.intStackSize - 1] = 0;
                           }

                           var3 = 1;
                        }
                     } else {
                        var3 = 2;
                     }

                     return var3;
                  } else if(var0 < 3700) {
                     return class37.cs2_3600s(var0, var1, var2);
                  } else if(var0 < 4000) {
                     return class168.cs2_3900s(var0, var1, var2);
                  } else if(var0 < 4100) {
                     if(var0 == 4000) {
                        class82.intStackSize -= 2;
                        var19 = class82.intStack[class82.intStackSize];
                        var18 = class82.intStack[class82.intStackSize + 1];
                        class82.intStack[++class82.intStackSize - 1] = var18 + var19;
                        var3 = 1;
                     } else if(var0 == 4001) {
                        class82.intStackSize -= 2;
                        var19 = class82.intStack[class82.intStackSize];
                        var18 = class82.intStack[class82.intStackSize + 1];
                        class82.intStack[++class82.intStackSize - 1] = var19 - var18;
                        var3 = 1;
                     } else if(var0 == 4002) {
                        class82.intStackSize -= 2;
                        var19 = class82.intStack[class82.intStackSize];
                        var18 = class82.intStack[class82.intStackSize + 1];
                        class82.intStack[++class82.intStackSize - 1] = var19 * var18;
                        var3 = 1;
                     } else if(var0 == 4003) {
                        class82.intStackSize -= 2;
                        var19 = class82.intStack[class82.intStackSize];
                        var18 = class82.intStack[class82.intStackSize + 1];
                        class82.intStack[++class82.intStackSize - 1] = var19 / var18;
                        var3 = 1;
                     } else if(var0 == 4004) {
                        var19 = class82.intStack[--class82.intStackSize];
                        class82.intStack[++class82.intStackSize - 1] = (int)(Math.random() * (double)var19);
                        var3 = 1;
                     } else if(var0 == 4005) {
                        var19 = class82.intStack[--class82.intStackSize];
                        class82.intStack[++class82.intStackSize - 1] = (int)(Math.random() * (double)(var19 + 1));
                        var3 = 1;
                     } else if(var0 == 4006) {
                        class82.intStackSize -= 5;
                        var19 = class82.intStack[class82.intStackSize];
                        var18 = class82.intStack[class82.intStackSize + 1];
                        var6 = class82.intStack[class82.intStackSize + 2];
                        var49 = class82.intStack[class82.intStackSize + 3];
                        var45 = class82.intStack[class82.intStackSize + 4];
                        class82.intStack[++class82.intStackSize - 1] = var19 + (var45 - var6) * (var18 - var19) / (var49 - var6);
                        var3 = 1;
                     } else if(var0 == 4007) {
                        class82.intStackSize -= 2;
                        var19 = class82.intStack[class82.intStackSize];
                        var18 = class82.intStack[class82.intStackSize + 1];
                        class82.intStack[++class82.intStackSize - 1] = var19 + var18 * var19 / 100;
                        var3 = 1;
                     } else if(var0 == 4008) {
                        class82.intStackSize -= 2;
                        var19 = class82.intStack[class82.intStackSize];
                        var18 = class82.intStack[class82.intStackSize + 1];
                        class82.intStack[++class82.intStackSize - 1] = var19 | 1 << var18;
                        var3 = 1;
                     } else if(var0 == 4009) {
                        class82.intStackSize -= 2;
                        var19 = class82.intStack[class82.intStackSize];
                        var18 = class82.intStack[class82.intStackSize + 1];
                        class82.intStack[++class82.intStackSize - 1] = var19 & -1 - (1 << var18);
                        var3 = 1;
                     } else if(var0 == 4010) {
                        class82.intStackSize -= 2;
                        var19 = class82.intStack[class82.intStackSize];
                        var18 = class82.intStack[class82.intStackSize + 1];
                        class82.intStack[++class82.intStackSize - 1] = (var19 & 1 << var18) != 0?1:0;
                        var3 = 1;
                     } else if(var0 == 4011) {
                        class82.intStackSize -= 2;
                        var19 = class82.intStack[class82.intStackSize];
                        var18 = class82.intStack[class82.intStackSize + 1];
                        class82.intStack[++class82.intStackSize - 1] = var19 % var18;
                        var3 = 1;
                     } else if(var0 == 4012) {
                        class82.intStackSize -= 2;
                        var19 = class82.intStack[class82.intStackSize];
                        var18 = class82.intStack[class82.intStackSize + 1];
                        if(var19 == 0) {
                           class82.intStack[++class82.intStackSize - 1] = 0;
                        } else {
                           class82.intStack[++class82.intStackSize - 1] = (int)Math.pow((double)var19, (double)var18);
                        }

                        var3 = 1;
                     } else if(var0 == 4013) {
                        class82.intStackSize -= 2;
                        var19 = class82.intStack[class82.intStackSize];
                        var18 = class82.intStack[class82.intStackSize + 1];
                        if(var19 == 0) {
                           class82.intStack[++class82.intStackSize - 1] = 0;
                           var3 = 1;
                        } else {
                           switch(var18) {
                           case 0:
                              class82.intStack[++class82.intStackSize - 1] = Integer.MAX_VALUE;
                              break;
                           case 1:
                              class82.intStack[++class82.intStackSize - 1] = var19;
                              break;
                           case 2:
                              class82.intStack[++class82.intStackSize - 1] = (int)Math.sqrt((double)var19);
                              break;
                           case 3:
                              class82.intStack[++class82.intStackSize - 1] = (int)Math.cbrt((double)var19);
                              break;
                           case 4:
                              class82.intStack[++class82.intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)var19));
                              break;
                           default:
                              class82.intStack[++class82.intStackSize - 1] = (int)Math.pow((double)var19, 1.0D / (double)var18);
                           }

                           var3 = 1;
                        }
                     } else if(var0 == 4014) {
                        class82.intStackSize -= 2;
                        var19 = class82.intStack[class82.intStackSize];
                        var18 = class82.intStack[class82.intStackSize + 1];
                        class82.intStack[++class82.intStackSize - 1] = var19 & var18;
                        var3 = 1;
                     } else if(var0 == 4015) {
                        class82.intStackSize -= 2;
                        var19 = class82.intStack[class82.intStackSize];
                        var18 = class82.intStack[class82.intStackSize + 1];
                        class82.intStack[++class82.intStackSize - 1] = var19 | var18;
                        var3 = 1;
                     } else if(var0 == 4018) {
                        class82.intStackSize -= 3;
                        long var29 = (long)class82.intStack[class82.intStackSize];
                        long var31 = (long)class82.intStack[class82.intStackSize + 1];
                        long var33 = (long)class82.intStack[class82.intStackSize + 2];
                        class82.intStack[++class82.intStackSize - 1] = (int)(var29 * var33 / var31);
                        var3 = 1;
                     } else {
                        var3 = 2;
                     }

                     return var3;
                  } else {
                     int var11;
                     int var12;
                     int var13;
                     int var16;
                     String var38;
                     String var39;
                     if(var0 < 4200) {
                        if(var0 == 4100) {
                           var38 = class82.scriptStringStack[--class35.scriptStringStackSize];
                           var18 = class82.intStack[--class82.intStackSize];
                           class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var38 + var18;
                           var3 = 1;
                        } else if(var0 == 4101) {
                           class35.scriptStringStackSize -= 2;
                           var38 = class82.scriptStringStack[class35.scriptStringStackSize];
                           var39 = class82.scriptStringStack[class35.scriptStringStackSize + 1];
                           class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var38 + var39;
                           var3 = 1;
                        } else if(var0 == 4102) {
                           var38 = class82.scriptStringStack[--class35.scriptStringStackSize];
                           var18 = class82.intStack[--class82.intStackSize];
                           String[] var64 = class82.scriptStringStack;
                           var49 = ++class35.scriptStringStackSize - 1;
                           String var63;
                           if(var18 < 0) {
                              var63 = Integer.toString(var18);
                           } else {
                              var11 = var18;
                              String var10;
                              if(var18 < 0) {
                                 var10 = Integer.toString(var18, 10);
                              } else {
                                 var12 = 2;

                                 for(var13 = var18 / 10; var13 != 0; ++var12) {
                                    var13 /= 10;
                                 }

                                 char[] var14 = new char[var12];
                                 var14[0] = '+';

                                 for(int var15 = var12 - 1; var15 > 0; --var15) {
                                    var16 = var11;
                                    var11 /= 10;
                                    int var50 = var16 - var11 * 10;
                                    if(var50 >= 10) {
                                       var14[var15] = (char)(var50 + 87);
                                    } else {
                                       var14[var15] = (char)(var50 + 48);
                                    }
                                 }

                                 var10 = new String(var14);
                              }

                              var63 = var10;
                           }

                           var64[var49] = var38 + var63;
                           var3 = 1;
                        } else if(var0 == 4103) {
                           var38 = class82.scriptStringStack[--class35.scriptStringStackSize];
                           class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var38.toLowerCase();
                           var3 = 1;
                        } else if(var0 == 4104) {
                           var19 = class82.intStack[--class82.intStackSize];
                           long var36 = ((long)var19 + 11745L) * 86400000L;
                           class82.calendar.setTime(new Date(var36));
                           var49 = class82.calendar.get(5);
                           var45 = class82.calendar.get(2);
                           var9 = class82.calendar.get(1);
                           class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var49 + "-" + class82.months[var45] + "-" + var9;
                           var3 = 1;
                        } else if(var0 == 4105) {
                           class35.scriptStringStackSize -= 2;
                           var38 = class82.scriptStringStack[class35.scriptStringStackSize];
                           var39 = class82.scriptStringStack[class35.scriptStringStackSize + 1];
                           if(UrlRequest.localPlayer.composition != null && UrlRequest.localPlayer.composition.isFemale) {
                              class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var39;
                           } else {
                              class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var38;
                           }

                           var3 = 1;
                        } else if(var0 == 4106) {
                           var19 = class82.intStack[--class82.intStackSize];
                           class82.scriptStringStack[++class35.scriptStringStackSize - 1] = Integer.toString(var19);
                           var3 = 1;
                        } else if(var0 == 4107) {
                           class35.scriptStringStackSize -= 2;
                           class82.intStack[++class82.intStackSize - 1] = class276.method4981(TextureProvider.method2406(class82.scriptStringStack[class35.scriptStringStackSize], class82.scriptStringStack[class35.scriptStringStackSize + 1], Client.languageId));
                           var3 = 1;
                        } else {
                           Font var59;
                           byte[] var67;
                           if(var0 == 4108) {
                              var38 = class82.scriptStringStack[--class35.scriptStringStackSize];
                              class82.intStackSize -= 2;
                              var18 = class82.intStack[class82.intStackSize];
                              var6 = class82.intStack[class82.intStackSize + 1];
                              var67 = Preferences.indexCache13.getConfigData(var6, 0);
                              var59 = new Font(var67);
                              class82.intStack[++class82.intStackSize - 1] = var59.method4889(var38, var18);
                              var3 = 1;
                           } else if(var0 == 4109) {
                              var38 = class82.scriptStringStack[--class35.scriptStringStackSize];
                              class82.intStackSize -= 2;
                              var18 = class82.intStack[class82.intStackSize];
                              var6 = class82.intStack[class82.intStackSize + 1];
                              var67 = Preferences.indexCache13.getConfigData(var6, 0);
                              var59 = new Font(var67);
                              class82.intStack[++class82.intStackSize - 1] = var59.method4888(var38, var18);
                              var3 = 1;
                           } else if(var0 == 4110) {
                              class35.scriptStringStackSize -= 2;
                              var38 = class82.scriptStringStack[class35.scriptStringStackSize];
                              var39 = class82.scriptStringStack[class35.scriptStringStackSize + 1];
                              if(class82.intStack[--class82.intStackSize] == 1) {
                                 class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var38;
                              } else {
                                 class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var39;
                              }

                              var3 = 1;
                           } else if(var0 == 4111) {
                              var38 = class82.scriptStringStack[--class35.scriptStringStackSize];
                              class82.scriptStringStack[++class35.scriptStringStackSize - 1] = FontTypeFace.appendTags(var38);
                              var3 = 1;
                           } else if(var0 == 4112) {
                              var38 = class82.scriptStringStack[--class35.scriptStringStackSize];
                              var18 = class82.intStack[--class82.intStackSize];
                              class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var38 + (char)var18;
                              var3 = 1;
                           } else if(var0 == 4113) {
                              var19 = class82.intStack[--class82.intStackSize];
                              class82.intStack[++class82.intStackSize - 1] = SoundTaskDataProvider.method753((char)var19)?1:0;
                              var3 = 1;
                           } else if(var0 == 4114) {
                              var19 = class82.intStack[--class82.intStackSize];
                              class82.intStack[++class82.intStackSize - 1] = UrlRequest.method2926((char)var19)?1:0;
                              var3 = 1;
                           } else if(var0 == 4115) {
                              var19 = class82.intStack[--class82.intStackSize];
                              class82.intStack[++class82.intStackSize - 1] = ObjectComposition.method4664((char)var19)?1:0;
                              var3 = 1;
                           } else {
                              char var46;
                              if(var0 == 4116) {
                                 var19 = class82.intStack[--class82.intStackSize];
                                 var40 = class82.intStack;
                                 var6 = ++class82.intStackSize - 1;
                                 var46 = (char)var19;
                                 boolean var51 = var46 >= '0' && var46 <= '9';
                                 var40[var6] = var51?1:0;
                                 var3 = 1;
                              } else if(var0 == 4117) {
                                 var38 = class82.scriptStringStack[--class35.scriptStringStackSize];
                                 if(var38 != null) {
                                    class82.intStack[++class82.intStackSize - 1] = var38.length();
                                 } else {
                                    class82.intStack[++class82.intStackSize - 1] = 0;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4118) {
                                 var38 = class82.scriptStringStack[--class35.scriptStringStackSize];
                                 class82.intStackSize -= 2;
                                 var18 = class82.intStack[class82.intStackSize];
                                 var6 = class82.intStack[class82.intStackSize + 1];
                                 class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var38.substring(var18, var6);
                                 var3 = 1;
                              } else if(var0 == 4119) {
                                 var38 = class82.scriptStringStack[--class35.scriptStringStackSize];
                                 StringBuilder var47 = new StringBuilder(var38.length());
                                 boolean var42 = false;

                                 for(var49 = 0; var49 < var38.length(); ++var49) {
                                    var46 = var38.charAt(var49);
                                    if(var46 == '<') {
                                       var42 = true;
                                    } else if(var46 == '>') {
                                       var42 = false;
                                    } else if(!var42) {
                                       var47.append(var46);
                                    }
                                 }

                                 class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var47.toString();
                                 var3 = 1;
                              } else if(var0 == 4120) {
                                 var38 = class82.scriptStringStack[--class35.scriptStringStackSize];
                                 var18 = class82.intStack[--class82.intStackSize];
                                 class82.intStack[++class82.intStackSize - 1] = var38.indexOf(var18);
                                 var3 = 1;
                              } else if(var0 == 4121) {
                                 class35.scriptStringStackSize -= 2;
                                 var38 = class82.scriptStringStack[class35.scriptStringStackSize];
                                 var39 = class82.scriptStringStack[class35.scriptStringStackSize + 1];
                                 var6 = class82.intStack[--class82.intStackSize];
                                 class82.intStack[++class82.intStackSize - 1] = var38.indexOf(var39, var6);
                                 var3 = 1;
                              } else {
                                 var3 = 2;
                              }
                           }
                        }

                        return var3;
                     } else if(var0 < 4300) {
                        return WallObject.method2882(var0, var1, var2);
                     } else if(var0 >= 5100) {
                        if(var0 < 5400) {
                           return CacheFile.method2352(var0, var1, var2);
                        } else if(var0 < 5600) {
                           return class260.method4554(var0, var1, var2);
                        } else if(var0 < 5700) {
                           return NamedRecord.method549(var0, var1, var2);
                        } else if(var0 < 6300) {
                           if(var0 == 6200) {
                              class82.intStackSize -= 2;
                              Client.field1080 = (short)class82.intStack[class82.intStackSize];
                              if(Client.field1080 <= 0) {
                                 Client.field1080 = 256;
                              }

                              Client.field1081 = (short)class82.intStack[class82.intStackSize + 1];
                              if(Client.field1081 <= 0) {
                                 Client.field1081 = 205;
                              }

                              var3 = 1;
                           } else if(var0 == 6201) {
                              class82.intStackSize -= 2;
                              Client.field878 = (short)class82.intStack[class82.intStackSize];
                              if(Client.field878 <= 0) {
                                 Client.field878 = 256;
                              }

                              Client.field1083 = (short)class82.intStack[class82.intStackSize + 1];
                              if(Client.field1083 <= 0) {
                                 Client.field1083 = 320;
                              }

                              var3 = 1;
                           } else if(var0 == 6202) {
                              class82.intStackSize -= 4;
                              Client.field1084 = (short)class82.intStack[class82.intStackSize];
                              if(Client.field1084 <= 0) {
                                 Client.field1084 = 1;
                              }

                              Client.field867 = (short)class82.intStack[class82.intStackSize + 1];
                              if(Client.field867 <= 0) {
                                 Client.field867 = 32767;
                              } else if(Client.field867 < Client.field1084) {
                                 Client.field867 = Client.field1084;
                              }

                              Client.field1086 = (short)class82.intStack[class82.intStackSize + 2];
                              if(Client.field1086 <= 0) {
                                 Client.field1086 = 1;
                              }

                              Client.field1006 = (short)class82.intStack[class82.intStackSize + 3];
                              if(Client.field1006 <= 0) {
                                 Client.field1006 = 32767;
                              } else if(Client.field1006 < Client.field1086) {
                                 Client.field1006 = Client.field1086;
                              }

                              var3 = 1;
                           } else if(var0 == 6203) {
                              if(Client.field1000 != null) {
                                 BoundingBox3D.method47(0, 0, Client.field1000.width, Client.field1000.height, false);
                                 class82.intStack[++class82.intStackSize - 1] = Client.viewportHeight;
                                 class82.intStack[++class82.intStackSize - 1] = Client.viewportWidth;
                              } else {
                                 class82.intStack[++class82.intStackSize - 1] = -1;
                                 class82.intStack[++class82.intStackSize - 1] = -1;
                              }

                              var3 = 1;
                           } else if(var0 == 6204) {
                              class82.intStack[++class82.intStackSize - 1] = Client.field878;
                              class82.intStack[++class82.intStackSize - 1] = Client.field1083;
                              var3 = 1;
                           } else if(var0 == 6205) {
                              class82.intStack[++class82.intStackSize - 1] = Client.field1080;
                              class82.intStack[++class82.intStackSize - 1] = Client.field1081;
                              var3 = 1;
                           } else {
                              var3 = 2;
                           }

                           return var3;
                        } else if(var0 < 6600) {
                           return GameObjectTransformMetadata.method1551(var0, var1, var2);
                        } else if(var0 < 6700) {
                           if(var0 == 6600) {
                              var19 = BoundingBox2D.plane;
                              var18 = (UrlRequest.localPlayer.x >> 7) + SceneChunkMetadata.baseX;
                              var6 = (UrlRequest.localPlayer.y >> 7) + Client.baseY;
                              class86.method1655().method5349(var19, var18, var6, true);
                              var3 = 1;
                           } else {
                              WorldMapData var56;
                              if(var0 == 6601) {
                                 var19 = class82.intStack[--class82.intStackSize];
                                 var39 = "";
                                 var56 = class86.method1655().method5365(var19);
                                 if(var56 != null) {
                                    var39 = var56.method279();
                                 }

                                 class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var39;
                                 var3 = 1;
                              } else if(var0 == 6602) {
                                 var19 = class82.intStack[--class82.intStackSize];
                                 class86.method1655().method5350(var19);
                                 var3 = 1;
                              } else if(var0 == 6603) {
                                 class82.intStack[++class82.intStackSize - 1] = class86.method1655().method5362();
                                 var3 = 1;
                              } else if(var0 == 6604) {
                                 var19 = class82.intStack[--class82.intStackSize];
                                 class86.method1655().method5359(var19);
                                 var3 = 1;
                              } else if(var0 == 6605) {
                                 class82.intStack[++class82.intStackSize - 1] = class86.method1655().method5364()?1:0;
                                 var3 = 1;
                              } else {
                                 Coordinates var52;
                                 if(var0 == 6606) {
                                    var52 = new Coordinates(class82.intStack[--class82.intStackSize]);
                                    class86.method1655().method5366(var52.worldX, var52.worldY);
                                    var3 = 1;
                                 } else if(var0 == 6607) {
                                    var52 = new Coordinates(class82.intStack[--class82.intStackSize]);
                                    class86.method1655().method5367(var52.worldX, var52.worldY);
                                    var3 = 1;
                                 } else if(var0 == 6608) {
                                    var52 = new Coordinates(class82.intStack[--class82.intStackSize]);
                                    class86.method1655().method5368(var52.plane, var52.worldX, var52.worldY);
                                    var3 = 1;
                                 } else if(var0 == 6609) {
                                    var52 = new Coordinates(class82.intStack[--class82.intStackSize]);
                                    class86.method1655().method5369(var52.plane, var52.worldX, var52.worldY);
                                    var3 = 1;
                                 } else if(var0 == 6610) {
                                    class82.intStack[++class82.intStackSize - 1] = class86.method1655().method5370();
                                    class82.intStack[++class82.intStackSize - 1] = class86.method1655().method5371();
                                    var3 = 1;
                                 } else {
                                    WorldMapData var41;
                                    if(var0 == 6611) {
                                       var19 = class82.intStack[--class82.intStackSize];
                                       var41 = class86.method1655().method5365(var19);
                                       if(var41 == null) {
                                          class82.intStack[++class82.intStackSize - 1] = 0;
                                       } else {
                                          class82.intStack[++class82.intStackSize - 1] = var41.method291().hash30();
                                       }

                                       var3 = 1;
                                    } else if(var0 == 6612) {
                                       var19 = class82.intStack[--class82.intStackSize];
                                       var41 = class86.method1655().method5365(var19);
                                       if(var41 == null) {
                                          class82.intStack[++class82.intStackSize - 1] = 0;
                                          class82.intStack[++class82.intStackSize - 1] = 0;
                                       } else {
                                          class82.intStack[++class82.intStackSize - 1] = (var41.method285() - var41.method340() + 1) * 64;
                                          class82.intStack[++class82.intStackSize - 1] = (var41.method287() - var41.method286() + 1) * 64;
                                       }

                                       var3 = 1;
                                    } else if(var0 == 6613) {
                                       var19 = class82.intStack[--class82.intStackSize];
                                       var41 = class86.method1655().method5365(var19);
                                       if(var41 == null) {
                                          class82.intStack[++class82.intStackSize - 1] = 0;
                                          class82.intStack[++class82.intStackSize - 1] = 0;
                                          class82.intStack[++class82.intStackSize - 1] = 0;
                                          class82.intStack[++class82.intStackSize - 1] = 0;
                                       } else {
                                          class82.intStack[++class82.intStackSize - 1] = var41.method340() * 64;
                                          class82.intStack[++class82.intStackSize - 1] = var41.method286() * 64;
                                          class82.intStack[++class82.intStackSize - 1] = var41.method285() * 64 + 64 - 1;
                                          class82.intStack[++class82.intStackSize - 1] = var41.method287() * 64 + 64 - 1;
                                       }

                                       var3 = 1;
                                    } else if(var0 == 6614) {
                                       var19 = class82.intStack[--class82.intStackSize];
                                       var41 = class86.method1655().method5365(var19);
                                       if(var41 == null) {
                                          class82.intStack[++class82.intStackSize - 1] = -1;
                                       } else {
                                          class82.intStack[++class82.intStackSize - 1] = var41.method283();
                                       }

                                       var3 = 1;
                                    } else if(var0 == 6615) {
                                       var52 = class86.method1655().method5431();
                                       if(var52 == null) {
                                          class82.intStack[++class82.intStackSize - 1] = -1;
                                          class82.intStack[++class82.intStackSize - 1] = -1;
                                       } else {
                                          class82.intStack[++class82.intStackSize - 1] = var52.worldX;
                                          class82.intStack[++class82.intStackSize - 1] = var52.worldY;
                                       }

                                       var3 = 1;
                                    } else if(var0 == 6616) {
                                       class82.intStack[++class82.intStackSize - 1] = class86.method1655().method5351();
                                       var3 = 1;
                                    } else if(var0 == 6617) {
                                       var52 = new Coordinates(class82.intStack[--class82.intStackSize]);
                                       var41 = class86.method1655().method5520();
                                       if(var41 == null) {
                                          class82.intStack[++class82.intStackSize - 1] = -1;
                                          class82.intStack[++class82.intStackSize - 1] = -1;
                                          var3 = 1;
                                       } else {
                                          int[] var60 = var41.method275(var52.plane, var52.worldX, var52.worldY);
                                          if(var60 == null) {
                                             class82.intStack[++class82.intStackSize - 1] = -1;
                                             class82.intStack[++class82.intStackSize - 1] = -1;
                                          } else {
                                             class82.intStack[++class82.intStackSize - 1] = var60[0];
                                             class82.intStack[++class82.intStackSize - 1] = var60[1];
                                          }

                                          var3 = 1;
                                       }
                                    } else {
                                       Coordinates var61;
                                       if(var0 == 6618) {
                                          var52 = new Coordinates(class82.intStack[--class82.intStackSize]);
                                          var41 = class86.method1655().method5520();
                                          if(var41 == null) {
                                             class82.intStack[++class82.intStackSize - 1] = -1;
                                             class82.intStack[++class82.intStackSize - 1] = -1;
                                             var3 = 1;
                                          } else {
                                             var61 = var41.method289(var52.worldX, var52.worldY);
                                             if(var61 == null) {
                                                class82.intStack[++class82.intStackSize - 1] = -1;
                                             } else {
                                                class82.intStack[++class82.intStackSize - 1] = var61.hash30();
                                             }

                                             var3 = 1;
                                          }
                                       } else {
                                          Coordinates var43;
                                          if(var0 == 6619) {
                                             class82.intStackSize -= 2;
                                             var19 = class82.intStack[class82.intStackSize];
                                             var43 = new Coordinates(class82.intStack[class82.intStackSize + 1]);
                                             Friend.method1036(var19, var43, false);
                                             var3 = 1;
                                          } else if(var0 == 6620) {
                                             class82.intStackSize -= 2;
                                             var19 = class82.intStack[class82.intStackSize];
                                             var43 = new Coordinates(class82.intStack[class82.intStackSize + 1]);
                                             Friend.method1036(var19, var43, true);
                                             var3 = 1;
                                          } else if(var0 == 6621) {
                                             class82.intStackSize -= 2;
                                             var19 = class82.intStack[class82.intStackSize];
                                             var43 = new Coordinates(class82.intStack[class82.intStackSize + 1]);
                                             var56 = class86.method1655().method5365(var19);
                                             if(var56 == null) {
                                                class82.intStack[++class82.intStackSize - 1] = 0;
                                                var3 = 1;
                                             } else {
                                                class82.intStack[++class82.intStackSize - 1] = var56.method273(var43.plane, var43.worldX, var43.worldY)?1:0;
                                                var3 = 1;
                                             }
                                          } else if(var0 == 6622) {
                                             class82.intStack[++class82.intStackSize - 1] = class86.method1655().method5373();
                                             class82.intStack[++class82.intStackSize - 1] = class86.method1655().method5374();
                                             var3 = 1;
                                          } else if(var0 == 6623) {
                                             var52 = new Coordinates(class82.intStack[--class82.intStackSize]);
                                             var41 = class86.method1655().method5348(var52.plane, var52.worldX, var52.worldY);
                                             if(var41 == null) {
                                                class82.intStack[++class82.intStackSize - 1] = -1;
                                             } else {
                                                class82.intStack[++class82.intStackSize - 1] = var41.method282();
                                             }

                                             var3 = 1;
                                          } else if(var0 == 6624) {
                                             class86.method1655().method5478(class82.intStack[--class82.intStackSize]);
                                             var3 = 1;
                                          } else if(var0 == 6625) {
                                             class86.method1655().method5375();
                                             var3 = 1;
                                          } else if(var0 == 6626) {
                                             class86.method1655().method5524(class82.intStack[--class82.intStackSize]);
                                             var3 = 1;
                                          } else if(var0 == 6627) {
                                             class86.method1655().method5357();
                                             var3 = 1;
                                          } else {
                                             boolean var68;
                                             if(var0 == 6628) {
                                                var68 = class82.intStack[--class82.intStackSize] == 1;
                                                class86.method1655().method5379(var68);
                                                var3 = 1;
                                             } else if(var0 == 6629) {
                                                var19 = class82.intStack[--class82.intStackSize];
                                                class86.method1655().method5380(var19);
                                                var3 = 1;
                                             } else if(var0 == 6630) {
                                                var19 = class82.intStack[--class82.intStackSize];
                                                class86.method1655().method5503(var19);
                                                var3 = 1;
                                             } else if(var0 == 6631) {
                                                class86.method1655().method5378();
                                                var3 = 1;
                                             } else if(var0 == 6632) {
                                                var68 = class82.intStack[--class82.intStackSize] == 1;
                                                class86.method1655().method5383(var68);
                                                var3 = 1;
                                             } else {
                                                boolean var53;
                                                if(var0 == 6633) {
                                                   class82.intStackSize -= 2;
                                                   var19 = class82.intStack[class82.intStackSize];
                                                   var53 = class82.intStack[class82.intStackSize + 1] == 1;
                                                   class86.method1655().method5384(var19, var53);
                                                   var3 = 1;
                                                } else if(var0 == 6634) {
                                                   class82.intStackSize -= 2;
                                                   var19 = class82.intStack[class82.intStackSize];
                                                   var53 = class82.intStack[class82.intStackSize + 1] == 1;
                                                   class86.method1655().method5352(var19, var53);
                                                   var3 = 1;
                                                } else if(var0 == 6635) {
                                                   class82.intStack[++class82.intStackSize - 1] = class86.method1655().method5386()?1:0;
                                                   var3 = 1;
                                                } else if(var0 == 6636) {
                                                   var19 = class82.intStack[--class82.intStackSize];
                                                   class82.intStack[++class82.intStackSize - 1] = class86.method1655().method5381(var19)?1:0;
                                                   var3 = 1;
                                                } else if(var0 == 6637) {
                                                   var19 = class82.intStack[--class82.intStackSize];
                                                   class82.intStack[++class82.intStackSize - 1] = class86.method1655().method5388(var19)?1:0;
                                                   var3 = 1;
                                                } else if(var0 == 6638) {
                                                   class82.intStackSize -= 2;
                                                   var19 = class82.intStack[class82.intStackSize];
                                                   var43 = new Coordinates(class82.intStack[class82.intStackSize + 1]);
                                                   var61 = class86.method1655().method5382(var19, var43);
                                                   if(var61 == null) {
                                                      class82.intStack[++class82.intStackSize - 1] = -1;
                                                   } else {
                                                      class82.intStack[++class82.intStackSize - 1] = var61.hash30();
                                                   }

                                                   var3 = 1;
                                                } else {
                                                   AreaMapIconMetadata var58;
                                                   if(var0 == 6639) {
                                                      var58 = class86.method1655().method5393();
                                                      if(var58 == null) {
                                                         class82.intStack[++class82.intStackSize - 1] = -1;
                                                         class82.intStack[++class82.intStackSize - 1] = -1;
                                                      } else {
                                                         class82.intStack[++class82.intStackSize - 1] = var58.field499;
                                                         class82.intStack[++class82.intStackSize - 1] = var58.field498.hash30();
                                                      }

                                                      var3 = 1;
                                                   } else if(var0 == 6640) {
                                                      var58 = class86.method1655().method5394();
                                                      if(var58 == null) {
                                                         class82.intStack[++class82.intStackSize - 1] = -1;
                                                         class82.intStack[++class82.intStackSize - 1] = -1;
                                                      } else {
                                                         class82.intStack[++class82.intStackSize - 1] = var58.field499;
                                                         class82.intStack[++class82.intStackSize - 1] = var58.field498.hash30();
                                                      }

                                                      var3 = 1;
                                                   } else {
                                                      Area var44;
                                                      if(var0 == 6693) {
                                                         var19 = class82.intStack[--class82.intStackSize];
                                                         var44 = Area.mapAreaType[var19];
                                                         if(var44.name == null) {
                                                            class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
                                                         } else {
                                                            class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var44.name;
                                                         }

                                                         var3 = 1;
                                                      } else if(var0 == 6694) {
                                                         var19 = class82.intStack[--class82.intStackSize];
                                                         var44 = Area.mapAreaType[var19];
                                                         class82.intStack[++class82.intStackSize - 1] = var44.field3386;
                                                         var3 = 1;
                                                      } else if(var0 == 6695) {
                                                         var19 = class82.intStack[--class82.intStackSize];
                                                         var44 = Area.mapAreaType[var19];
                                                         if(var44 == null) {
                                                            class82.intStack[++class82.intStackSize - 1] = -1;
                                                         } else {
                                                            class82.intStack[++class82.intStackSize - 1] = var44.field3398;
                                                         }

                                                         var3 = 1;
                                                      } else if(var0 == 6696) {
                                                         var19 = class82.intStack[--class82.intStackSize];
                                                         var44 = Area.mapAreaType[var19];
                                                         if(var44 == null) {
                                                            class82.intStack[++class82.intStackSize - 1] = -1;
                                                         } else {
                                                            class82.intStack[++class82.intStackSize - 1] = var44.spriteId;
                                                         }

                                                         var3 = 1;
                                                      } else if(var0 == 6697) {
                                                         class82.intStack[++class82.intStackSize - 1] = class82.field1238.mapAreaTypeArrayIndex;
                                                         var3 = 1;
                                                      } else if(var0 == 6698) {
                                                         class82.intStack[++class82.intStackSize - 1] = class82.field1238.field565.hash30();
                                                         var3 = 1;
                                                      } else if(var0 == 6699) {
                                                         class82.intStack[++class82.intStackSize - 1] = class82.field1238.field562.hash30();
                                                         var3 = 1;
                                                      } else {
                                                         var3 = 2;
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

                           return var3;
                        } else {
                           return 2;
                        }
                     } else {
                        if(var0 == 5000) {
                           class82.intStack[++class82.intStackSize - 1] = Client.publicChatMode;
                           var3 = 1;
                        } else if(var0 == 5001) {
                           class82.intStackSize -= 3;
                           Client.publicChatMode = class82.intStack[class82.intStackSize];
                           class64.field727 = IndexStoreActionHandler.socialStatusForId(class82.intStack[class82.intStackSize + 1]);
                           if(class64.field727 == null) {
                              class64.field727 = SocialStatus.field3807;
                           }

                           Client.field1087 = class82.intStack[class82.intStackSize + 2];
                           PacketNode var4 = FileSystem.bufferForSize(ClientPacket.field2339, Client.field888.field1449);
                           var4.packetBuffer.putByte(Client.publicChatMode);
                           var4.packetBuffer.putByte(class64.field727.field3809);
                           var4.packetBuffer.putByte(Client.field1087);
                           Client.field888.method1862(var4);
                           var3 = 1;
                        } else if(var0 == 5002) {
                           var38 = class82.scriptStringStack[--class35.scriptStringStackSize];
                           class82.intStackSize -= 2;
                           var18 = class82.intStack[class82.intStackSize];
                           var6 = class82.intStack[class82.intStackSize + 1];
                           PacketNode var23 = FileSystem.bufferForSize(ClientPacket.field2372, Client.field888.field1449);
                           var23.packetBuffer.putByte(Ignore.getLength(var38) + 2);
                           var23.packetBuffer.putString(var38);
                           var23.packetBuffer.putByte(var18 - 1);
                           var23.packetBuffer.putByte(var6);
                           Client.field888.method1862(var23);
                           var3 = 1;
                        } else if(var0 == 5003) {
                           class82.intStackSize -= 2;
                           var19 = class82.intStack[class82.intStackSize];
                           var18 = class82.intStack[class82.intStackSize + 1];
                           ChatLineBuffer var66 = (ChatLineBuffer)class96.chatLineMap.get(Integer.valueOf(var19));
                           MessageNode var20 = var66.getMessage(var18);
                           if(var20 != null) {
                              class82.intStack[++class82.intStackSize - 1] = var20.id;
                              class82.intStack[++class82.intStackSize - 1] = var20.tick;
                              class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var20.name != null?var20.name:"";
                              class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var20.sender != null?var20.sender:"";
                              class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var20.value != null?var20.value:"";
                           } else {
                              class82.intStack[++class82.intStackSize - 1] = -1;
                              class82.intStack[++class82.intStackSize - 1] = 0;
                              class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
                              class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
                              class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
                           }

                           var3 = 1;
                        } else if(var0 == 5004) {
                           var19 = class82.intStack[--class82.intStackSize];
                           MessageNode var5 = class41.method576(var19);
                           if(var5 != null) {
                              class82.intStack[++class82.intStackSize - 1] = var5.type;
                              class82.intStack[++class82.intStackSize - 1] = var5.tick;
                              class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var5.name != null?var5.name:"";
                              class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var5.sender != null?var5.sender:"";
                              class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var5.value != null?var5.value:"";
                           } else {
                              class82.intStack[++class82.intStackSize - 1] = -1;
                              class82.intStack[++class82.intStackSize - 1] = 0;
                              class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
                              class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
                              class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
                           }

                           var3 = 1;
                        } else if(var0 == 5005) {
                           if(class64.field727 == null) {
                              class82.intStack[++class82.intStackSize - 1] = -1;
                           } else {
                              class82.intStack[++class82.intStackSize - 1] = class64.field727.field3809;
                           }

                           var3 = 1;
                        } else if(var0 == 5008) {
                           var38 = class82.scriptStringStack[--class35.scriptStringStackSize];
                           var18 = class82.intStack[--class82.intStackSize];
                           String var54 = var38.toLowerCase();
                           byte var7 = 0;
                           if(var54.startsWith("yellow:")) {
                              var7 = 0;
                              var38 = var38.substring("yellow:".length());
                           } else if(var54.startsWith("red:")) {
                              var7 = 1;
                              var38 = var38.substring("red:".length());
                           } else if(var54.startsWith("green:")) {
                              var7 = 2;
                              var38 = var38.substring("green:".length());
                           } else if(var54.startsWith("cyan:")) {
                              var7 = 3;
                              var38 = var38.substring("cyan:".length());
                           } else if(var54.startsWith("purple:")) {
                              var7 = 4;
                              var38 = var38.substring("purple:".length());
                           } else if(var54.startsWith("white:")) {
                              var7 = 5;
                              var38 = var38.substring("white:".length());
                           } else if(var54.startsWith("flash1:")) {
                              var7 = 6;
                              var38 = var38.substring("flash1:".length());
                           } else if(var54.startsWith("flash2:")) {
                              var7 = 7;
                              var38 = var38.substring("flash2:".length());
                           } else if(var54.startsWith("flash3:")) {
                              var7 = 8;
                              var38 = var38.substring("flash3:".length());
                           } else if(var54.startsWith("glow1:")) {
                              var7 = 9;
                              var38 = var38.substring("glow1:".length());
                           } else if(var54.startsWith("glow2:")) {
                              var7 = 10;
                              var38 = var38.substring("glow2:".length());
                           } else if(var54.startsWith("glow3:")) {
                              var7 = 11;
                              var38 = var38.substring("glow3:".length());
                           } else if(Client.languageId != 0) {
                              if(var54.startsWith("yellow:")) {
                                 var7 = 0;
                                 var38 = var38.substring("yellow:".length());
                              } else if(var54.startsWith("red:")) {
                                 var7 = 1;
                                 var38 = var38.substring("red:".length());
                              } else if(var54.startsWith("green:")) {
                                 var7 = 2;
                                 var38 = var38.substring("green:".length());
                              } else if(var54.startsWith("cyan:")) {
                                 var7 = 3;
                                 var38 = var38.substring("cyan:".length());
                              } else if(var54.startsWith("purple:")) {
                                 var7 = 4;
                                 var38 = var38.substring("purple:".length());
                              } else if(var54.startsWith("white:")) {
                                 var7 = 5;
                                 var38 = var38.substring("white:".length());
                              } else if(var54.startsWith("flash1:")) {
                                 var7 = 6;
                                 var38 = var38.substring("flash1:".length());
                              } else if(var54.startsWith("flash2:")) {
                                 var7 = 7;
                                 var38 = var38.substring("flash2:".length());
                              } else if(var54.startsWith("flash3:")) {
                                 var7 = 8;
                                 var38 = var38.substring("flash3:".length());
                              } else if(var54.startsWith("glow1:")) {
                                 var7 = 9;
                                 var38 = var38.substring("glow1:".length());
                              } else if(var54.startsWith("glow2:")) {
                                 var7 = 10;
                                 var38 = var38.substring("glow2:".length());
                              } else if(var54.startsWith("glow3:")) {
                                 var7 = 11;
                                 var38 = var38.substring("glow3:".length());
                              }
                           }

                           var54 = var38.toLowerCase();
                           byte var8 = 0;
                           if(var54.startsWith("wave:")) {
                              var8 = 1;
                              var38 = var38.substring("wave:".length());
                           } else if(var54.startsWith("wave2:")) {
                              var8 = 2;
                              var38 = var38.substring("wave2:".length());
                           } else if(var54.startsWith("shake:")) {
                              var8 = 3;
                              var38 = var38.substring("shake:".length());
                           } else if(var54.startsWith("scroll:")) {
                              var8 = 4;
                              var38 = var38.substring("scroll:".length());
                           } else if(var54.startsWith("slide:")) {
                              var8 = 5;
                              var38 = var38.substring("slide:".length());
                           } else if(Client.languageId != 0) {
                              if(var54.startsWith("wave:")) {
                                 var8 = 1;
                                 var38 = var38.substring("wave:".length());
                              } else if(var54.startsWith("wave2:")) {
                                 var8 = 2;
                                 var38 = var38.substring("wave2:".length());
                              } else if(var54.startsWith("shake:")) {
                                 var8 = 3;
                                 var38 = var38.substring("shake:".length());
                              } else if(var54.startsWith("scroll:")) {
                                 var8 = 4;
                                 var38 = var38.substring("scroll:".length());
                              } else if(var54.startsWith("slide:")) {
                                 var8 = 5;
                                 var38 = var38.substring("slide:".length());
                              }
                           }

                           PacketNode var22 = FileSystem.bufferForSize(ClientPacket.field2387, Client.field888.field1449);
                           var22.packetBuffer.putByte(0);
                           int var24 = var22.packetBuffer.offset;
                           var22.packetBuffer.putByte(var18);
                           var22.packetBuffer.putByte(var7);
                           var22.packetBuffer.putByte(var8);
                           PacketBuffer var25 = var22.packetBuffer;
                           var12 = var25.offset;
                           int var26 = var38.length();
                           byte[] var27 = new byte[var26];

                           for(var16 = 0; var16 < var26; ++var16) {
                              char var17 = var38.charAt(var16);
                              if((var17 <= 0 || var17 >= 128) && (var17 < 160 || var17 > 255)) {
                                 if(var17 == 8364) {
                                    var27[var16] = -128;
                                 } else if(var17 == 8218) {
                                    var27[var16] = -126;
                                 } else if(var17 == 402) {
                                    var27[var16] = -125;
                                 } else if(var17 == 8222) {
                                    var27[var16] = -124;
                                 } else if(var17 == 8230) {
                                    var27[var16] = -123;
                                 } else if(var17 == 8224) {
                                    var27[var16] = -122;
                                 } else if(var17 == 8225) {
                                    var27[var16] = -121;
                                 } else if(var17 == 710) {
                                    var27[var16] = -120;
                                 } else if(var17 == 8240) {
                                    var27[var16] = -119;
                                 } else if(var17 == 352) {
                                    var27[var16] = -118;
                                 } else if(var17 == 8249) {
                                    var27[var16] = -117;
                                 } else if(var17 == 338) {
                                    var27[var16] = -116;
                                 } else if(var17 == 381) {
                                    var27[var16] = -114;
                                 } else if(var17 == 8216) {
                                    var27[var16] = -111;
                                 } else if(var17 == 8217) {
                                    var27[var16] = -110;
                                 } else if(var17 == 8220) {
                                    var27[var16] = -109;
                                 } else if(var17 == 8221) {
                                    var27[var16] = -108;
                                 } else if(var17 == 8226) {
                                    var27[var16] = -107;
                                 } else if(var17 == 8211) {
                                    var27[var16] = -106;
                                 } else if(var17 == 8212) {
                                    var27[var16] = -105;
                                 } else if(var17 == 732) {
                                    var27[var16] = -104;
                                 } else if(var17 == 8482) {
                                    var27[var16] = -103;
                                 } else if(var17 == 353) {
                                    var27[var16] = -102;
                                 } else if(var17 == 8250) {
                                    var27[var16] = -101;
                                 } else if(var17 == 339) {
                                    var27[var16] = -100;
                                 } else if(var17 == 382) {
                                    var27[var16] = -98;
                                 } else if(var17 == 376) {
                                    var27[var16] = -97;
                                 } else {
                                    var27[var16] = 63;
                                 }
                              } else {
                                 var27[var16] = (byte)var17;
                              }
                           }

                           var25.putShortSmart(var27.length);
                           var25.offset += class276.huffman.compress(var27, 0, var27.length, var25.payload, var25.offset);
                           var22.packetBuffer.method3258(var22.packetBuffer.offset - var24);
                           Client.field888.method1862(var22);
                           var3 = 1;
                        } else if(var0 == 5009) {
                           class35.scriptStringStackSize -= 2;
                           var38 = class82.scriptStringStack[class35.scriptStringStackSize];
                           var39 = class82.scriptStringStack[class35.scriptStringStackSize + 1];
                           PacketNode var55 = FileSystem.bufferForSize(ClientPacket.field2373, Client.field888.field1449);
                           var55.packetBuffer.putShort(0);
                           var49 = var55.packetBuffer.offset;
                           var55.packetBuffer.putString(var38);
                           PacketBuffer var21 = var55.packetBuffer;
                           var9 = var21.offset;
                           var11 = var39.length();
                           byte[] var28 = new byte[var11];

                           for(var13 = 0; var13 < var11; ++var13) {
                              char var69 = var39.charAt(var13);
                              if((var69 <= 0 || var69 >= 128) && (var69 < 160 || var69 > 255)) {
                                 if(var69 == 8364) {
                                    var28[var13] = -128;
                                 } else if(var69 == 8218) {
                                    var28[var13] = -126;
                                 } else if(var69 == 402) {
                                    var28[var13] = -125;
                                 } else if(var69 == 8222) {
                                    var28[var13] = -124;
                                 } else if(var69 == 8230) {
                                    var28[var13] = -123;
                                 } else if(var69 == 8224) {
                                    var28[var13] = -122;
                                 } else if(var69 == 8225) {
                                    var28[var13] = -121;
                                 } else if(var69 == 710) {
                                    var28[var13] = -120;
                                 } else if(var69 == 8240) {
                                    var28[var13] = -119;
                                 } else if(var69 == 352) {
                                    var28[var13] = -118;
                                 } else if(var69 == 8249) {
                                    var28[var13] = -117;
                                 } else if(var69 == 338) {
                                    var28[var13] = -116;
                                 } else if(var69 == 381) {
                                    var28[var13] = -114;
                                 } else if(var69 == 8216) {
                                    var28[var13] = -111;
                                 } else if(var69 == 8217) {
                                    var28[var13] = -110;
                                 } else if(var69 == 8220) {
                                    var28[var13] = -109;
                                 } else if(var69 == 8221) {
                                    var28[var13] = -108;
                                 } else if(var69 == 8226) {
                                    var28[var13] = -107;
                                 } else if(var69 == 8211) {
                                    var28[var13] = -106;
                                 } else if(var69 == 8212) {
                                    var28[var13] = -105;
                                 } else if(var69 == 732) {
                                    var28[var13] = -104;
                                 } else if(var69 == 8482) {
                                    var28[var13] = -103;
                                 } else if(var69 == 353) {
                                    var28[var13] = -102;
                                 } else if(var69 == 8250) {
                                    var28[var13] = -101;
                                 } else if(var69 == 339) {
                                    var28[var13] = -100;
                                 } else if(var69 == 382) {
                                    var28[var13] = -98;
                                 } else if(var69 == 376) {
                                    var28[var13] = -97;
                                 } else {
                                    var28[var13] = 63;
                                 }
                              } else {
                                 var28[var13] = (byte)var69;
                              }
                           }

                           var21.putShortSmart(var28.length);
                           var21.offset += class276.huffman.compress(var28, 0, var28.length, var21.payload, var21.offset);
                           var55.packetBuffer.method3257(var55.packetBuffer.offset - var49);
                           Client.field888.method1862(var55);
                           var3 = 1;
                        } else if(var0 == 5015) {
                           if(UrlRequest.localPlayer != null && UrlRequest.localPlayer.name != null) {
                              var38 = UrlRequest.localPlayer.name;
                           } else {
                              var38 = "";
                           }

                           class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var38;
                           var3 = 1;
                        } else if(var0 == 5016) {
                           class82.intStack[++class82.intStackSize - 1] = Client.field1087;
                           var3 = 1;
                        } else if(var0 == 5017) {
                           var19 = class82.intStack[--class82.intStackSize];
                           class82.intStack[++class82.intStackSize - 1] = BaseVarType.method12(var19);
                           var3 = 1;
                        } else if(var0 == 5018) {
                           var19 = class82.intStack[--class82.intStackSize];
                           var40 = class82.intStack;
                           var6 = ++class82.intStackSize - 1;
                           MessageNode var57 = (MessageNode)class96.messages.get((long)var19);
                           if(var57 == null) {
                              var49 = -1;
                           } else if(var57.previous == class96.field1414.sentinel) {
                              var49 = -1;
                           } else {
                              var49 = ((MessageNode)var57.previous).id;
                           }

                           var40[var6] = var49;
                           var3 = 1;
                        } else if(var0 == 5019) {
                           var19 = class82.intStack[--class82.intStackSize];
                           class82.intStack[++class82.intStackSize - 1] = class115.method2106(var19);
                           var3 = 1;
                        } else if(var0 == 5020) {
                           var38 = class82.scriptStringStack[--class35.scriptStringStackSize];
                           SceneTilePaint.method2683(var38);
                           var3 = 1;
                        } else if(var0 == 5021) {
                           Client.field1046 = class82.scriptStringStack[--class35.scriptStringStackSize].toLowerCase().trim();
                           var3 = 1;
                        } else if(var0 == 5022) {
                           class82.scriptStringStack[++class35.scriptStringStackSize - 1] = Client.field1046;
                           var3 = 1;
                        } else {
                           var3 = 2;
                        }

                        return var3;
                     }
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "46"
   )
   static final void method4077() {
      Client.field947 = 0;
      int var0 = (UrlRequest.localPlayer.x >> 7) + SceneChunkMetadata.baseX;
      int var1 = (UrlRequest.localPlayer.y >> 7) + Client.baseY;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.field947 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.field947 = 1;
      }

      if(Client.field947 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.field947 = 0;
      }

   }
}
