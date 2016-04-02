import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bd")
public class class57 {
   @ObfuscatedName("f")
   int[] field1170 = new int[2];
   @ObfuscatedName("w")
   int[] field1171 = new int[2];
   @ObfuscatedName("k")
   int field1172;
   @ObfuscatedName("m")
   int field1173;
   @ObfuscatedName("p")
   int field1174;
   @ObfuscatedName("h")
   int field1175;
   @ObfuscatedName("g")
   int field1176;
   @ObfuscatedName("a")
   int field1177;
   @ObfuscatedName("r")
   int field1178;
   @ObfuscatedName("s")
   int field1179;
   @ObfuscatedName("e")
   int field1180 = 2;

   @ObfuscatedName("f")
   final void method1230() {
      this.field1176 = 0;
      this.field1177 = 0;
      this.field1178 = 0;
      this.field1172 = 0;
      this.field1173 = 0;
   }

   @ObfuscatedName("s")
   final int method1231(int var1) {
      if(this.field1173 >= this.field1176) {
         this.field1172 = this.field1170[this.field1177++] << 15;
         if(this.field1177 >= this.field1180) {
            this.field1177 = this.field1180 - 1;
         }

         this.field1176 = (int)((double)this.field1171[this.field1177] / 65536.0D * (double)var1);
         if(this.field1176 > this.field1173) {
            this.field1178 = ((this.field1170[this.field1177] << 15) - this.field1172) / (this.field1176 - this.field1173);
         }
      }

      this.field1172 += this.field1178;
      ++this.field1173;
      return this.field1172 - this.field1178 >> 15;
   }

   class57() {
      this.field1171[0] = 0;
      this.field1171[1] = '\uffff';
      this.field1170[0] = 0;
      this.field1170[1] = '\uffff';
   }

   @ObfuscatedName("e")
   final void method1234(class119 var1) {
      this.field1175 = var1.method2523();
      this.field1179 = var1.method2528();
      this.field1174 = var1.method2528();
      this.method1236(var1);
   }

   @ObfuscatedName("w")
   final void method1236(class119 var1) {
      this.field1180 = var1.method2523();
      this.field1171 = new int[this.field1180];
      this.field1170 = new int[this.field1180];

      for(int var2 = 0; var2 < this.field1180; ++var2) {
         this.field1171[var2] = var1.method2700();
         this.field1170[var2] = var1.method2700();
      }

   }
}
