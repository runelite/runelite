import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ey")
@Implements("Frame")
public class Frame {
   @ObfuscatedName("t")
   static int[] field1886;
   @ObfuscatedName("p")
   static int[] field1887;
   @ObfuscatedName("f")
   @Export("translator_y")
   int[] translator_y;
   @ObfuscatedName("e")
   static int[] field1889;
   @ObfuscatedName("w")
   FrameMap field1890;
   @ObfuscatedName("z")
   int field1891;
   @ObfuscatedName("i")
   @Export("translator_x")
   int[] translator_x;
   @ObfuscatedName("m")
   static int[] field1893;
   @ObfuscatedName("j")
   int[] field1894;
   @ObfuscatedName("c")
   @Export("translator_z")
   int[] translator_z;
   @ObfuscatedName("o")
   @Export("showing")
   boolean showing;

   Frame(byte[] var1, FrameMap var2) {
      this.field1890 = null;
      this.field1891 = -1;
      this.showing = false;
      this.field1890 = var2;
      Buffer var3 = new Buffer(var1);
      Buffer var4 = new Buffer(var1);
      var3.offset = 2;
      int var5 = var3.readUnsignedByte();
      int var6 = -1;
      int var7 = 0;
      var4.offset = var5 + var3.offset;

      int var8;
      for(var8 = 0; var8 < var5; ++var8) {
         int var9 = var3.readUnsignedByte();
         if(var9 > 0) {
            if(this.field1890.field2050[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1890.field2050[var10] == 0) {
                     field1887[var7] = var10;
                     field1893[var7] = 0;
                     field1889[var7] = 0;
                     field1886[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1887[var7] = var8;
            short var11 = 0;
            if(this.field1890.field2050[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1893[var7] = var4.readShortSmart();
            } else {
               field1893[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1889[var7] = var4.readShortSmart();
            } else {
               field1889[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1886[var7] = var4.readShortSmart();
            } else {
               field1886[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1890.field2050[var8] == 5) {
               this.showing = true;
            }
         }
      }

      if(var1.length != var4.offset) {
         throw new RuntimeException();
      } else {
         this.field1891 = var7;
         this.field1894 = new int[var7];
         this.translator_x = new int[var7];
         this.translator_y = new int[var7];
         this.translator_z = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1894[var8] = field1887[var8];
            this.translator_x[var8] = field1893[var8];
            this.translator_y[var8] = field1889[var8];
            this.translator_z[var8] = field1886[var8];
         }

      }
   }

   static {
      field1887 = new int[500];
      field1893 = new int[500];
      field1889 = new int[500];
      field1886 = new int[500];
   }
}
