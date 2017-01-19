import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bl")
public class class58 {
   @ObfuscatedName("b")
   int field1064;
   @ObfuscatedName("c")
   int[] field1065 = new int[2];
   @ObfuscatedName("n")
   int field1066;
   @ObfuscatedName("h")
   int field1067;
   @ObfuscatedName("s")
   int field1068 = 2;
   @ObfuscatedName("g")
   int field1069;
   @ObfuscatedName("k")
   int field1070;
   @ObfuscatedName("u")
   int field1071;
   @ObfuscatedName("a")
   int field1072;
   @ObfuscatedName("r")
   int field1073;
   @ObfuscatedName("f")
   int[] field1074 = new int[2];

   @ObfuscatedName("s")
   final void method1047(Buffer var1) {
      this.field1069 = var1.readUnsignedByte();
      this.field1067 = var1.method2727();
      this.field1072 = var1.method2727();
      this.method1048(var1);
   }

   @ObfuscatedName("c")
   final void method1048(Buffer var1) {
      this.field1068 = var1.readUnsignedByte();
      this.field1065 = new int[this.field1068];
      this.field1074 = new int[this.field1068];

      for(int var2 = 0; var2 < this.field1068; ++var2) {
         this.field1065[var2] = var1.readUnsignedShort();
         this.field1074[var2] = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("f")
   final void method1049() {
      this.field1070 = 0;
      this.field1071 = 0;
      this.field1064 = 0;
      this.field1073 = 0;
      this.field1066 = 0;
   }

   @ObfuscatedName("g")
   final int method1051(int var1) {
      if(this.field1066 >= this.field1070) {
         this.field1073 = this.field1074[this.field1071++] << 15;
         if(this.field1071 >= this.field1068) {
            this.field1071 = this.field1068 - 1;
         }

         this.field1070 = (int)((double)this.field1065[this.field1071] / 65536.0D * (double)var1);
         if(this.field1070 > this.field1066) {
            this.field1064 = ((this.field1074[this.field1071] << 15) - this.field1073) / (this.field1070 - this.field1066);
         }
      }

      this.field1073 += this.field1064;
      ++this.field1066;
      return this.field1073 - this.field1064 >> 15;
   }

   class58() {
      this.field1065[0] = 0;
      this.field1065[1] = '\uffff';
      this.field1074[0] = 0;
      this.field1074[1] = '\uffff';
   }
}
