import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bt")
public class class71 {
   @ObfuscatedName("j")
   int[] field1323;
   @ObfuscatedName("x")
   int field1324;
   @ObfuscatedName("z")
   int[] field1325;
   @ObfuscatedName("r")
   int field1326;

   class71() {
      class73.method1560(16);
      this.field1324 = class73.method1558() != 0?class73.method1560(4) + 1:1;
      if(class73.method1558() != 0) {
         class73.method1560(8);
      }

      class73.method1560(2);
      if(this.field1324 > 1) {
         this.field1326 = class73.method1560(4);
      }

      this.field1323 = new int[this.field1324];
      this.field1325 = new int[this.field1324];

      for(int var1 = 0; var1 < this.field1324; ++var1) {
         class73.method1560(8);
         this.field1323[var1] = class73.method1560(8);
         this.field1325[var1] = class73.method1560(8);
      }

   }
}
