import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ja")
@Implements("IndexStoreActionHandler")
public class IndexStoreActionHandler implements Runnable {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   @Export("IndexStoreActionHandler_requestQueue")
   static Deque IndexStoreActionHandler_requestQueue;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   @Export("IndexStoreActionHandler_responseQueue")
   static Deque IndexStoreActionHandler_responseQueue;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 667948873
   )
   public static int field3394;
   @ObfuscatedName("r")
   @Export("IndexStoreActionHandler_lock")
   public static Object IndexStoreActionHandler_lock;
   @ObfuscatedName("e")
   @Export("IndexStoreActionHandler_thread")
   static Thread IndexStoreActionHandler_thread;
   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   static IndexedSprite field3390;

   static {
      IndexStoreActionHandler_requestQueue = new Deque();
      IndexStoreActionHandler_responseQueue = new Deque();
      field3394 = 0;
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
                  var1.index.write((int)var1.hash, var1.field3359, var1.field3359.length);
                  var2 = IndexStoreActionHandler_requestQueue;
                  synchronized(IndexStoreActionHandler_requestQueue) {
                     var1.unlink();
                  }
               } else if(var1.type == 1) {
                  var1.field3359 = var1.index.read((int)var1.hash);
                  var2 = IndexStoreActionHandler_requestQueue;
                  synchronized(IndexStoreActionHandler_requestQueue) {
                     IndexStoreActionHandler_responseQueue.addFront(var1);
                  }
               }

               var14 = IndexStoreActionHandler_lock;
               synchronized(IndexStoreActionHandler_lock) {
                  if(field3394 <= 1) {
                     field3394 = 0;
                     IndexStoreActionHandler_lock.notifyAll();
                     return;
                  }

                  field3394 = 600;
               }
            } else {
               PacketBuffer.method3907(100L);
               var14 = IndexStoreActionHandler_lock;
               synchronized(IndexStoreActionHandler_lock) {
                  if(field3394 <= 1) {
                     field3394 = 0;
                     IndexStoreActionHandler_lock.notifyAll();
                     return;
                  }

                  --field3394;
               }
            }
         }
      } catch (Exception var13) {
         ItemLayer.method2658((String)null, var13);
      }
   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static void method4767() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         int var2 = Client.menuTypes[var0];
         boolean var1 = var2 == 57 || var2 == 58 || var2 == 1007 || var2 == 25 || var2 == 30;
         if(var1) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var3 = var0; var3 < Client.menuOptionCount - 1; ++var3) {
                  Client.menuOptions[var3] = Client.menuOptions[var3 + 1];
                  Client.menuTargets[var3] = Client.menuTargets[var3 + 1];
                  Client.menuTypes[var3] = Client.menuTypes[var3 + 1];
                  Client.menuIdentifiers[var3] = Client.menuIdentifiers[var3 + 1];
                  Client.menuActionParams0[var3] = Client.menuActionParams0[var3 + 1];
                  Client.menuActionParams1[var3] = Client.menuActionParams1[var3 + 1];
                  Client.menuBooleanArray[var3] = Client.menuBooleanArray[var3 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }
}
