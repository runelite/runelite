import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
public class class116 {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1825930159
   )
   int field1697;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1838429099
   )
   int field1700;
   @ObfuscatedName("y")
   int[][] field1701;
   @ObfuscatedName("n")
   public static short[][] field1703;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1891522449"
   )
   int method2091(int var1) {
      if(this.field1701 != null) {
         var1 = (int)((long)var1 * (long)this.field1700 / (long)this.field1697);
      }

      return var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "1003057419"
   )
   byte[] method2092(byte[] var1) {
      if(this.field1701 != null) {
         int var2 = (int)((long)var1.length * (long)this.field1700 / (long)this.field1697) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1701[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var9 + var4] += var8[var9] * var7;
            }

            var5 += this.field1700;
            var9 = var5 / this.field1697;
            var4 += var9;
            var5 -= this.field1697 * var9;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = var3[var6] + '耀' >> 16;
            if(var10 < -128) {
               var1[var6] = -128;
            } else if(var10 > 127) {
               var1[var6] = 127;
            } else {
               var1[var6] = (byte)var10;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "-479"
   )
   int method2094(int var1) {
      if(this.field1701 != null) {
         var1 = (int)((long)var1 * (long)this.field1700 / (long)this.field1697) + 6;
      }

      return var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1872998918"
   )
   public static String method2098(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            var5 = RSSocket.method3005(var5);
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }

   public class116(int var1, int var2) {
      if(var2 != var1) {
         int var3 = class239.method4271(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.field1697 = var1;
         this.field1700 = var2;
         this.field1701 = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.field1701[var4];
            double var6 = 6.0D + (double)var4 / (double)var1;
            int var8 = (int)Math.floor(1.0D + (var6 - 7.0D));
            if(var8 < 0) {
               var8 = 0;
            }

            int var9 = (int)Math.ceil(7.0D + var6);
            if(var9 > 14) {
               var9 = 14;
            }

            for(double var10 = (double)var2 / (double)var1; var8 < var9; ++var8) {
               double var12 = 3.141592653589793D * ((double)var8 - var6);
               double var14 = var10;
               if(var12 < -1.0E-4D || var12 > 1.0E-4D) {
                  var14 = var10 * (Math.sin(var12) / var12);
               }

               var14 *= 0.54D + 0.46D * Math.cos(((double)var8 - var6) * 0.2243994752564138D);
               var5[var8] = (int)Math.floor(var14 * 65536.0D + 0.5D);
            }
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;Lclass186;I)Lclass186;",
      garbageValue = "-883196519"
   )
   static final class186 method2101(Buffer var0, class186 var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = class29.method228(var2);
         var1 = new class186(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var0.readUnsignedByte() == 1;
         int var5 = var0.read24BitInt();
         Object var6;
         if(var4) {
            var6 = new class185(var0.readString());
         } else {
            var6 = new class198(var0.readInt());
         }

         var1.method3476((Node)var6, (long)var5);
      }

      return var1;
   }
}
