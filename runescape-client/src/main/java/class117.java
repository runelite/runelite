import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("du")
public class class117 {
   @ObfuscatedName("k")
   int[][] field1674;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1470846277
   )
   int field1673;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -140408205
   )
   int field1676;

   public class117(int var1, int var2) {
      if(var2 != var1) {
         int var3 = class39.method538(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.field1676 = var1;
         this.field1673 = var2;
         this.field1674 = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.field1674[var4];
            double var6 = (double)var4 / (double)var1 + 6.0D;
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

               var14 *= 0.54D + 0.46D * Math.cos(0.2243994752564138D * ((double)var8 - var6));
               var5[var8] = (int)Math.floor(var14 * 65536.0D + 0.5D);
            }
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1126683851"
   )
   byte[] method2131(byte[] var1) {
      if(this.field1674 != null) {
         int var2 = (int)((long)var1.length * (long)this.field1673 / (long)this.field1676) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1674[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var9 + var4] += var7 * var8[var9];
            }

            var5 += this.field1673;
            var9 = var5 / this.field1676;
            var4 += var9;
            var5 -= var9 * this.field1676;
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1863185684"
   )
   int method2132(int var1) {
      if(this.field1674 != null) {
         var1 = (int)((long)var1 * (long)this.field1673 / (long)this.field1676);
      }

      return var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1234694208"
   )
   int method2133(int var1) {
      if(this.field1674 != null) {
         var1 = (int)((long)var1 * (long)this.field1673 / (long)this.field1676) + 6;
      }

      return var1;
   }

   @ObfuscatedName("js")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1258171227"
   )
   static void method2139(String var0) {
      class72.sessionToken = var0;

      try {
         String var1 = class5.clientInstance.getParameter(Parameters.field3697.key);
         String var2 = class5.clientInstance.getParameter(Parameters.field3693.key);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            String var4 = var3 + "; Expires=";
            long var6 = class170.currentTimeMs() + 94608000000L;
            class183.field2424.setTime(new Date(var6));
            int var8 = class183.field2424.get(7);
            int var9 = class183.field2424.get(5);
            int var10 = class183.field2424.get(2);
            int var11 = class183.field2424.get(1);
            int var12 = class183.field2424.get(11);
            int var13 = class183.field2424.get(12);
            int var14 = class183.field2424.get(13);
            String var5 = class183.field2422[var8 - 1] + ", " + var9 / 10 + var9 % 10 + "-" + class183.field2426[0][var10] + "-" + var11 + " " + var12 / 10 + var12 % 10 + ":" + var13 / 10 + var13 % 10 + ":" + var14 / 10 + var14 % 10 + " GMT";
            var3 = var4 + var5 + "; Max-Age=" + 94608000L;
         }

         class52.method777(class5.clientInstance, "document.cookie=\"" + var3 + "\"");
      } catch (Throwable var15) {
         ;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lit;Ljava/lang/String;Ljava/lang/String;I)Ljp;",
      garbageValue = "-1960766185"
   )
   @Export("getSprite")
   public static IndexedSprite getSprite(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      IndexedSprite var5;
      if(!Script.method1883(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class14.method80();
      }

      return var5;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "801556878"
   )
   public static Class method2140(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }
}
