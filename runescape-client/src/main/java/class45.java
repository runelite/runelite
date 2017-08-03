import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class45 extends class28 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -115352407
   )
   int field553;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2087375717
   )
   int field557;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1563995373
   )
   int field554;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -560055171
   )
   int field556;

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-469819449"
   )
   int method650() {
      return this.field554;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIS)Z",
      garbageValue = "300"
   )
   boolean method645(int var1, int var2) {
      return var1 < this.field554 * 8?false:(var2 < this.field556 * 8?false:(var1 >= this.field554 * 8 + 8?false:var2 < this.field556 * 8 + 8));
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2075149772"
   )
   int method643() {
      return this.field556;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfw;Lfw;I)V",
      garbageValue = "1198543138"
   )
   void method644(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field477.field478) {
         throw new IllegalStateException("");
      } else {
         super.field383 = var2.readUnsignedByte();
         super.field382 = var2.readUnsignedByte();
         super.field384 = var2.readUnsignedShort();
         super.field380 = var2.readUnsignedShort();
         this.field553 = var2.readUnsignedByte();
         this.field557 = var2.readUnsignedByte();
         super.field381 = var2.readUnsignedShort();
         super.field390 = var2.readUnsignedShort();
         this.field554 = var2.readUnsignedByte();
         this.field556 = var2.readUnsignedByte();
         super.field382 = Math.min(super.field382, 4);
         super.field385 = new short[1][64][64];
         super.field386 = new short[super.field382][64][64];
         super.field388 = new byte[super.field382][64][64];
         super.field387 = new byte[super.field382][64][64];
         super.field389 = new class31[super.field382][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field469.field470) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(var4 == super.field381 && var5 == super.field390 && var6 == this.field554 && var7 == this.field556) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method212(this.field554 * 8 + var8, this.field556 * 8 + var9, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1840939897"
   )
   int method648() {
      return this.field553;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-987976933"
   )
   int method649() {
      return this.field557;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class45)) {
         return false;
      } else {
         class45 var2 = (class45)var1;
         return var2.field381 == super.field381 && super.field390 == var2.field390?this.field554 == var2.field554 && var2.field556 == this.field556:false;
      }
   }

   public int hashCode() {
      return super.field381 | super.field390 << 8 | this.field554 << 16 | this.field556 << 24;
   }
}
