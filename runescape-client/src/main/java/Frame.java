import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cg")
@Implements("Frame")
public class Frame {
   @ObfuscatedName("d")
   static int[] field1309 = new int[500];
   @ObfuscatedName("c")
   int[] field1310;
   @ObfuscatedName("m")
   static int[] field1311 = new int[500];
   @ObfuscatedName("h")
   static int[] field1312 = new int[500];
   @ObfuscatedName("n")
   static int[] field1313 = new int[500];
   @ObfuscatedName("r")
   int field1314 = -1;
   @ObfuscatedName("w")
   FrameMap field1315 = null;
   @ObfuscatedName("p")
   int[] field1316;
   @ObfuscatedName("g")
   int[] field1317;
   @ObfuscatedName("z")
   int[] field1318;
   @ObfuscatedName("q")
   boolean field1319 = false;

   Frame(byte[] var1, FrameMap var2) {
      this.field1315 = var2;
      Buffer var3 = new Buffer(var1);
      Buffer var4 = new Buffer(var1);
      var3.offset = 2;
      int var5 = var3.method3033();
      int var6 = -1;
      int var7 = 0;
      var4.offset = var3.offset + var5;

      int var8;
      for(var8 = 0; var8 < var5; ++var8) {
         int var9 = var3.method3033();
         if(var9 > 0) {
            if(this.field1315.field1467[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1315.field1467[var10] == 0) {
                     field1313[var7] = var10;
                     field1309[var7] = 0;
                     field1311[var7] = 0;
                     field1312[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1313[var7] = var8;
            short var11 = 0;
            if(this.field1315.field1467[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1309[var7] = var4.method3002();
            } else {
               field1309[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1311[var7] = var4.method3002();
            } else {
               field1311[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1312[var7] = var4.method3002();
            } else {
               field1312[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1315.field1467[var8] == 5) {
               this.field1319 = true;
            }
         }
      }

      if(var4.offset != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1314 = var7;
         this.field1310 = new int[var7];
         this.field1316 = new int[var7];
         this.field1317 = new int[var7];
         this.field1318 = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1310[var8] = field1313[var8];
            this.field1316[var8] = field1309[var8];
            this.field1317[var8] = field1311[var8];
            this.field1318[var8] = field1312[var8];
         }

      }
   }
}
