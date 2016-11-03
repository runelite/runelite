import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cq")
@Implements("Frame")
public class Frame {
   @ObfuscatedName("c")
   static int[] field1597 = new int[500];
   @ObfuscatedName("q")
   static int[] field1598 = new int[500];
   @ObfuscatedName("u")
   int[] field1599;
   @ObfuscatedName("j")
   int field1600 = -1;
   @ObfuscatedName("v")
   FrameMap field1601 = null;
   @ObfuscatedName("l")
   boolean field1602 = false;
   @ObfuscatedName("m")
   int[] field1603;
   @ObfuscatedName("y")
   int[] field1604;
   @ObfuscatedName("k")
   static int[] field1605 = new int[500];
   @ObfuscatedName("h")
   int[] field1606;
   @ObfuscatedName("f")
   static int[] field1607 = new int[500];

   Frame(byte[] var1, FrameMap var2) {
      this.field1601 = var2;
      Buffer var3 = new Buffer(var1);
      Buffer var4 = new Buffer(var1);
      var3.offset = 2;
      int var5 = var3.method2571();
      int var6 = -1;
      int var7 = 0;
      var4.offset = var3.offset + var5;

      int var8;
      for(var8 = 0; var8 < var5; ++var8) {
         int var9 = var3.method2571();
         if(var9 > 0) {
            if(this.field1601.field1825[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1601.field1825[var10] == 0) {
                     field1605[var7] = var10;
                     field1598[var7] = 0;
                     field1607[var7] = 0;
                     field1597[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1605[var7] = var8;
            short var11 = 0;
            if(this.field1601.field1825[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1598[var7] = var4.method2583();
            } else {
               field1598[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1607[var7] = var4.method2583();
            } else {
               field1607[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1597[var7] = var4.method2583();
            } else {
               field1597[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1601.field1825[var8] == 5) {
               this.field1602 = true;
            }
         }
      }

      if(var4.offset != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1600 = var7;
         this.field1603 = new int[var7];
         this.field1604 = new int[var7];
         this.field1599 = new int[var7];
         this.field1606 = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1603[var8] = field1605[var8];
            this.field1604[var8] = field1598[var8];
            this.field1599[var8] = field1607[var8];
            this.field1606[var8] = field1597[var8];
         }

      }
   }
}
