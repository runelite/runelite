import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
public class class235 {
   @ObfuscatedName("qi")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   @Export("indexStore255")
   static IndexFile indexStore255;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILfx;Lio;I)V",
      garbageValue = "1778859898"
   )
   static void method4334(int var0, IndexFile var1, IndexData var2) {
      byte[] var3 = null;
      Deque var4 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
         for(FileSystem var5 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.getFront(); var5 != null; var5 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.getNext()) {
            if(var5.hash == (long)var0 && var1 == var5.index && var5.type == 0) {
               var3 = var5.field3276;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.load(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.read(var0);
         var2.load(var1, var0, var8, true);
      }
   }
}
