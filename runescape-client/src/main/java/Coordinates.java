import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
@Implements("Coordinates")
public class Coordinates {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -666198645
   )
   @Export("plane")
   public int plane;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1400042277
   )
   @Export("worldX")
   public int worldX;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -600094391
   )
   @Export("worldY")
   public int worldY;

   public Coordinates() {
      this.plane = -1;
   }

   @ObfuscatedSignature(
      signature = "(Lhd;)V"
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1386944416"
   )
   public int method3915() {
      return this.plane << 28 | this.worldX << 14 | this.worldY;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1193641631"
   )
   public void method3928(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lhd;B)Z",
      garbageValue = "-6"
   )
   boolean method3917(Coordinates var1) {
      return this.plane != var1.plane?false:(this.worldX != var1.worldX?false:this.worldY == var1.worldY);
   }

   public boolean equals(Object var1) {
      return this == var1?true:(!(var1 instanceof Coordinates)?false:this.method3917((Coordinates)var1));
   }

   public int hashCode() {
      return this.method3915();
   }

   public String toString() {
      return this.plane + "," + (this.worldX >> 6) + "," + (this.worldY >> 6) + "," + (this.worldX & 63) + "," + (this.worldY & 63);
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "24"
   )
   static final boolean method3932() {
      return Client.menuOptionCount <= 0?false:Client.field1054 && KeyFocusListener.field626[81] && Client.field940 != -1;
   }
}
