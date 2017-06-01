import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 163170635
   )
   @Export("id")
   int id;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1070376935
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([Lclass178;II)Lclass178;",
      garbageValue = "-2082707027"
   )
   public static class178 method1751(class178[] var0, int var1) {
      class178[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class178 var4 = var2[var3];
         if(var1 == var4.vmethod5009()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1408398879"
   )
   static int method1752(int var0, Script var1, boolean var2) {
      Widget var3 = WorldMapType3.method199(class83.intStack[--class83.intStackSize]);
      if(var0 == 2800) {
         int[] var8 = class83.intStack;
         int var5 = ++class83.intStackSize - 1;
         int var7 = class210.method3903(var3);
         int var6 = var7 >> 11 & 63;
         var8[var5] = var6;
         return 1;
      } else if(var0 != 2801) {
         if(var0 == 2802) {
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "2096882887"
   )
   protected final Model getModel() {
      return Buffer.getItemDefinition(this.id).getModel(this.quantity);
   }
}
