import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
@Implements("Coordinates")
public class Coordinates {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1834581919
   )
   @Export("worldY")
   public int worldY;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1118499867
   )
   @Export("plane")
   public int plane;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 62950583
   )
   @Export("worldX")
   public int worldX;

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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1090703109"
   )
   public void method3954(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "443936672"
   )
   public int method3955() {
      return this.plane << 28 | this.worldX << 14 | this.worldY;
   }

   public Coordinates() {
      this.plane = -1;
   }

   public int hashCode() {
      return this.method3955();
   }

   public String toString() {
      return this.plane + "," + (this.worldX >> 6) + "," + (this.worldY >> 6) + "," + (this.worldX & 63) + "," + (this.worldY & 63);
   }

   public boolean equals(Object var1) {
      return this == var1?true:(!(var1 instanceof Coordinates)?false:this.method3959((Coordinates)var1));
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LCoordinates;I)Z",
      garbageValue = "-1613812781"
   )
   boolean method3959(Coordinates var1) {
      return var1.plane != this.plane?false:(this.worldX != var1.worldX?false:var1.worldY == this.worldY);
   }

   public Coordinates(Coordinates var1) {
      this.plane = var1.plane;
      this.worldX = var1.worldX;
      this.worldY = var1.worldY;
   }
}
