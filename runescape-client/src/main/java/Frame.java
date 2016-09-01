import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cf")
@Implements("Frame")
public class Frame {
   @ObfuscatedName("i")
   FrameMap field1586 = null;
   @ObfuscatedName("r")
   static int[] field1587 = new int[500];
   @ObfuscatedName("p")
   int[] field1588;
   @ObfuscatedName("z")
   static int[] field1589 = new int[500];
   @ObfuscatedName("j")
   static int[] field1590 = new int[500];
   @ObfuscatedName("d")
   boolean field1591 = false;
   @ObfuscatedName("l")
   int[] field1592;
   @ObfuscatedName("m")
   int[] field1593;
   @ObfuscatedName("x")
   static int[] field1594 = new int[500];
   @ObfuscatedName("f")
   int[] field1595;
   @ObfuscatedName("b")
   int field1596 = -1;

   Frame(byte[] var1, FrameMap var2) {
      this.field1586 = var2;
      Buffer var3 = new Buffer(var1);
      Buffer var4 = new Buffer(var1);
      var3.offset = 2;
      int var5 = var3.method2556();
      int var6 = -1;
      int var7 = 0;
      var4.offset = var3.offset + var5;

      int var8;
      for(var8 = 0; var8 < var5; ++var8) {
         int var9 = var3.method2556();
         if(var9 > 0) {
            if(this.field1586.field1821[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1586.field1821[var10] == 0) {
                     field1594[var7] = var10;
                     field1587[var7] = 0;
                     field1590[var7] = 0;
                     field1589[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1594[var7] = var8;
            short var11 = 0;
            if(this.field1586.field1821[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1587[var7] = var4.method2568();
            } else {
               field1587[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1590[var7] = var4.method2568();
            } else {
               field1590[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1589[var7] = var4.method2568();
            } else {
               field1589[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1586.field1821[var8] == 5) {
               this.field1591 = true;
            }
         }
      }

      if(var4.offset != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1596 = var7;
         this.field1592 = new int[var7];
         this.field1593 = new int[var7];
         this.field1588 = new int[var7];
         this.field1595 = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1592[var8] = field1594[var8];
            this.field1593[var8] = field1587[var8];
            this.field1588[var8] = field1590[var8];
            this.field1595[var8] = field1589[var8];
         }

      }
   }
}
