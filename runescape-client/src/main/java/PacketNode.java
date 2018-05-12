import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
@Implements("PacketNode")
public class PacketNode extends Node {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "[Lfe;"
   )
   @Export("packetBufferNodes")
   static PacketNode[] packetBufferNodes;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1988723367
   )
   static int field2277;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lfy;"
   )
   @Export("clientPacket")
   ClientPacket clientPacket;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -354778165
   )
   int field2278;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   @Export("packetBuffer")
   public PacketBuffer packetBuffer;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -499035007
   )
   public int field2280;

   static {
      packetBufferNodes = new PacketNode[300];
      field2277 = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   public void method3479() {
      if(field2277 < packetBufferNodes.length) {
         packetBufferNodes[++field2277 - 1] = this;
      }
   }
}
