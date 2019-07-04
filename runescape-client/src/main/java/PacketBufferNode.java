import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
@Implements("PacketBufferNode")
public class PacketBufferNode extends Node {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[Lgg;"
   )
   @Export("packetBufferNodes")
   public static PacketBufferNode[] packetBufferNodes;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1583654139
   )
   public static int field668;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   public ClientPacket field669;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1433542775
   )
   public int field670;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   @Export("packetBuffer")
   public PacketBuffer packetBuffer;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2051819203
   )
   public int field671;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1987685511"
   )
   public void method238() {
      if (field668 < packetBufferNodes.length) {
         packetBufferNodes[++field668 - 1] = this;
      }

   }

   @ObfuscatedName("kq")
   @ObfuscatedSignature(
      signature = "(Lho;I)Z",
      garbageValue = "-739353556"
   )
   static boolean method3673(Widget var0) {
      return var0.isHidden;
   }

   static {
      packetBufferNodes = new PacketBufferNode[300];
      field668 = 0;
   }
}
