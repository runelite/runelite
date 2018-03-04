import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
@Implements("PacketNode")
public class PacketNode extends Node {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "[Lgl;"
   )
   @Export("packetBufferNodes")
   public static PacketNode[] packetBufferNodes;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1627108207
   )
   public static int field2497;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   @Export("clientPacket")
   public ClientPacket clientPacket;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1281579281
   )
   public int field2493;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   @Export("packetBuffer")
   public PacketBuffer packetBuffer;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 443533569
   )
   public int field2495;

   static {
      packetBufferNodes = new PacketNode[300];
      field2497 = 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "8804"
   )
   public void method3485() {
      if(field2497 < packetBufferNodes.length) {
         packetBufferNodes[++field2497 - 1] = this;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Ljn;",
      garbageValue = "-3"
   )
   public static Enum method3491(int var0) {
      Enum var1 = (Enum)Enum.EnumDefinition_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Enum.EnumDefinition_indexCache.getConfigData(8, var0);
         var1 = new Enum();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Enum.EnumDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgy;II)Ljava/lang/String;",
      garbageValue = "-993134682"
   )
   public static String method3492(Buffer var0, int var1) {
      try {
         int var2 = var0.getUSmart();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class313.huffman.decompress(var0.payload, var0.offset, var3, 0, var2);
         String var4 = class152.getString(var3, 0, var2);
         return var4;
      } catch (Exception var6) {
         return "Cabbage";
      }
   }
}
