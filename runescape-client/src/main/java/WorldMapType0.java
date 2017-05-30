import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
@Implements("WorldMapType0")
public class WorldMapType0 implements WorldMapSectionBase {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -924987217
   )
   int field600;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 912616741
   )
   int field601;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -906105067
   )
   int field602;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1837356813
   )
   int field603;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -719619535
   )
   int field604;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1212663407
   )
   int field605;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 729187671
   )
   int field606;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 265890919
   )
   int field607;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -514788839
   )
   int field608;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1994639325
   )
   int field609;
   @ObfuscatedName("og")
   @ObfuscatedGetter(
      intValue = -438866759
   )
   @Export("clanChatCount")
   static int clanChatCount;
   @ObfuscatedName("ps")
   static class109 field611;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = 300230769
   )
   static int field612;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass32;I)V",
      garbageValue = "-228062308"
   )
   public void vmethod715(WorldMapData var1) {
      if(var1.field453 > this.field604) {
         var1.field453 = this.field604;
      }

      if(var1.field454 < this.field604) {
         var1.field454 = this.field604;
      }

      if(var1.field463 > this.field608) {
         var1.field463 = this.field608;
      }

      if(var1.field456 < this.field608) {
         var1.field456 = this.field608;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "437687546"
   )
   public boolean vmethod716(int var1, int var2) {
      return var1 >= (this.field600 << 3) + (this.field604 << 6) && var1 <= (this.field600 << 3) + (this.field604 << 6) + 7 && var2 >= (this.field609 << 3) + (this.field608 << 6) && var2 <= (this.field608 << 6) + (this.field609 << 3) + 7;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "892960012"
   )
   public int[] vmethod717(int var1, int var2, int var3) {
      if(!this.vmethod724(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field600 * 8 - this.field602 * 8 + var2 + (this.field604 * 64 - this.field601 * 64), var3 + (this.field608 * 64 - this.field603 * 64) + (this.field609 * 8 - this.field607 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Lclass212;",
      garbageValue = "-820164631"
   )
   public Coordinates vmethod718(int var1, int var2) {
      if(!this.vmethod716(var1, var2)) {
         return null;
      } else {
         int var3 = var1 + (this.field601 * 64 - this.field604 * 64) + (this.field602 * 8 - this.field600 * 8);
         int var4 = this.field603 * 64 - this.field608 * 64 + var2 + (this.field607 * 8 - this.field609 * 8);
         return new Coordinates(this.field606, var3, var4);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1671424373"
   )
   public void vmethod719(Buffer var1) {
      this.field606 = var1.readUnsignedByte();
      this.field605 = var1.readUnsignedByte();
      this.field601 = var1.readUnsignedShort();
      this.field602 = var1.readUnsignedByte();
      this.field603 = var1.readUnsignedShort();
      this.field607 = var1.readUnsignedByte();
      this.field604 = var1.readUnsignedShort();
      this.field600 = var1.readUnsignedByte();
      this.field608 = var1.readUnsignedShort();
      this.field609 = var1.readUnsignedByte();
      this.method720();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1330348866"
   )
   void method720() {
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-5"
   )
   public boolean vmethod724(int var1, int var2, int var3) {
      return var1 >= this.field606 && var1 < this.field605 + this.field606?var2 >= (this.field602 << 3) + (this.field601 << 6) && var2 <= (this.field602 << 3) + (this.field601 << 6) + 7 && var3 >= (this.field607 << 3) + (this.field603 << 6) && var3 <= (this.field603 << 6) + (this.field607 << 3) + 7:false;
   }

   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-14"
   )
   static void method737() {
      if(class83.field1325 != null) {
         class83.field1325.method5262(Sequence.plane, class166.baseX + (XGrandExchangeOffer.localPlayer.x >> 7), (XGrandExchangeOffer.localPlayer.y >> 7) + class146.baseY, false);
         class83.field1325.method5275();
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IB)I",
      garbageValue = "-40"
   )
   public static int method738(CharSequence var0, int var1) {
      return class217.method4119(var0, var1, true);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass69;II)V",
      garbageValue = "-830429689"
   )
   static void method739(class69 var0, int var1) {
      Object[] var2 = var0.field826;
      Script var3;
      int var7;
      int var8;
      int var9;
      Script var12;
      int var14;
      String var16;
      int var17;
      byte[] var18;
      int var22;
      int var24;
      if(class176.method3440(var0.field825)) {
         Item.field1476 = (class47)var2[0];
         class242 var4 = class242.field3276[Item.field1476.field598];
         class219 var6 = var0.field825;
         var7 = var4.field3279;
         var8 = var4.field3296;
         var9 = (var7 << 8) + var6.field2792;
         var12 = (Script)Script.field1534.get((long)(var9 << 16));
         Script var11;
         if(var12 != null) {
            var11 = var12;
         } else {
            String var13 = String.valueOf(var9);
            var14 = class66.indexScripts.method4189(var13);
            if(var14 == -1) {
               var11 = null;
            } else {
               label1798: {
                  byte[] var15 = class66.indexScripts.method4180(var14);
                  if(var15 != null) {
                     if(var15.length <= 1) {
                        var11 = null;
                        break label1798;
                     }

                     var12 = class19.method144(var15);
                     if(var12 != null) {
                        Script.field1534.put(var12, (long)(var9 << 16));
                        var11 = var12;
                        break label1798;
                     }
                  }

                  var11 = null;
               }
            }
         }

         Script var5;
         if(var11 != null) {
            var5 = var11;
         } else {
            var22 = var6.field2792 + (var8 + '鱀' << 8);
            Script var48 = (Script)Script.field1534.get((long)(var22 << 16));
            Script var23;
            if(var48 != null) {
               var23 = var48;
            } else {
               var16 = String.valueOf(var22);
               var17 = class66.indexScripts.method4189(var16);
               if(var17 == -1) {
                  var23 = null;
               } else {
                  label1713: {
                     var18 = class66.indexScripts.method4180(var17);
                     if(var18 != null) {
                        if(var18.length <= 1) {
                           var23 = null;
                           break label1713;
                        }

                        var48 = class19.method144(var18);
                        if(var48 != null) {
                           Script.field1534.put(var48, (long)(var22 << 16));
                           var23 = var48;
                           break label1713;
                        }
                     }

                     var23 = null;
                  }
               }
            }

            if(var23 != null) {
               var5 = var23;
            } else {
               var5 = null;
            }
         }

         var3 = var5;
      } else {
         var24 = ((Integer)var2[0]).intValue();
         var3 = class90.method1746(var24);
      }

      if(var3 != null) {
         class83.intStackSize = 0;
         ChatMessages.scriptStringStackSize = 0;
         var24 = -1;
         int[] var39 = var3.instructions;
         int[] var40 = var3.intOperands;
         byte var41 = -1;
         class83.scriptStackCount = 0;

         int var10;
         try {
            class83.scriptLocalInts = new int[var3.localIntCount];
            var8 = 0;
            class83.scriptLocalStrings = new String[var3.localStringCount];
            var9 = 0;

            int var25;
            String var43;
            for(var10 = 1; var10 < var2.length; ++var10) {
               if(var2[var10] instanceof Integer) {
                  var25 = ((Integer)var2[var10]).intValue();
                  if(var25 == -2147483647) {
                     var25 = var0.field817;
                  }

                  if(var25 == -2147483646) {
                     var25 = var0.field819;
                  }

                  if(var25 == -2147483645) {
                     var25 = var0.field816 != null?var0.field816.id:-1;
                  }

                  if(var25 == -2147483644) {
                     var25 = var0.field814;
                  }

                  if(var25 == -2147483643) {
                     var25 = var0.field816 != null?var0.field816.index:-1;
                  }

                  if(var25 == -2147483642) {
                     var25 = var0.field820 != null?var0.field820.id:-1;
                  }

                  if(var25 == -2147483641) {
                     var25 = var0.field820 != null?var0.field820.index:-1;
                  }

                  if(var25 == -2147483640) {
                     var25 = var0.field822;
                  }

                  if(var25 == -2147483639) {
                     var25 = var0.field818;
                  }

                  class83.scriptLocalInts[var8++] = var25;
               } else if(var2[var10] instanceof String) {
                  var43 = (String)var2[var10];
                  if(var43.equals("event_opbase")) {
                     var43 = var0.field815;
                  }

                  class83.scriptLocalStrings[var9++] = var43;
               }
            }

            var10 = 0;
            class83.field1321 = var0.field824;

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
                                                                                       label1535:
                                                                                       while(true) {
                                                                                          ++var10;
                                                                                          if(var10 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var24;
                                                                                          var7 = var39[var24];
                                                                                          int var26;
                                                                                          int var27;
                                                                                          int var28;
                                                                                          if(var7 < 100) {
                                                                                             if(var7 != 0) {
                                                                                                if(var7 != 1) {
                                                                                                   if(var7 != 2) {
                                                                                                      if(var7 != 3) {
                                                                                                         if(var7 != 6) {
                                                                                                            if(var7 != 7) {
                                                                                                               if(var7 != 8) {
                                                                                                                  if(var7 != 9) {
                                                                                                                     if(var7 != 10) {
                                                                                                                        if(var7 != 21) {
                                                                                                                           if(var7 != 25) {
                                                                                                                              if(var7 != 27) {
                                                                                                                                 if(var7 != 31) {
                                                                                                                                    if(var7 != 32) {
                                                                                                                                       if(var7 != 33) {
                                                                                                                                          if(var7 != 34) {
                                                                                                                                             if(var7 != 35) {
                                                                                                                                                if(var7 != 36) {
                                                                                                                                                   if(var7 != 37) {
                                                                                                                                                      if(var7 != 38) {
                                                                                                                                                         if(var7 != 39) {
                                                                                                                                                            if(var7 != 40) {
                                                                                                                                                               if(var7 != 42) {
                                                                                                                                                                  if(var7 != 43) {
                                                                                                                                                                     if(var7 == 44) {
                                                                                                                                                                        var25 = var40[var24] >> 16;
                                                                                                                                                                        var26 = var40[var24] & '\uffff';
                                                                                                                                                                        var22 = class83.intStack[--class83.intStackSize];
                                                                                                                                                                        if(var22 >= 0 && var22 <= 5000) {
                                                                                                                                                                           class83.field1322[var25] = var22;
                                                                                                                                                                           byte var74 = -1;
                                                                                                                                                                           if(var26 == 105) {
                                                                                                                                                                              var74 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var27 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var27 >= var22) {
                                                                                                                                                                                 continue label1535;
                                                                                                                                                                              }

                                                                                                                                                                              class83.field1312[var25][var27] = var74;
                                                                                                                                                                              ++var27;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var7 == 45) {
                                                                                                                                                                        var25 = var40[var24];
                                                                                                                                                                        var26 = class83.intStack[--class83.intStackSize];
                                                                                                                                                                        if(var26 < 0 || var26 >= class83.field1322[var25]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class83.intStack[++class83.intStackSize - 1] = class83.field1312[var25][var26];
                                                                                                                                                                     } else if(var7 == 46) {
                                                                                                                                                                        var25 = var40[var24];
                                                                                                                                                                        class83.intStackSize -= 2;
                                                                                                                                                                        var26 = class83.intStack[class83.intStackSize];
                                                                                                                                                                        if(var26 < 0 || var26 >= class83.field1322[var25]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class83.field1312[var25][var26] = class83.intStack[class83.intStackSize + 1];
                                                                                                                                                                     } else if(var7 == 47) {
                                                                                                                                                                        var43 = Client.chatMessages.method1831(var40[var24]);
                                                                                                                                                                        if(var43 == null) {
                                                                                                                                                                           var43 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var43;
                                                                                                                                                                     } else if(var7 == 48) {
                                                                                                                                                                        Client.chatMessages.method1852(var40[var24], class83.scriptStringStack[--ChatMessages.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var7 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        class186 var49 = var3.switches[var40[var24]];
                                                                                                                                                                        class198 var45 = (class198)var49.method3559((long)class83.intStack[--class83.intStackSize]);
                                                                                                                                                                        if(var45 != null) {
                                                                                                                                                                           var24 += var45.field2480;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     Client.chatMessages.method1822(var40[var24], class83.intStack[--class83.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class83.intStack[++class83.intStackSize - 1] = Client.chatMessages.method1823(var40[var24]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var25 = var40[var24];
                                                                                                                                                               var12 = class90.method1746(var25);
                                                                                                                                                               int[] var46 = new int[var12.localIntCount];
                                                                                                                                                               String[] var67 = new String[var12.localStringCount];

                                                                                                                                                               for(var27 = 0; var27 < var12.intStackCount; ++var27) {
                                                                                                                                                                  var46[var27] = class83.intStack[class83.intStackSize - var12.intStackCount + var27];
                                                                                                                                                               }

                                                                                                                                                               for(var27 = 0; var27 < var12.stringStackCount; ++var27) {
                                                                                                                                                                  var67[var27] = class83.scriptStringStack[var27 + (ChatMessages.scriptStringStackSize - var12.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class83.intStackSize -= var12.intStackCount;
                                                                                                                                                               ChatMessages.scriptStringStackSize -= var12.stringStackCount;
                                                                                                                                                               ScriptState var61 = new ScriptState();
                                                                                                                                                               var61.invokedFromScript = var3;
                                                                                                                                                               var61.invokedFromPc = var24;
                                                                                                                                                               var61.savedLocalInts = class83.scriptLocalInts;
                                                                                                                                                               var61.savedLocalStrings = class83.scriptLocalStrings;
                                                                                                                                                               class83.scriptStack[++class83.scriptStackCount - 1] = var61;
                                                                                                                                                               var3 = var12;
                                                                                                                                                               var39 = var12.instructions;
                                                                                                                                                               var40 = var12.intOperands;
                                                                                                                                                               var24 = -1;
                                                                                                                                                               class83.scriptLocalInts = var46;
                                                                                                                                                               class83.scriptLocalStrings = var67;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --ChatMessages.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class83.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var25 = var40[var24];
                                                                                                                                                      ChatMessages.scriptStringStackSize -= var25;
                                                                                                                                                      String var42 = class50.method748(class83.scriptStringStack, ChatMessages.scriptStringStackSize, var25);
                                                                                                                                                      class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var42;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class83.scriptLocalStrings[var40[var24]] = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = class83.scriptLocalStrings[var40[var24]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class83.scriptLocalInts[var40[var24]] = class83.intStack[--class83.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class83.intStack[++class83.intStackSize - 1] = class83.scriptLocalInts[var40[var24]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class83.intStackSize -= 2;
                                                                                                                                       if(class83.intStack[class83.intStackSize] >= class83.intStack[class83.intStackSize + 1]) {
                                                                                                                                          var24 += var40[var24];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class83.intStackSize -= 2;
                                                                                                                                    if(class83.intStack[class83.intStackSize] <= class83.intStack[class83.intStackSize + 1]) {
                                                                                                                                       var24 += var40[var24];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var25 = var40[var24];
                                                                                                                                 var26 = class83.intStack[--class83.intStackSize];
                                                                                                                                 Varbit var44 = class12.method60(var25);
                                                                                                                                 var14 = var44.configId;
                                                                                                                                 var27 = var44.leastSignificantBit;
                                                                                                                                 var28 = var44.mostSignificantBit;
                                                                                                                                 var17 = class211.field2597[var28 - var27];
                                                                                                                                 if(var26 < 0 || var26 > var17) {
                                                                                                                                    var26 = 0;
                                                                                                                                 }

                                                                                                                                 var17 <<= var27;
                                                                                                                                 class211.widgetSettings[var14] = class211.widgetSettings[var14] & ~var17 | var26 << var27 & var17;
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var25 = var40[var24];
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = Actor.method1539(var25);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class83.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var47 = class83.scriptStack[--class83.scriptStackCount];
                                                                                                                           var3 = var47.invokedFromScript;
                                                                                                                           var39 = var3.instructions;
                                                                                                                           var40 = var3.intOperands;
                                                                                                                           var24 = var47.invokedFromPc;
                                                                                                                           class83.scriptLocalInts = var47.savedLocalInts;
                                                                                                                           class83.scriptLocalStrings = var47.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class83.intStackSize -= 2;
                                                                                                                        if(class83.intStack[class83.intStackSize] > class83.intStack[class83.intStackSize + 1]) {
                                                                                                                           var24 += var40[var24];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class83.intStackSize -= 2;
                                                                                                                     if(class83.intStack[class83.intStackSize] < class83.intStack[class83.intStackSize + 1]) {
                                                                                                                        var24 += var40[var24];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class83.intStackSize -= 2;
                                                                                                                  if(class83.intStack[class83.intStackSize] == class83.intStack[class83.intStackSize + 1]) {
                                                                                                                     var24 += var40[var24];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class83.intStackSize -= 2;
                                                                                                               if(class83.intStack[class83.intStackSize + 1] != class83.intStack[class83.intStackSize]) {
                                                                                                                  var24 += var40[var24];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var24 += var40[var24];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var3.stringOperands[var24];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var25 = var40[var24];
                                                                                                      class211.widgetSettings[var25] = class83.intStack[--class83.intStackSize];
                                                                                                      class45.method676(var25);
                                                                                                   }
                                                                                                } else {
                                                                                                   var25 = var40[var24];
                                                                                                   class83.intStack[++class83.intStackSize - 1] = class211.widgetSettings[var25];
                                                                                                }
                                                                                             } else {
                                                                                                class83.intStack[++class83.intStackSize - 1] = var40[var24];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var72;
                                                                                             if(var3.intOperands[var24] == 1) {
                                                                                                var72 = true;
                                                                                             } else {
                                                                                                var72 = false;
                                                                                             }

                                                                                             if(var7 < 1000) {
                                                                                                var26 = class7.method25(var7, var3, var72);
                                                                                             } else if(var7 < 1100) {
                                                                                                var26 = MessageNode.method1128(var7, var3, var72);
                                                                                             } else if(var7 < 1200) {
                                                                                                var26 = WidgetNode.method1105(var7, var3, var72);
                                                                                             } else if(var7 < 1300) {
                                                                                                var26 = class14.method74(var7, var3, var72);
                                                                                             } else if(var7 < 1400) {
                                                                                                var26 = RSSocket.method3054(var7, var3, var72);
                                                                                             } else if(var7 < 1500) {
                                                                                                var26 = Client.method1510(var7, var3, var72);
                                                                                             } else {
                                                                                                Widget var29;
                                                                                                byte var62;
                                                                                                if(var7 < 1600) {
                                                                                                   var29 = var72?class83.field1311:Buffer.field2384;
                                                                                                   if(var7 == 1500) {
                                                                                                      class83.intStack[++class83.intStackSize - 1] = var29.relativeX;
                                                                                                      var62 = 1;
                                                                                                   } else if(var7 == 1501) {
                                                                                                      class83.intStack[++class83.intStackSize - 1] = var29.relativeY;
                                                                                                      var62 = 1;
                                                                                                   } else if(var7 == 1502) {
                                                                                                      class83.intStack[++class83.intStackSize - 1] = var29.width;
                                                                                                      var62 = 1;
                                                                                                   } else if(var7 == 1503) {
                                                                                                      class83.intStack[++class83.intStackSize - 1] = var29.height;
                                                                                                      var62 = 1;
                                                                                                   } else if(var7 == 1504) {
                                                                                                      class83.intStack[++class83.intStackSize - 1] = var29.isHidden?1:0;
                                                                                                      var62 = 1;
                                                                                                   } else if(var7 == 1505) {
                                                                                                      class83.intStack[++class83.intStackSize - 1] = var29.parentId;
                                                                                                      var62 = 1;
                                                                                                   } else {
                                                                                                      var62 = 2;
                                                                                                   }

                                                                                                   var26 = var62;
                                                                                                } else if(var7 < 1700) {
                                                                                                   var26 = class36.method498(var7, var3, var72);
                                                                                                } else if(var7 < 1800) {
                                                                                                   var26 = class12.method58(var7, var3, var72);
                                                                                                } else {
                                                                                                   int var30;
                                                                                                   int[] var50;
                                                                                                   Widget var63;
                                                                                                   if(var7 < 1900) {
                                                                                                      var63 = var72?class83.field1311:Buffer.field2384;
                                                                                                      if(var7 == 1800) {
                                                                                                         var50 = class83.intStack;
                                                                                                         var28 = ++class83.intStackSize - 1;
                                                                                                         var30 = class43.method626(var63);
                                                                                                         var17 = var30 >> 11 & 63;
                                                                                                         var50[var28] = var17;
                                                                                                         var62 = 1;
                                                                                                      } else if(var7 != 1801) {
                                                                                                         if(var7 == 1802) {
                                                                                                            if(var63.name == null) {
                                                                                                               class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
                                                                                                            } else {
                                                                                                               class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var63.name;
                                                                                                            }

                                                                                                            var62 = 1;
                                                                                                         } else {
                                                                                                            var62 = 2;
                                                                                                         }
                                                                                                      } else {
                                                                                                         var27 = class83.intStack[--class83.intStackSize];
                                                                                                         --var27;
                                                                                                         if(var63.actions != null && var27 < var63.actions.length && var63.actions[var27] != null) {
                                                                                                            class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var63.actions[var27];
                                                                                                         } else {
                                                                                                            class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
                                                                                                         }

                                                                                                         var62 = 1;
                                                                                                      }

                                                                                                      var26 = var62;
                                                                                                   } else if(var7 < 2000) {
                                                                                                      var26 = class73.method1135(var7, var3, var72);
                                                                                                   } else if(var7 < 2100) {
                                                                                                      var26 = MessageNode.method1128(var7, var3, var72);
                                                                                                   } else if(var7 < 2200) {
                                                                                                      var26 = WidgetNode.method1105(var7, var3, var72);
                                                                                                   } else if(var7 < 2300) {
                                                                                                      var26 = class14.method74(var7, var3, var72);
                                                                                                   } else if(var7 < 2400) {
                                                                                                      var26 = RSSocket.method3054(var7, var3, var72);
                                                                                                   } else if(var7 < 2500) {
                                                                                                      var26 = Client.method1510(var7, var3, var72);
                                                                                                   } else if(var7 < 2600) {
                                                                                                      var26 = class31.method267(var7, var3, var72);
                                                                                                   } else if(var7 < 2700) {
                                                                                                      var63 = class261.method4792(class83.intStack[--class83.intStackSize]);
                                                                                                      if(var7 == 2600) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var63.scrollX;
                                                                                                         var62 = 1;
                                                                                                      } else if(var7 == 2601) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var63.scrollY;
                                                                                                         var62 = 1;
                                                                                                      } else if(var7 == 2602) {
                                                                                                         class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var63.text;
                                                                                                         var62 = 1;
                                                                                                      } else if(var7 == 2603) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var63.scrollWidth;
                                                                                                         var62 = 1;
                                                                                                      } else if(var7 == 2604) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var63.scrollHeight;
                                                                                                         var62 = 1;
                                                                                                      } else if(var7 == 2605) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var63.field2696;
                                                                                                         var62 = 1;
                                                                                                      } else if(var7 == 2606) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var63.rotationX;
                                                                                                         var62 = 1;
                                                                                                      } else if(var7 == 2607) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var63.rotationY;
                                                                                                         var62 = 1;
                                                                                                      } else if(var7 == 2608) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var63.rotationZ;
                                                                                                         var62 = 1;
                                                                                                      } else if(var7 == 2609) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var63.opacity;
                                                                                                         var62 = 1;
                                                                                                      } else if(var7 == 2610) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var63.field2734;
                                                                                                         var62 = 1;
                                                                                                      } else if(var7 == 2611) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var63.textColor;
                                                                                                         var62 = 1;
                                                                                                      } else if(var7 == 2612) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var63.field2668;
                                                                                                         var62 = 1;
                                                                                                      } else if(var7 == 2613) {
                                                                                                         class83.intStack[++class83.intStackSize - 1] = var63.field2672.vmethod5090();
                                                                                                         var62 = 1;
                                                                                                      } else {
                                                                                                         var62 = 2;
                                                                                                      }

                                                                                                      var26 = var62;
                                                                                                   } else if(var7 < 2800) {
                                                                                                      var26 = class23.method163(var7, var3, var72);
                                                                                                   } else if(var7 < 2900) {
                                                                                                      var63 = class261.method4792(class83.intStack[--class83.intStackSize]);
                                                                                                      if(var7 == 2800) {
                                                                                                         var50 = class83.intStack;
                                                                                                         var28 = ++class83.intStackSize - 1;
                                                                                                         var30 = class43.method626(var63);
                                                                                                         var17 = var30 >> 11 & 63;
                                                                                                         var50[var28] = var17;
                                                                                                         var62 = 1;
                                                                                                      } else if(var7 != 2801) {
                                                                                                         if(var7 == 2802) {
                                                                                                            if(var63.name == null) {
                                                                                                               class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
                                                                                                            } else {
                                                                                                               class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var63.name;
                                                                                                            }

                                                                                                            var62 = 1;
                                                                                                         } else {
                                                                                                            var62 = 2;
                                                                                                         }
                                                                                                      } else {
                                                                                                         var27 = class83.intStack[--class83.intStackSize];
                                                                                                         --var27;
                                                                                                         if(var63.actions != null && var27 < var63.actions.length && var63.actions[var27] != null) {
                                                                                                            class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var63.actions[var27];
                                                                                                         } else {
                                                                                                            class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
                                                                                                         }

                                                                                                         var62 = 1;
                                                                                                      }

                                                                                                      var26 = var62;
                                                                                                   } else if(var7 < 3000) {
                                                                                                      var26 = class73.method1135(var7, var3, var72);
                                                                                                   } else {
                                                                                                      int var19;
                                                                                                      boolean var68;
                                                                                                      if(var7 < 3200) {
                                                                                                         String var64;
                                                                                                         if(var7 == 3100) {
                                                                                                            var64 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
                                                                                                            GameObject.sendGameMessage(0, "", var64);
                                                                                                            var62 = 1;
                                                                                                         } else if(var7 == 3101) {
                                                                                                            class83.intStackSize -= 2;
                                                                                                            class44.method644(XGrandExchangeOffer.localPlayer, class83.intStack[class83.intStackSize], class83.intStack[class83.intStackSize + 1]);
                                                                                                            var62 = 1;
                                                                                                         } else if(var7 == 3103) {
                                                                                                            Friend.method1097();
                                                                                                            var62 = 1;
                                                                                                         } else if(var7 == 3104) {
                                                                                                            var64 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
                                                                                                            var27 = 0;
                                                                                                            if(class269.method4931(var64)) {
                                                                                                               var27 = Friend.method1098(var64);
                                                                                                            }

                                                                                                            Client.secretPacketBuffer1.putOpcode(120);
                                                                                                            Client.secretPacketBuffer1.putInt(var27);
                                                                                                            var62 = 1;
                                                                                                         } else if(var7 == 3105) {
                                                                                                            var64 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
                                                                                                            Client.secretPacketBuffer1.putOpcode(54);
                                                                                                            Client.secretPacketBuffer1.putByte(var64.length() + 1);
                                                                                                            Client.secretPacketBuffer1.method3191(var64);
                                                                                                            var62 = 1;
                                                                                                         } else if(var7 == 3106) {
                                                                                                            var64 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
                                                                                                            Client.secretPacketBuffer1.putOpcode(204);
                                                                                                            Client.secretPacketBuffer1.putByte(var64.length() + 1);
                                                                                                            Client.secretPacketBuffer1.method3191(var64);
                                                                                                            var62 = 1;
                                                                                                         } else {
                                                                                                            String var52;
                                                                                                            if(var7 != 3107) {
                                                                                                               if(var7 == 3108) {
                                                                                                                  class83.intStackSize -= 3;
                                                                                                                  var14 = class83.intStack[class83.intStackSize];
                                                                                                                  var27 = class83.intStack[class83.intStackSize + 1];
                                                                                                                  var28 = class83.intStack[class83.intStackSize + 2];
                                                                                                                  var29 = class261.method4792(var28);
                                                                                                                  Ignore.method1120(var29, var14, var27);
                                                                                                                  var62 = 1;
                                                                                                               } else if(var7 == 3109) {
                                                                                                                  class83.intStackSize -= 2;
                                                                                                                  var14 = class83.intStack[class83.intStackSize];
                                                                                                                  var27 = class83.intStack[class83.intStackSize + 1];
                                                                                                                  Widget var51 = var72?class83.field1311:Buffer.field2384;
                                                                                                                  Ignore.method1120(var51, var14, var27);
                                                                                                                  var62 = 1;
                                                                                                               } else if(var7 == 3110) {
                                                                                                                  class149.field2178 = class83.intStack[--class83.intStackSize] == 1;
                                                                                                                  var62 = 1;
                                                                                                               } else if(var7 == 3111) {
                                                                                                                  class83.intStack[++class83.intStackSize - 1] = class134.field1989.field1284?1:0;
                                                                                                                  var62 = 1;
                                                                                                               } else if(var7 == 3112) {
                                                                                                                  class134.field1989.field1284 = class83.intStack[--class83.intStackSize] == 1;
                                                                                                                  GroundObject.method2523();
                                                                                                                  var62 = 1;
                                                                                                               } else if(var7 == 3113) {
                                                                                                                  var64 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
                                                                                                                  var68 = class83.intStack[--class83.intStackSize] == 1;
                                                                                                                  class11.method47(var64, var68, false);
                                                                                                                  var62 = 1;
                                                                                                               } else if(var7 == 3115) {
                                                                                                                  var14 = class83.intStack[--class83.intStackSize];
                                                                                                                  Client.secretPacketBuffer1.putOpcode(224);
                                                                                                                  Client.secretPacketBuffer1.putShort(var14);
                                                                                                                  var62 = 1;
                                                                                                               } else if(var7 == 3116) {
                                                                                                                  var14 = class83.intStack[--class83.intStackSize];
                                                                                                                  ChatMessages.scriptStringStackSize -= 2;
                                                                                                                  var52 = class83.scriptStringStack[ChatMessages.scriptStringStackSize];
                                                                                                                  var16 = class83.scriptStringStack[ChatMessages.scriptStringStackSize + 1];
                                                                                                                  if(var52.length() > 500) {
                                                                                                                     var62 = 1;
                                                                                                                  } else if(var16.length() > 500) {
                                                                                                                     var62 = 1;
                                                                                                                  } else {
                                                                                                                     Client.secretPacketBuffer1.putOpcode(239);
                                                                                                                     Client.secretPacketBuffer1.putShort(class46.method711(var52) + 1 + class46.method711(var16));
                                                                                                                     Client.secretPacketBuffer1.method3191(var52);
                                                                                                                     Client.secretPacketBuffer1.method3191(var16);
                                                                                                                     Client.secretPacketBuffer1.putByte(var14);
                                                                                                                     var62 = 1;
                                                                                                                  }
                                                                                                               } else if(var7 == 3117) {
                                                                                                                  Client.field1005 = class83.intStack[--class83.intStackSize] == 1;
                                                                                                                  var62 = 1;
                                                                                                               } else {
                                                                                                                  var62 = 2;
                                                                                                               }
                                                                                                            } else {
                                                                                                               var14 = class83.intStack[--class83.intStackSize];
                                                                                                               var52 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
                                                                                                               var28 = class96.field1489;
                                                                                                               int[] var69 = class96.field1496;
                                                                                                               boolean var71 = false;

                                                                                                               for(var19 = 0; var19 < var28; ++var19) {
                                                                                                                  Player var20 = Client.cachedPlayers[var69[var19]];
                                                                                                                  if(var20 != null && XGrandExchangeOffer.localPlayer != var20 && var20.name != null && var20.name.equalsIgnoreCase(var52)) {
                                                                                                                     if(var14 == 1) {
                                                                                                                        Client.secretPacketBuffer1.putOpcode(207);
                                                                                                                        Client.secretPacketBuffer1.method3225(0);
                                                                                                                        Client.secretPacketBuffer1.method3234(var69[var19]);
                                                                                                                     } else if(var14 == 4) {
                                                                                                                        Client.secretPacketBuffer1.putOpcode(34);
                                                                                                                        Client.secretPacketBuffer1.putShort(var69[var19]);
                                                                                                                        Client.secretPacketBuffer1.method3225(0);
                                                                                                                     } else if(var14 == 6) {
                                                                                                                        Client.secretPacketBuffer1.putOpcode(139);
                                                                                                                        Client.secretPacketBuffer1.method3223(0);
                                                                                                                        Client.secretPacketBuffer1.putShort(var69[var19]);
                                                                                                                     } else if(var14 == 7) {
                                                                                                                        Client.secretPacketBuffer1.putOpcode(69);
                                                                                                                        Client.secretPacketBuffer1.method3382(var69[var19]);
                                                                                                                        Client.secretPacketBuffer1.method3225(0);
                                                                                                                     }

                                                                                                                     var71 = true;
                                                                                                                     break;
                                                                                                                  }
                                                                                                               }

                                                                                                               if(!var71) {
                                                                                                                  GameObject.sendGameMessage(4, "", "Unable to find " + var52);
                                                                                                               }

                                                                                                               var62 = 1;
                                                                                                            }
                                                                                                         }

                                                                                                         var26 = var62;
                                                                                                      } else if(var7 < 3300) {
                                                                                                         if(var7 == 3200) {
                                                                                                            class83.intStackSize -= 3;
                                                                                                            var14 = class83.intStack[class83.intStackSize];
                                                                                                            var27 = class83.intStack[class83.intStackSize + 1];
                                                                                                            var28 = class83.intStack[class83.intStackSize + 2];
                                                                                                            if(Client.field1129 != 0 && var27 != 0 && Client.field1131 < 50) {
                                                                                                               Client.field1132[Client.field1131] = var14;
                                                                                                               Client.field1009[Client.field1131] = var27;
                                                                                                               Client.field1134[Client.field1131] = var28;
                                                                                                               Client.field1136[Client.field1131] = null;
                                                                                                               Client.field1135[Client.field1131] = 0;
                                                                                                               ++Client.field1131;
                                                                                                            }

                                                                                                            var62 = 1;
                                                                                                         } else if(var7 != 3201) {
                                                                                                            if(var7 == 3202) {
                                                                                                               class83.intStackSize -= 2;
                                                                                                               var14 = class83.intStack[class83.intStackSize];
                                                                                                               var27 = class83.intStack[class83.intStackSize + 1];
                                                                                                               if(Client.field1077 != 0 && var14 != -1) {
                                                                                                                  WorldMapData.method322(class33.indexTrack2, var14, 0, Client.field1077, false);
                                                                                                                  Client.field1109 = true;
                                                                                                               }

                                                                                                               var62 = 1;
                                                                                                            } else {
                                                                                                               var62 = 2;
                                                                                                            }
                                                                                                         } else {
                                                                                                            var14 = class83.intStack[--class83.intStackSize];
                                                                                                            if(var14 == -1 && !Client.field1109) {
                                                                                                               class36.field501.method3801();
                                                                                                               class203.field2498 = 1;
                                                                                                               Varbit.field3380 = null;
                                                                                                            } else if(var14 != -1 && var14 != Client.field1127 && Client.field1077 != 0 && !Client.field1109) {
                                                                                                               class13.method62(2, class44.indexTrack1, var14, 0, Client.field1077, false);
                                                                                                            }

                                                                                                            Client.field1127 = var14;
                                                                                                            var62 = 1;
                                                                                                         }

                                                                                                         var26 = var62;
                                                                                                      } else {
                                                                                                         int var32;
                                                                                                         if(var7 < 3400) {
                                                                                                            if(var7 == 3300) {
                                                                                                               class83.intStack[++class83.intStackSize - 1] = Client.gameCycle;
                                                                                                               var62 = 1;
                                                                                                            } else {
                                                                                                               XItemContainer var31;
                                                                                                               int[] var53;
                                                                                                               if(var7 == 3301) {
                                                                                                                  class83.intStackSize -= 2;
                                                                                                                  var14 = class83.intStack[class83.intStackSize];
                                                                                                                  var27 = class83.intStack[class83.intStackSize + 1];
                                                                                                                  var53 = class83.intStack;
                                                                                                                  var17 = ++class83.intStackSize - 1;
                                                                                                                  var31 = (XItemContainer)XItemContainer.itemContainers.method3615((long)var14);
                                                                                                                  if(var31 == null) {
                                                                                                                     var30 = -1;
                                                                                                                  } else if(var27 >= 0 && var27 < var31.itemIds.length) {
                                                                                                                     var30 = var31.itemIds[var27];
                                                                                                                  } else {
                                                                                                                     var30 = -1;
                                                                                                                  }

                                                                                                                  var53[var17] = var30;
                                                                                                                  var62 = 1;
                                                                                                               } else if(var7 == 3302) {
                                                                                                                  class83.intStackSize -= 2;
                                                                                                                  var14 = class83.intStack[class83.intStackSize];
                                                                                                                  var27 = class83.intStack[class83.intStackSize + 1];
                                                                                                                  class83.intStack[++class83.intStackSize - 1] = class51.method772(var14, var27);
                                                                                                                  var62 = 1;
                                                                                                               } else {
                                                                                                                  int var21;
                                                                                                                  if(var7 == 3303) {
                                                                                                                     class83.intStackSize -= 2;
                                                                                                                     var14 = class83.intStack[class83.intStackSize];
                                                                                                                     var27 = class83.intStack[class83.intStackSize + 1];
                                                                                                                     var53 = class83.intStack;
                                                                                                                     var17 = ++class83.intStackSize - 1;
                                                                                                                     var31 = (XItemContainer)XItemContainer.itemContainers.method3615((long)var14);
                                                                                                                     if(var31 == null) {
                                                                                                                        var30 = 0;
                                                                                                                     } else if(var27 == -1) {
                                                                                                                        var30 = 0;
                                                                                                                     } else {
                                                                                                                        var32 = 0;

                                                                                                                        for(var21 = 0; var21 < var31.stackSizes.length; ++var21) {
                                                                                                                           if(var31.itemIds[var21] == var27) {
                                                                                                                              var32 += var31.stackSizes[var21];
                                                                                                                           }
                                                                                                                        }

                                                                                                                        var30 = var32;
                                                                                                                     }

                                                                                                                     var53[var17] = var30;
                                                                                                                     var62 = 1;
                                                                                                                  } else if(var7 == 3304) {
                                                                                                                     var14 = class83.intStack[--class83.intStackSize];
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = class44.method650(var14).field3267;
                                                                                                                     var62 = 1;
                                                                                                                  } else if(var7 == 3305) {
                                                                                                                     var14 = class83.intStack[--class83.intStackSize];
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = Client.boostedSkillLevels[var14];
                                                                                                                     var62 = 1;
                                                                                                                  } else if(var7 == 3306) {
                                                                                                                     var14 = class83.intStack[--class83.intStackSize];
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = Client.realSkillLevels[var14];
                                                                                                                     var62 = 1;
                                                                                                                  } else if(var7 == 3307) {
                                                                                                                     var14 = class83.intStack[--class83.intStackSize];
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = Client.skillExperiences[var14];
                                                                                                                     var62 = 1;
                                                                                                                  } else if(var7 == 3308) {
                                                                                                                     var14 = Sequence.plane;
                                                                                                                     var27 = (XGrandExchangeOffer.localPlayer.x >> 7) + class166.baseX;
                                                                                                                     var28 = class146.baseY + (XGrandExchangeOffer.localPlayer.y >> 7);
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = (var27 << 14) + (var14 << 28) + var28;
                                                                                                                     var62 = 1;
                                                                                                                  } else if(var7 == 3309) {
                                                                                                                     var14 = class83.intStack[--class83.intStackSize];
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = var14 >> 14 & 16383;
                                                                                                                     var62 = 1;
                                                                                                                  } else if(var7 == 3310) {
                                                                                                                     var14 = class83.intStack[--class83.intStackSize];
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = var14 >> 28;
                                                                                                                     var62 = 1;
                                                                                                                  } else if(var7 == 3311) {
                                                                                                                     var14 = class83.intStack[--class83.intStackSize];
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = var14 & 16383;
                                                                                                                     var62 = 1;
                                                                                                                  } else if(var7 == 3312) {
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = Client.isMembers?1:0;
                                                                                                                     var62 = 1;
                                                                                                                  } else if(var7 == 3313) {
                                                                                                                     class83.intStackSize -= 2;
                                                                                                                     var14 = class83.intStack[class83.intStackSize] + '耀';
                                                                                                                     var27 = class83.intStack[class83.intStackSize + 1];
                                                                                                                     var53 = class83.intStack;
                                                                                                                     var17 = ++class83.intStackSize - 1;
                                                                                                                     var31 = (XItemContainer)XItemContainer.itemContainers.method3615((long)var14);
                                                                                                                     if(var31 == null) {
                                                                                                                        var30 = -1;
                                                                                                                     } else if(var27 >= 0 && var27 < var31.itemIds.length) {
                                                                                                                        var30 = var31.itemIds[var27];
                                                                                                                     } else {
                                                                                                                        var30 = -1;
                                                                                                                     }

                                                                                                                     var53[var17] = var30;
                                                                                                                     var62 = 1;
                                                                                                                  } else if(var7 == 3314) {
                                                                                                                     class83.intStackSize -= 2;
                                                                                                                     var14 = class83.intStack[class83.intStackSize] + '耀';
                                                                                                                     var27 = class83.intStack[class83.intStackSize + 1];
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = class51.method772(var14, var27);
                                                                                                                     var62 = 1;
                                                                                                                  } else if(var7 != 3315) {
                                                                                                                     if(var7 == 3316) {
                                                                                                                        if(Client.field1057 >= 2) {
                                                                                                                           class83.intStack[++class83.intStackSize - 1] = Client.field1057;
                                                                                                                        } else {
                                                                                                                           class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                        }

                                                                                                                        var62 = 1;
                                                                                                                     } else if(var7 == 3317) {
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = Client.field906;
                                                                                                                        var62 = 1;
                                                                                                                     } else if(var7 == 3318) {
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = Client.world;
                                                                                                                        var62 = 1;
                                                                                                                     } else if(var7 == 3321) {
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = Client.energy;
                                                                                                                        var62 = 1;
                                                                                                                     } else if(var7 == 3322) {
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = Client.weight;
                                                                                                                        var62 = 1;
                                                                                                                     } else if(var7 == 3323) {
                                                                                                                        if(Client.field1059) {
                                                                                                                           class83.intStack[++class83.intStackSize - 1] = 1;
                                                                                                                        } else {
                                                                                                                           class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                        }

                                                                                                                        var62 = 1;
                                                                                                                     } else if(var7 == 3324) {
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = Client.flags;
                                                                                                                        var62 = 1;
                                                                                                                     } else if(var7 == 3325) {
                                                                                                                        class83.intStackSize -= 4;
                                                                                                                        var14 = class83.intStack[class83.intStackSize];
                                                                                                                        var27 = class83.intStack[class83.intStackSize + 1];
                                                                                                                        var28 = class83.intStack[class83.intStackSize + 2];
                                                                                                                        var17 = class83.intStack[class83.intStackSize + 3];
                                                                                                                        var14 += var27 << 14;
                                                                                                                        var14 += var28 << 28;
                                                                                                                        var14 += var17;
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = var14;
                                                                                                                        var62 = 1;
                                                                                                                     } else {
                                                                                                                        var62 = 2;
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class83.intStackSize -= 2;
                                                                                                                     var14 = class83.intStack[class83.intStackSize] + '耀';
                                                                                                                     var27 = class83.intStack[class83.intStackSize + 1];
                                                                                                                     var53 = class83.intStack;
                                                                                                                     var17 = ++class83.intStackSize - 1;
                                                                                                                     var31 = (XItemContainer)XItemContainer.itemContainers.method3615((long)var14);
                                                                                                                     if(var31 == null) {
                                                                                                                        var30 = 0;
                                                                                                                     } else if(var27 == -1) {
                                                                                                                        var30 = 0;
                                                                                                                     } else {
                                                                                                                        var32 = 0;

                                                                                                                        for(var21 = 0; var21 < var31.stackSizes.length; ++var21) {
                                                                                                                           if(var31.itemIds[var21] == var27) {
                                                                                                                              var32 += var31.stackSizes[var21];
                                                                                                                           }
                                                                                                                        }

                                                                                                                        var30 = var32;
                                                                                                                     }

                                                                                                                     var53[var17] = var30;
                                                                                                                     var62 = 1;
                                                                                                                  }
                                                                                                               }
                                                                                                            }

                                                                                                            var26 = var62;
                                                                                                         } else if(var7 < 3500) {
                                                                                                            if(var7 == 3400) {
                                                                                                               class83.intStackSize -= 2;
                                                                                                               var14 = class83.intStack[class83.intStackSize];
                                                                                                               var27 = class83.intStack[class83.intStackSize + 1];
                                                                                                               class253 var70 = (class253)class253.field3393.get((long)var14);
                                                                                                               class253 var55;
                                                                                                               if(var70 != null) {
                                                                                                                  var55 = var70;
                                                                                                               } else {
                                                                                                                  var18 = class253.field3400.getConfigData(8, var14);
                                                                                                                  var70 = new class253();
                                                                                                                  if(var18 != null) {
                                                                                                                     var70.method4530(new Buffer(var18));
                                                                                                                  }

                                                                                                                  class253.field3393.put(var70, (long)var14);
                                                                                                                  var55 = var70;
                                                                                                               }

                                                                                                               var70 = var55;
                                                                                                               if(var55.field3396 != 115) {
                                                                                                                  ;
                                                                                                               }

                                                                                                               for(var30 = 0; var30 < var70.field3394; ++var30) {
                                                                                                                  if(var27 == var70.field3397[var30]) {
                                                                                                                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var70.field3402[var30];
                                                                                                                     var70 = null;
                                                                                                                     break;
                                                                                                                  }
                                                                                                               }

                                                                                                               if(var70 != null) {
                                                                                                                  class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var70.field3399;
                                                                                                               }

                                                                                                               var62 = 1;
                                                                                                            } else if(var7 == 3408) {
                                                                                                               class83.intStackSize -= 4;
                                                                                                               var14 = class83.intStack[class83.intStackSize];
                                                                                                               var27 = class83.intStack[class83.intStackSize + 1];
                                                                                                               var28 = class83.intStack[class83.intStackSize + 2];
                                                                                                               var17 = class83.intStack[class83.intStackSize + 3];
                                                                                                               class253 var73 = (class253)class253.field3393.get((long)var28);
                                                                                                               class253 var56;
                                                                                                               if(var73 != null) {
                                                                                                                  var56 = var73;
                                                                                                               } else {
                                                                                                                  byte[] var60 = class253.field3400.getConfigData(8, var28);
                                                                                                                  var73 = new class253();
                                                                                                                  if(var60 != null) {
                                                                                                                     var73.method4530(new Buffer(var60));
                                                                                                                  }

                                                                                                                  class253.field3393.put(var73, (long)var28);
                                                                                                                  var56 = var73;
                                                                                                               }

                                                                                                               var73 = var56;
                                                                                                               if(var56.field3395 == var14 && var27 == var56.field3396) {
                                                                                                                  for(var32 = 0; var32 < var73.field3394; ++var32) {
                                                                                                                     if(var73.field3397[var32] == var17) {
                                                                                                                        if(var27 == 115) {
                                                                                                                           class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var73.field3402[var32];
                                                                                                                        } else {
                                                                                                                           class83.intStack[++class83.intStackSize - 1] = var73.field3401[var32];
                                                                                                                        }

                                                                                                                        var73 = null;
                                                                                                                        break;
                                                                                                                     }
                                                                                                                  }

                                                                                                                  if(var73 != null) {
                                                                                                                     if(var27 == 115) {
                                                                                                                        class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var73.field3399;
                                                                                                                     } else {
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = var73.field3398;
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var62 = 1;
                                                                                                               } else {
                                                                                                                  if(var27 == 115) {
                                                                                                                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "null";
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var62 = 1;
                                                                                                               }
                                                                                                            } else {
                                                                                                               var62 = 2;
                                                                                                            }

                                                                                                            var26 = var62;
                                                                                                         } else if(var7 < 3700) {
                                                                                                            var26 = WorldMapType2.method540(var7, var3, var72);
                                                                                                         } else if(var7 < 4000) {
                                                                                                            if(var7 == 3903) {
                                                                                                               var14 = class83.intStack[--class83.intStackSize];
                                                                                                               class83.intStack[++class83.intStackSize - 1] = Client.grandExchangeOffers[var14].method96();
                                                                                                               var62 = 1;
                                                                                                            } else if(var7 == 3904) {
                                                                                                               var14 = class83.intStack[--class83.intStackSize];
                                                                                                               class83.intStack[++class83.intStackSize - 1] = Client.grandExchangeOffers[var14].itemId;
                                                                                                               var62 = 1;
                                                                                                            } else if(var7 == 3905) {
                                                                                                               var14 = class83.intStack[--class83.intStackSize];
                                                                                                               class83.intStack[++class83.intStackSize - 1] = Client.grandExchangeOffers[var14].price;
                                                                                                               var62 = 1;
                                                                                                            } else if(var7 == 3906) {
                                                                                                               var14 = class83.intStack[--class83.intStackSize];
                                                                                                               class83.intStack[++class83.intStackSize - 1] = Client.grandExchangeOffers[var14].totalQuantity;
                                                                                                               var62 = 1;
                                                                                                            } else if(var7 == 3907) {
                                                                                                               var14 = class83.intStack[--class83.intStackSize];
                                                                                                               class83.intStack[++class83.intStackSize - 1] = Client.grandExchangeOffers[var14].quantitySold;
                                                                                                               var62 = 1;
                                                                                                            } else if(var7 == 3908) {
                                                                                                               var14 = class83.intStack[--class83.intStackSize];
                                                                                                               class83.intStack[++class83.intStackSize - 1] = Client.grandExchangeOffers[var14].spent;
                                                                                                               var62 = 1;
                                                                                                            } else if(var7 == 3910) {
                                                                                                               var14 = class83.intStack[--class83.intStackSize];
                                                                                                               var27 = Client.grandExchangeOffers[var14].method111();
                                                                                                               class83.intStack[++class83.intStackSize - 1] = var27 == 0?1:0;
                                                                                                               var62 = 1;
                                                                                                            } else if(var7 == 3911) {
                                                                                                               var14 = class83.intStack[--class83.intStackSize];
                                                                                                               var27 = Client.grandExchangeOffers[var14].method111();
                                                                                                               class83.intStack[++class83.intStackSize - 1] = var27 == 2?1:0;
                                                                                                               var62 = 1;
                                                                                                            } else if(var7 == 3912) {
                                                                                                               var14 = class83.intStack[--class83.intStackSize];
                                                                                                               var27 = Client.grandExchangeOffers[var14].method111();
                                                                                                               class83.intStack[++class83.intStackSize - 1] = var27 == 5?1:0;
                                                                                                               var62 = 1;
                                                                                                            } else if(var7 == 3913) {
                                                                                                               var14 = class83.intStack[--class83.intStackSize];
                                                                                                               var27 = Client.grandExchangeOffers[var14].method111();
                                                                                                               class83.intStack[++class83.intStackSize - 1] = var27 == 1?1:0;
                                                                                                               var62 = 1;
                                                                                                            } else {
                                                                                                               boolean var65;
                                                                                                               if(var7 == 3914) {
                                                                                                                  var65 = class83.intStack[--class83.intStackSize] == 1;
                                                                                                                  if(class176.field2402 != null) {
                                                                                                                     class176.field2402.method63(class13.field280, var65);
                                                                                                                  }

                                                                                                                  var62 = 1;
                                                                                                               } else if(var7 == 3915) {
                                                                                                                  var65 = class83.intStack[--class83.intStackSize] == 1;
                                                                                                                  if(class176.field2402 != null) {
                                                                                                                     class176.field2402.method63(class13.field282, var65);
                                                                                                                  }

                                                                                                                  var62 = 1;
                                                                                                               } else if(var7 == 3916) {
                                                                                                                  class83.intStackSize -= 2;
                                                                                                                  var65 = class83.intStack[class83.intStackSize] == 1;
                                                                                                                  var68 = class83.intStack[class83.intStackSize + 1] == 1;
                                                                                                                  if(class176.field2402 != null) {
                                                                                                                     class176.field2402.method63(new class95(var68), var65);
                                                                                                                  }

                                                                                                                  var62 = 1;
                                                                                                               } else if(var7 == 3917) {
                                                                                                                  var65 = class83.intStack[--class83.intStackSize] == 1;
                                                                                                                  if(class176.field2402 != null) {
                                                                                                                     class176.field2402.method63(class13.field278, var65);
                                                                                                                  }

                                                                                                                  var62 = 1;
                                                                                                               } else if(var7 == 3918) {
                                                                                                                  var65 = class83.intStack[--class83.intStackSize] == 1;
                                                                                                                  if(class176.field2402 != null) {
                                                                                                                     class176.field2402.method63(class13.field281, var65);
                                                                                                                  }

                                                                                                                  var62 = 1;
                                                                                                               } else if(var7 == 3919) {
                                                                                                                  class83.intStack[++class83.intStackSize - 1] = class176.field2402 == null?0:class176.field2402.field277.size();
                                                                                                                  var62 = 1;
                                                                                                               } else {
                                                                                                                  class14 var54;
                                                                                                                  if(var7 == 3920) {
                                                                                                                     var14 = class83.intStack[--class83.intStackSize];
                                                                                                                     var54 = (class14)class176.field2402.field277.get(var14);
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = var54.field285;
                                                                                                                     var62 = 1;
                                                                                                                  } else if(var7 == 3921) {
                                                                                                                     var14 = class83.intStack[--class83.intStackSize];
                                                                                                                     var54 = (class14)class176.field2402.field277.get(var14);
                                                                                                                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var54.method70();
                                                                                                                     var62 = 1;
                                                                                                                  } else if(var7 == 3922) {
                                                                                                                     var14 = class83.intStack[--class83.intStackSize];
                                                                                                                     var54 = (class14)class176.field2402.field277.get(var14);
                                                                                                                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var54.method80();
                                                                                                                     var62 = 1;
                                                                                                                  } else if(var7 == 3923) {
                                                                                                                     var14 = class83.intStack[--class83.intStackSize];
                                                                                                                     var54 = (class14)class176.field2402.field277.get(var14);
                                                                                                                     long var33 = class226.method4147() - class6.field227 - var54.field289;
                                                                                                                     var30 = (int)(var33 / 3600000L);
                                                                                                                     var19 = (int)((var33 - (long)(var30 * 3600000)) / 60000L);
                                                                                                                     var32 = (int)((var33 - (long)(var30 * 3600000) - (long)(var19 * '\uea60')) / 1000L);
                                                                                                                     String var35 = var30 + ":" + var19 / 10 + var19 % 10 + ":" + var32 / 10 + var32 % 10;
                                                                                                                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var35;
                                                                                                                     var62 = 1;
                                                                                                                  } else if(var7 == 3924) {
                                                                                                                     var14 = class83.intStack[--class83.intStackSize];
                                                                                                                     var54 = (class14)class176.field2402.field277.get(var14);
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = var54.field286.totalQuantity;
                                                                                                                     var62 = 1;
                                                                                                                  } else if(var7 == 3925) {
                                                                                                                     var14 = class83.intStack[--class83.intStackSize];
                                                                                                                     var54 = (class14)class176.field2402.field277.get(var14);
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = var54.field286.price;
                                                                                                                     var62 = 1;
                                                                                                                  } else if(var7 == 3926) {
                                                                                                                     var14 = class83.intStack[--class83.intStackSize];
                                                                                                                     var54 = (class14)class176.field2402.field277.get(var14);
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = var54.field286.itemId;
                                                                                                                     var62 = 1;
                                                                                                                  } else {
                                                                                                                     var62 = 2;
                                                                                                                  }
                                                                                                               }
                                                                                                            }

                                                                                                            var26 = var62;
                                                                                                         } else if(var7 < 4100) {
                                                                                                            var26 = class31.method266(var7, var3, var72);
                                                                                                         } else if(var7 < 4200) {
                                                                                                            var26 = NPC.method1732(var7, var3, var72);
                                                                                                         } else if(var7 < 4300) {
                                                                                                            var26 = Friend.method1095(var7, var3, var72);
                                                                                                         } else if(var7 < 5100) {
                                                                                                            var26 = class29.method239(var7, var3, var72);
                                                                                                         } else if(var7 < 5400) {
                                                                                                            var26 = class28.method236(var7, var3, var72);
                                                                                                         } else if(var7 < 5600) {
                                                                                                            var26 = class15.method93(var7, var3, var72);
                                                                                                         } else if(var7 < 5700) {
                                                                                                            var26 = GroundObject.method2521(var7, var3, var72);
                                                                                                         } else if(var7 < 6300) {
                                                                                                            if(var7 == 6200) {
                                                                                                               class83.intStackSize -= 2;
                                                                                                               Client.field900 = (short)class83.intStack[class83.intStackSize];
                                                                                                               if(Client.field900 <= 0) {
                                                                                                                  Client.field900 = 256;
                                                                                                               }

                                                                                                               Client.field1144 = (short)class83.intStack[class83.intStackSize + 1];
                                                                                                               if(Client.field1144 <= 0) {
                                                                                                                  Client.field1144 = 205;
                                                                                                               }

                                                                                                               var62 = 1;
                                                                                                            } else if(var7 == 6201) {
                                                                                                               class83.intStackSize -= 2;
                                                                                                               Client.field942 = (short)class83.intStack[class83.intStackSize];
                                                                                                               if(Client.field942 <= 0) {
                                                                                                                  Client.field942 = 256;
                                                                                                               }

                                                                                                               Client.field1121 = (short)class83.intStack[class83.intStackSize + 1];
                                                                                                               if(Client.field1121 <= 0) {
                                                                                                                  Client.field1121 = 320;
                                                                                                               }

                                                                                                               var62 = 1;
                                                                                                            } else if(var7 == 6202) {
                                                                                                               class83.intStackSize -= 4;
                                                                                                               Client.field1147 = (short)class83.intStack[class83.intStackSize];
                                                                                                               if(Client.field1147 <= 0) {
                                                                                                                  Client.field1147 = 1;
                                                                                                               }

                                                                                                               Client.field1148 = (short)class83.intStack[class83.intStackSize + 1];
                                                                                                               if(Client.field1148 <= 0) {
                                                                                                                  Client.field1148 = 32767;
                                                                                                               } else if(Client.field1148 < Client.field1147) {
                                                                                                                  Client.field1148 = Client.field1147;
                                                                                                               }

                                                                                                               Client.field1149 = (short)class83.intStack[class83.intStackSize + 2];
                                                                                                               if(Client.field1149 <= 0) {
                                                                                                                  Client.field1149 = 1;
                                                                                                               }

                                                                                                               Client.field914 = (short)class83.intStack[class83.intStackSize + 3];
                                                                                                               if(Client.field914 <= 0) {
                                                                                                                  Client.field914 = 32767;
                                                                                                               } else if(Client.field914 < Client.field1149) {
                                                                                                                  Client.field914 = Client.field1149;
                                                                                                               }

                                                                                                               var62 = 1;
                                                                                                            } else if(var7 == 6203) {
                                                                                                               if(Client.field903 != null) {
                                                                                                                  Client.method1512(0, 0, Client.field903.width, Client.field903.height, false);
                                                                                                                  class83.intStack[++class83.intStackSize - 1] = Client.camera2;
                                                                                                                  class83.intStack[++class83.intStackSize - 1] = Client.camera3;
                                                                                                               } else {
                                                                                                                  class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                  class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                               }

                                                                                                               var62 = 1;
                                                                                                            } else if(var7 == 6204) {
                                                                                                               class83.intStack[++class83.intStackSize - 1] = Client.field942;
                                                                                                               class83.intStack[++class83.intStackSize - 1] = Client.field1121;
                                                                                                               var62 = 1;
                                                                                                            } else if(var7 == 6205) {
                                                                                                               class83.intStack[++class83.intStackSize - 1] = Client.field900;
                                                                                                               class83.intStack[++class83.intStackSize - 1] = Client.field1144;
                                                                                                               var62 = 1;
                                                                                                            } else {
                                                                                                               var62 = 2;
                                                                                                            }

                                                                                                            var26 = var62;
                                                                                                         } else if(var7 < 6600) {
                                                                                                            if(var7 == 6500) {
                                                                                                               class83.intStack[++class83.intStackSize - 1] = class41.loadWorlds()?1:0;
                                                                                                               var62 = 1;
                                                                                                            } else {
                                                                                                               World var66;
                                                                                                               if(var7 == 6501) {
                                                                                                                  var66 = class27.method205();
                                                                                                                  if(var66 != null) {
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = var66.id;
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = var66.mask;
                                                                                                                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var66.activity;
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = var66.location;
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = var66.playerCount;
                                                                                                                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var66.address;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var62 = 1;
                                                                                                               } else if(var7 == 6502) {
                                                                                                                  var66 = class230.method4156();
                                                                                                                  if(var66 != null) {
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = var66.id;
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = var66.mask;
                                                                                                                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var66.activity;
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = var66.location;
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = var66.playerCount;
                                                                                                                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var66.address;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                     class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var62 = 1;
                                                                                                               } else {
                                                                                                                  World var58;
                                                                                                                  if(var7 == 6506) {
                                                                                                                     var14 = class83.intStack[--class83.intStackSize];
                                                                                                                     var58 = null;

                                                                                                                     for(var28 = 0; var28 < World.field1267; ++var28) {
                                                                                                                        if(var14 == World.worldList[var28].id) {
                                                                                                                           var58 = World.worldList[var28];
                                                                                                                           break;
                                                                                                                        }
                                                                                                                     }

                                                                                                                     if(var58 != null) {
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = var58.id;
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = var58.mask;
                                                                                                                        class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var58.activity;
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = var58.location;
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = var58.playerCount;
                                                                                                                        class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var58.address;
                                                                                                                     } else {
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                        class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                        class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var62 = 1;
                                                                                                                  } else if(var7 == 6507) {
                                                                                                                     class83.intStackSize -= 4;
                                                                                                                     var14 = class83.intStack[class83.intStackSize];
                                                                                                                     var68 = class83.intStack[class83.intStackSize + 1] == 1;
                                                                                                                     var28 = class83.intStack[class83.intStackSize + 2];
                                                                                                                     boolean var59 = class83.intStack[class83.intStackSize + 3] == 1;
                                                                                                                     class33.method353(var14, var68, var28, var59);
                                                                                                                     var62 = 1;
                                                                                                                  } else if(var7 != 6511) {
                                                                                                                     if(var7 == 6512) {
                                                                                                                        Client.field1036 = class83.intStack[--class83.intStackSize] == 1;
                                                                                                                        var62 = 1;
                                                                                                                     } else {
                                                                                                                        class251 var57;
                                                                                                                        if(var7 == 6513) {
                                                                                                                           class83.intStackSize -= 2;
                                                                                                                           var14 = class83.intStack[class83.intStackSize];
                                                                                                                           var27 = class83.intStack[class83.intStackSize + 1];
                                                                                                                           var57 = class54.method790(var27);
                                                                                                                           if(var57.method4495()) {
                                                                                                                              class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = class220.getNpcDefinition(var14).method4708(var27, var57.field3385);
                                                                                                                           } else {
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = class220.getNpcDefinition(var14).method4726(var27, var57.field3381);
                                                                                                                           }

                                                                                                                           var62 = 1;
                                                                                                                        } else if(var7 == 6514) {
                                                                                                                           class83.intStackSize -= 2;
                                                                                                                           var14 = class83.intStack[class83.intStackSize];
                                                                                                                           var27 = class83.intStack[class83.intStackSize + 1];
                                                                                                                           var57 = class54.method790(var27);
                                                                                                                           if(var57.method4495()) {
                                                                                                                              class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = class43.getObjectDefinition(var14).method4614(var27, var57.field3385);
                                                                                                                           } else {
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = class43.getObjectDefinition(var14).method4588(var27, var57.field3381);
                                                                                                                           }

                                                                                                                           var62 = 1;
                                                                                                                        } else if(var7 == 6515) {
                                                                                                                           class83.intStackSize -= 2;
                                                                                                                           var14 = class83.intStack[class83.intStackSize];
                                                                                                                           var27 = class83.intStack[class83.intStackSize + 1];
                                                                                                                           var57 = class54.method790(var27);
                                                                                                                           if(var57.method4495()) {
                                                                                                                              class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = class51.getItemDefinition(var14).method4641(var27, var57.field3385);
                                                                                                                           } else {
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = class51.getItemDefinition(var14).method4642(var27, var57.field3381);
                                                                                                                           }

                                                                                                                           var62 = 1;
                                                                                                                        } else if(var7 == 6516) {
                                                                                                                           class83.intStackSize -= 2;
                                                                                                                           var14 = class83.intStack[class83.intStackSize];
                                                                                                                           var27 = class83.intStack[class83.intStackSize + 1];
                                                                                                                           var57 = class54.method790(var27);
                                                                                                                           if(var57.method4495()) {
                                                                                                                              class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = Script.method1877(var14).method4525(var27, var57.field3385);
                                                                                                                           } else {
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = Script.method1877(var14).method4509(var27, var57.field3381);
                                                                                                                           }

                                                                                                                           var62 = 1;
                                                                                                                        } else {
                                                                                                                           var62 = 2;
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     var14 = class83.intStack[--class83.intStackSize];
                                                                                                                     if(var14 >= 0 && var14 < World.field1267) {
                                                                                                                        var58 = World.worldList[var14];
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = var58.id;
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = var58.mask;
                                                                                                                        class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var58.activity;
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = var58.location;
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = var58.playerCount;
                                                                                                                        class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var58.address;
                                                                                                                     } else {
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = -1;
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                        class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                        class83.intStack[++class83.intStackSize - 1] = 0;
                                                                                                                        class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var62 = 1;
                                                                                                                  }
                                                                                                               }
                                                                                                            }

                                                                                                            var26 = var62;
                                                                                                         } else if(var7 < 6700) {
                                                                                                            var26 = class35.method494(var7, var3, var72);
                                                                                                         } else {
                                                                                                            var26 = 2;
                                                                                                         }
                                                                                                      }
                                                                                                   }
                                                                                                }
                                                                                             }

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
         } catch (Exception var38) {
            StringBuilder var37 = new StringBuilder(30);
            var37.append("").append(var3.hash).append(" ");

            for(var10 = class83.scriptStackCount - 1; var10 >= 0; --var10) {
               var37.append("").append(class83.scriptStack[var10].invokedFromScript.hash).append(" ");
            }

            var37.append("").append(var41);
            class232.method4169(var37.toString(), var38);
         }
      }
   }
}
