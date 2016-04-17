import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bk")
public class class57 {
   @ObfuscatedName("w")
   int[] field1206 = new int[2];
   @ObfuscatedName("y")
   int field1207;
   @ObfuscatedName("a")
   int field1208 = 2;
   @ObfuscatedName("c")
   int field1209;
   @ObfuscatedName("k")
   int field1210;
   @ObfuscatedName("r")
   int field1211;
   @ObfuscatedName("p")
   int field1212;
   @ObfuscatedName("d")
   int[] field1213 = new int[2];
   @ObfuscatedName("m")
   int field1214;
   @ObfuscatedName("e")
   int field1215;
   @ObfuscatedName("q")
   int field1216;

   @ObfuscatedName("a")
   final void method1321(class119 var1) {
      this.field1211 = var1.method2613();
      this.field1209 = var1.method2618();
      this.field1210 = var1.method2618();
      this.method1326(var1);
   }

   @ObfuscatedName("c")
   final int method1323(int var1) {
      if(this.field1207 >= this.field1212) {
         this.field1215 = this.field1213[this.field1216++] << 15;
         if(this.field1216 >= this.field1208) {
            this.field1216 = this.field1208 - 1;
         }

         this.field1212 = (int)((double)this.field1206[this.field1216] / 65536.0D * (double)var1);
         if(this.field1212 > this.field1207) {
            this.field1214 = ((this.field1213[this.field1216] << 15) - this.field1215) / (this.field1212 - this.field1207);
         }
      }

      this.field1215 += this.field1214;
      ++this.field1207;
      return this.field1215 - this.field1214 >> 15;
   }

   class57() {
      this.field1206[0] = 0;
      this.field1206[1] = '\uffff';
      this.field1213[0] = 0;
      this.field1213[1] = '\uffff';
   }

   @ObfuscatedName("d")
   final void method1325() {
      this.field1212 = 0;
      this.field1216 = 0;
      this.field1214 = 0;
      this.field1215 = 0;
      this.field1207 = 0;
   }

   @ObfuscatedName("w")
   final void method1326(class119 var1) {
      this.field1208 = var1.method2613();
      this.field1206 = new int[this.field1208];
      this.field1213 = new int[this.field1208];

      for(int var2 = 0; var2 < this.field1208; ++var2) {
         this.field1206[var2] = var1.method2615();
         this.field1213[var2] = var1.method2615();
      }

   }
}
