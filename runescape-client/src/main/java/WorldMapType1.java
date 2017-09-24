import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
@Implements("WorldMapType1")
public class WorldMapType1 implements WorldMapSectionBase {
   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   static IndexedSprite field446;
   @ObfuscatedName("ch")
   public static char field444;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -847282959
   )
   int field440;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -91340359
   )
   int field434;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2046643205
   )
   int field442;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1386247699
   )
   int field435;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 311430543
   )
   int field436;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -357767947
   )
   int field437;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 290534923
   )
   int field443;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -621762557
   )
   int field438;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -830112947
   )
   int field441;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 352539825
   )
   int field439;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "59"
   )
   public boolean vmethod747(int var1, int var2) {
      return var1 >> 6 >= this.field440 && var1 >> 6 <= this.field442 && var2 >> 6 >= this.field436 && var2 >> 6 <= this.field443;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "1746025354"
   )
   public boolean vmethod746(int var1, int var2, int var3) {
      return var1 >= this.field434 && var1 < this.field434 + this.field435?var2 >> 6 >= this.field437 && var2 >> 6 <= this.field438 && var3 >> 6 >= this.field441 && var3 >> 6 <= this.field439:false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lam;I)V",
      garbageValue = "2013920575"
   )
   public void vmethod745(WorldMapData var1) {
      if(var1.field462 > this.field440) {
         var1.field462 = this.field440;
      }

      if(var1.field468 < this.field442) {
         var1.field468 = this.field442;
      }

      if(var1.field456 > this.field436) {
         var1.field456 = this.field436;
      }

      if(var1.field465 < this.field443) {
         var1.field465 = this.field443;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)Lhs;",
      garbageValue = "1278074658"
   )
   public Coordinates vmethod771(int var1, int var2) {
      if(!this.vmethod747(var1, var2)) {
         return null;
      } else {
         int var3 = var1 + (this.field437 * 64 - this.field440 * 64);
         int var4 = var2 + (this.field441 * 64 - this.field436 * 64);
         return new Coordinates(this.field434, var3, var4);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1584803853"
   )
   public int[] vmethod757(int var1, int var2, int var3) {
      if(!this.vmethod746(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field440 * 64 - this.field437 * 64 + var2, var3 + (this.field436 * 64 - this.field441 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "-1644047401"
   )
   public void vmethod751(Buffer var1) {
      this.field434 = var1.readUnsignedByte();
      this.field435 = var1.readUnsignedByte();
      this.field437 = var1.readUnsignedShort();
      this.field441 = var1.readUnsignedShort();
      this.field438 = var1.readUnsignedShort();
      this.field439 = var1.readUnsignedShort();
      this.field440 = var1.readUnsignedShort();
      this.field436 = var1.readUnsignedShort();
      this.field442 = var1.readUnsignedShort();
      this.field443 = var1.readUnsignedShort();
      this.method282();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1701715016"
   )
   void method282() {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lbm;IB)V",
      garbageValue = "1"
   )
   static void method300(ScriptEvent var0, int var1) {
      Object[] var2 = var0.field864;
      class220 var5 = var0.field867;
      boolean var4 = var5 == class220.field2796 || var5 == class220.field2799 || var5 == class220.field2798 || var5 == class220.field2809 || var5 == class220.field2800 || var5 == class220.field2801 || var5 == class220.field2803 || var5 == class220.field2797;
      Script var3;
      Script var7;
      int var9;
      int var10;
      int var11;
      Script var15;
      int var17;
      int var22;
      String var25;
      byte[] var29;
      int var31;
      Script var46;
      if(var4) {
         Script.field1543 = (class47)var2[0];
         Area var6 = Area.field3294[Script.field1543.field613];
         class220 var8 = var0.field867;
         var9 = var6.field3296;
         var10 = var6.field3313;
         var11 = class25.method206(var9, var8);
         Script var13 = (Script)Script.field1546.get((long)(var11 << 16));
         Script var12;
         if(var13 != null) {
            var12 = var13;
         } else {
            var25 = String.valueOf(var11);
            var31 = class67.indexScripts.getFile(var25);
            if(var31 == -1) {
               var12 = null;
            } else {
               label654: {
                  var29 = class67.indexScripts.method4209(var31);
                  if(var29 != null) {
                     if(var29.length <= 1) {
                        var12 = null;
                        break label654;
                     }

                     var13 = MilliTimer.method2993(var29);
                     if(var13 != null) {
                        Script.field1546.put(var13, (long)(var11 << 16));
                        var12 = var13;
                        break label654;
                     }
                  }

                  var12 = null;
               }
            }
         }

         if(var12 != null) {
            var7 = var12;
         } else {
            var11 = Timer.method3055(var10, var8);
            var15 = (Script)Script.field1546.get((long)(var11 << 16));
            if(var15 != null) {
               var46 = var15;
            } else {
               String var48 = String.valueOf(var11);
               var17 = class67.indexScripts.getFile(var48);
               if(var17 == -1) {
                  var46 = null;
               } else {
                  label585: {
                     byte[] var30 = class67.indexScripts.method4209(var17);
                     if(var30 != null) {
                        if(var30.length <= 1) {
                           var46 = null;
                           break label585;
                        }

                        var15 = MilliTimer.method2993(var30);
                        if(var15 != null) {
                           Script.field1546.put(var15, (long)(var11 << 16));
                           var46 = var15;
                           break label585;
                        }
                     }

                     var46 = null;
                  }
               }
            }

            if(var46 != null) {
               var7 = var46;
            } else {
               var7 = null;
            }
         }

         var3 = var7;
      } else {
         var22 = ((Integer)var2[0]).intValue();
         Script var36 = (Script)Script.field1546.get((long)var22);
         if(var36 != null) {
            var7 = var36;
         } else {
            byte[] var32 = class67.indexScripts.getConfigData(var22, 0);
            if(var32 == null) {
               var7 = null;
            } else {
               var36 = MilliTimer.method2993(var32);
               Script.field1546.put(var36, (long)var22);
               var7 = var36;
            }
         }

         var3 = var7;
      }

      if(var3 != null) {
         Ignore.intStackSize = 0;
         class169.scriptStringStackSize = 0;
         var22 = -1;
         int[] var39 = var3.instructions;
         int[] var37 = var3.intOperands;
         byte var38 = -1;
         class82.scriptStackCount = 0;

         int var23;
         try {
            class82.scriptLocalInts = new int[var3.localIntCount];
            var10 = 0;
            class165.scriptLocalStrings = new String[var3.localStringCount];
            var11 = 0;

            int var24;
            String var40;
            for(var23 = 1; var23 < var2.length; ++var23) {
               if(var2[var23] instanceof Integer) {
                  var24 = ((Integer)var2[var23]).intValue();
                  if(var24 == -2147483647) {
                     var24 = var0.field859;
                  }

                  if(var24 == -2147483646) {
                     var24 = var0.field860;
                  }

                  if(var24 == -2147483645) {
                     var24 = var0.widget != null?var0.widget.id:-1;
                  }

                  if(var24 == -2147483644) {
                     var24 = var0.field861;
                  }

                  if(var24 == -2147483643) {
                     var24 = var0.widget != null?var0.widget.index:-1;
                  }

                  if(var24 == -2147483642) {
                     var24 = var0.field862 != null?var0.field862.id:-1;
                  }

                  if(var24 == -2147483641) {
                     var24 = var0.field862 != null?var0.field862.index:-1;
                  }

                  if(var24 == -2147483640) {
                     var24 = var0.field856;
                  }

                  if(var24 == -2147483639) {
                     var24 = var0.field857;
                  }

                  class82.scriptLocalInts[var10++] = var24;
               } else if(var2[var23] instanceof String) {
                  var40 = (String)var2[var23];
                  if(var40.equals("event_opbase")) {
                     var40 = var0.field865;
                  }

                  class165.scriptLocalStrings[var11++] = var40;
               }
            }

            var23 = 0;
            class82.field1354 = var0.field863;

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
                                                                                       label392:
                                                                                       while(true) {
                                                                                          ++var23;
                                                                                          if(var23 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var22;
                                                                                          var9 = var39[var22];
                                                                                          int var14;
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
                                                                                                                              int var16;
                                                                                                                              int var18;
                                                                                                                              int var19;
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
                                                                                                                                                                        var24 = var37[var22] >> 16;
                                                                                                                                                                        var14 = var37[var22] & '\uffff';
                                                                                                                                                                        var31 = class82.intStack[--Ignore.intStackSize];
                                                                                                                                                                        if(var31 >= 0 && var31 <= 5000) {
                                                                                                                                                                           class82.field1346[var24] = var31;
                                                                                                                                                                           byte var45 = -1;
                                                                                                                                                                           if(var14 == 105) {
                                                                                                                                                                              var45 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var17 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var17 >= var31) {
                                                                                                                                                                                 continue label392;
                                                                                                                                                                              }

                                                                                                                                                                              class82.SHAPE_VERTICES[var24][var17] = var45;
                                                                                                                                                                              ++var17;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var9 == 45) {
                                                                                                                                                                        var24 = var37[var22];
                                                                                                                                                                        var14 = class82.intStack[--Ignore.intStackSize];
                                                                                                                                                                        if(var14 < 0 || var14 >= class82.field1346[var24]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class82.intStack[++Ignore.intStackSize - 1] = class82.SHAPE_VERTICES[var24][var14];
                                                                                                                                                                     } else if(var9 == 46) {
                                                                                                                                                                        var24 = var37[var22];
                                                                                                                                                                        Ignore.intStackSize -= 2;
                                                                                                                                                                        var14 = class82.intStack[Ignore.intStackSize];
                                                                                                                                                                        if(var14 < 0 || var14 >= class82.field1346[var24]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class82.SHAPE_VERTICES[var24][var14] = class82.intStack[Ignore.intStackSize + 1];
                                                                                                                                                                     } else if(var9 == 47) {
                                                                                                                                                                        var40 = class2.chatMessages.getVarcString(var37[var22]);
                                                                                                                                                                        if(var40 == null) {
                                                                                                                                                                           var40 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var40;
                                                                                                                                                                     } else if(var9 == 48) {
                                                                                                                                                                        class2.chatMessages.putVarcString(var37[var22], class82.scriptStringStack[--class169.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var9 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        IterableHashTable var44 = var3.switches[var37[var22]];
                                                                                                                                                                        IntegerNode var52 = (IntegerNode)var44.get((long)class82.intStack[--Ignore.intStackSize]);
                                                                                                                                                                        if(var52 != null) {
                                                                                                                                                                           var22 += var52.value;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     class2.chatMessages.putVarc(var37[var22], class82.intStack[--Ignore.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class82.intStack[++Ignore.intStackSize - 1] = class2.chatMessages.getVarc(var37[var22]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var24 = var37[var22];
                                                                                                                                                               var15 = (Script)Script.field1546.get((long)var24);
                                                                                                                                                               if(var15 != null) {
                                                                                                                                                                  var46 = var15;
                                                                                                                                                               } else {
                                                                                                                                                                  var29 = class67.indexScripts.getConfigData(var24, 0);
                                                                                                                                                                  if(var29 == null) {
                                                                                                                                                                     var46 = null;
                                                                                                                                                                  } else {
                                                                                                                                                                     var15 = MilliTimer.method2993(var29);
                                                                                                                                                                     Script.field1546.put(var15, (long)var24);
                                                                                                                                                                     var46 = var15;
                                                                                                                                                                  }
                                                                                                                                                               }

                                                                                                                                                               var15 = var46;
                                                                                                                                                               int[] var49 = new int[var46.localIntCount];
                                                                                                                                                               String[] var47 = new String[var46.localStringCount];

                                                                                                                                                               for(var18 = 0; var18 < var15.intStackCount; ++var18) {
                                                                                                                                                                  var49[var18] = class82.intStack[var18 + (Ignore.intStackSize - var15.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var18 = 0; var18 < var15.stringStackCount; ++var18) {
                                                                                                                                                                  var47[var18] = class82.scriptStringStack[var18 + (class169.scriptStringStackSize - var15.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               Ignore.intStackSize -= var15.intStackCount;
                                                                                                                                                               class169.scriptStringStackSize -= var15.stringStackCount;
                                                                                                                                                               ScriptState var51 = new ScriptState();
                                                                                                                                                               var51.invokedFromScript = var3;
                                                                                                                                                               var51.invokedFromPc = var22;
                                                                                                                                                               var51.savedLocalInts = class82.scriptLocalInts;
                                                                                                                                                               var51.savedLocalStrings = class165.scriptLocalStrings;
                                                                                                                                                               class82.scriptStack[++class82.scriptStackCount - 1] = var51;
                                                                                                                                                               var3 = var15;
                                                                                                                                                               var39 = var15.instructions;
                                                                                                                                                               var37 = var15.intOperands;
                                                                                                                                                               var22 = -1;
                                                                                                                                                               class82.scriptLocalInts = var49;
                                                                                                                                                               class165.scriptLocalStrings = var47;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --class169.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --Ignore.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var24 = var37[var22];
                                                                                                                                                      class169.scriptStringStackSize -= var24;
                                                                                                                                                      String[] var43 = class82.scriptStringStack;
                                                                                                                                                      var16 = class169.scriptStringStackSize;
                                                                                                                                                      if(var24 == 0) {
                                                                                                                                                         var25 = "";
                                                                                                                                                      } else if(var24 == 1) {
                                                                                                                                                         String var26 = var43[var16];
                                                                                                                                                         if(var26 == null) {
                                                                                                                                                            var25 = "null";
                                                                                                                                                         } else {
                                                                                                                                                            var25 = var26.toString();
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         var17 = var24 + var16;
                                                                                                                                                         var18 = 0;

                                                                                                                                                         for(var19 = var16; var19 < var17; ++var19) {
                                                                                                                                                            String var20 = var43[var19];
                                                                                                                                                            if(var20 == null) {
                                                                                                                                                               var18 += 4;
                                                                                                                                                            } else {
                                                                                                                                                               var18 += var20.length();
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         StringBuilder var27 = new StringBuilder(var18);

                                                                                                                                                         for(int var28 = var16; var28 < var17; ++var28) {
                                                                                                                                                            String var21 = var43[var28];
                                                                                                                                                            if(var21 == null) {
                                                                                                                                                               var27.append("null");
                                                                                                                                                            } else {
                                                                                                                                                               var27.append(var21);
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         var25 = var27.toString();
                                                                                                                                                      }

                                                                                                                                                      class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var25;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class165.scriptLocalStrings[var37[var22]] = class82.scriptStringStack[--class169.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class82.scriptStringStack[++class169.scriptStringStackSize - 1] = class165.scriptLocalStrings[var37[var22]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class82.scriptLocalInts[var37[var22]] = class82.intStack[--Ignore.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class82.intStack[++Ignore.intStackSize - 1] = class82.scriptLocalInts[var37[var22]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       Ignore.intStackSize -= 2;
                                                                                                                                       if(class82.intStack[Ignore.intStackSize] >= class82.intStack[Ignore.intStackSize + 1]) {
                                                                                                                                          var22 += var37[var22];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    Ignore.intStackSize -= 2;
                                                                                                                                    if(class82.intStack[Ignore.intStackSize] <= class82.intStack[Ignore.intStackSize + 1]) {
                                                                                                                                       var22 += var37[var22];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var24 = var37[var22];
                                                                                                                                 var14 = class82.intStack[--Ignore.intStackSize];
                                                                                                                                 Varbit var42 = KitDefinition.method4395(var24);
                                                                                                                                 var16 = var42.configId;
                                                                                                                                 var17 = var42.leastSignificantBit;
                                                                                                                                 var18 = var42.mostSignificantBit;
                                                                                                                                 var19 = class212.field2607[var18 - var17];
                                                                                                                                 if(var14 < 0 || var14 > var19) {
                                                                                                                                    var14 = 0;
                                                                                                                                 }

                                                                                                                                 var19 <<= var17;
                                                                                                                                 class212.widgetSettings[var16] = class212.widgetSettings[var16] & ~var19 | var14 << var17 & var19;
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var24 = var37[var22];
                                                                                                                              class82.intStack[++Ignore.intStackSize - 1] = WidgetNode.method1121(var24);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class82.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var41 = class82.scriptStack[--class82.scriptStackCount];
                                                                                                                           var3 = var41.invokedFromScript;
                                                                                                                           var39 = var3.instructions;
                                                                                                                           var37 = var3.intOperands;
                                                                                                                           var22 = var41.invokedFromPc;
                                                                                                                           class82.scriptLocalInts = var41.savedLocalInts;
                                                                                                                           class165.scriptLocalStrings = var41.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        Ignore.intStackSize -= 2;
                                                                                                                        if(class82.intStack[Ignore.intStackSize] > class82.intStack[Ignore.intStackSize + 1]) {
                                                                                                                           var22 += var37[var22];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     Ignore.intStackSize -= 2;
                                                                                                                     if(class82.intStack[Ignore.intStackSize] < class82.intStack[Ignore.intStackSize + 1]) {
                                                                                                                        var22 += var37[var22];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  Ignore.intStackSize -= 2;
                                                                                                                  if(class82.intStack[Ignore.intStackSize] == class82.intStack[Ignore.intStackSize + 1]) {
                                                                                                                     var22 += var37[var22];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               Ignore.intStackSize -= 2;
                                                                                                               if(class82.intStack[Ignore.intStackSize + 1] != class82.intStack[Ignore.intStackSize]) {
                                                                                                                  var22 += var37[var22];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var22 += var37[var22];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var3.stringOperands[var22];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var24 = var37[var22];
                                                                                                      class212.widgetSettings[var24] = class82.intStack[--Ignore.intStackSize];
                                                                                                      method301(var24);
                                                                                                   }
                                                                                                } else {
                                                                                                   var24 = var37[var22];
                                                                                                   class82.intStack[++Ignore.intStackSize - 1] = class212.widgetSettings[var24];
                                                                                                }
                                                                                             } else {
                                                                                                class82.intStack[++Ignore.intStackSize - 1] = var37[var22];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var50;
                                                                                             if(var3.intOperands[var22] == 1) {
                                                                                                var50 = true;
                                                                                             } else {
                                                                                                var50 = false;
                                                                                             }

                                                                                             var14 = class28.method267(var9, var3, var50);
                                                                                             switch(var14) {
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
         } catch (Exception var35) {
            StringBuilder var34 = new StringBuilder(30);
            var34.append("").append(var3.hash).append(" ");

            for(var23 = class82.scriptStackCount - 1; var23 >= 0; --var23) {
               var34.append("").append(class82.scriptStack[var23].invokedFromScript.hash).append(" ");
            }

            var34.append("").append(var38);
            class150.method2975(var34.toString(), var35);
         }
      }
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "92"
   )
   static final void method301(int var0) {
      class9.method54();

      for(class81 var1 = (class81)class81.field1334.getFront(); var1 != null; var1 = (class81)class81.field1334.getNext()) {
         if(var1.field1339 != null) {
            var1.method1609();
         }
      }

      int var4 = class36.method520(var0).configType;
      if(var4 != 0) {
         int var2 = class212.widgetSettings[var0];
         if(var4 == 1) {
            if(var2 == 1) {
               Graphics3D.setBrightness(0.9D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.9D);
            }

            if(var2 == 2) {
               Graphics3D.setBrightness(0.8D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.8D);
            }

            if(var2 == 3) {
               Graphics3D.setBrightness(0.7D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.7D);
            }

            if(var2 == 4) {
               Graphics3D.setBrightness(0.6D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.6D);
            }

            class37.method527();
         }

         if(var4 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(var3 != Client.field1167) {
               if(Client.field1167 == 0 && Client.field1168 != -1) {
                  CacheFile.method2339(class45.indexTrack1, Client.field1168, 0, var3, false);
                  Client.field1169 = false;
               } else if(var3 == 0) {
                  class165.method3158();
                  Client.field1169 = false;
               } else {
                  class164.method3148(var3);
               }

               Client.field1167 = var3;
            }
         }

         if(var4 == 4) {
            if(var2 == 0) {
               Client.field1185 = 127;
            }

            if(var2 == 1) {
               Client.field1185 = 96;
            }

            if(var2 == 2) {
               Client.field1185 = 64;
            }

            if(var2 == 3) {
               Client.field1185 = 32;
            }

            if(var2 == 4) {
               Client.field1185 = 0;
            }
         }

         if(var4 == 5) {
            Client.field1068 = var2;
         }

         if(var4 == 6) {
            Client.field1093 = var2;
         }

         if(var4 == 9) {
            Client.field1144 = var2;
         }

         if(var4 == 10) {
            if(var2 == 0) {
               Client.field1171 = 127;
            }

            if(var2 == 1) {
               Client.field1171 = 96;
            }

            if(var2 == 2) {
               Client.field1171 = 64;
            }

            if(var2 == 3) {
               Client.field1171 = 32;
            }

            if(var2 == 4) {
               Client.field1171 = 0;
            }
         }

         if(var4 == 17) {
            Client.field1099 = var2 & '\uffff';
         }

         if(var4 == 18) {
            Client.field967 = (class90)class88.forOrdinal(class11.method64(), var2);
            if(Client.field967 == null) {
               Client.field967 = class90.field1431;
            }
         }

         if(var4 == 19) {
            if(var2 == -1) {
               Client.field1060 = -1;
            } else {
               Client.field1060 = var2 & 2047;
            }
         }

         if(var4 == 22) {
            Client.field968 = (class90)class88.forOrdinal(class11.method64(), var2);
            if(Client.field968 == null) {
               Client.field968 = class90.field1431;
            }
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1702880281"
   )
   public static boolean method280(int var0) {
      return (var0 >> 21 & 1) != 0;
   }
}
