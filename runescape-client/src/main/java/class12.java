import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
final class class12 implements Comparator {
   @ObfuscatedName("cw")
   @Export("indexMaps")
   static IndexData indexMaps;
   @ObfuscatedName("e")
   @Export("overlayPaths")
   static byte[][][] overlayPaths;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "705783682"
   )
   int method61(class14 var1, class14 var2) {
      return var1.field301 < var2.field301?-1:(var2.field301 == var1.field301?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method61((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)[Lclass239;",
      garbageValue = "-87"
   )
   static class239[] method72() {
      return new class239[]{class239.field3275, class239.field3274, class239.field3278};
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-696932353"
   )
   static void method67() {
      for(class82 var0 = (class82)class82.field1322.getFront(); var0 != null; var0 = (class82)class82.field1322.getNext()) {
         if(var0.field1324 != null) {
            class203.field2511.method1867(var0.field1324);
            var0.field1324 = null;
         }

         if(var0.field1321 != null) {
            class203.field2511.method1867(var0.field1321);
            var0.field1321 = null;
         }
      }

      class82.field1322.clear();
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(LNPCComposition;IIII)V",
      garbageValue = "43376750"
   )
   static final void method65(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.transform();
         }

         if(var0 != null) {
            if(var0.field3584) {
               if(!var0.field3586 || Client.field1074 == var1) {
                  String var4 = var0.name;
                  int var7;
                  int var8;
                  if(var0.combatLevel != 0) {
                     var7 = var0.combatLevel;
                     var8 = Script.localPlayer.combatLevel;
                     int var9 = var8 - var7;
                     String var6;
                     if(var9 < -9) {
                        var6 = class46.getColTags(16711680);
                     } else if(var9 < -6) {
                        var6 = class46.getColTags(16723968);
                     } else if(var9 < -3) {
                        var6 = class46.getColTags(16740352);
                     } else if(var9 < 0) {
                        var6 = class46.getColTags(16756736);
                     } else if(var9 > 9) {
                        var6 = class46.getColTags('\uff00');
                     } else if(var9 > 6) {
                        var6 = class46.getColTags(4259584);
                     } else if(var9 > 3) {
                        var6 = class46.getColTags(8453888);
                     } else if(var9 > 0) {
                        var6 = class46.getColTags(12648192);
                     } else {
                        var6 = class46.getColTags(16776960);
                     }

                     var4 = var4 + var6 + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3586 && Client.field1052) {
                     class37.addMenuEntry("Examine", class46.getColTags(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.itemSelectionState == 1) {
                     class37.addMenuEntry("Use", Client.selectedItemName + " " + "->" + " " + class46.getColTags(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.spellSelected) {
                     if((class116.field1676 & 2) == 2) {
                        class37.addMenuEntry(Client.field1064, Client.field1019 + " " + "->" + " " + class46.getColTags(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var10 = var0.field3586 && Client.field1052?2000:0;
                     String[] var11 = var0.actions;
                     if(Client.field1026) {
                        var11 = class34.method481(var11);
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

                              class37.addMenuEntry(var11[var7], class46.getColTags(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var11 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var11[var7] != null && var11[var7].equalsIgnoreCase("Attack")) {
                              short var12 = 0;
                              if(Client.field932 != class91.field1409) {
                                 if(Client.field932 == class91.field1416 || class91.field1410 == Client.field932 && var0.combatLevel > Script.localPlayer.combatLevel) {
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

                                 class37.addMenuEntry(var11[var7], class46.getColTags(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3586 || !Client.field1052) {
                        class37.addMenuEntry("Examine", class46.getColTags(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)LWidget;",
      garbageValue = "1473459012"
   )
   public static Widget method70(int var0, int var1) {
      Widget var2 = class61.method1038(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILScript;ZS)I",
      garbageValue = "-29528"
   )
   static int method69(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 5504) {
         WorldMapType2.intStackSize -= 2;
         var3 = class83.intStack[WorldMapType2.intStackSize];
         int var4 = class83.intStack[WorldMapType2.intStackSize + 1];
         if(!Client.field1152) {
            Client.field989 = var3;
            Client.mapAngle = var4;
         }

         return 1;
      } else if(var0 == 5505) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = Client.field989;
         return 1;
      } else if(var0 == 5506) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = Client.mapAngle;
         return 1;
      } else if(var0 == 5530) {
         var3 = class83.intStack[--WorldMapType2.intStackSize];
         if(var3 < 0) {
            var3 = 0;
         }

         Client.field995 = var3;
         return 1;
      } else if(var0 == 5531) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = Client.field995;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "465540724"
   )
   public static boolean method71(int var0) {
      return (var0 & 1) != 0;
   }
}
