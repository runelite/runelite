import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class25 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -9955195
   )
   @Export("canvasHeight")
   protected static int canvasHeight;
   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "Lfl;"
   )
   @Export("rssocket")
   static class159 rssocket;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 80291903
   )
   int field356;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lht;"
   )
   Coordinates field358;

   @ObfuscatedSignature(
      signature = "(ILht;)V"
   )
   class25(int var1, Coordinates var2) {
      this.field356 = var1;
      this.field358 = var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1629164964"
   )
   static void method174() {
      Object var0 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
         if(IndexStoreActionHandler.field3328 == 0) {
            IndexStoreActionHandler.IndexStoreActionHandler_thread = new Thread(new IndexStoreActionHandler());
            IndexStoreActionHandler.IndexStoreActionHandler_thread.setDaemon(true);
            IndexStoreActionHandler.IndexStoreActionHandler_thread.start();
            IndexStoreActionHandler.IndexStoreActionHandler_thread.setPriority(5);
         }

         IndexStoreActionHandler.field3328 = 600;
      }
   }
}
