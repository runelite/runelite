import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
@Implements("XClanMember")
public class class24 extends class207 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -715910007
   )
   @Export("world")
   int field620;
   @ObfuscatedName("l")
   String field621;
   @ObfuscatedName("i")
   @Export("rank")
   byte field622;
   @ObfuscatedName("bw")
   static class167 field623;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1435693125
   )
   static int field624;
   @ObfuscatedName("m")
   static class78 field625;
   @ObfuscatedName("j")
   @Export("username")
   String field626;
   @ObfuscatedName("nq")
   static class74 field628;

   @ObfuscatedName("l")
   static String method592(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("l")
   static final void method593(class121 var0, int var1) {
      int var2 = var0.field1998;
      class32.field756 = 0;
      class8.method100(var0);
      class35.method738(var0);
      if(var0.field1998 - var2 != var1) {
         throw new RuntimeException(var0.field1998 - var2 + " " + var1);
      }
   }

   @ObfuscatedName("x")
   static final byte[] method594(byte[] var0) {
      class118 var1 = new class118(var0);
      int var2 = var1.method2453();
      int var3 = var1.method2458();
      if(var3 < 0 || 0 != class166.field2694 && var3 > class166.field2694) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var6 = new byte[var3];
         var1.method2534(var6, 0, var3);
         return var6;
      } else {
         int var4 = var1.method2458();
         if(var4 >= 0 && (0 == class166.field2694 || var4 <= class166.field2694)) {
            byte[] var5 = new byte[var4];
            if(var2 == 1) {
               class116.method2404(var5, var4, var0, 9);
            } else {
               class166.field2692.method2401(var1, var5);
            }

            return var5;
         } else {
            throw new RuntimeException();
         }
      }
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(Lclass172;IIZI)V",
      garbageValue = "118219901"
   )
   static void method595(class172 var0, int var1, int var2, boolean var3) {
      int var4 = var0.field2774;
      int var5 = var0.field2890;
      if(0 == var0.field2766) {
         var0.field2774 = var0.field2781;
      } else if(1 == var0.field2766) {
         var0.field2774 = var1 - var0.field2781;
      } else if(var0.field2766 == 2) {
         var0.field2774 = var0.field2781 * var1 >> 14;
      }

      if(0 == var0.field2767) {
         var0.field2890 = var0.field2771;
      } else if(var0.field2767 == 1) {
         var0.field2890 = var2 - var0.field2771;
      } else if(var0.field2767 == 2) {
         var0.field2890 = var2 * var0.field2771 >> 14;
      }

      if(4 == var0.field2766) {
         var0.field2774 = var0.field2890 * var0.field2776 / var0.field2777;
      }

      if(4 == var0.field2767) {
         var0.field2890 = var0.field2774 * var0.field2777 / var0.field2776;
      }

      if(client.field458 && var0.field2849 == 0) {
         if(var0.field2890 < 5 && var0.field2774 < 5) {
            var0.field2890 = 5;
            var0.field2774 = 5;
         } else {
            if(var0.field2890 <= 0) {
               var0.field2890 = 5;
            }

            if(var0.field2774 <= 0) {
               var0.field2774 = 5;
            }
         }
      }

      if(1337 == var0.field2763) {
         client.field460 = var0;
      }

      if(var3 && null != var0.field2879 && (var4 != var0.field2774 || var5 != var0.field2890)) {
         class0 var6 = new class0();
         var6.field2 = var0;
         var6.field5 = var0.field2879;
         client.field465.method3768(var6);
      }

   }
}
