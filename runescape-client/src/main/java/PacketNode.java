import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
@Implements("PacketNode")
public class PacketNode extends Node {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[Lgj;"
   )
   @Export("packetBufferNodes")
   public static PacketNode[] packetBufferNodes;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1121375225
   )
   public static int field2491;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   @Export("clientPacket")
   public ClientPacket clientPacket;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1225622277
   )
   public int field2487;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("packetBuffer")
   public PacketBuffer packetBuffer;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1553837013
   )
   public int field2489;

   static {
      packetBufferNodes = new PacketNode[300];
      field2491 = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1513402665"
   )
   public void method3508() {
      if(field2491 < packetBufferNodes.length) {
         packetBufferNodes[++field2491 - 1] = this;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-18"
   )
   static void method3514(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      FileRequest var4 = (FileRequest)class264.NetCache_pendingWrites.get(var2);
      if(var4 != null) {
         class264.NetCache_pendingWritesQueue.setHead(var4);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1615225476"
   )
   public static void method3515() {
      Object var0 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
         if(IndexStoreActionHandler.field3386 != 0) {
            IndexStoreActionHandler.field3386 = 1;

            try {
               IndexStoreActionHandler.IndexStoreActionHandler_lock.wait();
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }
}
