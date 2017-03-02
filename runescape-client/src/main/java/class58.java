import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bf")
public class class58 {
   @ObfuscatedName("b")
   int field1047 = 2;
   @ObfuscatedName("r")
   int field1048;
   @ObfuscatedName("i")
   int[] field1049 = new int[2];
   @ObfuscatedName("t")
   int field1050;
   @ObfuscatedName("k")
   int field1051;
   @ObfuscatedName("h")
   int field1052;
   @ObfuscatedName("a")
   int field1053;
   @ObfuscatedName("f")
   int field1054;
   @ObfuscatedName("l")
   int[] field1055 = new int[2];
   @ObfuscatedName("n")
   int field1056;
   @ObfuscatedName("z")
   int field1057;

   @ObfuscatedName("b")
   final void method1164(Buffer var1) {
      this.field1052 = var1.readUnsignedByte();
      this.field1050 = var1.readInt();
      this.field1051 = var1.readInt();
      this.method1165(var1);
   }

   @ObfuscatedName("l")
   final void method1165(Buffer var1) {
      this.field1047 = var1.readUnsignedByte();
      this.field1055 = new int[this.field1047];
      this.field1049 = new int[this.field1047];

      for(int var2 = 0; var2 < this.field1047; ++var2) {
         this.field1055[var2] = var1.readUnsignedShort();
         this.field1049[var2] = var1.readUnsignedShort();
      }

   }

   class58() {
      this.field1055[0] = 0;
      this.field1055[1] = '\uffff';
      this.field1049[0] = 0;
      this.field1049[1] = '\uffff';
   }

   @ObfuscatedName("t")
   final int method1166(int var1) {
      if(this.field1057 >= this.field1056) {
         this.field1048 = this.field1049[this.field1054++] << 15;
         if(this.field1054 >= this.field1047) {
            this.field1054 = this.field1047 - 1;
         }

         this.field1056 = (int)((double)this.field1055[this.field1054] / 65536.0D * (double)var1);
         if(this.field1056 > this.field1057) {
            this.field1053 = ((this.field1049[this.field1054] << 15) - this.field1048) / (this.field1056 - this.field1057);
         }
      }

      this.field1048 += this.field1053;
      ++this.field1057;
      return this.field1048 - this.field1053 >> 15;
   }

   @ObfuscatedName("i")
   final void method1167() {
      this.field1056 = 0;
      this.field1054 = 0;
      this.field1053 = 0;
      this.field1048 = 0;
      this.field1057 = 0;
   }
}
