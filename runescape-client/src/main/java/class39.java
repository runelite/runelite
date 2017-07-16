import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class39 {
   @ObfuscatedName("fj")
   static byte[][] field525;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Law;"
   )
   final class33 field520;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1512677497
   )
   public final int field523;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1128770705
   )
   int field521;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   public final Coordinates field522;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   public final Coordinates field516;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1864482637
   )
   final int field518;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1535031185
   )
   int field515;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -149637829
   )
   final int field519;

   @ObfuscatedSignature(
      signature = "(ILhd;Lhd;Law;)V"
   )
   class39(int var1, Coordinates var2, Coordinates var3, class33 var4) {
      this.field523 = var1;
      this.field522 = var2;
      this.field516 = var3;
      this.field520 = var4;
      Area var5 = class54.field662[this.field523];
      SpritePixels var6 = var5.method4249(false);
      if(var6 != null) {
         this.field518 = var6.width;
         this.field519 = var6.height;
      } else {
         this.field518 = 0;
         this.field519 = 0;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "69"
   )
   boolean method538(int var1, int var2) {
      Area var3 = class54.field662[this.field523];
      switch(var3.field3303.field3551) {
      case 0:
         if(var1 > this.field521 - this.field518 && var1 <= this.field521) {
            break;
         }

         return false;
      case 1:
         if(var1 >= this.field521 - this.field518 / 2 && var1 <= this.field518 / 2 + this.field521) {
            break;
         }

         return false;
      case 2:
         if(var1 < this.field521 || var1 >= this.field518 + this.field521) {
            return false;
         }
      }

      switch(var3.field3304.field3276) {
      case 0:
         if(var2 >= this.field515 && var2 < this.field515 + this.field519) {
            break;
         }

         return false;
      case 1:
         if(var2 < this.field515 - this.field519 / 2 || var2 > this.field519 / 2 + this.field515) {
            return false;
         }
         break;
      case 2:
         if(var2 <= this.field515 - this.field519 || var2 > this.field515) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-582563995"
   )
   boolean method539(int var1, int var2) {
      return this.field520 == null?false:(var1 >= this.field521 - this.field520.field455 / 2 && var1 <= this.field520.field455 / 2 + this.field521?var2 >= this.field515 && var2 <= this.field520.field456 + this.field515:false);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-46"
   )
   boolean method546(int var1, int var2) {
      return this.method538(var1, var2)?true:this.method539(var1, var2);
   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1598172825"
   )
   static final void method549(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field1006; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1111[var4] = true;
         }
      }

   }

   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "(B)Lke;",
      garbageValue = "0"
   )
   static RenderOverview method548() {
      return class11.renderOverview;
   }
}
