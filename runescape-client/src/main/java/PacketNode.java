import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
@Implements("PacketNode")
public class PacketNode extends Node {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "[Lfq;"
   )
   @Export("packetBufferNodes")
   static PacketNode[] packetBufferNodes;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 244986515
   )
   static int field2425;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   @Export("clientPacket")
   ClientPacket clientPacket;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1203047415
   )
   int field2421;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   @Export("packetBuffer")
   public PacketBuffer packetBuffer;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1776737313
   )
   public int field2423;

   static {
      packetBufferNodes = new PacketNode[300];
      field2425 = 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "102"
   )
   public void method3212() {
      if(field2425 < packetBufferNodes.length) {
         packetBufferNodes[++field2425 - 1] = this;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILff;Liv;I)V",
      garbageValue = "-275530401"
   )
   static void method3214(int var0, IndexFile var1, IndexData var2) {
      FileSystem var3 = new FileSystem();
      var3.type = 1;
      var3.hash = (long)var0;
      var3.index = var1;
      var3.data = var2;
      Deque var4 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
         IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(var3);
      }

      class209.method3827();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "43959931"
   )
   static int method3213(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 0) {
            var1 = 0;
         } else if(var1 > 127) {
            var1 = 127;
         }

         var1 = 127 - var1;
         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }
}
