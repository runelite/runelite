import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("l")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("e")
   static class170 field988;
   @ObfuscatedName("n")
   static class170 field989;
   @ObfuscatedName("t")
   static NodeCache field990 = new NodeCache(64);
   @ObfuscatedName("v")
   static NodeCache field991 = new NodeCache(100);
   @ObfuscatedName("b")
   public int[] field992;
   @ObfuscatedName("m")
   int[] field993;
   @ObfuscatedName("k")
   public int[] field994;
   @ObfuscatedName("c")
   public int[] field995;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 228245973
   )
   public int field996 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 119712801
   )
   public int field997 = -1;
   @ObfuscatedName("h")
   @Export("stretches")
   public boolean stretches = false;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -112482299
   )
   public int field1000 = -1;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2113532637
   )
   public int field1001 = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 329117495
   )
   @Export("maxLoops")
   public int maxLoops = 99;
   @ObfuscatedName("f")
   static class170 field1003;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1931900135
   )
   public int field1005 = 5;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 817859469
   )
   @Export("replyMode")
   public int replyMode = 2;
   @ObfuscatedName("qi")
   @ObfuscatedGetter(
      intValue = -1526994763
   )
   protected static int field1010;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 982864337
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating = -1;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1870298340"
   )
   void method879(Buffer var1) {
      while(true) {
         int var2 = var1.method2656();
         if(var2 == 0) {
            return;
         }

         this.method880(var1, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "2105517875"
   )
   void method880(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2535();
         this.field994 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field994[var4] = var1.method2535();
         }

         this.field992 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field992[var4] = var1.method2535();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field992[var4] += var1.method2535() << 16;
         }
      } else if(var2 == 2) {
         this.field996 = var1.method2535();
      } else if(var2 == 3) {
         var3 = var1.method2656();
         this.interleaveLeave = new int[var3 + 1];

         for(var4 = 0; var4 < var3; ++var4) {
            this.interleaveLeave[var4] = var1.method2656();
         }

         this.interleaveLeave[var3] = 9999999;
      } else if(var2 == 4) {
         this.stretches = true;
      } else if(var2 == 5) {
         this.field1005 = var1.method2656();
      } else if(var2 == 6) {
         this.field1000 = var1.method2535();
      } else if(var2 == 7) {
         this.field1001 = var1.method2535();
      } else if(var2 == 8) {
         this.maxLoops = var1.method2656();
      } else if(var2 == 9) {
         this.precedenceAnimating = var1.method2656();
      } else if(var2 == 10) {
         this.field997 = var1.method2656();
      } else if(var2 == 11) {
         this.replyMode = var1.method2656();
      } else if(var2 == 12) {
         var3 = var1.method2656();
         this.field993 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field993[var4] = var1.method2535();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field993[var4] += var1.method2535() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.method2656();
         this.field995 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field995[var4] = var1.method2537();
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "44"
   )
   void method881() {
      if(this.precedenceAnimating == -1) {
         if(null != this.interleaveLeave) {
            this.precedenceAnimating = 2;
         } else {
            this.precedenceAnimating = 0;
         }
      }

      if(this.field997 == -1) {
         if(this.interleaveLeave != null) {
            this.field997 = 2;
         } else {
            this.field997 = 0;
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "-2036701462"
   )
   public Model method882(Model var1, int var2) {
      var2 = this.field992[var2];
      Frames var3 = class54.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2353(true);
      } else {
         Model var4 = var1.method2353(!var3.method2313(var2));
         var4.method2325(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LModel;IIB)LModel;",
      garbageValue = "0"
   )
   Model method883(Model var1, int var2, int var3) {
      var2 = this.field992[var2];
      Frames var4 = class54.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var4 == null) {
         return var1.method2353(true);
      } else {
         Model var5 = var1.method2353(!var4.method2313(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2330();
         } else if(var3 == 2) {
            var5.method2331();
         } else if(var3 == 3) {
            var5.method2328();
         }

         var5.method2325(var4, var2);
         if(var3 == 1) {
            var5.method2328();
         } else if(var3 == 2) {
            var5.method2331();
         } else if(var3 == 3) {
            var5.method2330();
         }

         return var5;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "393354646"
   )
   Model method884(Model var1, int var2) {
      var2 = this.field992[var2];
      Frames var3 = class54.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2317(true);
      } else {
         Model var4 = var1.method2317(!var3.method2313(var2));
         var4.method2325(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LModel;ILSequence;IB)LModel;",
      garbageValue = "91"
   )
   public Model method885(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.field992[var2];
      Frames var5 = class54.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method882(var1, var4);
      } else {
         var4 = var3.field992[var4];
         Frames var6 = class54.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(null == var6) {
            var7 = var1.method2353(!var5.method2313(var2));
            var7.method2325(var5, var2);
            return var7;
         } else {
            var7 = var1.method2353(!var5.method2313(var2) & !var6.method2313(var4));
            var7.method2326(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LModel;IB)LModel;",
      garbageValue = "84"
   )
   public Model method889(Model var1, int var2) {
      int var3 = this.field992[var2];
      Frames var4 = class54.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(null == var4) {
         return var1.method2353(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field993 != null && var2 < this.field993.length) {
            var6 = this.field993[var2];
            var5 = class54.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(null != var5 && var6 != '\uffff') {
            var7 = var1.method2353(!var4.method2313(var3) & !var5.method2313(var6));
            var7.method2325(var4, var3);
            var7.method2325(var5, var6);
            return var7;
         } else {
            var7 = var1.method2353(!var4.method2313(var3));
            var7.method2325(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IZZZS)Lclass171;",
      garbageValue = "-18588"
   )
   static class171 method891(int var0, boolean var1, boolean var2, boolean var3) {
      class137 var4 = null;
      if(class152.field2281 != null) {
         var4 = new class137(var0, class152.field2281, class23.field606[var0], 1000000);
      }

      return new class171(var4, class59.field1228, var0, var1, var2, var3);
   }

   @ObfuscatedName("f")
   public static String method918(long var0) {
      class114.field2009.setTime(new Date(var0));
      int var2 = class114.field2009.get(7);
      int var3 = class114.field2009.get(5);
      int var4 = class114.field2009.get(2);
      int var5 = class114.field2009.get(1);
      int var6 = class114.field2009.get(11);
      int var7 = class114.field2009.get(12);
      int var8 = class114.field2009.get(13);
      return class114.field2008[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class114.field2015[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass170;I)V",
      garbageValue = "-1984575795"
   )
   public static void method920(class170 var0) {
      class52.field1131 = var0;
   }
}
