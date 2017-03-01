import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bx")
public class class58 {
   @ObfuscatedName("n")
   int field1074 = 2;
   @ObfuscatedName("g")
   int[] field1075 = new int[2];
   @ObfuscatedName("v")
   int[] field1076 = new int[2];
   @ObfuscatedName("p")
   int field1077;
   @ObfuscatedName("s")
   int field1078;
   @ObfuscatedName("j")
   int field1079;
   @ObfuscatedName("a")
   int field1080;
   @ObfuscatedName("i")
   int field1081;
   @ObfuscatedName("m")
   int field1082;
   @ObfuscatedName("k")
   int field1083;
   @ObfuscatedName("y")
   int field1084;

   @ObfuscatedName("g")
   final void method1181() {
      this.field1080 = 0;
      this.field1081 = 0;
      this.field1078 = 0;
      this.field1083 = 0;
      this.field1084 = 0;
   }

   @ObfuscatedName("x")
   final void method1182(Buffer var1) {
      this.field1082 = var1.readUnsignedByte();
      this.field1077 = var1.readInt();
      this.field1079 = var1.readInt();
      this.method1183(var1);
   }

   @ObfuscatedName("n")
   final void method1183(Buffer var1) {
      this.field1074 = var1.readUnsignedByte();
      this.field1075 = new int[this.field1074];
      this.field1076 = new int[this.field1074];

      for(int var2 = 0; var2 < this.field1074; ++var2) {
         this.field1075[var2] = var1.readUnsignedShort();
         this.field1076[var2] = var1.readUnsignedShort();
      }

   }

   class58() {
      this.field1075[0] = 0;
      this.field1075[1] = '\uffff';
      this.field1076[0] = 0;
      this.field1076[1] = '\uffff';
   }

   @ObfuscatedName("v")
   final int method1196(int var1) {
      if(this.field1084 >= this.field1080) {
         this.field1083 = this.field1076[this.field1081++] << 15;
         if(this.field1081 >= this.field1074) {
            this.field1081 = this.field1074 - 1;
         }

         this.field1080 = (int)((double)this.field1075[this.field1081] / 65536.0D * (double)var1);
         if(this.field1080 > this.field1084) {
            this.field1078 = ((this.field1076[this.field1081] << 15) - this.field1083) / (this.field1080 - this.field1084);
         }
      }

      this.field1083 += this.field1078;
      ++this.field1084;
      return this.field1083 - this.field1078 >> 15;
   }
}
