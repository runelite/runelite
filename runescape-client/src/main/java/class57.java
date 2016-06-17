import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ba")
public class class57 {
   @ObfuscatedName("n")
   int field1169;
   @ObfuscatedName("g")
   int[] field1170 = new int[2];
   @ObfuscatedName("j")
   int[] field1171 = new int[2];
   @ObfuscatedName("d")
   int field1172;
   @ObfuscatedName("r")
   int field1173;
   @ObfuscatedName("b")
   int field1174 = 2;
   @ObfuscatedName("l")
   int field1175;
   @ObfuscatedName("u")
   int field1176;
   @ObfuscatedName("p")
   int field1177;
   @ObfuscatedName("c")
   int field1178;
   @ObfuscatedName("y")
   int field1179;

   @ObfuscatedName("b")
   final void method1234(class119 var1) {
      this.field1178 = var1.method2514();
      this.field1172 = var1.method2519();
      this.field1173 = var1.method2519();
      this.method1246(var1);
   }

   class57() {
      this.field1170[0] = 0;
      this.field1170[1] = '\uffff';
      this.field1171[0] = 0;
      this.field1171[1] = '\uffff';
   }

   @ObfuscatedName("j")
   final void method1235() {
      this.field1175 = 0;
      this.field1176 = 0;
      this.field1177 = 0;
      this.field1169 = 0;
      this.field1179 = 0;
   }

   @ObfuscatedName("d")
   final int method1236(int var1) {
      if(this.field1179 >= this.field1175) {
         this.field1169 = this.field1171[this.field1176++] << 15;
         if(this.field1176 >= this.field1174) {
            this.field1176 = this.field1174 - 1;
         }

         this.field1175 = (int)((double)this.field1170[this.field1176] / 65536.0D * (double)var1);
         if(this.field1175 > this.field1179) {
            this.field1177 = ((this.field1171[this.field1176] << 15) - this.field1169) / (this.field1175 - this.field1179);
         }
      }

      this.field1169 += this.field1177;
      ++this.field1179;
      return this.field1169 - this.field1177 >> 15;
   }

   @ObfuscatedName("g")
   final void method1246(class119 var1) {
      this.field1174 = var1.method2514();
      this.field1170 = new int[this.field1174];
      this.field1171 = new int[this.field1174];

      for(int var2 = 0; var2 < this.field1174; ++var2) {
         this.field1170[var2] = var1.method2516();
         this.field1171[var2] = var1.method2516();
      }

   }
}
