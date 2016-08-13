import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
public class class114 {
   @ObfuscatedName("qy")
   protected static java.awt.Frame field2013;
   @ObfuscatedName("r")
   static Calendar field2014;
   @ObfuscatedName("g")
   static final String[] field2015 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("l")
   static final String[][] field2017 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIZI)Ljava/lang/String;",
      garbageValue = "1744466502"
   )
   static String method2539(int var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         if(var2 && var0 >= 0) {
            int var3 = 2;

            for(int var4 = var0 / var1; var4 != 0; ++var3) {
               var4 /= var1;
            }

            char[] var8 = new char[var3];
            var8[0] = 43;

            for(int var5 = var3 - 1; var5 > 0; --var5) {
               int var6 = var0;
               var0 /= var1;
               int var7 = var6 - var1 * var0;
               if(var7 >= 10) {
                  var8[var5] = (char)(87 + var7);
               } else {
                  var8[var5] = (char)(var7 + 48);
               }
            }

            return new String(var8);
         } else {
            return Integer.toString(var0, var1);
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)LFileOnDisk;",
      garbageValue = "-2133949869"
   )
   public static FileOnDisk method2540(String var0, String var1, boolean var2) {
      File var3 = new File(class152.field2300, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var11 = new FileOnDisk(var3, "rw", 10000L);
            return var11;
         } catch (IOException var10) {
            ;
         }
      }

      String var4 = "";
      if(XItemContainer.field227 == 33) {
         var4 = "_rc";
      } else if(XItemContainer.field227 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(WidgetNode.field67, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var9) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var8) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1716578301"
   )
   public static void method2542(Component var0) {
      var0.addMouseListener(class143.mouse);
      var0.addMouseMotionListener(class143.mouse);
      var0.addFocusListener(class143.mouse);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "260409439"
   )
   static int method2543(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      return null != class174.field2780 && class174.field2780.hash == var2?1 + class159.field2368.offset * 99 / (class159.field2368.payload.length - class174.field2780.field2793):0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "40"
   )
   static final void method2545(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var2 + var0; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class232.field3275[0][var5][var4] = 127;
               if(var5 == var0 && var5 > 0) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][var5 - 1][var4];
               }

               if(var2 + var0 == var5 && var5 < 103) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][1 + var5][var4];
               }

               if(var1 == var4 && var4 > 0) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var3 + var1 && var4 < 103) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][var5][1 + var4];
               }
            }
         }
      }

   }

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2014 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }
}
