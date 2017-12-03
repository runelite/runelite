import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
@Implements("PacketNode")
public class PacketNode extends Node {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "[Lfg;"
   )
   @Export("packetBufferNodes")
   static PacketNode[] packetBufferNodes;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1029418191
   )
   static int field2436;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lfo;"
   )
   @Export("clientPacket")
   public ClientPacket clientPacket;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -657508309
   )
   public int field2432;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   @Export("packetBuffer")
   public PacketBuffer packetBuffer;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2005634151
   )
   public int field2434;

   static {
      packetBufferNodes = new PacketNode[300];
      field2436 = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1645508271"
   )
   public void method3173() {
      if(field2436 < packetBufferNodes.length) {
         packetBufferNodes[++field2436 - 1] = this;
      }
   }
}
