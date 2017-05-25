import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dl")
public class class120 {
   @ObfuscatedName("h")
   int field1707;
   @ObfuscatedName("q")
   int[] field1708;
   @ObfuscatedName("u")
   int[] field1709;
   @ObfuscatedName("i")
   int field1710;

   class120() {
      class106.method1978(16);
      this.field1710 = class106.method1977() != 0?class106.method1978(4) + 1:1;
      if(class106.method1977() != 0) {
         class106.method1978(8);
      }

      class106.method1978(2);
      if(this.field1710 > 1) {
         this.field1707 = class106.method1978(4);
      }

      this.field1709 = new int[this.field1710];
      this.field1708 = new int[this.field1710];

      for(int var1 = 0; var1 < this.field1710; ++var1) {
         class106.method1978(8);
         this.field1709[var1] = class106.method1978(8);
         this.field1708[var1] = class106.method1978(8);
      }

   }
}
