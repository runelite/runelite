import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class39 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 333684957
   )
   final int field537;
   @ObfuscatedName("m")
   public final Coordinates field538;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -995866223
   )
   int field539;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2040381943
   )
   final int field540;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1105157913
   )
   public final int field541;
   @ObfuscatedName("z")
   final class33 field542;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -657916097
   )
   int field544;
   @ObfuscatedName("e")
   public final Coordinates field545;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "558535940"
   )
   boolean method513(int var1, int var2) {
      Area var3 = Area.field3304[this.field541];
      switch(var3.field3314.field3551) {
      case 0:
         if(var1 < this.field539 - this.field540 / 2 || var1 > this.field540 / 2 + this.field539) {
            return false;
         }
         break;
      case 1:
         if(var1 < this.field539 || var1 >= this.field539 + this.field540) {
            return false;
         }
         break;
      case 2:
         if(var1 <= this.field539 - this.field540 || var1 > this.field539) {
            return false;
         }
      }

      switch(var3.field3310.field3282) {
      case 0:
         if(var2 >= this.field544 - this.field537 / 2 && var2 <= this.field537 / 2 + this.field544) {
            break;
         }

         return false;
      case 1:
         if(var2 < this.field544 || var2 >= this.field544 + this.field537) {
            return false;
         }
         break;
      case 2:
         if(var2 <= this.field544 - this.field537 || var2 > this.field544) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "10"
   )
   boolean method516(int var1, int var2) {
      return this.method513(var1, var2)?true:this.method524(var1, var2);
   }

   class39(int var1, Coordinates var2, Coordinates var3, class33 var4) {
      this.field541 = var1;
      this.field545 = var2;
      this.field538 = var3;
      this.field542 = var4;
      Area var5 = Area.field3304[this.field541];
      SpritePixels var6 = var5.method4189(false);
      if(var6 != null) {
         this.field540 = var6.width;
         this.field537 = var6.height;
      } else {
         this.field540 = 0;
         this.field537 = 0;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-89"
   )
   boolean method524(int var1, int var2) {
      return this.field542 == null?false:(var1 >= this.field539 - this.field542.field474 / 2 && var1 <= this.field539 + this.field542.field474 / 2?var2 >= this.field544 && var2 <= this.field544 + this.field542.field475:false);
   }
}
