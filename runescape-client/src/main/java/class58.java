import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bu")
public class class58 {
   @ObfuscatedName("v")
   int field1063;
   @ObfuscatedName("m")
   int[] field1064 = new int[2];
   @ObfuscatedName("b")
   int[] field1065 = new int[2];
   @ObfuscatedName("g")
   int field1066;
   @ObfuscatedName("h")
   int field1067;
   @ObfuscatedName("k")
   int field1068;
   @ObfuscatedName("l")
   int field1069;
   @ObfuscatedName("c")
   int field1070;
   @ObfuscatedName("u")
   int field1071;
   @ObfuscatedName("o")
   int field1072 = 2;
   @ObfuscatedName("z")
   int field1073;

   @ObfuscatedName("o")
   final void method1078(Buffer var1) {
      this.field1063 = var1.readUnsignedByte();
      this.field1066 = var1.method2731();
      this.field1067 = var1.method2731();
      this.method1079(var1);
   }

   @ObfuscatedName("m")
   final void method1079(Buffer var1) {
      this.field1072 = var1.readUnsignedByte();
      this.field1064 = new int[this.field1072];
      this.field1065 = new int[this.field1072];

      for(int var2 = 0; var2 < this.field1072; ++var2) {
         this.field1064[var2] = var1.readUnsignedShort();
         this.field1065[var2] = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("g")
   final int method1081(int var1) {
      if(this.field1073 >= this.field1069) {
         this.field1068 = this.field1065[this.field1070++] << 15;
         if(this.field1070 >= this.field1072) {
            this.field1070 = this.field1072 - 1;
         }

         this.field1069 = (int)((double)this.field1064[this.field1070] / 65536.0D * (double)var1);
         if(this.field1069 > this.field1073) {
            this.field1071 = ((this.field1065[this.field1070] << 15) - this.field1068) / (this.field1069 - this.field1073);
         }
      }

      this.field1068 += this.field1071;
      ++this.field1073;
      return this.field1068 - this.field1071 >> 15;
   }

   class58() {
      this.field1064[0] = 0;
      this.field1064[1] = '\uffff';
      this.field1065[0] = 0;
      this.field1065[1] = '\uffff';
   }

   @ObfuscatedName("b")
   final void method1082() {
      this.field1069 = 0;
      this.field1070 = 0;
      this.field1071 = 0;
      this.field1068 = 0;
      this.field1073 = 0;
   }
}
