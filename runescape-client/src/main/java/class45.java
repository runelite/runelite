import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class45 extends class28 {
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = 1241304983
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -673301709
   )
   int field562;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1582215967
   )
   int field565;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 886236297
   )
   int field564;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1106792419
   )
   int field567;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lfv;Lfv;I)V",
      garbageValue = "1458514291"
   )
   void method694(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field478.field481) {
         throw new IllegalStateException("");
      } else {
         super.field395 = var2.readUnsignedByte();
         super.field391 = var2.readUnsignedByte();
         super.field399 = var2.readUnsignedShort();
         super.field392 = var2.readUnsignedShort();
         this.field562 = var2.readUnsignedByte();
         this.field565 = var2.readUnsignedByte();
         super.field393 = var2.readUnsignedShort();
         super.field394 = var2.readUnsignedShort();
         this.field564 = var2.readUnsignedByte();
         this.field567 = var2.readUnsignedByte();
         super.field391 = Math.min(super.field391, 4);
         super.field396 = new short[1][64][64];
         super.field397 = new short[super.field391][64][64];
         super.field398 = new byte[super.field391][64][64];
         super.field400 = new byte[super.field391][64][64];
         super.field401 = new class31[super.field391][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field469.field468) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(var4 == super.field393 && var5 == super.field394 && var6 == this.field564 && var7 == this.field567) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method244(var8 + this.field564 * 8, var9 + this.field567 * 8, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "793212456"
   )
   boolean method695(int var1, int var2) {
      return var1 < this.field564 * 8?false:(var2 < this.field567 * 8?false:(var1 >= this.field564 * 8 + 8?false:var2 < this.field567 * 8 + 8));
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "998391235"
   )
   int method702() {
      return this.field562;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1368651440"
   )
   int method698() {
      return this.field565;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1778492245"
   )
   int method699() {
      return this.field564;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "115"
   )
   int method700() {
      return this.field567;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class45)) {
         return false;
      } else {
         class45 var2 = (class45)var1;
         return super.field393 == var2.field393 && super.field394 == var2.field394?var2.field564 == this.field564 && var2.field567 == this.field567:false;
      }
   }

   public int hashCode() {
      return super.field393 | super.field394 << 8 | this.field564 << 16 | this.field567 << 24;
   }
}
