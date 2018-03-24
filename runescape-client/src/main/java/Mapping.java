import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dw")
@Implements("Mapping")
public class Mapping {
   @ObfuscatedName("t")
   int field1631;
   @ObfuscatedName("q")
   @Export("mux")
   int mux;
   @ObfuscatedName("i")
   @Export("submapFloors")
   int[] submapFloors;
   @ObfuscatedName("a")
   int[] field1632;

   Mapping() {
      class104.getInt(16);
      this.field1631 = class104.getBit() != 0?class104.getInt(4) + 1:1;
      if(class104.getBit() != 0) {
         class104.getInt(8);
      }

      class104.getInt(2);
      if(this.field1631 > 1) {
         this.mux = class104.getInt(4);
      }

      this.submapFloors = new int[this.field1631];
      this.field1632 = new int[this.field1631];

      for(int var1 = 0; var1 < this.field1631; ++var1) {
         class104.getInt(8);
         this.submapFloors[var1] = class104.getInt(8);
         this.field1632[var1] = class104.getInt(8);
      }

   }
}
