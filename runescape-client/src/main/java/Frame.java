import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cy")
@Implements("Frame")
public class Frame {
   @ObfuscatedName("p")
   static int[] field1336 = new int[500];
   @ObfuscatedName("d")
   static int[] field1337 = new int[500];
   @ObfuscatedName("h")
   static int[] field1338 = new int[500];
   @ObfuscatedName("o")
   @Export("translator_z")
   int[] translator_z;
   @ObfuscatedName("r")
   int[] field1340;
   @ObfuscatedName("q")
   static int[] field1341 = new int[500];
   @ObfuscatedName("n")
   int field1342 = -1;
   @ObfuscatedName("j")
   FrameMap field1343 = null;
   @ObfuscatedName("i")
   @Export("translator_y")
   int[] translator_y;
   @ObfuscatedName("c")
   @Export("translator_x")
   int[] translator_x;
   @ObfuscatedName("m")
   boolean field1346 = false;

   Frame(byte[] var1, FrameMap var2) {
      this.field1343 = var2;
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
            if(this.field1343.field1484[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1343.field1484[var10] == 0) {
                     field1341[var7] = var10;
                     field1337[var7] = 0;
                     field1338[var7] = 0;
                     field1336[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1341[var7] = var8;
            short var11 = 0;
            if(this.field1343.field1484[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1337[var7] = var4.readShortSmart();
            } else {
               field1337[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1338[var7] = var4.readShortSmart();
            } else {
               field1338[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1336[var7] = var4.readShortSmart();
            } else {
               field1336[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1343.field1484[var8] == 5) {
               this.field1346 = true;
            }
         }
      }

      if(var4.offset != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1342 = var7;
         this.field1340 = new int[var7];
         this.translator_x = new int[var7];
         this.translator_y = new int[var7];
         this.translator_z = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1340[var8] = field1341[var8];
            this.translator_x[var8] = field1337[var8];
            this.translator_y[var8] = field1338[var8];
            this.translator_z[var8] = field1336[var8];
         }

      }
   }
}
