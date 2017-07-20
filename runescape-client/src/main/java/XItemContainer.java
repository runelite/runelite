import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   @Export("itemContainers")
   static XHashTable itemContainers;
   @ObfuscatedName("o")
   @Export("itemIds")
   int[] itemIds;
   @ObfuscatedName("i")
   @Export("stackSizes")
   int[] stackSizes;

   static {
      itemContainers = new XHashTable(32);
   }

   XItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "34"
   )
   static int method1032(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      return class238.currentRequest != null && class238.currentRequest.hash == var2?GameObject.field2154.offset * 99 / (GameObject.field2154.payload.length - class238.currentRequest.padding) + 1:0;
   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-28094"
   )
   static void method1031() {
      Client.secretPacketBuffer1.putOpcode(36);
      PacketBuffer var0 = Client.secretPacketBuffer1;
      int var1 = Client.isResized?2:1;
      var0.putByte(var1);
      Client.secretPacketBuffer1.putShort(class45.canvasWidth);
      Client.secretPacketBuffer1.putShort(class10.canvasHeight);
   }
}
