import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bq")
public class class69 {
   @ObfuscatedName("p")
   int[] field1160;
   @ObfuscatedName("d")
   int field1161;
   @ObfuscatedName("h")
   int[] field1162;
   @ObfuscatedName("q")
   int field1163;

   class69() {
      class54.method1051(16);
      this.field1163 = class54.method1050() != 0?class54.method1051(4) + 1:1;
      if(class54.method1050() != 0) {
         class54.method1051(8);
      }

      class54.method1051(2);
      if(this.field1163 > 1) {
         this.field1161 = class54.method1051(4);
      }

      this.field1162 = new int[this.field1163];
      this.field1160 = new int[this.field1163];

      for(int var1 = 0; var1 < this.field1163; ++var1) {
         class54.method1051(8);
         this.field1162[var1] = class54.method1051(8);
         this.field1160[var1] = class54.method1051(8);
      }

   }
}
