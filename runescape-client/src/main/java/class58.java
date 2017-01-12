import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bb")
public class class58 {
   @ObfuscatedName("t")
   int field1057;
   @ObfuscatedName("i")
   int[] field1058 = new int[2];
   @ObfuscatedName("a")
   int[] field1059 = new int[2];
   @ObfuscatedName("u")
   int field1060 = 2;
   @ObfuscatedName("c")
   int field1061;
   @ObfuscatedName("d")
   int field1062;
   @ObfuscatedName("l")
   int field1063;
   @ObfuscatedName("g")
   int field1064;
   @ObfuscatedName("m")
   int field1065;
   @ObfuscatedName("z")
   int field1066;
   @ObfuscatedName("f")
   int field1067;

   @ObfuscatedName("x")
   final void method1060(Buffer var1) {
      this.field1060 = var1.readUnsignedByte();
      this.field1058 = new int[this.field1060];
      this.field1059 = new int[this.field1060];

      for(int var2 = 0; var2 < this.field1060; ++var2) {
         this.field1058[var2] = var1.readUnsignedShort();
         this.field1059[var2] = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("i")
   final void method1061() {
      this.field1063 = 0;
      this.field1064 = 0;
      this.field1066 = 0;
      this.field1057 = 0;
      this.field1065 = 0;
   }

   @ObfuscatedName("a")
   final int method1062(int var1) {
      if(this.field1065 >= this.field1063) {
         this.field1057 = this.field1059[this.field1064++] << 15;
         if(this.field1064 >= this.field1060) {
            this.field1064 = this.field1060 - 1;
         }

         this.field1063 = (int)((double)this.field1058[this.field1064] / 65536.0D * (double)var1);
         if(this.field1063 > this.field1065) {
            this.field1066 = ((this.field1059[this.field1064] << 15) - this.field1057) / (this.field1063 - this.field1065);
         }
      }

      this.field1057 += this.field1066;
      ++this.field1065;
      return this.field1057 - this.field1066 >> 15;
   }

   @ObfuscatedName("u")
   final void method1064(Buffer var1) {
      this.field1062 = var1.readUnsignedByte();
      this.field1067 = var1.method2780();
      this.field1061 = var1.method2780();
      this.method1060(var1);
   }

   class58() {
      this.field1058[0] = 0;
      this.field1058[1] = '\uffff';
      this.field1059[0] = 0;
      this.field1059[1] = '\uffff';
   }
}
