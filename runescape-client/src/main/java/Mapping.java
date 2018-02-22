import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("du")
@Implements("Mapping")
public class Mapping {
   @ObfuscatedName("b")
   int field1607;
   @ObfuscatedName("q")
   @Export("mux")
   int mux;
   @ObfuscatedName("o")
   @Export("submapFloors")
   int[] submapFloors;
   @ObfuscatedName("p")
   int[] field1604;

   Mapping() {
      class103.getInt(16);
      this.field1607 = class103.getBit() != 0?class103.getInt(4) + 1:1;
      if(class103.getBit() != 0) {
         class103.getInt(8);
      }

      class103.getInt(2);
      if(this.field1607 > 1) {
         this.mux = class103.getInt(4);
      }

      this.submapFloors = new int[this.field1607];
      this.field1604 = new int[this.field1607];

      for(int var1 = 0; var1 < this.field1607; ++var1) {
         class103.getInt(8);
         this.submapFloors[var1] = class103.getInt(8);
         this.field1604[var1] = class103.getInt(8);
      }

   }
}
