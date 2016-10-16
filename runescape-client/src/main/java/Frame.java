import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cc")
@Implements("Frame")
public class Frame {
   @ObfuscatedName("t")
   static int[] field1579 = new int[500];
   @ObfuscatedName("z")
   static int[] field1580 = new int[500];
   @ObfuscatedName("p")
   FrameMap field1581 = null;
   @ObfuscatedName("y")
   static int[] field1582 = new int[500];
   @ObfuscatedName("m")
   int[] field1583;
   @ObfuscatedName("g")
   int field1584 = -1;
   @ObfuscatedName("h")
   int[] field1585;
   @ObfuscatedName("f")
   int[] field1586;
   @ObfuscatedName("k")
   int[] field1587;
   @ObfuscatedName("s")
   static int[] field1588 = new int[500];
   @ObfuscatedName("r")
   boolean field1589 = false;

   Frame(byte[] var1, FrameMap var2) {
      this.field1581 = var2;
      Buffer var3 = new Buffer(var1);
      Buffer var4 = new Buffer(var1);
      var3.offset = 2;
      int var5 = var3.method2481();
      int var6 = -1;
      int var7 = 0;
      var4.offset = var3.offset + var5;

      int var8;
      for(var8 = 0; var8 < var5; ++var8) {
         int var9 = var3.method2481();
         if(var9 > 0) {
            if(this.field1581.field1804[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1581.field1804[var10] == 0) {
                     field1588[var7] = var10;
                     field1580[var7] = 0;
                     field1579[var7] = 0;
                     field1582[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1588[var7] = var8;
            short var11 = 0;
            if(this.field1581.field1804[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1580[var7] = var4.method2670();
            } else {
               field1580[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1579[var7] = var4.method2670();
            } else {
               field1579[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1582[var7] = var4.method2670();
            } else {
               field1582[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1581.field1804[var8] == 5) {
               this.field1589 = true;
            }
         }
      }

      if(var4.offset != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1584 = var7;
         this.field1583 = new int[var7];
         this.field1586 = new int[var7];
         this.field1587 = new int[var7];
         this.field1585 = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1583[var8] = field1588[var8];
            this.field1586[var8] = field1580[var8];
            this.field1587[var8] = field1579[var8];
            this.field1585[var8] = field1582[var8];
         }

      }
   }
}
