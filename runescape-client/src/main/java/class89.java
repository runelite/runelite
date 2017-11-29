import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
public class class89 {
   @ObfuscatedName("d")
   static final BigInteger field1331;
   @ObfuscatedName("x")
   static final BigInteger field1330;

   static {
      field1331 = new BigInteger("10001", 16);
      field1330 = new BigInteger("be7a67da8f7aa61e7a66947e920fdafa92897e8c96311aa9eed116a66505f9cebd8f8cf98d216728a3985a8a04715278c669741659564218d4ba3db8bafa9eac32b5ab75dc37d1c9632790bdb65b4855ce033118fc217c831538235810e2214bc0d3a3673b2c7561aa0f83147550ab9bbcfbe12a7c6d2e27619bb2e40baa1cc7", 16);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Lfq;",
      garbageValue = "1940323529"
   )
   static PacketNode method1765() {
      return PacketNode.field2425 == 0?new PacketNode():PacketNode.packetBufferNodes[--PacketNode.field2425];
   }
}
