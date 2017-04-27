import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bh")
public class class69 {
   @ObfuscatedName("d")
   int field1126;
   @ObfuscatedName("c")
   int field1127;
   @ObfuscatedName("n")
   int[] field1128;
   @ObfuscatedName("q")
   int[] field1129;

   class69() {
      class54.method1004(16);
      this.field1126 = class54.method1005() != 0?class54.method1004(4) + 1:1;
      if(class54.method1005() != 0) {
         class54.method1004(8);
      }

      class54.method1004(2);
      if(this.field1126 > 1) {
         this.field1127 = class54.method1004(4);
      }

      this.field1128 = new int[this.field1126];
      this.field1129 = new int[this.field1126];

      for(int var1 = 0; var1 < this.field1126; ++var1) {
         class54.method1004(8);
         this.field1128[var1] = class54.method1004(8);
         this.field1129[var1] = class54.method1004(8);
      }

   }
}
