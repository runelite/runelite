import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("da")
@Implements("Mapping")
public class Mapping {
   @ObfuscatedName("m")
   int field1638;
   @ObfuscatedName("p")
   @Export("mux")
   int mux;
   @ObfuscatedName("i")
   @Export("submapFloors")
   int[] submapFloors;
   @ObfuscatedName("j")
   int[] field1640;

   Mapping() {
      class105.getInt(16);
      this.field1638 = class105.getBit() != 0?class105.getInt(4) + 1:1;
      if(class105.getBit() != 0) {
         class105.getInt(8);
      }

      class105.getInt(2);
      if(this.field1638 > 1) {
         this.mux = class105.getInt(4);
      }

      this.submapFloors = new int[this.field1638];
      this.field1640 = new int[this.field1638];

      for(int var1 = 0; var1 < this.field1638; ++var1) {
         class105.getInt(8);
         this.submapFloors[var1] = class105.getInt(8);
         this.field1640[var1] = class105.getInt(8);
      }

   }
}
