import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public enum class232 implements Enumerated {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field2923(0, 0),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field2921(1, 0),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field2920(2, 0),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field2918(3, 0),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field2929(9, 2),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field2934(4, 1),
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field2924(5, 1),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field2922(6, 1),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field2926(7, 1),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field2927(8, 1),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field2928(12, 2),
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field2932(13, 2),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field2940(14, 2),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field2931(15, 2),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field2930(16, 2),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field2933(17, 2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field2925(18, 2),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field2935(19, 2),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field2936(20, 2),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field2937(21, 2),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field2938(10, 2),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field2939(11, 2),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field2919(22, 3);

   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -929274249
   )
   public final int field2941;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class232(int var3, int var4) {
      this.field2941 = var3;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1035813094"
   )
   public int rsOrdinal() {
      return this.field2941;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "79"
   )
   static final int method4209() {
      return class133.Viewport_mouseX;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1460359231"
   )
   protected static int method4205() {
      int var0 = 0;
      if(PlayerComposition.field2738 == null || !PlayerComposition.field2738.isValid()) {
         try {
            Iterator var1 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

            while(var1.hasNext()) {
               GarbageCollectorMXBean var2 = (GarbageCollectorMXBean)var1.next();
               if(var2.isValid()) {
                  PlayerComposition.field2738 = var2;
                  GameEngine.garbageCollectorLastCheckTimeMs = -1L;
                  GameEngine.garbageCollectorLastCollectionTime = -1L;
               }
            }
         } catch (Throwable var11) {
            ;
         }
      }

      if(PlayerComposition.field2738 != null) {
         long var9 = Preferences.currentTimeMs();
         long var3 = PlayerComposition.field2738.getCollectionTime();
         if(GameEngine.garbageCollectorLastCollectionTime != -1L) {
            long var5 = var3 - GameEngine.garbageCollectorLastCollectionTime;
            long var7 = var9 - GameEngine.garbageCollectorLastCheckTimeMs;
            if(var7 != 0L) {
               var0 = (int)(100L * var5 / var7);
            }
         }

         GameEngine.garbageCollectorLastCollectionTime = var3;
         GameEngine.garbageCollectorLastCheckTimeMs = var9;
      }

      return var0;
   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(Ljn;IIIB)V",
      garbageValue = "-111"
   )
   static final void method4202(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.transform();
         }

         if(var0 != null) {
            if(var0.field3643) {
               if(!var0.field3654 || Client.field996 == var1) {
                  String var4 = var0.name;
                  int var7;
                  int var8;
                  if(var0.combatLevel != 0) {
                     var7 = var0.combatLevel;
                     var8 = UrlRequest.localPlayer.combatLevel;
                     int var9 = var8 - var7;
                     String var6;
                     if(var9 < -9) {
                        var6 = Buffer.getColTags(16711680);
                     } else if(var9 < -6) {
                        var6 = Buffer.getColTags(16723968);
                     } else if(var9 < -3) {
                        var6 = Buffer.getColTags(16740352);
                     } else if(var9 < 0) {
                        var6 = Buffer.getColTags(16756736);
                     } else if(var9 > 9) {
                        var6 = Buffer.getColTags(65280);
                     } else if(var9 > 6) {
                        var6 = Buffer.getColTags(4259584);
                     } else if(var9 > 3) {
                        var6 = Buffer.getColTags(8453888);
                     } else if(var9 > 0) {
                        var6 = Buffer.getColTags(12648192);
                     } else {
                        var6 = Buffer.getColTags(16776960);
                     }

                     var4 = var4 + var6 + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3654 && Client.field975) {
                     class37.addMenuEntry("Examine", Buffer.getColTags(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.itemSelectionState == 1) {
                     class37.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + Buffer.getColTags(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.spellSelected) {
                     if((class86.field1278 & 2) == 2) {
                        class37.addMenuEntry(Client.field986, Client.field910 + " " + "->" + " " + Buffer.getColTags(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var10 = var0.field3654 && Client.field975?2000:0;
                     String[] var11 = var0.actions;
                     if(Client.numberMenuOptions) {
                        var11 = GameEngine.prependIndices(var11);
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

                              class37.addMenuEntry(var11[var7], Buffer.getColTags(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var11 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var11[var7] != null && var11[var7].equalsIgnoreCase("Attack")) {
                              short var12 = 0;
                              if(AttackOption.AttackOption_hidden != Client.npcAttackOption) {
                                 if(Client.npcAttackOption == AttackOption.AttackOption_alwaysRightClick || Client.npcAttackOption == AttackOption.AttackOption_dependsOnCombatLevels && var0.combatLevel > UrlRequest.localPlayer.combatLevel) {
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

                                 class37.addMenuEntry(var11[var7], Buffer.getColTags(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3654 || !Client.field975) {
                        class37.addMenuEntry("Examine", Buffer.getColTags(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }
}
