import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bl")
@Implements("SoundEffect2")
public class SoundEffect2 {
   @ObfuscatedName("l")
   int field1050;
   @ObfuscatedName("z")
   int field1051;
   @ObfuscatedName("n")
   int[] field1052;
   @ObfuscatedName("q")
   int field1053;
   @ObfuscatedName("t")
   int field1054;
   @ObfuscatedName("d")
   int field1055;
   @ObfuscatedName("c")
   int[] field1056;
   @ObfuscatedName("u")
   int field1057;
   @ObfuscatedName("p")
   int field1058;
   @ObfuscatedName("v")
   int field1059;
   @ObfuscatedName("g")
   int field1060;

   @ObfuscatedName("d")
   final void method1120(Buffer var1) {
      this.field1058 = var1.readUnsignedByte();
      this.field1053 = var1.readInt();
      this.field1054 = var1.readInt();
      this.method1121(var1);
   }

   @ObfuscatedName("c")
   final void method1121(Buffer var1) {
      this.field1055 = var1.readUnsignedByte();
      this.field1056 = new int[this.field1055];
      this.field1052 = new int[this.field1055];

      for(int var2 = 0; var2 < this.field1055; ++var2) {
         this.field1056[var2] = var1.readUnsignedShort();
         this.field1052[var2] = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("n")
   final void method1122() {
      this.field1057 = 0;
      this.field1051 = 0;
      this.field1050 = 0;
      this.field1059 = 0;
      this.field1060 = 0;
   }

   @ObfuscatedName("q")
   final int method1123(int var1) {
      if(this.field1060 >= this.field1057) {
         this.field1059 = this.field1052[this.field1051++] << 15;
         if(this.field1051 >= this.field1055) {
            this.field1051 = this.field1055 - 1;
         }

         this.field1057 = (int)((double)this.field1056[this.field1051] / 65536.0D * (double)var1);
         if(this.field1057 > this.field1060) {
            this.field1050 = ((this.field1052[this.field1051] << 15) - this.field1059) / (this.field1057 - this.field1060);
         }
      }

      this.field1059 += this.field1050;
      ++this.field1060;
      return this.field1059 - this.field1050 >> 15;
   }

   SoundEffect2() {
      this.field1055 = 2;
      this.field1056 = new int[2];
      this.field1052 = new int[2];
      this.field1056[0] = 0;
      this.field1056[1] = '\uffff';
      this.field1052[0] = 0;
      this.field1052[1] = '\uffff';
   }
}
