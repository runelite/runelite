import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bm")
public class class68 {
   @ObfuscatedName("h")
   int[] field1283;
   @ObfuscatedName("i")
   int field1284;
   @ObfuscatedName("g")
   int[] field1285;
   @ObfuscatedName("t")
   int field1286;

   class68() {
      class70.method1487(16);
      this.field1286 = class70.method1505() != 0?class70.method1487(4) + 1:1;
      if(class70.method1505() != 0) {
         class70.method1487(8);
      }

      class70.method1487(2);
      if(this.field1286 > 1) {
         this.field1284 = class70.method1487(4);
      }

      this.field1285 = new int[this.field1286];
      this.field1283 = new int[this.field1286];

      for(int var1 = 0; var1 < this.field1286; ++var1) {
         class70.method1487(8);
         this.field1285[var1] = class70.method1487(8);
         this.field1283[var1] = class70.method1487(8);
      }

   }
}
