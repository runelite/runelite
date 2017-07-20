import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("db")
@Implements("Mapping")
public class Mapping {
   @ObfuscatedName("c")
   int field1686;
   @ObfuscatedName("o")
   @Export("mux")
   int mux;
   @ObfuscatedName("i")
   @Export("submapFloors")
   int[] submapFloors;
   @ObfuscatedName("u")
   int[] field1687;

   Mapping() {
      class106.getInt(16);
      this.field1686 = class106.getBit() != 0?class106.getInt(4) + 1:1;
      if(class106.getBit() != 0) {
         class106.getInt(8);
      }

      class106.getInt(2);
      if(this.field1686 > 1) {
         this.mux = class106.getInt(4);
      }

      this.submapFloors = new int[this.field1686];
      this.field1687 = new int[this.field1686];

      for(int var1 = 0; var1 < this.field1686; ++var1) {
         class106.getInt(8);
         this.submapFloors[var1] = class106.getInt(8);
         this.field1687[var1] = class106.getInt(8);
      }

   }
}
