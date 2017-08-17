import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("du")
@Implements("Mapping")
public class Mapping {
   @ObfuscatedName("j")
   int field1731;
   @ObfuscatedName("h")
   @Export("mux")
   int mux;
   @ObfuscatedName("f")
   @Export("submapFloors")
   int[] submapFloors;
   @ObfuscatedName("p")
   int[] field1730;

   Mapping() {
      class107.getInt(16);
      this.field1731 = class107.getBit() != 0?class107.getInt(4) + 1:1;
      if(class107.getBit() != 0) {
         class107.getInt(8);
      }

      class107.getInt(2);
      if(this.field1731 > 1) {
         this.mux = class107.getInt(4);
      }

      this.submapFloors = new int[this.field1731];
      this.field1730 = new int[this.field1731];

      for(int var1 = 0; var1 < this.field1731; ++var1) {
         class107.getInt(8);
         this.submapFloors[var1] = class107.getInt(8);
         this.field1730[var1] = class107.getInt(8);
      }

   }
}
