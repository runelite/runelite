import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("df")
public class class120 {
   @ObfuscatedName("n")
   int field1727;
   @ObfuscatedName("j")
   int[] field1728;
   @ObfuscatedName("i")
   int[] field1729;
   @ObfuscatedName("p")
   int field1730;

   class120() {
      class106.method1936(16);
      this.field1727 = class106.method1935() != 0?class106.method1936(4) + 1:1;
      if(class106.method1935() != 0) {
         class106.method1936(8);
      }

      class106.method1936(2);
      if(this.field1727 > 1) {
         this.field1730 = class106.method1936(4);
      }

      this.field1729 = new int[this.field1727];
      this.field1728 = new int[this.field1727];

      for(int var1 = 0; var1 < this.field1727; ++var1) {
         class106.method1936(8);
         this.field1729[var1] = class106.method1936(8);
         this.field1728[var1] = class106.method1936(8);
      }

   }
}
