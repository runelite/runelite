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
      if(var4 != null) {
         class30.field713 = 0;
         class32.scriptStringStackSize = 0;
         int var5 = -1;
         int[] var6 = var4.instructions;
         int[] var7 = var4.intOperands;
         byte var8 = -1;
         class32.scriptStackCount = 0;

         int var9;
         try {
            class32.field739 = new int[var4.localIntCount];
            int var10 = 0;
            class32.field740 = new String[var4.localStringCount];
            int var22 = 0;

            int var12;
            String var13;
            for(var9 = 1; var9 < var2.length; ++var9) {
               if(var2[var9] instanceof Integer) {
                  var12 = ((Integer)var2[var9]).intValue();
                  if(var12 == -2147483647) {
                     var12 = var0.field198;
                  }

                  if(var12 == -2147483646) {
                     var12 = var0.field201;
                  }

                  if(var12 == -2147483645) {
                     var12 = var0.field207 != null?var0.field207.id:-1;
                  }

                  if(var12 == -2147483644) {
                     var12 = var0.field202;
                  }

                  if(var12 == -2147483643) {
                     var12 = var0.field207 != null?var0.field207.index:-1;
                  }

                  if(var12 == -2147483642) {
                     var12 = var0.field203 != null?var0.field203.id:-1;
                  }

                  if(var12 == -2147483641) {
                     var12 = var0.field203 != null?var0.field203.index:-1;
                  }

                  if(var12 == -2147483640) {
                     var12 = var0.field204;
                  }

                  if(var12 == -2147483639) {
                     var12 = var0.field205;
                  }

                  class32.field739[var10++] = var12;
               } else if(var2[var9] instanceof String) {
                  var13 = (String)var2[var9];
                  if(var13.equals("event_opbase")) {
                     var13 = var0.field200;
                  }

                  class32.field740[var22++] = var13;
               }
            }

            var9 = 0;
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
                                                                                       label221:
                                                                                       while(true) {
                                                                                          ++var9;
                                                                                          if(var9 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var5;
                                                                                          int var14 = var6[var5];
                                                                                          int var15;
                                                                                          if(var14 < 100) {
                                                                                             if(var14 != 0) {
                                                                                                if(var14 != 1) {
                                                                                                   if(var14 != 2) {
                                                                                                      if(var14 != 3) {
                                                                                                         if(var14 != 6) {
                                                                                                            if(var14 != 7) {
                                                                                                               if(var14 != 8) {
                                                                                                                  if(var14 != 9) {
                                                                                                                     if(var14 != 10) {
                                                                                                                        if(var14 != 21) {
                                                                                                                           if(var14 != 25) {
                                                                                                                              int var24;
                                                                                                                              if(var14 != 27) {
                                                                                                                                 if(var14 != 31) {
                                                                                                                                    if(var14 != 32) {
                                                                                                                                       if(var14 != 33) {
                                                                                                                                          if(var14 != 34) {
                                                                                                                                             if(var14 != 35) {
                                                                                                                                                if(var14 != 36) {
                                                                                                                                                   if(var14 != 37) {
                                                                                                                                                      if(var14 != 38) {
                                                                                                                                                         if(var14 != 39) {
                                                                                                                                                            if(var14 != 40) {
                                                                                                                                                               if(var14 != 42) {
                                                                                                                                                                  if(var14 != 43) {
                                                                                                                                                                     if(var14 == 44) {
                                                                                                                                                                        var12 = var7[var5] >> 16;
                                                                                                                                                                        var15 = var7[var5] & '\uffff';
                                                                                                                                                                        int var27 = class32.field743[--class30.field713];
                                                                                                                                                                        if(var27 >= 0 && var27 <= 5000) {
                                                                                                                                                                           class32.field741[var12] = var27;
                                                                                                                                                                           byte var29 = -1;
                                                                                                                                                                           if(var15 == 105) {
                                                                                                                                                                              var29 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var24 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var24 >= var27) {
                                                                                                                                                                                 continue label221;
                                                                                                                                                                              }

                                                                                                                                                                              class32.field742[var12][var24] = var29;
                                                                                                                                                                              ++var24;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var14 == 45) {
                                                                                                                                                                        var12 = var7[var5];
                                                                                                                                                                        var15 = class32.field743[--class30.field713];
                                                                                                                                                                        if(var15 < 0 || var15 >= class32.field741[var12]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class32.field743[++class30.field713 - 1] = class32.field742[var12][var15];
                                                                                                                                                                     } else if(var14 == 46) {
                                                                                                                                                                        var12 = var7[var5];
                                                                                                                                                                        class30.field713 -= 2;
                                                                                                                                                                        var15 = class32.field743[class30.field713];
                                                                                                                                                                        if(var15 < 0 || var15 >= class32.field741[var12]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class32.field742[var12][var15] = class32.field743[class30.field713 + 1];
                                                                                                                                                                     } else if(var14 == 47) {
                                                                                                                                                                        var13 = class9.chatMessages.method873(var7[var5]);
                                                                                                                                                                        if(var13 == null) {
                                                                                                                                                                           var13 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var13;
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var14 != 48) {
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
                                                                                                                                                               Script var26 = CombatInfo1.method593(var12);
                                                                                                                                                               int[] var28 = new int[var26.localIntCount];
                                                                                                                                                               String[] var30 = new String[var26.localStringCount];

                                                                                                                                                               for(var24 = 0; var24 < var26.intStackCount; ++var24) {
                                                                                                                                                                  var28[var24] = class32.field743[var24 + (class30.field713 - var26.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var24 = 0; var24 < var26.stringStackCount; ++var24) {
                                                                                                                                                                  var30[var24] = class32.scriptStringStack[var24 + (class32.scriptStringStackSize - var26.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class30.field713 -= var26.intStackCount;
                                                                                                                                                               class32.scriptStringStackSize -= var26.stringStackCount;
                                                                                                                                                               ScriptState var31 = new ScriptState();
                                                                                                                                                               var31.field111 = var4;
                                                                                                                                                               var31.field104 = var5;
                                                                                                                                                               var31.field105 = class32.field739;
                                                                                                                                                               var31.field112 = class32.field740;
                                                                                                                                                               class32.scriptStack[++class32.scriptStackCount - 1] = var31;
                                                                                                                                                               var4 = var26;
                                                                                                                                                               var6 = var26.instructions;
                                                                                                                                                               var7 = var26.intOperands;
                                                                                                                                                               var5 = -1;
                                                                                                                                                               class32.field739 = var28;
                                                                                                                                                               class32.field740 = var30;
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
                                                                                                                                                      String var25 = class170.method3303(class32.scriptStringStack, class32.scriptStringStackSize, var12);
                                                                                                                                                      class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var25;
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
                                                                                                                                       if(class32.field743[class30.field713] >= class32.field743[class30.field713 + 1]) {
                                                                                                                                          var5 += var7[var5];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class30.field713 -= 2;
                                                                                                                                    if(class32.field743[class30.field713] <= class32.field743[class30.field713 + 1]) {
                                                                                                                                       var5 += var7[var5];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var12 = var7[var5];
                                                                                                                                 var15 = class32.field743[--class30.field713];
                                                                                                                                 Varbit var17 = class22.method201(var12);
                                                                                                                                 int var18 = var17.leastSignificantBit;
                                                                                                                                 var24 = var17.configId;
                                                                                                                                 int var19 = var17.mostSignificantBit;
                                                                                                                                 int var20 = class165.field2182[var19 - var24];
                                                                                                                                 if(var15 < 0 || var15 > var20) {
                                                                                                                                    var15 = 0;
                                                                                                                                 }

                                                                                                                                 var20 <<= var24;
                                                                                                                                 class165.widgetSettings[var18] = class165.widgetSettings[var18] & ~var20 | var15 << var24 & var20;
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var12 = var7[var5];
                                                                                                                              class32.field743[++class30.field713 - 1] = class25.method560(var12);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class32.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var23 = class32.scriptStack[--class32.scriptStackCount];
                                                                                                                           var4 = var23.field111;
                                                                                                                           var6 = var4.instructions;
                                                                                                                           var7 = var4.intOperands;
                                                                                                                           var5 = var23.field104;
                                                                                                                           class32.field739 = var23.field105;
                                                                                                                           class32.field740 = var23.field112;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class30.field713 -= 2;
                                                                                                                        if(class32.field743[class30.field713] > class32.field743[class30.field713 + 1]) {
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
                                                                                                                  if(class32.field743[class30.field713 + 1] == class32.field743[class30.field713]) {
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
                                                                                             boolean var16;
                                                                                             if(var4.intOperands[var5] == 1) {
                                                                                                var16 = true;
                                                                                             } else {
                                                                                                var16 = false;
                                                                                             }

                                                                                             var15 = class13.method158(var14, var4, var16);
                                                                                             switch(var15) {
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
         } catch (Exception var21) {
            StringBuilder var11 = new StringBuilder(30);
            var11.append("").append(var4.hash).append(" ");

            for(var9 = class32.scriptStackCount - 1; var9 >= 0; --var9) {
               var11.append("").append(class32.scriptStack[var9].field111.hash).append(" ");
            }

            var11.append("").append(var8);
            GameObject.method1958(var11.toString(), var21);
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
            if(var0 != null) {
               Buffer var1 = new Buffer(var0);
               World.field708 = var1.readUnsignedShort();
               World.worldList = new World[World.field708];

               World var2;
               for(int var3 = 0; var3 < World.field708; var2.index = var3++) {
                  var2 = World.worldList[var3] = new World();
                  var2.id = var1.readUnsignedShort();
                  var2.mask = var1.readInt();
                  var2.address = var1.readString();
                  var2.activity = var1.readString();
                  var2.location = var1.readUnsignedByte();
                  var2.playerCount = var1.readShort();
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
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method2433(); var3 != null && var3.field684 <= var1; var3 = (CombatInfo1)this.combatInfo1.method2433()) {
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
      if(var0 == null) {
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
