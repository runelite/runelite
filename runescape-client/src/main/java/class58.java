import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bs")
public class class58 {
   @ObfuscatedName("v")
   int field1067;
   @ObfuscatedName("e")
   int[] field1068 = new int[2];
   @ObfuscatedName("i")
   int field1069 = 2;
   @ObfuscatedName("k")
   int field1070;
   @ObfuscatedName("g")
   int field1071;
   @ObfuscatedName("w")
   int field1072;
   @ObfuscatedName("a")
   int field1073;
   @ObfuscatedName("q")
   int field1074;
   @ObfuscatedName("f")
   int[] field1075 = new int[2];
   @ObfuscatedName("n")
   int field1076;
   @ObfuscatedName("h")
   int field1077;

   @ObfuscatedName("e")
   final void method1071(Buffer var1) {
      this.field1069 = var1.readUnsignedByte();
      this.field1068 = new int[this.field1069];
      this.field1075 = new int[this.field1069];

      for(int var2 = 0; var2 < this.field1069; ++var2) {
         this.field1068[var2] = var1.readUnsignedShort();
         this.field1075[var2] = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("i")
   final void method1072(Buffer var1) {
      this.field1076 = var1.readUnsignedByte();
      this.field1070 = var1.method2844();
      this.field1071 = var1.method2844();
      this.method1071(var1);
   }

   @ObfuscatedName("k")
   final int method1075(int var1) {
      if(this.field1077 >= this.field1073) {
         this.field1067 = this.field1075[this.field1074++] << 15;
         if(this.field1074 >= this.field1069) {
            this.field1074 = this.field1069 - 1;
         }

         this.field1073 = (int)((double)this.field1068[this.field1074] / 65536.0D * (double)var1);
         if(this.field1073 > this.field1077) {
            this.field1072 = ((this.field1075[this.field1074] << 15) - this.field1067) / (this.field1073 - this.field1077);
         }
      }

      this.field1067 += this.field1072;
      ++this.field1077;
      return this.field1067 - this.field1072 >> 15;
   }

   class58() {
      this.field1068[0] = 0;
      this.field1068[1] = '\uffff';
      this.field1075[0] = 0;
      this.field1075[1] = '\uffff';
   }

   @ObfuscatedName("f")
   final void method1080() {
      this.field1073 = 0;
      this.field1074 = 0;
      this.field1072 = 0;
      this.field1067 = 0;
      this.field1077 = 0;
   }
}
