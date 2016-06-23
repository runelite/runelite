import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bc")
public class class57 {
   @ObfuscatedName("n")
   int field1210;
   @ObfuscatedName("u")
   int[] field1211 = new int[2];
   @ObfuscatedName("k")
   int field1212;
   @ObfuscatedName("l")
   int field1213;
   @ObfuscatedName("d")
   int field1214;
   @ObfuscatedName("r")
   int field1215;
   @ObfuscatedName("m")
   int field1216;
   @ObfuscatedName("g")
   int field1217;
   @ObfuscatedName("s")
   int field1218;
   @ObfuscatedName("f")
   int field1219 = 2;
   @ObfuscatedName("b")
   int[] field1220 = new int[2];

   class57() {
      this.field1211[0] = 0;
      this.field1211[1] = '\uffff';
      this.field1220[0] = 0;
      this.field1220[1] = '\uffff';
   }

   @ObfuscatedName("f")
   final void method1292(class119 var1) {
      this.field1210 = var1.method2554();
      this.field1213 = var1.method2696();
      this.field1214 = var1.method2696();
      this.method1299(var1);
   }

   @ObfuscatedName("x")
   final void method1294() {
      this.field1216 = 0;
      this.field1217 = 0;
      this.field1218 = 0;
      this.field1215 = 0;
      this.field1212 = 0;
   }

   @ObfuscatedName("b")
   final int method1295(int var1) {
      if(this.field1212 >= this.field1216) {
         this.field1215 = this.field1220[this.field1217++] << 15;
         if(this.field1217 >= this.field1219) {
            this.field1217 = this.field1219 - 1;
         }

         this.field1216 = (int)((double)this.field1211[this.field1217] / 65536.0D * (double)var1);
         if(this.field1216 > this.field1212) {
            this.field1218 = ((this.field1220[this.field1217] << 15) - this.field1215) / (this.field1216 - this.field1212);
         }
      }

      this.field1215 += this.field1218;
      ++this.field1212;
      return this.field1215 - this.field1218 >> 15;
   }

   @ObfuscatedName("u")
   final void method1299(class119 var1) {
      this.field1219 = var1.method2554();
      this.field1211 = new int[this.field1219];
      this.field1220 = new int[this.field1219];

      for(int var2 = 0; var2 < this.field1219; ++var2) {
         this.field1211[var2] = var1.method2556();
         this.field1220[var2] = var1.method2556();
      }

   }
}
