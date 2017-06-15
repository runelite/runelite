import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
public class class234 extends CacheableNode {
   @ObfuscatedName("e")
   byte field3214;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1061928713
   )
   int field3215;
   @ObfuscatedName("p")
   IndexData field3218;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LModel;IIII)Z",
      garbageValue = "1987741006"
   )
   static final boolean method3991(Model var0, int var1, int var2, int var3) {
      if(!ObjectComposition.method4411()) {
         return false;
      } else {
         int var4;
         int var5;
         int var6;
         int var7;
         int var10;
         int var11;
         int var12;
         int var15;
         int var16;
         if(!class134.field2004) {
            var4 = Region.field2079;
            var5 = Region.field2085;
            var6 = Region.field2106;
            var7 = Region.field2087;
            byte var8 = 50;
            short var9 = 3500;
            var10 = (class134.field1994 - class136.field2025) * var8 / class136.field2024;
            var11 = var8 * (class134.field1995 - class136.field2026) / class136.field2024;
            var12 = (class134.field1994 - class136.field2025) * var9 / class136.field2024;
            int var13 = (class134.field1995 - class136.field2026) * var9 / class136.field2024;
            int var14 = class136.method2527(var11, var8, var5, var4);
            var15 = class136.method2533(var11, var8, var5, var4);
            var11 = var14;
            var14 = class136.method2527(var13, var9, var5, var4);
            var16 = class136.method2533(var13, var9, var5, var4);
            var13 = var14;
            var14 = class136.method2512(var10, var15, var7, var6);
            var15 = class136.method2513(var10, var15, var7, var6);
            var10 = var14;
            var14 = class136.method2512(var12, var16, var7, var6);
            var16 = class136.method2513(var12, var16, var7, var6);
            class134.field1993 = (var14 + var10) / 2;
            class134.field1998 = (var11 + var13) / 2;
            CombatInfo1.field1274 = (var16 + var15) / 2;
            BufferProvider.field3759 = (var14 - var10) / 2;
            class134.field1999 = (var13 - var11) / 2;
            Preferences.field1301 = (var16 - var15) / 2;
            Script.field1535 = Math.abs(BufferProvider.field3759);
            class149.field2209 = Math.abs(class134.field1999);
            class134.field1997 = Math.abs(Preferences.field1301);
         }

         var4 = var1 + var0.field1955;
         var5 = var0.field1956 + var2;
         var6 = var3 + var0.field1957;
         var7 = var0.field1958;
         var15 = var0.field1959;
         var16 = var0.field1928;
         var10 = class134.field1993 - var4;
         var11 = class134.field1998 - var5;
         var12 = CombatInfo1.field1274 - var6;
         return Math.abs(var10) > var7 + Script.field1535?false:(Math.abs(var11) > var15 + class149.field2209?false:(Math.abs(var12) > class134.field1997 + var16?false:(Math.abs(class134.field1999 * var12 - var11 * Preferences.field1301) > class149.field2209 * var16 + class134.field1997 * var15?false:(Math.abs(Preferences.field1301 * var10 - var12 * BufferProvider.field3759) > class134.field1997 * var7 + Script.field1535 * var16?false:Math.abs(BufferProvider.field3759 * var11 - var10 * class134.field1999) <= var7 * class149.field2209 + var15 * Script.field1535))));
      }
   }
}
