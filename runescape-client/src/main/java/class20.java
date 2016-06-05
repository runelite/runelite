import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class20 implements class112 {
   @ObfuscatedName("t")
   static final class20 field569 = new class20(0);
   @ObfuscatedName("h")
   static final class20 field570 = new class20(3);
   @ObfuscatedName("i")
   static final class20 field571 = new class20(1);
   @ObfuscatedName("g")
   static final class20 field573 = new class20(2);
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1210689869
   )
   final int field574;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-2020023785"
   )
   static String method543() {
      String var0 = "";

      class35 var2;
      for(Iterator var1 = class11.field180.iterator(); var1.hasNext(); var0 = var0 + var2.field778 + ':' + var2.field784 + '\n') {
         var2 = (class35)var1.next();
      }

      return var0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-59"
   )
   public int vmethod3145() {
      return this.field574;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class20(int var1) {
      this.field574 = var1;
   }

   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)V",
      garbageValue = "-669274506"
   )
   static void method547(class173 var0) {
      if(var0.field2908 == client.field468) {
         client.field396[var0.field2813] = true;
      }

   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "([Lclass173;IIIZS)V",
      garbageValue = "25590"
   )
   static void method548(class173[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         class173 var6 = var0[var5];
         if(var6 != null && var1 == var6.field2795) {
            class191.method3708(var6, var2, var3, var4);
            class173.method3410(var6, var2, var3);
            if(var6.field2835 > var6.field2894 - var6.field2791) {
               var6.field2835 = var6.field2894 - var6.field2791;
            }

            if(var6.field2835 < 0) {
               var6.field2835 = 0;
            }

            if(var6.field2861 > var6.field2823 - var6.field2792) {
               var6.field2861 = var6.field2823 - var6.field2792;
            }

            if(var6.field2861 < 0) {
               var6.field2861 = 0;
            }

            if(var6.field2778 == 0) {
               class46.method935(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2"
   )
   public static void method549(int var0) {
      class183.field2981 = 1;
      class24.field614 = null;
      class142.field2204 = -1;
      class183.field2977 = -1;
      class151.field2286 = 0;
      class29.field694 = false;
      class183.field2980 = var0;
   }
}
