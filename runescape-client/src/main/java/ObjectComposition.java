import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("ax")
   boolean field923 = false;
   @ObfuscatedName("r")
   static class170 field924;
   @ObfuscatedName("z")
   static NodeCache field925 = new NodeCache(64);
   @ObfuscatedName("i")
   public static NodeCache field926 = new NodeCache(500);
   @ObfuscatedName("b")
   static NodeCache field927 = new NodeCache(30);
   @ObfuscatedName("l")
   static NodeCache field928 = new NodeCache(30);
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -2112279957
   )
   public int field929 = 0;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -805591097
   )
   int field930 = -1;
   @ObfuscatedName("f")
   int[] field931;
   @ObfuscatedName("az")
   public boolean field932 = true;
   @ObfuscatedName("v")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("q")
   short[] field934;
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = 304897227
   )
   protected static int field935;
   @ObfuscatedName("s")
   short[] field937;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1038456919
   )
   public int field938 = 1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -703338177
   )
   public int field939 = 1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -394972839
   )
   public int field940 = 2;
   @ObfuscatedName("ex")
   static SpritePixels[] field942;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 319301291
   )
   int field943 = -1;
   @ObfuscatedName("y")
   boolean field944 = false;
   @ObfuscatedName("k")
   public boolean field945 = false;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1531891231
   )
   public int field946 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1467238319
   )
   public int field947;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -105071773
   )
   public int field948 = -1;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 416416699
   )
   int field949 = 0;
   @ObfuscatedName("ag")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 835910155
   )
   public int field951 = -1;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1312403009
   )
   public int field952 = -1;
   @ObfuscatedName("x")
   static boolean field954 = false;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 997847083
   )
   int field955 = 128;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1065896493
   )
   int field956 = 128;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 677859601
   )
   int field957 = 128;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -2087713113
   )
   int field958 = 0;
   @ObfuscatedName("m")
   static ModelData[] field959 = new ModelData[4];
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1651580213
   )
   int field960 = 0;
   @ObfuscatedName("ay")
   public boolean field961 = false;
   @ObfuscatedName("ad")
   boolean field962 = false;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1736095417
   )
   public int field963 = -1;
   @ObfuscatedName("al")
   public int[] field964;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1773772593
   )
   int field965 = -1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1517657061
   )
   public int field966 = -1;
   @ObfuscatedName("d")
   int[] field967;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 255753867
   )
   public int field968 = 0;
   @ObfuscatedName("t")
   short[] field969;
   @ObfuscatedName("ac")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("g")
   short[] field971;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1317864713
   )
   int field972 = 0;
   @ObfuscatedName("e")
   public boolean field973 = true;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -368331697
   )
   public int field974 = 0;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -949470507
   )
   int field975 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 861396129
   )
   public int field976 = 16;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1340149336"
   )
   public boolean method797() {
      if(this.impostorIds == null) {
         return this.field948 != -1 || this.field964 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = class1.getObjectDefinition(this.impostorIds[var1]);
               if(var2.field948 != -1 || null != var2.field964) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "779712732"
   )
   void method798() {
      if(this.field966 == -1) {
         this.field966 = 0;
         if(null != this.field931 && (null == this.field967 || this.field967[0] == 10)) {
            this.field966 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.actions[var1] != null) {
               this.field966 = 1;
            }
         }
      }

      if(this.field963 == -1) {
         this.field963 = this.field940 != 0?1:0;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1080006954"
   )
   void method799(Buffer var1) {
      while(true) {
         int var2 = var1.method2556();
         if(var2 == 0) {
            return;
         }

         this.method800(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1897984094"
   )
   void method800(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2556();
         if(var3 > 0) {
            if(null != this.field931 && !field954) {
               var1.offset += 3 * var3;
            } else {
               this.field967 = new int[var3];
               this.field931 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field931[var4] = var1.method2551();
                  this.field967[var4] = var1.method2556();
               }
            }
         }
      } else if(var2 == 2) {
         this.name = var1.method2774();
      } else if(var2 == 5) {
         var3 = var1.method2556();
         if(var3 > 0) {
            if(null != this.field931 && !field954) {
               var1.offset += 2 * var3;
            } else {
               this.field967 = null;
               this.field931 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field931[var4] = var1.method2551();
               }
            }
         }
      } else if(var2 == 14) {
         this.field938 = var1.method2556();
      } else if(var2 == 15) {
         this.field939 = var1.method2556();
      } else if(var2 == 17) {
         this.field940 = 0;
         this.field973 = false;
      } else if(var2 == 18) {
         this.field973 = false;
      } else if(var2 == 19) {
         this.field966 = var1.method2556();
      } else if(var2 == 21) {
         this.field943 = 0;
      } else if(var2 == 22) {
         this.field944 = true;
      } else if(var2 == 23) {
         this.field945 = true;
      } else if(var2 == 24) {
         this.field946 = var1.method2551();
         if(this.field946 == '\uffff') {
            this.field946 = -1;
         }
      } else if(var2 == 27) {
         this.field940 = 1;
      } else if(var2 == 28) {
         this.field976 = var1.method2556();
      } else if(var2 == 29) {
         this.field972 = var1.method2557();
      } else if(var2 == 39) {
         this.field949 = var1.method2557() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method2774();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2556();
         this.field934 = new short[var3];
         this.field969 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field934[var4] = (short)var1.method2551();
            this.field969[var4] = (short)var1.method2551();
         }
      } else if(var2 == 41) {
         var3 = var1.method2556();
         this.field971 = new short[var3];
         this.field937 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field971[var4] = (short)var1.method2551();
            this.field937[var4] = (short)var1.method2551();
         }
      } else if(var2 == 60) {
         this.field951 = var1.method2551();
      } else if(var2 == 62) {
         this.field923 = true;
      } else if(var2 == 64) {
         this.field932 = false;
      } else if(var2 == 65) {
         this.field955 = var1.method2551();
      } else if(var2 == 66) {
         this.field956 = var1.method2551();
      } else if(var2 == 67) {
         this.field957 = var1.method2551();
      } else if(var2 == 68) {
         this.field952 = var1.method2551();
      } else if(var2 == 69) {
         var1.method2556();
      } else if(var2 == 70) {
         this.field958 = var1.method2759();
      } else if(var2 == 71) {
         this.field975 = var1.method2759();
      } else if(var2 == 72) {
         this.field960 = var1.method2759();
      } else if(var2 == 73) {
         this.field961 = true;
      } else if(var2 == 74) {
         this.field962 = true;
      } else if(var2 == 75) {
         this.field963 = var1.method2556();
      } else if(var2 == 77) {
         this.field965 = var1.method2551();
         if(this.field965 == '\uffff') {
            this.field965 = -1;
         }

         this.field930 = var1.method2551();
         if(this.field930 == '\uffff') {
            this.field930 = -1;
         }

         var3 = var1.method2556();
         this.impostorIds = new int[var3 + 1];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.impostorIds[var4] = var1.method2551();
            if(this.impostorIds[var4] == '\uffff') {
               this.impostorIds[var4] = -1;
            }
         }
      } else if(var2 == 78) {
         this.field948 = var1.method2551();
         this.field968 = var1.method2556();
      } else if(var2 == 79) {
         this.field929 = var1.method2551();
         this.field974 = var1.method2551();
         this.field968 = var1.method2556();
         var3 = var1.method2556();
         this.field964 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field964[var4] = var1.method2551();
         }
      } else if(var2 == 81) {
         this.field943 = var1.method2556() * 256;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1692422905"
   )
   public final boolean method801(int var1) {
      if(this.field967 != null) {
         for(int var4 = 0; var4 < this.field967.length; ++var4) {
            if(this.field967[var4] == var1) {
               return class180.field2962.method3292(this.field931[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(this.field931 == null) {
         return true;
      } else if(var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.field931.length; ++var3) {
            var2 &= class180.field2962.method3292(this.field931[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "46"
   )
   public final boolean method802() {
      if(null == this.field931) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field931.length; ++var2) {
            var1 &= class180.field2962.method3292(this.field931[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LRenderable;",
      garbageValue = "-1984667902"
   )
   public final Renderable method803(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(null == this.field967) {
         var7 = (long)((this.field947 << 10) + var2);
      } else {
         var7 = (long)((var1 << 3) + (this.field947 << 10) + var2);
      }

      Object var9 = (Renderable)field927.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method808(var1, var2);
         if(var10 == null) {
            return null;
         }

         if(!this.field944) {
            var9 = var10.method2290(this.field972 + 64, this.field949 + 768, -50, -10, -50);
         } else {
            var10.field1784 = (short)(this.field972 + 64);
            var10.field1741 = (short)(768 + this.field949);
            var10.computeNormals();
            var9 = var10;
         }

         field927.put((CacheableNode)var9, var7);
      }

      if(this.field944) {
         var9 = ((ModelData)var9).method2267();
      }

      if(this.field943 >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2359(var3, var4, var5, var6, true, this.field943);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2268(var3, var4, var5, var6, true, this.field943);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II[[IIIILSequence;II)LModel;",
      garbageValue = "374353551"
   )
   public final Model method805(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.field967 == null) {
         var9 = (long)(var2 + (this.field947 << 10));
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.field947 << 10));
      }

      Model var11 = (Model)field928.get(var9);
      if(var11 == null) {
         ModelData var12 = this.method808(var1, var2);
         if(null == var12) {
            return null;
         }

         var11 = var12.method2290(64 + this.field972, this.field949 + 768, -50, -10, -50);
         field928.put(var11, var9);
      }

      if(null == var7 && this.field943 == -1) {
         return var11;
      } else {
         if(null != var7) {
            var11 = var7.method865(var11, var8, var2);
         } else {
            var11 = var11.method2360(true);
         }

         if(this.field943 >= 0) {
            var11 = var11.method2359(var3, var4, var5, var6, false, this.field943);
         }

         return var11;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)LObjectComposition;",
      garbageValue = "-1083557682"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.field965 != -1) {
         var1 = Sequence.method901(this.field965);
      } else if(this.field930 != -1) {
         var1 = class179.widgetSettings[this.field930];
      }

      return var1 >= 0 && var1 < this.impostorIds.length && this.impostorIds[var1] != -1?class1.getObjectDefinition(this.impostorIds[var1]):null;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)LModelData;",
      garbageValue = "-2013662798"
   )
   final ModelData method808(int var1, int var2) {
      ModelData var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(this.field967 == null) {
         if(var1 != 10) {
            return null;
         }

         if(this.field931 == null) {
            return null;
         }

         var4 = this.field923;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.field931.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            var7 = this.field931[var6];
            if(var4) {
               var7 += 65536;
            }

            var3 = (ModelData)field926.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2262(class180.field2962, var7 & '\uffff', 0);
               if(null == var3) {
                  return null;
               }

               if(var4) {
                  var3.method2277();
               }

               field926.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field959[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field959, var5);
         }
      } else {
         int var9 = -1;

         for(var5 = 0; var5 < this.field967.length; ++var5) {
            if(this.field967[var5] == var1) {
               var9 = var5;
               break;
            }
         }

         if(var9 == -1) {
            return null;
         }

         var5 = this.field931[var9];
         boolean var10 = this.field923 ^ var2 > 3;
         if(var10) {
            var5 += 65536;
         }

         var3 = (ModelData)field926.get((long)var5);
         if(null == var3) {
            var3 = ModelData.method2262(class180.field2962, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method2277();
            }

            field926.put(var3, (long)var5);
         }
      }

      if(this.field955 == 128 && this.field956 == 128 && this.field957 == 128) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var11;
      if(this.field958 == 0 && this.field975 == 0 && this.field960 == 0) {
         var11 = false;
      } else {
         var11 = true;
      }

      ModelData var8 = new ModelData(var3, var2 == 0 && !var4 && !var11, this.field934 == null, this.field971 == null, true);
      if(var1 == 4 && var2 > 3) {
         var8.method2273(256);
         var8.method2284(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2264();
      } else if(var2 == 2) {
         var8.method2261();
      } else if(var2 == 3) {
         var8.method2316();
      }

      if(this.field934 != null) {
         for(var7 = 0; var7 < this.field934.length; ++var7) {
            var8.method2337(this.field934[var7], this.field969[var7]);
         }
      }

      if(this.field971 != null) {
         for(var7 = 0; var7 < this.field971.length; ++var7) {
            var8.method2276(this.field971[var7], this.field937[var7]);
         }
      }

      if(var4) {
         var8.method2286(this.field955, this.field956, this.field957);
      }

      if(var11) {
         var8.method2284(this.field958, this.field975, this.field960);
      }

      return var8;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II[[IIIIS)LModel;",
      garbageValue = "2619"
   )
   public final Model method812(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(null == this.field967) {
         var7 = (long)((this.field947 << 10) + var2);
      } else {
         var7 = (long)(var2 + (this.field947 << 10) + (var1 << 3));
      }

      Model var9 = (Model)field928.get(var7);
      if(null == var9) {
         ModelData var10 = this.method808(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.method2290(64 + this.field972, this.field949 + 768, -50, -10, -50);
         field928.put(var9, var7);
      }

      if(this.field943 >= 0) {
         var9 = var9.method2359(var3, var4, var5, var6, true, this.field943);
      }

      return var9;
   }
}
