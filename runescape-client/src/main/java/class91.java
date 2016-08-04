import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ci")
@Implements("Frame")
public class class91 {
   @ObfuscatedName("n")
   int[] field1615;
   @ObfuscatedName("m")
   boolean field1616 = false;
   @ObfuscatedName("l")
   static int[] field1617 = new int[500];
   @ObfuscatedName("e")
   static int[] field1618 = new int[500];
   @ObfuscatedName("h")
   class105 field1619 = null;
   @ObfuscatedName("s")
   int field1620 = -1;
   @ObfuscatedName("k")
   int[] field1621;
   @ObfuscatedName("g")
   static int[] field1622 = new int[500];
   @ObfuscatedName("u")
   int[] field1623;
   @ObfuscatedName("b")
   int[] field1624;
   @ObfuscatedName("r")
   static int[] field1625 = new int[500];

   class91(byte[] var1, class105 var2) {
      this.field1619 = var2;
      class122 var3 = new class122(var1);
      class122 var4 = new class122(var1);
      var3.field2050 = 2;
      int var5 = var3.method2633();
      int var6 = -1;
      int var7 = 0;
      var4.field2050 = var3.field2050 + var5;

      int var8;
      for(var8 = 0; var8 < var5; ++var8) {
         int var9 = var3.method2633();
         if(var9 > 0) {
            if(this.field1619.field1836[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1619.field1836[var10] == 0) {
                     field1617[var7] = var10;
                     field1622[var7] = 0;
                     field1625[var7] = 0;
                     field1618[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1617[var7] = var8;
            short var11 = 0;
            if(this.field1619.field1836[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1622[var7] = var4.method2645();
            } else {
               field1622[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1625[var7] = var4.method2645();
            } else {
               field1625[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1618[var7] = var4.method2645();
            } else {
               field1618[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1619.field1836[var8] == 5) {
               this.field1616 = true;
            }
         }
      }

      if(var4.field2050 != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1620 = var7;
         this.field1621 = new int[var7];
         this.field1623 = new int[var7];
         this.field1615 = new int[var7];
         this.field1624 = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1621[var8] = field1617[var8];
            this.field1623[var8] = field1622[var8];
            this.field1615[var8] = field1625[var8];
            this.field1624[var8] = field1618[var8];
         }

      }
   }
}
