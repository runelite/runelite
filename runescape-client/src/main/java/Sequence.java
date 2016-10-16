import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("s")
   static class170 field965;
   @ObfuscatedName("t")
   static class170 field966;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1404323271
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating = -1;
   @ObfuscatedName("p")
   static NodeCache field968 = new NodeCache(100);
   @ObfuscatedName("g")
   public int[] field969;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -31269281
   )
   public int field970 = 5;
   @ObfuscatedName("r")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("y")
   static NodeCache field972 = new NodeCache(64);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -923089307
   )
   public int field973 = -1;
   @ObfuscatedName("m")
   int[] field974;
   @ObfuscatedName("w")
   @Export("stretches")
   public boolean stretches = false;
   @ObfuscatedName("k")
   public int[] field976;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 898794647
   )
   public int field977 = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -310772011
   )
   public int field978 = -1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1203729515
   )
   @Export("maxLoops")
   public int maxLoops = 99;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1256263309
   )
   public int field980 = -1;
   @ObfuscatedName("f")
   public int[] field981;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1510543805
   )
   @Export("replyMode")
   public int replyMode = 2;
   @ObfuscatedName("aq")
   static class171 field983;
   @ObfuscatedName("pf")
   static class8 field984;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "1"
   )
   void method877(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2668();
         this.field981 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field981[var4] = var1.method2668();
         }

         this.field969 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field969[var4] = var1.method2668();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field969[var4] += var1.method2668() << 16;
         }
      } else if(var2 == 2) {
         this.field973 = var1.method2668();
      } else if(var2 == 3) {
         var3 = var1.method2481();
         this.interleaveLeave = new int[var3 + 1];

         for(var4 = 0; var4 < var3; ++var4) {
            this.interleaveLeave[var4] = var1.method2481();
         }

         this.interleaveLeave[var3] = 9999999;
      } else if(var2 == 4) {
         this.stretches = true;
      } else if(var2 == 5) {
         this.field970 = var1.method2481();
      } else if(var2 == 6) {
         this.field977 = var1.method2668();
      } else if(var2 == 7) {
         this.field978 = var1.method2668();
      } else if(var2 == 8) {
         this.maxLoops = var1.method2481();
      } else if(var2 == 9) {
         this.precedenceAnimating = var1.method2481();
      } else if(var2 == 10) {
         this.field980 = var1.method2481();
      } else if(var2 == 11) {
         this.replyMode = var1.method2481();
      } else if(var2 == 12) {
         var3 = var1.method2481();
         this.field974 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field974[var4] = var1.method2668();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field974[var4] += var1.method2668() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.method2481();
         this.field976 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field976[var4] = var1.method2485();
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-78"
   )
   void method878(Buffer var1) {
      while(true) {
         int var2 = var1.method2481();
         if(var2 == 0) {
            return;
         }

         this.method877(var1, var2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "2052144198"
   )
   public Model method879(Model var1, int var2) {
      int var3 = this.field969[var2];
      Frames var4 = class13.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method2272(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field974 != null && var2 < this.field974.length) {
            var6 = this.field974[var2];
            var5 = class13.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(null != var5 && var6 != '\uffff') {
            var7 = var1.method2272(!var4.method2261(var3) & !var5.method2261(var6));
            var7.method2288(var4, var3);
            var7.method2288(var5, var6);
            return var7;
         } else {
            var7 = var1.method2272(!var4.method2261(var3));
            var7.method2288(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "893143362"
   )
   void method880() {
      if(this.precedenceAnimating == -1) {
         if(this.interleaveLeave != null) {
            this.precedenceAnimating = 2;
         } else {
            this.precedenceAnimating = 0;
         }
      }

      if(this.field980 == -1) {
         if(this.interleaveLeave != null) {
            this.field980 = 2;
         } else {
            this.field980 = 0;
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LModel;III)LModel;",
      garbageValue = "138231460"
   )
   Model method882(Model var1, int var2, int var3) {
      var2 = this.field969[var2];
      Frames var4 = class13.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var4) {
         return var1.method2272(true);
      } else {
         Model var5 = var1.method2272(!var4.method2261(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2283();
         } else if(var3 == 2) {
            var5.method2282();
         } else if(var3 == 3) {
            var5.method2327();
         }

         var5.method2288(var4, var2);
         if(var3 == 1) {
            var5.method2327();
         } else if(var3 == 2) {
            var5.method2282();
         } else if(var3 == 3) {
            var5.method2283();
         }

         return var5;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LModel;IB)LModel;",
      garbageValue = "2"
   )
   Model method883(Model var1, int var2) {
      var2 = this.field969[var2];
      Frames var3 = class13.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2297(true);
      } else {
         Model var4 = var1.method2297(!var3.method2261(var2));
         var4.method2288(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LModel;ILSequence;II)LModel;",
      garbageValue = "-738834936"
   )
   public Model method884(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.field969[var2];
      Frames var5 = class13.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method908(var1, var4);
      } else {
         var4 = var3.field969[var4];
         Frames var6 = class13.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(var6 == null) {
            var7 = var1.method2272(!var5.method2261(var2));
            var7.method2288(var5, var2);
            return var7;
         } else {
            var7 = var1.method2272(!var5.method2261(var2) & !var6.method2261(var4));
            var7.method2321(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass69;I)V",
      garbageValue = "-1432338613"
   )
   static final void method898(class69 var0) {
      var0.field1306 = false;
      if(null != var0.field1305) {
         var0.field1305.field1304 = 0;
      }

      for(class69 var1 = var0.vmethod3708(); null != var1; var1 = var0.vmethod3709()) {
         method898(var1);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LModel;IB)LModel;",
      garbageValue = "-47"
   )
   public Model method908(Model var1, int var2) {
      var2 = this.field969[var2];
      Frames var3 = class13.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method2272(true);
      } else {
         Model var4 = var1.method2272(!var3.method2261(var2));
         var4.method2288(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1948712815"
   )
   public static void method910() {
      field972.reset();
      field968.reset();
   }

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "-647455293"
   )
   static String method911(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.field267 == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.field267 == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.field267 == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.field267 == 5) {
         var0 = var0 + "-wti";
      } else if(Client.field267 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(Client.field273 != null) {
         var3 = "/p=" + Client.field273;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.field346 + "/a=" + class75.field1395 + var3 + "/";
   }
}
