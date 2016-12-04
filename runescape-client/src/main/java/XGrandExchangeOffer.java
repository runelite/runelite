import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("n")
   @Export("progress")
   byte progress;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1467674911
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = 1123691143
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 611341127
   )
   @Export("price")
   public int price;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 79732827
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1202731559
   )
   @Export("spent")
   public int spent;
   @ObfuscatedName("cf")
   static class208 field45;
   @ObfuscatedName("ek")
   static SpritePixels[] field47;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 155244287
   )
   @Export("totalQuantity")
   public int totalQuantity;

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "0"
   )
   public XGrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.method2995();
      this.totalQuantity = var1.method2995();
      this.quantitySold = var1.method2995();
      this.spent = var1.method2995();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int method48() {
      return this.progress & 7;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-638628455"
   )
   static final byte[] method50(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.method2995();
      if(var3 >= 0 && (class182.field2723 == 0 || var3 <= class182.field2723)) {
         if(var2 == 0) {
            byte[] var6 = new byte[var3];
            var1.method3043(var6, 0, var3);
            return var6;
         } else {
            int var4 = var1.method2995();
            if(var4 < 0 || class182.field2723 != 0 && var4 > class182.field2723) {
               throw new RuntimeException();
            } else {
               byte[] var5 = new byte[var4];
               if(var2 == 1) {
                  class154.method2948(var5, var4, var0, var3, 9);
               } else {
                  class182.field2715.method2925(var1, var5);
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "57"
   )
   void method59(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1918077582"
   )
   public int method63() {
      return (this.progress & 8) == 8?1:0;
   }

   public XGrandExchangeOffer() {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   void method67(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(LWidgetNode;ZB)V",
      garbageValue = "-114"
   )
   static final void method68(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1) {
         class142.method2746(var2);
      }

      for(class133 var4 = (class133)Client.widgetFlags.method2414(); var4 != null; var4 = (class133)Client.widgetFlags.method2409()) {
         if((var4.hash >> 48 & 65535L) == (long)var2) {
            var4.unlink();
         }
      }

      Widget var5 = class5.method79(var3);
      if(var5 != null) {
         Tile.method1577(var5);
      }

      class162.method3195();
      if(Client.widgetRoot != -1) {
         XItemContainer.method181(Client.widgetRoot, 1);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)LWidget;",
      garbageValue = "-167032756"
   )
   public static Widget method69(int var0, int var1) {
      Widget var2 = class5.method79(var0);
      return var1 == -1?var2:(null != var2 && null != var2.children && var1 < var2.children.length?var2.children[var1]:null);
   }
}
