import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dy")
@Implements("Mapping")
public class Mapping {
   @ObfuscatedName("g")
   int field1627;
   @ObfuscatedName("e")
   @Export("mux")
   int mux;
   @ObfuscatedName("b")
   @Export("submapFloors")
   int[] submapFloors;
   @ObfuscatedName("z")
   int[] field1625;

   Mapping() {
      class104.getInt(16);
      this.field1627 = class104.getBit() != 0?class104.getInt(4) + 1:1;
      if(class104.getBit() != 0) {
         class104.getInt(8);
      }

      class104.getInt(2);
      if(this.field1627 > 1) {
         this.mux = class104.getInt(4);
      }

      this.submapFloors = new int[this.field1627];
      this.field1625 = new int[this.field1627];

      for(int var1 = 0; var1 < this.field1627; ++var1) {
         class104.getInt(8);
         this.submapFloors[var1] = class104.getInt(8);
         this.field1625[var1] = class104.getInt(8);
      }

   }
}
