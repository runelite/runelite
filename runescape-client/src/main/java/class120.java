import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ds")
public class class120 {
   @ObfuscatedName("e")
   int[] field1736;
   @ObfuscatedName("c")
   int field1737;
   @ObfuscatedName("i")
   int field1738;
   @ObfuscatedName("v")
   int[] field1739;

   class120() {
      class106.method1950(16);
      this.field1738 = class106.method1949() != 0?class106.method1950(4) + 1:1;
      if(class106.method1949() != 0) {
         class106.method1950(8);
      }

      class106.method1950(2);
      if(this.field1738 > 1) {
         this.field1737 = class106.method1950(4);
      }

      this.field1736 = new int[this.field1738];
      this.field1739 = new int[this.field1738];

      for(int var1 = 0; var1 < this.field1738; ++var1) {
         class106.method1950(8);
         this.field1736[var1] = class106.method1950(8);
         this.field1739[var1] = class106.method1950(8);
      }

   }
}
