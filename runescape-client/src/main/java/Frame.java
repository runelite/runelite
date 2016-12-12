import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cz")
@Implements("Frame")
public class Frame {
   @ObfuscatedName("w")
   int[] field1318;
   @ObfuscatedName("e")
   static int[] field1319 = new int[500];
   @ObfuscatedName("f")
   static int[] field1320 = new int[500];
   @ObfuscatedName("q")
   int[] field1321;
   @ObfuscatedName("k")
   static int[] field1322 = new int[500];
   @ObfuscatedName("n")
   int field1323 = -1;
   @ObfuscatedName("a")
   int[] field1324;
   @ObfuscatedName("v")
   int[] field1325;
   @ObfuscatedName("i")
   static int[] field1326 = new int[500];
   @ObfuscatedName("g")
   FrameMap field1327 = null;
   @ObfuscatedName("h")
   boolean field1328 = false;

   Frame(byte[] var1, FrameMap var2) {
      this.field1327 = var2;
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
            if(this.field1327.field1468[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1327.field1468[var10] == 0) {
                     field1326[var7] = var10;
                     field1319[var7] = 0;
                     field1320[var7] = 0;
                     field1322[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1326[var7] = var8;
            short var11 = 0;
            if(this.field1327.field1468[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1319[var7] = var4.readShortSmart();
            } else {
               field1319[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1320[var7] = var4.readShortSmart();
            } else {
               field1320[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1322[var7] = var4.readShortSmart();
            } else {
               field1322[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1327.field1468[var8] == 5) {
               this.field1328 = true;
            }
         }
      }

      if(var4.offset != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1323 = var7;
         this.field1324 = new int[var7];
         this.field1321 = new int[var7];
         this.field1318 = new int[var7];
         this.field1325 = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1324[var8] = field1326[var8];
            this.field1321[var8] = field1319[var8];
            this.field1318[var8] = field1320[var8];
            this.field1325[var8] = field1322[var8];
         }

      }
   }
}
