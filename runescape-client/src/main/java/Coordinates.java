import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
@Implements("Coordinates")
public class Coordinates {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -405594809
   )
   @Export("worldX")
   public int worldX;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1651555163
   )
   @Export("worldY")
   public int worldY;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1865577855
   )
   @Export("plane")
   public int plane;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(BI)C",
      garbageValue = "1802023354"
   )
   public static char method3989(byte var0) {
      int var1 = var0 & 255;
      if(var1 == 0) {
         throw new IllegalArgumentException("");
      } else {
         if(var1 >= 128 && var1 < 160) {
            char var2 = class266.field3658[var1 - 128];
            if(var2 == 0) {
               var2 = 63;
            }

            var1 = var2;
         }

         return (char)var1;
      }
   }

   public Coordinates() {
      this.plane = -1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1990922717"
   )
   public int method3991() {
      return this.plane << 28 | this.worldX << 14 | this.worldY;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-975800986"
   )
   public void method3992(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   public Coordinates(Coordinates var1) {
      this.plane = var1.plane;
      this.worldX = var1.worldX;
      this.worldY = var1.worldY;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1635445800"
   )
   public static boolean method3993() {
      ClassInfo var0 = (ClassInfo)class280.field3745.method3620();
      return var0 != null;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass212;B)Z",
      garbageValue = "100"
   )
   boolean method3994(Coordinates var1) {
      return var1.plane != this.plane?false:(this.worldX != var1.worldX?false:var1.worldY == this.worldY);
   }

   public int hashCode() {
      return this.method3991();
   }

   public String toString() {
      return this.plane + "," + (this.worldX >> 6) + "," + (this.worldY >> 6) + "," + (this.worldX & 63) + "," + (this.worldY & 63);
   }

   public boolean equals(Object var1) {
      return this == var1?true:(!(var1 instanceof Coordinates)?false:this.method3994((Coordinates)var1));
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

   public Coordinates(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }
}
