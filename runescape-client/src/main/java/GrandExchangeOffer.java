import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("indexSprites")
   static IndexData indexSprites;
   @ObfuscatedName("on")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   static SpritePixels field315;
   @ObfuscatedName("i")
   @Export("progress")
   byte progress;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1126476721
   )
   @Export("price")
   public int price;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -336445013
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 310254597
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -84399659
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1751143957
   )
   @Export("spent")
   public int spent;

   public GrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(Lfp;Z)V",
      garbageValue = "0"
   )
   public GrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-8"
   )
   void method127(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-3229128"
   )
   void method115(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int method114() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2020300473"
   )
   public int method118() {
      return this.progress & 7;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IB)I",
      garbageValue = "12"
   )
   public static int method129(CharSequence var0, int var1) {
      return class227.parseInt(var0, var1, true);
   }
}
