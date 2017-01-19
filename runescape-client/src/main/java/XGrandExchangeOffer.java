import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1216850173
   )
   @Export("spent")
   public int spent;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -52161969
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1538806693
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -646027585
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2035125335
   )
   @Export("price")
   public int price;
   @ObfuscatedName("s")
   @Export("progress")
   byte progress;

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "0"
   )
   public XGrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.method2727();
      this.totalQuantity = var1.method2727();
      this.quantitySold = var1.method2727();
      this.spent = var1.method2727();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "7354"
   )
   public int method43() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1256762137"
   )
   void method44(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "36"
   )
   void method46(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   public XGrandExchangeOffer() {
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1361404247"
   )
   public int method58() {
      return this.progress & 7;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2014491596"
   )
   static void method60() {
      class10.field91 = 99;
      ChatLineBuffer.underlayIds = new byte[4][104][104];
      class10.overlayIds = new byte[4][104][104];
      class20.overlayPaths = new byte[4][104][104];
      class10.overlayRotations = new byte[4][104][104];
      class161.field2152 = new int[4][105][105];
      class162.field2157 = new byte[4][105][105];
      class10.field93 = new int[105][105];
      class16.field184 = new int[104];
      class11.field116 = new int[104];
      class37.field784 = new int[104];
      class10.field97 = new int[104];
      class170.field2349 = new int[104];
   }
}
