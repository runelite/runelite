import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cj")
@Implements("Frame")
public class class88 {
   @ObfuscatedName("p")
   boolean field1512 = false;
   @ObfuscatedName("g")
   static int[] field1513 = new int[500];
   @ObfuscatedName("j")
   static int[] field1514 = new int[500];
   @ObfuscatedName("d")
   static int[] field1515 = new int[500];
   @ObfuscatedName("x")
   class102 field1516 = null;
   @ObfuscatedName("y")
   int field1517 = -1;
   @ObfuscatedName("r")
   int[] field1518;
   @ObfuscatedName("u")
   int[] field1519;
   @ObfuscatedName("l")
   int[] field1520;
   @ObfuscatedName("c")
   int[] field1521;
   @ObfuscatedName("b")
   static int[] field1522 = new int[500];

   class88(byte[] var1, class102 var2) {
      this.field1516 = var2;
      class119 var3 = new class119(var1);
      class119 var4 = new class119(var1);
      var3.field1976 = 2;
      int var5 = var3.method2514();
      int var6 = -1;
      int var7 = 0;
      var4.field1976 = var3.field1976 + var5;

      int var8;
      for(var8 = 0; var8 < var5; ++var8) {
         int var9 = var3.method2514();
         if(var9 > 0) {
            if(this.field1516.field1744[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1516.field1744[var10] == 0) {
                     field1522[var7] = var10;
                     field1513[var7] = 0;
                     field1514[var7] = 0;
                     field1515[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1522[var7] = var8;
            short var11 = 0;
            if(this.field1516.field1744[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1513[var7] = var4.method2689();
            } else {
               field1513[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1514[var7] = var4.method2689();
            } else {
               field1514[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1515[var7] = var4.method2689();
            } else {
               field1515[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1516.field1744[var8] == 5) {
               this.field1512 = true;
            }
         }
      }

      if(var4.field1976 != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1517 = var7;
         this.field1518 = new int[var7];
         this.field1521 = new int[var7];
         this.field1520 = new int[var7];
         this.field1519 = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1518[var8] = field1522[var8];
            this.field1521[var8] = field1513[var8];
            this.field1520[var8] = field1514[var8];
            this.field1519[var8] = field1515[var8];
         }

      }
   }
}
