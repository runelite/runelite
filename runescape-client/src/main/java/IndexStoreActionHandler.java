import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jv")
@Implements("IndexStoreActionHandler")
public class IndexStoreActionHandler implements Runnable {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhr;"
   )
   @Export("IndexStoreActionHandler_requestQueue")
   public static Deque IndexStoreActionHandler_requestQueue;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhr;"
   )
   @Export("IndexStoreActionHandler_responseQueue")
   public static Deque IndexStoreActionHandler_responseQueue;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lll;"
   )
   static IndexedSprite field3398;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2083116819
   )
   public static int field3401;
   @ObfuscatedName("h")
   @Export("IndexStoreActionHandler_lock")
   public static Object IndexStoreActionHandler_lock;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1349346113
   )
   static int field3399;
   @ObfuscatedName("ae")
   protected static GarbageCollectorMXBean field3402;

   static {
      IndexStoreActionHandler_requestQueue = new Deque();
      IndexStoreActionHandler_responseQueue = new Deque();
      field3401 = 0;
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
                  if(field3401 <= 1) {
                     field3401 = 0;
                     IndexStoreActionHandler_lock.notifyAll();
                     return;
                  }

                  field3401 = 600;
               }
            } else {
               ScriptVarType.method11(100L);
               var14 = IndexStoreActionHandler_lock;
               synchronized(IndexStoreActionHandler_lock) {
                  if(field3401 <= 1) {
                     field3401 = 0;
                     IndexStoreActionHandler_lock.notifyAll();
                     return;
                  }

                  --field3401;
               }
            }
         }
      } catch (Exception var13) {
         AttackOption.processClientError((String)null, var13);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2142349185"
   )
   static final boolean method4629() {
      return class132.Viewport_containsMouse;
   }
}
