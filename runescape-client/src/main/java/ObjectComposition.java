import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gy")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1604920083
   )
   public int field2892 = 16;
   @ObfuscatedName("f")
   public static class182 field2893;
   @ObfuscatedName("k")
   static NodeCache field2894 = new NodeCache(64);
   @ObfuscatedName("g")
   public static NodeCache field2895 = new NodeCache(500);
   @ObfuscatedName("n")
   static NodeCache field2896 = new NodeCache(30);
   @ObfuscatedName("a")
   static NodeCache field2897 = new NodeCache(30);
   @ObfuscatedName("q")
   static ModelData[] field2898 = new ModelData[4];
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 995675923
   )
   int field2899 = 0;
   @ObfuscatedName("i")
   public static boolean field2900 = false;
   @ObfuscatedName("h")
   int[] field2901;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 953220627
   )
   public int field2902 = 0;
   @ObfuscatedName("l")
   short[] field2903;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1744048529
   )
   int field2904 = -1;
   @ObfuscatedName("m")
   short[] field2905;
   @ObfuscatedName("r")
   short[] field2906;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1302378327
   )
   public int field2907 = 1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 218649013
   )
   public int field2908 = 1;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 441430231
   )
   public int field2909 = 2;
   @ObfuscatedName("d")
   public boolean field2910 = true;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 601506377
   )
   public int field2911 = -1;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 647278373
   )
   int field2912 = 128;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1758604921
   )
   public int field2913 = -1;
   @ObfuscatedName("z")
   public boolean field2914 = false;
   @ObfuscatedName("aj")
   public boolean field2915 = true;
   @ObfuscatedName("p")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1633478819
   )
   int field2917 = 0;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1089898927
   )
   int field2918 = 0;
   @ObfuscatedName("aq")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1048141819
   )
   public int field2920 = 0;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 17283239
   )
   public int field2921 = -1;
   @ObfuscatedName("ap")
   boolean field2922 = false;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -106073567
   )
   public int field2923;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -363027139
   )
   int field2924 = 128;
   @ObfuscatedName("c")
   short[] field2925;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1532747277
   )
   int field2926 = 128;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 374605739
   )
   int field2927 = 0;
   @ObfuscatedName("t")
   boolean field2928 = false;
   @ObfuscatedName("v")
   int[] field2929;
   @ObfuscatedName("ad")
   public boolean field2930 = false;
   @ObfuscatedName("ab")
   boolean field2931 = false;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -14980883
   )
   public int field2932 = -1;
   @ObfuscatedName("as")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1037002391
   )
   int field2934 = -1;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -298860011
   )
   int field2935 = -1;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 679195997
   )
   public int field2936 = -1;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1875339023
   )
   int field2937 = 0;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 135901935
   )
   public int field2938 = 0;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1501396823
   )
   public int field2939 = -1;
   @ObfuscatedName("ae")
   public int[] field2940;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = -1088561507
   )
   static int field2941;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1554159016"
   )
   void method3539() {
      if(this.field2911 == -1) {
         this.field2911 = 0;
         if(this.field2929 != null && (null == this.field2901 || this.field2901[0] == 10)) {
            this.field2911 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(null != this.actions[var1]) {
               this.field2911 = 1;
            }
         }
      }

      if(this.field2932 == -1) {
         this.field2932 = this.field2909 != 0?1:0;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-28"
   )
   void method3540(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3555(var1, var2);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "0"
   )
   public final boolean method3542(int var1) {
      if(null != this.field2901) {
         for(int var4 = 0; var4 < this.field2901.length; ++var4) {
            if(var1 == this.field2901[var4]) {
               return field2893.method3213(this.field2929[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(null == this.field2929) {
         return true;
      } else if(var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.field2929.length; ++var3) {
            var2 &= field2893.method3213(this.field2929[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1961921175"
   )
   public final boolean method3543() {
      if(this.field2929 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field2929.length; ++var2) {
            var1 &= field2893.method3213(this.field2929[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LRenderable;",
      garbageValue = "-1660875893"
   )
   public final Renderable method3544(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(null == this.field2901) {
         var7 = (long)((this.field2923 << 10) + var2);
      } else {
         var7 = (long)(var2 + (this.field2923 << 10) + (var1 << 3));
      }

      Object var9 = (Renderable)field2896.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method3547(var1, var2);
         if(null == var10) {
            return null;
         }

         if(!this.field2928) {
            var9 = var10.method1480(this.field2917 + 64, 768 + this.field2918, -50, -10, -50);
         } else {
            var10.field1250 = (short)(this.field2917 + 64);
            var10.field1260 = (short)(768 + this.field2918);
            var10.computeNormals();
            var9 = var10;
         }

         field2896.put((CacheableNode)var9, var7);
      }

      if(this.field2928) {
         var9 = ((ModelData)var9).method1477();
      }

      if(this.field2904 >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method1540(var3, var4, var5, var6, true, this.field2904);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method1457(var3, var4, var5, var6, true, this.field2904);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II[[IIIILSequence;II)LModel;",
      garbageValue = "-1947401653"
   )
   public final Model method3546(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(null == this.field2901) {
         var9 = (long)(var2 + (this.field2923 << 10));
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.field2923 << 10));
      }

      Model var11 = (Model)field2897.get(var9);
      if(var11 == null) {
         ModelData var12 = this.method3547(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.method1480(64 + this.field2917, 768 + this.field2918, -50, -10, -50);
         field2897.put(var11, var9);
      }

      if(var7 == null && this.field2904 == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method3709(var11, var8, var2);
         } else {
            var11 = var11.method1541(true);
         }

         if(this.field2904 >= 0) {
            var11 = var11.method1540(var3, var4, var5, var6, false, this.field2904);
         }

         return var11;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)LModelData;",
      garbageValue = "1045903283"
   )
   final ModelData method3547(int var1, int var2) {
      ModelData var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(this.field2901 == null) {
         if(var1 != 10) {
            return null;
         }

         if(this.field2929 == null) {
            return null;
         }

         var4 = this.field2922;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.field2929.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            var7 = this.field2929[var6];
            if(var4) {
               var7 += 65536;
            }

            var3 = (ModelData)field2895.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method1452(field2893, var7 & '\uffff', 0);
               if(null == var3) {
                  return null;
               }

               if(var4) {
                  var3.method1520();
               }

               field2895.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field2898[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field2898, var5);
         }
      } else {
         int var9 = -1;

         for(var5 = 0; var5 < this.field2901.length; ++var5) {
            if(var1 == this.field2901[var5]) {
               var9 = var5;
               break;
            }
         }

         if(var9 == -1) {
            return null;
         }

         var5 = this.field2929[var9];
         boolean var10 = this.field2922 ^ var2 > 3;
         if(var10) {
            var5 += 65536;
         }

         var3 = (ModelData)field2895.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method1452(field2893, var5 & '\uffff', 0);
            if(null == var3) {
               return null;
            }

            if(var10) {
               var3.method1520();
            }

            field2895.put(var3, (long)var5);
         }
      }

      if(this.field2924 == 128 && this.field2926 == 128 && this.field2912 == 128) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var11;
      if(this.field2899 == 0 && this.field2927 == 0 && this.field2937 == 0) {
         var11 = false;
      } else {
         var11 = true;
      }

      ModelData var8 = new ModelData(var3, var2 == 0 && !var4 && !var11, this.field2903 == null, this.field2905 == null, true);
      if(var1 == 4 && var2 > 3) {
         var8.method1512(256);
         var8.method1463(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method1515();
      } else if(var2 == 2) {
         var8.method1526();
      } else if(var2 == 3) {
         var8.method1461();
      }

      if(this.field2903 != null) {
         for(var7 = 0; var7 < this.field2903.length; ++var7) {
            var8.method1483(this.field2903[var7], this.field2925[var7]);
         }
      }

      if(null != this.field2905) {
         for(var7 = 0; var7 < this.field2905.length; ++var7) {
            var8.method1476(this.field2905[var7], this.field2906[var7]);
         }
      }

      if(var4) {
         var8.method1471(this.field2924, this.field2926, this.field2912);
      }

      if(var11) {
         var8.method1463(this.field2899, this.field2927, this.field2937);
      }

      return var8;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)LObjectComposition;",
      garbageValue = "0"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.field2934 != -1) {
         var1 = class97.method1898(this.field2934);
      } else if(this.field2935 != -1) {
         var1 = class165.widgetSettings[this.field2935];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?ItemLayer.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "2082066465"
   )
   void method3555(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(null != this.field2929 && !field2900) {
               var1.offset += 3 * var3;
            } else {
               this.field2901 = new int[var3];
               this.field2929 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field2929[var4] = var1.readUnsignedShort();
                  this.field2901[var4] = var1.readUnsignedByte();
               }
            }
         }
      } else if(var2 == 2) {
         this.name = var1.method2767();
      } else if(var2 == 5) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(null != this.field2929 && !field2900) {
               var1.offset += 2 * var3;
            } else {
               this.field2901 = null;
               this.field2929 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field2929[var4] = var1.readUnsignedShort();
               }
            }
         }
      } else if(var2 == 14) {
         this.field2907 = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field2908 = var1.readUnsignedByte();
      } else if(var2 == 17) {
         this.field2909 = 0;
         this.field2910 = false;
      } else if(var2 == 18) {
         this.field2910 = false;
      } else if(var2 == 19) {
         this.field2911 = var1.readUnsignedByte();
      } else if(var2 == 21) {
         this.field2904 = 0;
      } else if(var2 == 22) {
         this.field2928 = true;
      } else if(var2 == 23) {
         this.field2914 = true;
      } else if(var2 == 24) {
         this.field2913 = var1.readUnsignedShort();
         if(this.field2913 == '\uffff') {
            this.field2913 = -1;
         }
      } else if(var2 == 27) {
         this.field2909 = 1;
      } else if(var2 == 28) {
         this.field2892 = var1.readUnsignedByte();
      } else if(var2 == 29) {
         this.field2917 = var1.readByte();
      } else if(var2 == 39) {
         this.field2918 = var1.readByte() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method2767();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.field2903 = new short[var3];
         this.field2925 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field2903[var4] = (short)var1.readUnsignedShort();
            this.field2925[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field2905 = new short[var3];
         this.field2906 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field2905[var4] = (short)var1.readUnsignedShort();
            this.field2906[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         this.field2921 = var1.readUnsignedShort();
      } else if(var2 == 62) {
         this.field2922 = true;
      } else if(var2 == 64) {
         this.field2915 = false;
      } else if(var2 == 65) {
         this.field2924 = var1.readUnsignedShort();
      } else if(var2 == 66) {
         this.field2926 = var1.readUnsignedShort();
      } else if(var2 == 67) {
         this.field2912 = var1.readUnsignedShort();
      } else if(var2 == 68) {
         this.field2939 = var1.readUnsignedShort();
      } else if(var2 == 69) {
         var1.readUnsignedByte();
      } else if(var2 == 70) {
         this.field2899 = var1.method2762();
      } else if(var2 == 71) {
         this.field2927 = var1.method2762();
      } else if(var2 == 72) {
         this.field2937 = var1.method2762();
      } else if(var2 == 73) {
         this.field2930 = true;
      } else if(var2 == 74) {
         this.field2931 = true;
      } else if(var2 == 75) {
         this.field2932 = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.field2936 = var1.readUnsignedShort();
            this.field2920 = var1.readUnsignedByte();
         } else if(var2 == 79) {
            this.field2938 = var1.readUnsignedShort();
            this.field2902 = var1.readUnsignedShort();
            this.field2920 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.field2940 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2940[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.field2904 = var1.readUnsignedByte() * 256;
         }
      } else {
         this.field2934 = var1.readUnsignedShort();
         if(this.field2934 == '\uffff') {
            this.field2934 = -1;
         }

         this.field2935 = var1.readUnsignedShort();
         if(this.field2935 == '\uffff') {
            this.field2935 = -1;
         }

         var3 = -1;
         if(var2 == 92) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         var4 = var1.readUnsignedByte();
         this.impostorIds = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.impostorIds[var5] = var1.readUnsignedShort();
            if(this.impostorIds[var5] == '\uffff') {
               this.impostorIds[var5] = -1;
            }
         }

         this.impostorIds[1 + var4] = var3;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "136706488"
   )
   public boolean method3558() {
      if(this.impostorIds == null) {
         return this.field2936 != -1 || this.field2940 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = ItemLayer.getObjectDefinition(this.impostorIds[var1]);
               if(var2.field2936 != -1 || var2.field2940 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LModel;",
      garbageValue = "1506571995"
   )
   public final Model method3574(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field2901 == null) {
         var7 = (long)(var2 + (this.field2923 << 10));
      } else {
         var7 = (long)((this.field2923 << 10) + (var1 << 3) + var2);
      }

      Model var9 = (Model)field2897.get(var7);
      if(null == var9) {
         ModelData var10 = this.method3547(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.method1480(this.field2917 + 64, this.field2918 + 768, -50, -10, -50);
         field2897.put(var9, var7);
      }

      if(this.field2904 >= 0) {
         var9 = var9.method1540(var3, var4, var5, var6, true, this.field2904);
      }

      return var9;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1463307174"
   )
   static void method3581(int var0, String var1, String var2) {
      class13.addChatMessage(var0, var1, var2, (String)null);
   }
}
