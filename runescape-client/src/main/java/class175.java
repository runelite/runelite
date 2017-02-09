import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public class class175 {
   @ObfuscatedName("nj")
   @ObfuscatedGetter(
      intValue = 421046659
   )
   static int field2635;

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2066828613"
   )
   static final void method3253() {
      for(class25 var0 = (class25)Client.field300.method2403(); var0 != null; var0 = (class25)Client.field300.method2398()) {
         if(var0.field573 > 0) {
            --var0.field573;
         }

         if(var0.field573 == 0) {
            if(var0.field562 < 0 || class10.method126(var0.field562, var0.field572)) {
               Item.method811(var0.field575, var0.field563, var0.field564, var0.field565, var0.field562, var0.field567, var0.field572);
               var0.unlink();
            }
         } else {
            if(var0.field566 > 0) {
               --var0.field566;
            }

            if(var0.field566 == 0 && var0.field564 >= 1 && var0.field565 >= 1 && var0.field564 <= 102 && var0.field565 <= 102 && (var0.field569 < 0 || class10.method126(var0.field569, var0.field571))) {
               Item.method811(var0.field575, var0.field563, var0.field564, var0.field565, var0.field569, var0.field570, var0.field571);
               var0.field566 = -1;
               if(var0.field562 == var0.field569 && var0.field562 == -1) {
                  var0.unlink();
               } else if(var0.field569 == var0.field562 && var0.field570 == var0.field567 && var0.field572 == var0.field571) {
                  var0.unlink();
               }
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "698398144"
   )
   static final int method3254(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class45.method832(var3, var5);
      int var8 = class45.method832(var3 + 1, var5);
      int var9 = class45.method832(var3, 1 + var5);
      int var10 = class45.method832(var3 + 1, 1 + var5);
      int var11 = class8.method115(var7, var8, var4, var2);
      int var12 = class8.method115(var9, var10, var4, var2);
      return class8.method115(var11, var12, var6, var2);
   }

   class175() throws Throwable {
      throw new Error();
   }
}
