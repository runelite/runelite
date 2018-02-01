import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
@Implements("Coordinates")
public class Coordinates {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 2110922503
   )
   @Export("plane")
   public int plane;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1945152347
   )
   @Export("worldX")
   public int worldX;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1227624609
   )
   @Export("worldY")
   public int worldY;

   public Coordinates() {
      this.plane = -1;
   }

   @ObfuscatedSignature(
      signature = "(Lhn;)V"
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "86"
   )
   @Export("set")
   public void set(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1252131420"
   )
   public int method4196() {
      return this.plane << 28 | this.worldX << 14 | this.worldY;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lhn;S)Z",
      garbageValue = "800"
   )
   boolean method4188(Coordinates var1) {
      return this.plane != var1.plane?false:(this.worldX != var1.worldX?false:this.worldY == var1.worldY);
   }

   public String toString() {
      return this.plane + "," + (this.worldX >> 6) + "," + (this.worldY >> 6) + "," + (this.worldX & 63) + "," + (this.worldY & 63);
   }

   public int hashCode() {
      return this.method4196();
   }

   public boolean equals(Object var1) {
      return this == var1?true:(!(var1 instanceof Coordinates)?false:this.method4188((Coordinates)var1));
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1207460731"
   )
   @Export("decodeSprite")
   static void decodeSprite(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class310.field3894 = var1.readUnsignedShort();
      class310.field3892 = new int[class310.field3894];
      class310.offsetsY = new int[class310.field3894];
      class310.field3895 = new int[class310.field3894];
      class310.field3896 = new int[class310.field3894];
      class160.spritePixels = new byte[class310.field3894][];
      var1.offset = var0.length - 7 - class310.field3894 * 8;
      class310.field3891 = var1.readUnsignedShort();
      class310.field3898 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class310.field3894; ++var3) {
         class310.field3892[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class310.field3894; ++var3) {
         class310.offsetsY[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class310.field3894; ++var3) {
         class310.field3895[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class310.field3894; ++var3) {
         class310.field3896[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class310.field3894 * 8 - (var2 - 1) * 3;
      class310.field3897 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class310.field3897[var3] = var1.read24BitInt();
         if(class310.field3897[var3] == 0) {
            class310.field3897[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class310.field3894; ++var3) {
         int var4 = class310.field3895[var3];
         int var5 = class310.field3896[var3];
         int var6 = var5 * var4;
         byte[] var7 = new byte[var6];
         class160.spritePixels[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var10 * var4] = var1.readByte();
               }
            }
         }
      }

   }
}
