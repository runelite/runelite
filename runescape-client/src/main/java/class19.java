import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
@Implements("ChatMessages")
public class class19 {
   @ObfuscatedName("es")
   static class81[] field274;
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = 496215293
   )
   static int field278;
   @ObfuscatedName("c")
   boolean[] field279;
   @ObfuscatedName("b")
   boolean field280 = false;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 1232329389398912721L
   )
   long field281;
   @ObfuscatedName("a")
   @Export("messages")
   String[] field282;
   @ObfuscatedName("h")
   boolean[] field284;
   @ObfuscatedName("dw")
   @ObfuscatedGetter(
      intValue = 1441834465
   )
   @Export("baseX")
   static int field286;
   @ObfuscatedName("r")
   int[] field287;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-1355771140"
   )
   void method180(int var1, String var2) {
      this.field282[var1] = var2;
      if(this.field284[var1]) {
         this.field280 = true;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "540479678"
   )
   void method182() {
      if(this.field280 && this.field281 < client.method424() - 60000L) {
         this.method184();
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ZI)Lclass230;",
      garbageValue = "1596540232"
   )
   class230 method183(boolean var1) {
      return class110.method2465("2", client.field372.field2335, var1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-98"
   )
   void method184() {
      class230 var1 = this.method183(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field287.length; ++var4) {
            if(this.field279[var4] && this.field287[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.field282.length; ++var5) {
            if(this.field284[var5] && this.field282[var5] != null) {
               var2 += 2 + class29.method650(this.field282[var5]);
               ++var4;
            }
         }

         class122 var9 = new class122(var2);
         var9.method2795(1);
         var9.method2781(var3);

         int var6;
         for(var6 = 0; var6 < this.field287.length; ++var6) {
            if(this.field279[var6] && this.field287[var6] != -1) {
               var9.method2781(var6);
               var9.method2598(this.field287[var6]);
            }
         }

         var9.method2781(var4);

         for(var6 = 0; var6 < this.field282.length; ++var6) {
            if(this.field284[var6] && this.field282[var6] != null) {
               var9.method2781(var6);
               var9.method2601(this.field282[var6]);
            }
         }

         var1.method4212(var9.field2054, 0, var9.field2061);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method4213();
         } catch (Exception var16) {
            ;
         }

      }

      this.field280 = false;
      this.field281 = client.method424();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "186657329"
   )
   void method185() {
      class230 var1 = this.method183(false);

      label205: {
         try {
            byte[] var2 = new byte[(int)var1.method4214()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method4215(var2, var3, var2.length - var3);
               if(var4 == -1) {
                  throw new EOFException();
               }
            }

            class122 var13 = new class122(var2);
            if(var13.field2054.length - var13.field2061 < 1) {
               return;
            }

            int var14 = var13.method2610();
            if(var14 >= 0 && var14 <= 1) {
               int var15 = var13.method2612();

               int var7;
               int var8;
               int var9;
               for(var7 = 0; var7 < var15; ++var7) {
                  var8 = var13.method2612();
                  var9 = var13.method2614();
                  if(this.field279[var8]) {
                     this.field287[var8] = var9;
                  }
               }

               var7 = var13.method2612();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label205;
                  }

                  var9 = var13.method2612();
                  String var10 = var13.method2617();
                  if(this.field284[var9]) {
                     this.field282[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var24) {
            break label205;
         } finally {
            try {
               var1.method4213();
            } catch (Exception var23) {
               ;
            }

         }

         return;
      }

      this.field280 = false;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-2"
   )
   void method186() {
      int var1;
      for(var1 = 0; var1 < this.field287.length; ++var1) {
         if(!this.field279[var1]) {
            this.field287[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.field282.length; ++var1) {
         if(!this.field284[var1]) {
            this.field282[var1] = null;
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "101053146"
   )
   boolean method187() {
      return this.field280;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "376716876"
   )
   int method192(int var1) {
      return this.field287[var1];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass170;I)V",
      garbageValue = "-1468745402"
   )
   public static void method195(class170 var0) {
      class43.field1012 = var0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1818726542"
   )
   void method196(int var1, int var2) {
      this.field287[var1] = var2;
      if(this.field279[var1]) {
         this.field280 = true;
      }

   }

   class19() {
      this.field287 = new int[class172.field2748.method3352(19)];
      this.field282 = new String[class172.field2748.method3352(15)];
      this.field279 = new boolean[this.field287.length];

      int var1;
      for(var1 = 0; var1 < this.field287.length; ++var1) {
         class47 var3 = (class47)class47.field1073.method3834((long)var1);
         class47 var2;
         if(var3 != null) {
            var2 = var3;
         } else {
            byte[] var4 = class47.field1075.method3340(19, var1);
            var3 = new class47();
            if(null != var4) {
               var3.method1017(new class122(var4));
            }

            class47.field1073.method3836(var3, (long)var1);
            var2 = var3;
         }

         this.field279[var1] = var2.field1072;
      }

      this.field284 = new boolean[this.field282.length];

      for(var1 = 0; var1 < this.field282.length; ++var1) {
         class53 var5 = class5.method52(var1);
         this.field284[var1] = var5.field1158;
      }

      for(var1 = 0; var1 < this.field287.length; ++var1) {
         this.field287[var1] = -1;
      }

      this.method185();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "112"
   )
   String method205(int var1) {
      return this.field282[var1];
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Lclass39;B)V",
      garbageValue = "0"
   )
   static final void method206(class39 var0) {
      if(var0.field859 == client.field567 || var0.field890 == -1 || var0.field904 != 0 || 1 + var0.field884 > class13.method153(var0.field890).field1025[var0.field865]) {
         int var1 = var0.field859 - var0.field883;
         int var2 = client.field567 - var0.field883;
         int var3 = var0.field892 * 128 + var0.field851 * 64;
         int var4 = var0.field851 * 64 + var0.field894 * 128;
         int var5 = var0.field851 * 64 + var0.field893 * 128;
         int var6 = var0.field895 * 128 + var0.field851 * 64;
         var0.field896 = ((var1 - var2) * var3 + var2 * var5) / var1;
         var0.field879 = ((var1 - var2) * var4 + var6 * var2) / var1;
      }

      var0.field908 = 0;
      var0.field889 = var0.field862;
      var0.field905 = var0.field889;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "8214"
   )
   static final int method210(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "(IIIILclass81;Lclass178;I)V",
      garbageValue = "2147464345"
   )
   static final void method211(int var0, int var1, int var2, int var3, class81 var4, class178 var5) {
      int var6 = var2 * var2 + var3 * var3;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = client.field514 + client.field365 & 2047;
         int var8 = class94.field1655[var7];
         int var9 = class94.field1653[var7];
         var8 = var8 * 256 / (256 + client.field327);
         var9 = var9 * 256 / (client.field327 + 256);
         int var10 = var8 * var3 + var2 * var9 >> 16;
         int var11 = var9 * var3 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class30.field719.method1813(4 + var14 + var0 + 94 - 10, 83 + var1 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class51.method1121(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)Lclass176;",
      garbageValue = "-2"
   )
   public static class176 method212(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(class176.field2811[var1] == null || class176.field2811[var1][var2] == null) {
         boolean var3 = class10.method112(var1);
         if(!var3) {
            return null;
         }
      }

      return class176.field2811[var1][var2];
   }
}
