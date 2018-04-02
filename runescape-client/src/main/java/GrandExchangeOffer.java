import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   public static Track1 field292;
   @ObfuscatedName("c")
   @Export("state")
   byte state;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1681843795
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1202645115
   )
   @Export("price")
   public int price;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 774757347
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1825065405
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2074004771
   )
   @Export("spent")
   public int spent;

   public GrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(Lgp;Z)V",
      garbageValue = "0"
   )
   public GrandExchangeOffer(Buffer var1, boolean var2) {
      this.state = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2098724091"
   )
   @Export("status")
   public int status() {
      return this.state & 7;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "64"
   )
   @Export("type")
   public int type() {
      return (this.state & 8) == 8?1:0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "8"
   )
   void method114(int var1) {
      this.state &= -8;
      this.state = (byte)(this.state | var1 & 7);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "83382116"
   )
   void method115(int var1) {
      this.state &= -9;
      if(var1 == 1) {
         this.state = (byte)(this.state | 8);
      }

   }

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "50"
   )
   static void method124() {
      class45.method670();
      Client.menuOptions[0] = "Cancel";
      Client.menuTargets[0] = "";
      Client.menuTypes[0] = 1006;
      Client.menuBooleanArray[0] = false;
      Client.menuOptionCount = 1;
   }

   @ObfuscatedName("kj")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "2066232354"
   )
   public static void method125(int var0, int var1, int var2, boolean var3) {
      PacketNode var4 = FaceNormal.method3078(ClientPacket.field2373, Client.field902.field1475);
      var4.packetBuffer.method3670(var3?Client.field1009:0);
      var4.packetBuffer.method3544(var2);
      var4.packetBuffer.method3554(var1);
      var4.packetBuffer.method3554(var0);
      Client.field902.method2036(var4);
   }
}
