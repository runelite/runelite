import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bt")
public class class60 {
   @ObfuscatedName("f")
   int field1244 = 2;
   @ObfuscatedName("k")
   int field1245;
   @ObfuscatedName("n")
   int[] field1246 = new int[2];
   @ObfuscatedName("t")
   int field1247;
   @ObfuscatedName("v")
   int field1248;
   @ObfuscatedName("e")
   int[] field1249 = new int[2];
   @ObfuscatedName("m")
   int field1250;
   @ObfuscatedName("b")
   int field1251;
   @ObfuscatedName("c")
   int field1252;
   @ObfuscatedName("w")
   int field1253;
   @ObfuscatedName("l")
   int field1254;

   @ObfuscatedName("e")
   final void method1277(Buffer var1) {
      this.field1244 = var1.method2656();
      this.field1249 = new int[this.field1244];
      this.field1246 = new int[this.field1244];

      for(int var2 = 0; var2 < this.field1244; ++var2) {
         this.field1249[var2] = var1.method2535();
         this.field1246[var2] = var1.method2535();
      }

   }

   @ObfuscatedName("n")
   final void method1278() {
      this.field1250 = 0;
      this.field1245 = 0;
      this.field1252 = 0;
      this.field1253 = 0;
      this.field1254 = 0;
   }

   @ObfuscatedName("t")
   final int method1279(int var1) {
      if(this.field1254 >= this.field1250) {
         this.field1253 = this.field1246[this.field1245++] << 15;
         if(this.field1245 >= this.field1244) {
            this.field1245 = this.field1244 - 1;
         }

         this.field1250 = (int)((double)this.field1249[this.field1245] / 65536.0D * (double)var1);
         if(this.field1250 > this.field1254) {
            this.field1252 = ((this.field1246[this.field1245] << 15) - this.field1253) / (this.field1250 - this.field1254);
         }
      }

      this.field1253 += this.field1252;
      ++this.field1254;
      return this.field1253 - this.field1252 >> 15;
   }

   class60() {
      this.field1249[0] = 0;
      this.field1249[1] = '\uffff';
      this.field1246[0] = 0;
      this.field1246[1] = '\uffff';
   }

   @ObfuscatedName("f")
   final void method1284(Buffer var1) {
      this.field1251 = var1.method2656();
      this.field1247 = var1.method2538();
      this.field1248 = var1.method2538();
      this.method1277(var1);
   }
}
