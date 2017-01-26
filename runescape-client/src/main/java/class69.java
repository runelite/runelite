import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bw")
public class class69 {
   @ObfuscatedName("x")
   int[] field1145;
   @ObfuscatedName("g")
   int field1146;
   @ObfuscatedName("q")
   int[] field1147;
   @ObfuscatedName("p")
   int field1148;

   class69() {
      class54.method965(16);
      this.field1148 = class54.method964() != 0?class54.method965(4) + 1:1;
      if(class54.method964() != 0) {
         class54.method965(8);
      }

      class54.method965(2);
      if(this.field1148 > 1) {
         this.field1146 = class54.method965(4);
      }

      this.field1145 = new int[this.field1148];
      this.field1147 = new int[this.field1148];

      for(int var1 = 0; var1 < this.field1148; ++var1) {
         class54.method965(8);
         this.field1145[var1] = class54.method965(8);
         this.field1147[var1] = class54.method965(8);
      }

   }
}
