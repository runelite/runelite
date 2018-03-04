import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
@Implements("Coordinates")
public class Coordinates {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 797740343
   )
   @Export("plane")
   public int plane;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 6974957
   )
   @Export("worldX")
   public int worldX;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 549331175
   )
   @Export("worldY")
   public int worldY;

   @ObfuscatedSignature(
      signature = "(Lic;)V"
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

   public Coordinates() {
      this.plane = -1;
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1977624773"
   )
   @Export("set")
   public void set(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-825000231"
   )
   @Export("bitpack")
   public int bitpack() {
      return this.plane << 28 | this.worldX << 14 | this.worldY;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lic;B)Z",
      garbageValue = "-24"
   )
   boolean method4486(Coordinates var1) {
      return this.plane != var1.plane?false:(this.worldX != var1.worldX?false:this.worldY == var1.worldY);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1507465122"
   )
   String method4490(String var1) {
      return this.plane + var1 + (this.worldX >> 6) + var1 + (this.worldY >> 6) + var1 + (this.worldX & 63) + var1 + (this.worldY & 63);
   }

   public int hashCode() {
      return this.bitpack();
   }

   public boolean equals(Object var1) {
      return this == var1?true:(!(var1 instanceof Coordinates)?false:this.method4486((Coordinates)var1));
   }

   public String toString() {
      return this.method4490(",");
   }
}
