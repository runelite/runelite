import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class45 extends class28 {
   @ObfuscatedName("bt")
   @Export("sessionToken")
   static String sessionToken;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -5861551
   )
   int field543;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1177836333
   )
   int field540;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1872096463
   )
   int field544;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1257484187
   )
   int field542;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgn;Lgn;B)V",
      garbageValue = "37"
   )
   void method663(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field464.field469) {
         throw new IllegalStateException("");
      } else {
         super.field384 = var2.readUnsignedByte();
         super.field377 = var2.readUnsignedByte();
         super.field383 = var2.readUnsignedShort();
         super.field373 = var2.readUnsignedShort();
         this.field543 = var2.readUnsignedByte();
         this.field540 = var2.readUnsignedByte();
         super.field374 = var2.readUnsignedShort();
         super.field381 = var2.readUnsignedShort();
         this.field544 = var2.readUnsignedByte();
         this.field542 = var2.readUnsignedByte();
         super.field377 = Math.min(super.field377, 4);
         super.field378 = new short[1][64][64];
         super.field379 = new short[super.field377][64][64];
         super.field386 = new byte[super.field377][64][64];
         super.field380 = new byte[super.field377][64][64];
         super.field382 = new class31[super.field377][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field453.field455) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(var4 == super.field374 && var5 == super.field381 && var6 == this.field544 && var7 == this.field542) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method242(var8 + this.field544 * 8, var9 + this.field542 * 8, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-14"
   )
   boolean method672(int var1, int var2) {
      return var1 < this.field544 * 8?false:(var2 < this.field542 * 8?false:(var1 >= this.field544 * 8 + 8?false:var2 < this.field542 * 8 + 8));
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1408716497"
   )
   int method661() {
      return this.field543;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "289215540"
   )
   int method662() {
      return this.field540;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1341583799"
   )
   int method671() {
      return this.field544;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "114"
   )
   int method664() {
      return this.field542;
   }

   public int hashCode() {
      return super.field374 | super.field381 << 8 | this.field544 << 16 | this.field542 << 24;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class45)) {
         return false;
      } else {
         class45 var2 = (class45)var1;
         return super.field374 == var2.field374 && super.field381 == var2.field381?var2.field544 == this.field544 && var2.field542 == this.field542:false;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "53"
   )
   static void method677(int var0) {
      ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var1 != null) {
         var1.unlink();
      }
   }

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-40"
   )
   static final void method681() {
      if(class87.soundSystem1 != null) {
         class87.soundSystem1.method2203();
      }

      if(WorldMapData.soundSystem0 != null) {
         WorldMapData.soundSystem0.method2203();
      }

   }

   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1963287091"
   )
   static void method682(int var0) {
      class20.topContextMenuRow = new ContextMenuRow();
      class20.topContextMenuRow.param0 = Client.menuActionParams0[var0];
      class20.topContextMenuRow.param1 = Client.menuActionParams1[var0];
      class20.topContextMenuRow.type = Client.menuTypes[var0];
      class20.topContextMenuRow.identifier = Client.menuIdentifiers[var0];
      class20.topContextMenuRow.option = Client.menuOptions[var0];
   }
}
