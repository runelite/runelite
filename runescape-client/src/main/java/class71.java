import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bl")
public class class71 {
   @ObfuscatedName("m")
   int field1353;
   @ObfuscatedName("w")
   int field1354;
   @ObfuscatedName("e")
   int[] field1355;
   @ObfuscatedName("o")
   int[] field1356;

   class71() {
      class73.method1618(16);
      this.field1353 = class73.method1616() != 0?class73.method1618(4) + 1:1;
      if(class73.method1616() != 0) {
         class73.method1618(8);
      }

      class73.method1618(2);
      if(this.field1353 > 1) {
         this.field1354 = class73.method1618(4);
      }

      this.field1355 = new int[this.field1353];
      this.field1356 = new int[this.field1353];

      for(int var1 = 0; var1 < this.field1353; ++var1) {
         class73.method1618(8);
         this.field1355[var1] = class73.method1618(8);
         this.field1356[var1] = class73.method1618(8);
      }

   }
}
