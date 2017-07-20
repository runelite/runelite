import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   @Export("indexWorldMap")
   static IndexData indexWorldMap;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -678064429
   )
   @Export("id")
   int id;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -192784633
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Leo;",
      garbageValue = "1"
   )
   protected final Model getModel() {
      return class10.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "16"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      FileOnDisk.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-49"
   )
   public static int method1707(int var0) {
      return var0 >> 17 & 7;
   }
}
