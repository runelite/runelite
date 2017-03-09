import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cb")
@Implements("Frame")
public class Frame {
   @ObfuscatedName("c")
   static int[] field1327 = new int[500];
   @ObfuscatedName("j")
   static int[] field1328 = new int[500];
   @ObfuscatedName("d")
   static int[] field1329 = new int[500];
   @ObfuscatedName("x")
   static int[] field1330 = new int[500];
   @ObfuscatedName("w")
   FrameMap field1331 = null;
   @ObfuscatedName("h")
   int field1332 = -1;
   @ObfuscatedName("u")
   int[] field1333;
   @ObfuscatedName("k")
   @Export("translator_x")
   int[] translator_x;
   @ObfuscatedName("g")
   @Export("translator_y")
   int[] translator_y;
   @ObfuscatedName("y")
   @Export("translator_z")
   int[] translator_z;
   @ObfuscatedName("e")
   boolean field1337 = false;

   Frame(byte[] var1, FrameMap var2) {
      this.field1331 = var2;
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
            if(this.field1331.field1478[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1331.field1478[var10] == 0) {
                     field1330[var7] = var10;
                     field1328[var7] = 0;
                     field1327[var7] = 0;
                     field1329[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1330[var7] = var8;
            short var11 = 0;
            if(this.field1331.field1478[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1328[var7] = var4.readShortSmart();
            } else {
               field1328[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1327[var7] = var4.readShortSmart();
            } else {
               field1327[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1329[var7] = var4.readShortSmart();
            } else {
               field1329[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1331.field1478[var8] == 5) {
               this.field1337 = true;
            }
         }
      }

      if(var4.offset != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1332 = var7;
         this.field1333 = new int[var7];
         this.translator_x = new int[var7];
         this.translator_y = new int[var7];
         this.translator_z = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1333[var8] = field1330[var8];
            this.translator_x[var8] = field1328[var8];
            this.translator_y[var8] = field1327[var8];
            this.translator_z[var8] = field1329[var8];
         }

      }
   }
}
