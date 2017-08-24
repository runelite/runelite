import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -736885083
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 103296511
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 894408259
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 458464099
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -387411869
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -914532633
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -261433413
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -834535881
   )
   @Export("x")
   int x;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1835013323
   )
   @Export("y")
   int y;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 186849019
   )
   @Export("height")
   int height;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lew;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -242865057
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1955198605
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -571924079
   )
   @Export("drawPriority")
   int drawPriority;

   GameObject() {
      this.hash = 0;
      this.flags = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Liq;",
      garbageValue = "-174436540"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.objects.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.objects_ref.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         if(var1.isSolid) {
            var1.interactType = 0;
            var1.field3452 = false;
         }

         ObjectComposition.objects.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(Lhx;II)I",
      garbageValue = "496840329"
   )
   static final int method2942(Widget var0, int var1) {
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
                  var10 = GZipDecompressor.method3177(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class169.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var10.itemIds[var12] == var11 + 1) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class212.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class223.field2847[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class212.widgetSettings[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = Player.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class223.field2845[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = GZipDecompressor.method3177(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class169.getItemDefinition(var11).isMembers || Client.isMembers)) {
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
                  var9 = class212.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = WidgetNode.method1121(var9);
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
                  var7 = (Player.localPlayer.x >> 7) + class149.baseX;
               }

               if(var6 == 19) {
                  var7 = (Player.localPlayer.y >> 7) + class67.baseY;
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-879322116"
   )
   public static void method2943() {
      class281.field3757 = new CombatInfoList();
   }
}
