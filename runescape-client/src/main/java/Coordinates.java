import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
@Implements("Coordinates")
public class Coordinates {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 367352575
   )
   @Export("worldX")
   public int worldX;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1626171119
   )
   @Export("plane")
   public int plane;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1329355747
   )
   @Export("worldY")
   public int worldY;

   public Coordinates(int var1) {
      if(var1 == -1) {
         this.plane = -1;
      } else {
         this.plane = var1 >> 28 & 3;
         this.worldX = var1 >> 14 & 16383;
         this.worldY = var1 & 16383;
      }

   }

   public Coordinates(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   public Coordinates(Coordinates var1) {
      this.plane = var1.plane;
      this.worldX = var1.worldX;
      this.worldY = var1.worldY;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-607724737"
   )
   public void method3824(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1959489594"
   )
   public int method3825() {
      return this.plane << 28 | this.worldX << 14 | this.worldY;
   }

   public Coordinates() {
      this.plane = -1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LCoordinates;I)Z",
      garbageValue = "1348130088"
   )
   boolean method3826(Coordinates var1) {
      return this.plane != var1.plane?false:(this.worldX != var1.worldX?false:this.worldY == var1.worldY);
   }

   public int hashCode() {
      return this.method3825();
   }

   public String toString() {
      return this.plane + "," + (this.worldX >> 6) + "," + (this.worldY >> 6) + "," + (this.worldX & 63) + "," + (this.worldY & 63);
   }

   public boolean equals(Object var1) {
      return var1 == this?true:(!(var1 instanceof Coordinates)?false:this.method3826((Coordinates)var1));
   }
}
