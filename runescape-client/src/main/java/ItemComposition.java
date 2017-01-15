import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("k")
   @Export("textToReplaceWith")
   short[] field2934;
   @ObfuscatedName("a")
   static class182 field2935;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -636941583
   )
   int field2936 = 128;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 174839141
   )
   @Export("yan2d")
   public int field2937 = 0;
   @ObfuscatedName("l")
   static NodeCache field2938 = new NodeCache(64);
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 330430783
   )
   @Export("note")
   public int note = -1;
   @ObfuscatedName("z")
   @Export("itemSpriteCache")
   public static NodeCache itemSpriteCache = new NodeCache(200);
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 1184848347
   )
   int field2941 = -1;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 801132151
   )
   public int field2942 = -1;
   @ObfuscatedName("e")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("v")
   @Export("colourToReplace")
   short[] field2944;
   @ObfuscatedName("j")
   @Export("colourToReplaceWith")
   short[] field2945;
   @ObfuscatedName("p")
   @Export("textureToReplace")
   short[] field2946;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 122364169
   )
   @Export("inventoryModel")
   int field2947;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1935724557
   )
   @Export("zoom2d")
   public int field2948 = 2000;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 936490693
   )
   @Export("xan2d")
   public int field2949 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1347504897
   )
   @Export("zan2d")
   public int field2951 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1917829677
   )
   @Export("offsetX2d")
   public int field2952 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1049896293
   )
   @Export("offsetY2d")
   public int field2953 = 0;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -2101777909
   )
   public int field2954 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1127289627
   )
   @Export("price")
   public int price = 1;
   @ObfuscatedName("aj")
   @Export("isMembers")
   public boolean isMembers = false;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 565863917
   )
   public int field2957 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1022532413
   )
   @Export("id")
   public int id;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 672754093
   )
   @Export("maleModel")
   int field2959 = -1;
   @ObfuscatedName("ag")
   @Export("groundActions")
   public String[] groundActions = new String[]{null, null, "Take", null, null};
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1936373509
   )
   @Export("isStackable")
   public int isStackable = 0;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 131321879
   )
   int field2962 = -1;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 401775957
   )
   int field2963 = -1;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -65525033
   )
   int field2964 = 0;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 876106993
   )
   int field2965 = -1;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1959165703
   )
   int field2966 = -1;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -784529781
   )
   @Export("maleModel")
   int maleModel = -1;
   @ObfuscatedName("g")
   @Export("itemModelCache")
   static NodeCache itemModelCache = new NodeCache(50);
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 260180195
   )
   int field2969 = -1;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1624535803
   )
   int field2970 = -1;
   @ObfuscatedName("aq")
   int[] field2971;
   @ObfuscatedName("ac")
   int[] field2972;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1793289293
   )
   int field2973 = -1;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1397651855
   )
   @Export("notedTemplate")
   public int field2974 = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 881892393
   )
   public static int field2975;
   @ObfuscatedName("f")
   static class182 field2976;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -809703683
   )
   int field2977 = 128;
   @ObfuscatedName("al")
   @Export("inventoryActions")
   public String[] inventoryActions = new String[]{null, null, null, null, "Drop"};
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -471133615
   )
   public int field2979 = 0;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1154405339
   )
   int field2980 = -1;
   @ObfuscatedName("au")
   public boolean field2981 = false;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1622294711
   )
   int field2982 = 128;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -1225377779
   )
   int field2983 = -1;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -2080465283
   )
   public int field2984 = -1;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 795638717
   )
   int field2985 = 0;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "-53432563"
   )
   void method3636(ItemComposition var1, ItemComposition var2) {
      this.field2947 = var1.field2947;
      this.field2948 = var1.field2948;
      this.field2949 = var1.field2949;
      this.field2937 = var1.field2937;
      this.field2951 = var1.field2951;
      this.field2952 = var1.field2952;
      this.field2953 = var1.field2953;
      this.field2944 = var1.field2944;
      this.field2945 = var1.field2945;
      this.field2946 = var1.field2946;
      this.field2934 = var1.field2934;
      this.name = var2.name;
      this.isMembers = var2.isMembers;
      this.price = var2.price;
      this.isStackable = 1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;B)V",
      garbageValue = "43"
   )
   void method3637(ItemComposition var1, ItemComposition var2) {
      this.field2947 = var1.field2947;
      this.field2948 = var1.field2948;
      this.field2949 = var1.field2949;
      this.field2937 = var1.field2937;
      this.field2951 = var1.field2951;
      this.field2952 = var1.field2952;
      this.field2953 = var1.field2953;
      this.field2944 = var2.field2944;
      this.field2945 = var2.field2945;
      this.field2946 = var2.field2946;
      this.field2934 = var2.field2934;
      this.name = var2.name;
      this.isMembers = var2.isMembers;
      this.isStackable = var2.isStackable;
      this.field2959 = var2.field2959;
      this.field2980 = var2.field2980;
      this.field2965 = var2.field2965;
      this.field2962 = var2.field2962;
      this.field2963 = var2.field2963;
      this.field2966 = var2.field2966;
      this.maleModel = var2.maleModel;
      this.field2970 = var2.field2970;
      this.field2969 = var2.field2969;
      this.field2973 = var2.field2973;
      this.field2954 = var2.field2954;
      this.groundActions = var2.groundActions;
      this.inventoryActions = new String[5];
      if(null != var2.inventoryActions) {
         for(int var3 = 0; var3 < 4; ++var3) {
            this.inventoryActions[var3] = var2.inventoryActions[var3];
         }
      }

      this.inventoryActions[4] = "Discard";
      this.price = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)LModelData;",
      garbageValue = "-1938983245"
   )
   public final ModelData method3639(int var1) {
      int var2;
      if(this.field2971 != null && var1 > 1) {
         int var3 = -1;

         for(var2 = 0; var2 < 10; ++var2) {
            if(var1 >= this.field2972[var2] && this.field2972[var2] != 0) {
               var3 = this.field2971[var2];
            }
         }

         if(var3 != -1) {
            return class88.getItemDefinition(var3).method3639(1);
         }
      }

      ModelData var4 = ModelData.method1463(field2976, this.field2947, 0);
      if(var4 == null) {
         return null;
      } else {
         if(this.field2982 != 128 || this.field2936 != 128 || this.field2977 != 128) {
            var4.method1423(this.field2982, this.field2936, this.field2977);
         }

         if(this.field2944 != null) {
            for(var2 = 0; var2 < this.field2944.length; ++var2) {
               var4.method1427(this.field2944[var2], this.field2945[var2]);
            }
         }

         if(this.field2946 != null) {
            for(var2 = 0; var2 < this.field2946.length; ++var2) {
               var4.method1469(this.field2946[var2], this.field2934[var2]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)LModel;",
      garbageValue = "-1926260985"
   )
   @Export("getModel")
   public final Model getModel(int var1) {
      if(null != this.field2971 && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.field2972[var3] && this.field2972[var3] != 0) {
               var2 = this.field2971[var3];
            }
         }

         if(var2 != -1) {
            return class88.getItemDefinition(var2).getModel(1);
         }
      }

      Model var5 = (Model)itemModelCache.get((long)this.id);
      if(null != var5) {
         return var5;
      } else {
         ModelData var6 = ModelData.method1463(field2976, this.field2947, 0);
         if(var6 == null) {
            return null;
         } else {
            if(this.field2982 != 128 || this.field2936 != 128 || this.field2977 != 128) {
               var6.method1423(this.field2982, this.field2936, this.field2977);
            }

            int var4;
            if(null != this.field2944) {
               for(var4 = 0; var4 < this.field2944.length; ++var4) {
                  var6.method1427(this.field2944[var4], this.field2945[var4]);
               }
            }

            if(this.field2946 != null) {
               for(var4 = 0; var4 < this.field2946.length; ++var4) {
                  var6.method1469(this.field2946[var4], this.field2934[var4]);
               }
            }

            var5 = var6.method1486(64 + this.field2957, 768 + this.field2979, -50, -10, -50);
            var5.field1381 = true;
            itemModelCache.put(var5, (long)this.id);
            return var5;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)LItemComposition;",
      garbageValue = "-121"
   )
   public ItemComposition method3641(int var1) {
      if(this.field2971 != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.field2972[var3] && this.field2972[var3] != 0) {
               var2 = this.field2971[var3];
            }
         }

         if(var2 != -1) {
            return class88.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "956746864"
   )
   @Export("readyWorn")
   public final boolean readyWorn(boolean var1) {
      int var2 = this.field2959;
      int var3 = this.field2980;
      int var4 = this.field2965;
      if(var1) {
         var2 = this.field2962;
         var3 = this.field2963;
         var4 = this.field2966;
      }

      if(var2 == -1) {
         return true;
      } else {
         boolean var5 = true;
         if(!field2976.method3264(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !field2976.method3264(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !field2976.method3264(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ZI)LModelData;",
      garbageValue = "-1905375720"
   )
   @Export("getWornModelData")
   public final ModelData getWornModelData(boolean var1) {
      int var2 = this.field2959;
      int var3 = this.field2980;
      int var4 = this.field2965;
      if(var1) {
         var2 = this.field2962;
         var3 = this.field2963;
         var4 = this.field2966;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var5 = ModelData.method1463(field2976, var2, 0);
         if(var3 != -1) {
            ModelData var6 = ModelData.method1463(field2976, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method1463(field2976, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var6, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var6};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.field2985 != 0) {
            var5.method1426(0, this.field2985, 0);
         }

         if(var1 && this.field2964 != 0) {
            var5.method1426(0, this.field2964, 0);
         }

         int var9;
         if(null != this.field2944) {
            for(var9 = 0; var9 < this.field2944.length; ++var9) {
               var5.method1427(this.field2944[var9], this.field2945[var9]);
            }
         }

         if(null != this.field2946) {
            for(var9 = 0; var9 < this.field2946.length; ++var9) {
               var5.method1469(this.field2946[var9], this.field2934[var9]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "-1017911133"
   )
   public final boolean method3644(boolean var1) {
      int var2 = this.maleModel;
      int var3 = this.field2970;
      if(var1) {
         var2 = this.field2969;
         var3 = this.field2973;
      }

      if(var2 == -1) {
         return true;
      } else {
         boolean var4 = true;
         if(!field2976.method3264(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !field2976.method3264(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-78"
   )
   @Export("loadBuffer")
   void loadBuffer(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.populateFromBuffer(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2127976665"
   )
   void method3652() {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1635277199"
   )
   @Export("populateFromBuffer")
   void populateFromBuffer(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2947 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.name = var1.method2965();
      } else if(var2 == 4) {
         this.field2948 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field2949 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field2937 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field2952 = var1.readUnsignedShort();
         if(this.field2952 > 32767) {
            this.field2952 -= 65536;
         }
      } else if(var2 == 8) {
         this.field2953 = var1.readUnsignedShort();
         if(this.field2953 > 32767) {
            this.field2953 -= 65536;
         }
      } else if(var2 == 11) {
         this.isStackable = 1;
      } else if(var2 == 12) {
         this.price = var1.method2780();
      } else if(var2 == 16) {
         this.isMembers = true;
      } else if(var2 == 23) {
         this.field2959 = var1.readUnsignedShort();
         this.field2985 = var1.readUnsignedByte();
      } else if(var2 == 24) {
         this.field2980 = var1.readUnsignedShort();
      } else if(var2 == 25) {
         this.field2962 = var1.readUnsignedShort();
         this.field2964 = var1.readUnsignedByte();
      } else if(var2 == 26) {
         this.field2963 = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.groundActions[var2 - 30] = var1.method2965();
         if(this.groundActions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.groundActions[var2 - 30] = null;
         }
      } else if(var2 >= 35 && var2 < 40) {
         this.inventoryActions[var2 - 35] = var1.method2965();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field2944 = new short[var3];
            this.field2945 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2944[var4] = (short)var1.readUnsignedShort();
               this.field2945[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field2946 = new short[var3];
            this.field2934 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2946[var4] = (short)var1.readUnsignedShort();
               this.field2934[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 65) {
            this.field2981 = true;
         } else if(var2 == 78) {
            this.field2965 = var1.readUnsignedShort();
         } else if(var2 == 79) {
            this.field2966 = var1.readUnsignedShort();
         } else if(var2 == 90) {
            this.maleModel = var1.readUnsignedShort();
         } else if(var2 == 91) {
            this.field2969 = var1.readUnsignedShort();
         } else if(var2 == 92) {
            this.field2970 = var1.readUnsignedShort();
         } else if(var2 == 93) {
            this.field2973 = var1.readUnsignedShort();
         } else if(var2 == 95) {
            this.field2951 = var1.readUnsignedShort();
         } else if(var2 == 97) {
            this.note = var1.readUnsignedShort();
         } else if(var2 == 98) {
            this.field2974 = var1.readUnsignedShort();
         } else if(var2 >= 100 && var2 < 110) {
            if(null == this.field2971) {
               this.field2971 = new int[10];
               this.field2972 = new int[10];
            }

            this.field2971[var2 - 100] = var1.readUnsignedShort();
            this.field2972[var2 - 100] = var1.readUnsignedShort();
         } else if(var2 == 110) {
            this.field2982 = var1.readUnsignedShort();
         } else if(var2 == 111) {
            this.field2936 = var1.readUnsignedShort();
         } else if(var2 == 112) {
            this.field2977 = var1.readUnsignedShort();
         } else if(var2 == 113) {
            this.field2957 = var1.readByte();
         } else if(var2 == 114) {
            this.field2979 = var1.readByte() * 5;
         } else if(var2 == 115) {
            this.field2954 = var1.readUnsignedByte();
         } else if(var2 == 139) {
            this.field2941 = var1.readUnsignedShort();
         } else if(var2 == 140) {
            this.field2983 = var1.readUnsignedShort();
         } else if(var2 == 148) {
            this.field2984 = var1.readUnsignedShort();
         } else if(var2 == 149) {
            this.field2942 = var1.readUnsignedShort();
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "1177371448"
   )
   void method3679(ItemComposition var1, ItemComposition var2) {
      this.field2947 = var1.field2947;
      this.field2948 = var1.field2948;
      this.field2949 = var1.field2949;
      this.field2937 = var1.field2937;
      this.field2951 = var1.field2951;
      this.field2952 = var1.field2952;
      this.field2953 = var1.field2953;
      this.field2944 = var1.field2944;
      this.field2945 = var1.field2945;
      this.field2946 = var1.field2946;
      this.field2934 = var1.field2934;
      this.isStackable = var1.isStackable;
      this.name = var2.name;
      this.price = 0;
      this.isMembers = false;
      this.field2981 = false;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(IIIIIIS)V",
      garbageValue = "-9208"
   )
   static final void method3686(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = class84.field1438[var6];
         var12 = class84.field1428[var6];
         var13 = var9 * var12 - var11 * var5 >> 16;
         var10 = var12 * var5 + var11 * var9 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = class84.field1438[var7];
         var12 = class84.field1428[var7];
         var13 = var11 * var10 + var12 * var8 >> 16;
         var10 = var12 * var10 - var11 * var8 >> 16;
         var8 = var13;
      }

      class36.cameraX = var0 - var8;
      class36.cameraZ = var1 - var9;
      GroundObject.cameraY = var2 - var10;
      class165.cameraPitch = var3;
      XClanMember.cameraYaw = var4;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ZB)LModelData;",
      garbageValue = "83"
   )
   public final ModelData method3690(boolean var1) {
      int var2 = this.maleModel;
      int var3 = this.field2970;
      if(var1) {
         var2 = this.field2969;
         var3 = this.field2973;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method1463(field2976, var2, 0);
         if(var3 != -1) {
            ModelData var5 = ModelData.method1463(field2976, var3, 0);
            ModelData[] var6 = new ModelData[]{var4, var5};
            var4 = new ModelData(var6, 2);
         }

         int var7;
         if(null != this.field2944) {
            for(var7 = 0; var7 < this.field2944.length; ++var7) {
               var4.method1427(this.field2944[var7], this.field2945[var7]);
            }
         }

         if(this.field2946 != null) {
            for(var7 = 0; var7 < this.field2946.length; ++var7) {
               var4.method1469(this.field2946[var7], this.field2934[var7]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "1"
   )
   static final void method3697(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = (Client.field536 - Client.field535) * var5 / 100 + Client.field535;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var10;
      if(var7 < Client.field541) {
         var10 = Client.field541;
         var6 = 334 * var10 * var2 / (var3 * 512);
         if(var6 > Client.field540) {
            var6 = Client.field540;
            var8 = 512 * var3 * var6 / (334 * var10);
            var9 = (var2 - var8) / 2;
            if(var4) {
               class219.method3964();
               class219.method3993(var0, var1, var9, var3, -16777216);
               class219.method3993(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field513) {
         var10 = Client.field513;
         var6 = var2 * var10 * 334 / (512 * var3);
         if(var6 < Client.field539) {
            var6 = Client.field539;
            var8 = 334 * var2 * var10 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               class219.method3964();
               class219.method3993(var0, var1, var2, var9, -16777216);
               class219.method3993(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (Client.field538 - Client.field389) * var5 / 100 + Client.field389;
      Client.scale = var3 * var6 * var8 / 85504 << 1;
      if(var2 != Client.camera2 || Client.camera3 != var3) {
         int[] var11 = new int[9];

         for(int var12 = 0; var12 < 9; ++var12) {
            int var13 = 15 + var12 * 32 + 128;
            int var14 = 3 * var13 + 600;
            int var15 = class84.field1438[var13];
            var11[var12] = var14 * var15 >> 16;
         }

         Region.method1705(var11, 500, 800, var2, var3);
      }

      Client.field420 = var0;
      Client.field518 = var1;
      Client.camera2 = var2;
      Client.camera3 = var3;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;B)LModIcon;",
      garbageValue = "-32"
   )
   public static ModIcon method3698(class182 var0, String var1, String var2) {
      int var3 = var0.method3277(var1);
      int var4 = var0.method3278(var3, var2);
      ModIcon var5;
      if(!XGrandExchangeOffer.method60(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class177.method3250();
      }

      return var5;
   }
}
