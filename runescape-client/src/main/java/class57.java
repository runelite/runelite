import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("br")
public class class57 {
   @ObfuscatedName("p")
   int[] field1205 = new int[2];
   @ObfuscatedName("o")
   int field1206;
   @ObfuscatedName("l")
   int field1207;
   @ObfuscatedName("d")
   int field1208;
   @ObfuscatedName("u")
   int field1209;
   @ObfuscatedName("s")
   int field1210 = 2;
   @ObfuscatedName("b")
   int field1211;
   @ObfuscatedName("k")
   int field1212;
   @ObfuscatedName("c")
   int field1213;
   @ObfuscatedName("j")
   int[] field1214 = new int[2];
   @ObfuscatedName("t")
   int field1215;

   @ObfuscatedName("s")
   final void method1208(class119 var1) {
      this.field1206 = var1.method2492();
      this.field1208 = var1.method2497();
      this.field1209 = var1.method2497();
      this.method1209(var1);
   }

   @ObfuscatedName("j")
   final void method1209(class119 var1) {
      this.field1210 = var1.method2492();
      this.field1214 = new int[this.field1210];
      this.field1205 = new int[this.field1210];

      for(int var2 = 0; var2 < this.field1210; ++var2) {
         this.field1214[var2] = var1.method2584();
         this.field1205[var2] = var1.method2584();
      }

   }

   @ObfuscatedName("p")
   final void method1210() {
      this.field1211 = 0;
      this.field1212 = 0;
      this.field1213 = 0;
      this.field1207 = 0;
      this.field1215 = 0;
   }

   @ObfuscatedName("x")
   final int method1211(int var1) {
      if(this.field1215 >= this.field1211) {
         this.field1207 = this.field1205[this.field1212++] << 15;
         if(this.field1212 >= this.field1210) {
            this.field1212 = this.field1210 - 1;
         }

         this.field1211 = (int)((double)this.field1214[this.field1212] / 65536.0D * (double)var1);
         if(this.field1211 > this.field1215) {
            this.field1213 = ((this.field1205[this.field1212] << 15) - this.field1207) / (this.field1211 - this.field1215);
         }
      }

      this.field1207 += this.field1213;
      ++this.field1215;
      return this.field1207 - this.field1213 >> 15;
   }

   class57() {
      this.field1214[0] = 0;
      this.field1214[1] = '\uffff';
      this.field1205[0] = 0;
      this.field1205[1] = '\uffff';
   }
}
