import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
@Implements("Coordinates")
public class Coordinates {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -712546783
   )
   static int field2778;
   @ObfuscatedName("ba")
   static String field2779;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -268789449
   )
   @Export("plane")
   public int plane;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2069086975
   )
   @Export("worldX")
   public int worldX;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1261419047
   )
   @Export("worldY")
   public int worldY;

   @ObfuscatedSignature(
      signature = "(Lik;)V"
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1178669035"
   )
   @Export("set")
   public void set(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-28"
   )
   @Export("bitpack")
   public int bitpack() {
      return this.plane << 28 | this.worldX << 14 | this.worldY;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lik;I)Z",
      garbageValue = "-1407514139"
   )
   boolean method4397(Coordinates var1) {
      return this.plane != var1.plane?false:(this.worldX != var1.worldX?false:this.worldY == var1.worldY);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/String;",
      garbageValue = "42"
   )
   String method4394(String var1) {
      return this.plane + var1 + (this.worldX >> 6) + var1 + (this.worldY >> 6) + var1 + (this.worldX & 63) + var1 + (this.worldY & 63);
   }

   public int hashCode() {
      return this.bitpack();
   }

   public String toString() {
      return this.method4394(",");
   }

   public boolean equals(Object var1) {
      return this == var1?true:(!(var1 instanceof Coordinates)?false:this.method4397((Coordinates)var1));
   }
}
