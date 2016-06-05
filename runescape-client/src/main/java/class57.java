import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bh")
public class class57 {
   @ObfuscatedName("s")
   int field1205;
   @ObfuscatedName("i")
   int[] field1206 = new int[2];
   @ObfuscatedName("t")
   int field1207 = 2;
   @ObfuscatedName("g")
   int[] field1208 = new int[2];
   @ObfuscatedName("z")
   int field1209;
   @ObfuscatedName("r")
   int field1210;
   @ObfuscatedName("h")
   int field1211;
   @ObfuscatedName("f")
   int field1212;
   @ObfuscatedName("d")
   int field1213;
   @ObfuscatedName("l")
   int field1214;
   @ObfuscatedName("y")
   int field1215;

   @ObfuscatedName("t")
   final void method1190(class119 var1) {
      this.field1210 = var1.method2494();
      this.field1211 = var1.method2505();
      this.field1209 = var1.method2505();
      this.method1191(var1);
   }

   class57() {
      this.field1206[0] = 0;
      this.field1206[1] = '\uffff';
      this.field1208[0] = 0;
      this.field1208[1] = '\uffff';
   }

   @ObfuscatedName("i")
   final void method1191(class119 var1) {
      this.field1207 = var1.method2494();
      this.field1206 = new int[this.field1207];
      this.field1208 = new int[this.field1207];

      for(int var2 = 0; var2 < this.field1207; ++var2) {
         this.field1206[var2] = var1.method2470();
         this.field1208[var2] = var1.method2470();
      }

   }

   @ObfuscatedName("g")
   final void method1192() {
      this.field1212 = 0;
      this.field1205 = 0;
      this.field1213 = 0;
      this.field1214 = 0;
      this.field1215 = 0;
   }

   @ObfuscatedName("h")
   final int method1193(int var1) {
      if(this.field1215 >= this.field1212) {
         this.field1214 = this.field1208[this.field1205++] << 15;
         if(this.field1205 >= this.field1207) {
            this.field1205 = this.field1207 - 1;
         }

         this.field1212 = (int)((double)this.field1206[this.field1205] / 65536.0D * (double)var1);
         if(this.field1212 > this.field1215) {
            this.field1213 = ((this.field1208[this.field1205] << 15) - this.field1214) / (this.field1212 - this.field1215);
         }
      }

      this.field1214 += this.field1213;
      ++this.field1215;
      return this.field1214 - this.field1213 >> 15;
   }
}
