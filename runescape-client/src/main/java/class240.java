import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
public final class class240 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILfx;Lio;I)V",
      garbageValue = "461150856"
   )
   static void method4347(int var0, IndexFile var1, IndexData var2) {
      FileSystem var3 = new FileSystem();
      var3.type = 1;
      var3.hash = (long)var0;
      var3.index = var1;
      var3.data = var2;
      Deque var4 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
         IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(var3);
      }

      InvType.method4536();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "-21"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      class221.addChatMessage(var0, var1, var2, (String)null);
   }
}
