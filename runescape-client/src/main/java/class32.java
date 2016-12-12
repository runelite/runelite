import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class32 {
   @ObfuscatedName("h")
   static Widget field718;
   @ObfuscatedName("n")
   static int[][] field719 = new int[5][5000];
   @ObfuscatedName("a")
   static int[] field720 = new int[1000];
   @ObfuscatedName("q")
   @Export("chatboxSegments")
   static String[] chatboxSegments = new String[1000];
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1305276047
   )
   static int field722 = 0;
   @ObfuscatedName("k")
   static String[] field724;
   @ObfuscatedName("l")
   static Calendar field725 = Calendar.getInstance();
   @ObfuscatedName("c")
   static final String[] field726 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("g")
   static int[] field727 = new int[5];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1606222909
   )
   static int field728 = 0;
   @ObfuscatedName("v")
   static class11[] field732 = new class11[50];

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIZB)V",
      garbageValue = "6"
   )
   static void method654(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(null != var6 && var6.parentId == var1) {
            class1.method12(var6, var2, var3, var4);
            Friend.method167(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class2.method18(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "8"
   )
   static final void method656(int var0, int var1) {
      if(class212.method3870(var0)) {
         class190.method3419(Widget.widgets[var0], var1);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIIB)V",
      garbageValue = "121"
   )
   static void method657(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method657(var0, var1, var2, var5 - 1);
         method657(var0, var1, var5 + 1, var3);
      }

   }
}
