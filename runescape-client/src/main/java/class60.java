import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bt")
public class class60 {
   @ObfuscatedName("m")
   int field1258;
   @ObfuscatedName("q")
   int[] field1259 = new int[2];
   @ObfuscatedName("f")
   int[] field1260 = new int[2];
   @ObfuscatedName("c")
   int field1261;
   @ObfuscatedName("v")
   int field1262;
   @ObfuscatedName("j")
   int field1263;
   @ObfuscatedName("u")
   int field1264;
   @ObfuscatedName("k")
   int field1265 = 2;
   @ObfuscatedName("h")
   int field1266;
   @ObfuscatedName("l")
   int field1267;
   @ObfuscatedName("y")
   int field1268;

   @ObfuscatedName("q")
   final void method1273(Buffer var1) {
      this.field1265 = var1.method2571();
      this.field1259 = new int[this.field1265];
      this.field1260 = new int[this.field1265];

      for(int var2 = 0; var2 < this.field1265; ++var2) {
         this.field1259[var2] = var1.method2691();
         this.field1260[var2] = var1.method2691();
      }

   }

   @ObfuscatedName("f")
   final void method1274() {
      this.field1258 = 0;
      this.field1264 = 0;
      this.field1266 = 0;
      this.field1267 = 0;
      this.field1268 = 0;
   }

   @ObfuscatedName("c")
   final int method1275(int var1) {
      if(this.field1268 >= this.field1258) {
         this.field1267 = this.field1260[this.field1264++] << 15;
         if(this.field1264 >= this.field1265) {
            this.field1264 = this.field1265 - 1;
         }

         this.field1258 = (int)((double)this.field1259[this.field1264] / 65536.0D * (double)var1);
         if(this.field1258 > this.field1268) {
            this.field1266 = ((this.field1260[this.field1264] << 15) - this.field1267) / (this.field1258 - this.field1268);
         }
      }

      this.field1267 += this.field1266;
      ++this.field1268;
      return this.field1267 - this.field1266 >> 15;
   }

   @ObfuscatedName("k")
   final void method1276(Buffer var1) {
      this.field1263 = var1.method2571();
      this.field1261 = var1.method2576();
      this.field1262 = var1.method2576();
      this.method1273(var1);
   }

   class60() {
      this.field1259[0] = 0;
      this.field1259[1] = '\uffff';
      this.field1260[0] = 0;
      this.field1260[1] = '\uffff';
   }
}
