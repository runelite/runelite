import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bb")
public class class68 {
   @ObfuscatedName("s")
   int field1285;
   @ObfuscatedName("p")
   int[] field1286;
   @ObfuscatedName("j")
   int field1287;
   @ObfuscatedName("x")
   int[] field1288;

   class68() {
      class70.method1515(16);
      this.field1285 = class70.method1535() != 0?class70.method1515(4) + 1:1;
      if(class70.method1535() != 0) {
         class70.method1515(8);
      }

      class70.method1515(2);
      if(this.field1285 > 1) {
         this.field1287 = class70.method1515(4);
      }

      this.field1286 = new int[this.field1285];
      this.field1288 = new int[this.field1285];

      for(int var1 = 0; var1 < this.field1285; ++var1) {
         class70.method1515(8);
         this.field1286[var1] = class70.method1515(8);
         this.field1288[var1] = class70.method1515(8);
      }

   }
}
