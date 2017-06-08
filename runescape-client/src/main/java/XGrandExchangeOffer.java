import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2084632741
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -191548745
   )
   @Export("price")
   public int price;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 20535321
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("n")
   @Export("progress")
   byte progress;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1986521423
   )
   @Export("spent")
   public int spent;
   @ObfuscatedName("mz")
   static class156 field312;
   @ObfuscatedName("pv")
   @ObfuscatedGetter(
      intValue = 2091634031
   )
   static int field313;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1362389427
   )
   @Export("quantitySold")
   public int quantitySold;

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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1720558233"
   )
   public int method118() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1529102757"
   )
   void method119(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1329160240"
   )
   void method120(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1766012719"
   )
   public int method121() {
      return this.progress & 7;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)LVarbit;",
      garbageValue = "849641108"
   )
   public static Varbit method122(int var0) {
      Varbit var1 = (Varbit)Varbit.field3385.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Varbit.field3381.getConfigData(14, var0);
         var1 = new Varbit();
         if(var2 != null) {
            var1.method4441(new Buffer(var2));
         }

         Varbit.field3385.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass210;I)V",
      garbageValue = "1945858653"
   )
   static final void method135(int var0, int var1, int var2, int var3, SpritePixels var4, class210 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle + Client.mapScale & 2047;
         int var7 = var2 * var2 + var3 * var3;
         if(var7 <= 6400) {
            int var8 = class136.SINE[var6];
            int var9 = class136.COSINE[var6];
            var8 = var8 * 256 / (Client.mapScaleDelta + 256);
            var9 = var9 * 256 / (Client.mapScaleDelta + 256);
            int var10 = var9 * var2 + var3 * var8 >> 16;
            int var11 = var9 * var3 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method5140(var10 + var5.field2610 / 2 - var4.maxWidth / 2, var5.field2605 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2610, var5.field2605, var5.field2607, var5.field2606);
            } else {
               var4.method5097(var10 + var5.field2610 / 2 + var0 - var4.maxWidth / 2, var5.field2605 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }
}
