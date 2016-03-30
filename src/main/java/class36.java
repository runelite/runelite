import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.Calendar;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class36 {
   @ObfuscatedName("z")
   static class173 field798;
   @ObfuscatedName("t")
   static int[] field800;
   @ObfuscatedName("p")
   static String[] field801;
   @ObfuscatedName("e")
   static int[] field802 = new int[5];
   @ObfuscatedName("y")
   static int[][] field803 = new int[5][5000];
   @ObfuscatedName("m")
   static int[] field804 = new int[1000];
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -965847201
   )
   static int field806 = 0;
   @ObfuscatedName("l")
   static class14[] field808 = new class14[50];
   @ObfuscatedName("s")
   static class173 field809;
   @ObfuscatedName("j")
   static Calendar field810 = Calendar.getInstance();
   @ObfuscatedName("q")
   static final String[] field811 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1736425689
   )
   static int field812 = 0;
   @ObfuscatedName("ni")
   @ObfuscatedGetter(
      intValue = -175477583
   )
   static int field813;
   @ObfuscatedName("c")
   static String[] field816 = new String[1000];

   @ObfuscatedName("w")
   public static class39 method759(int var0) {
      class39 var1 = (class39)class39.field886.method3771((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class39.field905.method3335(9, var0);
         var1 = new class39();
         var1.field889 = var0;
         if(null != var2) {
            var1.method798(new class119(var2));
         }

         var1.method788();
         class39.field886.method3773(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("dh")
   static String method763(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(client.field299 == 1) {
         var0 = var0 + "-wtrc";
      } else if(client.field299 == 2) {
         var0 = var0 + "-wtqa";
      } else if(client.field299 == 3) {
         var0 = var0 + "-wtwip";
      } else if(client.field299 == 5) {
         var0 = var0 + "-wti";
      } else if(client.field299 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(null != class93.field1604) {
         var3 = "/p=" + class93.field1604;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + client.field302 + "/a=" + class155.field2322 + var3 + "/";
   }

   @ObfuscatedName("x")
   public static class41 method764(int var0) {
      class41 var1 = (class41)class41.field981.method3771((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class41.field982.method3335(1, var0);
         var1 = new class41();
         if(var2 != null) {
            var1.method877(new class119(var2));
         }

         var1.method875();
         class41.field981.method3773(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("x")
   public static String method765(CharSequence var0) {
      long var3 = 0L;
      int var5 = var0.length();

      for(int var6 = 0; var6 < var5; ++var6) {
         var3 *= 37L;
         char var7 = var0.charAt(var6);
         if(var7 >= 65 && var7 <= 90) {
            var3 += (long)(1 + var7 - 65);
         } else if(var7 >= 97 && var7 <= 122) {
            var3 += (long)(var7 + 1 - 97);
         } else if(var7 >= 48 && var7 <= 57) {
            var3 += (long)(27 + var7 - 48);
         }

         if(var3 >= 177917621779460413L) {
            break;
         }
      }

      while(0L == var3 % 37L && var3 != 0L) {
         var3 /= 37L;
      }

      String var8 = class104.method2296(var3);
      if(var8 == null) {
         var8 = "";
      }

      return var8;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1842846177"
   )
   static void method766() {
      int var0 = class144.field2226;
      int var1 = class144.field2221;
      int var2 = class16.field252 - class15.field235 - var0;
      int var3 = class90.field1568 - class15.field233 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = client.field294.method3039();
            int var5 = 0;
            int var6 = 0;
            if(var4 == class33.field773) {
               Insets var7 = class33.field773.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class90.field1568);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class16.field252, var1);
            }

            if(var2 > 0) {
               var9.fillRect(var5 + class16.field252 - var2, var6, var2, class90.field1568);
            }

            if(var3 > 0) {
               var9.fillRect(var5, class90.field1568 + var6 - var3, class16.field252, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }
}
