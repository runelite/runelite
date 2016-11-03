import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
public class class161 {
   @ObfuscatedName("d")
   static class13 field2639;

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(LNPCComposition;IIII)V",
      garbageValue = "168091037"
   )
   static final void method3193(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(null != var0.field923) {
            var0 = var0.method801();
         }

         if(null != var0) {
            if(var0.field926) {
               if(!var0.field900 || Client.field315 == var1) {
                  String var4 = var0.name;
                  if(var0.combatLevel != 0) {
                     var4 = var4 + ChatMessages.method226(var0.combatLevel, class165.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(Client.field497 == 1) {
                     class5.addMenuEntry("Use", Client.field434 + " " + "->" + " " + class144.method3013(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.field435) {
                     if((class145.field2220 & 2) == 2) {
                        class5.addMenuEntry(Client.field328, Client.field439 + " " + "->" + " " + class144.method3013(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     String[] var5 = var0.actions;
                     if(Client.field451) {
                        var5 = class56.method1174(var5);
                     }

                     int var6;
                     if(var5 != null) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(var5[var6] != null && !var5[var6].equalsIgnoreCase("Attack")) {
                              byte var7 = 0;
                              if(var6 == 0) {
                                 var7 = 9;
                              }

                              if(var6 == 1) {
                                 var7 = 10;
                              }

                              if(var6 == 2) {
                                 var7 = 11;
                              }

                              if(var6 == 3) {
                                 var7 = 12;
                              }

                              if(var6 == 4) {
                                 var7 = 13;
                              }

                              class5.addMenuEntry(var5[var6], class144.method3013(16776960) + var4, var7, var1, var2, var3);
                           }
                        }
                     }

                     if(var5 != null) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(var5[var6] != null && var5[var6].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(class21.field573 != Client.field305) {
                                 if(class21.field571 == Client.field305 || Client.field305 == class21.field577 && var0.combatLevel > class165.localPlayer.combatLevel) {
                                    var9 = 2000;
                                 }

                                 int var8 = 0;
                                 if(var6 == 0) {
                                    var8 = var9 + 9;
                                 }

                                 if(var6 == 1) {
                                    var8 = var9 + 10;
                                 }

                                 if(var6 == 2) {
                                    var8 = var9 + 11;
                                 }

                                 if(var6 == 3) {
                                    var8 = 12 + var9;
                                 }

                                 if(var6 == 4) {
                                    var8 = var9 + 13;
                                 }

                                 class5.addMenuEntry(var5[var6], class144.method3013(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     class5.addMenuEntry("Examine", class144.method3013(16776960) + var4, 1003, var1, var2, var3);
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LSequence;IIIB)V",
      garbageValue = "67"
   )
   static void method3194(Sequence var0, int var1, int var2, int var3) {
      if(Client.field522 < 50 && Client.field518 != 0) {
         if(var0.field1009 != null && var1 < var0.field1009.length) {
            int var4 = var0.field1009[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field523[Client.field522] = var5;
               Client.field524[Client.field522] = var6;
               Client.field327[Client.field522] = 0;
               Client.field527[Client.field522] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field392[Client.field522] = var7 + (var8 << 16) + (var9 << 8);
               ++Client.field522;
            }
         }
      }
   }
}
