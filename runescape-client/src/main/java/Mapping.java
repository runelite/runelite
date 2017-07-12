import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dz")
@Implements("Mapping")
public class Mapping {
   @ObfuscatedName("i")
   int field1730;
   @ObfuscatedName("w")
   @Export("mux")
   int mux;
   @ObfuscatedName("a")
   @Export("submapFloors")
   int[] submapFloors;
   @ObfuscatedName("t")
   int[] field1729;

   Mapping() {
      class106.getInt(16);
      this.field1730 = class106.getBit() != 0?class106.getInt(4) + 1:1;
      if(class106.getBit() != 0) {
         class106.getInt(8);
      }

      class106.getInt(2);
      if(this.field1730 > 1) {
         this.mux = class106.getInt(4);
      }

      this.submapFloors = new int[this.field1730];
      this.field1729 = new int[this.field1730];

      for(int var1 = 0; var1 < this.field1730; ++var1) {
         class106.getInt(8);
         this.submapFloors[var1] = class106.getInt(8);
         this.field1729[var1] = class106.getInt(8);
      }

   }
}
