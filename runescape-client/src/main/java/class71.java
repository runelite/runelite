import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bp")
public class class71 {
   @ObfuscatedName("k")
   int field1338;
   @ObfuscatedName("f")
   int[] field1339;
   @ObfuscatedName("q")
   int field1340;
   @ObfuscatedName("c")
   int[] field1341;

   class71() {
      class73.method1588(16);
      this.field1338 = class73.method1606() != 0?class73.method1588(4) + 1:1;
      if(class73.method1606() != 0) {
         class73.method1588(8);
      }

      class73.method1588(2);
      if(this.field1338 > 1) {
         this.field1340 = class73.method1588(4);
      }

      this.field1339 = new int[this.field1338];
      this.field1341 = new int[this.field1338];

      for(int var1 = 0; var1 < this.field1338; ++var1) {
         class73.method1588(8);
         this.field1339[var1] = class73.method1588(8);
         this.field1341[var1] = class73.method1588(8);
      }

   }
}
