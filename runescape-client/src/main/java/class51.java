import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class51 extends CacheableNode {
   @ObfuscatedName("e")
   public static class170 field1102;
   @ObfuscatedName("t")
   public int[] field1104;
   @ObfuscatedName("o")
   String field1105 = "";
   @ObfuscatedName("u")
   public static NodeCache field1106 = new NodeCache(20);
   @ObfuscatedName("ek")
   static SpritePixels field1107;
   @ObfuscatedName("g")
   public static NodeCache field1108 = new NodeCache(64);
   @ObfuscatedName("n")
   @Export("spriteCache")
   public static NodeCache spriteCache = new NodeCache(64);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1472436209
   )
   public int field1111 = 16777215;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1156760351
   )
   public int field1112 = 70;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -501700173
   )
   int field1113 = -1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1818745077
   )
   int field1114 = -1;
   @ObfuscatedName("h")
   public static class170 field1115;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1623354783
   )
   int field1116 = -1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 527415039
   )
   public int field1117 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2145818395
   )
   public int field1118 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1935126441
   )
   public int field1119 = -1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 197708975
   )
   int field1120 = -1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -381495385
   )
   public int field1121 = -1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1898410451
   )
   public int field1122 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -80118965
   )
   int field1123 = -1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1388883291
   )
   int field1124 = -1;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 888540503
   )
   int field1125 = -1;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 978541859
   )
   static int field1126;
   @ObfuscatedName("i")
   public static class170 field1127;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-74"
   )
   void method1035(Buffer var1) {
      while(true) {
         int var2 = var1.method2544();
         if(var2 == 0) {
            return;
         }

         this.method1051(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)Lclass51;",
      garbageValue = "-2338"
   )
   public final class51 method1037() {
      int var1 = -1;
      if(this.field1124 != -1) {
         var1 = class9.method127(this.field1124);
      } else if(this.field1125 != -1) {
         var1 = class179.widgetSettings[this.field1125];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field1104.length - 1) {
         var2 = this.field1104[var1];
      } else {
         var2 = this.field1104[this.field1104.length - 1];
      }

      return var2 != -1?class180.method3491(var2):null;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-702545527"
   )
   public String method1038(int var1) {
      String var2 = this.field1105;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         String var4 = var2.substring(0, var3);
         String var5 = Integer.toString(var1);
         var2 = var4 + var5 + var2.substring(2 + var3);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "9"
   )
   public SpritePixels method1039() {
      if(this.field1113 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1113);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class1.method13(field1115, this.field1113, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field1113);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-2137534889"
   )
   public SpritePixels method1040() {
      if(this.field1114 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1114);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class1.method13(field1115, this.field1114, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field1114);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "1748540402"
   )
   public SpritePixels method1041() {
      if(this.field1120 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1120);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class1.method13(field1115, this.field1120, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field1120);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-1652358405"
   )
   public SpritePixels method1042() {
      if(this.field1116 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1116);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class1.method13(field1115, this.field1116, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field1116);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-1"
   )
   void method1051(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1123 = var1.method2617();
      } else if(var2 == 2) {
         this.field1111 = var1.method2548();
      } else if(var2 == 3) {
         this.field1113 = var1.method2617();
      } else if(var2 == 4) {
         this.field1120 = var1.method2617();
      } else if(var2 == 5) {
         this.field1114 = var1.method2617();
      } else if(var2 == 6) {
         this.field1116 = var1.method2617();
      } else if(var2 == 7) {
         this.field1117 = var1.method2547();
      } else if(var2 == 8) {
         this.field1105 = var1.method2553();
      } else if(var2 == 9) {
         this.field1112 = var1.method2546();
      } else if(var2 == 10) {
         this.field1118 = var1.method2547();
      } else if(var2 == 11) {
         this.field1119 = 0;
      } else if(var2 == 12) {
         this.field1121 = var1.method2544();
      } else if(var2 == 13) {
         this.field1122 = var1.method2547();
      } else if(var2 == 14) {
         this.field1119 = var1.method2546();
      } else if(var2 == 17 || var2 == 18) {
         this.field1124 = var1.method2546();
         if(this.field1124 == '\uffff') {
            this.field1124 = -1;
         }

         this.field1125 = var1.method2546();
         if(this.field1125 == '\uffff') {
            this.field1125 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.method2546();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         int var4 = var1.method2544();
         this.field1104 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field1104[var5] = var1.method2546();
            if(this.field1104[var5] == '\uffff') {
               this.field1104[var5] = -1;
            }
         }

         this.field1104[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "668396833"
   )
   public static int method1057(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var2 + var0) / var1 - var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Lclass227;",
      garbageValue = "103"
   )
   public class227 method1059() {
      if(this.field1123 == -1) {
         return null;
      } else {
         class227 var1 = (class227)field1106.get((long)this.field1123);
         if(null != var1) {
            return var1;
         } else {
            var1 = class48.method1000(field1115, field1102, this.field1123, 0);
            if(null != var1) {
               field1106.put(var1, (long)this.field1123);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-280765363"
   )
   static long method1060() {
      try {
         URL var0 = new URL(class118.method2485("services", false) + "m=accountappeal/login.ws");
         URLConnection var1 = var0.openConnection();
         var1.setRequestProperty("connection", "close");
         var1.setDoInput(true);
         var1.setDoOutput(true);
         var1.setConnectTimeout(5000);
         OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
         var2.write("data1=req");
         var2.flush();
         InputStream var3 = var1.getInputStream();
         Buffer var4 = new Buffer(new byte[1000]);

         do {
            int var5 = var3.read(var4.payload, var4.offset, 1000 - var4.offset);
            if(var5 == -1) {
               var4.offset = 0;
               long var8 = var4.method2566();
               return var8;
            }

            var4.offset += var5;
         } while(var4.offset < 1000);

         return 0L;
      } catch (Exception var7) {
         return 0L;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "55"
   )
   static final int method1065(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass170;IS)LModIcon;",
      garbageValue = "15758"
   )
   public static ModIcon method1069(class170 var0, int var1) {
      return !class26.method590(var0, var1)?null:class12.method157();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;I)[LModIcon;",
      garbageValue = "-1132381628"
   )
   public static ModIcon[] method1072(class170 var0, String var1, String var2) {
      int var3 = var0.method3304(var1);
      int var4 = var0.method3305(var3, var2);
      return class128.method2833(var0, var3, var4);
   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(IIII)LWidgetNode;",
      garbageValue = "-230636068"
   )
   static final WidgetNode method1073(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.field70 = var2;
      Client.componentTable.method3813(var3, (long)var0);
      class24.method567(var1);
      Widget var4 = class173.method3412(var0);
      class32.method673(var4);
      if(Client.field464 != null) {
         class32.method673(Client.field464);
         Client.field464 = null;
      }

      class43.method895();
      class130.method2850(Widget.widgets[var0 >> 16], var4, false);
      class10.method133(var1);
      if(Client.widgetRoot != -1) {
         int var5 = Client.widgetRoot;
         if(class14.method172(var5)) {
            class49.method1007(Widget.widgets[var5], 1);
         }
      }

      return var3;
   }
}
