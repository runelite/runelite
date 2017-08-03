import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class39 {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   final class33 field507;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2045463309
   )
   public final int field505;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 755630459
   )
   int field498;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   public final Coordinates field500;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   public final Coordinates field504;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -224834063
   )
   final int field501;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 273132173
   )
   int field499;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1825306231
   )
   final int field502;

   @ObfuscatedSignature(
      signature = "(ILhy;Lhy;Lai;)V"
   )
   class39(int var1, Coordinates var2, Coordinates var3, class33 var4) {
      this.field505 = var1;
      this.field500 = var2;
      this.field504 = var3;
      this.field507 = var4;
      Area var5 = Area.field3286[this.field505];
      SpritePixels var6 = var5.method4271(false);
      if(var6 != null) {
         this.field501 = var6.width;
         this.field502 = var6.height;
      } else {
         this.field501 = 0;
         this.field502 = 0;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "14"
   )
   boolean method547(int var1, int var2) {
      Area var3 = Area.field3286[this.field505];
      switch(var3.field3291.field3524) {
      case 0:
         if(var1 >= this.field498 && var1 < this.field501 + this.field498) {
            break;
         }

         return false;
      case 1:
         if(var1 >= this.field498 - this.field501 / 2 && var1 <= this.field501 / 2 + this.field498) {
            break;
         }

         return false;
      case 2:
         if(var1 <= this.field498 - this.field501 || var1 > this.field498) {
            return false;
         }
      }

      switch(var3.field3293.field3256) {
      case 0:
         if(var2 >= this.field499 - this.field502 / 2 && var2 <= this.field502 / 2 + this.field499) {
            break;
         }

         return false;
      case 1:
         if(var2 <= this.field499 - this.field502 || var2 > this.field499) {
            return false;
         }
         break;
      case 2:
         if(var2 < this.field499 || var2 >= this.field502 + this.field499) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-15"
   )
   boolean method548(int var1, int var2) {
      return this.field507 == null?false:(var1 >= this.field498 - this.field507.field441 / 2 && var1 <= this.field507.field441 / 2 + this.field498?var2 >= this.field499 && var2 <= this.field507.field442 + this.field499:false);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-825613697"
   )
   boolean method545(int var1, int var2) {
      return this.method547(var1, var2)?true:this.method548(var1, var2);
   }
}
