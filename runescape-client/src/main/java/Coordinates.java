import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
@Implements("Coordinates")
public class Coordinates {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 175993377
   )
   @Export("plane")
   public int plane;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1606583697
   )
   @Export("worldY")
   public int worldY;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 274989271
   )
   @Export("worldX")
   public int worldX;

   public Coordinates() {
      this.plane = -1;
   }

   @ObfuscatedSignature(
      signature = "(Lhh;)V"
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2115820001"
   )
   public int method3941() {
      return this.plane << 28 | this.worldX << 14 | this.worldY;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "65"
   )
   public void method3940(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lhh;I)Z",
      garbageValue = "220106790"
   )
   boolean method3943(Coordinates var1) {
      return this.plane != var1.plane?false:(this.worldX != var1.worldX?false:this.worldY == var1.worldY);
   }

   public boolean equals(Object var1) {
      return this == var1?true:(!(var1 instanceof Coordinates)?false:this.method3943((Coordinates)var1));
   }

   public String toString() {
      return this.plane + "," + (this.worldX >> 6) + "," + (this.worldY >> 6) + "," + (this.worldX & 63) + "," + (this.worldY & 63);
   }

   public int hashCode() {
      return this.method3941();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lbm;I)V",
      garbageValue = "-881296087"
   )
   public static void method3942(ScriptEvent var0) {
      class40.method567(var0, 200000);
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2030047754"
   )
   static final void method3956(int var0) {
      if(var0 >= 0) {
         int var1 = Client.menuActionParams0[var0];
         int var2 = Client.menuActionParams1[var0];
         int var3 = Client.menuTypes[var0];
         int var4 = Client.menuIdentifiers[var0];
         String var5 = Client.menuOptions[var0];
         String var6 = Client.menuTargets[var0];
         class262.menuAction(var1, var2, var3, var4, var5, var6, MouseInput.field741, MouseInput.field742);
      }
   }
}
