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
      signature = "[Lcd;"
   )
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1307901353
   )
   @Export("plane")
   public int plane;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 699218057
   )
   @Export("worldX")
   public int worldX;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 992215149
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1514742160"
   )
   public void method4092(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-86"
   )
   public int method4093() {
      return this.plane << 28 | this.worldX << 14 | this.worldY;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lhq;I)Z",
      garbageValue = "226148438"
   )
   boolean method4094(Coordinates var1) {
      return this.plane != var1.plane?false:(this.worldX != var1.worldX?false:this.worldY == var1.worldY);
   }

   public String toString() {
      return this.plane + "," + (this.worldX >> 6) + "," + (this.worldY >> 6) + "," + (this.worldX & 63) + "," + (this.worldY & 63);
   }

   public int hashCode() {
      return this.method4093();
   }

   public boolean equals(Object var1) {
      return this == var1?true:(!(var1 instanceof Coordinates)?false:this.method4094((Coordinates)var1));
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Lib;",
      garbageValue = "1254175424"
   )
   public static Varbit method4096(int var0) {
      Varbit var1 = (Varbit)Varbit.varbits.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class12.varbit_ref.getConfigData(14, var0);
         var1 = new Varbit();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Varbit.varbits.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "(Lbv;I)V",
      garbageValue = "-1786022024"
   )
   static final void method4109(PendingSpawn var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.type == 0) {
         var1 = class56.region.method2814(var0.level, var0.x, var0.y);
      }

      if(var0.type == 1) {
         var1 = class56.region.method2808(var0.level, var0.x, var0.y);
      }

      if(var0.type == 2) {
         var1 = class56.region.method2851(var0.level, var0.x, var0.y);
      }

      if(var0.type == 3) {
         var1 = class56.region.method2942(var0.level, var0.x, var0.y);
      }

      if(var1 != 0) {
         int var5 = class56.region.method2912(var0.level, var0.x, var0.y, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field1135 = var2;
      var0.field1134 = var3;
      var0.field1136 = var4;
   }
}
