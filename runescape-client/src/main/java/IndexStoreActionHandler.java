import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
@Implements("IndexStoreActionHandler")
public class IndexStoreActionHandler implements Runnable {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("IndexStoreActionHandler_requestQueue")
   public static Deque IndexStoreActionHandler_requestQueue;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("IndexStoreActionHandler_responseQueue")
   public static Deque IndexStoreActionHandler_responseQueue;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -745457897
   )
   public static int field3328;
   @ObfuscatedName("k")
   @Export("IndexStoreActionHandler_lock")
   public static Object IndexStoreActionHandler_lock;
   @ObfuscatedName("u")
   @Export("IndexStoreActionHandler_thread")
   static Thread IndexStoreActionHandler_thread;

   static {
      IndexStoreActionHandler_requestQueue = new Deque();
      IndexStoreActionHandler_responseQueue = new Deque();
      field3328 = 0;
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
                  var1.index.write((int)var1.hash, var1.field3299, var1.field3299.length);
                  var2 = IndexStoreActionHandler_requestQueue;
                  synchronized(IndexStoreActionHandler_requestQueue) {
                     var1.unlink();
                  }
               } else if(var1.type == 1) {
                  var1.field3299 = var1.index.read((int)var1.hash);
                  var2 = IndexStoreActionHandler_requestQueue;
                  synchronized(IndexStoreActionHandler_requestQueue) {
                     IndexStoreActionHandler_responseQueue.addFront(var1);
                  }
               }

               var14 = IndexStoreActionHandler_lock;
               synchronized(IndexStoreActionHandler_lock) {
                  if(field3328 <= 1) {
                     field3328 = 0;
                     IndexStoreActionHandler_lock.notifyAll();
                     return;
                  }

                  field3328 = 600;
               }
            } else {
               World.method1500(100L);
               var14 = IndexStoreActionHandler_lock;
               synchronized(IndexStoreActionHandler_lock) {
                  if(field3328 <= 1) {
                     field3328 = 0;
                     IndexStoreActionHandler_lock.notifyAll();
                     return;
                  }

                  --field3328;
               }
            }
         }
      } catch (Exception var13) {
         PendingSpawn.method1461((String)null, var13);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Lku;",
      garbageValue = "1368333271"
   )
   @Export("socialStatusForId")
   public static class289 socialStatusForId(int var0) {
      class289[] var1 = new class289[]{class289.field3806, class289.field3807, class289.field3808};
      class289[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class289 var4 = var2[var3];
         if(var0 == var4.socialStateId) {
            return var4;
         }
      }

      return null;
   }
}
