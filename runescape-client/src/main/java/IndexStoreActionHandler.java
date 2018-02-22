import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
@Implements("IndexStoreActionHandler")
public class IndexStoreActionHandler implements Runnable {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   @Export("IndexStoreActionHandler_requestQueue")
   static Deque IndexStoreActionHandler_requestQueue;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   @Export("IndexStoreActionHandler_responseQueue")
   static Deque IndexStoreActionHandler_responseQueue;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -964558729
   )
   public static int field3338;
   @ObfuscatedName("p")
   @Export("IndexStoreActionHandler_lock")
   public static Object IndexStoreActionHandler_lock;
   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   @Export("slFlagSprites")
   static IndexedSprite[] slFlagSprites;

   static {
      IndexStoreActionHandler_requestQueue = new Deque();
      IndexStoreActionHandler_responseQueue = new Deque();
      field3338 = 0;
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
                  var1.index.write((int)var1.hash, var1.field3316, var1.field3316.length);
                  var2 = IndexStoreActionHandler_requestQueue;
                  synchronized(IndexStoreActionHandler_requestQueue) {
                     var1.unlink();
                  }
               } else if(var1.type == 1) {
                  var1.field3316 = var1.index.read((int)var1.hash);
                  var2 = IndexStoreActionHandler_requestQueue;
                  synchronized(IndexStoreActionHandler_requestQueue) {
                     IndexStoreActionHandler_responseQueue.addFront(var1);
                  }
               }

               var14 = IndexStoreActionHandler_lock;
               synchronized(IndexStoreActionHandler_lock) {
                  if(field3338 <= 1) {
                     field3338 = 0;
                     IndexStoreActionHandler_lock.notifyAll();
                     return;
                  }

                  field3338 = 600;
               }
            } else {
               class19.method152(100L);
               var14 = IndexStoreActionHandler_lock;
               synchronized(IndexStoreActionHandler_lock) {
                  if(field3338 <= 1) {
                     field3338 = 0;
                     IndexStoreActionHandler_lock.notifyAll();
                     return;
                  }

                  --field3338;
               }
            }
         }
      } catch (Exception var13) {
         class37.method519((String)null, var13);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BB)Lca;",
      garbageValue = "9"
   )
   @Export("newScript")
   static Script newScript(byte[] var0) {
      Script var1 = new Script();
      Buffer var2 = new Buffer(var0);
      var2.offset = var2.payload.length - 2;
      int var3 = var2.readUnsignedShort();
      int var4 = var2.payload.length - 2 - var3 - 12;
      var2.offset = var4;
      int var5 = var2.readInt();
      var1.localIntCount = var2.readUnsignedShort();
      var1.localStringCount = var2.readUnsignedShort();
      var1.intStackCount = var2.readUnsignedShort();
      var1.stringStackCount = var2.readUnsignedShort();
      int var6 = var2.readUnsignedByte();
      int var7;
      int var8;
      if(var6 > 0) {
         var1.switches = var1.method1999(var6);

         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2.readUnsignedShort();
            IterableHashTable var9 = new IterableHashTable(var8 > 0?class156.nextPowerOfTwo(var8):1);
            var1.switches[var7] = var9;

            while(var8-- > 0) {
               int var10 = var2.readInt();
               int var11 = var2.readInt();
               var9.put(new IntegerNode(var11), (long)var10);
            }
         }
      }

      var2.offset = 0;
      var2.getNullString();
      var1.instructions = new int[var5];
      var1.intOperands = new int[var5];
      var1.stringOperands = new String[var5];

      for(var7 = 0; var2.offset < var4; var1.instructions[var7++] = var8) {
         var8 = var2.readUnsignedShort();
         if(var8 == 3) {
            var1.stringOperands[var7] = var2.readString();
         } else if(var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
            var1.intOperands[var7] = var2.readInt();
         } else {
            var1.intOperands[var7] = var2.readUnsignedByte();
         }
      }

      return var1;
   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1653233469"
   )
   static void method4626(int var0) {
      Client.field1017 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      if(class70.method1179() == 1) {
         RenderOverview.clientInstance.method862(765, 503);
      } else {
         RenderOverview.clientInstance.method862(7680, 2160);
      }

      if(Client.gameState >= 25) {
         Resampler.method2310();
      }

   }
}
