import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
public class class99 extends class109 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -6308552715132342359L
   )
   long field1644 = class2.method27();
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -653052253
   )
   int field1645 = 256;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1786191527
   )
   int field1646 = 1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -68200569
   )
   int field1648 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 555681619
   )
   int field1649;
   @ObfuscatedName("s")
   long[] field1650 = new long[10];

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1247412707"
   )
   int vmethod1991(int var1, int var2) {
      int var3 = this.field1645;
      int var4 = this.field1646;
      this.field1645 = 300;
      this.field1646 = 1;
      this.field1644 = class2.method27();
      if(this.field1650[this.field1649] == 0L) {
         this.field1645 = var3;
         this.field1646 = var4;
      } else if(this.field1644 > this.field1650[this.field1649]) {
         this.field1645 = (int)((long)(var1 * 2560) / (this.field1644 - this.field1650[this.field1649]));
      }

      if(this.field1645 < 25) {
         this.field1645 = 25;
      }

      if(this.field1645 > 256) {
         this.field1645 = 256;
         this.field1646 = (int)((long)var1 - (this.field1644 - this.field1650[this.field1649]) / 10L);
      }

      if(this.field1646 > var1) {
         this.field1646 = var1;
      }

      this.field1650[this.field1649] = this.field1644;
      this.field1649 = (1 + this.field1649) % 10;
      int var5;
      if(this.field1646 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field1650[var5]) {
               this.field1650[var5] += (long)this.field1646;
            }
         }
      }

      if(this.field1646 < var2) {
         this.field1646 = var2;
      }

      Projectile.method757((long)this.field1646);

      for(var5 = 0; this.field1648 < 256; this.field1648 += this.field1645) {
         ++var5;
      }

      this.field1648 &= 255;
      return var5;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-386451580"
   )
   public void vmethod1992() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1650[var1] = 0L;
      }

   }

   class99() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1650[var1] = this.field1644;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass182;IIB)[LSpritePixels;",
      garbageValue = "119"
   )
   static SpritePixels[] method1882(class182 var0, int var1, int var2) {
      return !class37.method718(var0, var1, var2)?null:class164.method3034();
   }
}
