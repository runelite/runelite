import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bo")
public class class60 {
   @ObfuscatedName("v")
   int[] field1270 = new int[2];
   @ObfuscatedName("d")
   int[] field1271 = new int[2];
   @ObfuscatedName("k")
   int field1272;
   @ObfuscatedName("r")
   int field1273;
   @ObfuscatedName("i")
   int field1274;
   @ObfuscatedName("t")
   int field1275;
   @ObfuscatedName("n")
   int field1276;
   @ObfuscatedName("a")
   int field1277 = 2;
   @ObfuscatedName("g")
   int field1278;
   @ObfuscatedName("m")
   int field1279;
   @ObfuscatedName("z")
   int field1280;

   @ObfuscatedName("a")
   final void method1286(Buffer var1) {
      this.field1275 = var1.method2528();
      this.field1273 = var1.method2533();
      this.field1280 = var1.method2533();
      this.method1287(var1);
   }

   class60() {
      this.field1271[0] = 0;
      this.field1271[1] = '\uffff';
      this.field1270[0] = 0;
      this.field1270[1] = '\uffff';
   }

   @ObfuscatedName("d")
   final void method1287(Buffer var1) {
      this.field1277 = var1.method2528();
      this.field1271 = new int[this.field1277];
      this.field1270 = new int[this.field1277];

      for(int var2 = 0; var2 < this.field1277; ++var2) {
         this.field1271[var2] = var1.method2717();
         this.field1270[var2] = var1.method2717();
      }

   }

   @ObfuscatedName("r")
   final int method1288(int var1) {
      if(this.field1272 >= this.field1276) {
         this.field1279 = this.field1270[this.field1274++] << 15;
         if(this.field1274 >= this.field1277) {
            this.field1274 = this.field1277 - 1;
         }

         this.field1276 = (int)((double)this.field1271[this.field1274] / 65536.0D * (double)var1);
         if(this.field1276 > this.field1272) {
            this.field1278 = ((this.field1270[this.field1274] << 15) - this.field1279) / (this.field1276 - this.field1272);
         }
      }

      this.field1279 += this.field1278;
      ++this.field1272;
      return this.field1279 - this.field1278 >> 15;
   }

   @ObfuscatedName("v")
   final void method1293() {
      this.field1276 = 0;
      this.field1274 = 0;
      this.field1278 = 0;
      this.field1279 = 0;
      this.field1272 = 0;
   }
}
