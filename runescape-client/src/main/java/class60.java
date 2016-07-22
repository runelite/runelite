import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bo")
public class class60 {
   @ObfuscatedName("l")
   int field1270;
   @ObfuscatedName("k")
   int field1271;
   @ObfuscatedName("m")
   int field1272 = 2;
   @ObfuscatedName("o")
   int field1273;
   @ObfuscatedName("g")
   int field1274;
   @ObfuscatedName("h")
   int field1275;
   @ObfuscatedName("w")
   int[] field1276 = new int[2];
   @ObfuscatedName("r")
   int field1277;
   @ObfuscatedName("e")
   int[] field1278 = new int[2];
   @ObfuscatedName("v")
   int field1279;
   @ObfuscatedName("j")
   int field1280;

   class60() {
      this.field1276[0] = 0;
      this.field1276[1] = '\uffff';
      this.field1278[0] = 0;
      this.field1278[1] = '\uffff';
   }

   @ObfuscatedName("w")
   final void method1306(class122 var1) {
      this.field1272 = var1.method2556();
      this.field1276 = new int[this.field1272];
      this.field1278 = new int[this.field1272];

      for(int var2 = 0; var2 < this.field1272; ++var2) {
         this.field1276[var2] = var1.method2706();
         this.field1278[var2] = var1.method2706();
      }

   }

   @ObfuscatedName("m")
   final void method1307(class122 var1) {
      this.field1270 = var1.method2556();
      this.field1273 = var1.method2577();
      this.field1274 = var1.method2577();
      this.method1306(var1);
   }

   @ObfuscatedName("o")
   final int method1308(int var1) {
      if(this.field1275 >= this.field1280) {
         this.field1279 = this.field1278[this.field1277++] << 15;
         if(this.field1277 >= this.field1272) {
            this.field1277 = this.field1272 - 1;
         }

         this.field1280 = (int)((double)this.field1276[this.field1277] / 65536.0D * (double)var1);
         if(this.field1280 > this.field1275) {
            this.field1271 = ((this.field1278[this.field1277] << 15) - this.field1279) / (this.field1280 - this.field1275);
         }
      }

      this.field1279 += this.field1271;
      ++this.field1275;
      return this.field1279 - this.field1271 >> 15;
   }

   @ObfuscatedName("e")
   final void method1315() {
      this.field1280 = 0;
      this.field1277 = 0;
      this.field1271 = 0;
      this.field1279 = 0;
      this.field1275 = 0;
   }
}
