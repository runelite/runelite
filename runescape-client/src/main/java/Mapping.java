import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dt")
@Implements("Mapping")
public class Mapping {
   @ObfuscatedName("o")
   int field1664;
   @ObfuscatedName("k")
   @Export("mux")
   int mux;
   @ObfuscatedName("t")
   @Export("submapFloors")
   int[] submapFloors;
   @ObfuscatedName("d")
   int[] field1662;

   Mapping() {
      class104.getInt(16);
      this.field1664 = class104.getBit() != 0?class104.getInt(4) + 1:1;
      if(class104.getBit() != 0) {
         class104.getInt(8);
      }

      class104.getInt(2);
      if(this.field1664 > 1) {
         this.mux = class104.getInt(4);
      }

      this.submapFloors = new int[this.field1664];
      this.field1662 = new int[this.field1664];

      for(int var1 = 0; var1 < this.field1664; ++var1) {
         class104.getInt(8);
         this.submapFloors[var1] = class104.getInt(8);
         this.field1662[var1] = class104.getInt(8);
      }

   }
}
