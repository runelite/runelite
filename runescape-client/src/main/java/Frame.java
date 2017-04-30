import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cm")
@Implements("Frame")
public class Frame {
   @ObfuscatedName("c")
   static int[] field1305;
   @ObfuscatedName("q")
   static int[] field1306;
   @ObfuscatedName("n")
   static int[] field1307;
   @ObfuscatedName("z")
   @Export("translator_x")
   int[] translator_x;
   @ObfuscatedName("t")
   FrameMap field1309;
   @ObfuscatedName("p")
   int field1310;
   @ObfuscatedName("u")
   int[] field1311;
   @ObfuscatedName("d")
   static int[] field1312;
   @ObfuscatedName("l")
   @Export("translator_y")
   int[] translator_y;
   @ObfuscatedName("v")
   @Export("translator_z")
   int[] translator_z;
   @ObfuscatedName("g")
   boolean field1315;

   Frame(byte[] var1, FrameMap var2) {
      this.field1309 = null;
      this.field1310 = -1;
      this.field1315 = false;
      this.field1309 = var2;
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
            if(this.field1309.field1456[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1309.field1456[var10] == 0) {
                     field1312[var7] = var10;
                     field1305[var7] = 0;
                     field1307[var7] = 0;
                     field1306[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1312[var7] = var8;
            short var11 = 0;
            if(this.field1309.field1456[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1305[var7] = var4.readShortSmart();
            } else {
               field1305[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1307[var7] = var4.readShortSmart();
            } else {
               field1307[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1306[var7] = var4.readShortSmart();
            } else {
               field1306[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1309.field1456[var8] == 5) {
               this.field1315 = true;
            }
         }
      }

      if(var4.offset != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1310 = var7;
         this.field1311 = new int[var7];
         this.translator_x = new int[var7];
         this.translator_y = new int[var7];
         this.translator_z = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1311[var8] = field1312[var8];
            this.translator_x[var8] = field1305[var8];
            this.translator_y[var8] = field1307[var8];
            this.translator_z[var8] = field1306[var8];
         }

      }
   }

   static {
      field1312 = new int[500];
      field1305 = new int[500];
      field1307 = new int[500];
      field1306 = new int[500];
   }
}
