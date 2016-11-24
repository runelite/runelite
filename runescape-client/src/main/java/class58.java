import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bo")
public class class58 {
   @ObfuscatedName("m")
   int[] field1056 = new int[2];
   @ObfuscatedName("d")
   int[] field1057 = new int[2];
   @ObfuscatedName("h")
   int field1058;
   @ObfuscatedName("n")
   int field1059 = 2;
   @ObfuscatedName("p")
   int field1060;
   @ObfuscatedName("r")
   int field1061;
   @ObfuscatedName("c")
   int field1062;
   @ObfuscatedName("w")
   int field1063;
   @ObfuscatedName("g")
   int field1064;
   @ObfuscatedName("z")
   int field1065;
   @ObfuscatedName("q")
   int field1066;

   @ObfuscatedName("n")
   final void method1095(Buffer var1) {
      this.field1061 = var1.method3033();
      this.field1058 = var1.method2995();
      this.field1063 = var1.method2995();
      this.method1096(var1);
   }

   @ObfuscatedName("d")
   final void method1096(Buffer var1) {
      this.field1059 = var1.method3033();
      this.field1057 = new int[this.field1059];
      this.field1056 = new int[this.field1059];

      for(int var2 = 0; var2 < this.field1059; ++var2) {
         this.field1057[var2] = var1.method3097();
         this.field1056[var2] = var1.method3097();
      }

   }

   @ObfuscatedName("m")
   final void method1097() {
      this.field1062 = 0;
      this.field1060 = 0;
      this.field1064 = 0;
      this.field1065 = 0;
      this.field1066 = 0;
   }

   @ObfuscatedName("h")
   final int method1098(int var1) {
      if(this.field1066 >= this.field1062) {
         this.field1065 = this.field1056[this.field1060++] << 15;
         if(this.field1060 >= this.field1059) {
            this.field1060 = this.field1059 - 1;
         }

         this.field1062 = (int)((double)this.field1057[this.field1060] / 65536.0D * (double)var1);
         if(this.field1062 > this.field1066) {
            this.field1064 = ((this.field1056[this.field1060] << 15) - this.field1065) / (this.field1062 - this.field1066);
         }
      }

      this.field1065 += this.field1064;
      ++this.field1066;
      return this.field1065 - this.field1064 >> 15;
   }

   class58() {
      this.field1057[0] = 0;
      this.field1057[1] = '\uffff';
      this.field1056[0] = 0;
      this.field1056[1] = '\uffff';
   }
}
