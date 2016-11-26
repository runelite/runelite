import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("r")
   public static NodeCache field2890 = new NodeCache(30);
   @ObfuscatedName("ac")
   public boolean field2891 = true;
   @ObfuscatedName("m")
   public static class182 field2892;
   @ObfuscatedName("x")
   short[] field2893;
   @ObfuscatedName("ay")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("ar")
   public int[] field2895;
   @ObfuscatedName("c")
   public static NodeCache field2896 = new NodeCache(30);
   @ObfuscatedName("p")
   static ModelData[] field2897 = new ModelData[4];
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1552239663
   )
   public int field2898 = 0;
   @ObfuscatedName("z")
   int[] field2899;
   @ObfuscatedName("q")
   int[] field2900;
   @ObfuscatedName("l")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("h")
   public static NodeCache field2902 = new NodeCache(64);
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1956670767
   )
   public int field2903 = 1;
   @ObfuscatedName("w")
   public static NodeCache field2904 = new NodeCache(500);
   @ObfuscatedName("y")
   short[] field2905;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1053159541
   )
   int field2906 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1980014887
   )
   public int field2907 = 1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1678032253
   )
   public int field2908 = 2;
   @ObfuscatedName("a")
   public boolean field2909 = true;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1316234723
   )
   public int field2910 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 290727767
   )
   int field2911 = -1;
   @ObfuscatedName("d")
   public static class182 field2912;
   @ObfuscatedName("v")
   public boolean field2913 = false;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1252720321
   )
   public int field2914 = -1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 485457277
   )
   public int field2915 = 16;
   @ObfuscatedName("e")
   short[] field2916;
   @ObfuscatedName("ah")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 261459229
   )
   public int field2918;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 978679779
   )
   public int field2919 = -1;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1669283481
   )
   public int field2920 = -1;
   @ObfuscatedName("aq")
   boolean field2921 = false;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -545244285
   )
   public int field2922 = -1;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1614680207
   )
   int field2923 = 128;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -599311005
   )
   int field2924 = 128;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 342883545
   )
   int field2925 = 128;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1469913203
   )
   int field2926 = 0;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -754011913
   )
   int field2927 = 0;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1382355661
   )
   int field2928 = 0;
   @ObfuscatedName("ab")
   public boolean field2929 = false;
   @ObfuscatedName("ax")
   boolean field2930 = false;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -503846071
   )
   public int field2931 = -1;
   @ObfuscatedName("f")
   short[] field2932;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -92112577
   )
   int field2933 = -1;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -839720891
   )
   int field2934 = 0;
   @ObfuscatedName("n")
   public static boolean field2935 = false;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -874955027
   )
   public int field2936 = 0;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 2114528237
   )
   int field2937 = 0;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1426958189
   )
   public int field2938 = 0;
   @ObfuscatedName("k")
   boolean field2939 = false;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II[[IIIIB)LModel;",
      garbageValue = "-60"
   )
   public final Model method3652(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(null == this.field2900) {
         var7 = (long)(var2 + (this.field2918 << 10));
      } else {
         var7 = (long)((this.field2918 << 10) + (var1 << 3) + var2);
      }

      Model var9 = (Model)field2896.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method3678(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.method1512(this.field2937 + 64, this.field2934 + 768, -50, -10, -50);
         field2896.put(var9, var7);
      }

      if(this.field2911 >= 0) {
         var9 = var9.method1581(var3, var4, var5, var6, true, this.field2911);
      }

      return var9;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-10"
   )
   public final boolean method3653(int var1) {
      if(null != this.field2900) {
         for(int var4 = 0; var4 < this.field2900.length; ++var4) {
            if(var1 == this.field2900[var4]) {
               return field2892.method3347(this.field2899[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(this.field2899 == null) {
         return true;
      } else if(var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.field2899.length; ++var3) {
            var2 &= field2892.method3347(this.field2899[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-532557847"
   )
   void method3654(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3676(var1, var2);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LRenderable;",
      garbageValue = "2009816347"
   )
   public final Renderable method3655(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(null == this.field2900) {
         var7 = (long)(var2 + (this.field2918 << 10));
      } else {
         var7 = (long)((this.field2918 << 10) + (var1 << 3) + var2);
      }

      Object var9 = (Renderable)field2890.get(var7);
      if(null == var9) {
         ModelData var10 = this.method3678(var1, var2);
         if(var10 == null) {
            return null;
         }

         if(!this.field2939) {
            var9 = var10.method1512(64 + this.field2937, this.field2934 + 768, -50, -10, -50);
         } else {
            var10.field1247 = (short)(64 + this.field2937);
            var10.field1216 = (short)(768 + this.field2934);
            var10.computeNormals();
            var9 = var10;
         }

         field2890.put((CacheableNode)var9, var7);
      }

      if(this.field2939) {
         var9 = ((ModelData)var9).method1497();
      }

      if(this.field2911 >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method1581(var3, var4, var5, var6, true, this.field2911);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method1561(var3, var4, var5, var6, true, this.field2911);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II[[IIIILSequence;II)LModel;",
      garbageValue = "1274149242"
   )
   public final Model method3657(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.field2900 == null) {
         var9 = (long)((this.field2918 << 10) + var2);
      } else {
         var9 = (long)(var2 + (this.field2918 << 10) + (var1 << 3));
      }

      Model var11 = (Model)field2896.get(var9);
      if(var11 == null) {
         ModelData var12 = this.method3678(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.method1512(this.field2937 + 64, 768 + this.field2934, -50, -10, -50);
         field2896.put(var11, var9);
      }

      if(var7 == null && this.field2911 == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method3802(var11, var8, var2);
         } else {
            var11 = var11.method1582(true);
         }

         if(this.field2911 >= 0) {
            var11 = var11.method1581(var3, var4, var5, var6, false, this.field2911);
         }

         return var11;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)LObjectComposition;",
      garbageValue = "91"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.field2933 != -1) {
         var1 = class37.method765(this.field2933);
      } else if(this.field2906 != -1) {
         var1 = class146.widgetSettings[this.field2906];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?class15.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1787374915"
   )
   public boolean method3660() {
      if(null == this.impostorIds) {
         return this.field2922 != -1 || null != this.field2895;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = class15.getObjectDefinition(this.impostorIds[var1]);
               if(var2.field2922 != -1 || null != var2.field2895) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-103"
   )
   void method3670() {
      if(this.field2910 == -1) {
         this.field2910 = 0;
         if(this.field2899 != null && (null == this.field2900 || this.field2900[0] == 10)) {
            this.field2910 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(null != this.actions[var1]) {
               this.field2910 = 1;
            }
         }
      }

      if(this.field2931 == -1) {
         this.field2931 = this.field2908 != 0?1:0;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-3"
   )
   void method3676(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(null != this.field2899 && !field2935) {
               var1.offset += var3 * 3;
            } else {
               this.field2900 = new int[var3];
               this.field2899 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field2899[var4] = var1.readUnsignedShort();
                  this.field2900[var4] = var1.readUnsignedByte();
               }
            }
         }
      } else if(var2 == 2) {
         this.name = var1.method3057();
      } else if(var2 == 5) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(this.field2899 != null && !field2935) {
               var1.offset += 2 * var3;
            } else {
               this.field2900 = null;
               this.field2899 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field2899[var4] = var1.readUnsignedShort();
               }
            }
         }
      } else if(var2 == 14) {
         this.field2903 = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field2907 = var1.readUnsignedByte();
      } else if(var2 == 17) {
         this.field2908 = 0;
         this.field2909 = false;
      } else if(var2 == 18) {
         this.field2909 = false;
      } else if(var2 == 19) {
         this.field2910 = var1.readUnsignedByte();
      } else if(var2 == 21) {
         this.field2911 = 0;
      } else if(var2 == 22) {
         this.field2939 = true;
      } else if(var2 == 23) {
         this.field2913 = true;
      } else if(var2 == 24) {
         this.field2914 = var1.readUnsignedShort();
         if(this.field2914 == '\uffff') {
            this.field2914 = -1;
         }
      } else if(var2 == 27) {
         this.field2908 = 1;
      } else if(var2 == 28) {
         this.field2915 = var1.readUnsignedByte();
      } else if(var2 == 29) {
         this.field2937 = var1.method3047();
      } else if(var2 == 39) {
         this.field2934 = var1.method3047() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method3057();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.field2905 = new short[var3];
         this.field2916 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field2905[var4] = (short)var1.readUnsignedShort();
            this.field2916[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field2893 = new short[var3];
         this.field2932 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field2893[var4] = (short)var1.readUnsignedShort();
            this.field2932[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         this.field2919 = var1.readUnsignedShort();
      } else if(var2 == 62) {
         this.field2921 = true;
      } else if(var2 == 64) {
         this.field2891 = false;
      } else if(var2 == 65) {
         this.field2923 = var1.readUnsignedShort();
      } else if(var2 == 66) {
         this.field2924 = var1.readUnsignedShort();
      } else if(var2 == 67) {
         this.field2925 = var1.readUnsignedShort();
      } else if(var2 == 68) {
         this.field2920 = var1.readUnsignedShort();
      } else if(var2 == 69) {
         var1.readUnsignedByte();
      } else if(var2 == 70) {
         this.field2926 = var1.method2993();
      } else if(var2 == 71) {
         this.field2927 = var1.method2993();
      } else if(var2 == 72) {
         this.field2928 = var1.method2993();
      } else if(var2 == 73) {
         this.field2929 = true;
      } else if(var2 == 74) {
         this.field2930 = true;
      } else if(var2 == 75) {
         this.field2931 = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.field2922 = var1.readUnsignedShort();
            this.field2936 = var1.readUnsignedByte();
         } else if(var2 == 79) {
            this.field2898 = var1.readUnsignedShort();
            this.field2938 = var1.readUnsignedShort();
            this.field2936 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.field2895 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2895[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.field2911 = var1.readUnsignedByte() * 256;
         }
      } else {
         this.field2933 = var1.readUnsignedShort();
         if(this.field2933 == '\uffff') {
            this.field2933 = -1;
         }

         this.field2906 = var1.readUnsignedShort();
         if(this.field2906 == '\uffff') {
            this.field2906 = -1;
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)LModelData;",
      garbageValue = "-464139741"
   )
   final ModelData method3678(int var1, int var2) {
      ModelData var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(null == this.field2900) {
         if(var1 != 10) {
            return null;
         }

         if(this.field2899 == null) {
            return null;
         }

         var4 = this.field2921;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.field2899.length;

         for(int var8 = 0; var8 < var5; ++var8) {
            var7 = this.field2899[var8];
            if(var4) {
               var7 += 65536;
            }

            var3 = (ModelData)field2904.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method1491(field2892, var7 & '\uffff', 0);
               if(null == var3) {
                  return null;
               }

               if(var4) {
                  var3.method1507();
               }

               field2904.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field2897[var8] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field2897, var5);
         }
      } else {
         int var9 = -1;

         for(var5 = 0; var5 < this.field2900.length; ++var5) {
            if(this.field2900[var5] == var1) {
               var9 = var5;
               break;
            }
         }

         if(var9 == -1) {
            return null;
         }

         var5 = this.field2899[var9];
         boolean var11 = this.field2921 ^ var2 > 3;
         if(var11) {
            var5 += 65536;
         }

         var3 = (ModelData)field2904.get((long)var5);
         if(null == var3) {
            var3 = ModelData.method1491(field2892, var5 & '\uffff', 0);
            if(null == var3) {
               return null;
            }

            if(var11) {
               var3.method1507();
            }

            field2904.put(var3, (long)var5);
         }
      }

      if(this.field2923 == 128 && this.field2924 == 128 && this.field2925 == 128) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var10;
      if(this.field2926 == 0 && this.field2927 == 0 && this.field2928 == 0) {
         var10 = false;
      } else {
         var10 = true;
      }

      ModelData var6 = new ModelData(var3, var2 == 0 && !var4 && !var10, this.field2905 == null, this.field2893 == null, true);
      if(var1 == 4 && var2 > 3) {
         var6.method1502(256);
         var6.method1504(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var6.method1500();
      } else if(var2 == 2) {
         var6.method1501();
      } else if(var2 == 3) {
         var6.method1540();
      }

      if(this.field2905 != null) {
         for(var7 = 0; var7 < this.field2905.length; ++var7) {
            var6.method1490(this.field2905[var7], this.field2916[var7]);
         }
      }

      if(this.field2893 != null) {
         for(var7 = 0; var7 < this.field2893.length; ++var7) {
            var6.method1506(this.field2893[var7], this.field2932[var7]);
         }
      }

      if(var4) {
         var6.method1508(this.field2923, this.field2924, this.field2925);
      }

      if(var10) {
         var6.method1504(this.field2926, this.field2927, this.field2928);
      }

      return var6;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "469450076"
   )
   public final boolean method3689() {
      if(null == this.field2899) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field2899.length; ++var2) {
            var1 &= field2892.method3347(this.field2899[var2] & '\uffff', 0);
         }

         return var1;
      }
   }
}
