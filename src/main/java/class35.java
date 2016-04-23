import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("MessageNode")
public class class35 extends class204 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -27983663
   )
   int field763;
   @ObfuscatedName("z")
   String field764;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 151385875
   )
   int field765;
   @ObfuscatedName("x")
   @Export("sender")
   String field766;
   @ObfuscatedName("l")
   public static short[][] field767;
   @ObfuscatedName("e")
   @Export("value")
   String field768;
   @ObfuscatedName("y")
   static int[] field769;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2009154521
   )
   @Export("type")
   int field770;
   @ObfuscatedName("dx")
   @Export("region")
   static class86 field771;
   @ObfuscatedName("gi")
   static class173 field772;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)Lclass49;",
      garbageValue = "0"
   )
   public static class49 method725(int var0) {
      class49 var1 = (class49)class49.field1069.method3704((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class49.field1072.method3217(15, var0);
         var1 = new class49();
         if(var2 != null) {
            var1.method998(new class119(var2));
         }

         class49.field1069.method3706(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "-118"
   )
   void method729(int var1, String var2, String var3, String var4) {
      int var5 = ++class11.field173 - 1;
      this.field765 = var5;
      this.field763 = client.field285;
      this.field770 = var1;
      this.field764 = var2;
      this.field766 = var3;
      this.field768 = var4;
   }

   class35(int var1, String var2, String var3, String var4) {
      int var5 = ++class11.field173 - 1;
      this.field765 = var5;
      this.field763 = client.field285;
      this.field770 = var1;
      this.field764 = var2;
      this.field766 = var3;
      this.field768 = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIZI)Ljava/lang/String;",
      garbageValue = "1"
   )
   public static String method730(int var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         if(var0 < 0) {
            return Integer.toString(var0, var1);
         } else {
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
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
