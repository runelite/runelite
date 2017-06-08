import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("em")
@Implements("Frame")
public class Frame {
   @ObfuscatedName("z")
   @Export("translator_x")
   int[] translator_x;
   @ObfuscatedName("p")
   static int[] field1897;
   @ObfuscatedName("i")
   static int[] field1898;
   @ObfuscatedName("g")
   @Export("translator_z")
   int[] translator_z;
   @ObfuscatedName("f")
   FrameMap field1900;
   @ObfuscatedName("m")
   int field1901;
   @ObfuscatedName("c")
   int[] field1902;
   @ObfuscatedName("h")
   @Export("translator_y")
   int[] translator_y;
   @ObfuscatedName("j")
   static int[] field1904;
   @ObfuscatedName("e")
   boolean field1905;
   @ObfuscatedName("n")
   static int[] field1906;

   static {
      field1906 = new int[500];
      field1897 = new int[500];
      field1898 = new int[500];
      field1904 = new int[500];
   }

   Frame(byte[] var1, FrameMap var2) {
      this.field1900 = null;
      this.field1901 = -1;
      this.field1905 = false;
      this.field1900 = var2;
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
            if(this.field1900.field2055[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1900.field2055[var10] == 0) {
                     field1906[var7] = var10;
                     field1897[var7] = 0;
                     field1898[var7] = 0;
                     field1904[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1906[var7] = var8;
            short var11 = 0;
            if(this.field1900.field2055[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1897[var7] = var4.readShortSmart();
            } else {
               field1897[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1898[var7] = var4.readShortSmart();
            } else {
               field1898[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1904[var7] = var4.readShortSmart();
            } else {
               field1904[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1900.field2055[var8] == 5) {
               this.field1905 = true;
            }
         }
      }

      if(var4.offset != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1901 = var7;
         this.field1902 = new int[var7];
         this.translator_x = new int[var7];
         this.translator_y = new int[var7];
         this.translator_z = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1902[var8] = field1906[var8];
            this.translator_x[var8] = field1897[var8];
            this.translator_y[var8] = field1898[var8];
            this.translator_z[var8] = field1904[var8];
         }

      }
   }
}
