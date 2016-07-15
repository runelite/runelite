import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cz")
@Implements("Frame")
public class class91 {
   @ObfuscatedName("b")
   int[] field1605;
   @ObfuscatedName("l")
   static int[] field1606 = new int[500];
   @ObfuscatedName("e")
   static int[] field1607 = new int[500];
   @ObfuscatedName("c")
   static int[] field1608 = new int[500];
   @ObfuscatedName("r")
   class105 field1609 = null;
   @ObfuscatedName("h")
   static int[] field1610 = new int[500];
   @ObfuscatedName("a")
   int field1611 = -1;
   @ObfuscatedName("u")
   int[] field1612;
   @ObfuscatedName("o")
   int[] field1613;
   @ObfuscatedName("p")
   int[] field1614;
   @ObfuscatedName("i")
   boolean field1615 = false;

   class91(byte[] var1, class105 var2) {
      this.field1609 = var2;
      class122 var3 = new class122(var1);
      class122 var4 = new class122(var1);
      var3.field2061 = 2;
      int var5 = var3.method2610();
      int var6 = -1;
      int var7 = 0;
      var4.field2061 = var3.field2061 + var5;

      int var8;
      for(var8 = 0; var8 < var5; ++var8) {
         int var9 = var3.method2610();
         if(var9 > 0) {
            if(this.field1609.field1843[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1609.field1843[var10] == 0) {
                     field1607[var7] = var10;
                     field1606[var7] = 0;
                     field1608[var7] = 0;
                     field1610[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1607[var7] = var8;
            short var11 = 0;
            if(this.field1609.field1843[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1606[var7] = var4.method2702();
            } else {
               field1606[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1608[var7] = var4.method2702();
            } else {
               field1608[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1610[var7] = var4.method2702();
            } else {
               field1610[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1609.field1843[var8] == 5) {
               this.field1615 = true;
            }
         }
      }

      if(var4.field2061 != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1611 = var7;
         this.field1605 = new int[var7];
         this.field1612 = new int[var7];
         this.field1613 = new int[var7];
         this.field1614 = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1605[var8] = field1607[var8];
            this.field1612[var8] = field1606[var8];
            this.field1613[var8] = field1608[var8];
            this.field1614[var8] = field1610[var8];
         }

      }
   }
}
