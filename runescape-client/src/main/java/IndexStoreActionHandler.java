import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jr")
@Implements("IndexStoreActionHandler")
public class IndexStoreActionHandler implements Runnable {
   @ObfuscatedName("oa")
   static boolean field3392;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   @Export("IndexStoreActionHandler_requestQueue")
   public static Deque IndexStoreActionHandler_requestQueue;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   @Export("IndexStoreActionHandler_responseQueue")
   public static Deque IndexStoreActionHandler_responseQueue;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1328621685
   )
   public static int field3389;
   @ObfuscatedName("j")
   @Export("IndexStoreActionHandler_lock")
   public static Object IndexStoreActionHandler_lock;
   @ObfuscatedName("k")
   @Export("IndexStoreActionHandler_thread")
   static Thread IndexStoreActionHandler_thread;
   @ObfuscatedName("e")
   static boolean field3388;

   static {
      IndexStoreActionHandler_requestQueue = new Deque();
      IndexStoreActionHandler_responseQueue = new Deque();
      field3389 = 0;
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
                  var1.index.write((int)var1.hash, var1.field3356, var1.field3356.length);
                  var2 = IndexStoreActionHandler_requestQueue;
                  synchronized(IndexStoreActionHandler_requestQueue) {
                     var1.unlink();
                  }
               } else if(var1.type == 1) {
                  var1.field3356 = var1.index.read((int)var1.hash);
                  var2 = IndexStoreActionHandler_requestQueue;
                  synchronized(IndexStoreActionHandler_requestQueue) {
                     IndexStoreActionHandler_responseQueue.addFront(var1);
                  }
               }

               var14 = IndexStoreActionHandler_lock;
               synchronized(IndexStoreActionHandler_lock) {
                  if(field3389 <= 1) {
                     field3389 = 0;
                     IndexStoreActionHandler_lock.notifyAll();
                     return;
                  }

                  field3389 = 600;
               }
            } else {
               class163.method3223(100L);
               var14 = IndexStoreActionHandler_lock;
               synchronized(IndexStoreActionHandler_lock) {
                  if(field3389 <= 1) {
                     field3389 = 0;
                     IndexStoreActionHandler_lock.notifyAll();
                     return;
                  }

                  --field3389;
               }
            }
         }
      } catch (Exception var13) {
         UrlRequest.processClientError((String)null, var13);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "985642245"
   )
   public static void method4660(int var0) {
      class229.field2680 = 1;
      class61.field714 = null;
      class229.field2682 = -1;
      class152.field2129 = -1;
      Varcs.field1431 = 0;
      class313.field3910 = false;
      BoundingBox3D.field249 = var0;
   }
}
