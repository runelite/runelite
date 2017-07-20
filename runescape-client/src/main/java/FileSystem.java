import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
@Implements("FileSystem")
public class FileSystem extends Node {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1911631875
   )
   int field3171;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lfz;"
   )
   @Export("index")
   IndexFile index;
   @ObfuscatedName("o")
   byte[] field3170;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   @Export("data")
   IndexData data;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-202851467"
   )
   public static int method4002(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var0 + var2) / var1 - var2;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "-1907637253"
   )
   static int method4003(int var0, Script var1, boolean var2) {
      Widget var3 = class239.method4167(class83.intStack[--BufferProvider.intStackSize]);
      if(var0 == 2800) {
         int[] var4 = class83.intStack;
         int var5 = ++BufferProvider.intStackSize - 1;
         int var7 = class60.getWidgetConfig(var3);
         int var6 = var7 >> 11 & 63;
         var4[var5] = var6;
         return 1;
      } else if(var0 != 2801) {
         if(var0 == 2802) {
            if(var3.name == null) {
               class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
            } else {
               class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var3.name;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var8 = class83.intStack[--BufferProvider.intStackSize];
         --var8;
         if(var3.actions != null && var8 < var3.actions.length && var3.actions[var8] != null) {
            class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var3.actions[var8];
         } else {
            class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }
}
