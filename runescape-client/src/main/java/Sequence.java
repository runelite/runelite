import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("m")
   int[] field1001;
   @ObfuscatedName("t")
   static int[] field1003;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = -2127741847
   )
   static int field1004;
   @ObfuscatedName("v")
   static NodeCache field1005 = new NodeCache(100);
   @ObfuscatedName("j")
   public int[] field1006;
   @ObfuscatedName("k")
   public static class170 field1007;
   @ObfuscatedName("y")
   public int[] field1008;
   @ObfuscatedName("u")
   public int[] field1009;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -903152619
   )
   public int field1010 = -1;
   @ObfuscatedName("l")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 127674323
   )
   public int field1012 = 5;
   @ObfuscatedName("ds")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1826526429
   )
   public int field1014 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1857107017
   )
   public int field1015 = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 832577809
   )
   @Export("maxLoops")
   public int maxLoops = 99;
   @ObfuscatedName("b")
   @Export("stretches")
   public boolean stretches = false;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 566714973
   )
   public int field1018 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 906691555
   )
   @Export("replyMode")
   public int replyMode = 2;
   @ObfuscatedName("f")
   public static class170 field1020;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -516235403
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating = -1;
   @ObfuscatedName("c")
   static NodeCache field1023 = new NodeCache(64);
   @ObfuscatedName("nj")
   @ObfuscatedGetter(
      intValue = -1914247997
   )
   static int field1024;
   @ObfuscatedName("qs")
   @Export("bufferProvider")
   public static BufferProvider bufferProvider;
   @ObfuscatedName("q")
   public static class170 field1028;

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1468336560"
   )
   static final void method896() {
      Client.field324.method2828(21);
      Client.field324.method2556(0);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "242732378"
   )
   public Model method898(Model var1, int var2) {
      var2 = this.field1006[var2];
      Frames var3 = Client.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method2402(true);
      } else {
         Model var4 = var1.method2402(!var3.method2357(var2));
         var4.method2428(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LModel;IIB)LModel;",
      garbageValue = "0"
   )
   Model method899(Model var1, int var2, int var3) {
      var2 = this.field1006[var2];
      Frames var4 = Client.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var4) {
         return var1.method2402(true);
      } else {
         Model var5 = var1.method2402(!var4.method2357(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2373();
         } else if(var3 == 2) {
            var5.method2372();
         } else if(var3 == 3) {
            var5.method2371();
         }

         var5.method2428(var4, var2);
         if(var3 == 1) {
            var5.method2371();
         } else if(var3 == 2) {
            var5.method2372();
         } else if(var3 == 3) {
            var5.method2373();
         }

         return var5;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "-1026211298"
   )
   Model method900(Model var1, int var2) {
      var2 = this.field1006[var2];
      Frames var3 = Client.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2364(true);
      } else {
         Model var4 = var1.method2364(!var3.method2357(var2));
         var4.method2428(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "1959529589"
   )
   public Model method902(Model var1, int var2) {
      int var3 = this.field1006[var2];
      Frames var4 = Client.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method2402(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field1001 != null && var2 < this.field1001.length) {
            var6 = this.field1001[var2];
            var5 = Client.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(null != var5 && var6 != '\uffff') {
            var7 = var1.method2402(!var4.method2357(var3) & !var5.method2357(var6));
            var7.method2428(var4, var3);
            var7.method2428(var5, var6);
            return var7;
         } else {
            var7 = var1.method2402(!var4.method2357(var3));
            var7.method2428(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "585163146"
   )
   void method913(Buffer var1) {
      while(true) {
         int var2 = var1.method2571();
         if(var2 == 0) {
            return;
         }

         this.method919(var1, var2);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LModel;ILSequence;IB)LModel;",
      garbageValue = "115"
   )
   public Model method917(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.field1006[var2];
      Frames var5 = Client.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method898(var1, var4);
      } else {
         var4 = var3.field1006[var4];
         Frames var6 = Client.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(var6 == null) {
            var7 = var1.method2402(!var5.method2357(var2));
            var7.method2428(var5, var2);
            return var7;
         } else {
            var7 = var1.method2402(!var5.method2357(var2) & !var6.method2357(var4));
            var7.method2433(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;IS)V",
      garbageValue = "17257"
   )
   void method919(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2691();
         this.field1008 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1008[var4] = var1.method2691();
         }

         this.field1006 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1006[var4] = var1.method2691();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1006[var4] += var1.method2691() << 16;
         }
      } else if(var2 == 2) {
         this.field1010 = var1.method2691();
      } else if(var2 == 3) {
         var3 = var1.method2571();
         this.interleaveLeave = new int[var3 + 1];

         for(var4 = 0; var4 < var3; ++var4) {
            this.interleaveLeave[var4] = var1.method2571();
         }

         this.interleaveLeave[var3] = 9999999;
      } else if(var2 == 4) {
         this.stretches = true;
      } else if(var2 == 5) {
         this.field1012 = var1.method2571();
      } else if(var2 == 6) {
         this.field1014 = var1.method2691();
      } else if(var2 == 7) {
         this.field1015 = var1.method2691();
      } else if(var2 == 8) {
         this.maxLoops = var1.method2571();
      } else if(var2 == 9) {
         this.precedenceAnimating = var1.method2571();
      } else if(var2 == 10) {
         this.field1018 = var1.method2571();
      } else if(var2 == 11) {
         this.replyMode = var1.method2571();
      } else if(var2 == 12) {
         var3 = var1.method2571();
         this.field1001 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1001[var4] = var1.method2691();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1001[var4] += var1.method2691() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.method2571();
         this.field1009 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1009[var4] = var1.method2575();
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "469638137"
   )
   void method932() {
      if(this.precedenceAnimating == -1) {
         if(this.interleaveLeave != null) {
            this.precedenceAnimating = 2;
         } else {
            this.precedenceAnimating = 0;
         }
      }

      if(this.field1018 == -1) {
         if(this.interleaveLeave != null) {
            this.field1018 = 2;
         } else {
            this.field1018 = 0;
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass139;Ljava/awt/Component;III)Lclass59;",
      garbageValue = "-1886471333"
   )
   public static final class59 method933(class139 var0, Component var1, int var2, int var3) {
      if(class59.field1249 == 0) {
         throw new IllegalStateException();
      } else if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class72 var4 = new class72();
            var4.field1253 = new int[(class59.field1238?2:1) * 256];
            var4.field1240 = var3;
            var4.vmethod1565(var1);
            var4.field1233 = 1024 + (var3 & -1024);
            if(var4.field1233 > 16384) {
               var4.field1233 = 16384;
            }

            var4.vmethod1566(var4.field1233);
            if(class59.field1235 > 0 && class59.field1236 == null) {
               class59.field1236 = new class75();
               class59.field1236.field1412 = var0;
               var0.method2918(class59.field1236, class59.field1235);
            }

            if(null != class59.field1236) {
               if(null != class59.field1236.field1407[var2]) {
                  throw new IllegalArgumentException();
               }

               class59.field1236.field1407[var2] = var4;
            }

            return var4;
         } catch (Throwable var5) {
            return new class59();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass69;B)V",
      garbageValue = "-33"
   )
   static final void method934(class69 var0) {
      var0.field1325 = false;
      if(null != var0.field1322) {
         var0.field1322.field1321 = 0;
      }

      for(class69 var1 = var0.vmethod3751(); var1 != null; var1 = var0.vmethod3755()) {
         method934(var1);
      }

   }
}
