import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
public final class class207 {
   class207() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(LNPCComposition;IIII)V",
      garbageValue = "78734789"
   )
   static final void method3862(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.method3719();
         }

         if(null != var0) {
            if(var0.field3035) {
               if(!var0.field3037 || var1 == Client.field481) {
                  String var4 = var0.name;
                  if(var0.combatLevel != 0) {
                     var4 = var4 + class168.method3202(var0.combatLevel, class22.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3037 && Client.field346) {
                     class22.addMenuEntry("Examine", class116.method2288(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.field466 == 1) {
                     class22.addMenuEntry("Use", Client.field496 + " " + "->" + " " + class116.method2288(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.field468) {
                     if((class7.field73 & 2) == 2) {
                        class22.addMenuEntry(Client.field489, Client.field472 + " " + "->" + " " + class116.method2288(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var5 = var0.field3037 && Client.field346?2000:0;
                     String[] var6 = var0.actions;
                     if(Client.field484) {
                        var6 = Item.method875(var6);
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
                                 var8 = 10 + var5;
                              }

                              if(var7 == 2) {
                                 var8 = var5 + 11;
                              }

                              if(var7 == 3) {
                                 var8 = var5 + 12;
                              }

                              if(var7 == 4) {
                                 var8 = 13 + var5;
                              }

                              class22.addMenuEntry(var6[var7], class116.method2288(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var6 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var6[var7] != null && var6[var7].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(Client.field337 != class40.field836) {
                                 if(class40.field835 == Client.field337 || class40.field839 == Client.field337 && var0.combatLevel > class22.localPlayer.combatLevel) {
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
                                    var8 = 11 + var9;
                                 }

                                 if(var7 == 3) {
                                    var8 = 12 + var9;
                                 }

                                 if(var7 == 4) {
                                    var8 = var9 + 13;
                                 }

                                 class22.addMenuEntry(var6[var7], class116.method2288(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3037 || !Client.field346) {
                        class22.addMenuEntry("Examine", class116.method2288(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }
}
