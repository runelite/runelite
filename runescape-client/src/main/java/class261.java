import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
public class class261 {
   @ObfuscatedName("n")
   public static final class261 field3627;
   @ObfuscatedName("i")
   public static final class261 field3628;
   @ObfuscatedName("ec")
   static Font field3629;
   @ObfuscatedName("f")
   public static final class261 field3630;
   @ObfuscatedName("j")
   public static final class261 field3631;
   @ObfuscatedName("c")
   final String field3632;
   @ObfuscatedName("z")
   String field3633;
   @ObfuscatedName("m")
   public static final class261 field3634;
   @ObfuscatedName("p")
   public static final class261 field3635;

   static {
      field3627 = new class261("PLAIN11", "p11_full");
      field3635 = new class261("PLAIN12", "p12_full");
      field3628 = new class261("BOLD12", "b12_full");
      field3631 = new class261("VERDANA11", "verdana_11pt_regular");
      field3630 = new class261("VERDANA13", "verdana_13pt_regular");
      field3634 = new class261("VERDANA15", "verdana_15pt_regular");
   }

   class261(String var1, String var2) {
      this.field3632 = var1;
      this.field3633 = var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)[Lclass261;",
      garbageValue = "-1090811738"
   )
   public static class261[] method4760() {
      return new class261[]{field3630, field3635, field3628, field3634, field3631, field3627};
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(LWidget;II)I",
      garbageValue = "-1509108456"
   )
   static final int method4763(Widget var0, int var1) {
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
                  var10 = class177.method3390(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!ItemComposition.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var10.itemIds[var12] == var11 + 1) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class211.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class222.field2839[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class211.widgetSettings[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = class168.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class222.field2840[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class177.method3390(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!ItemComposition.getItemDefinition(var11).isMembers || Client.isMembers)) {
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
                  var9 = class211.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class205.method3843(var9);
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
                  var7 = class61.baseX + (class168.localPlayer.x >> 7);
               }

               if(var6 == 19) {
                  var7 = (class168.localPlayer.y >> 7) + class23.baseY;
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

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "-1402337071"
   )
   static final void method4764(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method4764(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method3545((long)var3.id);
               if(var4 != null) {
                  int var5 = var4.id;
                  if(class73.method1095(var5)) {
                     method4764(Widget.widgets[var5], var1);
                  }
               }
            }

            class69 var6;
            if(var1 == 0 && var3.field2759 != null) {
               var6 = new class69();
               var6.field824 = var3;
               var6.field833 = var3.field2759;
               class227.method4101(var6);
            }

            if(var1 == 1 && var3.field2760 != null) {
               if(var3.index >= 0) {
                  Widget var7 = class177.method3390(var3.id);
                  if(var7 == null || var7.children == null || var3.index >= var7.children.length || var7.children[var3.index] != var3) {
                     continue;
                  }
               }

               var6 = new class69();
               var6.field824 = var3;
               var6.field833 = var3.field2760;
               class227.method4101(var6);
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "93"
   )
   public static boolean method4765(int var0) {
      return (var0 >> 29 & 1) != 0;
   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2090186080"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class92.plane][var0][var1];
      if(var2 == null) {
         class61.region.method2747(class92.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.method3622(); var6 != null; var6 = (Item)var2.method3608()) {
            ItemComposition var7 = ItemComposition.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class61.region.method2747(class92.plane, var0, var1);
         } else {
            var2.method3603(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.method3622(); var6 != null; var6 = (Item)var2.method3608()) {
               if(var5.id != var6.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var6.id != var11.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = (var1 << 7) + var0 + 1610612736;
            class61.region.method2682(class92.plane, var0, var1, class181.method3424(var0 * 128 + 64, var1 * 128 + 64, class92.plane), var5, var9, var11, var10);
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "144401780"
   )
   static final int method4767(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = Item.method1739(var3, var5);
      int var8 = Item.method1739(var3 + 1, var5);
      int var9 = Item.method1739(var3, var5 + 1);
      int var10 = Item.method1739(var3 + 1, var5 + 1);
      int var11 = class39.method541(var7, var8, var4, var2);
      int var12 = class39.method541(var9, var10, var4, var2);
      return class39.method541(var11, var12, var6, var2);
   }
}
