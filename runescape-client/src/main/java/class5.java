import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
final class class5 implements Comparator {
   @ObfuscatedName("z")
   static int[] field47;
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = 60796343
   )
   static int field51;
   @ObfuscatedName("el")
   static SpritePixels[] field52;

   public int compare(Object var1, Object var2) {
      return this.method80((class2)var1, (class2)var2);
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(LNPCComposition;IIII)V",
      garbageValue = "-342707588"
   )
   static final void method73(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.method3729();
         }

         if(null != var0) {
            if(var0.field3014) {
               if(!var0.field3016 || var1 == Client.field445) {
                  String var4 = var0.name;
                  if(var0.combatLevel != 0) {
                     var4 = var4 + class10.method128(var0.combatLevel, VertexNormal.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(Client.field525 == 1) {
                     class20.addMenuEntry("Use", Client.field431 + " " + "->" + " " + class163.method3157(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.field432) {
                     if((ItemComposition.field2939 & 2) == 2) {
                        class20.addMenuEntry(Client.field435, Client.field436 + " " + "->" + " " + class163.method3157(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     String[] var5 = var0.actions;
                     if(Client.field394) {
                        var5 = XItemContainer.method170(var5);
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

                              class20.addMenuEntry(var5[var6], class163.method3157(16776960) + var4, var7, var1, var2, var3);
                           }
                        }
                     }

                     if(null != var5) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(null != var5[var6] && var5[var6].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(Client.field305 != class40.field810) {
                                 if(class40.field817 == Client.field305 || Client.field305 == class40.field818 && var0.combatLevel > VertexNormal.localPlayer.combatLevel) {
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
                                    var8 = 11 + var9;
                                 }

                                 if(var6 == 3) {
                                    var8 = 12 + var9;
                                 }

                                 if(var6 == 4) {
                                    var8 = var9 + 13;
                                 }

                                 class20.addMenuEntry(var5[var6], class163.method3157(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     class20.addMenuEntry("Examine", class163.method3157(16776960) + var4, 1003, var1, var2, var3);
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1338273781"
   )
   static final void method74(int var0, int var1) {
      if(Client.menuOptionCount >= 2 || Client.field525 != 0 || Client.field432) {
         String var2;
         if(Client.field525 == 1 && Client.menuOptionCount < 2) {
            var2 = "Use" + " " + Client.field431 + " " + "->";
         } else if(Client.field432 && Client.menuOptionCount < 2) {
            var2 = Client.field435 + " " + Client.field436 + " " + "->";
         } else {
            int var4 = Client.menuOptionCount - 1;
            String var3;
            if(Client.menuTargets[var4].length() > 0) {
               var3 = Client.menuOptions[var4] + " " + Client.menuTargets[var4];
            } else {
               var3 = Client.menuOptions[var4];
            }

            var2 = var3;
         }

         if(Client.menuOptionCount > 2) {
            var2 = var2 + class163.method3157(16777215) + " " + '/' + " " + (Client.menuOptionCount - 2) + " more options";
         }

         class16.field176.method3930(var2, 4 + var0, 15 + var1, 16777215, 0, Client.gameCycle / 1000);
      }
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;B)I",
      garbageValue = "23"
   )
   int method80(class2 var1, class2 var2) {
      return var1.field22.price < var2.field22.price?-1:(var1.field22.price == var2.field22.price?0:1);
   }
}
