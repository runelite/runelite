import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("aa")
   @Export("isSolid")
   boolean isSolid = false;
   @ObfuscatedName("b")
   static boolean field2898 = false;
   @ObfuscatedName("t")
   static NodeCache field2899 = new NodeCache(64);
   @ObfuscatedName("k")
   public static NodeCache field2900 = new NodeCache(500);
   @ObfuscatedName("i")
   static class182 field2901;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1836176345
   )
   @Export("mapIconId")
   public int mapIconId = -1;
   @ObfuscatedName("f")
   static ModelData[] field2903 = new ModelData[4];
   @ObfuscatedName("an")
   public boolean field2904 = true;
   @ObfuscatedName("r")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("x")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("z")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("p")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("s")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("ab")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("y")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1700792149
   )
   @Export("sizeX")
   public int sizeX = 1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1050007617
   )
   @Export("sizeY")
   public int sizeY = 1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1120035535
   )
   public int field2914 = 2;
   @ObfuscatedName("q")
   public boolean field2915 = true;
   @ObfuscatedName("ac")
   boolean field2916 = false;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 130047923
   )
   int field2917 = -1;
   @ObfuscatedName("e")
   @Export("nonFlatShading")
   boolean nonFlatShading = false;
   @ObfuscatedName("j")
   public boolean field2919 = false;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -540732249
   )
   @Export("animationId")
   public int animationId = -1;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 67035325
   )
   @Export("offsetY")
   int offsetY = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1904386929
   )
   public int field2922 = -1;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -2143587051
   )
   @Export("contrast")
   int contrast = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2026114335
   )
   public int field2924 = 16;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1254366603
   )
   @Export("mapSceneId")
   public int mapSceneId = -1;
   @ObfuscatedName("o")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -866399825
   )
   public int field2928;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -475107651
   )
   @Export("modelSizeX")
   int modelSizeX = 128;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1451351427
   )
   @Export("modelSizeHeight")
   int modelSizeHeight = 128;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1477310171
   )
   @Export("modelSizeY")
   int modelSizeY = 128;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 38562937
   )
   @Export("offsetX")
   int offsetX = 0;
   @ObfuscatedName("az")
   public int[] field2933;
   @ObfuscatedName("h")
   static NodeCache field2934 = new NodeCache(30);
   @ObfuscatedName("ai")
   public boolean field2935 = false;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1614009179
   )
   @Export("offsetHeight")
   int offsetHeight = 0;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1148191027
   )
   @Export("ambient")
   int ambient = 0;
   @ObfuscatedName("ag")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 25498613
   )
   public int field2939 = 0;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1361783151
   )
   @Export("configId")
   int configId = -1;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -93012623
   )
   @Export("ambientSoundId")
   public int ambientSoundId = -1;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1120290253
   )
   @Export("varpId")
   int varpId = -1;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1282869573
   )
   public int field2943 = -1;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1606410115
   )
   public int field2944 = 0;
   @ObfuscatedName("n")
   static NodeCache field2945 = new NodeCache(30);
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 292360499
   )
   public int field2947 = 0;
   @ObfuscatedName("ml")
   @Export("clanMembers")
   static XClanMember[] clanMembers;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-45"
   )
   @Export("loadData")
   void loadData(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(this.objectModels != null && !field2898) {
               var1.offset += 3 * var3;
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
            if(this.objectModels != null && !field2898) {
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
         this.field2914 = 0;
         this.field2915 = false;
      } else if(var2 == 18) {
         this.field2915 = false;
      } else if(var2 == 19) {
         this.field2922 = var1.readUnsignedByte();
      } else if(var2 == 21) {
         this.field2917 = 0;
      } else if(var2 == 22) {
         this.nonFlatShading = true;
      } else if(var2 == 23) {
         this.field2919 = true;
      } else if(var2 == 24) {
         this.animationId = var1.readUnsignedShort();
         if(this.animationId == '\uffff') {
            this.animationId = -1;
         }
      } else if(var2 == 27) {
         this.field2914 = 1;
      } else if(var2 == 28) {
         this.field2924 = var1.readUnsignedByte();
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
         this.field2916 = true;
      } else if(var2 == 64) {
         this.field2904 = false;
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
         this.field2935 = true;
      } else if(var2 == 74) {
         this.isSolid = true;
      } else if(var2 == 75) {
         this.field2943 = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.ambientSoundId = var1.readUnsignedShort();
            this.field2939 = var1.readUnsignedByte();
         } else if(var2 == 79) {
            this.field2947 = var1.readUnsignedShort();
            this.field2944 = var1.readUnsignedShort();
            this.field2939 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.field2933 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2933[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.field2917 = var1.readUnsignedByte() * 256;
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "726024362"
   )
   public final boolean method3684() {
      if(null == this.objectModels) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= field2901.method3413(this.objectModels[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LRenderable;",
      garbageValue = "-805519229"
   )
   public final Renderable method3685(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)(var2 + (this.field2928 << 10));
      } else {
         var7 = (long)((var1 << 3) + (this.field2928 << 10) + var2);
      }

      Object var9 = (Renderable)field2934.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method3688(var1, var2);
         if(null == var10) {
            return null;
         }

         if(!this.nonFlatShading) {
            var9 = var10.method1544(this.ambient + 64, 768 + this.contrast, -50, -10, -50);
         } else {
            var10.field1216 = (short)(64 + this.ambient);
            var10.field1240 = (short)(768 + this.contrast);
            var10.computeNormals();
            var9 = var10;
         }

         field2934.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method1526();
      }

      if(this.field2917 >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method1623(var3, var4, var5, var6, true, this.field2917);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method1560(var3, var4, var5, var6, true, this.field2917);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II[[IIIILSequence;IB)LModel;",
      garbageValue = "1"
   )
   public final Model method3687(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(null == this.objectTypes) {
         var9 = (long)((this.field2928 << 10) + var2);
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.field2928 << 10));
      }

      Model var11 = (Model)field2945.get(var9);
      if(null == var11) {
         ModelData var12 = this.method3688(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.method1544(64 + this.ambient, 768 + this.contrast, -50, -10, -50);
         field2945.put(var11, var9);
      }

      if(var7 == null && this.field2917 == -1) {
         return var11;
      } else {
         if(null != var7) {
            var11 = var7.method3860(var11, var8, var2);
         } else {
            var11 = var11.method1610(true);
         }

         if(this.field2917 >= 0) {
            var11 = var11.method1623(var3, var4, var5, var6, false, this.field2917);
         }

         return var11;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)LModelData;",
      garbageValue = "1122013933"
   )
   final ModelData method3688(int var1, int var2) {
      ModelData var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(null == this.objectTypes) {
         if(var1 != 10) {
            return null;
         }

         if(null == this.objectModels) {
            return null;
         }

         var4 = this.field2916;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.objectModels.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            var7 = this.objectModels[var6];
            if(var4) {
               var7 += 65536;
            }

            var3 = (ModelData)field2900.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method1563(field2901, var7 & '\uffff', 0);
               if(null == var3) {
                  return null;
               }

               if(var4) {
                  var3.method1535();
               }

               field2900.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field2903[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field2903, var5);
         }
      } else {
         int var9 = -1;

         for(var5 = 0; var5 < this.objectTypes.length; ++var5) {
            if(this.objectTypes[var5] == var1) {
               var9 = var5;
               break;
            }
         }

         if(var9 == -1) {
            return null;
         }

         var5 = this.objectModels[var9];
         boolean var10 = this.field2916 ^ var2 > 3;
         if(var10) {
            var5 += 65536;
         }

         var3 = (ModelData)field2900.get((long)var5);
         if(null == var3) {
            var3 = ModelData.method1563(field2901, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method1535();
            }

            field2900.put(var3, (long)var5);
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
         var8.method1532(256);
         var8.method1558(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method1529();
      } else if(var2 == 2) {
         var8.method1530();
      } else if(var2 == 3) {
         var8.method1531();
      }

      if(this.recolorToFind != null) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var8.method1579(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var8.method1541(this.textureToFind[var7], this.textureToReplace[var7]);
         }
      }

      if(var4) {
         var8.method1536(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var11) {
         var8.method1558(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var8;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)LObjectComposition;",
      garbageValue = "124"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = class156.method3084(this.varpId);
      } else if(this.configId != -1) {
         var1 = class165.widgetSettings[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?class196.getObjectDefinition(var2):null;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-646967599"
   )
   public boolean method3690() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || null != this.field2933;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = class196.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || var2.field2933 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1502619883"
   )
   void method3694(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.loadData(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "393781363"
   )
   void method3695() {
      if(this.field2922 == -1) {
         this.field2922 = 0;
         if(null != this.objectModels && (null == this.objectTypes || this.objectTypes[0] == 10)) {
            this.field2922 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.actions[var1] != null) {
               this.field2922 = 1;
            }
         }
      }

      if(this.field2943 == -1) {
         this.field2943 = this.field2914 != 0?1:0;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LModel;",
      garbageValue = "-1468076796"
   )
   public final Model method3706(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)((this.field2928 << 10) + var2);
      } else {
         var7 = (long)((var1 << 3) + (this.field2928 << 10) + var2);
      }

      Model var9 = (Model)field2945.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method3688(var1, var2);
         if(null == var10) {
            return null;
         }

         var9 = var10.method1544(64 + this.ambient, 768 + this.contrast, -50, -10, -50);
         field2945.put(var9, var7);
      }

      if(this.field2917 >= 0) {
         var9 = var9.method1623(var3, var4, var5, var6, true, this.field2917);
      }

      return var9;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "89021595"
   )
   public final boolean method3717(int var1) {
      if(this.objectTypes != null) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(var1 == this.objectTypes[var4]) {
               return field2901.method3413(this.objectModels[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(this.objectModels == null) {
         return true;
      } else if(var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.objectModels.length; ++var3) {
            var2 &= field2901.method3413(this.objectModels[var3] & '\uffff', 0);
         }

         return var2;
      }
   }
}
