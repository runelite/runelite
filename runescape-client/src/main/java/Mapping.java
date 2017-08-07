import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dj")
@Implements("Mapping")
public class Mapping {
   @ObfuscatedName("e")
   int field1709;
   @ObfuscatedName("n")
   @Export("mux")
   int mux;
   @ObfuscatedName("g")
   @Export("submapFloors")
   int[] submapFloors;
   @ObfuscatedName("y")
   int[] field1711;

   Mapping() {
      class107.getInt(16);
      this.field1709 = class107.getBit() != 0?class107.getInt(4) + 1:1;
      if(class107.getBit() != 0) {
         class107.getInt(8);
      }

      class107.getInt(2);
      if(this.field1709 > 1) {
         this.mux = class107.getInt(4);
      }

      this.submapFloors = new int[this.field1709];
      this.field1711 = new int[this.field1709];

      for(int var1 = 0; var1 < this.field1709; ++var1) {
         class107.getInt(8);
         this.submapFloors[var1] = class107.getInt(8);
         this.field1711[var1] = class107.getInt(8);
      }

   }
}
