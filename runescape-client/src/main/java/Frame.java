import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ck")
@Implements("Frame")
public class Frame {
   @ObfuscatedName("l")
   boolean field1595 = false;
   @ObfuscatedName("f")
   static int[] field1596 = new int[500];
   @ObfuscatedName("n")
   static int[] field1597 = new int[500];
   @ObfuscatedName("t")
   static int[] field1598 = new int[500];
   @ObfuscatedName("v")
   FrameMap field1599 = null;
   @ObfuscatedName("b")
   int field1600 = -1;
   @ObfuscatedName("c")
   int[] field1601;
   @ObfuscatedName("k")
   int[] field1602;
   @ObfuscatedName("m")
   int[] field1603;
   @ObfuscatedName("w")
   int[] field1604;
   @ObfuscatedName("e")
   static int[] field1605 = new int[500];

   Frame(byte[] var1, FrameMap var2) {
      this.field1599 = var2;
      Buffer var3 = new Buffer(var1);
      Buffer var4 = new Buffer(var1);
      var3.offset = 2;
      int var5 = var3.method2656();
      int var6 = -1;
      int var7 = 0;
      var4.offset = var3.offset + var5;

      int var8;
      for(var8 = 0; var8 < var5; ++var8) {
         int var9 = var3.method2656();
         if(var9 > 0) {
            if(this.field1599.field1823[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1599.field1823[var10] == 0) {
                     field1596[var7] = var10;
                     field1605[var7] = 0;
                     field1597[var7] = 0;
                     field1598[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1596[var7] = var8;
            short var11 = 0;
            if(this.field1599.field1823[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1605[var7] = var4.method2549();
            } else {
               field1605[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1597[var7] = var4.method2549();
            } else {
               field1597[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1598[var7] = var4.method2549();
            } else {
               field1598[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1599.field1823[var8] == 5) {
               this.field1595 = true;
            }
         }
      }

      if(var4.offset != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1600 = var7;
         this.field1603 = new int[var7];
         this.field1602 = new int[var7];
         this.field1601 = new int[var7];
         this.field1604 = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1603[var8] = field1596[var8];
            this.field1602[var8] = field1605[var8];
            this.field1601[var8] = field1597[var8];
            this.field1604[var8] = field1598[var8];
         }

      }
   }
}
