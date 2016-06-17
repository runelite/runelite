import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
public class class52 extends class204 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1813950809
   )
   public static int field1129;
   @ObfuscatedName("j")
   public static class193 field1130 = new class193(64);
   @ObfuscatedName("b")
   public static class167 field1131;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1827583609
   )
   public int field1132 = 0;
   @ObfuscatedName("no")
   static class55 field1134;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "-50"
   )
   void method1067(class119 var1) {
      while(true) {
         int var2 = var1.method2514();
         if(var2 == 0) {
            return;
         }

         this.method1076(var1, var2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)[Lclass153;",
      garbageValue = "892266018"
   )
   public static class153[] method1068() {
      return new class153[]{class153.field2259, class153.field2267, class153.field2257, class153.field2258};
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "27104819"
   )
   static void method1069() {
      for(class3 var0 = (class3)client.field448.method3799(); var0 != null; var0 = (class3)client.field448.method3800()) {
         int var1 = var0.field60;
         if(class84.method1909(var1)) {
            boolean var2 = true;
            class173[] var3 = class173.field2750[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].field2741;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.field3113;
               class173 var5 = class161.method3205(var4);
               if(null != var5) {
                  class4.method37(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "([Lclass173;IIIZI)V",
      garbageValue = "85033207"
   )
   static void method1074(class173[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         class173 var6 = var0[var5];
         if(var6 != null && var1 == var6.field2777) {
            class16.method176(var6, var2, var3, var4);
            client.method548(var6, var2, var3);
            if(var6.field2863 > var6.field2771 - var6.field2763) {
               var6.field2863 = var6.field2771 - var6.field2763;
            }

            if(var6.field2863 < 0) {
               var6.field2863 = 0;
            }

            if(var6.field2770 > var6.field2772 - var6.field2764) {
               var6.field2770 = var6.field2772 - var6.field2764;
            }

            if(var6.field2770 < 0) {
               var6.field2770 = 0;
            }

            if(var6.field2833 == 0) {
               class9.method121(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "845130728"
   )
   void method1076(class119 var1, int var2) {
      if(var2 == 5) {
         this.field1132 = var1.method2516();
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1011250026"
   )
   public static int method1080(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }
}
