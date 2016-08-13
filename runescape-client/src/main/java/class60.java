import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("be")
public class class60 {
   @ObfuscatedName("u")
   int field1269;
   @ObfuscatedName("m")
   int field1270;
   @ObfuscatedName("r")
   int[] field1271 = new int[2];
   @ObfuscatedName("e")
   int field1272;
   @ObfuscatedName("h")
   int field1273;
   @ObfuscatedName("s")
   int field1274;
   @ObfuscatedName("l")
   int field1275 = 2;
   @ObfuscatedName("g")
   int[] field1276 = new int[2];
   @ObfuscatedName("n")
   int field1277;
   @ObfuscatedName("b")
   int field1278;
   @ObfuscatedName("k")
   int field1279;

   @ObfuscatedName("g")
   final void method1356(Buffer var1) {
      this.field1275 = var1.method2633();
      this.field1276 = new int[this.field1275];
      this.field1271 = new int[this.field1275];

      for(int var2 = 0; var2 < this.field1275; ++var2) {
         this.field1276[var2] = var1.method2635();
         this.field1271[var2] = var1.method2635();
      }

   }

   @ObfuscatedName("r")
   final void method1357() {
      this.field1279 = 0;
      this.field1269 = 0;
      this.field1277 = 0;
      this.field1278 = 0;
      this.field1270 = 0;
   }

   @ObfuscatedName("e")
   final int method1358(int var1) {
      if(this.field1270 >= this.field1279) {
         this.field1278 = this.field1271[this.field1269++] << 15;
         if(this.field1269 >= this.field1275) {
            this.field1269 = this.field1275 - 1;
         }

         this.field1279 = (int)((double)this.field1276[this.field1269] / 65536.0D * (double)var1);
         if(this.field1279 > this.field1270) {
            this.field1277 = ((this.field1271[this.field1269] << 15) - this.field1278) / (this.field1279 - this.field1270);
         }
      }

      this.field1278 += this.field1277;
      ++this.field1270;
      return this.field1278 - this.field1277 >> 15;
   }

   class60() {
      this.field1276[0] = 0;
      this.field1276[1] = '\uffff';
      this.field1271[0] = 0;
      this.field1271[1] = '\uffff';
   }

   @ObfuscatedName("l")
   final void method1361(Buffer var1) {
      this.field1274 = var1.method2633();
      this.field1272 = var1.method2620();
      this.field1273 = var1.method2620();
      this.method1356(var1);
   }
}
