import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("av")
   public int[] field943;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 842149803
   )
   public int field944 = 16;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1033449825
   )
   int field945 = 0;
   @ObfuscatedName("n")
   public static NodeCache field947 = new NodeCache(500);
   @ObfuscatedName("u")
   static NodeCache field948 = new NodeCache(30);
   @ObfuscatedName("v")
   short[] field949;
   @ObfuscatedName("l")
   static ModelData[] field950 = new ModelData[4];
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -673385663
   )
   int field951 = -1;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1729920527
   )
   public int field952 = 0;
   @ObfuscatedName("y")
   int[] field953;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -90444351
   )
   public int field954;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 528584975
   )
   public int field955 = -1;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 953280161
   )
   public int field956 = -1;
   @ObfuscatedName("r")
   short[] field957;
   @ObfuscatedName("i")
   static boolean field958 = false;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1975333151
   )
   public int field959 = 1;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -292288515
   )
   public int field960 = 1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 554153531
   )
   public int field961 = 2;
   @ObfuscatedName("z")
   public boolean field962 = true;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 705938085
   )
   public int field963 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1270949547
   )
   int field964 = -1;
   @ObfuscatedName("f")
   boolean field965 = false;
   @ObfuscatedName("b")
   public boolean field966 = false;
   @ObfuscatedName("g")
   static NodeCache field967 = new NodeCache(64);
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1128240347
   )
   int field968 = 0;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 640128663
   )
   int field969 = 0;
   @ObfuscatedName("c")
   short[] field970;
   @ObfuscatedName("ad")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 197355277
   )
   public int field972 = -1;
   @ObfuscatedName("j")
   int[] field973;
   @ObfuscatedName("aq")
   boolean field974 = false;
   @ObfuscatedName("an")
   public boolean field975 = true;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1025283139
   )
   int field976 = 128;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -268805009
   )
   int field977 = 128;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 642493017
   )
   int field978 = 128;
   @ObfuscatedName("d")
   static NodeCache field979 = new NodeCache(30);
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -142998015
   )
   int field980 = 0;
   @ObfuscatedName("s")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("ao")
   public boolean field982 = false;
   @ObfuscatedName("ax")
   boolean field983 = false;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1789449871
   )
   public int field984 = -1;
   @ObfuscatedName("ai")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("e")
   static class170 field986;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1172965245
   )
   int field987 = -1;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -424381019
   )
   public int field988 = -1;
   @ObfuscatedName("p")
   short[] field989;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1400558707
   )
   public int field990 = 0;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -228247735
   )
   public int field991 = 0;
   @ObfuscatedName("h")
   static class170 field992;
   @ObfuscatedName("cu")
   static class146 field993;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1630963987
   )
   int field994 = 0;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-2147483648"
   )
   void method840(Buffer var1) {
      while(true) {
         int var2 = var1.method2544();
         if(var2 == 0) {
            return;
         }

         this.method841(var1, var2);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1375515142"
   )
   void method841(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2544();
         if(var3 > 0) {
            if(this.field973 != null && !field958) {
               var1.offset += 3 * var3;
            } else {
               this.field953 = new int[var3];
               this.field973 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field973[var4] = var1.method2546();
                  this.field953[var4] = var1.method2544();
               }
            }
         }
      } else if(var2 == 2) {
         this.name = var1.method2552();
      } else if(var2 == 5) {
         var3 = var1.method2544();
         if(var3 > 0) {
            if(this.field973 != null && !field958) {
               var1.offset += var3 * 2;
            } else {
               this.field953 = null;
               this.field973 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field973[var4] = var1.method2546();
               }
            }
         }
      } else if(var2 == 14) {
         this.field959 = var1.method2544();
      } else if(var2 == 15) {
         this.field960 = var1.method2544();
      } else if(var2 == 17) {
         this.field961 = 0;
         this.field962 = false;
      } else if(var2 == 18) {
         this.field962 = false;
      } else if(var2 == 19) {
         this.field963 = var1.method2544();
      } else if(var2 == 21) {
         this.field964 = 0;
      } else if(var2 == 22) {
         this.field965 = true;
      } else if(var2 == 23) {
         this.field966 = true;
      } else if(var2 == 24) {
         this.field955 = var1.method2546();
         if(this.field955 == '\uffff') {
            this.field955 = -1;
         }
      } else if(var2 == 27) {
         this.field961 = 1;
      } else if(var2 == 28) {
         this.field944 = var1.method2544();
      } else if(var2 == 29) {
         this.field969 = var1.method2545();
      } else if(var2 == 39) {
         this.field994 = var1.method2545() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method2552();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2544();
         this.field989 = new short[var3];
         this.field949 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field989[var4] = (short)var1.method2546();
            this.field949[var4] = (short)var1.method2546();
         }
      } else if(var2 == 41) {
         var3 = var1.method2544();
         this.field957 = new short[var3];
         this.field970 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field957[var4] = (short)var1.method2546();
            this.field970[var4] = (short)var1.method2546();
         }
      } else if(var2 == 60) {
         this.field972 = var1.method2546();
      } else if(var2 == 62) {
         this.field974 = true;
      } else if(var2 == 64) {
         this.field975 = false;
      } else if(var2 == 65) {
         this.field976 = var1.method2546();
      } else if(var2 == 66) {
         this.field977 = var1.method2546();
      } else if(var2 == 67) {
         this.field978 = var1.method2546();
      } else if(var2 == 68) {
         this.field956 = var1.method2546();
      } else if(var2 == 69) {
         var1.method2544();
      } else if(var2 == 70) {
         this.field968 = var1.method2547();
      } else if(var2 == 71) {
         this.field980 = var1.method2547();
      } else if(var2 == 72) {
         this.field945 = var1.method2547();
      } else if(var2 == 73) {
         this.field982 = true;
      } else if(var2 == 74) {
         this.field983 = true;
      } else if(var2 == 75) {
         this.field984 = var1.method2544();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.field988 = var1.method2546();
            this.field952 = var1.method2544();
         } else if(var2 == 79) {
            this.field990 = var1.method2546();
            this.field991 = var1.method2546();
            this.field952 = var1.method2544();
            var3 = var1.method2544();
            this.field943 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field943[var4] = var1.method2546();
            }
         } else if(var2 == 81) {
            this.field964 = var1.method2544() * 256;
         }
      } else {
         this.field951 = var1.method2546();
         if(this.field951 == '\uffff') {
            this.field951 = -1;
         }

         this.field987 = var1.method2546();
         if(this.field987 == '\uffff') {
            this.field987 = -1;
         }

         var3 = -1;
         if(var2 == 92) {
            var3 = var1.method2546();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         var4 = var1.method2544();
         this.impostorIds = new int[2 + var4];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.impostorIds[var5] = var1.method2546();
            if(this.impostorIds[var5] == '\uffff') {
               this.impostorIds[var5] = -1;
            }
         }

         this.impostorIds[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-37"
   )
   public final boolean method842(int var1) {
      if(null != this.field953) {
         for(int var4 = 0; var4 < this.field953.length; ++var4) {
            if(var1 == this.field953[var4]) {
               return field986.method3291(this.field973[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(this.field973 == null) {
         return true;
      } else if(var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.field973.length; ++var3) {
            var2 &= field986.method3291(this.field973[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1510587984"
   )
   void method843() {
      if(this.field963 == -1) {
         this.field963 = 0;
         if(null != this.field973 && (this.field953 == null || this.field953[0] == 10)) {
            this.field963 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.actions[var1] != null) {
               this.field963 = 1;
            }
         }
      }

      if(this.field984 == -1) {
         this.field984 = this.field961 != 0?1:0;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LRenderable;",
      garbageValue = "444996080"
   )
   public final Renderable method844(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field953 == null) {
         var7 = (long)((this.field954 << 10) + var2);
      } else {
         var7 = (long)((this.field954 << 10) + (var1 << 3) + var2);
      }

      Object var9 = (Renderable)field948.get(var7);
      if(null == var9) {
         ModelData var10 = this.method858(var1, var2);
         if(null == var10) {
            return null;
         }

         if(!this.field965) {
            var9 = var10.method2265(64 + this.field969, this.field994 + 768, -50, -10, -50);
         } else {
            var10.field1779 = (short)(this.field969 + 64);
            var10.field1783 = (short)(768 + this.field994);
            var10.computeNormals();
            var9 = var10;
         }

         field948.put((CacheableNode)var9, var7);
      }

      if(this.field965) {
         var9 = ((ModelData)var9).method2249();
      }

      if(this.field964 >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2354(var3, var4, var5, var6, true, this.field964);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2311(var3, var4, var5, var6, true, this.field964);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LModel;",
      garbageValue = "1695916593"
   )
   public final Model method845(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field953 == null) {
         var7 = (long)(var2 + (this.field954 << 10));
      } else {
         var7 = (long)((this.field954 << 10) + (var1 << 3) + var2);
      }

      Model var9 = (Model)field979.get(var7);
      if(null == var9) {
         ModelData var10 = this.method858(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.method2265(this.field969 + 64, this.field994 + 768, -50, -10, -50);
         field979.put(var9, var7);
      }

      if(this.field964 >= 0) {
         var9 = var9.method2354(var3, var4, var5, var6, true, this.field964);
      }

      return var9;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "110"
   )
   public final boolean method846() {
      if(null == this.field973) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field973.length; ++var2) {
            var1 &= field986.method3291(this.field973[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-819314001"
   )
   public boolean method849() {
      if(null == this.impostorIds) {
         return this.field988 != -1 || this.field943 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = class9.getObjectDefinition(this.impostorIds[var1]);
               if(var2.field988 != -1 || null != var2.field943) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II[[IIIILSequence;II)LModel;",
      garbageValue = "2072872022"
   )
   public final Model method852(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(null == this.field953) {
         var9 = (long)(var2 + (this.field954 << 10));
      } else {
         var9 = (long)((var1 << 3) + (this.field954 << 10) + var2);
      }

      Model var11 = (Model)field979.get(var9);
      if(null == var11) {
         ModelData var12 = this.method858(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.method2265(this.field969 + 64, this.field994 + 768, -50, -10, -50);
         field979.put(var11, var9);
      }

      if(var7 == null && this.field964 == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method901(var11, var8, var2);
         } else {
            var11 = var11.method2358(true);
         }

         if(this.field964 >= 0) {
            var11 = var11.method2354(var3, var4, var5, var6, false, this.field964);
         }

         return var11;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/CharSequence;IIS)Ljava/lang/String;",
      garbageValue = "11552"
   )
   public static String method853(CharSequence[] var0, int var1, int var2) {
      if(var2 == 0) {
         return "";
      } else if(var2 == 1) {
         CharSequence var3 = var0[var1];
         return null == var3?"null":var3.toString();
      } else {
         int var8 = var1 + var2;
         int var4 = 0;

         for(int var9 = var1; var9 < var8; ++var9) {
            CharSequence var6 = var0[var9];
            if(null == var6) {
               var4 += 4;
            } else {
               var4 += var6.length();
            }
         }

         StringBuilder var5 = new StringBuilder(var4);

         for(int var10 = var1; var10 < var8; ++var10) {
            CharSequence var7 = var0[var10];
            if(null == var7) {
               var5.append("null");
            } else {
               var5.append(var7);
            }
         }

         return var5.toString();
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)LModelData;",
      garbageValue = "1018711426"
   )
   final ModelData method858(int var1, int var2) {
      ModelData var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(null == this.field953) {
         if(var1 != 10) {
            return null;
         }

         if(null == this.field973) {
            return null;
         }

         var4 = this.field974;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.field973.length;

         for(int var8 = 0; var8 < var5; ++var8) {
            var7 = this.field973[var8];
            if(var4) {
               var7 += 65536;
            }

            var3 = (ModelData)field947.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2245(field986, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2259();
               }

               field947.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field950[var8] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field950, var5);
         }
      } else {
         int var9 = -1;

         for(var5 = 0; var5 < this.field953.length; ++var5) {
            if(this.field953[var5] == var1) {
               var9 = var5;
               break;
            }
         }

         if(var9 == -1) {
            return null;
         }

         var5 = this.field973[var9];
         boolean var11 = this.field974 ^ var2 > 3;
         if(var11) {
            var5 += 65536;
         }

         var3 = (ModelData)field947.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2245(field986, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var11) {
               var3.method2259();
            }

            field947.put(var3, (long)var5);
         }
      }

      if(this.field976 == 128 && this.field977 == 128 && this.field978 == 128) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var10;
      if(this.field968 == 0 && this.field980 == 0 && this.field945 == 0) {
         var10 = false;
      } else {
         var10 = true;
      }

      ModelData var6 = new ModelData(var3, var2 == 0 && !var4 && !var10, this.field989 == null, this.field957 == null, true);
      if(var1 == 4 && var2 > 3) {
         var6.method2272(256);
         var6.method2250(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var6.method2252();
      } else if(var2 == 2) {
         var6.method2253();
      } else if(var2 == 3) {
         var6.method2310();
      }

      if(this.field989 != null) {
         for(var7 = 0; var7 < this.field989.length; ++var7) {
            var6.method2315(this.field989[var7], this.field949[var7]);
         }
      }

      if(this.field957 != null) {
         for(var7 = 0; var7 < this.field957.length; ++var7) {
            var6.method2258(this.field957[var7], this.field970[var7]);
         }
      }

      if(var4) {
         var6.method2260(this.field976, this.field977, this.field978);
      }

      if(var10) {
         var6.method2250(this.field968, this.field980, this.field945);
      }

      return var6;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)LObjectComposition;",
      garbageValue = "0"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.field951 != -1) {
         var1 = class9.method127(this.field951);
      } else if(this.field987 != -1) {
         var1 = class179.widgetSettings[this.field987];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?class9.getObjectDefinition(var2):null;
   }
}
