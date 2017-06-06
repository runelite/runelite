import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("en")
@Implements("Frame")
public class Frame {
   @ObfuscatedName("i")
   static int[] field1903;
   @ObfuscatedName("c")
   static int[] field1904;
   @ObfuscatedName("e")
   static int[] field1905;
   @ObfuscatedName("y")
   int field1906;
   @ObfuscatedName("b")
   FrameMap field1907;
   @ObfuscatedName("a")
   boolean field1908;
   @ObfuscatedName("h")
   int[] field1909;
   @ObfuscatedName("x")
   @Export("translator_x")
   int[] translator_x;
   @ObfuscatedName("f")
   @Export("translator_y")
   int[] translator_y;
   @ObfuscatedName("n")
   @Export("translator_z")
   int[] translator_z;
   @ObfuscatedName("v")
   static int[] field1913;

   Frame(byte[] var1, FrameMap var2) {
      this.field1907 = null;
      this.field1906 = -1;
      this.field1908 = false;
      this.field1907 = var2;
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
            if(this.field1907.field2069[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1907.field2069[var10] == 0) {
                     field1903[var7] = var10;
                     field1904[var7] = 0;
                     field1905[var7] = 0;
                     field1913[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1903[var7] = var8;
            short var11 = 0;
            if(this.field1907.field2069[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1904[var7] = var4.readShortSmart();
            } else {
               field1904[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1905[var7] = var4.readShortSmart();
            } else {
               field1905[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1913[var7] = var4.readShortSmart();
            } else {
               field1913[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1907.field2069[var8] == 5) {
               this.field1908 = true;
            }
         }
      }

      if(var4.offset != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1906 = var7;
         this.field1909 = new int[var7];
         this.translator_x = new int[var7];
         this.translator_y = new int[var7];
         this.translator_z = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1909[var8] = field1903[var8];
            this.translator_x[var8] = field1904[var8];
            this.translator_y[var8] = field1905[var8];
            this.translator_z[var8] = field1913[var8];
         }

      }
   }

   static {
      field1903 = new int[500];
      field1904 = new int[500];
      field1905 = new int[500];
      field1913 = new int[500];
   }
}
