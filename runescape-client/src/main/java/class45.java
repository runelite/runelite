import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class45 extends CacheableNode {
   @ObfuscatedName("f")
   static NodeCache field1029 = new NodeCache(64);
   @ObfuscatedName("q")
   static class170 field1030;
   @ObfuscatedName("k")
   static class170 field1031;
   @ObfuscatedName("c")
   static NodeCache field1032 = new NodeCache(30);
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -728937029
   )
   int field1033;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 168598657
   )
   int field1034;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1143961937
   )
   public int field1035 = -1;
   @ObfuscatedName("y")
   short[] field1036;
   @ObfuscatedName("h")
   short[] field1038;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 836107913
   )
   int field1039 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 465906269
   )
   int field1040 = 128;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -424912765
   )
   int field1041 = 128;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 716648993
   )
   int field1042 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 200256383
   )
   int field1043 = 0;
   @ObfuscatedName("u")
   short[] field1044;
   @ObfuscatedName("l")
   short[] field1046;
   @ObfuscatedName("du")
   static byte[][] field1049;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "496061341"
   )
   void method936(Buffer var1) {
      while(true) {
         int var2 = var1.method2571();
         if(var2 == 0) {
            return;
         }

         this.method937(var1, var2);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "474090001"
   )
   void method937(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1034 = var1.method2691();
      } else if(var2 == 2) {
         this.field1035 = var1.method2691();
      } else if(var2 == 4) {
         this.field1040 = var1.method2691();
      } else if(var2 == 5) {
         this.field1041 = var1.method2691();
      } else if(var2 == 6) {
         this.field1042 = var1.method2691();
      } else if(var2 == 7) {
         this.field1039 = var1.method2571();
      } else if(var2 == 8) {
         this.field1043 = var1.method2571();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method2571();
            this.field1036 = new short[var3];
            this.field1044 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1036[var4] = (short)var1.method2691();
               this.field1044[var4] = (short)var1.method2691();
            }
         } else if(var2 == 41) {
            var3 = var1.method2571();
            this.field1038 = new short[var3];
            this.field1046 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1038[var4] = (short)var1.method2691();
               this.field1046[var4] = (short)var1.method2691();
            }
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)LModel;",
      garbageValue = "-456293243"
   )
   public final Model method938(int var1) {
      Model var2 = (Model)field1032.get((long)this.field1033);
      if(null == var2) {
         ModelData var3 = ModelData.method2274(field1030, this.field1034, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(null != this.field1036) {
            for(var4 = 0; var4 < this.field1036.length; ++var4) {
               var3.method2285(this.field1036[var4], this.field1044[var4]);
            }
         }

         if(null != this.field1038) {
            for(var4 = 0; var4 < this.field1038.length; ++var4) {
               var3.method2286(this.field1038[var4], this.field1046[var4]);
            }
         }

         var2 = var3.method2293(64 + this.field1039, 850 + this.field1043, -30, -50, -30);
         field1032.put(var2, (long)this.field1033);
      }

      Model var5;
      if(this.field1035 != -1 && var1 != -1) {
         var5 = NPC.getAnimation(this.field1035).method900(var2, var1);
      } else {
         var5 = var2.method2364(true);
      }

      if(this.field1040 != 128 || this.field1041 != 128) {
         var5.method2376(this.field1040, this.field1041, this.field1040);
      }

      if(this.field1042 != 0) {
         if(this.field1042 == 90) {
            var5.method2371();
         }

         if(this.field1042 == 180) {
            var5.method2371();
            var5.method2371();
         }

         if(this.field1042 == 270) {
            var5.method2371();
            var5.method2371();
            var5.method2371();
         }
      }

      return var5;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1300202112"
   )
   static void method942(int var0) {
      Client.field503 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      class0.method0();
      if(Client.gameState >= 25) {
         class23.method590();
      }

      GameEngine.field2253 = true;
   }

   @ObfuscatedName("q")
   public static String method951(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5 = new StringBuilder(var2);

            while(var0 != 0L) {
               long var6 = var0;
               var0 /= 37L;
               var5.append(class165.field2690[(int)(var6 - var0 * 37L)]);
            }

            return var5.reverse().toString();
         }
      } else {
         return null;
      }
   }
}
