import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("co")
@Implements("Frame")
public class Frame {
   @ObfuscatedName("s")
   @Export("translator_x")
   int[] translator_x;
   @ObfuscatedName("j")
   int[] field1316;
   @ObfuscatedName("x")
   static int[] field1317 = new int[500];
   @ObfuscatedName("p")
   static int[] field1318 = new int[500];
   @ObfuscatedName("d")
   FrameMap field1319 = null;
   @ObfuscatedName("k")
   int field1320 = -1;
   @ObfuscatedName("q")
   static int[] field1321 = new int[500];
   @ObfuscatedName("g")
   static int[] field1322 = new int[500];
   @ObfuscatedName("o")
   @Export("translator_y")
   int[] translator_y;
   @ObfuscatedName("a")
   @Export("translator_z")
   int[] translator_z;
   @ObfuscatedName("c")
   boolean field1325 = false;

   Frame(byte[] var1, FrameMap var2) {
      this.field1319 = var2;
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
            if(this.field1319.field1469[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1319.field1469[var10] == 0) {
                     field1318[var7] = var10;
                     field1322[var7] = 0;
                     field1317[var7] = 0;
                     field1321[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1318[var7] = var8;
            short var11 = 0;
            if(this.field1319.field1469[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1322[var7] = var4.readShortSmart();
            } else {
               field1322[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1317[var7] = var4.readShortSmart();
            } else {
               field1317[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1321[var7] = var4.readShortSmart();
            } else {
               field1321[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1319.field1469[var8] == 5) {
               this.field1325 = true;
            }
         }
      }

      if(var4.offset != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1320 = var7;
         this.field1316 = new int[var7];
         this.translator_x = new int[var7];
         this.translator_y = new int[var7];
         this.translator_z = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1316[var8] = field1318[var8];
            this.translator_x[var8] = field1322[var8];
            this.translator_y[var8] = field1317[var8];
            this.translator_z[var8] = field1321[var8];
         }

      }
   }
}
