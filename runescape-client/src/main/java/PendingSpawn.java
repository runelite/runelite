import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -290209351
   )
   @Export("level")
   int level;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 592789797
   )
   @Export("type")
   int type;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -199507877
   )
   @Export("x")
   int x;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1900059897
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2088127695
   )
   int field1103;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1689253859
   )
   int field1104;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1067382779
   )
   int field1105;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 35287899
   )
   @Export("id")
   int id;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2025376845
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1624567503
   )
   int field1108;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1225171633
   )
   @Export("delay")
   int delay;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1675793593
   )
   @Export("hitpoints")
   int hitpoints;

   PendingSpawn() {
      this.delay = 0;
      this.hitpoints = -1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgz;III)I",
      garbageValue = "911303531"
   )
   static int method1591(IterableHashTable var0, int var1, int var2) {
      if(var0 == null) {
         return var2;
      } else {
         IntegerNode var3 = (IntegerNode)var0.get((long)var1);
         return var3 == null?var2:var3.value;
      }
   }

   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "(Lhs;IIZI)V",
      garbageValue = "1817611634"
   )
   static void method1593(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.dynamicWidth == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.dynamicWidth == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.dynamicWidth == 2) {
         var0.width = var0.originalWidth * var1 >> 14;
      }

      if(var0.buttonType == 0) {
         var0.height = var0.originalHeight;
      } else if(var0.buttonType == 1) {
         var0.height = var2 - var0.originalHeight;
      } else if(var0.buttonType == 2) {
         var0.height = var2 * var0.originalHeight >> 14;
      }

      if(var0.dynamicWidth == 4) {
         var0.width = var0.height * var0.field2771 / var0.field2772;
      }

      if(var0.buttonType == 4) {
         var0.height = var0.field2772 * var0.width / var0.field2771;
      }

      if(Client.field1098 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field1003 = var0;
      }

      if(var3 && var0.field2812 != null && (var4 != var0.width || var5 != var0.height)) {
         ScriptEvent var6 = new ScriptEvent();
         var6.widget = var0;
         var6.objs = var0.field2812;
         Client.field1023.addFront(var6);
      }

   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(Lhs;II)I",
      garbageValue = "1658747100"
   )
   static final int method1592(Widget var0, int var1) {
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
                  var10 = class216.getWidget(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!ItemContainer.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class222.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class233.field2941[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class222.widgetSettings[var2[var4++]] * 100 / 46875;
               }

               if(var6 == 8) {
                  var7 = GroundObject.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class233.field2940[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class216.getWidget(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!ItemContainer.getItemDefinition(var11).isMembers || Client.isMembers)) {
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
                  var9 = class222.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = BoundingBox3DDrawMode.getVarbit(var9);
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
                  var7 = (GroundObject.localPlayer.x >> 7) + ClanMemberManager.baseX;
               }

               if(var6 == 19) {
                  var7 = (GroundObject.localPlayer.y >> 7) + WorldMapData.baseY;
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
}
