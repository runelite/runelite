import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1332493061
   )
   public int field993 = -1;
   @ObfuscatedName("d")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -830972139
   )
   @Export("replyMode")
   public int replyMode = 2;
   @ObfuscatedName("i")
   static NodeCache field996 = new NodeCache(100);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1946894293
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating = -1;
   @ObfuscatedName("l")
   int[] field998;
   @ObfuscatedName("m")
   public int[] field999;
   @ObfuscatedName("p")
   public int[] field1000;
   @ObfuscatedName("b")
   public int[] field1001;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -306966021
   )
   public int field1002 = -1;
   @ObfuscatedName("r")
   public static class170 field1003;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -357025511
   )
   public int field1004 = 5;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 822315817
   )
   public int field1005 = -1;
   @ObfuscatedName("v")
   @Export("stretches")
   public boolean stretches = false;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1386799239
   )
   @Export("maxLoops")
   public int maxLoops = 99;
   @ObfuscatedName("j")
   public static class170 field1008;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 940233773
   )
   public int field1009 = -1;
   @ObfuscatedName("z")
   static NodeCache field1010 = new NodeCache(64);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "70"
   )
   void method861(Buffer var1) {
      while(true) {
         int var2 = var1.method2556();
         if(var2 == 0) {
            return;
         }

         this.method862(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1845470262"
   )
   void method862(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2551();
         this.field999 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field999[var4] = var1.method2551();
         }

         this.field1001 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1001[var4] = var1.method2551();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1001[var4] += var1.method2551() << 16;
         }
      } else if(var2 == 2) {
         this.field1002 = var1.method2551();
      } else if(var2 == 3) {
         var3 = var1.method2556();
         this.interleaveLeave = new int[var3 + 1];

         for(var4 = 0; var4 < var3; ++var4) {
            this.interleaveLeave[var4] = var1.method2556();
         }

         this.interleaveLeave[var3] = 9999999;
      } else if(var2 == 4) {
         this.stretches = true;
      } else if(var2 == 5) {
         this.field1004 = var1.method2556();
      } else if(var2 == 6) {
         this.field1005 = var1.method2551();
      } else if(var2 == 7) {
         this.field993 = var1.method2551();
      } else if(var2 == 8) {
         this.maxLoops = var1.method2556();
      } else if(var2 == 9) {
         this.precedenceAnimating = var1.method2556();
      } else if(var2 == 10) {
         this.field1009 = var1.method2556();
      } else if(var2 == 11) {
         this.replyMode = var1.method2556();
      } else if(var2 == 12) {
         var3 = var1.method2556();
         this.field998 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field998[var4] = var1.method2551();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field998[var4] += var1.method2551() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.method2556();
         this.field1000 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1000[var4] = var1.method2560();
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2087061580"
   )
   void method863() {
      if(this.precedenceAnimating == -1) {
         if(this.interleaveLeave != null) {
            this.precedenceAnimating = 2;
         } else {
            this.precedenceAnimating = 0;
         }
      }

      if(this.field1009 == -1) {
         if(null != this.interleaveLeave) {
            this.field1009 = 2;
         } else {
            this.field1009 = 0;
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LModel;IB)LModel;",
      garbageValue = "-17"
   )
   public Model method864(Model var1, int var2) {
      var2 = this.field1001[var2];
      Frames var3 = Ignore.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method2360(true);
      } else {
         Model var4 = var1.method2360(!var3.method2351(var2));
         var4.method2375(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LModel;IIB)LModel;",
      garbageValue = "0"
   )
   Model method865(Model var1, int var2, int var3) {
      var2 = this.field1001[var2];
      Frames var4 = Ignore.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var4 == null) {
         return var1.method2360(true);
      } else {
         Model var5 = var1.method2360(!var4.method2351(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2371();
         } else if(var3 == 2) {
            var5.method2393();
         } else if(var3 == 3) {
            var5.method2430();
         }

         var5.method2375(var4, var2);
         if(var3 == 1) {
            var5.method2430();
         } else if(var3 == 2) {
            var5.method2393();
         } else if(var3 == 3) {
            var5.method2371();
         }

         return var5;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "-1293844149"
   )
   Model method866(Model var1, int var2) {
      var2 = this.field1001[var2];
      Frames var3 = Ignore.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method2358(true);
      } else {
         Model var4 = var1.method2358(!var3.method2351(var2));
         var4.method2375(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "1821784838"
   )
   public Model method868(Model var1, int var2) {
      int var3 = this.field1001[var2];
      Frames var4 = Ignore.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(null == var4) {
         return var1.method2360(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(null != this.field998 && var2 < this.field998.length) {
            var6 = this.field998[var2];
            var5 = Ignore.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(var5 != null && var6 != '\uffff') {
            var7 = var1.method2360(!var4.method2351(var3) & !var5.method2351(var6));
            var7.method2375(var4, var3);
            var7.method2375(var5, var6);
            return var7;
         } else {
            var7 = var1.method2360(!var4.method2351(var3));
            var7.method2375(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LModel;ILSequence;II)LModel;",
      garbageValue = "-1225784899"
   )
   public Model method880(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.field1001[var2];
      Frames var5 = Ignore.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method864(var1, var4);
      } else {
         var4 = var3.field1001[var4];
         Frames var6 = Ignore.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(null == var6) {
            var7 = var1.method2360(!var5.method2351(var2));
            var7.method2375(var5, var2);
            return var7;
         } else {
            var7 = var1.method2360(!var5.method2351(var2) & !var6.method2351(var4));
            var7.method2367(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass178;I)V",
      garbageValue = "-804064558"
   )
   static final void method883(int var0, int var1, int var2, int var3, SpritePixels var4, class178 var5) {
      if(null != var4) {
         int var6 = Client.mapAngle + Client.mapScale & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = class94.field1639[var6];
            int var9 = class94.field1640[var6];
            var8 = var8 * 256 / (256 + Client.mapScaleDelta);
            var9 = 256 * var9 / (Client.mapScaleDelta + 256);
            int var10 = var3 * var8 + var2 * var9 >> 16;
            int var11 = var3 * var9 - var2 * var8 >> 16;
            if(var7 > 2500) {
               var4.method1806(var10 + var5.field2953 / 2 - var4.field1440 / 2, var5.field2952 / 2 - var11 - var4.field1441 / 2, var0, var1, var5.field2953, var5.field2952, var5.field2954, var5.field2956);
            } else {
               var4.method1740(var10 + var0 + var5.field2953 / 2 - var4.field1440 / 2, var1 + var5.field2952 / 2 - var11 - var4.field1441 / 2);
            }

         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "1645538869"
   )
   static final boolean method896(char var0) {
      return var0 == 160 || var0 == 32 || var0 == 95 || var0 == 45;
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1931966"
   )
   static final void method897(int var0) {
      if(var0 >= 0) {
         int var1 = Client.menuActionParams0[var0];
         int var2 = Client.menuActionParams1[var0];
         int var3 = Client.menuTypes[var0];
         int var4 = Client.menuIdentifiers[var0];
         String var5 = Client.menuOptions[var0];
         String var6 = Client.menuTargets[var0];
         class143.menuAction(var1, var2, var3, var4, var5, var6, class143.field2211, class143.field2213);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;I)[LModIcon;",
      garbageValue = "-169882908"
   )
   public static ModIcon[] method898(class170 var0, String var1, String var2) {
      int var3 = var0.method3359(var1);
      int var4 = var0.method3305(var3, var2);
      return class24.method569(var0, var3, var4);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;I)V",
      garbageValue = "2063684514"
   )
   public static void method899(Applet var0, String var1) {
      class141.field2193 = var0;
      class141.field2184 = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "0"
   )
   public static int method901(int var0) {
      class50 var1 = Item.method654(var0);
      int var2 = var1.field1090;
      int var3 = var1.field1093;
      int var4 = var1.field1092;
      int var5 = class179.field2957[var4 - var3];
      return class179.widgetSettings[var2] >> var3 & var5;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1423347438"
   )
   static final void method902() {
      Client.field304 = 0;
      int var0 = class28.baseX + (class48.localPlayer.x >> 7);
      int var1 = (class48.localPlayer.y >> 7) + class159.baseY;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.field304 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.field304 = 1;
      }

      if(Client.field304 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.field304 = 0;
      }

   }
}
