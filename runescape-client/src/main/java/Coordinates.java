import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("im")
@Implements("Coordinates")
public class Coordinates {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 222112077
   )
   public static int field2777;
   @ObfuscatedName("ke")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   static Widget field2775;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 73194951
   )
   @Export("plane")
   public int plane;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1500657727
   )
   @Export("worldX")
   public int worldX;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -425737425
   )
   @Export("worldY")
   public int worldY;

   @ObfuscatedSignature(
      signature = "(Lim;)V"
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

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "96"
   )
   @Export("set")
   public void set(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-65"
   )
   @Export("bitpack")
   public int bitpack() {
      return this.plane << 28 | this.worldX << 14 | this.worldY;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lim;I)Z",
      garbageValue = "5422244"
   )
   boolean method4388(Coordinates var1) {
      return this.plane != var1.plane?false:(this.worldX != var1.worldX?false:this.worldY == var1.worldY);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/String;",
      garbageValue = "-20"
   )
   String method4385(String var1) {
      return this.plane + var1 + (this.worldX >> 6) + var1 + (this.worldY >> 6) + var1 + (this.worldX & 63) + var1 + (this.worldY & 63);
   }

   public int hashCode() {
      return this.bitpack();
   }

   public String toString() {
      return this.method4385(",");
   }

   public boolean equals(Object var1) {
      return this == var1?true:(!(var1 instanceof Coordinates)?false:this.method4388((Coordinates)var1));
   }
}
