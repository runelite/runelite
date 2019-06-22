import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
@Implements("Animation")
public class Animation {
   @ObfuscatedName("m")
   @Export("__dz_m")
   static int[] __dz_m;
   @ObfuscatedName("f")
   @Export("__dz_f")
   static int[] __dz_f;
   @ObfuscatedName("q")
   @Export("__dz_q")
   static int[] __dz_q;
   @ObfuscatedName("w")
   @Export("__dz_w")
   static int[] __dz_w;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lek;"
   )
   @Export("skeleton")
   Skeleton skeleton;
   @ObfuscatedName("u")
   @Export("transformCount")
   int transformCount;
   @ObfuscatedName("g")
   @Export("transformSkeletonLabels")
   int[] transformSkeletonLabels;
   @ObfuscatedName("l")
   @Export("transformXs")
   int[] transformXs;
   @ObfuscatedName("e")
   @Export("transformYs")
   int[] transformYs;
   @ObfuscatedName("x")
   @Export("transformZs")
   int[] transformZs;
   @ObfuscatedName("d")
   @Export("hasAlphaTransform")
   boolean hasAlphaTransform;

   @ObfuscatedSignature(
      signature = "([BLek;)V"
   )
   Animation(byte[] var1, Skeleton var2) {
      this.skeleton = null;
      this.transformCount = -1;
      this.hasAlphaTransform = false;
      this.skeleton = var2;
      Buffer var3 = new Buffer(var1);
      Buffer var4 = new Buffer(var1);
      var3.index = 2;
      int var5 = var3.readUnsignedByte();
      int var6 = -1;
      int var7 = 0;
      var4.index = var5 + var3.index;

      int var8;
      for(var8 = 0; var8 < var5; ++var8) {
         int var9 = var3.readUnsignedByte();
         if(var9 > 0) {
            if(this.skeleton.transformTypes[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.skeleton.transformTypes[var10] == 0) {
                     __dz_m[var7] = var10;
                     __dz_f[var7] = 0;
                     __dz_q[var7] = 0;
                     __dz_w[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            __dz_m[var7] = var8;
            short var11 = 0;
            if(this.skeleton.transformTypes[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               __dz_f[var7] = var4.__ab_306();
            } else {
               __dz_f[var7] = var11;
            }

            if((var9 & 2) != 0) {
               __dz_q[var7] = var4.__ab_306();
            } else {
               __dz_q[var7] = var11;
            }

            if((var9 & 4) != 0) {
               __dz_w[var7] = var4.__ab_306();
            } else {
               __dz_w[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.skeleton.transformTypes[var8] == 5) {
               this.hasAlphaTransform = true;
            }
         }
      }

      if(var1.length != var4.index) {
         throw new RuntimeException();
      } else {
         this.transformCount = var7;
         this.transformSkeletonLabels = new int[var7];
         this.transformXs = new int[var7];
         this.transformYs = new int[var7];
         this.transformZs = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.transformSkeletonLabels[var8] = __dz_m[var8];
            this.transformXs[var8] = __dz_f[var8];
            this.transformYs[var8] = __dz_q[var8];
            this.transformZs[var8] = __dz_w[var8];
         }

      }
   }

   static {
      __dz_m = new int[500];
      __dz_f = new int[500];
      __dz_q = new int[500];
      __dz_w = new int[500];
   }
}
