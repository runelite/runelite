import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bb")
public class class68 {
   @ObfuscatedName("u")
   int field1295;
   @ObfuscatedName("f")
   int field1296;
   @ObfuscatedName("x")
   int[] field1297;
   @ObfuscatedName("b")
   int[] field1298;

   class68() {
      class70.method1596(16);
      this.field1296 = class70.method1588() != 0?class70.method1596(4) + 1:1;
      if(class70.method1588() != 0) {
         class70.method1596(8);
      }

      class70.method1596(2);
      if(this.field1296 > 1) {
         this.field1295 = class70.method1596(4);
      }

      this.field1297 = new int[this.field1296];
      this.field1298 = new int[this.field1296];

      for(int var1 = 0; var1 < this.field1296; ++var1) {
         class70.method1596(8);
         this.field1297[var1] = class70.method1596(8);
         this.field1298[var1] = class70.method1596(8);
      }

   }
}
