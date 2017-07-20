import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public class class174 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 739074151
   )
   static int field2362;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1942288943
   )
   static int field2366;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 670291789
   )
   static int field2361;
   @ObfuscatedName("u")
   static byte[][] field2363;
   @ObfuscatedName("g")
   static byte[][] field2365;
   @ObfuscatedName("m")
   static byte[][] field2364;

   static {
      field2362 = 0;
      field2366 = 0;
      field2361 = 0;
      field2363 = new byte[1000][];
      field2365 = new byte[250][];
      field2364 = new byte[50][];
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "95"
   )
   static synchronized byte[] method3307(int var0) {
      byte[] var1;
      if(var0 == 100 && field2362 > 0) {
         var1 = field2363[--field2362];
         field2363[field2362] = null;
         return var1;
      } else if(var0 == 5000 && field2366 > 0) {
         var1 = field2365[--field2366];
         field2365[field2366] = null;
         return var1;
      } else if(var0 == 30000 && field2361 > 0) {
         var1 = field2364[--field2361];
         field2364[field2361] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(Lib;IIIB)V",
      garbageValue = "66"
   )
   static final void method3305(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.transform();
         }

         if(var0 != null) {
            if(var0.field3559) {
               if(!var0.field3533 || Client.field1072 == var1) {
                  String var4 = var0.name;
                  int var7;
                  int var8;
                  if(var0.combatLevel != 0) {
                     var7 = var0.combatLevel;
                     var8 = class226.localPlayer.combatLevel;
                     int var9 = var8 - var7;
                     String var6;
                     if(var9 < -9) {
                        var6 = class8.getColTags(16711680);
                     } else if(var9 < -6) {
                        var6 = class8.getColTags(16723968);
                     } else if(var9 < -3) {
                        var6 = class8.getColTags(16740352);
                     } else if(var9 < 0) {
                        var6 = class8.getColTags(16756736);
                     } else if(var9 > 9) {
                        var6 = class8.getColTags('\uff00');
                     } else if(var9 > 6) {
                        var6 = class8.getColTags(4259584);
                     } else if(var9 > 3) {
                        var6 = class8.getColTags(8453888);
                     } else if(var9 > 0) {
                        var6 = class8.getColTags(12648192);
                     } else {
                        var6 = class8.getColTags(16776960);
                     }

                     var4 = var4 + var6 + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3533 && Client.field1097) {
                     class261.addMenuEntry("Examine", class8.getColTags(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.itemSelectionState == 1) {
                     class261.addMenuEntry("Use", Client.field1058 + " " + "->" + " " + class8.getColTags(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.spellSelected) {
                     if((class39.field534 & 2) == 2) {
                        class261.addMenuEntry(Client.field1062, Client.field1063 + " " + "->" + " " + class8.getColTags(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var10 = var0.field3533 && Client.field1097?2000:0;
                     String[] var11 = var0.actions;
                     if(Client.field1174) {
                        var11 = IndexDataBase.method4103(var11);
                     }

                     if(var11 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var11[var7] != null && !var11[var7].equalsIgnoreCase("Attack")) {
                              var8 = 0;
                              if(var7 == 0) {
                                 var8 = var10 + 9;
                              }

                              if(var7 == 1) {
                                 var8 = var10 + 10;
                              }

                              if(var7 == 2) {
                                 var8 = var10 + 11;
                              }

                              if(var7 == 3) {
                                 var8 = var10 + 12;
                              }

                              if(var7 == 4) {
                                 var8 = var10 + 13;
                              }

                              class261.addMenuEntry(var11[var7], class8.getColTags(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var11 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var11[var7] != null && var11[var7].equalsIgnoreCase("Attack")) {
                              short var12 = 0;
                              if(class91.field1393 != Client.field1161) {
                                 if(Client.field1161 == class91.field1387 || Client.field1161 == class91.field1386 && var0.combatLevel > class226.localPlayer.combatLevel) {
                                    var12 = 2000;
                                 }

                                 var8 = 0;
                                 if(var7 == 0) {
                                    var8 = var12 + 9;
                                 }

                                 if(var7 == 1) {
                                    var8 = var12 + 10;
                                 }

                                 if(var7 == 2) {
                                    var8 = var12 + 11;
                                 }

                                 if(var7 == 3) {
                                    var8 = var12 + 12;
                                 }

                                 if(var7 == 4) {
                                    var8 = var12 + 13;
                                 }

                                 class261.addMenuEntry(var11[var7], class8.getColTags(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3533 || !Client.field1097) {
                        class261.addMenuEntry("Examine", class8.getColTags(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }
}
