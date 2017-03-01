import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("ob")
   @ObfuscatedGetter(
      intValue = 1886740671
   )
   static int field203;
   @ObfuscatedName("x")
   @Export("name")
   String name;
   @ObfuscatedName("n")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("a")
   public static byte[][] field211;

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(LNPCComposition;IIII)V",
      garbageValue = "-1743929372"
   )
   static final void method205(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.method3779();
         }

         if(var0 != null) {
            if(var0.field3039) {
               if(!var0.field3041 || Client.field457 == var1) {
                  String var4 = var0.name;
                  if(var0.combatLevel != 0) {
                     var4 = var4 + class168.method3274(var0.combatLevel, WidgetNode.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3041 && Client.field546) {
                     class6.addMenuEntry("Examine", class37.method813(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.field416 == 1) {
                     class6.addMenuEntry("Use", Client.field443 + " " + "->" + " " + class37.method813(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.field444) {
                     if((CombatInfoListHolder.field759 & 2) == 2) {
                        class6.addMenuEntry(Client.field353, Client.field448 + " " + "->" + " " + class37.method813(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var5 = var0.field3041 && Client.field546?2000:0;
                     String[] var6 = var0.actions;
                     if(Client.field460) {
                        var6 = class145.method2800(var6);
                     }

                     int var7;
                     int var8;
                     if(var6 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var6[var7] != null && !var6[var7].equalsIgnoreCase("Attack")) {
                              var8 = 0;
                              if(var7 == 0) {
                                 var8 = var5 + 9;
                              }

                              if(var7 == 1) {
                                 var8 = var5 + 10;
                              }

                              if(var7 == 2) {
                                 var8 = 11 + var5;
                              }

                              if(var7 == 3) {
                                 var8 = 12 + var5;
                              }

                              if(var7 == 4) {
                                 var8 = var5 + 13;
                              }

                              class6.addMenuEntry(var6[var7], class37.method813(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var6 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(null != var6[var7] && var6[var7].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(Client.field314 != class40.field814) {
                                 if(class40.field812 == Client.field314 || Client.field314 == class40.field816 && var0.combatLevel > WidgetNode.localPlayer.combatLevel) {
                                    var9 = 2000;
                                 }

                                 var8 = 0;
                                 if(var7 == 0) {
                                    var8 = var9 + 9;
                                 }

                                 if(var7 == 1) {
                                    var8 = 10 + var9;
                                 }

                                 if(var7 == 2) {
                                    var8 = var9 + 11;
                                 }

                                 if(var7 == 3) {
                                    var8 = var9 + 12;
                                 }

                                 if(var7 == 4) {
                                    var8 = 13 + var9;
                                 }

                                 class6.addMenuEntry(var6[var7], class37.method813(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3041 || !Client.field546) {
                        class6.addMenuEntry("Examine", class37.method813(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1482793028"
   )
   static int method206(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 3903) {
         var3 = class32.field726[--class32.field735];
         class32.field726[++class32.field735 - 1] = Client.grandExchangeOffers[var3].method50();
         return 1;
      } else if(var0 == 3904) {
         var3 = class32.field726[--class32.field735];
         class32.field726[++class32.field735 - 1] = Client.grandExchangeOffers[var3].itemId;
         return 1;
      } else if(var0 == 3905) {
         var3 = class32.field726[--class32.field735];
         class32.field726[++class32.field735 - 1] = Client.grandExchangeOffers[var3].price;
         return 1;
      } else if(var0 == 3906) {
         var3 = class32.field726[--class32.field735];
         class32.field726[++class32.field735 - 1] = Client.grandExchangeOffers[var3].totalQuantity;
         return 1;
      } else if(var0 == 3907) {
         var3 = class32.field726[--class32.field735];
         class32.field726[++class32.field735 - 1] = Client.grandExchangeOffers[var3].quantitySold;
         return 1;
      } else if(var0 == 3908) {
         var3 = class32.field726[--class32.field735];
         class32.field726[++class32.field735 - 1] = Client.grandExchangeOffers[var3].spent;
         return 1;
      } else {
         int var13;
         if(var0 == 3910) {
            var3 = class32.field726[--class32.field735];
            var13 = Client.grandExchangeOffers[var3].method54();
            class32.field726[++class32.field735 - 1] = var13 == 0?1:0;
            return 1;
         } else if(var0 == 3911) {
            var3 = class32.field726[--class32.field735];
            var13 = Client.grandExchangeOffers[var3].method54();
            class32.field726[++class32.field735 - 1] = var13 == 2?1:0;
            return 1;
         } else if(var0 == 3912) {
            var3 = class32.field726[--class32.field735];
            var13 = Client.grandExchangeOffers[var3].method54();
            class32.field726[++class32.field735 - 1] = var13 == 5?1:0;
            return 1;
         } else if(var0 == 3913) {
            var3 = class32.field726[--class32.field735];
            var13 = Client.grandExchangeOffers[var3].method54();
            class32.field726[++class32.field735 - 1] = var13 == 1?1:0;
            return 1;
         } else {
            boolean var12;
            if(var0 == 3914) {
               var12 = class32.field726[--class32.field735] == 1;
               if(Renderable.field1549 != null) {
                  Renderable.field1549.method15(class1.field6, var12);
               }

               return 1;
            } else if(var0 == 3915) {
               var12 = class32.field726[--class32.field735] == 1;
               if(Renderable.field1549 != null) {
                  Renderable.field1549.method15(class1.field10, var12);
               }

               return 1;
            } else if(var0 == 3916) {
               class32.field735 -= 2;
               var12 = class32.field726[class32.field735] == 1;
               boolean var11 = class32.field726[1 + class32.field735] == 1;
               if(null != Renderable.field1549) {
                  Renderable.field1549.method15(new class44(var11), var12);
               }

               return 1;
            } else if(var0 == 3917) {
               var12 = class32.field726[--class32.field735] == 1;
               if(Renderable.field1549 != null) {
                  Renderable.field1549.method15(class1.field4, var12);
               }

               return 1;
            } else if(var0 == 3918) {
               var12 = class32.field726[--class32.field735] == 1;
               if(Renderable.field1549 != null) {
                  Renderable.field1549.method15(class1.field7, var12);
               }

               return 1;
            } else if(var0 == 3919) {
               class32.field726[++class32.field735 - 1] = null == Renderable.field1549?0:Renderable.field1549.field9.size();
               return 1;
            } else {
               class2 var4;
               if(var0 == 3920) {
                  var3 = class32.field726[--class32.field735];
                  var4 = (class2)Renderable.field1549.field9.get(var3);
                  class32.field726[++class32.field735 - 1] = var4.field16;
                  return 1;
               } else if(var0 == 3921) {
                  var3 = class32.field726[--class32.field735];
                  var4 = (class2)Renderable.field1549.field9.get(var3);
                  class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var4.method30();
                  return 1;
               } else if(var0 == 3922) {
                  var3 = class32.field726[--class32.field735];
                  var4 = (class2)Renderable.field1549.field9.get(var3);
                  class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var4.method24();
                  return 1;
               } else if(var0 == 3923) {
                  var3 = class32.field726[--class32.field735];
                  var4 = (class2)Renderable.field1549.field9.get(var3);
                  long var5 = WallObject.method1985() - class88.field1542 - var4.field11;
                  int var7 = (int)(var5 / 3600000L);
                  int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
                  int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * '\uea60')) / 1000L);
                  String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                  class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var10;
                  return 1;
               } else if(var0 == 3924) {
                  var3 = class32.field726[--class32.field735];
                  var4 = (class2)Renderable.field1549.field9.get(var3);
                  class32.field726[++class32.field735 - 1] = var4.field13.totalQuantity;
                  return 1;
               } else if(var0 == 3925) {
                  var3 = class32.field726[--class32.field735];
                  var4 = (class2)Renderable.field1549.field9.get(var3);
                  class32.field726[++class32.field735 - 1] = var4.field13.price;
                  return 1;
               } else if(var0 == 3926) {
                  var3 = class32.field726[--class32.field735];
                  var4 = (class2)Renderable.field1549.field9.get(var3);
                  class32.field726[++class32.field735 - 1] = var4.field13.itemId;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([Lclass158;II)Lclass158;",
      garbageValue = "-1320041102"
   )
   public static class158 method207(class158[] var0, int var1) {
      class158[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class158 var4 = var2[var3];
         if(var1 == var4.vmethod4107()) {
            return var4;
         }
      }

      return null;
   }
}
