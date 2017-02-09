import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ba")
public class class69 {
   @ObfuscatedName("y")
   int field1146;
   @ObfuscatedName("k")
   int field1147;
   @ObfuscatedName("o")
   int[] field1148;
   @ObfuscatedName("r")
   int[] field1149;

   class69() {
      class54.method1006(16);
      this.field1147 = class54.method996() != 0?class54.method1006(4) + 1:1;
      if(class54.method996() != 0) {
         class54.method1006(8);
      }

      class54.method1006(2);
      if(this.field1147 > 1) {
         this.field1146 = class54.method1006(4);
      }

      this.field1148 = new int[this.field1147];
      this.field1149 = new int[this.field1147];

      for(int var1 = 0; var1 < this.field1147; ++var1) {
         class54.method1006(8);
         this.field1148[var1] = class54.method1006(8);
         this.field1149[var1] = class54.method1006(8);
      }

   }
}
