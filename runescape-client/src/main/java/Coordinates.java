import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
@Implements("Coordinates")
public class Coordinates {
   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   @Export("rssocket")
   static class159 rssocket;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2043640345
   )
   @Export("plane")
   public int plane;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 501083855
   )
   @Export("worldX")
   public int worldX;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1896838557
   )
   @Export("worldY")
   public int worldY;

   public Coordinates() {
      this.plane = -1;
   }

   @ObfuscatedSignature(
      signature = "(Lhv;)V"
   )
   public Coordinates(Coordinates var1) {
      this.plane = var1.plane;
      this.worldX = var1.worldX;
      this.worldY = var1.worldY;
   }

   public Coordinates(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   public Coordinates(int var1) {
      if(var1 == -1) {
         this.plane = -1;
      } else {
         this.plane = var1 >> 28 & 3;
         this.worldX = var1 >> 14 & 16383;
         this.worldY = var1 & 16383;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-709932987"
   )
   @Export("set")
   public void set(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-66"
   )
   public int method4357() {
      return this.plane << 28 | this.worldX << 14 | this.worldY;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lhv;I)Z",
      garbageValue = "1073741823"
   )
   boolean method4372(Coordinates var1) {
      return this.plane != var1.plane?false:(this.worldX != var1.worldX?false:this.worldY == var1.worldY);
   }

   public int hashCode() {
      return this.method4357();
   }

   public boolean equals(Object var1) {
      return this == var1?true:(!(var1 instanceof Coordinates)?false:this.method4372((Coordinates)var1));
   }

   public String toString() {
      return this.plane + "," + (this.worldX >> 6) + "," + (this.worldY >> 6) + "," + (this.worldX & 63) + "," + (this.worldY & 63);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-7"
   )
   static final int method4376(int var0, int var1) {
      int var2 = var0 + var1 * 57;
      var2 ^= var2 << 13;
      int var3 = var2 * (var2 * var2 * 15731 + 789221) + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }
}
