import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
@Implements("PacketNode")
public class PacketNode extends Node {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "[Lgh;"
   )
   @Export("packetBufferNodes")
   static PacketNode[] packetBufferNodes;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -72182589
   )
   static int field2502;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lfl;"
   )
   @Export("clientPacket")
   public ClientPacket clientPacket;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -434098959
   )
   public int field2503;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("packetBuffer")
   public PacketBuffer packetBuffer;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1932772265
   )
   public int field2505;

   static {
      packetBufferNodes = new PacketNode[300];
      field2502 = 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1599528097"
   )
   public void method3436() {
      if(field2502 < packetBufferNodes.length) {
         packetBufferNodes[++field2502 - 1] = this;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljf;IIIZB)V",
      garbageValue = "11"
   )
   public static void method3442(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class229.field2687 = 1;
      class185.field2511 = var0;
      VertexNormal.field1931 = var1;
      GrandExchangeEvents.field284 = var2;
      class86.field1330 = var3;
      class229.field2692 = var4;
      class2.field11 = 10000;
   }
}
