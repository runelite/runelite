import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -109694179
   )
   @Export("replyMode")
   public int replyMode = 2;
   @ObfuscatedName("h")
   public static class170 field1007;
   @ObfuscatedName("e")
   public static class170 field1008;
   @ObfuscatedName("y")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("i")
   public static class170 field1010;
   @ObfuscatedName("u")
   public int[] field1011;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1522721655
   )
   public int field1012 = -1;
   @ObfuscatedName("n")
   static NodeCache field1013 = new NodeCache(100);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -968933665
   )
   public int field1014 = 5;
   @ObfuscatedName("g")
   static NodeCache field1015 = new NodeCache(64);
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -74069205
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating = -1;
   @ObfuscatedName("s")
   @Export("stretches")
   public boolean stretches = false;
   @ObfuscatedName("d")
   int[] field1018;
   @ObfuscatedName("l")
   public int[] field1019;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1626074965
   )
   public int field1020 = -1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -655513661
   )
   @Export("maxLoops")
   public int maxLoops = 99;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1797253403
   )
   public int field1022 = -1;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1804300105
   )
   public int field1023 = -1;
   @ObfuscatedName("m")
   public int[] field1024;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "25"
   )
   void method899() {
      if(this.precedenceAnimating == -1) {
         if(null != this.interleaveLeave) {
            this.precedenceAnimating = 2;
         } else {
            this.precedenceAnimating = 0;
         }
      }

      if(this.field1023 == -1) {
         if(this.interleaveLeave != null) {
            this.field1023 = 2;
         } else {
            this.field1023 = 0;
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "-1765932137"
   )
   public Model method900(Model var1, int var2) {
      var2 = this.field1011[var2];
      Frames var3 = class8.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method2358(true);
      } else {
         Model var4 = var1.method2358(!var3.method2323(var2));
         var4.method2338(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LModel;III)LModel;",
      garbageValue = "-1502397453"
   )
   Model method901(Model var1, int var2, int var3) {
      var2 = this.field1011[var2];
      Frames var4 = class8.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var4 == null) {
         return var1.method2358(true);
      } else {
         Model var5 = var1.method2358(!var4.method2323(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2343();
         } else if(var3 == 2) {
            var5.method2361();
         } else if(var3 == 3) {
            var5.method2341();
         }

         var5.method2338(var4, var2);
         if(var3 == 1) {
            var5.method2341();
         } else if(var3 == 2) {
            var5.method2361();
         } else if(var3 == 3) {
            var5.method2343();
         }

         return var5;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-252477865"
   )
   static final void method902() {
      if(ObjectComposition.field993 != null) {
         ObjectComposition.field993.method3029();
         ObjectComposition.field993 = null;
      }

      class59.method1267();
      class128.region.method1952();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].method2419();
      }

      System.gc();
      class186.field3010 = 1;
      class35.field800 = null;
      FrameMap.field1823 = -1;
      class186.field3015 = -1;
      class186.field3016 = 0;
      class186.field3017 = false;
      class54.field1154 = 2;
      Client.field538 = -1;
      Client.field539 = false;
      class8.method115();
      class117.setGameState(10);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "-1709703924"
   )
   public Model method904(Model var1, int var2) {
      int var3 = this.field1011[var2];
      Frames var4 = class8.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(null == var4) {
         return var1.method2358(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(null != this.field1018 && var2 < this.field1018.length) {
            var6 = this.field1018[var2];
            var5 = class8.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(null != var5 && var6 != '\uffff') {
            var7 = var1.method2358(!var4.method2323(var3) & !var5.method2323(var6));
            var7.method2338(var4, var3);
            var7.method2338(var5, var6);
            return var7;
         } else {
            var7 = var1.method2358(!var4.method2323(var3));
            var7.method2338(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "-1371102600"
   )
   Model method916(Model var1, int var2) {
      var2 = this.field1011[var2];
      Frames var3 = class8.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method2384(true);
      } else {
         Model var4 = var1.method2384(!var3.method2323(var2));
         var4.method2338(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-412220002"
   )
   public static final boolean method920(String var0, String var1, String var2, String var3) {
      return null != var0 && null != var2?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LModel;ILSequence;II)LModel;",
      garbageValue = "2020160992"
   )
   public Model method921(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.field1011[var2];
      Frames var5 = class8.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method900(var1, var4);
      } else {
         var4 = var3.field1011[var4];
         Frames var6 = class8.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(var6 == null) {
            var7 = var1.method2358(!var5.method2323(var2));
            var7.method2338(var5, var2);
            return var7;
         } else {
            var7 = var1.method2358(!var5.method2323(var2) & !var6.method2323(var4));
            var7.method2339(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lclass45;",
      garbageValue = "-1116735070"
   )
   public static class45 method929(int var0) {
      class45 var1 = (class45)class45.field1029.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class45.field1038.method3292(13, var0);
         var1 = new class45();
         var1.field1027 = var0;
         if(var2 != null) {
            var1.method933(new Buffer(var2));
         }

         class45.field1029.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "4"
   )
   void method930(Buffer var1) {
      while(true) {
         int var2 = var1.method2544();
         if(var2 == 0) {
            return;
         }

         this.method931(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "805506535"
   )
   void method931(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2546();
         this.field1019 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1019[var4] = var1.method2546();
         }

         this.field1011 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1011[var4] = var1.method2546();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1011[var4] += var1.method2546() << 16;
         }
      } else if(var2 == 2) {
         this.field1012 = var1.method2546();
      } else if(var2 == 3) {
         var3 = var1.method2544();
         this.interleaveLeave = new int[var3 + 1];

         for(var4 = 0; var4 < var3; ++var4) {
            this.interleaveLeave[var4] = var1.method2544();
         }

         this.interleaveLeave[var3] = 9999999;
      } else if(var2 == 4) {
         this.stretches = true;
      } else if(var2 == 5) {
         this.field1014 = var1.method2544();
      } else if(var2 == 6) {
         this.field1022 = var1.method2546();
      } else if(var2 == 7) {
         this.field1020 = var1.method2546();
      } else if(var2 == 8) {
         this.maxLoops = var1.method2544();
      } else if(var2 == 9) {
         this.precedenceAnimating = var1.method2544();
      } else if(var2 == 10) {
         this.field1023 = var1.method2544();
      } else if(var2 == 11) {
         this.replyMode = var1.method2544();
      } else if(var2 == 12) {
         var3 = var1.method2544();
         this.field1018 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1018[var4] = var1.method2546();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1018[var4] += var1.method2546() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.method2544();
         this.field1024 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1024[var4] = var1.method2548();
         }
      }

   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1255884369"
   )
   static final void method932(int var0, int var1) {
      if(Client.menuOptionCount >= 2 || Client.field453 != 0 || Client.field455) {
         String var2;
         if(Client.field453 == 1 && Client.menuOptionCount < 2) {
            var2 = "Use" + " " + Client.field312 + " " + "->";
         } else if(Client.field455 && Client.menuOptionCount < 2) {
            var2 = Client.field458 + " " + Client.field459 + " " + "->";
         } else {
            int var4 = Client.menuOptionCount - 1;
            String var3;
            if(Client.menuTargets[var4].length() > 0) {
               var3 = Client.menuOptions[var4] + " " + Client.menuTargets[var4];
            } else {
               var3 = Client.menuOptions[var4];
            }

            var2 = var3;
         }

         if(Client.menuOptionCount > 2) {
            var2 = var2 + class137.method2909(16777215) + " " + '/' + " " + (Client.menuOptionCount - 2) + " more options";
         }

         MessageNode.field811.method4075(var2, 4 + var0, 15 + var1, 16777215, 0, Client.gameCycle / 1000);
      }
   }
}
