import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("qn")
   protected static java.awt.Frame field881;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1233123935
   )
   @Export("id")
   int id;
   @ObfuscatedName("f")
   static byte[][][] field884;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1162858851
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-8"
   )
   protected final Model getModel() {
      return class168.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-137570764"
   )
   static void method871() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         if(class149.method2824(Client.menuTypes[var0])) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var1 = var0; var1 < Client.menuOptionCount - 1; ++var1) {
                  Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
                  Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
                  Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
                  Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
                  Client.menuActionParams0[var1] = Client.menuActionParams0[1 + var1];
                  Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }
}
