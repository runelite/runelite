import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
public class class151 extends class158 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -820188237
   )
   int field2216;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 255155553
   )
   int field2217;
   @ObfuscatedName("n")
   long[] field2218;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1797148015
   )
   int field2221;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -256171155
   )
   int field2224;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -8603905455344683259L
   )
   long field2225;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2087389048"
   )
   public void vmethod2979() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2218[var1] = 0L;
      }

   }

   public class151() {
      this.field2218 = new long[10];
      this.field2217 = 256;
      this.field2224 = 1;
      this.field2216 = 0;
      this.field2225 = class134.method2587();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2218[var1] = this.field2225;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1909349990"
   )
   public int vmethod2985(int var1, int var2) {
      int var3 = this.field2217;
      int var4 = this.field2224;
      this.field2217 = 300;
      this.field2224 = 1;
      this.field2225 = class134.method2587();
      if(0L == this.field2218[this.field2221]) {
         this.field2217 = var3;
         this.field2224 = var4;
      } else if(this.field2225 > this.field2218[this.field2221]) {
         this.field2217 = (int)((long)(var1 * 2560) / (this.field2225 - this.field2218[this.field2221]));
      }

      if(this.field2217 < 25) {
         this.field2217 = 25;
      }

      if(this.field2217 > 256) {
         this.field2217 = 256;
         this.field2224 = (int)((long)var1 - (this.field2225 - this.field2218[this.field2221]) / 10L);
      }

      if(this.field2224 > var1) {
         this.field2224 = var1;
      }

      this.field2218[this.field2221] = this.field2225;
      this.field2221 = (this.field2221 + 1) % 10;
      int var5;
      if(this.field2224 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(this.field2218[var5] != 0L) {
               this.field2218[var5] += (long)this.field2224;
            }
         }
      }

      if(this.field2224 < var2) {
         this.field2224 = var2;
      }

      DynamicObject.method1842((long)this.field2224);

      for(var5 = 0; this.field2216 < 256; this.field2216 += this.field2217) {
         ++var5;
      }

      this.field2216 &= 255;
      return var5;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;I)V",
      garbageValue = "1307583429"
   )
   public static void method2927(IndexDataBase var0) {
      Overlay.field3598 = var0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;I)LModIcon;",
      garbageValue = "1277597696"
   )
   public static ModIcon method2928(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.method4141(var1);
      int var4 = var0.method4209(var3, var2);
      ModIcon var5;
      if(!class112.method2092(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = GameEngine.method967();
      }

      return var5;
   }
}
