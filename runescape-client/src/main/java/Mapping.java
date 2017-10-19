import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dd")
@Implements("Mapping")
public class Mapping {
   @ObfuscatedName("w")
   int field1709;
   @ObfuscatedName("s")
   @Export("mux")
   int mux;
   @ObfuscatedName("q")
   @Export("submapFloors")
   int[] submapFloors;
   @ObfuscatedName("o")
   int[] field1707;

   Mapping() {
      class104.getInt(16);
      this.field1709 = class104.getBit() != 0?class104.getInt(4) + 1:1;
      if(class104.getBit() != 0) {
         class104.getInt(8);
      }

      class104.getInt(2);
      if(this.field1709 > 1) {
         this.mux = class104.getInt(4);
      }

      this.submapFloors = new int[this.field1709];
      this.field1707 = new int[this.field1709];

      for(int var1 = 0; var1 < this.field1709; ++var1) {
         class104.getInt(8);
         this.submapFloors[var1] = class104.getInt(8);
         this.field1707[var1] = class104.getInt(8);
      }

   }
}
