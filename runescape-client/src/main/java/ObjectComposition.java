import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("p")
   short[] field934;
   @ObfuscatedName("q")
   static class170 field935;
   @ObfuscatedName("f")
   static class170 field936;
   @ObfuscatedName("c")
   public static NodeCache field937 = new NodeCache(64);
   @ObfuscatedName("v")
   public static NodeCache field938 = new NodeCache(500);
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 752487881
   )
   int field939 = 128;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 2032763011
   )
   public int field940 = -1;
   @ObfuscatedName("y")
   static ModelData[] field941 = new ModelData[4];
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -751165123
   )
   int field942 = 0;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -333456935
   )
   public int field943 = 0;
   @ObfuscatedName("l")
   int[] field944;
   @ObfuscatedName("b")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("g")
   short[] field946;
   @ObfuscatedName("e")
   short[] field947;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -671962839
   )
   public int field948 = 1;
   @ObfuscatedName("s")
   short[] field949;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1412495505
   )
   public int field950 = 1;
   @ObfuscatedName("d")
   public boolean field951 = false;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1618053845
   )
   public int field952 = 2;
   @ObfuscatedName("a")
   public boolean field953 = true;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -633462631
   )
   int field954 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1905058001
   )
   int field955 = -1;
   @ObfuscatedName("x")
   boolean field956 = false;
   @ObfuscatedName("j")
   public static NodeCache field957 = new NodeCache(30);
   @ObfuscatedName("h")
   int[] field958;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1459375151
   )
   public int field959 = 16;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 291248927
   )
   public int field960 = -1;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -877750735
   )
   int field961 = 0;
   @ObfuscatedName("av")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1790814819
   )
   public int field963 = -1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1280838311
   )
   public int field964 = -1;
   @ObfuscatedName("aj")
   boolean field965 = false;
   @ObfuscatedName("k")
   static boolean field966 = false;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1305389897
   )
   int field967 = 0;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1479775803
   )
   int field968 = 128;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 890084991
   )
   int field969 = 128;
   @ObfuscatedName("am")
   public boolean field971 = true;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -652987165
   )
   int field972 = 0;
   @ObfuscatedName("ap")
   public boolean field973 = false;
   @ObfuscatedName("ao")
   boolean field974 = false;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -412695987
   )
   public int field975;
   @ObfuscatedName("ai")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -2007393521
   )
   int field977 = -1;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -909475711
   )
   int field978 = -1;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 629554593
   )
   public int field979 = -1;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -780614655
   )
   public int field980 = 0;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 324077501
   )
   public int field981 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 854132033
   )
   public int field982 = -1;
   @ObfuscatedName("ah")
   public int[] field983;
   @ObfuscatedName("m")
   public static NodeCache field984 = new NodeCache(30);

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "14"
   )
   static final void method834(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field483; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var2 + var0 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var1 + var3) {
            Client.field485[var4] = true;
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1121979232"
   )
   void method836(Buffer var1) {
      while(true) {
         int var2 = var1.method2571();
         if(var2 == 0) {
            return;
         }

         this.method862(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-566582762"
   )
   public final boolean method838(int var1) {
      if(this.field944 != null) {
         for(int var4 = 0; var4 < this.field944.length; ++var4) {
            if(var1 == this.field944[var4]) {
               return field936.method3282(this.field958[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(null == this.field958) {
         return true;
      } else if(var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.field958.length; ++var3) {
            var2 &= field936.method3282(this.field958[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2022293801"
   )
   public final boolean method839() {
      if(this.field958 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field958.length; ++var2) {
            var1 &= field936.method3282(this.field958[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LModel;",
      garbageValue = "-1536191526"
   )
   public final Model method841(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field944 == null) {
         var7 = (long)(var2 + (this.field975 << 10));
      } else {
         var7 = (long)((var1 << 3) + (this.field975 << 10) + var2);
      }

      Model var9 = (Model)field984.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method853(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.method2293(64 + this.field954, this.field961 + 768, -50, -10, -50);
         field984.put(var9, var7);
      }

      if(this.field955 >= 0) {
         var9 = var9.method2369(var3, var4, var5, var6, true, this.field955);
      }

      return var9;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II[[IIIILSequence;IB)LModel;",
      garbageValue = "-22"
   )
   public final Model method842(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.field944 == null) {
         var9 = (long)((this.field975 << 10) + var2);
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.field975 << 10));
      }

      Model var11 = (Model)field984.get(var9);
      if(var11 == null) {
         ModelData var12 = this.method853(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.method2293(64 + this.field954, 768 + this.field961, -50, -10, -50);
         field984.put(var11, var9);
      }

      if(var7 == null && this.field955 == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method899(var11, var8, var2);
         } else {
            var11 = var11.method2402(true);
         }

         if(this.field955 >= 0) {
            var11 = var11.method2369(var3, var4, var5, var6, false, this.field955);
         }

         return var11;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)LObjectComposition;",
      garbageValue = "-16"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.field977 != -1) {
         var1 = class219.method3992(this.field977);
      } else if(this.field978 != -1) {
         var1 = class179.widgetSettings[this.field978];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?Projectile.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-56"
   )
   public boolean method845() {
      if(this.impostorIds == null) {
         return this.field979 != -1 || this.field983 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = Projectile.getObjectDefinition(this.impostorIds[var1]);
               if(var2.field979 != -1 || null != var2.field983) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)LModelData;",
      garbageValue = "1520942560"
   )
   final ModelData method853(int var1, int var2) {
      ModelData var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(this.field944 == null) {
         if(var1 != 10) {
            return null;
         }

         if(this.field958 == null) {
            return null;
         }

         var4 = this.field965;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.field958.length;

         for(int var8 = 0; var8 < var5; ++var8) {
            var7 = this.field958[var8];
            if(var4) {
               var7 += 65536;
            }

            var3 = (ModelData)field938.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2274(field936, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2287();
               }

               field938.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field941[var8] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field941, var5);
         }
      } else {
         int var9 = -1;

         for(var5 = 0; var5 < this.field944.length; ++var5) {
            if(var1 == this.field944[var5]) {
               var9 = var5;
               break;
            }
         }

         if(var9 == -1) {
            return null;
         }

         var5 = this.field958[var9];
         boolean var11 = this.field965 ^ var2 > 3;
         if(var11) {
            var5 += 65536;
         }

         var3 = (ModelData)field938.get((long)var5);
         if(null == var3) {
            var3 = ModelData.method2274(field936, var5 & '\uffff', 0);
            if(null == var3) {
               return null;
            }

            if(var11) {
               var3.method2287();
            }

            field938.put(var3, (long)var5);
         }
      }

      if(this.field939 == 128 && this.field968 == 128 && this.field969 == 128) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var10;
      if(this.field967 == 0 && this.field942 == 0 && this.field972 == 0) {
         var10 = false;
      } else {
         var10 = true;
      }

      ModelData var6 = new ModelData(var3, var2 == 0 && !var4 && !var10, this.field946 == null, this.field934 == null, true);
      if(var1 == 4 && var2 > 3) {
         var6.method2283(256);
         var6.method2275(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var6.method2280();
      } else if(var2 == 2) {
         var6.method2281();
      } else if(var2 == 3) {
         var6.method2282();
      }

      if(this.field946 != null) {
         for(var7 = 0; var7 < this.field946.length; ++var7) {
            var6.method2285(this.field946[var7], this.field947[var7]);
         }
      }

      if(null != this.field934) {
         for(var7 = 0; var7 < this.field934.length; ++var7) {
            var6.method2286(this.field934[var7], this.field949[var7]);
         }
      }

      if(var4) {
         var6.method2340(this.field939, this.field968, this.field969);
      }

      if(var10) {
         var6.method2275(this.field967, this.field942, this.field972);
      }

      return var6;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method855() {
      if(this.field982 == -1) {
         this.field982 = 0;
         if(null != this.field958 && (this.field944 == null || this.field944[0] == 10)) {
            this.field982 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.actions[var1] != null) {
               this.field982 = 1;
            }
         }
      }

      if(this.field940 == -1) {
         this.field940 = this.field952 != 0?1:0;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;IS)V",
      garbageValue = "-10201"
   )
   void method862(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2571();
         if(var3 > 0) {
            if(this.field958 != null && !field966) {
               var1.offset += var3 * 3;
            } else {
               this.field944 = new int[var3];
               this.field958 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field958[var4] = var1.method2691();
                  this.field944[var4] = var1.method2571();
               }
            }
         }
      } else if(var2 == 2) {
         this.name = var1.method2579();
      } else if(var2 == 5) {
         var3 = var1.method2571();
         if(var3 > 0) {
            if(null != this.field958 && !field966) {
               var1.offset += 2 * var3;
            } else {
               this.field944 = null;
               this.field958 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field958[var4] = var1.method2691();
               }
            }
         }
      } else if(var2 == 14) {
         this.field950 = var1.method2571();
      } else if(var2 == 15) {
         this.field948 = var1.method2571();
      } else if(var2 == 17) {
         this.field952 = 0;
         this.field953 = false;
      } else if(var2 == 18) {
         this.field953 = false;
      } else if(var2 == 19) {
         this.field982 = var1.method2571();
      } else if(var2 == 21) {
         this.field955 = 0;
      } else if(var2 == 22) {
         this.field956 = true;
      } else if(var2 == 23) {
         this.field951 = true;
      } else if(var2 == 24) {
         this.field964 = var1.method2691();
         if(this.field964 == '\uffff') {
            this.field964 = -1;
         }
      } else if(var2 == 27) {
         this.field952 = 1;
      } else if(var2 == 28) {
         this.field959 = var1.method2571();
      } else if(var2 == 29) {
         this.field954 = var1.method2572();
      } else if(var2 == 39) {
         this.field961 = var1.method2572() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method2579();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2571();
         this.field946 = new short[var3];
         this.field947 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field946[var4] = (short)var1.method2691();
            this.field947[var4] = (short)var1.method2691();
         }
      } else if(var2 == 41) {
         var3 = var1.method2571();
         this.field934 = new short[var3];
         this.field949 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field934[var4] = (short)var1.method2691();
            this.field949[var4] = (short)var1.method2691();
         }
      } else if(var2 == 60) {
         this.field963 = var1.method2691();
      } else if(var2 == 62) {
         this.field965 = true;
      } else if(var2 == 64) {
         this.field971 = false;
      } else if(var2 == 65) {
         this.field939 = var1.method2691();
      } else if(var2 == 66) {
         this.field968 = var1.method2691();
      } else if(var2 == 67) {
         this.field969 = var1.method2691();
      } else if(var2 == 68) {
         this.field960 = var1.method2691();
      } else if(var2 == 69) {
         var1.method2571();
      } else if(var2 == 70) {
         this.field967 = var1.method2574();
      } else if(var2 == 71) {
         this.field942 = var1.method2574();
      } else if(var2 == 72) {
         this.field972 = var1.method2574();
      } else if(var2 == 73) {
         this.field973 = true;
      } else if(var2 == 74) {
         this.field974 = true;
      } else if(var2 == 75) {
         this.field940 = var1.method2571();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.field979 = var1.method2691();
            this.field980 = var1.method2571();
         } else if(var2 == 79) {
            this.field981 = var1.method2691();
            this.field943 = var1.method2691();
            this.field980 = var1.method2571();
            var3 = var1.method2571();
            this.field983 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field983[var4] = var1.method2691();
            }
         } else if(var2 == 81) {
            this.field955 = var1.method2571() * 256;
         }
      } else {
         this.field977 = var1.method2691();
         if(this.field977 == '\uffff') {
            this.field977 = -1;
         }

         this.field978 = var1.method2691();
         if(this.field978 == '\uffff') {
            this.field978 = -1;
         }

         var3 = -1;
         if(var2 == 92) {
            var3 = var1.method2691();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         var4 = var1.method2571();
         this.impostorIds = new int[2 + var4];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.impostorIds[var5] = var1.method2691();
            if(this.impostorIds[var5] == '\uffff') {
               this.impostorIds[var5] = -1;
            }
         }

         this.impostorIds[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "1924217501"
   )
   static final void method874(int var0, int var1, int var2, boolean var3) {
      if(class85.method1938(var0)) {
         class132.method2874(Widget.widgets[var0], -1, var1, var2, var3);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II[[IIIIB)LRenderable;",
      garbageValue = "73"
   )
   public final Renderable method875(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(null == this.field944) {
         var7 = (long)(var2 + (this.field975 << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.field975 << 10));
      }

      Object var9 = (Renderable)field957.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method853(var1, var2);
         if(var10 == null) {
            return null;
         }

         if(!this.field956) {
            var9 = var10.method2293(64 + this.field954, this.field961 + 768, -50, -10, -50);
         } else {
            var10.field1779 = (short)(64 + this.field954);
            var10.field1791 = (short)(768 + this.field961);
            var10.computeNormals();
            var9 = var10;
         }

         field957.put((CacheableNode)var9, var7);
      }

      if(this.field956) {
         var9 = ((ModelData)var9).method2277();
      }

      if(this.field955 >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2369(var3, var4, var5, var6, true, this.field955);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2278(var3, var4, var5, var6, true, this.field955);
         }
      }

      return (Renderable)var9;
   }
}
