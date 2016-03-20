import java.awt.Component;
import java.io.EOFException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public class class19 {
   @ObfuscatedName("g")
   boolean field277 = false;
   @ObfuscatedName("f")
   boolean[] field278;
   @ObfuscatedName("ej")
   static class78 field279;
   @ObfuscatedName("e")
   String[] field281;
   @ObfuscatedName("y")
   int[] field282;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -4059478359268144577L
   )
   long field283;
   @ObfuscatedName("s")
   boolean[] field287;

   @ObfuscatedName("e")
   class226 method216(boolean var1) {
      return class135.method2882("2", class18.field274.field2272, var1);
   }

   @ObfuscatedName("a")
   void method217(int var1, int var2) {
      this.field282[var1] = var2;
      if(this.field278[var1]) {
         this.field277 = true;
      }

   }

   @ObfuscatedName("j")
   void method218() {
      if(this.field277 && this.field283 < class18.method214() - 60000L) {
         this.method221();
      }

   }

   @ObfuscatedName("r")
   int method219(int var1) {
      return this.field282[var1];
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-728605894"
   )
   void method220() {
      int var1;
      for(var1 = 0; var1 < this.field282.length; ++var1) {
         if(!this.field278[var1]) {
            this.field282[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.field281.length; ++var1) {
         if(!this.field287[var1]) {
            this.field281[var1] = null;
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1775757932"
   )
   void method221() {
      class226 var1 = this.method216(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field282.length; ++var4) {
            if(this.field278[var4] && this.field282[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.field281.length; ++var5) {
            if(this.field287[var5] && this.field281[var5] != null) {
               var2 += 2 + class22.method578(this.field281[var5]);
               ++var4;
            }
         }

         class118 var17 = new class118(var2);
         var17.method2497(1);
         var17.method2498(var3);

         int var6;
         for(var6 = 0; var6 < this.field282.length; ++var6) {
            if(this.field278[var6] && this.field282[var6] != -1) {
               var17.method2498(var6);
               var17.method2663(this.field282[var6]);
            }
         }

         var17.method2498(var4);

         for(var6 = 0; var6 < this.field281.length; ++var6) {
            if(this.field287[var6] && null != this.field281[var6]) {
               var17.method2498(var6);
               var17.method2503(this.field281[var6]);
            }
         }

         var1.method4154(var17.field1980, 0, var17.field1979);
      } catch (Exception var15) {
         ;
      } finally {
         try {
            var1.method4168();
         } catch (Exception var14) {
            ;
         }

      }

      this.field277 = false;
      this.field283 = class18.method214();
   }

   @ObfuscatedName("f")
   void method223(int var1, String var2) {
      this.field281[var1] = var2;
      if(this.field287[var1]) {
         this.field277 = true;
      }

   }

   class19() {
      this.field282 = new int[class48.field1079.method3273(19)];
      this.field281 = new String[class48.field1079.method3273(15)];
      this.field278 = new boolean[this.field282.length];

      int var1;
      for(var1 = 0; var1 < this.field282.length; ++var1) {
         class45 var3 = (class45)class45.field1038.method3792((long)var1);
         class45 var2;
         if(null != var3) {
            var2 = var3;
         } else {
            byte[] var4 = class45.field1046.method3263(19, var1);
            var3 = new class45();
            if(var4 != null) {
               var3.method957(new class118(var4));
            }

            class45.field1038.method3794(var3, (long)var1);
            var2 = var3;
         }

         this.field278[var1] = var2.field1040;
      }

      this.field287 = new boolean[this.field281.length];

      for(var1 = 0; var1 < this.field281.length; ++var1) {
         class49 var5 = class2.method28(var1);
         this.field287[var1] = var5.field1090;
      }

      for(var1 = 0; var1 < this.field282.length; ++var1) {
         this.field282[var1] = -1;
      }

      this.method240();
   }

   @ObfuscatedName("s")
   String method224(int var1) {
      return this.field281[var1];
   }

   @ObfuscatedName("n")
   boolean method225() {
      return this.field277;
   }

   @ObfuscatedName("m")
   void method240() {
      class226 var1 = this.method216(false);

      try {
         byte[] var2 = new byte[(int)var1.method4156()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var1.method4157(var2, var3, var2.length - var3);
            if(-1 == var4) {
               throw new EOFException();
            }
         }

         class118 var23 = new class118(var2);
         if(var23.field1980.length - var23.field1979 < 1) {
            return;
         }

         int var5 = var23.method2579();
         if(var5 < 0 || var5 > 1) {
            return;
         }

         int var6 = var23.method2514();

         int var7;
         int var8;
         int var9;
         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var23.method2514();
            var9 = var23.method2517();
            if(this.field278[var8]) {
               this.field282[var8] = var9;
            }
         }

         var7 = var23.method2514();

         for(var8 = 0; var8 < var7; ++var8) {
            var9 = var23.method2514();
            String var10 = var23.method2520();
            if(this.field287[var9]) {
               this.field281[var9] = var10;
            }
         }
      } catch (Exception var21) {
         ;
      } finally {
         try {
            var1.method4168();
         } catch (Exception var20) {
            ;
         }

      }

      this.field277 = false;
   }

   @ObfuscatedName("aw")
   public static class77 method247(int var0, int var1, Component var2) {
      try {
         class81 var3 = new class81();
         var3.vmethod1893(var0, var1, var2);
         return var3;
      } catch (Throwable var5) {
         class75 var4 = new class75();
         var4.vmethod1893(var0, var1, var2);
         return var4;
      }
   }
}
