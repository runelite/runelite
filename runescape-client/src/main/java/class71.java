import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bl")
public class class71 {
   @ObfuscatedName("s")
   int field1321;
   @ObfuscatedName("z")
   int field1322;
   @ObfuscatedName("t")
   int[] field1323;
   @ObfuscatedName("y")
   int[] field1324;

   class71() {
      class73.method1540(16);
      this.field1321 = class73.method1539() != 0?class73.method1540(4) + 1:1;
      if(class73.method1539() != 0) {
         class73.method1540(8);
      }

      class73.method1540(2);
      if(this.field1321 > 1) {
         this.field1322 = class73.method1540(4);
      }

      this.field1323 = new int[this.field1321];
      this.field1324 = new int[this.field1321];

      for(int var1 = 0; var1 < this.field1321; ++var1) {
         class73.method1540(8);
         this.field1323[var1] = class73.method1540(8);
         this.field1324[var1] = class73.method1540(8);
      }

   }
}
