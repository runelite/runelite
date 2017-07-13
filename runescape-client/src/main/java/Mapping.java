import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dp")
@Implements("Mapping")
public class Mapping {
   @ObfuscatedName("a")
   int field1711;
   @ObfuscatedName("j")
   @Export("mux")
   int mux;
   @ObfuscatedName("n")
   @Export("submapFloors")
   int[] submapFloors;
   @ObfuscatedName("r")
   int[] field1708;

   Mapping() {
      class106.getInt(16);
      this.field1711 = class106.getBit() != 0?class106.getInt(4) + 1:1;
      if(class106.getBit() != 0) {
         class106.getInt(8);
      }

      class106.getInt(2);
      if(this.field1711 > 1) {
         this.mux = class106.getInt(4);
      }

      this.submapFloors = new int[this.field1711];
      this.field1708 = new int[this.field1711];

      for(int var1 = 0; var1 < this.field1711; ++var1) {
         class106.getInt(8);
         this.submapFloors[var1] = class106.getInt(8);
         this.field1708[var1] = class106.getInt(8);
      }

   }
}
