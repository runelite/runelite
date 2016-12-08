import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bx")
public class class69 {
   @ObfuscatedName("b")
   int[] field1147;
   @ObfuscatedName("m")
   int field1148;
   @ObfuscatedName("o")
   int field1149;
   @ObfuscatedName("g")
   int[] field1150;

   class69() {
      class54.method959(16);
      this.field1149 = class54.method958() != 0?class54.method959(4) + 1:1;
      if(class54.method958() != 0) {
         class54.method959(8);
      }

      class54.method959(2);
      if(this.field1149 > 1) {
         this.field1148 = class54.method959(4);
      }

      this.field1147 = new int[this.field1149];
      this.field1150 = new int[this.field1149];

      for(int var1 = 0; var1 < this.field1149; ++var1) {
         class54.method959(8);
         this.field1147[var1] = class54.method959(8);
         this.field1150[var1] = class54.method959(8);
      }

   }
}
