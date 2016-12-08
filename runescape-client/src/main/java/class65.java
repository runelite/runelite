import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
public class class65 {
   @ObfuscatedName("v")
   int[][] field1104;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -344310643
   )
   int field1106;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -840518247
   )
   int field1107;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1594316657"
   )
   static int method1150(int var0, int var1) {
      long var2 = (long)(var1 + (var0 << 16));
      return null != class172.field2358 && var2 == class172.field2358.hash?class149.field2051.offset * 99 / (class149.field2051.payload.length - class172.field2358.field2710) + 1:0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2019620579"
   )
   int method1151(int var1) {
      if(null != this.field1104) {
         var1 = (int)((long)this.field1107 * (long)var1 / (long)this.field1106);
      }

      return var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "55283389"
   )
   int method1152(int var1) {
      if(this.field1104 != null) {
         var1 = (int)((long)this.field1107 * (long)var1 / (long)this.field1106) + 6;
      }

      return var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-2041408249"
   )
   byte[] method1156(byte[] var1) {
      if(null != this.field1104) {
         int var2 = 14 + (int)((long)this.field1107 * (long)var1.length / (long)this.field1106);
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1104[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var8[var9] * var7;
            }

            var5 += this.field1107;
            var9 = var5 / this.field1106;
            var4 += var9;
            var5 -= this.field1106 * var9;
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

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-30"
   )
   static final void method1161(boolean var0) {
      class183.method3292();
      ++Client.field336;
      if(Client.field336 >= 50 || var0) {
         Client.field336 = 0;
         if(!Client.field341 && class6.field46 != null) {
            Client.field330.method2967(78);

            try {
               class6.field46.method2016(Client.field330.payload, 0, Client.field330.offset);
               Client.field330.offset = 0;
            } catch (IOException var2) {
               Client.field341 = true;
            }
         }

      }
   }

   public class65(int var1, int var2) {
      if(var2 != var1) {
         int var3 = Player.method221(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.field1106 = var1;
         this.field1107 = var2;
         this.field1104 = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.field1104[var4];
            double var6 = 6.0D + (double)var4 / (double)var1;
            int var8 = (int)Math.floor(var6 - 7.0D + 1.0D);
            if(var8 < 0) {
               var8 = 0;
            }

            int var9 = (int)Math.ceil(var6 + 7.0D);
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
               var5[var8] = (int)Math.floor(0.5D + var14 * 65536.0D);
            }
         }

      }
   }

   @ObfuscatedName("ei")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "1677798744"
   )
   static String method1162(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.field428 == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.field428 == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.field428 == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.field428 == 5) {
         var0 = var0 + "-wti";
      } else if(Client.field428 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(null != class112.field1776) {
         var3 = "/p=" + class112.field1776;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.field509 + "/a=" + Ignore.field215 + var3 + "/";
   }
}
