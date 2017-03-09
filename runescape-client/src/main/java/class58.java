import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bm")
public class class58 {
   @ObfuscatedName("h")
   int field1071;
   @ObfuscatedName("c")
   int[] field1072 = new int[2];
   @ObfuscatedName("d")
   int[] field1073 = new int[2];
   @ObfuscatedName("e")
   int field1074;
   @ObfuscatedName("w")
   int field1075;
   @ObfuscatedName("g")
   int field1076;
   @ObfuscatedName("k")
   int field1077;
   @ObfuscatedName("u")
   int field1078;
   @ObfuscatedName("j")
   int field1079 = 2;
   @ObfuscatedName("q")
   int field1080;
   @ObfuscatedName("y")
   int field1081;

   @ObfuscatedName("j")
   final void method1180(Buffer var1) {
      this.field1079 = var1.readUnsignedByte();
      this.field1072 = new int[this.field1079];
      this.field1073 = new int[this.field1079];

      for(int var2 = 0; var2 < this.field1079; ++var2) {
         this.field1072[var2] = var1.readUnsignedShort();
         this.field1073[var2] = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("d")
   final int method1182(int var1) {
      if(this.field1081 >= this.field1077) {
         this.field1080 = this.field1073[this.field1076++] << 15;
         if(this.field1076 >= this.field1079) {
            this.field1076 = this.field1079 - 1;
         }

         this.field1077 = (int)((double)this.field1072[this.field1076] / 65536.0D * (double)var1);
         if(this.field1077 > this.field1081) {
            this.field1074 = ((this.field1073[this.field1076] << 15) - this.field1080) / (this.field1077 - this.field1081);
         }
      }

      this.field1080 += this.field1074;
      ++this.field1081;
      return this.field1080 - this.field1074 >> 15;
   }

   @ObfuscatedName("x")
   final void method1184(Buffer var1) {
      this.field1078 = var1.readUnsignedByte();
      this.field1075 = var1.readInt();
      this.field1071 = var1.readInt();
      this.method1180(var1);
   }

   @ObfuscatedName("c")
   final void method1187() {
      this.field1077 = 0;
      this.field1076 = 0;
      this.field1074 = 0;
      this.field1080 = 0;
      this.field1081 = 0;
   }

   class58() {
      this.field1072[0] = 0;
      this.field1072[1] = '\uffff';
      this.field1073[0] = 0;
      this.field1073[1] = '\uffff';
   }
}
