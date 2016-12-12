import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public class class1 {
   @ObfuscatedName("e")
   public static Comparator field10 = new class7();
   @ObfuscatedName("f")
   public static Comparator field11;
   @ObfuscatedName("k")
   public static Comparator field12;
   @ObfuscatedName("g")
   public static Comparator field13;
   @ObfuscatedName("i")
   public final List field14;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-631122367"
   )
   public static void method8() {
      while(true) {
         Deque var1 = class183.field2726;
         class180 var0;
         synchronized(class183.field2726) {
            var0 = (class180)class183.field2725.method2357();
         }

         if(null == var0) {
            return;
         }

         var0.field2694.method3322(var0.field2693, (int)var0.hash, var0.field2691, false);
      }
   }

   static {
      new class0();
      field11 = new class5();
      field12 = new class6();
      field13 = new class3();
   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "1"
   )
   public class1(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.field14 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field14.add(new class2(var1, var5, var3));
      }

   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(LWidget;IIZI)V",
      garbageValue = "-1602114367"
   )
   static void method12(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2215 == 0) {
         var0.width = var0.field2219;
      } else if(var0.field2215 == 1) {
         var0.width = var1 - var0.field2219;
      } else if(var0.field2215 == 2) {
         var0.width = var1 * var0.field2219 >> 14;
      }

      if(var0.field2264 == 0) {
         var0.height = var0.field2220;
      } else if(var0.field2264 == 1) {
         var0.height = var2 - var0.field2220;
      } else if(var0.field2264 == 2) {
         var0.height = var2 * var0.field2220 >> 14;
      }

      if(var0.field2215 == 4) {
         var0.width = var0.field2225 * var0.height / var0.field2329;
      }

      if(var0.field2264 == 4) {
         var0.height = var0.field2329 * var0.width / var0.field2225;
      }

      if(Client.field456 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field421 = var0;
      }

      if(var3 && null != var0.field2317 && (var4 != var0.width || var0.height != var5)) {
         class18 var6 = new class18();
         var6.field187 = var0;
         var6.field188 = var0.field2317;
         Client.field475.method2376(var6);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Throwable;B)Ljava/lang/String;",
      garbageValue = "105"
   )
   static String method13(Throwable var0) throws IOException {
      String var1;
      if(var0 instanceof class101) {
         class101 var2 = (class101)var0;
         var1 = var2.field1637 + " | ";
         var0 = var2.field1641;
      } else {
         var1 = "";
      }

      StringWriter var12 = new StringWriter();
      PrintWriter var3 = new PrintWriter(var12);
      var0.printStackTrace(var3);
      var3.close();
      String var4 = var12.toString();
      BufferedReader var5 = new BufferedReader(new StringReader(var4));
      String var6 = var5.readLine();

      while(true) {
         while(true) {
            String var7 = var5.readLine();
            if(null == var7) {
               var1 = var1 + "| " + var6;
               return var1;
            }

            int var8 = var7.indexOf(40);
            int var9 = var7.indexOf(41, var8 + 1);
            if(var8 >= 0 && var9 >= 0) {
               String var10 = var7.substring(1 + var8, var9);
               int var11 = var10.indexOf(".java:");
               if(var11 >= 0) {
                  var10 = var10.substring(0, var11) + var10.substring(5 + var11);
                  var1 = var1 + var10 + ' ';
                  continue;
               }

               var7 = var7.substring(0, var8);
            }

            var7 = var7.trim();
            var7 = var7.substring(var7.lastIndexOf(32) + 1);
            var7 = var7.substring(var7.lastIndexOf(9) + 1);
            var1 = var1 + var7 + ' ';
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I[BLclass116;I)V",
      garbageValue = "1851799159"
   )
   static void method14(int var0, byte[] var1, class116 var2) {
      class180 var3 = new class180();
      var3.field2692 = 0;
      var3.hash = (long)var0;
      var3.field2691 = var1;
      var3.field2693 = var2;
      Deque var4 = class183.field2726;
      synchronized(class183.field2726) {
         class183.field2726.method2376(var3);
      }

      class104.method1975();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZB)V",
      garbageValue = "50"
   )
   public void method15(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field14, var1);
      } else {
         Collections.sort(this.field14, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2051119504"
   )
   public static void method16() {
      class187.field2777.reset();
   }
}
