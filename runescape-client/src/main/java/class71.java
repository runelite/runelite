import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bm")
public class class71 {
   @ObfuscatedName("t")
   int[] field1326;
   @ObfuscatedName("f")
   int field1327;
   @ObfuscatedName("n")
   int[] field1328;
   @ObfuscatedName("e")
   int field1329;

   class71() {
      class73.method1584(16);
      this.field1327 = class73.method1581() != 0?class73.method1584(4) + 1:1;
      if(class73.method1581() != 0) {
         class73.method1584(8);
      }

      class73.method1584(2);
      if(this.field1327 > 1) {
         this.field1329 = class73.method1584(4);
      }

      this.field1328 = new int[this.field1327];
      this.field1326 = new int[this.field1327];

      for(int var1 = 0; var1 < this.field1327; ++var1) {
         class73.method1584(8);
         this.field1328[var1] = class73.method1584(8);
         this.field1326[var1] = class73.method1584(8);
      }

   }
}
