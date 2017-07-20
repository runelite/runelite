import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
@Implements("Coordinates")
public class Coordinates {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 700402515
   )
   @Export("plane")
   public int plane;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 71740711
   )
   @Export("worldY")
   public int worldY;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1022398379
   )
   @Export("worldX")
   public int worldX;

   public Coordinates() {
      this.plane = -1;
   }

   @ObfuscatedSignature(
      signature = "(Lhs;)V"
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "113785647"
   )
   public int method3866() {
      return this.plane << 28 | this.worldX << 14 | this.worldY;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1831541056"
   )
   public void method3874(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lhs;I)Z",
      garbageValue = "-591313480"
   )
   boolean method3863(Coordinates var1) {
      return this.plane != var1.plane?false:(this.worldX != var1.worldX?false:this.worldY == var1.worldY);
   }

   public String toString() {
      return this.plane + "," + (this.worldX >> 6) + "," + (this.worldY >> 6) + "," + (this.worldX & 63) + "," + (this.worldY & 63);
   }

   public boolean equals(Object var1) {
      return this == var1?true:(!(var1 instanceof Coordinates)?false:this.method3863((Coordinates)var1));
   }

   public int hashCode() {
      return this.method3866();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2147409620"
   )
   public static boolean method3860() {
      return class203.field2471 != 0?true:class203.field2470.method3649();
   }
}
