import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public class class13 {
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = 1294900051
   )
   static int field122;
   @ObfuscatedName("r")
   static String field136;
   @ObfuscatedName("a")
   @Export("worldServersDownload")
   static class26 worldServersDownload;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = 865844759
   )
   @Export("cameraPitch")
   static int cameraPitch;

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(LNPCComposition;IIII)V",
      garbageValue = "-1200405700"
   )
   static final void method174(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.method3708();
         }

         if(var0 != null) {
            if(var0.field3026) {
               if(!var0.field3028 || Client.field445 == var1) {
                  String var4 = var0.name;
                  if(var0.combatLevel != 0) {
                     var4 = var4 + class159.method3065(var0.combatLevel, class16.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(Client.field429 == 1) {
                     class72.addMenuEntry("Use", Client.field431 + " " + "->" + " " + Client.method568(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.field432) {
                     if((class3.field29 & 2) == 2) {
                        class72.addMenuEntry(Client.field406, Client.field436 + " " + "->" + " " + Client.method568(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     String[] var5 = var0.actions;
                     if(Client.field502) {
                        var5 = class159.method3042(var5);
                     }

                     int var6;
                     if(null != var5) {
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

                              class72.addMenuEntry(var5[var6], Client.method568(16776960) + var4, var7, var1, var2, var3);
                           }
                        }
                     }

                     if(var5 != null) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(var5[var6] != null && var5[var6].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(class40.field808 != Client.field305) {
                                 if(Client.field305 == class40.field812 || Client.field305 == class40.field815 && var0.combatLevel > class16.localPlayer.combatLevel) {
                                    var9 = 2000;
                                 }

                                 int var8 = 0;
                                 if(var6 == 0) {
                                    var8 = 9 + var9;
                                 }

                                 if(var6 == 1) {
                                    var8 = 10 + var9;
                                 }

                                 if(var6 == 2) {
                                    var8 = var9 + 11;
                                 }

                                 if(var6 == 3) {
                                    var8 = var9 + 12;
                                 }

                                 if(var6 == 4) {
                                    var8 = var9 + 13;
                                 }

                                 class72.addMenuEntry(var5[var6], Client.method568(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     class72.addMenuEntry("Examine", Client.method568(16776960) + var4, 1003, var1, var2, var3);
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1854257616"
   )
   static void method175() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         if(CollisionData.method2260(Client.menuTypes[var0])) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var1 = var0; var1 < Client.menuOptionCount - 1; ++var1) {
                  Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
                  Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
                  Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
                  Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
                  Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
                  Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }

   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1409238222"
   )
   static void method176() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method2361(); null != var0; var0 = (WidgetNode)Client.componentTable.method2369()) {
         int var1 = var0.id;
         if(class103.method1973(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(null != var3[var4]) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class37.method736(var4);
               if(var5 != null) {
                  class33.method682(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "81"
   )
   static final void method177(int var0) {
      if(var0 >= 0) {
         int var1 = Client.menuActionParams0[var0];
         int var2 = Client.menuActionParams1[var0];
         int var3 = Client.menuTypes[var0];
         int var4 = Client.menuIdentifiers[var0];
         String var5 = Client.menuOptions[var0];
         String var6 = Client.menuTargets[var0];
         class5.menuAction(var1, var2, var3, var4, var5, var6, class115.field1811, class115.field1812);
      }
   }

   class13() throws Throwable {
      throw new Error();
   }
}
