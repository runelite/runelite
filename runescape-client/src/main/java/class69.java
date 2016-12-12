import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bu")
public class class69 {
   @ObfuscatedName("k")
   int[] field1149;
   @ObfuscatedName("e")
   int field1150;
   @ObfuscatedName("f")
   int[] field1151;
   @ObfuscatedName("i")
   int field1152;

   class69() {
      class54.method953(16);
      this.field1152 = class54.method978() != 0?class54.method953(4) + 1:1;
      if(class54.method978() != 0) {
         class54.method953(8);
      }

      class54.method953(2);
      if(this.field1152 > 1) {
         this.field1150 = class54.method953(4);
      }

      this.field1151 = new int[this.field1152];
      this.field1149 = new int[this.field1152];

      for(int var1 = 0; var1 < this.field1152; ++var1) {
         class54.method953(8);
         this.field1151[var1] = class54.method953(8);
         this.field1149[var1] = class54.method953(8);
      }

   }
}
