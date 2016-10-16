import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("br")
public class class60 {
   @ObfuscatedName("m")
   int field1242;
   @ObfuscatedName("z")
   int[] field1243 = new int[2];
   @ObfuscatedName("t")
   int[] field1244 = new int[2];
   @ObfuscatedName("p")
   int field1245;
   @ObfuscatedName("s")
   int field1246 = 2;
   @ObfuscatedName("y")
   int field1247;
   @ObfuscatedName("f")
   int field1248;
   @ObfuscatedName("k")
   int field1249;
   @ObfuscatedName("r")
   int field1250;
   @ObfuscatedName("h")
   int field1251;
   @ObfuscatedName("g")
   int field1252;

   @ObfuscatedName("s")
   final void method1231(Buffer var1) {
      this.field1242 = var1.method2481();
      this.field1245 = var1.method2526();
      this.field1252 = var1.method2526();
      this.method1232(var1);
   }

   @ObfuscatedName("z")
   final void method1232(Buffer var1) {
      this.field1246 = var1.method2481();
      this.field1243 = new int[this.field1246];
      this.field1244 = new int[this.field1246];

      for(int var2 = 0; var2 < this.field1246; ++var2) {
         this.field1243[var2] = var1.method2668();
         this.field1244[var2] = var1.method2668();
      }

   }

   @ObfuscatedName("y")
   final int method1241(int var1) {
      if(this.field1247 >= this.field1248) {
         this.field1250 = this.field1244[this.field1249++] << 15;
         if(this.field1249 >= this.field1246) {
            this.field1249 = this.field1246 - 1;
         }

         this.field1248 = (int)((double)this.field1243[this.field1249] / 65536.0D * (double)var1);
         if(this.field1248 > this.field1247) {
            this.field1251 = ((this.field1244[this.field1249] << 15) - this.field1250) / (this.field1248 - this.field1247);
         }
      }

      this.field1250 += this.field1251;
      ++this.field1247;
      return this.field1250 - this.field1251 >> 15;
   }

   @ObfuscatedName("t")
   final void method1243() {
      this.field1248 = 0;
      this.field1249 = 0;
      this.field1251 = 0;
      this.field1250 = 0;
      this.field1247 = 0;
   }

   class60() {
      this.field1243[0] = 0;
      this.field1243[1] = '\uffff';
      this.field1244[0] = 0;
      this.field1244[1] = '\uffff';
   }
}
