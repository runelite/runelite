import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -913088257
   )
   int field920 = 0;
   @ObfuscatedName("e")
   public static class170 field921;
   @ObfuscatedName("n")
   public static class170 field922;
   @ObfuscatedName("t")
   public static NodeCache field923 = new NodeCache(64);
   @ObfuscatedName("v")
   public static NodeCache field924 = new NodeCache(500);
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1040364101
   )
   int field925 = -1;
   @ObfuscatedName("m")
   public static NodeCache field926 = new NodeCache(30);
   @ObfuscatedName("k")
   static ModelData[] field927 = new ModelData[4];
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1174337159
   )
   public int field928;
   @ObfuscatedName("w")
   int[] field929;
   @ObfuscatedName("l")
   int[] field930;
   @ObfuscatedName("ao")
   public boolean field931 = false;
   @ObfuscatedName("i")
   short[] field932;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 213733243
   )
   int field933 = -1;
   @ObfuscatedName("x")
   short[] field934;
   @ObfuscatedName("h")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1783321639
   )
   public int field936 = 1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -914102591
   )
   public int field937 = 1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 343126005
   )
   public int field938 = 2;
   @ObfuscatedName("ah")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1500000065
   )
   int field940 = 128;
   @ObfuscatedName("f")
   public static boolean field941 = false;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1095961963
   )
   public int field942 = -1;
   @ObfuscatedName("y")
   public boolean field943 = false;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1188634259
   )
   public int field944 = -1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1668751487
   )
   public int field945 = 16;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 390126907
   )
   int field946 = 0;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1084310709
   )
   int field947 = 0;
   @ObfuscatedName("ai")
   boolean field948 = false;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1432262135
   )
   public int field949 = -1;
   @ObfuscatedName("u")
   short[] field950;
   @ObfuscatedName("ae")
   boolean field951 = false;
   @ObfuscatedName("ac")
   public boolean field952 = true;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -3780873
   )
   int field953 = 128;
   @ObfuscatedName("eg")
   static SpritePixels field954;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -566782941
   )
   int field955 = 128;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -196539149
   )
   int field956 = 0;
   @ObfuscatedName("p")
   boolean field957 = false;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1513624479
   )
   public int field958 = -1;
   @ObfuscatedName("d")
   short[] field959;
   @ObfuscatedName("b")
   public static NodeCache field960 = new NodeCache(30);
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -210599645
   )
   public int field961 = -1;
   @ObfuscatedName("ak")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1592558491
   )
   int field963 = 0;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1922798615
   )
   int field964 = -1;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1206647075
   )
   public int field965 = -1;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 181917077
   )
   public int field966 = 0;
   @ObfuscatedName("r")
   public boolean field967 = true;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 2024928371
   )
   public int field968 = 0;
   @ObfuscatedName("ad")
   public int[] field969;
   @ObfuscatedName("mq")
   static byte field970;
   @ObfuscatedName("et")
   static SpritePixels field972;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 387945883
   )
   public int field973 = 0;

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(III)Lclass110;",
      garbageValue = "343126005"
   )
   static class110 method821(int var0, int var1) {
      Client.field559.field1938 = var0;
      Client.field559.field1935 = var1;
      Client.field559.field1934 = 1;
      Client.field559.field1936 = 1;
      return Client.field559;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1328831698"
   )
   void method823(Buffer var1) {
      while(true) {
         int var2 = var1.method2656();
         if(var2 == 0) {
            return;
         }

         this.method824(var1, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;IS)V",
      garbageValue = "-20610"
   )
   void method824(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2656();
         if(var3 > 0) {
            if(null != this.field929 && !field941) {
               var1.offset += var3 * 3;
            } else {
               this.field930 = new int[var3];
               this.field929 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field929[var4] = var1.method2535();
                  this.field930[var4] = var1.method2656();
               }
            }
         }
      } else if(var2 == 2) {
         this.name = var1.method2541();
      } else if(var2 == 5) {
         var3 = var1.method2656();
         if(var3 > 0) {
            if(null != this.field929 && !field941) {
               var1.offset += 2 * var3;
            } else {
               this.field930 = null;
               this.field929 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field929[var4] = var1.method2535();
               }
            }
         }
      } else if(var2 == 14) {
         this.field936 = var1.method2656();
      } else if(var2 == 15) {
         this.field937 = var1.method2656();
      } else if(var2 == 17) {
         this.field938 = 0;
         this.field967 = false;
      } else if(var2 == 18) {
         this.field967 = false;
      } else if(var2 == 19) {
         this.field958 = var1.method2656();
      } else if(var2 == 21) {
         this.field933 = 0;
      } else if(var2 == 22) {
         this.field957 = true;
      } else if(var2 == 23) {
         this.field943 = true;
      } else if(var2 == 24) {
         this.field944 = var1.method2535();
         if(this.field944 == '\uffff') {
            this.field944 = -1;
         }
      } else if(var2 == 27) {
         this.field938 = 1;
      } else if(var2 == 28) {
         this.field945 = var1.method2656();
      } else if(var2 == 29) {
         this.field946 = var1.method2534();
      } else if(var2 == 39) {
         this.field947 = var1.method2534() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method2541();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2656();
         this.field932 = new short[var3];
         this.field950 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field932[var4] = (short)var1.method2535();
            this.field950[var4] = (short)var1.method2535();
         }
      } else if(var2 == 41) {
         var3 = var1.method2656();
         this.field934 = new short[var3];
         this.field959 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field934[var4] = (short)var1.method2535();
            this.field959[var4] = (short)var1.method2535();
         }
      } else if(var2 == 60) {
         this.field942 = var1.method2535();
      } else if(var2 == 62) {
         this.field951 = true;
      } else if(var2 == 64) {
         this.field952 = false;
      } else if(var2 == 65) {
         this.field953 = var1.method2535();
      } else if(var2 == 66) {
         this.field940 = var1.method2535();
      } else if(var2 == 67) {
         this.field955 = var1.method2535();
      } else if(var2 == 68) {
         this.field949 = var1.method2535();
      } else if(var2 == 69) {
         var1.method2656();
      } else if(var2 == 70) {
         this.field956 = var1.method2633();
      } else if(var2 == 71) {
         this.field963 = var1.method2633();
      } else if(var2 == 72) {
         this.field920 = var1.method2633();
      } else if(var2 == 73) {
         this.field931 = true;
      } else if(var2 == 74) {
         this.field948 = true;
      } else if(var2 == 75) {
         this.field961 = var1.method2656();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.field965 = var1.method2535();
            this.field966 = var1.method2656();
         } else if(var2 == 79) {
            this.field973 = var1.method2535();
            this.field968 = var1.method2535();
            this.field966 = var1.method2656();
            var3 = var1.method2656();
            this.field969 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field969[var4] = var1.method2535();
            }
         } else if(var2 == 81) {
            this.field933 = var1.method2656() * 256;
         }
      } else {
         this.field925 = var1.method2535();
         if(this.field925 == '\uffff') {
            this.field925 = -1;
         }

         this.field964 = var1.method2535();
         if(this.field964 == '\uffff') {
            this.field964 = -1;
         }

         var3 = -1;
         if(var2 == 92) {
            var3 = var1.method2535();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         var4 = var1.method2656();
         this.impostorIds = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.impostorIds[var5] = var1.method2535();
            if(this.impostorIds[var5] == '\uffff') {
               this.impostorIds[var5] = -1;
            }
         }

         this.impostorIds[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-58"
   )
   public final boolean method825(int var1) {
      if(null != this.field930) {
         for(int var4 = 0; var4 < this.field930.length; ++var4) {
            if(this.field930[var4] == var1) {
               return field922.method3353(this.field929[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(this.field929 == null) {
         return true;
      } else if(var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.field929.length; ++var3) {
            var2 &= field922.method3353(this.field929[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II[[IIIIB)LRenderable;",
      garbageValue = "34"
   )
   public final Renderable method827(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(null == this.field930) {
         var7 = (long)((this.field928 << 10) + var2);
      } else {
         var7 = (long)((this.field928 << 10) + (var1 << 3) + var2);
      }

      Object var9 = (Renderable)field960.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method830(var1, var2);
         if(var10 == null) {
            return null;
         }

         if(!this.field957) {
            var9 = var10.method2256(this.field946 + 64, 768 + this.field947, -50, -10, -50);
         } else {
            var10.field1782 = (short)(this.field946 + 64);
            var10.field1783 = (short)(768 + this.field947);
            var10.computeNormals();
            var9 = var10;
         }

         field960.put((CacheableNode)var9, var7);
      }

      if(this.field957) {
         var9 = ((ModelData)var9).method2240();
      }

      if(this.field933 >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2318(var3, var4, var5, var6, true, this.field933);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2241(var3, var4, var5, var6, true, this.field933);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LModel;",
      garbageValue = "-903046054"
   )
   public final Model method828(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field930 == null) {
         var7 = (long)((this.field928 << 10) + var2);
      } else {
         var7 = (long)(var2 + (this.field928 << 10) + (var1 << 3));
      }

      Model var9 = (Model)field926.get(var7);
      if(null == var9) {
         ModelData var10 = this.method830(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.method2256(64 + this.field946, 768 + this.field947, -50, -10, -50);
         field926.put(var9, var7);
      }

      if(this.field933 >= 0) {
         var9 = var9.method2318(var3, var4, var5, var6, true, this.field933);
      }

      return var9;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II[[IIIILSequence;IB)LModel;",
      garbageValue = "24"
   )
   public final Model method829(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(null == this.field930) {
         var9 = (long)(var2 + (this.field928 << 10));
      } else {
         var9 = (long)((this.field928 << 10) + (var1 << 3) + var2);
      }

      Model var11 = (Model)field926.get(var9);
      if(null == var11) {
         ModelData var12 = this.method830(var1, var2);
         if(null == var12) {
            return null;
         }

         var11 = var12.method2256(this.field946 + 64, 768 + this.field947, -50, -10, -50);
         field926.put(var11, var9);
      }

      if(var7 == null && this.field933 == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method883(var11, var8, var2);
         } else {
            var11 = var11.method2353(true);
         }

         if(this.field933 >= 0) {
            var11 = var11.method2318(var3, var4, var5, var6, false, this.field933);
         }

         return var11;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIB)LModelData;",
      garbageValue = "71"
   )
   final ModelData method830(int var1, int var2) {
      ModelData var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(this.field930 == null) {
         if(var1 != 10) {
            return null;
         }

         if(this.field929 == null) {
            return null;
         }

         var4 = this.field951;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.field929.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            var7 = this.field929[var6];
            if(var4) {
               var7 += 65536;
            }

            var3 = (ModelData)field924.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2236(field922, var7 & '\uffff', 0);
               if(null == var3) {
                  return null;
               }

               if(var4) {
                  var3.method2284();
               }

               field924.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field927[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field927, var5);
         }
      } else {
         int var9 = -1;

         for(var5 = 0; var5 < this.field930.length; ++var5) {
            if(var1 == this.field930[var5]) {
               var9 = var5;
               break;
            }
         }

         if(var9 == -1) {
            return null;
         }

         var5 = this.field929[var9];
         boolean var10 = this.field951 ^ var2 > 3;
         if(var10) {
            var5 += 65536;
         }

         var3 = (ModelData)field924.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2236(field922, var5 & '\uffff', 0);
            if(null == var3) {
               return null;
            }

            if(var10) {
               var3.method2284();
            }

            field924.put(var3, (long)var5);
         }
      }

      if(this.field953 == 128 && this.field940 == 128 && this.field955 == 128) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var11;
      if(this.field956 == 0 && this.field963 == 0 && this.field920 == 0) {
         var11 = false;
      } else {
         var11 = true;
      }

      ModelData var8 = new ModelData(var3, var2 == 0 && !var4 && !var11, null == this.field932, null == this.field934, true);
      if(var1 == 4 && var2 > 3) {
         var8.method2259(256);
         var8.method2247(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2243();
      } else if(var2 == 2) {
         var8.method2301();
      } else if(var2 == 3) {
         var8.method2245();
      }

      if(null != this.field932) {
         for(var7 = 0; var7 < this.field932.length; ++var7) {
            var8.method2248(this.field932[var7], this.field950[var7]);
         }
      }

      if(this.field934 != null) {
         for(var7 = 0; var7 < this.field934.length; ++var7) {
            var8.method2249(this.field934[var7], this.field959[var7]);
         }
      }

      if(var4) {
         var8.method2251(this.field953, this.field940, this.field955);
      }

      if(var11) {
         var8.method2247(this.field956, this.field963, this.field920);
      }

      return var8;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)LObjectComposition;",
      garbageValue = "81"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.field925 != -1) {
         var1 = class112.method2454(this.field925);
      } else if(this.field964 != -1) {
         var1 = class179.widgetSettings[this.field964];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?class8.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1070203733"
   )
   public final boolean method832() {
      if(null == this.field929) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field929.length; ++var2) {
            var1 &= field922.method3353(this.field929[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "110"
   )
   public boolean method836() {
      if(null == this.impostorIds) {
         return this.field965 != -1 || this.field969 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = class8.getObjectDefinition(this.impostorIds[var1]);
               if(var2.field965 != -1 || null != var2.field969) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2053177640"
   )
   void method839() {
      if(this.field958 == -1) {
         this.field958 = 0;
         if(null != this.field929 && (null == this.field930 || this.field930[0] == 10)) {
            this.field958 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.actions[var1] != null) {
               this.field958 = 1;
            }
         }
      }

      if(this.field961 == -1) {
         this.field961 = this.field938 != 0?1:0;
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   static final void method853() {
      Client.field401 = 0;
      int var0 = (class34.localPlayer.x >> 7) + class32.baseX;
      int var1 = class8.baseY + (class34.localPlayer.y >> 7);
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.field401 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.field401 = 1;
      }

      if(Client.field401 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.field401 = 0;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-51"
   )
   static void method855(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method3849((long)var0);
      if(null != var1) {
         var1.unlink();
      }
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(Lclass16;B)V",
      garbageValue = "3"
   )
   static final void method857(class16 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field231 == 0) {
         var1 = class9.region.method2044(var0.field234, var0.field229, var0.field230);
      }

      if(var0.field231 == 1) {
         var1 = class9.region.method1991(var0.field234, var0.field229, var0.field230);
      }

      if(var0.field231 == 2) {
         var1 = class9.region.method2123(var0.field234, var0.field229, var0.field230);
      }

      if(var0.field231 == 3) {
         var1 = class9.region.method2026(var0.field234, var0.field229, var0.field230);
      }

      if(var1 != 0) {
         int var5 = class9.region.method1994(var0.field234, var0.field229, var0.field230, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field235 = var2;
      var0.field233 = var3;
      var0.field227 = var4;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1418811806"
   )
   static int method858() {
      return ++class11.field169 - 1;
   }
}
