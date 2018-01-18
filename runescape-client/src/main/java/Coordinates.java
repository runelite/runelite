import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
@Implements("Coordinates")
public class Coordinates {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 552661879
   )
   @Export("plane")
   public int plane;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1851677327
   )
   @Export("worldX")
   public int worldX;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2079623241
   )
   @Export("worldY")
   public int worldY;

   public Coordinates() {
      this.plane = -1;
   }

   @ObfuscatedSignature(
      signature = "(Lht;)V"
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-36"
   )
   @Export("set")
   public void set(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-587924306"
   )
   public int method4160() {
      return this.plane << 28 | this.worldX << 14 | this.worldY;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lht;I)Z",
      garbageValue = "-1272250157"
   )
   boolean method4149(Coordinates var1) {
      return this.plane != var1.plane?false:(this.worldX != var1.worldX?false:this.worldY == var1.worldY);
   }

   public String toString() {
      return this.plane + "," + (this.worldX >> 6) + "," + (this.worldY >> 6) + "," + (this.worldX & 63) + "," + (this.worldY & 63);
   }

   public boolean equals(Object var1) {
      return this == var1?true:(!(var1 instanceof Coordinates)?false:this.method4149((Coordinates)var1));
   }

   public int hashCode() {
      return this.method4160();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIB)Lbs;",
      garbageValue = "15"
   )
   static MessageNode method4165(int var0, int var1) {
      ChatLineBuffer var2 = (ChatLineBuffer)class96.chatLineMap.get(Integer.valueOf(var0));
      return var2.getMessage(var1);
   }
}
