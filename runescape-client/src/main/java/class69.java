import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bw")
public class class69 {
   @ObfuscatedName("t")
   int[] field1128;
   @ObfuscatedName("l")
   int field1129;
   @ObfuscatedName("b")
   int field1130;
   @ObfuscatedName("i")
   int[] field1131;

   class69() {
      class54.method1062(16);
      this.field1130 = class54.method1065() != 0?class54.method1062(4) + 1:1;
      if(class54.method1065() != 0) {
         class54.method1062(8);
      }

      class54.method1062(2);
      if(this.field1130 > 1) {
         this.field1129 = class54.method1062(4);
      }

      this.field1131 = new int[this.field1130];
      this.field1128 = new int[this.field1130];

      for(int var1 = 0; var1 < this.field1130; ++var1) {
         class54.method1062(8);
         this.field1131[var1] = class54.method1062(8);
         this.field1128[var1] = class54.method1062(8);
      }

   }
}
