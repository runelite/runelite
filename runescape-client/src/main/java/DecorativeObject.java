import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = -1786396111
   )
   static int field1860;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -511355339
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1850199349
   )
   @Export("x")
   int x;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1602512817
   )
   @Export("y")
   int y;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 552093651
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1255582715
   )
   @Export("rotation")
   int rotation;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1346941497
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2085664887
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ldz;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ldz;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -5118687135473253869L
   )
   @Export("hash")
   public long hash;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1042594383
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   DecorativeObject() {
      this.hash = 0L;
      this.renderInfoBitPacked = 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lfy;Lgh;B)Lfe;",
      garbageValue = "46"
   )
   public static PacketNode method3115(ClientPacket var0, ISAACCipher var1) {
      PacketNode var2;
      if(PacketNode.field2277 == 0) {
         var2 = new PacketNode();
      } else {
         var2 = PacketNode.packetBufferNodes[--PacketNode.field2277];
      }

      var2.clientPacket = var0;
      var2.field2278 = var0.packetLength;
      if(var2.field2278 == -1) {
         var2.packetBuffer = new PacketBuffer(260);
      } else if(var2.field2278 == -2) {
         var2.packetBuffer = new PacketBuffer(10000);
      } else if(var2.field2278 <= 18) {
         var2.packetBuffer = new PacketBuffer(20);
      } else if(var2.field2278 <= 98) {
         var2.packetBuffer = new PacketBuffer(100);
      } else {
         var2.packetBuffer = new PacketBuffer(260);
      }

      var2.packetBuffer.setIsaacCipher(var1);
      var2.packetBuffer.putOpcode(var2.clientPacket.packetId);
      var2.field2280 = 0;
      return var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1803377882"
   )
   public static boolean method3114(int var0) {
      return (var0 >> 20 & 1) != 0;
   }
}
