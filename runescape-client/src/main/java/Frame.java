import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ca")
@Implements("Frame")
public class Frame {
   @ObfuscatedName("i")
   int[] field1623;
   @ObfuscatedName("g")
   int[] field1624;
   @ObfuscatedName("v")
   static int[] field1625 = new int[500];
   @ObfuscatedName("r")
   static int[] field1626 = new int[500];
   @ObfuscatedName("z")
   FrameMap field1627 = null;
   @ObfuscatedName("t")
   int field1628 = -1;
   @ObfuscatedName("n")
   int[] field1629;
   @ObfuscatedName("m")
   int[] field1630;
   @ObfuscatedName("a")
   static int[] field1631 = new int[500];
   @ObfuscatedName("d")
   static int[] field1632 = new int[500];
   @ObfuscatedName("k")
   boolean field1633 = false;

   Frame(byte[] var1, FrameMap var2) {
      this.field1627 = var2;
      Buffer var3 = new Buffer(var1);
      Buffer var4 = new Buffer(var1);
      var3.offset = 2;
      int var5 = var3.method2528();
      int var6 = -1;
      int var7 = 0;
      var4.offset = var3.offset + var5;

      int var8;
      for(var8 = 0; var8 < var5; ++var8) {
         int var9 = var3.method2528();
         if(var9 > 0) {
            if(this.field1627.field1847[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1627.field1847[var10] == 0) {
                     field1631[var7] = var10;
                     field1632[var7] = 0;
                     field1625[var7] = 0;
                     field1626[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1631[var7] = var8;
            short var11 = 0;
            if(this.field1627.field1847[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1632[var7] = var4.method2540();
            } else {
               field1632[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1625[var7] = var4.method2540();
            } else {
               field1625[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1626[var7] = var4.method2540();
            } else {
               field1626[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1627.field1847[var8] == 5) {
               this.field1633 = true;
            }
         }
      }

      if(var4.offset != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1628 = var7;
         this.field1629 = new int[var7];
         this.field1623 = new int[var7];
         this.field1624 = new int[var7];
         this.field1630 = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1629[var8] = field1631[var8];
            this.field1623[var8] = field1632[var8];
            this.field1624[var8] = field1625[var8];
            this.field1630[var8] = field1626[var8];
         }

      }
   }
}
