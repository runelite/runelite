import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("co")
@Implements("Frame")
public class Frame {
   @ObfuscatedName("u")
   static int[] field1316 = new int[500];
   @ObfuscatedName("x")
   static int[] field1317 = new int[500];
   @ObfuscatedName("i")
   static int[] field1318 = new int[500];
   @ObfuscatedName("t")
   boolean field1319 = false;
   @ObfuscatedName("f")
   FrameMap field1320 = null;
   @ObfuscatedName("c")
   int field1321 = -1;
   @ObfuscatedName("d")
   int[] field1322;
   @ObfuscatedName("l")
   int[] field1323;
   @ObfuscatedName("g")
   int[] field1324;
   @ObfuscatedName("a")
   static int[] field1325 = new int[500];
   @ObfuscatedName("z")
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
            if(this.field1320.field1462[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1320.field1462[var10] == 0) {
                     field1316[var7] = var10;
                     field1317[var7] = 0;
                     field1318[var7] = 0;
                     field1325[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1316[var7] = var8;
            short var11 = 0;
            if(this.field1320.field1462[var8] == 3) {
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
               field1325[var7] = var4.readShortSmart();
            } else {
               field1325[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1320.field1462[var8] == 5) {
               this.field1319 = true;
            }
         }
      }

      if(var4.offset != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1321 = var7;
         this.field1322 = new int[var7];
         this.field1323 = new int[var7];
         this.field1324 = new int[var7];
         this.field1326 = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1322[var8] = field1316[var8];
            this.field1323[var8] = field1317[var8];
            this.field1324[var8] = field1318[var8];
            this.field1326[var8] = field1325[var8];
         }

      }
   }
}
