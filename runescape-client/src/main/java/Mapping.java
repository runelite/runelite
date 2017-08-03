import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dc")
@Implements("Mapping")
public class Mapping {
   @ObfuscatedName("d")
   int field1712;
   @ObfuscatedName("q")
   @Export("mux")
   int mux;
   @ObfuscatedName("x")
   @Export("submapFloors")
   int[] submapFloors;
   @ObfuscatedName("y")
   int[] field1713;

   Mapping() {
      class108.getInt(16);
      this.field1712 = class108.getBit() != 0?class108.getInt(4) + 1:1;
      if(class108.getBit() != 0) {
         class108.getInt(8);
      }

      class108.getInt(2);
      if(this.field1712 > 1) {
         this.mux = class108.getInt(4);
      }

      this.submapFloors = new int[this.field1712];
      this.field1713 = new int[this.field1712];

      for(int var1 = 0; var1 < this.field1712; ++var1) {
         class108.getInt(8);
         this.submapFloors[var1] = class108.getInt(8);
         this.field1713[var1] = class108.getInt(8);
      }

   }
}
