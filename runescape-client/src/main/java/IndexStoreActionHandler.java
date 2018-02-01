import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
@Implements("IndexStoreActionHandler")
public class IndexStoreActionHandler implements Runnable {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   @Export("IndexStoreActionHandler_requestQueue")
   static Deque IndexStoreActionHandler_requestQueue;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   @Export("IndexStoreActionHandler_responseQueue")
   static Deque IndexStoreActionHandler_responseQueue;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 270460959
   )
   static int field3307;
   @ObfuscatedName("s")
   @Export("IndexStoreActionHandler_lock")
   static Object IndexStoreActionHandler_lock;

   static {
      IndexStoreActionHandler_requestQueue = new Deque();
      IndexStoreActionHandler_responseQueue = new Deque();
      field3307 = 0;
      IndexStoreActionHandler_lock = new Object();
   }

   public void run() {
      try {
         while(true) {
            Deque var2 = IndexStoreActionHandler_requestQueue;
            FileSystem var1;
            synchronized(IndexStoreActionHandler_requestQueue) {
               var1 = (FileSystem)IndexStoreActionHandler_requestQueue.getFront();
            }

            Object var14;
            if(var1 != null) {
               if(var1.type == 0) {
                  var1.index.write((int)var1.hash, var1.field3276, var1.field3276.length);
                  var2 = IndexStoreActionHandler_requestQueue;
                  synchronized(IndexStoreActionHandler_requestQueue) {
                     var1.unlink();
                  }
               } else if(var1.type == 1) {
                  var1.field3276 = var1.index.read((int)var1.hash);
                  var2 = IndexStoreActionHandler_requestQueue;
                  synchronized(IndexStoreActionHandler_requestQueue) {
                     IndexStoreActionHandler_responseQueue.addFront(var1);
                  }
               }

               var14 = IndexStoreActionHandler_lock;
               synchronized(IndexStoreActionHandler_lock) {
                  if(field3307 <= 1) {
                     field3307 = 0;
                     IndexStoreActionHandler_lock.notifyAll();
                     return;
                  }

                  field3307 = 600;
               }
            } else {
               class1.method3(100L);
               var14 = IndexStoreActionHandler_lock;
               synchronized(IndexStoreActionHandler_lock) {
                  if(field3307 <= 1) {
                     field3307 = 0;
                     IndexStoreActionHandler_lock.notifyAll();
                     return;
                  }

                  --field3307;
               }
            }
         }
      } catch (Exception var13) {
         class89.method1900((String)null, var13);
      }
   }
}
