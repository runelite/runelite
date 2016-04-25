import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public final class class29 extends class85 {
   @ObfuscatedName("i")
   class42 field668;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2070616725
   )
   int field669;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 625591685
   )
   int field671;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1732502421
   )
   int field672;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1344714403
   )
   int field673;
   @ObfuscatedName("l")
   boolean field674 = false;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 461982529
   )
   int field675 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1146697287
   )
   int field676;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1134249253
   )
   int field677 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1752487855
   )
   int field682;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "33"
   )
   final void method651(int var1) {
      if(!this.field674) {
         this.field677 += var1;

         while(this.field677 > this.field668.field974[this.field675]) {
            this.field677 -= this.field668.field974[this.field675];
            ++this.field675;
            if(this.field675 >= this.field668.field972.length) {
               this.field674 = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "-1145523992"
   )
   protected final class105 vmethod1900() {
      class43 var1 = class19.method239(this.field676);
      class105 var2;
      if(!this.field674) {
         var2 = var1.method888(this.field675);
      } else {
         var2 = var1.method888(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "4"
   )
   static final int method653(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class13.method169(var3, var5);
      int var8 = class13.method169(var3 + 1, var5);
      int var9 = class13.method169(var3, var5 + 1);
      int var10 = class13.method169(var3 + 1, var5 + 1);
      int var11 = class135.method2845(var7, var8, var4, var2);
      int var12 = class135.method2845(var9, var10, var4, var2);
      return class135.method2845(var11, var12, var6, var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Lclass45;",
      garbageValue = "-1407647085"
   )
   public static class45 method654(int var0) {
      class45 var1 = (class45)class45.field1023.method3704((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class45.field1028.method3217(19, var0);
         var1 = new class45();
         if(null != var2) {
            var1.method936(new class119(var2));
         }

         class45.field1023.method3706(var1, (long)var0);
         return var1;
      }
   }

   class29(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field676 = var1;
      this.field682 = var2;
      this.field671 = var3;
      this.field672 = var4;
      this.field673 = var5;
      this.field669 = var7 + var6;
      int var8 = class19.method239(this.field676).field993;
      if(var8 != -1) {
         this.field674 = false;
         this.field668 = class161.method3153(var8);
      } else {
         this.field674 = true;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;B)Z",
      garbageValue = "-72"
   )
   static boolean method657(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class138.field2110.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var10 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var10.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var5) {
            return false;
         }
      } else if(1 == var1) {
         try {
            Object var3 = class132.method2816(class138.field2115, var2, new Object[]{(new URL(class138.field2115.getCodeBase(), var0)).toString()});
            return var3 != null;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class138.field2115.getAppletContext().showDocument(new URL(class138.field2115.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(3 == var1) {
         try {
            class132.method2815(class138.field2115, "loggedout");
         } catch (Throwable var9) {
            ;
         }

         try {
            class138.field2115.getAppletContext().showDocument(new URL(class138.field2115.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}
