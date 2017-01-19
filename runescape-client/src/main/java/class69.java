import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bz")
public class class69 {
   @ObfuscatedName("h")
   int[] field1143;
   @ObfuscatedName("c")
   int field1144;
   @ObfuscatedName("f")
   int[] field1145;
   @ObfuscatedName("s")
   int field1146;

   class69() {
      class54.method927(16);
      this.field1146 = class54.method926() != 0?class54.method927(4) + 1:1;
      if(class54.method926() != 0) {
         class54.method927(8);
      }

      class54.method927(2);
      if(this.field1146 > 1) {
         this.field1144 = class54.method927(4);
      }

      this.field1145 = new int[this.field1146];
      this.field1143 = new int[this.field1146];

      for(int var1 = 0; var1 < this.field1146; ++var1) {
         class54.method927(8);
         this.field1145[var1] = class54.method927(8);
         this.field1143[var1] = class54.method927(8);
      }

   }
}
