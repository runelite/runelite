import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cf")
@Implements("Frame")
public class Frame {
   @ObfuscatedName("r")
   static int[] field1316 = new int[500];
   @ObfuscatedName("y")
   static int[] field1317 = new int[500];
   @ObfuscatedName("o")
   static int[] field1318 = new int[500];
   @ObfuscatedName("k")
   static int[] field1319 = new int[500];
   @ObfuscatedName("w")
   FrameMap field1320 = null;
   @ObfuscatedName("j")
   int field1321 = -1;
   @ObfuscatedName("s")
   boolean field1322 = false;
   @ObfuscatedName("d")
   @Export("translator_x")
   int[] translator_x;
   @ObfuscatedName("n")
   @Export("translator_y")
   int[] translator_y;
   @ObfuscatedName("c")
   @Export("translator_z")
   int[] translator_z;
   @ObfuscatedName("q")
   int[] field1326;

   Frame(byte[] var1, FrameMap var2) {
      this.field1320 = var2;
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
            if(this.field1320.field1471[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1320.field1471[var10] == 0) {
                     field1319[var7] = var10;
                     field1317[var7] = 0;
                     field1318[var7] = 0;
                     field1316[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1319[var7] = var8;
            short var11 = 0;
            if(this.field1320.field1471[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1317[var7] = var4.readShortSmart();
            } else {
               field1317[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1318[var7] = var4.readShortSmart();
            } else {
               field1318[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1316[var7] = var4.readShortSmart();
            } else {
               field1316[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1320.field1471[var8] == 5) {
               this.field1322 = true;
            }
         }
      }

      if(var4.offset != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1321 = var7;
         this.field1326 = new int[var7];
         this.translator_x = new int[var7];
         this.translator_y = new int[var7];
         this.translator_z = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1326[var8] = field1319[var8];
            this.translator_x[var8] = field1317[var8];
            this.translator_y[var8] = field1318[var8];
            this.translator_z[var8] = field1316[var8];
         }

      }
   }
}
