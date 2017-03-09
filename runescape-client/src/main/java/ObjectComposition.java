import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("aq")
   @Export("isSolid")
   boolean isSolid = false;
   @ObfuscatedName("v")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("c")
   public static class182 field2895;
   @ObfuscatedName("e")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("w")
   public static NodeCache field2897 = new NodeCache(500);
   @ObfuscatedName("h")
   static NodeCache field2898 = new NodeCache(30);
   @ObfuscatedName("u")
   static NodeCache field2899 = new NodeCache(30);
   @ObfuscatedName("k")
   static ModelData[] field2900 = new ModelData[4];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1832899929
   )
   public int field2901;
   @ObfuscatedName("aw")
   public int[] field2902;
   @ObfuscatedName("x")
   public static boolean field2903 = false;
   @ObfuscatedName("q")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -137331561
   )
   @Export("contrast")
   int contrast = 0;
   @ObfuscatedName("l")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("s")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("r")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 79776645
   )
   @Export("sizeX")
   public int sizeX = 1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2006044785
   )
   @Export("sizeY")
   public int sizeY = 1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 256794771
   )
   public int field2911 = 2;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1853159335
   )
   @Export("modelSizeHeight")
   int modelSizeHeight = 128;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 766018315
   )
   public int field2913 = -1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1045172501
   )
   int field2914 = -1;
   @ObfuscatedName("p")
   @Export("nonFlatShading")
   boolean nonFlatShading = false;
   @ObfuscatedName("n")
   public boolean field2916 = false;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1068336473
   )
   @Export("animationId")
   public int animationId = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 718521409
   )
   public int field2918 = 16;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 582900199
   )
   public int field2919 = -1;
   @ObfuscatedName("b")
   public boolean field2920 = true;
   @ObfuscatedName("aa")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -991334025
   )
   @Export("mapIconId")
   public int mapIconId = -1;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 778850501
   )
   public int field2923 = 0;
   @ObfuscatedName("ah")
   boolean field2924 = false;
   @ObfuscatedName("az")
   public boolean field2925 = true;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1622551789
   )
   @Export("modelSizeX")
   int modelSizeX = 128;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 297972897
   )
   @Export("ambient")
   int ambient = 0;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -730071051
   )
   @Export("modelSizeY")
   int modelSizeY = 128;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1862594445
   )
   @Export("offsetX")
   int offsetX = 0;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -325701629
   )
   @Export("offsetHeight")
   int offsetHeight = 0;
   @ObfuscatedName("y")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("ay")
   public boolean field2932 = false;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1584182235
   )
   @Export("configId")
   int configId = -1;
   @ObfuscatedName("ap")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 301932061
   )
   @Export("offsetY")
   int offsetY = 0;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1787907519
   )
   @Export("varpId")
   int varpId = -1;
   @ObfuscatedName("d")
   static NodeCache field2937 = new NodeCache(64);
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -413512675
   )
   @Export("ambientSoundId")
   public int ambientSoundId = -1;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1066991963
   )
   public int field2939 = 0;
   @ObfuscatedName("j")
   public static class182 field2940;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1409853411
   )
   public int field2941 = 0;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 805364873
   )
   @Export("mapSceneId")
   public int mapSceneId = -1;
   @ObfuscatedName("ne")
   @ObfuscatedGetter(
      intValue = -1773735531
   )
   static int field2945;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "17"
   )
   @Export("loadData")
   void loadData(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(null != this.objectModels && !field2903) {
               var1.offset += var3 * 3;
            } else {
               this.objectTypes = new int[var3];
               this.objectModels = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.objectModels[var4] = var1.readUnsignedShort();
                  this.objectTypes[var4] = var1.readUnsignedByte();
               }
            }
         }
      } else if(var2 == 2) {
         this.name = var1.readString();
      } else if(var2 == 5) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(null != this.objectModels && !field2903) {
               var1.offset += var3 * 2;
            } else {
               this.objectTypes = null;
               this.objectModels = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.objectModels[var4] = var1.readUnsignedShort();
               }
            }
         }
      } else if(var2 == 14) {
         this.sizeX = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.sizeY = var1.readUnsignedByte();
      } else if(var2 == 17) {
         this.field2911 = 0;
         this.field2920 = false;
      } else if(var2 == 18) {
         this.field2920 = false;
      } else if(var2 == 19) {
         this.field2913 = var1.readUnsignedByte();
      } else if(var2 == 21) {
         this.field2914 = 0;
      } else if(var2 == 22) {
         this.nonFlatShading = true;
      } else if(var2 == 23) {
         this.field2916 = true;
      } else if(var2 == 24) {
         this.animationId = var1.readUnsignedShort();
         if(this.animationId == '\uffff') {
            this.animationId = -1;
         }
      } else if(var2 == 27) {
         this.field2911 = 1;
      } else if(var2 == 28) {
         this.field2918 = var1.readUnsignedByte();
      } else if(var2 == 29) {
         this.ambient = var1.readByte();
      } else if(var2 == 39) {
         this.contrast = var1.readByte() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.readString();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.recolorToFind = new short[var3];
         this.recolorToReplace = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.recolorToFind[var4] = (short)var1.readUnsignedShort();
            this.recolorToReplace[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.textureToFind = new short[var3];
         this.textureToReplace = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.textureToFind[var4] = (short)var1.readUnsignedShort();
            this.textureToReplace[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         this.mapIconId = var1.readUnsignedShort();
      } else if(var2 == 62) {
         this.field2924 = true;
      } else if(var2 == 64) {
         this.field2925 = false;
      } else if(var2 == 65) {
         this.modelSizeX = var1.readUnsignedShort();
      } else if(var2 == 66) {
         this.modelSizeHeight = var1.readUnsignedShort();
      } else if(var2 == 67) {
         this.modelSizeY = var1.readUnsignedShort();
      } else if(var2 == 68) {
         this.mapSceneId = var1.readUnsignedShort();
      } else if(var2 == 69) {
         var1.readUnsignedByte();
      } else if(var2 == 70) {
         this.offsetX = var1.readShort();
      } else if(var2 == 71) {
         this.offsetHeight = var1.readShort();
      } else if(var2 == 72) {
         this.offsetY = var1.readShort();
      } else if(var2 == 73) {
         this.field2932 = true;
      } else if(var2 == 74) {
         this.isSolid = true;
      } else if(var2 == 75) {
         this.field2919 = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.ambientSoundId = var1.readUnsignedShort();
            this.field2939 = var1.readUnsignedByte();
         } else if(var2 == 79) {
            this.field2923 = var1.readUnsignedShort();
            this.field2941 = var1.readUnsignedShort();
            this.field2939 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.field2902 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2902[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.field2914 = var1.readUnsignedByte() * 256;
         }
      } else {
         this.varpId = var1.readUnsignedShort();
         if(this.varpId == '\uffff') {
            this.varpId = -1;
         }

         this.configId = var1.readUnsignedShort();
         if(this.configId == '\uffff') {
            this.configId = -1;
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

         this.impostorIds[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2015891247"
   )
   void method3613() {
      if(this.field2913 == -1) {
         this.field2913 = 0;
         if(null != this.objectModels && (null == this.objectTypes || this.objectTypes[0] == 10)) {
            this.field2913 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(null != this.actions[var1]) {
               this.field2913 = 1;
            }
         }
      }

      if(this.field2919 == -1) {
         this.field2919 = this.field2911 != 0?1:0;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1912520028"
   )
   public final boolean method3614(int var1) {
      if(null != this.objectTypes) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(var1 == this.objectTypes[var4]) {
               return field2895.method3374(this.objectModels[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(null == this.objectModels) {
         return true;
      } else if(var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.objectModels.length; ++var3) {
            var2 &= field2895.method3374(this.objectModels[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II[[IIIILSequence;II)LModel;",
      garbageValue = "1813872559"
   )
   public final Model method3615(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)(var2 + (this.field2901 << 10));
      } else {
         var9 = (long)(var2 + (this.field2901 << 10) + (var1 << 3));
      }

      Model var11 = (Model)field2899.get(var9);
      if(null == var11) {
         ModelData var12 = this.method3621(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.method1543(64 + this.ambient, 768 + this.contrast, -50, -10, -50);
         field2899.put(var11, var9);
      }

      if(var7 == null && this.field2914 == -1) {
         return var11;
      } else {
         if(null != var7) {
            var11 = var7.method3767(var11, var8, var2);
         } else {
            var11 = var11.method1614(true);
         }

         if(this.field2914 >= 0) {
            var11 = var11.method1613(var3, var4, var5, var6, false, this.field2914);
         }

         return var11;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "110"
   )
   public final boolean method3617() {
      if(null == this.objectModels) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= field2895.method3374(this.objectModels[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LRenderable;",
      garbageValue = "1625862192"
   )
   public final Renderable method3618(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(null == this.objectTypes) {
         var7 = (long)((this.field2901 << 10) + var2);
      } else {
         var7 = (long)((this.field2901 << 10) + (var1 << 3) + var2);
      }

      Object var9 = (Renderable)field2898.get(var7);
      if(null == var9) {
         ModelData var10 = this.method3621(var1, var2);
         if(var10 == null) {
            return null;
         }

         if(!this.nonFlatShading) {
            var9 = var10.method1543(64 + this.ambient, this.contrast + 768, -50, -10, -50);
         } else {
            var10.field1244 = (short)(this.ambient + 64);
            var10.field1269 = (short)(768 + this.contrast);
            var10.computeNormals();
            var9 = var10;
         }

         field2898.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method1539();
      }

      if(this.field2914 >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method1613(var3, var4, var5, var6, true, this.field2914);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method1529(var3, var4, var5, var6, true, this.field2914);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)LModelData;",
      garbageValue = "148097749"
   )
   final ModelData method3621(int var1, int var2) {
      ModelData var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(this.objectTypes == null) {
         if(var1 != 10) {
            return null;
         }

         if(this.objectModels == null) {
            return null;
         }

         var4 = this.field2924;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.objectModels.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            var7 = this.objectModels[var6];
            if(var4) {
               var7 += 65536;
            }

            var3 = (ModelData)field2897.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method1522(field2895, var7 & '\uffff', 0);
               if(null == var3) {
                  return null;
               }

               if(var4) {
                  var3.method1537();
               }

               field2897.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field2900[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field2900, var5);
         }
      } else {
         int var9 = -1;

         for(var5 = 0; var5 < this.objectTypes.length; ++var5) {
            if(var1 == this.objectTypes[var5]) {
               var9 = var5;
               break;
            }
         }

         if(var9 == -1) {
            return null;
         }

         var5 = this.objectModels[var9];
         boolean var10 = this.field2924 ^ var2 > 3;
         if(var10) {
            var5 += 65536;
         }

         var3 = (ModelData)field2897.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method1522(field2895, var5 & '\uffff', 0);
            if(null == var3) {
               return null;
            }

            if(var10) {
               var3.method1537();
            }

            field2897.put(var3, (long)var5);
         }
      }

      if(this.modelSizeX == 128 && this.modelSizeHeight == 128 && this.modelSizeY == 128) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var11;
      if(this.offsetX == 0 && this.offsetHeight == 0 && this.offsetY == 0) {
         var11 = false;
      } else {
         var11 = true;
      }

      ModelData var8 = new ModelData(var3, var2 == 0 && !var4 && !var11, this.recolorToFind == null, null == this.textureToFind, true);
      if(var1 == 4 && var2 > 3) {
         var8.method1534(256);
         var8.method1535(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method1531();
      } else if(var2 == 2) {
         var8.method1532();
      } else if(var2 == 3) {
         var8.method1533();
      }

      if(null != this.recolorToFind) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var8.method1555(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var8.method1536(this.textureToFind[var7], this.textureToReplace[var7]);
         }
      }

      if(var4) {
         var8.method1574(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var11) {
         var8.method1535(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var8;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)LObjectComposition;",
      garbageValue = "-965556956"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = class88.method1937(this.varpId);
      } else if(this.configId != -1) {
         var1 = class165.widgetSettings[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?class195.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2134529021"
   )
   public boolean method3623() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field2902 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = class195.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || null != var2.field2902) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1941589545"
   )
   void method3645(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.loadData(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LModel;",
      garbageValue = "1339623296"
   )
   public final Model method3654(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(null == this.objectTypes) {
         var7 = (long)(var2 + (this.field2901 << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.field2901 << 10));
      }

      Model var9 = (Model)field2899.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method3621(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.method1543(64 + this.ambient, this.contrast + 768, -50, -10, -50);
         field2899.put(var9, var7);
      }

      if(this.field2914 >= 0) {
         var9 = var9.method1613(var3, var4, var5, var6, true, this.field2914);
      }

      return var9;
   }
}
