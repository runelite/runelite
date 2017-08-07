import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
@Implements("Coordinates")
public class Coordinates {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   public static IndexDataBase field2586;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = 1726273927
   )
   public static int field2589;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1158484197
   )
   @Export("plane")
   public int plane;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 119846439
   )
   @Export("worldX")
   public int worldX;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 156372255
   )
   @Export("worldY")
   public int worldY;

   public Coordinates() {
      this.plane = -1;
   }

   @ObfuscatedSignature(
      signature = "(Lhq;)V"
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
      signature = "(B)I",
      garbageValue = "20"
   )
   public int method3935() {
      return this.plane << 28 | this.worldX << 14 | this.worldY;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIS)V",
      garbageValue = "26755"
   )
   public void method3934(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lhq;B)Z",
      garbageValue = "-113"
   )
   boolean method3933(Coordinates var1) {
      return this.plane != var1.plane?false:(this.worldX != var1.worldX?false:this.worldY == var1.worldY);
   }

   public boolean equals(Object var1) {
      return this == var1?true:(!(var1 instanceof Coordinates)?false:this.method3933((Coordinates)var1));
   }

   public String toString() {
      return this.plane + "," + (this.worldX >> 6) + "," + (this.worldY >> 6) + "," + (this.worldX & 63) + "," + (this.worldY & 63);
   }

   public int hashCode() {
      return this.method3935();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Liw;",
      garbageValue = "1834686607"
   )
   public static class252 method3948(int var0) {
      class252 var1 = (class252)class252.field3378.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class252.field3384.getConfigData(11, var0);
         var1 = new class252();
         if(var2 != null) {
            var1.method4448(new Buffer(var2));
         }

         var1.method4452();
         class252.field3378.put(var1, (long)var0);
         return var1;
      }
   }
}
