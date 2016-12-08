import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("r")
   public boolean field2890 = false;
   @ObfuscatedName("o")
   public static boolean field2891 = false;
   @ObfuscatedName("g")
   public static NodeCache field2892 = new NodeCache(64);
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -964385705
   )
   public int field2893 = 0;
   @ObfuscatedName("v")
   public static NodeCache field2894 = new NodeCache(30);
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1091357143
   )
   int field2895 = 0;
   @ObfuscatedName("c")
   static ModelData[] field2896 = new ModelData[4];
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -941744871
   )
   public int field2897;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1652063493
   )
   public int field2898 = 0;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -280402477
   )
   int field2899 = 0;
   @ObfuscatedName("y")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("f")
   short[] field2901;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1309405445
   )
   int field2902 = 128;
   @ObfuscatedName("p")
   short[] field2903;
   @ObfuscatedName("i")
   short[] field2904;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1912358127
   )
   public int field2905 = 1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1569453761
   )
   public int field2906 = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 439317553
   )
   public int field2907 = 2;
   @ObfuscatedName("z")
   int[] field2908;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1912588655
   )
   public int field2909 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1403870287
   )
   int field2910 = -1;
   @ObfuscatedName("t")
   boolean field2911 = false;
   @ObfuscatedName("h")
   public static NodeCache field2912 = new NodeCache(500);
   @ObfuscatedName("j")
   short[] field2913;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 53523273
   )
   public int field2914 = 16;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -588422563
   )
   int field2915 = 0;
   @ObfuscatedName("l")
   public static NodeCache field2916 = new NodeCache(30);
   @ObfuscatedName("au")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("w")
   public boolean field2918 = true;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1133773181
   )
   public int field2919 = -1;
   @ObfuscatedName("av")
   boolean field2920 = false;
   @ObfuscatedName("ao")
   public boolean field2921 = true;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1265063607
   )
   int field2922 = 128;
   @ObfuscatedName("aq")
   public int[] field2923;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1401678647
   )
   int field2924 = 128;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1211104987
   )
   int field2925 = 0;
   @ObfuscatedName("m")
   public static class182 field2926;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1980378059
   )
   int field2927 = 0;
   @ObfuscatedName("af")
   public boolean field2928 = false;
   @ObfuscatedName("ac")
   boolean field2929 = false;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1723423725
   )
   public int field2930 = -1;
   @ObfuscatedName("at")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -2146731317
   )
   int field2932 = -1;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 783621953
   )
   int field2933 = -1;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1207572881
   )
   public int field2934 = -1;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1540591579
   )
   public int field2935 = -1;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1101801091
   )
   public int field2936 = 0;
   @ObfuscatedName("k")
   int[] field2937;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -592699223
   )
   public int field2938 = 1;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1899135521"
   )
   void method3513() {
      if(this.field2909 == -1) {
         this.field2909 = 0;
         if(this.field2937 != null && (this.field2908 == null || this.field2908[0] == 10)) {
            this.field2909 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.actions[var1] != null) {
               this.field2909 = 1;
            }
         }
      }

      if(this.field2930 == -1) {
         this.field2930 = this.field2907 != 0?1:0;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "47"
   )
   void method3514(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3539(var1, var2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II[[IIIILSequence;II)LModel;",
      garbageValue = "-1320141273"
   )
   public final Model method3515(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.field2908 == null) {
         var9 = (long)(var2 + (this.field2897 << 10));
      } else {
         var9 = (long)((this.field2897 << 10) + (var1 << 3) + var2);
      }

      Model var11 = (Model)field2916.get(var9);
      if(null == var11) {
         ModelData var12 = this.method3521(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.method1465(this.field2915 + 64, 768 + this.field2895, -50, -10, -50);
         field2916.put(var11, var9);
      }

      if(null == var7 && this.field2910 == -1) {
         return var11;
      } else {
         if(null != var7) {
            var11 = var7.method3666(var11, var8, var2);
         } else {
            var11 = var11.method1534(true);
         }

         if(this.field2910 >= 0) {
            var11 = var11.method1522(var3, var4, var5, var6, false, this.field2910);
         }

         return var11;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1873653875"
   )
   public final boolean method3517() {
      if(this.field2937 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field2937.length; ++var2) {
            var1 &= class203.field3070.method3205(this.field2937[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LRenderable;",
      garbageValue = "-345736844"
   )
   public final Renderable method3518(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field2908 == null) {
         var7 = (long)((this.field2897 << 10) + var2);
      } else {
         var7 = (long)((this.field2897 << 10) + (var1 << 3) + var2);
      }

      Object var9 = (Renderable)field2894.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method3521(var1, var2);
         if(null == var10) {
            return null;
         }

         if(!this.field2911) {
            var9 = var10.method1465(this.field2915 + 64, this.field2895 + 768, -50, -10, -50);
         } else {
            var10.field1253 = (short)(this.field2915 + 64);
            var10.field1259 = (short)(this.field2895 + 768);
            var10.computeNormals();
            var9 = var10;
         }

         field2894.put((CacheableNode)var9, var7);
      }

      if(this.field2911) {
         var9 = ((ModelData)var9).method1440();
      }

      if(this.field2910 >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method1522(var3, var4, var5, var6, true, this.field2910);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method1481(var3, var4, var5, var6, true, this.field2910);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-23"
   )
   public final boolean method3520(int var1) {
      if(this.field2908 != null) {
         for(int var4 = 0; var4 < this.field2908.length; ++var4) {
            if(var1 == this.field2908[var4]) {
               return class203.field3070.method3205(this.field2937[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(this.field2937 == null) {
         return true;
      } else if(var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.field2937.length; ++var3) {
            var2 &= class203.field3070.method3205(this.field2937[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIB)LModelData;",
      garbageValue = "-43"
   )
   final ModelData method3521(int var1, int var2) {
      ModelData var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(this.field2908 == null) {
         if(var1 != 10) {
            return null;
         }

         if(null == this.field2937) {
            return null;
         }

         var4 = this.field2920;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.field2937.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            var7 = this.field2937[var6];
            if(var4) {
               var7 += 65536;
            }

            var3 = (ModelData)field2912.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method1434(class203.field3070, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method1450();
               }

               field2912.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field2896[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field2896, var5);
         }
      } else {
         int var9 = -1;

         for(var5 = 0; var5 < this.field2908.length; ++var5) {
            if(this.field2908[var5] == var1) {
               var9 = var5;
               break;
            }
         }

         if(var9 == -1) {
            return null;
         }

         var5 = this.field2937[var9];
         boolean var10 = this.field2920 ^ var2 > 3;
         if(var10) {
            var5 += 65536;
         }

         var3 = (ModelData)field2912.get((long)var5);
         if(null == var3) {
            var3 = ModelData.method1434(class203.field3070, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method1450();
            }

            field2912.put(var3, (long)var5);
         }
      }

      if(this.field2902 == 128 && this.field2922 == 128 && this.field2924 == 128) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var11;
      if(this.field2925 == 0 && this.field2899 == 0 && this.field2927 == 0) {
         var11 = false;
      } else {
         var11 = true;
      }

      ModelData var8 = new ModelData(var3, var2 == 0 && !var4 && !var11, null == this.field2913, this.field2903 == null, true);
      if(var1 == 4 && var2 > 3) {
         var8.method1446(256);
         var8.method1447(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method1443();
      } else if(var2 == 2) {
         var8.method1444();
      } else if(var2 == 3) {
         var8.method1445();
      }

      if(null != this.field2913) {
         for(var7 = 0; var7 < this.field2913.length; ++var7) {
            var8.method1448(this.field2913[var7], this.field2901[var7]);
         }
      }

      if(null != this.field2903) {
         for(var7 = 0; var7 < this.field2903.length; ++var7) {
            var8.method1449(this.field2903[var7], this.field2904[var7]);
         }
      }

      if(var4) {
         var8.method1498(this.field2902, this.field2922, this.field2924);
      }

      if(var11) {
         var8.method1447(this.field2925, this.field2899, this.field2927);
      }

      return var8;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)LObjectComposition;",
      garbageValue = "649423703"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.field2932 != -1) {
         var1 = XItemContainer.method161(this.field2932);
      } else if(this.field2933 != -1) {
         var1 = class165.widgetSettings[this.field2933];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?class143.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1006419364"
   )
   public boolean method3523() {
      if(this.impostorIds == null) {
         return this.field2934 != -1 || this.field2923 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = class143.getObjectDefinition(this.impostorIds[var1]);
               if(var2.field2934 != -1 || var2.field2923 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LModel;",
      garbageValue = "1282453081"
   )
   public final Model method3526(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field2908 == null) {
         var7 = (long)(var2 + (this.field2897 << 10));
      } else {
         var7 = (long)((var1 << 3) + (this.field2897 << 10) + var2);
      }

      Model var9 = (Model)field2916.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method3521(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.method1465(this.field2915 + 64, 768 + this.field2895, -50, -10, -50);
         field2916.put(var9, var7);
      }

      if(this.field2910 >= 0) {
         var9 = var9.method1522(var3, var4, var5, var6, true, this.field2910);
      }

      return var9;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1609592987"
   )
   void method3539(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(null != this.field2937 && !field2891) {
               var1.offset += 3 * var3;
            } else {
               this.field2908 = new int[var3];
               this.field2937 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field2937[var4] = var1.readUnsignedShort();
                  this.field2908[var4] = var1.readUnsignedByte();
               }
            }
         }
      } else if(var2 == 2) {
         this.name = var1.method2780();
      } else if(var2 == 5) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(null != this.field2937 && !field2891) {
               var1.offset += 2 * var3;
            } else {
               this.field2908 = null;
               this.field2937 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field2937[var4] = var1.readUnsignedShort();
               }
            }
         }
      } else if(var2 == 14) {
         this.field2905 = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field2938 = var1.readUnsignedByte();
      } else if(var2 == 17) {
         this.field2907 = 0;
         this.field2918 = false;
      } else if(var2 == 18) {
         this.field2918 = false;
      } else if(var2 == 19) {
         this.field2909 = var1.readUnsignedByte();
      } else if(var2 == 21) {
         this.field2910 = 0;
      } else if(var2 == 22) {
         this.field2911 = true;
      } else if(var2 == 23) {
         this.field2890 = true;
      } else if(var2 == 24) {
         this.field2906 = var1.readUnsignedShort();
         if(this.field2906 == '\uffff') {
            this.field2906 = -1;
         }
      } else if(var2 == 27) {
         this.field2907 = 1;
      } else if(var2 == 28) {
         this.field2914 = var1.readUnsignedByte();
      } else if(var2 == 29) {
         this.field2915 = var1.readByte();
      } else if(var2 == 39) {
         this.field2895 = var1.readByte() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method2780();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.field2913 = new short[var3];
         this.field2901 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field2913[var4] = (short)var1.readUnsignedShort();
            this.field2901[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field2903 = new short[var3];
         this.field2904 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field2903[var4] = (short)var1.readUnsignedShort();
            this.field2904[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         this.field2935 = var1.readUnsignedShort();
      } else if(var2 == 62) {
         this.field2920 = true;
      } else if(var2 == 64) {
         this.field2921 = false;
      } else if(var2 == 65) {
         this.field2902 = var1.readUnsignedShort();
      } else if(var2 == 66) {
         this.field2922 = var1.readUnsignedShort();
      } else if(var2 == 67) {
         this.field2924 = var1.readUnsignedShort();
      } else if(var2 == 68) {
         this.field2919 = var1.readUnsignedShort();
      } else if(var2 == 69) {
         var1.readUnsignedByte();
      } else if(var2 == 70) {
         this.field2925 = var1.method2729();
      } else if(var2 == 71) {
         this.field2899 = var1.method2729();
      } else if(var2 == 72) {
         this.field2927 = var1.method2729();
      } else if(var2 == 73) {
         this.field2928 = true;
      } else if(var2 == 74) {
         this.field2929 = true;
      } else if(var2 == 75) {
         this.field2930 = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.field2934 = var1.readUnsignedShort();
            this.field2898 = var1.readUnsignedByte();
         } else if(var2 == 79) {
            this.field2936 = var1.readUnsignedShort();
            this.field2893 = var1.readUnsignedShort();
            this.field2898 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.field2923 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2923[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.field2910 = var1.readUnsignedByte() * 256;
         }
      } else {
         this.field2932 = var1.readUnsignedShort();
         if(this.field2932 == '\uffff') {
            this.field2932 = -1;
         }

         this.field2933 = var1.readUnsignedShort();
         if(this.field2933 == '\uffff') {
            this.field2933 = -1;
         }

         var3 = -1;
         if(var2 == 92) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         var4 = var1.readUnsignedByte();
         this.impostorIds = new int[2 + var4];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.impostorIds[var5] = var1.readUnsignedShort();
            if(this.impostorIds[var5] == '\uffff') {
               this.impostorIds[var5] = -1;
            }
         }

         this.impostorIds[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass164;I)V",
      garbageValue = "692141436"
   )
   static final void method3547(int var0, int var1, int var2, int var3, SpritePixels var4, class164 var5) {
      int var6 = var2 * var2 + var3 * var3;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapScale + Client.mapAngle & 2047;
         int var8 = class84.field1435[var7];
         int var9 = class84.field1446[var7];
         var8 = var8 * 256 / (256 + Client.mapScaleDelta);
         var9 = var9 * 256 / (Client.mapScaleDelta + 256);
         int var10 = var2 * var9 + var8 * var3 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class88.field1526.method4060(var14 + 94 + var0 + 4 - 10, 83 + var1 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         FaceNormal.method1845(var0, var1, var2, var3, var4, var5);
      }

   }
}
