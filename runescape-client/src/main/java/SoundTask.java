import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
@Implements("SoundTask")
public class SoundTask implements Runnable {
   @ObfuscatedName("t")
   public static short[][] field1648;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[Ldk;"
   )
   @Export("systems")
   volatile AbstractSoundSystem[] systems;

   SoundTask() {
      this.systems = new AbstractSoundSystem[2];
   }

   public void run() {
      try {
         for(int var1 = 0; var1 < 2; ++var1) {
            AbstractSoundSystem var2 = this.systems[var1];
            if(var2 != null) {
               var2.method2084();
            }
         }
      } catch (Exception var4) {
         DynamicObject.method1932((String)null, var4);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILhh;B)I",
      garbageValue = "103"
   )
   public static int method2152(int var0, class219 var1) {
      return (var0 << 8) + var1.field2796;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILcv;ZS)I",
      garbageValue = "-31309"
   )
   static int method2155(int var0, Script var1, boolean var2) {
      if(var0 == 5630) {
         Client.field974 = 250;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(Lid;IIIB)V",
      garbageValue = "-77"
   )
   static final void method2153(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.transform();
         }

         if(var0 != null) {
            if(var0.field3586) {
               if(!var0.field3588 || Client.field1081 == var1) {
                  String var4 = var0.name;
                  int var7;
                  int var8;
                  if(var0.combatLevel != 0) {
                     var7 = var0.combatLevel;
                     var8 = AbstractByteBuffer.localPlayer.combatLevel;
                     int var9 = var8 - var7;
                     String var6;
                     if(var9 < -9) {
                        var6 = class60.getColTags(16711680);
                     } else if(var9 < -6) {
                        var6 = class60.getColTags(16723968);
                     } else if(var9 < -3) {
                        var6 = class60.getColTags(16740352);
                     } else if(var9 < 0) {
                        var6 = class60.getColTags(16756736);
                     } else if(var9 > 9) {
                        var6 = class60.getColTags('\uff00');
                     } else if(var9 > 6) {
                        var6 = class60.getColTags(4259584);
                     } else if(var9 > 3) {
                        var6 = class60.getColTags(8453888);
                     } else if(var9 > 0) {
                        var6 = class60.getColTags(12648192);
                     } else {
                        var6 = class60.getColTags(16776960);
                     }

                     var4 = var4 + var6 + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3588 && Client.field1060) {
                     class10.addMenuEntry("Examine", class60.getColTags(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.itemSelectionState == 1) {
                     class10.addMenuEntry("Use", Client.field1067 + " " + "->" + " " + class60.getColTags(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.spellSelected) {
                     if((WorldMapType1.field451 & 2) == 2) {
                        class10.addMenuEntry(Client.field1071, Client.field948 + " " + "->" + " " + class60.getColTags(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var10 = var0.field3588 && Client.field1060?2000:0;
                     String[] var11 = var0.actions;
                     if(Client.field978) {
                        var11 = DecorativeObject.method2966(var11);
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

                              class10.addMenuEntry(var11[var7], class60.getColTags(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var11 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var11[var7] != null && var11[var7].equalsIgnoreCase("Attack")) {
                              short var12 = 0;
                              if(class89.field1403 != Client.field947) {
                                 if(class89.field1401 == Client.field947 || Client.field947 == class89.field1404 && var0.combatLevel > AbstractByteBuffer.localPlayer.combatLevel) {
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

                                 class10.addMenuEntry(var11[var7], class60.getColTags(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3588 || !Client.field1060) {
                        class10.addMenuEntry("Examine", class60.getColTags(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }
}
