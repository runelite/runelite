import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
@Implements("IndexStoreActionHandler")
public class IndexStoreActionHandler implements Runnable {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lje;"
   )
   @Export("IndexStoreActionHandler_requestQueue")
   static NodeDeque IndexStoreActionHandler_requestQueue;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lje;"
   )
   @Export("IndexStoreActionHandler_responseQueue")
   static NodeDeque IndexStoreActionHandler_responseQueue;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1282224505
   )
   @Export("__iv_q")
   static int __iv_q;
   @ObfuscatedName("w")
   @Export("IndexStoreActionHandler_lock")
   static Object IndexStoreActionHandler_lock;

   @Export("run")
   @ObfuscatedName("run")
   public void run() {
      try {
         while(true) {
            NodeDeque var1 = IndexStoreActionHandler_requestQueue;
            NodeDeque var3 = IndexStoreActionHandler_requestQueue;
            IndexStoreAction var2;
            synchronized(IndexStoreActionHandler_requestQueue) {
               var2 = (IndexStoreAction)IndexStoreActionHandler_requestQueue.last();
            }

            Object var4;
            Object var15;
            if(var2 != null) {
               NodeDeque var16;
               if(var2.type == 0) {
                  var2.indexStore.write((int)var2.key, var2.data, var2.data.length);
                  var1 = IndexStoreActionHandler_requestQueue;
                  var16 = IndexStoreActionHandler_requestQueue;
                  synchronized(IndexStoreActionHandler_requestQueue) {
                     var2.remove();
                  }
               } else if(var2.type == 1) {
                  var2.data = var2.indexStore.read((int)var2.key);
                  var1 = IndexStoreActionHandler_requestQueue;
                  var16 = IndexStoreActionHandler_requestQueue;
                  synchronized(IndexStoreActionHandler_requestQueue) {
                     IndexStoreActionHandler_responseQueue.addFirst(var2);
                  }
               }

               var15 = IndexStoreActionHandler_lock;
               var4 = IndexStoreActionHandler_lock;
               synchronized(IndexStoreActionHandler_lock) {
                  if(__iv_q <= 1) {
                     __iv_q = 0;
                     IndexStoreActionHandler_lock.notifyAll();
                     return;
                  }

                  __iv_q = 600;
               }
            } else {
               class203.method4010(100L);
               var15 = IndexStoreActionHandler_lock;
               var4 = IndexStoreActionHandler_lock;
               synchronized(IndexStoreActionHandler_lock) {
                  if(__iv_q <= 1) {
                     __iv_q = 0;
                     IndexStoreActionHandler_lock.notifyAll();
                     return;
                  }

                  --__iv_q;
               }
            }
         }
      } catch (Exception var14) {
         NPCDefinition.sendStackTrace((String)null, var14);
      }
   }

   @ObfuscatedName("ky")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "67"
   )
   static final void method4655(String var0) {
      if(PacketWriter.clanChat != null) {
         PacketBufferNode var1 = Interpreter.method1915(ClientPacket.__gs_i, Client.packetWriter.isaacCipher);
         var1.packetBuffer.writeByte(WorldMapRegion.method550(var0));
         var1.packetBuffer.writeStringCp1252NullTerminated(var0);
         Client.packetWriter.__q_167(var1);
      }

   }

   static {
      IndexStoreActionHandler_requestQueue = new NodeDeque();
      IndexStoreActionHandler_responseQueue = new NodeDeque();
      __iv_q = 0;
      IndexStoreActionHandler_lock = new Object();
   }
}
