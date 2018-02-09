import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dd")
@Implements("Mapping")
public class Mapping {
   @ObfuscatedName("s")
   int field1631;
   @ObfuscatedName("g")
   @Export("mux")
   int mux;
   @ObfuscatedName("m")
   @Export("submapFloors")
   int[] submapFloors;
   @ObfuscatedName("h")
   int[] field1632;

   Mapping() {
      class105.getInt(16);
      this.field1631 = class105.getBit() != 0?class105.getInt(4) + 1:1;
      if(class105.getBit() != 0) {
         class105.getInt(8);
      }

      class105.getInt(2);
      if(this.field1631 > 1) {
         this.mux = class105.getInt(4);
      }

      this.submapFloors = new int[this.field1631];
      this.field1632 = new int[this.field1631];

      for(int var1 = 0; var1 < this.field1631; ++var1) {
         class105.getInt(8);
         this.submapFloors[var1] = class105.getInt(8);
         this.field1632[var1] = class105.getInt(8);
      }

   }
}
