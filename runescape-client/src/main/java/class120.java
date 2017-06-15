import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dj")
public class class120 {
   @ObfuscatedName("t")
   int[] field1719;
   @ObfuscatedName("p")
   int field1720;
   @ObfuscatedName("m")
   int field1721;
   @ObfuscatedName("e")
   int[] field1722;

   class120() {
      class106.method1874(16);
      this.field1720 = class106.method1850() != 0?class106.method1874(4) + 1:1;
      if(class106.method1850() != 0) {
         class106.method1874(8);
      }

      class106.method1874(2);
      if(this.field1720 > 1) {
         this.field1721 = class106.method1874(4);
      }

      this.field1722 = new int[this.field1720];
      this.field1719 = new int[this.field1720];

      for(int var1 = 0; var1 < this.field1720; ++var1) {
         class106.method1874(8);
         this.field1722[var1] = class106.method1874(8);
         this.field1719[var1] = class106.method1874(8);
      }

   }
}
