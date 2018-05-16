import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("h")
   @Export("validInterfaces")
   static boolean[] validInterfaces;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 577260357
   )
   @Export("id")
   int id;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 70858691
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Ldk;",
      garbageValue = "111"
   )
   protected final Model getModel() {
      return class120.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I[BLff;I)V",
      garbageValue = "494698684"
   )
   static void method1906(int var0, byte[] var1, IndexFile var2) {
      FileSystem var3 = new FileSystem();
      var3.type = 0;
      var3.hash = (long)var0;
      var3.field3165 = var1;
      var3.index = var2;
      Deque var4 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
         IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(var3);
      }

      class158.method3313();
   }
}
