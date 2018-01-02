import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ds")
@Implements("Mapping")
public class Mapping {
   @ObfuscatedName("a")
   int field1618;
   @ObfuscatedName("w")
   @Export("mux")
   int mux;
   @ObfuscatedName("e")
   @Export("submapFloors")
   int[] submapFloors;
   @ObfuscatedName("k")
   int[] field1617;

   Mapping() {
      SoundStudio.getInt(16);
      this.field1618 = SoundStudio.getBit() != 0? SoundStudio.getInt(4) + 1:1;
      if(SoundStudio.getBit() != 0) {
         SoundStudio.getInt(8);
      }

      SoundStudio.getInt(2);
      if(this.field1618 > 1) {
         this.mux = SoundStudio.getInt(4);
      }

      this.submapFloors = new int[this.field1618];
      this.field1617 = new int[this.field1618];

      for(int var1 = 0; var1 < this.field1618; ++var1) {
         SoundStudio.getInt(8);
         this.submapFloors[var1] = SoundStudio.getInt(8);
         this.field1617[var1] = SoundStudio.getInt(8);
      }

   }
}
