import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
@Implements("PacketNode")
public class PacketNode extends Node {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "[Lfv;"
   )
   @Export("packetBufferNodes")
   public static PacketNode[] packetBufferNodes;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 186841727
   )
   public static int field2441;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lfm;"
   )
   @Export("clientPacket")
   public ClientPacket clientPacket;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1375719667
   )
   public int field2442;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   @Export("packetBuffer")
   public PacketBuffer packetBuffer;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 986673059
   )
   public int field2437;

   static {
      packetBufferNodes = new PacketNode[300];
      field2441 = 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2103761865"
   )
   public void method3413() {
      if(field2441 < packetBufferNodes.length) {
         packetBufferNodes[++field2441 - 1] = this;
      }
   }
}
