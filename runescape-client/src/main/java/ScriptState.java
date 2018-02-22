import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("v")
   static int[] field700;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1097029829
   )
   static int field706;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = -100186593
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lca;"
   )
   @Export("invokedFromScript")
   Script invokedFromScript;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1709942147
   )
   @Export("invokedFromPc")
   int invokedFromPc;
   @ObfuscatedName("o")
   @Export("savedLocalInts")
   int[] savedLocalInts;
   @ObfuscatedName("p")
   @Export("savedLocalStrings")
   String[] savedLocalStrings;

   ScriptState() {
      this.invokedFromPc = -1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-82"
   )
   public static void method1103() {
      try {
         if(class223.field2646 == 1) {
            int var0 = class155.field2105.method4135();
            if(var0 > 0 && class155.field2105.method4180()) {
               var0 -= VertexNormal.field1888;
               if(var0 < 0) {
                  var0 = 0;
               }

               class155.field2105.method4134(var0);
               return;
            }

            class155.field2105.method4140();
            class155.field2105.method4138();
            if(Huffman.field2471 != null) {
               class223.field2646 = 2;
            } else {
               class223.field2646 = 0;
            }

            class46.field550 = null;
            Item.field1366 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class155.field2105.method4140();
         class223.field2646 = 0;
         class46.field550 = null;
         Item.field1366 = null;
         Huffman.field2471 = null;
      }

   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(Lim;II)I",
      garbageValue = "1715638873"
   )
   static final int method1104(Widget var0, int var1) {
      if(var0.dynamicValues != null && var1 < var0.dynamicValues.length) {
         try {
            int[] var2 = var0.dynamicValues[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = Client.boostedSkillLevels[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = Client.realSkillLevels[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = Client.skillExperiences[var2[var4++]];
               }

               int var9;
               Widget var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = NetWriter.getWidget(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!ContextMenuRow.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class231.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class242.field2961[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class231.widgetSettings[var2[var4++]] * 100 / 46875;
               }

               if(var6 == 8) {
                  var7 = OwnWorldComparator.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class242.field2959[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = NetWriter.getWidget(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!ContextMenuRow.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = Client.energy;
               }

               if(var6 == 12) {
                  var7 = Client.weight;
               }

               if(var6 == 13) {
                  var9 = class231.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class28.getVarbit(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = (OwnWorldComparator.localPlayer.x >> 7) + baseX;
               }

               if(var6 == 19) {
                  var7 = (OwnWorldComparator.localPlayer.y >> 7) + WorldMapType1.baseY;
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }

   @ObfuscatedName("kd")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-2010728332"
   )
   static void method1102(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < FriendManager.field1197; ++var4) {
         ItemComposition var5 = ContextMenuRow.getItemDefinition(var4);
         if((!var1 || var5.isTradable) && var5.notedTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               Item.field1367 = -1;
               NetWriter.field1432 = null;
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

      NetWriter.field1432 = var2;
      GrandExchangeEvents.field268 = 0;
      Item.field1367 = var3;
      String[] var8 = new String[Item.field1367];

      for(int var9 = 0; var9 < Item.field1367; ++var9) {
         var8[var9] = ContextMenuRow.getItemDefinition(var2[var9]).name;
      }

      World.method1680(var8, NetWriter.field1432);
   }
}
