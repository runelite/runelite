import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public class class174 {
   @ObfuscatedName("g")
   static byte[][] field2387;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -619678665
   )
   static int field2388;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1631416557
   )
   static int field2389;
   @ObfuscatedName("q")
   static byte[][] field2390;
   @ObfuscatedName("v")
   static byte[][] field2392;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -473260091
   )
   static int field2394;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "1"
   )
   static synchronized byte[] method3414(int var0) {
      byte[] var1;
      if(var0 == 100 && field2394 > 0) {
         var1 = field2390[--field2394];
         field2390[field2394] = null;
         return var1;
      } else if(var0 == 5000 && field2388 > 0) {
         var1 = field2387[--field2388];
         field2387[field2388] = null;
         return var1;
      } else if(var0 == 30000 && field2389 > 0) {
         var1 = field2392[--field2389];
         field2392[field2389] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   static {
      field2394 = 0;
      field2388 = 0;
      field2389 = 0;
      field2390 = new byte[1000][];
      field2387 = new byte[250][];
      field2392 = new byte[50][];
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(LNPCComposition;IIII)V",
      garbageValue = "-15610285"
   )
   static final void method3416(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.method4705();
         }

         if(var0 != null) {
            if(var0.field3575) {
               if(!var0.field3577 || Client.field1058 == var1) {
                  String var4 = var0.name;
                  int var7;
                  int var8;
                  if(var0.combatLevel != 0) {
                     var7 = var0.combatLevel;
                     var8 = XGrandExchangeOffer.localPlayer.combatLevel;
                     int var9 = var8 - var7;
                     String var6;
                     if(var9 < -9) {
                        var6 = class82.method1610(16711680);
                     } else if(var9 < -6) {
                        var6 = class82.method1610(16723968);
                     } else if(var9 < -3) {
                        var6 = class82.method1610(16740352);
                     } else if(var9 < 0) {
                        var6 = class82.method1610(16756736);
                     } else if(var9 > 9) {
                        var6 = class82.method1610('\uff00');
                     } else if(var9 > 6) {
                        var6 = class82.method1610(4259584);
                     } else if(var9 > 3) {
                        var6 = class82.method1610(8453888);
                     } else if(var9 > 0) {
                        var6 = class82.method1610(12648192);
                     } else {
                        var6 = class82.method1610(16776960);
                     }

                     var4 = var4 + var6 + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3577 && Client.field1036) {
                     class176.addMenuEntry("Examine", class82.method1610(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.field1043 == 1) {
                     class176.addMenuEntry("Use", Client.field1142 + " " + "->" + " " + class82.method1610(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.field1045) {
                     if((class24.field364 & 2) == 2) {
                        class176.addMenuEntry(Client.field1048, Client.field1049 + " " + "->" + " " + class82.method1610(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var5 = var0.field3577 && Client.field1036?2000:0;
                     String[] var12 = var0.actions;
                     if(Client.field994) {
                        var12 = class9.method37(var12);
                     }

                     if(var12 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var12[var7] != null && !var12[var7].equalsIgnoreCase("Attack")) {
                              var8 = 0;
                              if(var7 == 0) {
                                 var8 = var5 + 9;
                              }

                              if(var7 == 1) {
                                 var8 = var5 + 10;
                              }

                              if(var7 == 2) {
                                 var8 = var5 + 11;
                              }

                              if(var7 == 3) {
                                 var8 = var5 + 12;
                              }

                              if(var7 == 4) {
                                 var8 = var5 + 13;
                              }

                              class176.addMenuEntry(var12[var7], class82.method1610(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var12 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var12[var7] != null && var12[var7].equalsIgnoreCase("Attack")) {
                              short var11 = 0;
                              if(Client.field916 != class91.field1407) {
                                 if(Client.field916 == class91.field1405 || class91.field1410 == Client.field916 && var0.combatLevel > XGrandExchangeOffer.localPlayer.combatLevel) {
                                    var11 = 2000;
                                 }

                                 var8 = 0;
                                 if(var7 == 0) {
                                    var8 = var11 + 9;
                                 }

                                 if(var7 == 1) {
                                    var8 = var11 + 10;
                                 }

                                 if(var7 == 2) {
                                    var8 = var11 + 11;
                                 }

                                 if(var7 == 3) {
                                    var8 = var11 + 12;
                                 }

                                 if(var7 == 4) {
                                    var8 = var11 + 13;
                                 }

                                 class176.addMenuEntry(var12[var7], class82.method1610(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3577 || !Client.field1036) {
                        class176.addMenuEntry("Examine", class82.method1610(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }
}
