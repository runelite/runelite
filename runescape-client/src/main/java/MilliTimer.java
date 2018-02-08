import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
@Implements("MilliTimer")
public class MilliTimer extends Timer {
   @ObfuscatedName("s")
   long[] field2096;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1888647873
   )
   int field2097;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1916113065
   )
   @Export("sleepTime")
   int sleepTime;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -3518028772346433973L
   )
   @Export("milliTime")
   long milliTime;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -880187923
   )
   int field2100;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 410827167
   )
   int field2098;

   MilliTimer() {
      this.field2096 = new long[10];
      this.field2097 = 256;
      this.sleepTime = 1;
      this.field2100 = 0;
      this.milliTime = SceneTilePaint.currentTimeMs();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2096[var1] = this.milliTime;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1942817352"
   )
   public void vmethod3287() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2096[var1] = 0L;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2085537313"
   )
   public int vmethod3288(int var1, int var2) {
      int var3 = this.field2097;
      int var4 = this.sleepTime;
      this.field2097 = 300;
      this.sleepTime = 1;
      this.milliTime = SceneTilePaint.currentTimeMs();
      if(this.field2096[this.field2098] == 0L) {
         this.field2097 = var3;
         this.sleepTime = var4;
      } else if(this.milliTime > this.field2096[this.field2098]) {
         this.field2097 = (int)((long)(var1 * 2560) / (this.milliTime - this.field2096[this.field2098]));
      }

      if(this.field2097 < 25) {
         this.field2097 = 25;
      }

      if(this.field2097 > 256) {
         this.field2097 = 256;
         this.sleepTime = (int)((long)var1 - (this.milliTime - this.field2096[this.field2098]) / 10L);
      }

      if(this.sleepTime > var1) {
         this.sleepTime = var1;
      }

      this.field2096[this.field2098] = this.milliTime;
      this.field2098 = (this.field2098 + 1) % 10;
      int var5;
      if(this.sleepTime > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(this.field2096[var5] != 0L) {
               this.field2096[var5] += (long)this.sleepTime;
            }
         }
      }

      if(this.sleepTime < var2) {
         this.sleepTime = var2;
      }

      Tile.method2712((long)this.sleepTime);

      for(var5 = 0; this.field2100 < 256; this.field2100 += this.field2097) {
         ++var5;
      }

      this.field2100 &= 255;
      return var5;
   }

   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      signature = "(Lhs;III)V",
      garbageValue = "1727847084"
   )
   static final void method3180(Widget var0, int var1, int var2) {
      if(Client.field940 == null && !Client.isMenuOpen) {
         if(var0 != null && class167.method3391(var0) != null) {
            Client.field940 = var0;
            Client.field930 = class167.method3391(var0);
            Client.field999 = var1;
            Client.field921 = var2;
            UnitPriceComparator.field308 = 0;
            Client.field1008 = false;
            int var3 = Client.menuOptionCount - 1;
            if(var3 != -1) {
               ItemContainer.method1055(var3);
            }

         }
      }
   }
}
