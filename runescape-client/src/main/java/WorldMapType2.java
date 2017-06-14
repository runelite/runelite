import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1980480097
   )
   int field518;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1436371401
   )
   int field519;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 936289571
   )
   int field520;
   @ObfuscatedName("fc")
   static byte[][] field521;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1687654503
   )
   int field522;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2099693185
   )
   int field523;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -794483129
   )
   int field526;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-126"
   )
   public boolean vmethod693(int var1, int var2, int var3) {
      return var1 >= this.field526 && var1 < this.field519 + this.field526?var2 >> 6 == this.field520 && var3 >> 6 == this.field523:false;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;B)V",
      garbageValue = "101"
   )
   public void vmethod692(WorldMapData var1) {
      if(var1.field460 > this.field522) {
         var1.field460 = this.field522;
      }

      if(var1.field468 < this.field522) {
         var1.field468 = this.field522;
      }

      if(var1.field465 > this.field518) {
         var1.field465 = this.field518;
      }

      if(var1.field466 < this.field518) {
         var1.field466 = this.field518;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-2062162233"
   )
   public void vmethod697(Buffer var1) {
      this.field526 = var1.readUnsignedByte();
      this.field519 = var1.readUnsignedByte();
      this.field520 = var1.readUnsignedShort();
      this.field523 = var1.readUnsignedShort();
      this.field522 = var1.readUnsignedShort();
      this.field518 = var1.readUnsignedShort();
      this.method515();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-203277119"
   )
   public boolean vmethod713(int var1, int var2) {
      return var1 >> 6 == this.field522 && this.field518 == var2 >> 6;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIB)[I",
      garbageValue = "-1"
   )
   public int[] vmethod695(int var1, int var2, int var3) {
      if(!this.vmethod693(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{var2 + (this.field522 * 64 - this.field520 * 64), this.field518 * 64 - this.field523 * 64 + var3};
         return var4;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)LCoordinates;",
      garbageValue = "1721490041"
   )
   public Coordinates vmethod696(int var1, int var2) {
      if(!this.vmethod713(var1, var2)) {
         return null;
      } else {
         int var3 = var1 + (this.field520 * 64 - this.field522 * 64);
         int var4 = var2 + (this.field523 * 64 - this.field518 * 64);
         return new Coordinates(this.field526, var3, var4);
      }
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "1004639753"
   )
   static final boolean method512(Widget var0) {
      if(var0.tableActions == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.tableActions.length; ++var1) {
            int var2 = class261.method4763(var0, var1);
            int var3 = var0.field2766[var1];
            if(var0.tableActions[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var2 != var3) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1822706904"
   )
   void method515() {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "1132121946"
   )
   public static String method528(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class266.field3673[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }
}
