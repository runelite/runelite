import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("az")
public class class45 extends CacheableNode {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2626587
   )
   int field1030;
   @ObfuscatedName("a")
   static class170 field1031;
   @ObfuscatedName("r")
   public static NodeCache field1032 = new NodeCache(30);
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1295956353
   )
   int field1033;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -420958737
   )
   public int field1034 = -1;
   @ObfuscatedName("i")
   short[] field1036;
   @ObfuscatedName("g")
   short[] field1037;
   @ObfuscatedName("m")
   short[] field1038;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1254495081
   )
   int field1039 = 128;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1775176245
   )
   int field1041 = 128;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -857104675
   )
   int field1042 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1646051119
   )
   int field1043 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1236875557
   )
   int field1044 = 0;
   @ObfuscatedName("k")
   short[] field1045;
   @ObfuscatedName("v")
   public static NodeCache field1047 = new NodeCache(64);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-46"
   )
   void method935(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1030 = var1.method2717();
      } else if(var2 == 2) {
         this.field1034 = var1.method2717();
      } else if(var2 == 4) {
         this.field1039 = var1.method2717();
      } else if(var2 == 5) {
         this.field1041 = var1.method2717();
      } else if(var2 == 6) {
         this.field1042 = var1.method2717();
      } else if(var2 == 7) {
         this.field1043 = var1.method2528();
      } else if(var2 == 8) {
         this.field1044 = var1.method2528();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method2528();
            this.field1036 = new short[var3];
            this.field1037 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1036[var4] = (short)var1.method2717();
               this.field1037[var4] = (short)var1.method2717();
            }
         } else if(var2 == 41) {
            var3 = var1.method2528();
            this.field1038 = new short[var3];
            this.field1045 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1038[var4] = (short)var1.method2717();
               this.field1045[var4] = (short)var1.method2717();
            }
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;S)V",
      garbageValue = "409"
   )
   void method936(Buffer var1) {
      while(true) {
         int var2 = var1.method2528();
         if(var2 == 0) {
            return;
         }

         this.method935(var1, var2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)LModel;",
      garbageValue = "-570240050"
   )
   public final Model method940(int var1) {
      Model var2 = (Model)field1032.get((long)this.field1033);
      if(null == var2) {
         ModelData var3 = ModelData.method2284(class221.field3216, this.field1030, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(null != this.field1036) {
            for(var4 = 0; var4 < this.field1036.length; ++var4) {
               var3.method2239(this.field1036[var4], this.field1037[var4]);
            }
         }

         if(null != this.field1038) {
            for(var4 = 0; var4 < this.field1038.length; ++var4) {
               var3.method2240(this.field1038[var4], this.field1045[var4]);
            }
         }

         var2 = var3.method2247(this.field1043 + 64, this.field1044 + 850, -30, -50, -30);
         field1032.put(var2, (long)this.field1033);
      }

      Model var5;
      if(this.field1034 != -1 && var1 != -1) {
         var5 = Friend.getAnimation(this.field1034).method913(var2, var1);
      } else {
         var5 = var2.method2353(true);
      }

      if(this.field1039 != 128 || this.field1041 != 128) {
         var5.method2335(this.field1039, this.field1041, this.field1039);
      }

      if(this.field1042 != 0) {
         if(this.field1042 == 90) {
            var5.method2330();
         }

         if(this.field1042 == 180) {
            var5.method2330();
            var5.method2330();
         }

         if(this.field1042 == 270) {
            var5.method2330();
            var5.method2330();
            var5.method2330();
         }
      }

      return var5;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(LPlayer;III)V",
      garbageValue = "1787557636"
   )
   static void method949(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = Friend.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field881 = 0;
            var0.actionAnimationDisable = var2;
            var0.field875 = 0;
         }

         if(var3 == 2) {
            var0.field875 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || Friend.getAnimation(var1).field1020 >= Friend.getAnimation(var0.animation).field1020) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field881 = 0;
         var0.actionAnimationDisable = var2;
         var0.field875 = 0;
         var0.field898 = var0.field893;
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "28"
   )
   static void method950() {
      int var0 = class159.field2374;
      int var1 = class92.field1643;
      if(class31.field720 < var0) {
         var0 = class31.field720;
      }

      if(class146.field2258 < var1) {
         var1 = class146.field2258;
      }

      if(class116.field2039 != null) {
         try {
            Client var2 = Client.field277;
            Object[] var3 = new Object[]{Integer.valueOf(class23.method586())};
            JSObject.getWindow(var2).call("resize", var3);
         } catch (Throwable var4) {
            ;
         }
      }

   }
}
