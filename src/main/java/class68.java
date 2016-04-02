import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bg")
public class class68 {
   @ObfuscatedName("s")
   int[] field1251;
   @ObfuscatedName("w")
   int field1252;
   @ObfuscatedName("f")
   int[] field1253;
   @ObfuscatedName("e")
   int field1254;

   class68() {
      class70.method1555(16);
      this.field1254 = class70.method1559() != 0?class70.method1555(4) + 1:1;
      if(class70.method1559() != 0) {
         class70.method1555(8);
      }

      class70.method1555(2);
      if(this.field1254 > 1) {
         this.field1252 = class70.method1555(4);
      }

      this.field1253 = new int[this.field1254];
      this.field1251 = new int[this.field1254];

      for(int var1 = 0; var1 < this.field1254; ++var1) {
         class70.method1555(8);
         this.field1253[var1] = class70.method1555(8);
         this.field1251[var1] = class70.method1555(8);
      }

   }
}
