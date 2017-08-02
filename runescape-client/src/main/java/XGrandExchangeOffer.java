import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("c")
   @Export("progress")
   byte progress;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1742462719
   )
   @Export("price")
   public int price;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -943557443
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 777929655
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1568272623
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1296865761
   )
   @Export("spent")
   public int spent;

   public XGrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(Lfp;Z)V",
      garbageValue = "0"
   )
   public XGrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "49"
   )
   void method112(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "14"
   )
   void method114(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1304723411"
   )
   public int method96() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-68"
   )
   public int method95() {
      return this.progress & 7;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "53"
   )
   public static boolean method99(int var0) {
      return (var0 >> 29 & 1) != 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1096345650"
   )
   static final int method101(int var0, int var1) {
      int var2 = var1 * 57 + var0;
      var2 ^= var2 << 13;
      int var3 = 1376312589 + (var2 * var2 * 15731 + 789221) * var2 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }
}
