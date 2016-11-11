import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bq")
public class class60 {
   @ObfuscatedName("n")
   int field1252;
   @ObfuscatedName("h")
   int[] field1253 = new int[2];
   @ObfuscatedName("e")
   int[] field1254 = new int[2];
   @ObfuscatedName("g")
   int field1255;
   @ObfuscatedName("u")
   int field1256;
   @ObfuscatedName("i")
   int field1257 = 2;
   @ObfuscatedName("d")
   int field1258;
   @ObfuscatedName("l")
   int field1259;
   @ObfuscatedName("m")
   int field1260;
   @ObfuscatedName("j")
   int field1261;
   @ObfuscatedName("y")
   int field1262;

   @ObfuscatedName("i")
   final void method1269(Buffer var1) {
      this.field1256 = var1.method2544();
      this.field1255 = var1.method2549();
      this.field1252 = var1.method2549();
      this.method1274(var1);
   }

   @ObfuscatedName("e")
   final void method1271() {
      this.field1258 = 0;
      this.field1259 = 0;
      this.field1260 = 0;
      this.field1261 = 0;
      this.field1262 = 0;
   }

   @ObfuscatedName("h")
   final void method1274(Buffer var1) {
      this.field1257 = var1.method2544();
      this.field1253 = new int[this.field1257];
      this.field1254 = new int[this.field1257];

      for(int var2 = 0; var2 < this.field1257; ++var2) {
         this.field1253[var2] = var1.method2546();
         this.field1254[var2] = var1.method2546();
      }

   }

   @ObfuscatedName("g")
   final int method1275(int var1) {
      if(this.field1262 >= this.field1258) {
         this.field1261 = this.field1254[this.field1259++] << 15;
         if(this.field1259 >= this.field1257) {
            this.field1259 = this.field1257 - 1;
         }

         this.field1258 = (int)((double)this.field1253[this.field1259] / 65536.0D * (double)var1);
         if(this.field1258 > this.field1262) {
            this.field1260 = ((this.field1254[this.field1259] << 15) - this.field1261) / (this.field1258 - this.field1262);
         }
      }

      this.field1261 += this.field1260;
      ++this.field1262;
      return this.field1261 - this.field1260 >> 15;
   }

   class60() {
      this.field1253[0] = 0;
      this.field1253[1] = '\uffff';
      this.field1254[0] = 0;
      this.field1254[1] = '\uffff';
   }
}
