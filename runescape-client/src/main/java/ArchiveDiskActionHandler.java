import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
@Implements("ArchiveDiskActionHandler")
public class ArchiveDiskActionHandler implements Runnable {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lje;"
   )
   @Export("ArchiveDiskActionHandler_requestQueue")
   static NodeDeque ArchiveDiskActionHandler_requestQueue;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lje;"
   )
   @Export("ArchiveDiskActionHandler_responseQueue")
   static NodeDeque ArchiveDiskActionHandler_responseQueue;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1282224505
   )
   static int field412;
   @ObfuscatedName("w")
   @Export("ArchiveDiskActionHandler_lock")
   static Object ArchiveDiskActionHandler_lock;

   public void run() {
      try {
         while (true) {
            NodeDeque var1 = ArchiveDiskActionHandler_requestQueue;
            ArchiveDiskAction var2;
            synchronized(ArchiveDiskActionHandler_requestQueue) {
               var2 = (ArchiveDiskAction)ArchiveDiskActionHandler_requestQueue.last();
            }

            Object var3;
            if (var2 != null) {
               if (var2.type == 0) {
                  var2.archiveDisk.write((int)var2.key, var2.data, var2.data.length);
                  var1 = ArchiveDiskActionHandler_requestQueue;
                  synchronized(ArchiveDiskActionHandler_requestQueue) {
                     var2.remove();
                  }
               } else if (var2.type == 1) {
                  var2.data = var2.archiveDisk.read((int)var2.key);
                  var1 = ArchiveDiskActionHandler_requestQueue;
                  synchronized(ArchiveDiskActionHandler_requestQueue) {
                     ArchiveDiskActionHandler_responseQueue.addFirst(var2);
                  }
               }

               var3 = ArchiveDiskActionHandler_lock;
               synchronized(ArchiveDiskActionHandler_lock) {
                  if (field412 <= 1) {
                     field412 = 0;
                     ArchiveDiskActionHandler_lock.notifyAll();
                     return;
                  }

                  field412 = 600;
               }
            } else {
               class203.method4010(100L);
               var3 = ArchiveDiskActionHandler_lock;
               synchronized(ArchiveDiskActionHandler_lock) {
                  if (field412 <= 1) {
                     field412 = 0;
                     ArchiveDiskActionHandler_lock.notifyAll();
                     return;
                  }

                  --field412;
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
   @Export("clanKickUser")
   static final void clanKickUser(String var0) {
      if (PacketWriter.clanChat != null) {
         PacketBufferNode var1 = Interpreter.method1915(ClientPacket.field235, Client.packetWriter.isaacCipher);
         var1.packetBuffer.writeByte(WorldMapRegion.stringCp1252NullTerminatedByteSize(var0));
         var1.packetBuffer.writeStringCp1252NullTerminated(var0);
         Client.packetWriter.method241(var1);
      }

   }

   static {
      ArchiveDiskActionHandler_requestQueue = new NodeDeque();
      ArchiveDiskActionHandler_responseQueue = new NodeDeque();
      field412 = 0;
      ArchiveDiskActionHandler_lock = new Object();
   }
}
