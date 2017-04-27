import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1707626481
   )
   @Export("quantity")
   int quantity;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -933263931
   )
   @Export("id")
   int id;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-18"
   )
   protected final Model getModel() {
      return class47.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1412621916"
   )
   static final void method824(int var0, int var1) {
      int var2 = TextureProvider.field1192.method3904("Choose Option");

      int var3;
      int var4;
      for(var3 = 0; var3 < Client.menuOptionCount; ++var3) {
         var4 = TextureProvider.field1192.method3904(class13.method179(var3));
         if(var4 > var2) {
            var2 = var4;
         }
      }

      var2 += 8;
      var3 = Client.menuOptionCount * 15 + 22;
      var4 = var0 - var2 / 2;
      if(var2 + var4 > class187.field2760) {
         var4 = class187.field2760 - var2;
      }

      if(var4 < 0) {
         var4 = 0;
      }

      int var5 = var1;
      if(var3 + var1 > IndexDataBase.field2726) {
         var5 = IndexDataBase.field2726 - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      class172.region.method1758(Client.plane, var0, var1, false);
      Client.isMenuOpen = true;
      Player.menuX = var4;
      class1.menuY = var5;
      MessageNode.menuWidth = var2;
      class201.menuHeight = Client.menuOptionCount * 15 + 22;
   }
}
