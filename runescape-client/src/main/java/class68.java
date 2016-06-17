import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bo")
public class class68 {
   @ObfuscatedName("b")
   int field1247;
   @ObfuscatedName("g")
   int field1248;
   @ObfuscatedName("j")
   int[] field1249;
   @ObfuscatedName("d")
   int[] field1250;

   class68() {
      class70.method1544(16);
      this.field1247 = class70.method1546() != 0?class70.method1544(4) + 1:1;
      if(class70.method1546() != 0) {
         class70.method1544(8);
      }

      class70.method1544(2);
      if(this.field1247 > 1) {
         this.field1248 = class70.method1544(4);
      }

      this.field1249 = new int[this.field1247];
      this.field1250 = new int[this.field1247];

      for(int var1 = 0; var1 < this.field1247; ++var1) {
         class70.method1544(8);
         this.field1249[var1] = class70.method1544(8);
         this.field1250[var1] = class70.method1544(8);
      }

   }
}
