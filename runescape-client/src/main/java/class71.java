import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bw")
public class class71 {
   @ObfuscatedName("a")
   int field1351;
   @ObfuscatedName("d")
   int field1352;
   @ObfuscatedName("v")
   int[] field1353;
   @ObfuscatedName("r")
   int[] field1354;

   class71() {
      class73.method1599(16);
      this.field1351 = class73.method1582() != 0?class73.method1599(4) + 1:1;
      if(class73.method1582() != 0) {
         class73.method1599(8);
      }

      class73.method1599(2);
      if(this.field1351 > 1) {
         this.field1352 = class73.method1599(4);
      }

      this.field1353 = new int[this.field1351];
      this.field1354 = new int[this.field1351];

      for(int var1 = 0; var1 < this.field1351; ++var1) {
         class73.method1599(8);
         this.field1353[var1] = class73.method1599(8);
         this.field1354[var1] = class73.method1599(8);
      }

   }
}
