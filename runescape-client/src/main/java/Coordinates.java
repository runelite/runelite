import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
@Implements("Coordinates")
public class Coordinates {
   @ObfuscatedName("di")
   static IndexData field2613;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -752992095
   )
   @Export("worldY")
   public int worldY;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 648222391
   )
   @Export("plane")
   public int plane;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1135890275
   )
   @Export("worldX")
   public int worldX;

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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1945732510"
   )
   public void method3915(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   public boolean equals(Object var1) {
      return var1 == this?true:(!(var1 instanceof Coordinates)?false:this.method3929((Coordinates)var1));
   }

   public int hashCode() {
      return this.method3918();
   }

   public String toString() {
      return this.plane + "," + (this.worldX >> 6) + "," + (this.worldY >> 6) + "," + (this.worldX & 63) + "," + (this.worldY & 63);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "73"
   )
   public int method3918() {
      return this.plane << 28 | this.worldX << 14 | this.worldY;
   }

   public Coordinates() {
      this.plane = -1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LCoordinates;I)Z",
      garbageValue = "-2137264492"
   )
   boolean method3929(Coordinates var1) {
      return this.plane != var1.plane?false:(this.worldX != var1.worldX?false:this.worldY == var1.worldY);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;B)V",
      garbageValue = "-24"
   )
   public static void method3934(IndexDataBase var0) {
      Varbit.field3380 = var0;
   }
}
