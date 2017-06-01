import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public class class25 {
   @ObfuscatedName("t")
   static int[] field362;
   @ObfuscatedName("c")
   Coordinates field363;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1508816243
   )
   int field364;
   @ObfuscatedName("cm")
   static IndexData field365;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "3"
   )
   static int method167(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class232.field3187:class2.field15;
      if(var0 == 1800) {
         int[] var8 = class83.intStack;
         int var5 = ++class83.intStackSize - 1;
         int var7 = class210.method3903(var3);
         int var6 = var7 >> 11 & 63;
         var8[var5] = var6;
         return 1;
      } else if(var0 != 1801) {
         if(var0 == 1802) {
            if(var3.name == null) {
               class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "";
            } else {
               class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var3.name;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var4 = class83.intStack[--class83.intStackSize];
         --var4;
         if(var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
            class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var3.actions[var4];
         } else {
            class83.scriptStringStack[++class51.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1540152412"
   )
   static final int method168(int var0, int var1) {
      int var2 = var1 * 57 + var0;
      var2 ^= var2 << 13;
      int var3 = var2 * (var2 * var2 * 15731 + 789221) + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "2117025756"
   )
   static void method169(Widget var0) {
      if(var0.field2754 == Client.field1134) {
         Client.field1135[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "111"
   )
   static void method170(Buffer var0, int var1) {
      class3.method2(var0.payload, var1);
      if(class155.field2268 != null) {
         try {
            class155.field2268.method2316(0L);
            class155.field2268.method2321(var0.payload, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }

   class25(int var1, Coordinates var2) {
      this.field364 = var1;
      this.field363 = var2;
   }
}
