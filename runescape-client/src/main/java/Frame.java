import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
@Implements("Frame")
public class Frame {
   @ObfuscatedName("w")
   static int[] field1882;
   @ObfuscatedName("s")
   static int[] field1876;
   @ObfuscatedName("q")
   static int[] field1877;
   @ObfuscatedName("o")
   static int[] field1879;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lej;"
   )
   @Export("skin")
   FrameMap skin;
   @ObfuscatedName("z")
   @Export("showing")
   boolean showing;
   @ObfuscatedName("v")
   int field1880;
   @ObfuscatedName("p")
   int[] field1881;
   @ObfuscatedName("e")
   @Export("translator_x")
   int[] translator_x;
   @ObfuscatedName("d")
   @Export("translator_y")
   int[] translator_y;
   @ObfuscatedName("x")
   @Export("translator_z")
   int[] translator_z;

   static {
      field1882 = new int[500];
      field1876 = new int[500];
      field1877 = new int[500];
      field1879 = new int[500];
   }

   @ObfuscatedSignature(
      signature = "([BLej;)V"
   )
   Frame(byte[] var1, FrameMap var2) {
      this.skin = null;
      this.field1880 = -1;
      this.showing = false;
      this.skin = var2;
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
            if(this.skin.types[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.skin.types[var10] == 0) {
                     field1882[var7] = var10;
                     field1876[var7] = 0;
                     field1877[var7] = 0;
                     field1879[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1882[var7] = var8;
            short var11 = 0;
            if(this.skin.types[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1876[var7] = var4.readShortSmart();
            } else {
               field1876[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1877[var7] = var4.readShortSmart();
            } else {
               field1877[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1879[var7] = var4.readShortSmart();
            } else {
               field1879[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.skin.types[var8] == 5) {
               this.showing = true;
            }
         }
      }

      if(var1.length != var4.offset) {
         throw new RuntimeException();
      } else {
         this.field1880 = var7;
         this.field1881 = new int[var7];
         this.translator_x = new int[var7];
         this.translator_y = new int[var7];
         this.translator_z = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1881[var8] = field1882[var8];
            this.translator_x[var8] = field1876[var8];
            this.translator_y[var8] = field1877[var8];
            this.translator_z[var8] = field1879[var8];
         }

      }
   }
}
