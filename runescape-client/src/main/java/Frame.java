import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ck")
@Implements("Frame")
public class Frame {
   @ObfuscatedName("h")
   int field1301 = -1;
   @ObfuscatedName("l")
   static int[] field1302 = new int[500];
   @ObfuscatedName("a")
   @Export("translator_y")
   int[] translator_y;
   @ObfuscatedName("t")
   static int[] field1304 = new int[500];
   @ObfuscatedName("k")
   FrameMap field1305 = null;
   @ObfuscatedName("i")
   static int[] field1306 = new int[500];
   @ObfuscatedName("n")
   int[] field1307;
   @ObfuscatedName("x")
   boolean field1308 = false;
   @ObfuscatedName("b")
   static int[] field1309 = new int[500];
   @ObfuscatedName("r")
   @Export("translator_z")
   int[] translator_z;
   @ObfuscatedName("f")
   @Export("translator_x")
   int[] translator_x;

   Frame(byte[] var1, FrameMap var2) {
      this.field1305 = var2;
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
            if(this.field1305.field1456[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1305.field1456[var10] == 0) {
                     field1309[var7] = var10;
                     field1302[var7] = 0;
                     field1306[var7] = 0;
                     field1304[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1309[var7] = var8;
            short var11 = 0;
            if(this.field1305.field1456[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1302[var7] = var4.readShortSmart();
            } else {
               field1302[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1306[var7] = var4.readShortSmart();
            } else {
               field1306[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1304[var7] = var4.readShortSmart();
            } else {
               field1304[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1305.field1456[var8] == 5) {
               this.field1308 = true;
            }
         }
      }

      if(var4.offset != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1301 = var7;
         this.field1307 = new int[var7];
         this.translator_x = new int[var7];
         this.translator_y = new int[var7];
         this.translator_z = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1307[var8] = field1309[var8];
            this.translator_x[var8] = field1302[var8];
            this.translator_y[var8] = field1306[var8];
            this.translator_z[var8] = field1304[var8];
         }

      }
   }
}
