import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bm")
public class class58 {
   @ObfuscatedName("j")
   int field1064;
   @ObfuscatedName("g")
   int[] field1065 = new int[2];
   @ObfuscatedName("p")
   int field1066 = 2;
   @ObfuscatedName("o")
   int field1067;
   @ObfuscatedName("k")
   int field1068;
   @ObfuscatedName("s")
   int field1069;
   @ObfuscatedName("q")
   int[] field1070 = new int[2];
   @ObfuscatedName("d")
   int field1071;
   @ObfuscatedName("a")
   int field1072;
   @ObfuscatedName("c")
   int field1073;
   @ObfuscatedName("m")
   int field1074;

   class58() {
      this.field1065[0] = 0;
      this.field1065[1] = '\uffff';
      this.field1070[0] = 0;
      this.field1070[1] = '\uffff';
   }

   @ObfuscatedName("g")
   final void method1075(Buffer var1) {
      this.field1066 = var1.readUnsignedByte();
      this.field1065 = new int[this.field1066];
      this.field1070 = new int[this.field1066];

      for(int var2 = 0; var2 < this.field1066; ++var2) {
         this.field1065[var2] = var1.readUnsignedShort();
         this.field1070[var2] = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("p")
   final void method1077(Buffer var1) {
      this.field1064 = var1.readUnsignedByte();
      this.field1071 = var1.method2819();
      this.field1068 = var1.method2819();
      this.method1075(var1);
   }

   @ObfuscatedName("q")
   final int method1083(int var1) {
      if(this.field1074 >= this.field1069) {
         this.field1073 = this.field1070[this.field1067++] << 15;
         if(this.field1067 >= this.field1066) {
            this.field1067 = this.field1066 - 1;
         }

         this.field1069 = (int)((double)this.field1065[this.field1067] / 65536.0D * (double)var1);
         if(this.field1069 > this.field1074) {
            this.field1072 = ((this.field1070[this.field1067] << 15) - this.field1073) / (this.field1069 - this.field1074);
         }
      }

      this.field1073 += this.field1072;
      ++this.field1074;
      return this.field1073 - this.field1072 >> 15;
   }

   @ObfuscatedName("x")
   final void method1085() {
      this.field1069 = 0;
      this.field1067 = 0;
      this.field1072 = 0;
      this.field1073 = 0;
      this.field1074 = 0;
   }
}
