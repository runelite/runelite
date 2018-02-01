import java.awt.FontMetrics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
@Implements("BoundingBox")
public abstract class BoundingBox extends Node {
   @ObfuscatedName("ay")
   static FontMetrics field238;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "160"
   )
   @Export("draw")
   abstract void draw();

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-61"
   )
   static int method61(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.itemIds.length?var2.itemIds[var1]:-1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "1011089548"
   )
   public static String method65(CharSequence var0) {
      long var3 = 0L;
      int var5 = var0.length();

      for(int var6 = 0; var6 < var5; ++var6) {
         var3 *= 37L;
         char var7 = var0.charAt(var6);
         if(var7 >= 'A' && var7 <= 'Z') {
            var3 += (long)(var7 + 1 - 65);
         } else if(var7 >= 'a' && var7 <= 'z') {
            var3 += (long)(var7 + 1 - 97);
         } else if(var7 >= '0' && var7 <= '9') {
            var3 += (long)(var7 + 27 - 48);
         }

         if(var3 >= 177917621779460413L) {
            break;
         }
      }

      while(var3 % 37L == 0L && var3 != 0L) {
         var3 /= 37L;
      }

      String var8 = class268.method4895(var3);
      if(var8 == null) {
         var8 = "";
      }

      return var8;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILcd;ZI)I",
      garbageValue = "-326715872"
   )
   static int method62(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 4200) {
         var3 = class80.intStack[--class80.intStackSize];
         class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = CombatInfo1.getItemDefinition(var3).name;
         return 1;
      } else {
         int var4;
         ItemComposition var17;
         if(var0 == 4201) {
            class80.intStackSize -= 2;
            var3 = class80.intStack[class80.intStackSize];
            var4 = class80.intStack[class80.intStackSize + 1];
            var17 = CombatInfo1.getItemDefinition(var3);
            if(var4 >= 1 && var4 <= 5 && var17.groundActions[var4 - 1] != null) {
               class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var17.groundActions[var4 - 1];
            } else {
               class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4202) {
            class80.intStackSize -= 2;
            var3 = class80.intStack[class80.intStackSize];
            var4 = class80.intStack[class80.intStackSize + 1];
            var17 = CombatInfo1.getItemDefinition(var3);
            if(var4 >= 1 && var4 <= 5 && var17.inventoryActions[var4 - 1] != null) {
               class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var17.inventoryActions[var4 - 1];
            } else {
               class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4203) {
            var3 = class80.intStack[--class80.intStackSize];
            class80.intStack[++class80.intStackSize - 1] = CombatInfo1.getItemDefinition(var3).price;
            return 1;
         } else if(var0 == 4204) {
            var3 = class80.intStack[--class80.intStackSize];
            class80.intStack[++class80.intStackSize - 1] = CombatInfo1.getItemDefinition(var3).isStackable == 1?1:0;
            return 1;
         } else {
            ItemComposition var13;
            if(var0 == 4205) {
               var3 = class80.intStack[--class80.intStackSize];
               var13 = CombatInfo1.getItemDefinition(var3);
               if(var13.notedTemplate == -1 && var13.note >= 0) {
                  class80.intStack[++class80.intStackSize - 1] = var13.note;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4206) {
               var3 = class80.intStack[--class80.intStackSize];
               var13 = CombatInfo1.getItemDefinition(var3);
               if(var13.notedTemplate >= 0 && var13.note >= 0) {
                  class80.intStack[++class80.intStackSize - 1] = var13.note;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4207) {
               var3 = class80.intStack[--class80.intStackSize];
               class80.intStack[++class80.intStackSize - 1] = CombatInfo1.getItemDefinition(var3).isMembers?1:0;
               return 1;
            } else if(var0 == 4208) {
               var3 = class80.intStack[--class80.intStackSize];
               var13 = CombatInfo1.getItemDefinition(var3);
               if(var13.int3 == -1 && var13.int2 >= 0) {
                  class80.intStack[++class80.intStackSize - 1] = var13.int2;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4209) {
               var3 = class80.intStack[--class80.intStackSize];
               var13 = CombatInfo1.getItemDefinition(var3);
               if(var13.int3 >= 0 && var13.int2 >= 0) {
                  class80.intStack[++class80.intStackSize - 1] = var13.int2;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4210) {
               String var14 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
               var4 = class80.intStack[--class80.intStackSize];
               boolean var6 = var4 == 1;
               String var5 = var14.toLowerCase();
               short[] var7 = new short[16];
               int var8 = 0;
               int var9 = 0;

               while(true) {
                  if(var9 >= SoundTask.field1549) {
                     GroundObject.field1746 = var7;
                     class61.field693 = 0;
                     Script.field1420 = var8;
                     String[] var15 = new String[Script.field1420];

                     for(int var16 = 0; var16 < Script.field1420; ++var16) {
                        var15[var16] = CombatInfo1.getItemDefinition(var7[var16]).name;
                     }

                     short[] var18 = GroundObject.field1746;
                     GameCanvas.method773(var15, var18, 0, var15.length - 1);
                     break;
                  }

                  ItemComposition var10 = CombatInfo1.getItemDefinition(var9);
                  if((!var6 || var10.isTradable) && var10.notedTemplate == -1 && var10.name.toLowerCase().indexOf(var5) != -1) {
                     if(var8 >= 250) {
                        Script.field1420 = -1;
                        GroundObject.field1746 = null;
                        break;
                     }

                     if(var8 >= var7.length) {
                        short[] var11 = new short[var7.length * 2];

                        for(int var12 = 0; var12 < var8; ++var12) {
                           var11[var12] = var7[var12];
                        }

                        var7 = var11;
                     }

                     var7[var8++] = (short)var9;
                  }

                  ++var9;
               }

               class80.intStack[++class80.intStackSize - 1] = Script.field1420;
               return 1;
            } else if(var0 != 4211) {
               if(var0 == 4212) {
                  class61.field693 = 0;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               if(GroundObject.field1746 != null && class61.field693 < Script.field1420) {
                  class80.intStack[++class80.intStackSize - 1] = GroundObject.field1746[++class61.field693 - 1] & '\uffff';
               } else {
                  class80.intStack[++class80.intStackSize - 1] = -1;
               }

               return 1;
            }
         }
      }
   }
}
