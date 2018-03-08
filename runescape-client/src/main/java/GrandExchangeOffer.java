import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
   @ObfuscatedName("on")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   @Export("minimapSprite")
   static SpritePixels minimapSprite;
   @ObfuscatedName("e")
   static int[] field294;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1094681987
   )
   public static int field284;
   @ObfuscatedName("bj")
   static String field290;
   @ObfuscatedName("t")
   @Export("state")
   byte state;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1830026537
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -185808529
   )
   @Export("price")
   public int price;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1716879073
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1627042683
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2125956321
   )
   @Export("spent")
   public int spent;

   public GrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(Lgb;Z)V",
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
      garbageValue = "-1534869825"
   )
   @Export("status")
   public int status() {
      return this.state & 7;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1695031298"
   )
   @Export("type")
   public int type() {
      return (this.state & 8) == 8?1:0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1066687601"
   )
   void method106(int var1) {
      this.state &= -8;
      this.state = (byte)(this.state | var1 & 7);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1573795457"
   )
   void method107(int var1) {
      this.state &= -9;
      if(var1 == 1) {
         this.state = (byte)(this.state | 8);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1688664144"
   )
   public static int method124(int var0) {
      return var0 >> 17 & 7;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IZIZB)V",
      garbageValue = "-17"
   )
   static void method117(int var0, boolean var1, int var2, boolean var3) {
      if(World.worldList != null) {
         WorldMapType1.method286(0, World.worldList.length - 1, var0, var1, var2, var3);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-822209613"
   )
   @Export("adjustHSLListness0")
   static final int adjustHSLListness0(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }
}
