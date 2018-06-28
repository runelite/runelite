import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("da")
@Implements("Mapping")
public class Mapping {
   @ObfuscatedName("w")
   int field1413;
   @ObfuscatedName("m")
   @Export("mux")
   int mux;
   @ObfuscatedName("q")
   @Export("submapFloors")
   int[] submapFloors;
   @ObfuscatedName("b")
   int[] field1410;

   Mapping() {
      class92.getInt(16);
      this.field1413 = class92.getBit() != 0?class92.getInt(4) + 1:1;
      if(class92.getBit() != 0) {
         class92.getInt(8);
      }

      class92.getInt(2);
      if(this.field1413 > 1) {
         this.mux = class92.getInt(4);
      }

      this.submapFloors = new int[this.field1413];
      this.field1410 = new int[this.field1413];

      for(int var1 = 0; var1 < this.field1413; ++var1) {
         class92.getInt(8);
         this.submapFloors[var1] = class92.getInt(8);
         this.field1410[var1] = class92.getInt(8);
      }

   }
}
