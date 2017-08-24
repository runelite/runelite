import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
@Implements("Coordinates")
public class Coordinates {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   public static Track1 field2620;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   @Export("widgetIndex")
   public static IndexDataBase widgetIndex;
   @ObfuscatedName("ag")
   static int[] field2615;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 647341917
   )
   @Export("plane")
   public int plane;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1607710799
   )
   @Export("worldX")
   public int worldX;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1052165761
   )
   @Export("worldY")
   public int worldY;

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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-596399843"
   )
   public int method3970() {
      return this.plane << 28 | this.worldX << 14 | this.worldY;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1981440891"
   )
   public void method3972(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lhs;B)Z",
      garbageValue = "52"
   )
   boolean method3975(Coordinates var1) {
      return this.plane != var1.plane?false:(this.worldX != var1.worldX?false:this.worldY == var1.worldY);
   }

   public String toString() {
      return this.plane + "," + (this.worldX >> 6) + "," + (this.worldY >> 6) + "," + (this.worldX & 63) + "," + (this.worldY & 63);
   }

   public boolean equals(Object var1) {
      return this == var1?true:(!(var1 instanceof Coordinates)?false:this.method3975((Coordinates)var1));
   }

   public int hashCode() {
      return this.method3970();
   }

   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "(Lhx;B)I",
      garbageValue = "9"
   )
   @Export("getWidgetConfig")
   static int getWidgetConfig(Widget var0) {
      IntegerNode var1 = (IntegerNode)Client.widgetFlags.get(((long)var0.id << 32) + (long)var0.index);
      return var1 != null?var1.value:var0.config;
   }
}
