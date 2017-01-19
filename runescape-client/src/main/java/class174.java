import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public class class174 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lclass178;",
      garbageValue = "89578385"
   )
   public static class178 method3150(int var0) {
      class178[] var1 = new class178[]{class178.field2683, class178.field2680, class178.field2681, class178.field2682};
      class178[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class178 var4 = var2[var3];
         if(var4.field2684 == var0) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "1"
   )
   static int method3151(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method2274((long)var0);
      return null == var2?0:(var1 >= 0 && var1 < var2.stackSizes.length?var2.stackSizes[var1]:0);
   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(LNPCComposition;IIII)V",
      garbageValue = "16711680"
   )
   static final void method3152(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(null != var0.configs) {
            var0 = var0.method3576();
         }

         if(null != var0) {
            if(var0.field3037) {
               if(!var0.field3039 || Client.field459 == var1) {
                  String var4 = var0.name;
                  if(var0.combatLevel != 0) {
                     var4 = var4 + class109.method2000(var0.combatLevel, XItemContainer.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(Client.field412 == 1) {
                     class214.addMenuEntry("Use", Client.field322 + " " + "->" + " " + Actor.method574(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.field446) {
                     if((NPC.field760 & 2) == 2) {
                        class214.addMenuEntry(Client.field449, Client.field450 + " " + "->" + " " + Actor.method574(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     String[] var5 = var0.actions;
                     if(Client.field462) {
                        var5 = class11.method133(var5);
                     }

                     int var6;
                     if(null != var5) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(null != var5[var6] && !var5[var6].equalsIgnoreCase("Attack")) {
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

                              class214.addMenuEntry(var5[var6], Actor.method574(16776960) + var4, var7, var1, var2, var3);
                           }
                        }
                     }

                     if(null != var5) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(var5[var6] != null && var5[var6].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(Client.field320 != class40.field806) {
                                 if(class40.field803 == Client.field320 || class40.field805 == Client.field320 && var0.combatLevel > XItemContainer.localPlayer.combatLevel) {
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

                                 class214.addMenuEntry(var5[var6], Actor.method574(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     class214.addMenuEntry("Examine", Actor.method574(16776960) + var4, 1003, var1, var2, var3);
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)Z",
      garbageValue = "1565032794"
   )
   public static boolean method3153(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  return false;
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               return false;
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var1 * var5 + var10;
            if(var5 != var9 / var1) {
               return false;
            }

            var5 = var9;
            var4 = true;
         }

         return var4;
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
