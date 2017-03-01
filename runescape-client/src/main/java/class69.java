import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bg")
public class class69 {
   @ObfuscatedName("v")
   int[] field1160;
   @ObfuscatedName("n")
   int field1161;
   @ObfuscatedName("g")
   int[] field1162;
   @ObfuscatedName("x")
   int field1163;

   class69() {
      class54.method1070(16);
      this.field1163 = class54.method1090() != 0?class54.method1070(4) + 1:1;
      if(class54.method1090() != 0) {
         class54.method1070(8);
      }

      class54.method1070(2);
      if(this.field1163 > 1) {
         this.field1161 = class54.method1070(4);
      }

      this.field1162 = new int[this.field1163];
      this.field1160 = new int[this.field1163];

      for(int var1 = 0; var1 < this.field1163; ++var1) {
         class54.method1070(8);
         this.field1162[var1] = class54.method1070(8);
         this.field1160[var1] = class54.method1070(8);
      }

   }
}
