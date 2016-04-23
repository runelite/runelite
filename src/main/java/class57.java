import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bo")
public class class57 {
   @ObfuscatedName("u")
   int field1182;
   @ObfuscatedName("h")
   int[] field1183 = new int[2];
   @ObfuscatedName("z")
   int field1184;
   @ObfuscatedName("n")
   int field1185;
   @ObfuscatedName("e")
   int field1186;
   @ObfuscatedName("i")
   int field1187;
   @ObfuscatedName("c")
   int field1188;
   @ObfuscatedName("r")
   int field1189;
   @ObfuscatedName("l")
   int field1190;
   @ObfuscatedName("m")
   int[] field1191 = new int[2];
   @ObfuscatedName("j")
   int field1192 = 2;

   @ObfuscatedName("j")
   final void method1224(class119 var1) {
      this.field1187 = var1.method2500();
      this.field1184 = var1.method2505();
      this.field1186 = var1.method2505();
      this.method1225(var1);
   }

   @ObfuscatedName("h")
   final void method1225(class119 var1) {
      this.field1192 = var1.method2500();
      this.field1183 = new int[this.field1192];
      this.field1191 = new int[this.field1192];

      for(int var2 = 0; var2 < this.field1192; ++var2) {
         this.field1183[var2] = var1.method2502();
         this.field1191[var2] = var1.method2502();
      }

   }

   @ObfuscatedName("z")
   final int method1226(int var1) {
      if(this.field1189 >= this.field1188) {
         this.field1182 = this.field1191[this.field1185++] << 15;
         if(this.field1185 >= this.field1192) {
            this.field1185 = this.field1192 - 1;
         }

         this.field1188 = (int)((double)this.field1183[this.field1185] / 65536.0D * (double)var1);
         if(this.field1188 > this.field1189) {
            this.field1190 = ((this.field1191[this.field1185] << 15) - this.field1182) / (this.field1188 - this.field1189);
         }
      }

      this.field1182 += this.field1190;
      ++this.field1189;
      return this.field1182 - this.field1190 >> 15;
   }

   class57() {
      this.field1183[0] = 0;
      this.field1183[1] = '\uffff';
      this.field1191[0] = 0;
      this.field1191[1] = '\uffff';
   }

   @ObfuscatedName("m")
   final void method1228() {
      this.field1188 = 0;
      this.field1185 = 0;
      this.field1190 = 0;
      this.field1182 = 0;
      this.field1189 = 0;
   }
}
