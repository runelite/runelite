import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("p")
   @Export("progress")
   byte progress;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1133718989
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1680949765
   )
   @Export("price")
   public int price;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1952889433
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = -1316425137
   )
   static int field312;
   @ObfuscatedName("on")
   @ObfuscatedGetter(
      intValue = -2056985605
   )
   @Export("clanChatCount")
   static int clanChatCount;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1196460383
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1388412355
   )
   @Export("spent")
   public int spent;
   @ObfuscatedName("pz")
   @ObfuscatedGetter(
      intValue = -164851517
   )
   static int field317;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1926038987"
   )
   public int method113() {
      return this.progress & 7;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int method114() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2138364315"
   )
   void method115(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1082694131"
   )
   void method116(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
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

   public XGrandExchangeOffer() {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass165;B)V",
      garbageValue = "1"
   )
   public static void method128(class165 var0) {
      class265.field3660 = var0;
   }
}
