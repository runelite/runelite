import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("br")
public class class68 {
   @ObfuscatedName("j")
   int field1262;
   @ObfuscatedName("h")
   int field1263;
   @ObfuscatedName("m")
   int[] field1264;
   @ObfuscatedName("z")
   int[] field1265;

   class68() {
      class70.method1533(16);
      this.field1262 = class70.method1527() != 0?class70.method1533(4) + 1:1;
      if(class70.method1527() != 0) {
         class70.method1533(8);
      }

      class70.method1533(2);
      if(this.field1262 > 1) {
         this.field1263 = class70.method1533(4);
      }

      this.field1264 = new int[this.field1262];
      this.field1265 = new int[this.field1262];

      for(int var1 = 0; var1 < this.field1262; ++var1) {
         class70.method1533(8);
         this.field1264[var1] = class70.method1533(8);
         this.field1265[var1] = class70.method1533(8);
      }

   }
}
