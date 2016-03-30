import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bn")
public class class57 {
   @ObfuscatedName("s")
   int field1204;
   @ObfuscatedName("t")
   int[] field1205 = new int[2];
   @ObfuscatedName("p")
   int[] field1206 = new int[2];
   @ObfuscatedName("e")
   int field1207;
   @ObfuscatedName("m")
   int field1208;
   @ObfuscatedName("c")
   int field1209;
   @ObfuscatedName("z")
   int field1210;
   @ObfuscatedName("l")
   int field1211;
   @ObfuscatedName("y")
   int field1212;
   @ObfuscatedName("v")
   int field1213;
   @ObfuscatedName("w")
   int field1214 = 2;

   @ObfuscatedName("w")
   final void method1242(class119 var1) {
      this.field1209 = var1.method2506();
      this.field1207 = var1.method2511();
      this.field1208 = var1.method2511();
      this.method1243(var1);
   }

   @ObfuscatedName("x")
   final void method1243(class119 var1) {
      this.field1214 = var1.method2506();
      this.field1205 = new int[this.field1214];
      this.field1206 = new int[this.field1214];

      for(int var2 = 0; var2 < this.field1214; ++var2) {
         this.field1205[var2] = var1.method2508();
         this.field1206[var2] = var1.method2508();
      }

   }

   @ObfuscatedName("t")
   final void method1244() {
      this.field1213 = 0;
      this.field1211 = 0;
      this.field1210 = 0;
      this.field1204 = 0;
      this.field1212 = 0;
   }

   @ObfuscatedName("p")
   final int method1246(int var1) {
      if(this.field1212 >= this.field1213) {
         this.field1204 = this.field1206[this.field1211++] << 15;
         if(this.field1211 >= this.field1214) {
            this.field1211 = this.field1214 - 1;
         }

         this.field1213 = (int)((double)this.field1205[this.field1211] / 65536.0D * (double)var1);
         if(this.field1213 > this.field1212) {
            this.field1210 = ((this.field1206[this.field1211] << 15) - this.field1204) / (this.field1213 - this.field1212);
         }
      }

      this.field1204 += this.field1210;
      ++this.field1212;
      return this.field1204 - this.field1210 >> 15;
   }

   class57() {
      this.field1205[0] = 0;
      this.field1205[1] = '\uffff';
      this.field1206[0] = 0;
      this.field1206[1] = '\uffff';
   }
}
