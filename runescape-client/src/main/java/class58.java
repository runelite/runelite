import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bu")
public class class58 {
   @ObfuscatedName("m")
   int field1083;
   @ObfuscatedName("o")
   int field1084;
   @ObfuscatedName("h")
   int[] field1085 = new int[2];
   @ObfuscatedName("p")
   int field1086;
   @ObfuscatedName("j")
   int field1087;
   @ObfuscatedName("n")
   int field1088;
   @ObfuscatedName("q")
   int field1089 = 2;
   @ObfuscatedName("c")
   int field1090;
   @ObfuscatedName("r")
   int field1091;
   @ObfuscatedName("d")
   int[] field1092 = new int[2];
   @ObfuscatedName("i")
   int field1093;

   @ObfuscatedName("q")
   final void method1161(Buffer var1) {
      this.field1088 = var1.readUnsignedByte();
      this.field1086 = var1.method2965();
      this.field1087 = var1.method2965();
      this.method1172(var1);
   }

   @ObfuscatedName("h")
   final void method1163() {
      this.field1091 = 0;
      this.field1090 = 0;
      this.field1093 = 0;
      this.field1084 = 0;
      this.field1083 = 0;
   }

   @ObfuscatedName("p")
   final int method1164(int var1) {
      if(this.field1083 >= this.field1091) {
         this.field1084 = this.field1085[this.field1090++] << 15;
         if(this.field1090 >= this.field1089) {
            this.field1090 = this.field1089 - 1;
         }

         this.field1091 = (int)((double)this.field1092[this.field1090] / 65536.0D * (double)var1);
         if(this.field1091 > this.field1083) {
            this.field1093 = ((this.field1085[this.field1090] << 15) - this.field1084) / (this.field1091 - this.field1083);
         }
      }

      this.field1084 += this.field1093;
      ++this.field1083;
      return this.field1084 - this.field1093 >> 15;
   }

   class58() {
      this.field1092[0] = 0;
      this.field1092[1] = '\uffff';
      this.field1085[0] = 0;
      this.field1085[1] = '\uffff';
   }

   @ObfuscatedName("d")
   final void method1172(Buffer var1) {
      this.field1089 = var1.readUnsignedByte();
      this.field1092 = new int[this.field1089];
      this.field1085 = new int[this.field1089];

      for(int var2 = 0; var2 < this.field1089; ++var2) {
         this.field1092[var2] = var1.readUnsignedShort();
         this.field1085[var2] = var1.readUnsignedShort();
      }

   }
}
