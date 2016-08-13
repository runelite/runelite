import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1652065071
   )
   public int field944 = -1;
   @ObfuscatedName("g")
   public static class170 field945;
   @ObfuscatedName("o")
   short[] field946;
   @ObfuscatedName("e")
   public static NodeCache field947 = new NodeCache(64);
   @ObfuscatedName("h")
   public static NodeCache field948 = new NodeCache(500);
   @ObfuscatedName("u")
   static ModelData[] field949 = new ModelData[4];
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1595151265
   )
   public int field950 = -1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2119445067
   )
   public int field952;
   @ObfuscatedName("y")
   public boolean field953 = false;
   @ObfuscatedName("m")
   int[] field954;
   @ObfuscatedName("q")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -840728267
   )
   int field956 = 0;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 412184643
   )
   public int field957 = -1;
   @ObfuscatedName("l")
   public static boolean field958 = false;
   @ObfuscatedName("d")
   short[] field959;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1821950973
   )
   public int field960 = 1;
   @ObfuscatedName("v")
   public boolean field961 = true;
   @ObfuscatedName("b")
   int[] field962;
   @ObfuscatedName("s")
   public static NodeCache field963 = new NodeCache(30);
   @ObfuscatedName("bu")
   static class171 field964;
   @ObfuscatedName("w")
   short[] field965;
   @ObfuscatedName("t")
   boolean field966 = false;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1594291783
   )
   public int field967 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2071733525
   )
   public int field968 = -1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 623284145
   )
   public int field969 = 16;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 992672747
   )
   public int field970 = 1;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1222058109
   )
   int field971 = 0;
   @ObfuscatedName("ac")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("p")
   short[] field973;
   @ObfuscatedName("aq")
   boolean field974 = false;
   @ObfuscatedName("k")
   public static NodeCache field975 = new NodeCache(30);
   @ObfuscatedName("az")
   public boolean field976 = true;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1297741231
   )
   int field977 = 128;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 805108405
   )
   int field978 = 128;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -110173529
   )
   int field979 = 128;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1827156681
   )
   int field980 = 0;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1214615643
   )
   int field981 = 0;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -541451019
   )
   int field982 = 0;
   @ObfuscatedName("ay")
   public boolean field983 = false;
   @ObfuscatedName("ai")
   boolean field984 = false;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 545216561
   )
   public int field985 = -1;
   @ObfuscatedName("ae")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 148094071
   )
   int field987 = -1;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 567429573
   )
   int field988 = -1;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 176454147
   )
   public int field989 = -1;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1423152161
   )
   public int field990 = 0;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 104229439
   )
   public int field992 = 0;
   @ObfuscatedName("al")
   public int[] field993;
   @ObfuscatedName("gv")
   static Widget field994;
   @ObfuscatedName("r")
   public static class170 field995;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 134044289
   )
   int field996 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 298837713
   )
   public int field998 = 2;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1660722868"
   )
   void method845() {
      if(this.field944 == -1) {
         this.field944 = 0;
         if(this.field962 != null && (this.field954 == null || this.field954[0] == 10)) {
            this.field944 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(null != this.actions[var1]) {
               this.field944 = 1;
            }
         }
      }

      if(this.field985 == -1) {
         this.field985 = this.field998 != 0?1:0;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)LObjectComposition;",
      garbageValue = "-2012922836"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.field987 != -1) {
         var1 = class54.method1164(this.field987);
      } else if(this.field988 != -1) {
         var1 = class179.widgetSettings[this.field988];
      }

      return var1 >= 0 && var1 < this.impostorIds.length && this.impostorIds[var1] != -1?class160.getObjectDefinition(this.impostorIds[var1]):null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "22"
   )
   void method848(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2633();
         if(var3 > 0) {
            if(null != this.field962 && !field958) {
               var1.offset += var3 * 3;
            } else {
               this.field954 = new int[var3];
               this.field962 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field962[var4] = var1.method2635();
                  this.field954[var4] = var1.method2633();
               }
            }
         }
      } else if(var2 == 2) {
         this.name = var1.method2663();
      } else if(var2 == 5) {
         var3 = var1.method2633();
         if(var3 > 0) {
            if(null != this.field962 && !field958) {
               var1.offset += 2 * var3;
            } else {
               this.field954 = null;
               this.field962 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field962[var4] = var1.method2635();
               }
            }
         }
      } else if(var2 == 14) {
         this.field960 = var1.method2633();
      } else if(var2 == 15) {
         this.field970 = var1.method2633();
      } else if(var2 == 17) {
         this.field998 = 0;
         this.field961 = false;
      } else if(var2 == 18) {
         this.field961 = false;
      } else if(var2 == 19) {
         this.field944 = var1.method2633();
      } else if(var2 == 21) {
         this.field996 = 0;
      } else if(var2 == 22) {
         this.field966 = true;
      } else if(var2 == 23) {
         this.field953 = true;
      } else if(var2 == 24) {
         this.field968 = var1.method2635();
         if(this.field968 == '\uffff') {
            this.field968 = -1;
         }
      } else if(var2 == 27) {
         this.field998 = 1;
      } else if(var2 == 28) {
         this.field969 = var1.method2633();
      } else if(var2 == 29) {
         this.field956 = var1.method2634();
      } else if(var2 == 39) {
         this.field971 = var1.method2634() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method2663();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2633();
         this.field973 = new short[var3];
         this.field965 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field973[var4] = (short)var1.method2635();
            this.field965[var4] = (short)var1.method2635();
         }
      } else if(var2 == 41) {
         var3 = var1.method2633();
         this.field946 = new short[var3];
         this.field959 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field946[var4] = (short)var1.method2635();
            this.field959[var4] = (short)var1.method2635();
         }
      } else if(var2 == 60) {
         this.field957 = var1.method2635();
      } else if(var2 == 62) {
         this.field974 = true;
      } else if(var2 == 64) {
         this.field976 = false;
      } else if(var2 == 65) {
         this.field977 = var1.method2635();
      } else if(var2 == 66) {
         this.field978 = var1.method2635();
      } else if(var2 == 67) {
         this.field979 = var1.method2635();
      } else if(var2 == 68) {
         this.field950 = var1.method2635();
      } else if(var2 == 69) {
         var1.method2633();
      } else if(var2 == 70) {
         this.field980 = var1.method2636();
      } else if(var2 == 71) {
         this.field981 = var1.method2636();
      } else if(var2 == 72) {
         this.field982 = var1.method2636();
      } else if(var2 == 73) {
         this.field983 = true;
      } else if(var2 == 74) {
         this.field984 = true;
      } else if(var2 == 75) {
         this.field985 = var1.method2633();
      } else if(var2 == 77) {
         this.field987 = var1.method2635();
         if(this.field987 == '\uffff') {
            this.field987 = -1;
         }

         this.field988 = var1.method2635();
         if(this.field988 == '\uffff') {
            this.field988 = -1;
         }

         var3 = var1.method2633();
         this.impostorIds = new int[1 + var3];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.impostorIds[var4] = var1.method2635();
            if(this.impostorIds[var4] == '\uffff') {
               this.impostorIds[var4] = -1;
            }
         }
      } else if(var2 == 78) {
         this.field989 = var1.method2635();
         this.field990 = var1.method2633();
      } else if(var2 == 79) {
         this.field967 = var1.method2635();
         this.field992 = var1.method2635();
         this.field990 = var1.method2633();
         var3 = var1.method2633();
         this.field993 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field993[var4] = var1.method2635();
         }
      } else if(var2 == 81) {
         this.field996 = var1.method2633() * 256;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1691589598"
   )
   public final boolean method849(int var1) {
      if(this.field954 != null) {
         for(int var4 = 0; var4 < this.field954.length; ++var4) {
            if(this.field954[var4] == var1) {
               return field995.method3453(this.field962[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(this.field962 == null) {
         return true;
      } else if(var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.field962.length; ++var3) {
            var2 &= field995.method3453(this.field962[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LRenderable;",
      garbageValue = "-1251799623"
   )
   public final Renderable method851(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field954 == null) {
         var7 = (long)((this.field952 << 10) + var2);
      } else {
         var7 = (long)(var2 + (this.field952 << 10) + (var1 << 3));
      }

      Object var9 = (Renderable)field963.get(var7);
      if(null == var9) {
         ModelData var10 = this.method854(var1, var2);
         if(var10 == null) {
            return null;
         }

         if(!this.field966) {
            var9 = var10.method2321(this.field956 + 64, this.field971 + 768, -50, -10, -50);
         } else {
            var10.field1795 = (short)(this.field956 + 64);
            var10.field1777 = (short)(this.field971 + 768);
            var10.computeNormals();
            var9 = var10;
         }

         field963.put((CacheableNode)var9, var7);
      }

      if(this.field966) {
         var9 = ((ModelData)var9).method2299();
      }

      if(this.field996 >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2398(var3, var4, var5, var6, true, this.field996);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2300(var3, var4, var5, var6, true, this.field996);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LModel;",
      garbageValue = "-1264721722"
   )
   public final Model method852(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(null == this.field954) {
         var7 = (long)(var2 + (this.field952 << 10));
      } else {
         var7 = (long)((this.field952 << 10) + (var1 << 3) + var2);
      }

      Model var9 = (Model)field975.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method854(var1, var2);
         if(null == var10) {
            return null;
         }

         var9 = var10.method2321(64 + this.field956, 768 + this.field971, -50, -10, -50);
         field975.put(var9, var7);
      }

      if(this.field996 >= 0) {
         var9 = var9.method2398(var3, var4, var5, var6, true, this.field996);
      }

      return var9;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)LModelData;",
      garbageValue = "2053736548"
   )
   final ModelData method854(int var1, int var2) {
      ModelData var3 = null;
      boolean var4;
      int var5;
      int var6;
      int var7;
      if(null == this.field954) {
         if(var1 != 10) {
            return null;
         }

         if(this.field962 == null) {
            return null;
         }

         var4 = this.field974;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.field962.length;

         for(var7 = 0; var7 < var5; ++var7) {
            var6 = this.field962[var7];
            if(var4) {
               var6 += 65536;
            }

            var3 = (ModelData)field948.get((long)var6);
            if(null == var3) {
               var3 = ModelData.method2369(field995, var6 & '\uffff', 0);
               if(null == var3) {
                  return null;
               }

               if(var4) {
                  var3.method2294();
               }

               field948.put(var3, (long)var6);
            }

            if(var5 > 1) {
               field949[var7] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field949, var5);
         }
      } else {
         var7 = -1;

         for(var5 = 0; var5 < this.field954.length; ++var5) {
            if(var1 == this.field954[var5]) {
               var7 = var5;
               break;
            }
         }

         if(var7 == -1) {
            return null;
         }

         var5 = this.field962[var7];
         boolean var8 = this.field974 ^ var2 > 3;
         if(var8) {
            var5 += 65536;
         }

         var3 = (ModelData)field948.get((long)var5);
         if(null == var3) {
            var3 = ModelData.method2369(field995, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var8) {
               var3.method2294();
            }

            field948.put(var3, (long)var5);
         }
      }

      if(this.field977 == 128 && this.field978 == 128 && this.field979 == 128) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var10;
      if(this.field980 == 0 && this.field981 == 0 && this.field982 == 0) {
         var10 = false;
      } else {
         var10 = true;
      }

      ModelData var9 = new ModelData(var3, var2 == 0 && !var4 && !var10, this.field973 == null, null == this.field946, true);
      if(var1 == 4 && var2 > 3) {
         var9.method2348(256);
         var9.method2304(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var9.method2301();
      } else if(var2 == 2) {
         var9.method2302();
      } else if(var2 == 3) {
         var9.method2371();
      }

      if(this.field973 != null) {
         for(var6 = 0; var6 < this.field973.length; ++var6) {
            var9.method2305(this.field973[var6], this.field965[var6]);
         }
      }

      if(null != this.field946) {
         for(var6 = 0; var6 < this.field946.length; ++var6) {
            var9.method2306(this.field946[var6], this.field959[var6]);
         }
      }

      if(var4) {
         var9.method2375(this.field977, this.field978, this.field979);
      }

      if(var10) {
         var9.method2304(this.field980, this.field981, this.field982);
      }

      return var9;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-37"
   )
   public final boolean method857() {
      if(this.field962 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field962.length; ++var2) {
            var1 &= field995.method3453(this.field962[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-102"
   )
   public boolean method860() {
      if(this.impostorIds == null) {
         return this.field989 != -1 || null != this.field993;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = class160.getObjectDefinition(this.impostorIds[var1]);
               if(var2.field989 != -1 || var2.field993 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II[[IIIILSequence;IB)LModel;",
      garbageValue = "-37"
   )
   public final Model method870(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.field954 == null) {
         var9 = (long)(var2 + (this.field952 << 10));
      } else {
         var9 = (long)(var2 + (this.field952 << 10) + (var1 << 3));
      }

      Model var11 = (Model)field975.get(var9);
      if(null == var11) {
         ModelData var12 = this.method854(var1, var2);
         if(null == var12) {
            return null;
         }

         var11 = var12.method2321(64 + this.field956, this.field971 + 768, -50, -10, -50);
         field975.put(var11, var9);
      }

      if(var7 == null && this.field996 == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method912(var11, var8, var2);
         } else {
            var11 = var11.method2399(true);
         }

         if(this.field996 >= 0) {
            var11 = var11.method2398(var3, var4, var5, var6, false, this.field996);
         }

         return var11;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass170;I)V",
      garbageValue = "1869295282"
   )
   public static void method876(class170 var0) {
      class50.field1125 = var0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "869658248"
   )
   void method880(Buffer var1) {
      while(true) {
         int var2 = var1.method2633();
         if(var2 == 0) {
            return;
         }

         this.method848(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BII)I",
      garbageValue = "-1845658135"
   )
   public static int method885(byte[] var0, int var1) {
      return MessageNode.method784(var0, 0, var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-72"
   )
   static void method886() {
      FileOnDisk var0 = null;

      try {
         var0 = class114.method2540("", Client.field298.field2346, true);
         Buffer var1 = class136.field2123.method116();
         var0.method4275(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method4283();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIIB)V",
      garbageValue = "-63"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class82.method1908(var2, var3, var4, var5);
      class94.method2183();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var1 == var10.parentId || var1 == -1412584499 && var10 == Client.field466)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field496] = var10.relativeX + var6;
               Client.widgetPositionY[Client.field496] = var10.relativeY + var7;
               Client.widgetBoundsWidth[Client.field496] = var10.width;
               Client.widgetBoundsHeight[Client.field496] = var10.height;
               var11 = ++Client.field496 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.field2829 = Client.gameCycle;
            if(!var10.field2855 || !class9.method132(var10)) {
               if(var10.contentType > 0) {
                  class167.method3372(var10);
               }

               int var12 = var10.relativeX + var6;
               int var13 = var7 + var10.relativeY;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(Client.field466 == var10) {
                  if(var1 != -1412584499 && !var10.field2885) {
                     class10.field169 = var0;
                     class9.field160 = var6;
                     class31.field726 = var7;
                     continue;
                  }

                  if(Client.field390 && Client.field346) {
                     var15 = class143.field2206;
                     var16 = class143.field2209;
                     var15 -= Client.field387;
                     var16 -= Client.field472;
                     if(var15 < Client.field543) {
                        var15 = Client.field543;
                     }

                     if(var10.width + var15 > Client.field397.width + Client.field543) {
                        var15 = Client.field543 + Client.field397.width - var10.width;
                     }

                     if(var16 < Client.field295) {
                        var16 = Client.field295;
                     }

                     if(var16 + var10.height > Client.field397.height + Client.field295) {
                        var16 = Client.field295 + Client.field397.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2885) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var21;
               int var22;
               if(var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.type == 9) {
                  var21 = var12;
                  var19 = var13;
                  var20 = var12 + var10.width;
                  var22 = var13 + var10.height;
                  if(var20 < var12) {
                     var21 = var20;
                     var20 = var12;
                  }

                  if(var22 < var13) {
                     var19 = var22;
                     var22 = var13;
                  }

                  ++var20;
                  ++var22;
                  var15 = var21 > var2?var21:var2;
                  var16 = var19 > var3?var19:var3;
                  var17 = var20 < var4?var20:var4;
                  var18 = var22 < var5?var22:var5;
               } else {
                  var21 = var10.width + var12;
                  var19 = var13 + var10.height;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var21 < var4?var21:var4;
                  var18 = var19 < var5?var19:var5;
               }

               if(!var10.field2855 || var15 < var17 && var16 < var18) {
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.field433) {
                           var13 += 15;
                           class8.field144.method4172("Fps:" + GameEngine.FPS, var10.width + var12, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var40 = Runtime.getRuntime();
                           var19 = (int)((var40.totalMemory() - var40.freeMemory()) / 1024L);
                           var20 = 16776960;
                           if(var19 > '耀' && Client.field301) {
                              var20 = 16711680;
                           }

                           if(var19 > 65536 && !Client.field301) {
                              var20 = 16711680;
                           }

                           class8.field144.method4172("Mem:" + var19 + "k", var10.width + var12, var13, var20, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field442 = var12;
                        Client.field443 = var13;
                        ChatMessages.method246(var12, var13, var10.width, var10.height);
                        Client.field498[var10.boundsIndex] = true;
                        class82.method1908(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        class172.method3512(var10, var12, var13, var11);
                        class82.method1908(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class178 var39 = var10.method3557(false);
                        if(null != var39) {
                           if(Client.field530 < 3) {
                              class171.field2754.method1801(var12, var13, var39.field2953, var39.field2950, 25, 25, Client.mapAngle, 256, var39.field2954, var39.field2951);
                           } else {
                              class82.method1899(var12, var13, 0, var39.field2954, var39.field2951);
                           }
                        }

                        class82.method1908(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.field2855 && class9.method132(var10) && var10 != class11.field177) {
                        continue;
                     }

                     if(!var10.field2855) {
                        if(var10.scrollY > var10.scrollHeight - var10.height) {
                           var10.scrollY = var10.scrollHeight - var10.height;
                        }

                        if(var10.scrollY < 0) {
                           var10.scrollY = 0;
                        }
                     }

                     gameDraw(var0, var10.id, var15, var16, var17, var18, var12 - var10.itemId, var13 - var10.scrollY, var11);
                     if(var10.children != null) {
                        gameDraw(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.itemId, var13 - var10.scrollY, var11);
                     }

                     WidgetNode var23 = (WidgetNode)Client.componentTable.method3936((long)var10.id);
                     if(null != var23) {
                        CollisionData.method2500(var23.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     class82.method1908(var2, var3, var4, var5);
                     class94.method2183();
                  }

                  if(Client.isResized || Client.field500[var11] || Client.field357 > 1) {
                     int var24;
                     int var38;
                     if(var10.type == 0 && !var10.field2855 && var10.scrollHeight > var10.height) {
                        var21 = var10.width + var12;
                        var19 = var10.scrollY;
                        var20 = var10.height;
                        var22 = var10.scrollHeight;
                        class110.field1947[0].method1954(var21, var13);
                        class110.field1947[1].method1954(var21, var20 + var13 - 16);
                        class82.method1907(var21, var13 + 16, 16, var20 - 32, Client.field373);
                        var24 = var20 * (var20 - 32) / var22;
                        if(var24 < 8) {
                           var24 = 8;
                        }

                        var38 = var19 * (var20 - 32 - var24) / (var22 - var20);
                        class82.method1907(var21, 16 + var13 + var38, 16, var24, Client.field374);
                        class82.method1949(var21, var38 + 16 + var13, var24, Client.field554);
                        class82.method1949(var21 + 1, var13 + 16 + var38, var24, Client.field554);
                        class82.method1945(var21, var38 + var13 + 16, 16, Client.field554);
                        class82.method1945(var21, 17 + var13 + var38, 16, Client.field554);
                        class82.method1949(15 + var21, var13 + 16 + var38, var24, Client.field329);
                        class82.method1949(var21 + 14, 17 + var13 + var38, var24 - 1, Client.field329);
                        class82.method1945(var21, var24 + var38 + 15 + var13, 16, Client.field329);
                        class82.method1945(1 + var21, 14 + var13 + var38 + var24, 15, Client.field329);
                     }

                     if(var10.type != 1) {
                        int var25;
                        int var26;
                        int var27;
                        if(var10.type == 2) {
                           var21 = 0;

                           for(var19 = 0; var19 < var10.field2819; ++var19) {
                              for(var20 = 0; var20 < var10.field2818; ++var20) {
                                 var22 = var12 + var20 * (32 + var10.field2873);
                                 var24 = var13 + var19 * (32 + var10.field2874);
                                 if(var21 < 20) {
                                    var22 += var10.field2875[var21];
                                    var24 += var10.field2876[var21];
                                 }

                                 if(var10.itemIds[var21] <= 0) {
                                    if(var10.field2877 != null && var21 < 20) {
                                       SpritePixels var42 = var10.method3553(var21);
                                       if(var42 != null) {
                                          var42.method1824(var22, var24);
                                       } else if(Widget.field2796) {
                                          class79.method1777(var10);
                                       }
                                    }
                                 } else {
                                    boolean var41 = false;
                                    boolean var52 = false;
                                    var26 = var10.itemIds[var21] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var24 + 32 > var3 && var24 < var5 || class23.field614 == var10 && Client.field409 == var21) {
                                       SpritePixels var50;
                                       if(Client.field439 == 1 && class23.field618 == var21 && DecorativeObject.field1688 == var10.id) {
                                          var50 = class28.createSprite(var26, var10.itemQuantities[var21], 2, 0, 2, false);
                                       } else {
                                          var50 = class28.createSprite(var26, var10.itemQuantities[var21], 1, 3153952, 2, false);
                                       }

                                       if(var50 != null) {
                                          if(class23.field614 == var10 && var21 == Client.field409) {
                                             var38 = class143.field2206 - Client.field410;
                                             var25 = class143.field2209 - Client.field322;
                                             if(var38 < 5 && var38 > -5) {
                                                var38 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.field414 < 5) {
                                                var38 = 0;
                                                var25 = 0;
                                             }

                                             var50.method1812(var22 + var38, var24 + var25, 128);
                                             if(var1 != -1) {
                                                Widget var51 = var0[var1 & '\uffff'];
                                                if(var25 + var24 < class82.field1492 && var51.scrollY > 0) {
                                                   var27 = (class82.field1492 - var24 - var25) * Client.field370 / 3;
                                                   if(var27 > Client.field370 * 10) {
                                                      var27 = Client.field370 * 10;
                                                   }

                                                   if(var27 > var51.scrollY) {
                                                      var27 = var51.scrollY;
                                                   }

                                                   var51.scrollY -= var27;
                                                   Client.field322 += var27;
                                                   class79.method1777(var51);
                                                }

                                                if(var24 + var25 + 32 > class82.field1489 && var51.scrollY < var51.scrollHeight - var51.height) {
                                                   var27 = (var24 + var25 + 32 - class82.field1489) * Client.field370 / 3;
                                                   if(var27 > Client.field370 * 10) {
                                                      var27 = Client.field370 * 10;
                                                   }

                                                   if(var27 > var51.scrollHeight - var51.height - var51.scrollY) {
                                                      var27 = var51.scrollHeight - var51.height - var51.scrollY;
                                                   }

                                                   var51.scrollY += var27;
                                                   Client.field322 -= var27;
                                                   class79.method1777(var51);
                                                }
                                             }
                                          } else if(var10 == field994 && var21 == Client.field509) {
                                             var50.method1812(var22, var24, 128);
                                          } else {
                                             var50.method1824(var22, var24);
                                          }
                                       } else {
                                          class79.method1777(var10);
                                       }
                                    }
                                 }

                                 ++var21;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class53.method1149(var10)) {
                              var21 = var10.field2924;
                              if(class11.field177 == var10 && var10.field2909 != 0) {
                                 var21 = var10.field2909;
                              }
                           } else {
                              var21 = var10.textColor;
                              if(var10 == class11.field177 && var10.field2834 != 0) {
                                 var21 = var10.field2834;
                              }
                           }

                           if(var10.field2825) {
                              switch(var10.field2837.field1510) {
                              case 1:
                                 class82.method1888(var12, var13, var10.width, var10.height, var10.textColor, var10.field2924, 256 - (var10.opacity & 255), 256 - (var10.field2839 & 255));
                                 break;
                              case 2:
                                 class82.method1889(var12, var13, var10.width, var10.height, var10.textColor, var10.field2924, 256 - (var10.opacity & 255), 256 - (var10.field2839 & 255));
                                 break;
                              case 3:
                                 class82.method1890(var12, var13, var10.width, var10.height, var10.textColor, var10.field2924, 256 - (var10.opacity & 255), 256 - (var10.field2839 & 255));
                                 break;
                              case 4:
                                 class82.method1891(var12, var13, var10.width, var10.height, var10.textColor, var10.field2924, 256 - (var10.opacity & 255), 256 - (var10.field2839 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    class82.method1907(var12, var13, var10.width, var10.height, var21);
                                 } else {
                                    class82.method1894(var12, var13, var10.width, var10.height, var21, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              class82.method1893(var12, var13, var10.width, var10.height, var21);
                           } else {
                              class82.method1912(var12, var13, var10.width, var10.height, var21, 256 - (var14 & 255));
                           }
                        } else {
                           class227 var28;
                           String var30;
                           if(var10.type == 4) {
                              var28 = var10.method3588();
                              if(var28 == null) {
                                 if(Widget.field2796) {
                                    class79.method1777(var10);
                                 }
                              } else {
                                 String var44 = var10.text;
                                 if(class53.method1149(var10)) {
                                    var19 = var10.field2924;
                                    if(var10 == class11.field177 && var10.field2909 != 0) {
                                       var19 = var10.field2909;
                                    }

                                    if(var10.field2868.length() > 0) {
                                       var44 = var10.field2868;
                                    }
                                 } else {
                                    var19 = var10.textColor;
                                    if(class11.field177 == var10 && var10.field2834 != 0) {
                                       var19 = var10.field2834;
                                    }
                                 }

                                 if(var10.field2855 && var10.item != -1) {
                                    ItemComposition var49 = class1.getItemDefinition(var10.item);
                                    var44 = var49.name;
                                    if(null == var44) {
                                       var44 = "null";
                                    }

                                    if((var49.isStackable == 1 || var10.stackSize != 1) && var10.stackSize != -1) {
                                       var44 = class16.method205(16748608) + var44 + "</col>" + " " + 'x' + class151.method3270(var10.stackSize);
                                    }
                                 }

                                 if(Client.field376 == var10) {
                                    var30 = null;
                                    var44 = "Please wait...";
                                    var19 = var10.textColor;
                                 }

                                 if(!var10.field2855) {
                                    var44 = class9.method136(var44, var10);
                                 }

                                 var28.method4174(var44, var12, var13, var10.width, var10.height, var19, var10.field2827?0:-1, var10.field2814, var10.field2883, var10.field2869);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var43;
                              if(!var10.field2855) {
                                 var43 = var10.method3563(class53.method1149(var10));
                                 if(var43 != null) {
                                    var43.method1824(var12, var13);
                                 } else if(Widget.field2796) {
                                    class79.method1777(var10);
                                 }
                              } else {
                                 if(var10.item != -1) {
                                    var43 = class28.createSprite(var10.item, var10.stackSize, var10.borderThickness, var10.sprite2, var10.field2865, false);
                                 } else {
                                    var43 = var10.method3563(false);
                                 }

                                 if(null == var43) {
                                    if(Widget.field2796) {
                                       class79.method1777(var10);
                                    }
                                 } else {
                                    var19 = var43.field1484;
                                    var20 = var43.field1483;
                                    if(!var10.field2845) {
                                       var22 = var10.width * 4096 / var19;
                                       if(var10.field2844 != 0) {
                                          var43.method1819(var10.width / 2 + var12, var13 + var10.height / 2, var10.field2844, var22);
                                       } else if(var14 != 0) {
                                          var43.method1814(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var10.width == var19 && var10.height == var20) {
                                          var43.method1824(var12, var13);
                                       } else {
                                          var43.method1843(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       class82.method1941(var12, var13, var10.width + var12, var10.height + var13);
                                       var22 = (var10.width + (var19 - 1)) / var19;
                                       var24 = (var20 - 1 + var10.height) / var20;

                                       for(var38 = 0; var38 < var22; ++var38) {
                                          for(var25 = 0; var25 < var24; ++var25) {
                                             if(var10.field2844 != 0) {
                                                var43.method1819(var19 / 2 + var12 + var19 * var38, var20 * var25 + var13 + var20 / 2, var10.field2844, 4096);
                                             } else if(var14 != 0) {
                                                var43.method1812(var19 * var38 + var12, var13 + var20 * var25, 256 - (var14 & 255));
                                             } else {
                                                var43.method1824(var12 + var38 * var19, var13 + var20 * var25);
                                             }
                                          }
                                       }

                                       class82.method1908(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var29;
                              if(var10.type == 6) {
                                 boolean var48 = class53.method1149(var10);
                                 if(var48) {
                                    var19 = var10.field2923;
                                 } else {
                                    var19 = var10.field2854;
                                 }

                                 Model var46 = null;
                                 var22 = 0;
                                 if(var10.item != -1) {
                                    var29 = class1.getItemDefinition(var10.item);
                                    if(null != var29) {
                                       var29 = var29.method1185(var10.stackSize);
                                       var46 = var29.getModel(1);
                                       if(null != var46) {
                                          var46.method2402();
                                          var22 = var46.modelHeight / 2;
                                       } else {
                                          class79.method1777(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var46 = Client.field567.method3667((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var46 = WidgetNode.localPlayer.getModel();
                                    }
                                 } else if(var19 == -1) {
                                    var46 = var10.method3556((Sequence)null, -1, var48, WidgetNode.localPlayer.composition);
                                    if(null == var46 && Widget.field2796) {
                                       class79.method1777(var10);
                                    }
                                 } else {
                                    Sequence var54 = class22.getAnimation(var19);
                                    var46 = var10.method3556(var54, var10.field2929, var48, WidgetNode.localPlayer.composition);
                                    if(null == var46 && Widget.field2796) {
                                       class79.method1777(var10);
                                    }
                                 }

                                 class94.method2187(var12 + var10.width / 2, var13 + var10.height / 2);
                                 var24 = class94.field1661[var10.rotationX] * var10.field2933 >> 16;
                                 var38 = var10.field2933 * class94.field1662[var10.rotationX] >> 16;
                                 if(null != var46) {
                                    if(!var10.field2855) {
                                       var46.method2414(0, var10.rotationZ, 0, var10.rotationX, 0, var24, var38);
                                    } else {
                                       var46.method2402();
                                       if(var10.field2908) {
                                          var46.method2415(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2856, var24 + var22 + var10.field2857, var10.field2857 + var38, var10.field2933);
                                       } else {
                                          var46.method2414(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2856, var22 + var24 + var10.field2857, var38 + var10.field2857);
                                       }
                                    }
                                 }

                                 class94.method2167();
                              } else {
                                 if(var10.type == 7) {
                                    var28 = var10.method3588();
                                    if(var28 == null) {
                                       if(Widget.field2796) {
                                          class79.method1777(var10);
                                       }
                                       continue;
                                    }

                                    var19 = 0;

                                    for(var20 = 0; var20 < var10.field2819; ++var20) {
                                       for(var22 = 0; var22 < var10.field2818; ++var22) {
                                          if(var10.itemIds[var19] > 0) {
                                             var29 = class1.getItemDefinition(var10.itemIds[var19] - 1);
                                             if(var29.isStackable != 1 && var10.itemQuantities[var19] == 1) {
                                                var30 = class16.method205(16748608) + var29.name + "</col>";
                                             } else {
                                                var30 = class16.method205(16748608) + var29.name + "</col>" + " " + 'x' + class151.method3270(var10.itemQuantities[var19]);
                                             }

                                             var25 = var12 + var22 * (115 + var10.field2873);
                                             var26 = var13 + var20 * (12 + var10.field2874);
                                             if(var10.field2814 == 0) {
                                                var28.method4170(var30, var25, var26, var10.textColor, var10.field2827?0:-1);
                                             } else if(var10.field2814 == 1) {
                                                var28.method4173(var30, var25 + var10.width / 2, var26, var10.textColor, var10.field2827?0:-1);
                                             } else {
                                                var28.method4172(var30, var10.width + var25 - 1, var26, var10.textColor, var10.field2827?0:-1);
                                             }
                                          }

                                          ++var19;
                                       }
                                    }
                                 }

                                 int var47;
                                 if(var10.type == 8 && var10 == ChatMessages.field278 && Client.field444 == Client.field445) {
                                    var21 = 0;
                                    var19 = 0;
                                    class227 var31 = class8.field144;
                                    String var32 = var10.text;

                                    String var33;
                                    for(var32 = class9.method136(var32, var10); var32.length() > 0; var19 += var31.field3235 + 1) {
                                       var38 = var32.indexOf("<br>");
                                       if(var38 != -1) {
                                          var33 = var32.substring(0, var38);
                                          var32 = var32.substring(var38 + 4);
                                       } else {
                                          var33 = var32;
                                          var32 = "";
                                       }

                                       var25 = var31.method4165(var33);
                                       if(var25 > var21) {
                                          var21 = var25;
                                       }
                                    }

                                    var21 += 6;
                                    var19 += 7;
                                    var38 = var12 + var10.width - 5 - var21;
                                    var25 = 5 + var10.height + var13;
                                    if(var38 < var12 + 5) {
                                       var38 = var12 + 5;
                                    }

                                    if(var38 + var21 > var4) {
                                       var38 = var4 - var21;
                                    }

                                    if(var19 + var25 > var5) {
                                       var25 = var5 - var19;
                                    }

                                    class82.method1907(var38, var25, var21, var19, 16777120);
                                    class82.method1893(var38, var25, var21, var19, 0);
                                    var32 = var10.text;
                                    var26 = var25 + var31.field3235 + 2;

                                    for(var32 = class9.method136(var32, var10); var32.length() > 0; var26 += var31.field3235 + 1) {
                                       var47 = var32.indexOf("<br>");
                                       if(var47 != -1) {
                                          var33 = var32.substring(0, var47);
                                          var32 = var32.substring(var47 + 4);
                                       } else {
                                          var33 = var32;
                                          var32 = "";
                                       }

                                       var31.method4170(var33, var38 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2840 == 1) {
                                       if(var10.field2841) {
                                          var21 = var12;
                                          var19 = var13 + var10.height;
                                          var20 = var10.width + var12;
                                          var22 = var13;
                                       } else {
                                          var21 = var12;
                                          var19 = var13;
                                          var20 = var10.width + var12;
                                          var22 = var13 + var10.height;
                                       }

                                       class82.method1898(var21, var19, var20, var22, var10.textColor);
                                    } else {
                                       var21 = var10.width >= 0?var10.width:-var10.width;
                                       var19 = var10.height >= 0?var10.height:-var10.height;
                                       var20 = var21;
                                       if(var21 < var19) {
                                          var20 = var19;
                                       }

                                       if(var20 != 0) {
                                          var22 = (var10.width << 16) / var20;
                                          var24 = (var10.height << 16) / var20;
                                          if(var24 <= var22) {
                                             var22 = -var22;
                                          } else {
                                             var24 = -var24;
                                          }

                                          var38 = var10.field2840 * var24 >> 17;
                                          var25 = var24 * var10.field2840 + 1 >> 17;
                                          var26 = var10.field2840 * var22 >> 17;
                                          var47 = 1 + var22 * var10.field2840 >> 17;
                                          int var45 = var38 + var12;
                                          var27 = var12 - var25;
                                          int var53 = var12 + var10.width - var25;
                                          int var55 = var10.width + var12 + var38;
                                          int var34 = var26 + var13;
                                          int var35 = var13 - var47;
                                          int var36 = var10.height + var13 - var47;
                                          int var37 = var26 + var13 + var10.height;
                                          class94.setRasterClippingEnabled(var45, var27, var53);
                                          class94.rasterFlat(var34, var35, var36, var45, var27, var53, var10.textColor);
                                          class94.setRasterClippingEnabled(var45, var53, var55);
                                          class94.rasterFlat(var34, var36, var37, var45, var53, var55, var10.textColor);
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }
}
