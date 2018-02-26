import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -150479321
   )
   int field485;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 670751607
   )
   int field480;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1263578847
   )
   int field479;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 82951457
   )
   int field482;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1854662849
   )
   int field483;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1498723449
   )
   int field481;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lai;B)V",
      garbageValue = "59"
   )
   public void vmethod736(WorldMapData var1) {
      if(var1.field419 > this.field483) {
         var1.field419 = this.field483;
      }

      if(var1.field420 < this.field483) {
         var1.field420 = this.field483;
      }

      if(var1.field413 > this.field481) {
         var1.field413 = this.field481;
      }

      if(var1.field422 < this.field481) {
         var1.field422 = this.field481;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "2052357031"
   )
   public boolean vmethod737(int var1, int var2, int var3) {
      return var1 >= this.field485 && var1 < this.field480 + this.field485?var2 >> 6 == this.field479 && var3 >> 6 == this.field482:false;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "1"
   )
   public boolean vmethod745(int var1, int var2) {
      return var1 >> 6 == this.field483 && var2 >> 6 == this.field481;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-1022148607"
   )
   public int[] vmethod738(int var1, int var2, int var3) {
      if(!this.vmethod737(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field483 * 64 - this.field479 * 64 + var2, var3 + (this.field481 * 64 - this.field482 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)Lhp;",
      garbageValue = "-1642348517"
   )
   public Coordinates vmethod739(int var1, int var2) {
      if(!this.vmethod745(var1, var2)) {
         return null;
      } else {
         int var3 = this.field479 * 64 - this.field483 * 64 + var1;
         int var4 = this.field482 * 64 - this.field481 * 64 + var2;
         return new Coordinates(this.field485, var3, var4);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgn;I)V",
      garbageValue = "1338328003"
   )
   public void vmethod741(Buffer var1) {
      this.field485 = var1.readUnsignedByte();
      this.field480 = var1.readUnsignedByte();
      this.field479 = var1.readUnsignedShort();
      this.field482 = var1.readUnsignedShort();
      this.field483 = var1.readUnsignedShort();
      this.field481 = var1.readUnsignedShort();
      this.method528();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "537670178"
   )
   void method528() {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lba;II)V",
      garbageValue = "-1356846054"
   )
   @Export("runScript")
   static void runScript(ScriptEvent var0, int var1) {
      Object[] var2 = var0.objs;
      class239 var5 = var0.field752;
      boolean var4 = var5 == class239.field2915 || var5 == class239.field2916 || var5 == class239.field2918 || var5 == class239.field2924 || var5 == class239.field2919 || var5 == class239.field2920 || var5 == class239.field2921 || var5 == class239.field2922;
      Script var3;
      Script var7;
      int var9;
      int var10;
      int var11;
      int var12;
      int var24;
      if(var4) {
         class299.field3788 = (class47)var2[0];
         Area var6 = class330.mapAreaType[class299.field3788.field556];
         class239 var8 = var0.field752;
         var9 = var6.field3406;
         var10 = var6.field3397;
         var11 = (var9 << 8) + var8.field2917;
         Script var13 = class2.getScriptByFile(var11, var8);
         if(var13 != null) {
            var7 = var13;
         } else {
            var12 = DynamicObject.method2013(var10, var8);
            var13 = class2.getScriptByFile(var12, var8);
            if(var13 != null) {
               var7 = var13;
            } else {
               var7 = null;
            }
         }

         var3 = var7;
      } else {
         var24 = ((Integer)var2[0]).intValue();
         Script var43 = (Script)Script.field1406.get((long)var24);
         if(var43 != null) {
            var7 = var43;
         } else {
            byte[] var25 = class80.indexScripts.getConfigData(var24, 0);
            if(var25 == null) {
               var7 = null;
            } else {
               var43 = IndexStoreActionHandler.newScript(var25);
               Script.field1406.put(var43, (long)var24);
               var7 = var43;
            }
         }

         var3 = var7;
      }

      if(var3 != null) {
         class80.intStackSize = 0;
         class43.scriptStringStackSize = 0;
         var24 = -1;
         int[] var46 = var3.instructions;
         int[] var44 = var3.intOperands;
         byte var45 = -1;
         class80.scriptStackCount = 0;

         try {
            class80.scriptLocalInts = new int[var3.localIntCount];
            var10 = 0;
            class80.scriptLocalStrings = new String[var3.localStringCount];
            var11 = 0;

            int var26;
            String var47;
            for(var12 = 1; var12 < var2.length; ++var12) {
               if(var2[var12] instanceof Integer) {
                  var26 = ((Integer)var2[var12]).intValue();
                  if(var26 == -2147483647) {
                     var26 = var0.field744;
                  }

                  if(var26 == -2147483646) {
                     var26 = var0.field745;
                  }

                  if(var26 == -2147483645) {
                     var26 = var0.widget != null?var0.widget.id:-1;
                  }

                  if(var26 == -2147483644) {
                     var26 = var0.field753;
                  }

                  if(var26 == -2147483643) {
                     var26 = var0.widget != null?var0.widget.index:-1;
                  }

                  if(var26 == -2147483642) {
                     var26 = var0.field747 != null?var0.field747.id:-1;
                  }

                  if(var26 == -2147483641) {
                     var26 = var0.field747 != null?var0.field747.index:-1;
                  }

                  if(var26 == -2147483640) {
                     var26 = var0.field754;
                  }

                  if(var26 == -2147483639) {
                     var26 = var0.field749;
                  }

                  class80.scriptLocalInts[var10++] = var26;
               } else if(var2[var12] instanceof String) {
                  var47 = (String)var2[var12];
                  if(var47.equals("event_opbase")) {
                     var47 = var0.string;
                  }

                  class80.scriptLocalStrings[var11++] = var47;
               }
            }

            var12 = 0;
            class80.field1231 = var0.field751;

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
                                                                                       label1045:
                                                                                       while(true) {
                                                                                          ++var12;
                                                                                          if(var12 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var24;
                                                                                          var9 = var46[var24];
                                                                                          int var16;
                                                                                          int var18;
                                                                                          int var19;
                                                                                          int var27;
                                                                                          int var29;
                                                                                          int var32;
                                                                                          if(var9 < 100) {
                                                                                             if(var9 != 0) {
                                                                                                if(var9 != 1) {
                                                                                                   if(var9 != 2) {
                                                                                                      if(var9 != 3) {
                                                                                                         if(var9 != 6) {
                                                                                                            if(var9 != 7) {
                                                                                                               if(var9 != 8) {
                                                                                                                  if(var9 != 9) {
                                                                                                                     if(var9 != 10) {
                                                                                                                        if(var9 != 21) {
                                                                                                                           if(var9 != 25) {
                                                                                                                              if(var9 != 27) {
                                                                                                                                 if(var9 != 31) {
                                                                                                                                    if(var9 != 32) {
                                                                                                                                       if(var9 != 33) {
                                                                                                                                          if(var9 != 34) {
                                                                                                                                             if(var9 != 35) {
                                                                                                                                                if(var9 != 36) {
                                                                                                                                                   if(var9 != 37) {
                                                                                                                                                      if(var9 != 38) {
                                                                                                                                                         if(var9 != 39) {
                                                                                                                                                            if(var9 != 40) {
                                                                                                                                                               if(var9 != 42) {
                                                                                                                                                                  if(var9 != 43) {
                                                                                                                                                                     if(var9 == 44) {
                                                                                                                                                                        var26 = var44[var24] >> 16;
                                                                                                                                                                        var32 = var44[var24] & 65535;
                                                                                                                                                                        int var67 = class80.intStack[--class80.intStackSize];
                                                                                                                                                                        if(var67 >= 0 && var67 <= 5000) {
                                                                                                                                                                           class80.field1221[var26] = var67;
                                                                                                                                                                           byte var57 = -1;
                                                                                                                                                                           if(var32 == 105) {
                                                                                                                                                                              var57 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var27 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var27 >= var67) {
                                                                                                                                                                                 continue label1045;
                                                                                                                                                                              }

                                                                                                                                                                              class80.SHAPE_VERTICES[var26][var27] = var57;
                                                                                                                                                                              ++var27;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var9 == 45) {
                                                                                                                                                                        var26 = var44[var24];
                                                                                                                                                                        var32 = class80.intStack[--class80.intStackSize];
                                                                                                                                                                        if(var32 < 0 || var32 >= class80.field1221[var26]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class80.intStack[++class80.intStackSize - 1] = class80.SHAPE_VERTICES[var26][var32];
                                                                                                                                                                     } else if(var9 == 46) {
                                                                                                                                                                        var26 = var44[var24];
                                                                                                                                                                        class80.intStackSize -= 2;
                                                                                                                                                                        var32 = class80.intStack[class80.intStackSize];
                                                                                                                                                                        if(var32 < 0 || var32 >= class80.field1221[var26]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class80.SHAPE_VERTICES[var26][var32] = class80.intStack[class80.intStackSize + 1];
                                                                                                                                                                     } else if(var9 == 47) {
                                                                                                                                                                        var47 = class60.chatMessages.getVarcString(var44[var24]);
                                                                                                                                                                        if(var47 == null) {
                                                                                                                                                                           var47 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var47;
                                                                                                                                                                     } else if(var9 == 48) {
                                                                                                                                                                        class60.chatMessages.putVarcString(var44[var24], class80.scriptStringStack[--class43.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var9 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        IterableHashTable var51 = var3.switches[var44[var24]];
                                                                                                                                                                        IntegerNode var52 = (IntegerNode)var51.get((long)class80.intStack[--class80.intStackSize]);
                                                                                                                                                                        if(var52 != null) {
                                                                                                                                                                           var24 += var52.value;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     class60.chatMessages.putVarc(var44[var24], class80.intStack[--class80.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class80.intStack[++class80.intStackSize - 1] = class60.chatMessages.getVarc(var44[var24]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var26 = var44[var24];
                                                                                                                                                               Script var49 = (Script)Script.field1406.get((long)var26);
                                                                                                                                                               Script var50;
                                                                                                                                                               if(var49 != null) {
                                                                                                                                                                  var50 = var49;
                                                                                                                                                               } else {
                                                                                                                                                                  byte[] var62 = class80.indexScripts.getConfigData(var26, 0);
                                                                                                                                                                  if(var62 == null) {
                                                                                                                                                                     var50 = null;
                                                                                                                                                                  } else {
                                                                                                                                                                     var49 = IndexStoreActionHandler.newScript(var62);
                                                                                                                                                                     Script.field1406.put(var49, (long)var26);
                                                                                                                                                                     var50 = var49;
                                                                                                                                                                  }
                                                                                                                                                               }

                                                                                                                                                               var49 = var50;
                                                                                                                                                               int[] var63 = new int[var50.localIntCount];
                                                                                                                                                               String[] var54 = new String[var50.localStringCount];

                                                                                                                                                               for(var18 = 0; var18 < var49.intStackCount; ++var18) {
                                                                                                                                                                  var63[var18] = class80.intStack[var18 + (class80.intStackSize - var49.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var18 = 0; var18 < var49.stringStackCount; ++var18) {
                                                                                                                                                                  var54[var18] = class80.scriptStringStack[var18 + (class43.scriptStringStackSize - var49.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class80.intStackSize -= var49.intStackCount;
                                                                                                                                                               class43.scriptStringStackSize -= var49.stringStackCount;
                                                                                                                                                               ScriptState var65 = new ScriptState();
                                                                                                                                                               var65.invokedFromScript = var3;
                                                                                                                                                               var65.invokedFromPc = var24;
                                                                                                                                                               var65.savedLocalInts = class80.scriptLocalInts;
                                                                                                                                                               var65.savedLocalStrings = class80.scriptLocalStrings;
                                                                                                                                                               class80.scriptStack[++class80.scriptStackCount - 1] = var65;
                                                                                                                                                               var3 = var49;
                                                                                                                                                               var46 = var49.instructions;
                                                                                                                                                               var44 = var49.intOperands;
                                                                                                                                                               var24 = -1;
                                                                                                                                                               class80.scriptLocalInts = var63;
                                                                                                                                                               class80.scriptLocalStrings = var54;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --class43.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class80.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var26 = var44[var24];
                                                                                                                                                      class43.scriptStringStackSize -= var26;
                                                                                                                                                      String[] var15 = class80.scriptStringStack;
                                                                                                                                                      var16 = class43.scriptStringStackSize;
                                                                                                                                                      String var14;
                                                                                                                                                      if(var26 == 0) {
                                                                                                                                                         var14 = "";
                                                                                                                                                      } else if(var26 == 1) {
                                                                                                                                                         String var53 = var15[var16];
                                                                                                                                                         if(var53 == null) {
                                                                                                                                                            var14 = "null";
                                                                                                                                                         } else {
                                                                                                                                                            var14 = var53.toString();
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         var27 = var26 + var16;
                                                                                                                                                         var18 = 0;

                                                                                                                                                         for(var19 = var16; var19 < var27; ++var19) {
                                                                                                                                                            String var20 = var15[var19];
                                                                                                                                                            if(var20 == null) {
                                                                                                                                                               var18 += 4;
                                                                                                                                                            } else {
                                                                                                                                                               var18 += var20.length();
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         StringBuilder var60 = new StringBuilder(var18);

                                                                                                                                                         for(var29 = var16; var29 < var27; ++var29) {
                                                                                                                                                            String var56 = var15[var29];
                                                                                                                                                            if(var56 == null) {
                                                                                                                                                               var60.append("null");
                                                                                                                                                            } else {
                                                                                                                                                               var60.append(var56);
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         var14 = var60.toString();
                                                                                                                                                      }

                                                                                                                                                      class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var14;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class80.scriptLocalStrings[var44[var24]] = class80.scriptStringStack[--class43.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class80.scriptStringStack[++class43.scriptStringStackSize - 1] = class80.scriptLocalStrings[var44[var24]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class80.scriptLocalInts[var44[var24]] = class80.intStack[--class80.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class80.intStack[++class80.intStackSize - 1] = class80.scriptLocalInts[var44[var24]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class80.intStackSize -= 2;
                                                                                                                                       if(class80.intStack[class80.intStackSize] >= class80.intStack[class80.intStackSize + 1]) {
                                                                                                                                          var24 += var44[var24];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class80.intStackSize -= 2;
                                                                                                                                    if(class80.intStack[class80.intStackSize] <= class80.intStack[class80.intStackSize + 1]) {
                                                                                                                                       var24 += var44[var24];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var26 = var44[var24];
                                                                                                                                 ContextMenuRow.method1858(var26, class80.intStack[--class80.intStackSize]);
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var26 = var44[var24];
                                                                                                                              class80.intStack[++class80.intStackSize - 1] = class28.getVarbit(var26);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class80.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var48 = class80.scriptStack[--class80.scriptStackCount];
                                                                                                                           var3 = var48.invokedFromScript;
                                                                                                                           var46 = var3.instructions;
                                                                                                                           var44 = var3.intOperands;
                                                                                                                           var24 = var48.invokedFromPc;
                                                                                                                           class80.scriptLocalInts = var48.savedLocalInts;
                                                                                                                           class80.scriptLocalStrings = var48.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class80.intStackSize -= 2;
                                                                                                                        if(class80.intStack[class80.intStackSize] > class80.intStack[class80.intStackSize + 1]) {
                                                                                                                           var24 += var44[var24];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class80.intStackSize -= 2;
                                                                                                                     if(class80.intStack[class80.intStackSize] < class80.intStack[class80.intStackSize + 1]) {
                                                                                                                        var24 += var44[var24];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class80.intStackSize -= 2;
                                                                                                                  if(class80.intStack[class80.intStackSize] == class80.intStack[class80.intStackSize + 1]) {
                                                                                                                     var24 += var44[var24];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class80.intStackSize -= 2;
                                                                                                               if(class80.intStack[class80.intStackSize] != class80.intStack[class80.intStackSize + 1]) {
                                                                                                                  var24 += var44[var24];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var24 += var44[var24];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var3.stringOperands[var24];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var26 = var44[var24];
                                                                                                      class231.widgetSettings[var26] = class80.intStack[--class80.intStackSize];
                                                                                                      AbstractSoundSystem.method2232(var26);
                                                                                                   }
                                                                                                } else {
                                                                                                   var26 = var44[var24];
                                                                                                   class80.intStack[++class80.intStackSize - 1] = class231.widgetSettings[var26];
                                                                                                }
                                                                                             } else {
                                                                                                class80.intStack[++class80.intStackSize - 1] = var44[var24];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var64;
                                                                                             if(var3.intOperands[var24] == 1) {
                                                                                                var64 = true;
                                                                                             } else {
                                                                                                var64 = false;
                                                                                             }

                                                                                             if(var9 < 1000) {
                                                                                                var32 = BoundingBox3DDrawMode.method53(var9, var3, var64);
                                                                                             } else if(var9 < 1100) {
                                                                                                var32 = class40.method562(var9, var3, var64);
                                                                                             } else if(var9 < 1200) {
                                                                                                var32 = class87.method1863(var9, var3, var64);
                                                                                             } else if(var9 < 1300) {
                                                                                                var32 = class80.method1815(var9, var3, var64);
                                                                                             } else if(var9 < 1400) {
                                                                                                var32 = class194.method3793(var9, var3, var64);
                                                                                             } else if(var9 < 1500) {
                                                                                                var32 = class61.method1097(var9, var3, var64);
                                                                                             } else {
                                                                                                byte var33;
                                                                                                if(var9 < 1600) {
                                                                                                   Widget var28 = var64?class223.field2643:class80.field1228;
                                                                                                   if(var9 == 1500) {
                                                                                                      class80.intStack[++class80.intStackSize - 1] = var28.relativeX;
                                                                                                      var33 = 1;
                                                                                                   } else if(var9 == 1501) {
                                                                                                      class80.intStack[++class80.intStackSize - 1] = var28.relativeY;
                                                                                                      var33 = 1;
                                                                                                   } else if(var9 == 1502) {
                                                                                                      class80.intStack[++class80.intStackSize - 1] = var28.width;
                                                                                                      var33 = 1;
                                                                                                   } else if(var9 == 1503) {
                                                                                                      class80.intStack[++class80.intStackSize - 1] = var28.height;
                                                                                                      var33 = 1;
                                                                                                   } else if(var9 == 1504) {
                                                                                                      class80.intStack[++class80.intStackSize - 1] = var28.isHidden?1:0;
                                                                                                      var33 = 1;
                                                                                                   } else if(var9 == 1505) {
                                                                                                      class80.intStack[++class80.intStackSize - 1] = var28.parentId;
                                                                                                      var33 = 1;
                                                                                                   } else {
                                                                                                      var33 = 2;
                                                                                                   }

                                                                                                   var32 = var33;
                                                                                                } else {
                                                                                                   Widget var30;
                                                                                                   if(var9 < 1700) {
                                                                                                      var30 = var64?class223.field2643:class80.field1228;
                                                                                                      if(var9 == 1600) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var30.scrollX;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 1601) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var30.scrollY;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 1602) {
                                                                                                         class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var30.text;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 1603) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var30.scrollWidth;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 1604) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var30.scrollHeight;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 1605) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var30.modelZoom;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 1606) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var30.rotationX;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 1607) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var30.rotationY;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 1608) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var30.rotationZ;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 1609) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var30.opacity;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 1610) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var30.field2772;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 1611) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var30.textColor;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 1612) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var30.field2803;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 1613) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var30.field2807.rsOrdinal();
                                                                                                         var33 = 1;
                                                                                                      } else {
                                                                                                         var33 = 2;
                                                                                                      }

                                                                                                      var32 = var33;
                                                                                                   } else if(var9 < 1800) {
                                                                                                      var32 = SceneTilePaint.method2879(var9, var3, var64);
                                                                                                   } else if(var9 < 1900) {
                                                                                                      var32 = Client.method1616(var9, var3, var64);
                                                                                                   } else if(var9 < 2000) {
                                                                                                      var32 = GrandExchangeEvents.method75(var9, var3, var64);
                                                                                                   } else if(var9 < 2100) {
                                                                                                      var32 = class40.method562(var9, var3, var64);
                                                                                                   } else if(var9 < 2200) {
                                                                                                      var32 = class87.method1863(var9, var3, var64);
                                                                                                   } else if(var9 < 2300) {
                                                                                                      var32 = class80.method1815(var9, var3, var64);
                                                                                                   } else if(var9 < 2400) {
                                                                                                      var32 = class194.method3793(var9, var3, var64);
                                                                                                   } else if(var9 < 2500) {
                                                                                                      var32 = class61.method1097(var9, var3, var64);
                                                                                                   } else if(var9 < 2600) {
                                                                                                      var32 = BoundingBox.method45(var9, var3, var64);
                                                                                                   } else if(var9 < 2700) {
                                                                                                      var30 = NetWriter.getWidget(class80.intStack[--class80.intStackSize]);
                                                                                                      if(var9 == 2600) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var30.scrollX;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 2601) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var30.scrollY;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 2602) {
                                                                                                         class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var30.text;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 2603) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var30.scrollWidth;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 2604) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var30.scrollHeight;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 2605) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var30.modelZoom;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 2606) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var30.rotationX;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 2607) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var30.rotationY;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 2608) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var30.rotationZ;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 2609) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var30.opacity;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 2610) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var30.field2772;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 2611) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var30.textColor;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 2612) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var30.field2803;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 2613) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var30.field2807.rsOrdinal();
                                                                                                         var33 = 1;
                                                                                                      } else {
                                                                                                         var33 = 2;
                                                                                                      }

                                                                                                      var32 = var33;
                                                                                                   } else if(var9 < 2800) {
                                                                                                      var32 = class36.method511(var9, var3, var64);
                                                                                                   } else if(var9 < 2900) {
                                                                                                      var32 = DynamicObject.method2009(var9, var3, var64);
                                                                                                   } else if(var9 < 3000) {
                                                                                                      var32 = GrandExchangeEvents.method75(var9, var3, var64);
                                                                                                   } else if(var9 < 3200) {
                                                                                                      var32 = class46.method691(var9, var3, var64);
                                                                                                   } else if(var9 < 3300) {
                                                                                                      var32 = Script.method2008(var9, var3, var64);
                                                                                                   } else if(var9 < 3400) {
                                                                                                      var32 = DState.method3523(var9, var3, var64);
                                                                                                   } else if(var9 < 3500) {
                                                                                                      var32 = class37.method520(var9, var3, var64);
                                                                                                   } else if(var9 < 3700) {
                                                                                                      var32 = GrandExchangeEvents.method72(var9, var3, var64);
                                                                                                   } else if(var9 < 4000) {
                                                                                                      var32 = class162.method3200(var9, var3, var64);
                                                                                                   } else if(var9 < 4100) {
                                                                                                      if(var9 == 4000) {
                                                                                                         class80.intStackSize -= 2;
                                                                                                         var16 = class80.intStack[class80.intStackSize];
                                                                                                         var27 = class80.intStack[class80.intStackSize + 1];
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var27 + var16;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 4001) {
                                                                                                         class80.intStackSize -= 2;
                                                                                                         var16 = class80.intStack[class80.intStackSize];
                                                                                                         var27 = class80.intStack[class80.intStackSize + 1];
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var16 - var27;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 4002) {
                                                                                                         class80.intStackSize -= 2;
                                                                                                         var16 = class80.intStack[class80.intStackSize];
                                                                                                         var27 = class80.intStack[class80.intStackSize + 1];
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var27 * var16;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 4003) {
                                                                                                         class80.intStackSize -= 2;
                                                                                                         var16 = class80.intStack[class80.intStackSize];
                                                                                                         var27 = class80.intStack[class80.intStackSize + 1];
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var16 / var27;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 4004) {
                                                                                                         var16 = class80.intStack[--class80.intStackSize];
                                                                                                         class80.intStack[++class80.intStackSize - 1] = (int)(Math.random() * (double)var16);
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 4005) {
                                                                                                         var16 = class80.intStack[--class80.intStackSize];
                                                                                                         class80.intStack[++class80.intStackSize - 1] = (int)(Math.random() * (double)(var16 + 1));
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 4006) {
                                                                                                         class80.intStackSize -= 5;
                                                                                                         var16 = class80.intStack[class80.intStackSize];
                                                                                                         var27 = class80.intStack[class80.intStackSize + 1];
                                                                                                         var18 = class80.intStack[class80.intStackSize + 2];
                                                                                                         var19 = class80.intStack[class80.intStackSize + 3];
                                                                                                         var29 = class80.intStack[class80.intStackSize + 4];
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var16 + (var27 - var16) * (var29 - var18) / (var19 - var18);
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 4007) {
                                                                                                         class80.intStackSize -= 2;
                                                                                                         var16 = class80.intStack[class80.intStackSize];
                                                                                                         var27 = class80.intStack[class80.intStackSize + 1];
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var16 + var16 * var27 / 100;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 4008) {
                                                                                                         class80.intStackSize -= 2;
                                                                                                         var16 = class80.intStack[class80.intStackSize];
                                                                                                         var27 = class80.intStack[class80.intStackSize + 1];
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var16 | 1 << var27;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 4009) {
                                                                                                         class80.intStackSize -= 2;
                                                                                                         var16 = class80.intStack[class80.intStackSize];
                                                                                                         var27 = class80.intStack[class80.intStackSize + 1];
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var16 & -1 - (1 << var27);
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 4010) {
                                                                                                         class80.intStackSize -= 2;
                                                                                                         var16 = class80.intStack[class80.intStackSize];
                                                                                                         var27 = class80.intStack[class80.intStackSize + 1];
                                                                                                         class80.intStack[++class80.intStackSize - 1] = (var16 & 1 << var27) != 0?1:0;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 4011) {
                                                                                                         class80.intStackSize -= 2;
                                                                                                         var16 = class80.intStack[class80.intStackSize];
                                                                                                         var27 = class80.intStack[class80.intStackSize + 1];
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var16 % var27;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 4012) {
                                                                                                         class80.intStackSize -= 2;
                                                                                                         var16 = class80.intStack[class80.intStackSize];
                                                                                                         var27 = class80.intStack[class80.intStackSize + 1];
                                                                                                         if(var16 == 0) {
                                                                                                            class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                         } else {
                                                                                                            class80.intStack[++class80.intStackSize - 1] = (int)Math.pow((double)var16, (double)var27);
                                                                                                         }

                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 4013) {
                                                                                                         class80.intStackSize -= 2;
                                                                                                         var16 = class80.intStack[class80.intStackSize];
                                                                                                         var27 = class80.intStack[class80.intStackSize + 1];
                                                                                                         if(var16 == 0) {
                                                                                                            class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                            var33 = 1;
                                                                                                         } else {
                                                                                                            switch(var27) {
                                                                                                            case 0:
                                                                                                               class80.intStack[++class80.intStackSize - 1] = Integer.MAX_VALUE;
                                                                                                               break;
                                                                                                            case 1:
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var16;
                                                                                                               break;
                                                                                                            case 2:
                                                                                                               class80.intStack[++class80.intStackSize - 1] = (int)Math.sqrt((double)var16);
                                                                                                               break;
                                                                                                            case 3:
                                                                                                               class80.intStack[++class80.intStackSize - 1] = (int)Math.cbrt((double)var16);
                                                                                                               break;
                                                                                                            case 4:
                                                                                                               class80.intStack[++class80.intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)var16));
                                                                                                               break;
                                                                                                            default:
                                                                                                               class80.intStack[++class80.intStackSize - 1] = (int)Math.pow((double)var16, 1.0D / (double)var27);
                                                                                                            }

                                                                                                            var33 = 1;
                                                                                                         }
                                                                                                      } else if(var9 == 4014) {
                                                                                                         class80.intStackSize -= 2;
                                                                                                         var16 = class80.intStack[class80.intStackSize];
                                                                                                         var27 = class80.intStack[class80.intStackSize + 1];
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var16 & var27;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 4015) {
                                                                                                         class80.intStackSize -= 2;
                                                                                                         var16 = class80.intStack[class80.intStackSize];
                                                                                                         var27 = class80.intStack[class80.intStackSize + 1];
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var16 | var27;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 4018) {
                                                                                                         class80.intStackSize -= 3;
                                                                                                         long var34 = (long)class80.intStack[class80.intStackSize];
                                                                                                         long var36 = (long)class80.intStack[class80.intStackSize + 1];
                                                                                                         long var38 = (long)class80.intStack[class80.intStackSize + 2];
                                                                                                         class80.intStack[++class80.intStackSize - 1] = (int)(var34 * var38 / var36);
                                                                                                         var33 = 1;
                                                                                                      } else {
                                                                                                         var33 = 2;
                                                                                                      }

                                                                                                      var32 = var33;
                                                                                                   } else if(var9 < 4200) {
                                                                                                      var32 = class159.method3171(var9, var3, var64);
                                                                                                   } else if(var9 < 4300) {
                                                                                                      var32 = ItemContainer.method1122(var9, var3, var64);
                                                                                                   } else if(var9 < 5100) {
                                                                                                      var32 = class43.method643(var9, var3, var64);
                                                                                                   } else if(var9 < 5400) {
                                                                                                      var32 = class28.method266(var9, var3, var64);
                                                                                                   } else if(var9 < 5600) {
                                                                                                      if(var9 == 5504) {
                                                                                                         class80.intStackSize -= 2;
                                                                                                         var19 = class80.intStack[class80.intStackSize];
                                                                                                         var29 = class80.intStack[class80.intStackSize + 1];
                                                                                                         if(!Client.field983) {
                                                                                                            Client.cameraPitchTarget = var19;
                                                                                                            Client.mapAngle = var29;
                                                                                                         }

                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 5505) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = Client.cameraPitchTarget;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 5506) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = Client.mapAngle;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 5530) {
                                                                                                         var19 = class80.intStack[--class80.intStackSize];
                                                                                                         if(var19 < 0) {
                                                                                                            var19 = 0;
                                                                                                         }

                                                                                                         Client.field891 = var19;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 5531) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = Client.field891;
                                                                                                         var33 = 1;
                                                                                                      } else {
                                                                                                         var33 = 2;
                                                                                                      }

                                                                                                      var32 = var33;
                                                                                                   } else if(var9 < 5700) {
                                                                                                      if(var9 == 5630) {
                                                                                                         Client.field864 = 250;
                                                                                                         var33 = 1;
                                                                                                      } else {
                                                                                                         var33 = 2;
                                                                                                      }

                                                                                                      var32 = var33;
                                                                                                   } else if(var9 < 6300) {
                                                                                                      if(var9 == 6200) {
                                                                                                         class80.intStackSize -= 2;
                                                                                                         Client.field1055 = (short)class80.intStack[class80.intStackSize];
                                                                                                         if(Client.field1055 <= 0) {
                                                                                                            Client.field1055 = 256;
                                                                                                         }

                                                                                                         Client.field947 = (short)class80.intStack[class80.intStackSize + 1];
                                                                                                         if(Client.field947 <= 0) {
                                                                                                            Client.field947 = 205;
                                                                                                         }

                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 6201) {
                                                                                                         class80.intStackSize -= 2;
                                                                                                         Client.field899 = (short)class80.intStack[class80.intStackSize];
                                                                                                         if(Client.field899 <= 0) {
                                                                                                            Client.field899 = 256;
                                                                                                         }

                                                                                                         Client.field1058 = (short)class80.intStack[class80.intStackSize + 1];
                                                                                                         if(Client.field1058 <= 0) {
                                                                                                            Client.field1058 = 320;
                                                                                                         }

                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 6202) {
                                                                                                         class80.intStackSize -= 4;
                                                                                                         Client.field1059 = (short)class80.intStack[class80.intStackSize];
                                                                                                         if(Client.field1059 <= 0) {
                                                                                                            Client.field1059 = 1;
                                                                                                         }

                                                                                                         Client.field1060 = (short)class80.intStack[class80.intStackSize + 1];
                                                                                                         if(Client.field1060 <= 0) {
                                                                                                            Client.field1060 = 32767;
                                                                                                         } else if(Client.field1060 < Client.field1059) {
                                                                                                            Client.field1060 = Client.field1059;
                                                                                                         }

                                                                                                         Client.field1061 = (short)class80.intStack[class80.intStackSize + 2];
                                                                                                         if(Client.field1061 <= 0) {
                                                                                                            Client.field1061 = 1;
                                                                                                         }

                                                                                                         Client.field1062 = (short)class80.intStack[class80.intStackSize + 3];
                                                                                                         if(Client.field1062 <= 0) {
                                                                                                            Client.field1062 = 32767;
                                                                                                         } else if(Client.field1062 < Client.field1061) {
                                                                                                            Client.field1062 = Client.field1061;
                                                                                                         }

                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 6203) {
                                                                                                         if(Client.field975 != null) {
                                                                                                            class19.method161(0, 0, Client.field975.width, Client.field975.height, false);
                                                                                                            class80.intStack[++class80.intStackSize - 1] = Client.viewportWidth;
                                                                                                            class80.intStack[++class80.intStackSize - 1] = Client.viewportHeight;
                                                                                                         } else {
                                                                                                            class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                            class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                         }

                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 6204) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = Client.field899;
                                                                                                         class80.intStack[++class80.intStackSize - 1] = Client.field1058;
                                                                                                         var33 = 1;
                                                                                                      } else if(var9 == 6205) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = Client.field1055;
                                                                                                         class80.intStack[++class80.intStackSize - 1] = Client.field947;
                                                                                                         var33 = 1;
                                                                                                      } else {
                                                                                                         var33 = 2;
                                                                                                      }

                                                                                                      var32 = var33;
                                                                                                   } else if(var9 < 6600) {
                                                                                                      if(var9 == 6500) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = Preferences.loadWorlds()?1:0;
                                                                                                         var33 = 1;
                                                                                                      } else {
                                                                                                         World var17;
                                                                                                         if(var9 == 6501) {
                                                                                                            World.field1167 = 0;
                                                                                                            if(World.field1167 < World.worldCount) {
                                                                                                               var17 = World.worldList[++World.field1167 - 1];
                                                                                                            } else {
                                                                                                               var17 = null;
                                                                                                            }

                                                                                                            if(var17 != null) {
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var17.id;
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var17.mask;
                                                                                                               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var17.activity;
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var17.location;
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var17.playerCount;
                                                                                                               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var17.address;
                                                                                                            } else {
                                                                                                               class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                               class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = "";
                                                                                                               class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                               class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = "";
                                                                                                            }

                                                                                                            var33 = 1;
                                                                                                         } else if(var9 == 6502) {
                                                                                                            World var61;
                                                                                                            if(World.field1167 < World.worldCount) {
                                                                                                               var61 = World.worldList[++World.field1167 - 1];
                                                                                                            } else {
                                                                                                               var61 = null;
                                                                                                            }

                                                                                                            if(var61 != null) {
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var61.id;
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var61.mask;
                                                                                                               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var61.activity;
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var61.location;
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var61.playerCount;
                                                                                                               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var61.address;
                                                                                                            } else {
                                                                                                               class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                               class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = "";
                                                                                                               class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                               class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = "";
                                                                                                            }

                                                                                                            var33 = 1;
                                                                                                         } else if(var9 == 6506) {
                                                                                                            var16 = class80.intStack[--class80.intStackSize];
                                                                                                            var17 = null;

                                                                                                            for(var18 = 0; var18 < World.worldCount; ++var18) {
                                                                                                               if(var16 == World.worldList[var18].id) {
                                                                                                                  var17 = World.worldList[var18];
                                                                                                                  break;
                                                                                                               }
                                                                                                            }

                                                                                                            if(var17 != null) {
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var17.id;
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var17.mask;
                                                                                                               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var17.activity;
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var17.location;
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var17.playerCount;
                                                                                                               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var17.address;
                                                                                                            } else {
                                                                                                               class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                               class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = "";
                                                                                                               class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                               class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = "";
                                                                                                            }

                                                                                                            var33 = 1;
                                                                                                         } else if(var9 == 6507) {
                                                                                                            class80.intStackSize -= 4;
                                                                                                            var16 = class80.intStack[class80.intStackSize];
                                                                                                            boolean var66 = class80.intStack[class80.intStackSize + 1] == 1;
                                                                                                            var18 = class80.intStack[class80.intStackSize + 2];
                                                                                                            boolean var55 = class80.intStack[class80.intStackSize + 3] == 1;
                                                                                                            if(World.worldList != null) {
                                                                                                               class188.method3509(0, World.worldList.length - 1, var16, var66, var18, var55);
                                                                                                            }

                                                                                                            var33 = 1;
                                                                                                         } else if(var9 != 6511) {
                                                                                                            if(var9 == 6512) {
                                                                                                               Client.field950 = class80.intStack[--class80.intStackSize] == 1;
                                                                                                               var33 = 1;
                                                                                                            } else {
                                                                                                               class271 var31;
                                                                                                               if(var9 == 6513) {
                                                                                                                  class80.intStackSize -= 2;
                                                                                                                  var16 = class80.intStack[class80.intStackSize];
                                                                                                                  var27 = class80.intStack[class80.intStackSize + 1];
                                                                                                                  var31 = class157.method3163(var27);
                                                                                                                  if(var31.method4877()) {
                                                                                                                     class80.scriptStringStack[++class43.scriptStringStackSize - 1] = Tile.getNpcDefinition(var16).method5099(var27, var31.field3475);
                                                                                                                  } else {
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = Tile.getNpcDefinition(var16).method5072(var27, var31.field3477);
                                                                                                                  }

                                                                                                                  var33 = 1;
                                                                                                               } else if(var9 == 6514) {
                                                                                                                  class80.intStackSize -= 2;
                                                                                                                  var16 = class80.intStack[class80.intStackSize];
                                                                                                                  var27 = class80.intStack[class80.intStackSize + 1];
                                                                                                                  var31 = class157.method3163(var27);
                                                                                                                  if(var31.method4877()) {
                                                                                                                     class80.scriptStringStack[++class43.scriptStringStackSize - 1] = Preferences.getObjectDefinition(var16).method4974(var27, var31.field3475);
                                                                                                                  } else {
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = Preferences.getObjectDefinition(var16).method4979(var27, var31.field3477);
                                                                                                                  }

                                                                                                                  var33 = 1;
                                                                                                               } else if(var9 == 6515) {
                                                                                                                  class80.intStackSize -= 2;
                                                                                                                  var16 = class80.intStack[class80.intStackSize];
                                                                                                                  var27 = class80.intStack[class80.intStackSize + 1];
                                                                                                                  var31 = class157.method3163(var27);
                                                                                                                  if(var31.method4877()) {
                                                                                                                     class80.scriptStringStack[++class43.scriptStringStackSize - 1] = ContextMenuRow.getItemDefinition(var16).method5013(var27, var31.field3475);
                                                                                                                  } else {
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = ContextMenuRow.getItemDefinition(var16).method5012(var27, var31.field3477);
                                                                                                                  }

                                                                                                                  var33 = 1;
                                                                                                               } else if(var9 == 6516) {
                                                                                                                  class80.intStackSize -= 2;
                                                                                                                  var16 = class80.intStack[class80.intStackSize];
                                                                                                                  var27 = class80.intStack[class80.intStackSize + 1];
                                                                                                                  var31 = class157.method3163(var27);
                                                                                                                  class272 var21;
                                                                                                                  class272 var22;
                                                                                                                  byte[] var23;
                                                                                                                  if(var31.method4877()) {
                                                                                                                     String[] var58 = class80.scriptStringStack;
                                                                                                                     var29 = ++class43.scriptStringStackSize - 1;
                                                                                                                     var22 = (class272)class272.field3480.get((long)var16);
                                                                                                                     if(var22 != null) {
                                                                                                                        var21 = var22;
                                                                                                                     } else {
                                                                                                                        var23 = class272.field3481.getConfigData(34, var16);
                                                                                                                        var22 = new class272();
                                                                                                                        if(var23 != null) {
                                                                                                                           var22.method4884(new Buffer(var23));
                                                                                                                        }

                                                                                                                        var22.method4896();
                                                                                                                        class272.field3480.put(var22, (long)var16);
                                                                                                                        var21 = var22;
                                                                                                                     }

                                                                                                                     var58[var29] = var21.method4887(var27, var31.field3475);
                                                                                                                  } else {
                                                                                                                     int[] var59 = class80.intStack;
                                                                                                                     var29 = ++class80.intStackSize - 1;
                                                                                                                     var22 = (class272)class272.field3480.get((long)var16);
                                                                                                                     if(var22 != null) {
                                                                                                                        var21 = var22;
                                                                                                                     } else {
                                                                                                                        var23 = class272.field3481.getConfigData(34, var16);
                                                                                                                        var22 = new class272();
                                                                                                                        if(var23 != null) {
                                                                                                                           var22.method4884(new Buffer(var23));
                                                                                                                        }

                                                                                                                        var22.method4896();
                                                                                                                        class272.field3480.put(var22, (long)var16);
                                                                                                                        var21 = var22;
                                                                                                                     }

                                                                                                                     var59[var29] = var21.method4886(var27, var31.field3477);
                                                                                                                  }

                                                                                                                  var33 = 1;
                                                                                                               } else if(var9 == 6518) {
                                                                                                                  class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                                  var33 = 1;
                                                                                                               } else if(var9 == 6520) {
                                                                                                                  var33 = 1;
                                                                                                               } else if(var9 == 6521) {
                                                                                                                  var33 = 1;
                                                                                                               } else {
                                                                                                                  var33 = 2;
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var16 = class80.intStack[--class80.intStackSize];
                                                                                                            if(var16 >= 0 && var16 < World.worldCount) {
                                                                                                               var17 = World.worldList[var16];
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var17.id;
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var17.mask;
                                                                                                               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var17.activity;
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var17.location;
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var17.playerCount;
                                                                                                               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var17.address;
                                                                                                            } else {
                                                                                                               class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                               class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = "";
                                                                                                               class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                               class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = "";
                                                                                                            }

                                                                                                            var33 = 1;
                                                                                                         }
                                                                                                      }

                                                                                                      var32 = var33;
                                                                                                   } else if(var9 < 6700) {
                                                                                                      var32 = class277.method5061(var9, var3, var64);
                                                                                                   } else {
                                                                                                      var32 = 2;
                                                                                                   }
                                                                                                }
                                                                                             }

                                                                                             switch(var32) {
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
         } catch (Exception var42) {
            StringBuilder var41 = new StringBuilder(30);
            var41.append("").append(var3.hash).append(" ");

            for(var12 = class80.scriptStackCount - 1; var12 >= 0; --var12) {
               var41.append("").append(class80.scriptStack[var12].invokedFromScript.hash).append(" ");
            }

            var41.append("").append(var45);
            class37.method519(var41.toString(), var42);
         }
      }
   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(Lbq;II)V",
      garbageValue = "2124130109"
   )
   @Export("characterToScreen")
   static final void characterToScreen(Actor var0, int var1) {
      class225.worldToScreen(var0.x, var0.y, var1);
   }
}
