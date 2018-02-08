import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   static NodeCache field1424;
   @ObfuscatedName("g")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("m")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("h")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -558375573
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1652720491
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 939866111
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -967531463
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "[Lgz;"
   )
   @Export("switches")
   IterableHashTable[] switches;

   static {
      field1424 = new NodeCache(128);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)[Lgz;",
      garbageValue = "-860849918"
   )
   IterableHashTable[] method2016(int var1) {
      return new IterableHashTable[var1];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfm;Lgo;I)Lfv;",
      garbageValue = "869289622"
   )
   public static PacketNode method2025(ClientPacket var0, ISAACCipher var1) {
      PacketNode var2;
      if(PacketNode.field2441 == 0) {
         var2 = new PacketNode();
      } else {
         var2 = PacketNode.packetBufferNodes[--PacketNode.field2441];
      }

      var2.clientPacket = var0;
      var2.field2442 = var0.packetLength;
      if(var2.field2442 == -1) {
         var2.packetBuffer = new PacketBuffer(260);
      } else if(var2.field2442 == -2) {
         var2.packetBuffer = new PacketBuffer(10000);
      } else if(var2.field2442 <= 18) {
         var2.packetBuffer = new PacketBuffer(20);
      } else if(var2.field2442 <= 98) {
         var2.packetBuffer = new PacketBuffer(100);
      } else {
         var2.packetBuffer = new PacketBuffer(260);
      }

      var2.packetBuffer.setIsaacCipher(var1);
      var2.packetBuffer.putOpcode(var2.clientPacket.packetId);
      var2.field2437 = 0;
      return var2;
   }
}
