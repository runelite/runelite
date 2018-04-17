import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   @Export("underlay_ref")
   static IndexDataBase underlay_ref;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   @Export("underlays")
   public static NodeCache underlays;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -488989457
   )
   @Export("canvasHeight")
   protected static int canvasHeight;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -48884339
   )
   @Export("rgbColor")
   int rgbColor;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1664436141
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1666135093
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -227046357
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 743291309
   )
   @Export("hueMultiplier")
   public int hueMultiplier;

   static {
      underlays = new NodeCache(64);
   }

   FloorUnderlayDefinition() {
      this.rgbColor = 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "69425575"
   )
   @Export("post")
   void post() {
      this.setHSL(this.rgbColor);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgc;II)V",
      garbageValue = "-2048056271"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.decode(var1, var3, var2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgc;III)V",
      garbageValue = "1513416304"
   )
   @Export("decode")
   void decode(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.rgbColor = var1.read24BitInt();
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1999948540"
   )
   @Export("setHSL")
   void setHSL(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var10 + var8) / 2.0D;
      if(var10 != var8) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var10 == var6) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.saturation = (int)(256.0D * var14);
      this.lightness = (int)(256.0D * var16);
      if(this.saturation < 0) {
         this.saturation = 0;
      } else if(this.saturation > 255) {
         this.saturation = 255;
      }

      if(this.lightness < 0) {
         this.lightness = 0;
      } else if(this.lightness > 255) {
         this.lightness = 255;
      }

      if(var16 > 0.5D) {
         this.hueMultiplier = (int)((1.0D - var16) * var14 * 512.0D);
      } else {
         this.hueMultiplier = (int)(var16 * var14 * 512.0D);
      }

      if(this.hueMultiplier < 1) {
         this.hueMultiplier = 1;
      }

      this.hue = (int)((double)this.hueMultiplier * var12);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lbi;II)V",
      garbageValue = "-1967393375"
   )
   @Export("runScript")
   static void runScript(ScriptEvent var0, int var1) {
      Object[] var2 = var0.objs;
      Script var3;
      int var20;
      if(class279.method4922(var0.field800)) {
         class20.scriptMapIconReference = (MapIconReference)var2[0];
         Area var4 = Area.mapAreaType[class20.scriptMapIconReference.areaId];
         var3 = class178.method3431(var0.field800, var4.id, var4.field3473);
      } else {
         var20 = ((Integer)var2[0]).intValue();
         var3 = WorldMapDecoration.method313(var20);
      }

      if(var3 != null) {
         WorldComparator.intStackSize = 0;
         KeyFocusListener.scriptStringStackSize = 0;
         var20 = -1;
         int[] var5 = var3.instructions;
         int[] var6 = var3.intOperands;
         byte var7 = -1;
         class81.scriptStackCount = 0;

         int var10;
         try {
            class81.scriptLocalInts = new int[var3.localIntCount];
            int var8 = 0;
            class81.scriptLocalStrings = new String[var3.localStringCount];
            int var9 = 0;

            int var11;
            String var21;
            for(var10 = 1; var10 < var2.length; ++var10) {
               if(var2[var10] instanceof Integer) {
                  var11 = ((Integer)var2[var10]).intValue();
                  if(var11 == -2147483647) {
                     var11 = var0.field799;
                  }

                  if(var11 == -2147483646) {
                     var11 = var0.field798;
                  }

                  if(var11 == -2147483645) {
                     var11 = var0.widget != null?var0.widget.id:-1;
                  }

                  if(var11 == -2147483644) {
                     var11 = var0.field801;
                  }

                  if(var11 == -2147483643) {
                     var11 = var0.widget != null?var0.widget.index:-1;
                  }

                  if(var11 == -2147483642) {
                     var11 = var0.field802 != null?var0.field802.id:-1;
                  }

                  if(var11 == -2147483641) {
                     var11 = var0.field802 != null?var0.field802.index:-1;
                  }

                  if(var11 == -2147483640) {
                     var11 = var0.pressedKey;
                  }

                  if(var11 == -2147483639) {
                     var11 = var0.typedKey;
                  }

                  class81.scriptLocalInts[var8++] = var11;
               } else if(var2[var10] instanceof String) {
                  var21 = (String)var2[var10];
                  if(var21.equals("event_opbase")) {
                     var21 = var0.string;
                  }

                  class81.scriptLocalStrings[var9++] = var21;
               }
            }

            var10 = 0;
            class81.field1288 = var0.field806;

            while(true) {
               while(true) {
                  while(true) {
                     while(true) {
                        while(true) {
                           while(true) {
                              while(true) {
                                 while(true) {
                                    while(true) {
                                       while(true) {
                                          while(true) {
                                             while(true) {
                                                while(true) {
                                                   while(true) {
                                                      while(true) {
                                                         while(true) {
                                                            while(true) {
                                                               while(true) {
                                                                  while(true) {
                                                                     while(true) {
                                                                        while(true) {
                                                                           while(true) {
                                                                              while(true) {
                                                                                 while(true) {
                                                                                    while(true) {
                                                                                       label316:
                                                                                       while(true) {
                                                                                          ++var10;
                                                                                          if(var10 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var20;
                                                                                          int var31 = var5[var20];
                                                                                          int var26;
                                                                                          if(var31 < 100) {
                                                                                             if(var31 != 0) {
                                                                                                if(var31 != 1) {
                                                                                                   if(var31 != 2) {
                                                                                                      if(var31 != 3) {
                                                                                                         if(var31 != 6) {
                                                                                                            if(var31 != 7) {
                                                                                                               if(var31 != 8) {
                                                                                                                  if(var31 != 9) {
                                                                                                                     if(var31 != 10) {
                                                                                                                        if(var31 != 21) {
                                                                                                                           if(var31 != 25) {
                                                                                                                              if(var31 != 27) {
                                                                                                                                 if(var31 != 31) {
                                                                                                                                    if(var31 != 32) {
                                                                                                                                       if(var31 != 33) {
                                                                                                                                          if(var31 != 34) {
                                                                                                                                             if(var31 != 35) {
                                                                                                                                                if(var31 != 36) {
                                                                                                                                                   int var22;
                                                                                                                                                   if(var31 != 37) {
                                                                                                                                                      if(var31 != 38) {
                                                                                                                                                         if(var31 != 39) {
                                                                                                                                                            if(var31 != 40) {
                                                                                                                                                               if(var31 != 42) {
                                                                                                                                                                  if(var31 != 43) {
                                                                                                                                                                     if(var31 == 44) {
                                                                                                                                                                        var11 = var6[var20] >> 16;
                                                                                                                                                                        var26 = var6[var20] & 65535;
                                                                                                                                                                        int var27 = class81.intStack[--WorldComparator.intStackSize];
                                                                                                                                                                        if(var27 >= 0 && var27 <= 5000) {
                                                                                                                                                                           class81.field1282[var11] = var27;
                                                                                                                                                                           byte var35 = -1;
                                                                                                                                                                           if(var26 == 105) {
                                                                                                                                                                              var35 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var22 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var22 >= var27) {
                                                                                                                                                                                 continue label316;
                                                                                                                                                                              }

                                                                                                                                                                              class81.SHAPE_VERTICES[var11][var22] = var35;
                                                                                                                                                                              ++var22;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var31 == 45) {
                                                                                                                                                                        var11 = var6[var20];
                                                                                                                                                                        var26 = class81.intStack[--WorldComparator.intStackSize];
                                                                                                                                                                        if(var26 < 0 || var26 >= class81.field1282[var11]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class81.intStack[++WorldComparator.intStackSize - 1] = class81.SHAPE_VERTICES[var11][var26];
                                                                                                                                                                     } else if(var31 == 46) {
                                                                                                                                                                        var11 = var6[var20];
                                                                                                                                                                        WorldComparator.intStackSize -= 2;
                                                                                                                                                                        var26 = class81.intStack[WorldComparator.intStackSize];
                                                                                                                                                                        if(var26 < 0 || var26 >= class81.field1282[var11]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class81.SHAPE_VERTICES[var11][var26] = class81.intStack[WorldComparator.intStackSize + 1];
                                                                                                                                                                     } else if(var31 == 47) {
                                                                                                                                                                        var21 = SceneTilePaint.varcs.getVarcString(var6[var20]);
                                                                                                                                                                        if(var21 == null) {
                                                                                                                                                                           var21 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var21;
                                                                                                                                                                     } else if(var31 == 48) {
                                                                                                                                                                        SceneTilePaint.varcs.putVarcString(var6[var20], class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var31 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        IterableHashTable var39 = var3.switches[var6[var20]];
                                                                                                                                                                        IntegerNode var34 = (IntegerNode)var39.get((long)class81.intStack[--WorldComparator.intStackSize]);
                                                                                                                                                                        if(var34 != null) {
                                                                                                                                                                           var20 += var34.value;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     SceneTilePaint.varcs.putVarc(var6[var20], class81.intStack[--WorldComparator.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class81.intStack[++WorldComparator.intStackSize - 1] = SceneTilePaint.varcs.getVarc(var6[var20]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var11 = var6[var20];
                                                                                                                                                               Script var33 = WorldMapDecoration.method313(var11);
                                                                                                                                                               int[] var32 = new int[var33.localIntCount];
                                                                                                                                                               String[] var25 = new String[var33.localStringCount];

                                                                                                                                                               for(var22 = 0; var22 < var33.intStackCount; ++var22) {
                                                                                                                                                                  var32[var22] = class81.intStack[var22 + (WorldComparator.intStackSize - var33.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var22 = 0; var22 < var33.stringStackCount; ++var22) {
                                                                                                                                                                  var25[var22] = class81.scriptStringStack[var22 + (KeyFocusListener.scriptStringStackSize - var33.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               WorldComparator.intStackSize -= var33.intStackCount;
                                                                                                                                                               KeyFocusListener.scriptStringStackSize -= var33.stringStackCount;
                                                                                                                                                               ScriptState var36 = new ScriptState();
                                                                                                                                                               var36.invokedFromScript = var3;
                                                                                                                                                               var36.invokedFromPc = var20;
                                                                                                                                                               var36.savedLocalInts = class81.scriptLocalInts;
                                                                                                                                                               var36.savedLocalStrings = class81.scriptLocalStrings;
                                                                                                                                                               class81.scriptStack[++class81.scriptStackCount - 1] = var36;
                                                                                                                                                               var3 = var33;
                                                                                                                                                               var5 = var33.instructions;
                                                                                                                                                               var6 = var33.intOperands;
                                                                                                                                                               var20 = -1;
                                                                                                                                                               class81.scriptLocalInts = var32;
                                                                                                                                                               class81.scriptLocalStrings = var25;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --KeyFocusListener.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --WorldComparator.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var11 = var6[var20];
                                                                                                                                                      KeyFocusListener.scriptStringStackSize -= var11;
                                                                                                                                                      String[] var13 = class81.scriptStringStack;
                                                                                                                                                      int var14 = KeyFocusListener.scriptStringStackSize;
                                                                                                                                                      String var12;
                                                                                                                                                      if(var11 == 0) {
                                                                                                                                                         var12 = "";
                                                                                                                                                      } else if(var11 == 1) {
                                                                                                                                                         String var15 = var13[var14];
                                                                                                                                                         if(var15 == null) {
                                                                                                                                                            var12 = "null";
                                                                                                                                                         } else {
                                                                                                                                                            var12 = var15.toString();
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         var22 = var11 + var14;
                                                                                                                                                         int var16 = 0;

                                                                                                                                                         for(int var17 = var14; var17 < var22; ++var17) {
                                                                                                                                                            String var18 = var13[var17];
                                                                                                                                                            if(var18 == null) {
                                                                                                                                                               var16 += 4;
                                                                                                                                                            } else {
                                                                                                                                                               var16 += var18.length();
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         StringBuilder var23 = new StringBuilder(var16);

                                                                                                                                                         for(int var24 = var14; var24 < var22; ++var24) {
                                                                                                                                                            String var19 = var13[var24];
                                                                                                                                                            if(var19 == null) {
                                                                                                                                                               var23.append("null");
                                                                                                                                                            } else {
                                                                                                                                                               var23.append(var19);
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         var12 = var23.toString();
                                                                                                                                                      }

                                                                                                                                                      class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var12;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class81.scriptLocalStrings[var6[var20]] = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = class81.scriptLocalStrings[var6[var20]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class81.scriptLocalInts[var6[var20]] = class81.intStack[--WorldComparator.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class81.intStack[++WorldComparator.intStackSize - 1] = class81.scriptLocalInts[var6[var20]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       WorldComparator.intStackSize -= 2;
                                                                                                                                       if(class81.intStack[WorldComparator.intStackSize] >= class81.intStack[WorldComparator.intStackSize + 1]) {
                                                                                                                                          var20 += var6[var20];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    WorldComparator.intStackSize -= 2;
                                                                                                                                    if(class81.intStack[WorldComparator.intStackSize] <= class81.intStack[WorldComparator.intStackSize + 1]) {
                                                                                                                                       var20 += var6[var20];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var11 = var6[var20];
                                                                                                                                 class315.method5614(var11, class81.intStack[--WorldComparator.intStackSize]);
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var11 = var6[var20];
                                                                                                                              class81.intStack[++WorldComparator.intStackSize - 1] = DynamicObject.getVarbit(var11);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class81.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var38 = class81.scriptStack[--class81.scriptStackCount];
                                                                                                                           var3 = var38.invokedFromScript;
                                                                                                                           var5 = var3.instructions;
                                                                                                                           var6 = var3.intOperands;
                                                                                                                           var20 = var38.invokedFromPc;
                                                                                                                           class81.scriptLocalInts = var38.savedLocalInts;
                                                                                                                           class81.scriptLocalStrings = var38.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        WorldComparator.intStackSize -= 2;
                                                                                                                        if(class81.intStack[WorldComparator.intStackSize] > class81.intStack[WorldComparator.intStackSize + 1]) {
                                                                                                                           var20 += var6[var20];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     WorldComparator.intStackSize -= 2;
                                                                                                                     if(class81.intStack[WorldComparator.intStackSize] < class81.intStack[WorldComparator.intStackSize + 1]) {
                                                                                                                        var20 += var6[var20];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  WorldComparator.intStackSize -= 2;
                                                                                                                  if(class81.intStack[WorldComparator.intStackSize] == class81.intStack[WorldComparator.intStackSize + 1]) {
                                                                                                                     var20 += var6[var20];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               WorldComparator.intStackSize -= 2;
                                                                                                               if(class81.intStack[WorldComparator.intStackSize] != class81.intStack[WorldComparator.intStackSize + 1]) {
                                                                                                                  var20 += var6[var20];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var20 += var6[var20];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3.stringOperands[var20];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var11 = var6[var20];
                                                                                                      class237.clientVarps[var11] = class81.intStack[--WorldComparator.intStackSize];
                                                                                                      class18.method142(var11);
                                                                                                   }
                                                                                                } else {
                                                                                                   var11 = var6[var20];
                                                                                                   class81.intStack[++WorldComparator.intStackSize - 1] = class237.clientVarps[var11];
                                                                                                }
                                                                                             } else {
                                                                                                class81.intStack[++WorldComparator.intStackSize - 1] = var6[var20];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var37;
                                                                                             if(var3.intOperands[var20] == 1) {
                                                                                                var37 = true;
                                                                                             } else {
                                                                                                var37 = false;
                                                                                             }

                                                                                             var26 = class36.method539(var31, var3, var37);
                                                                                             switch(var26) {
                                                                                             case 0:
                                                                                                return;
                                                                                             case 1:
                                                                                             default:
                                                                                                break;
                                                                                             case 2:
                                                                                                throw new IllegalStateException();
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
         } catch (Exception var30) {
            StringBuilder var29 = new StringBuilder(30);
            var29.append("").append(var3.hash).append(" ");

            for(var10 = class81.scriptStackCount - 1; var10 >= 0; --var10) {
               var29.append("").append(class81.scriptStack[var10].invokedFromScript.hash).append(" ");
            }

            var29.append("").append(var7);
            AttackOption.processClientError(var29.toString(), var30);
         }
      }
   }
}
