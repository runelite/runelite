import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("be")
public class class68 {
   @ObfuscatedName("a")
   int field1287;
   @ObfuscatedName("d")
   int[] field1288;
   @ObfuscatedName("w")
   int field1289;
   @ObfuscatedName("c")
   int[] field1290;

   class68() {
      class70.method1636(16);
      this.field1287 = class70.method1633() != 0?class70.method1636(4) + 1:1;
      if(class70.method1633() != 0) {
         class70.method1636(8);
      }

      class70.method1636(2);
      if(this.field1287 > 1) {
         this.field1289 = class70.method1636(4);
      }

      this.field1288 = new int[this.field1287];
      this.field1290 = new int[this.field1287];

      for(int var1 = 0; var1 < this.field1287; ++var1) {
         class70.method1636(8);
         this.field1288[var1] = class70.method1636(8);
         this.field1290[var1] = class70.method1636(8);
      }

   }
}
