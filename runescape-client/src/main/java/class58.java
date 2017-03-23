import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("by")
public class class58 {
   @ObfuscatedName("n")
   int field1085;
   @ObfuscatedName("i")
   int[] field1086 = new int[2];
   @ObfuscatedName("o")
   int field1087;
   @ObfuscatedName("h")
   int field1088;
   @ObfuscatedName("r")
   int field1089;
   @ObfuscatedName("u")
   int[] field1090 = new int[2];
   @ObfuscatedName("l")
   int field1091;
   @ObfuscatedName("f")
   int field1092 = 2;
   @ObfuscatedName("m")
   int field1093;
   @ObfuscatedName("w")
   int field1094;
   @ObfuscatedName("j")
   int field1095;

   @ObfuscatedName("f")
   final void method1138(Buffer var1) {
      this.field1087 = var1.readUnsignedByte();
      this.field1088 = var1.readInt();
      this.field1089 = var1.readInt();
      this.method1144(var1);
   }

   @ObfuscatedName("u")
   final void method1140() {
      this.field1091 = 0;
      this.field1085 = 0;
      this.field1093 = 0;
      this.field1094 = 0;
      this.field1095 = 0;
   }

   @ObfuscatedName("r")
   final int method1141(int var1) {
      if(this.field1095 >= this.field1091) {
         this.field1094 = this.field1090[this.field1085++] << 15;
         if(this.field1085 >= this.field1092) {
            this.field1085 = this.field1092 - 1;
         }

         this.field1091 = (int)((double)this.field1086[this.field1085] / 65536.0D * (double)var1);
         if(this.field1091 > this.field1095) {
            this.field1093 = ((this.field1090[this.field1085] << 15) - this.field1094) / (this.field1091 - this.field1095);
         }
      }

      this.field1094 += this.field1093;
      ++this.field1095;
      return this.field1094 - this.field1093 >> 15;
   }

   @ObfuscatedName("i")
   final void method1144(Buffer var1) {
      this.field1092 = var1.readUnsignedByte();
      this.field1086 = new int[this.field1092];
      this.field1090 = new int[this.field1092];

      for(int var2 = 0; var2 < this.field1092; ++var2) {
         this.field1086[var2] = var1.readUnsignedShort();
         this.field1090[var2] = var1.readUnsignedShort();
      }

   }

   class58() {
      this.field1086[0] = 0;
      this.field1086[1] = '\uffff';
      this.field1090[0] = 0;
      this.field1090[1] = '\uffff';
   }
}
