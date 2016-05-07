import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class26 {
   @ObfuscatedName("iy")
   static class173 field664;

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-141388251"
   )
   static final void method615(int var0, int var1) {
      if(client.field496 >= 2 || client.field430 != 0 || client.field432) {
         String var2;
         if(client.field430 == 1 && client.field496 < 2) {
            var2 = "Use" + " " + client.field431 + " " + "->";
         } else if(client.field432 && client.field496 < 2) {
            var2 = client.field435 + " " + client.field436 + " " + "->";
         } else {
            int var4 = client.field496 - 1;
            String var3;
            if(client.field425[var4].length() > 0) {
               var3 = client.field424[var4] + " " + client.field425[var4];
            } else {
               var3 = client.field424[var4];
            }

            var2 = var3;
         }

         if(client.field496 > 2) {
            var2 = var2 + class12.method163(16777215) + " " + '/' + " " + (client.field496 - 2) + " more options";
         }

         class164.field2665.method4009(var2, var0 + 4, 15 + var1, 16777215, 0, client.field335 / 1000);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-32681"
   )
   static void method616() {
      class32.field755 = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class32.field768[var0] = null;
         class32.field753[var0] = 1;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIZI)Ljava/lang/String;",
      garbageValue = "1201447729"
   )
   static String method617(int var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         if(var2 && var0 >= 0) {
            int var3 = 2;

            for(int var4 = var0 / var1; 0 != var4; ++var3) {
               var4 /= var1;
            }

            char[] var5 = new char[var3];
            var5[0] = 43;

            for(int var6 = var3 - 1; var6 > 0; --var6) {
               int var7 = var0;
               var0 /= var1;
               int var8 = var7 - var1 * var0;
               if(var8 >= 10) {
                  var5[var6] = (char)(var8 + 87);
               } else {
                  var5[var6] = (char)(var8 + 48);
               }
            }

            return new String(var5);
         } else {
            return Integer.toString(var0, var1);
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass167;Ljava/lang/String;Ljava/lang/String;IZB)V",
      garbageValue = "255"
   )
   public static void method618(class167 var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.method3253(var1);
      int var6 = var0.method3254(var5, var2);
      class82.method1869(var0, var5, var6, var3, var4);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-498476840"
   )
   public static int method619(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if((var1 & 1) != 0) {
            var2 *= var0;
         }

         var0 *= var0;
      }

      if(1 == var1) {
         return var0 * var2;
      } else {
         return var2;
      }
   }
}
