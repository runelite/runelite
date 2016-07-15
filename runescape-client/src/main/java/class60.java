import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bg")
public class class60 {
   @ObfuscatedName("i")
   int field1265;
   @ObfuscatedName("b")
   int field1266;
   @ObfuscatedName("l")
   int[] field1267 = new int[2];
   @ObfuscatedName("c")
   int[] field1268 = new int[2];
   @ObfuscatedName("r")
   int field1269;
   @ObfuscatedName("a")
   int field1270;
   @ObfuscatedName("e")
   int field1271 = 2;
   @ObfuscatedName("u")
   int field1272;
   @ObfuscatedName("h")
   int field1273;
   @ObfuscatedName("p")
   int field1274;
   @ObfuscatedName("o")
   int field1275;

   @ObfuscatedName("e")
   final void method1328(class122 var1) {
      this.field1270 = var1.method2610();
      this.field1273 = var1.method2614();
      this.field1269 = var1.method2614();
      this.method1329(var1);
   }

   @ObfuscatedName("l")
   final void method1329(class122 var1) {
      this.field1271 = var1.method2610();
      this.field1267 = new int[this.field1271];
      this.field1268 = new int[this.field1271];

      for(int var2 = 0; var2 < this.field1271; ++var2) {
         this.field1267[var2] = var1.method2612();
         this.field1268[var2] = var1.method2612();
      }

   }

   @ObfuscatedName("c")
   final void method1330() {
      this.field1266 = 0;
      this.field1272 = 0;
      this.field1275 = 0;
      this.field1274 = 0;
      this.field1265 = 0;
   }

   class60() {
      this.field1267[0] = 0;
      this.field1267[1] = '\uffff';
      this.field1268[0] = 0;
      this.field1268[1] = '\uffff';
   }

   @ObfuscatedName("h")
   final int method1336(int var1) {
      if(this.field1265 >= this.field1266) {
         this.field1274 = this.field1268[this.field1272++] << 15;
         if(this.field1272 >= this.field1271) {
            this.field1272 = this.field1271 - 1;
         }

         this.field1266 = (int)((double)this.field1267[this.field1272] / 65536.0D * (double)var1);
         if(this.field1266 > this.field1265) {
            this.field1275 = ((this.field1268[this.field1272] << 15) - this.field1274) / (this.field1266 - this.field1265);
         }
      }

      this.field1274 += this.field1275;
      ++this.field1265;
      return this.field1274 - this.field1275 >> 15;
   }
}
