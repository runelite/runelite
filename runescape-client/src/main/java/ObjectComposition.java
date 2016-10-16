import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1378106675
   )
   int field908 = 128;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1435897695
   )
   int field909 = 0;
   @ObfuscatedName("y")
   static NodeCache field910 = new NodeCache(64);
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 409411747
   )
   int field911 = -1;
   @ObfuscatedName("g")
   static NodeCache field912 = new NodeCache(30);
   @ObfuscatedName("m")
   static NodeCache field913 = new NodeCache(30);
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1750387019
   )
   public int field914 = 2;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -269345045
   )
   public int field915 = 16;
   @ObfuscatedName("h")
   int[] field916;
   @ObfuscatedName("r")
   int[] field917;
   @ObfuscatedName("w")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -376482587
   )
   int field919 = 128;
   @ObfuscatedName("s")
   static boolean field920 = false;
   @ObfuscatedName("z")
   static class170 field921;
   @ObfuscatedName("a")
   short[] field922;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1996235295
   )
   public int field923 = 1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1832683263
   )
   public int field924 = 1;
   @ObfuscatedName("d")
   short[] field925;
   @ObfuscatedName("p")
   public static NodeCache field926 = new NodeCache(500);
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1733465399
   )
   public int field927 = -1;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 800065591
   )
   int field928 = 0;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -916565215
   )
   int field929 = -1;
   @ObfuscatedName("l")
   public boolean field930 = false;
   @ObfuscatedName("n")
   short[] field931;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2051928519
   )
   public int field932 = -1;
   @ObfuscatedName("v")
   boolean field933 = false;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 2136991373
   )
   int field934 = 0;
   @ObfuscatedName("am")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1342387447
   )
   public int field936 = -1;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 39923769
   )
   public int field937 = -1;
   @ObfuscatedName("ac")
   boolean field938 = false;
   @ObfuscatedName("ar")
   public boolean field939 = true;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1506114989
   )
   public int field940;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -484001963
   )
   int field941 = 128;
   @ObfuscatedName("f")
   static ModelData[] field942 = new ModelData[4];
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1097960933
   )
   int field943 = 0;
   @ObfuscatedName("u")
   short[] field944;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -521517865
   )
   int field945 = 0;
   @ObfuscatedName("au")
   public boolean field946 = false;
   @ObfuscatedName("ad")
   boolean field947 = false;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 974418463
   )
   public int field948 = -1;
   @ObfuscatedName("ai")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -730945851
   )
   int field950 = -1;
   @ObfuscatedName("c")
   public boolean field951 = true;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -968161241
   )
   public int field952 = -1;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1539120845
   )
   public int field953 = 0;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 2073751669
   )
   public int field954 = 0;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 330752777
   )
   public int field955 = 0;
   @ObfuscatedName("as")
   public int[] field956;
   @ObfuscatedName("eg")
   static SpritePixels[] field957;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1218606575"
   )
   public final boolean method812() {
      if(null == this.field916) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field916.length; ++var2) {
            var1 &= class180.field2953.method3252(this.field916[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1655880724"
   )
   void method814(Buffer var1) {
      while(true) {
         int var2 = var1.method2481();
         if(var2 == 0) {
            return;
         }

         this.method831(var1, var2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II[[IIIILSequence;II)LModel;",
      garbageValue = "-67375464"
   )
   public final Model method815(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.field917 == null) {
         var9 = (long)(var2 + (this.field940 << 10));
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.field940 << 10));
      }

      Model var11 = (Model)field913.get(var9);
      if(null == var11) {
         ModelData var12 = this.method821(var1, var2);
         if(null == var12) {
            return null;
         }

         var11 = var12.method2203(64 + this.field928, this.field934 + 768, -50, -10, -50);
         field913.put(var11, var9);
      }

      if(null == var7 && this.field911 == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method882(var11, var8, var2);
         } else {
            var11 = var11.method2272(true);
         }

         if(this.field911 >= 0) {
            var11 = var11.method2292(var3, var4, var5, var6, false, this.field911);
         }

         return var11;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-112391035"
   )
   void method816() {
      if(this.field927 == -1) {
         this.field927 = 0;
         if(this.field916 != null && (null == this.field917 || this.field917[0] == 10)) {
            this.field927 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(null != this.actions[var1]) {
               this.field927 = 1;
            }
         }
      }

      if(this.field948 == -1) {
         this.field948 = this.field914 != 0?1:0;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LRenderable;",
      garbageValue = "1656520001"
   )
   public final Renderable method818(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field917 == null) {
         var7 = (long)((this.field940 << 10) + var2);
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.field940 << 10));
      }

      Object var9 = (Renderable)field912.get(var7);
      if(null == var9) {
         ModelData var10 = this.method821(var1, var2);
         if(null == var10) {
            return null;
         }

         if(!this.field933) {
            var9 = var10.method2203(this.field928 + 64, this.field934 + 768, -50, -10, -50);
         } else {
            var10.field1763 = (short)(64 + this.field928);
            var10.field1764 = (short)(this.field934 + 768);
            var10.computeNormals();
            var9 = var10;
         }

         field912.put((CacheableNode)var9, var7);
      }

      if(this.field933) {
         var9 = ((ModelData)var9).method2189();
      }

      if(this.field911 >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2292(var3, var4, var5, var6, true, this.field911);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2200(var3, var4, var5, var6, true, this.field911);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II[[IIIIB)LModel;",
      garbageValue = "28"
   )
   public final Model method819(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(null == this.field917) {
         var7 = (long)(var2 + (this.field940 << 10));
      } else {
         var7 = (long)((this.field940 << 10) + (var1 << 3) + var2);
      }

      Model var9 = (Model)field913.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method821(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.method2203(this.field928 + 64, 768 + this.field934, -50, -10, -50);
         field913.put(var9, var7);
      }

      if(this.field911 >= 0) {
         var9 = var9.method2292(var3, var4, var5, var6, true, this.field911);
      }

      return var9;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)LModelData;",
      garbageValue = "1535075441"
   )
   final ModelData method821(int var1, int var2) {
      ModelData var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(null == this.field917) {
         if(var1 != 10) {
            return null;
         }

         if(null == this.field916) {
            return null;
         }

         var4 = this.field938;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.field916.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            var7 = this.field916[var6];
            if(var4) {
               var7 += 65536;
            }

            var3 = (ModelData)field926.get((long)var7);
            if(null == var3) {
               var3 = ModelData.method2184(class180.field2953, var7 & '\uffff', 0);
               if(null == var3) {
                  return null;
               }

               if(var4) {
                  var3.method2224();
               }

               field926.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field942[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field942, var5);
         }
      } else {
         int var9 = -1;

         for(var5 = 0; var5 < this.field917.length; ++var5) {
            if(var1 == this.field917[var5]) {
               var9 = var5;
               break;
            }
         }

         if(var9 == -1) {
            return null;
         }

         var5 = this.field916[var9];
         boolean var10 = this.field938 ^ var2 > 3;
         if(var10) {
            var5 += 65536;
         }

         var3 = (ModelData)field926.get((long)var5);
         if(null == var3) {
            var3 = ModelData.method2184(class180.field2953, var5 & '\uffff', 0);
            if(null == var3) {
               return null;
            }

            if(var10) {
               var3.method2224();
            }

            field926.put(var3, (long)var5);
         }
      }

      if(this.field908 == 128 && this.field941 == 128 && this.field919 == 128) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var11;
      if(this.field943 == 0 && this.field909 == 0 && this.field945 == 0) {
         var11 = false;
      } else {
         var11 = true;
      }

      ModelData var8 = new ModelData(var3, var2 == 0 && !var4 && !var11, this.field944 == null, null == this.field925, true);
      if(var1 == 4 && var2 > 3) {
         var8.method2195(256);
         var8.method2191(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2183();
      } else if(var2 == 2) {
         var8.method2187();
      } else if(var2 == 3) {
         var8.method2237();
      }

      if(this.field944 != null) {
         for(var7 = 0; var7 < this.field944.length; ++var7) {
            var8.method2197(this.field944[var7], this.field931[var7]);
         }
      }

      if(null != this.field925) {
         for(var7 = 0; var7 < this.field925.length; ++var7) {
            var8.method2234(this.field925[var7], this.field922[var7]);
         }
      }

      if(var4) {
         var8.method2198(this.field908, this.field941, this.field919);
      }

      if(var11) {
         var8.method2191(this.field943, this.field909, this.field945);
      }

      return var8;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)LObjectComposition;",
      garbageValue = "-871123138"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.field950 != -1) {
         var1 = class173.method3381(this.field950);
      } else if(this.field929 != -1) {
         var1 = class179.widgetSettings[this.field929];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?class40.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-875989303"
   )
   public boolean method823() {
      if(null == this.impostorIds) {
         return this.field952 != -1 || this.field956 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = class40.getObjectDefinition(this.impostorIds[var1]);
               if(var2.field952 != -1 || null != var2.field956) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-127"
   )
   public final boolean method826(int var1) {
      if(this.field917 != null) {
         for(int var4 = 0; var4 < this.field917.length; ++var4) {
            if(var1 == this.field917[var4]) {
               return class180.field2953.method3252(this.field916[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(this.field916 == null) {
         return true;
      } else if(var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.field916.length; ++var3) {
            var2 &= class180.field2953.method3252(this.field916[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "957912374"
   )
   void method831(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2481();
         if(var3 > 0) {
            if(this.field916 != null && !field920) {
               var1.offset += 3 * var3;
            } else {
               this.field917 = new int[var3];
               this.field916 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field916[var4] = var1.method2668();
                  this.field917[var4] = var1.method2481();
               }
            }
         }
      } else if(var2 == 2) {
         this.name = var1.method2503();
      } else if(var2 == 5) {
         var3 = var1.method2481();
         if(var3 > 0) {
            if(null != this.field916 && !field920) {
               var1.offset += var3 * 2;
            } else {
               this.field917 = null;
               this.field916 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field916[var4] = var1.method2668();
               }
            }
         }
      } else if(var2 == 14) {
         this.field923 = var1.method2481();
      } else if(var2 == 15) {
         this.field924 = var1.method2481();
      } else if(var2 == 17) {
         this.field914 = 0;
         this.field951 = false;
      } else if(var2 == 18) {
         this.field951 = false;
      } else if(var2 == 19) {
         this.field927 = var1.method2481();
      } else if(var2 == 21) {
         this.field911 = 0;
      } else if(var2 == 22) {
         this.field933 = true;
      } else if(var2 == 23) {
         this.field930 = true;
      } else if(var2 == 24) {
         this.field932 = var1.method2668();
         if(this.field932 == '\uffff') {
            this.field932 = -1;
         }
      } else if(var2 == 27) {
         this.field914 = 1;
      } else if(var2 == 28) {
         this.field915 = var1.method2481();
      } else if(var2 == 29) {
         this.field928 = var1.method2601();
      } else if(var2 == 39) {
         this.field934 = var1.method2601() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method2503();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2481();
         this.field944 = new short[var3];
         this.field931 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field944[var4] = (short)var1.method2668();
            this.field931[var4] = (short)var1.method2668();
         }
      } else if(var2 == 41) {
         var3 = var1.method2481();
         this.field925 = new short[var3];
         this.field922 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field925[var4] = (short)var1.method2668();
            this.field922[var4] = (short)var1.method2668();
         }
      } else if(var2 == 60) {
         this.field936 = var1.method2668();
      } else if(var2 == 62) {
         this.field938 = true;
      } else if(var2 == 64) {
         this.field939 = false;
      } else if(var2 == 65) {
         this.field908 = var1.method2668();
      } else if(var2 == 66) {
         this.field941 = var1.method2668();
      } else if(var2 == 67) {
         this.field919 = var1.method2668();
      } else if(var2 == 68) {
         this.field937 = var1.method2668();
      } else if(var2 == 69) {
         var1.method2481();
      } else if(var2 == 70) {
         this.field943 = var1.method2474();
      } else if(var2 == 71) {
         this.field909 = var1.method2474();
      } else if(var2 == 72) {
         this.field945 = var1.method2474();
      } else if(var2 == 73) {
         this.field946 = true;
      } else if(var2 == 74) {
         this.field947 = true;
      } else if(var2 == 75) {
         this.field948 = var1.method2481();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.field952 = var1.method2668();
            this.field953 = var1.method2481();
         } else if(var2 == 79) {
            this.field954 = var1.method2668();
            this.field955 = var1.method2668();
            this.field953 = var1.method2481();
            var3 = var1.method2481();
            this.field956 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field956[var4] = var1.method2668();
            }
         } else if(var2 == 81) {
            this.field911 = var1.method2481() * 256;
         }
      } else {
         this.field950 = var1.method2668();
         if(this.field950 == '\uffff') {
            this.field950 = -1;
         }

         this.field929 = var1.method2668();
         if(this.field929 == '\uffff') {
            this.field929 = -1;
         }

         var3 = -1;
         if(var2 == 92) {
            var3 = var1.method2668();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         var4 = var1.method2481();
         this.impostorIds = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.impostorIds[var5] = var1.method2668();
            if(this.impostorIds[var5] == '\uffff') {
               this.impostorIds[var5] = -1;
            }
         }

         this.impostorIds[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1946367816"
   )
   static final void method856(int var0) {
      if(class174.method3393(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(null != var3) {
               var3.field2811 = 0;
               var3.field2921 = 0;
            }
         }

      }
   }
}
