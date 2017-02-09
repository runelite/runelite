import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bx")
public class class58 {
   @ObfuscatedName("w")
   int field1063;
   @ObfuscatedName("o")
   int[] field1064 = new int[2];
   @ObfuscatedName("r")
   int[] field1065 = new int[2];
   @ObfuscatedName("q")
   int field1066;
   @ObfuscatedName("j")
   int field1067;
   @ObfuscatedName("k")
   int field1068 = 2;
   @ObfuscatedName("s")
   int field1069;
   @ObfuscatedName("n")
   int field1070;
   @ObfuscatedName("c")
   int field1071;
   @ObfuscatedName("d")
   int field1072;
   @ObfuscatedName("y")
   int field1073;

   @ObfuscatedName("o")
   final void method1106() {
      this.field1072 = 0;
      this.field1070 = 0;
      this.field1071 = 0;
      this.field1069 = 0;
      this.field1073 = 0;
   }

   @ObfuscatedName("y")
   final void method1108(Buffer var1) {
      this.field1068 = var1.readUnsignedByte();
      this.field1064 = new int[this.field1068];
      this.field1065 = new int[this.field1068];

      for(int var2 = 0; var2 < this.field1068; ++var2) {
         this.field1064[var2] = var1.readUnsignedShort();
         this.field1065[var2] = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("r")
   final int method1110(int var1) {
      if(this.field1073 >= this.field1072) {
         this.field1069 = this.field1065[this.field1070++] << 15;
         if(this.field1070 >= this.field1068) {
            this.field1070 = this.field1068 - 1;
         }

         this.field1072 = (int)((double)this.field1064[this.field1070] / 65536.0D * (double)var1);
         if(this.field1072 > this.field1073) {
            this.field1071 = ((this.field1065[this.field1070] << 15) - this.field1069) / (this.field1072 - this.field1073);
         }
      }

      this.field1069 += this.field1071;
      ++this.field1073;
      return this.field1069 - this.field1071 >> 15;
   }

   class58() {
      this.field1064[0] = 0;
      this.field1064[1] = '\uffff';
      this.field1065[0] = 0;
      this.field1065[1] = '\uffff';
   }

   @ObfuscatedName("k")
   final void method1116(Buffer var1) {
      this.field1066 = var1.readUnsignedByte();
      this.field1063 = var1.method3062();
      this.field1067 = var1.method3062();
      this.method1108(var1);
   }
}
