import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
@Implements("Coordinates")
public class Coordinates {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1286853209
   )
   @Export("plane")
   public int plane;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1375922379
   )
   @Export("worldX")
   public int worldX;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1205716517
   )
   @Export("worldY")
   public int worldY;

   @ObfuscatedSignature(
      signature = "(Lio;)V"
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-539305618"
   )
   @Export("set")
   public void set(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-389125420"
   )
   @Export("bitpack")
   public int bitpack() {
      return this.plane << 28 | this.worldX << 14 | this.worldY;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lio;B)Z",
      garbageValue = "99"
   )
   boolean method4481(Coordinates var1) {
      return this.plane != var1.plane?false:(this.worldX != var1.worldX?false:this.worldY == var1.worldY);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1109594590"
   )
   String method4475(String var1) {
      return this.plane + var1 + (this.worldX >> 6) + var1 + (this.worldY >> 6) + var1 + (this.worldX & 63) + var1 + (this.worldY & 63);
   }

   public boolean equals(Object var1) {
      return this == var1?true:(!(var1 instanceof Coordinates)?false:this.method4481((Coordinates)var1));
   }

   public String toString() {
      return this.method4475(",");
   }

   public int hashCode() {
      return this.bitpack();
   }

   public String aac() {
      return this.method4475(",");
   }

   public String aad() {
      return this.method4475(",");
   }
}
