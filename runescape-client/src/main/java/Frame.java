import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ca")
@Implements("Frame")
public class Frame {
   @ObfuscatedName("z")
   boolean field1312 = false;
   @ObfuscatedName("m")
   static int[] field1313 = new int[500];
   @ObfuscatedName("v")
   int field1314 = -1;
   @ObfuscatedName("g")
   static int[] field1315 = new int[500];
   @ObfuscatedName("h")
   FrameMap field1316 = null;
   @ObfuscatedName("u")
   int[] field1317;
   @ObfuscatedName("l")
   int[] field1318;
   @ObfuscatedName("c")
   int[] field1319;
   @ObfuscatedName("k")
   int[] field1320;
   @ObfuscatedName("o")
   static int[] field1321 = new int[500];
   @ObfuscatedName("b")
   static int[] field1322 = new int[500];

   Frame(byte[] var1, FrameMap var2) {
      this.field1316 = var2;
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
            if(this.field1316.field1456[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1316.field1456[var10] == 0) {
                     field1321[var7] = var10;
                     field1313[var7] = 0;
                     field1322[var7] = 0;
                     field1315[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1321[var7] = var8;
            short var11 = 0;
            if(this.field1316.field1456[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1313[var7] = var4.readShortSmart();
            } else {
               field1313[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1322[var7] = var4.readShortSmart();
            } else {
               field1322[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1315[var7] = var4.readShortSmart();
            } else {
               field1315[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1316.field1456[var8] == 5) {
               this.field1312 = true;
            }
         }
      }

      if(var4.offset != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1314 = var7;
         this.field1318 = new int[var7];
         this.field1319 = new int[var7];
         this.field1317 = new int[var7];
         this.field1320 = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1318[var8] = field1321[var8];
            this.field1319[var8] = field1313[var8];
            this.field1317[var8] = field1322[var8];
            this.field1320[var8] = field1315[var8];
         }

      }
   }
}
