import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class39 {
   @ObfuscatedName("fw")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = 1129109639
   )
   static int field534;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Laf;"
   )
   final class33 field533;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1108667525
   )
   public final int field531;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1184390637
   )
   int field526;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   public final Coordinates field532;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   public final Coordinates field537;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -987390457
   )
   final int field528;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 584794887
   )
   int field535;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1184663827
   )
   final int field529;

   @ObfuscatedSignature(
      signature = "(ILhs;Lhs;Laf;)V"
   )
   class39(int var1, Coordinates var2, Coordinates var3, class33 var4) {
      this.field531 = var1;
      this.field532 = var2;
      this.field537 = var3;
      this.field533 = var4;
      Area var5 = Area.field3265[this.field531];
      SpritePixels var6 = var5.method4181(false);
      if(var6 != null) {
         this.field528 = var6.width;
         this.field529 = var6.height;
      } else {
         this.field528 = 0;
         this.field529 = 0;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1778253810"
   )
   boolean method520(int var1, int var2) {
      Area var3 = Area.field3265[this.field531];
      switch(var3.field3280.field3524) {
      case 0:
         if(var1 >= this.field526 && var1 < this.field526 + this.field528) {
            break;
         }

         return false;
      case 1:
         if(var1 > this.field526 - this.field528 && var1 <= this.field526) {
            break;
         }

         return false;
      case 2:
         if(var1 < this.field526 - this.field528 / 2 || var1 > this.field528 / 2 + this.field526) {
            return false;
         }
      }

      switch(var3.field3276.field3247) {
      case 0:
         if(var2 > this.field535 - this.field529 && var2 <= this.field535) {
            break;
         }

         return false;
      case 1:
         if(var2 < this.field535 || var2 >= this.field535 + this.field529) {
            return false;
         }
         break;
      case 2:
         if(var2 < this.field535 - this.field529 / 2 || var2 > this.field529 / 2 + this.field535) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "2054480647"
   )
   boolean method522(int var1, int var2) {
      return this.field533 == null?false:(var1 >= this.field526 - this.field533.field452 / 2 && var1 <= this.field533.field452 / 2 + this.field526?var2 >= this.field535 && var2 <= this.field533.field453 + this.field535:false);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1342687393"
   )
   boolean method521(int var1, int var2) {
      return this.method520(var1, var2)?true:this.method522(var1, var2);
   }
}
