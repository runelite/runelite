import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bc")
public class class68 {
   @ObfuscatedName("t")
   int[] field1285;
   @ObfuscatedName("x")
   int field1286;
   @ObfuscatedName("p")
   int[] field1287;
   @ObfuscatedName("w")
   int field1288;

   class68() {
      class70.method1536(16);
      this.field1288 = class70.method1530() != 0?class70.method1536(4) + 1:1;
      if(class70.method1530() != 0) {
         class70.method1536(8);
      }

      class70.method1536(2);
      if(this.field1288 > 1) {
         this.field1286 = class70.method1536(4);
      }

      this.field1285 = new int[this.field1288];
      this.field1287 = new int[this.field1288];

      for(int var1 = 0; var1 < this.field1288; ++var1) {
         class70.method1536(8);
         this.field1285[var1] = class70.method1536(8);
         this.field1287[var1] = class70.method1536(8);
      }

   }
}
