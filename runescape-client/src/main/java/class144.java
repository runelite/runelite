import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
public class class144 extends class136 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1347894265
   )
   int field2221 = 1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1160107413
   )
   int field2222 = 256;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 838531355
   )
   int field2223 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 8826996337563469347L
   )
   long field2224 = class34.method713();
   @ObfuscatedName("x")
   long[] field2225 = new long[10];
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1476075715
   )
   int field2226;

   class144() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2225[var1] = this.field2224;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "10"
   )
   int vmethod3169(int var1, int var2) {
      int var3 = this.field2222;
      int var4 = this.field2221;
      this.field2222 = 300;
      this.field2221 = 1;
      this.field2224 = class34.method713();
      if(0L == this.field2225[this.field2226]) {
         this.field2222 = var3;
         this.field2221 = var4;
      } else if(this.field2224 > this.field2225[this.field2226]) {
         this.field2222 = (int)((long)(var1 * 2560) / (this.field2224 - this.field2225[this.field2226]));
      }

      if(this.field2222 < 25) {
         this.field2222 = 25;
      }

      if(this.field2222 > 256) {
         this.field2222 = 256;
         this.field2221 = (int)((long)var1 - (this.field2224 - this.field2225[this.field2226]) / 10L);
      }

      if(this.field2221 > var1) {
         this.field2221 = var1;
      }

      this.field2225[this.field2226] = this.field2224;
      this.field2226 = (1 + this.field2226) % 10;
      int var5;
      if(this.field2221 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2225[var5]) {
               this.field2225[var5] += (long)this.field2221;
            }
         }
      }

      if(this.field2221 < var2) {
         this.field2221 = var2;
      }

      class125.method2820((long)this.field2221);

      for(var5 = 0; this.field2223 < 256; this.field2223 += this.field2222) {
         ++var5;
      }

      this.field2223 &= 255;
      return var5;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2126353025"
   )
   static final void method3029() {
      if(null != Item.field694) {
         Item.field694.method3044();
         Item.field694 = null;
      }

      ChatMessages.method228();
      Projectile.region.method1948();

      for(int var1 = 0; var1 < 4; ++var1) {
         Client.collisionMaps[var1].method2442();
      }

      System.gc();
      class40.method771(2);
      Client.field517 = -1;
      Client.field518 = false;

      for(class24 var0 = (class24)class24.field604.method3850(); var0 != null; var0 = (class24)class24.field604.method3852()) {
         if(var0.field610 != null) {
            class14.field205.method1180(var0.field610);
            var0.field610 = null;
         }

         if(null != var0.field615) {
            class14.field205.method1180(var0.field615);
            var0.field615 = null;
         }
      }

      class24.field604.method3855();
      class130.setGameState(10);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1920699192"
   )
   void vmethod3173() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2225[var1] = 0L;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1553690645"
   )
   static void method3035(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.method3830((long)var0);
      if(null == var4) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.method3819(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[1 + var1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }
}
