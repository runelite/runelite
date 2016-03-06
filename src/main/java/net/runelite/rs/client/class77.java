package net.runelite.rs.client;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bu")
public abstract class class77 {
   @ObfuscatedName("m")
   public Image field1399;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -734183465
   )
   public int field1400;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -788494945
   )
   int field1401;
   @ObfuscatedName("a")
   public int[] field1402;
   @ObfuscatedName("no")
   static class56 field1403;

   @ObfuscatedName("j")
   abstract void vmethod1841(int var1, int var2, Component var3);

   @ObfuscatedName("a")
   public abstract void vmethod1847(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("l")
   public abstract void vmethod1842(Graphics var1, int var2, int var3);

   @ObfuscatedName("j")
   public static void method1665(class166 var0, class166 var1, class166 var2, class166 var3) {
      class51.field1162 = var0;
      class172.field2848 = var1;
      class172.field2752 = var2;
      class212.field3141 = var3;
      class172.field2757 = new class172[class51.field1162.method3246()][];
      class172.field2750 = new boolean[class51.field1162.method3246()];
   }

   @ObfuscatedName("ai")
   public final void method1667() {
      class79.method1768(this.field1402, this.field1400, this.field1401);
   }

   @ObfuscatedName("a")
   static boolean method1673(String var0, int var1) {
      return class0.method2(var0, var1, "openjs");
   }

   @ObfuscatedName("dg")
   static void method1674(String var0) {
      class95.field1639 = var0;

      try {
         String var1 = client.field284.getParameter(class189.field3059.field3062);
         String var2 = client.field284.getParameter(class189.field3060.field3062);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            var3 = var3 + "; Expires=" + class165.method3208(class109.method2381() + 94608000000L) + "; Max-Age=" + 94608000L;
         }

         class131.method2775(client.field284, "document.cookie=\"" + var3 + "\"");
      } catch (Throwable var4) {
         ;
      }

   }
}
