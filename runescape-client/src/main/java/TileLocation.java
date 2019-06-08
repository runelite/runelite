import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
@Implements("TileLocation")
public class TileLocation {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 503621925
   )
   @Export("plane")
   public int plane;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1225620013
   )
   @Export("x")
   public int x;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 154740833
   )
   @Export("y")
   public int y;

   @ObfuscatedSignature(
      signature = "(Lhu;)V"
   )
   public TileLocation(TileLocation var1) {
      this.plane = var1.plane;
      this.x = var1.x;
      this.y = var1.y;
   }

   public TileLocation(int var1, int var2, int var3) {
      this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   public TileLocation(int var1) {
      if(var1 == -1) {
         this.plane = -1;
      } else {
         this.plane = var1 >> 28 & 3;
         this.x = var1 >> 14 & 16383;
         this.y = var1 & 16383;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1645833361"
   )
   @Export("packed")
   public int packed() {
      return this.plane << 28 | this.x << 14 | this.y;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lhu;B)Z",
      garbageValue = "-1"
   )
   @Export("equals0")
   boolean equals0(TileLocation var1) {
      return this.plane != var1.plane?false:(this.x != var1.x?false:this.y == var1.y);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "997364398"
   )
   @Export("toString0")
   String toString0(String var1) {
      return this.plane + var1 + (this.x >> 6) + var1 + (this.y >> 6) + var1 + (this.x & 63) + var1 + (this.y & 63);
   }

   @Export("__equals_382")
   @ObfuscatedName("equals")
   public boolean __equals_382(Object var1) {
      return this == var1?true:(!(var1 instanceof TileLocation)?false:this.equals0((TileLocation)var1));
   }

   @Export("__hashCode_383")
   @ObfuscatedName("hashCode")
   public int __hashCode_383() {
      return this.packed();
   }

   @Export("__toString_384")
   @ObfuscatedName("toString")
   public String __toString_384() {
      return this.toString0(",");
   }
}
