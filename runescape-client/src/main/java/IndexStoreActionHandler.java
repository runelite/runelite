import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jt")
@Implements("IndexStoreActionHandler")
public class IndexStoreActionHandler implements Runnable {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   @Export("IndexStoreActionHandler_requestQueue")
   public static Deque IndexStoreActionHandler_requestQueue;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   @Export("IndexStoreActionHandler_responseQueue")
   public static Deque IndexStoreActionHandler_responseQueue;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 620701449
   )
   static int field3398;
   @ObfuscatedName("l")
   @Export("IndexStoreActionHandler_lock")
   static Object IndexStoreActionHandler_lock;
   @ObfuscatedName("b")
   @Export("IndexStoreActionHandler_thread")
   static Thread IndexStoreActionHandler_thread;

   static {
      IndexStoreActionHandler_requestQueue = new Deque();
      IndexStoreActionHandler_responseQueue = new Deque();
      field3398 = 0;
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
                  var1.index.write((int)var1.hash, var1.field3367, var1.field3367.length);
                  var2 = IndexStoreActionHandler_requestQueue;
                  synchronized(IndexStoreActionHandler_requestQueue) {
                     var1.unlink();
                  }
               } else if(var1.type == 1) {
                  var1.field3367 = var1.index.read((int)var1.hash);
                  var2 = IndexStoreActionHandler_requestQueue;
                  synchronized(IndexStoreActionHandler_requestQueue) {
                     IndexStoreActionHandler_responseQueue.addFront(var1);
                  }
               }

               var14 = IndexStoreActionHandler_lock;
               synchronized(IndexStoreActionHandler_lock) {
                  if(field3398 <= 1) {
                     field3398 = 0;
                     IndexStoreActionHandler_lock.notifyAll();
                     return;
                  }

                  field3398 = 600;
               }
            } else {
               class93.method1982(100L);
               var14 = IndexStoreActionHandler_lock;
               synchronized(IndexStoreActionHandler_lock) {
                  if(field3398 <= 1) {
                     field3398 = 0;
                     IndexStoreActionHandler_lock.notifyAll();
                     return;
                  }

                  --field3398;
               }
            }
         }
      } catch (Exception var13) {
         GroundObject.processClientError((String)null, var13);
      }
   }

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-89"
   )
   static final void method4675(int var0, int var1) {
      if(Client.hintArrowTargetType == 2) {
         class25.worldToScreen((Client.hintArrowX - class38.baseX << 7) + Client.hintArrowOffsetX, (Client.hintArrowY - PlayerComposition.baseY << 7) + Client.hintArrowOffsetY, Client.hintArrowType * 2);
         if(Client.screenX > -1 && Client.gameCycle % 20 < 10) {
            class234.headIconsHint[0].drawAt(var0 + Client.screenX - 12, Client.screenY + var1 - 28);
         }

      }
   }
}
