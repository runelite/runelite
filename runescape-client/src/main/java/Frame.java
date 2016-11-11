import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cq")
@Implements("Frame")
public class Frame {
   @ObfuscatedName("j")
   int[] field1589;
   @ObfuscatedName("g")
   static int[] field1590 = new int[500];
   @ObfuscatedName("e")
   static int[] field1591 = new int[500];
   @ObfuscatedName("h")
   static int[] field1592 = new int[500];
   @ObfuscatedName("n")
   FrameMap field1593 = null;
   @ObfuscatedName("u")
   int field1594 = -1;
   @ObfuscatedName("d")
   int[] field1595;
   @ObfuscatedName("l")
   int[] field1596;
   @ObfuscatedName("m")
   int[] field1597;
   @ObfuscatedName("i")
   static int[] field1598 = new int[500];
   @ObfuscatedName("y")
   boolean field1599 = false;

   Frame(byte[] var1, FrameMap var2) {
      this.field1593 = var2;
      Buffer var3 = new Buffer(var1);
      Buffer var4 = new Buffer(var1);
      var3.offset = 2;
      int var5 = var3.method2544();
      int var6 = -1;
      int var7 = 0;
      var4.offset = var3.offset + var5;

      int var8;
      for(var8 = 0; var8 < var5; ++var8) {
         int var9 = var3.method2544();
         if(var9 > 0) {
            if(this.field1593.field1818[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1593.field1818[var10] == 0) {
                     field1598[var7] = var10;
                     field1592[var7] = 0;
                     field1591[var7] = 0;
                     field1590[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1598[var7] = var8;
            short var11 = 0;
            if(this.field1593.field1818[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1592[var7] = var4.method2556();
            } else {
               field1592[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1591[var7] = var4.method2556();
            } else {
               field1591[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1590[var7] = var4.method2556();
            } else {
               field1590[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1593.field1818[var8] == 5) {
               this.field1599 = true;
            }
         }
      }

      if(var4.offset != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1594 = var7;
         this.field1595 = new int[var7];
         this.field1596 = new int[var7];
         this.field1597 = new int[var7];
         this.field1589 = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1595[var8] = field1598[var8];
            this.field1596[var8] = field1592[var8];
            this.field1597[var8] = field1591[var8];
            this.field1589[var8] = field1590[var8];
         }

      }
   }
}
