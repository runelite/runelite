import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dh")
@Implements("Mapping")
public class Mapping {
   @ObfuscatedName("i")
   int field1732;
   @ObfuscatedName("j")
   @Export("mux")
   int mux;
   @ObfuscatedName("a")
   @Export("submapFloors")
   int[] submapFloors;
   @ObfuscatedName("r")
   int[] field1733;

   Mapping() {
      class105.getInt(16);
      this.field1732 = class105.getBit() != 0?class105.getInt(4) + 1:1;
      if(class105.getBit() != 0) {
         class105.getInt(8);
      }

      class105.getInt(2);
      if(this.field1732 > 1) {
         this.mux = class105.getInt(4);
      }

      this.submapFloors = new int[this.field1732];
      this.field1733 = new int[this.field1732];

      for(int var1 = 0; var1 < this.field1732; ++var1) {
         class105.getInt(8);
         this.submapFloors[var1] = class105.getInt(8);
         this.field1733[var1] = class105.getInt(8);
      }

   }
}
