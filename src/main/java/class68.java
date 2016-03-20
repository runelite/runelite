import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bc")
public class class68 {
   @ObfuscatedName("a")
   int field1279;
   @ObfuscatedName("r")
   int field1280;
   @ObfuscatedName("f")
   int[] field1281;
   @ObfuscatedName("s")
   int[] field1282;

   class68() {
      class70.method1568(16);
      this.field1279 = class70.method1567() != 0?class70.method1568(4) + 1:1;
      if(class70.method1567() != 0) {
         class70.method1568(8);
      }

      class70.method1568(2);
      if(this.field1279 > 1) {
         this.field1280 = class70.method1568(4);
      }

      this.field1281 = new int[this.field1279];
      this.field1282 = new int[this.field1279];

      for(int var1 = 0; var1 < this.field1279; ++var1) {
         class70.method1568(8);
         this.field1281[var1] = class70.method1568(8);
         this.field1282[var1] = class70.method1568(8);
      }

   }
}
