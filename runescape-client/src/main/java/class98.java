import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("TextureProvider")
public class class98 implements class95 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -939840513
   )
   int field1685 = 0;
   @ObfuscatedName("w")
   class202 field1686 = new class202();
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 686905491
   )
   int field1687;
   @ObfuscatedName("m")
   class86[] field1688;
   @ObfuscatedName("g")
   double field1689 = 1.0D;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1519943111
   )
   int field1690 = 128;
   @ObfuscatedName("j")
   class170 field1692;
   @ObfuscatedName("t")
   public static String field1693;
   @ObfuscatedName("z")
   static int[] field1694;
   @ObfuscatedName("ak")
   static class81[] field1699;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method2250(double var1) {
      this.field1689 = var1;
      this.method2256();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "610189187"
   )
   @Export("load")
   public int[] vmethod2252(int var1) {
      class86 var2 = this.field1688[var1];
      if(null != var2) {
         if(var2.field1524 != null) {
            this.field1686.method3878(var2);
            var2.field1515 = true;
            return var2.field1524;
         }

         boolean var3 = var2.method1976(this.field1689, this.field1690, this.field1692);
         if(var3) {
            if(this.field1685 == 0) {
               class86 var4 = (class86)this.field1686.method3881();
               var4.method1977();
            } else {
               --this.field1685;
            }

            this.field1686.method3878(var2);
            var2.field1515 = true;
            return var2.field1524;
         }
      }

      return null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-601094714"
   )
   public int vmethod2253(int var1) {
      return this.field1688[var1] != null?this.field1688[var1].field1516:0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "46"
   )
   public boolean vmethod2254(int var1) {
      return this.field1688[var1].field1517;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "38"
   )
   public boolean vmethod2255(int var1) {
      return this.field1690 == 64;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1833260926"
   )
   public void method2256() {
      for(int var1 = 0; var1 < this.field1688.length; ++var1) {
         if(null != this.field1688[var1]) {
            this.field1688[var1].method1977();
         }
      }

      this.field1686 = new class202();
      this.field1685 = this.field1687;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   public void method2257(int var1) {
      for(int var2 = 0; var2 < this.field1688.length; ++var2) {
         class86 var3 = this.field1688[var2];
         if(var3 != null && var3.field1522 != 0 && var3.field1515) {
            var3.method1978(var1);
            var3.field1515 = false;
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;IDI)V",
      garbageValue = "64"
   )
   public class98(class170 var1, class170 var2, int var3, double var4, int var6) {
      this.field1692 = var2;
      this.field1687 = var3;
      this.field1685 = this.field1687;
      this.field1689 = var4;
      this.field1690 = var6;
      int[] var7 = var1.method3353(0);
      int var8 = var7.length;
      this.field1688 = new class86[var1.method3317(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         class122 var10 = new class122(var1.method3304(0, var7[var9]));
         this.field1688[var7[var9]] = new class86(var10);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)I",
      garbageValue = "4"
   )
   static int method2274(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var10 + var5 * var1;
            if(var5 != var9 / var1) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1712129453"
   )
   public static int method2275() {
      return ++class143.field2221 - 1;
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIB)V",
      garbageValue = "68"
   )
   @Export("addMenuEntry")
   static final void method2276(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!client.field517) {
         if(client.field412 < 500) {
            client.field417[client.field412] = var0;
            client.field328[client.field412] = var1;
            client.field415[client.field412] = var2;
            client.field322[client.field412] = var3;
            client.field294[client.field412] = var4;
            client.field414[client.field412] = var5;
            ++client.field412;
         }

      }
   }
}
