import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1936334143
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1562140691
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1527193555
   )
   @Export("price")
   public int price;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1884732667
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1359418369
   )
   @Export("spent")
   public int spent;
   @ObfuscatedName("mi")
   static byte field34;
   @ObfuscatedName("pz")
   static class30 field35;
   @ObfuscatedName("u")
   public static byte[][] field36;
   @ObfuscatedName("o")
   @Export("progress")
   byte progress;

   public XGrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "0"
   )
   public XGrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.method2731();
      this.totalQuantity = var1.method2731();
      this.quantitySold = var1.method2731();
      this.spent = var1.method2731();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1252858906"
   )
   public int method43() {
      return this.progress & 7;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2087650869"
   )
   public int method44() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "18"
   )
   static final void method45(int var0, int var1) {
      if(class2.method25(var0)) {
         Player.method230(Widget.widgets[var0], var1);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1662781582"
   )
   void method46(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1532213839"
   )
   static boolean method52(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1075218832"
   )
   void method55(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }
}
