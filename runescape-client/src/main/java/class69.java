import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bx")
public class class69 {
   @ObfuscatedName("c")
   int[] field1151;
   @ObfuscatedName("j")
   int field1152;
   @ObfuscatedName("d")
   int[] field1153;
   @ObfuscatedName("x")
   int field1154;

   class69() {
      class54.method1066(16);
      this.field1154 = class54.method1065() != 0?class54.method1066(4) + 1:1;
      if(class54.method1065() != 0) {
         class54.method1066(8);
      }

      class54.method1066(2);
      if(this.field1154 > 1) {
         this.field1152 = class54.method1066(4);
      }

      this.field1151 = new int[this.field1154];
      this.field1153 = new int[this.field1154];

      for(int var1 = 0; var1 < this.field1154; ++var1) {
         class54.method1066(8);
         this.field1151[var1] = class54.method1066(8);
         this.field1153[var1] = class54.method1066(8);
      }

   }
}
