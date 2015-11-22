package net.runelite.rs.client;

import java.io.EOFException;
import java.util.Date;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("v")
public class class19 {
   @ObfuscatedName("cm")
   static class145 field259;
   @ObfuscatedName("u")
   int[] field261;
   @ObfuscatedName("l")
   boolean[] field263;
   @ObfuscatedName("a")
   String[] field264;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 1043745098250391231L
   )
   long field266;
   @ObfuscatedName("hi")
   @ObfuscatedGetter(
      intValue = 1544358207
   )
   static int field267;
   @ObfuscatedName("pz")
   @ObfuscatedGetter(
      intValue = 755804251
   )
   static int field268;
   @ObfuscatedName("h")
   boolean field269 = false;
   @ObfuscatedName("dc")
   static byte[][] field270;
   @ObfuscatedName("f")
   boolean[] field271;

   @ObfuscatedName("j")
   void method224(int var1, int var2) {
      this.field261[var1] = var2;
      if(this.field271[var1]) {
         this.field269 = true;
      }

   }

   @ObfuscatedName("k")
   boolean method225() {
      return this.field269;
   }

   @ObfuscatedName("h")
   void method227() {
      class226 var1 = this.method262(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field261.length; ++var4) {
            if(this.field271[var4] && this.field261[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.field264.length; ++var5) {
            if(this.field263[var5] && this.field264[var5] != null) {
               var2 += 2 + class102.method2318(this.field264[var5]);
               ++var4;
            }
         }

         class118 var17 = new class118(var2);
         var17.method2521(1);
         var17.method2522(var3);

         int var6;
         for(var6 = 0; var6 < this.field261.length; ++var6) {
            if(this.field271[var6] && -1 != this.field261[var6]) {
               var17.method2522(var6);
               var17.method2524(this.field261[var6]);
            }
         }

         var17.method2522(var4);

         for(var6 = 0; var6 < this.field264.length; ++var6) {
            if(this.field263[var6] && this.field264[var6] != null) {
               var17.method2522(var6);
               var17.method2527(this.field264[var6]);
            }
         }

         var1.method4185(var17.field1980, 0, var17.field1981);
      } catch (Exception var15) {
         ;
      } finally {
         try {
            var1.method4183();
         } catch (Exception var14) {
            ;
         }

      }

      this.field269 = false;
      this.field266 = class92.method2177();
   }

   @ObfuscatedName("l")
   String method228(int var1) {
      return this.field264[var1];
   }

   class19() {
      this.field261 = new int[class50.field1087.method3322(19)];
      this.field264 = new String[class50.field1087.method3322(15)];
      this.field271 = new boolean[this.field261.length];

      int var1;
      for(var1 = 0; var1 < this.field261.length; ++var1) {
         class45 var2 = class102.method2322(var1);
         this.field271[var1] = var2.field1025;
      }

      this.field263 = new boolean[this.field264.length];

      for(var1 = 0; var1 < this.field264.length; ++var1) {
         class49 var3 = (class49)class49.field1073.method3808((long)var1);
         class49 var5;
         if(var3 != null) {
            var5 = var3;
         } else {
            byte[] var4 = class49.field1076.method3352(15, var1);
            var3 = new class49();
            if(var4 != null) {
               var3.method1039(new class118(var4));
            }

            class49.field1073.method3805(var3, (long)var1);
            var5 = var3;
         }

         this.field263[var1] = var5.field1072;
      }

      for(var1 = 0; var1 < this.field261.length; ++var1) {
         this.field261[var1] = -1;
      }

      this.method230();
   }

   @ObfuscatedName("i")
   void method230() {
      class226 var1 = this.method262(false);

      label192: {
         try {
            byte[] var2 = new byte[(int)var1.method4176()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method4177(var2, var3, var2.length - var3);
               if(var4 == -1) {
                  throw new EOFException();
               }
            }

            class118 var23 = new class118(var2);
            if(var23.field1980.length - var23.field1981 >= 1) {
               int var5 = var23.method2536();
               if(var5 < 0 || var5 > 1) {
                  return;
               }

               int var6 = var23.method2538();

               int var7;
               int var8;
               int var9;
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var23.method2538();
                  var9 = var23.method2541();
                  if(this.field271[var8]) {
                     this.field261[var8] = var9;
                  }
               }

               var7 = var23.method2538();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label192;
                  }

                  var9 = var23.method2538();
                  String var10 = var23.method2544();
                  if(this.field263[var9]) {
                     this.field264[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var21) {
            break label192;
         } finally {
            try {
               var1.method4183();
            } catch (Exception var20) {
               ;
            }

         }

         return;
      }

      this.field269 = false;
   }

   @ObfuscatedName("m")
   int method232(int var1) {
      return this.field261[var1];
   }

   @ObfuscatedName("t")
   void method233() {
      if(this.field269 && this.field266 < class92.method2177() - 60000L) {
         this.method227();
      }

   }

   @ObfuscatedName("u")
   static final void method243(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, class107[] var8) {
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var2 + var9 > 0 && var2 + var9 < 103 && var3 + var10 > 0 && var10 + var3 < 103) {
               var8[var1].field1879[var2 + var9][var3 + var10] &= -16777217;
            }
         }
      }

      class118 var13 = new class118(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var10 == var4 && var11 >= var5 && var11 < 8 + var5 && var12 >= var6 && var12 < 8 + var6) {
                  class138.method2977(var13, var1, var2 + class143.method3144(var11 & 7, var12 & 7, var7), var3 + class86.method2097(var11 & 7, var12 & 7, var7), 0, 0, var7);
               } else {
                  class138.method2977(var13, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }

   @ObfuscatedName("f")
   void method247(int var1, String var2) {
      this.field264[var1] = var2;
      if(this.field263[var1]) {
         this.field269 = true;
      }

   }

   @ObfuscatedName("u")
   void method253() {
      int var1;
      for(var1 = 0; var1 < this.field261.length; ++var1) {
         if(!this.field271[var1]) {
            this.field261[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.field264.length; ++var1) {
         if(!this.field263[var1]) {
            this.field264[var1] = null;
         }
      }

   }

   @ObfuscatedName("ae")
   static void method256() {
      client.field318.method2785(118);
      client.field318.method2521(class27.method688());
      client.field318.method2522(class129.field2048);
      client.field318.method2522(class136.field2101);
   }

   @ObfuscatedName("a")
   class226 method262(boolean var1) {
      return class75.method1666("2", class168.field2687.field2275, var1);
   }

   @ObfuscatedName("j")
   public static void method263(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var2 + var3) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(null == var6 || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method263(var0, var1, var2, var5 - 1);
         method263(var0, var1, 1 + var5, var3);
      }

   }

   @ObfuscatedName("j")
   public static String method264(long var0) {
      class110.field1937.setTime(new Date(var0));
      int var2 = class110.field1937.get(7);
      int var3 = class110.field1937.get(5);
      int var4 = class110.field1937.get(2);
      int var5 = class110.field1937.get(1);
      int var6 = class110.field1937.get(11);
      int var7 = class110.field1937.get(12);
      int var8 = class110.field1937.get(13);
      return class110.field1936[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class110.field1941[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }

   @ObfuscatedName("j")
   static String method265(int var0) {
      return "<img=" + var0 + ">";
   }
}
