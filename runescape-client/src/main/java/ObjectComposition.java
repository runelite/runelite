import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1871362647
   )
   int field2880 = 0;
   @ObfuscatedName("x")
   static class182 field2881;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 641512917
   )
   public int field2882 = -1;
   @ObfuscatedName("w")
   boolean field2883 = false;
   @ObfuscatedName("c")
   public static NodeCache field2884 = new NodeCache(30);
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1512646331
   )
   int field2885 = -1;
   @ObfuscatedName("l")
   static ModelData[] field2886 = new ModelData[4];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -59962383
   )
   public int field2887;
   @ObfuscatedName("z")
   int[] field2888;
   @ObfuscatedName("t")
   int[] field2889;
   @ObfuscatedName("m")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("q")
   short[] field2891;
   @ObfuscatedName("e")
   short[] field2892;
   @ObfuscatedName("v")
   short[] field2893;
   @ObfuscatedName("j")
   short[] field2894;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -648886593
   )
   public int field2895 = 1;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1313388547
   )
   int field2896 = -1;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -486098131
   )
   int field2897 = 0;
   @ObfuscatedName("y")
   public boolean field2898 = true;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -146539533
   )
   public int field2899 = -1;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -607021563
   )
   public int field2900 = 0;
   @ObfuscatedName("n")
   public boolean field2902 = false;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -767353949
   )
   public int field2903 = -1;
   @ObfuscatedName("a")
   public static NodeCache field2904 = new NodeCache(64);
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -130173279
   )
   public int field2905 = 16;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1105782901
   )
   int field2906 = 0;
   @ObfuscatedName("d")
   public static NodeCache field2908 = new NodeCache(30);
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -13539727
   )
   public int field2909 = -1;
   @ObfuscatedName("aa")
   boolean field2910 = false;
   @ObfuscatedName("ac")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1498989409
   )
   int field2912 = 128;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 2051655421
   )
   int field2913 = 128;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1476844117
   )
   int field2914 = 128;
   @ObfuscatedName("al")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("u")
   static boolean field2916 = false;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1147964401
   )
   int field2917 = 0;
   @ObfuscatedName("aw")
   public boolean field2918 = false;
   @ObfuscatedName("ak")
   boolean field2919 = false;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1842667325
   )
   public int field2920 = -1;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 2095730281
   )
   int field2921 = 0;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 755411111
   )
   int field2922 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1484134233
   )
   public int field2923 = 2;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 2146422057
   )
   public int field2924 = -1;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 2041972535
   )
   public int field2925 = 0;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -579246597
   )
   public int field2926 = 0;
   @ObfuscatedName("ax")
   public boolean field2927 = true;
   @ObfuscatedName("ae")
   public int[] field2928;
   @ObfuscatedName("f")
   public static NodeCache field2929 = new NodeCache(500);
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = 749511435
   )
   static int field2930;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -317976863
   )
   public int field2931 = 1;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LModel;",
      garbageValue = "1996691463"
   )
   public final Model method3593(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field2889 == null) {
         var7 = (long)((this.field2887 << 10) + var2);
      } else {
         var7 = (long)((var1 << 3) + (this.field2887 << 10) + var2);
      }

      Model var9 = (Model)field2908.get(var7);
      if(null == var9) {
         ModelData var10 = this.method3601(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.method1486(this.field2917 + 64, this.field2906 + 768, -50, -10, -50);
         field2908.put(var9, var7);
      }

      if(this.field2885 >= 0) {
         var9 = var9.method1515(var3, var4, var5, var6, true, this.field2885);
      }

      return var9;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "2004065494"
   )
   void method3594(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3606(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "255"
   )
   public final boolean method3596(int var1) {
      if(this.field2889 != null) {
         for(int var4 = 0; var4 < this.field2889.length; ++var4) {
            if(this.field2889[var4] == var1) {
               return NPC.field758.method3264(this.field2888[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(this.field2888 == null) {
         return true;
      } else if(var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.field2888.length; ++var3) {
            var2 &= NPC.field758.method3264(this.field2888[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "757300983"
   )
   public final boolean method3597() {
      if(this.field2888 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field2888.length; ++var2) {
            var1 &= NPC.field758.method3264(this.field2888[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LRenderable;",
      garbageValue = "1533680734"
   )
   public final Renderable method3598(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(null == this.field2889) {
         var7 = (long)((this.field2887 << 10) + var2);
      } else {
         var7 = (long)(var2 + (this.field2887 << 10) + (var1 << 3));
      }

      Object var9 = (Renderable)field2884.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method3601(var1, var2);
         if(var10 == null) {
            return null;
         }

         if(!this.field2883) {
            var9 = var10.method1486(this.field2917 + 64, 768 + this.field2906, -50, -10, -50);
         } else {
            var10.field1242 = (short)(this.field2917 + 64);
            var10.field1256 = (short)(this.field2906 + 768);
            var10.computeNormals();
            var9 = var10;
         }

         field2884.put((CacheableNode)var9, var7);
      }

      if(this.field2883) {
         var9 = ((ModelData)var9).method1494();
      }

      if(this.field2885 >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method1515(var3, var4, var5, var6, true, this.field2885);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method1420(var3, var4, var5, var6, true, this.field2885);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "52"
   )
   void method3600() {
      if(this.field2899 == -1) {
         this.field2899 = 0;
         if(null != this.field2888 && (null == this.field2889 || this.field2889[0] == 10)) {
            this.field2899 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.actions[var1] != null) {
               this.field2899 = 1;
            }
         }
      }

      if(this.field2920 == -1) {
         this.field2920 = this.field2923 != 0?1:0;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)LModelData;",
      garbageValue = "-2131873358"
   )
   final ModelData method3601(int var1, int var2) {
      ModelData var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(this.field2889 == null) {
         if(var1 != 10) {
            return null;
         }

         if(this.field2888 == null) {
            return null;
         }

         var4 = this.field2910;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.field2888.length;

         for(int var8 = 0; var8 < var5; ++var8) {
            var7 = this.field2888[var8];
            if(var4) {
               var7 += 65536;
            }

            var3 = (ModelData)field2929.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method1463(NPC.field758, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method1414();
               }

               field2929.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field2886[var8] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field2886, var5);
         }
      } else {
         int var9 = -1;

         for(var5 = 0; var5 < this.field2889.length; ++var5) {
            if(this.field2889[var5] == var1) {
               var9 = var5;
               break;
            }
         }

         if(var9 == -1) {
            return null;
         }

         var5 = this.field2888[var9];
         boolean var11 = this.field2910 ^ var2 > 3;
         if(var11) {
            var5 += 65536;
         }

         var3 = (ModelData)field2929.get((long)var5);
         if(null == var3) {
            var3 = ModelData.method1463(NPC.field758, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var11) {
               var3.method1414();
            }

            field2929.put(var3, (long)var5);
         }
      }

      if(this.field2912 == 128 && this.field2913 == 128 && this.field2914 == 128) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var10;
      if(this.field2921 == 0 && this.field2880 == 0 && this.field2897 == 0) {
         var10 = false;
      } else {
         var10 = true;
      }

      ModelData var6 = new ModelData(var3, var2 == 0 && !var4 && !var10, this.field2891 == null, null == this.field2893, true);
      if(var1 == 4 && var2 > 3) {
         var6.method1425(256);
         var6.method1426(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var6.method1422();
      } else if(var2 == 2) {
         var6.method1452();
      } else if(var2 == 3) {
         var6.method1424();
      }

      if(this.field2891 != null) {
         for(var7 = 0; var7 < this.field2891.length; ++var7) {
            var6.method1427(this.field2891[var7], this.field2892[var7]);
         }
      }

      if(this.field2893 != null) {
         for(var7 = 0; var7 < this.field2893.length; ++var7) {
            var6.method1469(this.field2893[var7], this.field2894[var7]);
         }
      }

      if(var4) {
         var6.method1423(this.field2912, this.field2913, this.field2914);
      }

      if(var10) {
         var6.method1426(this.field2921, this.field2880, this.field2897);
      }

      return var6;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2088013075"
   )
   public boolean method3605() {
      if(null == this.impostorIds) {
         return this.field2924 != -1 || this.field2928 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = Tile.getObjectDefinition(this.impostorIds[var1]);
               if(var2.field2924 != -1 || var2.field2928 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1810839187"
   )
   void method3606(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(this.field2888 != null && !field2916) {
               var1.offset += 3 * var3;
            } else {
               this.field2889 = new int[var3];
               this.field2888 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field2888[var4] = var1.readUnsignedShort();
                  this.field2889[var4] = var1.readUnsignedByte();
               }
            }
         }
      } else if(var2 == 2) {
         this.name = var1.method2965();
      } else if(var2 == 5) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(null != this.field2888 && !field2916) {
               var1.offset += var3 * 2;
            } else {
               this.field2889 = null;
               this.field2888 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field2888[var4] = var1.readUnsignedShort();
               }
            }
         }
      } else if(var2 == 14) {
         this.field2895 = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field2931 = var1.readUnsignedByte();
      } else if(var2 == 17) {
         this.field2923 = 0;
         this.field2898 = false;
      } else if(var2 == 18) {
         this.field2898 = false;
      } else if(var2 == 19) {
         this.field2899 = var1.readUnsignedByte();
      } else if(var2 == 21) {
         this.field2885 = 0;
      } else if(var2 == 22) {
         this.field2883 = true;
      } else if(var2 == 23) {
         this.field2902 = true;
      } else if(var2 == 24) {
         this.field2903 = var1.readUnsignedShort();
         if(this.field2903 == '\uffff') {
            this.field2903 = -1;
         }
      } else if(var2 == 27) {
         this.field2923 = 1;
      } else if(var2 == 28) {
         this.field2905 = var1.readUnsignedByte();
      } else if(var2 == 29) {
         this.field2917 = var1.readByte();
      } else if(var2 == 39) {
         this.field2906 = var1.readByte() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method2965();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.field2891 = new short[var3];
         this.field2892 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field2891[var4] = (short)var1.readUnsignedShort();
            this.field2892[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field2893 = new short[var3];
         this.field2894 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field2893[var4] = (short)var1.readUnsignedShort();
            this.field2894[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         this.field2882 = var1.readUnsignedShort();
      } else if(var2 == 62) {
         this.field2910 = true;
      } else if(var2 == 64) {
         this.field2927 = false;
      } else if(var2 == 65) {
         this.field2912 = var1.readUnsignedShort();
      } else if(var2 == 66) {
         this.field2913 = var1.readUnsignedShort();
      } else if(var2 == 67) {
         this.field2914 = var1.readUnsignedShort();
      } else if(var2 == 68) {
         this.field2909 = var1.readUnsignedShort();
      } else if(var2 == 69) {
         var1.readUnsignedByte();
      } else if(var2 == 70) {
         this.field2921 = var1.method2968();
      } else if(var2 == 71) {
         this.field2880 = var1.method2968();
      } else if(var2 == 72) {
         this.field2897 = var1.method2968();
      } else if(var2 == 73) {
         this.field2918 = true;
      } else if(var2 == 74) {
         this.field2919 = true;
      } else if(var2 == 75) {
         this.field2920 = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.field2924 = var1.readUnsignedShort();
            this.field2925 = var1.readUnsignedByte();
         } else if(var2 == 79) {
            this.field2926 = var1.readUnsignedShort();
            this.field2900 = var1.readUnsignedShort();
            this.field2925 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.field2928 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2928[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.field2885 = var1.readUnsignedByte() * 256;
         }
      } else {
         this.field2922 = var1.readUnsignedShort();
         if(this.field2922 == '\uffff') {
            this.field2922 = -1;
         }

         this.field2896 = var1.readUnsignedShort();
         if(this.field2896 == '\uffff') {
            this.field2896 = -1;
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

         this.impostorIds[1 + var4] = var3;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II[[IIIILSequence;IB)LModel;",
      garbageValue = "122"
   )
   public final Model method3614(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(null == this.field2889) {
         var9 = (long)((this.field2887 << 10) + var2);
      } else {
         var9 = (long)((this.field2887 << 10) + (var1 << 3) + var2);
      }

      Model var11 = (Model)field2908.get(var9);
      if(null == var11) {
         ModelData var12 = this.method3601(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.method1486(this.field2917 + 64, this.field2906 + 768, -50, -10, -50);
         field2908.put(var11, var9);
      }

      if(null == var7 && this.field2885 == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method3753(var11, var8, var2);
         } else {
            var11 = var11.method1557(true);
         }

         if(this.field2885 >= 0) {
            var11 = var11.method1515(var3, var4, var5, var6, false, this.field2885);
         }

         return var11;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)LObjectComposition;",
      garbageValue = "20"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.field2922 != -1) {
         var1 = class101.method1911(this.field2922);
      } else if(this.field2896 != -1) {
         var1 = class165.widgetSettings[this.field2896];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?Tile.getObjectDefinition(var2):null;
   }
}
