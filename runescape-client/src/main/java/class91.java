import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cv")
@Implements("Frame")
public class class91 {
   @ObfuscatedName("g")
   class105 field1612 = null;
   @ObfuscatedName("w")
   static int[] field1613 = new int[500];
   @ObfuscatedName("e")
   static int[] field1614 = new int[500];
   @ObfuscatedName("v")
   boolean field1615 = false;
   @ObfuscatedName("m")
   static int[] field1616 = new int[500];
   @ObfuscatedName("l")
   int field1617 = -1;
   @ObfuscatedName("j")
   int[] field1618;
   @ObfuscatedName("r")
   int[] field1619;
   @ObfuscatedName("x")
   int[] field1620;
   @ObfuscatedName("o")
   static int[] field1621 = new int[500];
   @ObfuscatedName("k")
   int[] field1622;

   class91(byte[] var1, class105 var2) {
      this.field1612 = var2;
      class122 var3 = new class122(var1);
      class122 var4 = new class122(var1);
      var3.field2045 = 2;
      int var5 = var3.method2556();
      int var6 = -1;
      int var7 = 0;
      var4.field2045 = var3.field2045 + var5;

      int var8;
      for(var8 = 0; var8 < var5; ++var8) {
         int var9 = var3.method2556();
         if(var9 > 0) {
            if(this.field1612.field1831[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1612.field1831[var10] == 0) {
                     field1616[var7] = var10;
                     field1613[var7] = 0;
                     field1614[var7] = 0;
                     field1621[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1616[var7] = var8;
            short var11 = 0;
            if(this.field1612.field1831[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1613[var7] = var4.method2584();
            } else {
               field1613[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1614[var7] = var4.method2584();
            } else {
               field1614[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1621[var7] = var4.method2584();
            } else {
               field1621[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1612.field1831[var8] == 5) {
               this.field1615 = true;
            }
         }
      }

      if(var4.field2045 != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1617 = var7;
         this.field1618 = new int[var7];
         this.field1619 = new int[var7];
         this.field1620 = new int[var7];
         this.field1622 = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1618[var8] = field1616[var8];
            this.field1619[var8] = field1613[var8];
            this.field1620[var8] = field1614[var8];
            this.field1622[var8] = field1621[var8];
         }

      }
   }
}
