import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
@Implements("InvType")
public class InvType extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public static IndexDataBase field3344;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   @Export("inventoryCache")
   public static NodeCache inventoryCache;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2006695059
   )
   @Export("size")
   public int size;

   static {
      inventoryCache = new NodeCache(64);
   }

   public InvType() {
      this.size = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgj;B)V",
      garbageValue = "0"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4534(var1, var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgj;IS)V",
      garbageValue = "16194"
   )
   void method4534(Buffer var1, int var2) {
      if(var2 == 2) {
         this.size = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1291518546"
   )
   static void method4536() {
      Object var0 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
         if(IndexStoreActionHandler.field3307 == 0) {
            Item.IndexStoreActionHandler_thread = new Thread(new IndexStoreActionHandler());
            Item.IndexStoreActionHandler_thread.setDaemon(true);
            Item.IndexStoreActionHandler_thread.start();
            Item.IndexStoreActionHandler_thread.setPriority(5);
         }

         IndexStoreActionHandler.field3307 = 600;
      }
   }
}
