import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
@Implements("Animation")
public class Animation {
   @ObfuscatedName("m")
   static int[] field26;
   @ObfuscatedName("f")
   static int[] field27;
   @ObfuscatedName("q")
   static int[] field28;
   @ObfuscatedName("w")
   static int[] field29;
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
      for (var8 = 0; var8 < var5; ++var8) {
         int var9 = var3.readUnsignedByte();
         if (var9 > 0) {
            if (this.skeleton.transformTypes[var8] != 0) {
               for (int var10 = var8 - 1; var10 > var6; --var10) {
                  if (this.skeleton.transformTypes[var10] == 0) {
                     field26[var7] = var10;
                     field27[var7] = 0;
                     field28[var7] = 0;
                     field29[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field26[var7] = var8;
            short var11 = 0;
            if (this.skeleton.transformTypes[var8] == 3) {
               var11 = 128;
            }

            if ((var9 & 1) != 0) {
               field27[var7] = var4.method47();
            } else {
               field27[var7] = var11;
            }

            if ((var9 & 2) != 0) {
               field28[var7] = var4.method47();
            } else {
               field28[var7] = var11;
            }

            if ((var9 & 4) != 0) {
               field29[var7] = var4.method47();
            } else {
               field29[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if (this.skeleton.transformTypes[var8] == 5) {
               this.hasAlphaTransform = true;
            }
         }
      }

      if (var1.length != var4.index) {
         throw new RuntimeException();
      } else {
         this.transformCount = var7;
         this.transformSkeletonLabels = new int[var7];
         this.transformXs = new int[var7];
         this.transformYs = new int[var7];
         this.transformZs = new int[var7];

         for (var8 = 0; var8 < var7; ++var8) {
            this.transformSkeletonLabels[var8] = field26[var8];
            this.transformXs[var8] = field27[var8];
            this.transformYs[var8] = field28[var8];
            this.transformZs[var8] = field29[var8];
         }

      }
   }

   static {
      field26 = new int[500];
      field27 = new int[500];
      field28 = new int[500];
      field29 = new int[500];
   }
}
