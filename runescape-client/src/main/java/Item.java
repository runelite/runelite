import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1424532003
   )
   @Export("id")
   int id;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1497042563
   )
   @Export("quantity")
   int quantity;
   @ObfuscatedName("m")
   static class47 field1476;
   @ObfuscatedName("pq")
   @ObfuscatedGetter(
      intValue = 891164431
   )
   static int field1477;
   @ObfuscatedName("db")
   @Export("host")
   static String host;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1208682604"
   )
   protected final Model getModel() {
      return class51.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-19"
   )
   static final void method1796(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var2 + var0; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class18.field315[0][var5][var4] = 127;
               if(var5 == var0 && var5 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 - 1][var4];
               }

               if(var2 + var0 == var5 && var5 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 + 1][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var3 + var1 && var4 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }
}
