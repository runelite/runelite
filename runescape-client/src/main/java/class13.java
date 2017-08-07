import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public class class13 {
   @ObfuscatedName("n")
   public static Comparator field280;
   @ObfuscatedName("g")
   public static Comparator field278;
   @ObfuscatedName("y")
   public static Comparator field277;
   @ObfuscatedName("w")
   public static Comparator field285;
   @ObfuscatedName("p")
   static int[] field276;
   @ObfuscatedName("e")
   public final List field279;

   static {
      field280 = new class19();
      new class12();
      field278 = new class17();
      field277 = new class18();
      field285 = new class15();
   }

   @ObfuscatedSignature(
      signature = "(Lfh;Z)V",
      garbageValue = "1"
   )
   public class13(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.field279 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field279.add(new class14(var1, var5, var3));
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "-289214238"
   )
   public void method64(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field279, var1);
      } else {
         Collections.sort(this.field279, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(Lin;IIIB)V",
      garbageValue = "38"
   )
   static final void method68(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.transform();
         }

         if(var0 != null) {
            if(var0.field3574) {
               if(!var0.field3559 || Client.field954 == var1) {
                  String var4 = var0.name;
                  int var7;
                  int var8;
                  if(var0.combatLevel != 0) {
                     var7 = var0.combatLevel;
                     var8 = class54.localPlayer.combatLevel;
                     int var9 = var8 - var7;
                     String var6;
                     if(var9 < -9) {
                        var6 = RSSocket.getColTags(16711680);
                     } else if(var9 < -6) {
                        var6 = RSSocket.getColTags(16723968);
                     } else if(var9 < -3) {
                        var6 = RSSocket.getColTags(16740352);
                     } else if(var9 < 0) {
                        var6 = RSSocket.getColTags(16756736);
                     } else if(var9 > 9) {
                        var6 = RSSocket.getColTags('\uff00');
                     } else if(var9 > 6) {
                        var6 = RSSocket.getColTags(4259584);
                     } else if(var9 > 3) {
                        var6 = RSSocket.getColTags(8453888);
                     } else if(var9 > 0) {
                        var6 = RSSocket.getColTags(12648192);
                     } else {
                        var6 = RSSocket.getColTags(16776960);
                     }

                     var4 = var4 + var6 + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3559 && Client.field1142) {
                     class165.addMenuEntry("Examine", RSSocket.getColTags(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.itemSelectionState == 1) {
                     class165.addMenuEntry("Use", Client.field1056 + " " + "->" + " " + RSSocket.getColTags(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.spellSelected) {
                     if((class1.field4 & 2) == 2) {
                        class165.addMenuEntry(Client.field997, Client.field1061 + " " + "->" + " " + RSSocket.getColTags(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var10 = var0.field3559 && Client.field1142?2000:0;
                     String[] var11 = var0.actions;
                     if(Client.field934) {
                        var11 = class84.method1685(var11);
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

                              class165.addMenuEntry(var11[var7], RSSocket.getColTags(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var11 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var11[var7] != null && var11[var7].equalsIgnoreCase("Attack")) {
                              short var12 = 0;
                              if(Client.field1089 != class92.field1410) {
                                 if(class92.field1417 == Client.field1089 || Client.field1089 == class92.field1408 && var0.combatLevel > class54.localPlayer.combatLevel) {
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

                                 class165.addMenuEntry(var11[var7], RSSocket.getColTags(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3559 || !Client.field1142) {
                        class165.addMenuEntry("Examine", RSSocket.getColTags(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-976189237"
   )
   static void method67(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < ItemComposition.field3480; ++var4) {
         ItemComposition var5 = ClassInfo.getItemDefinition(var4);
         if((!var1 || var5.field3521) && var5.notedTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               class25.field373 = -1;
               MilliTimer.field2190 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      MilliTimer.field2190 = var2;
      WidgetNode.field827 = 0;
      class25.field373 = var3;
      String[] var8 = new String[class25.field373];

      for(int var9 = 0; var9 < class25.field373; ++var9) {
         var8[var9] = ClassInfo.getItemDefinition(var2[var9]).name;
      }

      ScriptVarType.method26(var8, MilliTimer.field2190);
   }
}
