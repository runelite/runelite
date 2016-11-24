import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bg")
public class class69 {
   @ObfuscatedName("d")
   int field1137;
   @ObfuscatedName("h")
   int[] field1138;
   @ObfuscatedName("n")
   int field1139;
   @ObfuscatedName("m")
   int[] field1140;

   class69() {
      class54.method992(16);
      this.field1139 = class54.method985() != 0?class54.method992(4) + 1:1;
      if(class54.method985() != 0) {
         class54.method992(8);
      }

      class54.method992(2);
      if(this.field1139 > 1) {
         this.field1137 = class54.method992(4);
      }

      this.field1140 = new int[this.field1139];
      this.field1138 = new int[this.field1139];

      for(int var1 = 0; var1 < this.field1139; ++var1) {
         class54.method992(8);
         this.field1140[var1] = class54.method992(8);
         this.field1138[var1] = class54.method992(8);
      }

   }
}
