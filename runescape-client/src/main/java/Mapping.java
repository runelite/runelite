import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("db")
@Implements("Mapping")
public class Mapping {
   @ObfuscatedName("b")
   int field1634;
   @ObfuscatedName("s")
   @Export("mux")
   int mux;
   @ObfuscatedName("r")
   @Export("submapFloors")
   int[] submapFloors;
   @ObfuscatedName("g")
   int[] field1635;

   Mapping() {
      class105.getInt(16);
      this.field1634 = class105.getBit() != 0?class105.getInt(4) + 1:1;
      if(class105.getBit() != 0) {
         class105.getInt(8);
      }

      class105.getInt(2);
      if(this.field1634 > 1) {
         this.mux = class105.getInt(4);
      }

      this.submapFloors = new int[this.field1634];
      this.field1635 = new int[this.field1634];

      for(int var1 = 0; var1 < this.field1634; ++var1) {
         class105.getInt(8);
         this.submapFloors[var1] = class105.getInt(8);
         this.field1635[var1] = class105.getInt(8);
      }

   }
}
