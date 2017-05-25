import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ee")
@Implements("Frame")
public class Frame {
   @ObfuscatedName("a")
   @Export("translator_z")
   int[] translator_z;
   @ObfuscatedName("h")
   static int[] field1875;
   @ObfuscatedName("u")
   static int[] field1876;
   @ObfuscatedName("q")
   static int[] field1877;
   @ObfuscatedName("g")
   FrameMap field1878;
   @ObfuscatedName("v")
   int field1879;
   @ObfuscatedName("t")
   int[] field1880;
   @ObfuscatedName("i")
   static int[] field1881;
   @ObfuscatedName("k")
   boolean field1882;
   @ObfuscatedName("l")
   @Export("translator_y")
   int[] translator_y;
   @ObfuscatedName("p")
   @Export("translator_x")
   int[] translator_x;

   Frame(byte[] var1, FrameMap var2) {
      this.field1878 = null;
      this.field1879 = -1;
      this.field1882 = false;
      this.field1878 = var2;
      Buffer var3 = new Buffer(var1);
      Buffer var4 = new Buffer(var1);
      var3.offset = 2;
      int var5 = var3.readUnsignedByte();
      int var6 = -1;
      int var7 = 0;
      var4.offset = var3.offset + var5;

      int var8;
      for(var8 = 0; var8 < var5; ++var8) {
         int var9 = var3.readUnsignedByte();
         if(var9 > 0) {
            if(this.field1878.field2035[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1878.field2035[var10] == 0) {
                     field1881[var7] = var10;
                     field1875[var7] = 0;
                     field1876[var7] = 0;
                     field1877[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1881[var7] = var8;
            short var11 = 0;
            if(this.field1878.field2035[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1875[var7] = var4.readShortSmart();
            } else {
               field1875[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1876[var7] = var4.readShortSmart();
            } else {
               field1876[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1877[var7] = var4.readShortSmart();
            } else {
               field1877[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1878.field2035[var8] == 5) {
               this.field1882 = true;
            }
         }
      }

      if(var4.offset != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1879 = var7;
         this.field1880 = new int[var7];
         this.translator_x = new int[var7];
         this.translator_y = new int[var7];
         this.translator_z = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1880[var8] = field1881[var8];
            this.translator_x[var8] = field1875[var8];
            this.translator_y[var8] = field1876[var8];
            this.translator_z[var8] = field1877[var8];
         }

      }
   }

   static {
      field1881 = new int[500];
      field1875 = new int[500];
      field1876 = new int[500];
      field1877 = new int[500];
   }
}
