import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
@Implements("ChatMessages")
public class class19 {
   @ObfuscatedName("p")
   boolean[] field264;
   @ObfuscatedName("x")
   boolean[] field265;
   @ObfuscatedName("u")
   @Export("messages")
   String[] field266;
   @ObfuscatedName("o")
   boolean field268 = false;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -4663720936404828929L
   )
   long field269;
   @ObfuscatedName("d")
   int[] field271;
   @ObfuscatedName("gy")
   static class173 field274;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1830128416"
   )
   int method213(int var1) {
      return this.field271[var1];
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-806394778"
   )
   void method214(int var1, String var2) {
      this.field266[var1] = var2;
      if(this.field265[var1]) {
         this.field268 = true;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1739709261"
   )
   void method216() {
      int var1;
      for(var1 = 0; var1 < this.field271.length; ++var1) {
         if(!this.field264[var1]) {
            this.field271[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.field266.length; ++var1) {
         if(!this.field265[var1]) {
            this.field266[var1] = null;
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ZI)Lclass227;",
      garbageValue = "1"
   )
   class227 method217(boolean var1) {
      return class25.method614("2", client.field459.field2292, var1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1993869332"
   )
   void method219() {
      class227 var1 = this.method217(false);

      label196: {
         try {
            byte[] var2 = new byte[(int)var1.method4108()];

            int var3;
            for(int var4 = 0; var4 < var2.length; var4 += var3) {
               var3 = var1.method4119(var2, var4, var2.length - var4);
               if(-1 == var3) {
                  throw new EOFException();
               }
            }

            class119 var23 = new class119(var2);
            if(var23.field2007.length - var23.field2005 >= 1) {
               int var5 = var23.method2492();
               if(var5 >= 0 && var5 <= 1) {
                  int var6 = var23.method2584();

                  int var7;
                  int var8;
                  int var9;
                  for(var7 = 0; var7 < var6; ++var7) {
                     var8 = var23.method2584();
                     var9 = var23.method2497();
                     if(this.field264[var8]) {
                        this.field271[var8] = var9;
                     }
                  }

                  var7 = var23.method2584();
                  var8 = 0;

                  while(true) {
                     if(var8 >= var7) {
                        break label196;
                     }

                     var9 = var23.method2584();
                     String var10 = var23.method2500();
                     if(this.field265[var9]) {
                        this.field266[var9] = var10;
                     }

                     ++var8;
                  }
               }

               return;
            }
         } catch (Exception var21) {
            break label196;
         } finally {
            try {
               var1.method4121();
            } catch (Exception var20) {
               ;
            }

         }

         return;
      }

      this.field268 = false;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1204586221"
   )
   void method220() {
      if(this.field268 && this.field269 < class12.method162() - 60000L) {
         this.method227();
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1912955503"
   )
   void method226(int var1, int var2) {
      this.field271[var1] = var2;
      if(this.field264[var1]) {
         this.field268 = true;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "76408011"
   )
   void method227() {
      class227 var1 = this.method217(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field271.length; ++var4) {
            if(this.field264[var4] && -1 != this.field271[var4]) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.field266.length; ++var5) {
            if(this.field265[var5] && this.field266[var5] != null) {
               var2 += 2 + class30.method647(this.field266[var5]);
               ++var4;
            }
         }

         class119 var17 = new class119(var2);
         var17.method2477(1);
         var17.method2661(var3);

         int var6;
         for(var6 = 0; var6 < this.field271.length; ++var6) {
            if(this.field264[var6] && -1 != this.field271[var6]) {
               var17.method2661(var6);
               var17.method2480(this.field271[var6]);
            }
         }

         var17.method2661(var4);

         for(var6 = 0; var6 < this.field266.length; ++var6) {
            if(this.field265[var6] && null != this.field266[var6]) {
               var17.method2661(var6);
               var17.method2483(this.field266[var6]);
            }
         }

         var1.method4106(var17.field2007, 0, var17.field2005);
      } catch (Exception var15) {
         ;
      } finally {
         try {
            var1.method4121();
         } catch (Exception var14) {
            ;
         }

      }

      this.field268 = false;
      this.field269 = class12.method162();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "8"
   )
   boolean method230() {
      return this.field268;
   }

   class19() {
      this.field271 = new int[class186.field3023.method3249(19)];
      this.field266 = new String[class186.field3023.method3249(15)];
      this.field264 = new boolean[this.field271.length];

      int var1;
      byte[] var2;
      for(var1 = 0; var1 < this.field271.length; ++var1) {
         class45 var3 = (class45)class45.field1042.method3743((long)var1);
         class45 var4;
         if(var3 != null) {
            var4 = var3;
         } else {
            var2 = class45.field1044.method3239(19, var1);
            var3 = new class45();
            if(null != var2) {
               var3.method923(new class119(var2));
            }

            class45.field1042.method3745(var3, (long)var1);
            var4 = var3;
         }

         this.field264[var1] = var4.field1041;
      }

      this.field265 = new boolean[this.field266.length];

      for(var1 = 0; var1 < this.field266.length; ++var1) {
         class49 var5 = (class49)class49.field1098.method3743((long)var1);
         class49 var6;
         if(var5 != null) {
            var6 = var5;
         } else {
            var2 = class49.field1090.method3239(15, var1);
            var5 = new class49();
            if(null != var2) {
               var5.method975(new class119(var2));
            }

            class49.field1098.method3745(var5, (long)var1);
            var6 = var5;
         }

         this.field265[var1] = var6.field1099;
      }

      for(var1 = 0; var1 < this.field271.length; ++var1) {
         this.field271[var1] = -1;
      }

      this.method219();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "67"
   )
   String method233(int var1) {
      return this.field266[var1];
   }

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "0"
   )
   static boolean method241(String var0, boolean var1) {
      if(null == var0) {
         return false;
      } else {
         String var2 = class32.method690(var0, class1.field24);

         for(int var3 = 0; var3 < client.field499; ++var3) {
            if(var2.equalsIgnoreCase(class32.method690(client.field548[var3].field247, class1.field24))) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class32.method690(class106.field1881.field59, class1.field24))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1622085344"
   )
   static final int method242(int var0, int var1) {
      int var2 = class121.method2728(var0 - 1, var1 - 1) + class121.method2728(var0 + 1, var1 - 1) + class121.method2728(var0 - 1, 1 + var1) + class121.method2728(var0 + 1, var1 + 1);
      int var3 = class121.method2728(var0 - 1, var1) + class121.method2728(1 + var0, var1) + class121.method2728(var0, var1 - 1) + class121.method2728(var0, 1 + var1);
      int var4 = class121.method2728(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }
}
