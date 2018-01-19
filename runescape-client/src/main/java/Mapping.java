import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("du")
@Implements("Mapping")
public class Mapping {
   @ObfuscatedName("n")
   int field1635;
   @ObfuscatedName("v")
   @Export("mux")
   int mux;
   @ObfuscatedName("y")
   @Export("submapFloors")
   int[] submapFloors;
   @ObfuscatedName("r")
   int[] field1633;

   Mapping() {
      class105.getInt(16);
      this.field1635 = class105.getBit() != 0?class105.getInt(4) + 1:1;
      if(class105.getBit() != 0) {
         class105.getInt(8);
      }

      class105.getInt(2);
      if(this.field1635 > 1) {
         this.mux = class105.getInt(4);
      }

      this.submapFloors = new int[this.field1635];
      this.field1633 = new int[this.field1635];

      for(int var1 = 0; var1 < this.field1635; ++var1) {
         class105.getInt(8);
         this.submapFloors[var1] = class105.getInt(8);
         this.field1633[var1] = class105.getInt(8);
      }

   }
}
