import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bb")
public class class71 {
   @ObfuscatedName("e")
   int[] field1350;
   @ObfuscatedName("l")
   int field1351;
   @ObfuscatedName("g")
   int field1352;
   @ObfuscatedName("r")
   int[] field1353;

   class71() {
      class73.method1668(16);
      this.field1351 = class73.method1646() != 0?class73.method1668(4) + 1:1;
      if(class73.method1646() != 0) {
         class73.method1668(8);
      }

      class73.method1668(2);
      if(this.field1351 > 1) {
         this.field1352 = class73.method1668(4);
      }

      this.field1353 = new int[this.field1351];
      this.field1350 = new int[this.field1351];

      for(int var1 = 0; var1 < this.field1351; ++var1) {
         class73.method1668(8);
         this.field1353[var1] = class73.method1668(8);
         this.field1350[var1] = class73.method1668(8);
      }

   }
}
