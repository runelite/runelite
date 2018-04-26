import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jm")
@Implements("IndexStoreActionHandler")
public class IndexStoreActionHandler implements Runnable {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   @Export("IndexStoreActionHandler_requestQueue")
   static Deque IndexStoreActionHandler_requestQueue;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   @Export("IndexStoreActionHandler_responseQueue")
   static Deque IndexStoreActionHandler_responseQueue;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1957494801
   )
   static int field3386;
   @ObfuscatedName("z")
   @Export("IndexStoreActionHandler_lock")
   static Object IndexStoreActionHandler_lock;
   @ObfuscatedName("n")
   @Export("IndexStoreActionHandler_thread")
   static Thread IndexStoreActionHandler_thread;

   static {
      IndexStoreActionHandler_requestQueue = new Deque();
      IndexStoreActionHandler_responseQueue = new Deque();
      field3386 = 0;
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
                  var1.index.write((int)var1.hash, var1.field3358, var1.field3358.length);
                  var2 = IndexStoreActionHandler_requestQueue;
                  synchronized(IndexStoreActionHandler_requestQueue) {
                     var1.unlink();
                  }
               } else if(var1.type == 1) {
                  var1.field3358 = var1.index.read((int)var1.hash);
                  var2 = IndexStoreActionHandler_requestQueue;
                  synchronized(IndexStoreActionHandler_requestQueue) {
                     IndexStoreActionHandler_responseQueue.addFront(var1);
                  }
               }

               var14 = IndexStoreActionHandler_lock;
               synchronized(IndexStoreActionHandler_lock) {
                  if(field3386 <= 1) {
                     field3386 = 0;
                     IndexStoreActionHandler_lock.notifyAll();
                     return;
                  }

                  field3386 = 600;
               }
            } else {
               BoundingBox3DDrawMode.method59(100L);
               var14 = IndexStoreActionHandler_lock;
               synchronized(IndexStoreActionHandler_lock) {
                  if(field3386 <= 1) {
                     field3386 = 0;
                     IndexStoreActionHandler_lock.notifyAll();
                     return;
                  }

                  --field3386;
               }
            }
         }
      } catch (Exception var13) {
         class253.processClientError((String)null, var13);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-1264635180"
   )
   public static int method4752(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }
}
