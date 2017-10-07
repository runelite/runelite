import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dp")
@Implements("Mapping")
public class Mapping {
   @ObfuscatedName("d")
   int field1707;
   @ObfuscatedName("k")
   @Export("mux")
   int mux;
   @ObfuscatedName("e")
   @Export("submapFloors")
   int[] submapFloors;
   @ObfuscatedName("p")
   int[] field1710;

   Mapping() {
      class104.getInt(16);
      this.field1707 = class104.getBit() != 0?class104.getInt(4) + 1:1;
      if(class104.getBit() != 0) {
         class104.getInt(8);
      }

      class104.getInt(2);
      if(this.field1707 > 1) {
         this.mux = class104.getInt(4);
      }

      this.submapFloors = new int[this.field1707];
      this.field1710 = new int[this.field1707];

      for(int var1 = 0; var1 < this.field1707; ++var1) {
         class104.getInt(8);
         this.submapFloors[var1] = class104.getInt(8);
         this.field1710[var1] = class104.getInt(8);
      }

   }
}
