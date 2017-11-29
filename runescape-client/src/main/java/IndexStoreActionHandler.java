import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
@Implements("IndexStoreActionHandler")
public class IndexStoreActionHandler implements Runnable {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("IndexStoreActionHandler_requestQueue")
   static Deque IndexStoreActionHandler_requestQueue;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("IndexStoreActionHandler_responseQueue")
   static Deque IndexStoreActionHandler_responseQueue;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1650854241
   )
   static int field3308;
   @ObfuscatedName("z")
   @Export("IndexStoreActionHandler_lock")
   static Object IndexStoreActionHandler_lock;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1005389043
   )
   static int field3310;
   @ObfuscatedName("n")
   public static boolean field3311;

   static {
      IndexStoreActionHandler_requestQueue = new Deque();
      IndexStoreActionHandler_responseQueue = new Deque();
      field3308 = 0;
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
                  var1.index.write((int)var1.hash, var1.field3280, var1.field3280.length);
                  var2 = IndexStoreActionHandler_requestQueue;
                  synchronized(IndexStoreActionHandler_requestQueue) {
                     var1.unlink();
                  }
               } else if(var1.type == 1) {
                  var1.field3280 = var1.index.read((int)var1.hash);
                  var2 = IndexStoreActionHandler_requestQueue;
                  synchronized(IndexStoreActionHandler_requestQueue) {
                     IndexStoreActionHandler_responseQueue.addFront(var1);
                  }
               }

               var14 = IndexStoreActionHandler_lock;
               synchronized(IndexStoreActionHandler_lock) {
                  if(field3308 <= 1) {
                     field3308 = 0;
                     IndexStoreActionHandler_lock.notifyAll();
                     return;
                  }

                  field3308 = 600;
               }
            } else {
               BaseVarType.method12(100L);
               var14 = IndexStoreActionHandler_lock;
               synchronized(IndexStoreActionHandler_lock) {
                  if(field3308 <= 1) {
                     field3308 = 0;
                     IndexStoreActionHandler_lock.notifyAll();
                     return;
                  }

                  --field3308;
               }
            }
         }
      } catch (Exception var13) {
         Item.method1829((String)null, var13);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "99"
   )
   public static boolean method4358(int var0) {
      return (var0 >> 20 & 1) != 0;
   }
}
