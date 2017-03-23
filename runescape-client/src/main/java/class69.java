import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bo")
public class class69 {
   @ObfuscatedName("i")
   int field1168;
   @ObfuscatedName("f")
   int field1169;
   @ObfuscatedName("u")
   int[] field1170;
   @ObfuscatedName("h")
   int[] field1171;

   class69() {
      class54.method1021(16);
      this.field1169 = class54.method1020() != 0?class54.method1021(4) + 1:1;
      if(class54.method1020() != 0) {
         class54.method1021(8);
      }

      class54.method1021(2);
      if(this.field1169 > 1) {
         this.field1168 = class54.method1021(4);
      }

      this.field1170 = new int[this.field1169];
      this.field1171 = new int[this.field1169];

      for(int var1 = 0; var1 < this.field1169; ++var1) {
         class54.method1021(8);
         this.field1170[var1] = class54.method1021(8);
         this.field1171[var1] = class54.method1021(8);
      }

   }
}
