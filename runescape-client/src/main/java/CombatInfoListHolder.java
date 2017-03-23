import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("u")
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;
   @ObfuscatedName("h")
   @Export("combatInfo1")
   CombatInfoList combatInfo1 = new CombatInfoList();

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass18;II)V",
      garbageValue = "-1429544322"
   )
   static void method719(class18 var0, int var1) {
      Object[] var2 = var0.field199;
      int var3 = ((Integer)var2[0]).intValue();
      Script var4 = CombatInfo1.method593(var3);
      if(null != var4) {
         class30.field713 = 0;
         class32.scriptStringStackSize = 0;
         int var5 = -1;
         int[] var6 = var4.instructions;
         int[] var7 = var4.intOperands;
         byte var8 = -1;
         class32.scriptStackCount = 0;

         int var11;
         try {
            class32.field739 = new int[var4.localIntCount];
            int var9 = 0;
            class32.field740 = new String[var4.localStringCount];
            int var10 = 0;

            int var12;
            String var19;
            for(var11 = 1; var11 < var2.length; ++var11) {
               if(var2[var11] instanceof Integer) {
                  var12 = ((Integer)var2[var11]).intValue();
                  if(var12 == -2147483647) {
                     var12 = var0.field198;
                  }

                  if(var12 == -2147483646) {
                     var12 = var0.field201;
                  }

                  if(var12 == -2147483645) {
                     var12 = null != var0.field207?var0.field207.id:-1;
                  }

                  if(var12 == -2147483644) {
                     var12 = var0.field202;
                  }

                  if(var12 == -2147483643) {
                     var12 = var0.field207 != null?var0.field207.index:-1;
                  }

                  if(var12 == -2147483642) {
                     var12 = null != var0.field203?var0.field203.id:-1;
                  }

                  if(var12 == -2147483641) {
                     var12 = null != var0.field203?var0.field203.index:-1;
                  }

                  if(var12 == -2147483640) {
                     var12 = var0.field204;
                  }

                  if(var12 == -2147483639) {
                     var12 = var0.field205;
                  }

                  class32.field739[var9++] = var12;
               } else if(var2[var11] instanceof String) {
                  var19 = (String)var2[var11];
                  if(var19.equals("event_opbase")) {
                     var19 = var0.field200;
                  }

                  class32.field740[var10++] = var19;
               }
            }

            var11 = 0;
            class32.field751 = var0.field208;

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
                                                                                       label281:
                                                                                       while(true) {
                                                                                          ++var11;
                                                                                          if(var11 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var5;
                                                                                          int var27 = var6[var5];
                                                                                          int var13;
                                                                                          if(var27 < 100) {
                                                                                             if(var27 != 0) {
                                                                                                if(var27 != 1) {
                                                                                                   if(var27 != 2) {
                                                                                                      if(var27 != 3) {
                                                                                                         if(var27 != 6) {
                                                                                                            if(var27 != 7) {
                                                                                                               if(var27 != 8) {
                                                                                                                  if(var27 != 9) {
                                                                                                                     if(var27 != 10) {
                                                                                                                        if(var27 != 21) {
                                                                                                                           if(var27 != 25) {
                                                                                                                              int var16;
                                                                                                                              if(var27 != 27) {
                                                                                                                                 if(var27 != 31) {
                                                                                                                                    if(var27 != 32) {
                                                                                                                                       if(var27 != 33) {
                                                                                                                                          if(var27 != 34) {
                                                                                                                                             if(var27 != 35) {
                                                                                                                                                if(var27 != 36) {
                                                                                                                                                   if(var27 != 37) {
                                                                                                                                                      if(var27 != 38) {
                                                                                                                                                         if(var27 != 39) {
                                                                                                                                                            if(var27 != 40) {
                                                                                                                                                               if(var27 != 42) {
                                                                                                                                                                  if(var27 != 43) {
                                                                                                                                                                     if(var27 == 44) {
                                                                                                                                                                        var12 = var7[var5] >> 16;
                                                                                                                                                                        var13 = var7[var5] & '\uffff';
                                                                                                                                                                        int var23 = class32.field743[--class30.field713];
                                                                                                                                                                        if(var23 >= 0 && var23 <= 5000) {
                                                                                                                                                                           class32.field741[var12] = var23;
                                                                                                                                                                           byte var29 = -1;
                                                                                                                                                                           if(var13 == 105) {
                                                                                                                                                                              var29 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var16 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var16 >= var23) {
                                                                                                                                                                                 continue label281;
                                                                                                                                                                              }

                                                                                                                                                                              class32.field742[var12][var16] = var29;
                                                                                                                                                                              ++var16;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var27 == 45) {
                                                                                                                                                                        var12 = var7[var5];
                                                                                                                                                                        var13 = class32.field743[--class30.field713];
                                                                                                                                                                        if(var13 < 0 || var13 >= class32.field741[var12]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class32.field743[++class30.field713 - 1] = class32.field742[var12][var13];
                                                                                                                                                                     } else if(var27 == 46) {
                                                                                                                                                                        var12 = var7[var5];
                                                                                                                                                                        class30.field713 -= 2;
                                                                                                                                                                        var13 = class32.field743[class30.field713];
                                                                                                                                                                        if(var13 < 0 || var13 >= class32.field741[var12]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class32.field742[var12][var13] = class32.field743[1 + class30.field713];
                                                                                                                                                                     } else if(var27 == 47) {
                                                                                                                                                                        var19 = class9.chatMessages.method873(var7[var5]);
                                                                                                                                                                        if(null == var19) {
                                                                                                                                                                           var19 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var19;
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var27 != 48) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        class9.chatMessages.method897(var7[var5], class32.scriptStringStack[--class32.scriptStringStackSize]);
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     class9.chatMessages.method870(var7[var5], class32.field743[--class30.field713]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class32.field743[++class30.field713 - 1] = class9.chatMessages.method871(var7[var5]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var12 = var7[var5];
                                                                                                                                                               Script var32 = CombatInfo1.method593(var12);
                                                                                                                                                               int[] var28 = new int[var32.localIntCount];
                                                                                                                                                               String[] var21 = new String[var32.localStringCount];

                                                                                                                                                               for(var16 = 0; var16 < var32.intStackCount; ++var16) {
                                                                                                                                                                  var28[var16] = class32.field743[var16 + (class30.field713 - var32.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var16 = 0; var16 < var32.stringStackCount; ++var16) {
                                                                                                                                                                  var21[var16] = class32.scriptStringStack[var16 + (class32.scriptStringStackSize - var32.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class30.field713 -= var32.intStackCount;
                                                                                                                                                               class32.scriptStringStackSize -= var32.stringStackCount;
                                                                                                                                                               ScriptState var22 = new ScriptState();
                                                                                                                                                               var22.field111 = var4;
                                                                                                                                                               var22.field104 = var5;
                                                                                                                                                               var22.field105 = class32.field739;
                                                                                                                                                               var22.field112 = class32.field740;
                                                                                                                                                               class32.scriptStack[++class32.scriptStackCount - 1] = var22;
                                                                                                                                                               var4 = var32;
                                                                                                                                                               var6 = var32.instructions;
                                                                                                                                                               var7 = var32.intOperands;
                                                                                                                                                               var5 = -1;
                                                                                                                                                               class32.field739 = var28;
                                                                                                                                                               class32.field740 = var21;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --class32.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class30.field713;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var12 = var7[var5];
                                                                                                                                                      class32.scriptStringStackSize -= var12;
                                                                                                                                                      String var20 = class170.method3303(class32.scriptStringStack, class32.scriptStringStackSize, var12);
                                                                                                                                                      class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var20;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class32.field740[var7[var5]] = class32.scriptStringStack[--class32.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class32.scriptStringStack[++class32.scriptStringStackSize - 1] = class32.field740[var7[var5]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class32.field739[var7[var5]] = class32.field743[--class30.field713];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class32.field743[++class30.field713 - 1] = class32.field739[var7[var5]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class30.field713 -= 2;
                                                                                                                                       if(class32.field743[class30.field713] >= class32.field743[1 + class30.field713]) {
                                                                                                                                          var5 += var7[var5];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class30.field713 -= 2;
                                                                                                                                    if(class32.field743[class30.field713] <= class32.field743[1 + class30.field713]) {
                                                                                                                                       var5 += var7[var5];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var12 = var7[var5];
                                                                                                                                 var13 = class32.field743[--class30.field713];
                                                                                                                                 Varbit var14 = class22.method201(var12);
                                                                                                                                 int var15 = var14.leastSignificantBit;
                                                                                                                                 var16 = var14.configId;
                                                                                                                                 int var17 = var14.mostSignificantBit;
                                                                                                                                 int var18 = class165.field2182[var17 - var16];
                                                                                                                                 if(var13 < 0 || var13 > var18) {
                                                                                                                                    var13 = 0;
                                                                                                                                 }

                                                                                                                                 var18 <<= var16;
                                                                                                                                 class165.widgetSettings[var15] = class165.widgetSettings[var15] & ~var18 | var13 << var16 & var18;
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var12 = var7[var5];
                                                                                                                              class32.field743[++class30.field713 - 1] = class25.method560(var12);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class32.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var31 = class32.scriptStack[--class32.scriptStackCount];
                                                                                                                           var4 = var31.field111;
                                                                                                                           var6 = var4.instructions;
                                                                                                                           var7 = var4.intOperands;
                                                                                                                           var5 = var31.field104;
                                                                                                                           class32.field739 = var31.field105;
                                                                                                                           class32.field740 = var31.field112;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class30.field713 -= 2;
                                                                                                                        if(class32.field743[class30.field713] > class32.field743[1 + class30.field713]) {
                                                                                                                           var5 += var7[var5];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class30.field713 -= 2;
                                                                                                                     if(class32.field743[class30.field713] < class32.field743[class30.field713 + 1]) {
                                                                                                                        var5 += var7[var5];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class30.field713 -= 2;
                                                                                                                  if(class32.field743[1 + class30.field713] == class32.field743[class30.field713]) {
                                                                                                                     var5 += var7[var5];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class30.field713 -= 2;
                                                                                                               if(class32.field743[class30.field713 + 1] != class32.field743[class30.field713]) {
                                                                                                                  var5 += var7[var5];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var5 += var7[var5];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var4.stringOperands[var5];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var12 = var7[var5];
                                                                                                      class165.widgetSettings[var12] = class32.field743[--class30.field713];
                                                                                                      Client.method550(var12);
                                                                                                   }
                                                                                                } else {
                                                                                                   var12 = var7[var5];
                                                                                                   class32.field743[++class30.field713 - 1] = class165.widgetSettings[var12];
                                                                                                }
                                                                                             } else {
                                                                                                class32.field743[++class30.field713 - 1] = var7[var5];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var30;
                                                                                             if(var4.intOperands[var5] == 1) {
                                                                                                var30 = true;
                                                                                             } else {
                                                                                                var30 = false;
                                                                                             }

                                                                                             var13 = class13.method158(var27, var4, var30);
                                                                                             switch(var13) {
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
         } catch (Exception var26) {
            StringBuilder var25 = new StringBuilder(30);
            var25.append("").append(var4.hash).append(" ");

            for(var11 = class32.scriptStackCount - 1; var11 >= 0; --var11) {
               var25.append("").append(class32.scriptStack[var11].field111.hash).append(" ");
            }

            var25.append("").append(var8);
            GameObject.method1958(var25.toString(), var26);
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-924531048"
   )
   void method720(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method2442(); var7 != null; var7 = (CombatInfo1)this.combatInfo1.method2433()) {
         ++var6;
         if(var1 == var7.field684) {
            var7.method591(var1, var2, var3, var4);
            return;
         }

         if(var7.field684 <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.method2443(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method2432(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method2442().unlink();
         }

      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "8"
   )
   boolean method722() {
      return this.combatInfo1.method2429();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1469275719"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(class15.worldServersDownload == null) {
            class15.worldServersDownload = new class26(class108.field1755, new URL(NPC.field780));
         } else {
            byte[] var0 = class15.worldServersDownload.method562();
            if(null != var0) {
               Buffer var1 = new Buffer(var0);
               World.field708 = var1.readUnsignedShort();
               World.worldList = new World[World.field708];

               World var3;
               for(int var2 = 0; var2 < World.field708; var3.index = var2++) {
                  var3 = World.worldList[var2] = new World();
                  var3.id = var1.readUnsignedShort();
                  var3.mask = var1.readInt();
                  var3.address = var1.readString();
                  var3.activity = var1.readString();
                  var3.location = var1.readUnsignedByte();
                  var3.playerCount = var1.readShort();
               }

               class3.method25(World.worldList, 0, World.worldList.length - 1, World.field699, World.field698);
               class15.worldServersDownload = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class15.worldServersDownload = null;
      }

      return false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IS)LCombatInfo1;",
      garbageValue = "128"
   )
   CombatInfo1 method726(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method2442();
      if(var2 != null && var2.field684 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method2433(); null != var3 && var3.field684 <= var1; var3 = (CombatInfo1)this.combatInfo1.method2433()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field2840 + var2.field690 + var2.field684 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BB)LFont;",
      garbageValue = "10"
   )
   static Font method728(byte[] var0) {
      if(null == var0) {
         return null;
      } else {
         Font var1 = new Font(var0, class225.field3230, ItemComposition.field3003, class225.field3232, ChatLineBuffer.field994, class225.field3234, BufferProvider.field3199);
         WidgetNode.method172();
         return var1;
      }
   }

   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1200921701"
   )
   public static void method732() {
      class187.field2793.reset();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-1127"
   )
   static void method733() {
      class45.field923 = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class45.field919[var0] = null;
         class45.field921[var0] = 1;
      }

   }
}
