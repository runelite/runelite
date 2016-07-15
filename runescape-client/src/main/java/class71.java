import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("br")
public class class71 {
   @ObfuscatedName("l")
   int field1349;
   @ObfuscatedName("e")
   int field1350;
   @ObfuscatedName("c")
   int[] field1351;
   @ObfuscatedName("h")
   int[] field1352;

   class71() {
      class73.method1624(16);
      this.field1350 = class73.method1628() != 0?class73.method1624(4) + 1:1;
      if(class73.method1628() != 0) {
         class73.method1624(8);
      }

      class73.method1624(2);
      if(this.field1350 > 1) {
         this.field1349 = class73.method1624(4);
      }

      this.field1351 = new int[this.field1350];
      this.field1352 = new int[this.field1350];

      for(int var1 = 0; var1 < this.field1350; ++var1) {
         class73.method1624(8);
         this.field1351[var1] = class73.method1624(8);
         this.field1352[var1] = class73.method1624(8);
      }

   }
}
