import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bz")
public class class60 {
   @ObfuscatedName("f")
   int field1244;
   @ObfuscatedName("m")
   int field1245;
   @ObfuscatedName("z")
   int[] field1246 = new int[2];
   @ObfuscatedName("i")
   int field1247;
   @ObfuscatedName("r")
   int field1248 = 2;
   @ObfuscatedName("l")
   int field1249;
   @ObfuscatedName("p")
   int field1250;
   @ObfuscatedName("b")
   int field1251;
   @ObfuscatedName("v")
   int field1252;
   @ObfuscatedName("d")
   int field1253;
   @ObfuscatedName("j")
   int[] field1254 = new int[2];

   @ObfuscatedName("r")
   final void method1281(Buffer var1) {
      this.field1248 = var1.method2556();
      this.field1254 = new int[this.field1248];
      this.field1246 = new int[this.field1248];

      for(int var2 = 0; var2 < this.field1248; ++var2) {
         this.field1254[var2] = var1.method2551();
         this.field1246[var2] = var1.method2551();
      }

   }

   @ObfuscatedName("j")
   final void method1282() {
      this.field1245 = 0;
      this.field1250 = 0;
      this.field1244 = 0;
      this.field1253 = 0;
      this.field1252 = 0;
   }

   @ObfuscatedName("z")
   final int method1283(int var1) {
      if(this.field1252 >= this.field1245) {
         this.field1253 = this.field1246[this.field1250++] << 15;
         if(this.field1250 >= this.field1248) {
            this.field1250 = this.field1248 - 1;
         }

         this.field1245 = (int)((double)this.field1254[this.field1250] / 65536.0D * (double)var1);
         if(this.field1245 > this.field1252) {
            this.field1244 = ((this.field1246[this.field1250] << 15) - this.field1253) / (this.field1245 - this.field1252);
         }
      }

      this.field1253 += this.field1244;
      ++this.field1252;
      return this.field1253 - this.field1244 >> 15;
   }

   class60() {
      this.field1254[0] = 0;
      this.field1254[1] = '\uffff';
      this.field1246[0] = 0;
      this.field1246[1] = '\uffff';
   }

   @ObfuscatedName("x")
   final void method1289(Buffer var1) {
      this.field1249 = var1.method2556();
      this.field1247 = var1.method2561();
      this.field1251 = var1.method2561();
      this.method1281(var1);
   }
}
