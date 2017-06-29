import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dz")
public class class120 {
   @ObfuscatedName("t")
   int[] field1729;
   @ObfuscatedName("i")
   int field1730;
   @ObfuscatedName("a")
   int[] field1731;
   @ObfuscatedName("w")
   int field1732;

   class120() {
      class106.method1973(16);
      this.field1730 = class106.method1958() != 0?class106.method1973(4) + 1:1;
      if(class106.method1958() != 0) {
         class106.method1973(8);
      }

      class106.method1973(2);
      if(this.field1730 > 1) {
         this.field1732 = class106.method1973(4);
      }

      this.field1731 = new int[this.field1730];
      this.field1729 = new int[this.field1730];

      for(int var1 = 0; var1 < this.field1730; ++var1) {
         class106.method1973(8);
         this.field1731[var1] = class106.method1973(8);
         this.field1729[var1] = class106.method1973(8);
      }

   }
}
